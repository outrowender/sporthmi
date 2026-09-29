/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.tuner.ifc.listener.IUpdateListener;

public interface ISearchGUI {
    default public int[] getSources() {
    }

    default public int getMaxColumns() {
    }

    default public IUpdateListener getUpdateListener() {
    }

    default public void frequencySearchEnded(int n) {
    }

    default public void runCommands() {
    }
}

