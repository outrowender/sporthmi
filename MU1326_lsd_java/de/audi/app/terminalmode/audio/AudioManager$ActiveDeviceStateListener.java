/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$1;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;

final class AudioManager$ActiveDeviceStateListener
implements IActiveDeviceStateListener {
    private static final String LOGCLASS;
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$ActiveDeviceStateListener(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        AudioManager.access$4500(this.this$0).accept(tMDevice);
        if (tMDevice.isActive()) {
            AudioManager.access$300(this.this$0).log(14808325, "[%1.updateActiveDeviceState] %2", (Object)"AudioManager.ActiveDeviceStateListener", (Object)(tMDevice.isCarplayDevice() ? "will use CarPlay connections" : "will use AndroidAuto connections"));
            if (tMDevice.isCarplayDevice()) {
                AudioManager.access$4102(this.this$0, AudioManager.access$4600(this.this$0));
            } else if (tMDevice.isAndroidAutoDevice()) {
                AudioManager.access$4102(this.this$0, AudioManager.access$1500(this.this$0));
            } else if (tMDevice.smartphoneType().is(SmartphoneManager$SmartphoneType.CARLIFE)) {
                AudioManager.access$4102(this.this$0, AudioManager.access$4700(this.this$0));
            }
        }
    }

    /* synthetic */ AudioManager$ActiveDeviceStateListener(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }
}

