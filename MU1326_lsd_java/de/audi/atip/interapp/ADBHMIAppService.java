/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.ADBHMIAppServiceListener;
import org.dsi.ifc.organizer.AdbEntry;

public interface ADBHMIAppService {
    public static final String ADB_SERVICE_APP_NAME = "AddressBookInterHMIAppService";
    public static final int CONTEXT_TEL = 0;
    public static final int CONTEXT_NAV = 1;
    public static final int CONTEXT_MSG = 2;

    public void showEntryDetails(long var1, int var3);

    public void showSpeedDialEntryDetails(long var1, int var3);

    public void showEntryDetails(AdbEntry var1, int var2);

    public void requestParseVCards(String var1, ADBHMIAppServiceListener var2);

    public void requestInsertEntry(AdbEntry var1, ADBHMIAppServiceListener var2);
}

