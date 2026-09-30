/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.amfm.AMFMStation;
import java.io.Serializable;
import java.util.Comparator;
import org.dsi.ifc.radio.Station;

class SortAlgoAlphabeticallyNAR
implements Comparator,
Serializable {
    private static final long serialVersionUID = 2793054579318091520L;
    private final transient LanguageManager langMngr;

    public SortAlgoAlphabeticallyNAR(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        AMFMStation aMFMStation = (AMFMStation)object;
        AMFMStation aMFMStation2 = (AMFMStation)object2;
        if (this.isFixedNameStation(aMFMStation) && this.isFixedNameStation(aMFMStation2)) {
            int n = this.langMngr.getCollator().compare(this.getStationName(aMFMStation), this.getStationName(aMFMStation2));
            if (n != 0) {
                return n;
            }
            int n2 = aMFMStation.getPi() - aMFMStation2.getPi();
            if (n2 != 0) {
                return n2;
            }
            int n3 = aMFMStation.getServiceId() - aMFMStation2.getServiceId();
            if (n3 != 0) {
                return n3;
            }
        }
        if (this.isScrollingStation(aMFMStation) && this.isScrollingStation(aMFMStation2)) {
            return aMFMStation.pi - aMFMStation2.pi;
        }
        if (this.isScrollingStation(aMFMStation) && this.isFixedNameStation(aMFMStation2)) {
            return 1;
        }
        if (this.isScrollingStation(aMFMStation2) && this.isFixedNameStation(aMFMStation)) {
            return -1;
        }
        return (int)(aMFMStation.frequency - aMFMStation2.frequency);
    }

    private boolean isFixedNameStation(AMFMStation aMFMStation) {
        return aMFMStation.isHd() || aMFMStation.isRds() && !aMFMStation.isScroller();
    }

    private boolean isScrollingStation(AMFMStation aMFMStation) {
        return !aMFMStation.isHd() && aMFMStation.isScroller();
    }

    private String getStationName(Station station) {
        if (station.isHd()) {
            return station.getShortNameHD();
        }
        return station.getName();
    }
}

