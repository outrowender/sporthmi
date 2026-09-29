/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DSIHandler$1;

public class DSIHandler$DSIDownCallLock {
    private final String tag;
    private volatile boolean acquired;
    private final /* synthetic */ DSIHandler this$0;

    private DSIHandler$DSIDownCallLock(DSIHandler dSIHandler, String string) {
        this.this$0 = dSIHandler;
        this.tag = string;
    }

    public void acquire() {
        DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.DSIDownCallLock.acquire] %1", (Object)this.tag);
        this.acquired = true;
        DSIHandler.access$100(this.this$0);
    }

    public void release() {
        if (this.acquired) {
            DSIHandler.access$000(this.this$0).log(1078071040, "[DSIHandler.DSIDownCallLock.release] %1", (Object)this.tag);
        }
        this.acquired = false;
        DSIHandler.access$100(this.this$0);
    }

    /* synthetic */ DSIHandler$DSIDownCallLock(DSIHandler dSIHandler, String string, DSIHandler$1 dSIHandler$1) {
        this(dSIHandler, string);
    }

    static /* synthetic */ boolean access$600(DSIHandler$DSIDownCallLock dSIHandler$DSIDownCallLock) {
        return dSIHandler$DSIDownCallLock.acquired;
    }

    static /* synthetic */ String access$700(DSIHandler$DSIDownCallLock dSIHandler$DSIDownCallLock) {
        return dSIHandler$DSIDownCallLock.tag;
    }
}

