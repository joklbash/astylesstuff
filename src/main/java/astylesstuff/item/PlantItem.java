package astylesstuff.item;

import java.util.List;

import astylesstuff.AStylesStuff;
import astylesstuff.common.AStylesTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlantItem extends astylesstuff.common.NCraftingItem
{
    public PlantItem()
    {
        super(new String[] { "dye.plant"},
        		new String[] {"dye_plant"});
        setCreativeTab(AStylesStuff.itemTab);
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return (new StringBuilder()).append("item.").append(unlocalizedNames[itemstack.getItemDamage()]).toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
        case 0:
            list.add(StatCollector.translateToLocal("tooltip.dye.part"));
            break;
        }
    }
}
