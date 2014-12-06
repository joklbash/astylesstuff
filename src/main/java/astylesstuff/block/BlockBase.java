package astylesstuff.block;

import astylesstuff.AStylesStuff;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{
	String blockName;

	protected BlockBase(String blockName, Material material)
	{
		super(material);
		this.blockName = blockName;

		setCreativeTab(AStylesStuff.blockTab);
		this.setBlockName(blockName);
		this.setBlockTextureName(AStylesStuff.modID + ":" + blockName);

		GameRegistry.registerBlock(this, blockName);
	}

	protected BlockBase(String blockName,Material material,Class itemBlock)
	{
		super(material);
		this.blockName = blockName;
		
		setCreativeTab(AStylesStuff.blockTab);
		this.setBlockName(blockName);
		this.setBlockTextureName(AStylesStuff.modID + ":" + blockName);
		
		GameRegistry.registerBlock(this, itemBlock,blockName);
	}
}