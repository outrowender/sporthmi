/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.dab.DabStation;
import java.util.Comparator;
import org.dsi.ifc.radio.ServiceInfo;

public class ComparatorService
implements Comparator {
    private final LanguageManager langMngr;

    public ComparatorService(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    @Override
    public int compare(Object object, Object object2) {
        ServiceInfo serviceInfo;
        ServiceInfo serviceInfo2;
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        if (object instanceof DabStation) {
            serviceInfo2 = ((DabStation)object).service;
            serviceInfo = ((DabStation)object2).service;
        } else {
            serviceInfo2 = (ServiceInfo)object;
            serviceInfo = (ServiceInfo)object2;
        }
        int n = this.langMngr.getCollator().compare(serviceInfo2.getFullName(), serviceInfo.getFullName());
        if (n == 0) {
            return this.compare(serviceInfo2.getEnsID(), serviceInfo.getEnsID());
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
}

