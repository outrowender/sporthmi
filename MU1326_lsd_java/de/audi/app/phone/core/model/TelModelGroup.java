/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;

public class TelModelGroup
extends ModelGroup {
    private final String name;
    private final LogChannel log;
    private volatile boolean groupFlushed;

    public TelModelGroup(String string, LogChannel logChannel) {
        this.name = string;
        this.log = logChannel;
        this.groupFlushed = false;
    }

    public void add(HMIModelApp hMIModelApp) {
        this.log.log(100000000, "[TelModelGroup(%1)#add] adding %2", (Object)this.name, (long)hMIModelApp.getID());
        super.add(hMIModelApp);
    }

    public void remove(HMIModelApp hMIModelApp) {
        this.log.log(100000000, "[TelModelGroup(%1)#remove] removing %2", (Object)this.name, (long)hMIModelApp.getID());
        super.remove(hMIModelApp);
    }

    public void removeAll() {
        this.log.log(100000000, "[TelModelGroup(%1)#remove] removeAll", (Object)this.name);
        super.removeAll();
    }

    public void flush() {
        this.log.log(100000000, "[TelModelGroup(%1)#flush] flush", (Object)this.name);
        super.flush();
        this.groupFlushed = true;
    }

    public boolean isGroupFlushed() {
        return this.groupFlushed;
    }
}

