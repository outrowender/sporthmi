/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.auxheater;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
import de.audi.app.car.evo.auxheater.AuxheaterComponentEvo$1;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.JokerKeyService;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AuxheaterComponentEvo
extends AbstractAuxheaterComponent
implements IScreenStateListener,
IPowerEventListener {
    private CarServiceTracker jokerKeyServiceTracker;
    private JokerKeyService jokerKeyService;
    private final Object mutex = new Object();
    private volatile int connectedScreen = -1;
    private boolean auxHeatNowOn = false;
    private int auxHeatNowVisiblityState = 1;
    static /* synthetic */ Class class$de$audi$atip$interapp$JokerKeyService;

    public AuxheaterComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        this.jokerKeyServiceTracker = new CarServiceTracker(new AuxheaterComponentEvo$1(this), iCarApplication.getBundleContext(), this.getLogChannel());
    }

    @Override
    public void init() {
        super.init();
        this.jokerKeyServiceTracker.startTracking();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(1294469376, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-483981056, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-517535488, this);
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(1294469376, this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-483981056, this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-517535488, this);
        this.jokerKeyServiceTracker.stopTracking();
        super.deinit();
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2210, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2220, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2230, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-165213952, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-148436736, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(222, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(223, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(224, (short)9);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2210);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2220);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2230);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-165213952);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-148436736);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(222);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(223);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(224);
    }

    @Override
    protected void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        this.updateAuxHeatNowVisibilityState(this.getMenuEntryVisibilityState(new CarViewOption[]{auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff(), auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(222, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(223, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(224, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.getAuxHeaterCoolerMode()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2210, this.getMenuEntryVisibilityState(new CarViewOption[]{auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff(), auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2220, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2230, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2()));
        this.updateJokerKeyListEntryVisibility(auxHeaterCoolerViewOptions);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateJokerKeyListEntryVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        if (auxHeaterCoolerViewOptions != null) {
            boolean bl = auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff().getState() != 0 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerState().getState() != 0;
            Object object = this.mutex;
            synchronized (object) {
                if (this.jokerKeyService != null) {
                    this.jokerKeyService.setFunctionAvailable(1, bl);
                }
            }
        }
    }

    @Override
    public int getID() {
        return 17;
    }

    @Override
    public void notifyScreenVisible(int n) {
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
    public void notifyScreenConnected(int n) {
        this.getLogChannel().log(1078071040, "[AuxheaterComponentEvo#notifyScreenConnected] screenID='%1'", (long)n);
        this.setConnectedScreen(n);
        if (n == 1294469376) {
            this.updatePastErrorDisclaimerModel(this.pastAuxHeatError);
        }
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1078071040, "[AuxheaterComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
        if (n == 1294469376) {
            this.resetPastError();
        } else if (n == -483981056) {
            this.setConnectedScreen(-1);
            if (!this.isHeaterStateDefect(this.currentAuxHeatError)) {
                this.updateCurrentErrorDisclaimerModel(this.currentAuxHeatError);
                this.updateInfobox();
            }
        } else if (n == -517535488) {
            this.setConnectedScreen(-1);
            if (this.isHeaterStateDefect(this.currentAuxHeatError)) {
                this.updateInfobox();
            }
        }
    }

    @Override
    protected boolean deferCurrentErrorDisclaimerUpdate(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        boolean bl = this.isHeaterStateDefect(auxHeaterCoolerErrorReason);
        boolean bl2 = this.isLeavingAuxHeatHintsActualScreenForMain(bl);
        int n = bl ? 1 : 0;
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-1507063552);
        if (choiceModelApp.getValue() != n) {
            choiceModelApp.setValue(n);
        }
        return bl2;
    }

    @Override
    protected boolean deferInfoBoxUpdate(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        boolean bl = this.isHeaterStateDefect(auxHeaterCoolerErrorReason);
        return this.isLeavingAuxHeatMainScreenForError(bl) || this.isLeavingAuxHeatHintsActualScreenForMain(bl);
    }

    private boolean isHeaterStateDefect(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        return auxHeaterCoolerErrorReason.isBatteryLow() || auxHeaterCoolerErrorReason.isFuelLow() || auxHeaterCoolerErrorReason.isHeaterDefect();
    }

    private boolean isLeavingAuxHeatHintsActualScreenForMain(boolean bl) {
        return this.isScreenConnected(-483981056) && !bl;
    }

    private boolean isLeavingAuxHeatMainScreenForError(boolean bl) {
        return this.isScreenConnected(-517535488) && bl;
    }

    private int getConnectedScreen() {
        return this.connectedScreen;
    }

    private synchronized void setConnectedScreen(int n) {
        this.connectedScreen = n;
    }

    private synchronized boolean isScreenConnected(int n) {
        return this.getConnectedScreen() == n;
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

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.getLogChannel().log(1078071040, "[AuxheaterComponentEvo#updateClampState] clamp15='%1'", bl2);
        if (bl2) {
            this.updatePastErrorDisclaimerModel(this.pastAuxHeatError);
        }
    }

    private void updateMenuEntryVisibilityNow(boolean bl, int n) {
        if (bl) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-148436736, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-165213952, 1);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-165213952, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-148436736, 1);
        }
    }

    @Override
    protected void updateAuxHeatNowOn(boolean bl) {
        this.auxHeatNowOn = bl;
        this.updateMenuEntryVisibilityNow(bl, this.auxHeatNowVisiblityState);
    }

    private void updateAuxHeatNowVisibilityState(int n) {
        this.auxHeatNowVisiblityState = n;
        this.updateMenuEntryVisibilityNow(this.auxHeatNowOn, n);
    }

    @Override
    protected void updateMenuEntryVisibilityForError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        if (auxHeaterCoolerErrorReason.isHeaterDefect() || auxHeaterCoolerErrorReason.isBatteryLow() || auxHeaterCoolerErrorReason.isFuelLow()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(222, 2);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(223, 2);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(224, 2);
            this.updateMenuEntryVisibilityNow(this.auxHeatNowOn, 2);
        } else if (this.currViewOptions != null) {
            this.updateMenuEntryVisibility(this.currViewOptions);
        } else {
            this.getLogChannel().log(-1601830656, "[AuxheaterComponentEvo#updateMenuEntryVisibilityForError] Cannot update menu visibility because VOs are NULL!");
        }
    }

    static /* synthetic */ Object access$000(AuxheaterComponentEvo auxheaterComponentEvo) {
        return auxheaterComponentEvo.mutex;
    }

    static /* synthetic */ JokerKeyService access$102(AuxheaterComponentEvo auxheaterComponentEvo, JokerKeyService jokerKeyService) {
        auxheaterComponentEvo.jokerKeyService = jokerKeyService;
        return auxheaterComponentEvo.jokerKeyService;
    }

    static /* synthetic */ AuxHeaterCoolerViewOptions access$200(AuxheaterComponentEvo auxheaterComponentEvo) {
        return auxheaterComponentEvo.currViewOptions;
    }

    static /* synthetic */ void access$300(AuxheaterComponentEvo auxheaterComponentEvo, AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        auxheaterComponentEvo.updateJokerKeyListEntryVisibility(auxHeaterCoolerViewOptions);
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

