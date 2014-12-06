package astylesstuff.item;

import astylesstuff.AStylesStuff;
import astylesstuff.common.AStylesTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.google.common.collect.Multimap;

public class ItemLittleHandOfGod extends ItemSword 
{
    protected int weaponDamage;
    protected int enchantability;
    
	public ItemLittleHandOfGod() 
	{
		this("astylesstuff.lhog", 5, 15, 1500);
	}
	
	public ItemLittleHandOfGod(String itemName, int dmg, int enchant, int maxDmg)
	{
		super(ToolMaterial.IRON);
		setMaxStackSize(1);
		setUnlocalizedName(itemName);
        setMaxDamage(maxDmg);
        setCreativeTab(AStylesStuff.itemTab);
		setTextureName(AStylesStuff.modID + ":lhog");

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
    
//    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
//    {
//    	 itemstack.damageItem(25, entityplayer);
//    	 entityplayer.addPotionEffect(new PotionEffect(Potion.heal.getId(), 5, 0));
    	 
    	//entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 200, 0));
    	//entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 200, 0));
    	
//         if (!world.isRemote)
//         {
//                 Vec3 look = entityplayer.getLookVec();
//                 EntitySmallFireball fireball2 = new EntitySmallFireball(world, entityplayer, 1, 1, 1);
//                 fireball2.setPosition(
//                                 entityplayer.posX + look.xCoord * 5,
//                                 entityplayer.posY + look.yCoord * 5,
//                                 entityplayer.posZ + look.zCoord * 5);
//                 fireball2.accelerationX = look.xCoord * 0.1;
//                 fireball2.accelerationY = look.yCoord * 0.1;
//                 fireball2.accelerationZ = look.zCoord * 0.1;
//                 world.spawnEntityInWorld(fireball2);
//         }
         
//    	return itemstack;
//    }
    
//    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
//    {
//    	super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
//    	par1ItemStack.addEnchantment(Enchantment.looting, 2);
//    	par1ItemStack.addEnchantment(Enchantment.sharpness, 2);
//    	par1ItemStack.addEnchantment(Enchantment.fireAspect, 2);
//    }
    
//    @SideOnly(Side.CLIENT)
//    public boolean hasEffect(ItemStack itemstack)
//    {
//            return true;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
//    {
//    	par3List.add("Vampirism \u00a74I");
//    }

}
