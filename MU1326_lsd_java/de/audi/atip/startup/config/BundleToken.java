/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup.config;

import de.esolutions.fw.util.config.query.IConfigQuery;

public final class BundleToken {
    private String name;
    private boolean developmentOnly;
    private boolean pcSimOnly;

    public BundleToken(IConfigQuery iConfigQuery) {
        this.name = iConfigQuery.getStringValue("name");
        this.developmentOnly = iConfigQuery.getBooleanValue("development_only", false);
        this.pcSimOnly = iConfigQuery.getBooleanValue("pcsim_only", false);
    }

    public String getName() {
        return this.name;
    }

    public boolean isDevelopmentOnly() {
        return this.developmentOnly;
    }

    public boolean isPcSimOnly() {
        return this.pcSimOnly;
    }
}

