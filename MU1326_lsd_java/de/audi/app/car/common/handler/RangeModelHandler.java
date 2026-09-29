/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.RangeModelEventBusiness;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public interface RangeModelHandler
extends ButtonModelHandler {
    default public void updateOnAdjustment(int n) {
    }

    default public RangeModelApp getRangeModel() {
    }

    default public RangeModelEventBusiness getRangeEventBusiness() {
    }

    default public void updateRangeModelLimits(int n, int n2, int n3) {
    }

    default public void updateRangeModelValue(int n) {
    }
}

