/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.GeneralConst;
import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorscheHeadlineButtonEntry
implements DeepCloneable,
PorscheGenericEntry {
    public final String id;
    private String context;
    public final String type;
    public String text;
    public String url;
    public boolean urlExists;

    public PorscheHeadlineButtonEntry() {
        this.id = "";
        this.url = "";
        this.type = "headlineButton";
    }

    public PorscheHeadlineButtonEntry(String string, String string2, String string3) {
        this.id = string;
        this.url = string2;
        this.type = GeneralConst.HEADLINE_ELEMENTS.contains(string3.toLowerCase()) ? string3 : "headlineButton";
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.getClass().getName());
        buffer.append("[ id: ").append(this.id);
        if (this.type.equalsIgnoreCase("headlineButton")) {
            buffer.append(" url: ").append(this.url);
        } else if (this.type.equalsIgnoreCase("headlinePlay")) {
            buffer.append(" text: ").append(this.text);
        }
        buffer.append(" ]");
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof PorscheHeadlineButtonEntry)) {
            return false;
        }
        PorscheHeadlineButtonEntry porscheHeadlineButtonEntry = (PorscheHeadlineButtonEntry)object;
        return !(this.id == null ? porscheHeadlineButtonEntry.id != null : !this.id.equals(porscheHeadlineButtonEntry.id));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.id == null ? 0 : this.id.hashCode());
        return n;
    }

    public Object clone(boolean bl) {
        if (bl) {
            return new PorscheHeadlineButtonEntry(this.id, this.url, this.type);
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

