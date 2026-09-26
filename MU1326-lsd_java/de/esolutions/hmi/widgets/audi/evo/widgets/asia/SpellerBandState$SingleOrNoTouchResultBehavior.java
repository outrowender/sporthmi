/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$IBandStateDependentBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;

public class SpellerBandState$SingleOrNoTouchResultBehavior
implements SpellerBandState$IBandStateDependentBehavior {
    private SpellerBandState$SingleOrNoTouchResultBehavior() {
    }

    @Override
    public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
        if (null == string) {
            return;
        }
        SpellerBandState spellerBandState = SpellerBandState.access$000(string, spellerControllerAsia, SpellerBandState.TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
        spellerControllerAsia.changeSpellerState(spellerBandState);
        spellerControllerAsia.getTouchResultLine().setResultItems(string);
    }

    @Override
    public void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerControllerAsia spellerControllerAsia) {
        if (spellerControllerAsia.getTouchResultLine().isToggleButton(spellerController$ISpellerItem)) {
            spellerControllerAsia.toggleTouchResultLineToSpeller(((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType());
            spellerControllerAsia.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
        } else if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(true) == " " || spellerController$ISpellerItem instanceof SpellerController$ButtonItem && ((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType() == SpellerController$SpellerButtonType.SPACE) {
            if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_PREDICTION_LINE);
            } else {
                spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
            }
            spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
        } else {
            spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
        }
    }

    @Override
    public void closed(SpellerControllerAsia spellerControllerAsia) {
        spellerControllerAsia.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
    }

    @Override
    public boolean hasPendingTouchResult() {
        return false;
    }

    @Override
    public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
        return "";
    }

    /* synthetic */ SpellerBandState$SingleOrNoTouchResultBehavior(SpellerBandState$1 spellerBandState$1) {
        this();
    }
}

