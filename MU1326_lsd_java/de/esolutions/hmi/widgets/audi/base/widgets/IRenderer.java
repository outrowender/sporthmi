/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;

public interface IRenderer {
    public void connect(InitializationContext var1);

    public void disconnect();

    public void render(RedrawContext var1);

    public InitializationContext createInitContextForChildren(InitializationContext var1);

    public RedrawContext createRedrawContext(RedrawContext var1);

    public void restoreRedrawContext(RedrawContext var1);

    public void prepareRedrawContextForChildren(RedrawContext var1, AbstractWidget var2);

    public void setCompositesDirty(boolean var1);

    public void setCompositeDirty(int var1);

    public boolean areCompositesDirty();

    public void updateInheritedFonts();
}

