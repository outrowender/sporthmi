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
    default public void registerListener(ITelADBHandlerListener iTelADBHandlerListener) {
    }

    default public void removeListener(ITelADBHandlerListener iTelADBHandlerListener) {
    }

    default public void getADBEntry(long l, ITelADBGetADBEntryListener iTelADBGetADBEntryListener) {
    }

    default public void getADBSpeedDialFavoritesList(ITelADBGetSpeedDialListFavoritesListener iTelADBGetSpeedDialListFavoritesListener) {
    }

    default public int getADBSpeedDialEntriesMaxNumber() {
    }

    default public void setFavoriteSpeedDial(String string, int n, int n2, String string2, String string3, String string4, String string5, ResourceLocator resourceLocator) {
    }

    default public void deleteFavoriteSpeedDial(int n) {
    }

    default public void deleteAllFavoriteSpeedDials() {
    }

    default public void deleteSpecificFavoriteSpeedDials(long[] lArray) {
    }

    default public void showEntryDetails(long l) {
    }

    default public void showSpeedDialEntryDetails(long l) {
    }

    default public ADBApplication getAdbApplication() {
    }

    default public ADBOrganizerSearch getOrganizerSearch() {
    }
}

