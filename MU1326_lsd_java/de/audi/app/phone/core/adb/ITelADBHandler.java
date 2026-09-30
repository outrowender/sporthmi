/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.core.adb.ITelADBGetSpeedDialListFavoritesListener;
import de.audi.app.phone.core.adb.ITelADBHandlerListener;
import org.dsi.ifc.global.ResourceLocator;

public interface ITelADBHandler {
    public void registerListener(ITelADBHandlerListener var1);

    public void removeListener(ITelADBHandlerListener var1);

    public void getADBEntry(long var1, ITelADBGetADBEntryListener var3);

    public void getADBSpeedDialFavoritesList(ITelADBGetSpeedDialListFavoritesListener var1);

    public int getADBSpeedDialEntriesMaxNumber();

    public void setFavoriteSpeedDial(String var1, int var2, int var3, String var4, String var5, String var6, String var7, ResourceLocator var8);

    public void deleteFavoriteSpeedDial(int var1);

    public void deleteAllFavoriteSpeedDials();

    public void deleteSpecificFavoriteSpeedDials(long[] var1);

    public void showEntryDetails(long var1);

    public void showSpeedDialEntryDetails(long var1);

    public ADBApplication getAdbApplication();

    public ADBOrganizerSearch getOrganizerSearch();
}

