/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup.config;

import de.esolutions.fw.util.config.query.IConfigQuery;

public final class Domain {
    private final int id;
    private final int requiredState;
    private final int minimumState;

    public Domain(IConfigQuery iConfigQuery) {
        this.id = iConfigQuery.getIntegerValue("id", 0);
        this.requiredState = Long.decode(iConfigQuery.getStringValue("required_state", "0x00")).intValue();
        this.minimumState = Long.decode(iConfigQuery.getStringValue("minimum_state", "0x00")).intValue();
    }

    public int getId() {
        return this.id;
    }

    public int getRequiredState() {
        return this.requiredState;
    }

    public int getMinimumState() {
        if (this.minimumState == 0) {
            return this.requiredState;
        }
        return this.minimumState;
    }
}

