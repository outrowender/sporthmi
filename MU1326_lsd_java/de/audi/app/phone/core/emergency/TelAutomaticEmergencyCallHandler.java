/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.emergency.DSIGeneralVehicleStatesListenerBase;
import de.audi.app.phone.core.power.IPowerEventListener;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.NullLogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;
import org.osgi.framework.BundleContext;

public class TelAutomaticEmergencyCallHandler
extends AbstractPhoneComponent
implements ChoiceListener,
IPowerEventListener {
    private static final long REDIAL_TIMOUT_DEFAULT = 60000L;
    private static final int MAX_REDIAL_ATTEMPTS_DEFAULT = 4;
    private static final int ECALL_ON = 1;
    private static final int ECALL_OFF = 0;
    private static final int ECALL_MENU_ITEM_SHOW = 1;
    private static final int ECALL_MENU_ITEM_HIDE = 0;
    private final BundleContext bundleContext;
    private volatile IGlobalTelephoneStateStruct gloablPhoneState;
    private volatile boolean isClamp15;
    private volatile boolean isECallEnabled;
    private volatile AirbagData airbagData;
    private final Timer autoRedialTimer;
    private int maxRedialAttempts;
    private volatile int redialAttempt;
    private volatile boolean automaticECallDialed;
    private volatile boolean automaticECallSuccessful;
    private final DSIActivator dsiGeneralVehicleStatesActivator;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public TelAutomaticEmergencyCallHandler(ITelApplication iTelApplication) {
        this(iTelApplication, 60000L);
    }

    public TelAutomaticEmergencyCallHandler(ITelApplication iTelApplication, long l) {
        super(iTelApplication, "App.Phone.Main");
        this.bundleContext = iTelApplication.getBundleContext();
        this.maxRedialAttempts = iTelApplication.getFrameworkAccess().getSysApp() != null && iTelApplication.getFrameworkAccess().getSysApp().getAdaptationANP() != null ? iTelApplication.getFrameworkAccess().getSysApp().getAdaptationANP().getEmergencyEstablishLinkAttempts() : 4;
        this.autoRedialTimer = new Timer("AutoECallRedialTimer", 5, NullLogChannel.getInstance(), new TimerListener(){

            public void fireTimer(Timer timer) {
                TelAutomaticEmergencyCallHandler.this.log.log(1000000, "[TelAutomaticEmergencyCallHandler.TelAutomaticEmergencyCallHandler(...).new TimerListener() {...}#fireTimer] checking for dialing emergency.");
                TelAutomaticEmergencyCallHandler.this.checkDialEmergency(true);
            }

            public void cancelTimer(Timer timer) {
            }
        }, l, true);
        this.dsiGeneralVehicleStatesActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = TelAutomaticEmergencyCallHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = TelAutomaticEmergencyCallHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName(), new Integer(0), new TelDSIGeneralVehicleStatesListener(), new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
                if (dSIBase instanceof DSIGeneralVehicleStates) {
                    TelAutomaticEmergencyCallHandler.this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#TelAutomaticEmergencyCallHandler] dsi available.");
                } else {
                    TelAutomaticEmergencyCallHandler.this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#TelAutomaticEmergencyCallHandler] dsi no longer available.");
                }
            }

            public int[] getAutoNotifications() {
                return new int[]{2};
            }
        });
    }

    void setMaxRedialAttempts(int n) {
        this.maxRedialAttempts = n;
    }

    public void init() {
        this.getApplication().addDiagnosisComponent(new TelAutomaticEmergencyCallDiag());
        this.getChoiceModel(300311).setChoiceListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
        this.dsiGeneralVehicleStatesActivator.start(this.bundleContext);
    }

    public void deinit() {
        this.getChoiceModel(300311).resetListener();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        this.dsiGeneralVehicleStatesActivator.stop(this.bundleContext);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(10000000, "TelAutomaticEmergencyCallHandler#itemSelected: id=%1, row=%2", (long)n, (long)n2);
        if (n != 300311) {
            this.log.log(10000, "TelAutomaticEmergencyCallHandler#itemSelected: Unhandled id %1! ", (long)n);
            return;
        }
        switch (n2) {
            case 0: {
                this.log.log(10000000, "[itemSelected#itemSelectedECallChoice] eCall is switched off.");
                this.setAutoEmergancyDSI(false);
                break;
            }
            case 1: {
                this.log.log(10000000, "[itemSelected#itemSelectedECallChoice] eCall is switched on.");
                this.setAutoEmergancyDSI(true);
                break;
            }
            default: {
                this.log.log(10000, "[itemSelected#itemSelectedECallChoice] Unhandled value");
            }
        }
    }

    public void setAutoEmergancyDSI(boolean bl) {
        this.log.log(10000000, "[TelAutomaticEmergencyCallHandler#setECallFlag] Called, flag: %1", bl);
        this.getApplication().getTelephoneDSIAccess().requestSetAutomaticEmergencyCallActive(bl, 0);
    }

    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    private void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting) {
        this.log.log(10000000, "[TelAutomaticEmergencyCallHandler#updateEmergencyCallActive] enter");
        boolean bl = emergencyCallSetting.isChangeable();
        this.showECallMenuItem(bl);
        this.isECallEnabled = emergencyCallSetting.isValue();
        if (this.isECallEnabled) {
            this.log.log(10000000, "[TelAutomaticEmergencyCallHandler#updateEmergencyCallActive] Called with value '%1', set HMI model to ON.", emergencyCallSetting.isValue());
            this.setECallEnabledModelVal(1);
        } else {
            this.log.log(10000000, "[TelAutomaticEmergencyCallHandler#updateEmergencyCallActive] Called with value '%1', set HMI model to OFF.", emergencyCallSetting.isValue());
            this.setECallEnabledModelVal(0);
        }
    }

    public void setECallEnabledModelVal(int n) {
        this.log.log(10000000, "[TelAutomaticEmergencyCallHandler#setECallModel] Called, value: %1", (long)n);
        this.getChoiceModel(300311).setValue(n);
    }

    public void showECallMenuItem(boolean bl) {
        this.log.log(10000000, "[TelAutomaticEmergencyCallHandler#showECallMenuItem] shouldShow: %1", bl);
        if (bl) {
            this.getChoiceModel(300331).setValue(1);
        } else {
            this.getChoiceModel(300331).setValue(0);
        }
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.gloablPhoneState = iGlobalTelephoneStateStruct;
        if (n == 65548) {
            if (iGlobalTelephoneStateStruct.getEmergencyCallActive() == null) {
                this.log.log(10000, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] missing global state or emergency call info");
            }
            this.updateEmergencyCallActive(iGlobalTelephoneStateStruct.getEmergencyCallActive());
        } else if (this.automaticECallDialed && n == 65544) {
            this.checkECallDialingStatus(iGlobalTelephoneStateStruct);
        }
    }

    void checkECallDialingStatus(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct = iGlobalTelephoneStateStruct.getCallState();
        if (callStateStruct != null) {
            AbstractPhoneCall abstractPhoneCall = callStateStruct.getEmergencyCall();
            if (abstractPhoneCall != null) {
                this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] automatic ECall is present.");
                if (abstractPhoneCall.getTelCallState() == 4) {
                    this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] automatic ECall is active.");
                    this.automaticECallSuccessful = true;
                }
            } else {
                if (!this.automaticECallSuccessful) {
                    this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] automatic ecall did not enter state active, starting redial timer.");
                    this.autoRedialTimer.start();
                } else {
                    this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#checkECallDialingStatus] automatic ecall established sucessfully.");
                }
                this.resetECallDialingStatusFlags();
            }
        }
    }

    public void airbagDataUpdate(AirbagData airbagData, int n) {
        if (n != 1) {
            this.log.log(10000000, "TelAutomaticEmergencyCallHandler#updateAirbagData: Invalid data: NOP!");
            return;
        }
        if (this.gloablPhoneState == null) {
            this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#airbagDataUpdate] telephone state is null --> NOP!");
            return;
        }
        this.airbagData = airbagData;
        this.checkDialEmergency(false);
    }

    private void checkDialEmergency(boolean bl) {
        boolean bl2 = this.isECallPresent();
        this.log.log(1000000, "TelAutomaticEmergencyCallHandler#checkDialEmergency: airbagData=%2,  this.isEmergancyCallPresnt = %1", bl2, (Object)this.airbagData);
        if (!bl2 && this.airbagData != null && this.crashIntensityReached(this.airbagData.getCrashIntensity()) && this.isAutomaticEmergencyCallAllowed(this.airbagData) && this.isAutomaticEmergencyCallPossible()) {
            this.log.log(1000000, "TelAutomaticEmergencyCallHandler#checkDialEmergency: dialing emergency call");
            this.dialEmergency(bl);
        } else {
            this.log.log(1000000, "TelAutomaticEmergencyCallHandler#checkDialEmergency: conditions not met - NOP!");
        }
    }

    public void dialEmergency(boolean bl) {
        String string;
        EmergencyNumbers emergencyNumbers = this.gloablPhoneState.getTelEmerNums();
        String string2 = string = emergencyNumbers != null ? emergencyNumbers.getMainEmergencyNumber() : null;
        if (string == null) {
            this.log.log(100000, "TelAutomaticEmergencyCallHandler#dialEmergency: cannot establish a call - emergancy number is null !");
            return;
        }
        this.log.log(10000000, "TelAutomaticEmergencyCallHandler#dialEmergency: sending a DSI request to place an emergancy call");
        if (bl) {
            if (++this.redialAttempt > this.maxRedialAttempts) {
                this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#dialEmergency] redial attempt %1. Max redial attempts (%2) reached. NOP!", (long)this.redialAttempt, (long)this.maxRedialAttempts);
                return;
            }
            this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#dialEmergency] redial attempt %1", (long)this.redialAttempt);
        }
        this.automaticECallDialed = true;
        this.getApplication().getTelephoneDSIAccess().dialNumber(string, 0, true, new TelDefaultDSIResponseListener(){

            public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                TelAutomaticEmergencyCallHandler.this.dialNumberResult(n);
            }
        });
        this.autoRedialTimer.cancel();
    }

    boolean isECallPresent() {
        CallInformation[] callInformationArray = this.gloablPhoneState.getCallList();
        if (callInformationArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
            if (callInformationArray[i2] == null || callInformationArray[i2].getTelCallType() != 3) continue;
            this.log.log(1000000, "TelAutomaticEmergencyCallHandler#isECallPresent - yes, returning true");
            return true;
        }
        this.log.log(1000000, "TelAutomaticEmergencyCallHandler#isECallPresen - no, returning false");
        return false;
    }

    boolean isAutomaticEmergencyCallAllowed(AirbagData airbagData) {
        if (airbagData == null) {
            this.log.log(10000, "TelAutomaticEmergencyCallHandler#isAutomaticEmergencyCallAllowed airbagData is null");
            return false;
        }
        boolean bl = airbagData.isDiagnosis();
        boolean bl2 = airbagData.isActuatorTest();
        this.log.log(1000000, "TelAutomaticEmergencyCallHandler#isAutomaticEmergencyCallAllowed: eCallSettingOn=%1, diagnose=%2, actuatorTest=%3", this.isECallEnabled, bl, bl2);
        return this.isECallEnabled && !bl && !bl2;
    }

    boolean crashIntensityReached(int n) {
        this.log.log(1000000, "TelAutomaticEmergencyCallHandler#crashIntensityReached: crashIntensity=%1", (long)n);
        return n == 3;
    }

    boolean isAutomaticEmergencyCallPossible() {
        boolean bl = this.gloablPhoneState.getPhoneModuleState() == 2;
        boolean bl2 = this.gloablPhoneState.getActivationState().getTelActivationState() == 5;
        this.log.log(1000000, "TelAutomaticEmergencyCallHandler#isAutomaticEmergencyCallPossible: isClamp15=%1, isNADBuiltIn=%2, isPhoneOn=%3", this.isClamp15, bl, bl2);
        return this.isClamp15 && (bl || bl2);
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#updateClampState] clampS=%1, clamp15=%2", bl, bl2);
        this.isClamp15 = bl2;
    }

    void setGloablPhoneStateDBG(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.gloablPhoneState = iGlobalTelephoneStateStruct;
    }

    IGlobalTelephoneStateStruct getGloablPhoneStateDBG() {
        return this.gloablPhoneState;
    }

    void setECallEnabledDBG(boolean bl) {
        this.isECallEnabled = bl;
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    void dialNumberResult(int n) {
        this.log.log(1000000, "[TelAutomaticEmergencyCallHandler#dialNumberResult] result=%1", (long)n);
        if (n != 0) {
            this.autoRedialTimer.start();
            this.resetECallDialingStatusFlags();
        }
    }

    void resetECallDialingStatusFlags() {
        this.automaticECallDialed = false;
        this.automaticECallSuccessful = false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelAutomaticEmergencyCallDiag
    implements IPhoneDiagComponent {
        private TelAutomaticEmergencyCallDiag() {
        }

        public void cmdTriggerCrash() {
            AirbagData airbagData = new AirbagData(3, false, false);
            TelAutomaticEmergencyCallHandler.this.airbagDataUpdate(airbagData, 1);
        }
    }

    private class TelDSIGeneralVehicleStatesListener
    extends DSIGeneralVehicleStatesListenerBase {
        private TelDSIGeneralVehicleStatesListener() {
        }

        public void updateAirbagData(AirbagData airbagData, int n) {
            TelAutomaticEmergencyCallHandler.this.airbagDataUpdate(airbagData, n);
        }
    }
}

