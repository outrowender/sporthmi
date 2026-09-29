/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IFingerTraceRenderer
extends IRenderer {
    default public void startLine(int n, int n2) {
    }

    default public void addPoint(int n, int n2) {
    }

    default public void clearLine() {
    }

    default public void showFingerTrace(float f2) {
    }

    default public void removeFingerTrace() {
    }

    default public boolean isFingerTraceVisible() {
    }

    default public void viewSizeChanged() {
    }

    default public void onviewSizeChanging() {
    }
}

