/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.StationInfoExt;
import org.dsi.ifc.sdars.RadioText;

public class ArtistTitleRow
extends EvoListRow {
    public static final int SORTMODE_ARTIST = 0;
    public static final int SORTMODE_TITLE = 1;
    public static final int SORTMODES_COUNT = 2;
    protected static final int INDEX_RS = 0;
    protected static final int INDEX_ARTIST = 1;
    protected static final int INDEX_TITLE = 2;
    protected static final int INDEX_STATIONNAME = 3;
    protected static final int INDEX_STATIONNUMBER = 4;
    protected static final int INDEX_ISFAVORITE = 5;
    public static final int NUM_COLUMNS = 6;
    private final StationInfoExt station;
    private final RadioText pdt;
    private int mode;
    private boolean isFavorite;

    public ArtistTitleRow(RadioText radioText, StationInfoExt stationInfoExt, int n) {
        this(6, radioText, stationInfoExt, n);
    }

    protected ArtistTitleRow(int n, RadioText radioText, StationInfoExt stationInfoExt, int n2) {
        super(radioText.sID, n);
        this.station = stationInfoExt;
        this.pdt = radioText;
        this.mode = n2;
        this.isFavorite = false;
        this.updateColumns();
    }

    protected ArtistTitleRow(ArtistTitleRow artistTitleRow) {
        super(artistTitleRow);
        this.station = artistTitleRow.station;
        this.pdt = artistTitleRow.pdt;
        this.mode = artistTitleRow.mode;
        this.isFavorite = artistTitleRow.isFavorite;
    }

    public EvoListRow copy() {
        return new ArtistTitleRow(this);
    }

    public RadioText getRadioText() {
        return this.pdt;
    }

    public StationInfoExt getStation() {
        return this.station;
    }

    public void setMode(int n) {
        this.mode = n;
        this.updateColumns();
    }

    public void setFavorite(boolean bl) {
        this.isFavorite = bl;
        this.updateColumns();
    }

    private void updateColumns() {
        this.setInteger(0, this.mode + (this.isFavorite ? 2 : 0));
        this.setText(1, this.pdt.longArtistName);
        this.setText(2, this.pdt.longProgramTitle);
        this.setText(3, this.station.shortLabel);
        this.setText(4, Utilities.getFormatedStationNumber(this.station.stationNumber));
        this.setInteger(5, 0);
    }

    public boolean getFavorite() {
        return this.isFavorite;
    }
}

