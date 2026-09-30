/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import java.util.List;

public interface IWidgetDiagnosis {
    public String getClassName();

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public int getDepth();

    public String getDiagnosisText();

    public String getInternalInfo();

    public int[] getBitmapIndices();

    public int[] getColorIndices();

    public List getDiagnosisChildren();

    public boolean isEnabled();

    public boolean isActive();

    public boolean isHighlighted();

    public boolean isVisible();

    public boolean isFocused();

    public boolean isFunctional();

    public int getModelID();
}

