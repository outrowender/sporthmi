/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfolineController;

public interface IInfoLineRenderer
extends IRenderer {
    public int getPreferredHeight(int var1);

    public void setController(InfolineController var1);

    public void setFonts(Object[] var1);

    public int getAutoWrap();

    public void setAutoWrap(int var1);
}

