/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractStatusBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class StatusbarControllerHigh
extends AbstractStatusBarController
implements IStatusbarGapEventHandler,
LayoutContainer {
    private int currentGapWidth = 450;
    private int maxGapWidth;
    private float gapHeight = 2.0f;
    private boolean entertainmentDrawerAvailable;

    protected void initializeWidget() {
        super.initializeWidget();
        this.entertainmentDrawerAvailable = !AbstractWidget.isScreenResolution400();
        this.calculateMaxGapWidth();
        this.terminal.getWidgetRegistry().setStatusbarGapEventHandler(this);
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        this.updateContent();
    }

    public int getCurrentGapWidth() {
        return this.currentGapWidth;
    }

    public int getMinGapWidth() {
        if (this.terminal != null && this.terminal.getWidgetRegistry() != null && this.terminal.getWidgetRegistry().getEntertainmentDrawerGapEventHandler() != null) {
            return ((EntertainmentDrawerOpenCloseController)this.terminal.getWidgetRegistry().getEntertainmentDrawerGapEventHandler()).getMinWidth();
        }
        return 0;
    }

    public boolean setGapWidth(int n, boolean bl) {
        if (!this.entertainmentDrawerAvailable) {
            return true;
        }
        this.currentGapWidth = n;
        return true;
    }

    private void calculateMaxGapWidth() {
        int n = Math.max(leftGroupMinWidth, rightGroupMinWidth);
        this.maxGapWidth = this.width - 2 * n;
    }

    public int getMaxGapWidth() {
        int n = Math.max(this.neededLeftGroupSpace, this.neededRightGroupSpace);
        this.maxGapWidth = this.width - 2 * n;
        return this.maxGapWidth;
    }

    public float getGapHeight() {
        return this.gapHeight;
    }

    public void setGapHeight(float f2) {
        if (this.entertainmentDrawerAvailable) {
            this.gapHeight = f2;
            this.setCompositesDirty(true);
        }
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public void setScaleFactor(float f2) {
    }

    protected LayoutContainerController getRightGroupContainer() {
        LayoutContainerController layoutContainerController = new LayoutContainerController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
        layoutContainerController.setRenderer(compositeRendererHigh);
        layoutContainerController.setBounds(this.getX(), this.getY() + yOffsetIcon, this.getWidth() - gapScreenBorder, 36);
        layoutContainerController.setHasDynamicLayout(true);
        return layoutContainerController;
    }

    protected LayoutContainerController getLeftGroupContainer() {
        LayoutContainerController layoutContainerController = new LayoutContainerController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
        layoutContainerController.setRenderer(compositeRendererHigh);
        layoutContainerController.setBounds(this.getX() + gapScreenBorder, this.getY() + yOffsetIcon, this.getWidth(), containerHeight);
        layoutContainerController.setHasDynamicLayout(true);
        return layoutContainerController;
    }

    protected boolean isViewSizeChanging() {
        return false;
    }
}

