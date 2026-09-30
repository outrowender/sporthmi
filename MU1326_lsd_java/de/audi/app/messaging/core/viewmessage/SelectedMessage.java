/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.attachments.AttachmentUtil;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.core.util.Times;
import de.audi.app.messaging.core.viewmessage.ConcatenatedSMS;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand;
import de.audi.app.messaging.core.viewmessage.SetMessageReadStatusCommand;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.sysapp.carcoding.Coding;
import java.util.Set;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.StatusInformation;

public final class SelectedMessage
extends AbstractMessagingComponent
implements IDiagProvider {
    private static final int MESSAGE_DOWNLOAD_RESULT_OK = 0;
    private static final int MESSAGE_DOWNLOAD_RESULT_ERROR_GENERAL = 1;
    private static final int MESSAGE_DOWNLOAD_RESULT_ERROR_ATTACHMENTS_INCOMPLETE = 2;
    private volatile MessageListEntry messageListEntry;
    private volatile MessageDetails messageDetails;
    private volatile boolean isInDetailView = false;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public SelectedMessage(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        Coding coding = this.framework.getSysConstManager().getCarCoding();
        int n = coding.isScrollingActivated() ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200304).setValue(n);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getEntryList().addObserver(new EntryListObserver());
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new NewMessageIndicationManagerObserver());
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SelectedMessage.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new MyMsgListener(), ServiceProperties.createServiceProperties());
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
        this.log.log(10000000, "[SelectedMessage#setMessageDetails]");
        this.messageDetails = this.merge(messageDetails, this.getMessageListEntry());
        this.setSubject(this.getMessageDetails());
        String string = this.getMessageDetails() == null ? "" : ConcatenatedSMS.checkEllipsis(this.getMessageDetails(), this.log);
        this.framework.getHmiServiceApp().getLabelModel(2200244).setText(string);
        this.msgApp.getMessageOptionsManager().setSelectedMessageDetails(this.getMessageDetails());
    }

    private MessageDetails merge(MessageDetails messageDetails, MessageListEntry messageListEntry) {
        this.log.log(10000000, "[SelectedMessage#merge]");
        MessageDetails messageDetails2 = messageDetails;
        if (messageDetails != null && messageListEntry != null && messageDetails.getMessageID().equals(messageListEntry.getMessageID())) {
            boolean bl;
            long l = messageDetails.getDateTime();
            long l2 = messageListEntry.getDateTime();
            boolean bl2 = bl = !Times.isTimeStampValid(l) && Times.isTimeStampValid(l2);
            if (bl) {
                this.log.log(1000000, "[SelectedMessage#merge] Merging time stamp of list item into message details descriptor: %1", l2);
                messageDetails2 = new MessageDetails(messageDetails.getMessagingAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), l2, messageDetails.getMessageStatus(), messageDetails.getReplyTo(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
            }
        }
        return messageDetails2;
    }

    public boolean isInDetailView() {
        return this.isInDetailView;
    }

    public void clear() {
        this.log.log(1000000, "[SelectedMessage#clear]");
        this.setMessage(null, null);
    }

    public void requestSetMessage(MessageListEntry messageListEntry, int n, final ISetMessageResultHandler iSetMessageResultHandler) {
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
                this.log.log(1000000, "[SelectedMessage#requestSetMessage] requestedMessageId = %1, attachmentDownloadMode = %2, currentMessageListEntryId = %3, currentMessageDetailsId = %4", (Object)String.valueOf(string2), (Object)String.valueOf(n), (Object)String.valueOf(string3), (Object)String.valueOf(string));
            }
            this.msgApp.getEntryList().setSelectedItemTypeModel(true);
            int n2 = this.isMessageDisplayable(messageListEntry) ? 1 : 0;
            this.framework.getHmiServiceApp().getChoiceModel(2200137).setValue(n2);
            if (!this.isMessageDisplayable(messageListEntry)) {
                this.setMessage(messageListEntry, null);
                this.emitResponseSetMessage(iSetMessageResultHandler, true, this.getMessageDetails());
                this.signalMessageContentsReady(1);
            } else {
                this.signalMessageContentsReady(0);
                this.setAttachmentDownloadMode(n);
                final MessageListEntry messageListEntry3 = messageListEntry;
                this.msgApp.getMessageOptionsManager().initExtractedItems(messageListEntry3);
                GetMessageContentsCommand.ResultHandler resultHandler = new GetMessageContentsCommand.ResultHandler(){

                    public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
                        SelectedMessage.this.handleSetMessageCommandResult(messageListEntry3, bl, messageDetails, n, iSetMessageResultHandler);
                    }
                };
                new GetMessageContentsCommand(this.msgApp, messageListEntry.getMessagingAccountID(), string2, n, resultHandler).schedule();
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SelectedMessage#requestSetMessage]");
            this.emitResponseSetMessage(iSetMessageResultHandler, false, this.getMessageDetails());
            this.signalMessageContentsReady(2);
        }
    }

    private void setMessage(MessageListEntry messageListEntry, MessageDetails messageDetails) {
        if (this.log.isInfo()) {
            String string = messageListEntry != null ? messageListEntry.getMessageID() : null;
            this.log.log(1000000, "[SelectedMessage#setMessage] messageListEntry = %1", (Object)String.valueOf(string));
        }
        this.setMessageListEntry(messageListEntry);
        this.setMessageDetails(messageDetails);
        this.setMessageDeleted(false);
    }

    public void signalMessageContentsReady(int n) {
        this.log.log(1000000, "[SelectedMessage#signalMessageContentsReady] mediatorState = %1", (long)n);
        this.msgApp.getModelAccess().setWaitSyncChoice(2200170, n);
    }

    private void handleUpdateMessageCommandResult(boolean bl, MessageDetails messageDetails, int n) {
        this.log.log(10000000, "[SelectedMessage#handleUpdateMessageCommandResult]");
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
    private void handleSetMessageCommandResult(MessageListEntry messageListEntry, boolean bl, MessageDetails messageDetails, int n, ISetMessageResultHandler iSetMessageResultHandler) {
        this.log.log(10000000, "[SelectedMessage#handleSetMessageCommandResult]");
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
            this.emitResponseSetMessage(iSetMessageResultHandler, bl2, this.getMessageDetails());
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

    private void emitResponseSetMessage(ISetMessageResultHandler iSetMessageResultHandler, boolean bl, MessageDetails messageDetails) {
        if (iSetMessageResultHandler != null) {
            iSetMessageResultHandler.responseSetMessage(bl, messageDetails);
        }
    }

    private void setSubject(MessageDetails messageDetails) {
        String string = "";
        if (messageDetails != null) {
            string = messageDetails.getSubject();
        }
        this.log.log(10000000, "[SelectedMessage#setSubject] text = %1", (Object)string);
        this.framework.getHmiServiceApp().getLabelModel(2200499).setText(string);
    }

    private void setSubtitle(MessageListEntry messageListEntry) {
        String string = "";
        if (messageListEntry != null) {
            string = messageListEntry.getType() == 2 ? messageListEntry.getSubject() : MessageContacts.getPrimaryContactInfo(messageListEntry, this.msgApp.getTextLookup());
        }
        this.log.log(10000000, "[SelectedMessage#setSubtitle] subtitleText = %1", (Object)string);
        this.framework.getHmiServiceApp().getLabelModel(2200169).setText(string);
    }

    private void updateHeaderList(MessageListEntry messageListEntry) {
        if (messageListEntry != null) {
            ListModelApp listModelApp = this.framework.getHmiServiceApp().getListModel(2200168);
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
        this.log.log(10000000, "[SelectedMessage#requestSetReadStatus]");
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
            this.log.log(10000000, "[SelectedMessage#setAttachmentDownloadMode] attachmentDownloadMode = %1", (long)n);
        }
        int n2 = n == 1 ? 1 : (n == 2 ? 2 : 0);
        this.framework.getHmiServiceApp().getChoiceModel(2200398).setValue(n2);
    }

    private void setMessageDownloadResult(int n) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[SelectedMessage#setMessageDownloadResult] messageDownloadResult = %1", (long)n);
        }
        this.framework.getHmiServiceApp().getChoiceModel(2200397).setValue(n);
    }

    private void setMessageDeleted(boolean bl) {
        this.log.log(10000000, "[SelectedMessage#setMessageDeleted] isMessageDeleted = %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200412).setValue(n);
        if (bl) {
            this.clear();
        }
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public void cmdSetReplyTo(String string) {
            MessageDetails messageDetails = SelectedMessage.this.getMessageDetails();
            if (messageDetails != null) {
                messageDetails.replyTo = Strings.removeNonNumericChars(string);
            }
        }
    }

    private final class MyMsgListener
    implements MsgListener {
        private MyMsgListener() {
        }

        public void processMsg(int n) {
            if (n == 11) {
                SelectedMessage.this.log.log(1000000, "[SelectedMessage#processMsg] message = %1 (UNITS_CHANGED)", (long)n);
                SelectedMessage.this.updateHeaderList(SelectedMessage.this.getMessageListEntry());
            }
        }
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void detailViewTransition(int n, int n2) {
            SelectedMessage.this.log.log(10000000, "[SelectedMessage#detailViewTransition]");
            SelectedMessage.this.isInDetailView = n2 == 0;
        }
    }

    private class EntryListObserver
    extends IEntryListObserver.EmptyImplementation {
        private EntryListObserver() {
        }

        public void indicateItemSelected(ListEntry listEntry, long l) {
            SelectedMessage.this.log.log(10000000, "[SelectedMessage#indicateItemSelected]");
            if (ListEntries.isMessage(listEntry)) {
                SelectedMessage.this.requestSetMessage(listEntry.getMessageListEntry(), 0, null);
            }
        }
    }

    private final class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public void indicateMessageStatus(StatusInformation statusInformation) {
            MessageDetails messageDetails;
            SelectedMessage.this.log.log(10000000, "[SelectedMessage#indicateMessageStatus]");
            if (statusInformation.getStatus() == 1 && (messageDetails = SelectedMessage.this.getMessageDetails()) != null && messageDetails.getMessageID().equals(statusInformation.getMessageId())) {
                SelectedMessage.this.log.log(1000000, "[SelectedMessage#indicateMessageStatus] Selected message deleted, message ID: %1", (Object)messageDetails.getMessageID());
                SelectedMessage.this.setMessageDeleted(true);
            }
        }
    }

    public static interface ISetMessageResultHandler {
        public void responseSetMessage(boolean var1, MessageDetails var2);
    }

    private class NewMessageIndicationManagerObserver
    implements INewMessageIndicationManagerObserver {
        private NewMessageIndicationManagerObserver() {
        }

        public void indicateIndicationStateChanged(int n) {
            if (n == 0 && SelectedMessage.this.getMessageDetails() != null) {
                int n2 = SelectedMessage.this.getMessageDetails().getMessagingAccountID();
                Set set = SelectedMessage.this.msgApp.getNewMessageIndicationManager().getNewMessageIDs(n2);
                String string = SelectedMessage.this.getMessageDetails().getMessageID();
                if (SelectedMessage.this.log.isDebug()) {
                    SelectedMessage.this.log.log(10000000, "[SelectedMessage#indicateIndicationStateChanged]: selectedMessageId = %1; newMessageIds = %2", (Object)string, (Object)Collections.toString(set));
                }
                if (set.contains(string) && SelectedMessage.this.isInDetailView()) {
                    GetMessageContentsCommand.ResultHandler resultHandler = new GetMessageContentsCommand.ResultHandler(){

                        public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
                            SelectedMessage.this.handleUpdateMessageCommandResult(bl, messageDetails, n);
                        }
                    };
                    new GetMessageContentsCommand(SelectedMessage.this.msgApp, n2, string, 0, resultHandler).schedule();
                }
            }
        }
    }
}

