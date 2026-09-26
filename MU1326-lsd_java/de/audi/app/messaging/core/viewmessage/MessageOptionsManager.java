/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.addressbook.GetEntryForMessageOptionsCommand;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.attachments.AttachmentList;
import de.audi.app.messaging.core.callback.CallbackNumberList;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.extracteditems.ExtractInformationCommand;
import de.audi.app.messaging.core.extracteditems.ExtractInformationCommand$ResultHandler;
import de.audi.app.messaging.core.extracteditems.ExtractedMailAddressList;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.viewmessage.IMessageOptionsManagerObserver;
import de.audi.app.messaging.core.viewmessage.IMessagePropertyFactory;
import de.audi.app.messaging.core.viewmessage.IMessagePropertyFactory$NullFactory;
import de.audi.app.messaging.core.viewmessage.MessageOptionsManager$1;
import de.audi.app.messaging.core.viewmessage.MessageOptionsManager$EntryListObserver;
import de.audi.app.messaging.core.viewmessage.RecipientList;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.organizer.AdbEntry;

public final class MessageOptionsManager
extends AbstractMessagingComponent {
    private volatile IMessagePropertyFactory messagePropertyFactory = new IMessagePropertyFactory$NullFactory();
    private volatile MessageListEntry focusedMessageListEntry = null;
    private volatile MessageListEntry selectedMessageListEntry = null;
    private volatile MessageDetails selectedMessageDetails = null;
    private final AttachmentList attachmentList;
    private volatile AdbEntry adbEntry = null;
    private volatile boolean hasExtractedPhoneNumbers = false;
    private volatile boolean hasExtractedEmailAddresses = false;
    private final CopyOnWriteArrayList messageOptionManagerObservers = new CopyOnWriteArrayList();
    private final ExtractInformationCommand$ResultHandler extractInformationResultHandler = new MessageOptionsManager$1(this);

    public MessageOptionsManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.attachmentList = new AttachmentList(messagingBundleContext);
        this.addComponent(this.attachmentList);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getEntryList().addObserver(new MessageOptionsManager$EntryListObserver(this, null));
    }

    public void setMessagePropertyFactory(IMessagePropertyFactory iMessagePropertyFactory) {
        this.log.log(-2137614336, "[MessageOptionsManager#setMessagePropertyFactory] messagePropertyFactory = %1", (Object)iMessagePropertyFactory);
        this.messagePropertyFactory = iMessagePropertyFactory;
    }

    public AdbEntry getAdbEntry() {
        return this.adbEntry;
    }

    public AttachmentList getAttachmentList() {
        return this.attachmentList;
    }

    public void setFocusedMessageListEntry(MessageListEntry messageListEntry) {
        this.log.log(-2137614336, "[MessageOptionsManager#setFocusedMessageListEntry] messageListEntry = %1", (Object)messageListEntry);
        this.focusedMessageListEntry = messageListEntry;
    }

    public MessageListEntry getFocusedMessageListEntry() {
        return this.focusedMessageListEntry;
    }

    public void setSelectedMessageListEntry(MessageListEntry messageListEntry) {
        this.log.log(-2137614336, "[MessageOptionsManager#setSelectedMessageListEntry] messageListEntry = %1", (Object)messageListEntry);
        this.selectedMessageListEntry = messageListEntry;
        this.selectedMessageDetails = null;
        this.adbEntry = null;
        this.msgApp.getMessagingAdbHandler().getModelUpdater().clearNavDestinations();
        this.initCallbackNumbers(messageListEntry);
        this.setRightDrawerOptions();
    }

    public void setSelectedMessageDetails(MessageDetails messageDetails) {
        String string = messageDetails != null ? messageDetails.getMessageID() : String.valueOf(messageDetails);
        this.log.log(-2137614336, "[MessageOptionsManager#setMessageDetails] messageDetails.getMessageID() = %1", (Object)string);
        this.selectedMessageDetails = messageDetails;
        this.setRightDrawerOptions();
        this.initRecipientList(messageDetails);
        this.emitMessageDetailsChanged();
    }

    public void responseGetAdbEntry(AdbEntry adbEntry) {
        this.log.log(-2137614336, "[MessageOptionsManager#responseGetAdbEntry] adbEntry.getEntryId() = %1", adbEntry.getEntryId());
        this.adbEntry = adbEntry;
        this.setRightDrawerOptions();
        this.msgApp.getCallbackNumberList().setContent(adbEntry);
    }

    private void initCallbackNumbers(MessageListEntry messageListEntry) {
        this.log.log(-2137614336, "[ExtractInformationCommand#initCallbackNumbers]");
        if (messageListEntry == null) {
            this.log.log(10000, "[ExtractInformationCommand#initCallbackNumbers] messageListEntry is NULL!!");
            return;
        }
        CallbackNumberList callbackNumberList = this.msgApp.getCallbackNumberList();
        callbackNumberList.clear();
        long l = messageListEntry.getMatchedAddress().getAdbEntryID();
        if (l != 0L) {
            GetEntryForMessageOptionsCommand.schedule(this.msgApp.getMessagingAdbHandler(), l, this.framework.getHmiServiceApp().getModelApp(1603412224));
        } else if (messageListEntry.getType() == 1) {
            String string = messageListEntry.getMatchedAddress().getAddress();
            callbackNumberList.setContent(string);
        }
    }

    public void initExtractedItems(MessageListEntry messageListEntry) {
        this.log.log(-2137614336, "[ExtractInformationCommand#initExtractedItems]");
        if (messageListEntry == null) {
            this.log.log(10000, "[ExtractInformationCommand#initExtractedItems] messageListEntry is NULL!!");
            return;
        }
        ExtractedNumberList extractedNumberList = this.msgApp.getExtractedNumberList();
        extractedNumberList.clear();
        ExtractedMailAddressList extractedMailAddressList = this.msgApp.getExtractedMailAddressList();
        extractedMailAddressList.clear();
        String string = messageListEntry.getMatchedAddress().getAddress();
        if (this.msgApp.getAccountManager().isEmailMode()) {
            extractedMailAddressList.setPrimaryContactAddress(string);
        } else if (!Accounts.supportsSend(this.msgApp.getAccountManager().getSelectedAccount())) {
            extractedNumberList.setPrimaryContactNumber("");
        } else {
            extractedNumberList.setPrimaryContactNumber(string);
        }
        new ExtractInformationCommand(this.msgApp, this.extractInformationResultHandler, messageListEntry.getMessageID()).schedule();
    }

    private void handleExtractInformationResult(int n, ExtractedItem[] extractedItemArray) {
        this.log.log(-2137614336, "[ExtractInformationCommand#handleExtractInformationResult] result = %1", (long)n);
        this.msgApp.getExtractedNumberList().setExtractedItems(extractedItemArray);
        this.msgApp.getExtractedMailAddressList().setExtractedItems(extractedItemArray);
        this.hasExtractedPhoneNumbers = this.msgApp.getExtractedNumberList().getLength() > 0;
        this.hasExtractedEmailAddresses = this.msgApp.getExtractedMailAddressList().getLength() > 0;
    }

    private void initRecipientList(MessageDetails messageDetails) {
        RecipientList recipientList = this.msgApp.getRecipientList();
        recipientList.clear();
        if (messageDetails != null) {
            recipientList.addRecipients(messageDetails.getRecipientsTo(), 1);
            recipientList.addRecipients(messageDetails.getRecipientsCc(), 2);
            recipientList.addRecipients(messageDetails.getRecipientsBcc(), 3);
        }
    }

    private void setRightDrawerOptions() {
        PropertyListCell propertyListCell = this.messagePropertyFactory.create(this.selectedMessageListEntry, this.selectedMessageDetails, this.adbEntry, this.hasExtractedPhoneNumbers, this.hasExtractedEmailAddresses);
        this.log.log(-2137614336, "[MessageOptionsManager#setRightDrawerOptions] Setting properties = %1", (Object)propertyListCell);
        PropertyModelApp propertyModelApp = this.framework.getHmiServiceApp().getPropertyModel(-275635968);
        propertyModelApp.setProperties(propertyListCell.getCategory(), propertyListCell.getProperties());
    }

    public void addListener(IMessageOptionsManagerObserver iMessageOptionsManagerObserver) {
        this.log.log(-2137614336, "[MessageOptionsManager#addListener] listener = %1", (Object)iMessageOptionsManagerObserver);
        this.messageOptionManagerObservers.add(iMessageOptionsManagerObserver);
    }

    private void emitMessageDetailsChanged() {
        Iterator iterator = this.messageOptionManagerObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IMessageOptionsManagerObserver)iterator.next()).messageDetailsChanged();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[MessageOptionsManager#emitMessageDetailsChanged]");
            }
        }
    }

    static /* synthetic */ void access$000(MessageOptionsManager messageOptionsManager, int n, ExtractedItem[] extractedItemArray) {
        messageOptionsManager.handleExtractInformationResult(n, extractedItemArray);
    }

    static /* synthetic */ LogChannel access$200(MessageOptionsManager messageOptionsManager) {
        return messageOptionsManager.log;
    }
}

