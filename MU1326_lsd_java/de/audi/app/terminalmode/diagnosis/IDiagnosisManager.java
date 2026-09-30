/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.diagnosis;

import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import java.util.List;

public interface IDiagnosisManager {
    public void addDataProvider(int var1, IDiagnosisDataProvider var2);

    public List getDataProviderKeys(int var1);

    public IDiagnosisDataProvider getDataProvider(int var1, String var2);

    public void addCommandProvider(int var1, IDiagnosisCommandProvider var2);

    public List getCommandProviderKeys(int var1);

    public IDiagnosisCommandProvider getCommandProvider(int var1, String var2);
}

