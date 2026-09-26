/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.TelAssociatedUnlockHandler;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler$TelAppEnteredListener;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler$TelAppLeftListener;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler$TelUnlockAssociatedPinBlockedScreenListener;
import de.audi.app.phone.evo.sim.TelUnlockPopupListener;

public class TelEvoAssociatedUnlockHandler
extends TelAssociatedUnlockHandler {
    private final TelEvoPopupHandler unlockPopupAssociatedHandler;
    private volatile boolean telEntered;

    public TelEvoAssociatedUnlockHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.unlockPopupAssociatedHandler = new TelEvoPopupHandler(iTelApplication, "App.Phone.LockState", -258800640);
        this.addSubPhoneComponent(this.unlockPopupAssociatedHandler);
        this.addSubPhoneComponent(new TelEvoAssociatedUnlockHandler$TelAppEnteredListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoAssociatedUnlockHandler$TelAppLeftListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoAssociatedUnlockHandler$TelUnlockAssociatedPinBlockedScreenListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelUnlockPopupListener(iTelApplication));
    }

    @Override
    protected void processPINRequired(int n) {
        super.processPINRequired(n);
        this.showUnlockPopup();
    }

    @Override
    protected void processSIMNotFunctioning() {
        super.processSIMNotFunctioning();
        this.showUnlockPopup();
    }

    @Override
    protected void processPUKBlocked() {
        super.processPUKBlocked();
        this.showUnlockPopup();
    }

    @Override
    protected void processPUKRequired(int n) {
        super.processPUKRequired(n);
        this.showUnlockPopup();
    }

    public void showUnlockPopup() {
        if (this.telEntered && this.lockHandlingRequired()) {
            this.log.log(1078071040, "[TelEvoAssociatedUnlockHandler#showUnlockPopup]");
            this.unlockPopupAssociatedHandler.requestShowPopup(0);
        }
    }

    static /* synthetic */ boolean access$002(TelEvoAssociatedUnlockHandler telEvoAssociatedUnlockHandler, boolean bl) {
        telEvoAssociatedUnlockHandler.telEntered = bl;
        return telEvoAssociatedUnlockHandler.telEntered;
    }

    static /* synthetic */ boolean access$100(TelEvoAssociatedUnlockHandler telEvoAssociatedUnlockHandler) {
        return telEvoAssociatedUnlockHandler.lockHandlingRequired();
    }

    static /* synthetic */ void access$200(TelEvoAssociatedUnlockHandler telEvoAssociatedUnlockHandler) {
        telEvoAssociatedUnlockHandler.resetPukConditionChoice();
    }
}

