/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navtmc;

import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.tmc.TmcMessage;

public interface TMCService {
    public static final long TMC_REPEAT_MIN_TIMESLOT;
    public static final int TMC_REPEAT_SUCCESS;
    public static final int TMC_REPEAT_NO_MESSAGE_AVAILABLE;
    public static final int TMC_REPEAT_NO_TIMESLOT;
    public static final int TMC_ABORTED;
    public static final int OPTION_TRAFFICREROUTING_AUTO;
    public static final int OPTION_TRAFFICREROUTING_SEMIDYNAMIC;
    public static final int OPTION_TRAFFICREROUTING_OFF;

    default public void updateDistanceToFinalDestination(int n) {
    }

    default public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    default public void updateIndexOfCurrentDestination(int n) {
    }

    default public void updateTimeToNextAnnouncement(long l) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void updateDynamicRgActive(boolean bl) {
    }

    default public void updateTrafficRerouting(int n) {
    }

    default public void updateSemidynamicRouteGuidance(long l, boolean bl, boolean bl2, int n) {
    }

    default public void updateTMCMapActive(boolean bl) {
    }

    default public void updateNaviFullyOperable(boolean bl) {
    }

    default public int repeatOrAbortTmcMessageReadOutSince(long l) {
    }

    default public void showHideTMCPopup() {
    }

    default public void showTMCWarningPopup() {
    }

    default public void fillDetailScreen(TmcMessage tmcMessage) {
    }

    default public void fillDetailScreen(TmcMessage tmcMessage, int n) {
    }

    default public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage) {
    }

    default public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n) {
    }

    default public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
    }

    default public void leaveMapSemidynamicRouteScreen() {
    }

    default public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
    }
}

