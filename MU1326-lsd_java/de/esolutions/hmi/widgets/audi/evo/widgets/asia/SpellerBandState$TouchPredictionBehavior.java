/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$IBandStateDependentBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$TouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public class SpellerBandState$TouchPredictionBehavior
implements SpellerBandState$IBandStateDependentBehavior {
    private static final String EMPTY_SPACE = String.valueOf(' ');

    private SpellerBandState$TouchPredictionBehavior() {
    }

    @Override
    public void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerControllerAsia spellerControllerAsia) {
        ITouchPredictionLine iTouchPredictionLine = spellerControllerAsia.getTouchPredictionLine();
        if (iTouchPredictionLine.isResultItem(spellerController$ISpellerItem)) {
            if (((SpellerControllerAsia$TouchPredictionLine)iTouchPredictionLine).isOutdatedData()) {
                return;
            }
            String string = ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(true);
            SpellerBandState.access$100(spellerControllerAsia, string);
            spellerControllerAsia.notifyCharacterPressed(string, false, false);
            ((SpellerControllerAsia$TouchPredictionLine)iTouchPredictionLine).setOutdatedData(true);
        } else if (iTouchPredictionLine.isToggleButton(spellerController$ISpellerItem)) {
            spellerControllerAsia.toggleTouchResultLineToSpeller(((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType());
            spellerControllerAsia.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
        } else if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(true) == " " || spellerController$ISpellerItem instanceof SpellerController$ButtonItem && ((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType() == SpellerController$SpellerButtonType.SPACE) {
            spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
            SpellerBandState.access$100(spellerControllerAsia, EMPTY_SPACE);
            spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
        } else {
            boolean bl;
            spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
            boolean bl2 = bl = spellerController$ISpellerItem instanceof SpellerController$ButtonItem && ((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType() == SpellerController$SpellerButtonType.CLOSE;
            if (!bl) {
                iTouchPredictionLine.deleteOldResultItemsIfPresent();
                spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
            }
        }
    }

    @Override
    public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return;
        }
        SpellerBandState spellerBandState = SpellerBandState.access$000(string, spellerControllerAsia, SpellerBandState.TOUCH_PREDICTION_LINE);
        if (spellerBandState == SpellerBandState.TOUCH_PREDICTION_LINE && !TouchControllerAsia.isOnlyBackSpace(string)) {
            SpellerBandState.access$100(spellerControllerAsia, string);
        } else {
            spellerControllerAsia.changeSpellerState(spellerBandState);
        }
        spellerControllerAsia.getTouchResultLine().setResultItems(string);
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

    /* synthetic */ SpellerBandState$TouchPredictionBehavior(SpellerBandState$1 spellerBandState$1) {
        this();
    }
}

