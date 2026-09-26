/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MessagingAccount;

public final class CoreAccountListRow
extends AbstractAccountListRow {
    public static final int COLUMN_COUNT;
    private static final int CELL_ID_ICON;
    private static final int CELL_ID_ACCOUNT_DESC;
    private static final int CELL_ID_ACCOUNT_NO;
    private static final int CELL_ID_ACCOUNT_NAME;
    private static final int CELL_ID_RECORDSET;
    private static final int CELL_IDX_UNREAD_COUNT;
    private static final int CELL_IDX_NEW_MESSAGE_COUNT;
    private static final int CELL_IDX_SUPPORTS_SEND;
    private static final int ICON_SMS_ACC;
    private static final int ICON_EMAIL_ACC;
    private static final int ICON_SMS_ACC_NEW_MSG;
    private static final int ICON_EMAIL_ACC_NEW_MSG;
    private static final int TEXT_CONST_SMS_ACC_INTERNAL;
    private static final int TEXT_CONST_SMS_ACC_EXTERNAL;
    private static final int TEXT_CONST_EMAIL_ACC_INTERNAL;
    private static final int TEXT_CONST_EMAIL_ACC_EXTERNAL;
    private static final int TEXT_CONST_SMS_ACC_EXTERNAL_NAME_KNOWN;
    private static final int TEXT_CONST_EMAIL_ACC_EXTERNAL_NAME_KNOWN;
    private static final int RECORDSET_STATIC_DESCRIPTION;
    private static final int RECORDSET_DYNAMIC_DESCRIPTION;
    private final MessagingAccount messagingAccount;
    private final int accountNo;
    private final boolean isBasedOnBtConnection;
    private final String btDeviceName;
    private final boolean newMessages;
    private final int newMessageCount;

    public CoreAccountListRow(MessagingAccount messagingAccount, int n, boolean bl, String string, boolean bl2, int n2) {
        super(messagingAccount.accountID, 8);
        this.messagingAccount = messagingAccount;
        this.accountNo = n;
        this.isBasedOnBtConnection = bl;
        this.btDeviceName = string;
        this.newMessages = bl2;
        this.newMessageCount = n2;
        String string2 = AccountManager.getDynamicAccountName(messagingAccount, string);
        int n3 = Strings.isNullOrEmpty(string2) ? 0 : 1;
        this.setInteger(0, CoreAccountListRow.getIconCellValue(messagingAccount, bl2));
        this.setInteger(2, CoreAccountListRow.getAccountDescCellValue(messagingAccount, bl, string2));
        this.setText(1, CoreAccountListRow.getAccountNoCellText(n));
        this.setText(3, string2);
        this.setInteger(4, n3);
        this.setInteger(5, messagingAccount.getUnreadMessageCount());
        this.setInteger(6, n2 > 100 ? 100 : n2);
        this.setInteger(7, Accounts.supportsSend(messagingAccount) ? 1 : 0);
    }

    @Override
    public EvoListRow copy() {
        return new CoreAccountListRow(this.messagingAccount, this.accountNo, this.isBasedOnBtConnection, this.btDeviceName, this.newMessages, this.newMessageCount);
    }

    @Override
    public int getIconId() {
        return ((IntegerListCell)this.getCell(0)).getValue();
    }

    @Override
    public int getAccountDescId() {
        return ((IntegerListCell)this.getCell(2)).getValue();
    }

    @Override
    public String getAccountNo() {
        return ((TextListCell)this.getCell(1)).getText();
    }

    @Override
    public MessagingAccount getMessagingAccount() {
        return this.messagingAccount;
    }

    @Override
    public int getUnreadCount() {
        return ((IntegerListCell)this.getCell(5)).getValue();
    }

    @Override
    public int getNewMessageCount() {
        return ((IntegerListCell)this.getCell(6)).getValue();
    }

    @Override
    public boolean supportsSend() {
        return ((IntegerListCell)this.getCell(7)).getValue() == 1;
    }

    private static int getIconCellValue(MessagingAccount messagingAccount, boolean bl) {
        int n = 0;
        n = messagingAccount.isSupportsEMail() ? (bl ? 3 : 1) : (bl ? 2 : 0);
        return n;
    }

    private static int getAccountDescCellValue(MessagingAccount messagingAccount, boolean bl, String string) {
        int n = 0;
        int n2 = AccountManager.getAccountTextType(bl, string);
        n = messagingAccount.isSupportsEMail() ? (n2 == 2 ? 2 : (n2 == 1 ? 3 : 5)) : (n2 == 2 ? 0 : (n2 == 1 ? 1 : 4));
        return n;
    }

    private static String getAccountNoCellText(int n) {
        Buffer buffer = new Buffer(3);
        if (n != -1) {
            buffer.append("(");
            buffer.append(n);
            buffer.append(')');
        }
        return buffer.toString();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        try {
            int n = ((CoreAccountListRow)object).getMessagingAccount().getAccountID();
            int n2 = this.getMessagingAccount().getAccountID();
            bl = n == n2;
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int hashCode() {
        return this.getMessagingAccount().getAccountID();
    }
}

