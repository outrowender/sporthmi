/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;

public interface IRootWindowEvo
extends IRootWindow {
    public IDrawerFocusManagerEvo getDrawerFocusManager();

    public void setDrawerFocusManager(IDrawerFocusManagerEvo var1);

    public void setViewSizeManager(IViewSizeManager var1);

    public IViewSizeManager getViewSizeManager();

    public void postRepaintEvent();
}

