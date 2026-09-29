/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import org.dsi.ifc.messaging.MessagingAccount;

public final class Accounts {
    public static boolean supportsSend(MessagingAccount messagingAccount) {
        return messagingAccount != null && (messagingAccount.getOfferedFolderTypes() & 8) != 0;
    }

    public static boolean supportsDrafts(MessagingAccount messagingAccount) {
        return messagingAccount != null && (messagingAccount.getOfferedFolderTypes() & 2) != 0;
    }

    public static boolean supportsSms(MessagingAccount messagingAccount) {
        return messagingAccount != null && messagingAccount.getSupportsSMS() != 0;
    }

    public static boolean isBasedOnBtConnection(MessagingAccount messagingAccount, boolean bl) {
        int n = messagingAccount.getAccountType();
        boolean bl2 = n == 2;
        boolean bl3 = n == 3;
        boolean bl4 = n == 1 && bl;
        return bl2 || bl3 || bl4;
    }
}

