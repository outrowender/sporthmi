/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.icon.RenderingInfoProvider$PoiIconCallback;
import de.audi.atip.interapp.icon.RenderingInfoProvider$SatelliteMapsLogoCallback;
import de.audi.atip.interapp.icon.RenderingInfoProvider$TrafficSignCallback;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.iconrenderer.IconRenderer$AdditionalInfoIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$CountryIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$EventQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$ExitQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$Key;
import de.audi.tghu.iconrenderer.IconRenderer$PoiFromRawDataQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$PoiQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$RequestQueue;
import de.audi.tghu.iconrenderer.IconRenderer$RoadClassIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$RoadQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$SatelliteMapsLogoQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$TargetIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$TrafficRegulationIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$TrafficSignElement;
import de.audi.tghu.iconrenderer.IconRendererSimulation;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.dsi.ifc.iconhandling.DSIIconExtractorListener;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class IconRenderer
implements DSIIconExtractorListener,
RenderingInfoProvider {
    private static final long TIME;
    private static final int DEFAULT_ICONSIZE;
    private LogChannel lc;
    private DSIIconExtractor dsiIconrenderer;
    private Map eventMap;
    private Map targetIconMap;
    private Map roadClassIconMap;
    private Map additionalInfoIconMap;
    private Map poiMap;
    private Map trafficRegulationIconWithSubindexMap;
    private Map trafficSignMap;
    private Map roadMap;
    private Map exitMap;
    private Map countryIconMap;
    private Map poiFromRawDataMap;
    private IconRenderer$RequestQueue roadIconQueue;
    private IconRenderer$RequestQueue exitIconQueue;
    private IconRenderer$RequestQueue eventIconQueue;
    private IconRenderer$RequestQueue poiIconQueue;
    private IconRenderer$RequestQueue trafficRegulationIconWithSubindexQueue;
    private IconRenderer$RequestQueue targetIconQueue;
    private IconRenderer$RequestQueue roadClassIconQueue;
    private IconRenderer$RequestQueue additionalInfoIconQueue;
    private IconRenderer$RequestQueue trafficSignQueue;
    private IconRenderer$RequestQueue countryIconQueue;
    private IconRenderer$RequestQueue poiIconFromRawDataQueue;
    private IconRenderer$RequestQueue satMapsLogosQueue;
    private boolean iconRequestedForSatMaps = false;
    private boolean iconWasNotYetAvailable = false;
    private RenderingInfoProvider$SatelliteMapsLogoCallback satMapCallback = null;
    private boolean callbackForLogoMainReceived = false;
    private boolean callbackForLogoCombiReceived = false;

    IconRenderer(LogChannel logChannel) {
        this.lc = logChannel;
        this.eventMap = new HashMap(50);
        this.targetIconMap = new HashMap(50);
        this.roadClassIconMap = new HashMap(50);
        this.additionalInfoIconMap = new HashMap(50);
        this.poiMap = new HashMap(100);
        this.trafficRegulationIconWithSubindexMap = new HashMap(50);
        this.trafficSignMap = new HashMap(50);
        this.roadMap = new HashMap(50);
        this.exitMap = new HashMap(10);
        this.countryIconMap = new HashMap(50);
        this.poiFromRawDataMap = new HashMap(50);
        this.roadIconQueue = new IconRenderer$RequestQueue(this, null);
        this.exitIconQueue = new IconRenderer$RequestQueue(this, null);
        this.eventIconQueue = new IconRenderer$RequestQueue(this, null);
        this.poiIconQueue = new IconRenderer$RequestQueue(this, null);
        this.trafficSignQueue = new IconRenderer$RequestQueue(this, null);
        this.targetIconQueue = new IconRenderer$RequestQueue(this, null);
        this.trafficRegulationIconWithSubindexQueue = new IconRenderer$RequestQueue(this, null);
        this.roadClassIconQueue = new IconRenderer$RequestQueue(this, null);
        this.additionalInfoIconQueue = new IconRenderer$RequestQueue(this, null);
        this.countryIconQueue = new IconRenderer$RequestQueue(this, null);
        this.poiIconFromRawDataQueue = new IconRenderer$RequestQueue(this, null);
        this.satMapsLogosQueue = new IconRenderer$RequestQueue(this, null);
        this.dsiIconrenderer = new IconRendererSimulation(this, logChannel);
    }

    public void setDSIIconrenderer(DSIIconExtractor dSIIconExtractor) {
        this.lc.log(-2137614336, "[IconRenderer#setDSIIconrenderer] Called ");
        this.dsiIconrenderer = dSIIconExtractor;
    }

    private synchronized RenderingInfo getFromEventIconCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromEventIconCache] iconId=%1, subIndex=%2", (long)n, (long)n2);
        return (RenderingInfo)this.eventMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized RenderingInfo getFromPoiIconCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromPoiIconCache] catNumber=%1, subIndex: %2 ", (long)n, (long)n2);
        return (RenderingInfo)this.poiMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized RenderingInfo getFromPoiIconRawDataCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromPoiIconRawDataCache] countryCode=%1, catReference: %2", (long)n, (long)n2);
        return (RenderingInfo)this.poiFromRawDataMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized RenderingInfo getFromTargetIconCache(int n) {
        this.lc.log(-2137614336, "[IconRenderer#getFromTargetIconCache] styleReference=%1", (long)n);
        return (RenderingInfo)this.targetIconMap.get(new IconRenderer$Key(this, n));
    }

    private synchronized RenderingInfo getFromRoadClassIconCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromRoadClassIconCache] iconId=%1, variant=%2", (long)n, (long)n2);
        return (RenderingInfo)this.roadClassIconMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized RenderingInfo getFromAdditionalInfoIconCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromAdditionalInfoIconCache] iconId=%1, variant=%2", (long)n, (long)n2);
        return (RenderingInfo)this.additionalInfoIconMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized RenderingInfo getFromTrafficRegulationIconWithSubindexCache(int n, int n2, int n3) {
        this.lc.log(-2137614336, "[IconRenderer#getFromTrafficRegulationIconWithSubindexCache] iconId=%1, variant=%2, subIndex=%3", (long)n, (long)n2, (long)n3);
        return (RenderingInfo)this.trafficRegulationIconWithSubindexMap.get(new IconRenderer$Key(this, n, n2, n3));
    }

    private synchronized RenderingInfo getFromCountryIconCache(int n) {
        this.lc.log(-2137614336, "[IconRenderer#getFromCountryIconCache] iconId=%1", (long)n);
        return (RenderingInfo)this.countryIconMap.get(new IconRenderer$Key(this, n));
    }

    private synchronized RenderingInfo getFromTrafficSignCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromTrafficSignCache] signID=%1, variant=%2", (long)n, (long)n2);
        return this.getFromTrafficSignCache(n, n2, 1);
    }

    private synchronized RenderingInfo getFromTrafficSignCache(int n, int n2, int n3) {
        this.lc.log(-2137614336, "[IconRenderer#getFromTrafficSignCache] signID=%1, variant=%2, size=%3", (long)n, (long)n2, (long)n3);
        return (RenderingInfo)this.trafficSignMap.get(new IconRenderer$Key(this, n, n2, n3));
    }

    private synchronized RenderingInfo getFromRoadIconCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromRoadIconCache] iconRef=%1, textLen=%2 ", (long)n, (long)n2);
        return (RenderingInfo)this.roadMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized RenderingInfo getFromExitIconCache(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getFromExitIconCache] iconRef=%1, textLen=%2 ", (long)n, (long)n2);
        return (RenderingInfo)this.exitMap.get(new IconRenderer$Key(this, n, n2));
    }

    private synchronized void putIntoEventIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoEventIconCache] renderingInfo: %1", (Object)renderingInfo);
        this.eventMap.put(new IconRenderer$Key(this, n, n2), renderingInfo);
    }

    private synchronized void putIntoTargetIconCache(int n, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoTargetIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.targetIconMap.put(new IconRenderer$Key(this, n), renderingInfo);
    }

    private synchronized void putIntoTrafficRegulationIconWithSubindexCache(int n, int n2, int n3, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoTrafficRegulationIconWithSubindexCache] renderingInfo=%1", (Object)renderingInfo);
        this.trafficRegulationIconWithSubindexMap.put(new IconRenderer$Key(this, n, n2, n3), renderingInfo);
    }

    private synchronized void putIntoTrafficSignCache(int n, int n2, int n3, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoTrafficSignCache] renderingInfo=%1", (Object)renderingInfo);
        this.trafficSignMap.put(new IconRenderer$Key(this, n, n2, n3), renderingInfo);
    }

    private synchronized void putIntoRoadClassIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoRoadClassIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.roadClassIconMap.put(new IconRenderer$Key(this, n), renderingInfo);
    }

    private synchronized void putIntoAdditionalInfoIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoAdditionalInfoIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.additionalInfoIconMap.put(new IconRenderer$Key(this, n, n2), renderingInfo);
    }

    private synchronized void putIntoPoiIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoPoiIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.poiMap.put(new IconRenderer$Key(this, n, n2), renderingInfo);
    }

    private synchronized void putIntoPoiIconRawDataCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoPoiIconRawDataCache] renderingInfo=%1", (Object)renderingInfo);
        this.poiFromRawDataMap.put(new IconRenderer$Key(this, n, n2), renderingInfo);
    }

    private synchronized void putIntoRoadIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoRoadIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.roadMap.put(new IconRenderer$Key(this, n, n2), renderingInfo);
    }

    private synchronized void putIntoExitIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoExitIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.exitMap.put(new IconRenderer$Key(this, n, n2), renderingInfo);
    }

    private synchronized void putIntoCountryIconCache(int n, RenderingInfo renderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#putIntoCountryIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.countryIconMap.put(new IconRenderer$Key(this, n), renderingInfo);
    }

    @Override
    public RenderingInfo getResourceIdForTMCEventIcon(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTMCEventIcon] Called, icon ID: %1, subindex: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromEventIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTMCEventIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForTMCEventIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$EventQueueElement iconRenderer$EventQueueElement = new IconRenderer$EventQueueElement(this, 1000, n, n2);
        this.eventIconQueue.queue(iconRenderer$EventQueueElement);
        return iconRenderer$EventQueueElement.waitForResponse();
    }

    @Override
    public void getResourceIdForPoiIconAsync(int n, int n2, RenderingInfoProvider$PoiIconCallback renderingInfoProvider$PoiIconCallback) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForPoiIconAsync] catNum=%1, subIndex=%2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromPoiIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForPoiIconAsync] Return cached info=%1", (Object)renderingInfo);
            if (renderingInfoProvider$PoiIconCallback != null) {
                renderingInfoProvider$PoiIconCallback.renderingInfoReceived(n, n2, renderingInfo);
            } else {
                this.lc.log(10000, "[IconRenderer#getResourceIdForPoiIconAsync] callback is null");
            }
            return;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForPoiIconAsync] No icon renderer DSI available!");
            return;
        }
        IconRenderer$PoiQueueElement iconRenderer$PoiQueueElement = new IconRenderer$PoiQueueElement(this, 1001, n, n2, renderingInfoProvider$PoiIconCallback);
        this.poiIconQueue.queue(iconRenderer$PoiQueueElement);
    }

    @Override
    public void getResourceIdForTrafficSignAsync(int n, int n2, RenderingInfoProvider$TrafficSignCallback renderingInfoProvider$TrafficSignCallback) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTrafficSignAsync] signID: %1, variant: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromTrafficSignCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTrafficSignAsync] Return cached info object: %1", (Object)renderingInfo);
            if (renderingInfoProvider$TrafficSignCallback != null) {
                renderingInfoProvider$TrafficSignCallback.renderingInfoReceived(n, n2, renderingInfo);
            } else {
                this.lc.log(10000, "[IconRenderer#getResourceIdForTrafficSignAsync] callback is null");
            }
            return;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForTrafficSignAsync] No icon renderer DSI available!");
            return;
        }
        IconRenderer$TrafficSignElement iconRenderer$TrafficSignElement = new IconRenderer$TrafficSignElement(this, 1005, n, n2, renderingInfoProvider$TrafficSignCallback, null);
        this.trafficSignQueue.queue(iconRenderer$TrafficSignElement);
    }

    @Override
    public RenderingInfo getResourceIdForPOIIcon(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForPOIIcon] catNumber: %1, subIndex: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromPoiIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForPOIIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForTMCEventIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$PoiQueueElement iconRenderer$PoiQueueElement = new IconRenderer$PoiQueueElement(this, 1001, n, n2, null);
        this.poiIconQueue.queue(iconRenderer$PoiQueueElement);
        return iconRenderer$PoiQueueElement.waitForResponse();
    }

    @Override
    public RenderingInfo resourceIdForPOIIconFromRawData(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForPOIIconFromRawData] countryCode: %1, catReference: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromPoiIconRawDataCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#resourceIdForPOIIconFromRawData] Return cached RenderingInfo object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#resourceIdForPOIIconFromRawData] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$PoiFromRawDataQueueElement iconRenderer$PoiFromRawDataQueueElement = new IconRenderer$PoiFromRawDataQueueElement(this, 1025, n, n2, null);
        this.poiIconFromRawDataQueue.queue(iconRenderer$PoiFromRawDataQueueElement);
        return iconRenderer$PoiFromRawDataQueueElement.waitForResponse();
    }

    @Override
    public synchronized void flushCacheForPOIIcon() {
        this.lc.log(1078071040, "[IconRenderer#flushCacheForPOIIcon] flushing POI icon cache");
        this.poiMap = new HashMap(50);
        this.poiFromRawDataMap = new HashMap(50);
    }

    @Override
    public ExtRenderingInfo getRenderingInformationForRoadIcon(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getRenderingInformationForRoadIcon] iconReference: %1, iconRef: %2", (long)n, (long)n2);
        ExtRenderingInfo extRenderingInfo = (ExtRenderingInfo)this.getFromRoadIconCache(n, n2);
        if (extRenderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getRenderingInformationForRoadIcon] Return cached info object: %1", (Object)extRenderingInfo);
            return extRenderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getRenderingInformationForRoadIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$RoadQueueElement iconRenderer$RoadQueueElement = new IconRenderer$RoadQueueElement(this, 1002, n, n2);
        this.roadIconQueue.queue(iconRenderer$RoadQueueElement);
        return (ExtRenderingInfo)iconRenderer$RoadQueueElement.waitForResponse();
    }

    @Override
    public ExtRenderingInfo getRenderingInformationForExitIcon(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getRenderingInformationForExitIcon] iconRef: %1, textLength: %2", (long)n, (long)n2);
        ExtRenderingInfo extRenderingInfo = (ExtRenderingInfo)this.getFromExitIconCache(n, n2);
        if (extRenderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getRenderingInformationForExitIcon] Return cached info object: %1", (Object)extRenderingInfo);
            return extRenderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getRenderingInformationForExitIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$ExitQueueElement iconRenderer$ExitQueueElement = new IconRenderer$ExitQueueElement(this, 1006, n, n2);
        this.exitIconQueue.queue(iconRenderer$ExitQueueElement);
        return (ExtRenderingInfo)iconRenderer$ExitQueueElement.waitForResponse();
    }

    @Override
    public RenderingInfo getResourceIdForTargetIcon(int n) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTargetIcon] Called, styleReference: %1", (long)n);
        RenderingInfo renderingInfo = this.getFromTargetIconCache(n);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTargetIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForTargetIcon] No icon renderer DSI available!");
            return null;
        }
        if (this.isSatelliteLogoStyleRef(n)) {
            IconRenderer$SatelliteMapsLogoQueueElement iconRenderer$SatelliteMapsLogoQueueElement = new IconRenderer$SatelliteMapsLogoQueueElement(this, 1003, n);
            this.satMapsLogosQueue.queue(iconRenderer$SatelliteMapsLogoQueueElement);
            this.iconRequestedForSatMaps = true;
            return iconRenderer$SatelliteMapsLogoQueueElement.waitForResponse();
        }
        IconRenderer$TargetIconQueueElement iconRenderer$TargetIconQueueElement = new IconRenderer$TargetIconQueueElement(this, 1003, n);
        this.targetIconQueue.queue(iconRenderer$TargetIconQueueElement);
        return iconRenderer$TargetIconQueueElement.waitForResponse();
    }

    @Override
    public RenderingInfo getResourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTrafficRegulationIconWithSubindex] Called, iconId: %1, variant: %2, subIndex: %3", (long)n, (long)n2, (long)n3);
        RenderingInfo renderingInfo = this.getFromTrafficRegulationIconWithSubindexCache(n, n2, n3);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTrafficRegulationIconWithSubindex] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForTrafficRegulationIconWithSubindex] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$TrafficRegulationIconQueueElement iconRenderer$TrafficRegulationIconQueueElement = new IconRenderer$TrafficRegulationIconQueueElement(this, 1009, n, n2, n3);
        this.trafficRegulationIconWithSubindexQueue.queue(iconRenderer$TrafficRegulationIconQueueElement);
        return iconRenderer$TrafficRegulationIconQueueElement.waitForResponse();
    }

    @Override
    public RenderingInfo getResourceIdForTrafficRegulationIcon(int n, int n2) {
        return this.getResourceIdForTrafficRegulationIcon(n, n2, 1);
    }

    @Override
    public RenderingInfo getResourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTrafficRegulationIcon] Called, iconId: %1, variant: %2, size: %3", (long)n, (long)n2, (long)n3);
        RenderingInfo renderingInfo = this.getFromTrafficSignCache(n, n2, n3);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForTrafficRegulationIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForTrafficRegulationIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$TrafficSignElement iconRenderer$TrafficSignElement = new IconRenderer$TrafficSignElement(this, 1005, n, n2, n3, null);
        this.trafficSignQueue.queue(iconRenderer$TrafficSignElement);
        return iconRenderer$TrafficSignElement.waitForResponse();
    }

    @Override
    public RenderingInfo getResourceIdForRoadClassIcon(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForRoadClassIcon] Called, iconId: %1, variant: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromRoadClassIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForRoadClassIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForRoadClassIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$RoadClassIconQueueElement iconRenderer$RoadClassIconQueueElement = new IconRenderer$RoadClassIconQueueElement(this, 1004, n, n2);
        this.roadClassIconQueue.queue(iconRenderer$RoadClassIconQueueElement);
        return iconRenderer$RoadClassIconQueueElement.waitForResponse();
    }

    @Override
    public RenderingInfo getResourceIdForAdditionalInfoIcon(int n, int n2) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForAdditionalInfoIcon] Called, iconId: %1, variant: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromAdditionalInfoIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForAdditionalInfoIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForAdditionalInfoIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$AdditionalInfoIconQueueElement iconRenderer$AdditionalInfoIconQueueElement = new IconRenderer$AdditionalInfoIconQueueElement(this, 1007, n, n2);
        this.additionalInfoIconQueue.queue(iconRenderer$AdditionalInfoIconQueueElement);
        return iconRenderer$AdditionalInfoIconQueueElement.waitForResponse();
    }

    @Override
    public RenderingInfo getResourceIdForCountryIcon(int n) {
        this.lc.log(-2137614336, "[IconRenderer#getResourceIdForCountryIcon] Called, iconId: %1", (long)n);
        RenderingInfo renderingInfo = this.getFromCountryIconCache(n);
        if (renderingInfo != null) {
            this.lc.log(-2137614336, "[IconRenderer#getResourceIdForCountryIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(-1601830656, "[IconRenderer#getResourceIdForCountryIcon] No icon renderer DSI available!");
            return null;
        }
        IconRenderer$CountryIconQueueElement iconRenderer$CountryIconQueueElement = new IconRenderer$CountryIconQueueElement(this, 1008, n);
        this.countryIconQueue.queue(iconRenderer$CountryIconQueueElement);
        return iconRenderer$CountryIconQueueElement.waitForResponse();
    }

    @Override
    public void renderingInformationForRoadIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        ExtRenderingInfo extRenderingInfo;
        this.lc.log(-2137614336, "[IconRenderer#renderingInformationForRoadIcon] Called, info: %1, resourceLocator: %2", (Object)textRenderingInfo, (Object)resourceLocator);
        if (resourceLocator != null && textRenderingInfo != null) {
            extRenderingInfo = new ExtRenderingInfo(resourceLocator.getId(), textRenderingInfo.fontReference, textRenderingInfo.fontSize, textRenderingInfo.fontColor, textRenderingInfo.deltaX, textRenderingInfo.deltaY, true);
        } else {
            this.lc.log(10000, "[IconRenderer#renderingInformationForRoadIcon] info or resourceLocator is null");
            extRenderingInfo = new ExtRenderingInfo(-1, -1, -1, -1, -1, -1, false);
        }
        this.roadIconQueue.dequeue(extRenderingInfo, true);
    }

    @Override
    public void resourceIdForPOIIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForPOIIcon] Called, resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.poiIconQueue, resourceLocator);
    }

    @Override
    public void resourceIdForTMCEventIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForTMCEventIcon] Called, resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.eventIconQueue, resourceLocator);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[IconRenderer#asyncException] errorCode=%2, Msg=%1, request=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void resourceIdForTargetIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForTargetIcon] Called, resourceLocator: %1", (Object)resourceLocator);
        if (this.iconRequestedForSatMaps) {
            this.dequeueResource(this.satMapsLogosQueue, resourceLocator);
            this.iconRequestedForSatMaps = false;
        } else if (this.iconWasNotYetAvailable && this.isSatelliteLogoResourceID(resourceLocator)) {
            if (this.satMapCallback == null) {
                this.lc.log(10000, "[IconRenderer#dequeueResource] SatMapsCallBack is null");
                return;
            }
            this.satMapCallback.renderingInformationForSatelliteLogo(resourceLocator == null ? new RenderingInfo(-1, false) : new RenderingInfo(resourceLocator.getId(), true));
            if (resourceLocator != null) {
                if (resourceLocator.getId() == 204) {
                    this.callbackForLogoMainReceived = true;
                } else if (resourceLocator.getId() == 206) {
                    this.callbackForLogoCombiReceived = true;
                }
            }
            if (this.callbackForLogoMainReceived && this.callbackForLogoCombiReceived) {
                this.iconWasNotYetAvailable = false;
                this.callbackForLogoCombiReceived = false;
                this.callbackForLogoMainReceived = false;
            }
        } else {
            this.dequeueResource(this.targetIconQueue, resourceLocator);
        }
    }

    @Override
    public void resourceIdForTrafficRegulationIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForTrafficRegulationIcon] resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.trafficSignQueue, resourceLocator);
    }

    @Override
    public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForTrafficRegulationIconWithSubIndex] Called unexpectedly, rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.trafficRegulationIconWithSubindexQueue, resourceLocator);
    }

    @Override
    public void resourceIdForPOIIconFromRawDataResult(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForPOIIconFromRawDataResult] Called, resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.poiIconFromRawDataQueue, resourceLocator);
    }

    @Override
    public void iconResult(int n) {
        this.lc.log(-2137614336, "[IconRenderer#iconResult] Called, result: %1", (long)n);
    }

    @Override
    public void resourceIdForRoadClassIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForRoadClassIcon] Called, rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.roadClassIconQueue, resourceLocator);
    }

    @Override
    public void renderingInformationForExitIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        ExtRenderingInfo extRenderingInfo;
        this.lc.log(-2137614336, "[IconRenderer#renderingInformationForExitIcon] rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
        if (resourceLocator != null && textRenderingInfo != null) {
            extRenderingInfo = new ExtRenderingInfo(resourceLocator.getId(), textRenderingInfo.fontReference, textRenderingInfo.fontSize, textRenderingInfo.fontColor, textRenderingInfo.deltaX, textRenderingInfo.deltaY, true);
        } else {
            this.lc.log(10000, "[IconRenderer#renderingInformationForExitIcon] info or resourceLocator is null");
            extRenderingInfo = new ExtRenderingInfo(-1, -1, -1, -1, -1, -1, false);
        }
        this.exitIconQueue.dequeue(extRenderingInfo, true);
    }

    @Override
    public void renderingInformationForExitIconWithVariant(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#renderingInformationForExitIconWithVariant] Called unexpectedly, rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
    }

    @Override
    public void resourceIdForAdditionalIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForAdditionalIcon] rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.additionalInfoIconQueue, resourceLocator);
    }

    @Override
    public void resourceIdForCountryIcon(ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#resourceIdForCountryIcon] rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.countryIconQueue, resourceLocator);
    }

    public void tmcEventIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#tmcEventIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForTMCEventIcon(resourceLocator);
    }

    public void poiIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#poiIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForPOIIcon(resourceLocator);
    }

    public void roadIcon(int n, ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#roadIcon] rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
        this.renderingInformationForRoadIcon(resourceLocator, textRenderingInfo);
    }

    public void destinationIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#destinationIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForTargetIcon(resourceLocator);
    }

    public void roadClassIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#roadClassIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForRoadClassIcon(resourceLocator);
    }

    public void countryInfoIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#countryInfoIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForAdditionalIcon(resourceLocator);
    }

    public void countryFlagIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#countryFlagIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForCountryIcon(resourceLocator);
    }

    public void trafficRegulationIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "[IconRenderer#trafficRegulationIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForTrafficRegulationIcon(resourceLocator);
    }

    public void exitIcon(int n, ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.lc.log(-2137614336, "[IconRenderer#exitIcon] rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
        this.renderingInformationForExitIcon(resourceLocator, textRenderingInfo);
    }

    @Override
    public void setBrandIconStyleResult(int n) {
        this.lc.log(-2137614336, "[IconRenderer#setBrandIconStyleResult] result: %1", (long)n);
    }

    private void dequeueResource(IconRenderer$RequestQueue iconRenderer$RequestQueue, ResourceLocator resourceLocator) {
        RenderingInfo renderingInfo;
        if (iconRenderer$RequestQueue == null) {
            this.lc.log(10000, "[IconRenderer#dequeueResource] queue is null");
            return;
        }
        if (resourceLocator == null) {
            this.lc.log(-1601830656, "[IconRenderer#dequeueResource] resourceLocator is null: requested icon not available!");
            renderingInfo = new RenderingInfo(-1, false);
        } else if (this.isSatelliteLogoNotAvailableYet(resourceLocator)) {
            this.iconWasNotYetAvailable = true;
            renderingInfo = new RenderingInfo(resourceLocator.getId(), true);
        } else {
            renderingInfo = new RenderingInfo(resourceLocator.getId(), true);
        }
        iconRenderer$RequestQueue.dequeue(renderingInfo, true);
    }

    @Override
    public void resourceIdForTrafficSourceIconResult(ResourceLocator resourceLocator) {
    }

    @Override
    public void resourceIdForAreaWarningIconResult(ResourceLocator resourceLocator) {
    }

    @Override
    public void resourceIdForAdditionalTurnListIconResult(ResourceLocator resourceLocator) {
    }

    @Override
    public void resourceIdForComposedPOIIconResult(ResourceLocator resourceLocator) {
    }

    private boolean isSatelliteLogoStyleRef(int n) {
        return n == 204 || n == 206;
    }

    private boolean isSatelliteLogoNotAvailableYet(ResourceLocator resourceLocator) {
        return resourceLocator.getId() == 0x1000060 || resourceLocator.getId() == 0x3000060;
    }

    private boolean isSatelliteLogoResourceID(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            return false;
        }
        return resourceLocator.getId() == 0x11000060 || resourceLocator.getId() == 318767200;
    }

    @Override
    public void setSatMapCallback(RenderingInfoProvider$SatelliteMapsLogoCallback renderingInfoProvider$SatelliteMapsLogoCallback) {
        this.satMapCallback = renderingInfoProvider$SatelliteMapsLogoCallback;
    }

    static /* synthetic */ LogChannel access$300(IconRenderer iconRenderer) {
        return iconRenderer.lc;
    }

    static /* synthetic */ DSIIconExtractor access$500(IconRenderer iconRenderer) {
        return iconRenderer.dsiIconrenderer;
    }

    static /* synthetic */ void access$1000(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoEventIconCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1100(IconRenderer iconRenderer, int n, int n2, int n3, RenderingInfo renderingInfo) {
        iconRenderer.putIntoTrafficRegulationIconWithSubindexCache(n, n2, n3, renderingInfo);
    }

    static /* synthetic */ void access$1200(IconRenderer iconRenderer, int n, RenderingInfo renderingInfo) {
        iconRenderer.putIntoTargetIconCache(n, renderingInfo);
    }

    static /* synthetic */ void access$1300(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoRoadClassIconCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1400(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoAdditionalInfoIconCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1500(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoRoadIconCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1600(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoExitIconCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1700(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoPoiIconCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1800(IconRenderer iconRenderer, int n, int n2, RenderingInfo renderingInfo) {
        iconRenderer.putIntoPoiIconRawDataCache(n, n2, renderingInfo);
    }

    static /* synthetic */ void access$1900(IconRenderer iconRenderer, int n, int n2, int n3, RenderingInfo renderingInfo) {
        iconRenderer.putIntoTrafficSignCache(n, n2, n3, renderingInfo);
    }

    static /* synthetic */ void access$2000(IconRenderer iconRenderer, int n, RenderingInfo renderingInfo) {
        iconRenderer.putIntoCountryIconCache(n, renderingInfo);
    }
}

