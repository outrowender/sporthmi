/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.tm.TVEngineering;
import de.audi.tv.app.tm.TVEngineering$1;

class TVEngineering$ActivationListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVEngineering this$0;

    private TVEngineering$ActivationListener(TVEngineering tVEngineering) {
        this.this$0 = tVEngineering;
    }

    @Override
    public void onMuGotTvAudioFocus() {
        TVEngineering.access$200(this.this$0);
    }

    @Override
    public void onAppActivated(int n) {
        TVEngineering.access$200(this.this$0);
    }

    /* synthetic */ TVEngineering$ActivationListener(TVEngineering tVEngineering, TVEngineering$1 tVEngineering$1) {
        this(tVEngineering);
    }
}

