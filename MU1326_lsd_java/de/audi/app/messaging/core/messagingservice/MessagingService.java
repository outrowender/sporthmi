/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.messagingservice.MessagingServiceDiagPlugIn
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.accounts.PrimaryPhoneAccountFilter;
import de.audi.app.messaging.core.addressbook.GetEntryCommand;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.messagingservice.AdbHmiAppServiceDefaultListener;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Classes;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;
import de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.mib.swdiagnosis.msg.core.messagingservice.MessagingServiceDiagPlugIn;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.organizer.AdbEntry;

public final class MessagingService
extends AbstractMessagingComponent
implements IMessagingComponent,
IMessagingService,
ADBHMIAppServiceListener,
SpeedThresholdListener,
IDiagProvider,
IDeviceRoleObserver {
    private final ChoiceModelApp syncModel;
    private final AdbHmiAppServiceDefaultListener adbHmiAppServiceDefaultListener;
    private IAccountFilter lastAddedFilter = null;
    private DeviceRoleInfo primaryDevice;
    private volatile ICommandResponseSupplier commandResponseSupplier;
    private final CopyOnWriteArrayList speedThresholdListeners = new CopyOnWriteArrayList();
    private volatile boolean messagingThresholdExceeded = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver;

    public MessagingService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.syncModel = this.framework.getHMIService().getChoiceModel(2200159);
        this.adbHmiAppServiceDefaultListener = new AdbHmiAppServiceDefaultListener(messagingBundleContext);
        this.addComponent(this.adbHmiAppServiceDefaultListener);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        this.framework.getSysApp().registerSpeedThresholdListener(this, 11);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public void dispose() {
        super.dispose();
        this.framework.getSysApp().unregisterSpeedThresholdListener(this);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$interapp$IMessagingService == null ? (class$de$audi$atip$interapp$IMessagingService = MessagingService.class$("de.audi.atip.interapp.IMessagingService")) : class$de$audi$atip$interapp$IMessagingService).getName(), (Object)this, ServiceProperties.createServiceProperties());
        iServiceRegistry.registerService((class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver == null ? (class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver = MessagingService.class$("de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver")) : class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver).getName(), (Object)this, ServiceProperties.createServiceProperties());
    }

    public void addSpeedThresholdListener(SpeedThresholdListener speedThresholdListener) {
        this.log.log(10000000, "[MessagingService#addSpeedThresholdListener] speedThresholdListener = %1", (Object)speedThresholdListener);
        this.speedThresholdListeners.add(speedThresholdListener);
        this.sendLastThresholdStateToListener(speedThresholdListener, this.messagingThresholdExceeded);
    }

    private void sendLastThresholdStateToListener(SpeedThresholdListener speedThresholdListener, boolean bl) {
        this.log.log(1000000, "[MessagingService#sendLastThresholdStateToListener] speedThresholdExceeded=", bl);
        if (bl) {
            speedThresholdListener.exceedsUpperThreshold(11);
        } else {
            speedThresholdListener.belowLowerThreshold(11);
        }
    }

    public AdbHmiAppServiceDefaultListener getAdbHmiAppServiceDefaultListener() {
        return this.adbHmiAppServiceDefaultListener;
    }

    private void selectSuitableAccount(int n) {
        int n2;
        this.log.log(10000000, "[MessagingService#selectSuitableAccount] msgType = %1", (long)n);
        AccountList accountList = this.msgApp.getAccountManager().getDialogAccountList();
        if (this.lastAddedFilter != null) {
            accountList.removeAccountFilter(this.lastAddedFilter);
            this.log.log(10000000, "[MessagingService#selectSuitableAccount] old filter has been removed for the case the last try failed");
        }
        PrimaryPhoneAccountFilter primaryPhoneAccountFilter = new PrimaryPhoneAccountFilter(this.primaryDevice, this.log);
        accountList.addAccountFilter(primaryPhoneAccountFilter);
        this.lastAddedFilter = primaryPhoneAccountFilter;
        this.log.log(10000000, "[MessagingService#selectSuitableAccount] new filter has been added");
        boolean bl = n == 0;
        int n3 = n2 = bl ? 1 : 2;
        if (this.isAutoSelectNecessary(n2)) {
            accountList.selectFirstAccount(n2);
        }
        accountList.removeAccountFilter(primaryPhoneAccountFilter);
        this.log.log(10000000, "[MessagingService#selectSuitableAccount] old filter has been removed");
    }

    private boolean isAutoSelectNecessary(int n) {
        boolean bl = !this.msgApp.getAccountManager().isAccTypeSelected(n);
        boolean bl2 = false;
        this.log.log(10000000, "[MessagingService#isAutoSelectNecessary] current autoSelectNecessary=%1, accountType=%2", bl, (long)n);
        if (this.primaryDevice != null) {
            if (this.primaryDevice.isSimDevice()) {
                this.log.log(10000000, "[MessagingService#isAutoSelectNecessary] PrimaryDevice is SIM Card");
                bl2 = this.msgApp.getAccountManager().getSelectedAccount() != null && this.msgApp.getAccountManager().getSelectedAccount().getSimCardId() != null && this.msgApp.getAccountManager().getSelectedAccount().getSimCardId().equalsIgnoreCase(this.primaryDevice.getSimCardId());
            } else {
                this.log.log(10000000, "[MessagingService#isAutoSelectNecessary] PrimaryDevice is BT Device");
                bl2 = this.msgApp.getAccountManager().getSelectedAccount() != null && this.msgApp.getAccountManager().getSelectedAccount().getBtDeviceAddress() != null && this.msgApp.getAccountManager().getSelectedAccount().getBtDeviceAddress().equalsIgnoreCase(this.primaryDevice.getBtDeviceAddress());
            }
        }
        this.log.log(10000000, "[MessagingService#isAutoSelectNecessary] is autoSelect necessary? %1", (Object)(bl || !bl2 ? "true" : "false"));
        return bl || !bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void handleCommandResult(int n, AdbEntry adbEntry, int n2, int n3) {
        int n4 = 2;
        try {
            if (n == 0) {
                this.log.log(10000000, "MessagingService#handleCommandResult(): got entry: %1, dataIndex: %2", (Object)ADBDbgUtils.dbg(adbEntry), (long)n2);
                this.selectSuitableAccount(n3);
                this.msgApp.getMessagingAdbHandler().setCurrentEntry(adbEntry);
                this.msgApp.getNewMessage().clear();
                this.msgApp.getMessagingAdbHandler().getModelUpdater().updateRecipientSelection(adbEntry, n2, n3);
                n4 = 1;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[MessagingService#handleCommandResult]");
        }
        finally {
            this.syncModel.setStatus(n4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void handleAttachResultVCardCommand(int n, AdbEntry adbEntry, int n2, String string) {
        int n3 = 2;
        try {
            if (n == 0) {
                this.log.log(1000000, "[MessagingService#composeMsgAttachVCard] msgType = %1, vCardPath = %2, contactName = %3", (Object)String.valueOf(n2), (Object)string, (Object)adbEntry.getCombinedName());
                this.selectSuitableAccount(n2);
                AttachmentInformation attachmentInformation = new AttachmentInformation(0, adbEntry.getCombinedName(), "text/x-vcard", 0, 0, new ResourceLocator(string));
                NewMessage newMessage = this.msgApp.getNewMessage();
                newMessage.clear();
                newMessage.setAttachments(new AttachmentInformation[]{attachmentInformation});
                n3 = 1;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[MessagingService#handleAttachVCardCommandResult]");
        }
        finally {
            this.syncModel.setStatus(n3);
        }
    }

    public void composeMsgPresetRecipient(int n, long l, int n2) {
        this.composeMsgPresetRecipient(n, l, n2, 0);
    }

    public void composeMsgPresetRecipient(final int n, long l, final int n2, int n3) {
        this.log.log(10000000, "[MessagingService#composeMsgPresetRecipient] msgType = %1, recipientEntryId = %2, dataIndex = %3", (long)n, l, (long)n2);
        GetEntryCommand.ResultHandler resultHandler = new GetEntryCommand.ResultHandler(){

            public void handleResult(int n3, AdbEntry adbEntry) {
                MessagingService.this.handleCommandResult(n3, adbEntry, n2, n);
            }
        };
        this.syncModel.setStatus(0);
        GetEntryCommand.schedule(this.msgApp.getMessagingAdbHandler(), l, resultHandler, n3);
    }

    public void composeMsgPresetRecipient(int n, String string) {
        this.log.log(10000000, "[MessagingService#composeMsgPresetRecipient] msgType = %2, address = %1", (Object)string, (long)n);
        this.selectSuitableAccount(n);
        this.msgApp.getNewMessage().clear();
        this.msgApp.getMessagingAdbHandler().getModelUpdater().updateRecipientSelection(n, string);
    }

    public void composeMsgAttachVCard(final int n, final String string, long l) {
        this.log.log(10000000, "[MessagingService#composeMsgAttachVCard] msgType = %1", (long)n);
        this.msgApp.getNewMessage().clear();
        GetEntryCommand.ResultHandler resultHandler = new GetEntryCommand.ResultHandler(){

            public void handleResult(int n2, AdbEntry adbEntry) {
                MessagingService.this.handleAttachResultVCardCommand(n2, adbEntry, n, string);
            }
        };
        this.syncModel.setStatus(0);
        GetEntryCommand.schedule(this.msgApp.getMessagingAdbHandler(), l, resultHandler);
    }

    public void responseParseVCards(final int n, final AdbEntry[] adbEntryArray) {
        this.log.log(1000000, "[MessagingService#responseParseVCards] success = %2, entries = %1", (Object)ADBDbgUtils.dbg(adbEntryArray), (long)n);
        CommandResponse commandResponse = new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ADBHMIAppServiceListener aDBHMIAppServiceListener = (ADBHMIAppServiceListener)((Object)dSIListener);
                aDBHMIAppServiceListener.responseParseVCards(n, adbEntryArray);
            }
        };
        CommandResponse.executeTryCatch(this.commandResponseSupplier, commandResponse, "responseParseVCards");
    }

    public void responseInsertEntry(final int n) {
        CommandResponse commandResponse = new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ADBHMIAppServiceListener aDBHMIAppServiceListener = (ADBHMIAppServiceListener)((Object)dSIListener);
                aDBHMIAppServiceListener.responseInsertEntry(n);
            }
        };
        CommandResponse.executeTryCatch(this.commandResponseSupplier, commandResponse, "responseInsertEntry");
    }

    private ICommandResponseSupplier createCommandResponseSupplier() {
        return new ICommandResponseSupplier(){
            private final CommandListManager cmdListManager;
            private final LogChannel logChannel;
            private final String handlerName;
            {
                this.cmdListManager = MessagingService.this.msgApp.getExecutorManager().getCommandListManager();
                this.logChannel = this.cmdListManager.getLogChannel();
                this.handlerName = Classes.getShortClassName(MessagingService.this.getClass());
            }

            public DSIListener getDSIDefaultHandler() {
                return MessagingService.this.adbHmiAppServiceDefaultListener;
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

    private void emitExceedsUpperThreshold(int n) {
        this.log.log(10000000, "[MessagingService#emitExceedsUpperThreshold] thresholdId = %1", (long)n);
        Iterator iterator = this.speedThresholdListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpeedThresholdListener)iterator.next()).exceedsUpperThreshold(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[MessagingService#emitExceedsUpperThreshold]");
            }
        }
    }

    private void emitBelowLowerThreshold(int n) {
        this.log.log(10000000, "[MessagingService#belowLowerThreshold] thresholdId = %1", (long)n);
        Iterator iterator = this.speedThresholdListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpeedThresholdListener)iterator.next()).belowLowerThreshold(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[MessagingService#belowLowerThreshold]");
            }
        }
    }

    public void exceedsUpperThreshold(int n) {
        if (n == 11) {
            this.log.log(1000000, "[MessagingService#exceedsUpperThreshold]");
            this.messagingThresholdExceeded = true;
            this.framework.getHmiServiceApp().getChoiceModel(2200237).setValue(1);
            this.emitExceedsUpperThreshold(n);
        }
    }

    public void belowLowerThreshold(int n) {
        if (n == 11) {
            this.log.log(1000000, "[MessagingService#belowLowerThreshold]");
            this.messagingThresholdExceeded = false;
            this.framework.getHmiServiceApp().getChoiceModel(2200237).setValue(0);
            this.emitBelowLowerThreshold(n);
        }
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new MessagingServiceDiagPlugIn(this)};
    }

    public void updateDeviceRoleInfo(DeviceRoleInfo deviceRoleInfo) {
        this.log.log(1000000, "[MessagingService#updateDeviceRoleInfo] primaryDevice = %1", (Object)deviceRoleInfo);
        this.primaryDevice = deviceRoleInfo;
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

