/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.preset;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.app.addressbook.evo.main.preset.GetPresetTelNumberCommand;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;

public class AddressBookEvoPresetHandler
implements IAppPresetDefinitionHandler {
    private AddressBookEvoApplication appAdr;
    private LogChannel log;
    private Object getPresetTelNumberLock = new Object();
    private PhoneData getPresetTelNumberData = null;
    private static final int[] SUPPORTED_MODEL_IDS = new int[]{700595, 700594, 700525, 700527};

    public AddressBookEvoPresetHandler(AddressBookEvoApplication addressBookEvoApplication, LogChannel logChannel) {
        this.appAdr = addressBookEvoApplication;
        this.log = logChannel;
    }

    public AddressBookEvoApplication getAppAdr() {
        return this.appAdr;
    }

    public int getType() {
        return 1;
    }

    public int[] getModelIds() {
        return SUPPORTED_MODEL_IDS;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestDefinition(DefinitionRequest definitionRequest) {
        if (definitionRequest == null) {
            this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): request is null.");
            return;
        }
        EvoListRow evoListRow = this.appAdr.getHMIService().getBaseListModel(definitionRequest.getModelId()).getRow(definitionRequest.getRowId());
        if (evoListRow == null) {
            this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): row is null.");
            return;
        }
        if (evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            AdbEntry adbEntry = aDBEntryDetailsListRow.getEntry();
            if (adbEntry == null) {
                this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): adbEntry is null.");
                return;
            }
            int n = aDBEntryDetailsListRow.getDataIndex();
            if (aDBEntryDetailsListRow.getDataType() == 0) {
                this.appAdr.getPhoneGateway().definePreset(definitionRequest, adbEntry.phoneData[n].number, adbEntry.getCombinedName(), adbEntry.phoneData[n].numberType);
            } else if (aDBEntryDetailsListRow.getDataType() == 1) {
                switch (aDBEntryDetailsListRow.getAddressType()) {
                    case 2: {
                        this.appAdr.getNaviGateway().definePreset(definitionRequest, adbEntry.addressData[0].navLocation, adbEntry.getCombinedName());
                        break;
                    }
                    case 3: {
                        this.appAdr.getNaviGateway().definePreset(definitionRequest, adbEntry.addressData[1].navLocation, adbEntry.getCombinedName());
                        break;
                    }
                    case 4: {
                        String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                        if (stringArray == null || stringArray.length != 2) {
                            this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): invalid business geo position.");
                            definitionRequest.responseDefine(2, null, null, 99);
                            break;
                        }
                        this.appAdr.getNaviGateway().definePreset(definitionRequest, stringArray[1], stringArray[0], adbEntry.getCombinedName());
                        break;
                    }
                    case 5: {
                        String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                        if (stringArray == null || stringArray.length != 2) {
                            this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): invalid private geo position.");
                            definitionRequest.responseDefine(2, null, null, 99);
                            break;
                        }
                        this.appAdr.getNaviGateway().definePreset(definitionRequest, stringArray[1], stringArray[0], adbEntry.getCombinedName());
                        break;
                    }
                    default: {
                        this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): no navi preset handling available for address type %1.", (long)aDBEntryDetailsListRow.getAddressType());
                        definitionRequest.responseDefine(2, null, null, 99);
                        break;
                    }
                }
            } else {
                this.log.log(1000000, "AddressBookEvoPresetHandler#requestDefinition(): unsupported data type: %1", (long)aDBEntryDetailsListRow.getDataType());
                definitionRequest.responseDefine(2, null, null, 99);
            }
        } else if (evoListRow instanceof ADBSearchListRow && this.appAdr.getAdbMode() == 0 && ((ADBSearchListRow)((Object)evoListRow)).getPhoneCount() == 1) {
            PhoneData phoneData;
            Object object = this.getPresetTelNumberLock;
            synchronized (object) {
                this.getPresetTelNumberData = null;
                GetPresetTelNumberCommand.createGetPresetTelNumberCommand(this, ((ADBSearchListRow)((Object)evoListRow)).getEntryId());
                try {
                    this.getPresetTelNumberLock.wait(500L);
                }
                catch (InterruptedException interruptedException) {
                    this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): InterruptedException e: %1", (Throwable)interruptedException);
                }
                phoneData = this.getPresetTelNumberData;
            }
            if (phoneData != null) {
                this.log.log(1000000, "AddressBookEvoPresetHandler#requestDefinition(): storing single phone number \"%1\" of entry \"%2\" as preset.", (Object)phoneData.number, (Object)((ADBSearchListRow)((Object)evoListRow)).getCombinedName());
                this.appAdr.getPhoneGateway().definePreset(definitionRequest, phoneData.number, ((ADBSearchListRow)((Object)evoListRow)).getCombinedName(), phoneData.numberType);
            } else {
                this.log.log(10000, "AddressBookEvoPresetHandler#requestDefinition(): failed to retreive single phone number of entry \"%1\"!", (Object)((ADBSearchListRow)((Object)evoListRow)).getCombinedName());
                definitionRequest.responseDefine(2, null, null, 99);
            }
        } else {
            this.log.log(1000000, "AddressBookEvoPresetHandler#requestDefinition(): unsupported row type of row: %1", (Object)evoListRow);
            definitionRequest.responseDefine(3, null, null, 99);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPresetTelNumberData(PhoneData phoneData) {
        Object object = this.getPresetTelNumberLock;
        synchronized (object) {
            this.getPresetTelNumberData = phoneData;
            this.getPresetTelNumberLock.notifyAll();
        }
    }
}

