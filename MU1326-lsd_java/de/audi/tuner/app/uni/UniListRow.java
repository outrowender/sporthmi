/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.esolutions.fw.util.commons.Buffer;

public class UniListRow
extends AbstractRadioListRow {
    private static final int INDEX_NAME;
    private static final int INDEX_AUDIO_STATUS;
    private static final int INDEX_ARTIST;
    private static final int INDEX_TITLE;
    private static final int INDEX_IMAGE;
    private static final int INDEX_PTY;
    private static final int INDEX_DASH;
    private static final int INDEX_SEPARATOR;
    private static final int INDEX_PSFREEZE_STATUS;
    protected static final int INDEX_PROPERTIES;
    private static final int INDEX_RADIOTEXT_ICON;
    private static final int INDEX_SLIDESHOW_ICON;
    private static final int INDEX_DEFAULT_IMAGE_ID;
    private static final int INDEX_INDENTEND;
    public static final int NUM_OF_COLS;
    private final UnifiedStationExt station;
    private boolean tmpStation;

    public UniListRow(int n, UnifiedStationExt unifiedStationExt, boolean bl, int n2) {
        super(unifiedStationExt.getUniqueId(), n);
        this.setText(0, unifiedStationExt.getName(true));
        this.setInteger(1, unifiedStationExt.getAudioStatus());
        this.setArtistAndTitle(unifiedStationExt);
        this.setHMIResourceLocator(4, unifiedStationExt.getImage(n2));
        this.setInteger(5, Utilities.getDABPty(unifiedStationExt.getPtyCodes()));
        this.setInteger(7, 0);
        this.setInteger(8, unifiedStationExt.isPsFreezed() ? 1 : 0);
        this.setInteger(11, unifiedStationExt.getSlsImage().containsResourceURI() ? 2 : 1);
        this.setInteger(10, unifiedStationExt.getTag(64).length() > 0 ? 2 : 1);
        this.setInteger(12, 11);
        this.setInteger(13, unifiedStationExt.sCIDI == 0 ? 0 : 1);
        this.station = unifiedStationExt;
        this.tmpStation = bl;
    }

    protected UniListRow(UniListRow uniListRow) {
        super(uniListRow);
        this.station = uniListRow.station;
    }

    public UnifiedStationExt getStation() {
        return this.station;
    }

    public boolean isTmpAdded() {
        return this.tmpStation;
    }

    @Override
    public TunerObjectContainer getTOContainer() {
        return new TunerObjectContainer(new UnifiedStationExt(this.station));
    }

    public void reset() {
        this.setText(2, "");
        this.setText(3, "");
        this.setInteger(6, 0);
        if (this.station.ensId == 0) {
            this.setInteger(1, 1);
        } else {
            this.setInteger(1, 2);
        }
        this.setHMIResourceLocator(4, new HMIResourceLocator(HMIResourceLocator.UNDEFINED_URI));
        this.setInteger(11, 1);
        this.setInteger(10, 1);
    }

    public void setStationActive(boolean bl) {
    }

    void setProgramData(UnifiedStationExt unifiedStationExt, int n) {
        this.setHMIResourceLocator(4, unifiedStationExt.getImage(n));
        this.setSLSAvailability(unifiedStationExt.getSlsImage());
        this.setInteger(10, unifiedStationExt.getTag(64).length() > 0 ? 2 : 1);
        this.setArtistAndTitle(unifiedStationExt);
        this.setInteger(1, unifiedStationExt.getAudioStatus());
        this.station.ptyCodes = unifiedStationExt.ptyCodes;
        this.setInteger(5, unifiedStationExt.getPty());
    }

    private void setArtistAndTitle(UnifiedStationExt unifiedStationExt) {
        ArtistAndTitlePair artistAndTitlePair = unifiedStationExt.getArtistAndTitlePair();
        this.setText(2, artistAndTitlePair.artistString);
        this.setText(3, artistAndTitlePair.titleString);
        this.setInteger(6, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
    }

    protected void setSLSAvailability(HMIResourceLocator hMIResourceLocator) {
        this.setInteger(11, hMIResourceLocator.containsResourceURI() ? 2 : 1);
    }

    public void setSeparatorLine(boolean bl) {
        int n = bl ? 2 : 1;
        int n2 = this.getInteger(7);
        if (n2 == 2 && n == 1 || n2 == 1 && n == 2) {
            this.setInteger(7, 3);
        } else {
            this.setInteger(7, n);
        }
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append(this.station).append(' ');
        buffer.append(super.toString());
        return buffer.toString();
    }

    public int getSeparatorLine() {
        return this.getInteger(7);
    }

    public void setSeparatorLine(int n) {
        this.setInteger(7, n);
    }
}

