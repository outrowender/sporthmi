/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.handler.DefaultMenuModelHandler;
import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.MenuModelEventBusinessAdapter;
import de.audi.app.earlyfunc.hybrid.EtronPopupHKTimerController;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class EtronMenuEventBusiness
extends MenuModelEventBusinessAdapter {
    private ChoiceModelApp focusChoice;
    private EtronPopupHKTimerController popupHKTimer;
    private DefaultMenuModelHandler handler;

    protected EtronMenuEventBusiness(DSIBase dSIBase, LogChannel logChannel) {
        super(dSIBase, logChannel);
    }

    protected EtronMenuEventBusiness(DSIBase dSIBase, DefaultMenuModelHandler defaultMenuModelHandler, ChoiceModelApp choiceModelApp, EtronPopupHKTimerController etronPopupHKTimerController, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.focusChoice = choiceModelApp;
        this.popupHKTimer = etronPopupHKTimerController;
        this.handler = defaultMenuModelHandler;
    }

    public boolean processItemFocused(int n, MenuModelHandler menuModelHandler) {
        if (this.getFocusChoice().getValue() != n) {
            this.setFocusChoice(n);
            this.popupHKTimer.deactivate();
        }
        return true;
    }

    public void updateActiveOperationMode(int n) {
        if (this.getHandler() != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[EtronMenuEventBusiness#updateActiveProfile] trigger JOIN_CURSOR: menuModelID='%1', currentFocus='%2', targetFocus'%3'", (long)this.getHandler().getHandledModel().getID(), (long)this.getFocusChoice().getValue(), (long)n);
            }
            this.setFocusChoice(n);
            ((MenuModelApp)this.getHandler().getHandledModel()).trigger(ModelTrigger.JOIN_CURSOR);
            this.popupHKTimer.resetActivated();
        }
    }

    private void setFocusChoice(int n) {
        this.getFocusChoice().setValue(n);
    }

    protected void setHandler(DefaultMenuModelHandler defaultMenuModelHandler) {
        this.handler = defaultMenuModelHandler;
    }

    private DefaultMenuModelHandler getHandler() {
        return this.handler;
    }

    private ChoiceModelApp getFocusChoice() {
        return this.focusChoice;
    }
}

