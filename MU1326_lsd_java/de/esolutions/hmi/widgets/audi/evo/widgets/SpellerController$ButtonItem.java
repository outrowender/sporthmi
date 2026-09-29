/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;

public class SpellerController$ButtonItem
implements SpellerController$ISpellerItem {
    public static final String TYPE_KEY;
    private SpellerController$SpellerButtonType buttonType;
    private boolean enabled = true;
    private SpellerButtonArgument additionalArgument = null;

    public void setAdditionalArgument(SpellerButtonArgument spellerButtonArgument) {
        this.additionalArgument = spellerButtonArgument;
    }

    public SpellerButtonArgument getAdditionalArgument() {
        return this.additionalArgument;
    }

    private SpellerController$ButtonItem() {
        this.reset();
    }

    public static SpellerController$ButtonItem createInstance(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        SpellerController$ButtonItem spellerController$ButtonItem = (SpellerController$ButtonItem)SpellerController.access$000().getOrCreateInstance("ButtonItem");
        spellerController$ButtonItem.setButtonType(spellerController$SpellerButtonType);
        return spellerController$ButtonItem;
    }

    @Override
    public String getTypeKey() {
        return "ButtonItem";
    }

    @Override
    public void reset() {
        this.buttonType = SpellerController$SpellerButtonType.NULL;
        this.enabled = true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public String toString() {
        return new StringBuffer().append("ButtonItem type:").append(this.buttonType).toString();
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
        SpellerController$ButtonItem spellerController$ButtonItem = (SpellerController$ButtonItem)spellerController$ISpellerItem;
        return this.buttonType == spellerController$ButtonItem.getButtonType();
    }

    public SpellerController$SpellerButtonType getButtonType() {
        return this.buttonType;
    }

    protected void setButtonType(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        this.buttonType = spellerController$SpellerButtonType;
    }

    /* synthetic */ SpellerController$ButtonItem(SpellerController$1 spellerController$1) {
        this();
    }
}

