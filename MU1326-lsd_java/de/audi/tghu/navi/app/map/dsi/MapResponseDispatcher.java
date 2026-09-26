/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$1;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$2;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$3;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$4;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$5;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$6;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$7;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$8;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher$9;
import de.audi.tghu.navi.app.map.dsi.MapViewerDefaultHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapResponseDispatcher
implements ICommandResponseSupplier {
    AbstractMap naviMap;
    CommandListManager manager;
    private final IDSIMapViewerControlListener defaultHandler;
    private final LogChannel logChannel;
    private final String listenerName;

    public MapResponseDispatcher(NavigationEnv navigationEnv, CommandListManager commandListManager, AbstractMap abstractMap, LogChannel logChannel) {
        this.naviMap = abstractMap;
        this.manager = commandListManager;
        this.defaultHandler = new MapViewerDefaultHandler(abstractMap.getMapDSILogChannel());
        this.logChannel = logChannel;
        this.listenerName = new StringBuffer().append("MapResponseDispatcher").append(abstractMap.getMapConfig().getMapInstanceId()).toString();
    }

    public AbstractMap getMap() {
        return this.naviMap;
    }

    public IDSIMapViewerControlListener getDefaultHandler() {
        return this.defaultHandler;
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultHandler;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.manager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public String getHandlerName() {
        return this.listenerName;
    }

    public void configureFlags(long[] lArray) {
        CommandResponse.execute(this, new MapResponseDispatcher$1(this, lArray));
    }

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        CommandResponse.execute(this, new MapResponseDispatcher$2(this, navLocationWgs84, bl));
    }

    public void updateDayNightView(boolean bl) {
        CommandResponse.execute(this, new MapResponseDispatcher$3(this, bl));
    }

    public void updateCurrentViewType(int n) {
        CommandResponse.execute(this, new MapResponseDispatcher$4(this, n));
    }

    public void updateViewScreenViewPort(Rect rect) {
        CommandResponse.execute(this, new MapResponseDispatcher$5(this, rect));
    }

    public void updateCarPosition(Point point) {
        CommandResponse.execute(this, new MapResponseDispatcher$6(this, point));
    }

    public void updateMapOrientation(int n) {
        CommandResponse.execute(this, new MapResponseDispatcher$7(this, n));
    }

    public void updateMapMode(int n) {
        CommandResponse.execute(this, new MapResponseDispatcher$8(this, n));
    }

    public void updateSoftZoomEnabled(boolean bl) {
        CommandResponse.execute(this, new MapResponseDispatcher$9(this, bl));
    }
}

