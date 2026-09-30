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

    public Object clone(boolean bl) {
        if (bl) {
            return new PorscheBreadcrumbEntry(this.id, this.url, this.text);
        }
        return this;
    }

    public String getFirstImagePath() {
        return this.url;
    }

    public void setFirstImagePath(String string) {
        this.url = string;
    }

    public String getSecondImagePath() {
        return null;
    }

    public void setSecondImagePath(String string) {
    }

    public boolean isSecondImageAvailable() {
        return false;
    }

    public void setContextName(String string) {
        this.context = string;
    }

    public String getContextName() {
        return this.context;
    }
}

