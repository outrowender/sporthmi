/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.EwsSetting;
import de.audi.tv.app.settings.EwsSetting$1;

class EwsSetting$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ EwsSetting this$0;

    private EwsSetting$ChoiceListener(EwsSetting ewsSetting) {
        this.this$0 = ewsSetting;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 == 1;
        EwsSetting.access$100((EwsSetting)this.this$0).lcHMI.log(-2137614336, "[EwsSetting.itemSelected] %2 -> %1", bl, (long)n2);
        EwsSetting.access$200(this.this$0, bl);
    }

    /* synthetic */ EwsSetting$ChoiceListener(EwsSetting ewsSetting, EwsSetting$1 ewsSetting$1) {
        this(ewsSetting);
    }
}

