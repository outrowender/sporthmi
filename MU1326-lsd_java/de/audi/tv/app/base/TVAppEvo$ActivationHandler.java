/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.ap.TVActionProxyDefaultListenerEvo;
import de.audi.tv.app.base.TVAppEvo;
import de.audi.tv.app.base.TVAppEvo$1;

class TVAppEvo$ActivationHandler
extends TVActionProxyDefaultListenerEvo {
    private final /* synthetic */ TVAppEvo this$0;

    private TVAppEvo$ActivationHandler(TVAppEvo tVAppEvo) {
        this.this$0 = tVAppEvo;
    }

    @Override
    public void hmiActivatedTV(int n) {
        this.this$0.tvEventDispatcher.updateAppActivated(0);
        this.this$0.audioFocus.activateTVAudio(0);
    }

    @Override
    public void hmiDeactivatedTV(int n) {
        this.this$0.tvEventDispatcher.updateAppDeactivated(0);
    }

    @Override
    public void tvFullscreenEntered(int n) {
        this.this$0.tvEventDispatcher.enteredFullscreen(n);
    }

    @Override
    public void tvFullscreenLeft(int n) {
        this.this$0.tvEventDispatcher.leftFullscreen(n);
    }

    @Override
    public void tvSeekModeLeft(int n) {
        this.this$0.seekHandler.abortSeek();
    }

    @Override
    public void tvEwsPopupClosed(int n) {
        this.this$0.ews.onEwsPopupClosed();
    }

    /* synthetic */ TVAppEvo$ActivationHandler(TVAppEvo tVAppEvo, TVAppEvo$1 tVAppEvo$1) {
        this(tVAppEvo);
    }
}

