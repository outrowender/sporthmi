/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.uni.stationlist;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UnifiedStationExt;

public class UniListRowEvo
extends UniListRow {
    private final RadioRowProperties props;

    public UniListRowEvo(UnifiedStationExt unifiedStationExt, boolean bl, int n) {
        super(14, unifiedStationExt, bl, n);
        this.props = new RadioRowProperties();
        this.props.setCategory(unifiedStationExt.isAnalog() ? 1466468416 : 801161503);
        this.props.setScrollingPS(unifiedStationExt.scrollingPS == 2);
        this.props.setNameFreezed(unifiedStationExt.isPsFreezed());
        this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    private UniListRowEvo(UniListRowEvo uniListRowEvo) {
        super(uniListRowEvo);
        this.props = uniListRowEvo.props;
    }

    public EvoListRow copy() {
        return new UniListRowEvo(this);
    }

    public void setStationActive(boolean bl) {
        super.setStationActive(bl);
        this.props.setActive(bl);
        this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        if (!bl) {
            this.reset();
        }
    }

    protected void setSLSAvailability(HMIResourceLocator hMIResourceLocator) {
        super.setSLSAvailability(hMIResourceLocator);
        if (hMIResourceLocator.containsResourceURI()) {
            this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        }
    }
}

