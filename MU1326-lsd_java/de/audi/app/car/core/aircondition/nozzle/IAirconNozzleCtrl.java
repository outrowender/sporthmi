/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.core.aircondition.nozzle.IAirconNozzleState;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public interface IAirconNozzleCtrl
extends IAirconNozzleState {
    default public void setModels(RangeModelApp rangeModelApp, RangeModel2DApp rangeModel2DApp, ChoiceModelApp choiceModelApp) {
    }

    default public RangeModel2DApp getPositionModel() {
    }

    default public RangeModelApp getAirflowModel() {
    }

    default public ChoiceModelApp getStyleModel() {
    }
}

