package astylesstuff;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class AStylesConfig 
{
	public static String itemBHOGKey = "bhog";
	public static boolean enableBHOG = true;
	
	public static String itemDiggerkey = "digger";
	public static boolean enableDigger = true;
	
	public static String itemLHOGKey = "lhog";
	public static boolean enableLHOG = true;
	
	public static String itemSwiftShotkey = "swiftShot";
	public static boolean enableSwiftShot = true;
	
	public static String itemPokeFishkey = "pokeFish";
	public static boolean enablePokeFish = true;
	
	public static String blockColoredStoneKey = "coloredStone";
	public static float blockColoredStoneLight = 1F;
	public static float blockColoredStoneHardness = 2F;
	public static float blockColoredStoneResistance = 2000F;
	
	public static String blockFactoryBrickKey = "factoryBrick";
	public static float blockFactoryBrickLight = 1F;
	public static float blockFactoryBrickHardness = 2F;
	public static float blockFactoryBrickResistance = 2000F;
	 
	public static String blockFactoryStairsKey = "factoryStairs";
	 
	public static String blockColoredStairsKey = "coloredStairs";
	
	public static String blockGlassKey = "factoryGlass";
	public static float blockGlassLight = 1F;
	public static float blockGlassHardness = 2F;
	public static float blockGlassResistance = 2000F;
	
	public static boolean fertilizedDirtGrowthIndicator = true;
	public static int fertilizedDirtGrowthModifier = 3;
	
    public static void initCommon(FMLPreInitializationEvent event)
    {
    	AStylesStuff.logger.info("Configuring AStyles");
		
		String idConfigFile = event.getModConfigurationDirectory().getPath() + "\\AStyles";
		Configuration generalConfig = new Configuration(new File(idConfigFile, "general.cfg"));

		try 
		{
			generalConfig.load();
			
			enableBHOG = (boolean) generalConfig.get(Configuration.CATEGORY_GENERAL, "EnableBHOG", enableBHOG, "Enable BHOG").getBoolean(enableBHOG);
			enableLHOG = (boolean) generalConfig.get(Configuration.CATEGORY_GENERAL, "EnableLHOG", enableLHOG, "Enable LHOG").getBoolean(enableBHOG);
			enableDigger = (boolean) generalConfig.get(Configuration.CATEGORY_GENERAL, "EnableDigger", enableDigger, "Enable Digger").getBoolean(enableDigger);
			enableSwiftShot = (boolean) generalConfig.get(Configuration.CATEGORY_GENERAL, "EnableSwiftShot", enableSwiftShot, "Enable SwiftShot").getBoolean(enableSwiftShot);
			enablePokeFish = (boolean) generalConfig.get(Configuration.CATEGORY_GENERAL, "EnablePokeFish", enablePokeFish, "Enable PokeFish").getBoolean(enablePokeFish);
			
			blockFactoryBrickLight = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "FactoryBrickLightLevel", blockFactoryBrickLight, "Factory Brick light level (0-1)").getDouble(blockFactoryBrickLight);
			blockColoredStoneLight = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "ColoredStoneLightLevel", blockColoredStoneLight, "Colored Stone light level (0-1)").getDouble(blockColoredStoneLight);
			blockGlassLight = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "GlassLightLevel", blockGlassLight, "Glass light level (0-1)").getDouble(blockGlassLight);

			blockFactoryBrickHardness = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "FactoryBrickHardness", blockFactoryBrickHardness, "Factory Brick Hardness (def 2)").getDouble(blockFactoryBrickHardness);
			blockColoredStoneHardness = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "ColoredStoneHardness", blockColoredStoneHardness, "Colored Stone Hardness (def 2)").getDouble(blockColoredStoneHardness);
			blockGlassHardness = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "GlassHardness", blockGlassHardness, "Glass Hardness (def 2)").getDouble(blockGlassHardness);

			blockFactoryBrickResistance = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "FactoryBrickResistance", blockFactoryBrickResistance, "Factory Brick Resistance (def 2000)").getDouble(blockFactoryBrickResistance);
			blockColoredStoneResistance = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "ColoredStoneResistance", blockColoredStoneResistance, "Colored Stone Resistance (def 2000)").getDouble(blockColoredStoneResistance);
			blockGlassResistance = (float) generalConfig.get(Configuration.CATEGORY_GENERAL, "GlassResistance", blockGlassResistance, "Glass Resistance (def 2000)").getDouble(blockGlassResistance);
			
			fertilizedDirtGrowthIndicator = (boolean) generalConfig.get(Configuration.CATEGORY_GENERAL, "FertilizedDirtGrowthIndicator", fertilizedDirtGrowthIndicator, "Bonemeal particles will appear whenever fertilized dirt boosts the plant").getBoolean(fertilizedDirtGrowthIndicator);
			fertilizedDirtGrowthModifier = generalConfig.get(Configuration.CATEGORY_GENERAL, "FertilizedDirtGrowthModifier", fertilizedDirtGrowthModifier, "How often should Fertilize Dirt tick the plant above it when it's ticked itself?").getInt(fertilizedDirtGrowthModifier);
		}
		catch (Exception e)
		{
			AStylesStuff.logger.fatal("AStyles Stuff has a problem loading it's configuration", e);
		}
		finally
		{
			if(generalConfig.hasChanged())
				generalConfig.save();
		}
    	
    }
}
