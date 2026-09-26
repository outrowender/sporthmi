/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.NaviMyAudiImport$IMyAudiImportResultListener;
import de.audi.atip.interapp.OnlineAdbEntry;

public interface NaviMyAudiImport {
    default public void storeAddressList(OnlineAdbEntry[] onlineAdbEntryArray, int n, IMyAudiImportResultListener iMyAudiImportResultListener) {
    }

    default public void downloadStarted() {
    }
}

