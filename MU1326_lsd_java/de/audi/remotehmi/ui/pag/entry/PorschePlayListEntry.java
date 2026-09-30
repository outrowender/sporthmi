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
        return "PorschePlayListEntry [id=" + this.id + ", title=" + this.title + ", additionalInfo=" + this.additionalInfo + ", isSelected=" + this.isSelected + "]";
    }

    public PorschePlayListEntry(String string, String string2, String string3, boolean bl) {
        this.id = string;
        this.title = string2;
        this.additionalInfo = string3;
        this.isSelected = bl;
    }
}

