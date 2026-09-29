/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusiness;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public interface ChoiceModelHandler
extends ButtonModelHandler {
    default public void updateOnItemSelected(int n) {
    }

    default public void updateOnItemFocused(int n) {
    }

    default public void updateChoiceModelValue(int n) {
    }

    default public ChoiceModelApp getChoiceModel() {
    }

    default public ChoiceModelEventBusiness getChoiceModelBusiness() {
    }
}

