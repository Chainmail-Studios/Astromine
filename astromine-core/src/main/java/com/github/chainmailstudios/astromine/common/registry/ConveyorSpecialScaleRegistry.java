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

package com.github.chainmailstudios.astromine.common.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Pair;

import com.github.chainmailstudios.astromine.common.registry.base.UniRegistry;

/**
 * An {@link UniRegistry} for registration of
 * {@link Item}s to {@link Pair}s
 * of {@link Float} and {@link Boolean}.
 *
 * When an item on this list appears in a conveyor,
 * its scale is overridden by the registered value.
 */
public class ConveyorSpecialScaleRegistry extends UniRegistry<Item, Pair<Float, Boolean>> {
	public static final ConveyorSpecialScaleRegistry INSTANCE = new ConveyorSpecialScaleRegistry();

	/** We only want one instance of this. */
	private ConveyorSpecialScaleRegistry() {}
}
