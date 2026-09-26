/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.TVInfobar;
import de.audi.tv.app.TVInfobar$1;
import de.audi.tv.app.base.TVEventDefaultListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

class TVInfobar$EventListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVInfobar this$0;

    private TVInfobar$EventListener(TVInfobar tVInfobar) {
        this.this$0 = tVInfobar;
    }

    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
        TVInfobar.access$700(this.this$0, programInfo, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onMuGotTvAudioFocus() {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$802(this.this$0, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onMuLostTvAudioFocus() {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$900(this.this$0).cancel();
            TVInfobar.access$802(this.this$0, false);
            TVInfobar.access$600(this.this$0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEWSInfoVisibilityChange(boolean bl) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$1002(this.this$0, bl);
            if (bl) {
                TVInfobar.access$900(this.this$0).cancel();
                TVInfobar.access$600(this.this$0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onFullscreenEntered(int n) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$1102(this.this$0, true);
            if (!TVInfobar.access$1200(this.this$0) && !TVInfobar.access$1000(this.this$0)) {
                TVInfobar.access$900(this.this$0).cancel();
                TVInfobar.access$1400(this.this$0, TVInfobar.access$1300(this.this$0));
                TVInfobar.access$1500(this.this$0).flush();
                TVInfobar.access$900(this.this$0).start();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onFullscreenLeft(int n) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$900(this.this$0).cancel();
            TVInfobar.access$1102(this.this$0, false);
            TVInfobar.access$600(this.this$0);
        }
    }

    /* synthetic */ TVInfobar$EventListener(TVInfobar tVInfobar, TVInfobar$1 tVInfobar$1) {
        this(tVInfobar);
    }
}

