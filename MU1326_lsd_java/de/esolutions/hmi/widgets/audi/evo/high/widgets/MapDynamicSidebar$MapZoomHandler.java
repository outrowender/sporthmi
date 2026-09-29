/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapDynamicSidebar;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchMapHandler;

public final class MapDynamicSidebar$MapZoomHandler {
    private RangeModel modelRef;
    private TiledListModelGUI zoomLevelModelRef;
    private int terminalID;
    private int zoomLevelIndex;
    private int[] zoomLevels;
    private int zoomLevelIndexTmp = -1;
    private MapDynamicSidebar parentRef;

    public int getZoomLevel() {
        return this.zoomLevels[this.zoomLevelIndex];
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        int n = -1;
        if (wheelButtonEvent.getDirection() == 1) {
            n = 1;
        }
        if (this.zoomLevels == null) {
            IWidgetLogChannel.sideBarLogChannel.log(10000, "MapScrollHandler#keyTurned zoomLevels is null.");
            return;
        }
        int n2 = Math.max(0, Math.min(this.zoomLevels.length - 1, this.zoomLevelIndex + n * wheelButtonEvent.getClickCount()));
        if (this.parentRef.getCurrentState() == 5) {
            n2 = wheelButtonEvent.getDirection() == 1 ? 1 : 0;
        }
        this.setZoomLevel(n2);
    }

    public void setModel(RangeModel rangeModel) {
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapScrollHandler#setModel model = %1", (Object)rangeModel);
        this.modelRef = rangeModel;
    }

    public void setModel(TiledListModelGUI tiledListModelGUI) {
        this.zoomLevelModelRef = tiledListModelGUI;
    }

    public void setParent(MapDynamicSidebar mapDynamicSidebar) {
        this.parentRef = mapDynamicSidebar;
    }

    private void setZoomLevel(int n) {
        int n2 = this.zoomLevels[n];
        if (this.modelRef != null) {
            this.modelRef.increment(n2, this.terminalID);
        } else {
            IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapScrollHandler#setZoomLevel Model is not set.");
        }
        this.zoomLevelIndex = n;
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapScrollHandler#setZoomLevel zoomLevelToSet = %1", (long)n2);
    }

    protected void setZoomLevelNoModelWrite(int n) {
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapScrollHandler#setZoomLevelNoModelWrite newZoomLevelIndex = %1", (long)n);
        this.zoomLevelIndex = n;
    }

    public void updateZoomLevel(int n, boolean bl) {
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapZoomHandler#updateZoomLevel magnification range update (oldValue = %1, newValue = %2)", (long)this.zoomLevelIndex, (long)n);
        if (this.zoomLevels != null) {
            if (0 <= n && n < this.zoomLevels.length) {
                if (bl) {
                    this.setZoomLevel(n);
                } else {
                    IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapZoomHandler#updateZoomLevel only update zoomLevelIndex - used for autoZoom");
                    this.zoomLevelIndex = n;
                }
            }
        } else {
            this.zoomLevelIndexTmp = n;
            IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapZoomHandler#updateZoomLevel Zoomlevels not initialized yet.");
        }
    }

    public void updateZoomLevels() {
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapZoomHandler#updateZoomLevels");
        this.zoomLevels = TouchMapHandler.updateZoomLevels(this.zoomLevelModelRef);
        if (this.zoomLevelIndexTmp != -1) {
            this.updateZoomLevel(this.zoomLevelIndexTmp, true);
            this.zoomLevelIndexTmp = -1;
        }
    }
}

