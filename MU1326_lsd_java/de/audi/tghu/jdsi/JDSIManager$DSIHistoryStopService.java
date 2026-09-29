/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIManager;
import de.esolutions.fw.util.commons.Buffer;

class JDSIManager$DSIHistoryStopService {
    private final long timestamp;
    private final String service;
    private final int instance;
    private final /* synthetic */ JDSIManager this$0;

    JDSIManager$DSIHistoryStopService(JDSIManager jDSIManager, String string, int n) {
        this.this$0 = jDSIManager;
        this.timestamp = JDSIManager.access$000(jDSIManager).getMonotonicTime();
        this.service = string;
        this.instance = n;
    }

    public String toString() {
        return new Buffer().append('[').append(this.timestamp).append("] stopped DSI: ").append(this.service).append(':').append(this.instance).toString();
    }
}

