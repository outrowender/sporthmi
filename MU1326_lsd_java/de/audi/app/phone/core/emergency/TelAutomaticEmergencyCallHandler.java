/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$1;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$2;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$3;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$TelAutomaticEmergencyCallDiag;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$TelDSIGeneralVehicleStatesListener;
import de.audi.app.phone.core.power.IPowerEventListener;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.atip.timer.Timer;
import de.audi.mib.jdsi.DSIActivator;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.osgi.framework.BundleContext;

public class TelAutomaticEmergencyCallHandler
extends AbstractPhoneComponent
implements ChoiceListener,
IPowerEventListener {
    private static final long REDIAL_TIMOUT_DEFAULT;
    private static final int MAX_REDIAL_ATTEMPTS_DEFAULT;
    private static final int ECALL_ON;
    private static final int ECALL_OFF;
    private static final int ECALL_MENU_ITEM_SHOW;
    private static final int ECALL_MENU_ITEM_HIDE;
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
        this(iTelApplication, 0);
    }

    public TelAutomaticEmergencyCallHandler(ITelApplication iTelApplication, long l) {
        super(iTelApplication, "App.Phone.Main");
        this.bundleContext = iTelApplication.getBundleContext();
        this.maxRedialAttempts = iTelApplication.getFrameworkAccess().getSysApp() != null && iTelApplication.getFrameworkAccess().getSysApp().getAdaptationANP() != null ? iTelApplication.getFrameworkAccess().getSysApp().getAdaptationANP().getEmergencyEstablishLinkAttempts() : 4;
        this.autoRedialTimer = new Timer("AutoECallRedialTimer", 5, NullLogChannel.getInstance(), new TelAutomaticEmergencyCallHandler$1(this), l, true);
        this.dsiGeneralVehicleStatesActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = TelAutomaticEmergencyCallHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = TelAutomaticEmergencyCallHandler.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName(), new Integer(0), new TelAutomaticEmergencyCallHandler$TelDSIGeneralVehicleStatesListener(this, null), new TelAutomaticEmergencyCallHandler$2(this));
    }

    void setMaxRedialAttempts(int n) {
        this.maxRedialAttempts = n;
    }

    @Override
    public void init() {
        this.getApplication().addDiagnosisComponent(new TelAutomaticEmergencyCallHandler$TelAutomaticEmergencyCallDiag(this, null));
        this.getChoiceModel(395641856).setChoiceListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
        this.dsiGeneralVehicleStatesActivator.start(this.bundleContext);
    }

    @Override
    public void deinit() {
        this.getChoiceModel(395641856).resetListener();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        this.dsiGeneralVehicleStatesActivator.stop(this.bundleContext);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "TelAutomaticEmergencyCallHandler#itemSelected: id=%1, row=%2", (long)n, (long)n2);
        if (n != 395641856) {
            this.log.log(10000, "TelAutomaticEmergencyCallHandler#itemSelected: Unhandled id %1! ", (long)n);
            return;
        }
        switch (n2) {
            case 0: {
                this.log.log(-2137614336, "[itemSelected#itemSelectedECallChoice] eCall is switched off.");
                this.setAutoEmergancyDSI(false);
                break;
            }
            case 1: {
                this.log.log(-2137614336, "[itemSelected#itemSelectedECallChoice] eCall is switched on.");
                this.setAutoEmergancyDSI(true);
                break;
            }
            default: {
                this.log.log(10000, "[itemSelected#itemSelectedECallChoice] Unhandled value");
            }
        }
    }

    public void setAutoEmergancyDSI(boolean bl) {
        this.log.log(-2137614336, "[TelAutomaticEmergencyCallHandler#setECallFlag] Called, flag: %1", bl);
        this.getApplication().getTelephoneDSIAccess().requestSetAutomaticEmergencyCallActive(bl, 0);
    }

    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    private void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting) {
        this.log.log(-2137614336, "[TelAutomaticEmergencyCallHandler#updateEmergencyCallActive] enter");
        boolean bl = emergencyCallSetting.isChangeable();
        this.showECallMenuItem(bl);
        this.isECallEnabled = emergencyCallSetting.isValue();
        if (this.isECallEnabled) {
            this.log.log(-2137614336, "[TelAutomaticEmergencyCallHandler#updateEmergencyCallActive] Called with value '%1', set HMI model to ON.", emergencyCallSetting.isValue());
            this.setECallEnabledModelVal(1);
        } else {
            this.log.log(-2137614336, "[TelAutomaticEmergencyCallHandler#updateEmergencyCallActive] Called with value '%1', set HMI model to OFF.", emergencyCallSetting.isValue());
            this.setECallEnabledModelVal(0);
        }
    }

    public void setECallEnabledModelVal(int n) {
        this.log.log(-2137614336, "[TelAutomaticEmergencyCallHandler#setECallModel] Called, value: %1", (long)n);
        this.getChoiceModel(395641856).setValue(n);
    }

    public void showECallMenuItem(boolean bl) {
        this.log.log(-2137614336, "[TelAutomaticEmergencyCallHandler#showECallMenuItem] shouldShow: %1", bl);
        if (bl) {
            this.getChoiceModel(731186176).setValue(1);
        } else {
            this.getChoiceModel(731186176).setValue(0);
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.gloablPhoneState = iGlobalTelephoneStateStruct;
        if (n == 0xC000100) {
            if (iGlobalTelephoneStateStruct.getEmergencyCallActive() == null) {
                this.log.log(10000, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] missing global state or emergency call info");
            }
            this.updateEmergencyCallActive(iGlobalTelephoneStateStruct.getEmergencyCallActive());
        } else if (this.automaticECallDialed && n == 0x8000100) {
            this.checkECallDialingStatus(iGlobalTelephoneStateStruct);
        }
    }

    void checkECallDialingStatus(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct = iGlobalTelephoneStateStruct.getCallState();
        if (callStateStruct != null) {
            AbstractPhoneCall abstractPhoneCall = callStateStruct.getEmergencyCall();
            if (abstractPhoneCall != null) {
                this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] automatic ECall is present.");
                if (abstractPhoneCall.getTelCallState() == 4) {
                    this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] automatic ECall is active.");
                    this.automaticECallSuccessful = true;
                }
            } else {
                if (!this.automaticECallSuccessful) {
                    this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#updateGlobalTelephoneStateProperty] automatic ecall did not enter state active, starting redial timer.");
                    this.autoRedialTimer.start();
                } else {
                    this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#checkECallDialingStatus] automatic ecall established sucessfully.");
                }
                this.resetECallDialingStatusFlags();
            }
        }
    }

    public void airbagDataUpdate(AirbagData airbagData, int n) {
        if (n != 1) {
            this.log.log(-2137614336, "TelAutomaticEmergencyCallHandler#updateAirbagData: Invalid data: NOP!");
            return;
        }
        if (this.gloablPhoneState == null) {
            this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#airbagDataUpdate] telephone state is null --> NOP!");
            return;
        }
        this.airbagData = airbagData;
        this.checkDialEmergency(false);
    }

    private void checkDialEmergency(boolean bl) {
        boolean bl2 = this.isECallPresent();
        this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#checkDialEmergency: airbagData=%2,  this.isEmergancyCallPresnt = %1", bl2, (Object)this.airbagData);
        if (!bl2 && this.airbagData != null && this.crashIntensityReached(this.airbagData.getCrashIntensity()) && this.isAutomaticEmergencyCallAllowed(this.airbagData) && this.isAutomaticEmergencyCallPossible()) {
            this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#checkDialEmergency: dialing emergency call");
            this.dialEmergency(bl);
        } else {
            this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#checkDialEmergency: conditions not met - NOP!");
        }
    }

    public void dialEmergency(boolean bl) {
        String string;
        EmergencyNumbers emergencyNumbers = this.gloablPhoneState.getTelEmerNums();
        String string2 = string = emergencyNumbers != null ? emergencyNumbers.getMainEmergencyNumber() : null;
        if (string == null) {
            this.log.log(-1601830656, "TelAutomaticEmergencyCallHandler#dialEmergency: cannot establish a call - emergancy number is null !");
            return;
        }
        this.log.log(-2137614336, "TelAutomaticEmergencyCallHandler#dialEmergency: sending a DSI request to place an emergancy call");
        if (bl) {
            if (++this.redialAttempt > this.maxRedialAttempts) {
                this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#dialEmergency] redial attempt %1. Max redial attempts (%2) reached. NOP!", (long)this.redialAttempt, (long)this.maxRedialAttempts);
                return;
            }
            this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#dialEmergency] redial attempt %1", (long)this.redialAttempt);
        }
        this.automaticECallDialed = true;
        this.getApplication().getTelephoneDSIAccess().dialNumber(string, 0, true, new TelAutomaticEmergencyCallHandler$3(this));
        this.autoRedialTimer.cancel();
    }

    boolean isECallPresent() {
        CallInformation[] callInformationArray = this.gloablPhoneState.getCallList();
        if (callInformationArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
            if (callInformationArray[i2] == null || callInformationArray[i2].getTelCallType() != 3) continue;
            this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#isECallPresent - yes, returning true");
            return true;
        }
        this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#isECallPresen - no, returning false");
        return false;
    }

    boolean isAutomaticEmergencyCallAllowed(AirbagData airbagData) {
        if (airbagData == null) {
            this.log.log(10000, "TelAutomaticEmergencyCallHandler#isAutomaticEmergencyCallAllowed airbagData is null");
            return false;
        }
        boolean bl = airbagData.isDiagnosis();
        boolean bl2 = airbagData.isActuatorTest();
        this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#isAutomaticEmergencyCallAllowed: eCallSettingOn=%1, diagnose=%2, actuatorTest=%3", this.isECallEnabled, bl, bl2);
        return this.isECallEnabled && !bl && !bl2;
    }

    boolean crashIntensityReached(int n) {
        this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#crashIntensityReached: crashIntensity=%1", (long)n);
        return n == 3;
    }

    boolean isAutomaticEmergencyCallPossible() {
        boolean bl = this.gloablPhoneState.getPhoneModuleState() == 2;
        boolean bl2 = this.gloablPhoneState.getActivationState().getTelActivationState() == 5;
        this.log.log(1078071040, "TelAutomaticEmergencyCallHandler#isAutomaticEmergencyCallPossible: isClamp15=%1, isNADBuiltIn=%2, isPhoneOn=%3", this.isClamp15, bl, bl2);
        return this.isClamp15 && (bl || bl2);
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#updateClampState] clampS=%1, clamp15=%2", bl, bl2);
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

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n) {
    }

    @Override
    public void notifyPowerTriggerAction(int n) {
    }

    void dialNumberResult(int n) {
        this.log.log(1078071040, "[TelAutomaticEmergencyCallHandler#dialNumberResult] result=%1", (long)n);
        if (n != 0) {
            this.autoRedialTimer.start();
            this.resetECallDialingStatusFlags();
        }
    }

    void resetECallDialingStatusFlags() {
        this.automaticECallDialed = false;
        this.automaticECallSuccessful = false;
    }

    static /* synthetic */ LogChannel access$000(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        return telAutomaticEmergencyCallHandler.log;
    }

    static /* synthetic */ void access$100(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler, boolean bl) {
        telAutomaticEmergencyCallHandler.checkDialEmergency(bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$300(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        return telAutomaticEmergencyCallHandler.log;
    }

    static /* synthetic */ LogChannel access$400(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        return telAutomaticEmergencyCallHandler.log;
    }
}

