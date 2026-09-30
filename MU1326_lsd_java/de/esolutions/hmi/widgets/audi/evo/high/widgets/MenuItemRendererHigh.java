/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class MenuItemRendererHigh
extends CompositeRendererHigh {
    private IWrappedNode3D backgroundParent;
    private IWrappedNode3DImage backgroundImage;

    public MenuItemRendererHigh(MenuItemController menuItemController) {
        super(menuItemController);
    }

    private MenuItemController getMenuItem() {
        return (MenuItemController)this.controller;
    }

    public void render(RedrawContext redrawContext) {
        this.clipping = this.needsMenuItemClipping();
        super.render(redrawContext);
        if (this.node != null) {
            this.node.setClippingInheritance(1);
        }
    }

    private boolean needsMenuItemClipping() {
        MenuItemController menuItemController = this.getMenuItem();
        return menuItemController.getClippingHeight() < menuItemController.getHeight();
    }

    protected int getClippingHeight() {
        MenuItemController menuItemController = this.getMenuItem();
        return Math.min(menuItemController.getClippingHeight(), menuItemController.getHeight());
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        ((RedrawContextHigh)redrawContext).parentNodeSecondary = null;
    }

    protected IWrappedNode3D getParentNode(RedrawContextHigh redrawContextHigh) {
        if (this.getMenuItem().isMoving()) {
            IWrappedNode3D iWrappedNode3D = redrawContextHigh.parentNodeSecondary;
            if (iWrappedNode3D != null) {
                return iWrappedNode3D;
            }
            menuItemLogCh.log(100000, "MenuItemRendererHigh#getParentNode: item is moving, but redrawContext contains no secondary parent layer. Context: %1", (Object)redrawContextHigh);
            return super.getParentNode(redrawContextHigh);
        }
        return super.getParentNode(redrawContextHigh);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        if (this.getMenuItem().isMoving()) {
            this.setupBackground();
        } else {
            this.destroyBackground();
        }
    }

    private void setupBackground() {
        if (this.backgroundParent == null) {
            this.backgroundParent = this.getEALManager().createNode3D(null, EALManager.createNodeName("menuItemBackgroundParent", this), this.controller.getWidth(), this.controller.getHeight(), -1);
            this.node.add(this.backgroundParent);
        }
        if (this.backgroundImage == null) {
            TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.black_pixel, false, this.getInitContext().getScreenID());
            if (textureDescription == null) {
                return;
            }
            this.backgroundImage = this.getEALManager().createImage3D(this.backgroundParent, EALManager.createNodeName("menuItemBackground", this), textureDescription, 0, true, (Object)this);
        }
        int n = Math.max(1, this.controller.getWidth());
        int n2 = Math.max(1, this.controller.getHeight());
        this.backgroundImage.setScale(n, n2, 1.0f);
        this.backgroundImage.setPosition(0.0f, 0.0f, 0.0f);
    }

    private void destroyBackground() {
        if (this.backgroundImage != null) {
            this.getEALManager().destroy(this.backgroundImage);
            this.backgroundImage = null;
        }
        if (this.backgroundParent != null) {
            this.getEALManager().destroy(this.backgroundParent);
            this.backgroundParent = null;
        }
    }

    public void disconnect() {
        this.destroyBackground();
        super.disconnect();
    }
}

