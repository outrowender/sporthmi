/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.interapp.ADBSDSService$EmailAddressDetails;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.phone.ITelServiceSDS;
import java.util.LinkedList;

public interface MessageDictationHandler
extends ISDSApplication {
    public static final int TXT_TYPE_BODY_ADD;
    public static final int TXT_TYPE_SUBJECT_ADD;
    public static final int TXT_TYPE_BODY_REPLACE;
    public static final int TXT_TYPE_SUBJECT_NEW;
    public static final int TXT_TYPE_BODY_NEW;
    public static final int TXT_TYPE_SUBJECT_REPLACE;
    public static final int TXT_TYPE_SUBJECT_RESET;

    default public void setMessagingDictationService(IMessagingDictationService iMessagingDictationService) {
    }

    default public IMessagingDictationService getMessagingDictationService() {
    }

    default public void unsetMessagingDictationService() {
    }

    default public void setPhoneService(ITelServiceSDS iTelServiceSDS) {
    }

    default public void unsetPhoneService() {
    }

    default public int getActivationState() {
    }

    default public void setStopRequested(boolean bl) {
    }

    default public void clearBody() {
    }

    default public void signalStartOfSpeech() {
    }

    default public void signalEndOfSpeech() {
    }

    default public String getCurrentRecipient() {
    }

    default public void clearSubject() {
    }

    default public void evaluateCompositionState() {
    }

    default public void setDictationStep(int n) {
    }

    default public void handleDictationResult(LinkedList linkedList) {
    }

    default public void undoLastInsertion() {
    }

    default public void positionBodyCursor(int n) {
    }

    default public void positionSubjectCursor(int n) {
    }

    default public void dictationStarted() {
    }

    default public void dictationStopped() {
    }

    default public void updateEmailList(String[] stringArray) {
    }

    default public void setEmailAddressDetails(ADBSDSService$EmailAddressDetails aDBSDSService$EmailAddressDetails) {
    }

    default public ADBSDSService$EmailAddressDetails getEmailAddressDetails() {
    }

    default public int getMessageType() {
    }

    default public boolean isDictationRunning() {
    }
}

