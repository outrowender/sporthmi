/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public interface IViewSizeAnimatable {
    public void setViewSizeAnimation(float var1, float[] var2, float[] var3, boolean var4);

    public void setViewSizeAnimationFinished(float[] var1, boolean var2);

    public void viewSizeTargetChanged(float[] var1, float[] var2, boolean var3);

    public void viewSizeAnimationStarted(float var1, float[] var2, float[] var3);
}

