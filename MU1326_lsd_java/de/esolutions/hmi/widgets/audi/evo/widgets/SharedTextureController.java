/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISharedTextureRenderer;

public class SharedTextureController
extends AbstractWidgetController {
    public static final int UPDATE_MODE_ONCE = 0;
    public static final int UPDATE_MODE_MANUAL = 1;
    public static final int UPDATE_MODE_CONTINUOUS = 2;
    private ISharedTextureRenderer renderer;
    private int displayableID = -1;
    private int updateMode = 0;
    private int updateInterval = 0;
    private int[] captureRect;
    private boolean r8distinction = false;

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ISharedTextureRenderer iSharedTextureRenderer) {
        this.renderer = iSharedTextureRenderer;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.checkForR8Hack();
    }

    private void checkForR8Hack() {
        if (this.r8distinction && this.terminal != null && this.terminal.getCarCodingHelper() != null && this.terminal.getCarCodingHelper().isR8() && this.hasBitmap(1)) {
            this.bitmapIndices[0] = this.bitmapIndices[1];
        }
    }

    public void setDisplayableID(int n) {
        logWidgetSharedTexture.log(10000000, "SharedTextureController#setDisplayableID %1", (long)n);
        this.displayableID = n;
        this.setCompositesDirty(true);
        this.renderer.updateSharedTexture();
        this.checkVisibility();
    }

    private void checkVisibility() {
        if (this.getParent() instanceof ContainerController) {
            ((ContainerController)this.parent).handleSharedTextureController();
        }
    }

    public int getDisplayableID() {
        return this.displayableID;
    }

    public void setUpdateMode(int n) {
        this.updateMode = n;
    }

    public int getUpdateMode() {
        return this.updateMode;
    }

    public void setUpdateInterval(int n) {
        this.updateInterval = n;
    }

    public int getUpdateInterval() {
        return this.updateInterval;
    }

    private void updateRendererVisibility() {
        if (this.renderer != null) {
            this.renderer.setVisible(this.shouldRender());
        }
    }

    public void setVisible(boolean bl) {
        if (this.isVisible() != bl) {
            super.setVisible(bl);
            this.updateRendererVisibility();
        }
    }

    public void setOnScreen(boolean bl) {
        if (this.isOnScreen() != bl) {
            super.setOnScreen(bl);
            this.updateRendererVisibility();
        }
    }

    public void setR8Distinction(boolean bl) {
        this.r8distinction = bl;
    }

    public void setVisibleOnCurrentStage(boolean bl) {
        if (this.isVisibleOnCurrentStage() != bl) {
            super.setVisibleOnCurrentStage(bl);
            this.updateRendererVisibility();
        }
    }

    public void setHMIBackgroundOpaque(boolean bl) {
        this.renderer.setHMIBackgroundOpaque(bl);
    }

    public void setCaptureRect(int n, int n2, int n3, int n4) {
        if (this.captureRect == null) {
            this.captureRect = new int[4];
        }
        this.captureRect[0] = n;
        this.captureRect[1] = n2;
        this.captureRect[2] = n3;
        this.captureRect[3] = n4;
    }

    public int[] getCaptureRect() {
        return this.captureRect;
    }

    public boolean useCaptureRect() {
        return this.captureRect != null;
    }
}

