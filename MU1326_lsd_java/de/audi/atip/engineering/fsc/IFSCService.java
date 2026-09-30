/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.engineering.fsc;

import de.audi.atip.engineering.fsc.IFSCServiceListener;

public interface IFSCService {
    public void startFSCImport(int var1);

    public void setFscServiceListener(IFSCServiceListener var1);

    public void removeListener();
}

