package com.example.examplemod.gunmodels;

import com.example.examplemod.modmodels.Kar98kModModel2;
import com.jg.oldguns.animations.Animation;
import com.jg.oldguns.animations.RepetitiveAnimation;
import com.jg.oldguns.client.ClientEventHandler;
import com.jg.oldguns.client.handlers.ReloadHandler;
import com.jg.oldguns.client.handlers.SoundHandler;
import com.jg.oldguns.client.models.GunModel;
import com.jg.oldguns.client.models.GunModelPart;
import com.jg.oldguns.registries.ItemRegistries;
import com.jg.oldguns.registries.SoundRegistries;
import com.jg.oldguns.utils.MeleeHelper;
import com.jg.oldguns.utils.Paths;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class Kar98kGunModel2 extends GunModel{

	public static final Animation SA = Animation.create(24);
	public static final RepetitiveAnimation R = Animation.createRep(43);
	public static final Animation KB = Animation.create(32);
	public static final Animation IA = Animation.create(32);

	public Kar98kGunModel2() {
		super(ItemRegistries.Kar98k.get());
	}

	@Override
	public void initExtraParts() {

	}

	@Override
	public void onAnimationEnd() {
		
	}

	@Override
	public boolean canRenderMag(ItemStack arg0) {
		return false;
	}

	@Override
	public boolean canShoot(ItemStack arg0) {
		return getAnimation() == EMPTY;
	}

	@Override
	public void doGetOutMag(ItemStack arg0) {

	}

	@Override
	public String getHammerPath() {
		return Paths.KARKHAM;
	}

	@Override
	public IBakedModel getModifiedModel(IBakedModel origin) {
		return new Kar98kModModel2(origin);
	}

	@Override
	public GunModelPart[] getParts() {
		return new GunModelPart[] { rightarm, leftarm, gun, mag, hammer, scope };
	}

	@Override
	public void handleAim(MatrixStack matrix, float p) {
		debugAim(matrix, p);
		matrix.translate(MathHelper.lerp(p, 0, -0.2999f), MathHelper.lerp(p, 0, 0.055f), 0);
		matrix.mulPose(Vector3f.YN.rotation((float) Math.toRadians(MathHelper.rotLerp(p, 0, 6))));
	}

	@Override
	public void handleSprint(MatrixStack matrix, float p) {
		matrix.mulPose(Vector3f.XP.rotation((float) Math.toRadians(MathHelper.rotLerp(p, 0, -24))));
	}

	@Override
	public void initReloadAnimation(int gun, int mag) {
		int bf = 5 - gun;
		if (mag > bf && bf != 0) {
			mag = bf;
			R.setDuration(35 + (mag*8));
			R.setTimes(mag);
		} else {
			R.setDuration(35 + (mag*8));
			R.setTimes(mag);
		}
		setAnimation(R);
	}

	@Override
	public void onAnimTick(float tick) {
		Animation c = getAnimation();
		ItemStack stack = ClientEventHandler.getPlayer().getMainHandItem();
		System.out.println("v: " + ((22 + (((tick-22)/8)*8))) + " Duration: " + R.getDuration());
		if (c == SA) {
			if (tick == 8) {
				SoundHandler.playSoundOnServer(SoundRegistries.KARKBACK.get(), SoundCategory.NEUTRAL);
			} else if (tick == 12) {
				SoundHandler.playSoundOnServer(SoundRegistries.KARKBACK.get(), SoundCategory.NEUTRAL);
			}
		} else if(c == R) {
			if(tick == 12) {
				SoundHandler.playSoundOnServer(SoundRegistries.KARKBACK.get(), SoundCategory.NEUTRAL);
			} else if(tick >= 22 && (tick-22)%8 == 0 && (((tick-22)/8)+1) <= R.getTimes()) {
				SoundHandler.playSoundOnServer(SoundRegistries.KARKPUSH.get(), SoundCategory.NEUTRAL);
				ReloadHandler.growOneBullet(stack);
				ReloadHandler.removeItem(ammoindex, 1);
			} else if(tick == ((22 + (R.getTimes()*8))+2)) {
				SoundHandler.playSoundOnServer(SoundRegistries.KARKFORWARD.get(), SoundCategory.NEUTRAL);
			}
		} else if(c == KB) {
			if(animTick == 1) {
				SoundHandler.playSoundOnServer(SoundRegistries.SWING.get());
			} if(tick == 4) {
				MeleeHelper.hit(7);
			}
		}

	}

	@Override
	public void onShoot(ItemStack arg0) {
		setAnimation(SA);

	}

	@Override
	public void setupAnimations() {

		// Shoot animation
		animator.setAnimation(SA);
		animator.startKeyframe(4);
		animator.move(rightarm, 0.15f, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(rightarm, 0.11f, 0.23f, -0.14f);
		animator.endKeyframe();
		animator.startKeyframe(2);
		animator.move(hammer, 0.02f, -0.01f, 0.23f);
		animator.move(rightarm, 0.15f, 0.23f, 0);
		animator.endKeyframe();
		animator.startKeyframe(2);
		animator.move(hammer, 0.02f, -0.01f, 0.23f);
		animator.move(rightarm, 0.15f, 0.23f, 0);
		animator.endKeyframe();
		animator.startKeyframe(2);
		animator.move(rightarm, 0.11f, 0.23f, -0.14f);
		animator.endKeyframe();
		animator.startKeyframe(2);
		animator.move(rightarm, 0.11f, 0.23f, -0.14f);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(rightarm, 0.15f, 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(4);
		animator.endKeyframe();

		animator.setAnimation(R);
		animator.startKeyframe(4);
		animator.move(rightarm, 0.15f, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(rightarm, 0.11f, 0.23f, -0.14f);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(hammer, 0.02f, -0.01f, 0.23f);
		animator.move(rightarm, 0.15f, 0.23f, 0);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(rightarm, 0.06f, 0.23f, -0.14f);
		animator.move(leftarm, -0.05f, -0.02f, 0);
		animator.move(gun, 0.18f, -0.1f, 0f);
		animator.rotate(gun, 0, -0.279252f, 0);
		animator.move(hammer, 0.2f, -0.1f, 0.18f);
		animator.rotate(hammer, 0, -0.279252f, 0);
		animator.endKeyframe();
		R.anim(() -> {
			animator.startKeyframe(4);
			animator.move(rightarm, 0.04f, 0.19f, -0.14f);
			animator.move(leftarm, -0.05f, -0.02f, 0);
			animator.move(gun, 0.18f, -0.1f, 0f);
			animator.rotate(gun, 0, -0.279252f, 0);
			animator.move(hammer, 0.2f, -0.1f, 0.18f);
			animator.rotate(hammer, 0, -0.279252f, 0);
			animator.endKeyframe();
			animator.startKeyframe(4);
			animator.move(rightarm, 0.06f, 0.23f, -0.14f);
			animator.move(leftarm, -0.05f, -0.02f, 0);
			animator.move(gun, 0.18f, -0.1f, 0f);
			animator.rotate(gun, 0, -0.279252f, 0);
			animator.move(hammer, 0.2f, -0.1f, 0.18f);
			animator.rotate(hammer, 0, -0.279252f, 0);
			animator.endKeyframe();
		});
		animator.startKeyframe(4);
		animator.move(rightarm, 0.1f, 0.27f, 0.05f);
		animator.rotate(rightarm, 0, -0.06981f, 0);
		animator.move(leftarm, -0.05f, -0.02f, 0);
		animator.move(gun, 0.18f, -0.1f, 0f);
		animator.rotate(gun, 0, -0.279252f, 0);
		animator.move(hammer, 0.2f, -0.1f, 0.18f);
		animator.rotate(hammer, 0, -0.279252f, 0);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(rightarm, 0.05f, 0.27f, -0.14f);
		animator.rotate(rightarm, 0, -0.06981f, 0);
		animator.move(leftarm, -0.05f, -0.02f, 0);
		animator.move(gun, 0.18f, -0.1f, 0f);
		animator.rotate(gun, 0, -0.279252f, 0);
		animator.move(hammer, 0.18f, -0.1f, -0.02f);
		animator.rotate(hammer, 0, -0.279252f, 0);
		animator.endKeyframe();
		animator.startKeyframe(5);
		animator.move(rightarm, 0.15f, 0, 0);
		animator.rotate(rightarm, 0, -0.06981f, 0);
		animator.move(leftarm, -0.05f, -0.02f, 0);
		animator.move(gun, 0.18f, -0.1f, 0f);
		animator.rotate(gun, 0, -0.279252f, 0);
		animator.move(hammer, 0.18f, -0.1f, -0.02f);
		animator.rotate(hammer, 0, -0.279252f, 0);
		animator.endKeyframe();
		animator.resetKeyframe(6);
		animator.endKeyframe();
		
		animator.setAnimation(KB);
		animator.startKeyframe(2);
		animator.move(leftarm, -0.13300012f, 0.0f, 0.1310002f);
		animator.move(gun, 0.59f, 0.0155000003f, -0.100022f);
		animator.rotate(gun, 0.0f, 0.0f, 0.74351515f);
		animator.move(hammer, 0.59f, 0.0155000003f, -0.100022f);
		animator.rotate(hammer, 0.0f, 0.0f, 0.74351515f);
		animator.rotate(rightarm, 0.282744525f, 0.0f, 0.0f);
		animator.endKeyframe();
		animator.startKeyframe(1);
		animator.move(leftarm, -0.26600012f, 0.0f, 0.2610002f);
		animator.move(gun, 1.1889995f, 0.031000003f, -0.19900022f);
		animator.rotate(gun, 0.0f, 0.0f, 1.4870303f);
		animator.rotate(rightarm, 0.56548905f, 0.0f, 0.0f);
		animator.move(hammer, 1.1889995f, 0.031000003f, -0.19900022f);
		animator.rotate(hammer, 0.0f, 0.0f, 1.4870303f);
		animator.endKeyframe();
		animator.startKeyframe(2);
		animator.move(leftarm, -0.26600012f, 0.0f, 0.2610002f);
		animator.move(gun, 1.1889995f, 0.031000003f, -0.19900022f);
		animator.rotate(rightarm, 0.56548905f, 0.0f, 0.0f);
		animator.rotate(gun, 0.0f, 0.0f, 1.4870303f);
		animator.move(hammer, 1.1889995f, 0.031000003f, -0.19900022f);
		animator.rotate(hammer, 0.0f, 0.0f, 1.4870303f);
		animator.endKeyframe();
		animator.resetKeyframe(8);
		animator.endKeyframe();
		
		animator.setAnimation(IA);
		animator.startKeyframe(4);
		animator.move(gun, 0.0f, 0.30999997f, 0.0f);
		animator.move(leftarm, 0.22000001f, 0.0f, 0.0f);
		animator.move(rightarm, 0.2f, -0.02f, -0.06999999f);
		animator.rotate(gun, 0.0f, 0.43633226f, 0.0f);
		animator.rotate(leftarm, 0.0f, -0.52359873f, 0.0f);
		animator.rotate(rightarm, 0.0f, 0.43633226f, 0.0f);
		animator.endKeyframe();
		animator.startKeyframe(8);
		animator.move(gun, 0.0f, 0.30999997f, 0.0f);
		animator.move(leftarm, 0.22000001f, 0.0f, 0.0f);
		animator.move(rightarm, 0.2f, -0.02f, -0.06999999f);
		animator.rotate(gun, 0.0f, 0.43633226f, 0.0f);
		animator.rotate(leftarm, 0.0f, -0.52359873f, 0.0f);
		animator.rotate(rightarm, 0.0f, 0.43633226f, 0.0f);
		animator.endKeyframe();
		animator.startKeyframe(4);
		animator.move(gun, 0.25000003f, -0.040000014f, 0.0f);
		animator.move(leftarm, -0.14f, 0.0f, 0.0f);
		animator.move(rightarm, -0.050000012f, 0.23000003f, -0.06999999f);
		animator.rotate(gun, 0.0f, -0.43633223f, 0.0f);
		animator.rotate(leftarm, 0.0f, -0.52359873f, 0.0f);
		animator.rotate(rightarm, 0.0f, -0.43633223f, 0.0f);
		animator.endKeyframe();
		animator.startKeyframe(8);
		animator.move(gun, 0.25000003f, -0.040000014f, 0.0f);
		animator.move(leftarm, -0.14f, 0.0f, 0.0f);
		animator.move(rightarm, -0.050000012f, 0.23000003f, -0.06999999f);
		animator.rotate(gun, 0.0f, -0.43633223f, 0.0f);
		animator.rotate(leftarm, 0.0f, -0.52359873f, 0.0f);
		animator.rotate(rightarm, 0.0f, -0.43633223f, 0.0f);
		animator.endKeyframe();
		animator.resetKeyframe(4);
		animator.endKeyframe();
		
	}

	@Override
	public void setupParts() {
		
		setPartDisplayTransform(rightarm, 0.0400f, 0.3710f, 0.7298f, -0.5060f, -0.5410f, -0.4009f);
		setPartDisplayTransform(leftarm, -0.3397f, 0.8498f, 0.6989f, 0.3666f, 0.8202f, 0.2619f);
		setPartDisplayTransform(gun, -0.24f, -0.84f, -0.08f, -1.5533f, 0, 0.1047f);
		setPartDisplayTransform(scope, -0.24f, -0.84f, -0.08f, -1.5533f, 0, 0.1047f);
		setPartDisplayTransform(hammer, -0.24f, -0.84f, -0.08f, -1.5533f, 0, 0.1047f);
		
	}

	@Override
	public boolean hasMultipleParts() {
		return true;
	}

	@Override
	public void startKickBackAnim() {
		setAnimation(KB);
		
	}

	@Override
	public void startInspectAnim() {
		setAnimation(IA);
		
	}

	@Override
	public Vector3f getMuzzleFlashPos(ItemStack stack) {
		return new Vector3f(0.071f, -0.13f, -2.14f);
	}

}
