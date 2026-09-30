/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.command.AddMapFlagCmd;
import de.audi.tghu.navi.app.map.command.ClearMapFlagCmd;
import de.audi.tghu.navi.app.map.command.MapCommand;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler;
import de.audi.tghu.navi.app.map.handler.MapFlagUtils;
import de.audi.tghu.navi.app.map.utils.MapArrayUtils;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

public class PinHandler
implements IMapFlagHandler {
    private final AbstractMap map;
    private final IMapFlagHandler.IMapFlagHandlerEnv mapFlagEnv;
    protected final LogChannel sLogChannel;
    protected final ArrayList pinList = new ArrayList();
    private volatile boolean isDirty = true;
    private final LocationSerializer locationSerializer;

    public PinHandler(AbstractMap abstractMap, NavigationEnv navigationEnv, IMapFlagHandler.IMapFlagHandlerEnv iMapFlagHandlerEnv, LocationSerializer locationSerializer) {
        this.map = abstractMap;
        this.locationSerializer = locationSerializer;
        this.sLogChannel = abstractMap.getMapLogChannel();
        this.mapFlagEnv = iMapFlagHandlerEnv;
    }

    private LogChannel getLogChannel() {
        return this.sLogChannel;
    }

    private AbstractMap getMap() {
        return this.map;
    }

    public void refresh(boolean bl, boolean bl2) {
        this.refresh(bl);
    }

    public void refresh(boolean bl) {
        Object[] objectArray;
        if (!bl && !this.isDirty) {
            return;
        }
        this.getLogChannel().log(10000000, "PinHandler#refresh() - forceUpdate=%1, isDirty=%2", bl, this.isDirty);
        ArrayList arrayList = new ArrayList();
        NavLocation navLocation = this.mapFlagEnv.getHome();
        if (navLocation != null) {
            arrayList.add(new MapPin(navLocation.longitude, navLocation.latitude, 23, 1));
        }
        if (this.getMap().getSetup().isFavoriteVisible(0) && (objectArray = this.getMap().getNaviInterface().getFavorites()) != null) {
            this.getLogChannel().log(100000000, "PinHandler#refresh() - got %1 favorites", (long)objectArray.length);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (objectArray[i2] == null) continue;
                arrayList.add(new MapPin(objectArray[i2].getLongitude(), objectArray[i2].getLatitude(), MapUtils.getStyleIndexForFavorite(), (int)objectArray[i2].getUniqueID(), 0));
            }
        }
        objectArray = this.mapFlagEnv.getTops();
        boolean bl2 = this.getMap().getSetup().getTopBusiness(0);
        boolean bl3 = this.getMap().getSetup().getTopPrivate(0);
        if (objectArray != null) {
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                MapPin mapPin = (MapPin)MapFlagUtils.convertAdbEntryToTopDestBusiness((AdbEntry)objectArray[i3], this.locationSerializer);
                if (mapPin != null && bl2) {
                    mapPin.index = i3;
                    mapPin.type = 6;
                    arrayList.add(mapPin);
                    continue;
                }
                mapPin = (MapPin)MapFlagUtils.convertAdbEntryToTopDestPrivate((AdbEntry)objectArray[i3], this.locationSerializer);
                if (mapPin == null || !bl3) continue;
                mapPin.index = i3;
                mapPin.type = 7;
                arrayList.add(mapPin);
            }
        }
        MapPin[] mapPinArray = new MapPin[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); ++i4) {
            mapPinArray[i4] = (MapPin)arrayList.get(i4);
        }
        MapDataContainer mapDataContainer = this.getMap().getMapDataContainer();
        MapPin[] mapPinArray2 = this.mapFlagEnv.getContextDependedPins();
        mapDataContainer.sPins = MapArrayUtils.concatenate(null, mapPinArray, mapPinArray2);
        for (int i5 = 0; i5 < mapDataContainer.sPins.length; ++i5) {
            this.getLogChannel().log(100000000, "PinHandler#refresh() - Pins: %1", (Object)mapDataContainer.sPins[i5]);
        }
        this.setPins(mapDataContainer.sPins);
        this.isDirty = false;
    }

    public MapPin getPin(long l) {
        MapPin[] mapPinArray = this.getMap().getMapDataContainer().sPins;
        if (mapPinArray != null) {
            for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                if (mapPinArray[i2].handle != l) continue;
                return mapPinArray[i2];
            }
        }
        return null;
    }

    public void setTemporaryPins(MapPin[] mapPinArray) {
        this.getLogChannel().log(10000000, "PinHandler#addPins() - %1", (Object)mapPinArray);
        CommandList commandList = this.getMap().createCommandList();
        commandList.add(new AddMapFlagCmd(mapPinArray));
        commandList.execute("PinHandler#addPins()");
        for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
            if (this.pinList.contains(mapPinArray[i2])) continue;
            this.pinList.add(mapPinArray[i2]);
        }
    }

    public void cleanPins(MapPin[] mapPinArray) {
        this.getLogChannel().log(10000000, "PinHandler#cleanPins() - %1", (Object)mapPinArray);
        CommandList commandList = this.getMap().createCommandList();
        commandList.add(new ClearMapFlagCmd(mapPinArray));
        commandList.execute("PinHandler#cleanPins()");
        if (mapPinArray == null || mapPinArray.length == 0) {
            this.pinList.clear();
        } else {
            for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                if (this.pinList.contains(mapPinArray[i2])) {
                    this.pinList.remove(mapPinArray[i2]);
                    continue;
                }
                this.getLogChannel().log(100000, "PinHandler#cleanPins() - %1 does no exist", (long)i2);
            }
        }
    }

    public void setPins(final MapPin[] mapPinArray) {
        for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
            this.getLogChannel().log(100000000, "PinHandler#setPins() - %1 ", (Object)mapPinArray[i2]);
        }
        CommandList commandList = this.getMap().createCommandList();
        commandList.add(new ClearMapFlagCmd());
        commandList.add(new AddMapFlagCmd(mapPinArray));
        commandList.add(new MapCommand("StorePins"){

            public void execute() {
                try {
                    PinHandler.this.getLogChannel().log(10000000, "PinHandler#setPins() - update pin List");
                    PinHandler.this.pinList.clear();
                    for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                        if (PinHandler.this.pinList.contains(mapPinArray[i2])) continue;
                        PinHandler.this.pinList.add(mapPinArray[i2]);
                    }
                }
                catch (Exception exception) {
                    PinHandler.this.getLogChannel().log(100000, "PinHandler#setPins() - %1", (Throwable)exception);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PinHandler#setPins()");
    }

    public void cleanAllPins() {
        this.getLogChannel().log(10000000, "PinHandler#cleanAllPins()");
        CommandList commandList = this.getMap().createCommandList();
        commandList.add(new ClearMapFlagCmd());
        commandList.add(new MapCommand("UpdatePinList"){

            public void execute() {
                try {
                    PinHandler.this.getLogChannel().log(10000000, "PinHandler#cleanAllPins() - update pin list");
                    PinHandler.this.pinList.clear();
                }
                catch (Exception exception) {
                    PinHandler.this.getLogChannel().log(100000, "PinHandler#cleanAllPins() - %1", (Throwable)exception);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PinHandler#cleanAllPins()");
        this.isDirty = true;
    }

    public MapPin[] getPins() {
        return this.getMap().getMapDataContainer().sPins;
    }

    public boolean configureFlags(long[] lArray) {
        return false;
    }

    public void onChangedRenderer(int n) {
    }

    public void addTemporaryPins(MapPin[] mapPinArray) {
    }

    public void removeTemporaryPins(MapPin[] mapPinArray) {
    }
}

