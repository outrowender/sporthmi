/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;

public class AirconNozzleCtrl$InvertValueConverterStrategy
implements IValueConverterStrategy {
    private final /* synthetic */ AirconNozzleCtrl this$0;

    public AirconNozzleCtrl$InvertValueConverterStrategy(AirconNozzleCtrl airconNozzleCtrl) {
        this.this$0 = airconNozzleCtrl;
    }

    @Override
    public Object getDSIValue(Object object) {
        return new Integer(-((Integer)object).intValue());
    }

    @Override
    public Object getHMIValue(Object object) {
        return new Integer(-((Integer)object).intValue());
    }
}

