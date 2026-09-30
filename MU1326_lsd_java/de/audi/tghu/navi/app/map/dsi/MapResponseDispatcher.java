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
        this.listenerName = "MapResponseDispatcher" + abstractMap.getMapConfig().getMapInstanceId();
    }

    public AbstractMap getMap() {
        return this.naviMap;
    }

    public IDSIMapViewerControlListener getDefaultHandler() {
        return this.defaultHandler;
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultHandler;
    }

    public CommandList getActiveCommandList() {
        return this.manager.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public String getHandlerName() {
        return this.listenerName;
    }

    public void configureFlags(final long[] lArray) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).configureFlags(lArray);
            }
        });
    }

    public void isDetailedMapMaterialAvailable(final NavLocationWgs84 navLocationWgs84, final boolean bl) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).isDetailedMapMaterialAvailable(navLocationWgs84, bl);
            }
        });
    }

    public void updateDayNightView(final boolean bl) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateDayNightView(bl);
            }
        });
    }

    public void updateCurrentViewType(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateCurrentViewType(n);
            }
        });
    }

    public void updateViewScreenViewPort(final Rect rect) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateViewScreenViewPort(rect);
            }
        });
    }

    public void updateCarPosition(final Point point) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateCarPosition(point);
            }
        });
    }

    public void updateMapOrientation(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateMapOrientation(n);
            }
        });
    }

    public void updateMapMode(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateMapMode(n);
            }
        });
    }

    public void updateSoftZoomEnabled(final boolean bl) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSIMapViewerControlListener)dSIListener).updateSoftZoomEnabled(bl);
            }
        });
    }
}

