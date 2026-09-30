/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import java.io.Serializable;
import java.util.Comparator;
import org.dsi.ifc.radio.DataServiceInfo;

public class ComparatorDataService
implements Comparator,
Serializable {
    private static final long serialVersionUID = 3289363369511483051L;

    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        DataServiceInfo dataServiceInfo = (DataServiceInfo)object;
        DataServiceInfo dataServiceInfo2 = (DataServiceInfo)object2;
        int n = this.compare(dataServiceInfo.ensID, dataServiceInfo2.ensID);
        if (n != 0) {
            return n;
        }
        n = this.compare(dataServiceInfo.ensECC, dataServiceInfo2.ensECC);
        if (n != 0) {
            return n;
        }
        n = this.compare(dataServiceInfo.sID, dataServiceInfo2.sID);
        if (n == 0) {
            n = this.compare(dataServiceInfo.sCIDI, dataServiceInfo2.sCIDI);
        }
        return n;
    }

    private int compare(int n, int n2) {
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }

    private int compare(long l, long l2) {
        if (l < l2) {
            return -1;
        }
        if (l > l2) {
            return 1;
        }
        return 0;
    }
}

