/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.adb;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.AbstractADBEntryDetailsListRowBuilder;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.organizer.AdbEntry;

public class TelEntryDetailsListRowBuilder
extends AbstractADBEntryDetailsListRowBuilder {
    @Override
    public ADBEntryDetailsListRow createTelDetailsRow(AdbEntry adbEntry, int n) {
        if (adbEntry != null && adbEntry.phoneData != null && adbEntry.phoneData[n] != null && ADBUtils.isEmpty(adbEntry.phoneData[n].number)) {
            return null;
        }
        PropertyListCell propertyListCell = PropertyListCell.create(-1635178174, new int[]{-2040561860});
        return new ADBEntryDetailsListRow(0, adbEntry, n, propertyListCell, null);
    }

    @Override
    public ADBEntryDetailsListRow createAddressDetailsRow(AdbEntry adbEntry, int n) {
        return null;
    }
}

