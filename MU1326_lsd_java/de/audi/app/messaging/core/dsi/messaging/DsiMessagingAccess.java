/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.IDsiAccessClient;
import de.audi.app.messaging.core.dsi.IDsiAccessProvider;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess$2;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess$DiagPlugIn;
import de.audi.app.messaging.core.osgi.DsiDescriptor;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.RecipientList;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class DsiMessagingAccess
extends AbstractMessagingComponent
implements DSIMessaging,
IDsiAccessProvider,
IDiagProvider {
    private volatile DSIMessaging dsiMessaging;
    private final Collection dsiAccessClients = new LinkedList();
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessaging;

    public DsiMessagingAccess(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        try {
            if (this.dsiMessaging != null) {
                this.dsiMessaging.clearNotification(this.msgApp.getDsiMessagingPrimaryListener());
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[DsiMessagingAccess#dispose] An error occurred: ", (Throwable)exception);
        }
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
            iServiceRegistry.startDsiService(new DsiDescriptor((class$org$dsi$ifc$messaging$DSIMessaging == null ? (class$org$dsi$ifc$messaging$DSIMessaging = DsiMessagingAccess.class$("org.dsi.ifc.messaging.DSIMessaging")) : class$org$dsi$ifc$messaging$DSIMessaging).getName(), 0));
        }
        catch (Exception exception) {
            this.log.log(10000, "[DsiMessagingAccess#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private void setDsiMessaging(DSIMessaging dSIMessaging) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new DsiMessagingAccess$1(this, dSIMessaging));
    }

    private void updateDsiAccessClients(boolean bl) {
        IDsiAccessClient[] iDsiAccessClientArray = this.getCurrentDsiAccessClients();
        for (int i2 = 0; i2 < iDsiAccessClientArray.length; ++i2) {
            try {
                iDsiAccessClientArray[i2].updateDsiAvailability(bl);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingAccess#updateDsiAccessClients]");
            }
        }
    }

    private synchronized IDsiAccessClient[] getCurrentDsiAccessClients() {
        Object[] objectArray = new IDsiAccessClient[this.dsiAccessClients.size()];
        this.dsiAccessClients.toArray(objectArray);
        return objectArray;
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$org$dsi$ifc$messaging$DSIMessaging == null ? (class$org$dsi$ifc$messaging$DSIMessaging = DsiMessagingAccess.class$("org.dsi.ifc.messaging.DSIMessaging")) : class$org$dsi$ifc$messaging$DSIMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        DsiMessagingAccess$2 dsiMessagingAccess$2 = new DsiMessagingAccess$2(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)dsiMessagingAccess$2);
    }

    @Override
    public synchronized void addDsiAccessClient(IDsiAccessClient iDsiAccessClient) {
        this.dsiAccessClients.add(iDsiAccessClient);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiMessagingAccess$DiagPlugIn(this)};
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingAccess#setNotification] Not implemented.");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingAccess#setNotification] Not implemented.");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingAccess#setNotification] Not implemented.");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingAccess#clearNotification] Not implemented.");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingAccess#clearNotification] Not implemented.");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingAccess#clearNotification] Not implemented.");
    }

    @Override
    public void changeFolderRequest(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("[DsiMessagingAccess#changeFolderRequest] ");
            buffer.append("folderID = ").append(n).append(", ");
            buffer.append("filter = ").append(n2).append(", ");
            buffer.append("accountID = ").append(n3).append(", ");
            buffer.append("sortCriteria = ").append(n4).append(", ");
            buffer.append("order = ").append(n5);
            this.log.log(1078071040, buffer.toString());
        }
        this.dsiMessaging.changeFolderRequest(n, n2, n3, n4, n5);
    }

    @Override
    public void listEntriesRequest(int n, int n2, int n3) {
        this.log.log(1078071040, "[DsiMessagingAccess#listEntriesRequest] requestId = %1, offset = %2, numItems = %3", (long)n, (long)n2, (long)n3);
        this.dsiMessaging.listEntriesRequest(n, n2, n3);
    }

    @Override
    public void getPositionOfMessageRequest(String string) {
        this.log.log(-1601830656, "[DsiMessagingAccess#getPositionOfMessageRequest] Not implemented.");
    }

    @Override
    public void deleteMessageRequest(String[] stringArray, boolean bl) {
        this.log.log(1078071040, "[DsiMessagingAccess#deleteMessageRequest] messageIDs = %1, deleteList = %2", (Object)Arrays.toString(stringArray), (Object)String.valueOf(bl));
        this.dsiMessaging.deleteMessageRequest(stringArray, bl);
    }

    @Override
    public void sendMessageRequest(int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("[DsiMessagingAccess#sendMessageRequest] ");
            buffer.append("requestId = ").append(n).append(", ");
            buffer.append("type = ").append(n2).append(", ");
            buffer.append("recipients = ").append(recipientList).append(", ");
            buffer.append("subject = ").append(string).append(", ");
            buffer.append("message.length() = ").append(string2 != null ? String.valueOf(string2.length()) : String.valueOf(string2)).append(", ");
            buffer.append("attachments = ").append(Arrays.toString(attachmentInformationArray)).append(", ");
            buffer.append("messagingAccountID = ").append(n3);
            this.log.log(1078071040, buffer.toString());
        }
        this.dsiMessaging.sendMessageRequest(n, n2, recipientList, string, string2, attachmentInformationArray, n3);
    }

    @Override
    public void getMessageContentsRequest(int n, String string, int n2) {
        this.log.log(1078071040, "[DsiMessagingAccess#getMessageContentsRequest] accountId = %1, messageID = %2, download = %3.", (Object)String.valueOf(n), (Object)string, (long)n2);
        this.dsiMessaging.getMessageContentsRequest(n, string, n2);
    }

    @Override
    public void setMessageReadStatusRequest(String string, boolean bl) {
        this.log.log(1078071040, "[DsiMessagingAccess#setMessageReadStatusRequest] messageID = %1, read = %2", (Object)String.valueOf(string), (Object)String.valueOf(bl));
        this.dsiMessaging.setMessageReadStatusRequest(string, bl);
    }

    public void parseVCardRequest(String string, int n) {
        this.log.log(-1601830656, "[DsiMessagingAccess#parseVCardRequest] Not implemented.");
    }

    @Override
    public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        this.log.log(1078071040, "[DsiMessagingAccess#saveAsDraftRequest] messageID = %1, recipients = %2, subject = %3", (Object)String.valueOf(string), (Object)String.valueOf(recipientList), (Object)String.valueOf(string2));
        this.dsiMessaging.saveAsDraftRequest(string, n, recipientList, string2, string3, n2, attachmentInformationArray);
    }

    @Override
    public void extractInformationRequest(String string) {
        this.log.log(1078071040, "[DsiMessagingAccess#extractInformationRequest] messageID = %1", (Object)String.valueOf(string));
        this.dsiMessaging.extractInformationRequest(string);
    }

    @Override
    public void changeTemplateRequest(int n, String string) {
        this.log.log(1078071040, "[DsiMessagingAccess#changeTemplateRequest]");
        this.dsiMessaging.changeTemplateRequest(n, string);
    }

    @Override
    public void getTemplateRequest(int n) {
        this.log.log(-1601830656, "[DsiMessagingAccess#getTemplateRequest] Not implemented.");
    }

    @Override
    public void getTemplatesRequest() {
        this.log.log(1078071040, "[DsiMessagingAccess#getTemplatesRequest]");
        this.dsiMessaging.getTemplatesRequest();
    }

    @Override
    public void deleteTemplateRequest(int[] nArray) {
        this.log.log(1078071040, "[DsiMessagingAccess#deleteTemplateRequest] templateIDs[0] = %1", (Object)String.valueOf(nArray[0]));
        this.dsiMessaging.deleteTemplateRequest(nArray);
    }

    @Override
    public void getPositionOfFolderRequest(int n) {
        this.log.log(-1601830656, "[DsiMessagingAccess#getTemplateRequest] Not implemented.");
    }

    @Override
    public void deleteSimCardMessagesRequest(int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiMessagingAccess#deleteSimCardMessagesRequest] accountID = %1, delFlat = %2", (long)n, (long)n2);
        }
        this.dsiMessaging.deleteSimCardMessagesRequest(n, n2);
    }

    @Override
    public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiMessagingAccess#decodeAttachmentRequest] attachment = %1", (Object)String.valueOf(attachmentInformation));
        }
        this.dsiMessaging.decodeAttachmentRequest(attachmentInformation);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(DsiMessagingAccess dsiMessagingAccess) {
        return dsiMessagingAccess.log;
    }

    static /* synthetic */ DSIMessaging access$102(DsiMessagingAccess dsiMessagingAccess, DSIMessaging dSIMessaging) {
        dsiMessagingAccess.dsiMessaging = dSIMessaging;
        return dsiMessagingAccess.dsiMessaging;
    }

    static /* synthetic */ AbstractMsgApplication access$200(DsiMessagingAccess dsiMessagingAccess) {
        return dsiMessagingAccess.msgApp;
    }

    static /* synthetic */ void access$300(DsiMessagingAccess dsiMessagingAccess, boolean bl) {
        dsiMessagingAccess.updateDsiAccessClients(bl);
    }

    static /* synthetic */ void access$400(DsiMessagingAccess dsiMessagingAccess, DSIMessaging dSIMessaging) {
        dsiMessagingAccess.setDsiMessaging(dSIMessaging);
    }

    static /* synthetic */ AbstractMsgApplication access$500(DsiMessagingAccess dsiMessagingAccess) {
        return dsiMessagingAccess.msgApp;
    }

    static /* synthetic */ LogChannel access$600(DsiMessagingAccess dsiMessagingAccess) {
        return dsiMessagingAccess.log;
    }

    static /* synthetic */ AbstractMsgApplication access$700(DsiMessagingAccess dsiMessagingAccess) {
        return dsiMessagingAccess.msgApp;
    }
}

