/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IMessagingDictationService;

public interface IMessagingDictationServiceListener {
    public void responseBeginDialog(int var1);

    public void responseEndDialog(int var1);

    public void responseNextDialogStep(int var1);

    public void responseAddRecipient(int var1);

    public void responseClearRecipients(int var1);

    public void responseSendMessage(int var1);

    public void updateCompositionState(IMessagingDictationService.CompositionState var1);

    public static class EmptyImplementation
    implements IMessagingDictationServiceListener {
        public void responseBeginDialog(int n) {
        }

        public void responseEndDialog(int n) {
        }

        public void responseNextDialogStep(int n) {
        }

        public void responseAddRecipient(int n) {
        }

        public void responseClearRecipients(int n) {
        }

        public void responseSendMessage(int n) {
        }

        public void updateCompositionState(IMessagingDictationService.CompositionState compositionState) {
        }
    }
}

