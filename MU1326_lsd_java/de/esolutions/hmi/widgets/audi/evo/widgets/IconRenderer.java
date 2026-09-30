/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IconRenderer
extends IRenderer,
PreferredSize {
    public static final int SCALE_MODE_FIXED_FACTOR = 0;
    public static final int SCALE_MODE_AUTOSCALE_FIT = 1;
    public static final int SCALE_MODE_AUTOSCALE_FILL = 2;
    public static final int SCALE_MODE_AUTOSCALE_STRETCH = 3;
    public static final int AUTOSCALE_UP_AND_DOWN = 0;
    public static final int AUTOSCALE_ONLY_UP = 1;
    public static final int AUTOSCALE_ONLY_DOWN = 2;

    public String getDiagnosisText();

    public void setAlignment(int var1, int var2);

    public void setScaleFactor(float var1, float var2);

    public void setScaleMode(int var1);

    public void setAutoscaleModification(int var1);

    public void setRotationY(float var1);

    public void setRotationZ(float var1);
}

