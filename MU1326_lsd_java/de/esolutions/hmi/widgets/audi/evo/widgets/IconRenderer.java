/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IconRenderer
extends IRenderer,
PreferredSize {
    public static final int SCALE_MODE_FIXED_FACTOR;
    public static final int SCALE_MODE_AUTOSCALE_FIT;
    public static final int SCALE_MODE_AUTOSCALE_FILL;
    public static final int SCALE_MODE_AUTOSCALE_STRETCH;
    public static final int AUTOSCALE_UP_AND_DOWN;
    public static final int AUTOSCALE_ONLY_UP;
    public static final int AUTOSCALE_ONLY_DOWN;

    default public String getDiagnosisText() {
    }

    default public void setAlignment(int n, int n2) {
    }

    default public void setScaleFactor(float f2, float f3) {
    }

    default public void setScaleMode(int n) {
    }

    default public void setAutoscaleModification(int n) {
    }

    default public void setRotationY(float f2) {
    }

    default public void setRotationZ(float f2) {
    }
}

