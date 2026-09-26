/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.dsi.ISpeechRecognitionStateListener;

public interface ISystemVBIHandler
extends ISpeechRecognitionStateListener {
    default public void sendTTSFinishAtPromptEnd(boolean bl) {
    }

    default public void sendTTSFinishAtPromptRequestForLastQueuedPrompt(int n) {
    }

    default public void startRecognitionProlongDuringPrompt() {
    }

    default public boolean isVBIActiveDuringActivePrompt() {
    }

    default public void initializeRecgonitionMode() {
    }

    @Override
    default public void updateSpeechRecognitionState(int n) {
    }

    default public void stopRecognitionProlongAtPromptEnd() {
    }

    default public boolean isTTSFinishAlreadySent() {
    }

    default public boolean isRegularPromptAtSessionEndActive() {
    }

    default public boolean informTTSAbortCommandAboutPromptEnd() {
    }
}

