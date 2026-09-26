/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.audio.HMIAudioService;
import de.audi.tghu.power.PowerCommandFactory;

class PowerCommandFactory$6
implements Runnable {
    private final /* synthetic */ HMIAudioService val$hmiAM;
    private final /* synthetic */ PowerCommandFactory this$0;

    PowerCommandFactory$6(PowerCommandFactory powerCommandFactory, HMIAudioService hMIAudioService) {
        this.this$0 = powerCommandFactory;
        this.val$hmiAM = hMIAudioService;
    }

    @Override
    public final void run() {
        PowerCommandFactory.access$100(this.this$0).getPwrAudioHandler().setAudioDeviceService(this.val$hmiAM);
        PowerCommandFactory.access$100(this.this$0).getPowerFSM(0).setAudioDeviceService();
    }

    public final String toString() {
        return new StringBuffer().append("setAudioDeviceServiceCmd: hmiAM=").append(this.val$hmiAM).toString();
    }
}

