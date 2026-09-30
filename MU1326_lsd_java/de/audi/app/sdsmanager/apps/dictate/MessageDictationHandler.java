/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.phone.ITelServiceSDS;
import java.util.LinkedList;

public interface MessageDictationHandler
extends ISDSApplication {
    public static final int TXT_TYPE_BODY_ADD = 0;
    public static final int TXT_TYPE_SUBJECT_ADD = 1;
    public static final int TXT_TYPE_BODY_REPLACE = 2;
    public static final int TXT_TYPE_SUBJECT_NEW = 3;
    public static final int TXT_TYPE_BODY_NEW = 4;
    public static final int TXT_TYPE_SUBJECT_REPLACE = 5;
    public static final int TXT_TYPE_SUBJECT_RESET = 6;

    public void setMessagingDictationService(IMessagingDictationService var1);

    public IMessagingDictationService getMessagingDictationService();

    public void unsetMessagingDictationService();

    public void setPhoneService(ITelServiceSDS var1);

    public void unsetPhoneService();

    public int getActivationState();

    public void setStopRequested(boolean var1);

    public void clearBody();

    public void signalStartOfSpeech();

    public void signalEndOfSpeech();

    public String getCurrentRecipient();

    public void clearSubject();

    public void evaluateCompositionState();

    public void setDictationStep(int var1);

    public void handleDictationResult(LinkedList var1);

    public void undoLastInsertion();

    public void positionBodyCursor(int var1);

    public void positionSubjectCursor(int var1);

    public void dictationStarted();

    public void dictationStopped();

    public void updateEmailList(String[] var1);

    public void setEmailAddressDetails(ADBSDSService.EmailAddressDetails var1);

    public ADBSDSService.EmailAddressDetails getEmailAddressDetails();

    public int getMessageType();

    public boolean isDictationRunning();
}

