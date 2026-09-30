/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.tuner.ifc.listener.IUpdateListener;

public interface ISearchGUI {
    public int[] getSources();

    public int getMaxColumns();

    public IUpdateListener getUpdateListener();

    public void frequencySearchEnded(int var1);

    public void runCommands();
}

