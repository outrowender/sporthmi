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

    @Override
    public void showETCNoCardInsertedReminderPartialPopup() {
        this.log.log(-2137614336, "%1 showETCNoCardInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 281612288);
    }

    @Override
    public void hideETCNoCardInsertedReminderPartialPopup() {
        this.log.log(-2137614336, "%1 hideETCNoCardInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 281612288);
    }

    @Override
    public void showETCCardIStillInsertedReminderPartialPopup() {
        this.log.log(-2137614336, "%1 showETCCardIStillInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 298389504);
    }

    @Override
    public void hideETCCardIStillInsertedReminderPartialPopup() {
        this.log.log(-2137614336, "%1 hideETCCardIStillInsertedReminderPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 298389504);
    }

    @Override
    public void showETCWarningPartialPopup() {
        this.log.log(-2137614336, "%1 showETCWarningPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 365498368);
    }

    @Override
    public void hideETCWarningPartialPopup() {
        this.log.log(-2137614336, "%1 hideETCWarningPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 365498368);
    }

    @Override
    public void showETCTollAmountPartialPopup() {
        this.log.log(-2137614336, "%1 showETCTollAmountPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().showPartialPopup(this.getTerminalID(), 382275584);
    }

    @Override
    public void hideETCTollAmountPartialPopup() {
        this.log.log(-2137614336, "%1 hideETCTollAmountPartialPopup()", (Object)CLASSNAME);
        this.getHMIService().removePartialPopup(this.getTerminalID(), 382275584);
    }
}

