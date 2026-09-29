/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIManager;
import de.esolutions.fw.util.commons.Buffer;

class JDSIManager$DSIHistoryServiceRemoved {
    private final long timestamp;
    private final String serviceName;
    private final long instanceID;
    private final /* synthetic */ JDSIManager this$0;

    JDSIManager$DSIHistoryServiceRemoved(JDSIManager jDSIManager, String string, int n) {
        this.this$0 = jDSIManager;
        this.timestamp = JDSIManager.access$000(jDSIManager).getMonotonicTime();
        this.serviceName = string;
        this.instanceID = n;
    }

    public String toString() {
        return new Buffer().append('[').append(this.timestamp).append("] removed DSI: ").append(this.serviceName).append(" instance ").append(this.instanceID).toString();
    }
}

