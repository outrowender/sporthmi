/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;

public abstract class AbstractETCPopupManager {
    private final IFrameworkAccess framework;

    public AbstractETCPopupManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
    }

    public final int getTerminalID() {
        return this.framework.isFrontMU() ? 0 : 5;
    }

    public final IHMIServiceApp getHMIService() {
        return this.framework.getHmiServiceApp();
    }

    public abstract void showETCNoCardInsertedReminderPartialPopup() {
    }

    public abstract void hideETCNoCardInsertedReminderPartialPopup() {
    }

    public abstract void showETCCardIStillInsertedReminderPartialPopup() {
    }

    public abstract void hideETCCardIStillInsertedReminderPartialPopup() {
    }

    public abstract void showETCWarningPartialPopup() {
    }

    public abstract void hideETCWarningPartialPopup() {
    }

    public abstract void showETCTollAmountPartialPopup() {
    }

    public abstract void hideETCTollAmountPartialPopup() {
    }
}

