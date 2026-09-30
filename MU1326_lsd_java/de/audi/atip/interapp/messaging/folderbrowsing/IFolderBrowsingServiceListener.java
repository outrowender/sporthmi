/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.folderbrowsing;

import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;

public interface IFolderBrowsingServiceListener {
    public void updateAccounts(int var1, int var2);

    public void responseEnterAccount(IFolderBrowsingService.ResultCode var1);
}

