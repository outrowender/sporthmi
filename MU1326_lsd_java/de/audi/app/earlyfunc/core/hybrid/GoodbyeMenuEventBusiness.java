/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.MenuModelEventBusinessAdapter;
import de.audi.app.earlyfunc.core.hybrid.GoodbyePopupHKTimerController;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class GoodbyeMenuEventBusiness
extends MenuModelEventBusinessAdapter {
    private ChoiceModelApp focusChoice;
    private GoodbyePopupHKTimerController popupHKTimer;

    protected GoodbyeMenuEventBusiness(DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
    }

    protected GoodbyeMenuEventBusiness(DSIBase dSIBase, ChoiceModelApp choiceModelApp, GoodbyePopupHKTimerController goodbyePopupHKTimerController, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.focusChoice = choiceModelApp;
        this.popupHKTimer = goodbyePopupHKTimerController;
    }

    @Override
    public boolean processItemFocused(int n, MenuModelHandler menuModelHandler) {
        if (this.getFocusChoice().getValue() != n) {
            this.setFocusChoice(n);
            this.popupHKTimer.resetActivated();
        }
        return true;
    }

    private void setFocusChoice(int n) {
        this.getFocusChoice().setValue(n);
    }

    private ChoiceModelApp getFocusChoice() {
        return this.focusChoice;
    }
}

