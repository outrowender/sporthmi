/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.atip.hmi.model.DefaultRangeListener;

class AbstractAirconComponent$2
extends DefaultRangeListener {
    private final /* synthetic */ AbstractAirconComponent this$0;

    AbstractAirconComponent$2(AbstractAirconComponent abstractAirconComponent) {
        this.this$0 = abstractAirconComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirConditionComponent#keyPressed] modelID='%1'", (long)n);
        switch (n) {
            case 601991: {
                AbstractAirconComponent.access$3300(this.this$0, -2026960640).fireEvent(n3);
                break;
            }
            case 601990: {
                AbstractAirconComponent.access$3400(this.this$0, -2043737856).fireEvent(n3);
                break;
            }
            case 601988: {
                AbstractAirconComponent.access$3500(this.this$0, -2077292288).fireEvent(n3);
                break;
            }
            case 601989: {
                AbstractAirconComponent.access$3600(this.this$0, -2060515072).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractAirconComponent.DefaultRangeListener#decrement] modelID=%1, steps=%2", (long)n, (long)n2);
        switch (n) {
            case 600630: {
                AbstractAirconComponent.access$3700(this.this$0).notifyDecrement(5, n2);
                break;
            }
            case 602187: {
                this.this$0.temperatureZone1.decrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(1);
                break;
            }
            case 602192: {
                this.this$0.temperatureZone1.decrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(1);
                break;
            }
            case 602195: {
                this.this$0.temperatureZone2.decrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(2);
                break;
            }
            case 602194: {
                this.this$0.temperatureZone2.decrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(2);
                break;
            }
            case 602162: {
                this.this$0.airVolumeZone1.decrementVolume(n2);
                this.this$0.onVolumeAction(1);
                break;
            }
            case 602165: {
                this.this$0.airVolumeZone2.decrementVolume(n2);
                this.this$0.onVolumeAction(2);
                break;
            }
            case 601991: {
                AbstractAirconComponent.access$3800(this.this$0, 1, n2);
                break;
            }
            case 601990: {
                AbstractAirconComponent.access$3800(this.this$0, 2, n2);
                break;
            }
            case 602186: {
                this.this$0.temperatureZone3.decrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(3);
                break;
            }
            case 602403: {
                this.this$0.temperatureZone3.decrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(3);
                break;
            }
            case 602197: {
                this.this$0.temperatureZone4.decrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(4);
                break;
            }
            case 602413: {
                this.this$0.temperatureZone4.decrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(4);
                break;
            }
            case 602416: {
                this.this$0.airVolumeZone3.decrementVolume(n2);
                this.this$0.onVolumeAction(3);
                break;
            }
            case 602407: {
                this.this$0.airVolumeZone4.decrementVolume(n2);
                this.this$0.onVolumeAction(4);
                break;
            }
            case 601988: {
                AbstractAirconComponent.access$3800(this.this$0, 3, n2);
                break;
            }
            case 601989: {
                AbstractAirconComponent.access$3800(this.this$0, 4, n2);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AbstractAirconComponent.DefaultRangeListener#decrement] ModelID='%1' not supported.", (long)n);
            }
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractAirconComponent.DefaultRangeListener#increment] modelID=%1, steps=%2", (long)n, (long)n2);
        switch (n) {
            case 600630: {
                AbstractAirconComponent.access$3700(this.this$0).notifyIncrement(5, n2);
                break;
            }
            case 602187: {
                this.this$0.temperatureZone1.incrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(1);
                break;
            }
            case 602192: {
                this.this$0.temperatureZone1.incrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(1);
                break;
            }
            case 602195: {
                this.this$0.temperatureZone2.incrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(2);
                break;
            }
            case 602194: {
                this.this$0.temperatureZone2.incrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(2);
                break;
            }
            case 602162: {
                this.this$0.airVolumeZone1.incrementVolume(n2);
                this.this$0.onVolumeAction(1);
                break;
            }
            case 602165: {
                this.this$0.airVolumeZone2.incrementVolume(n2);
                this.this$0.onVolumeAction(2);
                break;
            }
            case 601991: {
                AbstractAirconComponent.access$3900(this.this$0, 1, n2);
                break;
            }
            case 601990: {
                AbstractAirconComponent.access$3900(this.this$0, 2, n2);
                break;
            }
            case 602186: {
                this.this$0.temperatureZone3.incrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(3);
                break;
            }
            case 602403: {
                this.this$0.temperatureZone3.incrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(3);
                break;
            }
            case 602197: {
                this.this$0.temperatureZone4.incrementTemperature(n2, 1);
                this.this$0.onTemperatureAction(4);
                break;
            }
            case 602413: {
                this.this$0.temperatureZone4.incrementTemperature(n2, 2);
                this.this$0.onTemperatureAction(4);
                break;
            }
            case 602416: {
                this.this$0.airVolumeZone3.incrementVolume(n2);
                this.this$0.onVolumeAction(3);
                break;
            }
            case 602407: {
                this.this$0.airVolumeZone4.incrementVolume(n2);
                this.this$0.onVolumeAction(4);
                break;
            }
            case 601988: {
                AbstractAirconComponent.access$3900(this.this$0, 3, n2);
                break;
            }
            case 601989: {
                AbstractAirconComponent.access$3900(this.this$0, 4, n2);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AbstractAirconComponent.DefaultRangeListener#increment] ModelID='%1' not supported.", (long)n);
            }
        }
    }
}

