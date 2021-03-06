/*
 * MIT License
 *
 * Copyright (c) 2020, 2021 Mixinors
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

package com.github.mixinors.astromine.registry.common;

import net.minecraft.item.Items;
import net.minecraft.util.Pair;

import com.github.mixinors.astromine.common.registry.ConveyorSpecialScaleRegistry;

public class AMConveyorBlockBlacklists {
	public static void initialize() {
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.CHEST, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.TRAPPED_CHEST, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.ENDER_CHEST, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.CREEPER_HEAD, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.DRAGON_HEAD, new Pair<>(0.625F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.PLAYER_HEAD, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.ZOMBIE_HEAD, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.SKELETON_SKULL, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.WITHER_SKELETON_SKULL, new Pair<>(1F, true));
		ConveyorSpecialScaleRegistry.INSTANCE.register(Items.REDSTONE, new Pair<>(0.8F, true));
	}
}
