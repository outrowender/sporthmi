/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;

public interface ExtHMITerminalEvo
extends HMITerminalEvo {
    public IRendererFactory getRendererFactory();

    public IViewSizeManager getViewSizeManager();
}

