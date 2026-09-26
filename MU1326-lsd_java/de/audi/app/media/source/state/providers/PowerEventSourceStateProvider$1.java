/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.source.state.providers.PowerEventSourceStateProvider;

class PowerEventSourceStateProvider$1
implements IDiagnosisCommandProvider {
    private final /* synthetic */ PowerEventSourceStateProvider this$0;

    PowerEventSourceStateProvider$1(PowerEventSourceStateProvider powerEventSourceStateProvider) {
        this.this$0 = powerEventSourceStateProvider;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"power.updateClampS"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if (stringArray.length != 1) {
            return;
        }
        boolean bl = Boolean.valueOf(stringArray[0]);
        this.this$0.updateClampState(bl, false, false, false);
    }
}

