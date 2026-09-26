/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.EditorModeController;
import de.audi.app.messaging.evo.compose.EditorModeController$1;
import de.audi.atip.msg.MsgListener;

final class EditorModeController$MyMsgListener
implements MsgListener {
    private final /* synthetic */ EditorModeController this$0;

    private EditorModeController$MyMsgListener(EditorModeController editorModeController) {
        this.this$0 = editorModeController;
    }

    @Override
    public void processMsg(int n) {
        boolean bl;
        boolean bl2 = n == 206;
        boolean bl3 = bl = n == 207;
        if (bl2 || bl) {
            EditorModeController.access$500(this.this$0).log(1078071040, "[EditorModeController#MyMsgListener#processMsg] LOCK_FEATURE_ACTIVATED=%1, LOCK_FEATURE_DEACTIVATED=%1", bl2, bl);
            EditorModeController.access$600(this.this$0);
        }
    }

    /* synthetic */ EditorModeController$MyMsgListener(EditorModeController editorModeController, EditorModeController$1 editorModeController$1) {
        this(editorModeController);
    }
}

