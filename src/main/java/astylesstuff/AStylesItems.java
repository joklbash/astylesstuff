package astylesstuff;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import astylesstuff.block.CropDyeBlock;
import astylesstuff.item.AStylesSeeds;
import astylesstuff.item.ItemBigHandOfGod;
import astylesstuff.item.ItemDigger;
import astylesstuff.item.ItemLittleHandOfGod;
import astylesstuff.item.ItemPokeFish;
import astylesstuff.item.ItemSwiftShot;
import astylesstuff.item.PlantItem;

public class AStylesItems 
{
	public static ItemBigHandOfGod itemBHOG;
	public static ItemDigger itemDigger;
	public static ItemLittleHandOfGod itemLHOG;
	public static ItemSwiftShot itemSwiftShot;
	public static ItemPokeFish itemPokeFish;

    //Crops
    public static Item seeds;
    public static Item plantItem;
    public static CropDyeBlock crops;

    public static void initItems()
    {
    	if (AStylesConfig.enableDigger)
    		setupDigger();

    	if (AStylesConfig.enableLHOG)
			setupLHOG();

    	if (AStylesConfig.enableBHOG)
			setupBHOG();

    	if (AStylesConfig.enableSwiftShot)
    		setupSwiftShot();

    	if (AStylesConfig.enablePokeFish)
    		setupPokeFish();

		setupDyeCrop();
    }

	private static void setupDyeCrop()
	{
        //Crops
        plantItem = new PlantItem().setUnlocalizedName("astylesDye");
        GameRegistry.registerItem(plantItem, "astylesDye");
        
        crops = new CropDyeBlock();
        GameRegistry.registerBlock(crops, "astylesDyeCrop");
        
        seeds = new AStylesSeeds(crops, Blocks.farmland).setUnlocalizedName("dye.seed");
        GameRegistry.registerItem(seeds, "dye.seed");
        GameRegistry.registerCustomItemStack("seedAStyles", new ItemStack(seeds, 1, 0));
	}
	
	private static void setupPokeFish()
	{
		// Set up PokeFish
		itemPokeFish = new ItemPokeFish();
		GameRegistry.registerItem(itemPokeFish, "astylesstuff.pokefish");
	}
	
	private static void setupSwiftShot() 
	{
		// ***************
		 // Set up SwiftShot
		 // ***************
		itemSwiftShot = new ItemSwiftShot();
		GameRegistry.registerItem(itemSwiftShot, "astylesstuff.swiftshot");
	}

	private static void setupDigger() 
	{
		// ***************
		 // Set up Digger
		 // ***************
		 itemDigger = new ItemDigger();
		 GameRegistry.registerItem(itemDigger, "astylesstuff.digger");
	}

	private static void setupBHOG() 
	{
		// ***************
		 // Set up Big Hand of God
		 // ***************
		 itemBHOG = new ItemBigHandOfGod();
		 GameRegistry.registerItem(itemBHOG, "astylesstuff.bhog");
	 }

	private static void setupLHOG() 
	{
		// ***************
		 // Set up Little Hand of God
		 // ***************
		 itemLHOG = new ItemLittleHandOfGod();
		 GameRegistry.registerItem(itemLHOG, "astylesstuff.lhog");
	}
}
