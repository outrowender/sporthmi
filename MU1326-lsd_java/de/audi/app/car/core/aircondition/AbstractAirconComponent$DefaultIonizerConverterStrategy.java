/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.app.car.core.aircondition.AbstractAirconComponent$1;

class AbstractAirconComponent$DefaultIonizerConverterStrategy
implements IValueConverterStrategy {
    private static final int IONIZER_OFF;
    private static final int IONIZER_ON;
    private static final int IONIZER_AUTO;
    private final /* synthetic */ AbstractAirconComponent this$0;

    private AbstractAirconComponent$DefaultIonizerConverterStrategy(AbstractAirconComponent abstractAirconComponent) {
        this.this$0 = abstractAirconComponent;
    }

    @Override
    public Object getDSIValue(Object object) {
        int n;
        switch ((Integer)object) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                throw new ValueConverterStrategyException(1);
            }
        }
        return new Integer(n);
    }

    @Override
    public Object getHMIValue(Object object) {
        int n;
        switch ((Integer)object) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                throw new ValueConverterStrategyException(1);
            }
        }
        return new Integer(n);
    }

    /* synthetic */ AbstractAirconComponent$DefaultIonizerConverterStrategy(AbstractAirconComponent abstractAirconComponent, AbstractAirconComponent$1 abstractAirconComponent$1) {
        this(abstractAirconComponent);
    }
}

