/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.ScreenWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;

public class CombiMapScreenRenderer
implements ScreenWidgetRenderer {
    public void connect(InitializationContext initializationContext) {
    }

    public void disconnect() {
    }

    public void render(RedrawContext redrawContext) {
    }

    public InitializationContext createInitContextForChildren(InitializationContext initializationContext) {
        return initializationContext;
    }

    public RedrawContext createRedrawContext(RedrawContext redrawContext) {
        return null;
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
    }

    public void setCompositesDirty(boolean bl) {
    }

    public void setCompositeDirty(int n) {
    }

    public void updateInheritedFonts() {
    }

    public void handlePaintError(Exception exception) {
    }

    public RedrawContext createRedrawContextRoot() {
        return new RedrawContextHigh();
    }

    public boolean areCompositesDirty() {
        return false;
    }

    public void restoreRedrawContext(RedrawContext redrawContext) {
    }

    public void invalidateViewPort() {
    }
}

