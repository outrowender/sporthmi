/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$IBandStateDependentBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public class SpellerBandState$MultipleTouchResultsBehavior
implements SpellerBandState$IBandStateDependentBehavior {
    private SpellerBandState$MultipleTouchResultsBehavior() {
    }

    @Override
    public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
        if (null == string) {
            return;
        }
        SpellerBandState spellerBandState = SpellerBandState.access$000(string, spellerControllerAsia, SpellerBandState.TOUCH_RESULT_LINE_MULTIPLE_RESULTS);
        if (spellerBandState == SpellerBandState.TOUCH_PREDICTION_LINE && !TouchControllerAsia.isOnlyBackSpace(string)) {
            String string2 = StringUtility.concatenate(this.getPendingTouchResult(spellerControllerAsia), string);
            SpellerBandState.access$100(spellerControllerAsia, string2);
        }
        spellerControllerAsia.changeSpellerState(spellerBandState);
        spellerControllerAsia.getTouchResultLine().setResultItems(string);
    }

    @Override
    public void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerControllerAsia spellerControllerAsia) {
        ITouchResultLine iTouchResultLine = spellerControllerAsia.getTouchResultLine();
        if (iTouchResultLine.isToggleButton(spellerController$ISpellerItem)) {
            spellerControllerAsia.toggleTouchResultLineToSpeller(((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType());
            spellerControllerAsia.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
        } else if (iTouchResultLine.isResultItem(spellerController$ISpellerItem)) {
            String string = ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(true);
            iTouchResultLine.setResultItems("");
            if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_PREDICTION_LINE);
                if (spellerControllerAsia.shouldShowWordPredictionResultsForTouch()) {
                    SpellerBandState.access$100(spellerControllerAsia, string);
                }
            } else {
                spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
            }
            spellerControllerAsia.notifyCharacterPressed(string, false, false);
        } else if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(true) == " ") {
            if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_PREDICTION_LINE);
                if (spellerControllerAsia.shouldShowWordPredictionResultsForTouch()) {
                    String string = StringUtility.concatenate(iTouchResultLine.getFirstResultOrEmptyString(), ' ');
                    SpellerBandState.access$100(spellerControllerAsia, string);
                }
            } else {
                spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
            }
            iTouchResultLine.deleteOldResultItemsIfPresent();
            spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
            spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
        } else {
            boolean bl;
            boolean bl2 = bl = spellerController$ISpellerItem instanceof SpellerController$ButtonItem && ((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType() == SpellerController$SpellerButtonType.CLOSE;
            if (!bl) {
                if (((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType() == SpellerController$SpellerButtonType.DELETE) {
                    spellerControllerAsia.changeSpellerState(SpellerBandState.TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
                }
                iTouchResultLine.deleteOldResultItemsIfPresent();
                spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
            }
            spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
        }
    }

    @Override
    public void closed(SpellerControllerAsia spellerControllerAsia) {
        spellerControllerAsia.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
    }

    @Override
    public boolean hasPendingTouchResult() {
        return true;
    }

    @Override
    public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
        SpellerController$ISpellerItem spellerController$ISpellerItem = spellerControllerAsia.getCurrentCursorTarget();
        if (spellerControllerAsia.getTouchResultLine().isResultItem(spellerController$ISpellerItem)) {
            return ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(true);
        }
        return spellerControllerAsia.getTouchResultLine().getFirstResultOrEmptyString();
    }

    /* synthetic */ SpellerBandState$MultipleTouchResultsBehavior(SpellerBandState$1 spellerBandState$1) {
        this();
    }
}

