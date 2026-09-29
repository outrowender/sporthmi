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
    @Override
    public void connect(InitializationContext initializationContext) {
    }

    @Override
    public void disconnect() {
    }

    @Override
    public void render(RedrawContext redrawContext) {
    }

    @Override
    public InitializationContext createInitContextForChildren(InitializationContext initializationContext) {
        return initializationContext;
    }

    @Override
    public RedrawContext createRedrawContext(RedrawContext redrawContext) {
        return null;
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
    }

    @Override
    public void setCompositesDirty(boolean bl) {
    }

    @Override
    public void setCompositeDirty(int n) {
    }

    @Override
    public void updateInheritedFonts() {
    }

    @Override
    public void handlePaintError(Exception exception) {
    }

    @Override
    public RedrawContext createRedrawContextRoot() {
        return new RedrawContextHigh();
    }

    @Override
    public boolean areCompositesDirty() {
        return false;
    }

    @Override
    public void restoreRedrawContext(RedrawContext redrawContext) {
    }

    @Override
    public void invalidateViewPort() {
    }
}

