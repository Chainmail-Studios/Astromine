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

package com.github.chainmailstudios.astromine.common.world.layer.mars;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.ParentedLayer;
import net.minecraft.world.biome.layer.util.IdentityCoordinateTransformer;
import net.minecraft.world.biome.layer.util.LayerSampleContext;
import net.minecraft.world.biome.layer.util.LayerSampler;

import com.github.chainmailstudios.astromine.registry.AstromineBiomes;

public class MarsBiomeLayer implements ParentedLayer, IdentityCoordinateTransformer {
	private final Registry<Biome> biomeRegistry;
	private final int riverId;
	private final int marsId;

	public MarsBiomeLayer(Registry<Biome> biomeRegistry) {
		this.biomeRegistry = biomeRegistry;
		this.riverId = biomeRegistry.getRawId(biomeRegistry.get(AstromineBiomes.MARTIAN_RIVERBED));
		this.marsId = biomeRegistry.getRawId(biomeRegistry.get(AstromineBiomes.MARTIAN_PLAINS));
	}

	@Override
	public int sample(LayerSampleContext<?> context, LayerSampler parent, int x, int z) {
		int sample = parent.sample(x, z);
		if (sample == riverId) {
			return riverId;
		}

		return marsId;
	}
}
