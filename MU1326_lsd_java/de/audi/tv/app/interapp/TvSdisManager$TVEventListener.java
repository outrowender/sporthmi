/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.interapp.TvSdisManager;
import de.audi.tv.app.interapp.TvSdisManager$1;
import org.dsi.ifc.tvtuner.ProgramInfo;

class TvSdisManager$TVEventListener
extends TVEventDefaultListener {
    private final /* synthetic */ TvSdisManager this$0;

    private TvSdisManager$TVEventListener(TvSdisManager tvSdisManager) {
        this.this$0 = tvSdisManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEsmLeft() {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$602(this.this$0, 0);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerAvailable() {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$602(this.this$0, 0);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerUnavailable() {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$602(this.this$0, -2);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onMuGotTvAudioFocus() {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$902(this.this$0, true);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onMuLostTvAudioFocus() {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$902(this.this$0, false);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    @Override
    public void parentalLevelSettingChanged(int n) {
        TvSdisManager.access$1002(this.this$0, n);
        TvSdisManager.access$800(this.this$0).updateParentalSettings(TvSdisManager.access$1100(this.this$0), n);
    }

    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
        TvSdisManager.access$1202(this.this$0, programInfo);
        TvSdisManager.access$1300(this.this$0, programInfo);
    }

    /* synthetic */ TvSdisManager$TVEventListener(TvSdisManager tvSdisManager, TvSdisManager$1 tvSdisManager$1) {
        this(tvSdisManager);
    }
}

