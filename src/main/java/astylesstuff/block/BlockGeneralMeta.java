package astylesstuff.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import astylesstuff.AStylesStuff;
import astylesstuff.common.AStylesTab;

public class BlockGeneralMeta extends Block
{

	public String textureNamePrefix;
	public String[] textureNames;
	public IIcon[] icons;
	
	public BlockGeneralMeta(
			Material material, 
			float lightLevel, 
			float hardness, 
			float resistance, 
			String namePrefix, 
			String[] tex)
	{
		super(material);
		setLightLevel(lightLevel);
		setHardness(hardness);
		setResistance(resistance);
		setCreativeTab(AStylesStuff.blockTab);
		textureNamePrefix = namePrefix;
		textureNames = tex;
	}

	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        this.icons = new IIcon[textureNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(AStylesStuff.modID + ":" + textureNamePrefix + textureNames[i]);
        }
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        return meta < icons.length ? icons[meta] : icons[0];
    }

	@Override
    public void getSubBlocks (Item block, CreativeTabs tab, List list)
    {
        for (int iter = 0; iter < icons.length; iter++)
        {
            list.add(new ItemStack(block, 1, iter));
        }
    }
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
	{
		return false;
	}
	
	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) 
	{
	    ;
	}
	 
	@Override
	public boolean canDropFromExplosion(Explosion p_149659_1_) 
	{
		 return false;
	}
	 
	 
}
