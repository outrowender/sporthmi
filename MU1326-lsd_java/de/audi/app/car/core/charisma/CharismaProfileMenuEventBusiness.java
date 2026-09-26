/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.charisma.CharismaPopupHKTimerController;
import de.audi.app.car.common.handler.DefaultMenuModelHandler;
import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.MenuModelEventBusinessAdapter;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class CharismaProfileMenuEventBusiness
extends MenuModelEventBusinessAdapter {
    private final ChoiceModelApp focusChoice;
    private final CharismaPopupHKTimerController popupHKTimer;
    private DefaultMenuModelHandler handler;

    protected CharismaProfileMenuEventBusiness(DSIBase dSIBase, DefaultMenuModelHandler defaultMenuModelHandler, ChoiceModelApp choiceModelApp, CharismaPopupHKTimerController charismaPopupHKTimerController, LogChannel logChannel) {
        super(dSIBase, logChannel);
        this.focusChoice = choiceModelApp;
        this.popupHKTimer = charismaPopupHKTimerController;
        this.handler = defaultMenuModelHandler;
    }

    @Override
    public boolean processItemFocused(int n, MenuModelHandler menuModelHandler) {
        if (this.getFocusChoice().getValue() != n) {
            this.setFocusChoice(n);
            this.popupHKTimer.deactivate();
        }
        return true;
    }

    private ChoiceModelApp getFocusChoice() {
        return this.focusChoice;
    }

    private void setFocusChoice(int n) {
        this.getFocusChoice().setValue(n);
    }

    public void updateActiveProfile(int n) {
        if (this.getHandler() != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[CharismaProfileMenuEventBusiness#updateActiveProfile] trigger JOIN_CURSOR: menuModelID='%1', currentFocus='%2', targetFocus'%3'", (long)this.getHandler().getHandledModel().getID(), (long)this.getFocusChoice().getValue(), (long)n);
            }
            this.setFocusChoice(n);
            ((MenuModelApp)this.getHandler().getHandledModel()).trigger(ModelTrigger.JOIN_CURSOR);
            this.popupHKTimer.resetActivated();
        }
    }

    protected void setHandler(DefaultMenuModelHandler defaultMenuModelHandler) {
        this.handler = defaultMenuModelHandler;
    }

    private DefaultMenuModelHandler getHandler() {
        return this.handler;
    }
}

