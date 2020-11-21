/*
 * MIT License
 *
 * Copyright (c) 2020 Chainmail Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.chainmailstudios.astromine.common.block.entity.base;

import com.github.chainmailstudios.astromine.common.component.inventory.FluidComponent;
import net.minecraft.block.entity.BlockEntityType;

import com.github.chainmailstudios.astromine.common.component.inventory.ItemComponent;
import com.github.chainmailstudios.astromine.common.utilities.capability.inventory.ComponentInventoryProvider;
import com.github.chainmailstudios.astromine.registry.AstromineComponents;

/**
 * A {@link ComponentBlockEntity} with an attached
 * {@link FluidComponent} and {@link ItemComponent}.
 */
public abstract class ComponentFluidItemBlockEntity extends ComponentBlockEntity implements ComponentInventoryProvider {
	/** Instantiates a {@link ComponentFluidItemBlockEntity}. */
	public ComponentFluidItemBlockEntity(BlockEntityType<?> type) {
		super(type);

		addComponent(AstromineComponents.FLUID_INVENTORY_COMPONENT, getFluidComponent());
		getFluidComponent().updateListeners();

		addComponent(AstromineComponents.ITEM_INVENTORY_COMPONENT, getItemComponent());
		getItemComponent().updateListeners();
	}

	/** Returns the {@link FluidComponent} to be attached. */
	public abstract FluidComponent createFluidComponent();

	/** Returns the attached {@link FluidComponent}. */
	public FluidComponent getFluidComponent() {
		return FluidComponent.get(this);
	}

	/** Returns the {@link ItemComponent} to be attached. */
	public abstract ItemComponent createItemComponent();

	/** Returns the attached {@link ItemComponent}. */
	public ItemComponent getItemComponent() {
		return ItemComponent.get(this);
	}
}
