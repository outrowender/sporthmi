/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.tv.TVStation;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.UnifiedStation;

public class RadioComparators {
    public static boolean equals(TunerObjectContainer tunerObjectContainer, TunerObjectContainer tunerObjectContainer2) {
        if (tunerObjectContainer == null || tunerObjectContainer2 == null) {
            return false;
        }
        if (tunerObjectContainer.getType() == tunerObjectContainer2.getType()) {
            switch (tunerObjectContainer.getType()) {
                case 3: {
                    AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
                    AMFMStation aMFMStation2 = tunerObjectContainer2.getAMFMService();
                    return RadioComparators.equals(aMFMStation, aMFMStation2);
                }
                case 5: {
                    StationInfoExt stationInfoExt = tunerObjectContainer.getSDARSService();
                    StationInfoExt stationInfoExt2 = tunerObjectContainer2.getSDARSService();
                    if (stationInfoExt.sID != stationInfoExt2.sID) break;
                    return true;
                }
                case 6: {
                    DabStation dabStation = tunerObjectContainer.getDABStation();
                    DabStation dabStation2 = tunerObjectContainer2.getDABStation();
                    return RadioComparators.equals(dabStation, dabStation2);
                }
                case 7: {
                    UnifiedStationExt unifiedStationExt = tunerObjectContainer.getUniStation();
                    UnifiedStationExt unifiedStationExt2 = tunerObjectContainer2.getUniStation();
                    return RadioComparators.equals(unifiedStationExt, unifiedStationExt2);
                }
                case 8: {
                    TVStation tVStation = tunerObjectContainer.getTVStation();
                    TVStation tVStation2 = tunerObjectContainer2.getTVStation();
                    return RadioComparators.equals(tVStation, tVStation2);
                }
            }
        }
        return false;
    }

    public static boolean equals(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        if (aMFMStation == null || aMFMStation2 == null) {
            return false;
        }
        if (aMFMStation.rds && aMFMStation2.rds && Utilities.isSinglePiMode()) {
            return aMFMStation.pi > 0 && aMFMStation2.pi > 0 && aMFMStation.pi == aMFMStation2.pi || aMFMStation.pi == 0 && aMFMStation2.pi == 0 && aMFMStation.frequency == aMFMStation2.frequency;
        }
        if (Utilities.isPiIgnore() && aMFMStation.frequency == aMFMStation2.frequency && RadioComparators.compareServiceId(aMFMStation, aMFMStation2)) {
            return true;
        }
        return !aMFMStation.rds && !aMFMStation2.rds && aMFMStation.frequency == aMFMStation2.frequency && RadioComparators.compareServiceId(aMFMStation, aMFMStation2);
    }

    private static boolean compareServiceId(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        int n = aMFMStation.serviceId == 0 ? 1 : aMFMStation.serviceId;
        int n2 = aMFMStation2.serviceId == 0 ? 1 : aMFMStation2.serviceId;
        return n == n2;
    }

    static boolean checkRegionalisation(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        int n = aMFMStation.pi & 0xF0FF;
        int n2 = aMFMStation2.pi & 0xF0FF;
        return n == n2 && aMFMStation.frequency == aMFMStation2.frequency;
    }

    public static boolean equals(DabStation dabStation, DabStation dabStation2) {
        if (dabStation == null || dabStation2 == null) {
            return false;
        }
        return RadioComparators.equals(dabStation.ensemble, dabStation2.ensemble) && RadioComparators.equals(dabStation.service, dabStation2.service) && RadioComparators.equals(dabStation.component, dabStation2.component);
    }

    public static boolean equals(EnsembleInfo ensembleInfo, EnsembleInfo ensembleInfo2) {
        return ensembleInfo.ensID == ensembleInfo2.ensID && ensembleInfo.ensECC == ensembleInfo2.ensECC;
    }

    public static boolean equals(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (serviceInfo == null || serviceInfo2 == null) {
            return false;
        }
        return serviceInfo.sID == serviceInfo2.sID && serviceInfo.ensID == serviceInfo2.ensID && serviceInfo.ensECC == serviceInfo2.ensECC;
    }

