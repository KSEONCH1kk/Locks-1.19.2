package melonslise.locks.client.gui.sprite;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//存储纹理
@OnlyIn(Dist.CLIENT)
public class TextureInfo
{
	public int startX, startY, width, height, canvasWidth, canvasHeight;
	public ResourceLocation resourceLocation;

	public TextureInfo(int startX, int startY, int width, int height, int canvasWidth, int canvasHeight, ResourceLocation resourceLocation)
	{
		this.startX = startX;
		this.startY = startY;
		this.width = width;
		this.height = height;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		this.resourceLocation = resourceLocation;
	}

	public void draw(PoseStack poseStack, float x, float y, float alpha, ResourceLocation location)
	{
		RenderSystem.setShaderTexture(0, location);
		RenderSystem.enableBlend();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
		GuiComponent.blit(poseStack, (int)x, (int)y, this.startX, this.startY,
				this.width, this.height, this.canvasWidth, this.canvasHeight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableBlend();
	}
}