/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.audio.list.AbstractListAdapterFastListAudio;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.dsi.fastlist.audio.DSIFastListReceptionList;
import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListReceptionList;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public final class ReceptionListAdapterFastList
extends AbstractListAdapterFastListAudio {
    private final IDSIFastListReceptionList dsiFastListControllerReceptionList = new DSIFastListReceptionList();
    private volatile boolean pushListNotification = false;
    private volatile boolean currentListSizeNotification = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry;

    public ReceptionListAdapterFastList(ReceptionListHandler receptionListHandler) {
        super(receptionListHandler);
    }

    private DataReceptionList[] convertList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        DataReceptionList[] dataReceptionListArray = new DataReceptionList[combiBAPArrayElementArray.length];
        for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
            dataReceptionListArray[i2] = this.convertArrayElement(combiBAPArrayElementArray[i2]);
        }
        return dataReceptionListArray;
    }

    private DataReceptionList convertArrayElement(CombiBAPArrayElement combiBAPArrayElement) {
        DataReceptionList dataReceptionList = new DataReceptionList();
        if (combiBAPArrayElement instanceof CombiBAPReceptionListEntry) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)combiBAPArrayElement;
            dataReceptionList.pos = combiBAPReceptionListEntry.getPosID();
            dataReceptionList.type = combiBAPReceptionListEntry.getType();
            dataReceptionList.attributes = combiBAPReceptionListEntry.getAttributes();
            dataReceptionList.presetID = combiBAPReceptionListEntry.getPresetID();
            dataReceptionList.fmREGCode = combiBAPReceptionListEntry.getFmRegionCode();
            dataReceptionList.category = combiBAPReceptionListEntry.getCategory();
            dataReceptionList.nameReceptionList = combiBAPReceptionListEntry.getName();
            dataReceptionList.frequency = combiBAPReceptionListEntry.getFrequency();
        } else {
            this.logChannel.log(10000, "[ReceptionListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry = ReceptionListAdapterFastList.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry).getName(), (Object)super.getClass().getName());
        }
        return dataReceptionList;
    }

    private void sendCurrentListSize() {
        this.logChannel.log(-2137614336, "[ReceptionListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1)", this.currentListSizeNotification);
        if (this.currentListSizeNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((ReceptionListHandler)this.listHandler).getManagedList();
            this.dsiFastListControllerReceptionList.pushCurrentListSizeReceptionList(combiBAPArrayElementArray.length);
        }
    }

    private void sendCurrentList() {
        this.logChannel.log(-2137614336, "[ReceptionListAdapterFastList#sendCurrentList] called (pushListNotification=%1)", this.pushListNotification);
        if (this.pushListNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((ReceptionListHandler)this.listHandler).getManagedList();
            this.dsiFastListControllerReceptionList.pushReceptionList(this.convertList(combiBAPArrayElementArray));
        }
    }

    @Override
    public boolean sendFullRangeUpdate() {
        this.sendCurrentListSize();
        this.sendCurrentList();
        return false;
    }

    @Override
    public boolean isSpontaneousStatusRequestSupported() {
        return true;
    }

    @Override
    public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
    }

    @Override
    public void sendChangedArrayRequest(ListDelta listDelta) {
        this.sendFullRangeUpdate();
    }

    @Override
    public void setNotificationReceptionList(boolean bl) {
        this.pushListNotification = bl;
        if (bl) {
            this.sendCurrentList();
        }
    }

    @Override
    public void setNotificationCurrentListSizes(boolean bl) {
        this.currentListSizeNotification = bl;
        if (bl) {
            this.sendCurrentListSize();
        }
    }

    @Override
    public void addMediaBrowserJob(int n, int n2, ArrayHeader arrayHeader) {
    }

    @Override
    public void addMediaBrowserJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
    }

    @Override
    public int[] getDSINotifications() {
        return new int[0];
    }

    @Override
    public IDSIController getDSIController() {
        return this.dsiFastListControllerReceptionList;
    }

    @Override
    public int getDSIListID() {
        return -1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

