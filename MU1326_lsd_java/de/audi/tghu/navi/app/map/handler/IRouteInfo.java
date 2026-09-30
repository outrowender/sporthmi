/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.INaviInterface;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface IRouteInfo {
    public static final int MIXEDLIST_COUNTRYINFO_HORIZON = 500;
    public static final int DIST_SHOW_THRESHOLD = 30;

    public void forceRouteInfo(boolean var1);

    public void show();

    public void hide();

    public boolean isMixedListVisible();

    public void setMixedListVisible(boolean var1);

    public void updateRgActive(boolean var1);

    public void updateRgTurnList(TurnListElement[] var1);

    public void updateRgDestinationInfo(NavRouteListData[] var1);

    public void enableRouteInfoComplete(boolean var1);

    public void updateRgPoiInfo(NavPoiInfo[] var1);

    public void updateTmcMessagesAhead(TmcMessage[] var1);

    public void setLanguage(String var1);

    public void refreshDestinationFlag();

    public void refreshDistAndRtt();

    public void setTravelParameters(boolean var1, boolean var2, long var3, long var5, int var7, int var8, long var9, long var11, int var13, int var14, int var15);

    public Object getItemByUID(long var1);

    public static interface IRouteInfoHandlerEnv {
        public void updateDestDistance(int var1);

        public boolean showETAandDistanceToNextStopover();

        public boolean isInMap();

        public boolean isRouteInfoEnabled();

        public boolean supportsAdditionalInfo();

        public boolean isRouteInfoAllowedToFadeIn();

        public void automaticOrientateMap();

        public INaviInterface getNaviInterface();

        public GUIInterface getGuiInterface();
    }
}

