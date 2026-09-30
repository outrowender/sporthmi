/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.phone.list.AbstractListAdapterFastListPhone;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListHandler;
import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListCombinedNumbers;
import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListCombinedNumbers;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataInitials;

public final class CombinedNumbersListAdapterFastList
extends AbstractListAdapterFastListPhone {
    private final IDSIFastListCombinedNumbers dsiFastListControllerCombinedNumbers = new DSIFastListCombinedNumbers();
    private volatile boolean pushListNotification = false;
    private volatile boolean currentListSizeNotification = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry;

    public CombinedNumbersListAdapterFastList(CombinedNumbersListHandler combinedNumbersListHandler) {
        super(combinedNumbersListHandler);
    }

    public int getDSIListID() {
        return 1;
    }

    public int[] getDSINotifications() {
        return new int[0];
    }

    public boolean sendFullRangeUpdate() {
        this.sendCurrentListSize();
        this.sendCurrentList();
        return false;
    }

    private void sendCurrentListSize() {
        this.logChannel.log(10000000, "[CombinedNumbersListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1)", this.currentListSizeNotification);
        if (this.currentListSizeNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((CombinedNumbersListHandler)this.listHandler).getManagedList();
            this.dsiFastListControllerCombinedNumbers.pushCurrentListSizeCombinedNumbers(combiBAPArrayElementArray.length);
        }
    }

    private void sendCurrentList() {
        this.logChannel.log(10000000, "[CombinedNumbersListAdapterFastList#sendCurrentList] called (pushListNotification=%1)", this.pushListNotification);
        if (this.pushListNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((CombinedNumbersListHandler)this.listHandler).getManagedList();
            this.dsiFastListControllerCombinedNumbers.pushCombinedNumbers(this.convertList(combiBAPArrayElementArray));
        }
    }

    private DataCombinedNumbers[] convertList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        DataCombinedNumbers[] dataCombinedNumbersArray = new DataCombinedNumbers[combiBAPArrayElementArray.length];
        for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
            dataCombinedNumbersArray[i2] = this.convertArrayElement(combiBAPArrayElementArray[i2]);
        }
        return dataCombinedNumbersArray;
    }

    private DataCombinedNumbers convertArrayElement(CombiBAPArrayElement combiBAPArrayElement) {
        DataCombinedNumbers dataCombinedNumbers = new DataCombinedNumbers();
        if (combiBAPArrayElement instanceof CombiBAPCallStackEntry) {
            CombiBAPCallStackEntry combiBAPCallStackEntry = (CombiBAPCallStackEntry)combiBAPArrayElement;
            dataCombinedNumbers.pos = combiBAPCallStackEntry.getPosID();
            dataCombinedNumbers.pbName = combiBAPCallStackEntry.getPbName();
            dataCombinedNumbers.numberType = combiBAPCallStackEntry.getNumberType();
            dataCombinedNumbers.callMode = combiBAPCallStackEntry.getCallMode();
            dataCombinedNumbers.telNumber = combiBAPCallStackEntry.getTelNumber();
            dataCombinedNumbers.day = combiBAPCallStackEntry.getDay();
            dataCombinedNumbers.month = combiBAPCallStackEntry.getMonth();
            dataCombinedNumbers.year = combiBAPCallStackEntry.getYear();
            dataCombinedNumbers.hour = combiBAPCallStackEntry.getHour();
            dataCombinedNumbers.minute = combiBAPCallStackEntry.getMinute();
            dataCombinedNumbers.second = combiBAPCallStackEntry.getSecond();
        } else {
            this.logChannel.log(10000, "[CombinedNumbersListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry == null ? (class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry = CombinedNumbersListAdapterFastList.class$("de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry")) : class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return dataCombinedNumbers;
    }

    public boolean isSpontaneousStatusRequestSupported() {
        return true;
    }

    public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
    }

    public void sendChangedArrayRequest(ListDelta listDelta) {
        this.sendFullRangeUpdate();
    }

    public void setNotificationFavoriteList(boolean bl) {
    }

    public void setNotificationCombinedNumbers(boolean bl) {
        this.pushListNotification = bl;
        if (bl) {
            this.sendCurrentList();
        }
    }

    public void setNotificationCurrentListSizes(boolean bl) {
        this.currentListSizeNotification = bl;
        if (bl) {
            this.sendCurrentListSize();
        }
    }

    public void addPhonebookJob(int n, int n2, ArrayHeader arrayHeader) {
    }

    public void addPhonebookJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
    }

    public IDSIController getDSIController() {
        return this.dsiFastListControllerCombinedNumbers;
    }

    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiFastListControllerCombinedNumbers.responseGetInitialsTelephone(n, n2, n3, dataInitialsArray);
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

