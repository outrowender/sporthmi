/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.esolutions.fw.util.commons.Buffer;

public class PicklistSlot
implements IPicklistSlot {
    private String text;
    private final String objectStringID;
    private final long objID;
    private final int slotIndex;

    public PicklistSlot(String string, String string2, long l, int n) {
        this.text = string;
        this.objectStringID = string2;
        this.objID = l;
        this.slotIndex = n;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
    }

    public String getObjectStringID() {
        return this.objectStringID;
    }

    public long getObjID() {
        return this.objID;
    }

    public int getIndex() {
        return this.slotIndex;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (int)(this.objID ^ this.objID >>> 32);
        n = 31 * n + (this.text == null ? 0 : this.text.hashCode());
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
        PicklistSlot picklistSlot = (PicklistSlot)object;
        if (this.objID != picklistSlot.getObjID()) {
            return false;
        }
        return !(this.text == null ? picklistSlot.text != null : !this.text.equals(picklistSlot.getText()));
    }

    public boolean isDuplicateSlot(IPicklistSlot iPicklistSlot) {
        if (iPicklistSlot == null || this.objID != iPicklistSlot.getObjID()) {
            return false;
        }
        String string = iPicklistSlot.getText();
        if (SDSUtils.isEmpty(this.objectStringID)) {
            if (SDSUtils.isEmpty(iPicklistSlot.getObjectStringID())) {
                return this.objID != -1L || string.equals(this.text);
            }
        } else if (this.objectStringID.equals(iPicklistSlot.getObjectStringID())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return new Buffer().append(this.text).append(" (objID=").append(this.objID).append(", objectStringID=").append(this.objectStringID).append(", slotIndex=").append(this.slotIndex).append(")").toString();
    }
}

