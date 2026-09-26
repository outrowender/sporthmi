/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.indication;

import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.evo.indication.PhoneIndicationController;
import de.audi.app.messaging.evo.indication.PhoneIndicationController$1;

class PhoneIndicationController$NewMessageIndicationManagerObserver
implements INewMessageIndicationManagerObserver {
    private final /* synthetic */ PhoneIndicationController this$0;

    private PhoneIndicationController$NewMessageIndicationManagerObserver(PhoneIndicationController phoneIndicationController) {
        this.this$0 = phoneIndicationController;
    }

    @Override
    public void indicateIndicationStateChanged(int n) {
        PhoneIndicationController.access$600(this.this$0).log(-2137614336, "[PhoneIndicationController#indicateIndicationStateChanged] stateAspect = %1", (long)n);
        if (n == 0) {
            PhoneIndicationController.access$700(this.this$0);
        }
    }

    /* synthetic */ PhoneIndicationController$NewMessageIndicationManagerObserver(PhoneIndicationController phoneIndicationController, PhoneIndicationController$1 phoneIndicationController$1) {
        this(phoneIndicationController);
    }
}

