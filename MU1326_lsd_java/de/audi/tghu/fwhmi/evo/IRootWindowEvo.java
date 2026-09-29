/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;

public interface IRootWindowEvo
extends IRootWindow {
    default public IDrawerFocusManagerEvo getDrawerFocusManager() {
    }

    default public void setDrawerFocusManager(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
    }

    default public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
    }

    default public IViewSizeManager getViewSizeManager() {
    }

    default public void postRepaintEvent() {
    }
}

