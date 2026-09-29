/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorscheBreadcrumbEntry
implements DeepCloneable,
PorscheGenericEntry {
    public final String id;
    public String url;
    public String text;
    private String context;
    public boolean urlExists;

    public PorscheBreadcrumbEntry() {
        this.id = "";
        this.url = "";
        this.text = "";
    }

    public PorscheBreadcrumbEntry(String string, String string2, String string3) {
        this.id = string;
        this.url = string2;
        this.text = string3;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PorscheBreadcrumbEntry[");
        buffer.append(" id: ").append(this.id);
        buffer.append(" url: ").append(this.url);
        buffer.append(" text: ").append(this.text);
        buffer.append(" ]");
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PorscheBreadcrumbEntry)) {
            return false;
        }
        PorscheBreadcrumbEntry porscheBreadcrumbEntry = (PorscheBreadcrumbEntry)object;
        return !(this.id == null ? porscheBreadcrumbEntry.id != null : !this.id.equals(porscheBreadcrumbEntry.id));
    }

    public int hashCode() {
        return this.id == null ? 0 : this.id.hashCode();
    }

    @Override
    public Object clone(boolean bl) {
        if (bl) {
            return new PorscheBreadcrumbEntry(this.id, this.url, this.text);
        }
        return this;
    }

    @Override
    public String getFirstImagePath() {
        return this.url;
    }

    @Override
    public void setFirstImagePath(String string) {
        this.url = string;
    }

    @Override
    public String getSecondImagePath() {
        return null;
    }

    @Override
    public void setSecondImagePath(String string) {
    }

    @Override
    public boolean isSecondImageAvailable() {
        return false;
    }

    @Override
    public void setContextName(String string) {
        this.context = string;
    }

    @Override
    public String getContextName() {
        return this.context;
    }
}

