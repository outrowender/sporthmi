/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.AbstractListAdapter;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHeaderBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractListAdapterBAP
extends AbstractListAdapter {
    protected final LogChannel logChannel;
    private final BAPFunctionArrayFSG bapFunction;

    public AbstractListAdapterBAP(AbstractBAPModuleFSG abstractBAPModuleFSG, int n, ArrayHandler arrayHandler) {
        super(arrayHandler);
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.bapFunction = abstractBAPModuleFSG.getBAPFunctionArrayFSG(n);
    }

    public IArrayHeader createArrayHeader() {
        return new ArrayHeaderBAP();
    }

    public boolean sendFullRangeUpdate() {
        if (this.bapFunction != null) {
            ChangedArray changedArray = this.createChangedArraySerializer();
            changedArray.getArrayHeader().setFullRangeUpdate(this.listHandler.is16BitIndexSize());
            changedArray.getArrayData().reset();
            this.bapFunction.changedArrayREQ(changedArray);
            return true;
        }
        return false;
    }

    public boolean isSpontaneousStatusRequestSupported() {
        return true;
    }

    public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (getArrayIndication.getArrayHeader() instanceof ArrayHeaderBAP) {
            this.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray, this.createStatusArraySerializer());
        } else {
            this.logChannel.log(100000000, "[AbstractListAdapterBAP#sendStatusRequest] ignore status request because of wrong ArrayHeader type");
        }
    }

    protected void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray, StatusArray statusArray) {
        ArrayHeader arrayHeader = ((ArrayHeaderBAP)getArrayIndication.getArrayHeader()).getArrayHeader();
        arrayHeader.elements = combiBAPArrayElementArray == null ? 0 : combiBAPArrayElementArray.length;
        arrayHeader.mode.arrayPositionIsTransmitted = true;
        arrayHeader.mode.indexSize16BitForStartElements = this.listHandler.is16BitIndexSize();
        statusArray.setArrayHeader(arrayHeader);
        statusArray.setAsgId(getArrayIndication.getAsgID());
        statusArray.setTransactionId(getArrayIndication.getTaID());
        statusArray.setNumberOfElements(combiBAPArrayElementArray == null ? 0 : this.listHandler.getNumberOfElements());
        BAPArrayData bAPArrayData = statusArray.getArrayData();
        bAPArrayData.reset();
        Buffer buffer = new Buffer();
        if (this.logChannel.isDebug()) {
            buffer.append("lsgID=").append(this.bapFunction.getLSGIDDescription());
            buffer.append(", fctID=").append(this.bapFunction.getFctIDDescription());
            buffer.append("\n");
        }
        if (combiBAPArrayElementArray != null) {
            if (this.listHandler.dataMustBeReversed() && arrayHeader.mode.arrayDirectionIsBackward) {
                for (int i2 = combiBAPArrayElementArray.length - 1; i2 >= 0; --i2) {
                    bAPArrayData.add(this.convertArrayElement(combiBAPArrayElementArray[i2], arrayHeader));
                    if (!this.logChannel.isDebug()) continue;
                    buffer.append(combiBAPArrayElementArray[i2]).append("\n");
                }
            } else {
                for (int i3 = 0; i3 < combiBAPArrayElementArray.length; ++i3) {
                    bAPArrayData.add(this.convertArrayElement(combiBAPArrayElementArray[i3], arrayHeader));
                    if (!this.logChannel.isDebug()) continue;
                    buffer.append(combiBAPArrayElementArray[i3]).append("\n");
                }
            }
        }
        this.logChannel.log(10000000, "[AbstractListAdapterBAP#sendStatusRequest]\n%1", (Object)buffer);
        this.bapFunction.statusArrayREQ(getArrayIndication.getTaID(), statusArray);
    }

    public void sendChangedArrayRequest(ListDelta listDelta) {
        this.sendChangedArrayRequestRemovedElements(listDelta);
        this.sendChangedArrayRequestAddedElements(listDelta);
        this.sendChangedArrayRequestChangedElements(listDelta);
    }

    private void sendChangedArrayRequestChangedElements(ListDelta listDelta) {
        List list = listDelta.getChangedElementsIDs();
        if (!list.isEmpty()) {
            ChangedArray changedArray = this.createChangedArraySerializer();
            ArrayHeader arrayHeader = changedArray.getArrayHeader();
            BAPArrayData bAPArrayData = changedArray.getArrayData();
            bAPArrayData.reset();
            int n = (Integer)list.get(0);
            int n2 = list.size();
            Buffer buffer = new Buffer();
            if (n2 == 1) {
                arrayHeader.setElementChangedRequest(n, this.listHandler.is16BitIndexSize(), listDelta.getChangedElementRecordAddress(n));
                if (this.logChannel.isDebug()) {
                    buffer.append(n);
                }
            } else {
                int n3 = this.listHandler.getPredecessorID(n);
                arrayHeader.setElementsChangedBlockRequest(n3, n2 + 1, this.listHandler.getIndexSize() == 1, this.getCommonRecordAddress(listDelta.getChangedElementsRecordAddresses()));
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    int n4 = (Integer)iterator.next();
                    bAPArrayData.add(this.createArrayElement(arrayHeader, n4));
                    if (this.logChannel.isDebug()) {
                        buffer.append(n4);
                    }
                    if (iterator.hasNext()) {
                        if (!this.logChannel.isDebug()) continue;
                        buffer.append(", ");
                        continue;
                    }
                    BAPArrayElement bAPArrayElement = this.createArrayElement(arrayHeader, this.listHandler.getSuccessorID(n4));
                    bAPArrayData.add(bAPArrayElement);
                }
            }
            this.logChannel.log(10000000, "[AbstractListAdapterBAP#sendChangedArrayRequestChangedElements] changed %2 elements (IDs: %1)", (Object)buffer, (long)n2);
            this.bapFunction.changedArrayREQ(changedArray);
        }
    }

    private void sendChangedArrayRequestAddedElements(ListDelta listDelta) {
        List list = listDelta.getAddedElementsIDs();
        if (!list.isEmpty()) {
            ChangedArray changedArray = this.createChangedArraySerializer();
            ArrayHeader arrayHeader = changedArray.getArrayHeader();
            BAPArrayData bAPArrayData = changedArray.getArrayData();
            bAPArrayData.reset();
            int n = (Integer)list.get(0);
            int n2 = this.listHandler.getPredecessorID(n);
            int n3 = list.size();
            arrayHeader.setElementsInsertedBlockRequest(n2, n3 + 1, this.listHandler.is16BitIndexSize());
            Buffer buffer = new Buffer();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                int n4 = (Integer)iterator.next();
                bAPArrayData.add(this.createArrayElement(arrayHeader, n4));
                if (this.logChannel.isDebug()) {
                    buffer.append(n4);
                }
                if (iterator.hasNext()) {
                    if (!this.logChannel.isDebug()) continue;
                    buffer.append(", ");
                    continue;
                }
                BAPArrayElement bAPArrayElement = this.createArrayElement(arrayHeader, this.listHandler.getSuccessorID(n4));
                bAPArrayData.add(bAPArrayElement);
            }
            this.logChannel.log(10000000, "[AbstractListAdapterBAP#sendChangedArrayRequestAddedElements] added %2 elements (IDs: %1)", (Object)buffer, (long)n3);
            this.bapFunction.changedArrayREQ(changedArray);
        }
    }

    private void sendChangedArrayRequestRemovedElements(ListDelta listDelta) {
        List list = listDelta.getRemovedElementsIDs();
        if (!list.isEmpty()) {
            ChangedArray changedArray = this.createChangedArraySerializer();
            ArrayHeader arrayHeader = changedArray.getArrayHeader();
            BAPArrayData bAPArrayData = changedArray.getArrayData();
            bAPArrayData.reset();
            int n = list.size();
            arrayHeader.setElementsDeleteBlockRequest((Integer)list.get(0), n, this.listHandler.is16BitIndexSize());
            Buffer buffer = new Buffer();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)iterator.next();
                bAPArrayData.add(this.createArrayElement(arrayHeader, n2));
                if (!this.logChannel.isDebug()) continue;
                buffer.append(n2);
                if (!iterator.hasNext()) continue;
                buffer.append(", ");
            }
            this.logChannel.log(10000000, "[AbstractListAdapterBAP#sendChangedArrayRequestRemovedElements] removed %2 elements (IDs: %1)", (Object)buffer, (long)n);
            this.bapFunction.changedArrayREQ(changedArray);
        }
    }

    private int getCommonRecordAddress(Collection collection) {
        boolean[] blArray = new boolean[16];
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            blArray[((Integer)iterator.next()).intValue()] = true;
        }
        int n = blArray[0] ? 0 : this.getCommonRecordAddress(blArray);
        return n;
    }

    protected abstract int getCommonRecordAddress(boolean[] var1);

    protected abstract BAPArrayElement convertArrayElement(CombiBAPArrayElement var1, ArrayHeader var2);

    protected abstract BAPArrayElement createArrayElement(ArrayHeader var1, int var2);

    protected abstract ChangedArray createChangedArraySerializer();

    protected abstract StatusArray createStatusArraySerializer();
}

