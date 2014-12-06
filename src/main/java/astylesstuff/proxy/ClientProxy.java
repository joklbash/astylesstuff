package astylesstuff.proxy;

import astylesstuff.client.CropRender;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderInformation()
	{
		RenderingRegistry.registerBlockHandler(new CropRender());
	}
}
