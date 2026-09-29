/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;

public class SpellerController$SingleCharItem
implements SpellerController$ICharacterSpellerItem {
    public static final String TYPE_KEY;
    private String charactersUC;
    private String charactersLC;
    private boolean enabled = true;
    private SpellerController$AbstractExpandableItem parent;

    private SpellerController$SingleCharItem() {
    }

    public static SpellerController$SingleCharItem createInstance(String string) {
        return SpellerController$SingleCharItem.createInstance(null, string, null);
    }

    public static SpellerController$SingleCharItem createInstance(String string, String string2) {
        return SpellerController$SingleCharItem.createInstance(null, string, string2);
    }

    public static SpellerController$SingleCharItem createInstance(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem, String string, String string2) {
        SpellerController$SingleCharItem spellerController$SingleCharItem = (SpellerController$SingleCharItem)SpellerController.access$000().getOrCreateInstance("SingleCharItem");
        spellerController$SingleCharItem.setChar(string, string2);
        spellerController$SingleCharItem.parent = spellerController$AbstractExpandableItem;
        return spellerController$SingleCharItem;
    }

    @Override
    public String getTypeKey() {
        return "SingleCharItem";
    }

    @Override
    public void reset() {
        this.charactersUC = null;
        this.charactersLC = null;
        this.enabled = true;
        this.parent = null;
    }

    public void setChar(String string, String string2) {
        this.charactersUC = string;
        this.charactersLC = string2;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    @Override
    public String getChar(boolean bl) {
        if (bl || this.charactersLC == null) {
            return this.charactersUC;
        }
        return this.charactersLC;
    }

    @Override
    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public SpellerController$AbstractExpandableItem getParent() {
        return this.parent;
    }

    public String toString() {
        return new StringBuffer().append("Character: ").append(this.charactersUC).toString();
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
        SpellerController$SingleCharItem spellerController$SingleCharItem = (SpellerController$SingleCharItem)spellerController$ISpellerItem;
        if (this.charactersLC == null ? spellerController$SingleCharItem.charactersLC != null : !this.charactersLC.equals(spellerController$SingleCharItem.charactersLC)) {
            return false;
        }
        return !(this.charactersUC == null ? spellerController$SingleCharItem.charactersUC != null : !this.charactersUC.equals(spellerController$SingleCharItem.charactersUC));
    }

    static /* synthetic */ SpellerController$AbstractExpandableItem access$302(SpellerController$SingleCharItem spellerController$SingleCharItem, SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        spellerController$SingleCharItem.parent = spellerController$AbstractExpandableItem;
        return spellerController$SingleCharItem.parent;
    }

    static /* synthetic */ SpellerController$AbstractExpandableItem access$300(SpellerController$SingleCharItem spellerController$SingleCharItem) {
        return spellerController$SingleCharItem.parent;
    }

    /* synthetic */ SpellerController$SingleCharItem(SpellerController$1 spellerController$1) {
        this();
    }

    static /* synthetic */ String access$1200(SpellerController$SingleCharItem spellerController$SingleCharItem) {
        return spellerController$SingleCharItem.charactersUC;
    }
}

