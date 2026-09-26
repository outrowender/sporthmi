/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import java.util.List;

public interface IDiagnosisManager {
    default public void addDataProvider(int n, IDiagnosisDataProvider iDiagnosisDataProvider) {
    }

    default public List getDataProviderKeys(int n) {
    }

    default public IDiagnosisDataProvider getDataProvider(int n, String string) {
    }

    default public void addCommandProvider(int n, IDiagnosisCommandProvider iDiagnosisCommandProvider) {
    }

    default public List getCommandProviderKeys(int n) {
    }

    default public IDiagnosisCommandProvider getCommandProvider(int n, String string) {
    }
}

