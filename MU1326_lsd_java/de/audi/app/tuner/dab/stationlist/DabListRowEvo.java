/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.dab.stationlist;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.dab.stationlist.RecordSets;

public class DabListRowEvo
extends DabListRow {
    private static final int INDEX_PROPERTIES = 9;
    private static final int INDEX_ARTIST = 10;
    private static final int INDEX_TITLE = 11;
    private static final int INDEX_DASH = 12;
    private static final int INDEX_DEFAULT_IMAGE_ID = 13;
    private static final int INDEX_RADIOTEXT_ICON = 14;
    private static final int INDEX_SLIDESHOW_ICON = 15;
    private static final int INDEX_IS_ENSEMBLE = 16;
    public static final int NUM_COLS = 17;
    private final RadioRowProperties props;

    public DabListRowEvo(RecordSets recordSets, DabStation dabStation, boolean bl, int n) {
        super(17, recordSets, dabStation, bl, n);
        this.props = new RadioRowProperties();
        switch (dabStation.getType()) {
            case 1: {
                this.props.setCategory(1236892399);
                break;
            }
            case 2: {
                if (dabStation.ensemble.ensID != 0) {
                    this.props.setCategory(1356910090);
                    break;
                }
                this.props.setCategory(-371109441);
                break;
            }
            case 3: {
                this.props.setCategory(1356910090);
                break;
            }
        }
        this.setInteger(15, dabStation.getSlsImage().containsResourceURI() ? 1 : 0);
        this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(13, 5);
        this.setInteger(16, dabStation.isEnsemble() ? 1 : 0);
        this.setProgramData(dabStation, n);
    }

    public DabListRowEvo(DabListRowEvo dabListRowEvo) {
        super(dabListRowEvo);
        this.props = dabListRowEvo.props;
    }

    public EvoListRow copy() {
        return new DabListRowEvo(this);
    }

    public void setStationActive(boolean bl) {
        super.setStationActive(bl);
        this.props.setActive(bl);
        this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        if (!bl) {
            this.resetProgramData();
        }
    }

    public final void setProgramData(DabStation dabStation, int n) {
        super.setProgramData(dabStation, n);
        this.setInteger(14, dabStation.getTag(64).length() > 0 ? 2 : 1);
        ArtistAndTitlePair artistAndTitlePair = dabStation.getArtistAndTitlePair();
        this.setText(10, artistAndTitlePair.artistString);
        this.setText(11, artistAndTitlePair.titleString);
        this.setInteger(12, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
        if (this.isEnsemble() && this.isClosed()) {
            this.props.setCategory(-246403493);
            this.props.setActive(true);
            this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        }
    }

    public void resetProgramData() {
        super.resetProgramData();
        this.setText(1, this.station.getFullName());
        this.setText(10, "");
        this.setText(11, "");
        this.setInteger(12, 0);
        this.setInteger(14, 1);
        this.setInteger(15, 1);
        if (this.isEnsemble()) {
            this.props.setCategory(1236892399);
            this.props.setActive(false);
            this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        }
    }

    public void setSLSAvailability(HMIResourceLocator hMIResourceLocator) {
        if (hMIResourceLocator.containsResourceURI()) {
            this.setInteger(15, 2);
            this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        } else {
            this.setInteger(15, 1);
        }
    }

    public DabListRow open(DabStation dabStation) {
        super.open(dabStation);
        if (this.isEnsemble()) {
            if (this.isActive(dabStation)) {
                this.setText(10, "");
                this.setText(11, "");
                this.setInteger(12, Utilities.getDashCode("", ""));
            }
            this.props.setCategory(1236892399);
            this.props.setActive(false);
            this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        }
        return this;
    }

    public DabListRow close(DabStation dabStation) {
        super.close(dabStation);
        if (this.isEnsemble() && this.isActive(dabStation)) {
            ArtistAndTitlePair artistAndTitlePair = dabStation.getArtistAndTitlePair();
            this.setText(10, artistAndTitlePair.artistString);
            this.setText(11, artistAndTitlePair.titleString);
            this.setInteger(12, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
            this.props.setCategory(-246403493);
            this.props.setActive(true);
            this.setPropertyCell(9, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        }
        return this;
    }
}

