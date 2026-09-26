/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBListRow;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;

public final class ADBEntryDetailsListRow
extends EvoListRow
implements ADBListRow {
    private AdbEntry adbEntry;
    private int dataIndex;
    private static final String ADDRESS_LINE_SEPARATOR_COMMA;
    private static final String ADDRESS_LINE_SEPARATOR_SPACE;

    public ADBEntryDetailsListRow(int n, AdbEntry adbEntry, int n2, PropertyListCell propertyListCell, PropertyListCell propertyListCell2) {
        super(ADBEntryDetailsListRow.getUniqueIdForDetailsRow(n, n2), 11);
        this.adbEntry = adbEntry;
        this.dataIndex = n2;
        switch (n) {
            case 0: {
                this.setInteger(0, 1);
                this.setInteger(1, 0);
                this.setInteger(2, ADBModelUtils.getIconTypeForPhoneNumber(adbEntry.phoneData[n2].numberType));
                this.setText(3, adbEntry.phoneData[n2].number);
                this.setPropertyCell(4, propertyListCell);
                this.setPropertyCell(5, propertyListCell2);
                break;
            }
            case 3: {
                this.setInteger(0, 1);
                this.setInteger(1, 3);
                break;
            }
            case 2: {
                this.setInteger(0, 1);
                this.setInteger(1, 2);
                this.setInteger(2, 0);
                this.setText(3, adbEntry.emailData[n2].emailAddr);
                this.setPropertyCell(4, propertyListCell);
                this.setPropertyCell(5, propertyListCell2);
                break;
            }
            case 5: {
                this.setInteger(0, 1);
                this.setInteger(1, 5);
                break;
            }
        }
    }

    public ADBEntryDetailsListRow(AdbEntry adbEntry, int n, String string, String string2, String string3, String string4, PropertyListCell propertyListCell, PropertyListCell propertyListCell2) {
        super(ADBEntryDetailsListRow.getUniqueIdForDetailsRow(n == -1 ? 4 : 1, n), 11);
        this.adbEntry = adbEntry;
        this.dataIndex = n;
        if (n != -1) {
            String string5;
            String string6 = ADBUtils.isEmpty(string) ? string2 : string;
            String string7 = string5 = ADBUtils.isEmpty(string) ? "" : string2;
            String string8 = ADBUtils.isEmpty(string3) ? new StringBuffer().append(string6).append(ADBUtils.isEmpty(string5) ? "" : string4).append(string5).toString() : string3;
            this.setInteger(0, 1);
            this.setInteger(1, 1);
            this.setInteger(2, n);
            this.setText(3, string6);
            this.setPropertyCell(4, propertyListCell);
            this.setPropertyCell(5, propertyListCell2);
            this.setText(7, string5);
            this.setInteger(9, ADBUtils.isEmpty(string5) ? 0 : 1);
            this.setText(10, string8);
        } else {
            this.setInteger(0, 1);
            this.setInteger(1, 4);
        }
    }

    public ADBEntryDetailsListRow(AdbEntry adbEntry, int n, String string, String string2, String string3, PropertyListCell propertyListCell, PropertyListCell propertyListCell2) {
        this(adbEntry, n, string, string2, string3, ", ", propertyListCell, propertyListCell2);
    }

    public ADBEntryDetailsListRow(AdbEntry adbEntry, int n, String string, String string2, String string3, boolean bl) {
        this(adbEntry, n, string, string2, string3, bl ? " " : ", ", null, null);
    }

    private ADBEntryDetailsListRow(ADBEntryDetailsListRow aDBEntryDetailsListRow) {
        super(aDBEntryDetailsListRow.getUniqueID(), 11);
        this.adbEntry = aDBEntryDetailsListRow.getEntry();
        this.dataIndex = aDBEntryDetailsListRow.getDataIndex();
        if (aDBEntryDetailsListRow.getCell(0) != null) {
            this.setInteger(0, aDBEntryDetailsListRow.getInteger(0));
        }
        if (aDBEntryDetailsListRow.getCell(1) != null) {
            this.setInteger(1, aDBEntryDetailsListRow.getInteger(1));
        }
        if (aDBEntryDetailsListRow.getCell(2) != null) {
            this.setInteger(2, aDBEntryDetailsListRow.getInteger(2));
        }
        if (aDBEntryDetailsListRow.getCell(3) != null) {
            this.setText(3, aDBEntryDetailsListRow.getText(3));
        }
        if (aDBEntryDetailsListRow.getCell(4) != null) {
            this.setPropertyCell(4, (PropertyListCell)aDBEntryDetailsListRow.getCell(4));
        }
        if (aDBEntryDetailsListRow.getCell(5) != null) {
            this.setPropertyCell(5, (PropertyListCell)aDBEntryDetailsListRow.getCell(5));
        }
        if (aDBEntryDetailsListRow.getCell(7) != null) {
            this.setText(7, aDBEntryDetailsListRow.getText(7));
        }
        if (aDBEntryDetailsListRow.getCell(9) != null) {
            this.setInteger(9, aDBEntryDetailsListRow.getInteger(9));
        }
        if (aDBEntryDetailsListRow.getCell(10) != null) {
            this.setText(10, aDBEntryDetailsListRow.getText(10));
        }
    }

    @Override
    public EvoListRow copy() {
        return new ADBEntryDetailsListRow(this);
    }

    public AdbEntry getEntry() {
        return this.adbEntry;
    }

    @Override
    public long getEntryId() {
        return this.adbEntry.entryId;
    }

    @Override
    public String getCombinedName() {
        return this.adbEntry.getCombinedName();
    }

    @Override
    public int getEntryType() {
        return this.adbEntry.getEntryType();
    }

    @Override
    public ResourceLocator getContactPicture() {
        return this.adbEntry.getPersonalData().getContactPicture();
    }

    public int getDataIndex() {
        return this.dataIndex;
    }

    public int getDataType() {
        return this.getInteger(1);
    }

    public int getAddressIndex() {
        int n = this.getInteger(1);
        if (n != 1) {
            return -1;
        }
        switch (this.dataIndex) {
            case 0: 
            case 2: 
            case 4: {
                return 0;
            }
            case 1: 
            case 3: 
            case 5: {
                return 1;
            }
        }
        return -1;
    }

    public int getAddressType() {
        int n = this.getInteger(1);
        if (n != 1) {
            return -1;
        }
        return this.dataIndex;
    }

    private static long getUniqueIdForDetailsRow(int n, int n2) {
        if (n == 4 || n == 5 || n == 3) {
            return -1L;
        }
        return (n2 + 1) * -1;
    }
}

