/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import org.dsi.ifc.messaging.MessagingAccount;

public interface IAccountListRowFactory {
    default public AbstractAccountListRow create(MessagingAccount messagingAccount, int n, boolean bl, String string, boolean bl2, int n2) {
    }
}

