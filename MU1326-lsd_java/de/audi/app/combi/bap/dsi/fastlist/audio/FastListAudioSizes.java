/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio;

public final class FastListAudioSizes {
    private static volatile int currentListSizeMediaBrowser;
    private static volatile int currentListSizeCommonList;
    private static volatile int currentListSizeReceptionList;

    public static void pushListSizeMediaBrowser(DSIFastListScrollingAudio dSIFastListScrollingAudio, int n) {
        currentListSizeMediaBrowser = n;
        dSIFastListScrollingAudio.pushCurrentListSizeAudio(currentListSizeMediaBrowser, currentListSizeCommonList, currentListSizeReceptionList);
    }

    public static void pushListSizeCommonList(DSIFastListScrollingAudio dSIFastListScrollingAudio, int n) {
        currentListSizeCommonList = n;
        dSIFastListScrollingAudio.pushCurrentListSizeAudio(currentListSizeMediaBrowser, currentListSizeCommonList, currentListSizeReceptionList);
    }

    public static void pushListSizeReceptionList(DSIFastListScrollingAudio dSIFastListScrollingAudio, int n) {
        currentListSizeReceptionList = n;
        dSIFastListScrollingAudio.pushCurrentListSizeAudio(currentListSizeMediaBrowser, currentListSizeCommonList, currentListSizeReceptionList);
    }
}

