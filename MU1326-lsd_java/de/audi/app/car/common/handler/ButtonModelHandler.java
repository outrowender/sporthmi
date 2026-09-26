/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface ButtonModelHandler
extends ModelHandler {
    default public void updateOnKeyPressed(int n) {
    }

    default public void updateOnKeyReleased(int n) {
    }

    default public void updateOnKeyTyped(int n) {
    }

    default public ButtonModelApp returnButtonModel() {
    }

    default public ButtonModelEventBusiness getButtonModelBusiness() {
    }
}

