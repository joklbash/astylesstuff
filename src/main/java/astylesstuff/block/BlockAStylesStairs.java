package astylesstuff.block;

import astylesstuff.AStylesStuff;
import astylesstuff.common.AStylesTab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockAStylesStairs extends BlockStairs 
{

	public BlockAStylesStairs(Block par2Block, int metaData, float lightLevel, String name) 
	{
		super(par2Block, metaData);
		setCreativeTab(AStylesStuff.blockTab);
		this.setLightOpacity(0);
		setLightLevel(lightLevel);
		setBlockName(name);
	}

}
