/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.listener.IUpdateListener;

public interface IStationListHandler {
    public boolean tuneById(long var1, int var3);

    public void addUpdateListener(IUpdateListener var1);

    public void setPrefImgType(int var1);

    public boolean isEnsemble(int var1);

    public void register(ISearchBreak var1, int var2);

    public void register(IDrawerFocusManager var1);
}

