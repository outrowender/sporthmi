/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;

public class GetArrayIndicationBAP
extends GetArrayIndication {
    protected final BAPFunctionArrayFSG bapFunction;

    public GetArrayIndicationBAP(BAPFunctionArrayFSG bAPFunctionArrayFSG, int n, int n2, IArrayHeader iArrayHeader) {
        super(n, n2, iArrayHeader);
        this.bapFunction = bAPFunctionArrayFSG;
    }

    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this.bapFunction == null ? 0 : this.bapFunction.hashCode());
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
        GetArrayIndicationBAP getArrayIndicationBAP = (GetArrayIndicationBAP)object;
        return !(this.bapFunction == null ? getArrayIndicationBAP.bapFunction != null : !this.bapFunction.equals(getArrayIndicationBAP.bapFunction));
    }
}

