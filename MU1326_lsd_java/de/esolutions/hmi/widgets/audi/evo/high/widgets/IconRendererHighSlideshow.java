/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHighAsync;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconCrossFadeController;

public class IconRendererHighSlideshow
extends IconRendererHighAsync {
    protected int lastControllerWidth;
    protected float lastNodePosition;

    public IconRendererHighSlideshow(IconController iconController) {
        super(iconController);
        this.lastControllerWidth = iconController.getWidth();
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        super.renderNode(redrawContextHigh);
        if (this.node != null) {
            this.lastNodePosition = this.node.getX() + redrawContextHigh.parentNode.getX();
        }
    }

    protected void calculatePosition(float[] fArray, RedrawContextHigh redrawContextHigh) {
        float f2 = IconRendererHighSlideshow.calculateNodeOffset(this.controller.getWidth(), this.node.getUnscaledWidth() * fArray[0], this.alignmentHoriz);
        float f3 = IconRendererHighSlideshow.calculateNodeOffset(this.controller.getHeight(), this.node.getUnscaledHeight() * fArray[1], this.alignmentVert);
        float f4 = (float)this.controller.getX() + this.x0 + f2;
        float f5 = (float)this.controller.getY() + this.y0 + f3;
        if (Math.abs((int)(redrawContextHigh.parentNode.getX() + f4 - this.lastNodePosition)) < 2) {
            this.node.setPosition(this.lastNodePosition - redrawContextHigh.parentNode.getX(), f5, 0.0f);
        } else {
            this.lastNodePosition = this.node.getX() + redrawContextHigh.parentNode.getX();
            this.node.setPosition(f4, f5, 0.0f);
        }
        this.lastNodePosition = this.node.getX() + redrawContextHigh.parentNode.getX();
    }

    public void resourceLoadedCallback(int n, Object object, ATIPEvent aTIPEvent) {
        super.resourceLoadedCallback(n, object, aTIPEvent);
        AbstractWidget abstractWidget = this.controller.getParent();
        if (abstractWidget instanceof IconCrossFadeController) {
            ((IconCrossFadeController)abstractWidget).startCrossFadingAnimation();
        }
    }
}

