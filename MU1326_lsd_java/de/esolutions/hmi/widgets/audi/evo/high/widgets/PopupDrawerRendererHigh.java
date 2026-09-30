/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.List;

public class PopupDrawerRendererHigh
extends ContainerRendererHigh {
    public PopupDrawerRendererHigh(ContainerController containerController) {
        super(containerController);
    }

    protected IWrappedNode3D getParentNode(RedrawContextHigh redrawContextHigh) {
        return this.getEALManager().getOptionDrawerNode();
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        ContainerController containerController = this.getContainerController();
        float f2 = (float)containerController.getX() + containerController.getTransX();
        float f3 = (float)containerController.getY() + containerController.getTransY();
        this.node.setOpacity(containerController.getOpacity());
        float f4 = containerController.getScaling();
        if (!this.getTerminal().getFramework().getLanguageMgr().isLeftToRightOrientation()) {
            int n = this.node.getScreenWidth();
            AbstractWidget abstractWidget = this.getMenu();
            f2 = abstractWidget == null ? (float)n - f2 - (float)this.controller.getWidth() : (float)n - f2 - (float)abstractWidget.getX() - (float)abstractWidget.getWidth();
        }
        this.node.setPosition(f2, f3, 0.0f);
        this.node.setScale(f4, f4, 1.0f);
        this.node.setVisible(this.shouldRenderVisible());
    }

    private AbstractWidget getMenu() {
        List list = this.controller.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Object object = list.get(i2);
            if (!(object instanceof MenuController)) continue;
            return (AbstractWidget)object;
        }
        return null;
    }

    private ContainerController getContainerController() {
        return (ContainerController)this.controller;
    }
}

