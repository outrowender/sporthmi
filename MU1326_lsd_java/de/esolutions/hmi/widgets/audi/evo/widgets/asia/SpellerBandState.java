/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$DefaultSpellerBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$IBandStateDependentBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$MultipleTouchResultsBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$SingleOrNoTouchResultBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState$TouchPredictionBehavior;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;

public class SpellerBandState {
    private static final int USES_DEFAULT_BAND;
    private static final int USES_TOUCH_RESULT_LINE;
    private static final int USES_TOUCH_PREDICTION_LINE;
    public static final SpellerBandState DEFAULT_SPELLER;
    public static final SpellerBandState TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT;
    public static final SpellerBandState TOUCH_RESULT_LINE_MULTIPLE_RESULTS;
    public static final SpellerBandState TOUCH_PREDICTION_LINE;
    private final int bandUsage;
    private final String name;
    private final String abbreviatedName;
    private final SpellerBandState$IBandStateDependentBehavior behavior;

    private SpellerBandState(String string, String string2, SpellerBandState$IBandStateDependentBehavior iBandStateDependentBehavior, int n) {
        this.name = string;
        this.abbreviatedName = string2;
        this.behavior = iBandStateDependentBehavior;
        this.bandUsage = n;
    }

    public SpellerBandState$IBandStateDependentBehavior getBehavior() {
        return this.behavior;
    }

    public String getAbbreviationName() {
        return this.abbreviatedName;
    }

    public String toString() {
        return this.name;
    }

    private static boolean hasOneResults(String string) {
        return string.length() == 1;
    }

    private static boolean hasZeroResults(String string) {
        return string.length() < 1;
    }

    public boolean isUsingSameSpellerBandAs(SpellerBandState spellerBandState) {
        return this.bandUsage == spellerBandState.bandUsage;
    }

    public boolean isUsingDefaultSpellerBand() {
        return this.bandUsage == 0;
    }

    public boolean isUsingTouchResultLine() {
        return this.bandUsage == 1;
    }

    public boolean isUsingTouchPredictionLine() {
        return this.bandUsage == 2;
    }

    private static SpellerBandState updateSpellerBandStateByTouchInput(String string, SpellerControllerAsia spellerControllerAsia, SpellerBandState spellerBandState) {
        if (SpellerBandState.hasOneResults(string)) {
            if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                return TOUCH_PREDICTION_LINE;
            }
            return TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT;
        }
        if (SpellerBandState.hasZeroResults(string)) {
            if (spellerBandState == TOUCH_PREDICTION_LINE) {
                return TOUCH_PREDICTION_LINE;
            }
            return TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT;
        }
        return TOUCH_RESULT_LINE_MULTIPLE_RESULTS;
    }

    private static void notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(SpellerControllerAsia spellerControllerAsia, String string) {
        if (spellerControllerAsia.shouldShowWordPredictionResultsForTouch()) {
            spellerControllerAsia.notifyWordPredictionTouchInputOccurred(string);
        }
    }

    static /* synthetic */ SpellerBandState access$000(String string, SpellerControllerAsia spellerControllerAsia, SpellerBandState spellerBandState) {
        return SpellerBandState.updateSpellerBandStateByTouchInput(string, spellerControllerAsia, spellerBandState);
    }

    static /* synthetic */ void access$100(SpellerControllerAsia spellerControllerAsia, String string) {
        SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string);
    }

    static {
        DEFAULT_SPELLER = new SpellerBandState("DEFAULT_SPELLER", "DEFAULT", new SpellerBandState$DefaultSpellerBehavior(null), 0);
        TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT = new SpellerBandState("TOUCH_RESULT_SINGLE_OR_NO_RESULT", "TRL_0/1", new SpellerBandState$SingleOrNoTouchResultBehavior(null), 1);
        TOUCH_RESULT_LINE_MULTIPLE_RESULTS = new SpellerBandState("TOUCH_RESULT_LINE_MULTIPLE_ALTERNATIVES", "TRL_MULT", new SpellerBandState$MultipleTouchResultsBehavior(null), 1);
        TOUCH_PREDICTION_LINE = new SpellerBandState("TOUCH_PREDICTION_LINE", "TPL", new SpellerBandState$TouchPredictionBehavior(null), 2);
    }
}

