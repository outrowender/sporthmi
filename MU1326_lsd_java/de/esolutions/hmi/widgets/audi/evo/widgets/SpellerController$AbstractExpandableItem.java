/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import java.util.Collections;
import java.util.List;

public abstract class SpellerController$AbstractExpandableItem
implements SpellerController$ISpellerItem {
    public static final int TYPE_CHAR;
    public static final int TYPE_CHARSET;
    private static final String[] CHARSET_NAMES;
    public static final int CHARSET_SYMBOLS;
    public static final int CHARSET_DIGITS;
    public static final int CHARSET_UMLAUTS;
    public static final int CHARSET_LATIN_A_Z;
    public static final int CHARSET_NONE;
    public final int type;
    private List subBand;
    private boolean closed;
    private boolean enabled;

    private SpellerController$AbstractExpandableItem(List list, int n) {
        this.setSubBand(list);
        this.type = n;
        this.closed = true;
        this.enabled = true;
    }

    protected void setSubBand(List list) {
        this.subBand = list;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                Object object = list.get(i2);
                if (!(object instanceof SpellerController$SingleCharItem)) continue;
                SpellerController$SingleCharItem.access$302((SpellerController$SingleCharItem)object, this);
            }
        }
    }

    public List getSubBand() {
        return this.subBand;
    }

    @Override
    public void reset() {
        this.closed = true;
        this.enabled = true;
        this.subBand = Collections.EMPTY_LIST;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void setClosed(boolean bl) {
        this.closed = bl;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    @Override
    public boolean itemContentEquals(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (this == spellerController$ISpellerItem) {
            return true;
        }
        if (spellerController$ISpellerItem == null) {
            return false;
        }
        if (super.getClass() != super.getClass()) {
            return false;
        }
        SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem = (SpellerController$AbstractExpandableItem)spellerController$ISpellerItem;
        return this.itemListContentEqualsOthersList(spellerController$AbstractExpandableItem);
    }

    protected boolean itemListContentEqualsOthersList(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        if (this.subBand == null) {
            return spellerController$AbstractExpandableItem.subBand == null;
        }
        if (this.subBand.size() != spellerController$AbstractExpandableItem.subBand.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.subBand.size(); ++i2) {
            SpellerController$ISpellerItem spellerController$ISpellerItem;
            SpellerController$ISpellerItem spellerController$ISpellerItem2 = (SpellerController$ISpellerItem)this.subBand.get(i2);
            if (spellerController$ISpellerItem2.itemContentEquals(spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerController$AbstractExpandableItem.subBand.get(i2))) continue;
            return false;
        }
        return true;
    }

    /* synthetic */ SpellerController$AbstractExpandableItem(List list, int n, SpellerController$1 spellerController$1) {
        this(list, n);
    }

    static /* synthetic */ String[] access$200() {
        return CHARSET_NAMES;
    }

    static /* synthetic */ boolean access$1300(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        return spellerController$AbstractExpandableItem.closed;
    }

    static /* synthetic */ boolean access$1302(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem, boolean bl) {
        spellerController$AbstractExpandableItem.closed = bl;
        return spellerController$AbstractExpandableItem.closed;
    }

    static /* synthetic */ List access$1400(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        return spellerController$AbstractExpandableItem.subBand;
    }

    static {
        CHARSET_NAMES = new String[]{"SYMBOLS", "DIGITS", "UMLAUTS", "LATIN_A_Z", "NONE"};
    }
}

