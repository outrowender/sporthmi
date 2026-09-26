/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.EmptyMemoryRow;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.ISimpleTuner;

public abstract class AbstractMemoryRow
extends AbstractRadioListRow {
    protected static final int COL0_STATION_NAME;
    protected static final int COL1_FREQUENCY_NAME;
    protected static final int COL2_BAND_ID;
    protected static final int COL3_PSFREEZE_STATUS;
    protected static final int COL4_LAYOUT;
    protected static final int COL5_FREQUENCY_UNIT;
    protected static final int COL6_HD_ICON;
    protected static final int COL7_ARTIST;
    protected static final int COL8_TITLE;
    protected static final int COL9_DASH;
    protected static final int INDEX_IMAGE;
    protected static final int INDEX_RADIOTEXT_ICON;
    protected static final int INDEX_SLIDESHOW_ICON;
    protected static final int INDEX_SDARS_CATEGORY;
    public static final int NUMBER_OF_COLS_MEM;
    public static final int STATUS_OK;
    public static final int STATUS_NOT_INITIALIZED;
    public static final int STATUS_ANTENNA_ERROR;
    public static final int STATUS_BAND_ERROR;
    public static final int STATUS_STATION_UNSUBSCRIBED;
    public static final int STATUS_STATION_INVALID;
    public static final int HD_ICON_NON;
    public static final int HD_ICON_GREY;
    public static final int HD_ICON_WHITE;
    public static final int HD_ICON_LOW_RECEPTION;
    private final int band;
    private int bandState = 0;
    private String combiIndexLabel = "";

    protected AbstractMemoryRow(int n, int n2) {
        super(AbstractListRowFactory.getNextUniqueId(), n);
        this.band = n2;
    }

    protected AbstractMemoryRow(AbstractMemoryRow abstractMemoryRow) {
        super(abstractMemoryRow);
        this.band = abstractMemoryRow.band;
        this.bandState = abstractMemoryRow.bandState;
    }

    public final int getBand() {
        return this.band;
    }

    public final String getCombiIndexLabel() {
        return this.combiIndexLabel;
    }

    public final int getState() {
        if (this.bandState != 0) {
            return this.bandState;
        }
        return this.getStationState();
    }

    protected int getStationState() {
        return 0;
    }

    public final boolean isOccupied() {
        return !(this instanceof EmptyMemoryRow);
    }

    public final void setBandStatus(int n) {
        this.bandState = n;
        this.setLineColor();
    }

    protected void setLineColor() {
    }

    public boolean isPSFreezed() {
        return false;
    }

    public final boolean isEmpty() {
        return this.band == 8;
    }

    public final boolean isAmFm() {
        return this.band == 4 || this.band == 1;
    }

    public final boolean isDAB() {
        return this.band == 5;
    }

    public final boolean isSDARS() {
        return this.band == 7;
    }

    public ListCell getReceptionCell() {
        return IntegerListCell.create(0);
    }

    public void resetProgramData() {
        this.setInteger(11, 0);
        this.setInteger(12, this.band == 4 || this.band == 1 ? 0 : 1);
        this.setText(7, "");
        this.setText(8, "");
        this.setInteger(9, 0);
        this.setHMIResourceLocator(10, ISimpleTuner.EMPTY_RL);
    }

    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        boolean bl;
        String string = tunerObjectContainer.getTag(64);
        int n2 = Utilities.isEmpty(string) ? 1 : 2;
        boolean bl2 = bl = tunerObjectContainer.getBand() == 4 && !tunerObjectContainer.getAMFMService().hd;
        if (bl || Utilities.isJapan()) {
            n2 = 0;
        }
        this.setInteger(11, n2);
        ArtistAndTitlePair artistAndTitlePair = tunerObjectContainer.getArtistAndTitlePair();
        this.setText(7, artistAndTitlePair.artistString);
        this.setText(8, artistAndTitlePair.titleString);
        this.setInteger(9, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
        HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(tunerObjectContainer.getImage(n));
        hMIResourceLocator.setMinDisplayDuration(5000);
        this.setHMIResourceLocator(10, hMIResourceLocator);
        this.setSLSAvailability(tunerObjectContainer.getSlsImage());
    }

    protected void setSLSAvailability(HMIResourceLocator hMIResourceLocator) {
    }

    public void setStationActive(boolean bl) {
    }

    protected void tmpOverwrite(TunerObjectContainer tunerObjectContainer) {
        String string = tunerObjectContainer.getStationName(true);
        this.setText(0, string);
    }

    protected void resetOverwrite() {
        this.setInteger(2, this.getBand());
    }

    public void setPresetIndex(int n) {
    }

    public boolean adjustLayoutIfNecessary(boolean bl, boolean bl2, int n) {
        return false;
    }
}

