/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.dsi.MapFlagHandler$PinData;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler$IMapFlagHandlerEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.PinList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;

public class MapFlagHandler
implements IMapFlagHandler {
    private Object mutex = new Object();
    private final MapFlagHandler$PinData mapPins = new MapFlagHandler$PinData(null);
    private final IMapFlagHandler$IMapFlagHandlerEnv mapFlagEnv;
    protected final LogChannel sLogChannel;
    private boolean waitingForResponse = false;

    public MapFlagHandler(IMapFlagHandler$IMapFlagHandlerEnv iMapFlagHandler$IMapFlagHandlerEnv) {
        this.sLogChannel = iMapFlagHandler$IMapFlagHandlerEnv.getLogger();
        this.mapFlagEnv = iMapFlagHandler$IMapFlagHandlerEnv;
    }

    private LogChannel getLogChannel() {
        return this.sLogChannel;
    }

    @Override
    public void refresh(boolean bl) {
        this.getLogChannel().log(14808325, "MapFlagHandler#refresh() removeTempPins");
        this.refresh(bl, true);
    }

    @Override
    public void refresh(boolean bl, boolean bl2) {
        Object object;
        NavLocation navLocation;
        if (!bl) {
            return;
        }
        this.getLogChannel().log(-2137614336, "MapFlagHandler#refresh() - forceUpdate=%1 removeTempPins=%2", bl, bl2);
        PinList pinList = new PinList();
        NavLocation navLocation2 = this.mapFlagEnv.getHome();
        if (navLocation2 != null) {
            pinList.add(new MapPin(navLocation2.longitude, navLocation2.latitude, 23, 1));
        }
        if ((navLocation = this.mapFlagEnv.getOffice()) != null) {
            pinList.add(new MapPin(navLocation.longitude, navLocation.latitude, 1, 9));
        }
        if (this.mapFlagEnv.isFavoriteVisible(0) && (object = this.mapFlagEnv.getFavorites()) != null) {
            this.getLogChannel().log(14808325, "MapFlagHandler#refresh() - got %1 favorites", (long)((IFavorite[])object).length);
            for (int i2 = 0; i2 < ((IFavorite[])object).length; ++i2) {
                if (object[i2] == null) continue;
                pinList.add(new MapPin(object[i2].getLongitude(), object[i2].getLatitude(), MapUtils.getStyleIndexForFavorite(), (int)object[i2].getUniqueID(), 0));
            }
        }
        pinList.addAll(this.mapFlagEnv.getContextDependedPins());
        object = this.mapFlagEnv.getMapDataContainer();
        object.sPins = pinList.toArray();
        this.setPins(object.sPins, bl2);
    }

    @Override
    public MapPin getPin(long l) {
        int n;
        MapPin[] mapPinArray = this.mapPins.pinList.toArray();
        if (mapPinArray != null) {
            for (n = 0; n < mapPinArray.length; ++n) {
                if (mapPinArray[n].handle != l) continue;
                return mapPinArray[n];
            }
        }
        if (MapFlagHandler$PinData.access$100(this.mapPins).size() > 0) {
            for (n = 0; n < MapFlagHandler$PinData.access$100(this.mapPins).size(); ++n) {
                if (MapFlagHandler$PinData.access$100((MapFlagHandler$PinData)this.mapPins).get((int)n).handle != l) continue;
                return MapFlagHandler$PinData.access$100(this.mapPins).get(n);
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setTemporaryPins(MapPin[] mapPinArray) {
        if (mapPinArray == null) {
            return;
        }
        this.getLogChannel().log(-2137614336, "MapFlagHandler#setTemporaryPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForResponse) {
                this.getLogChannel().log(-2137614336, "MapFlagHandler#setTemporaryPins() - queued");
                MapFlagHandler$PinData.access$200(this.mapPins).clear();
                MapFlagHandler$PinData.access$200(this.mapPins).addAll(mapPinArray);
                MapFlagHandler$PinData.access$302(this.mapPins, true);
                return;
            }
            PinList pinList = new PinList();
            PinList pinList2 = new PinList();
            MapFlagHandler$PinData.access$100(this.mapPins).set(mapPinArray, pinList, pinList2);
            this.addAndRemove(MapFlagHandler$PinData.access$100(this.mapPins), pinList2, pinList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addTemporaryPins(MapPin[] mapPinArray) {
        if (mapPinArray == null) {
            return;
        }
        this.getLogChannel().log(-2137614336, "MapFlagHandler#addTemporaryPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            PinList pinList = new PinList();
            pinList.addAll(mapPinArray);
            if (MapFlagHandler$PinData.access$300(this.mapPins)) {
                pinList.addAll(MapFlagHandler$PinData.access$200(this.mapPins));
            } else {
                pinList.addAll(MapFlagHandler$PinData.access$100(this.mapPins));
            }
            this.setTemporaryPins(pinList.toArray());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeTemporaryPins(MapPin[] mapPinArray) {
        if (mapPinArray == null) {
            return;
        }
        this.getLogChannel().log(-2137614336, "MapFlagHandler#removeTemporaryPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            PinList pinList = new PinList();
            if (MapFlagHandler$PinData.access$300(this.mapPins)) {
                pinList.addAll(MapFlagHandler$PinData.access$200(this.mapPins));
            } else {
                pinList.addAll(MapFlagHandler$PinData.access$100(this.mapPins));
            }
            pinList.removeAll(mapPinArray);
            this.setTemporaryPins(pinList.toArray());
        }
    }

    @Override
    public void cleanPins(MapPin[] mapPinArray) {
        this.getLogChannel().log(-2137614336, "MapFlagHandler#cleanPins() - unexpected call %1", (Object)mapPinArray);
        this.setPins(null);
    }

    private void addAndRemove(PinList pinList, PinList pinList2, PinList pinList3) {
        int n;
        for (n = 0; n < pinList.size(); ++n) {
            this.getLogChannel().log(14808325, "MapFlagHandler#addAndRemove() - [=] %1", (Object)pinList.get(n));
        }
        for (n = 0; n < pinList3.size(); ++n) {
            this.getLogChannel().log(-2137614336, "MapFlagHandler#addAndRemove() - [-] %1", (Object)pinList3.get(n));
        }
        for (n = 0; n < pinList2.size(); ++n) {
            this.getLogChannel().log(-2137614336, "MapFlagHandler#addAndRemove() - [+] %1", (Object)pinList2.get(n));
        }
        if (pinList2.size() == 0 && pinList3.size() == 0) {
            this.getLogChannel().log(14808325, "MapFlagHandler#addAndRemove() - nothing changed ");
            this.handlePendingPins();
            return;
        }
        if (pinList3.size() > 0) {
            this.waitingForResponse = true;
            this.getLogChannel().log(-2137614336, "MapFlagHandler#addAndRemove() - removeList len : %1", (long)pinList3.size());
            this.mapFlagEnv.configureFlags(2, pinList3.toArray());
        }
        if (pinList2.size() > 0) {
            this.waitingForResponse = true;
            this.getLogChannel().log(-2137614336, "MapFlagHandler#addAndRemove() - process");
            MapFlagHandler$PinData.access$400(this.mapPins).addAll(pinList2);
            this.mapFlagEnv.configureFlags(0, pinList2.toArray());
        }
    }

    @Override
    public void setPins(MapPin[] mapPinArray) {
        this.getLogChannel().log(14808325, "MapFlagHandler#setPins()");
        this.setPins(mapPinArray, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setPins(MapPin[] mapPinArray, boolean bl) {
        this.getLogChannel().log(-2137614336, "MapFlagHandler#setPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForResponse) {
                this.getLogChannel().log(-2137614336, "MapFlagHandler#setPins() - queued");
                MapFlagHandler$PinData.access$500(this.mapPins).clear();
                MapFlagHandler$PinData.access$500(this.mapPins).addAll(mapPinArray);
                MapFlagHandler$PinData.access$602(this.mapPins, true);
                MapFlagHandler$PinData.access$200(this.mapPins).clear();
                MapFlagHandler$PinData.access$302(this.mapPins, false);
                return;
            }
            PinList pinList = new PinList();
            PinList pinList2 = new PinList();
            this.mapPins.pinList.set(mapPinArray, pinList, pinList2);
            if (MapFlagHandler$PinData.access$100(this.mapPins).size() > 0 && bl) {
                pinList.addAll(MapFlagHandler$PinData.access$100(this.mapPins));
                MapFlagHandler$PinData.access$100(this.mapPins).clear();
            }
            this.addAndRemove(this.mapPins.pinList, pinList2, pinList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cleanAllPins() {
        this.getLogChannel().log(-2137614336, "MapFlagHandler#cleanAllPins()");
        Object object = this.mutex;
        synchronized (object) {
            this.mapPins.pinList.clear();
            MapFlagHandler$PinData.access$100(this.mapPins).clear();
            this.mapFlagEnv.configureFlags(1, new MapFlag[0]);
        }
    }

    @Override
    public MapPin[] getPins() {
        return this.mapPins.pinList.toArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean configureFlags(long[] lArray) {
        Object object = this.mutex;
        synchronized (object) {
            if (lArray == null || lArray.length == 0) {
                this.getLogChannel().log(14808325, "MapFlagHandler#configureFlags() - some flags were removed.");
                if (MapFlagHandler$PinData.access$400(this.mapPins).size() == 0) {
                    this.waitingForResponse = false;
                }
                this.handlePendingPins();
            } else if (!this.waitingForResponse) {
                this.getLogChannel().log(-1601830656, "MapFlagHandler#configureFlags(): unexpected call");
            } else {
                this.getLogChannel().log(14808325, "MapFlagHandler#configureFlags() - [%1]", (Object)MapUtils.toString(lArray));
                try {
                    for (int i2 = 0; i2 < lArray.length; ++i2) {
                        if (lArray[i2] != -1L) {
                            MapFlagHandler$PinData.access$400((MapFlagHandler$PinData)this.mapPins).get((int)i2).handle = lArray[i2];
                            this.getLogChannel().log(14808325, "MapFlagHandler#configureFlags(): %1", (Object)MapFlagHandler$PinData.access$400(this.mapPins).get(i2));
                            continue;
                        }
                        this.getLogChannel().log(10000, "MapFlagHandler#configureFlags(): handle already set in map (handle is -1)");
                    }
                }
                catch (Exception exception) {
                    this.getLogChannel().log(-1601830656, "MapFlagHandler#configureFlags(): %1", (Throwable)exception);
                }
                this.waitingForResponse = false;
                MapFlagHandler$PinData.access$400(this.mapPins).clear();
                this.handlePendingPins();
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handlePendingPins() {
        Object object = this.mutex;
        synchronized (object) {
            this.getLogChannel().log(-2137614336, "MapFlagHandler#handlePendingPins() - processing:%1, pending:%2, pendingTemp:%3", (long)MapFlagHandler$PinData.access$400(this.mapPins).size(), (long)MapFlagHandler$PinData.access$500(this.mapPins).size(), (long)MapFlagHandler$PinData.access$200(this.mapPins).size());
            if (this.waitingForResponse) {
                return;
            }
            if (MapFlagHandler$PinData.access$600(this.mapPins)) {
                MapFlagHandler$PinData.access$602(this.mapPins, false);
                MapPin[] mapPinArray = MapFlagHandler$PinData.access$500(this.mapPins).toArray();
                MapFlagHandler$PinData.access$500(this.mapPins).clear();
                this.setPins(mapPinArray);
            } else if (MapFlagHandler$PinData.access$300(this.mapPins)) {
                MapFlagHandler$PinData.access$302(this.mapPins, false);
                MapPin[] mapPinArray = MapFlagHandler$PinData.access$200(this.mapPins).toArray();
                MapFlagHandler$PinData.access$200(this.mapPins).clear();
                this.setTemporaryPins(mapPinArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onChangedRenderer(int n) {
        this.getLogChannel().log(-2137614336, "MapFlagHandler#onChangedRenderer( %1 )", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForResponse) {
                this.getLogChannel().log(-1601830656, "MapFlagHandler#onChangedRenderer() - cancel processing");
            }
            this.waitingForResponse = false;
            MapFlagHandler$PinData.access$400(this.mapPins).clear();
            MapFlagHandler$PinData.access$500(this.mapPins).clear();
            MapFlagHandler$PinData.access$602(this.mapPins, false);
            MapFlagHandler$PinData.access$200(this.mapPins).clear();
            MapFlagHandler$PinData.access$302(this.mapPins, false);
            this.cleanAllPins();
        }
    }
}

