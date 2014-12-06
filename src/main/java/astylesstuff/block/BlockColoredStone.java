package astylesstuff.block;

import java.util.List;

import astylesstuff.AStylesStuff;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockColoredStone extends BlockGeneralMeta
{
	public BlockColoredStone (Material material, float lightLevel, float hardness, float resistance) 
	{
		super(material, lightLevel, hardness, resistance, "coloredStone", AStylesStuff.dyeNames);
		setBlockName("coloredStone");
		setStepSound(soundTypeStone);
	}
	
	@Override
	public int damageDropped (int metadata) 
	{
		return metadata;
	}
	
}
