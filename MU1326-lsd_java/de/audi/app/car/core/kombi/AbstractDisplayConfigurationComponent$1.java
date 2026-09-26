/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent;
import de.audi.atip.hmi.model.DefaultRangeListener;

class AbstractDisplayConfigurationComponent$1
extends DefaultRangeListener {
    private final /* synthetic */ AbstractDisplayConfigurationComponent this$0;

    AbstractDisplayConfigurationComponent$1(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent) {
        this.this$0 = abstractDisplayConfigurationComponent;
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(1078071040, "AbstractDisplayConfigurationComponent.DefaultRangeListener#decrement: '%1', modelID: '%2'", (long)n2, (long)n);
        switch (n) {
            case 602293: {
                int n4 = AbstractDisplayConfigurationComponent.access$100(this.this$0, n).getValue() - n2;
                this.setBrightness(n4);
                break;
            }
            case 602323: {
                int n5 = AbstractDisplayConfigurationComponent.access$200(this.this$0, n).getValue() - n2;
                this.setVolume(n5);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "AbstractDisplayConfigurationComponent.DefaultRangeListener#increment: ModelID='%1' not supported.", (long)n);
            }
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(1078071040, "AbstractDisplayConfigurationComponent.DefaultRangeListener#increment: '%1', modelID: '%2'", (long)n2, (long)n);
        switch (n) {
            case 602293: {
                int n4 = AbstractDisplayConfigurationComponent.access$300(this.this$0, n).getValue() + n2;
                this.setBrightness(n4);
                break;
            }
            case 602323: {
                int n5 = AbstractDisplayConfigurationComponent.access$400(this.this$0, n).getValue() + n2;
                this.setVolume(n5);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "AbstractDisplayConfigurationComponent.DefaultRangeListener#increment: ModelID='%1' not supported.", (long)n);
            }
        }
    }

    private void setBrightness(int n) {
        AbstractDisplayConfigurationComponent.access$500(this.this$0).setTempValue(n);
        try {
            this.this$0.displayConfigurationController.dsiSetBrightness(this.this$0.brightnessRangeValueConverterStrategy.getDSIValue(n));
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.this$0.getLogChannel().log(-1601830656, "AbstractDisplayConfigurationComponent.DefaultRangeListener#setVolume] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
        }
    }

    private void setVolume(int n) {
        AbstractDisplayConfigurationComponent.access$600(this.this$0).setTempValue(n);
        try {
            this.this$0.displayConfigurationController.dsiSetVolume(this.this$0.volumeRangeValueConverterStrategy.getDSIValue(n));
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.this$0.getLogChannel().log(-1601830656, "AbstractDisplayConfigurationComponent.DefaultRangeListener#setVolume] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
        }
    }
}

