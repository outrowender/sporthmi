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
    public boolean isMinStrokeReached();

    public boolean exceededMinStrokeLength();

    public void writingModeEntered();

    public float getPeepholeTransparency();

    public void hideFingerTrace();

    public void characterRecognized(char var1);

    public boolean isLineVisible();

    public void setRenderer(IFingerTraceRenderer var1);

    public IRenderer getRenderer();

    public void registerFTListener(FingerTraceListener var1);

    public AbstractWidget toAbstractWidget();

    public void setMaxOpacity(float var1);
}

