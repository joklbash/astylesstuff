package astylesstuff.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import astylesstuff.AStylesStuff;
import astylesstuff.common.AStylesTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDigger extends ItemTool
{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] 
    		{
    		Blocks.cobblestone, Blocks.double_stone_slab, 
    		Blocks.stone_slab, Blocks.stone, 
    		Blocks.sandstone, Blocks.mossy_cobblestone, 
    		Blocks.iron_ore, Blocks.iron_block, 
    		Blocks.coal_ore, Blocks.gold_block, 
    		Blocks.gold_ore, Blocks.diamond_ore, 
    		Blocks.diamond_block, Blocks.ice, 
    		Blocks.netherrack, Blocks.lapis_ore, 
    		Blocks.lapis_block, Blocks.redstone_ore, 
    		Blocks.lit_redstone_ore, Blocks.rail, 
    		Blocks.detector_rail, Blocks.golden_rail, 
    		Blocks.activator_rail, Blocks.obsidian,
    		Blocks.grass, Blocks.dirt, Blocks.sand,
    		Blocks.anvil, Blocks.gravel, Blocks.glass,
    		Blocks.glass_pane
    		}
    );
	
	public ItemDigger() 
	{
		super(2, ToolMaterial.EMERALD, blocksEffectiveAgainst);
		setUnlocalizedName("astylesstuff.digger");
		setMaxDamage(ToolMaterial.EMERALD.getMaxUses() * 2);
		setCreativeTab(AStylesStuff.itemTab);
		setTextureName(AStylesStuff.modID + ":digger");
	}

    public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
	 
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		 if(par2Block == Blocks.obsidian)
		 {
			 return 80F;
		 }
		 else
		 {
			 return par2Block != null && (par2Block.getMaterial() == Material.iron || par2Block.getMaterial() == Material.anvil || par2Block.getMaterial() == Material.rock) ? this.efficiencyOnProperMaterial : this.efficiencyOnProperMaterial * 1.25F;
		 }
	}

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
    	if (p_150893_2_ == Blocks.obsidian)
    	{
    		return 80F;
    	}
    	else
    	{
    		return this.blocksEffectiveAgainst.contains(p_150893_2_) ? this.efficiencyOnProperMaterial : this.efficiencyOnProperMaterial * 1.25F;
    	}
    }

	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
		createEnchantment(par1ItemStack);
	}

	public void createEnchantment(ItemStack par1)
	{
	    par1.addEnchantment(Enchantment.fortune, 2);
	    par1.addEnchantment(Enchantment.unbreaking, 2);
	}
	
}
