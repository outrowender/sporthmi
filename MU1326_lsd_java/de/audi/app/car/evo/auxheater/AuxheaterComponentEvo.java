/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.auxheater;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
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
        this.jokerKeyServiceTracker = new CarServiceTracker(new CarServiceTrackerListener(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void serviceRemoved() {
                Object object = AuxheaterComponentEvo.this.mutex;
                synchronized (object) {
                    AuxheaterComponentEvo.this.jokerKeyService = null;
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void serviceAvailable(Object object) {
                Object object2 = AuxheaterComponentEvo.this.mutex;
                synchronized (object2) {
                    AuxheaterComponentEvo.this.jokerKeyService = (JokerKeyService)object;
                }
                AuxheaterComponentEvo.this.updateJokerKeyListEntryVisibility(AuxheaterComponentEvo.this.currViewOptions);
            }

            public String[] getTrackedServiceClazzName() {
                return new String[]{(class$de$audi$atip$interapp$JokerKeyService == null ? (class$de$audi$atip$interapp$JokerKeyService = AuxheaterComponentEvo.class$("de.audi.atip.interapp.JokerKeyService")) : class$de$audi$atip$interapp$JokerKeyService).getName()};
            }
        }, iCarApplication.getBundleContext(), this.getLogChannel());
    }

    public void init() {
        super.init();
        this.jokerKeyServiceTracker.startTracking();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600141, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600035, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600033, this);
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(600141, this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(600035, this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(600033, this);
        this.jokerKeyServiceTracker.stopTracking();
        super.deinit();
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2210, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2220, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2230, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600054, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600055, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(222, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(223, (short)9);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(224, (short)9);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2210);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2220);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2230);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600054);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600055);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(222);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(223);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(224);
    }

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

    public int getID() {
        return 17;
    }

    public void notifyScreenVisible(int n) {
    }

    public void notifyScreenHidden(int n) {
    }

    public void notifyScreenConnected(int n) {
        this.getLogChannel().log(1000000, "[AuxheaterComponentEvo#notifyScreenConnected] screenID='%1'", (long)n);
        this.setConnectedScreen(n);
        if (n == 600141) {
            this.updatePastErrorDisclaimerModel(this.pastAuxHeatError);
        }
    }

    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1000000, "[AuxheaterComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
        if (n == 600141) {
            this.resetPastError();
        } else if (n == 600035) {
            this.setConnectedScreen(-1);
            if (!this.isHeaterStateDefect(this.currentAuxHeatError)) {
                this.updateCurrentErrorDisclaimerModel(this.currentAuxHeatError);
                this.updateInfobox();
            }
        } else if (n == 600033) {
            this.setConnectedScreen(-1);
            if (this.isHeaterStateDefect(this.currentAuxHeatError)) {
                this.updateInfobox();
            }
        }
    }

    protected boolean deferCurrentErrorDisclaimerUpdate(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        boolean bl = this.isHeaterStateDefect(auxHeaterCoolerErrorReason);
        boolean bl2 = this.isLeavingAuxHeatHintsActualScreenForMain(bl);
        int n = bl ? 1 : 0;
        ChoiceModelApp choiceModelApp = this.getChoiceModel(601254);
        if (choiceModelApp.getValue() != n) {
            choiceModelApp.setValue(n);
        }
        return bl2;
    }

    protected boolean deferInfoBoxUpdate(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        boolean bl = this.isHeaterStateDefect(auxHeaterCoolerErrorReason);
        return this.isLeavingAuxHeatMainScreenForError(bl) || this.isLeavingAuxHeatHintsActualScreenForMain(bl);
    }

    private boolean isHeaterStateDefect(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        return auxHeaterCoolerErrorReason.isBatteryLow() || auxHeaterCoolerErrorReason.isFuelLow() || auxHeaterCoolerErrorReason.isHeaterDefect();
    }

    private boolean isLeavingAuxHeatHintsActualScreenForMain(boolean bl) {
        return this.isScreenConnected(600035) && !bl;
    }

    private boolean isLeavingAuxHeatMainScreenForError(boolean bl) {
        return this.isScreenConnected(600033) && bl;
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

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.getLogChannel().log(1000000, "[AuxheaterComponentEvo#updateClampState] clamp15='%1'", bl2);
        if (bl2) {
            this.updatePastErrorDisclaimerModel(this.pastAuxHeatError);
        }
    }

    private void updateMenuEntryVisibilityNow(boolean bl, int n) {
        if (bl) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600055, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600054, 1);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600054, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600055, 1);
        }
    }

    protected void updateAuxHeatNowOn(boolean bl) {
        this.auxHeatNowOn = bl;
        this.updateMenuEntryVisibilityNow(bl, this.auxHeatNowVisiblityState);
    }

    private void updateAuxHeatNowVisibilityState(int n) {
        this.auxHeatNowVisiblityState = n;
        this.updateMenuEntryVisibilityNow(this.auxHeatNowOn, n);
    }

    protected void updateMenuEntryVisibilityForError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        if (auxHeaterCoolerErrorReason.isHeaterDefect() || auxHeaterCoolerErrorReason.isBatteryLow() || auxHeaterCoolerErrorReason.isFuelLow()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(222, 2);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(223, 2);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(224, 2);
            this.updateMenuEntryVisibilityNow(this.auxHeatNowOn, 2);
        } else if (this.currViewOptions != null) {
            this.updateMenuEntryVisibility(this.currViewOptions);
        } else {
            this.getLogChannel().log(100000, "[AuxheaterComponentEvo#updateMenuEntryVisibilityForError] Cannot update menu visibility because VOs are NULL!");
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
}

