/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.indication;

import de.audi.app.messaging.evo.indication.PhoneIndicationController;
import de.audi.app.messaging.evo.indication.PhoneIndicationController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class PhoneIndicationController$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ PhoneIndicationController this$0;

    private PhoneIndicationController$ButtonListener(PhoneIndicationController phoneIndicationController) {
        this.this$0 = phoneIndicationController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 3960) {
            PhoneIndicationController.access$800(this.this$0, n, n3);
        } else {
            PhoneIndicationController.access$900(this.this$0).log(10000, "[PhoneIndicationController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ PhoneIndicationController$ButtonListener(PhoneIndicationController phoneIndicationController, PhoneIndicationController$1 phoneIndicationController$1) {
        this(phoneIndicationController);
    }
}

