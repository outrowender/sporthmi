/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface ITouchRenderer
extends IRenderer {
    public static final int COMPOSITE_BLINK_CURSOR = 0;
    public static final int COMPOSITE_TOUCH_INDICATOR_ICON = 1;

    public int getTextureHeight(int var1);
}

