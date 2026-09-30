/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface ButtonModelHandler
extends ModelHandler {
    public void updateOnKeyPressed(int var1);

    public void updateOnKeyReleased(int var1);

    public void updateOnKeyTyped(int var1);

    public ButtonModelApp returnButtonModel();

    public ButtonModelEventBusiness getButtonModelBusiness();
}

