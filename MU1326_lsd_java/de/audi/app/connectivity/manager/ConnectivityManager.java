/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.connectivity.core.AbstractApplication;
import de.audi.app.connectivity.manager.CoMaCarplayHandler;
import de.audi.app.connectivity.manager.CoMaDrawer;
import de.audi.app.connectivity.manager.CoMaMediaServiceListener;
import de.audi.app.connectivity.manager.CoMaSelectionHandler;
import de.audi.app.connectivity.manager.ComaBluetoothListener;
import de.audi.app.connectivity.manager.ComaPhoneStateListener;
import de.audi.app.connectivity.manager.ComaWlanListener;
import de.audi.app.connectivity.manager.ConnectivityManager$1;
import de.audi.app.connectivity.manager.IConnectivityManager;
import de.audi.app.connectivity.manager.TerminalModeProxy;
import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.app.connectivity.manager.contents.CoMaCategory;
import de.audi.app.connectivity.manager.contents.CoMaDeviceRhmi;
import de.audi.app.connectivity.manager.contents.CoMaDeviceSmartphone;
import de.audi.app.connectivity.manager.contents.CoMaDeviceUpnp;
import de.audi.app.connectivity.manager.contents.CoMaList;
import de.audi.app.wlan.core.client.Network;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.IConnectivityRHMIStateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.StringUtils;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import java.io.File;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ConnectivityManager
extends AbstractApplication
implements IConnectivityManager,
IConnectivityRHMIStateListener,
I18NTarget,
MsgListener {
    private static final String MODULE_NAME;
    private static final boolean ENABLE_NEW_DEVICE_LINE;
    private static final boolean DISABLE_NEW_DEVICE_LINE;
    private static final boolean DISABLE_MULTIPLE_SELECTION;
    private ServiceRegistration registration1;
    private ServiceRegistration registration2;
    private ServiceRegistration registration3;
    private ServiceRegistration registration4;
    private ServiceRegistration registration5;
    private final IEvoConnectivity connectivity;
    private final ComaBluetoothListener bluetoothListener;
    private final ComaWlanListener wlanListener;
    private final ComaPhoneStateListener simState;
    private final CoMaList list;
    private final CoMaSelectionHandler selectionHandler;
    private final CoMaCarplayHandler carplayHandler;
    private final CoMaDrawer optionDrawer;
    private final TerminalModeProxy smartphoneProxy;
    private final boolean isNadModeSwitch;
    private final boolean isWifi;
    private final List blueCoMaDevices = new ArrayList();
    private final List wlanCoMaDevices = new ArrayList();
    private volatile AbstractCoMaDevice sim;
    private final boolean eSimAlwaysAvailable;
    private volatile AbstractCoMaDevice uPnP = null;
    private final List smartphones = new ArrayList();
    private final List rhmiAppServerDevices = new ArrayList();
    private volatile boolean isCallActiveOrPhoneRinging;
    private boolean activateAssociatedNewDeviceEntry;
    private volatile boolean isTerminalModeActive;
    private boolean ignoreSimVanishOnNadModeUpgrade = false;
    private boolean phoneModuleStateIsOn = false;
    private boolean simOrRSAPAvailable;
    private AbstractCoMaDevice delaySim;
    private volatile boolean isAnyEorBCallActive;
    private volatile boolean isLockFeatureCurrentlyActivated = false;
    private volatile long lastSimUpdateTime;
    private static final long SIM_UPDATE_DELAY;
    Timer updateSimTimer = new Timer("UpdateSim", 0, true, new ConnectivityManager$1(this));
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityRHMIStateListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    private static final CoMaCategory[] getCategories(ArrayList arrayList) {
        CoMaCategory[] coMaCategoryArray = new CoMaCategory[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            coMaCategoryArray[i2] = (CoMaCategory)arrayList.get(i2);
        }
        return coMaCategoryArray;
    }

    private static ArrayList getCategoryArray(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CoMaCategory(0, 1, true, false));
        if (bl) {
            arrayList.add(new CoMaCategory(5, 2, true, false));
        }
        if (bl2 && !bl3) {
            arrayList.add(new CoMaCategory(1, 4, bl6, false));
        }
        if (bl4) {
            arrayList.add(new CoMaCategory(2, 8, true, false));
        }
        arrayList.add(new CoMaCategory(3, 16, true, false));
        if (bl5 || bl8) {
            arrayList.add(new CoMaCategory(7, 128, true, false));
        }
        if (bl6) {
            arrayList.add(new CoMaCategory(4, 32, true, false));
        }
        if (bl7) {
            arrayList.add(new CoMaCategory(6, 64, false, false));
        }
        return arrayList;
    }

    public ConnectivityManager(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IEvoConnectivity iEvoConnectivity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super(iFrameworkAccess, bundleContext, "App.Connectivity.Main", "App.Connectivity.Main", "CONNECTIVIY_MANAGER");
        this.connectivity = iEvoConnectivity;
        IHMIServiceApp iHMIServiceApp = iFrameworkAccess.getHmiServiceApp();
        Adaptation adaptation = iFrameworkAccess.getSysConstManager().getAdaptationANP();
        this.isNadModeSwitch = adaptation.isSimCardModeSwitch();
        this.eSimAlwaysAvailable = iFrameworkAccess.getSysConstManager().getAdaptationANP().getESIMUUsage() == 2;
        boolean bl5 = iFrameworkAccess.getSysConst(4177) == 1;
        boolean bl6 = bl;
        boolean bl7 = iFrameworkAccess.getSysConst(4238) == 1;
        boolean bl8 = iFrameworkAccess.getSysConst(4237) == 1;
        boolean bl9 = new File("/var/smartphone_integration").exists();
        this.bluetoothListener = new ComaBluetoothListener(iEvoConnectivity.getBluetooth(), this);
        this.addComponent(this.bluetoothListener);
        this.wlanListener = new ComaWlanListener(this);
        this.addComponent(this.wlanListener);
        this.simState = new ComaPhoneStateListener(this.log, this, iHMIServiceApp, this.isNadModeSwitch);
        this.smartphoneProxy = new TerminalModeProxy(bundleContext, this.log, this);
        this.selectionHandler = new CoMaSelectionHandler(iFrameworkAccess, bundleContext, iEvoConnectivity, this.smartphoneProxy, this);
        this.carplayHandler = new CoMaCarplayHandler(iFrameworkAccess, this.smartphoneProxy);
        ArrayList arrayList = ConnectivityManager.getCategoryArray(bl5, bl2, this.eSimAlwaysAvailable, bl6, bl3, this.isNadModeSwitch, bl7 || bl8 || bl9, bl4);
        this.list = new CoMaList(this.log, this.selectionHandler, iHMIServiceApp, ConnectivityManager.getCategories(arrayList));
        this.optionDrawer = new CoMaDrawer(this.log, iEvoConnectivity, iHMIServiceApp, this.smartphoneProxy);
        this.isWifi = bl3;
    }

    boolean isWifi() {
        return this.isWifi;
    }

    boolean isEsimAlwaysAvailable() {
        return this.eSimAlwaysAvailable;
    }

    AbstractCoMaDevice getSim() {
        return this.sim;
    }

    void initNadModeUpgrade() {
        this.ignoreSimVanishOnNadModeUpgrade = true;
    }

    synchronized void updateBluetoothDevices(List list, boolean bl) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "ConnectivityManager#updateBluetoothDevices simOrSap=%2, devices=%1", (Object)list.toString(), (Object)String.valueOf(bl));
        }
        this.blueCoMaDevices.clear();
        this.blueCoMaDevices.addAll(list);
        this.simOrRSAPAvailable = bl;
        this.updateListDevices();
    }

    public void updatePhoneModuleState(boolean bl) {
        this.log.log(-2137614336, "ConnectivityManager#updatePhoneModuleState isOn=%1", (Object)String.valueOf(bl));
        this.phoneModuleStateIsOn = bl;
        if (this.list != null) {
            this.list.updatePhoneModuleState(bl);
        }
    }

    synchronized void updateSim(AbstractCoMaDevice abstractCoMaDevice) {
        boolean bl;
        this.log.log(1078071040, "ConnectivityManager#updateSim(): %1", (Object)abstractCoMaDevice);
        long l = System.currentTimeMillis();
        boolean bl2 = bl = this.ignoreSimVanishOnNadModeUpgrade && abstractCoMaDevice == null;
        if (bl) {
            this.log.log(-2137614336, "ConnectivityManager#updateSimState(): Delaying SIM update");
        } else if (l - this.lastSimUpdateTime < 0) {
            this.log.log(-2137614336, "ConnectivityManager#updateSim(): skip");
            this.delaySim = abstractCoMaDevice;
            this.updateSimTimer.restart();
        } else {
            this.log.log(-2137614336, "ConnectivityManager#updateSim(): update.");
            this.ignoreSimVanishOnNadModeUpgrade = false;
            this.sim = abstractCoMaDevice;
            this.updateNewDeviceLineActivations();
            this.updateListDevices();
        }
        this.lastSimUpdateTime = l;
    }

    synchronized void updateWlanDevices(List list) {
        this.wlanCoMaDevices.clear();
        this.wlanCoMaDevices.addAll(list);
        this.updateListDevices();
    }

    synchronized void updateCallActivity(boolean bl) {
        this.isCallActiveOrPhoneRinging = bl;
        this.updateNewDeviceLineActivations();
    }

    synchronized void updateEorBCallActivity(boolean bl) {
        if (this.isAnyEorBCallActive != bl) {
            this.isAnyEorBCallActive = bl;
            this.updateNewDeviceLineActivations();
        }
    }

    public void updateAssociatedNewDeviceEntryActivation(boolean bl) {
        this.activateAssociatedNewDeviceEntry = bl;
        this.updateNewDeviceLineActivations();
    }

    private void updateNewDeviceLineActivations() {
        this.list.setNewDeviceLineActivation(0, !this.isCallActiveOrPhoneRinging && !this.isTerminalModeActive && !this.isAnyEorBCallActive && !this.isLockFeatureCurrentlyActivated, this.isLockFeatureCurrentlyActivated);
        this.list.setNewDeviceLineActivation(5, !this.isCallActiveOrPhoneRinging && this.activateAssociatedNewDeviceEntry && !this.isTerminalModeActive && !this.isAnyEorBCallActive && !this.isLockFeatureCurrentlyActivated, this.isLockFeatureCurrentlyActivated);
        this.list.setNewDeviceLineActivation(1, !this.isCallActiveOrPhoneRinging && this.sim == null && !this.isTerminalModeActive && this.phoneModuleStateIsOn && !this.isAnyEorBCallActive && !this.isLockFeatureCurrentlyActivated, this.isLockFeatureCurrentlyActivated);
        this.list.setNewDeviceLineActivation(4, this.sim != null && this.sim.isConnected(3) && !this.isTerminalModeActive && !this.isAnyEorBCallActive && !this.isLockFeatureCurrentlyActivated, this.isLockFeatureCurrentlyActivated);
        this.list.setNewDeviceLineActivation(3, !this.isTerminalModeActive && !this.isAnyEorBCallActive && !this.isLockFeatureCurrentlyActivated, this.isLockFeatureCurrentlyActivated);
        this.list.setNewDeviceLineActivation(7, !this.isTerminalModeActive && !this.isAnyEorBCallActive && !this.isLockFeatureCurrentlyActivated, this.isLockFeatureCurrentlyActivated);
    }

    synchronized void updateSmartphones(TerminalModeDevice[] terminalModeDeviceArray) {
        if (terminalModeDeviceArray != null) {
            this.log.log(1078071040, "ConnectivityManager#updateSmartphones(): %1", (Object)StringUtils.toString(terminalModeDeviceArray));
            this.smartphones.clear();
            this.isTerminalModeActive = false;
            for (int i2 = 0; i2 < terminalModeDeviceArray.length; ++i2) {
                TerminalModeDevice terminalModeDevice = terminalModeDeviceArray[i2];
                if (terminalModeDevice == null) continue;
                this.isTerminalModeActive = this.isTerminalModeActive || terminalModeDevice.isActive();
                CoMaDeviceSmartphone coMaDeviceSmartphone = new CoMaDeviceSmartphone(terminalModeDevice, terminalModeDevice.getDeviceUniqueId());
                this.smartphones.add(coMaDeviceSmartphone);
            }
            this.bluetoothListener.updateTerminalModeState(this.isTerminalModeActive);
            this.simState.updateTerminalModeState(this.isTerminalModeActive);
            this.list.setTerminalModeActive(this.isTerminalModeActive);
            this.list.updateTerminalModeDevicesAmount(terminalModeDeviceArray.length);
            this.updateListDevices();
            this.updateNewDeviceLineActivations();
        } else {
            this.log.log(10000, "ConnectivityManager#updateSmartphones(): pDeviceList is NULL");
        }
    }

    @Override
    public void updateTrustedWlanNetworks(Network[] networkArray) {
        this.wlanListener.updateTrustedWlanNetworks(networkArray);
    }

    @Override
    public synchronized void updateUPnPState(String string) {
        this.log.log(1078071040, "ConnectivityManager#updateUPnPState(): %1", (Object)string);
        this.uPnP = string != null ? new CoMaDeviceUpnp(string) : null;
        this.updateListDevices();
    }

    @Override
    public synchronized void updateActiveMediaDevice(int n, String string) {
        this.log.log(1078071040, "ConnectivityManager#updateActiveMediaDevice(): %2 %1", (Object)string, (long)n);
        this.list.updateCategoryDeviceName(3, string);
    }

    @Override
    public void connectivityManagerEntered() {
        this.log.log(1078071040, "ConnectivityManager#connectivityManagerEntered()");
        this.list.resetList();
    }

    @Override
    public void responseConnectService(int n, int n2) {
        this.selectionHandler.responseConnectService(n, n2);
    }

    @Override
    public synchronized void updateRHMIServerList(String[] stringArray, String[] stringArray2, boolean[] blArray) {
        if (stringArray == null || stringArray2 == null || blArray == null) {
            return;
        }
        this.log.log(-2137614336, "ConnectivityManager#updateRHMIServerList(): Received RHMI app server list.");
        this.rhmiAppServerDevices.clear();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            CoMaDeviceRhmi coMaDeviceRhmi = new CoMaDeviceRhmi(stringArray[i2], stringArray2[i2], blArray[i2]);
            this.rhmiAppServerDevices.add(coMaDeviceRhmi);
        }
        this.updateListDevices();
    }

    private void updateListDevices() {
        ArrayList arrayList = new ArrayList();
        if (this.sim != null) {
            arrayList.add(this.sim);
        }
        arrayList.addAll(this.blueCoMaDevices);
        arrayList.addAll(this.wlanCoMaDevices);
        if (this.uPnP != null) {
            arrayList.add(this.uPnP);
        }
        arrayList.addAll(this.smartphones);
        arrayList.addAll(this.rhmiAppServerDevices);
        this.list.updateDevices((AbstractCoMaDevice[])arrayList.toArray(new AbstractCoMaDevice[arrayList.size()]));
    }

    private void handleLockStatus(boolean bl) {
        this.isLockFeatureCurrentlyActivated = bl;
        this.updateNewDeviceLineActivations();
    }

    @Override
    public synchronized void setLanguage(Language language) {
        this.log.log(1078071040, "ConnectivityManager#setLanguage(): %1", (Object)language);
        this.list.languageChanged();
        this.simState.languageChanged();
    }

    @Override
    public void processMsg(int n) {
        if ((n == 206 || n == 207) && this.getFramework().getHMIService().getChoiceModel(5588).getValue() == 0) {
            this.registration5.unregister();
            this.registration5 = null;
            return;
        }
        if (n == 206) {
            this.log.log(1078071040, "[ConnectivityManager#processMsg] LOCK_FEATURE_ACTIVATED");
            this.handleLockStatus(true);
        } else if (n == 207) {
            this.log.log(1078071040, "[ConnectivityManager#processMsg] LOCK_FEATURE_DEACTIVATED");
            this.handleLockStatus(false);
        }
    }

    @Override
    public ConnectivityDiag getDiag() {
        return this.connectivity.getDiagnosis();
    }

    @Override
    protected void registerDSIListener() {
    }

    @Override
    protected void startDSI() {
    }

    @Override
    public void init() {
        super.init();
        Hashtable hashtable = new Hashtable(0);
        this.registration1 = this.getBundleContext().registerService((class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = ConnectivityManager.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener).getName(), (Object)new CoMaMediaServiceListener(this.log, this), (Dictionary)hashtable);
        this.registration2 = this.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityRHMIStateListener == null ? (class$de$audi$atip$interapp$IConnectivityRHMIStateListener = ConnectivityManager.class$("de.audi.atip.interapp.IConnectivityRHMIStateListener")) : class$de$audi$atip$interapp$IConnectivityRHMIStateListener).getName(), (Object)this, (Dictionary)hashtable);
        Hashtable hashtable2 = new Hashtable(2);
        hashtable2.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        hashtable2.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        this.registration3 = this.getBundleContext().registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = ConnectivityManager.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this, (Dictionary)hashtable2);
        this.registration4 = this.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = ConnectivityManager.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this.simState, (Dictionary)hashtable);
        this.registration5 = this.getBundleContext().registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ConnectivityManager.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this, null);
        if (this.getFramework().getHMIService().getChoiceModel(5588).getValue() == 1 && this.getFramework().getHMIService().getChoiceModel(5583).getValue() == 1) {
            this.handleLockStatus(true);
        }
        this.optionDrawer.init();
        this.smartphoneProxy.init();
        this.selectionHandler.init();
        this.carplayHandler.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.registration1.unregister();
        this.registration2.unregister();
        this.registration3.unregister();
        this.registration4.unregister();
        this.registration1 = null;
        this.registration2 = null;
        this.registration3 = null;
        this.registration4 = null;
        if (this.registration5 != null) {
            this.registration5.unregister();
            this.registration5 = null;
        }
        this.optionDrawer.deinit();
        this.smartphoneProxy.deinit();
        this.selectionHandler.deinit();
        this.carplayHandler.deinit();
        this.blueCoMaDevices.clear();
        this.wlanCoMaDevices.clear();
        this.rhmiAppServerDevices.clear();
    }

    public boolean isSimOrRsapAvailable() {
        return this.simOrRSAPAvailable;
    }

    static /* synthetic */ LogChannel access$000(ConnectivityManager connectivityManager) {
        return connectivityManager.log;
    }

    static /* synthetic */ LogChannel access$100(ConnectivityManager connectivityManager) {
        return connectivityManager.log;
    }

    static /* synthetic */ boolean access$202(ConnectivityManager connectivityManager, boolean bl) {
        connectivityManager.ignoreSimVanishOnNadModeUpgrade = bl;
        return connectivityManager.ignoreSimVanishOnNadModeUpgrade;
    }

    static /* synthetic */ AbstractCoMaDevice access$302(ConnectivityManager connectivityManager, AbstractCoMaDevice abstractCoMaDevice) {
        connectivityManager.sim = abstractCoMaDevice;
        return connectivityManager.sim;
    }

    static /* synthetic */ AbstractCoMaDevice access$400(ConnectivityManager connectivityManager) {
        return connectivityManager.delaySim;
    }

    static /* synthetic */ void access$500(ConnectivityManager connectivityManager) {
        connectivityManager.updateNewDeviceLineActivations();
    }

    static /* synthetic */ void access$600(ConnectivityManager connectivityManager) {
        connectivityManager.updateListDevices();
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

