/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;
import de.audi.app.phone.core.sim.SimUsageUserDecision;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.IConnectivitySimUsageListener;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.esolutions.fw.util.commons.Converter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelSIMModeSwitchHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private final SimModeSwitchStorageHandler storageHandler;
    private final boolean isNadModeSwitch;
    private volatile IGlobalTelephoneStateStruct telState;
    private volatile SimUsageUserDecision[] simUserDecisions;
    private volatile String simCardID = "";
    private volatile PhoneServiceTracker connectivityPhoneStateListenerTracker;
    private volatile IConnectivitySimUsageListener simUsageListener;
    private volatile boolean showingIsAllowed;
    private final int UNKNOWN;
    private final int ACTIVE;
    private final int NOT_ACTIVE;
    private int eSIMActiveState = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivitySimUsageListener;

    private static boolean simCardIDAvailable(String string) {
        return string != null && !"".equals(string);
    }

    public TelSIMModeSwitchHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.UNKNOWN = 0;
        this.ACTIVE = 1;
        this.NOT_ACTIVE = 2;
        this.storageHandler = new SimModeSwitchStorageHandler(iTelApplication.getFrameworkAccess().getStorageMgr());
        this.isNadModeSwitch = iTelApplication.getFrameworkAccess().getSysConstManager().getAdaptationANP().isSimCardModeSwitch();
        this.addSubPhoneComponent(new FactoryResetHandler(iTelApplication));
        this.addSubPhoneComponent(new VoiceAndDataButtonListener(iTelApplication));
        this.addSubPhoneComponent(new DataOnlyButtonListener(iTelApplication));
        this.addSubPhoneComponent(new SimUsageHkReturnButtonListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.simUserDecisions = this.storageHandler.loadSimUsageUserDecisionInfo();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        boolean bl = this.getApplication().getFrameworkAccess().getSysApp().getAdaptationANP().isSimCardModeSwitch();
        boolean bl2 = this.getApplication().getFrameworkAccess().getSysConst(463) == 1;
        boolean bl3 = bl2 && bl;
        this.getChoiceModel(300643).setValue(bl3 ? 1 : 0);
        this.connectivityPhoneStateListenerTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$IConnectivitySimUsageListener == null ? (class$de$audi$atip$interapp$IConnectivitySimUsageListener = TelSIMModeSwitchHandler.class$("de.audi.atip.interapp.IConnectivitySimUsageListener")) : class$de$audi$atip$interapp$IConnectivitySimUsageListener).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.connectivityPhoneStateListenerTracker.openTracker();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.connectivityPhoneStateListenerTracker.closeTracker();
        this.connectivityPhoneStateListenerTracker = null;
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telState = iGlobalTelephoneStateStruct;
        if (this.isNadModeSwitch) {
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNadInstanceState();
            String string = this.getSimCardID(iTelDSIMobileEquipmentDeviceState);
            SimUsageUserDecision simUsageUserDecision = this.getSIMUsageData(string);
            this.setShowingIsAllowed(n, iGlobalTelephoneStateStruct);
            this.setShowSimModeUsageScreenChoice(string, simUsageUserDecision, iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getTelMode() : 4);
            this.checkCallViaNadActive(iTelDSIMobileEquipmentDeviceState, simUsageUserDecision);
        }
    }

    private void setShowingIsAllowed(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 262153) {
            int n2 = this.eSIMActiveState = iGlobalTelephoneStateStruct.isESIMActive() ? 1 : 2;
        }
        this.showingIsAllowed = iGlobalTelephoneStateStruct.getNadInstanceState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().isPhoneReady() ? this.eSIMActiveState != 0 : false;
    }

    private boolean isShowingOfSIMSwitchPopupAllowed() {
        return this.showingIsAllowed;
    }

    private void checkCallViaNadActive(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, SimUsageUserDecision simUsageUserDecision) {
        int n = this.telState.getNadMode();
        if (iTelDSIMobileEquipmentDeviceState != null && n == 1) {
            boolean bl;
            boolean bl2 = iTelDSIMobileEquipmentDeviceState.getCallState() != null ? !iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() : (bl = false);
            if (bl && simUsageUserDecision == null && this.isSimModeUsageToBeShown()) {
                this.log.log(1000000, "[TelSIMModeSwitchHandler#checkCallViaNadActive] call is active but no user decision was made. Setting user decision to voice & data");
                this.resetShowSimModeUsageChoice();
                this.addSimUsageData(1);
            }
        }
    }

    private String getSimCardID(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getSimId() : "";
    }

    private void setShowSimModeUsageScreenChoice(String string, SimUsageUserDecision simUsageUserDecision, int n) {
        boolean bl = n == 0;
        boolean bl2 = string != null && !string.equals(this.simCardID);
        this.simCardID = string;
        if (this.eSIMActiveState == 1) {
            this.log.log(1000000, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] ESIM is active. No usage for ESIM");
            this.showSimModeUsageChoice(false);
            return;
        }
        if (TelSIMModeSwitchHandler.simCardIDAvailable(string)) {
            if (simUsageUserDecision == null && bl) {
                if (bl2) {
                    this.log.log(1000000, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] no usage data found for sim with id=%1", (Object)string);
                }
                if (this.isShowingOfSIMSwitchPopupAllowed()) {
                    this.log.log(1000000, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] show SIM Usage id=%1", (Object)string);
                    this.showSimModeUsageChoice(true);
                } else {
                    this.log.log(1000000, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] showing SIM Usage not allowed");
                }
            } else {
                if (bl2) {
                    this.log.log(1000000, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] usage data found for sim with id=%1: %2", (Object)string, (Object)simUsageUserDecision);
                }
                this.showSimModeUsageChoice(false);
            }
        } else {
            this.showSimModeUsageChoice(false);
        }
    }

    private boolean isSimModeUsageToBeShown() {
        return this.getChoiceModel(300917).getValue() == 1;
    }

    protected void showSimModeUsageChoice(boolean bl) {
        if (this.simUsageListener != null) {
            this.simUsageListener.updateSimUsageToBeShown(bl);
        }
        this.getChoiceModel(300917).setValue(bl ? 1 : 0);
    }

    private void resetShowSimModeUsageChoice() {
        if (this.simUsageListener != null) {
            this.simUsageListener.updateSimUsageToBeShown(false);
        }
        this.getChoiceModel(300917).setValue(0);
    }

    protected void addSimUsageData(int n) {
        this.addSimUsageData(this.simCardID, n);
    }

    private void addSimUsageData(String string, int n) {
        SimUsageUserDecision[] simUsageUserDecisionArray = new SimUsageUserDecision[]{new SimUsageUserDecision(string, n)};
        this.log.log(1000000, "[TelSIMModeSwitchHandler#addSimUsageData] usageInfo=%1", (Object)Converter.array2String(simUsageUserDecisionArray));
        this.storageHandler.storeSIMUsageUserDecision(simUsageUserDecisionArray);
        this.simUserDecisions = simUsageUserDecisionArray;
    }

    private SimUsageUserDecision getSIMUsageData(String string) {
        if (TelSIMModeSwitchHandler.simCardIDAvailable(string) && this.simUserDecisions != null) {
            for (int i2 = 0; i2 < this.simUserDecisions.length; ++i2) {
                if (this.simUserDecisions[i2] == null || this.simUserDecisions[i2].getSimCardID() == null || !this.simUserDecisions[i2].getSimCardID().equals(string)) continue;
                return this.simUserDecisions[i2];
            }
        }
        return null;
    }

    private void checkSwitchToDataOnly(int n, int n2) {
        if (this.telState != null) {
            int n3 = this.telState.getNadMode();
            if (n3 == 2) {
                this.log.log(1000000, "[TelSIMModeSwitchHandler#checkSwitchToDataOnly] NAD-Mode is already in data only--> no switch necessary.");
                this.getApplication().getFrameworkAccess().getHMIService().getModelApp(n2).fireEvent(n);
            } else {
                this.log.log(1000000, "[TelSIMModeSwitchHandler#checkSwitchToDataOnly] current nad mode is %1. Setting NAD-Mode to data only", (long)n3);
                this.getApplication().getTelephoneDSIAccess().requestSetNadMode(2, n);
            }
        } else {
            this.log.log(100000, "[TelSIMModeSwitchHandler#checkSwitchToDataOnly] telState is null --> NOP!");
        }
    }

    private void checkSwitchToVoiceAndData(int n, int n2) {
        if (this.telState != null) {
            int n3 = this.telState.getNadMode();
            if (n3 == 1) {
                this.log.log(1000000, "[TelSIMModeSwitchHandler#checkSwitchToVoiceAndData] NAD-Mode is already in Voice & Data --> no switch necessary.");
                this.getApplication().getFrameworkAccess().getHMIService().getModelApp(n2).fireEvent(n);
            } else {
                this.log.log(1000000, "[TelSIMModeSwitchHandler#checkSwitchToVoiceAndData] current nad mode is %1. Setting NAD-Mode to Voice & Data", (long)n3);
                this.getApplication().getTelephoneDSIAccess().requestSetNadMode(1, n);
            }
        } else {
            this.log.log(100000, "[TelSIMModeSwitchHandler#checkSwitchToVoiceAndData] telState is null --> NOP!");
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof IConnectivitySimUsageListener) {
            this.simUsageListener = (IConnectivitySimUsageListener)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectivityPhoneStateListener) {
            this.simUsageListener = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
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

    static /* synthetic */ SimUsageUserDecision[] access$1502(TelSIMModeSwitchHandler telSIMModeSwitchHandler, SimUsageUserDecision[] simUsageUserDecisionArray) {
        telSIMModeSwitchHandler.simUserDecisions = simUsageUserDecisionArray;
        return simUsageUserDecisionArray;
    }

    private class FactoryResetHandler
    extends AbstractTelMessageListener {
        public FactoryResetHandler(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 28);
        }

        protected void messageReceived() {
            this.log.log(1000000, "[TelSIMModeSwitchHandler.FactoryResetHandler#messageRecieved] deleting all sim usage information.");
            TelSIMModeSwitchHandler.access$1502(TelSIMModeSwitchHandler.this, new SimUsageUserDecision[0]);
            TelSIMModeSwitchHandler.this.storageHandler.storeSIMUsageUserDecision(TelSIMModeSwitchHandler.this.simUserDecisions);
        }
    }

    private class DataOnlyButtonListener
    extends TelDefaultButtonListener {
        public DataOnlyButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300804);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelSIMModeSwitchHandler.DataOnlyButtonListener#keyTyped] data only selected.");
            TelSIMModeSwitchHandler.this.checkSwitchToDataOnly(n3, n);
            TelSIMModeSwitchHandler.this.resetShowSimModeUsageChoice();
            TelSIMModeSwitchHandler.this.addSimUsageData(2);
        }
    }

    private class VoiceAndDataButtonListener
    extends TelDefaultButtonListener {
        public VoiceAndDataButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300805);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelSIMModeSwitchHandler.VoiceAndDataButtonListener#keyTyped] voice and data selected.");
            TelSIMModeSwitchHandler.this.checkSwitchToVoiceAndData(n3, n);
            TelSIMModeSwitchHandler.this.resetShowSimModeUsageChoice();
            TelSIMModeSwitchHandler.this.addSimUsageData(1);
        }
    }

    private class SimModeSwitchStorageHandler
    extends AbstractStorageDataContainer {
        private static final int PERSISTENCE_CONTAINER_VERSION = 0;
        private SimUsageUserDecision[] usageInfo;

        public SimModeSwitchStorageHandler(IStorageAccess iStorageAccess) {
            super(iStorageAccess, 0, 1003, 110);
        }

        private void storeSIMUsageUserDecision(SimUsageUserDecision[] simUsageUserDecisionArray) {
            this.usageInfo = simUsageUserDecisionArray != null ? simUsageUserDecisionArray : new SimUsageUserDecision[]{};
            TelSIMModeSwitchHandler.this.log.log(1000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#storeSIMUsageUserDecision] %1", (Object)Converter.array2String(this.usageInfo));
            this.serializeAndWrite();
        }

        private SimUsageUserDecision[] loadSimUsageUserDecisionInfo() {
            this.readAndDeserialize();
            TelSIMModeSwitchHandler.this.log.log(1000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#loadSimUsageUserDecisionInfo] %1", (Object)Converter.array2String(this.usageInfo));
            return this.usageInfo;
        }

        protected void handleCRC32Error() {
            TelSIMModeSwitchHandler.this.log.log(10000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#handleCRC32Error]");
        }

        protected void handleStorageReadError(Exception exception) {
            TelSIMModeSwitchHandler.this.log.log(1000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#handleStorageReadError] - no persisted sim usage information!");
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            TelSIMModeSwitchHandler.this.log.log(100000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#convertContainer] persistedVersion=%1, containerVersion=%2 --> NOP!", (long)n, (long)n2);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            int n = this.usageInfo.length;
            TelSIMModeSwitchHandler.this.log.log(10000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#serialize] length=%1", (long)n);
            dataOutputStream.writeInt(n);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            for (int i2 = 0; i2 < this.usageInfo.length; ++i2) {
                SimUsageUserDecision simUsageUserDecision = this.usageInfo[i2];
                TelSIMModeSwitchHandler.this.log.log(1000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#serialize] SimUsageUserDecision=%1", (Object)simUsageUserDecision);
                objectOutputStream.writeObject(simUsageUserDecision);
            }
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            TelSIMModeSwitchHandler.this.log.log(10000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize]");
            int n = dataInputStream.readInt();
            TelSIMModeSwitchHandler.this.log.log(10000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] arrayLength=%1", (long)n);
            if (n < 0 || n > 50) {
                TelSIMModeSwitchHandler.this.log.log(10000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] array length not valid: %1", (long)n);
                return;
            }
            this.usageInfo = new SimUsageUserDecision[n];
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            for (int i2 = 0; i2 < n; ++i2) {
                try {
                    SimUsageUserDecision simUsageUserDecision = (SimUsageUserDecision)objectInputStream.readObject();
                    TelSIMModeSwitchHandler.this.log.log(10000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] usageInfo=%1", (Object)this.usageInfo);
                    this.usageInfo[i2] = simUsageUserDecision;
                    continue;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    TelSIMModeSwitchHandler.this.log.log(10000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] %1", (Throwable)classNotFoundException);
                }
            }
            TelSIMModeSwitchHandler.this.log.log(10000000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] %1", (Object)Converter.array2String(this.usageInfo));
        }
    }

    private class SimUsageHkReturnButtonListener
    extends TelDefaultButtonListener {
        public SimUsageHkReturnButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 301083);
        }

        public void keyTyped(int n, int n2, int n3) {
            int n4 = TelSIMModeSwitchHandler.this.telState.getNadMode();
            if (n4 == 1) {
                this.log.log(1000000, "[TelSIMModeSwitchHandler.SimUsageHkReturnButtonListener#keyTyped] HK_RETURN (saving decision for NADMODE_VOICE_DATA)");
                TelSIMModeSwitchHandler.this.addSimUsageData(1);
                TelSIMModeSwitchHandler.this.resetShowSimModeUsageChoice();
            } else if (n4 == 2) {
                this.log.log(1000000, "[TelSIMModeSwitchHandler.SimUsageHkReturnButtonListener#keyTyped] HK_RETURN (saving decision for NADMODE_DATA)");
                TelSIMModeSwitchHandler.this.addSimUsageData(2);
                TelSIMModeSwitchHandler.this.resetShowSimModeUsageChoice();
            }
            this.fireEvent(n3);
        }
    }
}

