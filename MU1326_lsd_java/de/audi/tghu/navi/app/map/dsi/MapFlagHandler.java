/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.PinList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;

public class MapFlagHandler
implements IMapFlagHandler {
    private Object mutex = new Object();
    private final PinData mapPins = new PinData();
    private final IMapFlagHandler.IMapFlagHandlerEnv mapFlagEnv;
    protected final LogChannel sLogChannel;
    private boolean waitingForResponse = false;

    public MapFlagHandler(IMapFlagHandler.IMapFlagHandlerEnv iMapFlagHandlerEnv) {
        this.sLogChannel = iMapFlagHandlerEnv.getLogger();
        this.mapFlagEnv = iMapFlagHandlerEnv;
    }

    private LogChannel getLogChannel() {
        return this.sLogChannel;
    }

    public void refresh(boolean bl) {
        this.getLogChannel().log(100000000, "MapFlagHandler#refresh() removeTempPins");
        this.refresh(bl, true);
    }

    public void refresh(boolean bl, boolean bl2) {
        Object object;
        NavLocation navLocation;
        if (!bl) {
            return;
        }
        this.getLogChannel().log(10000000, "MapFlagHandler#refresh() - forceUpdate=%1 removeTempPins=%2", bl, bl2);
        PinList pinList = new PinList();
        NavLocation navLocation2 = this.mapFlagEnv.getHome();
        if (navLocation2 != null) {
            pinList.add(new MapPin(navLocation2.longitude, navLocation2.latitude, 23, 1));
        }
        if ((navLocation = this.mapFlagEnv.getOffice()) != null) {
            pinList.add(new MapPin(navLocation.longitude, navLocation.latitude, 1, 9));
        }
        if (this.mapFlagEnv.isFavoriteVisible(0) && (object = this.mapFlagEnv.getFavorites()) != null) {
            this.getLogChannel().log(100000000, "MapFlagHandler#refresh() - got %1 favorites", (long)((IFavorite[])object).length);
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

    public MapPin getPin(long l) {
        int n;
        MapPin[] mapPinArray = this.mapPins.pinList.toArray();
        if (mapPinArray != null) {
            for (n = 0; n < mapPinArray.length; ++n) {
                if (mapPinArray[n].handle != l) continue;
                return mapPinArray[n];
            }
        }
        if (this.mapPins.tempPins.size() > 0) {
            for (n = 0; n < this.mapPins.tempPins.size(); ++n) {
                if (((PinData)this.mapPins).tempPins.get((int)n).handle != l) continue;
                return this.mapPins.tempPins.get(n);
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTemporaryPins(MapPin[] mapPinArray) {
        if (mapPinArray == null) {
            return;
        }
        this.getLogChannel().log(10000000, "MapFlagHandler#setTemporaryPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForResponse) {
                this.getLogChannel().log(10000000, "MapFlagHandler#setTemporaryPins() - queued");
                this.mapPins.pendingTempPins.clear();
                this.mapPins.pendingTempPins.addAll(mapPinArray);
                this.mapPins.pendingTempPinsNotRequestedYet = true;
                return;
            }
            PinList pinList = new PinList();
            PinList pinList2 = new PinList();
            this.mapPins.tempPins.set(mapPinArray, pinList, pinList2);
            this.addAndRemove(this.mapPins.tempPins, pinList2, pinList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addTemporaryPins(MapPin[] mapPinArray) {
        if (mapPinArray == null) {
            return;
        }
        this.getLogChannel().log(10000000, "MapFlagHandler#addTemporaryPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            PinList pinList = new PinList();
            pinList.addAll(mapPinArray);
            if (this.mapPins.pendingTempPinsNotRequestedYet) {
                pinList.addAll(this.mapPins.pendingTempPins);
            } else {
                pinList.addAll(this.mapPins.tempPins);
            }
            this.setTemporaryPins(pinList.toArray());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeTemporaryPins(MapPin[] mapPinArray) {
        if (mapPinArray == null) {
            return;
        }
        this.getLogChannel().log(10000000, "MapFlagHandler#removeTemporaryPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            PinList pinList = new PinList();
            if (this.mapPins.pendingTempPinsNotRequestedYet) {
                pinList.addAll(this.mapPins.pendingTempPins);
            } else {
                pinList.addAll(this.mapPins.tempPins);
            }
            pinList.removeAll(mapPinArray);
            this.setTemporaryPins(pinList.toArray());
        }
    }

    public void cleanPins(MapPin[] mapPinArray) {
        this.getLogChannel().log(10000000, "MapFlagHandler#cleanPins() - unexpected call %1", (Object)mapPinArray);
        this.setPins(null);
    }

    private void addAndRemove(PinList pinList, PinList pinList2, PinList pinList3) {
        int n;
        for (n = 0; n < pinList.size(); ++n) {
            this.getLogChannel().log(100000000, "MapFlagHandler#addAndRemove() - [=] %1", (Object)pinList.get(n));
        }
        for (n = 0; n < pinList3.size(); ++n) {
            this.getLogChannel().log(10000000, "MapFlagHandler#addAndRemove() - [-] %1", (Object)pinList3.get(n));
        }
        for (n = 0; n < pinList2.size(); ++n) {
            this.getLogChannel().log(10000000, "MapFlagHandler#addAndRemove() - [+] %1", (Object)pinList2.get(n));
        }
        if (pinList2.size() == 0 && pinList3.size() == 0) {
            this.getLogChannel().log(100000000, "MapFlagHandler#addAndRemove() - nothing changed ");
            this.handlePendingPins();
            return;
        }
        if (pinList3.size() > 0) {
            this.waitingForResponse = true;
            this.getLogChannel().log(10000000, "MapFlagHandler#addAndRemove() - removeList len : %1", (long)pinList3.size());
            this.mapFlagEnv.configureFlags(2, pinList3.toArray());
        }
        if (pinList2.size() > 0) {
            this.waitingForResponse = true;
            this.getLogChannel().log(10000000, "MapFlagHandler#addAndRemove() - process");
            this.mapPins.processingPins.addAll(pinList2);
            this.mapFlagEnv.configureFlags(0, pinList2.toArray());
        }
    }

    public void setPins(MapPin[] mapPinArray) {
        this.getLogChannel().log(100000000, "MapFlagHandler#setPins()");
        this.setPins(mapPinArray, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setPins(MapPin[] mapPinArray, boolean bl) {
        this.getLogChannel().log(10000000, "MapFlagHandler#setPins() - len:%1", (long)mapPinArray.length);
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForResponse) {
                this.getLogChannel().log(10000000, "MapFlagHandler#setPins() - queued");
                this.mapPins.pendingPins.clear();
                this.mapPins.pendingPins.addAll(mapPinArray);
                this.mapPins.pendingPinsNotRequestedYet = true;
                this.mapPins.pendingTempPins.clear();
                this.mapPins.pendingTempPinsNotRequestedYet = false;
                return;
            }
            PinList pinList = new PinList();
            PinList pinList2 = new PinList();
            this.mapPins.pinList.set(mapPinArray, pinList, pinList2);
            if (this.mapPins.tempPins.size() > 0 && bl) {
                pinList.addAll(this.mapPins.tempPins);
                this.mapPins.tempPins.clear();
            }
            this.addAndRemove(this.mapPins.pinList, pinList2, pinList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cleanAllPins() {
        this.getLogChannel().log(10000000, "MapFlagHandler#cleanAllPins()");
        Object object = this.mutex;
        synchronized (object) {
            this.mapPins.pinList.clear();
            this.mapPins.tempPins.clear();
            this.mapFlagEnv.configureFlags(1, new MapFlag[0]);
        }
    }

    public MapPin[] getPins() {
        return this.mapPins.pinList.toArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean configureFlags(long[] lArray) {
        Object object = this.mutex;
        synchronized (object) {
            if (lArray == null || lArray.length == 0) {
                this.getLogChannel().log(100000000, "MapFlagHandler#configureFlags() - some flags were removed.");
                if (this.mapPins.processingPins.size() == 0) {
                    this.waitingForResponse = false;
                }
                this.handlePendingPins();
            } else if (!this.waitingForResponse) {
                this.getLogChannel().log(100000, "MapFlagHandler#configureFlags(): unexpected call");
            } else {
                this.getLogChannel().log(100000000, "MapFlagHandler#configureFlags() - [%1]", (Object)MapUtils.toString(lArray));
                try {
                    for (int i2 = 0; i2 < lArray.length; ++i2) {
                        if (lArray[i2] != -1L) {
                            ((PinData)this.mapPins).processingPins.get((int)i2).handle = lArray[i2];
                            this.getLogChannel().log(100000000, "MapFlagHandler#configureFlags(): %1", (Object)this.mapPins.processingPins.get(i2));
                            continue;
                        }
                        this.getLogChannel().log(10000, "MapFlagHandler#configureFlags(): handle already set in map (handle is -1)");
                    }
                }
                catch (Exception exception) {
                    this.getLogChannel().log(100000, "MapFlagHandler#configureFlags(): %1", (Throwable)exception);
                }
                this.waitingForResponse = false;
                this.mapPins.processingPins.clear();
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
            this.getLogChannel().log(10000000, "MapFlagHandler#handlePendingPins() - processing:%1, pending:%2, pendingTemp:%3", (long)this.mapPins.processingPins.size(), (long)this.mapPins.pendingPins.size(), (long)this.mapPins.pendingTempPins.size());
            if (this.waitingForResponse) {
                return;
            }
            if (this.mapPins.pendingPinsNotRequestedYet) {
                this.mapPins.pendingPinsNotRequestedYet = false;
                MapPin[] mapPinArray = this.mapPins.pendingPins.toArray();
                this.mapPins.pendingPins.clear();
                this.setPins(mapPinArray);
            } else if (this.mapPins.pendingTempPinsNotRequestedYet) {
                this.mapPins.pendingTempPinsNotRequestedYet = false;
                MapPin[] mapPinArray = this.mapPins.pendingTempPins.toArray();
                this.mapPins.pendingTempPins.clear();
                this.setTemporaryPins(mapPinArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onChangedRenderer(int n) {
        this.getLogChannel().log(10000000, "MapFlagHandler#onChangedRenderer( %1 )", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForResponse) {
                this.getLogChannel().log(100000, "MapFlagHandler#onChangedRenderer() - cancel processing");
            }
            this.waitingForResponse = false;
            this.mapPins.processingPins.clear();
            this.mapPins.pendingPins.clear();
            this.mapPins.pendingPinsNotRequestedYet = false;
            this.mapPins.pendingTempPins.clear();
            this.mapPins.pendingTempPinsNotRequestedYet = false;
            this.cleanAllPins();
        }
    }

    private static class PinData {
        protected final PinList pinList = new PinList();
        private PinList processingPins = new PinList();
        private PinList pendingPins = new PinList();
        private boolean pendingPinsNotRequestedYet = false;
        private PinList tempPins = new PinList();
        private PinList pendingTempPins = new PinList();
        private boolean pendingTempPinsNotRequestedYet = false;

        private PinData() {
        }
    }
}

