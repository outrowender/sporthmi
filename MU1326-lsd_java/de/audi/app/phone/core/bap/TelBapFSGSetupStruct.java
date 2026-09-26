/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.esolutions.fw.util.commons.Buffer;

public class TelBapFSGSetupStruct {
    final boolean internalSimcardReaderAvailable;
    final boolean cableConnectionToMobilePossible;
    final boolean hfpConnectionToMobilePossible;
    final boolean rsapConnectionToMobilePossible;
    final int mobileConnectionType;

    public TelBapFSGSetupStruct(boolean bl, boolean bl2, boolean bl3, boolean bl4, int n) {
        this.internalSimcardReaderAvailable = bl;
        this.cableConnectionToMobilePossible = bl2;
        this.hfpConnectionToMobilePossible = bl3;
        this.rsapConnectionToMobilePossible = bl4;
        this.mobileConnectionType = n;
    }

    public boolean isInternalSimcardReaderAvailable() {
        return this.internalSimcardReaderAvailable;
    }

    public boolean isCableConnectionToMobilePossible() {
        return this.cableConnectionToMobilePossible;
    }

    public boolean isHfpConnectionToMobilePossible() {
        return this.hfpConnectionToMobilePossible;
    }

    public boolean isRsapConnectionToMobilePossible() {
        return this.rsapConnectionToMobilePossible;
    }

    public int getMobileConnectionType() {
        return this.mobileConnectionType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelBapFSGSetupStruct(");
        buffer.append("internalSimcardReaderAvailable=");
        buffer.append(this.internalSimcardReaderAvailable);
        buffer.append(", ");
        buffer.append("cableConnectionToMobilePossible=");
        buffer.append(this.cableConnectionToMobilePossible);
        buffer.append(", ");
        buffer.append("hfpConnectionToMobilePossible=");
        buffer.append(this.hfpConnectionToMobilePossible);
        buffer.append(", ");
        buffer.append("rsapConnectionToMobilePossible=");
        buffer.append(this.rsapConnectionToMobilePossible);
        buffer.append(", ");
        buffer.append("mobileConnectionType=");
        buffer.append(this.mobileConnectionType);
        buffer.append(")");
        return buffer.toString();
    }

    public int hashCode() {
        int n = this.internalSimcardReaderAvailable ? 1 : 0;
        int n2 = this.cableConnectionToMobilePossible ? 1 : 0;
        int n3 = this.hfpConnectionToMobilePossible ? 1 : 0;
        int n4 = this.rsapConnectionToMobilePossible ? 1 : 0;
        int n5 = 1;
        n5 = 31 * (n5 + n + n2 + n3 + n4 + this.mobileConnectionType);
        return n5;
    }

    public boolean equals(Object object) {
        if (object instanceof TelBapFSGSetupStruct) {
            TelBapFSGSetupStruct telBapFSGSetupStruct = (TelBapFSGSetupStruct)object;
            return telBapFSGSetupStruct.internalSimcardReaderAvailable == this.internalSimcardReaderAvailable && telBapFSGSetupStruct.cableConnectionToMobilePossible == this.cableConnectionToMobilePossible && telBapFSGSetupStruct.hfpConnectionToMobilePossible == this.hfpConnectionToMobilePossible && telBapFSGSetupStruct.rsapConnectionToMobilePossible == this.rsapConnectionToMobilePossible && telBapFSGSetupStruct.mobileConnectionType == this.mobileConnectionType;
        }
        return false;
    }
}

