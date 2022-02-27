package com.example.examplemod.client;

import com.example.examplemod.gunmodels.Colt1911GunModel2;
import com.example.examplemod.gunmodels.Kar98kGunModel2;
import com.example.examplemod.registries.ItemRegistries;
import com.jg.oldguns.events.GunModelRegistryEvent;

import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ClientEventHandler {
	
	public static void setup() {
		
	}
	
	public static void registerModEventListeners(IEventBus bus) {
		bus.addListener(ClientEventHandler::modelRegistry);
	}

	public static void registerForgeEventListeners(IEventBus bus) {
		bus.addListener(ClientEventHandler::registerGunModels);
	}
	
	private static void modelRegistry(ModelRegistryEvent e) {
		// Here register your models
		// ModelLoader.addSpecialModel(
		// new ModelResourceLocation(new ResourceLocation(
		// "oldguns:special/kark_hammer", "inventory")));
	}
	
	private static void registerGunModels(GunModelRegistryEvent e) {
		e.registerGunModel(ItemRegistries.Kar98k.get(), new Kar98kGunModel2());
		e.registerGunModel(ItemRegistries.Colt1911.get(), new Colt1911GunModel2());
	}
}
