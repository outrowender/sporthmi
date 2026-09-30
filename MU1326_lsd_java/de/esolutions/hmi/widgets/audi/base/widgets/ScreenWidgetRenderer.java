/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface ScreenWidgetRenderer
extends IRenderer {
    public void handlePaintError(Exception var1);

    public RedrawContext createRedrawContextRoot();

    public void invalidateViewPort();
}

