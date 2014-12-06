package astylesstuff;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cofh.CoFHCore;
import cofh.core.world.WorldHandler;
import astylesstuff.block.BlockAStylesStairs;
import astylesstuff.block.BlockColoredStone;
import astylesstuff.block.CropDyeBlock;
import astylesstuff.block.GlassBlockConnected;
import astylesstuff.block.ItemColoredStone;
import astylesstuff.common.AStylesTab;
import astylesstuff.compat.FMP;
import astylesstuff.compat.ICompat;
import astylesstuff.handler.AStylesHandler;
import astylesstuff.item.ItemBigHandOfGod;
import astylesstuff.item.ItemDigger;
import astylesstuff.item.ItemLittleHandOfGod;
import astylesstuff.item.ItemPokeFish;
import astylesstuff.item.ItemSwiftShot;
import astylesstuff.item.AStylesSeeds;
import astylesstuff.item.PlantItem;
import astylesstuff.proxy.CommonProxy;
import astylesstuff.world.WorldGenCluster;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
		modid = AStylesStuff.modID, 
		name = AStylesStuff.modName, 
		version = AStylesStuff.modVersion,
		dependencies = "after:CoFHCore;after:ForgeMultipart;after:MineFactoryReloaded")
public class AStylesStuff 
{
	public static Random random = new Random();
	private ArrayList<ICompat> compats = new ArrayList<ICompat>();
	
	public static final String modID = "AStylesStuff";
	public static final String modName = "AStyles Stuff";
	public static final String modVersion = "1.1";
	
	public static final Logger logger = LogManager.getLogger(modID);
	public static String VERSION = "version";
	
	public static final AStylesTab blockTab = new AStylesTab("AStyles Blocks");
	public static final AStylesTab itemTab = new AStylesTab("AStyles Items");
	
	@Instance(modID)
	public static AStylesStuff instance;
	
	@SidedProxy(clientSide = "astylesstuff.proxy.ClientProxy", serverSide = "astylesstuff.proxy.CommonProxy")
	public static CommonProxy proxy;
	 
    public static String[] dyeNames = 
		{
		"White", "Orange", "Magenta", "LightBlue", 
		"Yellow", "Lime", "Pink", "Gray", 
		"LightGray", "Cyan", "Purple", "Blue", 
		"Brown", "Green", "Red", "Black"
	};

    @EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		AStylesConfig.initCommon(event);
		
		AStylesHandler rte = new AStylesHandler();
		MinecraftForge.EVENT_BUS.register(rte);
		FMLCommonHandler.instance().bus().register(rte);

		compats.add(new FMP());

		// World Generation
		//WorldHandler.addFeature(new WorldGenCluster(blockGlass, 0, 50, 80, 200, 100));
	}
	 
    @EventHandler
    public void init(FMLInitializationEvent event) 
	{
    	AStylesItems.initItems();
    	AStylesBlocks.initBlocks();
    	AStylesRecipe.initRecipes();
		 
		// Complete setup
		proxy.registerRenderInformation();
		 
		setupDungeonLoot();
		 
		random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));

		for (ICompat c : compats)
		{
		    if (Loader.isModLoaded(c.getModID()))
		    {
		        logger.info("Loading compat " + c.getClass().getName());
		        c.load();
		    }
		}
	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
    }
    
	private void setupDungeonLoot() 
	{
		// Add to dungeon loot
		ChestGenHooks dungHook = ChestGenHooks.getInfo(DUNGEON_CHEST);
			 
		// Add to bonus loot
		ChestGenHooks bonusHook = ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST);
		
		if (AStylesConfig.enableBHOG)
		{
			// Create BHOG
			ItemStack dungBHOG = new ItemStack(AStylesItems.itemBHOG);
			AStylesItems.itemBHOG.createEnchantment(dungBHOG);
			dungHook.addItem(new WeightedRandomChestContent(dungBHOG, 1, 1, 30));
		}
		
		if (AStylesConfig.enableLHOG)
		{
			// Create LHOG
			ItemStack dungLHOG = new ItemStack(AStylesItems.itemLHOG);
			dungHook.addItem(new WeightedRandomChestContent(dungLHOG, 1, 1, 35));
			bonusHook.addItem(new WeightedRandomChestContent(dungLHOG, 1, 2, 10));
		}
		
		if (AStylesConfig.enableDigger)
		{
			// Create Digger
			ItemStack dungDigger = new ItemStack(AStylesItems.itemDigger);
			AStylesItems.itemDigger.createEnchantment(dungDigger);
			dungHook.addItem(new WeightedRandomChestContent(dungDigger, 1, 1, 30));
			bonusHook.addItem(new WeightedRandomChestContent(dungDigger, 2, 3, 8));
		}

		if (AStylesConfig.enableSwiftShot)
		{
			// Create SwiftShot
			ItemStack dungSwiftShot = new ItemStack(AStylesItems.itemSwiftShot);
			AStylesItems.itemSwiftShot.createEnchantment(dungSwiftShot);
			dungHook.addItem(new WeightedRandomChestContent(dungSwiftShot, 1, 1, 30));
		}
	}


}
