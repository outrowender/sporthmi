/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIManager;

class JDSIManager$PendingDSIStart {
    private final long timestamp;
    private final int domain;
    private final int state;
    private final /* synthetic */ JDSIManager this$0;

    JDSIManager$PendingDSIStart(JDSIManager jDSIManager, int n, int n2) {
        this.this$0 = jDSIManager;
        this.timestamp = JDSIManager.access$000(jDSIManager).getMonotonicTime();
        this.domain = n;
        this.state = n2;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.timestamp).append("]PendingDSIStart(").append(this.domain).append(",0x").append(Integer.toHexString(this.state)).append(")").toString();
    }

    static /* synthetic */ int access$100(JDSIManager$PendingDSIStart jDSIManager$PendingDSIStart) {
        return jDSIManager$PendingDSIStart.state;
    }
}

