/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;

public class GetArrayIndicationAddressList
extends GetArrayIndication {
    private final int otherListType;
    private final int otherListReference;

    public GetArrayIndicationAddressList(int n, int n2, IArrayHeader iArrayHeader, int n3, int n4) {
        super(n, n2, iArrayHeader);
        this.otherListType = n3;
        this.otherListReference = n4;
    }

    public int getOtherListType() {
        return this.otherListType;
    }

    public int getOtherListReference() {
        return this.otherListReference;
    }

    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + this.otherListReference;
        n = 31 * n + this.otherListType;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        GetArrayIndicationAddressList getArrayIndicationAddressList = (GetArrayIndicationAddressList)object;
        if (this.otherListReference != getArrayIndicationAddressList.otherListReference) {
            return false;
        }
        return this.otherListType == getArrayIndicationAddressList.otherListType;
    }
}

