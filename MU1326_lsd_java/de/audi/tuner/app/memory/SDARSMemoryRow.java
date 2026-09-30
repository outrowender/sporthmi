/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.MemoryListHelper;
import de.audi.tuner.app.sdars.ISDARSRow;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;
import de.esolutions.fw.util.commons.Buffer;

public class SDARSMemoryRow
extends AbstractMemoryRow
implements ISDARSRow {
    protected StationInfoExt station;
    private boolean isInvalid;
    private SdarsRadioText pdt = null;
    private boolean stationIsActive;

    public SDARSMemoryRow(int n, StationInfoExt stationInfoExt) {
        super(n, 7);
        this.station = stationInfoExt;
        this.setText(0, stationInfoExt.getFullLabel());
        this.setText(1, Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
        this.setText(13, stationInfoExt.getFullCategory());
        this.setInteger(2, this.getBand());
        this.setInteger(3, 0);
        this.setInteger(4, stationInfoExt.subscription == 2 ? MemoryListHelper.getRS(7) : 8);
        this.setText(5, "");
        this.setInteger(6, 0);
        this.setText(7, "");
        this.setText(8, "");
        this.setInteger(9, 0);
        if (Utilities.isPGen1OrBentley()) {
            if (stationInfoExt.getStationArt().containsResourceURI()) {
                this.setInteger(4, 2);
            } else {
                this.setInteger(4, 0);
            }
        }
        this.setHMIResourceLocator(10, stationInfoExt.getStationArt());
    }

    protected SDARSMemoryRow(SDARSMemoryRow sDARSMemoryRow) {
        super(sDARSMemoryRow);
        this.station = sDARSMemoryRow.station;
        this.isInvalid = sDARSMemoryRow.isInvalid;
        this.stationIsActive = sDARSMemoryRow.stationIsActive;
    }

    public String getStationName() {
        return this.station.getFullLabel();
    }

    public String getStationNameShort() {
        return this.station.getShortLabel();
    }

    public StationInfoExt getStation() {
        return this.station;
    }

    public String toString() {
        Buffer buffer = new Buffer(1000);
        buffer.append("{SDARS} ");
        buffer.append(this.station).append(' ').append(super.toString());
        return buffer.toString();
    }

    public TunerObjectContainer getTOContainer() {
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(this.station);
        tunerObjectContainer.setEnabled(this.getState() == 0);
        return tunerObjectContainer;
    }

    public boolean synchronize(StationInfoExt stationInfoExt) {
        if (stationInfoExt == null) {
            if (this.isInvalid) {
                return false;
            }
            this.isInvalid = true;
            this.station.subscription = 1;
            this.setInteger(4, 8);
            return true;
        }
        if (!RadioComparators.equalsAll(this.station, stationInfoExt)) {
            this.station = new StationInfoExt(stationInfoExt);
            this.setText(0, this.station.getFullLabel());
            this.setText(1, Utilities.getFormatedStationNumber(this.station.stationNumber));
            this.setInteger(4, this.station.subscription == 2 ? MemoryListHelper.getRS(7) : 8);
            return true;
        }
        if (this.isInvalid) {
            this.setInteger(4, this.station.subscription == 2 ? MemoryListHelper.getRS(7) : 8);
            this.isInvalid = false;
            return true;
        }
        return false;
    }

    protected int getStationState() {
        if (this.isInvalid) {
            return 12;
        }
        if (this.station.subscription != 2) {
            return 11;
        }
        return super.getStationState();
    }

    protected void setLineColor() {
        this.setInteger(4, this.getState() == 0 ? MemoryListHelper.getRS(7) : 8);
    }

    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        StationInfoExt stationInfoExt = tunerObjectContainer.getSDARSService();
        if (stationInfoExt.isAudioOk()) {
            this.setText(13, stationInfoExt.getFullCategory());
        } else {
            this.setText(13, "NoSignal");
        }
        this.tmpOverwrite(tunerObjectContainer);
    }

    public void setStationActive(boolean bl) {
        this.stationIsActive = bl;
    }

    public void resetProgramData() {
        boolean bl;
        super.resetProgramData();
        this.setHMIResourceLocator(10, this.station.getStationArt());
        this.setInteger(2, this.getBand());
        boolean bl2 = bl = this.getText(13) == "NoSignal";
        if (!bl) {
            this.setText(13, this.station.getFullCategory());
        }
        this.resetOverwrite();
    }

    public void setProgramData(SdarsRadioText sdarsRadioText, int n) {
        this.pdt = sdarsRadioText;
        this.setText(7, sdarsRadioText.shortArtistName);
        this.setText(8, sdarsRadioText.shortProgramTitle);
        this.setInteger(9, 2);
        HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(Utilities.getPreferredImage(n, null, sdarsRadioText.getCoverArt(), this.station.getStationArt()));
        if (this.stationIsActive) {
            hMIResourceLocator.setMinDisplayDuration(5000);
        }
        this.setHMIResourceLocator(10, hMIResourceLocator);
    }

    public void setSeekPossibility(AddToSeeksPossibilityEnum addToSeeksPossibilityEnum, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum2, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum3, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum4) {
    }

    public void resetPdt() {
        this.resetProgramData();
        this.pdt = null;
    }

    protected void tmpOverwrite(TunerObjectContainer tunerObjectContainer) {
        String string = tunerObjectContainer.getStationName(true);
        this.setText(0, string);
        this.setText(1, Utilities.getFormatedStationNumber(tunerObjectContainer.getSDARSService().stationNumber));
        this.setInteger(2, tunerObjectContainer.getBand());
        HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(tunerObjectContainer.getImage(0));
        if (this.pdt != null) {
            hMIResourceLocator = new HMIResourceLocator(Utilities.getFirstNotEmpty(this.pdt.getCoverArt(), tunerObjectContainer.getImage(0)));
        }
        this.setHMIResourceLocator(10, hMIResourceLocator);
    }

    protected void resetOverwrite() {
        super.resetOverwrite();
        this.setText(0, this.station.getFullLabel());
        this.setText(1, Utilities.getFormatedStationNumber(this.station.stationNumber));
    }

    public EvoListRow copy() {
        return new SDARSMemoryRow(this);
    }
}

