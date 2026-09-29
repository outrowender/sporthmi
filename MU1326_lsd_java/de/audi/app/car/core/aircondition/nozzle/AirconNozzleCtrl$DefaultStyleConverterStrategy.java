/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public class AirconNozzleCtrl$DefaultStyleConverterStrategy
implements IValueConverterStrategy {
    private final /* synthetic */ AirconNozzleCtrl this$0;

    public AirconNozzleCtrl$DefaultStyleConverterStrategy(AirconNozzleCtrl airconNozzleCtrl) {
        this.this$0 = airconNozzleCtrl;
    }

    @Override
    public Object getDSIValue(Object object) {
        switch ((Integer)object) {
            case 0: {
                return new AirconNozzleListStyles(false, false, false, true);
            }
            case 1: {
                return new AirconNozzleListStyles(false, false, true, false);
            }
            case 2: {
                return new AirconNozzleListStyles(false, true, false, false);
            }
            case 3: {
                return new AirconNozzleListStyles(true, false, false, false);
            }
        }
        return new AirconNozzleListStyles();
    }

    @Override
    public Object getHMIValue(Object object) {
        AirconNozzleListStyles airconNozzleListStyles = (AirconNozzleListStyles)object;
        if (!airconNozzleListStyles.isInterval() && !airconNozzleListStyles.isFocus() && !airconNozzleListStyles.isDiffuse() && airconNozzleListStyles.isManual()) {
            return new Integer(0);
        }
        if (!airconNozzleListStyles.isInterval() && !airconNozzleListStyles.isFocus() && airconNozzleListStyles.isDiffuse() && !airconNozzleListStyles.isManual()) {
            return new Integer(1);
        }
        if (!airconNozzleListStyles.isInterval() && airconNozzleListStyles.isFocus() && !airconNozzleListStyles.isDiffuse() && !airconNozzleListStyles.isManual()) {
            return new Integer(2);
        }
        if (airconNozzleListStyles.isInterval() && !airconNozzleListStyles.isFocus() && !airconNozzleListStyles.isDiffuse() && !airconNozzleListStyles.isManual()) {
            return new Integer(3);
        }
        return new Integer(-1);
    }
}

