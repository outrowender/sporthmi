/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.icon;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider$PoiIconCallback;
import de.audi.atip.interapp.icon.RenderingInfoProvider$SatelliteMapsLogoCallback;
import de.audi.atip.interapp.icon.RenderingInfoProvider$TrafficSignCallback;

public interface RenderingInfoProvider {
    default public void getResourceIdForPoiIconAsync(int n, int n2, RenderingInfoProvider$PoiIconCallback renderingInfoProvider$PoiIconCallback) {
    }

    default public void getResourceIdForTrafficSignAsync(int n, int n2, RenderingInfoProvider$TrafficSignCallback renderingInfoProvider$TrafficSignCallback) {
    }

    default public RenderingInfo getResourceIdForTMCEventIcon(int n, int n2) {
    }

    default public RenderingInfo getResourceIdForPOIIcon(int n, int n2) {
    }

    default public void flushCacheForPOIIcon() {
    }

    default public ExtRenderingInfo getRenderingInformationForExitIcon(int n, int n2) {
    }

    default public ExtRenderingInfo getRenderingInformationForRoadIcon(int n, int n2) {
    }

    default public RenderingInfo getResourceIdForTargetIcon(int n) {
    }

    default public RenderingInfo getResourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3) {
    }

    default public RenderingInfo getResourceIdForTrafficRegulationIcon(int n, int n2) {
    }

    default public RenderingInfo getResourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
    }

    default public RenderingInfo getResourceIdForRoadClassIcon(int n, int n2) {
    }

    default public RenderingInfo getResourceIdForAdditionalInfoIcon(int n, int n2) {
    }

    default public RenderingInfo getResourceIdForCountryIcon(int n) {
    }

    default public RenderingInfo resourceIdForPOIIconFromRawData(int n, int n2) {
    }

    default public void setSatMapCallback(RenderingInfoProvider$SatelliteMapsLogoCallback renderingInfoProvider$SatelliteMapsLogoCallback) {
    }
}

