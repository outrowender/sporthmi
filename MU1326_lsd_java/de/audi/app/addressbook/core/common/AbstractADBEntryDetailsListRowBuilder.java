/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public abstract class AbstractADBEntryDetailsListRowBuilder {
    public ADBEntryDetailsListRow createTelDetailsRow(AdbEntry adbEntry, int n) {
        if (adbEntry == null || adbEntry != null && ADBUtils.isEmpty(adbEntry.phoneData[n].number)) {
            return null;
        }
        return new ADBEntryDetailsListRow(0, adbEntry, n, null, null);
    }

    public ADBEntryDetailsListRow createTelDetailsEmptyRow(AdbEntry adbEntry) {
        return new ADBEntryDetailsListRow(3, adbEntry, -1, null, null);
    }

    public static boolean fillTelNumberList(AdbEntry adbEntry, BaseListModelApp baseListModelApp, AbstractADBEntryDetailsListRowBuilder abstractADBEntryDetailsListRowBuilder) {
        boolean bl = false;
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
            bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createTelDetailsRow(adbEntry, i2), baseListModelApp2);
        }
        baseListModelApp.update(baseListModelApp2);
        return bl;
    }

    public static ADBEntryDetailsListRow[] getTelDetailsRows(AdbEntry adbEntry, AbstractADBEntryDetailsListRowBuilder abstractADBEntryDetailsListRowBuilder) {
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
            AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createTelDetailsRow(adbEntry, i2), arrayList);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(abstractADBEntryDetailsListRowBuilder.createTelDetailsEmptyRow(adbEntry));
        }
        return (ADBEntryDetailsListRow[])arrayList.toArray(new ADBEntryDetailsListRow[arrayList.size()]);
    }

    public abstract ADBEntryDetailsListRow createAddressDetailsRow(AdbEntry var1, int var2);

    public ADBEntryDetailsListRow createAddressDetailsEmptyRow(AdbEntry adbEntry) {
        return new ADBEntryDetailsListRow(adbEntry, -1, null, null, null, null, null);
    }

    public static boolean fillAddressList(AdbEntry adbEntry, BaseListModelApp baseListModelApp, AbstractADBEntryDetailsListRowBuilder abstractADBEntryDetailsListRowBuilder) {
        boolean bl = false;
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 0), baseListModelApp2);
        bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 1), baseListModelApp2);
        bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 2), baseListModelApp2);
        bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 3), baseListModelApp2);
        bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 4), baseListModelApp2);
        baseListModelApp.update(baseListModelApp2);
        return bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 5), baseListModelApp2);
    }

    public static ADBEntryDetailsListRow[] getAddressDetailsRows(AdbEntry adbEntry, AbstractADBEntryDetailsListRowBuilder abstractADBEntryDetailsListRowBuilder) {
        ArrayList arrayList = new ArrayList(6);
        AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 0), arrayList);
        AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 1), arrayList);
        AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 2), arrayList);
        AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 3), arrayList);
        AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 4), arrayList);
        AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createAddressDetailsRow(adbEntry, 5), arrayList);
        if (arrayList.isEmpty()) {
            arrayList.add(abstractADBEntryDetailsListRowBuilder.createAddressDetailsEmptyRow(adbEntry));
        }
        return (ADBEntryDetailsListRow[])arrayList.toArray(new ADBEntryDetailsListRow[arrayList.size()]);
    }

    public ADBEntryDetailsListRow createEmailDetailsRow(AdbEntry adbEntry, int n) {
        if (ADBUtils.isEmpty(adbEntry.emailData[n].emailAddr)) {
            return null;
        }
        return new ADBEntryDetailsListRow(2, adbEntry, n, null, null);
    }

    public ADBEntryDetailsListRow createEmailDetailsEmptyRow(AdbEntry adbEntry) {
        return new ADBEntryDetailsListRow(5, adbEntry, -1, null, null);
    }

    public static boolean fillEmailList(AdbEntry adbEntry, BaseListModelApp baseListModelApp, AbstractADBEntryDetailsListRowBuilder abstractADBEntryDetailsListRowBuilder) {
        boolean bl = false;
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < adbEntry.emailData.length; ++i2) {
            bl |= AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createEmailDetailsRow(adbEntry, i2), baseListModelApp2);
        }
        baseListModelApp.update(baseListModelApp2);
        return bl;
    }

    public static ADBEntryDetailsListRow[] getEmailDetailsRows(AdbEntry adbEntry, AbstractADBEntryDetailsListRowBuilder abstractADBEntryDetailsListRowBuilder) {
        ArrayList arrayList = new ArrayList(3);
        for (int i2 = 0; i2 < adbEntry.emailData.length; ++i2) {
            AbstractADBEntryDetailsListRowBuilder.addNonNullRow(abstractADBEntryDetailsListRowBuilder.createEmailDetailsRow(adbEntry, i2), arrayList);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(abstractADBEntryDetailsListRowBuilder.createEmailDetailsEmptyRow(adbEntry));
        }
        return (ADBEntryDetailsListRow[])arrayList.toArray(new ADBEntryDetailsListRow[arrayList.size()]);
    }

    private static boolean addNonNullRow(ADBEntryDetailsListRow aDBEntryDetailsListRow, BaseListModelApp baseListModelApp) {
        if (aDBEntryDetailsListRow != null) {
            baseListModelApp.append(aDBEntryDetailsListRow);
            return true;
        }
        return false;
    }

    private static boolean addNonNullRow(ADBEntryDetailsListRow aDBEntryDetailsListRow, List list) {
        if (aDBEntryDetailsListRow != null) {
            list.add(aDBEntryDetailsListRow);
            return true;
        }
        return false;
    }
}

