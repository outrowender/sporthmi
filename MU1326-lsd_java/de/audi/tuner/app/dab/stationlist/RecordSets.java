/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.AbstractDABListHandler;

public class RecordSets {
    public static final int RS_UNUSED;
    static final int RS_ENSEMBLE_CLOSED;
    static final int RS_ENSEMBLE_OPEN;
    private static final int RS_SERVICE_FLAT;
    private static final int RS_SERVICE;
    private static final int RS_COMPONENT;
    private static final int RS_COMPONENT_FLAT;
    private int sortMode;
    private final AbstractDABListHandler listHandler;

    public RecordSets(AbstractDABListHandler abstractDABListHandler, int n) {
        this.listHandler = abstractDABListHandler;
        this.sortMode = n;
    }

    int getReceptionStatus(DabStation dabStation, int n, int n2) {
        DabStation dabStation2 = this.listHandler.getCurrentStation();
        switch (dabStation.getType()) {
            case 1: {
                if (this.isEnsembleActive(dabStation2, dabStation)) {
                    if (n2 == 2) {
                        return 1;
                    }
                    if (n != 4) {
                        return 2;
                    }
                }
                return 0;
            }
            case 2: {
                if (!this.isEnsembleActive(dabStation2, dabStation)) {
                    return 0;
                }
                if (this.isServiceActive(dabStation2, dabStation)) {
                    if (n2 == 2) {
                        return 1;
                    }
                    if (n != 4) {
                        return 2;
                    }
                } else if (n == 2 || n == 1) {
                    return 2;
                }
                return 0;
            }
            case 3: {
                if (!this.isEnsembleActive(dabStation2, dabStation) || n == 4) {
                    return 0;
                }
                boolean bl = this.isServiceActive(dabStation2, dabStation);
                switch (n) {
                    case 1: 
                    case 2: {
                        return 2;
                    }
                    case 3: {
                        return bl ? 2 : 0;
                    }
                }
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean isEnsembleActive(DabStation dabStation, DabStation dabStation2) {
        return dabStation.ensemble.ensID == dabStation2.ensemble.ensID && dabStation.ensemble.ensECC == dabStation2.ensemble.ensECC;
    }

    public boolean isServiceActive(DabStation dabStation, DabStation dabStation2) {
        return this.isEnsembleActive(dabStation, dabStation2) && dabStation2.service.sID == dabStation.service.sID && dabStation2.component.sCIDI == dabStation.component.sCIDI;
    }

    public int getServiceRS() {
        if (this.sortMode == 0) {
            return 2;
        }
        return 3;
    }

    public int getComponentRS() {
        if (this.sortMode == 0) {
            if (Utilities.isPGen1OrBentley()) {
                return 4;
            }
            return 5;
        }
        return 4;
    }
}

