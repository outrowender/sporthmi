/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayUtils;
import de.audi.app.bap.fw.arrays.ArrayUtils$IndexRange;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone.list.PhonebookHandler$PhonebookPictureProvider;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.telephone.serializer.GetNextListPos_Result;
import java.util.HashMap;
import java.util.Map;

public class PhonebookHandler
extends AbstractArrayHandler {
    private int currentListSize;
    private final Map detailRequestsInProgress = new HashMap();
    private CombiBAPPhonebookEntry[] pendingRequestResult;
    private final PhonebookHandler$PhonebookPictureProvider pictureProvider = new PhonebookHandler$PhonebookPictureProvider(this, null);

    public PhonebookHandler(CombiModulePhone combiModulePhone) {
        super(combiModulePhone, "PhonebookHandler");
        combiModulePhone.getPictureManager().registerPictureProvider(3, this.pictureProvider);
    }

    @Override
    public void requestListElements(GetArrayIndication getArrayIndication) {
        this.logChannel.log(-2137614336, "[%1#requestListElements] called", (Object)this.className);
        this.setPendingRequest(getArrayIndication);
        CombiBAPServiceAddressBookListener combiBAPServiceAddressBookListener = ((CombiModulePhone)this.moduleFsg).getAddressbookServiceListener();
        if (combiBAPServiceAddressBookListener != null) {
            if (this.currentListSize == 0) {
                this.sendEmptyList();
            } else {
                IArrayHeader iArrayHeader = getArrayIndication.getArrayHeader();
                int n = iArrayHeader.getStart() == 0 ? 0 : iArrayHeader.getStart() - 1;
                int n2 = iArrayHeader.getStartOffset();
                int n3 = iArrayHeader.getNumberOfElements();
                boolean bl = iArrayHeader.isModeShift();
                boolean bl2 = iArrayHeader.isModeArrayDirectionBackward();
                if (iArrayHeader.getStart() == 1 && bl && bl2) {
                    this.logChannel.log(-2137614336, "[PhonebookHandler#requestListElements] no wrap around with startPos!=0 -> send empty list");
                    this.sendEmptyList();
                } else {
                    ArrayUtils$IndexRange arrayUtils$IndexRange = ArrayUtils.computeRange(this.logChannel, this.currentListSize, n, n2, n3, bl, bl2);
                    if (arrayUtils$IndexRange == null) {
                        this.logChannel.log(-1601830656, "[PhonebookHandler#requestListElements] getArrayRequest not applicable on current list (currentListSize=%1, start=%2, numberOfElements=%3)", (long)this.currentListSize, (long)iArrayHeader.getStart(), (long)n3);
                        this.sendEmptyList();
                    } else {
                        combiBAPServiceAddressBookListener.requestPhonebookListElements(getArrayIndication.getTaID(), arrayUtils$IndexRange.startIndex, arrayUtils$IndexRange.getSize());
                    }
                }
            }
        } else {
            this.logChannel.log(10000, "[%1#requestListElements] unable to forward request because Addressbook service is not available", (Object)this.className);
            this.sendEmptyList();
            this.clearPendingRequest();
        }
    }

    @Override
    public CombiBAPArrayElement getArrayElement(int n) {
        return null;
    }

    @Override
    public void responseListElements(int n, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        this.pictureProvider.addToMapping((CombiBAPPhonebookEntry[])combiBAPArrayElementArray);
        if (this.checkTAID(n)) {
            this.logChannel.log(-2137614336, "[%1#responseListElements] taID check OK, received %2 element(s)", (Object)this.className, (long)combiBAPArrayElementArray.length);
            if (this.isRequestPending()) {
                switch (this.getPendingRequest().getArrayHeader().getRecordAddress()) {
                    case 0: 
                    case 2: 
                    case 4: {
                        this.pendingRequestResult = (CombiBAPPhonebookEntry[])combiBAPArrayElementArray;
                        if (combiBAPArrayElementArray.length == 1) {
                            this.requestEntryDetails(this.pendingRequestResult);
                            break;
                        }
                        if (combiBAPArrayElementArray.length > 1) {
                            this.logChannel.log(10000, "[%1#responseListElements] request of more than one element with full details not supported", (Object)this.className);
                            this.getPendingRequest().getArrayHeader().setRecordAddress(1);
                        }
                        this.sendStatusRequest(combiBAPArrayElementArray);
                        break;
                    }
                    default: {
                        this.sendStatusRequest(combiBAPArrayElementArray);
                        break;
                    }
                }
            } else {
                this.logChannel.log(-2137614336, "[%1#responseListElements] pending request is null -> ignore update", (Object)this.className);
            }
        } else {
            this.logChannel.log(10000, "[%1#responseListElements] taID check failed -> ignore update!", (Object)this.className);
        }
    }

    @Override
    public int getCurrentListSize() {
        return this.currentListSize;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void requestEntryDetails(CombiBAPPhonebookEntry[] combiBAPPhonebookEntryArray) {
        CombiBAPServiceAddressBookListener combiBAPServiceAddressBookListener = ((CombiModulePhone)this.moduleFsg).getAddressbookServiceListener();
        if (combiBAPServiceAddressBookListener == null) {
            this.logChannel.log(10000, "[%1#requestEntryDetails] unable to forward request because Addressbook service is not available", (Object)this.className);
            return;
        }
        Map map = this.detailRequestsInProgress;
        synchronized (map) {
            this.detailRequestsInProgress.clear();
        }
        for (int i2 = 0; i2 < combiBAPPhonebookEntryArray.length; ++i2) {
            long l = combiBAPPhonebookEntryArray[i2].getEntryId();
            Map map2 = this.detailRequestsInProgress;
            synchronized (map2) {
                this.detailRequestsInProgress.put(new Long(l), combiBAPPhonebookEntryArray[i2]);
            }
            this.logChannel.log(-2137614336, "[%1#requestEntryDetails] request details for entryID: %2", (Object)this.className, l);
            combiBAPServiceAddressBookListener.requestPhonebookEntryDetails(l);
        }
    }

    @Override
    public void getNextListPos(int n, int n2) {
        int n3 = n + n2;
        if (n3 < 1) {
            n3 = 1;
        } else if (n3 >= this.currentListSize) {
            n3 = this.currentListSize;
        }
        this.getNextListPosResult(true, n, n3, n3);
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "[%1#getNextListPosResult] called (result=%2, currentEntryID=%3,...)", (Object)this.className, (Object)(bl ? "successful" : "unsuccessful"), (long)n);
        this.logChannel.log(-2137614336, "[%1#getNextListPosResult] ..., nextEntryID=%2, absoluteListPos=%3", (Object)this.className, (long)n2, (long)n3);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(54);
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)this.moduleFsg.createResultSerializer(54);
        getNextListPos_Result.getNextListPos_Result = bl ? 0 : 1;
        getNextListPos_Result.currentPos = n;
        getNextListPos_Result.nextPos = n2;
        getNextListPos_Result.absoluteListPos = n3;
        bAPFunctionMethodFSG.resultREQ(getNextListPos_Result);
    }

    @Override
    public boolean dataMustBeReversed() {
        return true;
    }

    public void notifyPhonebookChanged(int n) {
        if (this.currentListSize == 0 && n == 0) {
            this.logChannel.log(-2137614336, "[PhonebookHandler#notifyPhonebookChanged] list is still empty -> don't send ChangedArray");
        } else {
            this.currentListSize = n;
            this.sendFullRangeUpdate();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEntryDetails(long l, CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray) {
        Map map = this.detailRequestsInProgress;
        synchronized (map) {
            CombiBAPPhonebookEntry combiBAPPhonebookEntry = (CombiBAPPhonebookEntry)this.detailRequestsInProgress.get(new Long(l));
            if (combiBAPPhonebookEntry != null) {
                this.logChannel.log(-2137614336, "[%1#setEntryDetails] set details for entryID: %2", (Object)this.className, l);
                combiBAPPhonebookEntry.setDetails(combiBAPPhonebookEntryDetailsArray);
                this.detailRequestsInProgress.remove(new Long(l));
                if (this.detailRequestsInProgress.isEmpty()) {
                    this.sendStatusRequest(this.pendingRequestResult);
                }
            } else {
                this.logChannel.log(-1601830656, "[%1#setEntryDetails] unknown entryID: %2", (Object)this.className, l);
            }
        }
    }

    @Override
    public int getPredecessorID(int n) {
        return 0;
    }

    @Override
    public int getSuccessorID(int n) {
        return 0;
    }

    static /* synthetic */ LogChannel access$000(PhonebookHandler phonebookHandler) {
        return phonebookHandler.logChannel;
    }

    static /* synthetic */ LogChannel access$100(PhonebookHandler phonebookHandler) {
        return phonebookHandler.logChannel;
    }

    static /* synthetic */ AbstractBAPModuleFSG access$200(PhonebookHandler phonebookHandler) {
        return phonebookHandler.moduleFsg;
    }

    static /* synthetic */ AbstractBAPModuleFSG access$300(PhonebookHandler phonebookHandler) {
        return phonebookHandler.moduleFsg;
    }
}

