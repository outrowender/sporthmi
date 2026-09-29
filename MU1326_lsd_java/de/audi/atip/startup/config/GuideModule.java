/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup.config;

import de.esolutions.fw.util.config.query.IConfigQuery;

public final class GuideModule {
    private final int id;
    private final String smBundle;
    private final String hmiBundle;

    public GuideModule(IConfigQuery iConfigQuery) {
        this.id = iConfigQuery.getIntegerValue("id", 0);
        this.smBundle = iConfigQuery.getStringValue("sm_bundle", null);
        this.hmiBundle = iConfigQuery.getStringValue("hmi_bundle", null);
    }

    public int getModuleId() {
        return this.id;
    }

    public String getSMMBundle() {
        return this.smBundle;
    }

    public String getHMIBundle() {
        return this.hmiBundle;
    }
}

