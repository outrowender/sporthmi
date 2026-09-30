/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.ArrayUtils;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ListDelta {
    private final List addedElementsIDs = new ArrayList(5);
    private final List removedElementsIDs = new ArrayList(5);
    private final List changedElementsIDs = new ArrayList(5);
    private final Map changedElementsRecordAddresses = new HashMap(5);
    private final int oldListSize;
    private volatile boolean fullRangeUpdateNeeded = false;
    private static final byte FULL_RANGE_UPDATE_THRESHOLD = 15;

    private ListDelta(int n) {
        this.oldListSize = n;
    }

    public static ListDelta compare(CombiBAPArrayElement[] combiBAPArrayElementArray, CombiBAPArrayElement[] combiBAPArrayElementArray2) {
        ListDelta listDelta = new ListDelta(combiBAPArrayElementArray == null ? 0 : combiBAPArrayElementArray.length);
        listDelta.compareLists(combiBAPArrayElementArray, combiBAPArrayElementArray2);
        return listDelta;
    }

    private void compareLists(CombiBAPArrayElement[] combiBAPArrayElementArray, CombiBAPArrayElement[] combiBAPArrayElementArray2) {
        int n;
        ArrayList arrayList = new ArrayList(5);
        if (combiBAPArrayElementArray != null) {
            for (n = 0; n < combiBAPArrayElementArray.length; ++n) {
                if (combiBAPArrayElementArray[n] == null) continue;
                arrayList.add(combiBAPArrayElementArray[n]);
            }
        }
        for (n = 0; n < combiBAPArrayElementArray2.length; ++n) {
            if (combiBAPArrayElementArray2[n] == null) continue;
            CombiBAPArrayElement combiBAPArrayElement = ArrayUtils.findElementByID(combiBAPArrayElementArray, combiBAPArrayElementArray2[n].getPosID());
            if (combiBAPArrayElement == null) {
                this.addedElement(combiBAPArrayElementArray2[n]);
                continue;
            }
            int n2 = combiBAPArrayElement.getDiffRecordAddress(combiBAPArrayElementArray2[n]);
            if (n2 >= 0) {
                this.changedElement(combiBAPArrayElementArray2[n], n2);
            }
            arrayList.remove(combiBAPArrayElement);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            this.removedElement((CombiBAPArrayElement)iterator.next());
        }
        this.checkFullRangeUpdateNeeded(combiBAPArrayElementArray, combiBAPArrayElementArray2);
    }

    private void checkFullRangeUpdateNeeded(CombiBAPArrayElement[] combiBAPArrayElementArray, CombiBAPArrayElement[] combiBAPArrayElementArray2) {
        if (ListDelta.listWasEmpty(combiBAPArrayElementArray) || this.allElementsChanged(combiBAPArrayElementArray)) {
            this.fullRangeUpdateNeeded = true;
        } else if (this.moreThanOneTypeOfOperationNeeded()) {
            this.fullRangeUpdateNeeded = true;
        } else if (this.moreThanThresholdElementsAffected()) {
            this.fullRangeUpdateNeeded = true;
        } else {
            int n;
            int n2 = 0;
            for (n = 0; n2 < combiBAPArrayElementArray.length && n < combiBAPArrayElementArray2.length; ++n2, ++n) {
                while (this.removedElementsIDs.contains(new Integer(combiBAPArrayElementArray[n2].getPosID()))) {
                    if (++n2 < combiBAPArrayElementArray.length) continue;
                    this.fullRangeUpdateNeeded = true;
                    return;
                }
                while (this.addedElementsIDs.contains(new Integer(combiBAPArrayElementArray2[n].getPosID()))) {
                    if (++n < combiBAPArrayElementArray2.length) continue;
                    this.fullRangeUpdateNeeded = true;
                    return;
                }
                if (combiBAPArrayElementArray[n2].getPosID() == combiBAPArrayElementArray2[n].getPosID()) continue;
                this.fullRangeUpdateNeeded = true;
                return;
            }
            if (this.isUnchanged() && (n2 < combiBAPArrayElementArray.length || n < combiBAPArrayElementArray2.length)) {
                this.fullRangeUpdateNeeded = true;
            }
        }
    }

    private boolean moreThanOneTypeOfOperationNeeded() {
        return this.typeOfOperationsCount() > 1;
    }

    private boolean moreThanThresholdElementsAffected() {
        return this.removedElementsIDs.size() > 15 || this.addedElementsIDs.size() > 15 || this.changedElementsIDs.size() > 15;
    }

    private int typeOfOperationsCount() {
        int n = this.removedElementsIDs.isEmpty() ? 0 : 1;
        int n2 = this.addedElementsIDs.isEmpty() ? 0 : 1;
        int n3 = this.changedElementsIDs.isEmpty() ? 0 : 1;
        return n + n2 + n3;
    }

    private boolean allElementsChanged(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        return combiBAPArrayElementArray.length == this.changedElementsIDs.size();
    }

    private static boolean listWasEmpty(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        return combiBAPArrayElementArray == null || combiBAPArrayElementArray.length == 0;
    }

    public boolean isFullRangeUpdateNeeded() {
        return this.fullRangeUpdateNeeded;
    }

    public List getAddedElementsIDs() {
        return this.addedElementsIDs;
    }

    public List getRemovedElementsIDs() {
        return this.removedElementsIDs;
    }

    public List getChangedElementsIDs() {
        return this.changedElementsIDs;
    }

    public int getOldListSize() {
        return this.oldListSize;
    }

    private void addedElement(CombiBAPArrayElement combiBAPArrayElement) {
        this.addedElementsIDs.add(new Integer(combiBAPArrayElement.getPosID()));
    }

    private void removedElement(CombiBAPArrayElement combiBAPArrayElement) {
        this.removedElementsIDs.add(new Integer(combiBAPArrayElement.getPosID()));
    }

    public void changedElement(CombiBAPArrayElement combiBAPArrayElement) {
        this.changedElement(combiBAPArrayElement, 0);
    }

    private void changedElement(CombiBAPArrayElement combiBAPArrayElement, int n) {
        Integer n2 = new Integer(combiBAPArrayElement.getPosID());
        this.changedElementsIDs.add(n2);
        this.changedElementsRecordAddresses.put(n2, new Integer(n));
    }

    public int getChangedElementRecordAddress(int n) {
        Integer n2 = (Integer)this.changedElementsRecordAddresses.get(new Integer(n));
        if (n2 == null) {
            return -1;
        }
        return n2;
    }

    public Collection getChangedElementsRecordAddresses() {
        return this.changedElementsRecordAddresses.values();
    }

    public boolean isChanged() {
        return !this.isUnchanged();
    }

    public boolean isUnchanged() {
        return !this.fullRangeUpdateNeeded && this.addedElementsIDs.isEmpty() && this.removedElementsIDs.isEmpty() && this.changedElementsIDs.isEmpty();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("removedElements: ");
        buffer.append(this.removedElementsIDs.size());
        if (!this.removedElementsIDs.isEmpty()) {
            buffer.append(ListDelta.printIDs(this.removedElementsIDs));
        }
        buffer.append(", addedElements: ");
        buffer.append(this.addedElementsIDs.size());
        if (!this.addedElementsIDs.isEmpty()) {
            buffer.append(ListDelta.printIDs(this.addedElementsIDs));
        }
        buffer.append(", changedElements: ");
        buffer.append(this.changedElementsIDs.size());
        if (!this.changedElementsIDs.isEmpty()) {
            buffer.append(ListDelta.printIDs(this.changedElementsIDs));
        }
        return buffer.toString();
    }

    private static String printIDs(List list) {
        Buffer buffer = new Buffer();
        buffer.append(" (IDs=");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next().toString());
            if (!iterator.hasNext()) continue;
            buffer.append(',');
        }
        buffer.append(')');
        return buffer.toString();
    }
}

