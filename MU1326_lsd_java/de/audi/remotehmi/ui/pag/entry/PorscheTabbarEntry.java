/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorscheTabbarEntry
implements DeepCloneable,
PorscheGenericEntry {
    static int counter;
    int idC = counter++;
    private final String id;
    private String url = null;
    private String secondUrl = null;
    private String text = null;
    private String context;
    private boolean enabled = true;

    public PorscheTabbarEntry(PorscheTabbarEntry porscheTabbarEntry) {
        this(porscheTabbarEntry.id, porscheTabbarEntry.url, porscheTabbarEntry.secondUrl, porscheTabbarEntry.text);
        this.idC = counter++;
        this.context = porscheTabbarEntry.context;
    }

    public PorscheTabbarEntry(String string) {
        this.id = string;
    }

    public PorscheTabbarEntry(String string, String string2, String string3, String string4) {
        this(string);
        this.url = string2;
        this.secondUrl = string3;
        this.text = string4;
    }

    public String getId() {
        return this.id;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public boolean isTextTabbarEntry() {
        return this.text != null && this.text.length() > 0;
    }

    public boolean setText(String string) {
        if (string != null) {
            this.text = string;
        } else {
            string = "";
        }
        return this.isTextTabbarEntry();
    }

    public String getText() {
        return this.text;
    }

    public void setSecondUrl(String string) {
        this.secondUrl = string;
    }

    public boolean isSecondUrlSet() {
        return this.secondUrl != null && this.secondUrl.length() > 0;
    }

    public String getSecondUrl() {
        return this.secondUrl;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public boolean isUrlSet() {
        return this.url != null && this.url.length() > 0;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PorscheTabbarEntry[").append("<count" + this.idC + ">");
        buffer.append(" id: ").append(this.id);
        buffer.append(" url: ").append(this.url);
        buffer.append(" secondUrl: ").append(this.secondUrl);
        buffer.append(" text: ").append(this.text);
        buffer.append(" enabled: ").append(this.isEnabled());
        buffer.append(" ]");
        return buffer.toString();
    }

    private boolean compareStrings(String string, String string2) {
        boolean bl = true;
        bl = string == null || string2 == null ? string == null && string2 == null : string.equals(string2);
        return bl;
    }

    public boolean equalEntries(PorscheTabbarEntry porscheTabbarEntry) {
        return this.compareStrings(this.getUrl(), porscheTabbarEntry.getUrl()) && this.compareStrings(this.getSecondUrl(), porscheTabbarEntry.getSecondUrl()) && this.compareStrings(this.getText(), porscheTabbarEntry.getText());
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof PorscheTabbarEntry && (bl = this.equalEntries((PorscheTabbarEntry)object)) && ((PorscheTabbarEntry)object).isEnabled() != this.isEnabled()) {
            bl = false;
        }
        return bl;
    }

    public boolean hasSameContext(PorscheTabbarEntry porscheTabbarEntry) {
        if (porscheTabbarEntry == null) {
            return false;
        }
        return !(this.context == null ? porscheTabbarEntry.context != null : !this.context.equals(porscheTabbarEntry.context));
    }

    public Object clone(boolean bl) {
        if (bl) {
            return new PorscheTabbarEntry(this);
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
        return this.secondUrl;
    }

    public void setSecondImagePath(String string) {
        this.secondUrl = string;
    }

    public boolean isSecondImageAvailable() {
        return true;
    }

    public void setContextName(String string) {
        this.context = string;
    }

    public String getContextName() {
        return this.context;
    }
}

