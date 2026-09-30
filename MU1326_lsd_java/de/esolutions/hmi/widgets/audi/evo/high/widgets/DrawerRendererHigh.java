/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerRenderer;

public class DrawerRendererHigh
extends ContainerRendererHigh
implements DrawerRenderer {
    public static final int OPTION_DRAWER = 0;
    public static final int SIDE_DRAWER = 0;
    public static final int ENTERTAINMENT_DRAWER = 1;
    private int renderLayer = 0;
    protected final DrawerController controller;

    public DrawerRendererHigh(DrawerController drawerController) {
        super(drawerController);
        this.controller = drawerController;
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        this.node = this.controller.isEntertainmentDrawerContent() ? this.getEALManager().createNode3D(super.getParentNode(redrawContextHigh), EALManager.createNodeName("entertainmentDrawerContent", this), 0.0f, redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth())) : this.getEALManager().createNode3D(this.getParentNode(), EALManager.createNodeName("drawer", this), 0.0f, redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
    }

    protected IWrappedNode3D getParentNode() {
        switch (this.renderLayer) {
            case 0: {
                return this.getEALManager().getOptionDrawerNode();
            }
            case 1: {
                return this.getEALManager().getEntertainmentDrawerNode();
            }
        }
        logDrawer.log(100000, "DrawerRendererHigh#getParentNode: unknown render layer: %1", (long)this.renderLayer);
        return this.getEALManager().getOptionDrawerNode();
    }

    public int getRenderLayer() {
        return this.renderLayer;
    }

    public void setRenderLayer(int n) {
        this.renderLayer = n;
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (abstractWidget instanceof ContainerController) {
            ContainerController containerController = (ContainerController)abstractWidget;
            int n = containerController.getScreenLayer();
            if (n == 5) {
                redrawContextHigh.parentNode = this.getEALManager().getOptionDrawerClosedLayer().getNode();
                return;
            }
            if (n == 4) {
                redrawContextHigh.parentNode = this.getEALManager().getSelectionDrawerClosedLayer().getNode();
                return;
            }
        }
        super.prepareRedrawContextForChildren(redrawContextHigh, abstractWidget);
    }
}

