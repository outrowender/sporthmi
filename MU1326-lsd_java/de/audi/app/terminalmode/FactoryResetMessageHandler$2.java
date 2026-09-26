/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.FactoryResetMessageHandler;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;

class FactoryResetMessageHandler$2
implements IDiagnosisCommandProvider {
    private final /* synthetic */ FactoryResetMessageHandler this$0;

    FactoryResetMessageHandler$2(FactoryResetMessageHandler factoryResetMessageHandler) {
        this.this$0 = factoryResetMessageHandler;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"requestFactoryReset"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        FactoryResetMessageHandler.access$000(this.this$0);
    }
}

