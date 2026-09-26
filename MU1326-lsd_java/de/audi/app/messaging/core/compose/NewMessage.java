/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.ICompositionValidator;
import de.audi.app.messaging.core.compose.INewMessageObserver;
import de.audi.app.messaging.core.compose.INewMessagePropertyFactory;
import de.audi.app.messaging.core.compose.INewMessagePropertyFactory$NullFactory;
import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.compose.NewMessage$1;
import de.audi.app.messaging.core.compose.NewMessage$DiagPlugIn;
import de.audi.app.messaging.core.compose.NewMessage$MessagingDictationServiceListener;
import de.audi.app.messaging.core.compose.NewMessage$MyDsiMessagingListener;
import de.audi.app.messaging.core.compose.NewMessage$MyMenuModelListener;
import de.audi.app.messaging.core.compose.NewMessage$MyTextEditorListenerDD;
import de.audi.app.messaging.core.compose.SelectedRecipientList;
import de.audi.app.messaging.core.compose.SendMessageController;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.drafts.SaveDraftController;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.recipients.RecipientListRow;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.templates.DeleteTemplateController;
import de.audi.app.messaging.core.templates.SaveTemplateController;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.LinkedList;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;

public final class NewMessage
extends AbstractMessagingComponent
implements IDiagProvider {
    static final int CHAR_LIMIT_SMS;
    static final int CHAR_LIMIT_EMAIL_SUBJECT;
    static final int CHAR_LIMIT_EMAIL_BODY;
    public static final String MESSAGE_ID_NONE;
    private static final ICompositionValidator DEFAULT_SEND_VALIDATOR;
    private static final int SEND_BUTTON_DISABLED;
    private static final int SEND_BUTTON_ENABLED;
    public static final int MENU_ITEM_RECIPIENTS;
    public static final int MENU_ITEM_SUBJECT;
    public static final int MENU_ITEM_BODY;
    public static final int MENU_ITEM_SEND;
    public static final int MENU_ITEM_ABORT;
    private static final int MENU_ITEM_NONE;
    private static final int LIST_MODEL_ID_NONE;
    private static final int LIST_ROW_ID_NONE;
    private final MessageCreator messageCreator;
    private final SelectedRecipientList selectedRecipientList;
    private final TextEditorModelDDApp subjectTextEditor;
    private final TextEditorModelDDApp bodyTextEditor;
    private final SendMessageController sendMessageController;
    private final SaveDraftController saveDraftController;
    private final SaveTemplateController saveTemplateController;
    private final DeleteTemplateController deleteTemplateController;
    private volatile INewMessagePropertyFactory newMessagePropertyFactory = new INewMessagePropertyFactory$NullFactory();
    private volatile ICompositionValidator sendValidator = DEFAULT_SEND_VALIDATOR;
    private String quotedText = "";
    private AttachmentInformation[] attachments = new AttachmentInformation[0];
    private boolean isBufferClean = true;
    private volatile int changeId = 0;
    private volatile int initialChangeId = 0;
    private volatile int hmiMessageId = 0;
    private String draftId = "";
    private volatile boolean isDictationDialogActive = false;
    private static final int VOICE_DATA_IDLE;
    private int voiceDataProcessingState = 0;
    private CopyOnWriteArrayList newMessageObservers = new CopyOnWriteArrayList();
    private boolean moveOtherRecipientsToCC = false;
    private boolean isAutoPositionCursorNeeded = true;

    public NewMessage(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.subjectTextEditor = this.framework.getHmiServiceApp().getTextEditorModelDD(-1349312256).getSyncedModel();
        this.bodyTextEditor = this.framework.getHmiServiceApp().getTextEditorModelDD(-1198317312).getSyncedModel();
        this.messageCreator = new MessageCreator(messagingBundleContext);
        this.selectedRecipientList = new SelectedRecipientList(messagingBundleContext);
        this.sendMessageController = new SendMessageController(messagingBundleContext);
        this.saveDraftController = new SaveDraftController(messagingBundleContext);
        this.saveTemplateController = new SaveTemplateController(messagingBundleContext);
        this.deleteTemplateController = new DeleteTemplateController(messagingBundleContext);
        this.addComponent(this.messageCreator);
        this.addComponent(this.selectedRecipientList);
        this.addComponent(this.sendMessageController);
        this.addComponent(this.saveDraftController);
        this.addComponent(this.saveTemplateController);
        this.addComponent(this.deleteTemplateController);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.framework.getHmiServiceApp().getMenuModel(831725824).setListener(new NewMessage$MyMenuModelListener(this, null));
        NewMessage$MyTextEditorListenerDD newMessage$MyTextEditorListenerDD = new NewMessage$MyTextEditorListenerDD(this, null);
        this.subjectTextEditor.addListener(newMessage$MyTextEditorListenerDD);
        this.bodyTextEditor.addListener(newMessage$MyTextEditorListenerDD);
        MessagingDictationService messagingDictationService = abstractMsgApplication.getMessagingDictationService();
        if (messagingDictationService != null) {
            messagingDictationService.addListener(new NewMessage$MessagingDictationServiceListener(this, null));
        }
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new NewMessage$MyDsiMessagingListener(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.clear();
    }

    public void setPropertyFactory(INewMessagePropertyFactory iNewMessagePropertyFactory) {
        this.log.log(-2137614336, "[NewMessage#setPropertyFactory] newMessagePropertyFactory = %1", (Object)iNewMessagePropertyFactory);
        this.newMessagePropertyFactory = iNewMessagePropertyFactory;
    }

    public void setSendValidator(ICompositionValidator iCompositionValidator) {
        this.sendValidator = iCompositionValidator != null ? iCompositionValidator : DEFAULT_SEND_VALIDATOR;
    }

    public TextEditorModelDDApp getSubjectTextEditor() {
        return this.subjectTextEditor;
    }

    public TextEditorModelDDApp getBodyTextEditor() {
        return this.bodyTextEditor;
    }

    public void setRecipientAssignmentStrategy(boolean bl) {
        this.moveOtherRecipientsToCC = bl;
    }

    public void clear() {
        this.log.log(-2137614336, "[NewMessage#clear]");
        this.selectedRecipientList.clear(0);
        this.setSubject("");
        this.setBody("");
        this.setAttachments(null);
        this.quotedText = "";
        this.setDraftId("");
        this.setRightDrawerOptions();
        this.setSendButtonActivation();
        this.setDirtyBit();
        this.contentChanged();
        this.beginNewMessage();
        this.setChangeModel(false);
        this.emitMessageCleared();
    }

    private void beginNewMessage() {
        this.log.log(-2137614336, "[NewMessage#beginNewMessage]");
        this.assignNewHmiMessageId();
        this.setInitialChangeId(this.getChangeId());
    }

    public boolean isBufferClean() {
        return this.isBufferClean;
    }

    public void setCursorPosition(int n) {
        this.log.log(-2137614336, "[NewMessage#setCursorPosition] menuItem = %1", (long)n);
        this.setCursorPosition(n, -1, -1L);
    }

    private void setCursorPosition(int n, int n2, long l) {
        this.log.log(-2137614336, "[NewMessage#setCursorPosition] menuItem = %1, listModelId = %2, listRowId = %3", (long)n, (long)n2, l);
        boolean bl = n2 != -1;
        int n3 = bl ? n2 : n;
        long l2 = bl ? l : -1L;
        MenuModelApp menuModelApp = this.framework.getHmiServiceApp().getMenuModel(831725824);
        menuModelApp.setFocusedItem(n3, FocusAdvice.KEEP_POSITION, l2);
    }

    public void setSendButtonActivation() {
        this.log.log(-2137614336, "[NewMessage#setSendButtonActivation]");
        int n = 0;
        if (this.sendValidator.isValid(this)) {
            n = 1;
        }
        this.framework.getHMIService().getButtonModel(-1483595520).setStatus(n);
    }

    public boolean isSendButtonEnabled() {
        int n = this.framework.getHMIService().getButtonModel(-1483595520).getStatus();
        return n == 1;
    }

    private void setDirtyBit() {
        boolean bl;
        boolean bl2 = bl = this.selectedRecipientList.isEmpty() && Strings.isNullOrEmpty(this.getSubject()) && Strings.isNullOrEmpty(this.getBody()) && this.attachments.length == 0;
        if (this.isBufferClean != bl) {
            this.log.log(-2137614336, "[NewMessage#setDirtyBit] State change: this.isBufferClean = %1", bl);
            this.isBufferClean = bl;
            int n = this.isBufferClean ? 0 : 1;
            this.framework.getHmiServiceApp().getChoiceModel(2056397056).setValue(n);
        }
    }

    private void signalSubjectLength() {
        this.log.log(-2137614336, "[NewMessage#signalSubjectLength]");
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        int n = bl ? 8192 : 700;
        this.framework.getHmiServiceApp().getLabelModel(1586700544).setText(String.valueOf(255));
        this.subjectTextEditor.setMaxLength(255);
        int n2 = this.getSubject().length() > 255 ? 1 : 0;
        this.framework.getHMIService().getChoiceModel(1569923328).setValue(n2);
        this.emitIndicateMessageLength(255 - this.getSubject().length(), n - this.getBody().length());
    }

    private void signalBodyLength() {
        this.log.log(-2137614336, "[NewMessage#signalBodyLength]");
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        int n = bl ? 8192 : 700;
        this.framework.getHmiServiceApp().getLabelModel(-846061312).setText(String.valueOf(n));
        this.bodyTextEditor.setMaxLength(n);
        int n2 = this.getBody().length() > n ? 1 : 0;
        this.framework.getHMIService().getChoiceModel(-829284096).setValue(n2);
        this.emitIndicateMessageLength(255 - this.getSubject().length(), n - this.getBody().length());
    }

    private void setRightDrawerOptions() {
        PropertyListCell propertyListCell = this.newMessagePropertyFactory.create(!this.msgApp.getAccountManager().isEmailMode());
        this.log.log(-2137614336, "[NewMessage#setRightDrawerOptions] Setting properties = %1", (Object)propertyListCell);
        PropertyModelApp propertyModelApp = this.framework.getHmiServiceApp().getPropertyModel(-292413184);
        propertyModelApp.setProperties(propertyListCell.getCategory(), propertyListCell.getProperties());
    }

    private void autoPositionCursor() {
        if (!this.isAutoPositionCursorNeeded) {
            this.log.log(-2137614336, "[NewMessage#autoPositionCursor] is not needed");
            return;
        }
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        int n = 0;
        n = this.voiceDataProcessingState != 0 ? 4 : (this.selectedRecipientList.isEmpty() ? 0 : (bl && Strings.isNullOrEmpty(this.getSubject()) ? 1 : (Strings.isNullOrEmpty(this.getBody()) && (bl || this.attachments.length <= 0) ? 2 : 3)));
        this.log.log(-2137614336, "[NewMessage#autoPositionCursor] menuItem = %1", (long)n);
        this.setCursorPosition(n);
    }

    private String composeQuotedText(MessageDetails messageDetails) {
        String string = this.msgApp.getTextLookup().getQuoteSeparator();
        Buffer buffer = new Buffer();
        buffer.append(string);
        buffer.append(messageDetails.getBody());
        return buffer.toString();
    }

    public void useTemplate(String string) {
        this.log.log(-2137614336, "[NewMessage#useTemplate]");
        String string2 = null;
        if (Strings.isNullOrEmpty(string)) {
            string2 = this.quotedText;
        } else if (Strings.isNullOrEmpty(this.quotedText)) {
            string2 = string;
        } else {
            Buffer buffer = new Buffer();
            buffer.append(string);
            buffer.append(this.quotedText);
            string2 = buffer.toString();
        }
        this.setBody(string2);
    }

    public void insertBodyText(String string) {
        this.log.log(-2137614336, "[NewMessage#insertBodyText]");
        this.bodyTextEditor.insert(string);
        this.bodyChanged(false);
    }

    public void setAttachments(AttachmentInformation[] attachmentInformationArray) {
        String string = "";
        if (attachmentInformationArray == null || attachmentInformationArray.length == 0) {
            this.log.log(-2137614336, "[NewMessage#setAttachmentInformation] attachments null or empty.");
            this.attachments = new AttachmentInformation[0];
        } else {
            this.log.log(-2137614336, "[NewMessage#setAttachmentInformation] attachments[0] = %1", (Object)attachmentInformationArray[0]);
            this.attachments = attachmentInformationArray;
            string = attachmentInformationArray[0].getName();
        }
        this.framework.getHMIService().getLabelModel(-2104352512).setText(string);
        this.setDirtyBit();
        this.contentChanged();
    }

    private int getHmiMessageId() {
        return this.hmiMessageId;
    }

    private void assignNewHmiMessageId() {
        this.log.log(-2137614336, "[NewMessage#assignNewHmiMessageId] this.hmiMessageId = %1", (long)this.hmiMessageId);
        ++this.hmiMessageId;
    }

    private int getInitialChangeId() {
        return this.initialChangeId;
    }

    public void setInitialChangeId(int n) {
        this.log.log(-2137614336, "[NewMessage#setInitialChangeId] initialChangeId = %1", (long)n);
        this.initialChangeId = n;
    }

    private int getChangeId() {
        return this.changeId;
    }

    private void contentChanged() {
        ++this.changeId;
        this.setChangeModel(true);
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[NewMessage#incrementChangeId] New changeId = %1", (long)this.changeId);
        }
    }

    private void setChangeModel(boolean bl) {
        this.framework.getHmiServiceApp().getChoiceModel(-1449975552).setValue(bl ? 1 : 0);
    }

    private void setDraftId(String string) {
        this.log.log(-2137614336, "[NewMessage#setDraftId] draftId = %1", (Object)string);
        this.draftId = string;
    }

    private String getDraftId() {
        return this.draftId;
    }

    public Message getTruncatedMessage() {
        MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
        if (messagingAccount == null) {
            throw new IllegalStateException("No account selected.");
        }
        int n = messagingAccount.getAccountID();
        String string = this.getDraftId();
        int n2 = messagingAccount.isSupportsEMail() ? 2 : 1;
        MatchedAddress matchedAddress = new MatchedAddress("", "", 0L, null);
        MatchedAddress[] matchedAddressArray = MessageContacts.toArray(this.selectedRecipientList.getRecipientsTo());
        MatchedAddress[] matchedAddressArray2 = MessageContacts.toArray(this.selectedRecipientList.getRecipientsCc());
        MatchedAddress[] matchedAddressArray3 = MessageContacts.toArray(this.selectedRecipientList.getRecipientsBcc());
        String string2 = this.getTruncatedSubject();
        long l = 0L;
        int n3 = 2;
        String string3 = "";
        String string4 = this.getTruncatedBody();
        AttachmentInformation[] attachmentInformationArray = this.getAttachments();
        int n4 = 2;
        int[] nArray = new int[]{};
        int n5 = -1;
        MessageDetails messageDetails = new MessageDetails(n, string, n2, matchedAddress, matchedAddressArray, matchedAddressArray2, matchedAddressArray3, string2, l, n3, string3, string4, attachmentInformationArray, n4, nArray, n5);
        return new Message(this.getHmiMessageId(), this.getInitialChangeId(), this.getChangeId(), messageDetails);
    }

    public void prepareEditMessage(MessageDetails messageDetails) {
        this.log.log(-2137614336, "[NewMessage#prepareEditMessage]");
        this.clear();
        this.selectedRecipientList.addRecipientsTo(messageDetails.getRecipientsTo());
        this.selectedRecipientList.addRecipientsCc(messageDetails.getRecipientsCc());
        this.selectedRecipientList.addRecipientsBcc(messageDetails.getRecipientsBcc());
        this.setSubject(messageDetails.getSubject());
        this.setBody(messageDetails.getBody());
        this.setAttachments(messageDetails.getAttachments());
        boolean bl = messageDetails.getMessageStatus() == 2;
        this.setDraftId(bl ? messageDetails.getMessageID() : "");
        this.setDirtyBit();
        this.contentChanged();
        this.beginNewMessage();
        this.setChangeModel(false);
    }

    void prepareForwardMessage(MessageDetails messageDetails) {
        this.log.log(-2137614336, "[NewMessage#prepareForwardMessage]");
        this.clear();
        String string = this.msgApp.getTextLookup().getForwardPrefix();
        String string2 = this.addSubjectPrefix(messageDetails.getSubject(), string);
        this.setSubject(string2);
        this.quotedText = this.composeQuotedText(messageDetails);
        this.setBody(this.quotedText, 0);
        this.setAttachments(messageDetails.getAttachments());
        this.setDirtyBit();
        this.contentChanged();
        this.beginNewMessage();
        this.setChangeModel(false);
    }

    void prepareReplyToMessage(MessageDetails messageDetails, boolean bl) {
        boolean bl2;
        this.log.log(-2137614336, "[NewMessage#prepareReplyToMessage] replyAll = %1", bl);
        this.clear();
        MatchedAddress matchedAddress = messageDetails.getSender();
        boolean bl3 = bl2 = matchedAddress != null && !Strings.isNullOrEmpty(matchedAddress.getAddress());
        if (bl2) {
            this.selectedRecipientList.addRecipientsTo(new MatchedAddress[]{matchedAddress});
        }
        if (bl) {
            if (this.moveOtherRecipientsToCC) {
                this.selectedRecipientList.addRecipientsCc(messageDetails.getRecipientsTo());
                this.selectedRecipientList.addRecipientsCc(messageDetails.getRecipientsCc());
            } else {
                this.selectedRecipientList.addRecipientsTo(messageDetails.getRecipientsTo());
                this.selectedRecipientList.addRecipientsCc(messageDetails.getRecipientsCc());
            }
        }
        String string = this.msgApp.getTextLookup().getReplyPrefix();
        String string2 = this.addSubjectPrefix(messageDetails.getSubject(), string);
        this.setSubject(string2);
        if (this.msgApp.getAccountManager().isEmailMode()) {
            this.quotedText = this.composeQuotedText(messageDetails);
            this.setBody(this.quotedText, 0);
        }
        this.setDirtyBit();
        this.contentChanged();
        this.beginNewMessage();
        this.setChangeModel(false);
    }

    public MessageCreator getMessageCreator() {
        return this.messageCreator;
    }

    public SelectedRecipientList getSelectedRecipientList() {
        return this.selectedRecipientList;
    }

    public SendMessageController getSendMessageController() {
        return this.sendMessageController;
    }

    public SaveDraftController getSaveDraftController() {
        return this.saveDraftController;
    }

    public SaveTemplateController getSaveTemplateController() {
        return this.saveTemplateController;
    }

    public DeleteTemplateController getDeleteTemplateController() {
        return this.deleteTemplateController;
    }

    public void recipientCountChanged(int n) {
        this.log.log(-2137614336, "[NewMessage#recipientCountChanged] selectedRecipientList.isEmpty() = %1, removeIndex = %2", this.selectedRecipientList.isEmpty(), (long)n);
        this.setSendButtonActivation();
        this.setDirtyBit();
        this.contentChanged();
        if (!this.isDictationDialogActive()) {
            if (n == -1) {
                this.autoPositionCursor();
            } else if (n == 0) {
                this.setCursorPosition(0);
            } else if (n > 0) {
                int n2 = n - 1;
                RecipientListRow recipientListRow = this.selectedRecipientList.getRow(n2);
                if (recipientListRow == null) {
                    this.log.log(-1601830656, "[SelectedRecipientList#recipientCountChanged] Cannot focus recipient at index = %1", (long)n2);
                } else {
                    this.setCursorPosition(-1, this.selectedRecipientList.getListModel().getID(), recipientListRow.getUniqueID());
                }
            }
        }
    }

    public String getSubject() {
        return this.subjectTextEditor.getText();
    }

    public void setSubject(String string) {
        this.log.log(-2137614336, "[NewMessage#setSubject] subject = %1", (Object)string);
        this.subjectTextEditor.setText(string, -1);
        this.subjectChanged(false);
    }

    public boolean exceedsMaxSubjectLength() {
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(1569923328);
        return choiceModelApp.getValue() == 1;
    }

    public boolean exceedsMaxBodyLength() {
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(-829284096);
        return choiceModelApp.getValue() == 1;
    }

    public String getBody() {
        return this.bodyTextEditor.getText();
    }

    public String getTruncatedSubject() {
        String string = this.getSubject();
        if (this.exceedsMaxSubjectLength()) {
            string = string.substring(0, 255);
        }
        return string;
    }

    public String getTruncatedBody() {
        return this.getTruncatedBody(0);
    }

    public String getTruncatedBody(int n) {
        String string = this.getBody();
        if (this.exceedsMaxBodyLength()) {
            boolean bl = this.msgApp.getAccountManager().isEmailMode();
            int n2 = bl ? 8192 : 700;
            string = string.substring(0, n2 - n);
        }
        return string;
    }

    public void setBody(String string) {
        this.setBody(string, -1);
    }

    public void setBody(String string, int n) {
        this.log.log(-2137614336, "[NewMessage#setBody]");
        this.bodyTextEditor.setText(string, n);
        this.bodyChanged(false);
    }

    public LinkedList getBodyByList() {
        return this.framework.getHMIService().getTextEditorModel(153).getText();
    }

    public AttachmentInformation[] getAttachments() {
        return this.attachments;
    }

    private String addSubjectPrefix(String string, String string2) {
        return new StringBuffer().append(string2).append(" ").append(string).toString();
    }

    public void subjectChanged(boolean bl) {
        this.framework.getHMIService().getLabelModel(1267933440).setText(this.getSubject());
        this.setDirtyBit();
        this.contentChanged();
        this.signalSubjectLength();
        if (!bl && !this.isDictationDialogActive()) {
            this.autoPositionCursor();
        }
    }

    public void bodyChanged(boolean bl) {
        this.framework.getHMIService().getLabelModel(-1936580352).setText(this.getBody());
        this.setSendButtonActivation();
        this.setDirtyBit();
        this.contentChanged();
        this.signalBodyLength();
        if (!bl && !this.isDictationDialogActive()) {
            this.autoPositionCursor();
        }
    }

    private void subjectEditorTextChanged() {
        this.log.log(1078071040, "[NewMessage#subjectEditorTextChanged]");
        this.subjectChanged(true);
    }

    private void bodyEditorTextChanged() {
        this.log.log(1078071040, "[NewMessage#bodyEditorTextChanged]");
        this.bodyChanged(true);
    }

    public void indicateDraftSaved(Message message, String string) {
        this.hmiMessageId = this.getHmiMessageId();
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[NewMessage#indicateDraftSaved] getHmiMessageId() = %1, message.getHmiMessageId() = %2, draftId = %3", (Object)String.valueOf(this.hmiMessageId), (Object)String.valueOf(message.getHmiMessageId()), (Object)String.valueOf(string));
        }
        if (this.hmiMessageId == message.getHmiMessageId()) {
            this.setDraftId(string);
        }
    }

    public void indicateMessageDownload() {
        this.log.log(-2137614336, "[NewMessage#indicateMessageDownload]");
        boolean bl = this.getAttachments() != null && this.getAttachments().length > 0;
        String string = this.msgApp.getTextLookup().getAttachmentsDiscardedHint();
        if (!Strings.isNullOrEmpty(string) && bl) {
            this.log.log(1078071040, "[NewMessage#indicateMessageDownload] attachments available -> add text");
            DoubleCursor doubleCursor = this.bodyTextEditor.getCursor();
            doubleCursor.setCursorMode(1);
            doubleCursor.setCursorPos(-1);
            doubleCursor.insertWord(string);
        }
        this.setAttachments(null);
    }

    private boolean isDictationDialogActive() {
        return this.isDictationDialogActive;
    }

    private void setDictationDialogActive(boolean bl) {
        this.log.log(-2137614336, "[NewMessage#setDictationDialogActive] isDictationDialogActive = %1", bl);
        boolean bl2 = this.isDictationDialogActive() && !bl;
        this.isDictationDialogActive = bl;
        if (bl2) {
            this.autoPositionCursor();
        }
    }

    public void addObserver(INewMessageObserver iNewMessageObserver) {
        this.log.log(-2137614336, "[NewMessage#addObserver] observer = %1", (Object)iNewMessageObserver);
        this.newMessageObservers.add(iNewMessageObserver);
    }

    private void emitMessageCleared() {
        this.log.log(-2137614336, "[NewMessage#emitMessageCleared]");
        Iterator iterator = this.newMessageObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((INewMessageObserver)iterator.next()).messageCleared();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[NewMessage#emitMessageCleared]");
            }
        }
    }

    private void emitIndicateMessageLength(int n, int n2) {
        this.log.log(-2137614336, "[NewMessage#emitIndicateMessageLength]");
        Iterator iterator = this.newMessageObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((INewMessageObserver)iterator.next()).indicateMessageLength(n, n2);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[NewMessage#emitIndicateMessageLength]");
            }
        }
    }

    public void setIsAutoPositionCursorNeeded(boolean bl) {
        this.isAutoPositionCursorNeeded = bl;
    }

    public void resetIsAutoPositionCursorNeeded() {
        this.setIsAutoPositionCursorNeeded(true);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new NewMessage$DiagPlugIn(this)};
    }

    static /* synthetic */ LogChannel access$400(NewMessage newMessage) {
        return newMessage.log;
    }

    static /* synthetic */ IFrameworkAccess access$500(NewMessage newMessage) {
        return newMessage.framework;
    }

    static /* synthetic */ void access$600(NewMessage newMessage) {
        newMessage.subjectEditorTextChanged();
    }

    static /* synthetic */ void access$700(NewMessage newMessage) {
        newMessage.bodyEditorTextChanged();
    }

    static /* synthetic */ LogChannel access$800(NewMessage newMessage) {
        return newMessage.log;
    }

    static /* synthetic */ LogChannel access$900(NewMessage newMessage) {
        return newMessage.log;
    }

    static /* synthetic */ void access$1000(NewMessage newMessage, boolean bl) {
        newMessage.setDictationDialogActive(bl);
    }

    static /* synthetic */ LogChannel access$1100(NewMessage newMessage) {
        return newMessage.log;
    }

    static /* synthetic */ String access$1200(NewMessage newMessage) {
        return newMessage.getDraftId();
    }

    static /* synthetic */ LogChannel access$1300(NewMessage newMessage) {
        return newMessage.log;
    }

    static /* synthetic */ void access$1400(NewMessage newMessage, String string) {
        newMessage.setDraftId(string);
    }

    static /* synthetic */ TextEditorModelDDApp access$1500(NewMessage newMessage) {
        return newMessage.bodyTextEditor;
    }

    static {
        DEFAULT_SEND_VALIDATOR = new NewMessage$1();
    }
}

