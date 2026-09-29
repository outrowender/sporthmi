/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.fw.arrays.AbstractArrayJobListMonitor;
import de.audi.app.bap.fw.arrays.ArrayJobHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone.list.AbstractListAdapterFastListPhone;
import de.audi.app.combi.bap.app.phone.list.PhonebookHandler;
import de.audi.app.combi.bap.app.phone.list.PhonebookListAdapterFastList$PhonebookJobListMonitor;
import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListPhoneBook;
import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhoneBook;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationFastList;
import de.audi.app.combi.bap.fw.arrays.fastlist.ArrayHeaderFastList;
import de.audi.app.combi.bap.fw.arrays.fastlist.ArrayUtilsFastList;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public final class PhonebookListAdapterFastList
extends AbstractListAdapterFastListPhone {
    private final IDSIFastListPhoneBook dsiFastListControllerPhoneBook = new DSIFastListPhoneBook();
    private final ArrayJobHandler jobHandler;
    private volatile boolean currentListSizeNotification = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry;

    public PhonebookListAdapterFastList(CombiModulePhone combiModulePhone, PhonebookHandler phonebookHandler) {
        super(phonebookHandler);
        this.jobHandler = new ArrayJobHandler(combiModulePhone, phonebookHandler);
    }

    @Override
    public int getDSIListID() {
        return 0;
    }

    @Override
    public int[] getDSINotifications() {
        return new int[0];
    }

    @Override
    public boolean sendFullRangeUpdate() {
        if (this.dsiFastListControllerPhoneBook != null) {
            this.sendCurrentListSize();
            this.dsiFastListControllerPhoneBook.responsePhoneBook(0, 0, this.listHandler.getCurrentListSize(), 1, ArrayUtilsFastList.createFullRangeUpdateArrayHeader(true));
        }
        return false;
    }

    private void sendCurrentListSize() {
        this.logChannel.log(-2137614336, "[PhonebookListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1)", this.currentListSizeNotification);
        if (this.currentListSizeNotification) {
            this.dsiFastListControllerPhoneBook.pushCurrentListSizePhoneBook(this.listHandler.getCurrentListSize());
        }
    }

    @Override
    public boolean isSpontaneousStatusRequestSupported() {
        return true;
    }

    @Override
    public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (getArrayIndication.getArrayHeader() instanceof ArrayHeaderFastList) {
            if (this.dsiFastListControllerPhoneBook != null) {
                int n;
                DataPhonebook[] dataPhonebookArray = new DataPhonebook[combiBAPArrayElementArray.length];
                for (n = 0; n < combiBAPArrayElementArray.length; ++n) {
                    dataPhonebookArray[n] = this.convertArrayElement(combiBAPArrayElementArray[n]);
                }
                n = this.jobHandler.isJobListActive() ? 2 : 0;
                this.dsiFastListControllerPhoneBook.responsePhoneBook(getArrayIndication.getAsgID(), getArrayIndication.getTaID(), this.listHandler.getCurrentListSize(), n, ((ArrayHeaderFastList)getArrayIndication.getArrayHeader()).getArrayHeader());
                this.dsiFastListControllerPhoneBook.responsePhoneBookArray(dataPhonebookArray);
            }
            this.jobHandler.notifyStatusReceived(getArrayIndication);
        }
    }

    private DataPhonebook convertArrayElement(CombiBAPArrayElement combiBAPArrayElement) {
        DataPhonebook dataPhonebook = new DataPhonebook();
        if (combiBAPArrayElement instanceof CombiBAPPhonebookEntry) {
            CombiBAPPhonebookEntry combiBAPPhonebookEntry = (CombiBAPPhonebookEntry)combiBAPArrayElement;
            dataPhonebook.pos = combiBAPPhonebookEntry.getPosID();
            dataPhonebook.pbName = combiBAPPhonebookEntry.getPbName();
            dataPhonebook.storagePb = combiBAPPhonebookEntry.getStorage();
            dataPhonebook.telNumberQuantity = combiBAPPhonebookEntry.getTelNumberQuantity();
            CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray = combiBAPPhonebookEntry.getDetails();
            if (combiBAPPhonebookEntryDetailsArray != null) {
                block12: for (int i2 = 0; i2 < combiBAPPhonebookEntryDetailsArray.length; ++i2) {
                    switch (i2 + 1) {
                        case 1: {
                            dataPhonebook.telNumber01 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType01 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 2: {
                            dataPhonebook.telNumber02 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType02 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 3: {
                            dataPhonebook.telNumber03 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType03 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 4: {
                            dataPhonebook.telNumber04 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType04 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 5: {
                            dataPhonebook.telNumber05 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType05 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 6: {
                            dataPhonebook.telNumber06 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType06 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 7: {
                            dataPhonebook.telNumber07 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType07 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 8: {
                            dataPhonebook.telNumber08 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType08 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 9: {
                            dataPhonebook.telNumber09 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType09 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        case 10: {
                            dataPhonebook.telNumber10 = combiBAPPhonebookEntryDetailsArray[i2].getTelNumber();
                            dataPhonebook.numberType10 = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                            continue block12;
                        }
                        default: {
                            this.logChannel.log(10000, "[PhonebookListAdapterFastList#convertArrayElement] max possible nunmber of details is 10");
                        }
                    }
                }
            }
        } else {
            this.logChannel.log(10000, "[PhonebookListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry == null ? (class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry = PhonebookListAdapterFastList.class$("de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry")) : class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry).getName(), (Object)super.getClass().getName());
        }
        return dataPhonebook;
    }

    @Override
    public void sendChangedArrayRequest(ListDelta listDelta) {
    }

    @Override
    public void setNotificationFavoriteList(boolean bl) {
    }

    @Override
    public void setNotificationCombinedNumbers(boolean bl) {
    }

    @Override
    public void setNotificationCurrentListSizes(boolean bl) {
        this.currentListSizeNotification = bl;
        if (bl) {
            this.sendCurrentListSize();
        }
    }

    @Override
    public void addPhonebookJob(int n, int n2, ArrayHeader arrayHeader) {
        this.jobHandler.addSingleJob(new GetArrayIndicationFastList(n, n2, new ArrayHeaderFastList(arrayHeader)));
    }

    @Override
    public void addPhonebookJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
        GetArrayIndication[] getArrayIndicationArray = new GetArrayIndication[arrayHeaderArray.length];
        for (int i2 = 0; i2 < arrayHeaderArray.length; ++i2) {
            getArrayIndicationArray[i2] = new GetArrayIndicationFastList(n, n2, new ArrayHeaderFastList(arrayHeaderArray[i2]));
        }
        this.jobHandler.addJobList(getArrayIndicationArray, (AbstractArrayJobListMonitor)new PhonebookListAdapterFastList$PhonebookJobListMonitor(this, this.logChannel));
    }

    @Override
    public IDSIController getDSIController() {
        return this.dsiFastListControllerPhoneBook;
    }

    @Override
    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.dsiFastListControllerPhoneBook.responseGetInitialsTelephone(n, n2, n3, dataInitialsArray);
    }

    static /* synthetic */ IDSIFastListPhoneBook access$000(PhonebookListAdapterFastList phonebookListAdapterFastList) {
        return phonebookListAdapterFastList.dsiFastListControllerPhoneBook;
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

