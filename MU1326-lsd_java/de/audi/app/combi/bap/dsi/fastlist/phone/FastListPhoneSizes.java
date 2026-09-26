/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone;

public final class FastListPhoneSizes {
    private static volatile int currentListSizePhonebook;
    private static volatile int currentListSizeFavoriteList;
    private static volatile int currentListSizeCombinedNumbers;

    public static void pushListSizePhoneBook(DSIFastListScrollingTelephone dSIFastListScrollingTelephone, int n) {
        currentListSizePhonebook = n;
        dSIFastListScrollingTelephone.pushCurrentListSizeTelephone(currentListSizePhonebook, currentListSizeFavoriteList, currentListSizeCombinedNumbers);
    }

    public static void pushListSizeFavoriteNumbers(DSIFastListScrollingTelephone dSIFastListScrollingTelephone, int n) {
        currentListSizeFavoriteList = n;
        dSIFastListScrollingTelephone.pushCurrentListSizeTelephone(currentListSizePhonebook, currentListSizeFavoriteList, currentListSizeCombinedNumbers);
    }

    public static void pushListSizeCombinedNumbers(DSIFastListScrollingTelephone dSIFastListScrollingTelephone, int n) {
        currentListSizeCombinedNumbers = n;
        dSIFastListScrollingTelephone.pushCurrentListSizeTelephone(currentListSizePhonebook, currentListSizeFavoriteList, currentListSizeCombinedNumbers);
    }
}

