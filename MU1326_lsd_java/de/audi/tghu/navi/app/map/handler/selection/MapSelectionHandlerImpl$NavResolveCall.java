/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.call.NavSimpleCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

abstract class MapSelectionHandlerImpl$NavResolveCall
extends NavSimpleCall {
    private final NavLocation geoPosLocation;
    private final DSINavigationManager dsiNavigationManager;
    private final /* synthetic */ MapSelectionHandlerImpl this$0;

    public MapSelectionHandlerImpl$NavResolveCall(MapSelectionHandlerImpl mapSelectionHandlerImpl, String string, NavLocation navLocation) {
        this.this$0 = mapSelectionHandlerImpl;
        super(mapSelectionHandlerImpl.naviMap.getNavigationEnv().getCommandLogChannel(), string);
        this.dsiNavigationManager = mapSelectionHandlerImpl.naviMap.getNaviInterface().getDSINavigationManager();
        this.geoPosLocation = navLocation;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute() - calling liGetLocationDescriptionTransform( %2 ) ", (Object)this.getName(), (Object)LocationFormatter.formatLocationShort(this.geoPosLocation));
        this.dsiNavigationManager.getDSINavigation(0).liGetLocationDescriptionTransform(this.geoPosLocation);
    }

    @Override
    public abstract void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
    }
}

