/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import java.io.Serializable;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVPresetStation
implements Serializable {
    private static final long serialVersionUID = 536111538927937038L;
    public long namePID;
    public int servicePID;
    public String name;
    public int sType;

    TVPresetStation(ServiceInfo serviceInfo) {
        this.namePID = serviceInfo.namePID;
        this.servicePID = serviceInfo.servicePID;
        this.name = serviceInfo.name;
        this.sType = serviceInfo.sType;
    }

    public TVPresetStation() {
    }
}

