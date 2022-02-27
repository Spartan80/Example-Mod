package com.example.examplemod.modmodels;

import com.example.examplemod.registries.ItemRegistries;
import com.jg.oldguns.client.models.wrapper.WrapperModel;
import com.jg.oldguns.utils.Paths;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.item.Item;

public class Kar98kModModel2 extends WrapperModel{
	
	public Kar98kModModel2(IBakedModel origin) {
		super(origin, ItemRegistries.Kar98k.get());
	}

	@Override
	public Item getScope(int arg0) {
		return null;
	}

	@Override
	public String getHammerPath() {
		return Paths.KARKHAM;
	}
}
