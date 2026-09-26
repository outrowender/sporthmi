/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.favorites;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.memory.UniMemoryRow;
import de.audi.tuner.app.uni.UnifiedStationExt;

public class UniFavRowEvo
extends UniMemoryRow {
    private static final int INDEX_PROPERTIES;
    private static final int INDEX_DEFAULT_IMAGE_ID;
    public static final int NUM_COLS;
    private final RadioRowProperties props;

    public UniFavRowEvo(UnifiedStationExt unifiedStationExt, int n) {
        super(16, unifiedStationExt, n);
        this.props = new RadioRowProperties();
        this.props.setCategory(unifiedStationExt.isAnalog() ? 1082681431 : 532791343);
        this.props.setScrollingPS(unifiedStationExt.scrollingPS == 2);
        this.props.setNameFreezed(unifiedStationExt.isPsFreezed());
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(15, 11);
    }

    private UniFavRowEvo(UniFavRowEvo uniFavRowEvo) {
        super(uniFavRowEvo);
        this.props = uniFavRowEvo.props;
    }

    @Override
    public EvoListRow copy() {
        return new UniFavRowEvo(this);
    }

    @Override
    public void setStationActive(boolean bl) {
        this.props.setActive(bl);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        if (!bl) {
            this.resetProgramData();
        }
    }

    @Override
    public void setPSFreeze(boolean bl, String string) {
        super.setPSFreeze(bl, string);
        this.props.setNameFreezed(bl);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    @Override
    public void setSLSAvailability(HMIResourceLocator hMIResourceLocator) {
        if (hMIResourceLocator.containsResourceURI()) {
            this.setInteger(12, 2);
            this.props.setNoSlideShow(false);
            this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        } else {
            this.setInteger(12, 1);
        }
    }
}

