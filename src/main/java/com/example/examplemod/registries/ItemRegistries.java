package com.example.examplemod.registries;

import java.util.function.Supplier;

import com.jg.oldguns.OldGuns;
import com.jg.oldguns.client.ItemsReg;
import com.jg.oldguns.guns.GunPart;
import com.example.examplemod.guns.*;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistries {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "examplemod");
	
	public static final RegistryObject<Item> Kar98k = regAddGun("guns/kark",
			() -> new Kar98k(new Item.Properties().stacksTo(1).tab(OldGuns.tab), null));

	public static final RegistryObject<Item> Kar98kBarrel = regAddGunPart("guns/kark_barrel", "kark2",
			() -> new GunPart(new Item.Properties().stacksTo(16).tab(OldGuns.tab), 3, "kark2", 0, 8, true, GunPart.HEAVY));

	public static final RegistryObject<Item> Kar98kBody = regAddGunPart("guns/kark_body", "kark2",
			() -> new GunPart(new Item.Properties().stacksTo(16).tab(OldGuns.tab), 2, "kark2", 8, 8, true, GunPart.HEAVY));

	public static final RegistryObject<Item> Kar98kStock = regAddGunPart("guns/kark_stock", "kark2",
			() -> new GunPart(new Item.Properties().stacksTo(16).tab(OldGuns.tab), 1, "kark2", 8, 0, true, GunPart.HEAVY));
	
	public static final RegistryObject<Item> Colt1911 = regAddGun("guns/colt19112",
			() -> new Colt1911(new Item.Properties().stacksTo(1).tab(OldGuns.tab), null));

	public static final RegistryObject<Item> Colt1911Barrel = regAddGunPart("guns/kark_barrel", "colt19112",
			() -> new GunPart(new Item.Properties().stacksTo(16).tab(OldGuns.tab), 3, "colt19112", 0, 8, true, GunPart.LIGHT));

	public static final RegistryObject<Item> Colt1911Body = regAddGunPart("guns/kark_body", "colt19112",
			() -> new GunPart(new Item.Properties().stacksTo(16).tab(OldGuns.tab), 2, "colt19112", 8, 8, true, GunPart.LIGHT));

	public static final RegistryObject<Item> Colt1911Handle = regAddGunPart("guns/kark_stock", "colt19112",
			() -> new GunPart(new Item.Properties().stacksTo(16).tab(OldGuns.tab), 1, "colt19112", 8, 0, true, GunPart.LIGHT));
	
	public static <I extends Item> RegistryObject<I> regAddGunPart(String name, String id,
			final Supplier<? extends I> sup) {
		RegistryObject<I> obj = ITEMS.register(name, sup);
		ItemsReg.INSTANCE.registerPartForGun(obj, id);
		return obj;
	}
	
	public static <I extends Item> RegistryObject<I> regAddGun(String name, final Supplier<? extends I> sup) {
		RegistryObject<I> obj = ITEMS.register(name, sup);
		ItemsReg.INSTANCE.registerGun(obj);
		return obj;
	}
}
