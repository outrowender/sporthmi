/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.MemoryListHelper;
import de.audi.tuner.app.uni.UnifiedStationExt;

public class UniMemoryRow
extends AbstractMemoryRow {
    private final UnifiedStationExt station;

    public UniMemoryRow(int n, UnifiedStationExt unifiedStationExt, int n2) {
        super(n, 11);
        this.station = new UnifiedStationExt(unifiedStationExt);
        this.station.setAudioStatus(0);
        this.setText(0, this.station.getName(true));
        this.setText(1, "");
        this.setInteger(2, this.getBand());
        this.setInteger(3, this.station.isPsFreezed() ? 1 : 0);
        this.setInteger(4, MemoryListHelper.getRS(11));
        this.setText(5, this.station.isFM() ? this.station.getFmStation().getFrequencyUnit() : "");
        this.setInteger(6, 0);
        ArtistAndTitlePair artistAndTitlePair = this.station.getArtistAndTitlePair();
        this.setText(7, artistAndTitlePair.artistString);
        this.setText(8, artistAndTitlePair.titleString);
        this.setInteger(9, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
        this.setHMIResourceLocator(10, unifiedStationExt.getImage(n2));
    }

    protected UniMemoryRow(UniMemoryRow uniMemoryRow) {
        super(uniMemoryRow);
        this.station = uniMemoryRow.station;
    }

    public TunerObjectContainer getTOContainer() {
        UnifiedStationExt unifiedStationExt = new UnifiedStationExt(this.station);
        unifiedStationExt.shortName = this.getText(0);
        return new TunerObjectContainer(unifiedStationExt);
    }

    public UnifiedStationExt getStation() {
        return this.station;
    }

    public void setPSFreeze(boolean bl, String string) {
        if (bl) {
            this.station.freezePs(string);
            this.setText(0, this.station.getName(true));
        } else {
            this.station.unfreezePs();
        }
        this.setInteger(3, this.station.isPsFreezed() ? 1 : 0);
    }

    public void resetProgramData() {
        super.resetProgramData();
        this.setHMIResourceLocator(10, this.station.getImage(0));
        this.station.resetProgramData();
        this.setInteger(2, this.getBand());
        this.resetOverwrite();
    }

    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        super.setProgramData(tunerObjectContainer, n);
        if (tunerObjectContainer.getReceptionStatus() == 2) {
            this.setInteger(2, 0);
        } else {
            this.setInteger(2, this.getBand());
        }
        this.tmpOverwrite(tunerObjectContainer);
    }

    protected void tmpOverwrite(TunerObjectContainer tunerObjectContainer) {
        super.tmpOverwrite(tunerObjectContainer);
        this.setInteger(3, tunerObjectContainer.getUniStation().isPsFreezed() ? 1 : 0);
    }

    protected void resetOverwrite() {
        super.resetOverwrite();
        this.setText(0, this.station.getName(true));
        this.setInteger(3, this.station.isPsFreezed() ? 1 : 0);
    }

    public EvoListRow copy() {
        return new UniMemoryRow(this);
    }
}

