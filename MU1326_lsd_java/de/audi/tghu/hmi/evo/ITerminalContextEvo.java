/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;

public interface ITerminalContextEvo
extends ITerminalContext {
    public IDrawerControllerEvo[] getSelectionDrawers(int var1);

    public IDrawerControllerEvo[] getOptionDrawers(int var1);

    public Object getKanziResource(String var1, Object var2, int var3, int var4);

    public void notifyScreenFadedOut(int var1, int var2);

    public void notifyScreenConnected(int var1, int var2);

    public Screen getPartialPopup(int var1, int var2);
}

