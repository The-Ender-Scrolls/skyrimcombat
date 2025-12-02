package com.ryankshah.skyrimcombat.screen;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.network.recipe.FinishForgeRecipe;
import commonnetwork.api.Dispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ForgeScreen extends Screen
{
    protected static final ResourceLocation OVERLAY_ICONS = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "textures/gui/overlay_icons.png");

    // Mouse interaction variables
    private boolean isDragging = false;
    private int lastMouseX = 0;
    private int lastMouseY = 0;

    // UI bounds for mouse interaction
    private static final int CATEGORY_PANEL_X = 10;
    private static final int CATEGORY_PANEL_WIDTH = 70;
    private static final int ITEM_PANEL_X = 90;
    private static final int ITEM_PANEL_WIDTH = 110;

    private Multimap<String, ForgeRecipe> items;
    private List<ForgeRecipe> itemList;
    private Object[] categories;
    private boolean categoryChosen;
    private int currentCategory;
    private int currentItem;
    private int categoryStartIndex, itemStartIndex;
    private float spin = 0.0F;
    private ForgeRecipe currentRecipeObject = null;
    private Player player;

    public ForgeScreen(List<ForgeRecipe> recipes) {
        super(Component.translatable(Constants.MOD_ID + ".forgescreen.title"));
        this.player = Minecraft.getInstance().player;
        this.items = ArrayListMultimap.create();
        recipes.forEach(recipe -> items.put(recipe.getCategory(), recipe));
        this.categories = this.items.keySet().toArray();
        this.currentCategory = 0;
        this.currentItem = 0;
        this.itemList = new ArrayList<>();
        this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
        this.itemList.sort(Comparator.comparing(i -> i.getResult().getItem().getDescriptionId()));
        this.categoryChosen = false;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        Matrix3x2fStack matrixStack = graphics.pose();

        if(!this.categoryChosen) {
            graphics.fillGradient(10, 0, 80, this.height - 2, 0xAA000000, 0xAA555555);
            graphics.fillGradient(12, 2, 13, this.height - 2, 0xFF6E6B64, 0xFF6E6B64);
            graphics.fillGradient(77, 2, 78, this.height - 2, 0xFF6E6B64, 0xFF6E6B64);
            graphics.fillGradient(90, 0, 200, this.height, 0xAA000000, 0xAA000000);
            graphics.fillGradient(197, 2, 198, this.height - 2, 0xFF5D5A51, 0xFF5D5A51);
            graphics.fillGradient(92, 2, 93, this.height - 2, 0xFF5D5A51, 0xFF5D5A51);
        } else {
            graphics.fillGradient(10, 0, 80, this.height - 2, 0xAA000000, 0xAA000000);
            graphics.fillGradient(12, 2, 13, this.height - 2, 0xFF5D5A51, 0xFF5D5A51);
            graphics.fillGradient(77, 2, 78, this.height - 2, 0xFF5D5A51, 0xFF5D5A51);
            graphics.fillGradient(90, 0, 200, this.height, 0xAA000000, 0xAA555555);
            graphics.fillGradient(197, 2, 198, this.height - 2, 0xFF6E6B64, 0xFF6E6B64);
            graphics.fillGradient(92, 2, 93, this.height - 2, 0xFF6E6B64, 0xFF6E6B64);
        }

        int MIN_Y = 20;
        int MAX_Y = height / 2 + 14 * 6 - 10;

        if (!this.items.isEmpty()) {
            Object[] categories = this.getCategories(this.items);

            for(int i = 0; i < categories.length; i++) {
                int y = this.height / 2 + 14 * i - this.currentCategory * font.lineHeight;
                if(y <= MIN_Y || y >= MAX_Y)
                    continue;

                String categoryName = ((String)categories[i]).toUpperCase();

                if (categoryName.length() >= 10)
                    categoryName = categoryName.substring(0, 8) + "..";

                int color = i == currentCategory ? 0xFFFFFFFF : 0xFFC0C0C0;
                // Highlight on hover
                if (isMouseOverCategory(i, y)) {
                    color = 0xFFFFFFAA; // Light yellow highlight
                }

                graphics.drawString(font, categoryName, 18, y, color);
            }

            if (this.itemList != null) {
                for(int i = 0; i < itemList.size(); i++) {
                    ForgeRecipe recipe = this.itemList.get(i);

                    if (i == this.currentItem) {
                        this.currentRecipeObject = recipe;
                        this.drawItemImage(graphics, recipe.getResult(), width - 100, height / 2 - 70, this.spin);
                        this.drawItemInformation(graphics, recipe);
                    }

                    int y = this.height / 2 + 14 * i - this.currentItem * font.lineHeight;
                    if(y <= MIN_Y || y >= MAX_Y)
                        continue;

                    String name = recipe.getResult().getHoverName().getString();
                    if (name.length() >= 16)
                        name = name.substring(0, 14) + "..";

                    int color = i == currentItem ? 0xFFFFFFFF : 0xFFC0C0C0;
                    // Highlight on hover
                    if (isMouseOverItem(i, y)) {
                        color = 0xFFFFFFAA; // Light yellow highlight
                    }

                    graphics.drawString(font, name, 98, y, color);
                }
            }
        }

        graphics.fillGradient(0, this.height * 3 / 4 + 20, this.width, this.height, 0xAA000000, 0xAA000000);
        graphics.fillGradient(0, this.height * 3 / 4 + 22, this.width, this.height * 3 / 4 + 23, 0xFF6E6B64, 0xFF6E6B64);
        drawBorderedGradientRect(graphics, 17, this.height - 29, 32 + font.width("Enter"), this.height - 14, 0xAA000000, 0xAA000000, 0xFF6E6B64);
        graphics.drawString(font, "Enter", 25, this.height - 25, 0xFFFFFFFF);
        // Render "Create" button with hover effect
        int buttonX = 32 + font.width("Enter") + 6;
        int buttonY = this.height - 25;
        int buttonWidth = font.width("Create");
        int buttonHeight = 9;

        boolean isHoveringCreateButton = mouseX >= buttonX && mouseX <= buttonX + buttonWidth &&
                mouseY >= buttonY && mouseY <= buttonY + buttonHeight;

        int createButtonColor = isHoveringCreateButton ? 0xFFFFFFAA : 0xFFFFFFFF;
        graphics.drawString(font, "Create", buttonX, buttonY, createButtonColor);

        renderHealth(graphics);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.spin >= 360.0f)
            this.spin = 0.0f;
        else
            ++this.spin;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if(scrollY < 0) {
            if (!this.categoryChosen) {
                if (this.currentCategory < this.categories.length - 1)
                    ++this.currentCategory;

                this.itemList.clear();
                this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
            } else {
                if (this.currentItem < this.itemList.size() - 1)
                    ++this.currentItem;
            }
        } else if(scrollY > 0) {
            if (!this.categoryChosen) {
                if(this.currentCategory > 0)
                    --this.currentCategory;

                this.itemList.clear();
                this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
            } else {
                if (this.currentItem > 0)
                    --this.currentItem;
            }
        }
        return true;
    }

    @Override
    public boolean keyPressed(KeyEvent event) {
        if(event.key() == GLFW.GLFW_KEY_DOWN || event.key() == GLFW.GLFW_KEY_S) {
            if (!this.categoryChosen) {
                if (this.currentCategory < this.categories.length - 1) {
                    ++this.currentCategory;
                } else {
                    this.currentCategory = this.categories.length - 1;
                }

                this.itemList.clear();
                this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
            } else if (this.currentItem < this.itemList.size() - 1) {
                ++this.currentItem;
            } else {
                this.currentItem = this.itemList.size() - 1;
            }
        }

        if(event.key() == GLFW.GLFW_KEY_UP || event.key() == GLFW.GLFW_KEY_W) {
            if (!this.categoryChosen) {
                if (this.currentCategory > 0) {
                    --this.currentCategory;
                } else {
                    this.currentCategory = 0;
                }

                this.itemList.clear();
                this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
            } else if (this.currentItem > 0) {
                --this.currentItem;
            } else {
                this.currentItem = 0;
            }
        }

        if(event.key() == GLFW.GLFW_KEY_RIGHT || event.key() == GLFW.GLFW_KEY_D) {
            if(!this.categoryChosen) {
                this.categoryChosen = true;
                this.currentItem = 0;
            }
        }

        if(event.key() == GLFW.GLFW_KEY_LEFT || event.key() == GLFW.GLFW_KEY_A) {
            if(this.categoryChosen) {
                this.categoryChosen = false;
                this.currentItem = 0;
            }
        }

        if(event.key() == GLFW.GLFW_KEY_ENTER) {
            if (!this.categoryChosen) {
                return false;
            }

            final FinishForgeRecipe finishRecipe = new FinishForgeRecipe(currentRecipeObject);
            Dispatcher.sendToServer(finishRecipe);
        }

        return super.keyPressed(event);
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean isDoubleClick) {
        if (event.button() == 0) { // Left click
            // Check if clicking on categories
            if (event.x() >= CATEGORY_PANEL_X && event.x() <= CATEGORY_PANEL_X + CATEGORY_PANEL_WIDTH) {
                int clickedCategory = getCategoryAtMouse((int)event.y());
                if (clickedCategory != -1 && clickedCategory != this.currentCategory) {
                    this.currentCategory = clickedCategory;
                    this.itemList.clear();
                    this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
                    this.currentItem = 0;
                    this.categoryChosen = false;
                    return true;
                }
            }

            // Check if clicking on items
            if (event.x() >= ITEM_PANEL_X && event.x() <= ITEM_PANEL_X + ITEM_PANEL_WIDTH) {
                int clickedItem = getItemAtMouse((int)event.y());
                if (clickedItem != -1) {
                    this.currentItem = clickedItem;
                    this.categoryChosen = true;
                    return true;
                }
            }

            // Check if clicking on Create button
            int buttonX = 32 + font.width("Enter") + 6;
            int buttonY = this.height - 25;
            int buttonWidth = font.width("Create");
            int buttonHeight = 9;

            if (event.x() >= buttonX && event.x() <= buttonX + buttonWidth &&
                    event.y() >= buttonY && event.y() <= buttonY + buttonHeight &&
                    this.categoryChosen && this.currentRecipeObject != null) {

                final FinishForgeRecipe finishRecipe = new FinishForgeRecipe(currentRecipeObject);
                Dispatcher.sendToServer(finishRecipe);
                return true;
            }
        }

        return super.mouseClicked(event, isDoubleClick);
    }

    @Override
    public boolean mouseDragged(MouseButtonEvent event, double mouseX, double mouseY) {
        if (event.button() == 0) {
            this.isDragging = true;
            // Handle drag scrolling if needed
            return true;
        }
        return super.mouseDragged(event, mouseX, mouseY);
    }

    @Override
    public boolean mouseReleased(MouseButtonEvent event) {
        if (event.button() == 0) {
            this.isDragging = false;
        }
        return super.mouseReleased(event);
    }

    // Helper methods for mouse interaction
    private boolean isMouseOverCategory(int categoryIndex, int categoryY) {
        double mouseX = minecraft.mouseHandler.xpos() * minecraft.getWindow().getGuiScaledWidth() / minecraft.getWindow().getScreenWidth();
        double mouseY = minecraft.mouseHandler.ypos() * minecraft.getWindow().getGuiScaledHeight() / minecraft.getWindow().getScreenHeight();

        return mouseX >= CATEGORY_PANEL_X && mouseX <= CATEGORY_PANEL_X + CATEGORY_PANEL_WIDTH &&
                mouseY >= categoryY && mouseY <= categoryY + font.lineHeight;
    }

    private boolean isMouseOverItem(int itemIndex, int itemY) {
        double mouseX = minecraft.mouseHandler.xpos() * minecraft.getWindow().getGuiScaledWidth() / minecraft.getWindow().getScreenWidth();
        double mouseY = minecraft.mouseHandler.ypos() * minecraft.getWindow().getGuiScaledHeight() / minecraft.getWindow().getScreenHeight();

        return mouseX >= ITEM_PANEL_X && mouseX <= ITEM_PANEL_X + ITEM_PANEL_WIDTH &&
                mouseY >= itemY && mouseY <= itemY + font.lineHeight;
    }

    private int getCategoryAtMouse(int mouseY) {
        int MIN_Y = 20;
        int MAX_Y = height / 2 + 14 * 6 - 10;

        for (int i = 0; i < this.categories.length; i++) {
            int y = this.height / 2 + 14 * i - this.currentCategory * font.lineHeight;
            if (y <= MIN_Y || y >= MAX_Y) continue;

            if (mouseY >= y && mouseY <= y + font.lineHeight) {
                return i;
            }
        }
        return -1;
    }

    private int getItemAtMouse(int mouseY) {
        if (this.itemList == null) return -1;

        int MIN_Y = 20;
        int MAX_Y = height / 2 + 14 * 6 - 10;

        for (int i = 0; i < this.itemList.size(); i++) {
            int y = this.height / 2 + 14 * i - this.currentItem * font.lineHeight;
            if (y <= MIN_Y || y >= MAX_Y) continue;

            if (mouseY >= y && mouseY <= y + font.lineHeight) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isMouseOver(double mouseX, double mouseY) {
        return true;
    }

    @Override
    public void removed() {
        super.removed();
    }

    private void drawItemImage(GuiGraphics graphics, ItemStack is, int xPos, int yPos, float spin) {
        var poseStack = graphics.pose();
        poseStack.pushMatrix();

        poseStack.translate(xPos + 8, yPos + 8);
        poseStack.rotate((float)Math.toRadians(spin));
        poseStack.scale(3.75f, 3.75f);

        graphics.renderItem(is, -8, -8);
        poseStack.popMatrix();
    }

    private void drawItemInformation(GuiGraphics graphics, ForgeRecipe recipe) {
        drawBorderedGradientRect(graphics, this.width - 180, this.height / 2 - 20, this.width - 20, this.height / 2 + 20 + (10 * recipe.getRecipeItems().size()), 0xAA000000, 0xAA000000, 0xFF6E6B64);
        graphics.fillGradient(this.width - 160, (this.height) / 2, this.width - 40, (this.height) / 2 + 1, 0xFF6E6B64, 0xFF6E6B64); // Line under recipe item name

        graphics.drawCenteredString(font, recipe.getResult().getHoverName(), width - 100, height / 2 - 10, 0xFFFFFFFF);

        for(int i = 0; i < recipe.getIngredients().size(); i++) {
            Ingredient ingredient = recipe.getIngredients().get(i);
            ItemStack is = new ItemStack(ingredient.items().toList().get(0).value());
            boolean hasItem = hasItem(player, is);

            graphics.drawCenteredString(font, is.getHoverName().plainCopy().append(Component.translatable(" (" + is.getCount() + ")")), width - 100, height / 2 + 10 + (10 * i+1), !hasItem ? 0xFFFF0000 : 0xFF228B22);
        }
    }

    public static boolean hasItem(Player player, ItemStack is) {
        if (is != null) {
            int count = 0;
            for(int i = 0; i < player.inventoryMenu.slots.size(); ++i) {
                ItemStack stack = player.getInventory().getItem(i);

                if(stack.is(is.getItem())) {
                    count += stack.getCount();
                    if(count >= is.getCount())
                        return true;
                }
            }
        }
        return false;
    }

    private Object[] getCategories(Multimap<String, ForgeRecipe> items) {
        return items.keySet().toArray();
    }

    private void renderHealth(GuiGraphics graphics) {
        float healthPercentage = this.minecraft.player.getHealth() / minecraft.player.getMaxHealth();
        float healthBarWidth = 80.0f * healthPercentage;
        float healthBarStartX = (float)(width - 109) + (80.0f - healthBarWidth);

        // Use the correct RenderPipeline for textured blits
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                OVERLAY_ICONS,
                this.width - 120,
                this.height - 25,
                0, 51,
                102, 10,
                256, 256  // texture width and height
        );

        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                OVERLAY_ICONS,
                (int)healthBarStartX,
                this.height - 23,
                12 + ((78 - (int)healthBarWidth) / 2), 72,
                (int)healthBarWidth, 6,
                256, 256  // texture width and height
        );
    }

    private void drawBorderedGradientRect(GuiGraphics graphics, int startX, int startY, int endX, int endY, int colorStart, int colorEnd, int borderColor) {
        // Draw background
        graphics.fillGradient(startX, startY, endX, endY, colorStart, colorEnd);
        // Draw borders
        graphics.fill(startX, startY, endX, startY+1, borderColor); // top
        graphics.fill(startX, endY-1, endX, endY, borderColor); // bottom
        graphics.fill(startX, startY+1, startX+1, endY-1, borderColor); // left
        graphics.fill(endX-1, startY+1, endX, endY-1, borderColor); // right
    }
}