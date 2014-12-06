package astylesstuff.item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import astylesstuff.AStylesStuff;
import astylesstuff.common.AStylesTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBigHandOfGod extends ItemSword 
{
    protected int weaponDamage;
    protected int enchantability;
    
	public ItemBigHandOfGod() 
	{
		this("astylesstuff.bhog", 7, 20, 2000);
	}
	
	public ItemBigHandOfGod(String itemName, int dmg, int enchant, int maxDmg)
	{
		super(ToolMaterial.EMERALD);
		setMaxStackSize(1);
		setUnlocalizedName(itemName);
        setMaxDamage(maxDmg);
        setCreativeTab(AStylesStuff.itemTab);
		setTextureName(AStylesStuff.modID + ":bhog");

        weaponDamage = dmg;
        enchantability = enchant;
	}
	
    public int getDamageVsEntity(Entity par1Entity)
    {
        return weaponDamage;
    }

    public int getItemEnchantability()
    {
        return enchantability;
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	 itemstack.damageItem(25, entityplayer);
    	 entityplayer.addPotionEffect(new PotionEffect(Potion.heal.getId(), 5, 0));
    	 
    	return itemstack;
    }
    
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
    {
    	super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
    	createEnchantment(par1ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack)
    {
    	return true;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	par3List.add("Healing I");
    }

	public void createEnchantment(ItemStack par1)
	{
    	par1.addEnchantment(Enchantment.looting, 2);
    	par1.addEnchantment(Enchantment.sharpness, 2);
	}
}
