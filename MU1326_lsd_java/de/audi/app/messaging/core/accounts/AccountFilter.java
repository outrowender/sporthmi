/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.util.Collections;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.messaging.MessagingAccount;

public final class AccountFilter
implements IAccountFilter {
    public static final AccountFilter ACCOUNT_FILTER_ALL = new Builder().build();
    public static final AccountFilter ACCOUNT_FILTER_EMAIL_ONLY = new Builder().accountType(2).build();
    public static final AccountFilter ACCOUNT_FILTER_SMS_ONLY = new Builder().accountType(1).build();
    private final int accountType;
    private final boolean internalOrMergedOnly;
    private final boolean sendSupportOnly;
    private final boolean mostRecentMsgOnly;
    private final int mostRecentEmailAccId;
    private final int mostRecentSmsAccId;
    private final boolean newMessagesOnly;
    private final Set newMessageAccountSet;

    private AccountFilter(Builder builder) {
        this.accountType = builder.accountType;
        this.internalOrMergedOnly = builder.internalOrMergedOnly;
        this.sendSupportOnly = builder.sendSupportOnly;
        this.mostRecentMsgOnly = builder.mostRecentMsgOnly;
        this.mostRecentEmailAccId = builder.mostRecentEmailAccId;
        this.mostRecentSmsAccId = builder.mostRecentSmsAccId;
        this.newMessagesOnly = builder.newMessagesOnly;
        this.newMessageAccountSet = builder.newMessageAccountSet;
    }

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

    public static final class Builder {
        private int accountType = 0;
        private boolean internalOrMergedOnly = false;
        private boolean sendSupportOnly = false;
        private boolean mostRecentMsgOnly = false;
        private int mostRecentEmailAccId = -1;
        private int mostRecentSmsAccId = -1;
        private boolean newMessagesOnly = false;
        private Set newMessageAccountSet = java.util.Collections.EMPTY_SET;

        public Builder accountType(int n) {
            this.accountType = n;
            return this;
        }

        public Builder internalOrMergedOnly(boolean bl) {
            this.internalOrMergedOnly = bl;
            return this;
        }

        public Builder sendSupportOnly(boolean bl) {
            this.sendSupportOnly = bl;
            return this;
        }

        public Builder mostRecentMsgOnly(boolean bl, int n, int n2) {
            this.mostRecentMsgOnly = bl;
            this.mostRecentEmailAccId = n;
            this.mostRecentSmsAccId = n2;
            return this;
        }

        public Builder newMessagesOnly(boolean bl, Set set) {
            this.newMessagesOnly = bl;
            if (bl && set != null) {
                HashSet hashSet = new HashSet(set);
                Iterator iterator = hashSet.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() instanceof Integer) continue;
                    throw new IllegalArgumentException("newMessageAccountSet contains elements that are not of type Integer.");
                }
                this.newMessageAccountSet = hashSet;
            }
            return this;
        }

        public AccountFilter build() {
            return new AccountFilter(this);
        }
    }
}

