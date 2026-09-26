/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.atip.utils.generics.Consumer;

class TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState$1
implements Consumer {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState this$3;

    TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState$1(TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState tMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState) {
        this.this$3 = tMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState;
    }

    public void accept(ApplicationOwner applicationOwner) {
        if (applicationOwner.is(ApplicationOwner.NOBODY)) {
            TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState.access$1500(this.this$3)).sendMessage(18);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((ApplicationOwner)object);
    }
}

