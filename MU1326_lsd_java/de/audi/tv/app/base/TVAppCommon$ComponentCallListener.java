/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.tv.ITVComponentListener;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.dsi.DSICallListener;

public class TVAppCommon$ComponentCallListener
extends DSICallListener {
    private ITVComponentListener componentListener;
    private boolean startCalled;
    private final /* synthetic */ TVAppCommon this$0;

    public TVAppCommon$ComponentCallListener(TVAppCommon tVAppCommon) {
        this.this$0 = tVAppCommon;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startComponent(int n, int n2, int n3) {
        ITVComponentListener iTVComponentListener;
        TVAppCommon$ComponentCallListener tVAppCommon$ComponentCallListener = this;
        synchronized (tVAppCommon$ComponentCallListener) {
            iTVComponentListener = this.componentListener;
            this.startCalled = true;
        }
        if (iTVComponentListener != null) {
            iTVComponentListener.startComponenCalled();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stopComponent(int n, int n2, int n3) {
        ITVComponentListener iTVComponentListener;
        TVAppCommon$ComponentCallListener tVAppCommon$ComponentCallListener = this;
        synchronized (tVAppCommon$ComponentCallListener) {
            iTVComponentListener = this.componentListener;
            this.startCalled = false;
        }
        if (iTVComponentListener != null) {
            iTVComponentListener.stopComponentCalled();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setListener(ITVComponentListener iTVComponentListener) {
        TVAppCommon$ComponentCallListener tVAppCommon$ComponentCallListener = this;
        synchronized (tVAppCommon$ComponentCallListener) {
            this.componentListener = iTVComponentListener;
        }
        if (this.componentListener != null && this.startCalled) {
            iTVComponentListener.startComponenCalled();
        }
    }
}

