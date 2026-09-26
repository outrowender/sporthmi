/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.MobileKeyCount$Builder;

public final class MobileKeyCount {
    private int keyCountBackend;
    private int keyCountBackendState;
    private boolean vtanAvailable;

    public static MobileKeyCount$Builder builder() {
        return new MobileKeyCount$Builder();
    }

    private MobileKeyCount(int n, int n2, boolean bl) {
        this.keyCountBackend = n;
        this.keyCountBackendState = n2;
        this.vtanAvailable = bl;
    }

    public int getKeyCountBackend() {
        return this.keyCountBackend;
    }

    public int getKeyCountBackendState() {
        return this.keyCountBackendState;
    }

    public boolean isVtanAvailable() {
        return this.vtanAvailable;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobileKeyCount [");
        stringBuffer.append("keyCountBackend=").append(this.getKeyCountBackend());
        stringBuffer.append(", keyCountBackendState=").append(this.getKeyCountBackendState());
        stringBuffer.append(", vtanAvailable=").append(this.isVtanAvailable());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

