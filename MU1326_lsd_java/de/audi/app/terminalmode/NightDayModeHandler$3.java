/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.NightDayModeHandler;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;

class NightDayModeHandler$3
implements IDiagnosisCommandProvider {
    private final /* synthetic */ NightDayModeHandler this$0;

    NightDayModeHandler$3(NightDayModeHandler nightDayModeHandler) {
        this.this$0 = nightDayModeHandler;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"requestNightMode", "requestDayMode"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        NightDayModeHandler.access$100(this.this$0, "requestNightMode".equals(string));
    }
}

