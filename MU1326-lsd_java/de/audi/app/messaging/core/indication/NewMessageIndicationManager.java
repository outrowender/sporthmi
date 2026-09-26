/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.indication;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$1;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$2;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$DiagPlugIn;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$MessageOptionsManagerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager$MyDsiMessagingListener;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.IFormatter;
import de.audi.app.messaging.core.util.Maps;
import de.audi.app.messaging.core.util.Maps$ElementFormatter;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;
import de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.messaging.MessagingAccount;

public final class NewMessageIndicationManager
extends AbstractMessagingComponent
implements IDiagProvider,
IDeviceRoleObserver {
    public static final int ASPECT_NEW_MESSAGES;
    public static final int ASPECT_MEMORY_STATUS;
    public static final int ASPECT_SIM_MEMORY_STATUS;
    private final Collection newMessageIndicationManagerObservers = new LinkedList();
    private boolean memoryDepleted = false;
    private boolean simMemoryDepleted = false;
    private int simMemoryDepletedAccountId = -1;
    private final List mostRecentSmsAccIds = new LinkedList();
    private final List mostRecentEmailAccIds = new LinkedList();
    private final List mostRecentMessageAccIds = new LinkedList();
    private Map newMessageAccounts = new HashMap();
    private DeviceRoleInfo primaryDevice = null;
    private boolean showPrimaryIndicationsOnly = false;
    private final IFormatter newMessageAccountsElementFormatter = new Maps$ElementFormatter(IFormatter.SIMPLE_FORMATTER, new NewMessageIndicationManager$1(this));
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver;

    public NewMessageIndicationManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessageOptionsManager().addListener(new NewMessageIndicationManager$MessageOptionsManagerObserver(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new NewMessageIndicationManager$MyDsiMessagingListener(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver == null ? (class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver = NewMessageIndicationManager.class$("de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver")) : class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver).getName(), (Object)this, ServiceProperties.createServiceProperties());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addObserver(INewMessageIndicationManagerObserver iNewMessageIndicationManagerObserver) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.newMessageIndicationManagerObservers.add(iNewMessageIndicationManagerObserver);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addNewMessageIndication(int n, String string) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (this.log.isInfo()) {
                this.log.log(1078071040, "[NewMessageIndicationManager#addNewMessageIndication] accountId = %1, messageId = %2 ,this = %3", (Object)String.valueOf(n), (Object)string, (Object)this);
            }
            this.setMostRecentMsgAcc(n);
            Set set = (Set)this.newMessageAccounts.get(Util.createInteger(n));
            if (set == null) {
                set = new HashSet();
                this.newMessageAccounts.put(Util.createInteger(n), set);
            }
            set.add(string);
            this.notifyObservers(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearNewMessageIndication(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Set set;
            boolean bl;
            if (this.log.isInfo()) {
                this.log.log(1078071040, "[NewMessageIndicationManager#clearNewMessageIndication] accountId = %1, this = %2", (Object)String.valueOf(n), (Object)this);
            }
            boolean bl2 = bl = null != (set = (Set)this.newMessageAccounts.remove(Util.createInteger(n)));
            if (bl) {
                this.notifyObservers(0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearNewMessageIndication(String string) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (this.log.isInfo()) {
                this.log.log(1078071040, "[NewMessageIndicationManager#clearNewMessageIndication] messageId = %1, this = %2", (Object)string, (Object)this);
            }
            Iterator iterator = this.newMessageAccounts.keySet().iterator();
            while (iterator.hasNext()) {
                int n = (Integer)iterator.next();
                Set set = this.getNewMessageIDs(n);
                if (!set.contains(string)) continue;
                this.clearNewMessageIndication(n);
                break;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMostRecentSmsAccId() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.getFirst(this.mostRecentSmsAccIds);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMostRecentEmailAccId() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.getFirst(this.mostRecentEmailAccIds);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMostRecentMessageAccId() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.getFirst(this.mostRecentMessageAccIds);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getMostRecentSmsAccIds() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return new LinkedList(this.mostRecentSmsAccIds);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getMostRecentEmailAccIds() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return new LinkedList(this.mostRecentEmailAccIds);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getMostRecentMessageAccIds() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return new LinkedList(this.mostRecentMessageAccIds);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean newSmsAvailable() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            boolean bl = false;
            Iterator iterator = this.newMessageAccounts.keySet().iterator();
            while (iterator.hasNext()) {
                int n = (Integer)iterator.next();
                MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n);
                if (messagingAccount == null || !Accounts.supportsSms(messagingAccount)) continue;
                bl = true;
                break;
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean newEmailsAvailable() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            boolean bl = false;
            Iterator iterator = this.newMessageAccounts.keySet().iterator();
            while (iterator.hasNext()) {
                int n = (Integer)iterator.next();
                MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n);
                if (messagingAccount == null || !messagingAccount.isSupportsEMail()) continue;
                bl = true;
                break;
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean newMessagesAvailable() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return !this.newMessageAccounts.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Set getNewMessageAccountSet() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return new HashSet(this.newMessageAccounts.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasNewMessages(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.newMessageAccounts.containsKey(Util.createInteger(n));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Set getNewMessageIDs(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Set set = (Set)this.newMessageAccounts.get(Util.createInteger(n));
            if (set == null) {
                set = java.util.Collections.EMPTY_SET;
            }
            return set;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getNewMessageCount(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.getNewMessageIDs(n).size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getNewMessageCount() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Set set = this.newMessageAccounts.keySet();
            Iterator iterator = set.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                int n2 = (Integer)iterator.next();
                n += this.getNewMessageCount(n2);
            }
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isMemoryDepleted() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.memoryDepleted;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isSimMemoryDepleted() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.simMemoryDepleted;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getSimMemoryDepletedAccountId() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.simMemoryDepletedAccountId;
        }
    }

    private void notifyObservers(int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new NewMessageIndicationManager$2(this, n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setMostRecentMsgAcc(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(-2137614336, "[NewMessageIndicationManager#setMostRecentMsgAcc] accountId = %1", (long)n);
            MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n);
            if (messagingAccount == null) {
                this.log.log(10000, "[NewMessageIndicationManager#setMostRecentMsgAcc] Cannot find account ID %1. Skipping update of account ID cache.");
            } else if (!Accounts.supportsSms(messagingAccount) && !messagingAccount.isSupportsEMail()) {
                this.log.log(10000, "[NewMessageIndicationManager#setMostRecentMsgAcc] Account supports neither SMS nor e-mail. Skipping update of account ID cache.");
            } else {
                this.moveToFront(n, this.mostRecentMessageAccIds);
                if (messagingAccount.isSupportsEMail()) {
                    this.moveToFront(n, this.mostRecentEmailAccIds);
                } else {
                    this.moveToFront(n, this.mostRecentSmsAccIds);
                }
            }
        }
    }

    private void moveToFront(int n, List list) {
        Integer n2 = Util.createInteger(n);
        list.remove(n2);
        list.add(0, n2);
    }

    private int getFirst(List list) {
        int n = -1;
        if (!list.isEmpty()) {
            n = (Integer)list.get(0);
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private INewMessageIndicationManagerObserver[] getCurrentObservers() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Object[] objectArray = new INewMessageIndicationManagerObserver[this.newMessageIndicationManagerObservers.size()];
            objectArray = (INewMessageIndicationManagerObserver[])this.newMessageIndicationManagerObservers.toArray(objectArray);
            return objectArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDeviceRoleInfo(DeviceRoleInfo deviceRoleInfo) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            MessagingAccount[] messagingAccountArray;
            this.log.log(1078071040, "[NewMessageIndicationManager#updateDeviceRoleInfo] primaryDevice = %1", (Object)deviceRoleInfo);
            if (deviceRoleInfo != null && this.primaryDevice != null && !deviceRoleInfo.equals(this.primaryDevice) && (messagingAccountArray = this.msgApp.getAccountManager().getAccounts()) != null) {
                for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                    String string = messagingAccountArray[i2].getSimCardId() == null ? "" : messagingAccountArray[i2].getSimCardId();
                    String string2 = messagingAccountArray[i2].getBtDeviceAddress() == null ? "" : messagingAccountArray[i2].getBtDeviceAddress();
                    boolean bl = string.equalsIgnoreCase(deviceRoleInfo.getSimCardId());
                    boolean bl2 = string2.equalsIgnoreCase(deviceRoleInfo.getBtDeviceAddress());
                    if ((!deviceRoleInfo.isSimDevice() || bl) && (deviceRoleInfo.isSimDevice() || bl2)) continue;
                    this.clearNewMessageIndication(messagingAccountArray[i2].getAccountID());
                }
            }
            this.primaryDevice = deviceRoleInfo;
        }
    }

    public void showPrimaryIndicationsOnly() {
        this.showPrimaryIndicationsOnly = true;
    }

    private boolean isMessageFromPrimaryDevice(MessagingAccount messagingAccount) {
        this.log.log(1078071040, "[NewMessageIndicationManager#isMessageFromPrimaryDevice] account = %1, primaryDevice = %2", (Object)messagingAccount, (Object)this.primaryDevice);
        boolean bl = false;
        if (messagingAccount != null && this.primaryDevice != null) {
            if (this.primaryDevice.isSimDevice()) {
                if (messagingAccount.getSimCardId().equalsIgnoreCase(this.primaryDevice.getSimCardId())) {
                    bl = true;
                    this.log.log(1078071040, "[NewMessageIndicationManager#isMessageFromPrimaryDevice] isMessageFromPrimaryDevice = true ");
                }
            } else if (messagingAccount.getBtDeviceAddress().equalsIgnoreCase(this.primaryDevice.getBtDeviceAddress())) {
                bl = true;
                this.log.log(1078071040, "[NewMessageIndicationManager#isMessageFromPrimaryDevice] isMessageFromPrimaryDevice = true ");
            }
        }
        return bl;
    }

    public String toString() {
        Buffer buffer = new Buffer(256);
        buffer.append("NewMessageIndicationManager {");
        buffer.append("newMessageAccounts = ");
        buffer.append(Maps.toMultiLineString(this.newMessageAccounts, this.newMessageAccountsElementFormatter));
        buffer.append(", mostRecentMessageAccIds = ");
        buffer.append(Collections.toString(this.mostRecentMessageAccIds));
        buffer.append(", memoryDepleted = ");
        buffer.append(this.memoryDepleted);
        buffer.append(", simMemoryDepleted = ");
        buffer.append(this.simMemoryDepleted);
        buffer.append(", simMemoryDepletedAccountId = ");
        buffer.append(this.simMemoryDepletedAccountId);
        buffer.append('}');
        return buffer.toString();
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new NewMessageIndicationManager$DiagPlugIn(this)};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$200(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ INewMessageIndicationManagerObserver[] access$300(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.getCurrentObservers();
    }

    static /* synthetic */ LogChannel access$400(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ MessagingBundleContext access$500(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$600(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ boolean access$700(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.memoryDepleted;
    }

    static /* synthetic */ boolean access$800(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.simMemoryDepleted;
    }

    static /* synthetic */ boolean access$702(NewMessageIndicationManager newMessageIndicationManager, boolean bl) {
        newMessageIndicationManager.memoryDepleted = bl;
        return newMessageIndicationManager.memoryDepleted;
    }

    static /* synthetic */ boolean access$802(NewMessageIndicationManager newMessageIndicationManager, boolean bl) {
        newMessageIndicationManager.simMemoryDepleted = bl;
        return newMessageIndicationManager.simMemoryDepleted;
    }

    static /* synthetic */ int access$902(NewMessageIndicationManager newMessageIndicationManager, int n) {
        newMessageIndicationManager.simMemoryDepletedAccountId = n;
        return newMessageIndicationManager.simMemoryDepletedAccountId;
    }

    static /* synthetic */ List access$1000(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.mostRecentSmsAccIds;
    }

    static /* synthetic */ List access$1100(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.mostRecentEmailAccIds;
    }

    static /* synthetic */ List access$1200(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.mostRecentMessageAccIds;
    }

    static /* synthetic */ Map access$1300(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.newMessageAccounts;
    }

    static /* synthetic */ LogChannel access$1400(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ void access$1500(NewMessageIndicationManager newMessageIndicationManager, int n) {
        newMessageIndicationManager.notifyObservers(n);
    }

    static /* synthetic */ IFrameworkAccess access$1600(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.framework;
    }

    static /* synthetic */ MessagingBundleContext access$1700(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$1800(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ boolean access$1900(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.showPrimaryIndicationsOnly;
    }

    static /* synthetic */ AbstractMsgApplication access$2000(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.msgApp;
    }

    static /* synthetic */ boolean access$2100(NewMessageIndicationManager newMessageIndicationManager, MessagingAccount messagingAccount) {
        return newMessageIndicationManager.isMessageFromPrimaryDevice(messagingAccount);
    }

    static /* synthetic */ LogChannel access$2200(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ void access$2300(NewMessageIndicationManager newMessageIndicationManager, int n, String string) {
        newMessageIndicationManager.addNewMessageIndication(n, string);
    }

    static /* synthetic */ MessagingBundleContext access$2400(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$2500(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ void access$2600(NewMessageIndicationManager newMessageIndicationManager, String string) {
        newMessageIndicationManager.clearNewMessageIndication(string);
    }

    static /* synthetic */ MessagingBundleContext access$2700(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$2800(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.log;
    }

    static /* synthetic */ AbstractMsgApplication access$2900(NewMessageIndicationManager newMessageIndicationManager) {
        return newMessageIndicationManager.msgApp;
    }
}

