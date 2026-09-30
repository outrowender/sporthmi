/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.bap.telephone.IBAPPropertyTelLockStateService;
import de.audi.app.phone.core.bap.telephone2.IBAPPropertyTel2LockStateService;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.ITelLockStateHandler;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.SDSService;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class PhoneLockStateHandler
extends AbstractPhoneComponent
implements SpellerListener,
ChoiceListener,
ServiceTrackerCustomizer,
ITelLockStateHandler {
    private static final int NEW_PIN_COMPARE_NOK = 0;
    private static final int NEW_PIN_COMPARE_OK = 1;
    private static final int LOCKCODE_UNKNOWN = -1;
    public static final int PIN_MIN_LENGTH = 4;
    public static final int PIN_MAX_LENGTH = 8;
    static final int PUK_MIN_LENGTH = 8;
    static final int PUK_MAX_LENGTH = 8;
    public static final int LOCKSTATE_NOLOCK = 0;
    public static final int LOCKSTATE_ENTER_PIN = 1;
    public static final int LOCKSTATE_ENTER_PIN_2_ON_MOBILE = 2;
    public static final int LOCKSTATE_ENTER_PUK = 4;
    public static final int LOCKSTATE_ENTER_PUK_2_ON_MOBILE = 11;
    public static final int LOCKSTATE_PUK_BLOCKED = 6;
    public static final int LOCKSTATE_PUK2_BLOCKED = 3;
    public static final int LOCKSTATE_SIMNOTAVAILABLE = 51;
    public static final int LOCKSTATE_SIMNOTFUNCTIONAL = 53;
    public static final int LOCKSTATE_ENTER_NEW_PIN = 7;
    public static final int LOCKSTATE_CONFIRM_NEW_PIN = 8;
    public static final int LOCKSTATE_SECCO_REQUIRED = 9;
    public static final int LOCKSTATE_SECCO_BLOCKED = 10;
    public static final int LOCKSTATE_UNKNOWN = -1;
    public static final int AUTO_PIN_ON = 1;
    public static final int AUTO_PIN_OFF = 0;
    public static final int AUTO_PIN_DEFAULT = 1;
    public static final int PIN_SAVE_DIALOG_CHOICE_OFF = 0;
    public static final int PIN_SAVE_DIALOG_CHOICE_ON = 1;
    public static final int ENTER_PUK_CONDITION_PIN_BLOCKED = 0;
    public static final int ENTER_PUK_CONDITION_PUK_WRONG = 1;
    public static final int ENTER_PUK_EDIT = 2;
    private int lockCode = -1;
    private String currentPIN;
    private String changedPIN;
    private String currentPUK;
    private volatile boolean enteringManualPinPuk;
    private volatile PhoneServiceTracker serviceTracker;
    private volatile SDSService sdsService;
    protected volatile IGlobalTelephoneStateStruct telephoneState;
    protected boolean showPinSaveDialog;
    private volatile PhoneServiceTracker combiLockStateServiceTracker;
    private volatile IBAPPropertyTelLockStateService combiLockStateService;
    private volatile PhoneServiceTracker combiLockState2ServiceTracker;
    private volatile IBAPPropertyTel2LockStateService combiLockState2Service;
    private volatile PhoneServiceProvider lockStateHandlerServiceProvider;
    static /* synthetic */ Class class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService;
    static /* synthetic */ Class class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService;
    static /* synthetic */ Class class$de$audi$app$phone$core$sim$ITelLockStateHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    private static String getLockStateModelValueName(int n) {
        switch (n) {
            case 8: {
                return "LOCKSTATE_CONFIRM_NEW_PIN";
            }
            case 7: {
                return "LOCKSTATE_ENTER_NEW_PIN";
            }
            case 1: {
                return "LOCKSTATE_ENTER_PIN";
            }
            case 2: {
                return "LOCKSTATE_ENTER_PIN_2_ON_MOBILE";
            }
            case 4: {
                return "LOCKSTATE_ENTER_PUK";
            }
            case 11: {
                return "LOCKSTATE_ENTER_PUK_2_ON_MOBILE";
            }
            case 0: {
                return "LOCKSTATE_NOLOCK";
            }
            case 3: {
                return "LOCKSTATE_PUK2_BLOCKED";
            }
            case 6: {
                return "LOCKSTATE_PUK_BLOCKED";
            }
            case 10: {
                return "LOCKSTATE_SECCO_BLOCKED";
            }
            case 9: {
                return "LOCKSTATE_SECCO_REQUIRED";
            }
            case 51: {
                return "LOCKSTATE_SIMNOTAVAILABLE";
            }
            case 53: {
                return "LOCKSTATE_SIMNOTFUNCTIONAL";
            }
            case -1: {
                return "LOCKSTATE_UNKNOWN";
            }
        }
        return new StringBuffer().append("invalid lockStateModel value ").append(n).toString();
    }

    private static String getLockStateChoiceName(int n) {
        switch (n) {
            case 300664: {
                return "LOCK_STATE_CHOICE";
            }
            case 300612: {
                return "DATA_NAD_LOCK_STATE_CHOICE";
            }
            case 300952: {
                return "LOCK_STATE_ASSOCIATED_CHOICE";
            }
        }
        return new StringBuffer().append("not a lock state choice model!!! ").append(n).toString();
    }

    public PhoneLockStateHandler(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.addSubPhoneComponent(new PinBlockedHKReturnListener(iTelApplication));
        this.addSubPhoneComponent(new PinBlockedOkButtonListener(iTelApplication));
        this.addSubPhoneComponent(new PukWrongOkButtonListener(iTelApplication));
        this.addSubPhoneComponent(new PukWrongHkReturnButtonListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.initModels();
        this.combiLockStateServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService == null ? (class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService = PhoneLockStateHandler.class$("de.audi.app.phone.core.bap.telephone.IBAPPropertyTelLockStateService")) : class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.combiLockStateServiceTracker.openTracker();
        this.combiLockState2ServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService == null ? (class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService = PhoneLockStateHandler.class$("de.audi.app.phone.core.bap.telephone2.IBAPPropertyTel2LockStateService")) : class$de$audi$app$phone$core$bap$telephone2$IBAPPropertyTel2LockStateService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.combiLockState2ServiceTracker.openTracker();
        this.lockStateHandlerServiceProvider = new PhoneServiceProvider((class$de$audi$app$phone$core$sim$ITelLockStateHandler == null ? (class$de$audi$app$phone$core$sim$ITelLockStateHandler = PhoneLockStateHandler.class$("de.audi.app.phone.core.sim.ITelLockStateHandler")) : class$de$audi$app$phone$core$sim$ITelLockStateHandler).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.lockStateHandlerServiceProvider.startService();
    }

    public void deinit() {
        super.deinit();
        this.deinitModels();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        if (this.combiLockStateServiceTracker != null) {
            this.combiLockStateServiceTracker.closeTracker();
            this.combiLockStateServiceTracker = null;
        }
        if (this.combiLockState2ServiceTracker != null) {
            this.combiLockState2ServiceTracker.closeTracker();
            this.combiLockState2ServiceTracker = null;
        }
        if (this.lockStateHandlerServiceProvider != null) {
            this.lockStateHandlerServiceProvider.stopService();
            this.lockStateHandlerServiceProvider = null;
        }
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super.updateGlobalTelephoneStateProperty(n, iGlobalTelephoneStateStruct);
        this.telephoneState = iGlobalTelephoneStateStruct;
        this.updateAutomaticPinEntryActive(iGlobalTelephoneStateStruct.getNadInstanceState());
        if (n == 65551) {
            LockStateStruct lockStateStruct = iGlobalTelephoneStateStruct.getLockState();
            this.log.log(1000000, "[PhoneLockStateHandler#updateGlobalTelephoneStateProperty] update=%1, lockState=%2", (Object)GlobalTelephoneState.getAttributeName(n), (Object)lockStateStruct);
            this.updateLockState(this.getChoiceModel(300664), lockStateStruct);
        } else if (n == 196623 && iGlobalTelephoneStateStruct.getNadMode() == 2) {
            LockStateStruct lockStateStruct = iGlobalTelephoneStateStruct.getLockStateDSINAD();
            this.log.log(1000000, "[PhoneLockStateHandler#updateGlobalTelephoneStateProperty] update=%1, lockState=%2, nadMode=%3", (Object)GlobalTelephoneState.getAttributeName(n), (Object)lockStateStruct, (Object)String.valueOf(iGlobalTelephoneStateStruct.getNadMode()));
            this.updateLockState(this.getChoiceModel(300612), lockStateStruct);
        } else if (n == 262147 && iGlobalTelephoneStateStruct.getNadMode() == 2) {
            LockStateStruct lockStateStruct = iGlobalTelephoneStateStruct.getLockStateDSINAD();
            this.log.log(1000000, "[PhoneLockStateHandler#updateGlobalTelephoneStateProperty] update=%1, lockState=%2, nadMode=%3", (Object)GlobalTelephoneState.getAttributeName(n), (Object)lockStateStruct, (Object)String.valueOf(iGlobalTelephoneStateStruct.getNadMode()));
            this.updateLockState(this.getChoiceModel(300612), iGlobalTelephoneStateStruct.getLockStateDSINAD());
        }
    }

    protected void trackExternalServices() {
        this.log.log(10000000, "[PhoneLockStateHandler#trackExternalServices] called.");
        this.serviceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = PhoneLockStateHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.serviceTracker.openTracker();
    }

    protected void untrackExternalServices() {
        this.log.log(10000000, "[PhoneLockStateHandler#untrackExternalServices] called.");
        if (this.serviceTracker != null) {
            this.serviceTracker.closeTracker();
            this.serviceTracker = null;
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof SDSService) {
            this.log.log(10000000, "[PhoneLockStateHandler#addingService] adding SDSService");
            this.sdsService = (SDSService)object;
            return object;
        }
        if (object instanceof IBAPPropertyTelLockStateService) {
            this.combiLockStateService = (IBAPPropertyTelLockStateService)object;
            return object;
        }
        if (object instanceof IBAPPropertyTel2LockStateService) {
            this.combiLockState2Service = (IBAPPropertyTel2LockStateService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SDSService) {
            this.log.log(10000000, "[PhoneLockStateHandler#removedService] removing SDSService.");
            this.sdsService = null;
        } else if (object instanceof IBAPPropertyTelLockStateService) {
            this.combiLockStateService = null;
        } else if (object instanceof IBAPPropertyTel2LockStateService) {
            this.combiLockState2Service = null;
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    protected void initModels() {
        this.getCodeSpeller().setSpellerListener(this);
        this.getChoiceModel(300833).setValue(1);
        this.getChoiceModel(300497).setValue(1);
        this.getButtonModel(300223).setButtonListener(this);
        this.getButtonModel(300225).setButtonListener(this);
        this.getButtonModel(300751).setButtonListener(this);
        this.getButtonModel(300240).setButtonListener(this);
        this.getChoiceModel(300497).setChoiceListener(this);
        this.getButtonModel(300705).setButtonListener(this);
        this.getButtonModel(300826).setButtonListener(this);
        this.getButtonModel(300834).setButtonListener(this);
        this.getButtonModel(300835).setButtonListener(this);
        this.getButtonModel(300854).setButtonListener(this);
    }

    protected void deinitModels() {
        this.getCodeSpeller().resetListener();
        this.getButtonModel(300223).resetListener();
        this.getButtonModel(300225).resetListener();
        this.getButtonModel(300751).resetListener();
        this.getButtonModel(300240).resetListener();
        this.getButtonModel(300705).resetListener();
        this.getChoiceModel(300497).resetListener();
        this.getButtonModel(300826).resetListener();
        this.getButtonModel(300834).resetListener();
        this.getButtonModel(300835).resetListener();
        this.getButtonModel(300854).resetListener();
    }

    public void updateLockState(ChoiceModelApp choiceModelApp, LockStateStruct lockStateStruct) {
        int n;
        this.log.log(1000000, "[PhoneLockStateHandler#updateLockState] lockstate=%1", (Object)lockStateStruct);
        int n2 = lockStateStruct != null ? lockStateStruct.getTelLockState() : 0;
        int n3 = n = lockStateStruct != null ? lockStateStruct.getTelRetryCounter() : 0;
        if (n2 == 1 && this.enteringManualPinPuk) {
            this.getChoiceModel(300817).setValue(1);
        }
        switch (n2) {
            case 0: {
                this.setLockStateChoice(choiceModelApp, -1);
                this.log.log(10000000, "PhoneLockStateHandler#updateLockState: Lockstate unknown! ");
                break;
            }
            case 4: {
                this.setLockStateChoice(choiceModelApp, 2);
                this.log.log(10000000, "PhoneLockStateHandler#updateLockState: PIN2 required on mobile! ");
                break;
            }
            case 6: {
                this.setLockStateChoice(choiceModelApp, 11);
                this.log.log(10000000, "PhoneLockStateHandler#updateLockState: PUK2 required on mobile! ");
                break;
            }
            case 7: {
                this.setLockStateChoice(choiceModelApp, 6);
                this.log.log(10000000, "PhoneLockStateHandler#updateLockState: PUK blocked, SIM card out of order now! ");
                break;
            }
            case 8: {
                this.setLockStateChoice(choiceModelApp, 3);
                this.log.log(10000000, "PhoneLockStateHandler#updateLockState: PUK2 blocked, SIM card out of order now! ");
                break;
            }
            case 10: {
                this.setLockStateChoice(choiceModelApp, 10);
                this.log.log(10000000, "PhoneLockStateHandler#updateLockState: Mobile phone out of order now! ");
                break;
            }
            case 9: {
                this.setLockStateChoice(choiceModelApp, 9);
                break;
            }
            case 11: {
                this.setLockStateChoice(choiceModelApp, 53);
                break;
            }
            case 2: {
                this.processLockStateNoLock(choiceModelApp);
                break;
            }
            case 3: {
                this.processLockStateRequirePIN(choiceModelApp, n);
                break;
            }
            case 5: {
                this.processLockStateRequiredPUK(choiceModelApp, n);
                break;
            }
            case 1: {
                this.processLockStateUnlockInProgress();
                break;
            }
            default: {
                this.setLockStateChoice(choiceModelApp, -1);
                this.log.log(10000, "PhoneLockStateHandler#updateLockState: Unhandled lockState %1! ", (long)n2);
            }
        }
    }

    protected ChoiceModelApp getLockStateChoice() {
        int n = this.telephoneState.getNadMode();
        return n == 1 ? this.getChoiceModel(300664) : this.getChoiceModel(300612);
    }

    private void setLockStateChoice(ChoiceModelApp choiceModelApp, int n) {
        if (choiceModelApp != null) {
            if (choiceModelApp.getID() == 300664 || choiceModelApp.getID() == 300612 || choiceModelApp.getID() == 300952) {
                this.log.log(1000000, "[PhoneLockStateHandler#setLockStateChoice] lockStateChoice=%1, modelValue=%2", (Object)PhoneLockStateHandler.getLockStateChoiceName(choiceModelApp.getID()), (Object)PhoneLockStateHandler.getLockStateModelValueName(n));
                choiceModelApp.setValue(n);
            } else {
                this.log.log(100000, "[PhoneLockStateHandler#setLockStateChoice] model %1 is not a lock state choice model!", (long)choiceModelApp.getID());
            }
        } else {
            this.log.log(100000, "[PhoneLockStateHandler#setLockStateChoice] lockStateChoice is null --> NOP!");
        }
    }

    private void processLockStateRequiredPUK(ChoiceModelApp choiceModelApp, int n) {
        this.log.log(10000000, "PhoneLockStateHandler#processLockStateRequiredPUK: called ");
        this.getLabelModel(300230).setText(String.valueOf(n));
        switch (this.getLockCode()) {
            case -1: {
                this.getChoiceModel(300376).setValue(2);
                this.log.log(10000000, "PhoneLockStateHandler#processLockStateRequiredPUK: Displaying TEL_PUK_EDIT immediately! ");
                break;
            }
            case 0: {
                this.getChoiceModel(300376).setValue(0);
                this.log.log(10000000, "PhoneLockStateHandler#processLockStateRequiredPUK: Displaying TEL_PUK_PIN_BLOCKED! ");
                break;
            }
            case 2: {
                this.getChoiceModel(300376).setValue(1);
                this.log.log(10000000, "PhoneLockStateHandler#processLockStateRequiredPUK: Displaying TEL_PUK_WRONG! ");
                break;
            }
            default: {
                this.log.log(10000, "PhoneLockStateHandler#processLockStateRequiredPUK: Unhandled codeType %1! ", (long)this.getLockCode());
            }
        }
        this.initSpellerModel(300594, 8, 8);
        this.setLockStateChoice(choiceModelApp, 4);
    }

    private void processLockStateRequirePIN(ChoiceModelApp choiceModelApp, int n) {
        this.log.log(100000, "PhoneLockStateHandler#processLockStateRequirePIN: [Startup] Phase 4: LockState RequirePIN reached! ");
        this.log.log(10000000, "PhoneLockStateHandler#processLockStateRequirePIN: counter=%1 ", (long)n);
        this.getLabelModel(300224).setText(String.valueOf(n));
        this.setLockStateChoice(choiceModelApp, 1);
        if (this.getLockCode() == 0) {
            this.resetLockCode();
            this.log.log(10000000, "PhoneLockStateHandler#processLockStateRequirePIN(int): Displaying TEL_PIN_WRONG! ");
            this.getCodeSpeller().fireEvent(0);
            this.getChoiceModel(300373).setStatus(1);
        }
        this.initCodeSpeller();
    }

    protected void processLockStateNoLock(ChoiceModelApp choiceModelApp) {
        this.triggerPINSaveDialog(choiceModelApp);
        this.setLockStateChoice(choiceModelApp, 0);
        this.resetLockCode();
    }

    private void triggerPINSaveDialog(ChoiceModelApp choiceModelApp) {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        int n = choiceModelApp.getValue();
        int n2 = this.getChoiceModel(300497).getValue();
        int n3 = iGlobalTelephoneStateStruct.getNadMode() == 1 ? iGlobalTelephoneStateStruct.getTelMode() : iGlobalTelephoneStateStruct.getTelModeDSINAD();
        this.log.log(1000000, "[PhoneLockStateHandler#triggerPINSaveDialog] telMode=%1, lsModelValue=%2, enteringManualPIN=%3, autoPINValue=%4 ", (Object)new Integer(n3), (Object)new Integer(n), (Object)this.enteringManualPinPuk, (Object)new Integer(n2));
        if (this.checkPINSaveScreenConditions(n3, n, this.enteringManualPinPuk, n2)) {
            this.showPinSaveDialog = true;
            this.getChoiceModel(300226).setValue(1);
            this.log.log(1000000, "[PhoneLockStateHandler#triggerPINSaveDialog] PIN entered manually, displaying TEL_PIN_SAVE_MAIN!");
        } else {
            this.showPinSaveDialog = false;
            this.getChoiceModel(300226).setValue(0);
            this.log.log(1000000, "[PhoneLockStateHandler#triggerPINSaveDialog] Do not show TEL_PIN_SAVE_MAIN!");
        }
    }

    private boolean checkPINSaveScreenConditions(int n, int n2, boolean bl, int n3) {
        return n != 3 && n != 4 && n3 == 1 && (n2 == 8 || bl && n2 == 1);
    }

    private void processLockStateUnlockInProgress() {
        this.getChoiceModel(300373).setStatus(0);
        this.getCodeSpeller().setStatus(0);
        this.log.log(10000000, "PhoneLockStateHandler#processLockStateUnlockInProgress: Unlock in progress! ");
    }

    public void initCodeSpeller() {
        this.log.log(10000000, "PhoneLockStateHandler#initCodeSpeller: called ");
        this.initSpellerModel(300594, 4, 8);
        this.setNumberSpellerContentModel("");
        if (this.sdsService != null) {
            this.log.log(1000000, "[PhoneLockStateHandler#initCodeSpeller] calling clearPINSequence to SDS.");
            this.sdsService.textChanged(this.getCodeSpeller().getID(), "", '\u0000');
        } else {
            this.log.log(100000, "PhoneLockStateHandler#initCodeSpeller: phoneServiceListener is null");
        }
    }

    public void initCodeSpeller(int n) {
        this.log.log(10000000, "PhoneLockStateHandler#initCodeSpeller: called ");
        switch (n) {
            case 3: {
                this.initSpellerModel(300594, 4, 8);
                break;
            }
            case 5: {
                this.initSpellerModel(300594, 8, 8);
                break;
            }
            default: {
                this.initSpellerModelWithoutClearIt(300594, 4, 8);
            }
        }
        this.setNumberSpellerContentModel("");
        if (this.sdsService != null) {
            this.log.log(1000000, "[PhoneLockStateHandler#initCodeSpeller] calling clearPINSequence to SDS.");
            this.sdsService.textChanged(this.getCodeSpeller().getID(), "", '\u0000');
        } else {
            this.log.log(100000, "PhoneLockStateHandler#initCodeSpeller: phoneServiceListener is null");
        }
    }

    public void setNumberSpellerContentModel(String string) {
        String string2 = PhoneUtils.privatize(string, false);
        this.getLabelModel(300206).setText(string2);
        this.log.log(10000000, "PhoneLockStateHandler#setNumberSpellerContentModel: numberSpellerContentLabel.text=%1 ", (Object)string2);
    }

    public void initSpellerModelWithoutClearIt(int n, int n2, int n3) {
        SpellerModelApp spellerModelApp = this.getSpellerModel(n);
        spellerModelApp.setMinLength(n2);
        spellerModelApp.setMaxLength(n3);
        spellerModelApp.setStatus(1);
        this.getButtonModel(300705).setStatus(0);
        this.log.log(10000000, "PhoneLockStateHandler#initSpellerModelWithoutClearIt: Speller with ID %1 initialized with min=%2, max=%3 ", (long)n, (long)n2, (long)n3);
    }

    public void initSpellerModel(int n, int n2, int n3) {
        SpellerModelApp spellerModelApp = this.getSpellerModel(n);
        spellerModelApp.clear();
        spellerModelApp.setMinLength(n2);
        spellerModelApp.setMaxLength(n3);
        spellerModelApp.setStatus(1);
        this.getButtonModel(300705).setStatus(0);
        this.log.log(10000000, "PhoneLockStateHandler#initSpellerModel: Speller with ID %1 initialized with min=%2, max=%3 ", (long)n, (long)n2, (long)n3);
    }

    int getLockCode() {
        return this.lockCode;
    }

    void setLockCode(int n) {
        this.lockCode = n;
        this.log.log(10000000, "PhoneLockStateHandler#setLockCode: codeType=%1 ", (long)this.lockCode);
    }

    private void resetLockCode() {
        this.lockCode = -1;
    }

    private void keyTypedCodeSpeller(int n) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedCodeSpeller: called ");
        int n2 = this.getLockStateChoice().getValue();
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedCodeSpeller: lockState=%1 ", (long)n2);
        String string = this.getCodeSpeller().getText();
        switch (n2) {
            case 1: {
                this.keyTypedRequirePIN(string, n);
                break;
            }
            case 4: {
                this.keyTypedPUKEntered(string);
                break;
            }
            case 7: {
                this.keyTypedNewPinEntered(string);
                break;
            }
            case 8: {
                this.keyTypedNewPINConfirmed(string, n);
                break;
            }
            default: {
                this.log.log(10000, "PhoneLockStateHandler#keyTypedCodeSpeller: Unhandled lockState %1! ", (long)n2);
            }
        }
    }

    private void keyTypedRequirePIN(String string, int n) {
        this.currentPIN = string;
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedRequirePIN: pinCode=%1, currentPIN=%2 ", (Object)string, (Object)this.currentPIN);
        this.unlockSIMwithPIN(string, n, null);
        if (this.sdsService != null) {
            this.sdsService.abortSDSSession(true, (byte)7);
        }
    }

    public void unlockSIMwithPIN(String string, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        this.log.log(1000000, "[PhoneLockStateHandler#unlockSIMwithPIN] pinCode=%1", (Object)string);
        this.setLockCode(0);
        this.getChoiceModel(300373).setStatus(0);
        this.enteringManualPinPuk = true;
        this.getApplication().getTelephoneDSIAccess().unlockSIMWithPIN(string, n, true, new SIMUnlockDSIResponseListener(iTelDSIResponseListener));
    }

    private void unlockResponse(int n, int n2, LockStateStruct lockStateStruct) {
        this.log.log(1000000, "[PhoneLockStateHandler.TelLockStateResponseListener#responseUnlockSIM] result=%1", (long)n);
        this.getChoiceModel(300817).setValue(0);
        this.enteringManualPinPuk = false;
        if (lockStateStruct != null) {
            this.initCodeSpeller(lockStateStruct.getTelLockState());
        } else {
            this.initCodeSpeller(0);
        }
    }

    private void unlockSIMWithPUK(int n, ITelDSIResponseListener iTelDSIResponseListener) {
        this.setLockCode(2);
        this.getChoiceModel(300373).setStatus(0);
        this.enteringManualPinPuk = true;
        this.getApplication().getTelephoneDSIAccess().unlockSIMWithPUK(this.currentPUK, this.changedPIN, n, true, new SIMUnlockDSIResponseListener(iTelDSIResponseListener));
    }

    private void keyTypedPUKEntered(String string) {
        IBAPPropertyTelLockStateService iBAPPropertyTelLockStateService;
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedPUKEntered: PUK entered, PIN invalid, pukCode=%1 ", (Object)string);
        this.currentPUK = string;
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedPUKEntered: currentPUK=%1 ", (Object)this.currentPUK);
        this.initCodeSpeller();
        int n = this.telephoneState.getNadMode();
        if (n == 2) {
            IBAPPropertyTel2LockStateService iBAPPropertyTel2LockStateService = this.combiLockState2Service;
            if (iBAPPropertyTel2LockStateService != null) {
                iBAPPropertyTel2LockStateService.updateLockStatePUKNewPINRequired();
            }
        } else if (n == 1 && (iBAPPropertyTelLockStateService = this.combiLockStateService) != null) {
            iBAPPropertyTelLockStateService.updateLockStatePUKNewPINRequired();
        }
        this.setLockStateChoice(this.getLockStateChoice(), 7);
    }

    private void keyTypedNewPinEntered(String string) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedNewPinEntered: Called, new pinCode=%1 ", (Object)string);
        this.changedPIN = string;
        this.initCodeSpeller();
        this.setLockStateChoice(this.getLockStateChoice(), 8);
    }

    private void keyTypedNewPINConfirmed(String string, int n) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedNewPINConfirmed: changedPIN %1 has to be confirmed! ", (Object)this.changedPIN);
        if (string.equals(this.changedPIN)) {
            this.currentPIN = this.changedPIN;
            this.log.log(10000000, "PhoneLockStateHandler#keyTypedNewPINConfirmed: changedPIN %1 was confirmed, currentPIN=%2 ", (Object)this.changedPIN, (Object)this.currentPIN);
            this.getChoiceModel(300833).setValue(1);
            this.unlockSIMWithPUK(n, null);
        } else {
            this.log.log(10000000, "PhoneLockStateHandler#keyTypedNewPINConfirmed: Entered PIN %1 NOT confirmed, entering TEL_PUK_PIN_WRONG! ", (Object)string);
            this.getChoiceModel(300833).setValue(0);
            this.enterTelPinPukWrong();
        }
    }

    protected void enterTelPinPukWrong() {
        this.getCodeSpeller().fireEvent(0);
        this.initCodeSpeller();
    }

    protected SpellerModelApp getCodeSpeller() {
        return this.getSpellerModel(300594);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "PhoneLockStateHandler#keyTyped: model=%1 ", (long)n);
        switch (n) {
            case 300594: 
            case 300705: {
                this.keyTypedCodeSpeller(n3);
                break;
            }
            case 300225: {
                this.keyTypedPINSaveButton(n3);
                break;
            }
            case 300751: {
                this.keyTypedPINSaveConfirmedButton(n3);
                break;
            }
            case 300223: {
                this.keyTypedPINDontSaveButton(n3);
                break;
            }
            case 300240: {
                this.keyTypedPINAutoButton(n3);
                break;
            }
            case 300826: {
                this.keyTypedPINLeftHkBackButton(n3);
                break;
            }
            case 300834: {
                this.keyTypedNewPinWrongConfirmedButton(n3);
                break;
            }
            case 300835: {
                this.keyTypedEnterNewPinEnteredHKReturnButton(n3);
                break;
            }
            case 300854: {
                this.keyTypedPUKEnteredHKReturnButton(n3);
                break;
            }
            default: {
                this.log.log(10000, "PhoneLockStateHandler#keyTyped: No handling for modelId=%1 ", (long)n);
            }
        }
    }

    private void keyTypedPUKEnteredHKReturnButton(int n) {
        this.log.log(10000000, "[PhoneLockStateHandler#keyTypedPUKEnteredHKReturnButton]");
        this.getChoiceModel(300376).setValue(2);
        this.initSpellerModel(300594, 8, 8);
        this.getButtonModel(300854).fireEvent(n);
        this.setLockStateChoice(this.getLockStateChoice(), 4);
    }

    private void keyTypedEnterNewPinEnteredHKReturnButton(int n) {
        this.log.log(10000000, "[PhoneLockStateHandler#keyTypedEnterNewPinEnteredHKReturnButton]");
        this.setLockStateChoice(this.getLockStateChoice(), 7);
    }

    protected void keyTypedNewPinWrongConfirmedButton(int n) {
        this.log.log(10000000, "[PhoneLockStateHandler#keyTypedNewPinWrongConfirmedButton]");
        this.getButtonModel(300834).fireEvent(n);
        this.setLockStateChoice(this.getLockStateChoice(), 7);
    }

    protected void keyTypedPINSaveConfirmedButton(int n) {
        this.log.log(10000000, "[PhoneLockStateHandler#keyTypedPINSaveConfirmedButton]");
        this.getButtonModel(300751).fireEvent(n);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    protected void keyTypedPINSaveButton(int n) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedPINSaveButton: called ");
        this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n);
        this.getChoiceModel(300226).setValue(0);
        this.getButtonModel(300225).fireEvent(n);
    }

    protected void keyTypedPINDontSaveButton(int n) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedPINDontSaveButton: called ");
        this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(false, n);
        this.getChoiceModel(300226).setValue(0);
        this.getButtonModel(300223).fireEvent(n);
    }

    protected void keyTypedPINLeftHkBackButton(int n) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedPINLeftHkBackButton: called ");
        this.getChoiceModel(300226).setValue(0);
        this.getButtonModel(300826).fireEvent(n);
    }

    private void keyTypedPINAutoButton(int n) {
        this.log.log(10000000, "PhoneLockStateHandler#keyTypedPINAutoButton: called ");
        this.getButtonModel(300240).fireEvent(n);
    }

    public void setPINSpeller(String string) {
        this.log.log(1000000, "[PhoneLockStateHandler#setPINSpeller] pinCode=%1", (Object)string);
        this.getCodeSpeller().setText(string);
        this.setOKButtonEnabled(string);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[PhoneLockStateHandler#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        if (n == this.getCodeSpeller().getID()) {
            this.setOKButtonEnabled(string);
            if (this.sdsService != null) {
                if (string != null && string.length() > 0) {
                    this.log.log(1000000, "[PhoneLockStateHandler#textChanged] notifying SDS with matchTextWithPINSequence: text=%1", (Object)string);
                    this.sdsService.textChanged(this.getCodeSpeller().getID(), string, c2);
                } else {
                    this.log.log(1000000, "[PhoneLockStateHandler#textChanged] notifying SDS with clearPINSequence: text=%1", (Object)string);
                    this.sdsService.textChanged(this.getCodeSpeller().getID(), "", '\u0000');
                }
            } else {
                this.log.log(10000000, "[PhoneLockStateHandler#textChangedCodeSpeller] sdsService is null!");
            }
        }
    }

    private void setOKButtonEnabled(String string) {
        int n = this.getCodeSpeller().getMinLength();
        int n2 = this.getCodeSpeller().getMaxLength();
        if (string != null) {
            if (string.length() >= n && string.length() <= n2) {
                this.getButtonModel(300705).setStatus(1);
            } else {
                this.getButtonModel(300705).setStatus(0);
            }
        } else {
            this.getButtonModel(300705).setStatus(0);
        }
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1000000, "PhoneLockStateHandler#itemSelected: id=%1, itemID=%2", (long)n, (long)n2);
        switch (n) {
            case 300497: {
                this.itemSelectedAutoPINChoice(n2, n4);
                break;
            }
            default: {
                this.log.log(10000, "PhoneLockStateHandler#itemSelected: No handling for modelId=%1, itemID=%2", (long)n, (long)n2);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelectedAutoPINChoice(int n, int n2) {
        this.log.log(10000000, "PhoneLockStateHandler#itemSelectedAutoPINChoice: index=%1 ", (long)n);
        switch (n) {
            case 0: {
                this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(false, n2);
                break;
            }
            case 1: {
                this.getApplication().getTelephoneDSIAccess().setAutomaticPINEntryActive(true, n2);
                break;
            }
            default: {
                this.log.log(10000, "PhoneLockStateHandler#itemSelectedAutoPINChoice: Unhandled index %1! ", (long)n);
            }
        }
    }

    public void updateAutomaticPinEntryActive(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            boolean bl = iTelDSIMobileEquipmentDeviceState.isAutomaticPinEntryActive();
            if (bl) {
                this.log.log(10000000, "[PhoneLockStateHandler#updateAutomaticPinEntryActive] Called with value '%1', set auto PIN to ON.", bl);
                this.getChoiceModel(300497).setValue(1);
            } else {
                this.log.log(10000000, "[PhoneLockStateHandler#updateAutomaticPinEntryActive] Called with value '%1', set auto PIN to OFF.", bl);
                this.getChoiceModel(300497).setValue(0);
            }
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    protected void resetPukConditionChoice() {
        this.getChoiceModel(300376).setValue(2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class PukWrongOkButtonListener
    extends TelDefaultButtonListener {
        public PukWrongOkButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300991);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[PhoneLockStateHandler.PukWrongOkButtonListener#keyTyped]");
            PhoneLockStateHandler.this.resetPukConditionChoice();
            PhoneLockStateHandler.this.resetLockCode();
            this.fireEvent(n3);
        }
    }

    private class PinBlockedHKReturnListener
    extends TelDefaultButtonListener {
        public PinBlockedHKReturnListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300986);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[PhoneLockStateHandler.PinBlockedHKReturnListener#keyTyped]");
            PhoneLockStateHandler.this.resetPukConditionChoice();
            PhoneLockStateHandler.this.resetLockCode();
            this.fireEvent(n3);
        }
    }

    private class PinBlockedOkButtonListener
    extends TelDefaultButtonListener {
        public PinBlockedOkButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300985);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[PhoneLockStateHandler.PinBlockedOkButtonListener#keyTyped]");
            PhoneLockStateHandler.this.resetPukConditionChoice();
            PhoneLockStateHandler.this.resetLockCode();
            this.fireEvent(n3);
        }
    }

    private class SIMUnlockDSIResponseListener
    extends TelDefaultDSIResponseListener {
        private final ITelDSIResponseListener responseListener;

        public SIMUnlockDSIResponseListener(ITelDSIResponseListener iTelDSIResponseListener) {
            this.responseListener = iTelDSIResponseListener;
        }

        public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
            PhoneLockStateHandler.this.unlockResponse(n, n2, lockStateStruct);
            if (this.responseListener != null) {
                this.responseListener.responseUnlockSIM(n, n2, lockStateStruct);
            }
        }
    }

    private class PukWrongHkReturnButtonListener
    extends TelDefaultButtonListener {
        public PukWrongHkReturnButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300992);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[PhoneLockStateHandler.PukWrongHkReturnButtonListener#keyTyped]");
            PhoneLockStateHandler.this.resetPukConditionChoice();
            PhoneLockStateHandler.this.resetLockCode();
            this.fireEvent(n3);
        }
    }
}

