/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices.data;

import de.audi.atip.interapp.bap.remoteservices.data.VTANData$Builder;

public final class VTANData {
    private String vTAN;
    private String userName;

    public static VTANData$Builder builder() {
        return new VTANData$Builder();
    }

    private VTANData(String string, String string2) {
        this.vTAN = string;
        this.userName = string2;
    }

    public String getVTAN() {
        return this.vTAN;
    }

    public String getUserName() {
        return this.userName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANData [");
        stringBuffer.append("userName=").append(this.getUserName());
        stringBuffer.append(", vTAN=").append(this.getVTAN());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

