/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineDidYouMeanCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineSearchAreaSetCommand;
import de.audi.app.sdsmanager.apps.navi.commands.NaviPOIOnlineSelectDestinationCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;

class NaviSDSPOIOnlineServiceListenerImpl
implements NaviSDSPOIOnlineServiceListener {
    private final LogChannel lc = Logger.getAppNaviLog();
    private boolean useSuggestions = false;

    NaviSDSPOIOnlineServiceListenerImpl() {
    }

    public void poiOnlineSetSearchAreaResult(byte by) {
        this.lc.log(10000000, "NaviSDSPOIOnlineServiceListenerImpl#poiOnlineSetSearchAreaResult: status=%1", (long)by);
        try {
            ((NaviPOIOnlineSearchAreaSetCommand)SDSUtils.getActiveSystemCall()).poiOnlineSetSearchAreaResult(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviSDSPOIOnlineServiceListenerImpl#poiOnlineSetSearchAreaResult: Active command is no NaviPOIOnlineSearchAreaCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviSDSPOIOnlineServiceListenerImpl#poiOnlineSetSearchAreaResult: NullpointerException. No active command!");
        }
    }

    public void poiOnlineSearchDidYouMeanResult(byte by) {
        this.lc.log(10000000, "NaviSDSPOIOnlineServiceListenerImpl#poiOnlineSearchDidYouMeanResult: status=%1", (long)by);
        try {
            ((NaviPOIOnlineDidYouMeanCommand)SDSUtils.getActiveSystemCall()).poiOnlineSearchDidYouMeanResult(by);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviSDSPOIOnlineServiceListenerImpl#poiOnlineSearchDidYouMeanResult: Active command is no NaviPOIOnlineDidYouMeanCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviSDSPOIOnlineServiceListenerImpl#poiOnlineSearchDidYouMeanResult: NullpointerException. No active command!");
        }
    }

    public void updatePOIOnlineSearchResults(byte by, String string, String[] stringArray) {
        this.lc.log(10000000, "[NaviSDSPOIOnlineServiceListenerImpl#updatePOIOnlineSearchResults] status=%3, recognizedTerm=%1, suggestions=%2", (Object)string, (Object)stringArray, (long)by);
        if (!this.checkPOIOnlineStatus(by)) {
            this.lc.log(10000000, "[NaviSDSPOIOnlineServiceListenerImpl#updatePOIOnlineSearchResults] POI error detected, status NaviSDSPOIOnlineServiceListenerImpl was handled!", (long)by);
            return;
        }
        if (!SDSUtils.isEmpty(string)) {
            SDSModelAccess.setSlotModel(1, string);
        }
        if (!SDSUtils.isEmpty(stringArray) || this.useSuggestions) {
            this.lc.log(10000000, "[NaviSDSPOIOnlineServiceListenerImpl#updatePOIOnlineSearchResults] useSuggestions=%1, non-empty spelling suggestions assumed!", this.useSuggestions);
            SDSModelAccess.setNaviPOIOnlineRecognitionStatus(7, 1);
            return;
        }
        this.lc.log(10000000, "[NaviSDSPOIOnlineServiceListenerImpl#updatePOIOnlineSearchResults] Everything OK!");
    }

    private boolean checkPOIOnlineStatus(byte by) {
        this.lc.log(10000000, "NaviSDSPOIOnlineServiceListenerImpl#checkPOIOnlineStatus: status=%1", (long)by);
        boolean bl = false;
        byte by2 = by;
        switch (by) {
            case 0: {
                bl = true;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.lc.log(10000000, "NaviSDSPOIOnlineServiceListenerImpl#checkPOIOnlineStatus: Handled replyCode %1!", (long)by);
                break;
            }
            default: {
                this.lc.log(100000, "NaviSDSPOIOnlineServiceListenerImpl#checkPOIOnlineStatus: Unhandled replyCode %1!", (long)by);
                by2 = 1;
            }
        }
        SDSModelAccess.setNaviPOIOnlineRecognitionStatus(by2, 1);
        return bl;
    }

    public void setSuggestions(boolean bl) {
        this.lc.log(10000000, "NaviSDSPOIOnlineServiceListenerImpl#setSuggestions: suggestions=%1", bl);
        this.useSuggestions = bl;
    }

    public void responseSelectDestination(NavLocation navLocation) {
        this.lc.log(10000000, "NaviSDSPOIOnlineServiceListenerImpl#responseSelectDestination: navLocation=%1", (Object)navLocation);
        try {
            ((NaviPOIOnlineSelectDestinationCommand)SDSUtils.getActiveSystemCall()).responseSelectDestination(navLocation);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "NaviSDSPOIOnlineServiceListenerImpl#responseSelectDestination: Active command is no NaviPOIOnlineSelectDestinationCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "NaviSDSPOIOnlineServiceListenerImpl#responseSelectDestination: NullpointerException. No active command!");
        }
    }
}

