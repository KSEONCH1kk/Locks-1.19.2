package melonslise.locks.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import melonslise.locks.common.container.KeyRingContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KeyRingScreen extends AbstractContainerScreen<KeyRingContainer>
{
	public static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");

	public KeyRingScreen(KeyRingContainer cont, Inventory inv, Component title)
	{
		super(cont, inv, title);
		this.imageHeight = 114 + cont.rows * 18;
		this.inventoryLabelY = this.imageHeight - 94;
	}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick)
	{
		this.renderBackground(poseStack);
		super.render(poseStack, mouseX, mouseY, partialTick);
		this.renderTooltip(poseStack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY)
	{
		int rows = this.getMenu().rows;
		RenderSystem.setShaderTexture(0, TEXTURE);
		int cornerX = (this.width - this.imageWidth) / 2;
		int cornerY = (this.height - this.imageHeight) / 2;
		this.blit(poseStack, cornerX, cornerY, 0, 0, this.imageWidth, rows * 18 + 17);
		this.blit(poseStack, cornerX, cornerY + rows * 18 + 17, 0, 126, this.imageWidth, 96);
	}
}