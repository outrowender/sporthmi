/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface ICarViewerRenderer
extends IRenderer {
    public static final int DEFAULT = 0;
    public static final int QQ1 = 1;
    public static final int QQ2 = 2;

    public void setCarMenuIndex(int var1);

    public void setMode(int var1);

    public void setVisible(boolean var1);

    public void setDriveSelectValues(int var1, float var2, float var3, int var4, int var5, int var6, int var7, int var8, int var9, boolean var10, boolean var11, boolean var12);

    public void setDriveSelectDDBOpen(boolean var1);

    public void setAmbientLightValues(float[] var1, float[] var2, float[] var3);

    public void setAmbientLightPackage(int var1);

    public void setViewSizeTargetChanged(int var1, boolean var2);

    public void setViewSizeAnimationFinished(int var1);

    public void setSmallStagePositionPercentage(float var1);

    public void stopAnimations();

    public void setDriveSelectPHEVValues(int var1, int var2, int var3, int var4, int var5, int var6, int var7);

    public void setUGDOMode(int var1);

    public void updateSmallStageTranslationOffset(float var1);
}

