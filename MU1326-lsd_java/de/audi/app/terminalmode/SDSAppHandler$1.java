/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.SDSAppHandler;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.utils.reactive.observables.Observables$Consumer4;

class SDSAppHandler$1
implements Observables$Consumer4 {
    private final /* synthetic */ SDSAppHandler this$0;

    SDSAppHandler$1(SDSAppHandler sDSAppHandler) {
        this.this$0 = sDSAppHandler;
    }

    public void accept(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2, SDSService sDSService, TMDevice tMDevice) {
        sDSService.disablePTT(tMDevice.isCarplayDevice() && (audioConnectionState.isAudible() || audioConnectionState2.isAudible()), true, (byte)10);
    }

    @Override
    public /* synthetic */ void accept(Object object, Object object2, Object object3, Object object4) {
        this.accept((AudioConnectionState)object, (AudioConnectionState)object2, (SDSService)object3, (TMDevice)object4);
    }
}

