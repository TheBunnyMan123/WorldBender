package com.thekillerbunny.worldbender.commands;

import java.util.Arrays;

import com.mojang.brigadier.CommandDispatcher;
import com.thekillerbunny.worldbender.utils;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class sphere {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher,
            CommandRegistryAccess registryAccess) {
        dispatcher.register(ClientCommandManager.literal("sphere")
                .then(ClientCommandManager.argument("block", BlockStateArgumentType.blockState(registryAccess))
                        .executes(context -> {
                            if (com.thekillerbunny.worldbender.WorldBender.positionsSet[0]
                                    && com.thekillerbunny.worldbender.WorldBender.positionsSet[1]) {
                                ClientPlayNetworkHandler networkHandler = context.getSource().getClient()
                                        .getNetworkHandler();
                                BlockState blockstate = context.getArgument("block", BlockStateArgument.class)
                                        .getBlockState();
                                String blockStateString = utils.getStringFromState(blockstate);

                                Vec3d corner1 = com.thekillerbunny.worldbender.WorldBender.positions[0];
                                Vec3d corner2 = com.thekillerbunny.worldbender.WorldBender.positions[1];

                                double x1 = corner1.x;
                                double y1 = corner1.y;
                                double z1 = corner1.z;
                                double x2 = corner2.x;
                                double y2 = corner2.y;
                                double z2 = corner2.z;

                                corner1 = new Vec3d(Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2));
                                corner2 = new Vec3d(Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2));

                                double sphereArea = Math.abs((x2 - x1) * (y2 - y1) * (z2 - z1));

                                // Calculate prism dimensions
                                double minX = Math.min(corner1.x, corner2.x);
                                double minY = Math.min(corner1.y, corner2.y);
                                double minZ = Math.min(corner1.z, corner2.z);

                                double maxX = Math.max(corner1.x, corner2.x);
                                double maxY = Math.max(corner1.y, corner2.y);
                                double maxZ = Math.max(corner1.z, corner2.z);

                                // Calculate center and half-diameters
                                double centerX = (minX + maxX) / 2;
                                double centerY = (minY + maxY) / 2;
                                double centerZ = (minZ + maxZ) / 2;
                                double radiusX = (maxX - minX) / 2;
                                double radiusY = (maxY - minY) / 2;
                                double radiusZ = (maxZ - minZ) / 2;

                                // Define resolution for generating points (higher values give smoother
                                // surfaces)
                                double resolution = Math.ceil(Math.sqrt(sphereArea)) * 2;

                                // Generate points on each ellipsoid face and round to whole numbers
                                // log((x2 - x1) * (y2 - y1) * (z2 - z1))
                                Vec3d[] ellipsoidPoints = {};
                                for (double theta = 0; theta <= Math.PI; theta += (Math.PI / resolution)) {
                                    for (double phi = 0; phi <= (Math.PI * 2); phi += (Math.PI * 2 / resolution)) {
                                        // log("test")
                                        // Calculate unit sphere point based on angles
                                        double x = Math.sin(theta) * Math.cos(phi);
                                        double y = Math.sin(theta) * Math.sin(phi);
                                        double z = Math.cos(theta);

                                        // Offset and scale point to fit the ellipsoid surface, round to integers
                                        ellipsoidPoints = Arrays.copyOf(ellipsoidPoints, ellipsoidPoints.length + 1);
                                        ellipsoidPoints[ellipsoidPoints.length - 1] = new Vec3d(
                                                Math.floor(centerX + radiusX * x + 0.5),
                                                Math.floor(centerY + radiusY * y + 0.5),
                                                Math.floor(centerZ + radiusZ * z + 0.5));
                                    }
                                }

                                // Create and initialize seenPoints table
                                Vec3d[] seenPoints = {};

                                for (Vec3d point : ellipsoidPoints) {
                                    if (!(utils.Vec3dArrayContains(seenPoints, point))) {
                                        seenPoints = Arrays.copyOf(seenPoints, seenPoints.length + 1);
                                        seenPoints[seenPoints.length - 1] = point;
                                        networkHandler.sendChatCommand("setblock " + (long) point.x + " "
                                            + (long) point.y + " " + (long) point.z + " " + blockStateString);
                                    }
                                }

                                return 1;
                            } else {
                                context.getSource().sendFeedback(Text.literal("[WB] No positions set!"));
                                return 0;
                            }
                        })));
    }
}
