/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.Utilities;
import java.io.Serializable;
import java.util.Comparator;
import org.dsi.ifc.radio.Station;

class SortAlgoPiAscending
implements Comparator,
Serializable {
    private static final long serialVersionUID;

    SortAlgoPiAscending() {
    }

    @Override
    public int compare(Object object, Object object2) {
        Station station = (Station)object;
        Station station2 = (Station)object2;
        if (station.rds && station2.rds) {
            return Utilities.convertPi(station.pi) - Utilities.convertPi(station2.pi);
        }
        if (station.rds) {
            return -1;
        }
        if (station2.rds) {
            return 1;
        }
        return (int)(station.frequency - station2.frequency);
    }
}

