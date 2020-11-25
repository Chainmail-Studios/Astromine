package com.github.chainmailstudios.astromine.common.component.inventory;

import com.github.chainmailstudios.astromine.common.component.block.entity.BlockEntityTransferComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * An {@link ItemComponent} which bases insertion and
 * extraction on a {@link BlockEntityTransferComponent}.
 */
public class SimpleDirectionalItemComponent extends SimpleItemComponent {
    private BlockEntityTransferComponent transferComponent;

    private Supplier<BlockEntityTransferComponent> transferComponentSupplier;

    /** Instantiates a {@link SimpleDirectionalItemComponent}. */
    protected <V> SimpleDirectionalItemComponent(V v, int size) {
        super(size);

        transferComponentSupplier = () -> BlockEntityTransferComponent.get(v);
    }

    /** Instantiates a {@link SimpleDirectionalItemComponent}. */
    protected  <V> SimpleDirectionalItemComponent(V v, ItemStack... stacks) {
        super(stacks);

        transferComponentSupplier = () -> BlockEntityTransferComponent.get(v);
    }

    /** Updates the transfer component if not yet acquired. */

    /** Instantiates a {@link SimpleDirectionalItemComponent}. */
    public static <V> SimpleDirectionalItemComponent of(V v, int size) {
        return new SimpleDirectionalItemComponent(v, size);
    }

    /** Instantiates a {@link SimpleDirectionalItemComponent}. */
    public static <V> SimpleDirectionalItemComponent of(V v, ItemStack... stacks) {
        return new SimpleDirectionalItemComponent(v, stacks);
    }

    /** Override behavior to query transfer component. */
    @Override
    public boolean canInsert(@Nullable Direction direction, ItemStack stack, int slot) {
        if (transferComponent == null && transferComponentSupplier != null) {
            transferComponent = transferComponentSupplier.get();
            transferComponentSupplier = null;
        }

        return direction == null ? super.canInsert(direction, stack, slot) : transferComponent.getItem(direction).canInsert() && super.canInsert(direction, stack, slot);
    }

    /** Override behavior to query transfer component. */
    @Override
    public boolean canExtract(@Nullable Direction direction, ItemStack stack, int slot) {
        if (transferComponent == null && transferComponentSupplier != null) {
            transferComponent = transferComponentSupplier.get();
            transferComponentSupplier = null;
        }

        return direction == null ? super.canExtract(direction, stack, slot) : transferComponent.getItem(direction).canExtract() && super.canExtract(direction, stack, slot);
    }
}
