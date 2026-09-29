/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface IMessagingDictationService
extends AbstractSDSApplicationService {
    public static final int COMPOSITION_MODE_NEW;
    public static final int COMPOSITION_MODE_CONTINUE;
    public static final int COMPOSITION_MODE_EDIT;
    public static final int COMPOSITION_MODE_REPLY;
    public static final int COMPOSITION_MODE_REPLY_ALL;
    public static final int COMPOSITION_MODE_FORWARD;
    public static final int MSG_TYPE_ANY;
    public static final int MSG_TYPE_SMS;
    public static final int MSG_TYPE_MAIL;
    public static final int DIALOG_STEP_RECIPIENTS;
    public static final int DIALOG_STEP_SUBJECT;
    public static final int DIALOG_STEP_BODY;
    public static final int DIALOG_STEP_SEND;
    public static final int RECIPIENT_TYPE_ANY;
    public static final int RECIPIENT_TYPE_TO;
    public static final int RECIPIENT_TYPE_CC;
    public static final int RECIPIENT_TYPE_BCC;
    public static final int EDITOR_INPUT_MODE_REGULAR;
    public static final int EDITOR_INPUT_MODE_ALTERNATIVES;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT;
    public static final int RESULT_ERROR_ILLEGAL_STATE;

    default public TextEditorModelDDApp getSubjectEditorModel() {
    }

    default public TextEditorModelDDApp getBodyEditorModel() {
    }

    default public ChoiceModelApp getSubjectEditorInputModeModel() {
    }

    default public ChoiceModelApp getBodyEditorInputModeModel() {
    }

    default public void indicateSubjectEditorModelWrite() {
    }

    default public void indicateBodyEditorModelWrite() {
    }

    default public void requestBeginDialog(int n, int n2, boolean bl) {
    }

    default public void requestEndDialog() {
    }

    default public void requestDialogStep(int n) {
    }

    default public void requestAddRecipient(int n, String string, long l, String string2) {
    }

    default public void requestClearRecipients(int n) {
    }

    default public void requestSendMessage() {
    }
}

