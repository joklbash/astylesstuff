package astylesstuff.block;

import java.util.ArrayList;
import java.util.Random;

import astylesstuff.AStylesItems;
import astylesstuff.AStylesStuff;
import astylesstuff.client.CropRender;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CropDyeBlock extends BlockCrops
{
    public CropDyeBlock()
    {
        super();
        this.setTickRandomly(true);
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
        this.setCreativeTab((CreativeTabs) null);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick (World world, int x, int y, int z, Random random)
    {
        this.checkAndDropBlock(world, x, y, z);

        int light = world.getBlockLightValue(x, y, z);
        if (light >= 8)
        {
            int meta = world.getBlockMetadata(x, y, z);

            if (meta != 3)
            {
                float grow = this.getGrowthRate(world, x, y, z, meta, light);

                if (random.nextInt((int) (60.0F / grow) + 1) == 0)
                {
                    meta++;
                    world.setBlockMetadataWithNotify(x, y, z, meta, 2);
                }
            }
        }
    }

    /**
     * Apply bonemeal to the crops.
     */
    @Override
    public void func_149863_m (World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta < 3)
        {
            int output = AStylesStuff.random.nextInt(3) + 1 + meta;
        
            if (output > 3)
                output = 3;
            world.setBlockMetadataWithNotify(x, y, z, output, 3);
        }
    }

    protected float getGrowthRate (World world, int x, int y, int z, int meta, int light)
    {
        float growth = 0.25f * (light - 7);
        Block soil = world.getBlock(x, y - 1, z);

        if (world.canBlockSeeTheSky(x, y, z) || !requiresSun(meta))
            growth += 2f;

        if (soil != null && soil.isFertile(world, x, y - 1, z))
            growth *= 2f;

        return 1f + growth;
    }

    boolean requiresSun (int meta)
    {
        return true;
    }

    protected boolean canThisPlantGrowOnThisBlock (Block par1)
    {
        return par1 == Blocks.farmland;
    }

    public IIcon[] icons;
    public String[] textureNames = new String[] { "astylesDye_0", "astylesDye_1", "astylesDye_2", "astylesDye_3"};

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        this.icons = new IIcon[textureNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(AStylesStuff.modID + ":" + textureNames[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        return icons[meta];
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType ()
    {
        return CropRender.model;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        if (meta == 3)
            return this.getCropItem(meta);
        
        return this.getSeedItem(meta);
    }

    protected Item getCropItem (int meta)
    {
        return AStylesItems.plantItem;
    }

    protected Item getSeedItem (int meta)
    {
        return AStylesItems.seeds;
    }

    @Override
    public int damageDropped (int meta)
    {
        return 0;
    }

    public int seedDamageDropped (int meta)
    {
        return 0;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    @Override
    public void dropBlockAsItemWithChance (World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    @Override
    public ArrayList<ItemStack> getDrops (World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if (metadata == 3)
        {
            int count = quantityDropped(metadata, fortune, world.rand);
            for (int i = 0; i < count; i++)
            {
                Item id = getItemDropped(metadata, world.rand, 0);
                if (id != null)
                {
                    ret.add(new ItemStack(id, 1, damageDropped(metadata)));
                }
            }
        }

        ret.add(new ItemStack(this.getSeedItem(metadata), 1, seedDamageDropped(metadata)));
        if (metadata >= 2 && world.rand.nextInt(3) == 0)
            ret.add(new ItemStack(this.getSeedItem(metadata), 1, seedDamageDropped(metadata)));
        if (metadata >= 3 && world.rand.nextInt(4) == 0)
            ret.add(new ItemStack(this.getSeedItem(metadata), 1, seedDamageDropped(metadata)));

        return ret;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */

    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    @Override
    public Item getItem (World world, int x, int y, int z)
    {
        return this.getSeedItem(world.getBlockMetadata(x, y, z));
    }

    @Override
    public int getDamageValue (World par1World, int par2, int par3, int par4)
    {
        return seedDamageDropped(par1World.getBlockMetadata(par2, par3, par4));
    }

    @Override
    public EnumPlantType getPlantType (IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canBlockStay (World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z); //Wild crops can stay
        if (meta == 3)
            return world.getBlock(x, y - 1, z) != Blocks.air;

        return super.canBlockStay(world, x, y, z);
    }

    @Override
    public int getPlantMetadata (IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        return 0;
    }
}
