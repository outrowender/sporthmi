/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.fw.functiontypes.AbstractBAPArrayElementListASG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_Data;

public final class BAPArrayElementListECall
extends AbstractBAPArrayElementListASG {
    public BAPArrayElementListECall(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public boolean isDeleted(BAPArrayElement bAPArrayElement) {
        return bAPArrayElement instanceof AllowedEmergencyNumbers_Data && ((AllowedEmergencyNumbers_Data)bAPArrayElement).id.isEmptyString();
    }
}

