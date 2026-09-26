/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface ICarViewerRenderer
extends IRenderer {
    public static final int DEFAULT;
    public static final int QQ1;
    public static final int QQ2;

    default public void setCarMenuIndex(int n) {
    }

    default public void setMode(int n) {
    }

    default public void setVisible(boolean bl) {
    }

    default public void setDriveSelectValues(int n, float f2, float f3, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void setDriveSelectDDBOpen(boolean bl) {
    }

    default public void setAmbientLightValues(float[] fArray, float[] fArray2, float[] fArray3) {
    }

    default public void setAmbientLightPackage(int n) {
    }

    default public void setViewSizeTargetChanged(int n, boolean bl) {
    }

    default public void setViewSizeAnimationFinished(int n) {
    }

    default public void setSmallStagePositionPercentage(float f2) {
    }

    default public void stopAnimations() {
    }

    default public void setDriveSelectPHEVValues(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    default public void setUGDOMode(int n) {
    }

    default public void updateSmallStageTranslationOffset(float f2) {
    }
}