    public static boolean equals(ComponentInfo componentInfo, ComponentInfo componentInfo2) {
        if (componentInfo == null || componentInfo2 == null) {
            return false;
        }
        return componentInfo.sID == componentInfo2.sID && componentInfo.sCIDI == componentInfo2.sCIDI && componentInfo.ensID == componentInfo2.ensID && componentInfo.ensECC == componentInfo2.ensECC;
    }

    public static boolean equalsNoEnsemble(DabStation dabStation, DabStation dabStation2) {
        if (dabStation == null || dabStation2 == null) {
            return false;
        }
        return RadioComparators.equalsNoEnsemble(dabStation.service, dabStation2.service) && RadioComparators.equalsNoEnsemble(dabStation.component, dabStation2.component);
    }

    private static boolean equalsNoEnsemble(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (serviceInfo == null || serviceInfo2 == null) {
            return false;
        }
        return serviceInfo.sID == serviceInfo2.sID;
    }

    private static boolean equalsNoEnsemble(ComponentInfo componentInfo, ComponentInfo componentInfo2) {
        if (componentInfo == null || componentInfo2 == null) {
            return false;
        }
        return componentInfo.sID == componentInfo2.sID && componentInfo.sCIDI == componentInfo2.sCIDI;
    }

    public static boolean equals(StationInfoExt stationInfoExt, StationInfoExt stationInfoExt2) {
        if (stationInfoExt == null || stationInfoExt2 == null) {
            return false;
        }
        return stationInfoExt.sID == stationInfoExt2.sID;
    }

    public static boolean equalsAll(StationInfoExt stationInfoExt, StationInfoExt stationInfoExt2) {
        if (stationInfoExt == null || stationInfoExt2 == null) {
            return false;
        }
        return stationInfoExt.sID == stationInfoExt2.sID && stationInfoExt.stationNumber == stationInfoExt2.stationNumber && stationInfoExt.subscription == stationInfoExt2.subscription && stationInfoExt.categoryNumber == stationInfoExt2.categoryNumber && stationInfoExt.fullLabel.equals(stationInfoExt2.fullLabel) && stationInfoExt.shortLabel.equals(stationInfoExt2.shortLabel) && RadioComparators.equals(stationInfoExt.getStationArt(), stationInfoExt2.getStationArt());
    }

    private static boolean equals(HMIResourceLocator hMIResourceLocator, HMIResourceLocator hMIResourceLocator2) {
        if (hMIResourceLocator == null && hMIResourceLocator2 == null) {
            return true;
        }
        if (hMIResourceLocator == null || hMIResourceLocator2 == null) {
            return false;
        }
        if (hMIResourceLocator.containsResourceURI() && hMIResourceLocator2.containsResourceURI()) {
            return hMIResourceLocator.getResourceURI().equals(hMIResourceLocator2.getResourceURI());
        }
        return !hMIResourceLocator.containsResourceURI() && !hMIResourceLocator2.containsResourceURI();
    }

    public static boolean equals(UnifiedStation unifiedStation, UnifiedStation unifiedStation2) {
        if (unifiedStation == null || unifiedStation2 == null) {
            return false;
        }
        if ((unifiedStation.rds && unifiedStation.piSId != 0 || unifiedStation.ensId != 0) && (unifiedStation2.rds && unifiedStation2.piSId != 0 || unifiedStation2.ensId != 0)) {
            return unifiedStation.piSId == unifiedStation2.piSId && unifiedStation.sCIDI == unifiedStation2.sCIDI;
        }
        if (unifiedStation.rds != unifiedStation2.rds) {
            return false;
        }
        return unifiedStation.frequency == unifiedStation2.frequency;
    }

    private static boolean equals(TVStation tVStation, TVStation tVStation2) {
        if (tVStation == null || tVStation2 == null) {
            return false;
        }
        return tVStation.namePID == tVStation2.namePID && tVStation.sType == tVStation2.sType;
    }
}

