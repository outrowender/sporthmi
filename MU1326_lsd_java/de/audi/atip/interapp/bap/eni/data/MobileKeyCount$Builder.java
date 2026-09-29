/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;

public final class MobileKeyCount$Builder {
    private int keyCountBackend;
    private int keyCountBackendState;
    private boolean vtanAvailable;

    public MobileKeyCount$Builder setKeyCountBackend(int n) {
        this.keyCountBackend = n;
        return this;
    }

    public MobileKeyCount$Builder setKeyCountBackendState(int n) {
        this.keyCountBackendState = n;
        return this;
    }

    public MobileKeyCount$Builder setVtanAvailable(boolean bl) {
        this.vtanAvailable = bl;
        return this;
    }

    public MobileKeyCount build() {
        return new MobileKeyCount(this.keyCountBackend, this.keyCountBackendState, this.vtanAvailable);
    }
}

