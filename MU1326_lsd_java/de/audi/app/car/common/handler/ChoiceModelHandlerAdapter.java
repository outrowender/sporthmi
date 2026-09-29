/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandlerAdapter;
import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusiness;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class ChoiceModelHandlerAdapter
extends ButtonModelHandlerAdapter
implements ChoiceListener,
ChoiceModelHandler {
    protected ChoiceModelHandlerAdapter(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        super(choiceModelApp, logChannel);
        choiceModelApp.setChoiceListener(this);
    }

    @Override
    public final void itemSelected(int n, int n2, int n3, int n4) {
        if (this.getHandledModelID() == n) {
            this.updateOnItemSelected(n2);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        if (this.getHandledModelID() == n) {
            this.updateOnItemFocused(n2);
        }
    }

    @Override
    public void updateOnItemSelected(int n) {
    }

    @Override
    public void updateOnItemFocused(int n) {
    }

    @Override
    public void updateChoiceModelValue(int n) {
        this.getChoiceModel().setValue(n);
    }

    @Override
    public ChoiceModelApp getChoiceModel() {
        return (ChoiceModelApp)this.getHandledModel();
    }

    @Override
    public ChoiceModelEventBusiness getChoiceModelBusiness() {
        return (ChoiceModelEventBusiness)this.getBusiness();
    }
}

