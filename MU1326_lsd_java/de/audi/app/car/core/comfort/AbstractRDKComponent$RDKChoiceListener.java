/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.core.comfort.AbstractRDKComponent;
import de.audi.app.car.core.comfort.AbstractRDKComponent$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

final class AbstractRDKComponent$RDKChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractRDKComponent this$0;

    private AbstractRDKComponent$RDKChoiceListener(AbstractRDKComponent abstractRDKComponent) {
        this.this$0 = abstractRDKComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractRDKComponent.RDKChoiceListener#itemSelected] modelID='%1', itemID='%2', col='%3'", (long)n, (long)n2, (long)n3);
        Integer n5 = new Integer(n2);
        switch (n) {
            case 602152: {
                try {
                    int n6 = (Integer)this.this$0.getRdkSpeedLimitConverterStrategy().getDSIValue(n5);
                    AbstractRDKComponent.access$500(this.this$0, n6);
                }
                catch (ValueConverterStrategyException valueConverterStrategyException) {
                    this.this$0.getLogChannel().log(10000, "[AbstractRDKComponent.RDKChoiceListener#itemSelected] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                }
                break;
            }
            case 601686: {
                try {
                    byte by = (Byte)this.this$0.getRdkPressureLevelConverterStrategy().getDSIValue(n5);
                    AbstractRDKComponent.access$600(this.this$0, by);
                }
                catch (ValueConverterStrategyException valueConverterStrategyException) {
                    this.this$0.getLogChannel().log(10000, "[AbstractRDKComponent.RDKChoiceListener#itemSelected] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                }
                break;
            }
        }
    }

    /* synthetic */ AbstractRDKComponent$RDKChoiceListener(AbstractRDKComponent abstractRDKComponent, AbstractRDKComponent$1 abstractRDKComponent$1) {
        this(abstractRDKComponent);
    }
}

