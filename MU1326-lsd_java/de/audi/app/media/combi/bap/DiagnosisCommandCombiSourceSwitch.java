/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;

public class DiagnosisCommandCombiSourceSwitch
implements IDiagnosisCommandProvider {
    private final CombiBAPServiceListenerImpl combiBAPServiceListenerImpl;

    DiagnosisCommandCombiSourceSwitch(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl) {
        this.combiBAPServiceListenerImpl = combiBAPServiceListenerImpl;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"CombiBAPServiceListenerImpl.switchSource(pCombiSourceType|slotNumber|partitionNumber)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        int n = Integer.parseInt(stringArray[0]);
        int n2 = Integer.parseInt(stringArray[1]);
        int n3 = Integer.parseInt(stringArray[2]);
        this.combiBAPServiceListenerImpl.switchSource(n, n2, n3);
    }
}

