/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.PicklistElement;
import de.audi.app.sdsmanager.nbest.PicklistSlot;

public class Picklist
implements IPicklist {
    private final IPicklistElement[] elements;
    private int[] entryIndexMapping = new int[0];
    private boolean lineSelectedByNumber = false;
    private int lastRecogLineNumber = -1;

    public Picklist() {
        this.elements = new IPicklistElement[0];
    }

    public Picklist(IPicklistElement[] iPicklistElementArray) {
        this.elements = iPicklistElementArray;
    }

    public Picklist(IPicklistElement[] iPicklistElementArray, int[] nArray) {
        this.elements = iPicklistElementArray;
        this.entryIndexMapping = nArray;
    }

    public Picklist(String[] stringArray) {
        int n = stringArray.length;
        this.elements = new PicklistElement[n];
        for (int i2 = 0; i2 < n; ++i2) {
            this.elements[i2] = new PicklistElement(-1, 0, 0, -1, new PicklistSlot[]{new PicklistSlot(stringArray[i2], "", i2, i2)});
        }
    }

    public int[] getGraphGroupSizes() {
        int n = this.elements.length;
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = this.elements[i2].getGraphGroupSize();
        }
        return nArray;
    }

    public int[] getGraphGroupIndexes() {
        int n = this.elements.length;
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = this.elements[i2].getGraphGroupIndex();
        }
        return nArray;
    }

    public IPicklistElement get(int n) {
        if (n < 0 || n >= this.elements.length) {
            return null;
        }
        return this.elements[n];
    }

    public int getSize() {
        return this.elements == null ? 0 : this.elements.length;
    }

    public IPicklistSlot getSlot(int n, int n2) {
        if (n < 0 || n >= this.elements.length) {
            return null;
        }
        IPicklistElement iPicklistElement = this.elements[n];
        if (iPicklistElement == null) {
            return null;
        }
        IPicklistSlot[] iPicklistSlotArray = this.elements[n].getSlots();
        if (iPicklistSlotArray == null) {
            return null;
        }
        if (n2 < 0 || n2 >= iPicklistSlotArray.length) {
            return null;
        }
        return iPicklistSlotArray[n2];
    }

    public IPicklistElement[] getElements() {
        return this.elements;
    }

    public int getPositionForSlotIndex(int n) {
        if (SDSUtils.isEmpty(this.entryIndexMapping) || n < 0 || n >= this.entryIndexMapping.length) {
            return -1;
        }
        return this.entryIndexMapping[n];
    }

    public void setLastRecogLine(boolean bl, int n) {
        this.lineSelectedByNumber = bl;
        this.lastRecogLineNumber = n;
    }

    public int getLastRecogLineNumber() {
        return this.lastRecogLineNumber;
    }

    public boolean isLineSelectedByNumber() {
        return this.lineSelectedByNumber;
    }

    public String toString() {
        return SDSUtils.toString((Object[])this.elements, true);
    }

    public IPicklist getRearrangedPicklist(int[] nArray) {
        if (nArray.length <= 0) {
            return null;
        }
        IPicklistElement[] iPicklistElementArray = new IPicklistElement[this.elements.length];
        for (int i2 = 0; i2 < iPicklistElementArray.length; ++i2) {
            IPicklistSlot[] iPicklistSlotArray = this.elements[i2].getSlots();
            IPicklistSlot[] iPicklistSlotArray2 = new IPicklistSlot[nArray.length];
            for (int i3 = 0; i3 < iPicklistSlotArray2.length; ++i3) {
                int n = nArray[i3];
                if (n < 0) {
                    return null;
                }
                if (n >= iPicklistSlotArray.length) continue;
                iPicklistSlotArray2[i3] = iPicklistSlotArray[n];
            }
            iPicklistElementArray[i2] = new PicklistElement(this.elements[i2].getRuleID(), this.elements[i2].getConfidence(), this.elements[i2].getGraphGroupSize(), this.elements[i2].getGraphGroupIndex(), this.elements[i2].getGraphGroupId(), iPicklistSlotArray2);
        }
        return new Picklist(iPicklistElementArray, this.entryIndexMapping);
    }
}

