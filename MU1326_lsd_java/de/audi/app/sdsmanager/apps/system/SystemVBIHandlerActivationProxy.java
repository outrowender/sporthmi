/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.apps.system.SystemVBIHandler;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.testsupport.ISDSSettingEnumStateListener;
import de.audi.app.sdsmanager.testsupport.SDSSettingsEnum;
import de.audi.atip.log.LogChannel;

public class SystemVBIHandlerActivationProxy
implements ISystemVBIHandler,
ISDSSettingEnumStateListener {
    private final LogChannel logChannel;
    private final ISystemVBIHandler systemVBIHandler;
    private final SDSTimeoutHandler sdsTimeoutHandler;

    public SystemVBIHandlerActivationProxy(SDSAdapter sDSAdapter, AppSDSManager appSDSManager, SystemSDSHandler systemSDSHandler, SpeechTTSHandler speechTTSHandler, SpeechRecognitionHandler speechRecognitionHandler, SDSTimeoutHandler sDSTimeoutHandler, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.systemVBIHandler = new SystemVBIHandler(sDSAdapter, appSDSManager, systemSDSHandler, speechTTSHandler, speechRecognitionHandler, sDSTimeoutHandler, logChannel);
        SDSSettingsEnum.VBI.registerSDSSettingStateListener(this);
    }

    public void activateVBI() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.logChannel.log(-2137614336, "SystemVBIHandlerActivationProxy#activateVBI: Voice Barge-In is already on!");
            return;
        }
        this.logChannel.log(-2137614336, "SystemVBIHandlerActivationProxy#activateVBI: Activate Voice Barge-In!");
        SDSModelAccess.setVBISysConstModelValue(true);
        SDSModelAccess.setVoiceBargeIn(1);
        SDSSettingsEnum.VBI.setActivationStatus(true);
    }

    public void deactivateVBI() {
        if (!SDSModelAccess.isVoiceBargeInActive()) {
            this.logChannel.log(-2137614336, "SystemVBIHandlerActivationProxy#deactivateVBI: Voice Barge-In is already off!");
            return;
        }
        this.logChannel.log(-2137614336, "SystemVBIHandlerActivationProxy#deactivateVBI: Deactivate Voice-Barge In!");
        this.sdsTimeoutHandler.cancelRecognitionProlongLoopTimer();
        SDSModelAccess.setVBISysConstModelValue(false);
        SDSModelAccess.setVoiceBargeIn(0);
        SDSSettingsEnum.VBI.setActivationStatus(false);
    }

    @Override
    public void updateSDSSettingsEnumState(SDSSettingsEnum sDSSettingsEnum) {
        if (sDSSettingsEnum == SDSSettingsEnum.VBI) {
            if (SDSSettingsEnum.VBI.isActive()) {
                this.logChannel.log(-2137614336, "SystemVBIHandlerActivationProxy#updateSDSSettingsEnumState: Activate Voice Barge-In!");
                SDSModelAccess.setVBISysConstModelValue(true);
            } else {
                this.logChannel.log(-2137614336, "SystemVBIHandlerActivationProxy#updateSDSSettingsEnumState: Deactivate Voice-Barge In!");
                SDSModelAccess.setVBISysConstModelValue(false);
                this.sdsTimeoutHandler.cancelRecognitionProlongLoopTimer();
            }
        }
    }

    @Override
    public void sendTTSFinishAtPromptEnd(boolean bl) {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.systemVBIHandler.sendTTSFinishAtPromptEnd(bl);
        }
    }

    @Override
    public void sendTTSFinishAtPromptRequestForLastQueuedPrompt(int n) {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.systemVBIHandler.sendTTSFinishAtPromptRequestForLastQueuedPrompt(n);
        }
    }

    @Override
    public void startRecognitionProlongDuringPrompt() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.systemVBIHandler.startRecognitionProlongDuringPrompt();
        }
    }

    @Override
    public boolean isVBIActiveDuringActivePrompt() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            return this.systemVBIHandler.isVBIActiveDuringActivePrompt();
        }
        return false;
    }

    @Override
    public void initializeRecgonitionMode() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.systemVBIHandler.initializeRecgonitionMode();
        }
    }

    @Override
    public void updateSpeechRecognitionState(int n) {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.systemVBIHandler.updateSpeechRecognitionState(n);
        }
    }

    @Override
    public void stopRecognitionProlongAtPromptEnd() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            this.systemVBIHandler.stopRecognitionProlongAtPromptEnd();
        }
    }

    @Override
    public boolean isTTSFinishAlreadySent() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            return this.systemVBIHandler.isTTSFinishAlreadySent();
        }
        return false;
    }

    @Override
    public boolean isRegularPromptAtSessionEndActive() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            return this.systemVBIHandler.isRegularPromptAtSessionEndActive();
        }
        return false;
    }

    @Override
    public boolean informTTSAbortCommandAboutPromptEnd() {
        if (SDSModelAccess.isVoiceBargeInActive()) {
            return this.systemVBIHandler.informTTSAbortCommandAboutPromptEnd();
        }
        return false;
    }
}

