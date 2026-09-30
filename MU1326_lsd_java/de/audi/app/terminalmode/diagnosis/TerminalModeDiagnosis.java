/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.diagnosis;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.app.terminalmode.osgi.AbstractServiceListTracker;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class TerminalModeDiagnosis
extends AbstractSwDiagnosis {
    private final IContext activeTerminalModeTerminal;
    private volatile AbstractServiceListTracker terminalModeModelBankTracker;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIModelBank;

    public TerminalModeDiagnosis(IContext iContext) {
        this.activeTerminalModeTerminal = iContext;
        this.terminalModeModelBankTracker = new AbstractServiceListTracker(iContext.getLogger().main(), iContext.getServiceManager()){

            protected void serviceRemoved(Object object) {
            }

            protected void serviceAdded(Object object) {
            }

            protected Class getTrackedServiceClass() {
                return class$de$audi$atip$hmi$HMIModelBank == null ? (class$de$audi$atip$hmi$HMIModelBank = TerminalModeDiagnosis.class$("de.audi.atip.hmi.HMIModelBank")) : class$de$audi$atip$hmi$HMIModelBank;
            }

            protected boolean checkServiceProperties(Dictionary dictionary) {
                return (Integer)dictionary.get("moduleID") == 43;
            }
        };
    }

    public void init() {
        this.terminalModeModelBankTracker.init();
    }

    public void deinit() {
        this.terminalModeModelBankTracker.deinit();
    }

    public int getId() {
        return 32;
    }

    public String getName() {
        return "AppTerminalMode";
    }

    public String[] getKeys() {
        List list = this.activeTerminalModeTerminal.getDiagnosisManager().getDataProviderKeys(0);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next().toString());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public Object getValue(String string) {
        IDiagnosisDataProvider iDiagnosisDataProvider = this.activeTerminalModeTerminal.getDiagnosisManager().getDataProvider(0, string);
        return iDiagnosisDataProvider != null ? iDiagnosisDataProvider.getDiagValue() : "No provider found.";
    }

    public String[] getCommands() {
        ArrayList arrayList = new ArrayList();
        List list = this.activeTerminalModeTerminal.getDiagnosisManager().getCommandProviderKeys(0);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public int processCommand(String string, Object object) {
        IDiagnosisCommandProvider iDiagnosisCommandProvider = this.activeTerminalModeTerminal.getDiagnosisManager().getCommandProvider(0, string);
        if (iDiagnosisCommandProvider == null) {
            return -10;
        }
        iDiagnosisCommandProvider.executeDiagCommand(string, this.parseArgs((String)object, ","));
        return 0;
    }

    private String[] parseArgs(String string, String string2) {
        if (string == null) {
            return new String[0];
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList arrayList = new ArrayList(5);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

