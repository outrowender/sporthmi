/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.IContainsDabStation;
import de.audi.tuner.app.dab.stationlist.RecordSets;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabListRow
extends AbstractRadioListRow
implements IContainsDabStation {
    public static final int NUM_OF_COLS = 9;
    private static final int INDEX_SERVICE_NAME = 0;
    public static final int INDEX_ENSEMBLE_NAME = 1;
    private static final int INDEX_PTY = 2;
    private static final int INDEX_RECEPTION = 3;
    private static final int INDEX_RECORD_SET = 4;
    private static final int INDEX_DISPLAYED_IMAGE = 5;
    public static final int INDEX_IS_FAVORITE = 6;
    private static final String CLOSED_ENSEMBLE_SEPARATOR = ": ";
    private final RecordSets recordSets;
    protected final DabStation station;
    private int reception = 0;
    private boolean tmpStation;
    private int activeImgType;

    public DabListRow(int n, RecordSets recordSets, DabStation dabStation, boolean bl, int n2) {
        super(dabStation.getUniqueId(), n);
        this.station = dabStation;
        this.recordSets = recordSets;
        this.tmpStation = bl;
        this.activeImgType = n2;
        this.setInteger(6, dabStation.getPresetPos() == 0 ? 0 : 1);
        this.setHMIResourceLocator(5, dabStation.getImage(n2));
        this.setInteger(3, 0);
        String string = dabStation.isEnsemble() ? "" : dabStation.getFullName();
        this.setText(0, string);
        this.setText(1, dabStation.ensemble.fullName);
        this.setInteger(2, dabStation.getPTY());
        switch (dabStation.getType()) {
            case 1: {
                this.setInteger(4, -1);
                break;
            }
            case 2: {
                this.setInteger(4, recordSets.getServiceRS());
                break;
            }
            case 3: {
                this.setInteger(4, recordSets.getComponentRS());
                break;
            }
        }
    }

    public DabListRow(DabListRow dabListRow) {
        super(dabListRow);
        this.recordSets = dabListRow.recordSets;
        this.station = dabListRow.station;
    }

    public EvoListRow copy() {
        return new DabListRow(this);
    }

    public void setServiceForEnsemble(DabStation dabStation) {
        if (this.station.isEnsemble()) {
            this.setText(0, dabStation.getFullName());
            this.setText(1, this.getEnsembleName(dabStation.getFullName()));
        }
    }

    protected String getEnsembleName(String string) {
        String string2;
        if (this.isClosed()) {
            Buffer buffer = new Buffer(this.station.ensemble.getShortName());
            buffer.append(CLOSED_ENSEMBLE_SEPARATOR);
            buffer.append(string);
            string2 = buffer.toString();
        } else {
            string2 = this.station.ensemble.getFullName();
        }
        return string2;
    }

    public boolean isClosed() {
        return this.getInteger(4) == 0;
    }

    void setReceptionStatus(int n, int n2) {
        if (this.isEnsemble()) {
            this.reception = this.recordSets.getReceptionStatus(this.station, n, n2);
            if (this.isClosed()) {
                this.setInteger(3, this.reception);
            }
        } else {
            this.reception = this.recordSets.getReceptionStatus(this.station, n, n2);
            this.setInteger(3, this.reception);
            if (this.reception == 0) {
                this.setInteger(2, this.station.getPTY());
            } else {
                this.setInteger(2, 0);
            }
        }
    }

    public boolean isTmpAdded() {
        return this.tmpStation;
    }

    public TunerObjectContainer getTOContainer() {
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(new DabStation(this.station));
        tunerObjectContainer.setReceptionStatus(this.getInteger(3));
        return tunerObjectContainer;
    }

    public DabStation getDabStation() {
        return this.station;
    }

    public void setStationActive(boolean bl) {
        if (!bl) {
            this.resetProgramData();
        }
    }

    public EnsembleInfo getEnsemble() {
        return this.station.ensemble;
    }

    public ServiceInfo getService() {
        return this.station.service;
    }

    public ComponentInfo getComponent() {
        return this.station.component;
    }

    public boolean isEnsemble() {
        return this.station.isEnsemble();
    }

    public boolean isService() {
        return this.station.isService();
    }

    public boolean isComponent() {
        return this.station.isComponent();
    }

    public DabListRow open(DabStation dabStation) {
        if (this.isEnsemble()) {
            this.setInteger(4, 1);
            this.setInteger(3, 0);
            this.setText(1, this.station.getFullName());
            this.setHMIResourceLocator(5, this.station.getStationLogo());
            return this;
        }
        throw new IllegalArgumentException();
    }

    public DabListRow close(DabStation dabStation) {
        if (this.isEnsemble()) {
            this.setInteger(4, 0);
            this.setInteger(3, this.reception);
            if (this.isActive(dabStation)) {
                this.setServiceForEnsemble(dabStation);
                if (!Utilities.isPGen1OrBentley()) {
                    this.setHMIResourceLocator(5, dabStation.getImage(this.activeImgType));
                }
            }
            return this;
        }
        throw new IllegalArgumentException();
    }

    public boolean isActive(DabStation dabStation) {
        if (this.station.isEnsemble()) {
            return RadioComparators.equals(this.station.ensemble, dabStation.ensemble);
        }
        return RadioComparators.equals(this.station, dabStation);
    }

    public void setProgramData(DabStation dabStation, int n) {
        this.activeImgType = n;
        this.setHMIResourceLocator(5, dabStation.getImage(n));
        this.setSLSAvailability(dabStation.getSlsImage());
        this.station.service.ptyCodes = dabStation.service.ptyCodes;
        if (this.reception == 0) {
            this.setInteger(2, dabStation.getPTY());
        }
        if (this.station.isEnsemble()) {
            this.setText(0, dabStation.getFullName());
            this.setText(1, this.getEnsembleName(dabStation.getFullName()));
        } else if (this.station.isService()) {
            this.setText(0, dabStation.getFullName());
        }
    }

    public void resetProgramData() {
        if (this.station.isEnsemble()) {
            this.setText(0, "");
        }
        this.setHMIResourceLocator(5, this.station.getStationLogo());
    }

    public void resetReception() {
        this.setInteger(3, 0);
        this.setInteger(2, this.station.getPTY());
    }

    protected void setSLSAvailability(HMIResourceLocator hMIResourceLocator) {
    }
}

