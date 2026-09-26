/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import org.dsi.ifc.messaging.MessagingAccount;

public interface IAccountFilter {
    default public boolean accept(MessagingAccount messagingAccount) {
    }

    default public String getDescription() {
    }
}

