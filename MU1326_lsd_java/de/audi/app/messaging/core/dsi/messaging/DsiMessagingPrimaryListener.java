/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.dsi.messaging.DsiMessagingListenerDiagPlugIn
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingDefaultListener;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingMappings;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$10;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$11;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$12;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$13;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$14;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$15;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$16;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$17;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$18;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$19;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$2;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$20;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$21;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$22;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$3;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$4;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$5;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$6;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$7;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$8;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener$9;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Messages;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.msg.core.dsi.messaging.DsiMessagingListenerDiagPlugIn;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public final class DsiMessagingPrimaryListener
extends AbstractMessagingComponent
implements DSIMessagingListener,
IDiagProvider {
    private final DsiMessagingDefaultListener dsiMessagingDefaultListener;
    private volatile ICommandResponseSupplier commandResponseSupplier;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingListener;

    public DsiMessagingPrimaryListener(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.dsiMessagingDefaultListener = new DsiMessagingDefaultListener(messagingBundleContext);
        this.addComponent(this.dsiMessagingDefaultListener);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DsiMessagingPrimaryListener.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this, ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$messaging$DSIMessagingListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingListener = DsiMessagingPrimaryListener.class$("org.dsi.ifc.messaging.DSIMessagingListener")) : class$org$dsi$ifc$messaging$DSIMessagingListener).getName(), 0));
    }

    public void addSubscriber(DSIMessagingListener dSIMessagingListener) {
        this.dsiMessagingDefaultListener.addSubscriber(dSIMessagingListener);
    }

    DsiMessagingDefaultListener getDsiMessagingDefaultListener() {
        return this.dsiMessagingDefaultListener;
    }

    private void executeResponse(String string, CommandResponse commandResponse) {
        CommandResponse.executeTryCatch(this.commandResponseSupplier, commandResponse, string);
    }

    private ICommandResponseSupplier createCommandResponseSupplier() {
        return new DsiMessagingPrimaryListener$1(this);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiMessagingListenerDiagPlugIn((DSIMessagingListener)this)};
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DsiMessagingPrimaryListener#asyncException] errorCode = %1, errorMsg = %2, requestType = %3", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
        this.dsiMessagingDefaultListener.asyncException(n, string, n2);
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#indicateMessageStatus] statusInformation = %1", (Object)String.valueOf(statusInformation));
        this.executeResponse("indicateListChanged", new DsiMessagingPrimaryListener$2(this, statusInformation));
    }

    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#indicateListChanged] information = %1", (Object)String.valueOf(listChangedInformation));
        this.executeResponse("indicateListChanged", new DsiMessagingPrimaryListener$3(this, listChangedInformation));
    }

    @Override
    public void updateSynchInProgress(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#updateSynchInProgress] active = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingDefaultListener.updateSynchInProgress(bl, n);
        }
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiMessagingPrimaryListener#updateMessagingAccounts] accounts = %1, validFlag = %2", (Object)Arrays.toMultiLineString(messagingAccountArray), (long)n);
        }
        if (n == 1) {
            this.dsiMessagingDefaultListener.updateMessagingAccounts(messagingAccountArray, n);
        }
    }

    @Override
    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiMessagingPrimaryListener#indicateNewMessage] newMessage = %1, messageID = %2, messagingAccount = %3, messageType = %4", (Object)String.valueOf(bl), (Object)String.valueOf(string), (Object)String.valueOf(n), (Object)String.valueOf(n2));
        }
        this.dsiMessagingDefaultListener.indicateNewMessage(bl, string, n, n2);
    }

    public void indicateNewMessageOverflow(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#indicateNewMessageOverflow] Not implemented.");
    }

    @Override
    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        ListEntry[] listEntryArray2;
        if (this.log.isInfo()) {
            listEntryArray2 = new Buffer();
            listEntryArray2.append("[DsiMessagingPrimaryListener#listEntriesResponse] ");
            listEntryArray2.append("requestId = ").append(n).append(", ");
            listEntryArray2.append("result = ").append(n2).append(", ");
            listEntryArray2.append("entries.length = ").append(Arrays.getLengthAsString(listEntryArray)).append(", ");
            listEntryArray2.append("accountId = ").append(n3).append(", ");
            listEntryArray2.append("folderId = ").append(n4).append(", ");
            listEntryArray2.append("offset = ").append(n5);
            this.log.log(1078071040, listEntryArray2.toString());
        }
        listEntryArray2 = DsiMessagingMappings.mmsToSms(this.log, listEntryArray);
        this.executeResponse("listEntriesResponse", new DsiMessagingPrimaryListener$4(this, n, n2, listEntryArray2, n3, n4, n5));
    }

    @Override
    public void getPositionOfMessageResponse(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#getPositionOfMessageResponse] result = %1, position = %2", (long)n, (long)n2);
        this.executeResponse("getPositionOfMessageResponse", new DsiMessagingPrimaryListener$5(this, n, n2));
    }

    @Override
    public void changeFolderResponse(FolderEntry folderEntry, int n) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#changeFolderResponse] activeFolder = %1, result = %2", (Object)folderEntry, (long)n);
        this.executeResponse("changeFolderResponse", new DsiMessagingPrimaryListener$6(this, folderEntry, n));
    }

    @Override
    public void deleteMessageResponse(int n, int n2, int n3) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#deleteMessageResponse] result = %1, deleted = %2, num = %3", (long)n, (long)n2, (long)n3);
        this.executeResponse("deleteMessageResponse", new DsiMessagingPrimaryListener$7(this, n, n2, n3));
    }

    @Override
    public void sendMessageResponse(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#sendMessageResponse] result = %1, requestId = %2", (long)n, (long)n2);
        this.executeResponse("sendMessageResponse", new DsiMessagingPrimaryListener$8(this, n, n2));
    }

    @Override
    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
        MessageDetails messageDetails2;
        if (this.log.isInfo()) {
            messageDetails2 = Messages.truncateBody(messageDetails, 128);
            int n2 = messageDetails != null && messageDetails.getBody() != null ? messageDetails.getBody().length() : -1;
            this.log.log(1078071040, "[DsiMessagingPrimaryListener#getMessageContentsResponse] result = %1, truncatedMessageDetails = %2, originalBodyLength = %3", (Object)String.valueOf(n), (Object)String.valueOf(messageDetails2), (Object)String.valueOf(n2));
        }
        messageDetails2 = DsiMessagingMappings.mmsToSms(this.log, messageDetails);
        this.executeResponse("getMessageContentsResponse", new DsiMessagingPrimaryListener$9(this, n, messageDetails2));
    }

    @Override
    public void setMessageReadStatusResponse(int n) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#setMessageReadStatusResponse] result = %1", (long)n);
        this.executeResponse("setMessageReadStatusResponse", new DsiMessagingPrimaryListener$10(this, n));
    }

    @Override
    public void parseVCardResponse(int n, String string) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#parseVCardResponse] result = %2, adbEntry = %1", (Object)String.valueOf(string), (long)n);
        this.executeResponse("parseVCardResponse", new DsiMessagingPrimaryListener$11(this, n, string));
    }

    @Override
    public void saveAsDraftResponse(int n, String string) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#saveAsDraftResponse] result = %1, messageID = %2", (Object)String.valueOf(n), (Object)String.valueOf(string));
        this.executeResponse("saveAsDraftResponse", new DsiMessagingPrimaryListener$12(this, n, string));
    }

    @Override
    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#extractInformationResponse] result = %1, items = %2", (Object)String.valueOf(n), (Object)Arrays.getLengthAsString(extractedItemArray));
        this.executeResponse("extractInformationResponse", new DsiMessagingPrimaryListener$13(this, n, extractedItemArray));
    }

    @Override
    public void changeTemplateResponse(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#changeTemplateResponse] result = %1, templateID = %2", (long)n, (long)n2);
        this.executeResponse("changeTemplateResponse", new DsiMessagingPrimaryListener$14(this, n, n2));
    }

    @Override
    public void getTemplateResponse(int n, Template template) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#getTemplateResponse] result = %2, templateContent = %1", (Object)String.valueOf(template), (long)n);
        this.executeResponse("getTemplateResponse", new DsiMessagingPrimaryListener$15(this, n, template));
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiMessagingPrimaryListener#getTemplatesResponse] result = %1, templates = %2", (Object)String.valueOf(n), (Object)Arrays.toMultiLineString(templateArray));
        }
        this.executeResponse("getTemplatesResponse", new DsiMessagingPrimaryListener$16(this, n, templateArray));
    }

    @Override
    public void deleteTemplateResponse(int n) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#deleteTemplateResponse] result = %1", (long)n);
        this.executeResponse("deleteTemplateResponse", new DsiMessagingPrimaryListener$17(this, n));
    }

    @Override
    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#indicatePushMessageFailed] Not implemented.");
    }

    @Override
    public void indicateFolderInformation(FolderEntry folderEntry) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#indicateFolderInformation] folderEntry = %1", (Object)folderEntry);
        this.executeResponse("indicateFolderInformation", new DsiMessagingPrimaryListener$18(this, folderEntry));
    }

    @Override
    public void getPositionOfFolderResponse(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#getPositionOfFolderResponse] result = %1, position = %2", (long)n, (long)n2);
        this.executeResponse("getPositionOfFolderResponse", new DsiMessagingPrimaryListener$19(this, n, n2));
    }

    @Override
    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("[DsiMessagingPrimaryListener#indicateSendMessage] ");
            buffer.append("result = ").append(Arrays.toString(nArray)).append(", ");
            buffer.append("requestId = ").append(n).append(", ");
            buffer.append("type = ").append(n2).append(", ");
            buffer.append("recipients = ").append(recipientList).append(", ");
            buffer.append("subject = ").append(string).append(", ");
            buffer.append("message = ").append(string2).append(", ");
            buffer.append("attachments = ").append(attachmentInformationArray).append(", ");
            buffer.append("messagingAccountID = ").append(n3);
            this.log.log(1078071040, buffer.toString());
        }
        this.executeResponse("indicateSendMessage", new DsiMessagingPrimaryListener$20(this, nArray, n, n2, recipientList, string, string2, attachmentInformationArray, n3));
    }

    @Override
    public void deleteSimCardMessagesResponse(int n) {
        this.log.log(1078071040, "[DsiMessagingPrimaryListener#deleteSimCardMessagesResponse] result = %1", (long)n);
        this.executeResponse("deleteSimCardMessagesResponse", new DsiMessagingPrimaryListener$21(this, n));
    }

    @Override
    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiMessagingPrimaryListener#decodeAttachmentResponse] result = %1, destLoc = %2", (Object)String.valueOf(n), (Object)String.valueOf(resourceLocator));
        }
        this.executeResponse("decodeAttachmentResponse", new DsiMessagingPrimaryListener$22(this, n, resourceLocator));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ AbstractMsgApplication access$000(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.msgApp;
    }

    static /* synthetic */ DsiMessagingDefaultListener access$100(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.dsiMessagingDefaultListener;
    }

    static /* synthetic */ LogChannel access$200(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$300(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$400(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$500(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$600(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$700(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$800(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$900(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1000(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1100(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1200(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1300(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1400(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1500(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1600(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1700(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1800(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$1900(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$2000(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$2100(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$2200(DsiMessagingPrimaryListener dsiMessagingPrimaryListener) {
        return dsiMessagingPrimaryListener.log;
    }
}

