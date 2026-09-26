/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.deletemessage.DeleteMessageController;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class DeleteMessageController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ DeleteMessageController this$0;

    private DeleteMessageController$MyButtonListener(DeleteMessageController deleteMessageController) {
        this.this$0 = deleteMessageController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1704075520 || n == 1116938496) {
            DeleteMessageController.access$300(this.this$0, n, n3);
        } else if (n == 1418928384) {
            DeleteMessageController.access$400(this.this$0, n, n3);
        } else if (n == 1469260032) {
            DeleteMessageController.access$500(this.this$0, n, n3);
        } else if (n == 1452482816) {
            DeleteMessageController.access$600(this.this$0, n, n3);
        } else if (n == 1435705600) {
            DeleteMessageController.access$700(this.this$0, n, n3);
        } else {
            DeleteMessageController.access$800(this.this$0).log(10000, "[DeleteMessageController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ DeleteMessageController$MyButtonListener(DeleteMessageController deleteMessageController, DeleteMessageController$1 deleteMessageController$1) {
        this(deleteMessageController);
    }
}

