/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountFilter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AccountFilter$Builder {
    private int accountType = 0;
    private boolean internalOrMergedOnly = false;
    private boolean sendSupportOnly = false;
    private boolean mostRecentMsgOnly = false;
    private int mostRecentEmailAccId = -1;
    private int mostRecentSmsAccId = -1;
    private boolean newMessagesOnly = false;
    private Set newMessageAccountSet = Collections.EMPTY_SET;

    public AccountFilter$Builder accountType(int n) {
        this.accountType = n;
        return this;
    }

    public AccountFilter$Builder internalOrMergedOnly(boolean bl) {
        this.internalOrMergedOnly = bl;
        return this;
    }

    public AccountFilter$Builder sendSupportOnly(boolean bl) {
        this.sendSupportOnly = bl;
        return this;
    }

    public AccountFilter$Builder mostRecentMsgOnly(boolean bl, int n, int n2) {
        this.mostRecentMsgOnly = bl;
        this.mostRecentEmailAccId = n;
        this.mostRecentSmsAccId = n2;
        return this;
    }

    public AccountFilter$Builder newMessagesOnly(boolean bl, Set set) {
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

    static /* synthetic */ int access$100(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.accountType;
    }

    static /* synthetic */ boolean access$200(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.internalOrMergedOnly;
    }

    static /* synthetic */ boolean access$300(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.sendSupportOnly;
    }

    static /* synthetic */ boolean access$400(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.mostRecentMsgOnly;
    }

    static /* synthetic */ int access$500(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.mostRecentEmailAccId;
    }

    static /* synthetic */ int access$600(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.mostRecentSmsAccId;
    }

    static /* synthetic */ boolean access$700(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.newMessagesOnly;
    }

    static /* synthetic */ Set access$800(AccountFilter$Builder accountFilter$Builder) {
        return accountFilter$Builder.newMessageAccountSet;
    }
}

