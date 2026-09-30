/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.base.BaseLogEntryImpl;
import de.audi.tghu.log.LogExtractorFactory;

public final class LogEntryImpl
extends BaseLogEntryImpl {
    private int msgID;

    public LogEntryImpl(long l, String string, int n, String string2, Object object, Object object2, Object object3, Object object4, long l2, long l3, long l4, int n2, Throwable throwable) {
        super(l, string, n, string2, object, object2, object3, object4, l2, l3, l4, n2, throwable);
    }

    public LogEntryImpl(long l, String string, int n, int n2, Object object, Object object2, Object object3, Object object4, long l2, long l3, long l4, int n3, Throwable throwable) {
        super(l, string, n, null, object, object2, object3, object4, l2, l3, l4, n3, throwable);
        this.msgID = n2;
    }

    public String getTemplate() {
        if (this.template == null) {
            this.template = LogExtractorFactory.getInstance().getMsg(this.msgID, this.logLevel);
        }
        return this.template;
    }
}

