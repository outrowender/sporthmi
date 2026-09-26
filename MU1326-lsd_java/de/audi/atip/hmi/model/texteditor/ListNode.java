/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.modelaccess.ICopyTo;

public class ListNode
implements ICopyTo {
    public ListNode left;
    public ListNode right;
    public ICopyTo[] data;

    public ListNode() {
        this(null, null, null);
    }

    public ListNode(ICopyTo[] iCopyToArray) {
        this(null, null, iCopyToArray);
    }

    public ListNode(ListNode listNode, ListNode listNode2, ICopyTo[] iCopyToArray) {
        this.left = listNode;
        this.right = listNode2;
        this.data = iCopyToArray;
    }

    public String toString() {
        if (this.data != null) {
            return this.data[0].toString();
        }
        return null;
    }

    @Override
    public boolean copyTo(ICopyTo iCopyTo) {
        if (!(iCopyTo instanceof ListNode)) {
            return false;
        }
        ICopyTo[] iCopyToArray = new ICopyTo[this.data.length];
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            if (this.data[i2].copyTo(iCopyToArray[i2])) continue;
            return false;
        }
        ((ListNode)iCopyTo).data = iCopyToArray;
        return true;
    }
}

