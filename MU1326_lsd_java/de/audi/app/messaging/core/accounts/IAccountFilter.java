/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import org.dsi.ifc.messaging.MessagingAccount;

public interface IAccountFilter {
    public boolean accept(MessagingAccount var1);

    public String getDescription();
}

