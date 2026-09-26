/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import java.util.Collections;
import java.util.List;

public class SpellerController$AbstractExpandableItem$CharSet
extends SpellerController$AbstractExpandableItem {
    public static final String TYPE_KEY;
    private int charSetType;

    private SpellerController$AbstractExpandableItem$CharSet() {
        super(Collections.EMPTY_LIST, 1, null);
        this.reset();
    }

    public static SpellerController$AbstractExpandableItem$CharSet createInstance(List list, int n) {
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = (SpellerController$AbstractExpandableItem$CharSet)SpellerController.access$000().getOrCreateInstance("ExpandableItem.CharSet");
        spellerController$AbstractExpandableItem$CharSet.setSubBand(list);
        spellerController$AbstractExpandableItem$CharSet.setCharsetType(n);
        return spellerController$AbstractExpandableItem$CharSet;
    }

    @Override
    public String getTypeKey() {
        return "ExpandableItem.CharSet";
    }

    @Override
    public void reset() {
        super.reset();
        this.charSetType = 4;
    }

    public int getCharsetType() {
        return this.charSetType;
    }

    private void setCharsetType(int n) {
        this.charSetType = n;
    }

    public String toString() {
        return new Buffer("ExpandableItem.CharSet main: ").append(SpellerController$AbstractExpandableItem.access$200()[this.getCharsetType()]).append("[closed=").append(this.isClosed()).append("]").toString();
    }

    @Override
    public boolean itemContentEquals(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        return super.itemContentEquals(spellerController$ISpellerItem) && this.getCharsetType() == ((SpellerController$AbstractExpandableItem$CharSet)spellerController$ISpellerItem).getCharsetType();
    }

    /* synthetic */ SpellerController$AbstractExpandableItem$CharSet(SpellerController$1 spellerController$1) {
        this();
    }
}

