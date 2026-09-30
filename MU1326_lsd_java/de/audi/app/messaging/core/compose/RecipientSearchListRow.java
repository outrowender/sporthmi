/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchUtils;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.search.SearchResult;

public final class RecipientSearchListRow
extends SearchResultListRow {
    private static final int COLUMN_COUNT = 6;
    private static final int CELL_IDX_RECORDSET = 0;
    private static final int CELL_IDX_ENABLED = 1;
    private static final int CELL_IDX_ICON = 2;
    private static final int CELL_IDX_COMBINED_NAME = 3;
    private static final int CELL_IDX_ADDRESS = 4;
    private static final int CELL_IDX_EXPANDED = 5;
    private static final int RECORDSET_CONTACT = 0;
    private static final int RECORDSET_ADDRESS = 1;

    public RecipientSearchListRow(SearchResult searchResult) {
        super(searchResult, 6, searchResult.getDataId());
        this.setNodeType(1);
        this.setInteger(0, 0);
        this.setInteger(1, 1);
        this.setInteger(2, ADBTruffleSearchUtils.getEntryTypeModelValue(searchResult));
        this.setHighlightTextCell(3, ADBTruffleSearchUtils.getCombinedNameListCell(searchResult));
        this.setInteger(5, 0);
    }

    public EvoListRow copy() {
        RecipientSearchListRow recipientSearchListRow = new RecipientSearchListRow(this.getSearchResult());
        recipientSearchListRow.setOpen(this.isOpen());
        return recipientSearchListRow;
    }

    public void setOpen(boolean bl) {
        super.setOpen(bl);
        this.setInteger(5, bl ? 1 : 0);
    }

    public long getEntryId() {
        return this.getSearchResult().getDataId();
    }

    public static final class ChildRow
    extends EvoListRow {
        private final MatchedAddress matchedAddress;
        private final int iconId;

        private ChildRow(long l, MatchedAddress matchedAddress, int n) {
            super(l, 6);
            this.matchedAddress = matchedAddress;
            this.iconId = n;
            this.setInteger(0, 1);
            this.setInteger(1, 1);
            this.setInteger(2, n);
            this.setText(4, matchedAddress.getAddress());
        }

        static ChildRow createPhoneNumberRow(AdbEntry adbEntry, int n) {
            PhoneData phoneData = adbEntry.getPhoneData()[n];
            MatchedAddress matchedAddress = new MatchedAddress(phoneData.getNumber(), adbEntry.getCombinedName(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture());
            int n2 = ADBModelUtils.getIconTypeForPhoneNumber(phoneData.getNumberType());
            return new ChildRow(-n, matchedAddress, n2);
        }

        static ChildRow createEmailAddressRow(AdbEntry adbEntry, int n) {
            EmailData emailData = adbEntry.getEmailData()[n];
            MatchedAddress matchedAddress = new MatchedAddress(emailData.getEmailAddr(), adbEntry.getCombinedName(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture());
            int n2 = 0;
            return new ChildRow(-n, matchedAddress, n2);
        }

        public EvoListRow copy() {
            return new ChildRow(this.getUniqueID(), this.matchedAddress, this.iconId);
        }

        public MatchedAddress getMatchedAddress() {
            return this.matchedAddress;
        }

        public static ChildRow[] createPhoneNumberRows(AdbEntry adbEntry) {
            int n = ADBUtils.countPhoneNumbers(adbEntry);
            ChildRow[] childRowArray = new ChildRow[n];
            PhoneData[] phoneDataArray = adbEntry != null ? adbEntry.getPhoneData() : new PhoneData[]{};
            int n2 = 0;
            for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
                if (!ADBUtils.isValidPhoneNumber(phoneDataArray[i2])) continue;
                childRowArray[n2++] = ChildRow.createPhoneNumberRow(adbEntry, i2);
            }
            return childRowArray;
        }

        public static ChildRow[] createEmailAddressRows(AdbEntry adbEntry) {
            int n = ADBUtils.countEmailAddresses(adbEntry);
            ChildRow[] childRowArray = new ChildRow[n];
            EmailData[] emailDataArray = adbEntry != null ? adbEntry.getEmailData() : new EmailData[]{};
            int n2 = 0;
            for (int i2 = 0; i2 < emailDataArray.length; ++i2) {
                if (!ADBUtils.isValidEmailAddress(emailDataArray[i2])) continue;
                childRowArray[n2++] = ChildRow.createEmailAddressRow(adbEntry, i2);
            }
            return childRowArray;
        }
    }
}

