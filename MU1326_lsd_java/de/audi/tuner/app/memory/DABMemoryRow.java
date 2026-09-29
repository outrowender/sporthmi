/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DABMemoryRow
extends AbstractMemoryRow {
    protected DabStation station;

    public DABMemoryRow(int n, TunerObjectContainer tunerObjectContainer, int n2) {
        super(n, 5);
        this.station = new DabStation(tunerObjectContainer.getDABStation());
        tunerObjectContainer.setReceptionStatus(0);
        this.setText(1, "");
        this.setInteger(2, this.getBand());
        this.setInteger(3, 0);
        this.setInteger(4, 0);
        this.setText(5, "");
        this.setInteger(6, 0);
        ArtistAndTitlePair artistAndTitlePair = this.station.getArtistAndTitlePair();
        this.setText(7, artistAndTitlePair.artistString);
        this.setText(8, artistAndTitlePair.titleString);
        this.setInteger(9, Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString));
        this.setHMIResourceLocator(10, this.station.getImage(n2));
    }

    protected DABMemoryRow(DABMemoryRow dABMemoryRow) {
        super(dABMemoryRow);
        this.station = dABMemoryRow.station;
    }

    public String getStationName() {
        return this.station.getFullName();
    }

    public String getStationNameShort() {
        return this.station.getShortName();
    }

    public String getEnsName() {
        return this.station.ensemble.getFullName();
    }

    public int getEnsFrequency() {
        return this.station.ensemble.getFrequencyValue();
    }

    public ServiceInfo getService() {
        return this.station.service;
    }

    @Override
    public TunerObjectContainer getTOContainer() {
        return new TunerObjectContainer(new DabStation(this.station));
    }

    public EnsembleInfo getEnsemble() {
        return this.station.ensemble;
    }

    public void performNameChange(TunerObjectContainer tunerObjectContainer) {
        this.station = tunerObjectContainer.getDABStation();
        this.setText(0, this.station.getFullName());
    }

    @Override
    public void resetProgramData() {
        super.resetProgramData();
        this.setHMIResourceLocator(10, this.station.getImage(0));
        this.station.resetProgramData();
        this.setInteger(2, this.getBand());
        this.resetOverwrite();
    }

    @Override
    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        super.setProgramData(tunerObjectContainer, n);
        this.tmpOverwrite(tunerObjectContainer);
    }

    @Override
    public EvoListRow copy() {
        return new DABMemoryRow(this);
    }
}

