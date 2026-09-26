/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation;

public final class FastListNaviSizes {
    private static volatile int currentListSizeNavBook;
    private static volatile int currentListSizeLastDestList;
    private static volatile int currentListSizeFavoriteDestList;

    public static void pushListSizeNavBook(DSIFastListScrollingNavigation dSIFastListScrollingNavigation, int n) {
        currentListSizeNavBook = n;
        dSIFastListScrollingNavigation.pushCurrentListSizeNavigation(currentListSizeNavBook, currentListSizeLastDestList, currentListSizeFavoriteDestList);
    }

    public static void pushListSizeLastDestinationsList(DSIFastListScrollingNavigation dSIFastListScrollingNavigation, int n) {
        currentListSizeLastDestList = n;
        dSIFastListScrollingNavigation.pushCurrentListSizeNavigation(currentListSizeNavBook, currentListSizeLastDestList, currentListSizeFavoriteDestList);
    }

    public static void pushListSizeFavoriteDestinations(DSIFastListScrollingNavigation dSIFastListScrollingNavigation, int n) {
        currentListSizeFavoriteDestList = n;
        dSIFastListScrollingNavigation.pushCurrentListSizeNavigation(currentListSizeNavBook, currentListSizeLastDestList, currentListSizeFavoriteDestList);
    }
}

