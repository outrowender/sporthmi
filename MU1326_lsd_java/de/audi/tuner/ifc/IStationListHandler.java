/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.listener.IUpdateListener;

public interface IStationListHandler {
    default public boolean tuneById(long l, int n) {
    }

    default public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    default public void setPrefImgType(int n) {
    }

    default public boolean isEnsemble(int n) {
    }

    default public void register(ISearchBreak iSearchBreak, int n) {
    }

    default public void register(IDrawerFocusManager iDrawerFocusManager) {
    }
}

