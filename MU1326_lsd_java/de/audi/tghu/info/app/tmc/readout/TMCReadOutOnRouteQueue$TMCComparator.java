/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessageImpl;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutOnRouteQueue;
import java.util.Comparator;

class TMCReadOutOnRouteQueue$TMCComparator
implements Comparator {
    private final /* synthetic */ TMCReadOutOnRouteQueue this$0;

    TMCReadOutOnRouteQueue$TMCComparator(TMCReadOutOnRouteQueue tMCReadOutOnRouteQueue) {
        this.this$0 = tMCReadOutOnRouteQueue;
    }

    @Override
    public int compare(Object object, Object object2) {
        TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)object;
        TMCReadOutMessageImpl tMCReadOutMessageImpl2 = (TMCReadOutMessageImpl)object2;
        long l = this.getDistanceForCalculation(tMCReadOutMessageImpl);
        long l2 = this.getDistanceForCalculation(tMCReadOutMessageImpl2);
        return (int)(this.this$0.distanceToTarget - l - (this.this$0.distanceToTarget - l2));
    }

    private long getDistanceForCalculation(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        switch (tMCReadOutMessageImpl.getReadOutState()) {
            case 1: 
            case 3: {
                return tMCReadOutMessageImpl.getDistanceToAttentionPoint2();
            }
            case -1: {
                return tMCReadOutMessageImpl.getDistanceToAttentionPoint1();
            }
        }
        return tMCReadOutMessageImpl.getDistanceToAttentionPoint1();
    }
}

