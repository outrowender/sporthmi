/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.BAPArrayDataENI;
import de.audi.app.bap.fw.functiontypes.AbstractBAPArrayElementListASG$BAPElementConverter;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_Data;

class BAPArrayDataENI$3
implements AbstractBAPArrayElementListASG$BAPElementConverter {
    private final /* synthetic */ BAPArrayDataENI this$0;

    BAPArrayDataENI$3(BAPArrayDataENI bAPArrayDataENI) {
        this.this$0 = bAPArrayDataENI;
    }

    @Override
    public Object convert(BAPArrayElement bAPArrayElement) {
        return BAPArrayDataENI.access$200((ServiceList_Data)bAPArrayElement);
    }
}

