/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineMapOverlay;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineServiceListener;
import de.audi.atip.interapp.NaviOnlineService$POIOnlineData;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public class HMIViewMapListener
extends AbstractHMIViewListenerEvo
implements NaviOnlineService$NaviOnlineServiceListener {
    private static final int DELAY_DEFAULT;
    private int setId = 0;

    public HMIViewMapListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo);
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.setSelectedIds(hMIProperties.getStringArray("listTextId"));
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        this.checkNaviOperable(naviOnlineService);
        this.logChannel.log(-2137614336, "HMIViewMapListener#updateViewProperties: Called");
        if (naviOnlineService == null) {
            this.logChannel.log(10000, "HMIViewMapListener#updateViewProperties: no NaviOnlineService was found.");
            return;
        }
        NavLocationWgs84 navLocationWgs84 = this.extractFocussedLocation(hMIProperties);
        NaviOnlineService$POIOnlineData[] naviOnlineService$POIOnlineDataArray = this.extractPinData(hMIProperties);
        int n = -1;
        if (hMIProperties.contains("zoom")) {
            n = hMIProperties.getInt("zoom");
            this.logChannel.log(-2137614336, "HMIViewMapListener#updateViewProperties zoom value: %1", (long)n);
        }
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(572269312);
        this.logChannel.log(1078071040, "HMIViewMapListener#updateViewProperties: Setting %1 pins, focus on %2", (Object)new Integer(naviOnlineService$POIOnlineDataArray.length), (Object)navLocationWgs84.toString());
        naviOnlineService.setPOIViewportData(naviOnlineService$POIOnlineDataArray, n, null, choiceModelApp);
        NaviOnlineService$NaviOnlineMapOverlay[] naviOnlineService$NaviOnlineMapOverlayArray = this.extractMapOverlays(hMIProperties, bl);
        if (naviOnlineService$NaviOnlineMapOverlayArray.length > 0) {
            int n2 = hMIProperties.getInt("mapOverlayDelay");
            if (n2 < 0) {
                n2 = 5000;
            }
            ++this.setId;
            this.logChannel.log(1078071040, "HMIViewMapListener#updateViewProperties: Setting %1 overlays, set ID is %2, delay is %3", (Object)Integer.toString(naviOnlineService$NaviOnlineMapOverlayArray.length), (Object)Integer.toString(this.setId), (Object)Integer.toString(n2));
            naviOnlineService.setMapOverlays(this.setId, naviOnlineService$NaviOnlineMapOverlayArray, n2, null);
        }
    }

    private NaviOnlineService$NaviOnlineMapOverlay[] extractMapOverlays(HMIProperties hMIProperties, boolean bl) {
        String string = hMIProperties.getString("mapOverlayTransparentDefault");
        double[] dArray = hMIProperties.getDoubleArray("mapOverlayLat1");
        double[] dArray2 = hMIProperties.getDoubleArray("mapOverlayLon1");
        double[] dArray3 = hMIProperties.getDoubleArray("mapOverlayLat2");
        double[] dArray4 = hMIProperties.getDoubleArray("mapOverlayLon2");
        String[] stringArray = hMIProperties.getStringArray("mapOverlayPath");
        String[] stringArray2 = hMIProperties.getStringArray("mapOverlayDescription");
        int n = Math.min(dArray.length, dArray2.length);
        n = Math.min(n, dArray3.length);
        n = Math.min(n, dArray4.length);
        n = Math.min(n, stringArray.length);
        this.logChannel.log(1078071040, "HMIViewMapListener#extractMapOverlays: Length is %1", (long)n);
        boolean bl2 = false;
        NaviOnlineService$NaviOnlineMapOverlay[] naviOnlineService$NaviOnlineMapOverlayArray = new NaviOnlineService$NaviOnlineMapOverlay[n];
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl3 = false;
            String string2 = stringArray[i2];
            if (string2 == null || string2.length() == 0) {
                bl3 = true;
                bl2 = true;
                string2 = string;
            }
            naviOnlineService$NaviOnlineMapOverlayArray[i2] = new NaviOnlineService$NaviOnlineMapOverlay();
            naviOnlineService$NaviOnlineMapOverlayArray[i2].rectangle = this.createNavRectangle(dArray[i2], dArray2[i2], dArray3[i2], dArray4[i2]);
            naviOnlineService$NaviOnlineMapOverlayArray[i2].path = string2;
            naviOnlineService$NaviOnlineMapOverlayArray[i2].description = i2 < stringArray2.length ? stringArray2[i2] : "";
            this.logChannel.log(1078071040, "HMIViewMapListener#extractMapOverlays: index %1 - description %2, path %3 (%4)", (Object)Integer.toString(i2), (Object)naviOnlineService$NaviOnlineMapOverlayArray[i2].description, (Object)naviOnlineService$NaviOnlineMapOverlayArray[i2].path, (Object)(bl3 ? "missing" : "available"));
        }
        if (bl2 && n > 0) {
            this.logChannel.log(1078071040, "HMIViewMapListener#extractMapOverlays: sending the first image of %1 %2", (Object)new Integer(n), (Object)(naviOnlineService$NaviOnlineMapOverlayArray[0].path.equals(string) ? "(transparent image)" : ""));
            return new NaviOnlineService$NaviOnlineMapOverlay[]{naviOnlineService$NaviOnlineMapOverlayArray[0]};
        }
        this.logChannel.log(1078071040, "HMIViewMapListener#extractMapOverlays: sending the full array of %1 images", (long)n);
        return naviOnlineService$NaviOnlineMapOverlayArray;
    }

    private NavRectangle createNavRectangle(double d2, double d3, double d4, double d5) {
        int n = NavigationUtilities.degreeToWgs84(Math.min(d3, d5));
        int n2 = NavigationUtilities.degreeToWgs84(Math.max(d3, d5));
        int n3 = NavigationUtilities.degreeToWgs84(Math.min(d2, d4));
        int n4 = NavigationUtilities.degreeToWgs84(Math.max(d2, d4));
        NavRectangle navRectangle = new NavRectangle();
        navRectangle.xLeft = n;
        navRectangle.xRight = n2;
        navRectangle.yBottom = n3;
        navRectangle.yUp = n4;
        return navRectangle;
    }

    private NaviOnlineService$POIOnlineData[] extractPinData(HMIProperties hMIProperties) {
        double[] dArray = hMIProperties.getDoubleArray("lon");
        double[] dArray2 = hMIProperties.getDoubleArray("lat");
        String[] stringArray = hMIProperties.getStringArray("listText");
        int n = Math.min(dArray.length, dArray2.length);
        n = Math.min(n, stringArray.length);
        NaviOnlineService$POIOnlineData[] naviOnlineService$POIOnlineDataArray = new NaviOnlineService$POIOnlineData[n];
        for (int i2 = 0; i2 < naviOnlineService$POIOnlineDataArray.length; ++i2) {
            List list = this.extractListText(stringArray, i2);
            NaviOnlineService$POIOnlineData naviOnlineService$POIOnlineData = new NaviOnlineService$POIOnlineData();
            naviOnlineService$POIOnlineData.latitude = NavigationUtilities.degreeToWgs84(dArray2[i2]);
            naviOnlineService$POIOnlineData.longitude = NavigationUtilities.degreeToWgs84(dArray[i2]);
            int n2 = list.size();
            naviOnlineService$POIOnlineData.line0 = n2 > 0 ? (String)list.get(0) : "";
            naviOnlineService$POIOnlineData.line1 = n2 > 1 ? (String)list.get(1) : "";
            naviOnlineService$POIOnlineDataArray[i2] = naviOnlineService$POIOnlineData;
            this.logChannel.log(1078071040, "HMIViewMapListener#extractPinData: extracting PIN lat: %1 lon: %2", (long)naviOnlineService$POIOnlineData.latitude, (long)naviOnlineService$POIOnlineData.longitude);
        }
        return naviOnlineService$POIOnlineDataArray;
    }

    private List extractListText(String[] stringArray, int n) {
        String string;
        String string2 = string = stringArray != null && stringArray.length > n ? stringArray[n] : "";
        if (string == null) {
            string = "";
        }
        List list = StringUtilities.split(string, '\n');
        return list;
    }

    private NavLocationWgs84 extractFocussedLocation(HMIProperties hMIProperties) {
        double[] dArray = hMIProperties.getDoubleArray("lon");
        double[] dArray2 = hMIProperties.getDoubleArray("lat");
        int n = 0;
        int n2 = NavigationUtilities.degreeToWgs84(dArray2[n]);
        int n3 = NavigationUtilities.degreeToWgs84(dArray[n]);
        this.logChannel.log(1078071040, "HMIViewMapListener#extractFocussedLocation: selected item at index %1 (lat: %2, long: %3)", (long)n, (long)n2, (long)n3);
        NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(n3, n2);
        return navLocationWgs84;
    }

    public int getViewID() {
        return 6000;
    }

    @Override
    public void indicateSelectedMapFlag(int n) {
        this.logChannel.log(1078071040, "HMIViewMapListener#indicateSelectedMapFlag(%1): called...", (long)n);
        RemoteHMIAction remoteHMIAction = this.getAction(300);
        remoteHMIAction.getParameters().putInt("selectedNumber", n);
        remoteHMIAction.getParameters().putString("selectedId", this.getSelectedId(n));
        remoteHMIAction.getParameters().putString("actionId", this.getSelectedId(n));
        this.invokeAction(remoteHMIAction);
    }

    @Override
    public void indicateRouteGuidanceFinished(NavLocation navLocation, String string) {
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "HMIViewMapListener#indicateRouteGuidanceFinished: given navLocation should\u00b4nt be NULL!");
            return;
        }
        int n = navLocation.getLatitude();
        int n2 = navLocation.getLongitude();
        String string2 = string;
        this.logChannel.log(1078071040, "HMIViewMapListener#indicateRouteGuidanceFinished: with lat %1, lon %2 and PoiID %3", (Object)new Integer(n), (Object)new Integer(n2), (Object)string2);
        RemoteHMIAction remoteHMIAction = this.getAction(1371117568);
        remoteHMIAction.getParameters().putInt("guidanceResultLat", n);
        remoteHMIAction.getParameters().putInt("guidanceResultLon", n2);
        remoteHMIAction.getParameters().putString("guidanceResultLon", string2);
        this.invokeAction(remoteHMIAction);
    }
}

