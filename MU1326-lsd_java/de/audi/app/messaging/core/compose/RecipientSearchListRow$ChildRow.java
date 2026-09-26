/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PhoneData;

public final class RecipientSearchListRow$ChildRow
extends EvoListRow {
    private final MatchedAddress matchedAddress;
    private final int iconId;

    private RecipientSearchListRow$ChildRow(long l, MatchedAddress matchedAddress, int n) {
        super(l, 6);
        this.matchedAddress = matchedAddress;
        this.iconId = n;
        this.setInteger(0, 1);
        this.setInteger(1, 1);
        this.setInteger(2, n);
        this.setText(4, matchedAddress.getAddress());
    }

    static RecipientSearchListRow$ChildRow createPhoneNumberRow(AdbEntry adbEntry, int n) {
        PhoneData phoneData = adbEntry.getPhoneData()[n];
        MatchedAddress matchedAddress = new MatchedAddress(phoneData.getNumber(), adbEntry.getCombinedName(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture());
        int n2 = ADBModelUtils.getIconTypeForPhoneNumber(phoneData.getNumberType());
        return new RecipientSearchListRow$ChildRow(-n, matchedAddress, n2);
    }

    static RecipientSearchListRow$ChildRow createEmailAddressRow(AdbEntry adbEntry, int n) {
        EmailData emailData = adbEntry.getEmailData()[n];
        MatchedAddress matchedAddress = new MatchedAddress(emailData.getEmailAddr(), adbEntry.getCombinedName(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture());
        int n2 = 0;
        return new RecipientSearchListRow$ChildRow(-n, matchedAddress, n2);
    }

    @Override
    public EvoListRow copy() {
        return new RecipientSearchListRow$ChildRow(this.getUniqueID(), this.matchedAddress, this.iconId);
    }

    public MatchedAddress getMatchedAddress() {
        return this.matchedAddress;
    }

    public static RecipientSearchListRow$ChildRow[] createPhoneNumberRows(AdbEntry adbEntry) {
        int n = ADBUtils.countPhoneNumbers(adbEntry);
        RecipientSearchListRow$ChildRow[] recipientSearchListRow$ChildRowArray = new RecipientSearchListRow$ChildRow[n];
        PhoneData[] phoneDataArray = adbEntry != null ? adbEntry.getPhoneData() : new PhoneData[]{};
        int n2 = 0;
        for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
            if (!ADBUtils.isValidPhoneNumber(phoneDataArray[i2])) continue;
            recipientSearchListRow$ChildRowArray[n2++] = RecipientSearchListRow$ChildRow.createPhoneNumberRow(adbEntry, i2);
        }
        return recipientSearchListRow$ChildRowArray;
    }

    public static RecipientSearchListRow$ChildRow[] createEmailAddressRows(AdbEntry adbEntry) {
        int n = ADBUtils.countEmailAddresses(adbEntry);
        RecipientSearchListRow$ChildRow[] recipientSearchListRow$ChildRowArray = new RecipientSearchListRow$ChildRow[n];
        EmailData[] emailDataArray = adbEntry != null ? adbEntry.getEmailData() : new EmailData[]{};
        int n2 = 0;
        for (int i2 = 0; i2 < emailDataArray.length; ++i2) {
            if (!ADBUtils.isValidEmailAddress(emailDataArray[i2])) continue;
            recipientSearchListRow$ChildRowArray[n2++] = RecipientSearchListRow$ChildRow.createEmailAddressRow(adbEntry, i2);
        }
        return recipientSearchListRow$ChildRowArray;
    }
}

