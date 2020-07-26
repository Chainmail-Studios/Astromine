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
package com.github.chainmailstudios.astromine.common.block.transfer;

import com.github.chainmailstudios.astromine.AstromineCommon;
import net.minecraft.util.Identifier;

public enum TransferType {
	NONE(AstromineCommon.identifier("textures/widget/none.png")),
	INPUT(AstromineCommon.identifier("textures/widget/input.png")),
	OUTPUT(AstromineCommon.identifier("textures/widget/output.png")),
	INPUT_OUTPUT(AstromineCommon.identifier("textures/widget/input_output.png")),
	DISABLED(AstromineCommon.identifier("textures/widget/disabled.png"));

	private final Identifier texture;

	TransferType(Identifier texture) {
		this.texture = texture;
	}

	public TransferType next() {
		if (ordinal() + 1 == values().length)
			return values()[0];
		return values()[ordinal() + 1];
	}

	public Identifier texture() {
		return texture;
	}

	public boolean canInsert() {
		return this == INPUT || this == INPUT_OUTPUT;
	}

	public boolean canExtract() {
		return this == OUTPUT || this == INPUT_OUTPUT;
	}

	public boolean isNone() {
		return this == NONE || this == DISABLED;
	}

	public boolean isDisabled() {
		return this == DISABLED;
	}
}
