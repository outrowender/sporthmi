/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorscheControllerEntry
implements DeepCloneable,
PorscheGenericEntry {
    public static final int MAX_CONTROLLER_LENGTH = 8;
    public static final int LABELICON_BUTTON_INDEX = 8;
    public static final int ALIGNMENT_RIGHT = 1;
    public static final int ALIGNMENT_LEFT = 0;
    public static final int ALIGNMENT_UNDEFINED = -1;
    public int alignment = -1;
    public static final int TYPE_UNDEFINED = -1;
    public static final int TYPE_GLOW = 0;
    public static final int TYPE_LABELIMAGE = 1;
    public static final int TYPE_TOGGLE = 2;
    public static final int TYPE_ICONTEXT = 3;
    public int type = -1;
    public final String id;
    public String url;
    public String secondUrl;
    public String label;
    private String context;
    public boolean secondUrlExists;
    public boolean urlExists;
    public String iconText;

    public PorscheControllerEntry() {
        this.id = "undefined";
    }

    public PorscheControllerEntry(PorscheControllerEntry porscheControllerEntry) {
        this.id = porscheControllerEntry.id;
        this.label = porscheControllerEntry.label;
        this.type = porscheControllerEntry.type;
        this.url = porscheControllerEntry.url;
        this.urlExists = porscheControllerEntry.urlExists;
        this.secondUrl = porscheControllerEntry.secondUrl;
        this.secondUrlExists = porscheControllerEntry.secondUrlExists;
    }

    public PorscheControllerEntry(String string, String string2, String string3) {
        this.id = string;
        this.url = string2;
        this.secondUrl = string3;
    }

    boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public boolean isButtonAligned() {
        return this.alignment != -1;
    }

    public boolean isTextControllerEntry() {
        return this.iconText != null && this.iconText.length() != 0;
    }

    public String getIconText() {
        if (this.isTextControllerEntry()) {
            return this.iconText;
        }
        return "";
    }

    public void setIconText(String string) {
        this.iconText = string;
    }

    public Object clone(boolean bl) {
        if (bl) {
            return new PorscheControllerEntry(this);
        }
        return this;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PorscheControllerEntry[");
        buffer.append(" id: ").append(this.id);
        buffer.append(" url<").append(this.urlExists ? "available" : "not available").append(">: ").append(this.url);
        buffer.append(" secondurl<").append(this.secondUrlExists ? "available" : "not available").append(">: ").append(this.secondUrl);
        if (this.type == 1) {
            buffer.append(" label: ").append(this.label);
        }
        buffer.append(" iconText: ").append(this.getIconText());
        buffer.append(" ]");
        return buffer.toString();
    }

    public boolean equalUrls(PorscheControllerEntry porscheControllerEntry) {
        return this.compareStrings(this.getFirstImagePath(), porscheControllerEntry.getFirstImagePath()) && this.compareStrings(this.getSecondImagePath(), porscheControllerEntry.getSecondImagePath()) && this.compareStrings(this.getIconText(), porscheControllerEntry.getIconText()) && this.urlExists == porscheControllerEntry.urlExists && this.secondUrlExists == porscheControllerEntry.secondUrlExists;
    }

    private boolean compareStrings(String string, String string2) {
        boolean bl = true;
        bl = string == null || string2 == null ? string == null && string2 == null : string.equals(string2);
        return bl;
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

