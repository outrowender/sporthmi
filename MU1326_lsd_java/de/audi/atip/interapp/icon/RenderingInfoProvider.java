/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.icon;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;

public interface RenderingInfoProvider {
    public void getResourceIdForPoiIconAsync(int var1, int var2, PoiIconCallback var3);

    public void getResourceIdForTrafficSignAsync(int var1, int var2, TrafficSignCallback var3);

    public RenderingInfo getResourceIdForTMCEventIcon(int var1, int var2);

    public RenderingInfo getResourceIdForPOIIcon(int var1, int var2);

    public void flushCacheForPOIIcon();

    public ExtRenderingInfo getRenderingInformationForExitIcon(int var1, int var2);

    public ExtRenderingInfo getRenderingInformationForRoadIcon(int var1, int var2);

    public RenderingInfo getResourceIdForTargetIcon(int var1);

    public RenderingInfo getResourceIdForTrafficRegulationIconWithSubindex(int var1, int var2, int var3);

    public RenderingInfo getResourceIdForTrafficRegulationIcon(int var1, int var2);

    public RenderingInfo getResourceIdForTrafficRegulationIcon(int var1, int var2, int var3);

    public RenderingInfo getResourceIdForRoadClassIcon(int var1, int var2);

    public RenderingInfo getResourceIdForAdditionalInfoIcon(int var1, int var2);

    public RenderingInfo getResourceIdForCountryIcon(int var1);

    public RenderingInfo resourceIdForPOIIconFromRawData(int var1, int var2);

    public void setSatMapCallback(SatelliteMapsLogoCallback var1);

    public static interface PoiIconCallback {
        public void renderingInfoReceived(int var1, int var2, RenderingInfo var3);
    }

    public static interface TrafficSignCallback {
        public void renderingInfoReceived(int var1, int var2, RenderingInfo var3);
    }

    public static interface SatelliteMapsLogoCallback {
        public void renderingInformationForSatelliteLogo(RenderingInfo var1);
    }

    public static interface SatelliteMapsLogoConstants {
        public static final int SATELLITE_LOGO_STYLEREF_MAIN_COLORED = 204;
        public static final int SATELLITE_LOGO_STYLEREF_COMBI_COLORED = 206;
        public static final int RESOURCEID_SATELLITE_LOGO_MAIN_COLORED_NOT_YET_AVAILABLE = 0x60000001;
        public static final int RESOURCEID_SATELLITE_LOGO_MAIN_COLORED = 0x60000011;
        public static final int RESOURCEID_SATELLITE_LOGO_COMBI_COLORED = 1610612755;
        public static final int RESOURCEID_SATELLITE_LOGO_COMBI_COLORED_NOT_YET_AVAILABLE = 0x60000003;
    }
}

