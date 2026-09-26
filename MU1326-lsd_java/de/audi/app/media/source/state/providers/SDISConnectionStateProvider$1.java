/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.source.state.providers.SDISConnectionStateProvider;

class SDISConnectionStateProvider$1
implements IDiagnosisCommandProvider {
    private final /* synthetic */ SDISConnectionStateProvider this$0;

    SDISConnectionStateProvider$1(SDISConnectionStateProvider sDISConnectionStateProvider) {
        this.this$0 = sDISConnectionStateProvider;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"sdis.updateSdisConnected"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        this.this$0.updateSdisConnected(Boolean.valueOf(stringArray[0]));
    }
}

