/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.preset;

import de.audi.app.phone.evo.preset.TelPresetHandler;
import de.audi.app.phone.evo.preset.TelPresetHandler$1;
import de.audi.atip.interapp.phone.ITelPresetService;
import de.audi.atip.preset.DefinitionRequest;
import de.esolutions.fw.util.commons.Buffer;

class TelPresetHandler$TelPresetServiceImpl
implements ITelPresetService {
    private final /* synthetic */ TelPresetHandler this$0;

    private TelPresetHandler$TelPresetServiceImpl(TelPresetHandler telPresetHandler) {
        this.this$0 = telPresetHandler;
    }

    @Override
    public void definePreset(DefinitionRequest definitionRequest, String string, String string2, int n) {
        if (TelPresetHandler.access$100(this.this$0).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("definitionRequest=");
            buffer.append(definitionRequest);
            buffer.append(", ");
            buffer.append("number=");
            buffer.append(string);
            buffer.append(", ");
            buffer.append("name=");
            buffer.append(string2);
            buffer.append(", ");
            buffer.append("phoneNumberType=");
            buffer.append(n);
            buffer.append(", ");
            TelPresetHandler.access$200(this.this$0).log(1078071040, "[TelPresetServiceImpl#definePreset] %1", (Object)buffer);
        }
        TelPresetHandler.access$300(this.this$0, definitionRequest, string2, string, (short)n);
    }

    /* synthetic */ TelPresetHandler$TelPresetServiceImpl(TelPresetHandler telPresetHandler, TelPresetHandler$1 telPresetHandler$1) {
        this(telPresetHandler);
    }
}

