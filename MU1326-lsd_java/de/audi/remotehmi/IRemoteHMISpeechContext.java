/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext$CommandDisplay;
import de.audi.remotehmi.IRemoteHMISpeechEntity;

public interface IRemoteHMISpeechContext {
    default public int getCommandLength() {
    }

    default public IRemoteHMISpeechCommandSDS[] getCommands() {
    }

    default public IRemoteHMISpeechCommandSDS getCommand(int n) {
    }

    default public int getPromptLength() {
    }

    default public IRemoteHMISpeechEntity getOnlinePrompt() {
    }

    default public int getOnlinePromptLength() {
    }

    default public IRemoteHMISpeechEntity getPrompt() {
    }

    default public int getShortPromptLength() {
    }

    default public IRemoteHMISpeechEntity getShortPrompt() {
    }

    default public int getPardonPromptLength() {
    }

    default public IRemoteHMISpeechEntity getPardonPrompt() {
    }

    default public int getShortPardonPromptLength() {
    }

    default public IRemoteHMISpeechEntity getShortPardonPrompt() {
    }

    default public void setCommandDisplay(IRemoteHMISpeechContext$CommandDisplay iRemoteHMISpeechContext$CommandDisplay) {
    }

    default public IRemoteHMISpeechContext$CommandDisplay getCommandDisplay() {
    }

    default public void setFurtherCommandsDisplay(IRemoteHMISpeechContext$CommandDisplay iRemoteHMISpeechContext$CommandDisplay) {
    }

    default public IRemoteHMISpeechContext$CommandDisplay getFurtherCommandsDisplay() {
    }

    default public void setSkipSds(boolean bl) {
    }

    default public boolean isSkipSds() {
    }

    default public boolean isNavLocationInput() {
    }

    default public boolean useLineNumbers() {
    }

    default public boolean useLineNumbersStopDialog() {
    }

    default public boolean isSystemCorrectionCommandDisabled() {
    }

    default public boolean isHelpCommandsEnabled() {
    }

    default public boolean isDynamicState() {
    }

    default public boolean isDataUpdateAvailable() {
    }
}

