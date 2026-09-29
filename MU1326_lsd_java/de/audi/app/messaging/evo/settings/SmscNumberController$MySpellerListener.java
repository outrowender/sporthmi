/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.settings;

import de.audi.app.messaging.evo.settings.SmscNumberController;
import de.audi.app.messaging.evo.settings.SmscNumberController$1;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;

class SmscNumberController$MySpellerListener
extends DefaultSpellerListener {
    private final /* synthetic */ SmscNumberController this$0;

    private SmscNumberController$MySpellerListener(SmscNumberController smscNumberController) {
        this.this$0 = smscNumberController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 2200442: {
                SmscNumberController.access$1300(this.this$0).log(1078071040, "[SmscNumberController#MySpellerListener#keyTyped] id = SMSC_NUMBER_DIRECT_WRITING_SPELLER, keyID = %1", (long)n2);
                SmscNumberController.access$1000(this.this$0);
                SmscNumberController.access$1100(this.this$0).fireEvent(n3);
                break;
            }
            default: {
                SmscNumberController.access$1400(this.this$0).log(10000, "[SmscNumberController#MySpellerListener#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        switch (n) {
            case 2200441: {
                SmscNumberController.access$1500(this.this$0).log(1078071040, "[SmscNumberController#MySpellerListener#textChanged] id = SMSC_NUMBER_SPELLER, latestChar = %1", c2);
                SmscNumberController.access$1600(this.this$0);
                SmscNumberController.access$800(this.this$0, String.valueOf(c2));
                SmscNumberController.access$700(this.this$0).fireEvent(n2);
                break;
            }
            case 2200442: {
                SmscNumberController.access$1700(this.this$0).log(1078071040, "[SmscNumberController#MySpellerListener#textChanged] id = SMSC_NUMBER_DIRECT_WRITING_SPELLER, latestChar = %1", c2);
                SmscNumberController.access$800(this.this$0, string);
                break;
            }
            default: {
                SmscNumberController.access$1800(this.this$0).log(1078071040, "[SmscNumberController#MySpellerListener#textChanged] Unexpected modelID = %1", (long)n);
            }
        }
    }

    /* synthetic */ SmscNumberController$MySpellerListener(SmscNumberController smscNumberController, SmscNumberController$1 smscNumberController$1) {
        this(smscNumberController);
    }
}

