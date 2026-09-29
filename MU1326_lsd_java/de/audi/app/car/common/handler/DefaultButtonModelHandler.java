/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.ButtonModelHandlerAdapter;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;

public class DefaultButtonModelHandler
extends ButtonModelHandlerAdapter {
    public DefaultButtonModelHandler(ButtonModelApp buttonModelApp, LogChannel logChannel) {
        super(buttonModelApp, logChannel);
        buttonModelApp.setButtonListener(this);
    }

    @Override
    public void updateOnKeyPressed(int n) {
        this.getButtonModelBusiness().processKeyPressed(n, (ButtonModelHandler)this);
    }

    @Override
    public void updateOnKeyReleased(int n) {
        this.getButtonModelBusiness().processKeyReleased(n, (ButtonModelHandler)this);
    }

    @Override
    public void updateOnKeyTyped(int n) {
        this.getButtonModelBusiness().processKeyTyped(n, (ButtonModelHandler)this);
    }
}

