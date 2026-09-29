/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.engineering.fsc;

import de.audi.atip.engineering.fsc.IFSCServiceListener;

public interface IFSCService {
    default public void startFSCImport(int n) {
    }

    default public void setFscServiceListener(IFSCServiceListener iFSCServiceListener) {
    }

    default public void removeListener() {
    }
}

