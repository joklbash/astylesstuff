package astylesstuff.common;

import astylesstuff.AStylesBlocks;
import astylesstuff.AStylesItems;
import astylesstuff.AStylesStuff;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class AStylesTab extends CreativeTabs
{
	public AStylesTab(String label)
	{
		super(label);
	}

	@Override
	public Item getTabIconItem()
	{
		if (this.getTabLabel().equals(AStylesStuff.itemTab.getTabLabel()))
			return AStylesItems.itemBHOG;
		else if (this.getTabLabel().equals(AStylesStuff.blockTab.getTabLabel()))
			return Item.getItemFromBlock(AStylesBlocks.blockColoredStone);
		else
			return null;
	}
	
    @Override
    public String getTranslatedTabLabel()
    {
        return this.getTabLabel();
    }

}
