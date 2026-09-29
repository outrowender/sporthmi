/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconSeatComponent;
import de.audi.atip.hmi.model.DefaultRangeListener;

class AbstractAirconSeatComponent$1
extends DefaultRangeListener {
    private final /* synthetic */ AbstractAirconSeatComponent this$0;

    AbstractAirconSeatComponent$1(AbstractAirconSeatComponent abstractAirconSeatComponent) {
        this.this$0 = abstractAirconSeatComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirConditionSeatComponent#keyPressed] modelID='%1'", (long)n);
        switch (n) {
            case 600656: {
                AbstractAirconSeatComponent.access$000(this.this$0, 1344932096).fireEvent(n3);
                break;
            }
            case 600655: {
                AbstractAirconSeatComponent.access$100(this.this$0, 1328154880).fireEvent(n3);
                break;
            }
            case 600658: {
                AbstractAirconSeatComponent.access$200(this.this$0, 1378486528).fireEvent(n3);
                break;
            }
            case 600657: {
                AbstractAirconSeatComponent.access$300(this.this$0, 1361709312).fireEvent(n3);
                break;
            }
            case 600652: {
                AbstractAirconSeatComponent.access$400(this.this$0, 1277823232).fireEvent(n3);
                break;
            }
            case 600651: {
                AbstractAirconSeatComponent.access$500(this.this$0, 1261046016).fireEvent(n3);
                break;
            }
            case 600654: {
                AbstractAirconSeatComponent.access$600(this.this$0, 1311377664).fireEvent(n3);
                break;
            }
            case 600653: {
                AbstractAirconSeatComponent.access$700(this.this$0, 1294600448).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractAirconSeatComponent] RangeListener (modelID='%1') decrement: steps:%2", (long)n, (long)n2);
        AbstractAirconSeatComponent.access$800(this.this$0, n, -n2, n3);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractAirconSeatComponent] RangeListener (modelID='%1') increment: steps:%2", (long)n, (long)n2);
        AbstractAirconSeatComponent.access$800(this.this$0, n, n2, n3);
    }
}

