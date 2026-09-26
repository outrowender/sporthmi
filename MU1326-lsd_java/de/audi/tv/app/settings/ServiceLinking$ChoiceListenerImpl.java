/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.ServiceLinking;
import de.audi.tv.app.settings.ServiceLinking$1;

class ServiceLinking$ChoiceListenerImpl
extends DefaultChoiceListener {
    private final /* synthetic */ ServiceLinking this$0;

    private ServiceLinking$ChoiceListenerImpl(ServiceLinking serviceLinking) {
        this.this$0 = serviceLinking;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 == 1;
        ServiceLinking.access$100((ServiceLinking)this.this$0).lcHMI.log(-2137614336, "[ServiceLinking.itemSelected] %2 -> %1", bl, (long)n2);
        ServiceLinking.access$200(this.this$0).enableServiceLinking(bl);
    }

    /* synthetic */ ServiceLinking$ChoiceListenerImpl(ServiceLinking serviceLinking, ServiceLinking$1 serviceLinking$1) {
        this(serviceLinking);
    }
}

