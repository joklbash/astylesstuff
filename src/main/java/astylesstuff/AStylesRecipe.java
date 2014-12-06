package astylesstuff;

import java.util.List;

import astylesstuff.block.BlockAStylesStairs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class AStylesRecipe 
{
	public static void initRecipes()
	{
		setupBlockRecipes();
		setupItemRecipes();
	}
	
	public static void setupBlockRecipes()
	{
		ItemStack[] ingrediant = 
			{
				new ItemStack(Blocks.sand),
				new ItemStack(Blocks.dirt)
			};

		// Colored Stone Recipes
		for (int ix = 0; ix < 16; ix++)
		{
			String dye = "dye" + AStylesStuff.dyeNames[ix];
			ItemStack cobble = new ItemStack(Blocks.cobblestone, 1);
			ItemStack stone = new ItemStack(Blocks.stone, 1);
			ItemStack multiBlockStack = new ItemStack(AStylesBlocks.blockColoredStone, 8, ix);
			
			GameRegistry.addRecipe(new ShapelessOreRecipe(multiBlockStack, cobble, dye));
			GameRegistry.addRecipe(new ShapelessOreRecipe(multiBlockStack, stone, dye));
		}

		// Add some extra recipes since dyes are a pain
		GameRegistry.addShapelessRecipe(
				new ItemStack(AStylesBlocks.blockColoredStone, 2, 15), 
				new ItemStack(Blocks.cobblestone, 1),
				new ItemStack(Blocks.dirt));

		GameRegistry.addShapelessRecipe(
				new ItemStack(AStylesBlocks.blockColoredStone, 2, 15), 
				new ItemStack(Blocks.stone, 1),
				new ItemStack(Blocks.dirt));

		List recipes = CraftingManager.getInstance().getRecipeList();
		
		// Setup Stairs Recipes
		for (int ix = 0; ix < 16; ix++)
		{
			RecipeHelper.addShapedRecipeFirst(
					recipes, 
					new ItemStack(AStylesBlocks.blockColoredStairs[ix], 6, ix), 
					"#  ", "## ", "###", '#', 
					new ItemStack(AStylesBlocks.blockColoredStone, 1, ix));
		}

		// Setup Glass
		ItemStack multiBlockStack = new ItemStack(AStylesBlocks.blockGlass, 4);
		GameRegistry.addShapelessRecipe(multiBlockStack, new Object[]
				{
					new ItemStack(Blocks.cobblestone),
					new ItemStack(Blocks.sand)
				});
		
		// Setup fertilized dirt
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(AStylesBlocks.blockFertilizedDirt, 1), 
						"brb", "rdr", "brb", 
						'b', new ItemStack(Items.dye, 1, 15), 
						'r', new ItemStack(Items.rotten_flesh), 
						'd', new ItemStack(Blocks.dirt)
						));
	}
	
	public static void setupItemRecipes()
	{
        // Add some dye recipes
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 0), "###", "   ", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 1), "   ", "###", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 2), "   ", "   ", "###", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 3), "## ", "#  ", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 4), "## ", " # ", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 5), "## ", "  #", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 6), "## ", "   ", "#  ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 7), "## ", "   ", " # ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 8), "## ", "   ", "  #", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 9), "#  ", "## ", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 10), " # ", "## ", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 11), "  #", "## ", "   ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 12), "#  ", "   ", "## ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 13), " # ", "   ", "## ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 14), "  #", "   ", "## ", '#', new ItemStack(AStylesItems.plantItem, 1));
		GameRegistry.addShapedRecipe(new ItemStack(Items.dye, 6, 15), "   ", "#  ", "## ", '#', new ItemStack(AStylesItems.plantItem, 1));

		// Set Seed Recipe
		for (int ix = 0; ix < 16; ix++)
		{
			String dye = "dye" + AStylesStuff.dyeNames[ix];
			GameRegistry.addRecipe(
					new ShapelessOreRecipe(
							new ItemStack(AStylesItems.seeds, 1), 
							new ItemStack(Items.wheat_seeds, 1), 
							dye));
		 }
		
		// Poke some fish
		GameRegistry.addRecipe(
				 new ShapedOreRecipe(
						 new ItemStack(AStylesItems.itemPokeFish), 
						 "*& ","* &", "*  ", 
						 '*', "stickWood", 
						 '&', Items.string));

		// Swift Shot
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						 new ItemStack(AStylesItems.itemSwiftShot), 
						 "*& ","* &","*& ", 
						 '*', "stickWood", 
						 '&', Items.string));

		// Digger
		GameRegistry.addRecipe(
				 new ShapedOreRecipe(
						 new ItemStack(AStylesItems.itemDigger), 
						 "&&&"," X ", " X ", 
						 'X', "stickWood", 
						 '&', Items.glowstone_dust));

		// BHoG
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(AStylesItems.itemBHOG), 
						"&*&","&*&", " X ",
						'&', Items.redstone,
						'X', "stickWood", 
						'*', Items.glowstone_dust));

		// BHoG
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(AStylesItems.itemBHOG), 
						"& &","& &", " X ",
						'&', Items.redstone,
						 'X', AStylesItems.itemLHOG));

		// LHoG
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(AStylesItems.itemLHOG), 
						" * "," * ", " X ",
						'X', "stickWood", 
						'*', Items.glowstone_dust));
	}
}
