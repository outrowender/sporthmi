/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices.data;

import de.audi.atip.interapp.bap.remoteservices.data.VTANData;

public final class VTANData$Builder {
    private String vTAN;
    private String userName;

    public VTANData$Builder setVTAN(String string) {
        this.vTAN = string;
        return this;
    }

    public VTANData$Builder setUserName(String string) {
        this.userName = string;
        return this;
    }

    public VTANData build() {
        return new VTANData(this.vTAN, this.userName);
    }
}

