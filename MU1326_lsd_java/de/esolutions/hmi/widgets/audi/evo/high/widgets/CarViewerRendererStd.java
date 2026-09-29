/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CarViewerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICarViewerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class CarViewerRendererStd
extends AbstractRendererHigh
implements ICarViewerRenderer {
    private final CarViewerController controller;
    private int mode;

    public CarViewerRendererStd(CarViewerController carViewerController) {
        this.controller = carViewerController;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.controller.shouldRender()) {
            this.setVisible(false);
            return;
        }
        this.applyProperties();
    }

    protected void applyProperties() {
        IconController iconController = this.controller.getVariantController();
        if (iconController != null && this.mode != 1) {
            iconController.setOpacity(this.controller.getOpacity());
        }
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void setVisible(boolean bl) {
    }

    @Override
    public void setCarMenuIndex(int n) {
        IconController iconController = this.controller.getVariantController();
        if (iconController != null) {
            iconController.setValue(n);
            return;
        }
        logChannel3DCar.log(-2137614336, "CarViewerRendererStd#setCarMenuIndex no variant specific icon controller defined, no change in displayed picture.");
    }

    @Override
    public void setMode(int n) {
        this.mode = n;
    }

    @Override
    public void setDriveSelectValues(int n, float f2, float f3, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, boolean bl2, boolean bl3) {
    }

    @Override
    public void setDriveSelectDDBOpen(boolean bl) {
    }

    @Override
    public void setAmbientLightValues(float[] fArray, float[] fArray2, float[] fArray3) {
    }

    @Override
    public void setAmbientLightPackage(int n) {
    }

    @Override
    public void setSmallStagePositionPercentage(float f2) {
    }

    @Override
    public void setViewSizeTargetChanged(int n, boolean bl) {
    }

    @Override
    public void setViewSizeAnimationFinished(int n) {
    }

    @Override
    public void stopAnimations() {
    }

    @Override
    public void setDriveSelectPHEVValues(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    @Override
    public void setUGDOMode(int n) {
    }

    @Override
    public void updateSmallStageTranslationOffset(float f2) {
    }
}

