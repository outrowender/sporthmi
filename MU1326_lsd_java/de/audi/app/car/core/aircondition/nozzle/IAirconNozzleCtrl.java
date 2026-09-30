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
    public void setModels(RangeModelApp var1, RangeModel2DApp var2, ChoiceModelApp var3);

    public RangeModel2DApp getPositionModel();

    public RangeModelApp getAirflowModel();

    public ChoiceModelApp getStyleModel();
}

