/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodRingtoneMuteHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodRingtoneMuteHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void setRingToneMuteState(boolean bl) {
        this.log.log(1000000, "[TelBAPMethodRingtoneMuteHandler#setRingToneMuteState] ringToneMuted=%1", bl);
        this.getApplication().getAudio().muteRingtone(bl);
    }
}

