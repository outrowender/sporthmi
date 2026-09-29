/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.settings;

import de.audi.app.messaging.evo.settings.SmscNumberController;
import de.audi.app.messaging.evo.settings.SmscNumberController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class SmscNumberController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SmscNumberController this$0;

    private SmscNumberController$MyButtonListener(SmscNumberController smscNumberController) {
        this.this$0 = smscNumberController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 2200443: {
                SmscNumberController.access$600(this.this$0).log(1078071040, "[SmscNumberController#MyButtonListener#keyTyped] modelID = SMSC_NUMBER_TEXTFIELD");
                SmscNumberController.access$800(this.this$0, SmscNumberController.access$700(this.this$0).getText1());
                SmscNumberController.access$700(this.this$0).fireEvent(n3);
                break;
            }
            case 2200444: {
                SmscNumberController.access$900(this.this$0).log(1078071040, "[SmscNumberController#MyButtonListener#keyTyped] modelID = SMSC_NUMBER_OK_BUTTON");
                SmscNumberController.access$1000(this.this$0);
                SmscNumberController.access$1100(this.this$0).fireEvent(n3);
                break;
            }
            default: {
                SmscNumberController.access$1200(this.this$0).log(10000, "[SmscNumberController#MyButtonListener#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    /* synthetic */ SmscNumberController$MyButtonListener(SmscNumberController smscNumberController, SmscNumberController$1 smscNumberController$1) {
        this(smscNumberController);
    }
}

