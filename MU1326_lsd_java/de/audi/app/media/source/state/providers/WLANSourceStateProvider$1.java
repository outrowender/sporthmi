/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider;

class WLANSourceStateProvider$1
implements IDiagnosisCommandProvider {
    private final /* synthetic */ WLANSourceStateProvider this$0;

    WLANSourceStateProvider$1(WLANSourceStateProvider wLANSourceStateProvider) {
        this.this$0 = wLANSourceStateProvider;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"wlan.updateWLANState"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        this.this$0.updateWlanState(Boolean.valueOf(stringArray[0]));
    }
}

