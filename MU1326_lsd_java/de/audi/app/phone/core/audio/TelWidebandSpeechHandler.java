/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.app.phone.core.audio.TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.atip.log.LogChannel;

public class TelWidebandSpeechHandler
extends AbstractPhoneComponent {
    private static final int WIDEBAND_SPEECH_UNKNOWN;
    private static final int WIDEBAND_SPEECH_DISABLED;
    private static final int WIDEBAND_SPEECH_ENABLED;
    private volatile int currentWidebandSpeechSetting = 0;
    private final TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener widebandSpeechResponseListener = new TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener(this, null);
    private final TelAudioCmdManager cmdManager;
    private volatile boolean isAMAvailable = false;

    public TelWidebandSpeechHandler(ITelApplication iTelApplication, TelAudioCmdManager telAudioCmdManager) {
        super(iTelApplication, "App.Phone.Main");
        this.cmdManager = telAudioCmdManager;
    }

    public synchronized boolean setWidebandSpeech(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, boolean bl, boolean bl2) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            int n;
            int n2 = n = iTelDSIMobileEquipmentDeviceState.isWidebandSpeechActive() ? 2 : 1;
            if (this.isAMAvailable() && n != this.currentWidebandSpeechSetting || bl2) {
                this.currentWidebandSpeechSetting = n;
                boolean bl3 = this.currentWidebandSpeechSetting == 2;
                this.log.log(1078071040, "[TelWidebandSpeechHandler#setWidebandSpeech] %1 - setting wideband speech to %2", (Object)TelDSIUtils.getRoleName(iTelDSIMobileEquipmentDeviceState.getDeviceRole()), (Object)String.valueOf(bl3));
                this.cmdManager.scheduleWidebandSpeech(bl3, bl, this.widebandSpeechResponseListener);
                return true;
            }
        } else {
            this.log.log(10000, "TelWidebandSpeechHandler#setWidebandSpeech deviceState is null");
        }
        return false;
    }

    public boolean isAMAvailable() {
        return this.isAMAvailable;
    }

    public void setAMAvailable(boolean bl) {
        this.isAMAvailable = bl;
    }

    static /* synthetic */ LogChannel access$100(TelWidebandSpeechHandler telWidebandSpeechHandler) {
        return telWidebandSpeechHandler.log;
    }

    static /* synthetic */ boolean access$200(TelWidebandSpeechHandler telWidebandSpeechHandler) {
        return telWidebandSpeechHandler.isAMAvailable;
    }

    static /* synthetic */ int access$302(TelWidebandSpeechHandler telWidebandSpeechHandler, int n) {
        telWidebandSpeechHandler.currentWidebandSpeechSetting = n;
        return telWidebandSpeechHandler.currentWidebandSpeechSetting;
    }

    static /* synthetic */ LogChannel access$400(TelWidebandSpeechHandler telWidebandSpeechHandler) {
        return telWidebandSpeechHandler.log;
    }
}

