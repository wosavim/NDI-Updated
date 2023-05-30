package profhugo.nodami;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NDIUMod.MODID)
public class NDIUMod
{
	public static final String MODID = "ndiupdated";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static IEventBus bus;

	public NDIUMod()
	{
		bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NDIUConfig.SPEC);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{
		LOGGER.info("ndiupdated: Serverside operations started.");
		NDIUConfig.cacheValues();
		bus.register(new NDIUConfig());
	}


}
