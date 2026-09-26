/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.arrays.IListAdapter;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractArrayHandler
implements ArrayHandler {
    protected final AbstractBAPModuleFSG moduleFsg;
    protected final String className;
    protected final LogChannel logChannel;
    private final List listAdapters = new ArrayList(2);
    private volatile GetArrayIndication pendingRequest;

    public AbstractArrayHandler(AbstractBAPModuleFSG abstractBAPModuleFSG, String string) {
        this.moduleFsg = abstractBAPModuleFSG;
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.className = string;
    }

    @Override
    public void addListAdapter(IListAdapter iListAdapter) {
        this.listAdapters.add(iListAdapter);
    }

    @Override
    public int getNumberOfElements() {
        return this.getCurrentListSize();
    }

    @Override
    public void requestListElements(GetArrayIndication getArrayIndication) {
        this.setPendingRequest(getArrayIndication);
    }

    @Override
    public void responseListElements(int n, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (this.checkTAID(n)) {
            this.sendStatusRequest(combiBAPArrayElementArray);
        } else {
            this.logChannel.log(10000, "[%1#responseListElements] taID check failed -> ignore update!", (Object)this.className);
        }
    }

    protected boolean checkTAID(int n) {
        if (!this.isRequestPending()) {
            this.logChannel.log(10000, "[%1#checkTAID] no request pending", (Object)this.className, (long)n);
        } else {
            if (this.getPendingRequest().getTaID() == n) {
                return true;
            }
            this.logChannel.log(10000, "[%1#checkTAID] wrong taID received (expected: %2, received: %3)", (Object)this.className, (long)this.getPendingRequest().getTaID(), (long)n);
        }
        return false;
    }

    protected boolean sendChangedArrayRequest(ListDelta listDelta) {
        return this.sendChangedArrayRequest(listDelta, false);
    }

    private boolean sendChangedArrayRequest(ListDelta listDelta, boolean bl) {
        this.logChannel.log(-2137614336, "[%1#sendChangedArrayRequest] called - %2", (Object)this.className, (Object)listDelta.toString());
        if (listDelta.isUnchanged()) {
            this.logChannel.log(-2137614336, "[%1#sendChangedArrayRequest] list didn't change (%2)", (Object)this.className, (Object)(bl ? "send changedArray request anyway" : "don't send changedArray request"));
            if (!bl) {
                return false;
            }
        }
        if (this.isFullRangeUpdateNeeded(listDelta)) {
            return this.sendFullRangeUpdate();
        }
        Iterator iterator = this.listAdapters.iterator();
        while (iterator.hasNext()) {
            ((IListAdapter)iterator.next()).sendChangedArrayRequest(listDelta);
        }
        return true;
    }

    private boolean isFullRangeUpdateNeeded(ListDelta listDelta) {
        boolean bl = listDelta.isFullRangeUpdateNeeded();
        List list = listDelta.getAddedElementsIDs();
        List list2 = listDelta.getChangedElementsIDs();
        if (!bl) {
            if (list.size() > 1 && !this.isConsecutiveBlock(list)) {
                bl = true;
            }
            if (list2.size() > 1 && !this.isConsecutiveBlock(list2)) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean isConsecutiveBlock(List list) {
        Iterator iterator = list.iterator();
        int n = (Integer)iterator.next();
        while (iterator.hasNext()) {
            int n2 = (Integer)iterator.next();
            if (n2 != this.getSuccessorID(n)) {
                return false;
            }
            n = n2;
        }
        return true;
    }

    protected void sendStatusRequest(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (this.isRequestPending()) {
            GetArrayIndication getArrayIndication = this.getPendingRequest();
            this.clearPendingRequest();
            Iterator iterator = this.listAdapters.iterator();
            while (iterator.hasNext()) {
                IListAdapter iListAdapter = (IListAdapter)iterator.next();
                IArrayHeader iArrayHeader = getArrayIndication.getArrayHeader();
                if (iArrayHeader.getNumberOfElements() != combiBAPArrayElementArray.length) {
                    this.logChannel.log(-1601830656, "[%1#sendStatusRequest] Number of elements mismatch! Header='%3', Data='%4' (adapter='%2')", (Object)this.className, (Object)super.getClass().getName(), (Object)new Integer(iArrayHeader.getNumberOfElements()), (long)combiBAPArrayElementArray.length);
                }
                iListAdapter.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray);
            }
        } else {
            Iterator iterator = this.listAdapters.iterator();
            while (iterator.hasNext()) {
                IListAdapter iListAdapter = (IListAdapter)iterator.next();
                if (iListAdapter.isSpontaneousStatusRequestSupported()) {
                    this.logChannel.log(-1601830656, "[%1#sendStatusRequest] No pending request. Sending 'spontaneous' status array (adapter='%2')", (Object)this.className, (Object)super.getClass().getName());
                    IArrayHeader iArrayHeader = iListAdapter.createArrayHeader();
                    iArrayHeader.setStart(-65536);
                    GetArrayIndication getArrayIndication = new GetArrayIndication(0, 0, iArrayHeader);
                    iListAdapter.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray);
                    continue;
                }
                if (!this.logChannel.isDebug()) continue;
                this.logChannel.log(-2137614336, "[%1#sendStatusRequest] No pending request. 'Spontaneous' status array not supported for adapter: '%2'", (Object)this.className, (Object)super.getClass().getName());
            }
        }
    }

    protected void sendEmptyList() {
        this.sendStatusRequest(new CombiBAPArrayElement[0]);
    }

    @Override
    public boolean sendFullRangeUpdate() {
        this.logChannel.log(-2137614336, "[%1#sendFullRangeUpdate] called", (Object)this.className);
        boolean bl = false;
        Iterator iterator = this.listAdapters.iterator();
        while (iterator.hasNext()) {
            if (!((IListAdapter)iterator.next()).sendFullRangeUpdate()) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean dataMustBeReversed() {
        return false;
    }

    @Override
    public int getIndexSize() {
        return 1;
    }

    @Override
    public boolean is16BitIndexSize() {
        return this.getIndexSize() == 1;
    }

    protected final void setPendingRequest(GetArrayIndication getArrayIndication) {
        this.pendingRequest = getArrayIndication;
    }

    protected final GetArrayIndication getPendingRequest() {
        return this.pendingRequest;
    }

    protected final boolean isRequestPending() {
        return this.pendingRequest != null;
    }

    protected final void clearPendingRequest() {
        this.pendingRequest = null;
    }
}

