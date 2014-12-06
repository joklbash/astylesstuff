package astylesstuff.compat;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import astylesstuff.AStylesBlocks;
import astylesstuff.AStylesStuff;
import astylesstuff.block.BlockColoredStone;

public class FMP implements ICompat
{
    public String getModID()
    {
        return "ForgeMicroblock";
    }

    public void load()
    {
        try
        {
        	for (int i = 0; i < 16; i++)
            {
                FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(AStylesBlocks.blockColoredStone, 1, i));
            }

        	FMLInterModComms.sendMessage("ForgeMultipart", "microMaterial", new ItemStack(AStylesBlocks.blockGlass, 1, 0));

        	AStylesStuff.logger.info("ForgeMultiPart Compat Initialized");
        }
        catch (Throwable ex)
        {
            AStylesStuff.logger.warn("Couldn't initialize ForgeMultiPart compat");
            ex.printStackTrace();
        }
    }
}