/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.ChoiceModelHandlerAdapter;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class DefaultChoiceModelHandler
extends ChoiceModelHandlerAdapter {
    public DefaultChoiceModelHandler(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        super(choiceModelApp, logChannel);
        choiceModelApp.setChoiceListener(this);
    }

    @Override
    public void updateOnKeyPressed(int n) {
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processKeyPressed(n, (ButtonModelHandler)this);
        }
    }

    @Override
    public void updateOnKeyReleased(int n) {
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processKeyReleased(n, (ButtonModelHandler)this);
        }
    }

    @Override
    public void updateOnKeyTyped(int n) {
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processKeyTyped(n, (ButtonModelHandler)this);
        }
    }

    @Override
    public void updateOnItemSelected(int n) {
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processItemSelected(n, (ChoiceModelHandler)this);
        }
    }

    @Override
    public void updateOnItemFocused(int n) {
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processItemFocused(n, (ChoiceModelHandler)this);
        }
    }
}

