/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.app.media.evo.content.tv.TVContent;
import de.audi.atip.interapp.tv.ITVComponentListener;

class TVContent$1
implements ITVComponentListener {
    private final /* synthetic */ TVContent this$0;

    TVContent$1(TVContent tVContent) {
        this.this$0 = tVContent;
    }

    @Override
    public void stopComponentCalled() {
        TVContent.access$002(this.this$0, false);
    }

    @Override
    public void startComponenCalled() {
        TVContent.access$002(this.this$0, true);
        this.this$0.notifyContentActivationFinished();
    }
}

