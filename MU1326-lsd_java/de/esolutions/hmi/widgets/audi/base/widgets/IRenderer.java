/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;

public interface IRenderer {
    default public void connect(InitializationContext initializationContext) {
    }

    default public void disconnect() {
    }

    default public void render(RedrawContext redrawContext) {
    }

    default public InitializationContext createInitContextForChildren(InitializationContext initializationContext) {
    }

    default public RedrawContext createRedrawContext(RedrawContext redrawContext) {
    }

    default public void restoreRedrawContext(RedrawContext redrawContext) {
    }

    default public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
    }

    default public void setCompositesDirty(boolean bl) {
    }

    default public void setCompositeDirty(int n) {
    }

    default public boolean areCompositesDirty() {
    }

    default public void updateInheritedFonts() {
    }
}

