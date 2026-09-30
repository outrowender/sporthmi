/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.PoiOnlineRecognitionListElement;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlineSDSSearchSim
implements DSIPoiOnlineSearch {
    private final OnlineSearchController onlineSearchController;
    private final LogChannel logChannel;
    private final boolean useSuggestions;
    private volatile boolean aborted;

    public OnlineSDSSearchSim(LogChannel logChannel, OnlineSearchController onlineSearchController, boolean bl) {
        this.logChannel = logChannel;
        this.onlineSearchController = onlineSearchController;
        this.useSuggestions = bl;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public void poiStartSelectionZoom(String string, int n, int n2, int n3, int n4, int n5) {
    }

    public void dynamicPoiStartSelectionZoom(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    public void poiStartSelection(final String string, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "showList(LIST_HISTORY);: Sending result STATUS_OK_SEARCH_COMPLETE!");
        final DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = this.onlineSearchController.getDSIOnlineSearchListener();
        dSIPoiOnlineSearchListener.poiResult(1, 1, 10);
        this.aborted = false;
        Thread thread = new Thread(){

            public void run() {
                try {
                    Thread.sleep(20000L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if (!OnlineSDSSearchSim.this.aborted) {
                    dSIPoiOnlineSearchListener.poiResult(1, 1, 11);
                    PoiOnlineSearchValuelist poiOnlineSearchValuelist = OnlineSDSSearchSim.this.prepareList(string, 50, 0);
                    OnlineSDSSearchSim.this.logChannel.log(10000000, "OnlineSDSSearchSim#poiStartSelection: Sending result list!");
                    dSIPoiOnlineSearchListener.poiValueList(1, 0, poiOnlineSearchValuelist, 0, 100);
                }
            }
        };
        thread.start();
    }

    public void dynamicPoiStartSelection(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void poiStopSelection() {
        this.logChannel.log(10000000, "OnlineSDSSearchSim#poiStopSelection: Stopping POI search!");
        this.aborted = true;
        DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = this.onlineSearchController.getDSIOnlineSearchListener();
        dSIPoiOnlineSearchListener.poiResult(1, 1, 12);
    }

    public void poiRequestValueList(int n, int n2) {
    }

    public void poiStartVoiceSelection(int n, int n2, int n3, int n4, boolean bl, int n5) {
        this.logChannel.log(1000000, "OnlineSDSSearchSim#poiStartVoiceSelection: Called");
        this.onlineSearchController.getDSIOnlineSearchListener().poiResult(1, 1, 10);
    }

    private PoiOnlineSearchValuelist prepareList(String string, int n, int n2) {
        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = new PoiOnlineSearchValuelistElement[n];
        for (int i2 = 0; i2 < n; ++i2) {
            int n3 = n2 + i2;
            poiOnlineSearchValuelistElementArray[i2] = new PoiOnlineSearchValuelistElement(57464564, 678678966, new StringBuffer().append(string).append(" ").append(n3).toString(), new StringBuffer().append("Richard Strauss ").append(n3).toString(), "91054", "Erlangen", "Bayern", "Germany", new StringBuffer().append("+09131 300").append(i2).toString(), "http://www.spiegel.de", "My Info", 0, "http://www.welt.de", string, n3, null);
        }
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        PoiOnlineRecognitionListElement[] poiOnlineRecognitionListElementArray = new PoiOnlineRecognitionListElement[]{new PoiOnlineRecognitionListElement("PIZZA", 1.0f)};
        return new PoiOnlineSearchValuelist(0, "Google", 2, "Sim", 0, poiOnlineRecognitionListElementArray, string2, string3, null, null, string4, string5, n2, poiOnlineSearchValuelistElementArray);
    }

    public void poiRawVoiceDataAvailable(String string, int n) {
        this.logChannel.log(10000000, "OnlineSDSSearchSim#poiRawVoiceDataAvailable: Sending result STATUS_OK_SEARCH_COMPLETE!");
        DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = this.onlineSearchController.getDSIOnlineSearchListener();
        dSIPoiOnlineSearchListener.poiResult(1, 1, 11);
        if (this.useSuggestions) {
            this.logChannel.log(10000000, "OnlineSDSSearchSim#poiRawVoiceDataAvailable: Sending empty result list!");
            PoiOnlineSearchValuelist poiOnlineSearchValuelist = this.prepareList("PIZZA", 0, 0);
            dSIPoiOnlineSearchListener.poiValueList(1, 1, poiOnlineSearchValuelist, 0, 0);
        } else {
            PoiOnlineSearchValuelist poiOnlineSearchValuelist = this.prepareList("PIZZA", 50, 0);
            this.logChannel.log(10000000, "OnlineSDSSearchSim#poiRawVoiceDataAvailable: Sending result list!");
            dSIPoiOnlineSearchListener.poiValueList(1, 1, poiOnlineSearchValuelist, 0, 100);
        }
    }

    public void poiRequestSpellingSuggestion() {
        this.logChannel.log(10000000, "OnlineSDSSearchSim#poiRequestSpellingSuggestion: Sending spelling suggestions!");
        this.onlineSearchController.getDSIOnlineSearchListener().poiSpellingSuggestion(1, "PIZZA", new String[]{"PIZZA1", "PIZZA2", "PIZZA3"});
    }

    public void usedPoi(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
        this.logChannel.log(100000, "OnlineSDSSearchSim#poiRequestSpellingSuggestion: NOP!");
    }

    public void setLanguage(String string) {
        this.logChannel.log(100000, "OnlineSDSSearchSim#poiRequestSpellingSuggestion: NOP!");
    }

    public void setFallbackLanguage(String string) {
        this.logChannel.log(100000, "OnlineSDSSearchSim#poiRequestSpellingSuggestion: NOP!");
    }

    public void poiVoiceSearchActive() {
        this.logChannel.log(100000, "OnlineSDSSearchSim#poiVoiceSearchActive: NOP!");
    }

    public void precheckDynamicPOICategory(int n) {
        this.logChannel.log(100000, "OnlineSDSSearchSim#precheckDynamicPOICategory: NOP!");
    }
}

