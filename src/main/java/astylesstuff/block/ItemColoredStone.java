package astylesstuff.block;

import java.util.List;
import java.util.logging.Level;

import astylesstuff.AStylesStuff;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemColoredStone extends ItemBlock
{
	public ItemColoredStone(Block block) 
	{
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata (int meta) 
	{
		return meta;
	}
	
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return (new StringBuilder()).append(AStylesStuff.dyeNames[itemStack.getItemDamage()]).append("ColoredStone").toString();
	}
	
}
