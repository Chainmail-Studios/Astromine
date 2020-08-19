package com.github.chainmailstudios.astromine.foundations.datagen.generators.tag;

import net.minecraft.util.Identifier;

import com.github.chainmailstudios.astromine.AstromineCommon;
import com.github.chainmailstudios.astromine.foundations.datagen.MaterialItemType;
import com.github.chainmailstudios.astromine.foundations.datagen.MaterialSet;
import com.github.chainmailstudios.astromine.foundations.datagen.MaterialSets;
import me.shedaniel.cloth.api.datagen.v1.TagData;

public class StickTagGenerator implements TagGenerator {
	@Override
	public void generateTag(TagData tags, MaterialSet set) {
		tags.item(new Identifier("c", "wood_sticks")).append(new Identifier("stick"));
	}

	@Override
	public boolean shouldGenerate(MaterialSet set) {
		return set.equals(MaterialSets.WOOD);
	}

	@Override
	public String getGeneratorName() {
		return "stick";
	}
}