/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.attachments.AttachmentUtil;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Times;
import de.audi.app.messaging.core.viewmessage.ConcatenatedSMS;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$1;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$CoreActionProxy;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$DiagPlugIn;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$EntryListObserver;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$MyDsiMessagingListener;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$MyMsgListener;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$NewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.viewmessage.SetMessageReadStatusCommand;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.Coding;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;

public final class SelectedMessage
extends AbstractMessagingComponent
implements IDiagProvider {
    private static final int MESSAGE_DOWNLOAD_RESULT_OK;
    private static final int MESSAGE_DOWNLOAD_RESULT_ERROR_GENERAL;
    private static final int MESSAGE_DOWNLOAD_RESULT_ERROR_ATTACHMENTS_INCOMPLETE;
    private volatile MessageListEntry messageListEntry;
    private volatile MessageDetails messageDetails;
    private volatile boolean isInDetailView = false;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public SelectedMessage(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        Coding coding = this.framework.getSysConstManager().getCarCoding();
        int n = coding.isScrollingActivated() ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(-258858752).setValue(n);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getEntryList().addObserver(new SelectedMessage$EntryListObserver(this, null));
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new SelectedMessage$NewMessageIndicationManagerObserver(this, null));
        abstractMsgApplication.getActionProxyService().addSubscriber(new SelectedMessage$CoreActionProxy(this, null));
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new SelectedMessage$MyDsiMessagingListener(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SelectedMessage.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new SelectedMessage$MyMsgListener(this, null), ServiceProperties.createServiceProperties());
    }

    public MessageListEntry getMessageListEntry() {
        return this.messageListEntry;
    }

    private void setMessageListEntry(MessageListEntry messageListEntry) {
        this.messageListEntry = messageListEntry;
        if (messageListEntry != null) {
            this.setSubtitle(messageListEntry);
            this.updateHeaderList(messageListEntry);
            this.msgApp.getMessageOptionsManager().setSelectedMessageListEntry(messageListEntry);
        }
    }

    public MessageDetails getMessageDetails() {
        return this.messageDetails;
    }

    private void setMessageDetails(MessageDetails messageDetails) {
        this.log.log(-2137614336, "[SelectedMessage#setMessageDetails]");
        this.messageDetails = this.merge(messageDetails, this.getMessageListEntry());
        this.setSubject(this.getMessageDetails());
        String string = this.getMessageDetails() == null ? "" : ConcatenatedSMS.checkEllipsis(this.getMessageDetails(), this.log);
        this.framework.getHmiServiceApp().getLabelModel(-1265491712).setText(string);
        this.msgApp.getMessageOptionsManager().setSelectedMessageDetails(this.getMessageDetails());
    }

    private MessageDetails merge(MessageDetails messageDetails, MessageListEntry messageListEntry) {
        this.log.log(-2137614336, "[SelectedMessage#merge]");
        MessageDetails messageDetails2 = messageDetails;
        if (messageDetails != null && messageListEntry != null && messageDetails.getMessageID().equals(messageListEntry.getMessageID())) {
            boolean bl;
            long l = messageDetails.getDateTime();
            long l2 = messageListEntry.getDateTime();
            boolean bl2 = bl = !Times.isTimeStampValid(l) && Times.isTimeStampValid(l2);
            if (bl) {
                this.log.log(1078071040, "[SelectedMessage#merge] Merging time stamp of list item into message details descriptor: %1", l2);
                messageDetails2 = new MessageDetails(messageDetails.getMessagingAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), l2, messageDetails.getMessageStatus(), messageDetails.getReplyTo(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
            }
        }
        return messageDetails2;
    }

    public boolean isInDetailView() {
        return this.isInDetailView;
    }

    public void clear() {
        this.log.log(1078071040, "[SelectedMessage#clear]");
        this.setMessage(null, null);
    }

    public void requestSetMessage(MessageListEntry messageListEntry, int n, SelectedMessage$ISetMessageResultHandler selectedMessage$ISetMessageResultHandler) {
        try {
            String string;
            if (messageListEntry == null) {
                this.log.log(10000, "[SelectedMessage#requestSetMessage] messageListEntry is NULL!!");
                return;
            }
            MessageListEntry messageListEntry2 = this.getMessageListEntry();
            MessageDetails messageDetails = this.getMessageDetails();
            String string2 = messageListEntry.getMessageID();
            String string3 = messageListEntry2 != null ? messageListEntry2.getMessageID() : null;
            String string4 = string = messageDetails != null ? messageDetails.getMessageID() : null;
            if (this.log.isInfo()) {
                this.log.log(1078071040, "[SelectedMessage#requestSetMessage] requestedMessageId = %1, attachmentDownloadMode = %2, currentMessageListEntryId = %3, currentMessageDetailsId = %4", (Object)String.valueOf(string2), (Object)String.valueOf(n), (Object)String.valueOf(string3), (Object)String.valueOf(string));
            }
            this.msgApp.getEntryList().setSelectedItemTypeModel(true);
            int n2 = this.isMessageDisplayable(messageListEntry) ? 1 : 0;
            this.framework.getHmiServiceApp().getChoiceModel(1234313472).setValue(n2);
            if (!this.isMessageDisplayable(messageListEntry)) {
                this.setMessage(messageListEntry, null);
                this.emitResponseSetMessage(selectedMessage$ISetMessageResultHandler, true, this.getMessageDetails());
                this.signalMessageContentsReady(1);
            } else {
                this.signalMessageContentsReady(0);
                this.setAttachmentDownloadMode(n);
                MessageListEntry messageListEntry3 = messageListEntry;
                this.msgApp.getMessageOptionsManager().initExtractedItems(messageListEntry3);
                SelectedMessage$1 selectedMessage$1 = new SelectedMessage$1(this, messageListEntry3, selectedMessage$ISetMessageResultHandler);
                new GetMessageContentsCommand(this.msgApp, messageListEntry.getMessagingAccountID(), string2, n, selectedMessage$1).schedule();
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SelectedMessage#requestSetMessage]");
            this.emitResponseSetMessage(selectedMessage$ISetMessageResultHandler, false, this.getMessageDetails());
            this.signalMessageContentsReady(2);
        }
    }

    private void setMessage(MessageListEntry messageListEntry, MessageDetails messageDetails) {
        if (this.log.isInfo()) {
            String string = messageListEntry != null ? messageListEntry.getMessageID() : null;
            this.log.log(1078071040, "[SelectedMessage#setMessage] messageListEntry = %1", (Object)String.valueOf(string));
        }
        this.setMessageListEntry(messageListEntry);
        this.setMessageDetails(messageDetails);
        this.setMessageDeleted(false);
    }

    public void signalMessageContentsReady(int n) {
        this.log.log(1078071040, "[SelectedMessage#signalMessageContentsReady] mediatorState = %1", (long)n);
        this.msgApp.getModelAccess().setWaitSyncChoice(1787961600, n);
    }

    private void handleUpdateMessageCommandResult(boolean bl, MessageDetails messageDetails, int n) {
        this.log.log(-2137614336, "[SelectedMessage#handleUpdateMessageCommandResult]");
        if (bl) {
            this.setMessageDetails(messageDetails);
            if (this.isInDetailView) {
                this.requestSetReadStatus(this.getMessageDetails());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleSetMessageCommandResult(MessageListEntry messageListEntry, boolean bl, MessageDetails messageDetails, int n, SelectedMessage$ISetMessageResultHandler selectedMessage$ISetMessageResultHandler) {
        this.log.log(-2137614336, "[SelectedMessage#handleSetMessageCommandResult]");
        int n2 = 2;
        int n3 = 1;
        try {
            boolean bl2 = false;
            if (bl) {
                this.setMessage(messageListEntry, messageDetails);
                this.requestSetReadStatus(this.getMessageDetails());
                bl2 = true;
                n2 = 1;
                boolean bl3 = messageListEntry != null && messageListEntry.getAttachmentSize() > 0;
                AttachmentInformation[] attachmentInformationArray = this.getMessageDetails() != null ? this.getMessageDetails().getAttachments() : null;
                boolean bl4 = AttachmentUtil.isAttachmentDownloadComplete(bl3, n, attachmentInformationArray);
                n3 = bl4 ? 0 : 2;
            }
            this.emitResponseSetMessage(selectedMessage$ISetMessageResultHandler, bl2, this.getMessageDetails());
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SelectedMessage#handleSetMessageCommandResult]");
            n2 = 2;
            n3 = 1;
        }
        finally {
            this.setMessageDownloadResult(n3);
            this.signalMessageContentsReady(n2);
        }
    }

    private void emitResponseSetMessage(SelectedMessage$ISetMessageResultHandler selectedMessage$ISetMessageResultHandler, boolean bl, MessageDetails messageDetails) {
        if (selectedMessage$ISetMessageResultHandler != null) {
            selectedMessage$ISetMessageResultHandler.responseSetMessage(bl, messageDetails);
        }
    }

    private void setSubject(MessageDetails messageDetails) {
        String string = "";
        if (messageDetails != null) {
            string = messageDetails.getSubject();
        }
        this.log.log(-2137614336, "[SelectedMessage#setSubject] text = %1", (Object)string);
        this.framework.getHmiServiceApp().getLabelModel(-1282203392).setText(string);
    }

    private void setSubtitle(MessageListEntry messageListEntry) {
        String string = "";
        if (messageListEntry != null) {
            string = messageListEntry.getType() == 2 ? messageListEntry.getSubject() : MessageContacts.getPrimaryContactInfo(messageListEntry, this.msgApp.getTextLookup());
        }
        this.log.log(-2137614336, "[SelectedMessage#setSubtitle] subtitleText = %1", (Object)string);
        this.framework.getHmiServiceApp().getLabelModel(1771184384).setText(string);
    }

    private void updateHeaderList(MessageListEntry messageListEntry) {
        if (messageListEntry != null) {
            ListModelApp listModelApp = this.framework.getHmiServiceApp().getListModel(1754407168);
            listModelApp.setMaxColumns(4);
            listModelApp.setMaxRows(1);
            listModelApp.clear();
            long l = messageListEntry.getDateTime();
            long l2 = Times.getCurrentTime(this.framework);
            ListCell[] listCellArray = new ListCell[]{TextListCell.create(MessageContacts.getPrimaryContactInfo(messageListEntry, this.msgApp.getTextLookup())), TextListCell.create(Times.formatMsgTimeStamp(l, l2)), IntegerListCell.create(1), IntegerListCell.create(0)};
            listModelApp.addRow(listCellArray);
        }
    }

    private void requestSetReadStatus(MessageDetails messageDetails) {
        this.log.log(-2137614336, "[SelectedMessage#requestSetReadStatus]");
        new SetMessageReadStatusCommand(this.msgApp, messageDetails.getMessageID(), true).schedule();
    }

    private boolean isMessageDisplayable(MessageListEntry messageListEntry) {
        boolean bl = false;
        if (messageListEntry != null) {
            int n = messageListEntry.getType();
            bl = n == 1 || n == 2;
        }
        return bl;
    }

    private void setAttachmentDownloadMode(int n) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[SelectedMessage#setAttachmentDownloadMode] attachmentDownloadMode = %1", (long)n);
        }
        int n2 = n == 1 ? 1 : (n == 2 ? 2 : 0);
        this.framework.getHmiServiceApp().getChoiceModel(1318265088).setValue(n2);
    }

    private void setMessageDownloadResult(int n) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[SelectedMessage#setMessageDownloadResult] messageDownloadResult = %1", (long)n);
        }
        this.framework.getHmiServiceApp().getChoiceModel(1301487872).setValue(n);
    }

    private void setMessageDeleted(boolean bl) {
        this.log.log(-2137614336, "[SelectedMessage#setMessageDeleted] isMessageDeleted = %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(1553146112).setValue(n);
        if (bl) {
            this.clear();
        }
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new SelectedMessage$DiagPlugIn(this)};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$500(SelectedMessage selectedMessage, MessageListEntry messageListEntry, boolean bl, MessageDetails messageDetails, int n, SelectedMessage$ISetMessageResultHandler selectedMessage$ISetMessageResultHandler) {
        selectedMessage.handleSetMessageCommandResult(messageListEntry, bl, messageDetails, n, selectedMessage$ISetMessageResultHandler);
    }

    static /* synthetic */ LogChannel access$600(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ AbstractMsgApplication access$700(SelectedMessage selectedMessage) {
        return selectedMessage.msgApp;
    }

    static /* synthetic */ LogChannel access$800(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ LogChannel access$900(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ void access$1100(SelectedMessage selectedMessage, boolean bl, MessageDetails messageDetails, int n) {
        selectedMessage.handleUpdateMessageCommandResult(bl, messageDetails, n);
    }

    static /* synthetic */ AbstractMsgApplication access$1200(SelectedMessage selectedMessage) {
        return selectedMessage.msgApp;
    }

    static /* synthetic */ LogChannel access$1300(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ LogChannel access$1400(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ void access$1500(SelectedMessage selectedMessage, boolean bl) {
        selectedMessage.setMessageDeleted(bl);
    }

    static /* synthetic */ LogChannel access$1600(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ boolean access$1702(SelectedMessage selectedMessage, boolean bl) {
        selectedMessage.isInDetailView = bl;
        return selectedMessage.isInDetailView;
    }

    static /* synthetic */ LogChannel access$1800(SelectedMessage selectedMessage) {
        return selectedMessage.log;
    }

    static /* synthetic */ void access$1900(SelectedMessage selectedMessage, MessageListEntry messageListEntry) {
        selectedMessage.updateHeaderList(messageListEntry);
    }
}

