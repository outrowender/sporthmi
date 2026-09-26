/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Commands$StateGridResourceAvailablePayload
extends Commands$AbstractContextPayload {
    private final List localLocations;
    private final long delayMillis;
    private HMIProperties properties;

    public Commands$StateGridResourceAvailablePayload(String string, String string2, HMIProperties hMIProperties, long l) {
        super(string);
        this.delayMillis = l;
        this.localLocations = new ArrayList();
        this.localLocations.add(string2);
        this.properties = hMIProperties;
    }

    public List getLocalLocations() {
        return this.localLocations;
    }

    public HMIProperties getProperties() {
        return this.properties;
    }

    public void add(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (this.localLocations.contains(string)) continue;
            this.localLocations.add(string);
        }
    }

    public long getDelayMillis() {
        return this.delayMillis;
    }

    public void setProperties(HMIProperties hMIProperties) {
        this.properties = hMIProperties;
    }
}

