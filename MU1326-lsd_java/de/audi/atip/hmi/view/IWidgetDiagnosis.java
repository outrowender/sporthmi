/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import java.util.List;

public interface IWidgetDiagnosis {
    default public String getClassName() {
    }

    default public int getX() {
    }

    default public int getY() {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public int getDepth() {
    }

    default public String getDiagnosisText() {
    }

    default public String getInternalInfo() {
    }

    default public int[] getBitmapIndices() {
    }

    default public int[] getColorIndices() {
    }

    default public List getDiagnosisChildren() {
    }

    default public boolean isEnabled() {
    }

    default public boolean isActive() {
    }

    default public boolean isHighlighted() {
    }

    default public boolean isVisible() {
    }

    default public boolean isFocused() {
    }

    default public boolean isFunctional() {
    }

    default public int getModelID() {
    }
}

