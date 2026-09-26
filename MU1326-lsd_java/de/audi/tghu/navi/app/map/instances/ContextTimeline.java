/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.context.CtxShown;

public class ContextTimeline {
    public volatile IContext active = null;
    public volatile IContext last = null;
    public volatile int activeCid = 0;
    public volatile int lastCid = 0;
    public volatile int lastVisibleCid = 0;
    public volatile int lastShownCid = 0;
    public volatile int lastShownAndModifiedCid = 0;
    private volatile int intendedCtxId = -1;

    public String toString() {
        return StringUtilities.formatMessage("%1|%2|%3 [%4]", new int[]{this.lastCid, this.lastVisibleCid, this.lastShownCid, this.activeCid});
    }

    public void add(int n, IContext iContext) {
        this.lastCid = this.activeCid;
        this.last = this.active;
        this.active = iContext;
        this.activeCid = n;
        if (this.last == null) {
            this.last = iContext;
        }
        if (this.lastCid == 0) {
            this.lastCid = n;
        }
        if (this.last instanceof IVisibleContext) {
            this.lastVisibleCid = this.lastCid;
        }
        if (this.last instanceof CtxShown && this.lastShownCid != this.lastCid) {
            this.lastShownCid = this.lastCid;
            if (this.activeCid != this.lastCid && this.active instanceof CtxShown) {
                this.lastShownAndModifiedCid = this.lastCid;
            }
        }
    }

    public void setIntention(int n) {
        this.intendedCtxId = n;
    }

    public void clearIntention() {
        this.intendedCtxId = -1;
    }

    public int getIntention() {
        return this.intendedCtxId;
    }
}

