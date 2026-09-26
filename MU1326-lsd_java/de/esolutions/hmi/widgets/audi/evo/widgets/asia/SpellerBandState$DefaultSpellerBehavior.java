/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$IBandStateDependentBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public class SpellerBandState$DefaultSpellerBehavior
implements SpellerBandState$IBandStateDependentBehavior {
    private SpellerBandState$DefaultSpellerBehavior() {
    }

    @Override
    public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
        if (null == string || TouchControllerAsia.isOnlyBackSpace(string) || string.length() == 0) {
            return;
        }
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "#SpellerStateDefaultSpeller#touchPadFilteredCharactersRecognized: Last valid chars [%1]", (Object)string);
        SpellerBandState spellerBandState = SpellerBandState.access$000(string, spellerControllerAsia, SpellerBandState.DEFAULT_SPELLER);
        spellerControllerAsia.changeSpellerState(spellerBandState);
        spellerControllerAsia.getTouchResultLine().setResultItems(string);
        if (spellerBandState == SpellerBandState.TOUCH_PREDICTION_LINE) {
            SpellerBandState.access$100(spellerControllerAsia, string);
        }
    }

    @Override
    public void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerControllerAsia spellerControllerAsia) {
        spellerControllerAsia.callSuperHandlePressItem(spellerController$ISpellerItem);
    }

    @Override
    public void closed(SpellerControllerAsia spellerControllerAsia) {
    }

    @Override
    public boolean hasPendingTouchResult() {
        return false;
    }

    @Override
    public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
        return "";
    }

    /* synthetic */ SpellerBandState$DefaultSpellerBehavior(SpellerBandState$1 spellerBandState$1) {
        this();
    }
}

