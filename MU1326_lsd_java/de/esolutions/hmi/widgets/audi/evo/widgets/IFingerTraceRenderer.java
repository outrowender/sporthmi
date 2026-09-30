/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IFingerTraceRenderer
extends IRenderer {
    public void startLine(int var1, int var2);

    public void addPoint(int var1, int var2);

    public void clearLine();

    public void showFingerTrace(float var1);

    public void removeFingerTrace();

    public boolean isFingerTraceVisible();

    public void viewSizeChanged();

    public void onviewSizeChanging();
}

