package com.github.chainmailstudios.astromine.common.item;

import com.github.chainmailstudios.astromine.common.block.HolographicBridgeProjectorBlock;
import com.github.chainmailstudios.astromine.common.block.entity.HolographicBridgeBlockEntity;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class HolographicConnector extends Item {
	public static final Object2ObjectArrayMap<World, Object> CACHE = new Object2ObjectArrayMap<>();

	public HolographicConnector(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos position = context.getBlockPos();

		if (world.getBlockState(position).getBlock() instanceof HolographicBridgeProjectorBlock) {
			HolographicBridgeBlockEntity entity = (HolographicBridgeBlockEntity) world.getBlockEntity(position);

			if (CACHE.getOrDefault(world, null) == null) {
				CACHE.put(world, entity); // Parent.
			} else {
				HolographicBridgeBlockEntity parent = (HolographicBridgeBlockEntity) CACHE.get(world);

				BlockPos nP = entity.getPos();
				BlockPos oP = parent.getPos();

				Direction d = Direction.NORTH;

				if (nP.getX() > oP.getX()) {
					d = Direction.EAST;
				}
				if (nP.getX() < oP.getX()) {
					d = Direction.WEST;
				} else if (nP.getZ() > oP.getZ()) {
					d = Direction.SOUTH;
				} else if (nP.getZ() < oP.getZ()) {
					d = Direction.NORTH;
				}

				if (parent.getPos().getZ() < entity.getPos().getZ() || parent.getPos().getX() < entity.getPos().getX()) {
					HolographicBridgeBlockEntity temporary = parent;
					parent = entity;
					entity = temporary;
				}

				if (parent.getPos().getX() != entity.getPos().getX() && parent.getPos().getZ() != entity.getPos().getZ()) {
					CACHE.put(world, null);
					context.getPlayer().sendMessage(new TranslatableText("text.astromine.message.holographic_connection_failed", parent.getPos().toShortString(), entity.getPos().toShortString()).formatted(Formatting.RED), true);
					return ActionResult.FAIL;
				} else if (parent.getCachedState().get(HorizontalFacingBlock.FACING).getOpposite() != entity.getCachedState().get(HorizontalFacingBlock.FACING)) {
					CACHE.put(world, null);
					context.getPlayer().sendMessage(new TranslatableText("text.astromine.message.holographic_connection_failed", parent.getPos().toShortString(), entity.getPos().toShortString()).formatted(Formatting.RED), true);
					return ActionResult.FAIL;
				}

				parent.setChild(entity);
				entity.setParent(parent);

				if (parent.getParent() == entity.getParent()) {
					parent.setParent(null);
				}

				parent.direction = d;

				parent.buildBridge();

				if (world.isClient) {
					CACHE.put(world, null);
					context.getPlayer().sendMessage(new TranslatableText("text.astromine.message.holographic_connection_successful", parent.getPos().toShortString(), entity.getPos().toShortString()).formatted(Formatting.GREEN), true);
				}
			}
		} else {
			if (world.isClient) {
				context.getPlayer().sendMessage(new TranslatableText("text.astromine.message.holographic_connection_clear").formatted(Formatting.YELLOW), true);
			}

			CACHE.put(world, null);
		}

		return super.useOnBlock(context);
	}
}
