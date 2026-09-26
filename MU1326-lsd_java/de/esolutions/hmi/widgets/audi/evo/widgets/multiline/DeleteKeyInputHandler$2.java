/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.DeleteKeyInputHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ITimer;

class DeleteKeyInputHandler$2
implements ITimer {
    private final /* synthetic */ DeleteKeyInputHandler this$0;

    DeleteKeyInputHandler$2(DeleteKeyInputHandler deleteKeyInputHandler) {
        this.this$0 = deleteKeyInputHandler;
    }

    @Override
    public void onTimeout(int n) {
        if (this.this$0.m_cursor.getCursorMode() == 1) {
            if (DeleteKeyInputHandler.access$000(this.this$0)) {
                this.this$0.m_timerHandler.enqueueTimer(1);
                this.this$0.m_timerHandler.enqueueTimer(2);
            }
        } else if (DeleteKeyInputHandler.access$100(this.this$0)) {
            this.this$0.m_timerHandler.enqueueTimer(1);
        }
    }

    @Override
    public void onEnqueue(int n) {
    }

    @Override
    public void onCancel(int n) {
        this.this$0.m_timerDelays[1] = 250;
    }
}

