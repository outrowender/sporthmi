/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.etc.AbstractETCPopupManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class ETCPopupManagerEvo
extends AbstractETCPopupManager {
    private final LogChannel log;
    private static String CLASSNAME = "[ETCPopupManagerEvo]";

    public ETCPopupManagerEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        this.log = iFrameworkAccess.getLogChannel("App.Settings.ETC");
    }

    public void showETCNoCardInsertedReminderPartialPopup() {
        this.log.log(10000000, "%1 showETCNoCardInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 1100048);
    }

    public void hideETCNoCardInsertedReminderPartialPopup() {
        this.log.log(10000000, "%1 hideETCNoCardInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 1100048);
    }

    public void showETCCardIStillInsertedReminderPartialPopup() {
        this.log.log(10000000, "%1 showETCCardIStillInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 1100049);
    }

    public void hideETCCardIStillInsertedReminderPartialPopup() {
        this.log.log(10000000, "%1 hideETCCardIStillInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 1100049);
    }

    public void showETCWarningPartialPopup() {
        this.log.log(10000000, "%1 showETCWarningPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 1100053);
    }

    public void hideETCWarningPartialPopup() {
        this.log.log(10000000, "%1 hideETCWarningPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 1100053);
    }

    public void showETCTollAmountPartialPopup() {
        this.log.log(10000000, "%1 showETCTollAmountPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 1100054);
    }

    public void hideETCTollAmountPartialPopup() {
        this.log.log(10000000, "%1 hideETCTollAmountPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 1100054);
    }
}

