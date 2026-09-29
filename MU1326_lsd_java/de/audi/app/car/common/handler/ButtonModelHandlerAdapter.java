/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.ModelHandlerAdapter;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;

public class ButtonModelHandlerAdapter
extends ModelHandlerAdapter
implements ButtonModelHandler,
ButtonListener {
    protected ButtonModelHandlerAdapter(ButtonModelApp buttonModelApp, LogChannel logChannel) {
        super(buttonModelApp, logChannel);
    }

    @Override
    public final void keyPressed(int n, int n2, int n3) {
        if (this.getHandledModelID() == n) {
            this.updateOnKeyPressed(n2);
        }
    }

    @Override
    public final void keyReleased(int n, int n2, int n3) {
        if (this.getHandledModelID() == n) {
            this.updateOnKeyReleased(n2);
        }
    }

    @Override
    public final void keyTyped(int n, int n2, int n3) {
        if (this.getHandledModelID() == n) {
            this.updateOnKeyTyped(n2);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void updateOnKeyPressed(int n) {
    }

    @Override
    public void updateOnKeyReleased(int n) {
    }

    @Override
    public void updateOnKeyTyped(int n) {
    }

    @Override
    public ButtonModelApp returnButtonModel() {
        return (ButtonModelApp)this.getHandledModel();
    }

    @Override
    public ButtonModelEventBusiness getButtonModelBusiness() {
        return (ButtonModelEventBusiness)this.getBusiness();
    }
}

