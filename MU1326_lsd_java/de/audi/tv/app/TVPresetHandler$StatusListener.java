/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.TVPresetHandler;
import de.audi.tv.app.TVPresetHandler$1;
import de.audi.tv.app.base.TVEventDefaultListener;

class TVPresetHandler$StatusListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVPresetHandler this$0;

    private TVPresetHandler$StatusListener(TVPresetHandler tVPresetHandler) {
        this.this$0 = tVPresetHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEsmEntered() {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            TVPresetHandler.access$1102(this.this$0, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEsmLeft() {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            TVPresetHandler.access$1102(this.this$0, true);
            if (TVPresetHandler.access$1800(this.this$0) != null) {
                TVPresetHandler.access$1300(this.this$0).changeService(TVPresetHandler.access$1800(this.this$0), true);
                TVPresetHandler.access$1802(this.this$0, null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onMuGotTvAudioFocus() {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            TVPresetHandler.access$1602(this.this$0, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onMuLostTvAudioFocus() {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            TVPresetHandler.access$1602(this.this$0, false);
        }
    }

    /* synthetic */ TVPresetHandler$StatusListener(TVPresetHandler tVPresetHandler, TVPresetHandler$1 tVPresetHandler$1) {
        this(tVPresetHandler);
    }
}

