/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.ui.pag.entry.PorscheHeadlineButtonEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PorscheOptionEntry
implements DeepCloneable {
    public boolean isSubentriesActive = false;
    public boolean hasSubEntries = false;
    public Map subEntries;
    public List subEntriesList;
    public String title;
    public String secLvlTitle;
    public final String id;
    public String selectedSubentry;
    public boolean checked;
    public boolean enabled;
    public boolean isBlockable;
    public boolean closeOnClick;
    public String imageUrl;
    public int selectionIndex;
    public int type = 0;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_CHECKBOX = 1;
    public static final int TYPE_RADIOBUTTON = 2;
    public static final List types = Collections.unmodifiableList(Arrays.asList(new String[]{"normal", "checkbox", "radiobutton"}));
    public static final int TYPE_IMAGE = 3;
    public static final int TYPE_IMAGE_RADIOBUTTON = 4;
    public static final int TYPE_IMAGE_CHECKBOX = 5;
    public static final int TYPE_SUBELEMENTS = 6;

    public PorscheOptionEntry(String string, String string2, boolean bl) {
        this.title = string2;
        this.id = string;
        this.enabled = bl;
    }

    public PorscheOptionEntry(String string, String string2, boolean bl, String string3, Map map, int n) {
        this(string, string2, bl);
        this.subEntries = map;
        this.secLvlTitle = string3;
        this.type = n;
        if (map != null && map.size() > 0) {
            this.hasSubEntries = true;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.getClass().getName());
        buffer.append("[ id: ").append(this.id);
        buffer.append(" type: ").append(this.type);
        buffer.append(" ").append(this.title);
        buffer.append(" ").append(this.enabled ? "enable" : "disable");
        if (this.hasSubEntries && this.subEntries != null) {
            buffer.append("subEntries[ ");
            Set set = this.subEntries.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                buffer.append(entry);
                if (!iterator.hasNext()) continue;
                buffer.append(", ");
            }
            buffer.append(" ]");
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
            if (this.hasSubEntries) {
                PorscheOptionEntry porscheOptionEntry = new PorscheOptionEntry(this.id, this.title, this.enabled, this.secLvlTitle, this.subEntries, this.type);
                porscheOptionEntry.subEntriesList = this.subEntriesList;
                porscheOptionEntry.hasSubEntries = true;
                porscheOptionEntry.selectionIndex = this.selectionIndex;
                return porscheOptionEntry;
            }
            return new PorscheOptionEntry(this.id, this.title, this.enabled, this.secLvlTitle, this.subEntries, this.type);
        }
        return this;
    }
}

