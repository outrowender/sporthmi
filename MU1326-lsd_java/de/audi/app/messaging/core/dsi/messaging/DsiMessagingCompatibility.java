/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import org.dsi.ifc.messaging.MessagingAccount;

public final class DsiMessagingCompatibility {
    public static MessagingAccount createMessagingAccount(int n, String string, int n2, int n3, boolean bl, int n4, int n5, String string2, String string3, String string4) {
        MessagingAccount messagingAccount = null;
        messagingAccount = new MessagingAccount();
        messagingAccount.accountID = n;
        messagingAccount.accountName = string;
        messagingAccount.accountType = n2;
        messagingAccount.supportsSMS = n3;
        messagingAccount.supportsEMail = bl;
        messagingAccount.offeredFolderTypes = n4;
        messagingAccount.memoryStatus = n5;
        messagingAccount.unreadMessageCount = 0;
        messagingAccount.btDeviceAddress = string2;
        messagingAccount.btUserFriendlyName = string3;
        messagingAccount.simCardId = string4;
        return messagingAccount;
    }
}

