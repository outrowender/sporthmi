/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.MemoryListHelper;
import de.esolutions.fw.util.commons.Buffer;

public class AmFmMemoryRow
extends AbstractMemoryRow {
    private int hdStatus = 0;
    protected final AMFMStation station;

    public AmFmMemoryRow(int n, AMFMStation aMFMStation) {
        super(n, Utilities.getBandIdByWaveband(aMFMStation.getWaveband()));
        this.station = aMFMStation;
        this.setText(0, this.getAmFmStationName());
        this.setText(1, aMFMStation.getRawFrequencyString());
        this.setInteger(2, this.getBand());
        this.setInteger(3, aMFMStation.isPsFreezed() ? 1 : 0);
        this.setInteger(4, MemoryListHelper.getRS(1));
        this.setText(5, aMFMStation.getFrequencyUnit());
        if (aMFMStation.hd) {
            this.setInteger(6, 1);
        } else {
            this.setInteger(6, 0);
        }
        ArtistAndTitlePair artistAndTitlePair = aMFMStation.getArtistAndTitlePair();
        this.setText(7, artistAndTitlePair.artistString);
        this.setText(8, artistAndTitlePair.titleString);
        this.setInteger(9, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
    }

    protected AmFmMemoryRow(AmFmMemoryRow amFmMemoryRow) {
        super(amFmMemoryRow);
        this.hdStatus = amFmMemoryRow.hdStatus;
        this.station = amFmMemoryRow.station;
    }

    protected final String getAmFmStationName() {
        if (this.station.isHd()) {
            return this.station.getShortNameHD();
        }
        if (!Utilities.isEmpty(this.station.name)) {
            return this.station.getName();
        }
        if (Utilities.isSinglePiMode()) {
            return this.station.getFrequencyString();
        }
        return "";
    }

    private void setHdIcon(AMFMStation aMFMStation) {
        int n = 0;
        if (aMFMStation.hd) {
            switch (aMFMStation.getAudioStatus()) {
                case 3: {
                    n = 3;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    n = 1;
                }
            }
        }
        this.setInteger(6, n);
    }

    @Override
    public boolean isPSFreezed() {
        if (this.getBand() == 4) {
            return false;
        }
        return this.station.isPsFreezed();
    }

    public void setPSFreeze(boolean bl, String string) {
        if (bl) {
            this.station.freezePs(string);
            this.setText(0, this.getAmFmStationName());
        } else {
            this.station.unfreezePs();
        }
        this.setInteger(3, this.station.isPsFreezed() ? 1 : 0);
    }

    public AMFMStation getStation() {
        return this.station;
    }

    @Override
    public TunerObjectContainer getTOContainer() {
        return new TunerObjectContainer(new AMFMStation(this.station));
    }

    public void setHdStatus(int n) {
        this.hdStatus = n;
    }

    @Override
    public ListCell getReceptionCell() {
        if (this.getStation().isHd()) {
            switch (this.hdStatus) {
                case 2: {
                    return IntegerListCell.create(2);
                }
                case 3: {
                    return IntegerListCell.create(3);
                }
            }
            return IntegerListCell.create(1);
        }
        return super.getReceptionCell();
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append("AmFmMemoryRow ").append(this.station).append(' ').append(super.toString());
        return buffer.toString();
    }

    @Override
    public void resetProgramData() {
        super.resetProgramData();
        this.setHMIResourceLocator(10, this.station.getImage(0));
        this.station.resetProgramData();
        this.resetOverwrite();
    }

    @Override
    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        super.setProgramData(tunerObjectContainer, n);
        this.tmpOverwrite(tunerObjectContainer);
        this.setHdIcon(tunerObjectContainer.getAMFMService());
    }

    @Override
    protected void tmpOverwrite(TunerObjectContainer tunerObjectContainer) {
        if (Utilities.isPiIgnore()) {
            AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
            if (aMFMStation.hd) {
                this.setText(0, aMFMStation.getShortNameHD());
            } else {
                this.setText(0, aMFMStation.name);
            }
            this.setInteger(2, tunerObjectContainer.getBand());
        } else {
            super.tmpOverwrite(tunerObjectContainer);
            this.setInteger(3, tunerObjectContainer.getAMFMService().isPsFreezed() ? 1 : 0);
        }
    }

    @Override
    protected void resetOverwrite() {
        super.resetOverwrite();
        this.setText(0, this.getAmFmStationName());
        if (this.station.hd) {
            this.setInteger(6, 1);
        } else {
            this.setInteger(6, 0);
        }
        this.setHdIcon(this.station);
        this.setInteger(3, this.station.isPsFreezed() ? 1 : 0);
    }

    @Override
    public boolean adjustLayoutIfNecessary(boolean bl, boolean bl2, int n) {
        int n2 = MemoryListHelper.getRS(1);
        boolean bl3 = false;
        if (Utilities.isJapan() && !bl) {
            n2 = 5;
        }
        boolean bl4 = bl3 = n2 != this.getInteger(4);
        if (bl3) {
            this.setInteger(4, n2);
        }
        return bl3;
    }

    @Override
    public EvoListRow copy() {
        return new AmFmMemoryRow(this);
    }
}

