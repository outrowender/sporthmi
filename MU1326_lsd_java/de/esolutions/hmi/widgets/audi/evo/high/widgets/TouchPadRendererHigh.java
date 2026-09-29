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

    @Override
    public void showFingerTrace(float f2) {
    }

    @Override
    public void startLine(int n, int n2) {
    }

    @Override
    public void addPoint(int n, int n2) {
    }

    @Override
    public void clearLine() {
    }

    @Override
    public void removeFingerTrace() {
    }

    @Override
    public void setKzbIDs(int[] nArray) {
    }

    protected String getTemplateNodePath() {
        return "Prefabs/fingerTrace_plate";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public boolean isFingerTraceVisible() {
        return false;
    }

    @Override
    public void render(RedrawContext redrawContext) {
    }

    @Override
    public void onviewSizeChanging() {
    }

    @Override
    public void viewSizeChanged() {
    }
}

