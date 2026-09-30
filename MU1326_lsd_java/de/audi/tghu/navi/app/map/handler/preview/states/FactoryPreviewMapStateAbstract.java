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

    public abstract PreviewMapStateAbstract createPreviewMapNavLocation(NavLocation var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);

    public abstract PreviewMapStateAbstract createPreviewMapNavLocation(NavLocation var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3, boolean var4, String var5);

    public abstract PreviewMapStateAbstract createPreviewMapNavLocations(NavLocation[] var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);

    public abstract PreviewMapStateAbstract createPreviewMapNavLocations(NavLocation[] var1, boolean var2, boolean var3, boolean var4, NavLocationWgs84 var5, GuiModelAccessForPreviewMapDetailScreen var6, GuiTooltipInformationContainer var7);

    public abstract PreviewMapStateAbstract createPreviewMapTour(NavLocation[] var1, String var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public abstract PreviewMapStateAbstract createPreviewMapAroundCCP();

    public abstract PreviewMapStateAbstract createPreviewMapRouteSelenaSingle(NavSegmentID var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);

    public abstract PreviewMapStateAbstract createPreviewMapRouteSelenaOverview(NavSegmentID[] var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);

    public abstract PreviewMapStateAbstract createPreviewMapRoute(boolean var1);

    public abstract PreviewMapStateAbstract createPreviewMapRouteOffroad(NavSegmentID var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);

    public abstract PreviewMapStateAbstract createPreviewMapRouteRgActive(boolean var1, boolean var2);

    public abstract PreviewMapStateAbstract createPreviewMapTrafficInfoEvent(long var1, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public abstract PreviewMapStateAbstract createPreviewMapTrafficInfoEventsForRouteList(NavRectangle var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);

    public abstract PreviewMapStateAbstract createPreviewMapTrafficInfoEvents(long[] var1, NavRectangle var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public abstract PreviewMapStateAbstract createPreviewMapSDSPicklistEvents(NavLocation[] var1, GuiModelAccessForPreviewMapDetailScreen var2, GuiTooltipInformationContainer var3);
}

