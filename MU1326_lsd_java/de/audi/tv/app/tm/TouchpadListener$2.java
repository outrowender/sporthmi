/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.tm.TouchpadListener;

class TouchpadListener$2
extends TVEventDefaultListener {
    private final /* synthetic */ TouchpadListener this$0;

    TouchpadListener$2(TouchpadListener touchpadListener) {
        this.this$0 = touchpadListener;
    }

    @Override
    public void onTerminalModeInputModeChange(int n) {
        if (n == 0) {
            TouchpadListener.access$100(this.this$0, TouchpadListener.access$000(this.this$0), 0);
        }
    }
}

