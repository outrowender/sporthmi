/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

public class PicklistElement
implements IPicklistElement {
    private IPicklistSlot[] slots;
    private final int graphGroupSize;
    private final int graphGroupIndex;
    private final int graphGroupId;
    private final int ruleID;
    private int confidence = -1;

    private static int hashCode(Object[] objectArray) {
        int n = 31;
        if (objectArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            n2 = n * n2 + (objectArray[i2] == null ? 0 : objectArray[i2].hashCode());
        }
        return n2;
    }

    public PicklistElement(int n, int n2, int n3, IPicklistSlot[] iPicklistSlotArray) {
        this.ruleID = n;
        this.graphGroupSize = n2;
        this.graphGroupIndex = n3;
        this.graphGroupId = n3;
        this.slots = iPicklistSlotArray;
    }

    public PicklistElement(int n, int n2, int n3, int n4, IPicklistSlot[] iPicklistSlotArray) {
        this.ruleID = n;
        this.confidence = n2;
        this.graphGroupSize = n3;
        this.graphGroupIndex = n4;
        this.graphGroupId = n4;
        this.slots = iPicklistSlotArray;
    }

    public PicklistElement(int n, int n2, int n3, int n4, int n5, IPicklistSlot[] iPicklistSlotArray) {
        this.ruleID = n;
        this.confidence = n2;
        this.graphGroupSize = n3;
        this.graphGroupIndex = n4;
        this.graphGroupId = n5;
        this.slots = iPicklistSlotArray;
    }

    public IPicklistSlot[] getSlots() {
        return this.slots;
    }

    public void setSlots(IPicklistSlot[] iPicklistSlotArray) {
        this.slots = iPicklistSlotArray;
    }

    public int getGraphGroupSize() {
        return this.graphGroupSize;
    }

    public int getGraphGroupIndex() {
        return this.graphGroupIndex;
    }

    public int getGraphGroupId() {
        return this.graphGroupId;
    }

    public int getRuleID() {
        return this.ruleID;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.graphGroupIndex;
        n = 31 * n + this.graphGroupSize;
        n = 31 * n + this.ruleID;
        n = 31 * n + PicklistElement.hashCode(this.slots);
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
        PicklistElement picklistElement = (PicklistElement)object;
        if (this.graphGroupIndex != picklistElement.getGraphGroupIndex()) {
            return false;
        }
        if (this.graphGroupSize != picklistElement.getGraphGroupSize()) {
            return false;
        }
        if (this.ruleID != picklistElement.getRuleID()) {
            return false;
        }
        return Arrays.equals(this.slots, picklistElement.getSlots());
    }

    public String toString() {
        return new Buffer("ruleID: ").append(this.ruleID).append("; confidence: ").append(this.confidence).append("; ggSize: ").append(this.graphGroupSize).append("; ggIndex: ").append(this.graphGroupIndex).append("; ggId: ").append(this.graphGroupId).append("; slots: ").append(SDSUtils.toString((Object[])this.slots, false)).toString();
    }

    public long getObjectID() {
        IPicklistSlot[] iPicklistSlotArray = this.getSlots();
        if (iPicklistSlotArray == null || iPicklistSlotArray.length == 0) {
            return -1L;
        }
        IPicklistSlot iPicklistSlot = iPicklistSlotArray[0];
        if (iPicklistSlot == null) {
            return -1L;
        }
        return iPicklistSlot.getObjID();
    }
}

