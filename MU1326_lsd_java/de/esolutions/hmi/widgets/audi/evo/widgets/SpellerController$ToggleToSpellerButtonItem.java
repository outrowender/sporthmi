/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;

public class SpellerController$ToggleToSpellerButtonItem
extends SpellerController$ButtonItem {
    public static final String TYPE_KEY_TOGGLE_BUTTON;
    private TouchCharSetAndTTSHandler handler = null;

    private SpellerController$ToggleToSpellerButtonItem() {
        super(null);
        this.reset();
    }

    public static SpellerController$ToggleToSpellerButtonItem createInstance(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        SpellerController$ToggleToSpellerButtonItem spellerController$ToggleToSpellerButtonItem = (SpellerController$ToggleToSpellerButtonItem)SpellerController.access$000().getOrCreateInstance("ToggleToSpellerButtonItem");
        spellerController$ToggleToSpellerButtonItem.setTouchCharSetAndTTSHandler(touchCharSetAndTTSHandler);
        return spellerController$ToggleToSpellerButtonItem;
    }

    @Override
    public String getTypeKey() {
        return "ToggleToSpellerButtonItem";
    }

    @Override
    public void reset() {
        super.reset();
        this.handler = null;
    }

    public void setTouchCharSetAndTTSHandler(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        this.handler = touchCharSetAndTTSHandler;
        this.updateToggleButtonType();
    }

    private void updateToggleButtonType() {
        if (null == this.handler) {
            IWidgetLogChannel.spellerLogChannel.log(-1601830656, "[SpellerController#ToggleButtonItem] Could not GET Touch Utils.");
            this.setButtonType(SpellerController$SpellerButtonType.TOGGLE_HWR_TO_SPELLER);
        } else {
            this.setButtonType(this.handler.getAsianToggleToSpellerButtonType());
        }
    }

    /* synthetic */ SpellerController$ToggleToSpellerButtonItem(SpellerController$1 spellerController$1) {
        this();
    }
}

