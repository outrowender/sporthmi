/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.BAPArrayDataENI;
import de.audi.app.bap.fw.functiontypes.AbstractBAPArrayElementListASG$BAPElementConverter;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_Data;

class BAPArrayDataENI$1
implements AbstractBAPArrayElementListASG$BAPElementConverter {
    private final /* synthetic */ BAPArrayDataENI this$0;

    BAPArrayDataENI$1(BAPArrayDataENI bAPArrayDataENI) {
        this.this$0 = bAPArrayDataENI;
    }

    @Override
    public Object convert(BAPArrayElement bAPArrayElement) {
        return BAPArrayDataENI.access$000((DestinationsList_Data)bAPArrayElement);
    }
}

