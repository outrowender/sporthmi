/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelFSGSetup$BAPTerminalModeUpdateListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.data.FsgSetup;
import de.audi.atip.interapp.combi.bap.phone.data.FsgSetup$Builder;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class BAPPropertyTelFSGSetup
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private static final int E_SIM_CODED_NEVER;
    private static final int E_SIM_CODED_ALWAYS;
    private static final int E_SIM_CODED_SERVICE_DEPENDENT;
    private final boolean cableConnectionToMobilePossible;
    protected volatile FsgSetup fsgSetup;
    private final boolean nadCoded;
    private final boolean phoneModulOperationModeWithVoice;
    private final boolean simCardModeSwitch;
    private final boolean bluetoothCoded;
    private final boolean btTelephoneSupportCoded;
    private final IFrameworkAccess frameworkAccess;
    private final PhoneServiceProvider terminalModeUpdateListnerService;
    private final DefaultTerminalModeUpdateListener tmUpdateListener;
    private final boolean isCarplayPossible;
    private volatile boolean isAndroidAutoPossible;
    private final int eSIMCoding;
    private volatile boolean isCarplayActive = false;
    private volatile boolean isAndroidAutoActive = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    private static int getClusterMobileConnectionType(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 0: {
                return 1;
            }
        }
        return 0;
    }

    BAPPropertyTelFSGSetup(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
        this.cableConnectionToMobilePossible = false;
        this.frameworkAccess = iTelApplication.getFrameworkAccess();
        this.nadCoded = this.frameworkAccess.getSysConstManager().getSysConst(463) == 1;
        this.phoneModulOperationModeWithVoice = this.frameworkAccess.getSysApp().getAdaptationANP().isPhoneModuleOperationModeWithVoice();
        this.simCardModeSwitch = this.frameworkAccess.getSysApp().getAdaptationANP().isSimCardModeSwitch();
        this.bluetoothCoded = this.frameworkAccess.getSysApp().getDiagnosisCOD().isBluetoothAvailable();
        this.btTelephoneSupportCoded = this.frameworkAccess.getSysApp().getDiagnosisCOD().isBluetoothPhoneAvailable();
        this.isCarplayPossible = this.frameworkAccess.getSysApp().getAdaptationANP().isAppleDIO();
        this.isAndroidAutoPossible = this.frameworkAccess.getSysApp().getAdaptationANP().isGoogleGAL();
        this.tmUpdateListener = new BAPPropertyTelFSGSetup$BAPTerminalModeUpdateListener(this, null);
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = BAPPropertyTelFSGSetup.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelApplication.getBundleContext(), this.log);
        this.eSIMCoding = this.frameworkAccess.getSysConstManager().getAdaptationANP().getESIMUUsage();
    }

    BAPPropertyTelFSGSetup(ITelApplication iTelApplication, DispatcherBase dispatcherBase, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n) {
        super(iTelApplication, dispatcherBase);
        this.cableConnectionToMobilePossible = false;
        this.frameworkAccess = iTelApplication.getFrameworkAccess();
        this.nadCoded = bl;
        this.phoneModulOperationModeWithVoice = bl2;
        this.simCardModeSwitch = bl3;
        this.bluetoothCoded = bl4;
        this.btTelephoneSupportCoded = bl5;
        this.tmUpdateListener = new BAPPropertyTelFSGSetup$BAPTerminalModeUpdateListener(this, null);
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = BAPPropertyTelFSGSetup.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelApplication.getBundleContext(), this.log);
        this.isCarplayPossible = bl6;
        this.isAndroidAutoPossible = bl7;
        this.eSIMCoding = n;
    }

    @Override
    public void init() {
        this.terminalModeUpdateListnerService.startService();
        super.init();
    }

    @Override
    public void deinit() {
        this.terminalModeUpdateListnerService.stopService();
        super.deinit();
    }

    boolean isInternalSimCardReaderAvailable(int n, boolean bl) {
        if (this.nadCoded) {
            return this.nadCodedCheckESIMConditions(n, bl);
        }
        return false;
    }

    private boolean nadCodedCheckESIMConditions(int n, boolean bl) {
        switch (this.eSIMCoding) {
            case 2: {
                return false;
            }
            case 1: {
                return this.nadCodedESIMNotCodedCheckFullConnectConditions(n);
            }
            case 0: {
                return this.nadCodedESIMServiceDependentCheckESIMActive(n, bl);
            }
        }
        this.log.log(10000, "[BAPTerminalModeUpdateListener#isInternalSimCardReaderAvailable] invalid eSIMCoding=%1", (long)this.eSIMCoding);
        return this.nadCodedESIMNotCodedCheckFullConnectConditions(n);
    }

    private boolean nadCodedESIMServiceDependentCheckESIMActive(int n, boolean bl) {
        if (bl && this.simCardModeSwitch) {
            return true;
        }
        return this.nadCodedESIMNotCodedCheckFullConnectConditions(n);
    }

    private boolean nadCodedESIMNotCodedCheckFullConnectConditions(int n) {
        if (this.simCardModeSwitch) {
            return n == 1 || n == 3;
        }
        return this.phoneModulOperationModeWithVoice;
    }

    boolean isHfpConnectionAvailable() {
        return this.bluetoothCoded && this.btTelephoneSupportCoded;
    }

    boolean isRsapConnectionToMobilePossible(int n, boolean bl) {
        return this.isInternalSimCardReaderAvailable(n, bl) && this.bluetoothCoded;
    }

    private int getMobileConnectionType() {
        if (this.isCarplayActive) {
            return 5;
        }
        if (this.isAndroidAutoActive) {
            return 6;
        }
        if (this.isLowPrioritySOSEmergencyCallType()) {
            return 3;
        }
        if (this.isConnectionPresent()) {
            IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
            return BAPPropertyTelFSGSetup.getClusterMobileConnectionType(iTelDSIMobileEquipmentDeviceState.getTelMode());
        }
        return 0;
    }

    private boolean isConnectionPresent() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getActivationState() != null) {
            int n = iTelDSIMobileEquipmentDeviceState.getActivationState().getTelActivationState();
            return n == 5 || n == 2;
        }
        return false;
    }

    private boolean isLowPrioritySOSEmergencyCallType() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        IEcallState iEcallState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : null;
        return iEcallState != null && iEcallState.isLowPrioritySOSEmergencyCallType();
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return true;
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        int n = this.getMobileConnectionType();
        int n2 = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNadMode() : 0;
        boolean bl = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isESIMActive() : false;
        boolean bl2 = this.isInternalSimCardReaderAvailable(n2, bl);
        boolean bl3 = this.isHfpConnectionAvailable();
        boolean bl4 = this.isRsapConnectionToMobilePossible(n2, bl);
        FsgSetup$Builder fsgSetup$Builder = FsgSetup.builder();
        fsgSetup$Builder.setInternalSimCardReaderPresent(bl2);
        super.getClass();
        fsgSetup$Builder.setCableConnectionPossible(false);
        fsgSetup$Builder.setHfpConnectionPossible(bl3);
        fsgSetup$Builder.setRsapConnectionPossible(bl4);
        fsgSetup$Builder.setAppleLinkConnectionPossible(this.isCarplayPossible);
        fsgSetup$Builder.setGoogleLinkConnectionPossible(this.isAndroidAutoPossible);
        fsgSetup$Builder.setMobileConnectionType(n);
        FsgSetup fsgSetup = fsgSetup$Builder.build();
        if (combiBAPServicePhone != null) {
            if (!fsgSetup.equals(this.fsgSetup)) {
                this.log.log(1078071040, "[BAPPropertyTelFSGSetup#update] %1", (Object)fsgSetup);
                combiBAPServicePhone.updateFsgSetup(fsgSetup);
                this.fsgSetup = fsgSetup;
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelFSGSetup#update] combi service is null! --> NOP!");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$100(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        return bAPPropertyTelFSGSetup.log;
    }

    static /* synthetic */ boolean access$200(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        return bAPPropertyTelFSGSetup.isCarplayActive;
    }

    static /* synthetic */ boolean access$300(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        return bAPPropertyTelFSGSetup.isAndroidAutoActive;
    }

    static /* synthetic */ boolean access$202(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup, boolean bl) {
        bAPPropertyTelFSGSetup.isCarplayActive = bl;
        return bAPPropertyTelFSGSetup.isCarplayActive;
    }

    static /* synthetic */ boolean access$302(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup, boolean bl) {
        bAPPropertyTelFSGSetup.isAndroidAutoActive = bl;
        return bAPPropertyTelFSGSetup.isAndroidAutoActive;
    }

    static /* synthetic */ LogChannel access$400(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        return bAPPropertyTelFSGSetup.log;
    }

    static /* synthetic */ void access$500(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        bAPPropertyTelFSGSetup.enqueueUpdate();
    }

    static /* synthetic */ LogChannel access$600(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        return bAPPropertyTelFSGSetup.log;
    }

    static /* synthetic */ void access$700(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        bAPPropertyTelFSGSetup.enqueueUpdate();
    }
}

