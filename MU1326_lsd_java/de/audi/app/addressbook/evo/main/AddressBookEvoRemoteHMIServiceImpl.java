/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBRemoteHMIAddress;
import de.audi.atip.interapp.ADBRemoteHMIService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AddressData;

public class AddressBookEvoRemoteHMIServiceImpl
implements ADBRemoteHMIService {
    private LogChannel log;

    public AddressBookEvoRemoteHMIServiceImpl(AddressBookEvoApplication addressBookEvoApplication) {
        this.log = addressBookEvoApplication.getLog();
    }

    public int[] getListModelIDs() {
        return new int[]{700594, 700595};
    }

    public ADBRemoteHMIAddress getAddress(EvoListRow evoListRow) {
        if (evoListRow == null || !(evoListRow instanceof ADBEntryDetailsListRow)) {
            this.log.log(10000, "AddressBookEvoRemoteHMIServiceImpl#getAddress(): invalid row: %1", (Object)evoListRow);
            return null;
        }
        ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
        if (!this.isValidAddressType(aDBEntryDetailsListRow.getAddressType())) {
            this.log.log(10000, "AddressBookEvoRemoteHMIServiceImpl#getAddress(): invalid addressType: %1", (long)aDBEntryDetailsListRow.getAddressType());
            return null;
        }
        AddressData addressData = aDBEntryDetailsListRow.getEntry().getAddressData()[aDBEntryDetailsListRow.getAddressIndex()];
        ADBRemoteHMIAddress aDBRemoteHMIAddress = this.getRHMIAddress(addressData, aDBEntryDetailsListRow.getAddressType());
        this.log.log(1000000, "AddressBookEvoRemoteHMIServiceImpl#getAddress(): returning ADBRemoteHMIAddress: %1", (Object)aDBRemoteHMIAddress);
        return aDBRemoteHMIAddress;
    }

    private boolean isValidAddressType(int n) {
        return n == 2 || n == 3 || n == 4 || n == 5;
    }

    private ADBRemoteHMIAddress getRHMIAddress(AddressData addressData, int n) {
        if (addressData != null) {
            String[] stringArray;
            if (n == 2 || n == 3) {
                return new ADBRemoteHMIAddress(addressData.navLocation);
            }
            if ((n == 4 || n == 5) && (stringArray = ADBAddressUtils.vCardGeoPosToDegrees(addressData.geoPosition)) != null && stringArray.length == 2) {
                return new ADBRemoteHMIAddress(stringArray[1], stringArray[0]);
            }
            return null;
        }
        this.log.log(1000000, "AddressBookEvoRemoteHMIServiceImpl#getRHMIAddress(): null AddressData passed to the method");
        return null;
    }
}

