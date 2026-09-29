/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.navi.app.map.dsi.MapFlagHandler$1;
import de.audi.tghu.navi.app.map.utils.PinList;

class MapFlagHandler$PinData {
    protected final PinList pinList = new PinList();
    private PinList processingPins = new PinList();
    private PinList pendingPins = new PinList();
    private boolean pendingPinsNotRequestedYet = false;
    private PinList tempPins = new PinList();
    private PinList pendingTempPins = new PinList();
    private boolean pendingTempPinsNotRequestedYet = false;

    private MapFlagHandler$PinData() {
    }

    /* synthetic */ MapFlagHandler$PinData(MapFlagHandler$1 mapFlagHandler$1) {
        this();
    }

    static /* synthetic */ PinList access$100(MapFlagHandler$PinData mapFlagHandler$PinData) {
        return mapFlagHandler$PinData.tempPins;
    }

    static /* synthetic */ PinList access$200(MapFlagHandler$PinData mapFlagHandler$PinData) {
        return mapFlagHandler$PinData.pendingTempPins;
    }

    static /* synthetic */ boolean access$302(MapFlagHandler$PinData mapFlagHandler$PinData, boolean bl) {
        mapFlagHandler$PinData.pendingTempPinsNotRequestedYet = bl;
        return mapFlagHandler$PinData.pendingTempPinsNotRequestedYet;
    }

    static /* synthetic */ boolean access$300(MapFlagHandler$PinData mapFlagHandler$PinData) {
        return mapFlagHandler$PinData.pendingTempPinsNotRequestedYet;
    }

    static /* synthetic */ PinList access$400(MapFlagHandler$PinData mapFlagHandler$PinData) {
        return mapFlagHandler$PinData.processingPins;
    }

    static /* synthetic */ PinList access$500(MapFlagHandler$PinData mapFlagHandler$PinData) {
        return mapFlagHandler$PinData.pendingPins;
    }

    static /* synthetic */ boolean access$602(MapFlagHandler$PinData mapFlagHandler$PinData, boolean bl) {
        mapFlagHandler$PinData.pendingPinsNotRequestedYet = bl;
        return mapFlagHandler$PinData.pendingPinsNotRequestedYet;
    }

    static /* synthetic */ boolean access$600(MapFlagHandler$PinData mapFlagHandler$PinData) {
        return mapFlagHandler$PinData.pendingPinsNotRequestedYet;
    }
}

