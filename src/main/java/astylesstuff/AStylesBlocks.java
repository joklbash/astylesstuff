package astylesstuff;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import astylesstuff.block.BlockAStylesStairs;
import astylesstuff.block.BlockColoredStone;
import astylesstuff.block.BlockFertilizedDirt;
import astylesstuff.block.GlassBlockConnected;
import astylesstuff.block.ItemColoredStone;
import astylesstuff.item.ItemBigHandOfGod;
import astylesstuff.item.ItemDigger;
import astylesstuff.item.ItemLittleHandOfGod;
import astylesstuff.item.ItemPokeFish;
import astylesstuff.item.ItemSwiftShot;

public class AStylesBlocks 
{
	public static BlockColoredStone blockColoredStone;
	public static BlockAStylesStairs[] blockColoredStairs;
	public static GlassBlockConnected blockGlass;
	public static BlockFertilizedDirt blockFertilizedDirt;
	public static BlockFertilizedDirt blockFertilizedDirtTilled;
	
	public static final String[] coloredStoneNames = 
		{ 
		"White", "Orange", "Magenta", "Light Blue", 
		"Yellow", "Lime", "Pink", "Gray", 
		"Light Gray", "Cyan", "Purple", "Blue", 
		"Brown", "Green", "Red", "Black"
		};
	
	public static void initBlocks()
	{
    	setupColoredStone();
		setupStairs();
		setupGlass();
		setupDirt();
	}

	private static void setupStairs() 
	{
		blockColoredStairs = new BlockAStylesStairs[16];
		
		// Recipes
		for (int ix = 0; ix < blockColoredStairs.length; ix++)
		{
			blockColoredStairs[ix] = new BlockAStylesStairs(
					blockColoredStone, 
					ix, 
					AStylesConfig.blockColoredStoneLight,
					"stair." + AStylesStuff.dyeNames[ix]);
			GameRegistry.registerBlock(AStylesBlocks.blockColoredStairs[ix], blockColoredStairs[ix].getUnlocalizedName());
		}
}

	private static void setupColoredStone() 
	{
		// ***************
		 // Set up ColoredStone
		 // ***************
		 blockColoredStone = new BlockColoredStone(
				 Material.rock, 
				 AStylesConfig.blockColoredStoneLight, 
				 AStylesConfig.blockColoredStoneHardness, 
				 AStylesConfig.blockColoredStoneResistance);
		 GameRegistry.registerBlock(blockColoredStone, ItemColoredStone.class, blockColoredStone.getUnlocalizedName());
	}

	private static void setupGlass()
	{
		// ***************
		// Set up Glass
		// ***************
		blockGlass = new GlassBlockConnected(
				"clear", 
				false, 
				AStylesConfig.blockGlassLight, 
				AStylesConfig.blockGlassHardness, 
				AStylesConfig.blockGlassResistance);
		GameRegistry.registerBlock(blockGlass, blockGlass.getUnlocalizedName());
		
		OreDictionary.registerOre("blockGlass", new ItemStack(blockGlass));
	}
	
	private static void setupDirt()
	{
		blockFertilizedDirt = new BlockFertilizedDirt(false);
		blockFertilizedDirtTilled = new BlockFertilizedDirt(true);
	}
}
