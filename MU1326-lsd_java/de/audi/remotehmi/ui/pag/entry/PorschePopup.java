/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class PorschePopup
implements PorscheGenericEntry {
    public int type = 0;
    public String text;
    public boolean visibility = true;
    public Map buttons = new LinkedHashMap(3);
    public boolean hasCloseButton = false;
    public boolean hasBackButton = false;
    public String imageUrl;
    public String title;
    private String context = "";
    public static final int TYPE_HELP_TEXT_TIMEOUT;
    public static final int TYPE_HELP_TEXT_PERM;
    public static final int TYPE_HELP_TEXT_PROCESS;
    public static final int TYPE_PARTIAL;
    public static final List types;
    public static final int MAX_BUTTONS;

    public PorschePopup() {
    }

    public PorschePopup(String string, int n) {
        this();
        this.type = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PorschePopup");
        buffer.append(" type: ").append(types.get(this.type));
        buffer.append(" text: ").append(this.text);
        buffer.append(" visible: ").append(this.visibility);
        buffer.append(" context: ").append(this.context);
        buffer.append(" imageUrl: ").append(this.imageUrl != null ? this.imageUrl : "<url is null>");
        buffer.append(" buttons: ").append(this.buttons.keySet().size());
        buffer.append(" ]");
        return buffer.toString();
    }

    public int parseType(String string) {
        for (int i2 = 0; i2 < types.size(); ++i2) {
            if (!types.get(i2).equals(string)) continue;
            return i2;
        }
        return 0;
    }

    @Override
    public String getFirstImagePath() {
        return this.imageUrl;
    }

    @Override
    public void setFirstImagePath(String string) {
        this.imageUrl = string;
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

    static {
        types = Collections.unmodifiableList(Arrays.asList(new String[]{"helpText", "helpTextPerm", "helpTextProcess", "partial"}));
    }
}

