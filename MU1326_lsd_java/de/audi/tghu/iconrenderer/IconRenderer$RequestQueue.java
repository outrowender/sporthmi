/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$1;
import de.audi.tghu.iconrenderer.IconRenderer$AdditionalInfoIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$CountryIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$EventQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$ExitQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$PoiFromRawDataQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$PoiQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$RoadClassIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$RoadQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$SatelliteMapsLogoQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$TargetIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$TrafficRegulationIconQueueElement;
import de.audi.tghu.iconrenderer.IconRenderer$TrafficSignElement;
import java.util.LinkedList;

class IconRenderer$RequestQueue {
    private LinkedList queue = new LinkedList();
    private final /* synthetic */ IconRenderer this$0;

    private IconRenderer$RequestQueue(IconRenderer iconRenderer) {
        this.this$0 = iconRenderer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void queue(IconRenderer$QueueElement iconRenderer$QueueElement) {
        IconRenderer$RequestQueue iconRenderer$RequestQueue = this;
        synchronized (iconRenderer$RequestQueue) {
            IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#queue] Queue element: %1", (Object)iconRenderer$QueueElement);
            iconRenderer$QueueElement.setQueue(this);
            if (this.queue.isEmpty()) {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#queue] Queue is empty, call DSI");
                this.queue.add(iconRenderer$QueueElement);
                this.callDsi(iconRenderer$QueueElement);
            } else {
                this.queue.add(iconRenderer$QueueElement);
            }
            IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#queue] Queue size: %1", (long)this.queue.size());
        }
    }

    private void callDsi(IconRenderer$QueueElement iconRenderer$QueueElement) {
        switch (IconRenderer$QueueElement.access$400(iconRenderer$QueueElement)) {
            case 1002: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'renderingInformationForRoadIcon'");
                IconRenderer$RoadQueueElement iconRenderer$RoadQueueElement = (IconRenderer$RoadQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).renderingInformationForRoadIcon(iconRenderer$RoadQueueElement.getIconReference(), iconRenderer$RoadQueueElement.getTextLength(), 1);
                break;
            }
            case 1006: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'renderingInformationForExitIcon'");
                IconRenderer$ExitQueueElement iconRenderer$ExitQueueElement = (IconRenderer$ExitQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).renderingInformationForExitIcon(iconRenderer$ExitQueueElement.getIconReference(), iconRenderer$ExitQueueElement.getTextLength(), 1);
                break;
            }
            case 1005: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTrafficRegulationIcon'");
                IconRenderer$TrafficSignElement iconRenderer$TrafficSignElement = (IconRenderer$TrafficSignElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForTrafficRegulationIcon(IconRenderer$TrafficSignElement.access$600(iconRenderer$TrafficSignElement), IconRenderer$TrafficSignElement.access$700(iconRenderer$TrafficSignElement), IconRenderer$TrafficSignElement.access$800(iconRenderer$TrafficSignElement));
                break;
            }
            case 1009: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTrafficRegulationIconWithSubIndex'");
                IconRenderer$TrafficRegulationIconQueueElement iconRenderer$TrafficRegulationIconQueueElement = (IconRenderer$TrafficRegulationIconQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForTrafficRegulationIconWithSubindex(iconRenderer$TrafficRegulationIconQueueElement.getIconId(), iconRenderer$TrafficRegulationIconQueueElement.getVariant(), iconRenderer$TrafficRegulationIconQueueElement.getSubIndex(), 1);
                break;
            }
            case 1001: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForPOIIcon'");
                IconRenderer$PoiQueueElement iconRenderer$PoiQueueElement = (IconRenderer$PoiQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForPOIIcon(iconRenderer$PoiQueueElement.getCatNumber(), iconRenderer$PoiQueueElement.getSubIndex(), 1);
                break;
            }
            case 1000: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTMCEventIcon'");
                IconRenderer$EventQueueElement iconRenderer$EventQueueElement = (IconRenderer$EventQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForTMCEventIcon(iconRenderer$EventQueueElement.getIconId(), iconRenderer$EventQueueElement.getSubIndex(), 1);
                break;
            }
            case 1003: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForTargetIcon'");
                if (iconRenderer$QueueElement instanceof IconRenderer$SatelliteMapsLogoQueueElement) {
                    IconRenderer$SatelliteMapsLogoQueueElement iconRenderer$SatelliteMapsLogoQueueElement = (IconRenderer$SatelliteMapsLogoQueueElement)iconRenderer$QueueElement;
                    IconRenderer.access$500(this.this$0).resourceIdForTargetIcon(iconRenderer$SatelliteMapsLogoQueueElement.getStyleReference(), 1);
                    break;
                }
                IconRenderer$TargetIconQueueElement iconRenderer$TargetIconQueueElement = (IconRenderer$TargetIconQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForTargetIcon(iconRenderer$TargetIconQueueElement.getStyleReference(), 1);
                break;
            }
            case 1004: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForRoadClassIcon'");
                IconRenderer$RoadClassIconQueueElement iconRenderer$RoadClassIconQueueElement = (IconRenderer$RoadClassIconQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForRoadClassIcon(iconRenderer$RoadClassIconQueueElement.getIconId(), iconRenderer$RoadClassIconQueueElement.getVariant(), 1);
                break;
            }
            case 1007: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForAdditionalIcon'");
                IconRenderer$AdditionalInfoIconQueueElement iconRenderer$AdditionalInfoIconQueueElement = (IconRenderer$AdditionalInfoIconQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForAdditionalIcon(iconRenderer$AdditionalInfoIconQueueElement.getIconId(), iconRenderer$AdditionalInfoIconQueueElement.getVariant(), 1);
                break;
            }
            case 1008: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#callDsi] Call 'resourceIdForCountryIcon'");
                IconRenderer$CountryIconQueueElement iconRenderer$CountryIconQueueElement = (IconRenderer$CountryIconQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForCountryIcon(iconRenderer$CountryIconQueueElement.getIconId(), 1);
                break;
            }
            case 1025: {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#PoiFromRawDataQueueElement#callDsi] Call 'resourceIdForPOIIconFromRawData'");
                IconRenderer$PoiFromRawDataQueueElement iconRenderer$PoiFromRawDataQueueElement = (IconRenderer$PoiFromRawDataQueueElement)iconRenderer$QueueElement;
                IconRenderer.access$500(this.this$0).resourceIdForPOIIconFromRawData(iconRenderer$PoiFromRawDataQueueElement.getCountryCode(), iconRenderer$PoiFromRawDataQueueElement.getCatReference(), 1);
                break;
            }
        }
    }

    synchronized void dequeue(RenderingInfo renderingInfo, boolean bl) {
        IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#RequestQueue#dequeue] Dequeue element, queue size: %2, rendering info: %1 ", (Object)renderingInfo, (long)this.queue.size());
        if (this.queue.isEmpty()) {
            IconRenderer.access$300(this.this$0).log(-1601830656, "[IconRenderer#RequestQueue#dequeue] Request queue is empty -> invalid DSIIconrenderer up call, render info: %1 ", (Object)renderingInfo);
        } else {
            IconRenderer$QueueElement iconRenderer$QueueElement = (IconRenderer$QueueElement)this.queue.removeFirst();
            iconRenderer$QueueElement.setRenderingInfo(renderingInfo, bl);
            if (!this.queue.isEmpty()) {
                iconRenderer$QueueElement = (IconRenderer$QueueElement)this.queue.getFirst();
                this.callDsi(iconRenderer$QueueElement);
            }
        }
    }

    /* synthetic */ IconRenderer$RequestQueue(IconRenderer iconRenderer, IconRenderer$1 iconRenderer$1) {
        this(iconRenderer);
    }
}

