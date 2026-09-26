/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IMessagingDictationService$CompositionState;

public interface IMessagingDictationServiceListener {
    default public void responseBeginDialog(int n) {
    }

    default public void responseEndDialog(int n) {
    }

    default public void responseNextDialogStep(int n) {
    }

    default public void responseAddRecipient(int n) {
    }

    default public void responseClearRecipients(int n) {
    }

    default public void responseSendMessage(int n) {
    }

    default public void updateCompositionState(IMessagingDictationService.CompositionState compositionState) {
    }
}

