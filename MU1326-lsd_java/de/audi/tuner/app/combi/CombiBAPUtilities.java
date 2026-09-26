/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;

class CombiBAPUtilities {
    CombiBAPUtilities() {
    }

    static int getBAPSourceType(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 7: {
                return 5;
            }
            case 10: {
                return 17;
            }
            case 11: {
                return 36;
            }
        }
        return 0;
    }

    static int getBAPWaveband(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 7;
            }
            case 7: {
                return 5;
            }
            case 15: {
                return 9;
            }
        }
        return 0;
    }

    static int getTunerSourceType(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 4;
            }
            case 17: {
                return 10;
            }
            case 3: {
                return 5;
            }
            case 36: {
                return 11;
            }
            case 5: {
                return 7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("ConbiBAPUtilities.getTunerSourceType() ").append(n).toString());
    }

    static int getBAPReceptionListType(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 4: 
            case 10: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 7: {
                return 4;
            }
            case 11: {
                return 10;
            }
        }
        return 0;
    }

    static int getBAPAnnouncementType(int n) {
        switch (n) {
            case 20: {
                return 0;
            }
            case 1: 
            case 3: 
            case 5: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 4: {
                return 11;
            }
            case 9: {
                return 5;
            }
            case 10: {
                return 6;
            }
            case 14: {
                return 10;
            }
            case 8: {
                return 4;
            }
            case 12: {
                return 8;
            }
            case 11: {
                return 7;
            }
            case 13: {
                return 9;
            }
            case 6: {
                return 3;
            }
            case 7: {
                return 13;
            }
        }
        return 0;
    }

    static boolean isStationListUpdateRunning(int n, int n2) {
        return (n2 == 4 || n2 == 1) && n == 1 || n2 == 5 && n == 1;
    }

    static boolean isStationListUpdateAborted(int n, int n2) {
        return (n2 == 4 || n2 == 1) && n == 3 || n2 == 5 && n == 3;
    }

    static boolean isStationListUpdateDone(int n, int n2) {
        return (n2 == 4 || n2 == 1) && n == 2 || n2 == 5 && n == 2;
    }

    static int getTunerSeekMode(int n) {
        return n == 0 ? 1 : 2;
    }

    static int getBAPAbortAnnouncementStatus(boolean bl) {
        return bl ? 0 : 4;
    }

    static int getBAPSwitchSourceResult(boolean bl) {
        return bl ? 0 : 1;
    }

    static int getBAPStationAttributes(TunerObjectContainer tunerObjectContainer) {
        int n = 0;
        switch (tunerObjectContainer.getType()) {
            case 3: {
                n = CombiBAPUtilities.handleAMFMService(tunerObjectContainer, n);
                break;
            }
            case 6: {
                n = CombiBAPUtilities.handleDABService(tunerObjectContainer, n);
                break;
            }
            case 7: {
                if (tunerObjectContainer.getReceptionStatus() == 2) break;
                n |= 1;
                break;
            }
        }
        return n;
    }

    private static int handleDABService(TunerObjectContainer tunerObjectContainer, int n) {
        DabStation dabStation = tunerObjectContainer.getDABStation();
        switch (dabStation.getType()) {
            case 1: {
                if (dabStation.ensemble.isTp()) {
                    n |= 0x20;
                }
                if (tunerObjectContainer.getReceptionStatus() == 2) break;
                n |= 1;
                break;
            }
            case 2: {
                if (dabStation.service.isTp()) {
                    n |= 0x20;
                }
                if (tunerObjectContainer.getReceptionStatus() == 1) {
                    n |= 0x10;
                }
                if (tunerObjectContainer.getReceptionStatus() == 2) break;
                n |= 1;
                break;
            }
            case 3: {
                if (tunerObjectContainer.getReceptionStatus() == 2) break;
                n |= 1;
                break;
            }
        }
        return n;
    }

    private static int handleAMFMService(TunerObjectContainer tunerObjectContainer, int n) {
        AMFMStation aMFMStation;
        if (tunerObjectContainer.getAMFMService().isTp()) {
            n |= 0x20;
        }
        if (tunerObjectContainer.getAMFMService().isTmc()) {
            n |= 0x40;
        }
        if ((aMFMStation = tunerObjectContainer.getAMFMService()).isHd()) {
            if (aMFMStation.serviceId < 2 && aMFMStation.getAudioStatus() == 2) {
                n |= 1;
            } else if (aMFMStation.serviceId > 1 && aMFMStation.getAudioStatus() != 3) {
                n |= 1;
            }
        }
        return n;
    }

    static int getBAPPrestListAttributes(TunerObjectContainer tunerObjectContainer) {
        int n = 0;
        block0 : switch (tunerObjectContainer.getType()) {
            case 3: {
                AMFMStation aMFMStation;
                if (tunerObjectContainer.getAMFMService().isTp()) {
                    n |= 0x20;
                }
                if (tunerObjectContainer.getAMFMService().isTmc()) {
                    n |= 0x40;
                }
                if (!(aMFMStation = tunerObjectContainer.getAMFMService()).isHd()) break;
                n |= 1;
                break;
            }
            case 6: {
                DabStation dabStation = tunerObjectContainer.getDABStation();
                switch (dabStation.getType()) {
                    case 1: {
                        if (!dabStation.ensemble.isTp()) break block0;
                        n |= 0x20;
                        break block0;
                    }
                    case 2: {
                        if (!dabStation.service.isTp()) break block0;
                        n |= 0x20;
                        break block0;
                    }
                    case 3: {
                        n |= 2;
                        break block0;
                    }
                }
                break;
            }
            case 7: {
                break;
            }
            case 5: {
                if (tunerObjectContainer.getSDARSService().subscription != 2) break;
                n |= 0x80;
                break;
            }
        }
        return n;
    }

    static int getBAPInfoStateSDARS(int n) {
        switch (n) {
            case 3: {
                return 14;
            }
            case 4: {
                return 55;
            }
            case 5: 
            case 6: {
                return 56;
            }
        }
        return 0;
    }
}

