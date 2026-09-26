/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;

public interface ITerminalContextEvo
extends ITerminalContext {
    default public IDrawerControllerEvo[] getSelectionDrawers(int n) {
    }

    default public IDrawerControllerEvo[] getOptionDrawers(int n) {
    }

    default public Object getKanziResource(String string, Object object, int n, int n2) {
    }

    default public void notifyScreenFadedOut(int n, int n2) {
    }

    default public void notifyScreenConnected(int n, int n2) {
    }

    default public Screen getPartialPopup(int n, int n2) {
    }
}

