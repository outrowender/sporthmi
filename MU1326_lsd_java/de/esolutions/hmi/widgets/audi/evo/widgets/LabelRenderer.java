/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface LabelRenderer
extends IRenderer,
PreferredSize {
    default public String calculateDisplayData(String string, boolean bl) {
    }

    default public int getNumberOfRows(int n) {
    }

    default public String getText() {
    }

    default public void setAlignment(int n, int n2) {
    }

    default public void setFirstVisibleLine(int n) {
    }

    default public int getPreferredLineHeight() {
    }

    default public int getFontHeight() {
    }

    default public int getBaseline() {
    }

    default public boolean hasContent() {
    }

    default public boolean isTextDescriptorSupported() {
    }

    default public void setAutoWrap(int n) {
    }

    default public void setLineHeight(int n) {
    }

    default public int getLineHeight() {
    }
}

