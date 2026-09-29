/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;

public abstract class FactoryPreviewMapStateAbstract {
    protected PreviewMapHandlerAbstract previewMapHandler;
    protected final LogChannel logger;

    public FactoryPreviewMapStateAbstract(LogChannel logChannel, PreviewMapHandlerAbstract previewMapHandlerAbstract) {
        this.logger = logChannel;
        this.previewMapHandler = previewMapHandlerAbstract;
    }

    public abstract PreviewMapStateAbstract createPreviewMapNavLocation(NavLocation navLocation, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapNavLocation(NavLocation navLocation, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl, String string) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapNavLocations(NavLocation[] navLocationArray, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapNavLocations(NavLocation[] navLocationArray, boolean bl, boolean bl2, boolean bl3, NavLocationWgs84 navLocationWgs84, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapTour(NavLocation[] navLocationArray, String string, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapAroundCCP() {
    }

    public abstract PreviewMapStateAbstract createPreviewMapRouteSelenaSingle(NavSegmentID navSegmentID, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapRouteSelenaOverview(NavSegmentID[] navSegmentIDArray, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapRoute(boolean bl) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapRouteOffroad(NavSegmentID navSegmentID, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapRouteRgActive(boolean bl, boolean bl2) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapTrafficInfoEvent(long l, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapTrafficInfoEventsForRouteList(NavRectangle navRectangle, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapTrafficInfoEvents(long[] lArray, NavRectangle navRectangle, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public abstract PreviewMapStateAbstract createPreviewMapSDSPicklistEvents(NavLocation[] navLocationArray, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }
}

