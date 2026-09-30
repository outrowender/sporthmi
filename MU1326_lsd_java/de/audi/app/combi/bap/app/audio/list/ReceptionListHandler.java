/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.arrays.ArrayUtils;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.DABReceptionList;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationReceptionList;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionListType_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_Status;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;

public class ReceptionListHandler
extends AbstractManagedListHandler {
    private static final int ERROR_CODE_PARAMETER_MISMATCH = 69;
    private final Object mutex = new Object();
    private int matchingDABListPartSize;
    private final DABReceptionList dabReceptionList = new DABReceptionList(this.logChannel, this.className);
    private boolean dabStationSortingChanged = false;
    private boolean dabSortAlphabetically = false;
    private volatile CombiBAPArrayElement[] deferredNewList;

    protected ReceptionListHandler(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio, "ReceptionListHandler");
        combiModuleAudio.getPictureManager().registerPictureProvider(1, new StationArtProvider());
    }

    public int getNumberOfElements() {
        return this.getListType() == 3 ? this.getMatchingDABListPartSize() : this.getCurrentListSize();
    }

    public boolean isDABSortAlphabetically() {
        return this.dabSortAlphabetically;
    }

    public void updateReceptionList(int n, CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
        this.logChannel.log(10000000, "[%1#updateReceptionList] listType=%2, listSize=%3", (Object)this.className, (long)n, (long)combiBAPReceptionListEntryArray.length);
        this.updateReceptionListType(n);
        this.dabReceptionList.clear();
        if (n == 3) {
            this.dabReceptionList.buildDABListStructure(combiBAPReceptionListEntryArray);
            this.updateDABStationSorting();
        } else {
            for (int i2 = 0; i2 < combiBAPReceptionListEntryArray.length; ++i2) {
                CombiBAPReceptionListEntry combiBAPReceptionListEntry = combiBAPReceptionListEntryArray[i2];
                combiBAPReceptionListEntry.setAbsPos(i2 + 1);
            }
        }
        this.updateList(combiBAPReceptionListEntryArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        this.logChannel.log(10000000, "[%1#updateList] receptionListSize=%2", (Object)this.className, (long)combiBAPArrayElementArray.length);
        boolean bl = this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 0 || this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 2 || this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 5;
        SourceState_Status sourceState_Status = (SourceState_Status)this.moduleFsg.getBAPFunctionPropertyFSG(20).getLastStatus();
        boolean bl2 = sourceState_Status.stateInfo == 5;
        ListDelta listDelta = ListDelta.compare(this.getManagedList(), combiBAPArrayElementArray);
        if (bl) {
            this.logChannel.log(10000000, "[%1#updateList] function sync %2 is opened", (Object)this.className, (long)this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType());
            Object object = this.mutex;
            synchronized (object) {
                if (!listDelta.isUnchanged() || this.deferredNewList != null) {
                    this.deferredNewList = combiBAPArrayElementArray;
                    this.logChannel.log(10000000, "[%1#updateList] source change in progress, request deferred. New list:\n%2", (Object)this.className, (Object)this.deferredListToString());
                }
            }
        }
        if (bl2) {
            Object object = this.mutex;
            synchronized (object) {
                if (!listDelta.isUnchanged() || this.deferredNewList != null) {
                    this.deferredNewList = combiBAPArrayElementArray;
                    this.logChannel.log(10000000, "[%1#updateList] manual tuning active, request deferred. New list:\n%2", (Object)this.className, (Object)this.deferredListToString());
                }
            }
        }
        Object object = this.mutex;
        synchronized (object) {
            this.list = combiBAPArrayElementArray;
            this.deferredNewList = null;
        }
        if (this.dabStationSortingChanged) {
            this.sendFullRangeUpdate();
            this.dabStationSortingChanged = false;
        } else {
            this.sendChangedArrayRequest(listDelta);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updateDeferredList(boolean bl) {
        this.logChannel.log(10000000, "[%1#updateDeferredList] forceFullRangeUpdate=%2", (Object)this.className, (Object)bl);
        Object object = this.mutex;
        synchronized (object) {
            boolean bl2 = true;
            if (this.deferredNewList == null) {
                this.logChannel.log(10000000, "[%1#updateDeferredList] no deferred updates", (Object)this.className);
                if (bl) {
                    this.sendFullRangeUpdate();
                } else {
                    bl2 = false;
                }
            } else if (bl) {
                this.list = this.deferredNewList;
                this.deferredNewList = null;
                this.sendFullRangeUpdate();
            } else {
                ListDelta listDelta = ListDelta.compare(this.getManagedList(), this.deferredNewList);
                this.list = this.deferredNewList;
                this.deferredNewList = null;
                bl2 = this.sendChangedArrayRequest(listDelta);
            }
            return bl2;
        }
    }

    private String deferredListToString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.deferredNewList.length; ++i2) {
            buffer.append(this.deferredNewList[i2]);
            buffer.append('\n');
        }
        return buffer.toString();
    }

    public void requestListElements(GetArrayIndication getArrayIndication) {
        if (getArrayIndication instanceof GetArrayIndicationReceptionList) {
            int n = ((GetArrayIndicationReceptionList)getArrayIndication).getElementType();
            this.logChannel.log(10000000, "[%1#requestListElements] called (taID=%2)", (Object)this.className, (long)getArrayIndication.getTaID());
            if (this.getListType() == 3) {
                this.handleDABListRequest((GetArrayIndicationReceptionList)getArrayIndication);
            } else if (this.getListType() == 6) {
                super.requestListElements(getArrayIndication);
            } else if (n == 5) {
                super.requestListElements(getArrayIndication);
            } else {
                this.logChannel.log(10000, "[%1#requestListElements] invalid elementType (=%2). Must be %3", (Object)this.className, (long)n, 5L);
                this.setPendingRequest(getArrayIndication);
                this.sendEmptyList();
            }
        } else {
            super.requestListElements(getArrayIndication);
        }
    }

    private void updateDABStationSorting() {
        this.dabSortAlphabetically = this.dabReceptionList.isEmpty();
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(14);
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (fSG_Setup_Status.setup_Extensions.dabServiceSortedList != this.dabSortAlphabetically) {
            this.dabStationSortingChanged = true;
            this.logChannel.log(10000000, "[%1#updateDABStationSorting] DAB station list is sorted %2", (Object)this.className, (Object)(this.dabSortAlphabetically ? "alphabetically" : "by ensemble"));
            fSG_Setup_Status.setup_Extensions.dabServiceSortedList = this.dabSortAlphabetically;
            bAPFunctionPropertyFSG.sendStatus(fSG_Setup_Status);
        }
    }

    private void updateReceptionListType(int n) {
        this.logChannel.log(10000000, "[%1#updateReceptionListType] called", (Object)this.className);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(31);
        ReceptionListType_Status receptionListType_Status = new ReceptionListType_Status();
        receptionListType_Status.type = n;
        bAPFunctionPropertyFSG.sendStatusIfChanged(receptionListType_Status);
    }

    private void handleDABListRequest(GetArrayIndicationReceptionList getArrayIndicationReceptionList) {
        CombiBAPArrayElement[] combiBAPArrayElementArray;
        Object object;
        List list;
        block14: {
            int n;
            int n2;
            block13: {
                this.setPendingRequest(getArrayIndicationReceptionList);
                n2 = getArrayIndicationReceptionList.getElementType();
                n = getArrayIndicationReceptionList.getParentID();
                if (!this.dabSortAlphabetically) break block13;
                switch (n2) {
                    case 2: {
                        list = this.dabReceptionList.getDABServiceList(n, true);
                        break block14;
                    }
                    case 3: 
                    case 4: {
                        list = this.dabReceptionList.getDABFlatList(false, true, true);
                        break block14;
                    }
                    case 0: 
                    case 1: 
                    case 5: {
                        this.logChannel.log(10000, "[%1#handleDABListRequest] unsupported elementType for service sorted list (%2)", (Object)this.className, (long)n2);
                        this.abortRequestWithBAPError(getArrayIndicationReceptionList, 69);
                        return;
                    }
                    default: {
                        this.logChannel.log(10000, "[%1#handleDABListRequest] invalid elementType (%2)", (Object)this.className, (long)n2);
                        this.abortRequestWithBAPError(getArrayIndicationReceptionList, 65);
                        return;
                    }
                }
            }
            switch (n2) {
                case 0: {
                    list = this.dabReceptionList.getDABFlatList(true, false, false);
                    break;
                }
                case 2: {
                    list = this.dabReceptionList.getDABServiceList(n, true);
                    break;
                }
                case 3: {
                    list = this.dabReceptionList.getDABFlatList(true, true, true);
                    break;
                }
                case 1: 
                case 4: 
                case 5: {
                    this.logChannel.log(10000, "[%1#handleDABListRequest] unsupported elementType for ensemble sorted list (%2)", (Object)this.className, (long)n2);
                    this.abortRequestWithBAPError(getArrayIndicationReceptionList, 69);
                    return;
                }
                default: {
                    this.logChannel.log(10000, "[%1#handleDABListRequest] invalid elementType (%2)", (Object)this.className, (long)n2);
                    this.abortRequestWithBAPError(getArrayIndicationReceptionList, 65);
                    return;
                }
            }
        }
        if (this.logChannel.getCurrentLogThreshold() >= 10000000) {
            object = new Buffer();
            combiBAPArrayElementArray = list.iterator();
            while (combiBAPArrayElementArray.hasNext()) {
                ((Buffer)object).append(combiBAPArrayElementArray.next());
                ((Buffer)object).append('\n');
            }
            this.logChannel.log(10000000, "[%1#handleDABListRequest] matching DAB list part:\n%2", (Object)this.className, object);
        }
        this.matchingDABListPartSize = list.size();
        object = getArrayIndicationReceptionList.getArrayHeader();
        combiBAPArrayElementArray = ArrayUtils.getListSection(this.logChannel, list, object.getStart(), object.getNumberOfElements(), object.isModeShift(), object.isModeArrayDirectionBackward());
        this.responseListElements(getArrayIndicationReceptionList.getTaID(), combiBAPArrayElementArray);
    }

    private void abortRequestWithBAPError(GetArrayIndicationReceptionList getArrayIndicationReceptionList, int n) {
        this.logChannel.log(10000000, "[ReceptionListHandler#abortRequestWithBAPError]");
        this.clearPendingRequest();
        getArrayIndicationReceptionList.abortWithBAPError(n);
    }

    protected int getListType() {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(31);
        return ((ReceptionListType_Status)bAPFunctionPropertyFSG.getLastStatus()).type;
    }

    private int getMatchingDABListPartSize() {
        return this.matchingDABListPartSize;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CombiBAPArrayElement getArrayElement(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.deferredNewList != null) {
                for (int i2 = 0; i2 < this.deferredNewList.length; ++i2) {
                    if (this.deferredNewList[i2].getPosID() != n) continue;
                    return this.deferredNewList[i2];
                }
            }
        }
        return super.getArrayElement(n);
    }

    public void getNextListPos(int n, int n2) {
        super.getNextListPosForArbitraryIds(n, n2);
    }

    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        ((CombiModuleAudio)this.moduleFsg).getTunerService().getNextListPosResult(bl ? 0 : 1, n, n2, n3);
    }

    public List getDABFlatList(boolean bl, boolean bl2, boolean bl3) {
        return this.dabReceptionList.getDABFlatList(bl, bl2, bl3);
    }

    public List getDABServiceList(int n, boolean bl) {
        return this.dabReceptionList.getDABServiceList(n, bl);
    }

    private class StationArtProvider
    implements IPictureProvider {
        private StationArtProvider() {
        }

        public void requestPicture(long l) {
            this.requestPicture(l, 255);
        }

        public void requestPicture(long l, int n) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)ReceptionListHandler.this.getArrayElement((int)l);
            if (combiBAPReceptionListEntry != null) {
                String string = combiBAPReceptionListEntry.getPictureURL();
                ResourceLocator resourceLocator = string == null ? new ResourceLocator(-1) : new ResourceLocator(string);
                ((AbstractCombiModule)ReceptionListHandler.this.moduleFsg).getPictureManager().responseStationArt(l, n, resourceLocator, false);
            } else {
                ReceptionListHandler.this.logChannel.log(100000, "[%1.StationArtProvider#requestPicture] no entry available for entryID: %2", (Object)ReceptionListHandler.this.className, l);
                ((AbstractCombiModule)ReceptionListHandler.this.moduleFsg).getPictureManager().responseStationArt(l, n, null, false);
            }
        }
    }
}

