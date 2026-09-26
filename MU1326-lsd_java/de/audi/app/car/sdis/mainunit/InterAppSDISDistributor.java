/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.mainunit;

import de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor;
import de.audi.app.car.sdis.SDISCarManager;
import de.audi.app.car.sdis.base.SDISBase;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Iterator;

public class InterAppSDISDistributor
implements ISDISCarInfoDistributor {
    private LogChannel logChannel;
    private SDISBase sdisBase;

    public InterAppSDISDistributor(LogChannel logChannel, SDISCarManager sDISCarManager) {
        this.logChannel = logChannel;
        this.sdisBase = sDISCarManager.getSDISBase();
    }

    @Override
    public void init(HashMap hashMap) {
        if (hashMap.isEmpty()) {
            this.logChannel.log(1078071040, "init: no stored values.");
            return;
        }
        this.logChannel.log(1078071040, "init: send updates for stored values (%1)", (long)hashMap.size());
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            Object object2 = hashMap.get(object);
            int n = (Integer)object;
            this.sdisBase.getDsiAsiHandler().updateValue(n, object2);
        }
    }

    public void deinit() {
    }

    @Override
    public void sendContent(int n, Object object) {
        this.logChannel.log(1078071040, "sendContent: send content: %1 ", (long)n);
        this.sdisBase.getDsiAsiHandler().updateValue(n, object);
    }

    @Override
    public void serviceAvailable(Object object) {
        if (object instanceof ISDISCarInfoDistributor) {
            this.logChannel.log(1078071040, "serviceAvailable CAR SDIS service found");
        }
    }

    @Override
    public void serviceRemoved() {
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return null;
    }
}

