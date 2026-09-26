/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.ecall.DataEcall;
import de.audi.app.bap.fw.functiontypes.AbstractBAPArrayElementListASG$BAPElementConverter;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_Data;

class DataEcall$1
implements AbstractBAPArrayElementListASG$BAPElementConverter {
    private final /* synthetic */ DataEcall this$0;

    DataEcall$1(DataEcall dataEcall) {
        this.this$0 = dataEcall;
    }

    @Override
    public Object convert(BAPArrayElement bAPArrayElement) {
        return DataEcall.access$000((AllowedEmergencyNumbers_Data)bAPArrayElement);
    }
}

