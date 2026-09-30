/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface ISharedTextureRenderer
extends IRenderer {
    public void setVisible(boolean var1);

    public void setHMIBackgroundOpaque(boolean var1);

    public void updateSharedTexture();
}

