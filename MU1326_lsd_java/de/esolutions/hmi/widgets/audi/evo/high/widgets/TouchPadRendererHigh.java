/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchPadRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.TouchPadController;

public class TouchPadRendererHigh
extends AbstractRendererHigh
implements ITouchPadRenderer,
IKanziTemplateRenderer {
    private final TouchPadController controller;

    public TouchPadRendererHigh(TouchPadController touchPadController) {
        this.controller = touchPadController;
    }

    public void showFingerTrace(float f2) {
    }

    public void startLine(int n, int n2) {
    }

    public void addPoint(int n, int n2) {
    }

    public void clearLine() {
    }

    public void removeFingerTrace() {
    }

    public void setKzbIDs(int[] nArray) {
    }

    protected String getTemplateNodePath() {
        return "Prefabs/fingerTrace_plate";
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public boolean isFingerTraceVisible() {
        return false;
    }

    public void render(RedrawContext redrawContext) {
    }

    public void onviewSizeChanging() {
    }

    public void viewSizeChanged() {
    }
}

