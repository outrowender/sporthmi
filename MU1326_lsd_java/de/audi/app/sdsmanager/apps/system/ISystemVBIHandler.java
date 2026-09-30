/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.dsi.ISpeechRecognitionStateListener;

public interface ISystemVBIHandler
extends ISpeechRecognitionStateListener {
    public void sendTTSFinishAtPromptEnd(boolean var1);

    public void sendTTSFinishAtPromptRequestForLastQueuedPrompt(int var1);

    public void startRecognitionProlongDuringPrompt();

    public boolean isVBIActiveDuringActivePrompt();

    public void initializeRecgonitionMode();

    public void updateSpeechRecognitionState(int var1);

    public void stopRecognitionProlongAtPromptEnd();

    public boolean isTTSFinishAlreadySent();

    public boolean isRegularPromptAtSessionEndActive();

    public boolean informTTSAbortCommandAboutPromptEnd();
}

