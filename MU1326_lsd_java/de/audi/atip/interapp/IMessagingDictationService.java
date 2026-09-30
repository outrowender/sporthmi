/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.esolutions.fw.util.commons.Buffer;

public interface IMessagingDictationService
extends AbstractSDSApplicationService {
    public static final int COMPOSITION_MODE_NEW = 0;
    public static final int COMPOSITION_MODE_CONTINUE = 1;
    public static final int COMPOSITION_MODE_EDIT = 2;
    public static final int COMPOSITION_MODE_REPLY = 3;
    public static final int COMPOSITION_MODE_REPLY_ALL = 4;
    public static final int COMPOSITION_MODE_FORWARD = 5;
    public static final int MSG_TYPE_ANY = 0;
    public static final int MSG_TYPE_SMS = 1;
    public static final int MSG_TYPE_MAIL = 2;
    public static final int DIALOG_STEP_RECIPIENTS = 0;
    public static final int DIALOG_STEP_SUBJECT = 1;
    public static final int DIALOG_STEP_BODY = 2;
    public static final int DIALOG_STEP_SEND = 3;
    public static final int RECIPIENT_TYPE_ANY = 0;
    public static final int RECIPIENT_TYPE_TO = 1;
    public static final int RECIPIENT_TYPE_CC = 2;
    public static final int RECIPIENT_TYPE_BCC = 3;
    public static final int EDITOR_INPUT_MODE_REGULAR = 0;
    public static final int EDITOR_INPUT_MODE_ALTERNATIVES = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR_GENERAL = 1;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT = 2;
    public static final int RESULT_ERROR_ILLEGAL_STATE = 3;

    public TextEditorModelDDApp getSubjectEditorModel();

    public TextEditorModelDDApp getBodyEditorModel();

    public ChoiceModelApp getSubjectEditorInputModeModel();

    public ChoiceModelApp getBodyEditorInputModeModel();

    public void indicateSubjectEditorModelWrite();

    public void indicateBodyEditorModelWrite();

    public void requestBeginDialog(int var1, int var2, boolean var3);

    public void requestEndDialog();

    public void requestDialogStep(int var1);

    public void requestAddRecipient(int var1, String var2, long var3, String var5);

    public void requestClearRecipients(int var1);

    public void requestSendMessage();

    public static final class CompositionState {
        private final boolean isDialogActive;
        private final boolean hasFailed;
        private final boolean hasAccount;
        private final int accountType;
        private final int templateCount;
        private final boolean hasRecipients;
        private final String primaryRecipientName;
        private final boolean hasSubject;
        private final boolean hasBody;

        public CompositionState(boolean bl, boolean bl2, boolean bl3, int n, int n2, boolean bl4, String string, boolean bl5, boolean bl6) {
            this.isDialogActive = bl;
            this.hasFailed = bl2;
            this.hasAccount = bl3;
            this.accountType = n;
            this.templateCount = n2;
            this.hasRecipients = bl4;
            this.primaryRecipientName = string != null ? string : "";
            this.hasSubject = bl5;
            this.hasBody = bl6;
        }

        public boolean isDialogActive() {
            return this.isDialogActive;
        }

        public boolean hasDialogFailed() {
            return this.hasFailed;
        }

        public boolean hasAccount() {
            return this.hasAccount;
        }

        public int getAccountType() {
            return this.hasAccount() ? this.accountType : 0;
        }

        public int getTemplateCount() {
            return this.templateCount;
        }

        public boolean hasRecipients() {
            return this.hasRecipients;
        }

        public String getPrimaryRecipientName() {
            return this.primaryRecipientName;
        }

        public boolean hasSubject() {
            return this.hasSubject;
        }

        public boolean hasBody() {
            return this.hasBody;
        }

        public String toString() {
            Buffer buffer = new Buffer(256);
            buffer.append("CompositionState {isDialogActive = ");
            buffer.append(this.isDialogActive);
            buffer.append(", hasFailed = ");
            buffer.append(this.hasFailed);
            buffer.append(", hasAccount = ");
            buffer.append(this.hasAccount);
            buffer.append(", accountType = ");
            buffer.append(this.accountType);
            buffer.append(", templateCount = ");
            buffer.append(this.templateCount);
            buffer.append(", hasRecipients = ");
            buffer.append(this.hasRecipients);
            buffer.append(", primaryRecipientName = ");
            buffer.append(this.primaryRecipientName);
            buffer.append(", hasSubject = ");
            buffer.append(this.hasSubject);
            buffer.append(", hasBody = ");
            buffer.append(this.hasBody);
            buffer.append('}');
            return buffer.toString();
        }
    }
}

