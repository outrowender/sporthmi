/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navtmc;

import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.tmc.TmcMessage;

public interface TMCService {
    public static final long TMC_REPEAT_MIN_TIMESLOT = 2000L;
    public static final int TMC_REPEAT_SUCCESS = 0;
    public static final int TMC_REPEAT_NO_MESSAGE_AVAILABLE = 1;
    public static final int TMC_REPEAT_NO_TIMESLOT = 2;
    public static final int TMC_ABORTED = 3;
    public static final int OPTION_TRAFFICREROUTING_AUTO = 0;
    public static final int OPTION_TRAFFICREROUTING_SEMIDYNAMIC = 1;
    public static final int OPTION_TRAFFICREROUTING_OFF = 2;

    public void updateDistanceToFinalDestination(int var1);

    public void updateRgDestinationInfo(NavRouteListData[] var1);

    public void updateIndexOfCurrentDestination(int var1);

    public void updateTimeToNextAnnouncement(long var1);

    public void updateRgActive(boolean var1);

    public void updateDynamicRgActive(boolean var1);

    public void updateTrafficRerouting(int var1);

    public void updateSemidynamicRouteGuidance(long var1, boolean var3, boolean var4, int var5);

    public void updateTMCMapActive(boolean var1);

    public void updateNaviFullyOperable(boolean var1);

    public int repeatOrAbortTmcMessageReadOutSince(long var1);

    public void showHideTMCPopup();

    public void showTMCWarningPopup();

    public void fillDetailScreen(TmcMessage var1);

    public void fillDetailScreen(TmcMessage var1, int var2);

    public void setPreviewTrafficInfoTmcEvent(TmcMessage var1);

    public void setPreviewTrafficInfoTmcEvent(TmcMessage var1, int var2);

    public void setPreviewTrafficInfoTmcEvent(TmcMessage var1, int var2, boolean var3);

    public void leaveMapSemidynamicRouteScreen();

    public void updateTmcMessagesAhead(TmcMessage[] var1);
}

