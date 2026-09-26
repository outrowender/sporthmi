/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.TouchPadEventListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;

public interface IFingerTraceWidget
extends TouchPadEventListener {
    default public boolean isMinStrokeReached() {
    }

    default public boolean exceededMinStrokeLength() {
    }

    default public void writingModeEntered() {
    }

    default public float getPeepholeTransparency() {
    }

    default public void hideFingerTrace() {
    }

    default public void characterRecognized(char c2) {
    }

    default public boolean isLineVisible() {
    }

    default public void setRenderer(IFingerTraceRenderer iFingerTraceRenderer) {
    }

    default public IRenderer getRenderer() {
    }

    default public void registerFTListener(FingerTraceListener fingerTraceListener) {
    }

    default public AbstractWidget toAbstractWidget() {
    }

    default public void setMaxOpacity(float f2) {
    }
}

