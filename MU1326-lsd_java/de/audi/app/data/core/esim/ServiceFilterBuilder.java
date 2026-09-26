/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.esim;

import de.esolutions.fw.util.commons.Buffer;

final class ServiceFilterBuilder {
    private final Buffer filterSpec = new Buffer();

    ServiceFilterBuilder() {
    }

    ServiceFilterBuilder addProperty(String string, String string2) {
        this.filterSpec.append('(');
        this.filterSpec.append(string);
        this.filterSpec.append('=');
        this.filterSpec.append(string2);
        this.filterSpec.append(')');
        return this;
    }

    ServiceFilterBuilder beginAnd() {
        this.filterSpec.append("(&");
        return this;
    }

    ServiceFilterBuilder endAnd() {
        this.filterSpec.append(')');
        return this;
    }

    String createFilterString() {
        return this.filterSpec.toString();
    }
}

