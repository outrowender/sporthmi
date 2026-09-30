/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.diag;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.IDiagnosisApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.diag.DiagnosisDSIHandler;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class DiagnosisApp {
    private final DiagnosisDSIHandler dsiHandler;
    private final IFrameworkAccess fw;
    private final LogChannel lc;
    private final List diagApps = new LinkedList();

    public DiagnosisApp(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = this.fw.getLogChannel("Fw.Diag.Attribs");
        this.dsiHandler = new DiagnosisDSIHandler(iFrameworkAccess, this);
    }

    public IFrameworkAccess getFramework() {
        return this.fw;
    }

    public void addDiagnosisApplication(IDiagnosisApp iDiagnosisApp) {
        this.lc.log(10000000, "addDiagnosisApplication: app=%1", (Object)iDiagnosisApp);
        this.diagApps.add(iDiagnosisApp);
    }

    public void removeDiagnosisApplication(IDiagnosisApp iDiagnosisApp) {
        this.lc.log(10000000, "addDiagnosisApplication: app=%1", (Object)iDiagnosisApp);
        this.diagApps.remove(iDiagnosisApp);
    }

    public DiagnosisDSIHandler getDsiHandler() {
        return this.dsiHandler;
    }

    void performAction(int n, Object object) {
        this.lc.log(10000000, "PerformAction(action=%2, param=%1)", object, (long)n);
        try {
            ListIterator listIterator = this.diagApps.listIterator();
            while (listIterator.hasNext()) {
                ((IDiagnosisApp)listIterator.next()).performAction(n, object);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception in performAction(action=%1)! %2", (long)n, (Throwable)exception);
        }
    }

    void startDiagSession() {
        this.lc.log(10000000, "startDiagSession");
        try {
            ListIterator listIterator = this.diagApps.listIterator();
            while (listIterator.hasNext()) {
                ((IDiagnosisApp)listIterator.next()).startDiagSession();
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception in startDiagSession()!", (Throwable)exception);
        }
    }

    void stopDiagSession() {
        this.lc.log(10000000, "stopDiagSession");
        try {
            ListIterator listIterator = this.diagApps.listIterator();
            while (listIterator.hasNext()) {
                ((IDiagnosisApp)listIterator.next()).stopDiagSession();
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception in stopDiagSession()!", (Throwable)exception);
        }
    }

    void switch2OriginSource(int n, int n2) {
        this.lc.log(10000000, "switch2OriginSource app=%1", (long)n2);
        try {
            ListIterator listIterator = this.diagApps.listIterator();
            while (listIterator.hasNext()) {
                ((IDiagnosisApp)listIterator.next()).switch2OriginSource(n, n2);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception in switch2OriginSource!", (Throwable)exception);
        }
    }

    void updateDiagnosticValueChanged(int n, long l) {
        try {
            ListIterator listIterator = this.diagApps.listIterator();
            while (listIterator.hasNext()) {
                ((IDiagnosisApp)listIterator.next()).updateDiagnosticValueChanged(n, l);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception in updateDiagnosticValueChanged(namespace=%1, key=%2)", (long)n, l);
        }
    }
}

