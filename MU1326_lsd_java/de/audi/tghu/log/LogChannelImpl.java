/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogServAdmin;
import de.audi.tghu.log.LogEntryImpl;

final class LogChannelImpl
extends LogChannel {
    private final LogServAdmin logServ;
    private boolean useKombiTime;

    public LogChannelImpl(LogServAdmin logServAdmin, boolean bl) {
        this.logServ = logServAdmin;
        this.useKombiTime = bl;
    }

    public void log(int n, String string, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
        this.logServ.log(new LogEntryImpl(this.logServ.getTimeStamp(this.useKombiTime), this.name, n, string, object, object2, object3, object4, l, l2, l3, n2, throwable));
    }

    public void log(int n, int n2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n3, Throwable throwable) {
        this.logServ.log(new LogEntryImpl(this.logServ.getTimeStamp(this.useKombiTime), this.name, n, n2, object, object2, object3, object4, l, l2, l3, n3, throwable));
    }
}

