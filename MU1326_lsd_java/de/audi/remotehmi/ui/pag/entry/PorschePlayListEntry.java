/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

public class PorschePlayListEntry {
    public String id;
    public String title;
    public String additionalInfo;
    public boolean isSelected;

    public String toString() {
        return new StringBuffer().append("PorschePlayListEntry [id=").append(this.id).append(", title=").append(this.title).append(", additionalInfo=").append(this.additionalInfo).append(", isSelected=").append(this.isSelected).append("]").toString();
    }

    public PorschePlayListEntry(String string, String string2, String string3, boolean bl) {
        this.id = string;
        this.title = string2;
        this.additionalInfo = string3;
        this.isSelected = bl;
    }
}

