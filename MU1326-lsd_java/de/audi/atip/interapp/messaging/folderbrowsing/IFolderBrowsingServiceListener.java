/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.folderbrowsing;

import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$ResultCode;

public interface IFolderBrowsingServiceListener {
    default public void updateAccounts(int n, int n2) {
    }

    default public void responseEnterAccount(IFolderBrowsingService$ResultCode iFolderBrowsingService$ResultCode) {
    }
}

