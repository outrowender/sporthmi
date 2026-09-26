/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$1;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$AbstractState;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$TMActiveState;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$TMInactiveState;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$TelTerminalModeDiag;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$TerminalModeUpdateListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;

public class TelTerminalModeHandler
extends AbstractPhoneComponent {
    private static final int ENABLE_CAR_PLAY_DISCLAIMER;
    private static final int DISABLE_CAR_PLAY_DISCLAIMER;
    private final PhoneServiceProvider terminalModeUpdateListnerService;
    private final DefaultTerminalModeUpdateListener tmUpdateListener;
    private final TelTerminalModeHandler$AbstractState active = new TelTerminalModeHandler$TMActiveState(this, null);
    private final TelTerminalModeHandler$AbstractState inactive;
    private volatile TelTerminalModeHandler$AbstractState state = this.inactive = new TelTerminalModeHandler$TMInactiveState(this, null);
    private volatile IGlobalTelephoneStateStruct telStateStruct;
    private volatile TerminalModeDevice activeDevice;
    private volatile int nadModeBeforeTM = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    public TelTerminalModeHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.tmUpdateListener = new TelTerminalModeHandler$TerminalModeUpdateListener(this, null);
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TelTerminalModeHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelApplication.getBundleContext(), this.log);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(new TelTerminalModeHandler$1(this));
        this.getApplication().addDiagnosisComponent(new TelTerminalModeHandler$TelTerminalModeDiag(this));
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.terminalModeUpdateListnerService.stopService();
    }

    private void transitionToState(TelTerminalModeHandler$AbstractState telTerminalModeHandler$AbstractState) {
        this.state = telTerminalModeHandler$AbstractState;
        this.log.log(1078071040, "[TelTerminalModeHandler#transitionToState] Transition to a new state: %1", (Object)telTerminalModeHandler$AbstractState.toString());
        this.state.enter();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telStateStruct = iGlobalTelephoneStateStruct;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelApplication access$300(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.getApplication();
    }

    static /* synthetic */ PhoneServiceProvider access$400(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.terminalModeUpdateListnerService;
    }

    static /* synthetic */ TerminalModeDevice access$600(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.activeDevice;
    }

    static /* synthetic */ LogChannel access$700(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ TelTerminalModeHandler$AbstractState access$800(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.inactive;
    }

    static /* synthetic */ void access$900(TelTerminalModeHandler telTerminalModeHandler, TelTerminalModeHandler$AbstractState abstractState) {
        telTerminalModeHandler.transitionToState(abstractState);
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$1000(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.telStateStruct;
    }

    static /* synthetic */ int access$1102(TelTerminalModeHandler telTerminalModeHandler, int n) {
        telTerminalModeHandler.nadModeBeforeTM = n;
        return telTerminalModeHandler.nadModeBeforeTM;
    }

    static /* synthetic */ LogChannel access$1200(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ ITelApplication access$1300(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.getApplication();
    }

    static /* synthetic */ TelTerminalModeHandler$AbstractState access$1400(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.active;
    }

    static /* synthetic */ LogChannel access$1500(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ int access$1100(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.nadModeBeforeTM;
    }

    static /* synthetic */ LogChannel access$1600(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ ITelApplication access$1700(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.getApplication();
    }

    static /* synthetic */ LogChannel access$1800(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ LogChannel access$1900(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ TerminalModeDevice access$602(TelTerminalModeHandler telTerminalModeHandler, TerminalModeDevice terminalModeDevice) {
        telTerminalModeHandler.activeDevice = terminalModeDevice;
        return telTerminalModeHandler.activeDevice;
    }

    static /* synthetic */ ButtonModelApp access$2000(TelTerminalModeHandler telTerminalModeHandler, int n) {
        return telTerminalModeHandler.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$2100(TelTerminalModeHandler telTerminalModeHandler, int n) {
        return telTerminalModeHandler.getButtonModel(n);
    }

    static /* synthetic */ TelTerminalModeHandler$AbstractState access$2200(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.state;
    }

    static /* synthetic */ ChoiceModelApp access$2300(TelTerminalModeHandler telTerminalModeHandler, int n) {
        return telTerminalModeHandler.getChoiceModel(n);
    }

    static /* synthetic */ LogChannel access$2400(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ ChoiceModelApp access$2500(TelTerminalModeHandler telTerminalModeHandler, int n) {
        return telTerminalModeHandler.getChoiceModel(n);
    }

    static /* synthetic */ LogChannel access$2600(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.log;
    }

    static /* synthetic */ DefaultTerminalModeUpdateListener access$2700(TelTerminalModeHandler telTerminalModeHandler) {
        return telTerminalModeHandler.tmUpdateListener;
    }
}

