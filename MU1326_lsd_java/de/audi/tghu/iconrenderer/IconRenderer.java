/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.iconrenderer.IconRendererSimulation;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.dsi.ifc.iconhandling.DSIIconExtractorListener;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class IconRenderer
implements DSIIconExtractorListener,
RenderingInfoProvider {
    private static final long TIME = 5000L;
    private static final int DEFAULT_ICONSIZE = 1;
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
    private RequestQueue roadIconQueue;
    private RequestQueue exitIconQueue;
    private RequestQueue eventIconQueue;
    private RequestQueue poiIconQueue;
    private RequestQueue trafficRegulationIconWithSubindexQueue;
    private RequestQueue targetIconQueue;
    private RequestQueue roadClassIconQueue;
    private RequestQueue additionalInfoIconQueue;
    private RequestQueue trafficSignQueue;
    private RequestQueue countryIconQueue;
    private RequestQueue poiIconFromRawDataQueue;
    private RequestQueue satMapsLogosQueue;
    private boolean iconRequestedForSatMaps = false;
    private boolean iconWasNotYetAvailable = false;
    private RenderingInfoProvider.SatelliteMapsLogoCallback satMapCallback = null;
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
        this.roadIconQueue = new RequestQueue();
        this.exitIconQueue = new RequestQueue();
        this.eventIconQueue = new RequestQueue();
        this.poiIconQueue = new RequestQueue();
        this.trafficSignQueue = new RequestQueue();
        this.targetIconQueue = new RequestQueue();
        this.trafficRegulationIconWithSubindexQueue = new RequestQueue();
        this.roadClassIconQueue = new RequestQueue();
        this.additionalInfoIconQueue = new RequestQueue();
        this.countryIconQueue = new RequestQueue();
        this.poiIconFromRawDataQueue = new RequestQueue();
        this.satMapsLogosQueue = new RequestQueue();
        this.dsiIconrenderer = new IconRendererSimulation(this, logChannel);
    }

    public void setDSIIconrenderer(DSIIconExtractor dSIIconExtractor) {
        this.lc.log(10000000, "[IconRenderer#setDSIIconrenderer] Called ");
        this.dsiIconrenderer = dSIIconExtractor;
    }

    private synchronized RenderingInfo getFromEventIconCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromEventIconCache] iconId=%1, subIndex=%2", (long)n, (long)n2);
        return (RenderingInfo)this.eventMap.get(new Key(n, n2));
    }

    private synchronized RenderingInfo getFromPoiIconCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromPoiIconCache] catNumber=%1, subIndex: %2 ", (long)n, (long)n2);
        return (RenderingInfo)this.poiMap.get(new Key(n, n2));
    }

    private synchronized RenderingInfo getFromPoiIconRawDataCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromPoiIconRawDataCache] countryCode=%1, catReference: %2", (long)n, (long)n2);
        return (RenderingInfo)this.poiFromRawDataMap.get(new Key(n, n2));
    }

    private synchronized RenderingInfo getFromTargetIconCache(int n) {
        this.lc.log(10000000, "[IconRenderer#getFromTargetIconCache] styleReference=%1", (long)n);
        return (RenderingInfo)this.targetIconMap.get(new Key(n));
    }

    private synchronized RenderingInfo getFromRoadClassIconCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromRoadClassIconCache] iconId=%1, variant=%2", (long)n, (long)n2);
        return (RenderingInfo)this.roadClassIconMap.get(new Key(n, n2));
    }

    private synchronized RenderingInfo getFromAdditionalInfoIconCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromAdditionalInfoIconCache] iconId=%1, variant=%2", (long)n, (long)n2);
        return (RenderingInfo)this.additionalInfoIconMap.get(new Key(n, n2));
    }

    private synchronized RenderingInfo getFromTrafficRegulationIconWithSubindexCache(int n, int n2, int n3) {
        this.lc.log(10000000, "[IconRenderer#getFromTrafficRegulationIconWithSubindexCache] iconId=%1, variant=%2, subIndex=%3", (long)n, (long)n2, (long)n3);
        return (RenderingInfo)this.trafficRegulationIconWithSubindexMap.get(new Key(n, n2, n3));
    }

    private synchronized RenderingInfo getFromCountryIconCache(int n) {
        this.lc.log(10000000, "[IconRenderer#getFromCountryIconCache] iconId=%1", (long)n);
        return (RenderingInfo)this.countryIconMap.get(new Key(n));
    }

    private synchronized RenderingInfo getFromTrafficSignCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromTrafficSignCache] signID=%1, variant=%2", (long)n, (long)n2);
        return this.getFromTrafficSignCache(n, n2, 1);
    }

    private synchronized RenderingInfo getFromTrafficSignCache(int n, int n2, int n3) {
        this.lc.log(10000000, "[IconRenderer#getFromTrafficSignCache] signID=%1, variant=%2, size=%3", (long)n, (long)n2, (long)n3);
        return (RenderingInfo)this.trafficSignMap.get(new Key(n, n2, n3));
    }

    private synchronized RenderingInfo getFromRoadIconCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromRoadIconCache] iconRef=%1, textLen=%2 ", (long)n, (long)n2);
        return (RenderingInfo)this.roadMap.get(new Key(n, n2));
    }

    private synchronized RenderingInfo getFromExitIconCache(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getFromExitIconCache] iconRef=%1, textLen=%2 ", (long)n, (long)n2);
        return (RenderingInfo)this.exitMap.get(new Key(n, n2));
    }

    private synchronized void putIntoEventIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoEventIconCache] renderingInfo: %1", (Object)renderingInfo);
        this.eventMap.put(new Key(n, n2), renderingInfo);
    }

    private synchronized void putIntoTargetIconCache(int n, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoTargetIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.targetIconMap.put(new Key(n), renderingInfo);
    }

    private synchronized void putIntoTrafficRegulationIconWithSubindexCache(int n, int n2, int n3, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoTrafficRegulationIconWithSubindexCache] renderingInfo=%1", (Object)renderingInfo);
        this.trafficRegulationIconWithSubindexMap.put(new Key(n, n2, n3), renderingInfo);
    }

    private synchronized void putIntoTrafficSignCache(int n, int n2, int n3, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoTrafficSignCache] renderingInfo=%1", (Object)renderingInfo);
        this.trafficSignMap.put(new Key(n, n2, n3), renderingInfo);
    }

    private synchronized void putIntoRoadClassIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoRoadClassIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.roadClassIconMap.put(new Key(n), renderingInfo);
    }

    private synchronized void putIntoAdditionalInfoIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoAdditionalInfoIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.additionalInfoIconMap.put(new Key(n, n2), renderingInfo);
    }

    private synchronized void putIntoPoiIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoPoiIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.poiMap.put(new Key(n, n2), renderingInfo);
    }

    private synchronized void putIntoPoiIconRawDataCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoPoiIconRawDataCache] renderingInfo=%1", (Object)renderingInfo);
        this.poiFromRawDataMap.put(new Key(n, n2), renderingInfo);
    }

    private synchronized void putIntoRoadIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoRoadIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.roadMap.put(new Key(n, n2), renderingInfo);
    }

    private synchronized void putIntoExitIconCache(int n, int n2, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoExitIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.exitMap.put(new Key(n, n2), renderingInfo);
    }

    private synchronized void putIntoCountryIconCache(int n, RenderingInfo renderingInfo) {
        this.lc.log(10000000, "[IconRenderer#putIntoCountryIconCache] renderingInfo=%1", (Object)renderingInfo);
        this.countryIconMap.put(new Key(n), renderingInfo);
    }

    public RenderingInfo getResourceIdForTMCEventIcon(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForTMCEventIcon] Called, icon ID: %1, subindex: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromEventIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForTMCEventIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForTMCEventIcon] No icon renderer DSI available!");
            return null;
        }
        EventQueueElement eventQueueElement = new EventQueueElement(1000, n, n2);
        this.eventIconQueue.queue(eventQueueElement);
        return eventQueueElement.waitForResponse();
    }

    public void getResourceIdForPoiIconAsync(int n, int n2, RenderingInfoProvider.PoiIconCallback poiIconCallback) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForPoiIconAsync] catNum=%1, subIndex=%2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromPoiIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForPoiIconAsync] Return cached info=%1", (Object)renderingInfo);
            if (poiIconCallback != null) {
                poiIconCallback.renderingInfoReceived(n, n2, renderingInfo);
            } else {
                this.lc.log(10000, "[IconRenderer#getResourceIdForPoiIconAsync] callback is null");
            }
            return;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForPoiIconAsync] No icon renderer DSI available!");
            return;
        }
        PoiQueueElement poiQueueElement = new PoiQueueElement(1001, n, n2, poiIconCallback);
        this.poiIconQueue.queue(poiQueueElement);
    }

    public void getResourceIdForTrafficSignAsync(int n, int n2, RenderingInfoProvider.TrafficSignCallback trafficSignCallback) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForTrafficSignAsync] signID: %1, variant: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromTrafficSignCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForTrafficSignAsync] Return cached info object: %1", (Object)renderingInfo);
            if (trafficSignCallback != null) {
                trafficSignCallback.renderingInfoReceived(n, n2, renderingInfo);
            } else {
                this.lc.log(10000, "[IconRenderer#getResourceIdForTrafficSignAsync] callback is null");
            }
            return;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForTrafficSignAsync] No icon renderer DSI available!");
            return;
        }
        TrafficSignElement trafficSignElement = new TrafficSignElement(1005, n, n2, trafficSignCallback);
        this.trafficSignQueue.queue(trafficSignElement);
    }

    public RenderingInfo getResourceIdForPOIIcon(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForPOIIcon] catNumber: %1, subIndex: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromPoiIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForPOIIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForTMCEventIcon] No icon renderer DSI available!");
            return null;
        }
        PoiQueueElement poiQueueElement = new PoiQueueElement(1001, n, n2, null);
        this.poiIconQueue.queue(poiQueueElement);
        return poiQueueElement.waitForResponse();
    }

    public RenderingInfo resourceIdForPOIIconFromRawData(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForPOIIconFromRawData] countryCode: %1, catReference: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromPoiIconRawDataCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#resourceIdForPOIIconFromRawData] Return cached RenderingInfo object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#resourceIdForPOIIconFromRawData] No icon renderer DSI available!");
            return null;
        }
        PoiFromRawDataQueueElement poiFromRawDataQueueElement = new PoiFromRawDataQueueElement(1025, n, n2, null);
        this.poiIconFromRawDataQueue.queue(poiFromRawDataQueueElement);
        return poiFromRawDataQueueElement.waitForResponse();
    }

    public synchronized void flushCacheForPOIIcon() {
        this.lc.log(1000000, "[IconRenderer#flushCacheForPOIIcon] flushing POI icon cache");
        this.poiMap = new HashMap(50);
        this.poiFromRawDataMap = new HashMap(50);
    }

    public ExtRenderingInfo getRenderingInformationForRoadIcon(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getRenderingInformationForRoadIcon] iconReference: %1, iconRef: %2", (long)n, (long)n2);
        ExtRenderingInfo extRenderingInfo = (ExtRenderingInfo)this.getFromRoadIconCache(n, n2);
        if (extRenderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getRenderingInformationForRoadIcon] Return cached info object: %1", (Object)extRenderingInfo);
            return extRenderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getRenderingInformationForRoadIcon] No icon renderer DSI available!");
            return null;
        }
        RoadQueueElement roadQueueElement = new RoadQueueElement(1002, n, n2);
        this.roadIconQueue.queue(roadQueueElement);
        return (ExtRenderingInfo)roadQueueElement.waitForResponse();
    }

    public ExtRenderingInfo getRenderingInformationForExitIcon(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getRenderingInformationForExitIcon] iconRef: %1, textLength: %2", (long)n, (long)n2);
        ExtRenderingInfo extRenderingInfo = (ExtRenderingInfo)this.getFromExitIconCache(n, n2);
        if (extRenderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getRenderingInformationForExitIcon] Return cached info object: %1", (Object)extRenderingInfo);
            return extRenderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getRenderingInformationForExitIcon] No icon renderer DSI available!");
            return null;
        }
        ExitQueueElement exitQueueElement = new ExitQueueElement(1006, n, n2);
        this.exitIconQueue.queue(exitQueueElement);
        return (ExtRenderingInfo)exitQueueElement.waitForResponse();
    }

    public RenderingInfo getResourceIdForTargetIcon(int n) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForTargetIcon] Called, styleReference: %1", (long)n);
        RenderingInfo renderingInfo = this.getFromTargetIconCache(n);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForTargetIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForTargetIcon] No icon renderer DSI available!");
            return null;
        }
        if (this.isSatelliteLogoStyleRef(n)) {
            SatelliteMapsLogoQueueElement satelliteMapsLogoQueueElement = new SatelliteMapsLogoQueueElement(1003, n);
            this.satMapsLogosQueue.queue(satelliteMapsLogoQueueElement);
            this.iconRequestedForSatMaps = true;
            return satelliteMapsLogoQueueElement.waitForResponse();
        }
        TargetIconQueueElement targetIconQueueElement = new TargetIconQueueElement(1003, n);
        this.targetIconQueue.queue(targetIconQueueElement);
        return targetIconQueueElement.waitForResponse();
    }

    public RenderingInfo getResourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForTrafficRegulationIconWithSubindex] Called, iconId: %1, variant: %2, subIndex: %3", (long)n, (long)n2, (long)n3);
        RenderingInfo renderingInfo = this.getFromTrafficRegulationIconWithSubindexCache(n, n2, n3);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForTrafficRegulationIconWithSubindex] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForTrafficRegulationIconWithSubindex] No icon renderer DSI available!");
            return null;
        }
        TrafficRegulationIconQueueElement trafficRegulationIconQueueElement = new TrafficRegulationIconQueueElement(1009, n, n2, n3);
        this.trafficRegulationIconWithSubindexQueue.queue(trafficRegulationIconQueueElement);
        return trafficRegulationIconQueueElement.waitForResponse();
    }

    public RenderingInfo getResourceIdForTrafficRegulationIcon(int n, int n2) {
        return this.getResourceIdForTrafficRegulationIcon(n, n2, 1);
    }

    public RenderingInfo getResourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForTrafficRegulationIcon] Called, iconId: %1, variant: %2, size: %3", (long)n, (long)n2, (long)n3);
        RenderingInfo renderingInfo = this.getFromTrafficSignCache(n, n2, n3);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForTrafficRegulationIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForTrafficRegulationIcon] No icon renderer DSI available!");
            return null;
        }
        TrafficSignElement trafficSignElement = new TrafficSignElement(1005, n, n2, n3);
        this.trafficSignQueue.queue(trafficSignElement);
        return trafficSignElement.waitForResponse();
    }

    public RenderingInfo getResourceIdForRoadClassIcon(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForRoadClassIcon] Called, iconId: %1, variant: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromRoadClassIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForRoadClassIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForRoadClassIcon] No icon renderer DSI available!");
            return null;
        }
        RoadClassIconQueueElement roadClassIconQueueElement = new RoadClassIconQueueElement(1004, n, n2);
        this.roadClassIconQueue.queue(roadClassIconQueueElement);
        return roadClassIconQueueElement.waitForResponse();
    }

    public RenderingInfo getResourceIdForAdditionalInfoIcon(int n, int n2) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForAdditionalInfoIcon] Called, iconId: %1, variant: %2", (long)n, (long)n2);
        RenderingInfo renderingInfo = this.getFromAdditionalInfoIconCache(n, n2);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForAdditionalInfoIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForAdditionalInfoIcon] No icon renderer DSI available!");
            return null;
        }
        AdditionalInfoIconQueueElement additionalInfoIconQueueElement = new AdditionalInfoIconQueueElement(1007, n, n2);
        this.additionalInfoIconQueue.queue(additionalInfoIconQueueElement);
        return additionalInfoIconQueueElement.waitForResponse();
    }

    public RenderingInfo getResourceIdForCountryIcon(int n) {
        this.lc.log(10000000, "[IconRenderer#getResourceIdForCountryIcon] Called, iconId: %1", (long)n);
        RenderingInfo renderingInfo = this.getFromCountryIconCache(n);
        if (renderingInfo != null) {
            this.lc.log(10000000, "[IconRenderer#getResourceIdForCountryIcon] Return cached info object: %1", (Object)renderingInfo);
            return renderingInfo;
        }
        if (this.dsiIconrenderer == null) {
            this.lc.log(100000, "[IconRenderer#getResourceIdForCountryIcon] No icon renderer DSI available!");
            return null;
        }
        CountryIconQueueElement countryIconQueueElement = new CountryIconQueueElement(1008, n);
        this.countryIconQueue.queue(countryIconQueueElement);
        return countryIconQueueElement.waitForResponse();
    }

    public void renderingInformationForRoadIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        ExtRenderingInfo extRenderingInfo;
        this.lc.log(10000000, "[IconRenderer#renderingInformationForRoadIcon] Called, info: %1, resourceLocator: %2", (Object)textRenderingInfo, (Object)resourceLocator);
        if (resourceLocator != null && textRenderingInfo != null) {
            extRenderingInfo = new ExtRenderingInfo(resourceLocator.getId(), textRenderingInfo.fontReference, textRenderingInfo.fontSize, textRenderingInfo.fontColor, textRenderingInfo.deltaX, textRenderingInfo.deltaY, true);
        } else {
            this.lc.log(10000, "[IconRenderer#renderingInformationForRoadIcon] info or resourceLocator is null");
            extRenderingInfo = new ExtRenderingInfo(-1, -1, -1, -1, -1, -1, false);
        }
        this.roadIconQueue.dequeue(extRenderingInfo, true);
    }

    public void resourceIdForPOIIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForPOIIcon] Called, resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.poiIconQueue, resourceLocator);
    }

    public void resourceIdForTMCEventIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForTMCEventIcon] Called, resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.eventIconQueue, resourceLocator);
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[IconRenderer#asyncException] errorCode=%2, Msg=%1, request=%3", (Object)string, (long)n, (long)n2);
    }

    public void resourceIdForTargetIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForTargetIcon] Called, resourceLocator: %1", (Object)resourceLocator);
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

    public void resourceIdForTrafficRegulationIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForTrafficRegulationIcon] resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.trafficSignQueue, resourceLocator);
    }

    public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForTrafficRegulationIconWithSubIndex] Called unexpectedly, rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.trafficRegulationIconWithSubindexQueue, resourceLocator);
    }

    public void resourceIdForPOIIconFromRawDataResult(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForPOIIconFromRawDataResult] Called, resourceLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.poiIconFromRawDataQueue, resourceLocator);
    }

    public void iconResult(int n) {
        this.lc.log(10000000, "[IconRenderer#iconResult] Called, result: %1", (long)n);
    }

    public void resourceIdForRoadClassIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForRoadClassIcon] Called, rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.roadClassIconQueue, resourceLocator);
    }

    public void renderingInformationForExitIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        ExtRenderingInfo extRenderingInfo;
        this.lc.log(10000000, "[IconRenderer#renderingInformationForExitIcon] rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
        if (resourceLocator != null && textRenderingInfo != null) {
            extRenderingInfo = new ExtRenderingInfo(resourceLocator.getId(), textRenderingInfo.fontReference, textRenderingInfo.fontSize, textRenderingInfo.fontColor, textRenderingInfo.deltaX, textRenderingInfo.deltaY, true);
        } else {
            this.lc.log(10000, "[IconRenderer#renderingInformationForExitIcon] info or resourceLocator is null");
            extRenderingInfo = new ExtRenderingInfo(-1, -1, -1, -1, -1, -1, false);
        }
        this.exitIconQueue.dequeue(extRenderingInfo, true);
    }

    public void renderingInformationForExitIconWithVariant(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.lc.log(10000000, "[IconRenderer#renderingInformationForExitIconWithVariant] Called unexpectedly, rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
    }

    public void resourceIdForAdditionalIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForAdditionalIcon] rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.additionalInfoIconQueue, resourceLocator);
    }

    public void resourceIdForCountryIcon(ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#resourceIdForCountryIcon] rLocator: %1", (Object)resourceLocator);
        this.dequeueResource(this.countryIconQueue, resourceLocator);
    }

    public void tmcEventIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#tmcEventIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForTMCEventIcon(resourceLocator);
    }

    public void poiIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#poiIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForPOIIcon(resourceLocator);
    }

    public void roadIcon(int n, ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.lc.log(10000000, "[IconRenderer#roadIcon] rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
        this.renderingInformationForRoadIcon(resourceLocator, textRenderingInfo);
    }

    public void destinationIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#destinationIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForTargetIcon(resourceLocator);
    }

    public void roadClassIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#roadClassIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForRoadClassIcon(resourceLocator);
    }

    public void countryInfoIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#countryInfoIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForAdditionalIcon(resourceLocator);
    }

    public void countryFlagIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#countryFlagIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForCountryIcon(resourceLocator);
    }

    public void trafficRegulationIcon(int n, ResourceLocator resourceLocator) {
        this.lc.log(10000000, "[IconRenderer#trafficRegulationIcon] rLocator: %1", (Object)resourceLocator);
        this.resourceIdForTrafficRegulationIcon(resourceLocator);
    }

    public void exitIcon(int n, ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.lc.log(10000000, "[IconRenderer#exitIcon] rLocator: %1, info: %2", (Object)resourceLocator, (Object)textRenderingInfo);
        this.renderingInformationForExitIcon(resourceLocator, textRenderingInfo);
    }

    public void setBrandIconStyleResult(int n) {
        this.lc.log(10000000, "[IconRenderer#setBrandIconStyleResult] result: %1", (long)n);
    }

    private void dequeueResource(RequestQueue requestQueue, ResourceLocator resourceLocator) {
        RenderingInfo renderingInfo;
        if (requestQueue == null) {
            this.lc.log(10000, "[IconRenderer#dequeueResource] queue is null");
            return;
        }
        if (resourceLocator == null) {
            this.lc.log(100000, "[IconRenderer#dequeueResource] resourceLocator is null: requested icon not available!");
            renderingInfo = new RenderingInfo(-1, false);
        } else if (this.isSatelliteLogoNotAvailableYet(resourceLocator)) {
            this.iconWasNotYetAvailable = true;
            renderingInfo = new RenderingInfo(resourceLocator.getId(), true);
        } else {
            renderingInfo = new RenderingInfo(resourceLocator.getId(), true);
        }
        requestQueue.dequeue(renderingInfo, true);
    }

    public void resourceIdForTrafficSourceIconResult(ResourceLocator resourceLocator) {
    }

    public void resourceIdForAreaWarningIconResult(ResourceLocator resourceLocator) {
    }

    public void resourceIdForAdditionalTurnListIconResult(ResourceLocator resourceLocator) {
    }

    public void resourceIdForComposedPOIIconResult(ResourceLocator resourceLocator) {
    }

    private boolean isSatelliteLogoStyleRef(int n) {
        return n == 204 || n == 206;
    }

    private boolean isSatelliteLogoNotAvailableYet(ResourceLocator resourceLocator) {
        return resourceLocator.getId() == 0x60000001 || resourceLocator.getId() == 0x60000003;
    }

    private boolean isSatelliteLogoResourceID(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            return false;
        }
        return resourceLocator.getId() == 0x60000011 || resourceLocator.getId() == 1610612755;
    }

    public void setSatMapCallback(RenderingInfoProvider.SatelliteMapsLogoCallback satelliteMapsLogoCallback) {
        this.satMapCallback = satelliteMapsLogoCallback;
    }

    private class Key {
        private int firstIndex;
        private int secondIndex;
        private int thirdIndex;

        public Key(int n) {
            this.firstIndex = n;
            this.secondIndex = 0;
            this.thirdIndex = 0;
        }

        public Key(int n, int n2) {
            this.firstIndex = n;
            this.secondIndex = n2;
            this.thirdIndex = 0;
        }

        public Key(int n, int n2, int n3) {
            this.firstIndex = n;
            this.secondIndex = n2;
            this.thirdIndex = n3;
        }

        public int hashCode() {
            int n = 17;
            n = 37 * n + this.firstIndex;
            n = 37 * n + this.secondIndex;
            n = 37 * n + this.thirdIndex;
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Key)) {
                return false;
            }
            Key key = (Key)object;
            return this.thirdIndex == key.thirdIndex && this.secondIndex == key.secondIndex && this.firstIndex == key.firstIndex;
        }
    }

    private abstract class QueueElement {
        protected RequestQueue queue;
        protected int requestType;
        private boolean responseReceived = false;
        private RenderingInfo renderingInfo;

        private QueueElement(int n) {
            this.requestType = n;
        }

        private int getRequestType() {
            return this.requestType;
        }

        void setQueue(RequestQueue requestQueue) {
            this.queue = requestQueue;
        }

        synchronized RenderingInfo waitForResponse() {
            IconRenderer.this.lc.log(10000000, "[IconRenderer#QueueElement#waitForResponse] called");
            while (!this.responseReceived) {
                try {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#QueueElement#waitForResponse] Wait...");
                    long l = System.currentTimeMillis();
                    this.wait(5000L);
                    long l2 = System.currentTimeMillis();
                    if (this.responseReceived) continue;
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#QueueElement#waitForResponse] Timeout, time: %1", l2 - l);
                    if (this.queue == null) break;
                    this.queue.dequeue(null, false);
                    break;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            if (this.renderingInfo != null) {
                this.putIntoCache(this.renderingInfo);
            }
            return this.renderingInfo;
        }

        protected abstract void putIntoCache(RenderingInfo var1);

        synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
            IconRenderer.this.lc.log(10000000, "[IconRenderer#QueueElement#setRenderingInfo] called");
            this.renderingInfo = renderingInfo;
            this.responseReceived = bl;
            this.notifyAll();
            IconRenderer.this.lc.log(10000000, "[IconRenderer#QueueElement#setRenderingInfo] Notify");
        }
    }

    private class RequestQueue {
        private LinkedList queue = new LinkedList();

        private RequestQueue() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void queue(QueueElement queueElement) {
            RequestQueue requestQueue = this;
            synchronized (requestQueue) {
                IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#queue] Queue element: %1", (Object)queueElement);
                queueElement.setQueue(this);
                if (this.queue.isEmpty()) {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#queue] Queue is empty, call DSI");
                    this.queue.add(queueElement);
                    this.callDsi(queueElement);
                } else {
                    this.queue.add(queueElement);
                }
                IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#queue] Queue size: %1", (long)this.queue.size());
            }
        }

        private void callDsi(QueueElement queueElement) {
            switch (queueElement.getRequestType()) {
                case 1002: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'renderingInformationForRoadIcon'");
                    RoadQueueElement roadQueueElement = (RoadQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.renderingInformationForRoadIcon(roadQueueElement.getIconReference(), roadQueueElement.getTextLength(), 1);
                    break;
                }
                case 1006: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'renderingInformationForExitIcon'");
                    ExitQueueElement exitQueueElement = (ExitQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.renderingInformationForExitIcon(exitQueueElement.getIconReference(), exitQueueElement.getTextLength(), 1);
                    break;
                }
                case 1005: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTrafficRegulationIcon'");
                    TrafficSignElement trafficSignElement = (TrafficSignElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForTrafficRegulationIcon(trafficSignElement.getSignID(), trafficSignElement.getVariant(), trafficSignElement.getSize());
                    break;
                }
                case 1009: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTrafficRegulationIconWithSubIndex'");
                    TrafficRegulationIconQueueElement trafficRegulationIconQueueElement = (TrafficRegulationIconQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForTrafficRegulationIconWithSubindex(trafficRegulationIconQueueElement.getIconId(), trafficRegulationIconQueueElement.getVariant(), trafficRegulationIconQueueElement.getSubIndex(), 1);
                    break;
                }
                case 1001: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForPOIIcon'");
                    PoiQueueElement poiQueueElement = (PoiQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForPOIIcon(poiQueueElement.getCatNumber(), poiQueueElement.getSubIndex(), 1);
                    break;
                }
                case 1000: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTMCEventIcon'");
                    EventQueueElement eventQueueElement = (EventQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForTMCEventIcon(eventQueueElement.getIconId(), eventQueueElement.getSubIndex(), 1);
                    break;
                }
                case 1003: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTargetIcon'");
                    if (queueElement instanceof SatelliteMapsLogoQueueElement) {
                        SatelliteMapsLogoQueueElement satelliteMapsLogoQueueElement = (SatelliteMapsLogoQueueElement)queueElement;
                        IconRenderer.this.dsiIconrenderer.resourceIdForTargetIcon(satelliteMapsLogoQueueElement.getStyleReference(), 1);
                        break;
                    }
                    TargetIconQueueElement targetIconQueueElement = (TargetIconQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForTargetIcon(targetIconQueueElement.getStyleReference(), 1);
                    break;
                }
                case 1004: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForRoadClassIcon'");
                    RoadClassIconQueueElement roadClassIconQueueElement = (RoadClassIconQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForRoadClassIcon(roadClassIconQueueElement.getIconId(), roadClassIconQueueElement.getVariant(), 1);
                    break;
                }
                case 1007: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForAdditionalIcon'");
                    AdditionalInfoIconQueueElement additionalInfoIconQueueElement = (AdditionalInfoIconQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForAdditionalIcon(additionalInfoIconQueueElement.getIconId(), additionalInfoIconQueueElement.getVariant(), 1);
                    break;
                }
                case 1008: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForCountryIcon'");
                    CountryIconQueueElement countryIconQueueElement = (CountryIconQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForCountryIcon(countryIconQueueElement.getIconId(), 1);
                    break;
                }
                case 1025: {
                    IconRenderer.this.lc.log(10000000, "[IconRenderer#PoiFromRawDataQueueElement#callDsi] Call 'resourceIdForPOIIconFromRawData'");
                    PoiFromRawDataQueueElement poiFromRawDataQueueElement = (PoiFromRawDataQueueElement)queueElement;
                    IconRenderer.this.dsiIconrenderer.resourceIdForPOIIconFromRawData(poiFromRawDataQueueElement.getCountryCode(), poiFromRawDataQueueElement.getCatReference(), 1);
                    break;
                }
            }
        }

        synchronized void dequeue(RenderingInfo renderingInfo, boolean bl) {
            IconRenderer.this.lc.log(10000000, "[IconRenderer#RequestQueue#dequeue] Dequeue element, queue size: %2, rendering info: %1 ", (Object)renderingInfo, (long)this.queue.size());
            if (this.queue.isEmpty()) {
                IconRenderer.this.lc.log(100000, "[IconRenderer#RequestQueue#dequeue] Request queue is empty -> invalid DSIIconrenderer up call, render info: %1 ", (Object)renderingInfo);
            } else {
                QueueElement queueElement = (QueueElement)this.queue.removeFirst();
                queueElement.setRenderingInfo(renderingInfo, bl);
                if (!this.queue.isEmpty()) {
                    queueElement = (QueueElement)this.queue.getFirst();
                    this.callDsi(queueElement);
                }
            }
        }
    }

    private class PoiQueueElement
    extends QueueElement {
        private int catNumber;
        private int subIndex;
        private RenderingInfoProvider.PoiIconCallback callback;

        public PoiQueueElement(int n, int n2, int n3, RenderingInfoProvider.PoiIconCallback poiIconCallback) {
            super(n);
            this.catNumber = n2;
            this.subIndex = n3;
            this.callback = poiIconCallback;
        }

        int getCatNumber() {
            return this.catNumber;
        }

        int getSubIndex() {
            return this.subIndex;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoPoiIconCache(this.catNumber, this.subIndex, renderingInfo);
        }

        synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
            IconRenderer.this.lc.log(10000000, "[IconRenderer#PoiQueueElement#setRenderingInfo] called");
            if (this.callback != null) {
                this.callback.renderingInfoReceived(this.catNumber, this.subIndex, renderingInfo);
            } else {
                super.setRenderingInfo(renderingInfo, bl);
            }
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("icon id: ");
            buffer.append(this.catNumber);
            buffer.append("sub index: ");
            buffer.append(this.subIndex);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class ExitQueueElement
    extends QueueElement {
        private int iconReference;
        private int textLength;

        public ExitQueueElement(int n, int n2, int n3) {
            super(n);
            this.iconReference = n2;
            this.textLength = n3;
        }

        int getIconReference() {
            return this.iconReference;
        }

        int getTextLength() {
            return this.textLength;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoExitIconCache(this.iconReference, this.textLength, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("icon reference: ");
            buffer.append(this.iconReference);
            buffer.append("text length: ");
            buffer.append(this.textLength);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class RoadQueueElement
    extends QueueElement {
        private int iconReference;
        private int textLength;

        public RoadQueueElement(int n, int n2, int n3) {
            super(n);
            this.iconReference = n2;
            this.textLength = n3;
        }

        int getIconReference() {
            return this.iconReference;
        }

        int getTextLength() {
            return this.textLength;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoRoadIconCache(this.iconReference, this.textLength, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("icon reference: ");
            buffer.append(this.iconReference);
            buffer.append("text length: ");
            buffer.append(this.textLength);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class EventQueueElement
    extends QueueElement {
        private int iconId;
        private int subIndex;

        public EventQueueElement(int n, int n2, int n3) {
            super(n);
            this.iconId = n2;
            this.subIndex = n3;
        }

        int getIconId() {
            return this.iconId;
        }

        int getSubIndex() {
            return this.subIndex;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoEventIconCache(this.iconId, this.subIndex, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("icon id: ");
            buffer.append(this.iconId);
            buffer.append("sub index: ");
            buffer.append(this.subIndex);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class TrafficSignElement
    extends QueueElement {
        private int signID;
        private int variant;
        private int size;
        private RenderingInfoProvider.TrafficSignCallback callback;

        private TrafficSignElement(int n, int n2, int n3, int n4) {
            this(n, n2, n3, n4, (RenderingInfoProvider.TrafficSignCallback)null);
        }

        private TrafficSignElement(int n, int n2, int n3, RenderingInfoProvider.TrafficSignCallback trafficSignCallback) {
            this(n, n2, n3, 1, trafficSignCallback);
        }

        private TrafficSignElement(int n, int n2, int n3, int n4, RenderingInfoProvider.TrafficSignCallback trafficSignCallback) {
            super(n);
            this.signID = n2;
            this.variant = n3;
            this.size = n4;
            this.callback = trafficSignCallback;
        }

        private int getSignID() {
            return this.signID;
        }

        private int getVariant() {
            return this.variant;
        }

        private int getSize() {
            return this.size;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoTrafficSignCache(this.signID, this.variant, this.size, renderingInfo);
        }

        synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
            IconRenderer.this.lc.log(10000000, "[TrafficSignElement#TrafficSignElement#setRenderingInfo] called");
            if (this.callback != null) {
                this.callback.renderingInfoReceived(this.signID, this.variant, renderingInfo);
            } else {
                super.setRenderingInfo(renderingInfo, bl);
            }
        }

        public String toString() {
            Buffer buffer = new Buffer(100);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append(", sign ID: ");
            buffer.append(this.signID);
            buffer.append(", variant index: ");
            buffer.append(this.variant);
            buffer.append(", icon size: ");
            buffer.append(this.size);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class TargetIconQueueElement
    extends QueueElement {
        private int styleReference;

        public TargetIconQueueElement(int n, int n2) {
            super(n);
            this.styleReference = n2;
        }

        int getStyleReference() {
            return this.styleReference;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoTargetIconCache(this.styleReference, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("style reference: ");
            buffer.append(this.styleReference);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class CountryIconQueueElement
    extends QueueElement {
        private int iconId;

        public CountryIconQueueElement(int n, int n2) {
            super(n);
            this.iconId = n2;
        }

        int getIconId() {
            return this.iconId;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoCountryIconCache(this.iconId, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("country icon ID: ");
            buffer.append(this.iconId);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class RoadClassIconQueueElement
    extends QueueElement {
        private int iconId;
        private int variant;

        public RoadClassIconQueueElement(int n, int n2, int n3) {
            super(n);
            this.iconId = n2;
            this.variant = n3;
        }

        int getIconId() {
            return this.iconId;
        }

        int getVariant() {
            return this.variant;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoRoadClassIconCache(this.iconId, this.variant, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("road class icon ID: ");
            buffer.append(this.iconId);
            buffer.append("variant: ");
            buffer.append(this.variant);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class PoiFromRawDataQueueElement
    extends QueueElement {
        private int countryCode;
        private int catReference;
        private RenderingInfoProvider.PoiIconCallback callback;

        public PoiFromRawDataQueueElement(int n, int n2, int n3, RenderingInfoProvider.PoiIconCallback poiIconCallback) {
            super(n);
            this.countryCode = n2;
            this.catReference = n3;
            this.callback = poiIconCallback;
        }

        int getCountryCode() {
            return this.countryCode;
        }

        int getCatReference() {
            return this.catReference;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoPoiIconRawDataCache(this.countryCode, this.catReference, renderingInfo);
        }

        synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
            IconRenderer.this.lc.log(10000000, "[IconRenderer#PoiQueueElement#setRenderingInfo] called");
            if (this.callback != null) {
                this.callback.renderingInfoReceived(this.countryCode, this.catReference, renderingInfo);
            } else {
                super.setRenderingInfo(renderingInfo, bl);
            }
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("countryCode: ");
            buffer.append(this.countryCode);
            buffer.append("catReference: ");
            buffer.append(this.catReference);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class SatelliteMapsLogoQueueElement
    extends QueueElement {
        private int styleReference;

        public SatelliteMapsLogoQueueElement(int n, int n2) {
            super(n);
            this.styleReference = n2;
        }

        int getStyleReference() {
            return this.styleReference;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("style reference: ");
            buffer.append(this.styleReference);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class AdditionalInfoIconQueueElement
    extends QueueElement {
        private int iconId;
        private int variant;

        public AdditionalInfoIconQueueElement(int n, int n2, int n3) {
            super(n);
            this.iconId = n2;
            this.variant = n3;
        }

        int getIconId() {
            return this.iconId;
        }

        int getVariant() {
            return this.variant;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoAdditionalInfoIconCache(this.iconId, this.variant, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("additional info icon ID: ");
            buffer.append(this.iconId);
            buffer.append("variant: ");
            buffer.append(this.variant);
            buffer.append(']');
            return buffer.toString();
        }
    }

    private class TrafficRegulationIconQueueElement
    extends QueueElement {
        private int iconId;
        private int variant;
        private int subIndex;

        public TrafficRegulationIconQueueElement(int n, int n2, int n3, int n4) {
            super(n);
            this.iconId = n2;
            this.variant = n3;
            this.subIndex = n4;
        }

        int getIconId() {
            return this.iconId;
        }

        int getVariant() {
            return this.variant;
        }

        int getSubIndex() {
            return this.subIndex;
        }

        protected void putIntoCache(RenderingInfo renderingInfo) {
            IconRenderer.this.putIntoTrafficRegulationIconWithSubindexCache(this.iconId, this.variant, this.subIndex, renderingInfo);
        }

        public String toString() {
            Buffer buffer = new Buffer(80);
            buffer.append('[');
            buffer.append("request type: ");
            buffer.append(this.requestType);
            buffer.append("traffic regulation icon ID: ");
            buffer.append(this.iconId);
            buffer.append("variant: ");
            buffer.append(this.variant);
            buffer.append("sub index: ");
            buffer.append(this.subIndex);
            buffer.append(']');
            return buffer.toString();
        }
    }
}

