/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.ICompositionValidator;
import de.audi.app.messaging.core.compose.INewMessageObserver;
import de.audi.app.messaging.core.compose.INewMessagePropertyFactory;
import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.compose.SelectedRecipientList;
import de.audi.app.messaging.core.compose.SendMessageController;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.drafts.SaveDraftController;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.recipients.RecipientListRow;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.templates.DeleteTemplateController;
import de.audi.app.messaging.core.templates.SaveTemplateController;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.DefaultTextEditorListenerDD;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.LinkedList;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.StatusInformation;

public final class NewMessage
extends AbstractMessagingComponent
implements IDiagProvider {
    static final int CHAR_LIMIT_SMS = 700;
    static final int CHAR_LIMIT_EMAIL_SUBJECT = 255;
    static final int CHAR_LIMIT_EMAIL_BODY = 8192;
    public static final String MESSAGE_ID_NONE = "";
    private static final ICompositionValidator DEFAULT_SEND_VALIDATOR = new ICompositionValidator(){

        public boolean isValid(NewMessage newMessage) {
            boolean bl = !newMessage.getSelectedRecipientList().isEmpty();
            boolean bl2 = !Strings.isNullOrEmpty(newMessage.getBody());
            boolean bl3 = newMessage.getAttachments().length > 0;
            return bl && (bl2 || bl3);
        }
    };
    private static final int SEND_BUTTON_DISABLED = 0;
    private static final int SEND_BUTTON_ENABLED = 1;
    public static final int MENU_ITEM_RECIPIENTS = 0;
    public static final int MENU_ITEM_SUBJECT = 1;
    public static final int MENU_ITEM_BODY = 2;
    public static final int MENU_ITEM_SEND = 3;
    public static final int MENU_ITEM_ABORT = 4;
    private static final int MENU_ITEM_NONE = -1;
    private static final int LIST_MODEL_ID_NONE = -1;
    private static final int LIST_ROW_ID_NONE = -1;
    private final MessageCreator messageCreator;
    private final SelectedRecipientList selectedRecipientList;
    private final TextEditorModelDDApp subjectTextEditor;
    private final TextEditorModelDDApp bodyTextEditor;
    private final SendMessageController sendMessageController;
    private final SaveDraftController saveDraftController;
    private final SaveTemplateController saveTemplateController;
    private final DeleteTemplateController deleteTemplateController;
    private volatile INewMessagePropertyFactory newMessagePropertyFactory = new INewMessagePropertyFactory.NullFactory();
    private volatile ICompositionValidator sendValidator = DEFAULT_SEND_VALIDATOR;
    private String quotedText = "";
    private AttachmentInformation[] attachments = new AttachmentInformation[0];
    private boolean isBufferClean = true;
    private volatile int changeId = 0;
    private volatile int initialChangeId = 0;
    private volatile int hmiMessageId = 0;
    private String draftId = "";
    private volatile boolean isDictationDialogActive = false;
    private static final int VOICE_DATA_IDLE = 0;
    private int voiceDataProcessingState = 0;
    private CopyOnWriteArrayList newMessageObservers = new CopyOnWriteArrayList();
    private boolean moveOtherRecipientsToCC = false;
    private boolean isAutoPositionCursorNeeded = true;

    public NewMessage(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.subjectTextEditor = this.framework.getHmiServiceApp().getTextEditorModelDD(2200495).getSyncedModel();
        this.bodyTextEditor = this.framework.getHmiServiceApp().getTextEditorModelDD(2200504).getSyncedModel();
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.framework.getHmiServiceApp().getMenuModel(2200369).setListener(new MyMenuModelListener());
        MyTextEditorListenerDD myTextEditorListenerDD = new MyTextEditorListenerDD();
        this.subjectTextEditor.addListener(myTextEditorListenerDD);
        this.bodyTextEditor.addListener(myTextEditorListenerDD);
        MessagingDictationService messagingDictationService = abstractMsgApplication.getMessagingDictationService();
        if (messagingDictationService != null) {
            messagingDictationService.addListener(new MessagingDictationServiceListener());
        }
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public void dispose() {
        super.dispose();
        this.clear();
    }

    public void setPropertyFactory(INewMessagePropertyFactory iNewMessagePropertyFactory) {
        this.log.log(10000000, "[NewMessage#setPropertyFactory] newMessagePropertyFactory = %1", (Object)iNewMessagePropertyFactory);
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
        this.log.log(10000000, "[NewMessage#clear]");
        this.selectedRecipientList.clear(0);
        this.setSubject(MESSAGE_ID_NONE);
        this.setBody(MESSAGE_ID_NONE);
        this.setAttachments(null);
        this.quotedText = MESSAGE_ID_NONE;
        this.setDraftId(MESSAGE_ID_NONE);
        this.setRightDrawerOptions();
        this.setSendButtonActivation();
        this.setDirtyBit();
        this.contentChanged();
        this.beginNewMessage();
        this.setChangeModel(false);
        this.emitMessageCleared();
    }

    private void beginNewMessage() {
        this.log.log(10000000, "[NewMessage#beginNewMessage]");
        this.assignNewHmiMessageId();
        this.setInitialChangeId(this.getChangeId());
    }

    public boolean isBufferClean() {
        return this.isBufferClean;
    }

    public void setCursorPosition(int n) {
        this.log.log(10000000, "[NewMessage#setCursorPosition] menuItem = %1", (long)n);
        this.setCursorPosition(n, -1, -1L);
    }

    private void setCursorPosition(int n, int n2, long l) {
        this.log.log(10000000, "[NewMessage#setCursorPosition] menuItem = %1, listModelId = %2, listRowId = %3", (long)n, (long)n2, l);
        boolean bl = n2 != -1;
        int n3 = bl ? n2 : n;
        long l2 = bl ? l : -1L;
        MenuModelApp menuModelApp = this.framework.getHmiServiceApp().getMenuModel(2200369);
        menuModelApp.setFocusedItem(n3, FocusAdvice.KEEP_POSITION, l2);
    }

    public void setSendButtonActivation() {
        this.log.log(10000000, "[NewMessage#setSendButtonActivation]");
        int n = 0;
        if (this.sendValidator.isValid(this)) {
            n = 1;
        }
        this.framework.getHMIService().getButtonModel(2200231).setStatus(n);
    }

    public boolean isSendButtonEnabled() {
        int n = this.framework.getHMIService().getButtonModel(2200231).getStatus();
        return n == 1;
    }

    private void setDirtyBit() {
        boolean bl;
        boolean bl2 = bl = this.selectedRecipientList.isEmpty() && Strings.isNullOrEmpty(this.getSubject()) && Strings.isNullOrEmpty(this.getBody()) && this.attachments.length == 0;
        if (this.isBufferClean != bl) {
            this.log.log(10000000, "[NewMessage#setDirtyBit] State change: this.isBufferClean = %1", bl);
            this.isBufferClean = bl;
            int n = this.isBufferClean ? 0 : 1;
            this.framework.getHmiServiceApp().getChoiceModel(2200186).setValue(n);
        }
    }

    private void signalSubjectLength() {
        this.log.log(10000000, "[NewMessage#signalSubjectLength]");
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        int n = bl ? 8192 : 700;
        this.framework.getHmiServiceApp().getLabelModel(2200414).setText(String.valueOf(255));
        this.subjectTextEditor.setMaxLength(255);
        int n2 = this.getSubject().length() > 255 ? 1 : 0;
        this.framework.getHMIService().getChoiceModel(2200413).setValue(n2);
        this.emitIndicateMessageLength(255 - this.getSubject().length(), n - this.getBody().length());
    }

    private void signalBodyLength() {
        this.log.log(10000000, "[NewMessage#signalBodyLength]");
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        int n = bl ? 8192 : 700;
        this.framework.getHmiServiceApp().getLabelModel(2200269).setText(String.valueOf(n));
        this.bodyTextEditor.setMaxLength(n);
        int n2 = this.getBody().length() > n ? 1 : 0;
        this.framework.getHMIService().getChoiceModel(2200270).setValue(n2);
        this.emitIndicateMessageLength(255 - this.getSubject().length(), n - this.getBody().length());
    }

    private void setRightDrawerOptions() {
        PropertyListCell propertyListCell = this.newMessagePropertyFactory.create(!this.msgApp.getAccountManager().isEmailMode());
        this.log.log(10000000, "[NewMessage#setRightDrawerOptions] Setting properties = %1", (Object)propertyListCell);
        PropertyModelApp propertyModelApp = this.framework.getHmiServiceApp().getPropertyModel(2200302);
        propertyModelApp.setProperties(propertyListCell.getCategory(), propertyListCell.getProperties());
    }

    private void autoPositionCursor() {
        if (!this.isAutoPositionCursorNeeded) {
            this.log.log(10000000, "[NewMessage#autoPositionCursor] is not needed");
            return;
        }
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        int n = 0;
        n = this.voiceDataProcessingState != 0 ? 4 : (this.selectedRecipientList.isEmpty() ? 0 : (bl && Strings.isNullOrEmpty(this.getSubject()) ? 1 : (Strings.isNullOrEmpty(this.getBody()) && (bl || this.attachments.length <= 0) ? 2 : 3)));
        this.log.log(10000000, "[NewMessage#autoPositionCursor] menuItem = %1", (long)n);
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
        this.log.log(10000000, "[NewMessage#useTemplate]");
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
        this.log.log(10000000, "[NewMessage#insertBodyText]");
        this.bodyTextEditor.insert(string);
        this.bodyChanged(false);
    }

    public void setAttachments(AttachmentInformation[] attachmentInformationArray) {
        String string = MESSAGE_ID_NONE;
        if (attachmentInformationArray == null || attachmentInformationArray.length == 0) {
            this.log.log(10000000, "[NewMessage#setAttachmentInformation] attachments null or empty.");
            this.attachments = new AttachmentInformation[0];
        } else {
            this.log.log(10000000, "[NewMessage#setAttachmentInformation] attachments[0] = %1", (Object)attachmentInformationArray[0]);
            this.attachments = attachmentInformationArray;
            string = attachmentInformationArray[0].getName();
        }
        this.framework.getHMIService().getLabelModel(2200194).setText(string);
        this.setDirtyBit();
        this.contentChanged();
    }

    private int getHmiMessageId() {
        return this.hmiMessageId;
    }

    private void assignNewHmiMessageId() {
        this.log.log(10000000, "[NewMessage#assignNewHmiMessageId] this.hmiMessageId = %1", (long)this.hmiMessageId);
        ++this.hmiMessageId;
    }

    private int getInitialChangeId() {
        return this.initialChangeId;
    }

    public void setInitialChangeId(int n) {
        this.log.log(10000000, "[NewMessage#setInitialChangeId] initialChangeId = %1", (long)n);
        this.initialChangeId = n;
    }

    private int getChangeId() {
        return this.changeId;
    }

    private void contentChanged() {
        ++this.changeId;
        this.setChangeModel(true);
        if (this.log.isDebug()) {
            this.log.log(10000000, "[NewMessage#incrementChangeId] New changeId = %1", (long)this.changeId);
        }
    }

    private void setChangeModel(boolean bl) {
        this.framework.getHmiServiceApp().getChoiceModel(2200489).setValue(bl ? 1 : 0);
    }

    private void setDraftId(String string) {
        this.log.log(10000000, "[NewMessage#setDraftId] draftId = %1", (Object)string);
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
        MatchedAddress matchedAddress = new MatchedAddress(MESSAGE_ID_NONE, MESSAGE_ID_NONE, 0L, null);
        MatchedAddress[] matchedAddressArray = MessageContacts.toArray(this.selectedRecipientList.getRecipientsTo());
        MatchedAddress[] matchedAddressArray2 = MessageContacts.toArray(this.selectedRecipientList.getRecipientsCc());
        MatchedAddress[] matchedAddressArray3 = MessageContacts.toArray(this.selectedRecipientList.getRecipientsBcc());
        String string2 = this.getTruncatedSubject();
        long l = 0L;
        int n3 = 2;
        String string3 = MESSAGE_ID_NONE;
        String string4 = this.getTruncatedBody();
        AttachmentInformation[] attachmentInformationArray = this.getAttachments();
        int n4 = 2;
        int[] nArray = new int[]{};
        int n5 = -1;
        MessageDetails messageDetails = new MessageDetails(n, string, n2, matchedAddress, matchedAddressArray, matchedAddressArray2, matchedAddressArray3, string2, l, n3, string3, string4, attachmentInformationArray, n4, nArray, n5);
        return new Message(this.getHmiMessageId(), this.getInitialChangeId(), this.getChangeId(), messageDetails);
    }

    public void prepareEditMessage(MessageDetails messageDetails) {
        this.log.log(10000000, "[NewMessage#prepareEditMessage]");
        this.clear();
        this.selectedRecipientList.addRecipientsTo(messageDetails.getRecipientsTo());
        this.selectedRecipientList.addRecipientsCc(messageDetails.getRecipientsCc());
        this.selectedRecipientList.addRecipientsBcc(messageDetails.getRecipientsBcc());
        this.setSubject(messageDetails.getSubject());
        this.setBody(messageDetails.getBody());
        this.setAttachments(messageDetails.getAttachments());
        boolean bl = messageDetails.getMessageStatus() == 2;
        this.setDraftId(bl ? messageDetails.getMessageID() : MESSAGE_ID_NONE);
        this.setDirtyBit();
        this.contentChanged();
        this.beginNewMessage();
        this.setChangeModel(false);
    }

    void prepareForwardMessage(MessageDetails messageDetails) {
        this.log.log(10000000, "[NewMessage#prepareForwardMessage]");
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
        this.log.log(10000000, "[NewMessage#prepareReplyToMessage] replyAll = %1", bl);
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
        this.log.log(10000000, "[NewMessage#recipientCountChanged] selectedRecipientList.isEmpty() = %1, removeIndex = %2", this.selectedRecipientList.isEmpty(), (long)n);
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
                    this.log.log(100000, "[SelectedRecipientList#recipientCountChanged] Cannot focus recipient at index = %1", (long)n2);
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
        this.log.log(10000000, "[NewMessage#setSubject] subject = %1", (Object)string);
        this.subjectTextEditor.setText(string, -1);
        this.subjectChanged(false);
    }

    public boolean exceedsMaxSubjectLength() {
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(2200413);
        return choiceModelApp.getValue() == 1;
    }

    public boolean exceedsMaxBodyLength() {
        ChoiceModelApp choiceModelApp = this.framework.getHmiServiceApp().getChoiceModel(2200270);
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
        this.log.log(10000000, "[NewMessage#setBody]");
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
        this.framework.getHMIService().getLabelModel(2200395).setText(this.getSubject());
        this.setDirtyBit();
        this.contentChanged();
        this.signalSubjectLength();
        if (!bl && !this.isDictationDialogActive()) {
            this.autoPositionCursor();
        }
    }

    public void bodyChanged(boolean bl) {
        this.framework.getHMIService().getLabelModel(2200204).setText(this.getBody());
        this.setSendButtonActivation();
        this.setDirtyBit();
        this.contentChanged();
        this.signalBodyLength();
        if (!bl && !this.isDictationDialogActive()) {
            this.autoPositionCursor();
        }
    }

    private void subjectEditorTextChanged() {
        this.log.log(1000000, "[NewMessage#subjectEditorTextChanged]");
        this.subjectChanged(true);
    }

    private void bodyEditorTextChanged() {
        this.log.log(1000000, "[NewMessage#bodyEditorTextChanged]");
        this.bodyChanged(true);
    }

    public void indicateDraftSaved(Message message, String string) {
        this.hmiMessageId = this.getHmiMessageId();
        if (this.log.isDebug()) {
            this.log.log(10000000, "[NewMessage#indicateDraftSaved] getHmiMessageId() = %1, message.getHmiMessageId() = %2, draftId = %3", (Object)String.valueOf(this.hmiMessageId), (Object)String.valueOf(message.getHmiMessageId()), (Object)String.valueOf(string));
        }
        if (this.hmiMessageId == message.getHmiMessageId()) {
            this.setDraftId(string);
        }
    }

    public void indicateMessageDownload() {
        this.log.log(10000000, "[NewMessage#indicateMessageDownload]");
        boolean bl = this.getAttachments() != null && this.getAttachments().length > 0;
        String string = this.msgApp.getTextLookup().getAttachmentsDiscardedHint();
        if (!Strings.isNullOrEmpty(string) && bl) {
            this.log.log(1000000, "[NewMessage#indicateMessageDownload] attachments available -> add text");
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
        this.log.log(10000000, "[NewMessage#setDictationDialogActive] isDictationDialogActive = %1", bl);
        boolean bl2 = this.isDictationDialogActive() && !bl;
        this.isDictationDialogActive = bl;
        if (bl2) {
            this.autoPositionCursor();
        }
    }

    public void addObserver(INewMessageObserver iNewMessageObserver) {
        this.log.log(10000000, "[NewMessage#addObserver] observer = %1", (Object)iNewMessageObserver);
        this.newMessageObservers.add(iNewMessageObserver);
    }

    private void emitMessageCleared() {
        this.log.log(10000000, "[NewMessage#emitMessageCleared]");
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
        this.log.log(10000000, "[NewMessage#emitIndicateMessageLength]");
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

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public void cmdSetBodyExampleText() {
            String[][] stringArray = new String[][]{{"Hallo"}, {".", "!"}, {" "}, {"Stehe", "Schlehe", "Sehe", "Gehe"}, {" "}, {"gerade"}, {" "}, {"im Stau", "am Bau", "genau"}, {"."}, {" "}, {"Komme"}, {" "}, {"sp\u00e4ter", "\u00c4ther"}, {"."}};
            NewMessage.this.bodyTextEditor.setText(stringArray, -1);
            NewMessage.this.bodyChanged(false);
        }

        public void cmdSetBodyByLength(int n) {
            String string = "Hallo! Stehe gerade im Stau. Komme sp\u00e4ter. ";
            Buffer buffer = new Buffer(n);
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append(string.charAt(i2 % string.length()));
            }
            NewMessage.this.bodyTextEditor.setText(buffer.toString(), -1);
            NewMessage.this.bodyChanged(false);
        }
    }

    private class MyMenuModelListener
    implements MenuModelListener {
        private MyMenuModelListener() {
        }

        public void itemFocused(int n, int n2, long l, int n3) {
            NewMessage.this.log.log(1000000, "[NewMessage#itemFocused] menuItemID = %1", (long)n);
            NewMessage.this.framework.getHmiServiceApp().getChoiceModel(2200400).setValue(n);
        }
    }

    private final class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public void indicateMessageStatus(StatusInformation statusInformation) {
            NewMessage.this.log.log(10000000, "[NewMessage#indicateMessageStatus]");
            if (statusInformation.getStatus() == 1) {
                String string = statusInformation.getMessageId();
                if (NewMessage.this.getDraftId().equals(string)) {
                    NewMessage.this.log.log(1000000, "[NewMessage#indicateMessageStatus] The draft this message is backed by has been deleted, clearing cached draft ID.");
                    NewMessage.this.setDraftId(NewMessage.MESSAGE_ID_NONE);
                }
            }
        }
    }

    private class MyTextEditorListenerDD
    extends DefaultTextEditorListenerDD {
        private MyTextEditorListenerDD() {
        }

        public void textChanged(int n, int n2, int n3) {
            if (n == 2200495) {
                NewMessage.this.subjectEditorTextChanged();
            } else if (n == 2200504) {
                NewMessage.this.bodyEditorTextChanged();
            } else {
                NewMessage.this.log.log(10000, "[NewMessage#textChanged] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private final class MessagingDictationServiceListener
    extends IMessagingDictationServiceListener.EmptyImplementation {
        private MessagingDictationServiceListener() {
        }

        public void updateCompositionState(IMessagingDictationService.CompositionState compositionState) {
            NewMessage.this.log.log(10000000, "[NewMessage#updateCompositionState] compositionState.isDialogActive() = %1", compositionState.isDialogActive());
            NewMessage.this.setDictationDialogActive(compositionState.isDialogActive());
        }
    }
}

