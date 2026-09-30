/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.Utilities;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabDummyNames {
    private final SimpleIntObjectMap dummyEnsNames = new SimpleIntObjectMap();
    private final SimpleIntObjectMap dummyServNames = new SimpleIntObjectMap();
    private final SimpleIntObjectMap dummyCompNames = new SimpleIntObjectMap();
    private int dummyEnsNameCounter = 1;
    private int dummyServNameCounter = 1;
    private int dummyCompNameCounter = 1;

    public ComponentInfo getDummyComponentName(int n, int n2) {
        ComponentInfo componentInfo;
        SimpleIntObjectMap simpleIntObjectMap = (SimpleIntObjectMap)this.dummyCompNames.get(n);
        if (simpleIntObjectMap == null) {
            componentInfo = new ComponentInfo();
            componentInfo.fullName = "Component " + Utilities.getFormatedDummyCounter(this.dummyCompNameCounter);
            componentInfo.shortName = "Comp " + Utilities.getFormatedDummyCounter(this.dummyCompNameCounter);
            simpleIntObjectMap = new SimpleIntObjectMap();
            simpleIntObjectMap.add(n2, componentInfo);
            this.dummyCompNames.add(n, simpleIntObjectMap);
            ++this.dummyCompNameCounter;
        } else {
            componentInfo = (ComponentInfo)simpleIntObjectMap.get(n2);
            if (componentInfo == null) {
                componentInfo = new ComponentInfo();
                componentInfo.fullName = "Component " + Utilities.getFormatedDummyCounter(this.dummyCompNameCounter);
                componentInfo.shortName = "Comp " + Utilities.getFormatedDummyCounter(this.dummyCompNameCounter);
                simpleIntObjectMap.add(n2, componentInfo);
                this.dummyCompNames.add(n, simpleIntObjectMap);
                ++this.dummyCompNameCounter;
            }
        }
        return componentInfo;
    }

    public EnsembleInfo getDummyEnsembleName(int n, int n2) {
        EnsembleInfo ensembleInfo = null;
        ensembleInfo = (EnsembleInfo)this.dummyEnsNames.get(n);
        if (ensembleInfo == null) {
            ensembleInfo = new EnsembleInfo();
            ensembleInfo.ensID = n;
            ensembleInfo.ensECC = n2;
            ensembleInfo.fullName = "Ensemble " + Utilities.getFormatedDummyCounter(this.dummyEnsNameCounter);
            ensembleInfo.shortName = "Ens " + Utilities.getFormatedDummyCounter(this.dummyEnsNameCounter);
            this.dummyEnsNames.add(n, ensembleInfo);
            ++this.dummyEnsNameCounter;
        }
        return ensembleInfo;
    }

    public ServiceInfo getDummyServiceName(int n) {
        ServiceInfo serviceInfo = (ServiceInfo)this.dummyServNames.get(n);
        if (serviceInfo == null) {
            serviceInfo = new ServiceInfo();
            serviceInfo.fullName = "Service " + Utilities.getFormatedDummyCounter(this.dummyServNameCounter);
            serviceInfo.shortName = "Serv " + Utilities.getFormatedDummyCounter(this.dummyServNameCounter);
            serviceInfo.sID = n;
            this.dummyServNames.add((int)serviceInfo.sID, serviceInfo);
            ++this.dummyServNameCounter;
        }
        return serviceInfo;
    }
}

