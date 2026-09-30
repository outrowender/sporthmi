/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import org.dsi.ifc.messaging.MessagingAccount;

public interface IAccountListRowFactory {
    public AbstractAccountListRow create(MessagingAccount var1, int var2, boolean var3, String var4, boolean var5, int var6);
}

