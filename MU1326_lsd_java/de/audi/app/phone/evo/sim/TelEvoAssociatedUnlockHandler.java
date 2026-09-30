/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.screen.AbstractTelDefaultScreenStateListener;
import de.audi.app.phone.core.sim.TelAssociatedUnlockHandler;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import de.audi.app.phone.evo.sim.TelUnlockPopupListener;
import java.util.Map;

public class TelEvoAssociatedUnlockHandler
extends TelAssociatedUnlockHandler {
    private final TelEvoPopupHandler unlockPopupAssociatedHandler;
    private volatile boolean telEntered;

    public TelEvoAssociatedUnlockHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.unlockPopupAssociatedHandler = new TelEvoPopupHandler(iTelApplication, "App.Phone.LockState", 300016);
        this.addSubPhoneComponent(this.unlockPopupAssociatedHandler);
        this.addSubPhoneComponent(new TelAppEnteredListener(iTelApplication));
        this.addSubPhoneComponent(new TelAppLeftListener(iTelApplication));
        this.addSubPhoneComponent(new TelUnlockAssociatedPinBlockedScreenListener(iTelApplication));
        this.addSubPhoneComponent(new TelUnlockPopupListener(iTelApplication));
    }

    protected void processPINRequired(int n) {
        super.processPINRequired(n);
        this.showUnlockPopup();
    }

    protected void processSIMNotFunctioning() {
        super.processSIMNotFunctioning();
        this.showUnlockPopup();
    }

    protected void processPUKBlocked() {
        super.processPUKBlocked();
        this.showUnlockPopup();
    }

    protected void processPUKRequired(int n) {
        super.processPUKRequired(n);
        this.showUnlockPopup();
    }

    public void showUnlockPopup() {
        if (this.telEntered && this.lockHandlingRequired()) {
            this.log.log(1000000, "[TelEvoAssociatedUnlockHandler#showUnlockPopup]");
            this.unlockPopupAssociatedHandler.requestShowPopup(0);
        }
    }

    private class TelAppLeftListener
    extends AbstractTelActionProxyListener {
        public TelAppLeftListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 8);
        }

        protected void actionProxyCalled(Map map) {
            this.log.log(1000000, "[TelEvoAssociatedUnlockHandler.TelAppLeftListener#actionProxyCalled]");
            TelEvoAssociatedUnlockHandler.this.telEntered = false;
        }
    }

    private class TelAppEnteredListener
    extends AbstractTelActionProxyListener {
        public TelAppEnteredListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.LockState", 7);
        }

        protected void actionProxyCalled(Map map) {
            TelEvoAssociatedUnlockHandler.this.telEntered = true;
            if (TelEvoAssociatedUnlockHandler.this.lockHandlingRequired()) {
                this.log.log(1000000, "[TelEvoAssociatedUnlockHandler.TelAppEnteredListener#actionProxyCalled] showing unlock popup");
                TelEvoAssociatedUnlockHandler.this.showUnlockPopup();
            }
        }
    }

    private class TelUnlockAssociatedPinBlockedScreenListener
    extends AbstractTelDefaultScreenStateListener {
        public TelUnlockAssociatedPinBlockedScreenListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 300323);
        }

        public void notifyScreenConnected(int n) {
            this.log.log(1000000, "[TelEvoAssociatedUnlockHandler.TelUnlockAssociatedPinBlockedScreenListener#notifyScreenConnected]");
        }

        public void notifyScreenFadedOut(int n) {
            this.log.log(1000000, "[TelEvoAssociatedUnlockHandler.TelUnlockAssociatedPinBlockedScreenListener#notifyScreenFadedOut]");
            TelEvoAssociatedUnlockHandler.this.resetPukConditionChoice();
        }
    }
}

