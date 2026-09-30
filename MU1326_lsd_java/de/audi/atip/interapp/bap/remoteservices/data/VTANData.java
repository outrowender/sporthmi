/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices.data;

public final class VTANData {
    private String vTAN;
    private String userName;

    public static Builder builder() {
        return new Builder();
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

    public static final class Builder {
        private String vTAN;
        private String userName;

        public Builder setVTAN(String string) {
            this.vTAN = string;
            return this;
        }

        public Builder setUserName(String string) {
            this.userName = string;
            return this;
        }

        public VTANData build() {
            return new VTANData(this.vTAN, this.userName);
        }
    }
}

