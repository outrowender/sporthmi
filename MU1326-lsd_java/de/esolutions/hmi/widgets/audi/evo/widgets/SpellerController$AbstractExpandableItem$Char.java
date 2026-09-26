/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import java.util.Collections;
import java.util.List;

public class SpellerController$AbstractExpandableItem$Char
extends SpellerController$AbstractExpandableItem
implements SpellerController$ICharacterSpellerItem {
    public static final String TYPE_KEY;
    private String characterUC;
    private String characterLC;

    private SpellerController$AbstractExpandableItem$Char() {
        super(Collections.EMPTY_LIST, 0, null);
        this.reset();
    }

    public static SpellerController$AbstractExpandableItem$Char createInstance(List list, String string, String string2) {
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = (SpellerController$AbstractExpandableItem$Char)SpellerController.access$000().getOrCreateInstance("ExpandableItem.Char");
        spellerController$AbstractExpandableItem$Char.setSubBand(list);
        spellerController$AbstractExpandableItem$Char.setChar(string, string2);
        return spellerController$AbstractExpandableItem$Char;
    }

    public static SpellerController$AbstractExpandableItem$Char createInstance(List list, String string) {
        return SpellerController$AbstractExpandableItem$Char.createInstance(list, string, string);
    }

    public static SpellerController$AbstractExpandableItem$Char createInstance(String string, List list) {
        return SpellerController$AbstractExpandableItem$Char.createInstance(list, string, string);
    }

    @Override
    public String getTypeKey() {
        return "ExpandableItem.Char";
    }

    @Override
    public void reset() {
        super.reset();
        this.setChar(null, null);
    }

    @Override
    public String getChar(boolean bl) {
        if (bl || this.characterLC == null) {
            return this.characterUC;
        }
        return this.characterLC;
    }

    private void setChar(String string, String string2) {
        this.characterUC = string;
        this.characterLC = string2;
    }

    public String toString() {
        return new Buffer("ExpandableItem.Char main: ").append(this.characterUC).append("[closed=").append(this.isClosed()).append("]").toString();
    }

    @Override
    public boolean itemContentEquals(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (!super.itemContentEquals(spellerController$ISpellerItem)) {
            return false;
        }
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = (SpellerController$AbstractExpandableItem$Char)spellerController$ISpellerItem;
        if (spellerController$AbstractExpandableItem$Char.characterLC != null && this.characterLC == null) {
            return false;
        }
        if (this.characterLC != null && !this.characterLC.equals(spellerController$AbstractExpandableItem$Char.characterLC)) {
            return false;
        }
        return !(this.characterUC == null ? spellerController$AbstractExpandableItem$Char.characterUC != null : !this.characterUC.equals(spellerController$AbstractExpandableItem$Char.characterUC));
    }

    /* synthetic */ SpellerController$AbstractExpandableItem$Char(SpellerController$1 spellerController$1) {
        this();
    }
}

