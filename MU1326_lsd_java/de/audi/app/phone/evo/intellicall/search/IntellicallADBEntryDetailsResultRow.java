/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.adb.TelADBUtils;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PersonalData;

public class IntellicallADBEntryDetailsResultRow
extends EvoListRow {
    private static final int ADB_DETAILS_ID_MASK = 65536;
    private final AdbEntry entry;
    private final int phoneNumberIdx;
    private final short phoneNumberType;
    private final String number;

    protected static int getUniqueID(int n) {
        return n + 1 | 0x10000;
    }

    public IntellicallADBEntryDetailsResultRow(AdbEntry adbEntry, int n) {
        super(IntellicallADBEntryDetailsResultRow.getUniqueID(n), 10);
        this.entry = adbEntry;
        this.phoneNumberIdx = n;
        this.number = adbEntry.phoneData[n].number;
        this.phoneNumberType = (short)adbEntry.phoneData[n].numberType;
        this.setInteger(0, 6);
        this.setInteger(8, ADBModelUtils.getIconTypeForPhoneNumber(this.phoneNumberType));
        this.setText(4, this.number);
        this.setPropertyCell(7, PropertyListCell.create(1110018462, this.getFocusProperties()));
    }

    protected final int[] getFocusProperties() {
        boolean bl = TelADBUtils.hasEmailAddress(this.entry);
        if (bl) {
            return new int[]{1014980486, -1571551967, 404371893};
        }
        return new int[]{1014980486, -1571551967};
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.entry.getCombinedName();
    }

    public AdbEntry getEntry() {
        return this.entry;
    }

    public long getAdbEntryId() {
        return this.entry.getEntryId();
    }

    public int getPhoneNumberIdx() {
        return this.phoneNumberIdx;
    }

    public short getPhoneNumberType() {
        return this.phoneNumberType;
    }

    public ResourceLocator getContactPicture() {
        PersonalData personalData;
        PersonalData personalData2 = personalData = this.entry == null ? null : this.entry.getPersonalData();
        if (personalData != null) {
            return personalData.getContactPicture();
        }
        return null;
    }

    public EvoListRow copy() {
        return new IntellicallADBEntryDetailsResultRow(this.entry, this.phoneNumberIdx);
    }
}

