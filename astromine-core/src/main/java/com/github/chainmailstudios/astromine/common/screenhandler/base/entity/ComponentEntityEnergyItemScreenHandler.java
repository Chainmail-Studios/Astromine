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

package com.github.chainmailstudios.astromine.common.screenhandler.base.entity;

import com.github.chainmailstudios.astromine.common.entity.base.ComponentEnergyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandlerType;

import com.github.chainmailstudios.astromine.common.entity.base.ComponentEnergyItemEntity;
import com.github.chainmailstudios.astromine.common.widget.blade.EnergyVerticalBarWidget;
import com.github.vini2003.blade.common.miscellaneous.Position;
import com.github.vini2003.blade.common.miscellaneous.Size;

/**
 * A class representing a {@link ComponentEntityScreenHandler}
 * with an attached {@link ComponentEnergyItemEntity}.
 */
public abstract class ComponentEntityEnergyItemScreenHandler extends ComponentEntityScreenHandler {
	public ComponentEnergyItemEntity entity;

	public EnergyVerticalBarWidget energyBar;

	/** Instantiates a {@link ComponentEntityEnergyItemScreenHandler} with the given values. */
	public ComponentEntityEnergyItemScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerEntity player, int entityId) {
		super(type, syncId, player, entityId);

		entity = (ComponentEnergyItemEntity) player.world.getEntityById(entityId);
	}

	/** Override behavior to add a energy bar. */
	@Override
	public void initialize(int width, int height) {
		super.initialize(width, height);

		energyBar = new EnergyVerticalBarWidget();
		energyBar.setPosition(Position.of(mainTab, 7F, 11));
		energyBar.setSize(Size.of(24F, 48F));
		energyBar.setVolumeSupplier(() -> entity.getEnergyComponent().getVolume());

		mainTab.addWidget(energyBar);
	}
}
