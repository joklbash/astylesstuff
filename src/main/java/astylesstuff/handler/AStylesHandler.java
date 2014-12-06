package astylesstuff.handler;

import astylesstuff.AStylesBlocks;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class AStylesHandler 
{
	@SubscribeEvent
	public void useHoe(UseHoeEvent event)
	{
		if (event.world.getBlock(event.x, event.y, event.z) == AStylesBlocks.blockFertilizedDirt)
		{
			event.setResult(Result.ALLOW);
			event.world.setBlock(event.x, event.y, event.z, AStylesBlocks.blockFertilizedDirtTilled);
			event.world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, AStylesBlocks.blockFertilizedDirtTilled.stepSound.getStepResourcePath(), (AStylesBlocks.blockFertilizedDirtTilled.stepSound.getVolume() + 1.0F) / 2.0F, AStylesBlocks.blockFertilizedDirtTilled.stepSound.getPitch() * 0.8F);
		}
	}
}
