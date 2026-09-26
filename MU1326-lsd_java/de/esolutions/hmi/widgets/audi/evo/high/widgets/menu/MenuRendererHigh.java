/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLineController;

public class MenuRendererHigh
extends CompositeRendererHigh {
    private static final int CURSOR_LEFT_BREADTH;
    protected static final int NODE_FOREGROUND;
    protected static final int NODE_CONTENT;
    protected static final int NODE_CONTENT_FOREGROUND;
    protected static final int NODE_CURSOR_SCROLLBAR;
    protected static final int NODE_FOCUS_CURSOR_SHADOW;
    protected static final int NODE_SELECTION_CURSOR;
    protected static final int NODE_UNCLIPPED;
    protected static final int NODE_GLASSPLATE;
    protected static final int NODE_BACKGROUND;
    protected static final int NODE_NOW_PLAYING_WIDGET;
    protected static final int NODE_NOW_PLAYING_WIDGET_CLIPPED;
    protected static final int NODE_UNCLIPPED_FOREGROUND;
    protected static final int NODE_TRANSLATION;
    protected static final int NODE_OFFSET;
    protected static final int NODE_UNCLIPPED_TRANSLATION;
    protected final IWrappedNode3D[] nodes = new IWrappedNode3D[16];
    protected IWrappedLayer menuLayer;
    protected IWrappedNode3D parentOfOffsetNode;
    private boolean createdLayer;

    public MenuRendererHigh(MenuController menuController) {
        super(menuController);
    }

    @Override
    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        IWrappedNode3D iWrappedNode3D;
        super.renderNode(redrawContextHigh);
        MenuController menuController = (MenuController)this.controller;
        int n = this.controller.getWidth();
        int n2 = this.controller.getHeight();
        int n3 = menuController.getClipOffsetTop();
        int n4 = this.controller.getHeight() - n3 + menuController.getClipOffsetBottom();
        this.nodes[7] = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("MenuGlassplateNode", this), n, n2);
        this.menuLayer = redrawContextHigh.offscreenLayer;
        this.createdLayer = false;
        if (this.menuLayer == null && this.hasGlassplate()) {
            this.menuLayer = this.getEALManager().createLayer(EALManager.createNodeName("MainMenu", this), -10, GlassplateRendererHigh.OFFSCREEN_TEXTURE_WIDTH, GlassplateRendererHigh.OFFSCREEN_TEXTURE_HEIGHT);
            this.parentOfOffsetNode = this.menuLayer.getNode();
            this.createUnclippedNodes(this.node, n, n2);
            if (this.menuLayer != null) {
                this.createdLayer = true;
            }
        } else {
            this.parentOfOffsetNode = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("SubMenuNode", this), n, n2);
            iWrappedNode3D = redrawContextHigh.parentNodeSecondary;
            if (iWrappedNode3D != null) {
                int n5 = redrawContextHigh.getCalculatedNodeIndex(this.getAbstractController().getDepth());
                this.nodes[15] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuUnclippedTranslationNode", this), n, n2, n5);
                this.createUnclippedNodes(this.nodes[15], n, n2);
            } else {
                this.createUnclippedNodes(this.node, n, n2);
            }
        }
        this.nodes[13] = this.getEALManager().createNode3D(this.parentOfOffsetNode, EALManager.createNodeName("MenuTextureOffsetNode", this), n, n2);
        this.nodes[12] = iWrappedNode3D = this.getEALManager().createNode3D(this.nodes[13], EALManager.createNodeName("MenuTranslationNode", this), n, n2);
        this.nodes[8] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuBackgroundNode", this), n, n2);
        if (this.hasNowPlayingWidgetsClipped()) {
            this.nodes[10] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuNowPlayingWidgetsClipped", this), n, n2);
        }
        this.nodes[4] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuFocusShadowCursorNode", this), n, n2);
        this.nodes[5] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuSelectionCursorNode", this), n, n2);
        this.nodes[1] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuContentNode", this), n, n2);
        this.nodes[2] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuContentForegroundNode", this), n, n2);
        this.nodes[3] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuFocusCursorNode", this), n, n2);
        this.nodes[0] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuForegroundNode", this), n, n2);
        if (this.menuLayer == null && !this.getMenu().isComboBoxMenu() || this.getMenu().isClipContent()) {
            this.nodes[4].setClippingRectangle(28866, n3, n + 60, n4);
            this.nodes[4].useClippingRectangle(true);
            this.nodes[4].setClippingInheritance(1);
            this.nodes[4].setClipping(true);
            this.nodes[5].setClippingRectangle(28866, n3, n + 60, n4);
            this.nodes[5].useClippingRectangle(true);
            this.nodes[5].setClippingInheritance(1);
            this.nodes[5].setClipping(true);
            this.nodes[1].setClippingRectangle(0.0f, n3, n, n4);
            this.nodes[1].useClippingRectangle(true);
            this.nodes[1].setClippingInheritance(17);
            this.nodes[1].setClipping(true);
            this.nodes[2].setClippingRectangle(0.0f, n3, n, n4);
            this.nodes[2].useClippingRectangle(true);
            this.nodes[2].setClippingInheritance(1);
            this.nodes[2].setClipping(true);
            this.nodes[0].setClippingRectangle(0.0f, n3, n, n4);
            this.nodes[0].useClippingRectangle(true);
            this.nodes[0].setClippingInheritance(1);
            this.nodes[0].setClipping(true);
            this.nodes[3].setClippingRectangle(28866, n3, n + 60, n4);
            this.nodes[3].useClippingRectangle(true);
            this.nodes[3].setClippingInheritance(1);
            this.nodes[3].setClipping(true);
        }
        if (this.hasNowPlayingWidgets()) {
            this.nodes[9] = this.getEALManager().createNode3D(this.nodes[7], EALManager.createNodeName("MenuNowPlayingWidgets", this), n, n2);
        }
    }

    private void createUnclippedNodes(IWrappedNode3D iWrappedNode3D, int n, int n2) {
        this.nodes[6] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("MenuUnclippedNode", this), n, n2);
        this.nodes[11] = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("TouchUnclippedForegroundNode", this), n, n2);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2;
        super.applyProperties(redrawContextHigh);
        MenuController menuController = (MenuController)this.controller;
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        if (this.nodes[15] != null) {
            this.nodes[15].setPosition(menuController.getX(), menuController.getY(), 0.0f);
        }
        this.nodes[12].setPosition(menuController.getContentTransX(), menuController.getContentTransY(), 0.0f);
        this.nodes[12].setOpacity(menuController.getContentOpacity());
        int n = menuController.getClipOffsetTop();
        int n2 = this.controller.getHeight() - n + menuController.getClipOffsetBottom();
        this.nodes[1].setClippingRectangle(0.0f, n, this.controller.getWidth(), n2);
        this.nodes[2].setClippingRectangle(0.0f, n, this.controller.getWidth(), n2);
        this.nodes[0].setClippingRectangle(0.0f, n, this.controller.getWidth(), n2);
        this.nodes[3].setClippingRectangle(28866, n, this.controller.getWidth() + 60, n2);
        this.nodes[4].setClippingRectangle(28866, n, this.controller.getWidth() + 60, n2);
        this.nodes[5].setClippingRectangle(28866, n, this.controller.getWidth() + 60, n2);
        float f3 = this.getMenu().getViewSizeChangeContentOpacity();
        float f4 = this.getNowPlayingDecoratorOpacity();
        this.nodes[1].setOpacity(f3);
        this.nodes[2].setOpacity(f3);
        this.nodes[11].setOpacity(f3);
        this.nodes[3].setOpacity(f3 * f4);
        this.nodes[4].setOpacity(f3 * f4);
        this.nodes[5].setOpacity(f3 * f4);
        this.nodes[6].setOpacity(f4);
        if (this.nodes[9] != null) {
            f2 = this.getNowPlayingFadeInProgress();
            this.nodes[9].setVisible(f2 > 0.0f);
            this.nodes[9].setOpacity(f2);
        }
        if (this.nodes[10] != null) {
            f2 = this.getNowPlayingFadeInProgress();
            this.nodes[10].setVisible(f2 > 0.0f);
            this.nodes[10].setOpacity(f2);
        }
    }

    private float getNowPlayingDecoratorOpacity() {
        if (this.controller instanceof NowPlayingMenuController) {
            NowPlayingMenuController nowPlayingMenuController = (NowPlayingMenuController)this.controller;
            return nowPlayingMenuController.getNowPlayingFadeOutOpacity();
        }
        return 1.0f;
    }

    private float getNowPlayingFadeInProgress() {
        if (this.controller instanceof NowPlayingMenuController) {
            NowPlayingMenuController nowPlayingMenuController = (NowPlayingMenuController)this.controller;
            float f2 = nowPlayingMenuController.isNowPlayingAnimationRunning() ? nowPlayingMenuController.getNowPlayingAnimationProgress() : 1.0f;
            return nowPlayingMenuController.isNowPlayingActive() ? f2 : 1.0f - f2;
        }
        return 0.0f;
    }

    private boolean hasNowPlayingWidgets() {
        if (this.controller instanceof MenuController) {
            return !((MenuController)this.controller).getNowPlayingOnlyWidgets().isEmpty();
        }
        return false;
    }

    private boolean hasNowPlayingWidgetsClipped() {
        if (this.controller instanceof MenuController) {
            return !((MenuController)this.controller).getNowPlayingOnlyClippedWidgets().isEmpty();
        }
        return false;
    }

    private boolean hasGlassplate() {
        if (this.controller instanceof MenuController) {
            return ((MenuController)this.controller).getChildOfRole(4) instanceof GlassplateController;
        }
        return false;
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        MenuController menuController = (MenuController)this.controller;
        if (abstractWidget instanceof TouchController) {
            redrawContextHigh.parentNode = this.nodes[1];
            redrawContextHigh.parentNodeSecondary = this.nodes[11];
        } else if (abstractWidget instanceof MultilineTextFieldController) {
            redrawContextHigh.parentNode = this.nodes[1];
            redrawContextHigh.parentNodeSecondary = this.nodes[11];
        } else if (menuController.isMenuItem(abstractWidget)) {
            redrawContextHigh.parentNode = this.nodes[1];
            redrawContextHigh.parentNodeSecondary = this.nodes[2];
        } else if (abstractWidget == menuController.getChildOfRole(13)) {
            redrawContextHigh.parentNode = this.nodes[1];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget == menuController.getChildOfRole(1)) {
            redrawContextHigh.parentNode = this.nodes[3];
            redrawContextHigh.parentNodeSecondary = this.nodes[4];
        } else if (abstractWidget == menuController.getChildOfRole(2)) {
            redrawContextHigh.parentNode = this.nodes[5];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget == menuController.getChildOfRole(3)) {
            redrawContextHigh.parentNode = this.nodes[3];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget == menuController.getChildOfRole(6)) {
            redrawContextHigh.parentNode = this.nodes[6];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget == menuController.getChildOfRole(11)) {
            redrawContextHigh.parentNode = this.nodes[5];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget instanceof SeparatingLineController) {
            redrawContextHigh.parentNode = this.nodes[1];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (this.nodes[9] != null && menuController.getNowPlayingOnlyWidgets().contains(abstractWidget)) {
            redrawContextHigh.parentNode = this.nodes[9];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (this.nodes[10] != null && menuController.getNowPlayingOnlyClippedWidgets().contains(abstractWidget)) {
            redrawContextHigh.parentNode = this.nodes[10];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget == menuController.getChildOfRole(14)) {
            redrawContextHigh.parentNode = this.nodes[6];
            redrawContextHigh.parentNodeSecondary = null;
        } else if (abstractWidget == menuController.getChildOfRole(4)) {
            if (this.createdLayer && this.controller.isInvalid()) {
                this.menuLayer.setInvalid(true);
                abstractWidget.setCompositesDirty(true);
            }
            redrawContextHigh.parentNode = this.nodes[7];
            redrawContextHigh.parentNodeSecondary = this.nodes[13];
            redrawContextHigh.offscreenLayer = this.menuLayer;
        } else if (abstractWidget instanceof MenuItemController) {
            redrawContextHigh.parentNode = this.nodes[1];
            redrawContextHigh.parentNodeSecondary = this.nodes[2];
        } else {
            redrawContextHigh.parentNode = this.nodes[8];
            redrawContextHigh.parentNodeSecondary = this.nodes[0];
        }
    }

    private MenuController getMenu() {
        return (MenuController)this.controller;
    }

    @Override
    public void disconnect() {
        EALManager eALManager = this.getEALManager();
        for (int i2 = 0; i2 < this.nodes.length; ++i2) {
            if (this.nodes[i2] == null) continue;
            eALManager.destroy(this.nodes[i2]);
            this.nodes[i2] = null;
        }
        if (this.createdLayer) {
            eALManager.destroy(this.menuLayer);
        } else {
            eALManager.destroy(this.parentOfOffsetNode);
        }
        this.menuLayer = null;
        this.parentOfOffsetNode = null;
        this.createdLayer = false;
        super.disconnect();
    }

    @Override
    public void setKzbIDs(int[] nArray) {
    }
}

