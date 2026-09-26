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

public class SpellerController$ToggleCharsetButtonItem
extends SpellerController$ButtonItem {
    public static final String TYPE_KEY_TOGGLE_BUTTON;
    private TouchCharSetAndTTSHandler handler = null;

    private SpellerController$ToggleCharsetButtonItem() {
        super(null);
        this.reset();
    }

    public static SpellerController$ToggleCharsetButtonItem createInstance(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        SpellerController$ToggleCharsetButtonItem spellerController$ToggleCharsetButtonItem = (SpellerController$ToggleCharsetButtonItem)SpellerController.access$000().getOrCreateInstance("ToggleCharsetButtonItem");
        spellerController$ToggleCharsetButtonItem.setTouchCharSetAndTTSHandler(touchCharSetAndTTSHandler);
        return spellerController$ToggleCharsetButtonItem;
    }

    @Override
    public String getTypeKey() {
        return "ToggleCharsetButtonItem";
    }

    @Override
    public void reset() {
        super.reset();
        this.handler = null;
    }

    private void setTouchCharSetAndTTSHandler(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        this.handler = touchCharSetAndTTSHandler;
        this.updateToggleButtonType();
    }

    private void updateToggleButtonType() {
        if (null == this.handler) {
            IWidgetLogChannel.spellerLogChannel.log(-1601830656, "[SpellerController#ToggleButtonItem] Could not GET Touch Utils.");
            this.setButtonType(SpellerController$SpellerButtonType.TOGGLE_HWR_TO_SPELLER);
        } else {
            this.setButtonType(this.handler.getAsianToggleSpellerButtonType());
        }
    }

    /* synthetic */ SpellerController$ToggleCharsetButtonItem(SpellerController$1 spellerController$1) {
        this();
    }
}

