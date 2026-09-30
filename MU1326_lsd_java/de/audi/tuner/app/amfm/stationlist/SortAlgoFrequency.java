/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import java.io.Serializable;
import java.util.Comparator;

public class SortAlgoFrequency
implements Comparator,
Serializable {
    private static final long serialVersionUID = -4693186874261793027L;

    public int compare(Object object, Object object2) {
        AMFMStation aMFMStation;
        AMFMStation aMFMStation2;
        if (object instanceof AMFMStation) {
            aMFMStation2 = (AMFMStation)object;
            aMFMStation = (AMFMStation)object2;
        } else {
            aMFMStation2 = ((TunerObjectContainer)object).getAMFMService();
            aMFMStation = ((TunerObjectContainer)object2).getAMFMService();
        }
        int n = aMFMStation2.getServiceId();
        int n2 = aMFMStation.getServiceId();
        if (aMFMStation2.frequency < aMFMStation.frequency) {
            return -1;
        }
        if (aMFMStation2.frequency > aMFMStation.frequency) {
            return 1;
        }
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
}

