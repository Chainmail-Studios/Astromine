package com.github.chainmailstudios.astromine.common.recipe;

import com.github.chainmailstudios.astromine.AstromineCommon;
import com.github.chainmailstudios.astromine.common.component.inventory.ItemInventoryComponent;
import com.github.chainmailstudios.astromine.common.component.inventory.compatibility.ItemInventoryComponentFromItemInventory;
import com.github.chainmailstudios.astromine.common.utilities.*;
import com.github.chainmailstudios.astromine.registry.AstromineBlocks;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class AlloySmelterRecipe implements Recipe<Inventory> {
	final Identifier identifier;
	final BetterIngredient firstInput;
	final BetterIngredient secondInput;
	final ItemStack output;
	final double energyConsumed;
	final int time;

	public AlloySmelterRecipe(Identifier identifier, BetterIngredient firstInput, BetterIngredient secondInput, ItemStack output, double energyConsumed, int time) {
		this.identifier = identifier;
		this.firstInput = firstInput;
		this.secondInput = secondInput;
		this.output = output;
		this.energyConsumed = energyConsumed;
		this.time = time;
	}

	@Override
	public boolean matches(Inventory inventory, World world) {
		ItemInventoryComponent component = ItemInventoryComponentFromItemInventory.of(inventory);
		if (component.getItemSize() < 2) return false;
		ItemStack stack1 = component.getStack(0);
		ItemStack stack2 = component.getStack(1);
		if (firstInput.test(stack1))
			return secondInput.test(stack2);
		if (firstInput.test(stack2))
			return secondInput.test(stack1);
		return false;
	}

	@Override
	public ItemStack craft(Inventory inventory) {
		return output.copy();
	}

	@Override
	public boolean fits(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getOutput() {
		return output.copy();
	}

	@Override
	public Identifier getId() {
		return identifier;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public DefaultedList<Ingredient> getPreviewInputs() {
		DefaultedList<Ingredient> defaultedList = DefaultedList.of();
		defaultedList.add(this.firstInput.asIngredient());
		defaultedList.add(this.secondInput.asIngredient());
		return defaultedList;
	}

	public BetterIngredient getFirstInput() {
		return firstInput;
	}

	public BetterIngredient getSecondInput() {
		return secondInput;
	}

	@Override
	public ItemStack getRecipeKindIcon() {
		return new ItemStack(AstromineBlocks.ALLOY_SMELTER);
	}

	public int getTime() {
		return time;
	}

	public double getEnergyConsumed() {
		return energyConsumed;
	}

	public static final class Serializer implements RecipeSerializer<AlloySmelterRecipe> {
		public static final Identifier ID = AstromineCommon.identifier("alloy_smelter");

		public static final Serializer INSTANCE = new Serializer();

		private Serializer() {
			// Locked.
		}

		@Override
		public AlloySmelterRecipe read(Identifier identifier, JsonObject object) {
			AlloySmelterRecipe.Format format = new Gson().fromJson(object, AlloySmelterRecipe.Format.class);

			return new AlloySmelterRecipe(identifier,
					IngredientUtilities.fromBetterJson(format.firstInput),
					IngredientUtilities.fromBetterJson(format.secondInput),
					StackUtilities.fromJson(format.output),
					EnergyUtilities.fromJson(format.energyConsumed),
					ParsingUtilities.fromJson(format.time, Integer.class));
		}

		@Override
		public AlloySmelterRecipe read(Identifier identifier, PacketByteBuf buffer) {
			return new AlloySmelterRecipe(identifier,
					IngredientUtilities.fromBetterPacket(buffer),
					IngredientUtilities.fromBetterPacket(buffer),
					StackUtilities.fromPacket(buffer),
					EnergyUtilities.fromPacket(buffer),
					PacketUtilities.fromPacket(buffer, Integer.class));
		}

		@Override
		public void write(PacketByteBuf buffer, AlloySmelterRecipe recipe) {
			IngredientUtilities.toBetterPacket(buffer, recipe.firstInput);
			IngredientUtilities.toBetterPacket(buffer, recipe.secondInput);
			StackUtilities.toPacket(buffer, recipe.output);
			EnergyUtilities.toPacket(buffer, recipe.energyConsumed);
			PacketUtilities.toPacket(buffer, recipe.time);
		}
	}

	public static final class Type implements AstromineRecipeType<AlloySmelterRecipe> {
		public static final Type INSTANCE = new Type();

		private Type() {
			// Locked.
		}
	}

	public static final class Format {
		JsonObject firstInput;
		JsonObject secondInput;
		JsonObject output;
		@SerializedName("time")
		JsonPrimitive time;
		@SerializedName("energy_consumed")
		JsonElement energyConsumed;

		@Override
		public String toString() {
			return "Format{" +
			       "firstInput=" + firstInput +
			       ", secondInput=" + secondInput +
			       ", output=" + output +
			       ", time=" + time +
			       ", energyConsumed=" + energyConsumed +
			       '}';
		}
	}
}