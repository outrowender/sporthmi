/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;

public class ContainerRendererHigh
extends CompositeRendererHigh
implements ContainerRenderer {
    public ContainerRendererHigh(ContainerController containerController) {
        super(containerController);
    }

    private ContainerController getContainerController() {
        return (ContainerController)this.controller;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        ContainerController containerController = this.getContainerController();
        float f2 = (float)containerController.getX() + containerController.getTransX();
        float f3 = (float)containerController.getY() + containerController.getTransY();
        this.node.setOpacity(containerController.getOpacity());
        float f4 = containerController.getScaling();
        if (this.controller instanceof EntertainmentDrawerOpenCloseController) {
            EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = (EntertainmentDrawerOpenCloseController)this.controller;
            float f5 = this.getTerminal().getLayout().getDistance(2);
            if (f5 > 0.0f && f3 > f5 && !entertainmentDrawerOpenCloseController.isHeaderVisible()) {
                f3 = this.node.getY();
            }
            this.node.setPosition(f2, f3, 0.0f);
            this.node.setScale(f4, f4, 1.0f);
        } else {
            this.node.setPosition(f2, f3, 0.0f);
            this.node.setScale(f4, f4, 1.0f);
        }
        this.node.setVisible(this.shouldRenderVisible());
    }

    protected boolean shouldRenderVisible() {
        return super.shouldRenderVisible() && this.getContainerController().getMMICombiSyncMode() != 2;
    }

    public void setScreenChangeProgress(float f2) {
        if (this.node != null) {
            if (this.node.isValid()) {
                this.applyProperties(null);
            } else {
                logChannel3DEngine.log(10000, "ContainerRendererHigh#node is not valid");
            }
        }
    }

    public void setVisibleDirect(boolean bl) {
        if (this.node == null) {
            return;
        }
        this.node.setVisible(bl);
    }
}

