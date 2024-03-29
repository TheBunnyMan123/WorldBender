package com.thekillerbunny.worldbender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.thekillerbunny.worldbender.events.commandQueue;

import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Vec3d;
import javax.script.*;

public class utils {
	private static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	private static ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

	public static Double mathEval(String expression) {
		Double result = 0.00;
		try {
			result = (Double) scriptEngine.eval(expression);
			return result;
		} catch (ScriptException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String scriptEval(String expression) {
		String result = "";
		try {
			result = (String) scriptEngine.eval(expression);
			return result;
		} catch (ScriptException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getStringFromState(Boolean justName, BlockState state) {
		String transKey = state.getBlock().getTranslationKey();
		String[] splitKey = transKey.split("\\.");
		StringBuilder stringBuilder = new StringBuilder(splitKey[1] + ":" + splitKey[2]);

		if (!justName) {
			Map<Property<?>, Comparable<?>> properties = state.getEntries();
			if (!properties.isEmpty()) {
				stringBuilder.append("[");

				// Sort properties alphabetically for consistent output
				List<Property<?>> sortedProperties = new ArrayList<>(properties.keySet());
				Collections.sort(sortedProperties, Comparator.comparing(Property::getName));

				for (Property<?> property : sortedProperties) {
					Comparable<?> value = properties.get(property);
					stringBuilder.append(property.getName()).append("=").append(value.toString()).append(",");
				}

				// Remove trailing comma
				stringBuilder.deleteCharAt(stringBuilder.length() - 1);
				stringBuilder.append("]");
			}
		}

		return stringBuilder.toString();
	}

	public static void line(Vec3d startPos, Vec3d endPos, String blockState) {
		Vec3d delta = endPos.subtract(startPos);
		double steps = Math.max(Math.abs(delta.x), Math.max(Math.abs(delta.y), Math.abs(delta.z)));
		Vec3d step = delta.multiply(1 / steps);
		Vec3d pos = startPos;
		for (long i = 0; i <= steps; i++) {
			if ((255 >= pos.y) && (pos.y >= -64)) {
				commandQueue.queue("setblock " + (long) pos.x + " "
						+ (long) pos.y + " " + (long) pos.z + " " + blockState);
			}
			pos = pos.add(step);
		}

	}

	public static void fill(Vec3d[] points, String blockState) {
		for (Vec3d[] element : utils.dividePrism(points[0], points[1])) {
			commandQueue.queue("fill " + (long) Math.floor(element[0].x) + " " + (long) Math.floor(element[0].y) + " " + (long) Math.floor(element[0].z)
					+ " " + (long) Math.floor(element[1].x) + " " + (long) Math.floor(element[1].y) + " " + (long) Math.floor(element[1].z) + " "
					+ blockState);
		}
	}

	public static Vec3d[][] dividePrism(Vec3d pos1, Vec3d pos2) {
		Vec3d[][] subVolumes = {};

		Vec3d min = new Vec3d(Math.min(pos1.x, pos2.x), Math.min(pos1.y, pos2.y), Math.min(pos1.z, pos2.z));
		Vec3d max = new Vec3d(Math.max(pos1.x, pos2.x), Math.max(pos1.y, pos2.y), Math.max(pos1.z, pos2.z));
		long x1 = (long) Math.floor(min.x);
		long y1 = (long) Math.floor(min.y);
		long z1 = (long) Math.floor(min.z);
		long x2 = (long) Math.floor(max.x);
		long y2 = (long) Math.floor(max.y);
		long z2 = (long) Math.floor(max.z);

		long chunkSize = (long) Math.floor(Math.cbrt(32767));

		for (long x = x1; x <= x2; x += chunkSize) {
			for (long y = y1; y <= y2; y += chunkSize) {
				for (long z = z1; z <= z2; z += chunkSize) {
					long ex = Math.min(x + chunkSize - 1, x2);
					long ey = Math.min(y + chunkSize - 1, y2);
					long ez = Math.min(z + chunkSize - 1, z2);

					Vec3d vec1 = new Vec3d(x, y, z);
					Vec3d vec2 = new Vec3d(ex, ey, ez);
					Vec3d[] array = { vec1, vec2 };
					subVolumes = Arrays.copyOf(subVolumes, subVolumes.length + 1);
					subVolumes[subVolumes.length - 1] = array;
					// table.insert(subVolumes, { vec(x, y, z), vec(ex, ey, ez) })
					// -- queueCommand("fill " .. x .. " " .. y .. " " .. z .. " " .. ex .. " " ..
					// ey .. " " .. ez .. " " .. block)
				}
			}
		}

		return subVolumes;
	}

	public static boolean Vec3dArrayContains(Vec3d[] array, Vec3d value) {
		for (Vec3d element : array) {
			if ((element.x == value.x) && (element.y == value.y) && (element.z == value.z)) {
				return true;
			} // else {
				// System.out.println(element);
				// System.out.println(value);
				// }
		}
		return false;
	}
}
