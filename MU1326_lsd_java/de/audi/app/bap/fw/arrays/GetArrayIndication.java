/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.esolutions.fw.util.commons.Buffer;

public class GetArrayIndication {
    private final int asgID;
    private final int taID;
    private final IArrayHeader arrayHeader;

    public GetArrayIndication(int n, int n2, IArrayHeader iArrayHeader) {
        this.asgID = n;
        this.taID = n2;
        this.arrayHeader = iArrayHeader;
    }

    public int getAsgID() {
        return this.asgID;
    }

    public int getTaID() {
        return this.taID;
    }

    public IArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("GetArrayIndication: ASGID=");
        buffer.append(this.asgID);
        buffer.append(", TAID=");
        buffer.append(this.taID);
        buffer.append(", ArrayHeader=");
        buffer.append(this.arrayHeader.toString());
        return buffer.toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.arrayHeader == null ? 0 : ((Object)this.arrayHeader).hashCode());
        n = 31 * n + this.asgID;
        n = 31 * n + this.taID;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        GetArrayIndication getArrayIndication = (GetArrayIndication)object;
        if (this.arrayHeader == null ? getArrayIndication.arrayHeader != null : !((Object)this.arrayHeader).equals(getArrayIndication.arrayHeader)) {
            return false;
        }
        if (this.asgID != getArrayIndication.asgID) {
            return false;
        }
        return this.taID == getArrayIndication.taID;
    }
}

