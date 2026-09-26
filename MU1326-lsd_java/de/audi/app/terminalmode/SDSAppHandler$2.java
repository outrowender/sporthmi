/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.SDSAppHandler;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.utils.reactive.observables.Observables$Consumer3;

class SDSAppHandler$2
implements Observables$Consumer3 {
    private final /* synthetic */ SDSAppHandler this$0;

    SDSAppHandler$2(SDSAppHandler sDSAppHandler) {
        this.this$0 = sDSAppHandler;
    }

    public void accept(ApplicationOwner applicationOwner, SDSService sDSService, TMDevice tMDevice) {
        if (sDSService.isSDSActive() && SDSAppHandler.access$000(this.this$0).getActiveDevice().isCarplayDevice() && applicationOwner.is(ApplicationOwner.DEVICE)) {
            SDSAppHandler.access$100(this.this$0).log(1078071040, "[%1.Phone owner CPdevice while sds active] - disable SDS.", (Object)"SDSAppHandler");
            sDSService.disablePTT(true, true, (byte)10);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object, Object object2, Object object3) {
        this.accept((ApplicationOwner)object, (SDSService)object2, (TMDevice)object3);
    }
}

