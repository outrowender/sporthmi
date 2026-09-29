/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndicationBAP;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;

public class GetArrayIndicationReceptionList
extends GetArrayIndicationBAP {
    private final int elementType;
    private final int parentID;

    public GetArrayIndicationReceptionList(BAPFunctionArrayFSG bAPFunctionArrayFSG, int n, int n2, IArrayHeader iArrayHeader, int n3, int n4) {
        super(bAPFunctionArrayFSG, n, n2, iArrayHeader);
        this.elementType = n3;
        this.parentID = n4;
    }

    public int getElementType() {
        return this.elementType;
    }

    public int getParentID() {
        return this.parentID;
    }

    public void abortWithBAPError(int n) {
        this.bapFunction.finishGetArrayIndicationWithError(n);
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + this.elementType;
        n = 31 * n + this.parentID;
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        GetArrayIndicationReceptionList getArrayIndicationReceptionList = (GetArrayIndicationReceptionList)object;
        if (this.elementType != getArrayIndicationReceptionList.elementType) {
            return false;
        }
        return this.parentID == getArrayIndicationReceptionList.parentID;
    }
}

