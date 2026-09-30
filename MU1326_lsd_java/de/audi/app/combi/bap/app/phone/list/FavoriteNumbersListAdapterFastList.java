/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.phone.list.AbstractListAdapterFastListPhone;
import de.audi.app.combi.bap.app.phone.list.FavoriteNumbersListHandler;
import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListFavoriteNumbers;
import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListFavoriteNumbers;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPFavoriteNumberEntry;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;

public final class FavoriteNumbersListAdapterFastList
extends AbstractListAdapterFastListPhone {
    private final IDSIFastListFavoriteNumbers dsiFastListControllerFavoriteNumbers = new DSIFastListFavoriteNumbers();
    private volatile boolean pushListNotification = false;
    private volatile boolean currentListSizeNotification = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPFavoriteNumberEntry;

    public FavoriteNumbersListAdapterFastList(FavoriteNumbersListHandler favoriteNumbersListHandler) {
        super(favoriteNumbersListHandler);
    }

    public int getDSIListID() {
        return 3;
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
        this.logChannel.log(10000000, "[FavoriteNumbersListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1)", this.currentListSizeNotification);
        if (this.currentListSizeNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((FavoriteNumbersListHandler)this.listHandler).getManagedList();
            this.dsiFastListControllerFavoriteNumbers.pushCurrentListSizeFavoriteNumbers(combiBAPArrayElementArray.length);
        }
    }

    private void sendCurrentList() {
        this.logChannel.log(10000000, "[FavoriteNumbersListAdapterFastList#sendCurrentList] called (pushListNotification=%1)", this.pushListNotification);
        if (this.pushListNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((FavoriteNumbersListHandler)this.listHandler).getManagedList();
            this.dsiFastListControllerFavoriteNumbers.pushupdateFavoriteNumbers(this.convertList(combiBAPArrayElementArray));
        }
    }

    private DataFavoriteList[] convertList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        DataFavoriteList[] dataFavoriteListArray = new DataFavoriteList[combiBAPArrayElementArray.length];
        for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
            dataFavoriteListArray[i2] = this.convertArrayElement(combiBAPArrayElementArray[i2]);
        }
        return dataFavoriteListArray;
    }

    private DataFavoriteList convertArrayElement(CombiBAPArrayElement combiBAPArrayElement) {
        DataFavoriteList dataFavoriteList = new DataFavoriteList();
        if (combiBAPArrayElement instanceof CombiBAPFavoriteNumberEntry) {
            CombiBAPFavoriteNumberEntry combiBAPFavoriteNumberEntry = (CombiBAPFavoriteNumberEntry)combiBAPArrayElement;
            dataFavoriteList.pos = combiBAPFavoriteNumberEntry.getPosID();
            dataFavoriteList.pbName = combiBAPFavoriteNumberEntry.getName();
            dataFavoriteList.numberType = combiBAPFavoriteNumberEntry.getNumberType();
            dataFavoriteList.telNumber = combiBAPFavoriteNumberEntry.getTelNumber();
        } else {
            this.logChannel.log(10000, "[FavoriteNumbersListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPFavoriteNumberEntry == null ? (class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPFavoriteNumberEntry = FavoriteNumbersListAdapterFastList.class$("de.audi.atip.interapp.combi.bap.phone.data.CombiBAPFavoriteNumberEntry")) : class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPFavoriteNumberEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return dataFavoriteList;
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
        this.pushListNotification = bl;
        if (bl) {
            this.sendCurrentList();
        }
    }

    public void setNotificationCombinedNumbers(boolean bl) {
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
        return this.dsiFastListControllerFavoriteNumbers;
    }

    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiFastListControllerFavoriteNumbers.responseGetInitialsTelephone(n, n2, n3, dataInitialsArray);
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

