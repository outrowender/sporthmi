/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.app.phone.core.audio.TelDefaultDSISoundListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.TelDSIUtils;

public class TelWidebandSpeechHandler
extends AbstractPhoneComponent {
    private static final int WIDEBAND_SPEECH_UNKNOWN = 0;
    private static final int WIDEBAND_SPEECH_DISABLED = 1;
    private static final int WIDEBAND_SPEECH_ENABLED = 2;
    private volatile int currentWidebandSpeechSetting = 0;
    private final TelDSISoundWidebandSpeechListener widebandSpeechResponseListener = new TelDSISoundWidebandSpeechListener();
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
                this.log.log(1000000, "[TelWidebandSpeechHandler#setWidebandSpeech] %1 - setting wideband speech to %2", (Object)TelDSIUtils.getRoleName(iTelDSIMobileEquipmentDeviceState.getDeviceRole()), (Object)String.valueOf(bl3));
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

    private class TelDSISoundWidebandSpeechListener
    extends TelDefaultDSISoundListener {
        private TelDSISoundWidebandSpeechListener() {
        }

        public void responseWidebandSpeech(int n, boolean bl) {
            TelWidebandSpeechHandler.this.log.log(1000000, "[TelWidebandSpeechHandler.TelDSISoundWidebandSpeechListener#responseWidebandSpeech] widebandSpeech=%1", bl);
            if (TelWidebandSpeechHandler.this.isAMAvailable) {
                TelWidebandSpeechHandler.this.currentWidebandSpeechSetting = bl ? 2 : 1;
            } else {
                TelWidebandSpeechHandler.this.log.log(100000, "[TelWidebandSpeechHandler.TelDSISoundWidebandSpeechListener#responseWidebandSpeech] AMAvailable=FALSE, reset WBS setting to UNKNOWN");
                TelWidebandSpeechHandler.this.currentWidebandSpeechSetting = 0;
            }
        }
    }
}

