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

package com.github.chainmailstudios.astromine.common.utilities;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Direction;

import org.jetbrains.annotations.Nullable;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergyHandler;
import team.reborn.energy.EnergySide;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.text.DecimalFormat;

public class EnergyUtilities {
	/** Returns the {@link Direction} corresponding to the specified {@link EnergySide}. */
	@Nullable
	public static Direction toDirection(EnergySide side) {
		switch (side) {
			case NORTH: {
				return Direction.NORTH;
			}
			case SOUTH: {
				return Direction.SOUTH;
			}
			case WEST: {
				return Direction.WEST;
			}
			case EAST: {
				return Direction.EAST;
			}
			case UP: {
				return Direction.UP;
			}
			case DOWN: {
				return Direction.DOWN;
			}
			default: {
				return null;
			}
		}
	}

	/** Returns the {@link EnergySide} corresponding to the specified {@link Direction}. */
	public static EnergySide toSide(Direction direction) {
		switch (direction) {
			case NORTH: {
				return EnergySide.NORTH;
			}
			case SOUTH: {
				return EnergySide.SOUTH;
			}
			case WEST: {
				return EnergySide.WEST;
			}
			case EAST: {
				return EnergySide.EAST;
			}
			case UP: {
				return EnergySide.UP;
			}
			case DOWN: {
				return EnergySide.DOWN;
			}
			default: {
				return EnergySide.UNKNOWN;
			}
		}
	}
}
