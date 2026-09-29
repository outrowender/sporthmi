/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountFilter$Builder;
import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.util.Collections;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Set;
import org.dsi.ifc.messaging.MessagingAccount;

public final class AccountFilter
implements IAccountFilter {
    public static final AccountFilter ACCOUNT_FILTER_ALL = new AccountFilter$Builder().build();
    public static final AccountFilter ACCOUNT_FILTER_EMAIL_ONLY = new AccountFilter$Builder().accountType(2).build();
    public static final AccountFilter ACCOUNT_FILTER_SMS_ONLY = new AccountFilter$Builder().accountType(1).build();
    private final int accountType;
    private final boolean internalOrMergedOnly;
    private final boolean sendSupportOnly;
    private final boolean mostRecentMsgOnly;
    private final int mostRecentEmailAccId;
    private final int mostRecentSmsAccId;
    private final boolean newMessagesOnly;
    private final Set newMessageAccountSet;

    private AccountFilter(AccountFilter$Builder accountFilter$Builder) {
        this.accountType = AccountFilter$Builder.access$100(accountFilter$Builder);
        this.internalOrMergedOnly = AccountFilter$Builder.access$200(accountFilter$Builder);
        this.sendSupportOnly = AccountFilter$Builder.access$300(accountFilter$Builder);
        this.mostRecentMsgOnly = AccountFilter$Builder.access$400(accountFilter$Builder);
        this.mostRecentEmailAccId = AccountFilter$Builder.access$500(accountFilter$Builder);
        this.mostRecentSmsAccId = AccountFilter$Builder.access$600(accountFilter$Builder);
        this.newMessagesOnly = AccountFilter$Builder.access$700(accountFilter$Builder);
        this.newMessageAccountSet = AccountFilter$Builder.access$800(accountFilter$Builder);
    }

    @Override
    public boolean accept(MessagingAccount messagingAccount) {
        int n;
        boolean bl = true;
        boolean bl2 = messagingAccount.isSupportsEMail();
        if (this.accountType == 2 && !bl2 || this.accountType == 1 && bl2) {
            bl = false;
        }
        if (bl && this.mostRecentMsgOnly) {
            n = messagingAccount.getAccountID();
            if (bl2) {
                bl = n == this.mostRecentEmailAccId;
            } else {
                boolean bl3 = bl = n == this.mostRecentSmsAccId;
            }
        }
        if (bl && this.newMessagesOnly) {
            n = messagingAccount.getAccountID();
            bl = this.newMessageAccountSet.contains(Util.createInteger(n));
        }
        if (bl && this.internalOrMergedOnly) {
            boolean bl4 = bl = messagingAccount.getAccountType() != 2;
        }
        if (bl && this.sendSupportOnly) {
            bl = Accounts.supportsSend(messagingAccount);
        }
        return bl;
    }

    @Override
    public String getDescription() {
        Buffer buffer = new Buffer();
        buffer.append("AccountFilter {accType = ");
        buffer.append(this.accountType);
        buffer.append(", internalOrMergedOnly = ");
        buffer.append(this.internalOrMergedOnly);
        buffer.append(", sendSupportOnly = ");
        buffer.append(this.sendSupportOnly);
        buffer.append(", mostRecentMsgOnly = ");
        buffer.append(this.mostRecentMsgOnly);
        buffer.append(", mostRecentEmailAccId = ");
        buffer.append(this.mostRecentEmailAccId);
        buffer.append(", mostRecentSmsAccId = ");
        buffer.append(this.mostRecentSmsAccId);
        buffer.append(", newMessagesOnly = ");
        buffer.append(this.newMessagesOnly);
        buffer.append(", newMessageAccountIds = ");
        buffer.append(Collections.toString(this.newMessageAccountSet));
        buffer.append('}');
        return buffer.toString();
    }
}

