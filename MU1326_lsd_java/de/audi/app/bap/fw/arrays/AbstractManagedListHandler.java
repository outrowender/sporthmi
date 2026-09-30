/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayUtils;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public abstract class AbstractManagedListHandler
extends AbstractArrayHandler {
    private static final int UNKNOWN_ENTRY_ID = 65535;
    protected volatile CombiBAPArrayElement[] list = new CombiBAPArrayElement[0];

    public AbstractManagedListHandler(AbstractBAPModuleFSG abstractBAPModuleFSG, String string) {
        super(abstractBAPModuleFSG, string);
    }

    public void updateList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (combiBAPArrayElementArray == null) {
            this.logChannel.log(10000, "[%1#updateList] invalid list update: newList is null", (Object)this.className);
            return;
        }
        this.logChannel.log(10000000, "[%1#updateList] listSize=%2", (Object)this.className, (long)combiBAPArrayElementArray.length);
        if (this.list.length == 0 && combiBAPArrayElementArray.length == 0) {
            this.logChannel.log(10000000, "[%1#updateList] list is still empty -> don't send ChangedArray", (Object)this.className);
        } else {
            ListDelta listDelta = ListDelta.compare(this.list, combiBAPArrayElementArray);
            this.list = combiBAPArrayElementArray;
            this.sendChangedArrayRequest(listDelta);
        }
    }

    public void requestListElements(GetArrayIndication getArrayIndication) {
        super.requestListElements(getArrayIndication);
        CombiBAPArrayElement[] combiBAPArrayElementArray = this.getListSectionForRequest(getArrayIndication);
        this.responseListElements(getArrayIndication.getTaID(), combiBAPArrayElementArray);
    }

    public void responseListElements(int n, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        super.responseListElements(n, combiBAPArrayElementArray);
    }

    private CombiBAPArrayElement[] getListSectionForRequest(GetArrayIndication getArrayIndication) {
        IArrayHeader iArrayHeader = getArrayIndication.getArrayHeader();
        CombiBAPArrayElement[] combiBAPArrayElementArray = ArrayUtils.getListSection(this.logChannel, this.list, iArrayHeader.getStart(), iArrayHeader.getNumberOfElements(), iArrayHeader.isModeShift(), iArrayHeader.isModeArrayDirectionBackward());
        return combiBAPArrayElementArray;
    }

    public CombiBAPArrayElement[] getManagedList() {
        CombiBAPArrayElement[] combiBAPArrayElementArray = new CombiBAPArrayElement[this.list.length];
        System.arraycopy((Object)this.list, 0, (Object)combiBAPArrayElementArray, 0, combiBAPArrayElementArray.length);
        return this.list;
    }

    public CombiBAPArrayElement getArrayElement(int n) {
        if (this.list != null) {
            for (int i2 = 0; i2 < this.list.length; ++i2) {
                if (this.list[i2].getPosID() != n) continue;
                return this.list[i2];
            }
        }
        return null;
    }

    public int getCurrentListSize() {
        return this.list.length;
    }

    public abstract void getNextListPos(int var1, int var2);

    protected final void getNextListPosForArbitraryIds(int n, int n2) {
        int n3 = ArrayUtils.getIndexInList(this.list, n);
        if (n3 == -1) {
            this.getNextListPosFailed(n);
            return;
        }
        int n4 = n3 + n2;
        if (n4 < 0) {
            this.getNextListPosFailed(n);
            return;
        }
        if (n4 >= this.list.length) {
            this.getNextListPosFailed(n);
            return;
        }
        int n5 = ArrayUtils.getPosID(this.list, n4);
        if (n5 == -1) {
            this.getNextListPosFailed(n);
            return;
        }
        int n6 = n4 + 1;
        this.getNextListPosSucceeded(n, n5, n6);
    }

    protected final void getNextListPosForConsecutiveIds(int n, int n2) {
        int n3 = n + n2;
        if (n3 < 0) {
            this.getNextListPosFailed(n);
            return;
        }
        if (n3 >= this.list.length) {
            this.getNextListPosFailed(n);
            return;
        }
        int n4 = n3 + 1;
        this.getNextListPosSucceeded(n, n3, n4);
    }

    private void getNextListPosSucceeded(int n, int n2, int n3) {
        this.getNextListPosResult(true, n, n2, n3);
    }

    private void getNextListPosFailed(int n) {
        this.getNextListPosResult(false, n, 65535, 65535);
    }

    public int getPredecessorID(int n) {
        if (this.list != null) {
            for (int i2 = 0; i2 < this.list.length; ++i2) {
                if (this.list[i2].getPosID() != n) continue;
                return i2 == 0 ? 0 : this.list[i2 - 1].getPosID();
            }
        }
        return 0;
    }

    public int getSuccessorID(int n) {
        if (this.list != null) {
            for (int i2 = 0; i2 < this.list.length; ++i2) {
                if (this.list[i2].getPosID() != n) continue;
                return i2 == this.list.length - 1 ? 0 : this.list[i2 + 1].getPosID();
            }
        }
        return 0;
    }
}

