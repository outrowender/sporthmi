/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.misc;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.misc.OptionsHandler;
import de.audi.tuner.app.misc.OptionsHandler$1;

class OptionsHandler$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ OptionsHandler this$0;

    private OptionsHandler$ChoiceListener(OptionsHandler optionsHandler) {
        this.this$0 = optionsHandler;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 100887: {
                OptionsHandler.access$100(this.this$0).storeShowRadioText(n2 == 1);
                break;
            }
            case 100876: {
                OptionsHandler.access$100(this.this$0).storeAmfmView(n2);
                OptionsHandler.access$200(this.this$0).setPorscheNameMode(n2 == 0);
                TunerProxyManager.getInstance().getAmFmTuner().reNotification(2);
                OptionsHandler.access$300(this.this$0, n2);
                break;
            }
        }
        OptionsHandler.access$400(this.this$0).getChoiceModel(n).setValue(n2);
    }

    /* synthetic */ OptionsHandler$ChoiceListener(OptionsHandler optionsHandler, OptionsHandler$1 optionsHandler$1) {
        this(optionsHandler);
    }
}

