/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.models;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.main.models.AddressBookEntryDetailsListRowBuilder;
import de.audi.app.addressbook.evo.common.search.ADBFocusPropertiesHelper;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.organizer.AdbEntry;

public class EntryDetailsListRowBuilder
extends AddressBookEntryDetailsListRowBuilder {
    protected AddressBookEvoApplication appAdr;

    public EntryDetailsListRowBuilder(AddressBookEvoApplication addressBookEvoApplication) {
        super(addressBookEvoApplication);
        this.appAdr = addressBookEvoApplication;
    }

    public ADBEntryDetailsListRow createTelDetailsRow(AdbEntry adbEntry, int n) {
        if (adbEntry == null || ADBUtils.isEmpty(adbEntry.phoneData[n].number)) {
            return null;
        }
        return new ADBEntryDetailsListRow(0, adbEntry, n, new PropertyListCell(141942996, ADBFocusPropertiesHelper.getFocusProperties(adbEntry)), new PropertyListCell(-96933400, ADBFocusPropertiesHelper.getFocusProperties(adbEntry)));
    }

    public ADBEntryDetailsListRow createAddressDetailsRow(AdbEntry adbEntry, int n) {
        int n2;
        String string;
        if (adbEntry == null) {
            this.appAdr.getLog().log(10000, "EntryDetailsListRowBuilder#createAddressDetailsRow(): AdbEntry is null!");
            return null;
        }
        int n3 = n == 0 || n == 2 || n == 4 ? 0 : 1;
        String[] stringArray = this.getAddressDisplayText(adbEntry.addressData[n3], n);
        this.appAdr.getLog().log(10000000, "EntryDetailsListRowBuilder#createAddressDetailsRow(): displayTexts for addressData %1 and addressType %3 are: %2", (Object)adbEntry.addressData[n3], (Object)stringArray, (long)n);
        if (stringArray == null) {
            return null;
        }
        String string2 = string = n == 1 || n == 0 ? "" : super.getAddressDisplayTextSingleLine(adbEntry.addressData[n3].navLocation);
        int n4 = n == 0 || n == 1 ? -1067138139 : (n2 = n == 2 || n == 3 ? 1373543104 : 965955193);
        int n5 = n == 0 || n == 1 ? -707656616 : (n == 2 || n == 3 ? -608304874 : -434835632);
        return new ADBEntryDetailsListRow(adbEntry, n, stringArray[0], stringArray[1], string, new PropertyListCell(n2, ADBFocusPropertiesHelper.getFocusProperties(adbEntry)), new PropertyListCell(n5, ADBFocusPropertiesHelper.getFocusProperties(adbEntry)));
    }

    public ADBEntryDetailsListRow createEmailDetailsRow(AdbEntry adbEntry, int n) {
        if (adbEntry == null || ADBUtils.isEmpty(adbEntry.emailData[n].emailAddr)) {
            return null;
        }
        return new ADBEntryDetailsListRow(2, adbEntry, n, new PropertyListCell(11009108, ADBFocusPropertiesHelper.getFocusProperties(adbEntry)), new PropertyListCell(-1432713326, ADBFocusPropertiesHelper.getFocusProperties(adbEntry)));
    }
}

