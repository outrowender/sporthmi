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
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Classes;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Messages;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.msg.core.dsi.messaging.DsiMessagingListenerDiagPlugIn;
import org.dsi.ifc.base.DSIListener;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

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
        return new ICommandResponseSupplier(){
            private final CommandListManager cmdListManager;
            private final LogChannel logChannel;
            private final String handlerName;
            {
                this.cmdListManager = DsiMessagingPrimaryListener.this.msgApp.getExecutorManager().getCommandListManager();
                this.logChannel = this.cmdListManager.getLogChannel();
                this.handlerName = Classes.getShortClassName(DsiMessagingPrimaryListener.this.getClass());
            }

            public DSIListener getDSIDefaultHandler() {
                return DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
            }

            public CommandList getActiveCommandList() {
                return this.cmdListManager.getActiveCommandList();
            }

            public LogChannel getLogChannel() {
                return this.logChannel;
            }

            public String getHandlerName() {
                return this.handlerName;
            }
        };
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiMessagingListenerDiagPlugIn((DSIMessagingListener)this)};
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DsiMessagingPrimaryListener#asyncException] errorCode = %1, errorMsg = %2, requestType = %3", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
        this.dsiMessagingDefaultListener.asyncException(n, string, n2);
    }

    public void indicateMessageStatus(final StatusInformation statusInformation) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#indicateMessageStatus] statusInformation = %1", (Object)String.valueOf(statusInformation));
        this.executeResponse("indicateListChanged", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#indicateMessageStatus]");
                }
                dSIMessagingListener.indicateMessageStatus(statusInformation);
            }
        });
    }

    public void indicateListChanged(final ListChangedInformation listChangedInformation) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#indicateListChanged] information = %1", (Object)String.valueOf(listChangedInformation));
        this.executeResponse("indicateListChanged", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#indicateListChanged]");
                }
                dSIMessagingListener.indicateListChanged(listChangedInformation);
            }
        });
    }

    public void updateSynchInProgress(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#updateSynchInProgress] active = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingDefaultListener.updateSynchInProgress(bl, n);
        }
    }

    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[DsiMessagingPrimaryListener#updateMessagingAccounts] accounts = %1, validFlag = %2", (Object)Arrays.toMultiLineString(messagingAccountArray), (long)n);
        }
        if (n == 1) {
            this.dsiMessagingDefaultListener.updateMessagingAccounts(messagingAccountArray, n);
        }
    }

    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[DsiMessagingPrimaryListener#indicateNewMessage] newMessage = %1, messageID = %2, messagingAccount = %3, messageType = %4", (Object)String.valueOf(bl), (Object)String.valueOf(string), (Object)String.valueOf(n), (Object)String.valueOf(n2));
        }
        this.dsiMessagingDefaultListener.indicateNewMessage(bl, string, n, n2);
    }

    public void indicateNewMessageOverflow(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#indicateNewMessageOverflow] Not implemented.");
    }

    public void listEntriesResponse(final int n, final int n2, ListEntry[] listEntryArray, final int n3, final int n4, final int n5) {
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
            this.log.log(1000000, listEntryArray2.toString());
        }
        listEntryArray2 = DsiMessagingMappings.mmsToSms(this.log, listEntryArray);
        this.executeResponse("listEntriesResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#listEntriesResponse]");
                }
                dSIMessagingListener.listEntriesResponse(n, n2, listEntryArray2, n3, n4, n5);
            }
        });
    }

    public void getPositionOfMessageResponse(final int n, final int n2) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#getPositionOfMessageResponse] result = %1, position = %2", (long)n, (long)n2);
        this.executeResponse("getPositionOfMessageResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#getPositionOfMessageResponse]");
                }
                dSIMessagingListener.getPositionOfMessageResponse(n, n2);
            }
        });
    }

    public void changeFolderResponse(final FolderEntry folderEntry, final int n) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#changeFolderResponse] activeFolder = %1, result = %2", (Object)folderEntry, (long)n);
        this.executeResponse("changeFolderResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#changeFolderResponse]");
                }
                dSIMessagingListener.changeFolderResponse(folderEntry, n);
            }
        });
    }

    public void deleteMessageResponse(final int n, final int n2, final int n3) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#deleteMessageResponse] result = %1, deleted = %2, num = %3", (long)n, (long)n2, (long)n3);
        this.executeResponse("deleteMessageResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#deleteMessageResponse]");
                }
                dSIMessagingListener.deleteMessageResponse(n, n2, n3);
            }
        });
    }

    public void sendMessageResponse(final int n, final int n2) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#sendMessageResponse] result = %1, requestId = %2", (long)n, (long)n2);
        this.executeResponse("sendMessageResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#sendMessageResponse]");
                }
                dSIMessagingListener.sendMessageResponse(n, n2);
            }
        });
    }

    public void getMessageContentsResponse(final int n, MessageDetails messageDetails) {
        MessageDetails messageDetails2;
        if (this.log.isInfo()) {
            messageDetails2 = Messages.truncateBody(messageDetails, 128);
            int n2 = messageDetails != null && messageDetails.getBody() != null ? messageDetails.getBody().length() : -1;
            this.log.log(1000000, "[DsiMessagingPrimaryListener#getMessageContentsResponse] result = %1, truncatedMessageDetails = %2, originalBodyLength = %3", (Object)String.valueOf(n), (Object)String.valueOf(messageDetails2), (Object)String.valueOf(n2));
        }
        messageDetails2 = DsiMessagingMappings.mmsToSms(this.log, messageDetails);
        this.executeResponse("getMessageContentsResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#getMessageContentsResponse]");
                }
                dSIMessagingListener.getMessageContentsResponse(n, messageDetails2);
            }
        });
    }

    public void setMessageReadStatusResponse(final int n) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#setMessageReadStatusResponse] result = %1", (long)n);
        this.executeResponse("setMessageReadStatusResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#setMessageReadStatusResponse]");
                }
                dSIMessagingListener.setMessageReadStatusResponse(n);
            }
        });
    }

    public void parseVCardResponse(final int n, final String string) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#parseVCardResponse] result = %2, adbEntry = %1", (Object)String.valueOf(string), (long)n);
        this.executeResponse("parseVCardResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#parseVCardResponse]");
                }
                dSIMessagingListener.parseVCardResponse(n, string);
            }
        });
    }

    public void saveAsDraftResponse(final int n, final String string) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#saveAsDraftResponse] result = %1, messageID = %2", (Object)String.valueOf(n), (Object)String.valueOf(string));
        this.executeResponse("saveAsDraftResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#saveAsDraftResponse]");
                }
                dSIMessagingListener.saveAsDraftResponse(n, string);
            }
        });
    }

    public void extractInformationResponse(final int n, final ExtractedItem[] extractedItemArray) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#extractInformationResponse] result = %1, items = %2", (Object)String.valueOf(n), (Object)Arrays.getLengthAsString(extractedItemArray));
        this.executeResponse("extractInformationResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#extractInformationResponse]");
                }
                dSIMessagingListener.extractInformationResponse(n, extractedItemArray);
            }
        });
    }

    public void changeTemplateResponse(final int n, final int n2) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#changeTemplateResponse] result = %1, templateID = %2", (long)n, (long)n2);
        this.executeResponse("changeTemplateResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#changeTemplateResponse]");
                }
                dSIMessagingListener.changeTemplateResponse(n, n2);
            }
        });
    }

    public void getTemplateResponse(final int n, final Template template) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#getTemplateResponse] result = %2, templateContent = %1", (Object)String.valueOf(template), (long)n);
        this.executeResponse("getTemplateResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#getTemplateResponse]");
                }
                dSIMessagingListener.getTemplateResponse(n, template);
            }
        });
    }

    public void getTemplatesResponse(final int n, final Template[] templateArray) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[DsiMessagingPrimaryListener#getTemplatesResponse] result = %1, templates = %2", (Object)String.valueOf(n), (Object)Arrays.toMultiLineString(templateArray));
        }
        this.executeResponse("getTemplatesResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#getTemplatesResponse]");
                }
                dSIMessagingListener.getTemplatesResponse(n, templateArray);
            }
        });
    }

    public void deleteTemplateResponse(final int n) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#deleteTemplateResponse] result = %1", (long)n);
        this.executeResponse("deleteTemplateResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#deleteTemplateResponse]");
                }
                dSIMessagingListener.deleteTemplateResponse(n);
            }
        });
    }

    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#indicatePushMessageFailed] Not implemented.");
    }

    public void indicateFolderInformation(final FolderEntry folderEntry) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#indicateFolderInformation] folderEntry = %1", (Object)folderEntry);
        this.executeResponse("indicateFolderInformation", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#indicateFolderInformation]");
                }
                dSIMessagingListener.indicateFolderInformation(folderEntry);
            }
        });
    }

    public void getPositionOfFolderResponse(final int n, final int n2) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#getPositionOfFolderResponse] result = %1, position = %2", (long)n, (long)n2);
        this.executeResponse("getPositionOfFolderResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#getPositionOfFolderResponse]");
                }
                dSIMessagingListener.getPositionOfFolderResponse(n, n2);
            }
        });
    }

    public void indicateSendMessage(final int[] nArray, final int n, final int n2, final RecipientList recipientList, final String string, final String string2, final AttachmentInformation[] attachmentInformationArray, final int n3) {
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
            this.log.log(1000000, buffer.toString());
        }
        this.executeResponse("indicateSendMessage", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#indicateSendMessage]");
                }
                dSIMessagingListener.indicateSendMessage(nArray, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
            }
        });
    }

    public void deleteSimCardMessagesResponse(final int n) {
        this.log.log(1000000, "[DsiMessagingPrimaryListener#deleteSimCardMessagesResponse] result = %1", (long)n);
        this.executeResponse("deleteSimCardMessagesResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#deleteSimCardMessagesResponse]");
                }
                dSIMessagingListener.deleteSimCardMessagesResponse(n);
            }
        });
    }

    public void decodeAttachmentResponse(final int n, final ResourceLocator resourceLocator) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[DsiMessagingPrimaryListener#decodeAttachmentResponse] result = %1, destLoc = %2", (Object)String.valueOf(n), (Object)String.valueOf(resourceLocator));
        }
        this.executeResponse("decodeAttachmentResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.this.dsiMessagingDefaultListener;
                try {
                    dSIMessagingListener = (DSIMessagingListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingPrimaryListener.this.log, classCastException, "[DsiMessagingPrimaryListener#decodeAttachmentResponse]");
                }
                dSIMessagingListener.decodeAttachmentResponse(n, resourceLocator);
            }
        });
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

