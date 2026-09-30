/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import de.audi.app.messaging.core.accounts.CoreAccountListRow;
import de.audi.app.messaging.core.accounts.IAccountListRowFactory;
import org.dsi.ifc.messaging.MessagingAccount;

public class CoreAccountListRowFactory
implements IAccountListRowFactory {
    public AbstractAccountListRow create(MessagingAccount messagingAccount, int n, boolean bl, String string, boolean bl2, int n2) {
        return new CoreAccountListRow(messagingAccount, n, bl, string, bl2, n2);
    }
}

