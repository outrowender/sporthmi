/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.ADBHMIAppServiceListener;
import org.dsi.ifc.organizer.AdbEntry;

public interface ADBHMIAppService {
    public static final String ADB_SERVICE_APP_NAME;
    public static final int CONTEXT_TEL;
    public static final int CONTEXT_NAV;
    public static final int CONTEXT_MSG;

    default public void showEntryDetails(long l, int n) {
    }

    default public void showSpeedDialEntryDetails(long l, int n) {
    }

    default public void showEntryDetails(AdbEntry adbEntry, int n) {
    }

    default public void requestParseVCards(String string, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
    }

    default public void requestInsertEntry(AdbEntry adbEntry, ADBHMIAppServiceListener aDBHMIAppServiceListener) {
    }
}

