/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorscheGenericImage
implements DeepCloneable,
PorscheGenericEntry {
    public String checksum;
    public String url;
    public String id;

    public PorscheGenericImage() {
        this.id = "";
        this.checksum = "";
        this.url = "";
    }

    public PorscheGenericImage(String string, String string2, String string3) {
        this.id = string;
        this.checksum = string2;
        this.url = string3;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(super.getClass().getName());
        buffer.append("[ id: ").append(this.checksum);
        buffer.append("[ url: ").append(this.url);
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
        if (!(object instanceof PorscheGenericImage)) {
            return false;
        }
        PorscheGenericImage porscheGenericImage = (PorscheGenericImage)object;
        return !(this.checksum == null ? porscheGenericImage.checksum != null : !this.checksum.equals(porscheGenericImage.checksum));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.checksum == null ? 0 : this.checksum.hashCode());
        return n;
    }

    @Override
    public Object clone(boolean bl) {
        if (bl) {
            return new PorscheGenericImage(this.id, this.checksum, this.url);
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
        this.id = string;
    }

    @Override
    public String getContextName() {
        return this.id;
    }
}

