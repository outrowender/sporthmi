/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.osgi;

import de.esolutions.fw.util.commons.Buffer;

public final class ServiceFilterBuilder {
    private final Buffer filterSpec = new Buffer();

    public static String createFilterString(String string, String string2) {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.addProperty(string, string2);
        return serviceFilterBuilder.createFilterString();
    }

    public ServiceFilterBuilder addProperty(String string, String string2) {
        this.filterSpec.append('(');
        this.filterSpec.append(string);
        this.filterSpec.append('=');
        this.filterSpec.append(string2);
        this.filterSpec.append(')');
        return this;
    }

    public ServiceFilterBuilder beginOr() {
        this.filterSpec.append("(|");
        return this;
    }

    public ServiceFilterBuilder endOr() {
        this.filterSpec.append(')');
        return this;
    }

    public ServiceFilterBuilder beginAnd() {
        this.filterSpec.append("(&");
        return this;
    }

    public ServiceFilterBuilder endAnd() {
        this.filterSpec.append(')');
        return this;
    }

    public String createFilterString() {
        return this.filterSpec.toString();
    }
}

