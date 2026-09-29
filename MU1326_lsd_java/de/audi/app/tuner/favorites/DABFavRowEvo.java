/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.favorites;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.memory.DABMemoryRow;

public class DABFavRowEvo
extends DABMemoryRow {
    private static final int INDEX_PROPERTIES;
    private static final int INDEX_DEFAULT_IMAGE_ID;
    private static final int INDEX_PRESET_POS;
    public static final int NUM_COLS;
    private final RadioRowProperties props;

    public DABFavRowEvo(TunerObjectContainer tunerObjectContainer, int n) {
        super(17, tunerObjectContainer, n);
        DabStation dabStation = tunerObjectContainer.getDABStation();
        this.setText(0, dabStation.getFullName());
        this.props = new RadioRowProperties();
        this.props.setCategory(181330000);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(15, 5);
        this.setInteger(16, 0);
    }

    private DABFavRowEvo(DABFavRowEvo dABFavRowEvo) {
        super(dABFavRowEvo);
        this.props = dABFavRowEvo.props;
    }

    @Override
    public EvoListRow copy() {
        return new DABFavRowEvo(this);
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
    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        super.setProgramData(tunerObjectContainer, n);
        if (tunerObjectContainer.getReceptionStatus() == 2) {
            this.setInteger(2, 0);
        } else {
            this.setInteger(2, this.getBand());
        }
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

    @Override
    protected void resetOverwrite() {
        super.resetOverwrite();
        this.setText(0, this.station.getFullName());
    }
}

