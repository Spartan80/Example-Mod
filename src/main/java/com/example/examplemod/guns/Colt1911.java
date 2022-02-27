package com.example.examplemod.guns;

import com.example.examplemod.registries.ItemRegistries;
import com.jg.oldguns.entities.Bullet;
import com.jg.oldguns.guns.ItemBullet;
import com.jg.oldguns.guns.ItemGun;
import com.jg.oldguns.registries.SoundRegistries;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class Colt1911 extends ItemGun{

	public Colt1911(Item.Properties prop, RegistryObject<Item> mag) {
		super(prop, mag);

	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		return super.onEntityItemUpdate(stack, entity);
	}

	@Override
	public Item getBarrel() {
		return ItemRegistries.Colt1911Barrel.get();
	}

	@Override
	public Item getBarrelMouth() {
		return null;
	}

	@Override
	public float getBaseSpeedModifier() {
		return 0;
	}

	@Override
	public Item getBody() {
		return ItemRegistries.Colt1911Body.get();
	}

	@Override
	public String getGunId() {
		return "colt19112";
	}

	@Override
	public ResourceLocation getNullPartsResLoc() {
		return null;
	}

	@Override
	public ResourceLocation getScopeResLoc() {
		return null;
	}

	@Override
	public Item getStock() {
		return ItemRegistries.Colt1911Handle.get();
	}

	@Override
	public boolean hasScope() {
		return false;
	}

	@Override
	public boolean isBoth() {
		return true;
	}

	@Override
	public void onHit(ItemStack arg0, LivingEntity arg1) {

	}

	@Override
	public boolean shouldRenderCrosshair() {
		return false;
	}

	@Override
	public boolean canChangeParts() {
		return true;
	}

	@Override
	public BulletProvider<? extends Bullet> getProjectile(ItemStack stack) {
		return Bullet::new;
	}

	@Override
	public ShootMode getShootMode(ItemStack stack) {
		return ShootMode.SEMI;
	}

	@Override
	public double getGunDamage(ItemStack stack) {
		return 4;
	}

	@Override
	public double getPower(ItemStack stack) {
		return 10;
	}

	@Override
	public float getInaccuracy(ItemStack stack) {
		return 0.1f;
	}

	@Override
	public float getRHorRecoil(ItemStack stack) {
		return 0.05f;
	}

	@Override
	public float getRVertRecoil(ItemStack stack) {
		return 0;
	}

	@Override
	public float getZRecoil(ItemStack stack) {
		return 0.2f;
	}

	@Override
	public float getBurstTargetTime(ItemStack stack) {
		return 0;
	}

	@Override
	public int getRecoilTime(ItemStack stack) {
		return 4;
	}

	@Override
	public int getShootTime(ItemStack stack) {
		return 4;
	}

	@Override
	public int getRange(ItemStack stack) {
		return 6;
	}

	@Override
	public int getShotgunBullets(ItemStack stack) {
		return 0;
	}

	@Override
	public int getBurstShots(ItemStack stack) {
		return 0;
	}

	@Override
	public float getRangeDamageReduction(ItemStack stack) {
		return 0.7f;
	}

	@Override
	public boolean isShotgun(ItemStack stack) {
		return false;
	}

	@Override
	public boolean requiresMag(ItemStack stack) {
		return true;
	}

	@Override
	public String getAcceptedBulletType(ItemStack stack) {
		return ItemBullet.SMALL;
	}
	
	@Override
	public SoundEvent getShootSound(ItemStack stack) {
		return SoundRegistries.COLTSHOOT.get();
	}

	@Override
	public Item getBulletItem(ItemStack stack) {
		return null;
	}
	
}
