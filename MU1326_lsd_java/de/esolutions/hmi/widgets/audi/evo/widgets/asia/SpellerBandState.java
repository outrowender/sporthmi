/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public class SpellerBandState {
    private static final int USES_DEFAULT_BAND = 0;
    private static final int USES_TOUCH_RESULT_LINE = 1;
    private static final int USES_TOUCH_PREDICTION_LINE = 2;
    public static final SpellerBandState DEFAULT_SPELLER = new SpellerBandState("DEFAULT_SPELLER", "DEFAULT", new DefaultSpellerBehavior(), 0);
    public static final SpellerBandState TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT = new SpellerBandState("TOUCH_RESULT_SINGLE_OR_NO_RESULT", "TRL_0/1", new SingleOrNoTouchResultBehavior(), 1);
    public static final SpellerBandState TOUCH_RESULT_LINE_MULTIPLE_RESULTS = new SpellerBandState("TOUCH_RESULT_LINE_MULTIPLE_ALTERNATIVES", "TRL_MULT", new MultipleTouchResultsBehavior(), 1);
    public static final SpellerBandState TOUCH_PREDICTION_LINE = new SpellerBandState("TOUCH_PREDICTION_LINE", "TPL", new TouchPredictionBehavior(), 2);
    private final int bandUsage;
    private final String name;
    private final String abbreviatedName;
    private final IBandStateDependentBehavior behavior;

    private SpellerBandState(String string, String string2, IBandStateDependentBehavior iBandStateDependentBehavior, int n) {
        this.name = string;
        this.abbreviatedName = string2;
        this.behavior = iBandStateDependentBehavior;
        this.bandUsage = n;
    }

    public IBandStateDependentBehavior getBehavior() {
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

    protected static class DefaultSpellerBehavior
    implements IBandStateDependentBehavior {
        private DefaultSpellerBehavior() {
        }

        public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
            if (null == string || TouchControllerAsia.isOnlyBackSpace(string) || string.length() == 0) {
                return;
            }
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "#SpellerStateDefaultSpeller#touchPadFilteredCharactersRecognized: Last valid chars [%1]", (Object)string);
            SpellerBandState spellerBandState = SpellerBandState.updateSpellerBandStateByTouchInput(string, spellerControllerAsia, DEFAULT_SPELLER);
            spellerControllerAsia.changeSpellerState(spellerBandState);
            spellerControllerAsia.getTouchResultLine().setResultItems(string);
            if (spellerBandState == TOUCH_PREDICTION_LINE) {
                SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string);
            }
        }

        public void handlePressItem(SpellerController.ISpellerItem iSpellerItem, SpellerControllerAsia spellerControllerAsia) {
            spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
        }

        public void closed(SpellerControllerAsia spellerControllerAsia) {
        }

        public boolean hasPendingTouchResult() {
            return false;
        }

        public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
            return "";
        }
    }

    protected static class TouchPredictionBehavior
    implements IBandStateDependentBehavior {
        private static final String EMPTY_SPACE = String.valueOf(' ');

        private TouchPredictionBehavior() {
        }

        public void handlePressItem(SpellerController.ISpellerItem iSpellerItem, SpellerControllerAsia spellerControllerAsia) {
            ITouchPredictionLine iTouchPredictionLine = spellerControllerAsia.getTouchPredictionLine();
            if (iTouchPredictionLine.isResultItem(iSpellerItem)) {
                if (((SpellerControllerAsia.TouchPredictionLine)iTouchPredictionLine).isOutdatedData()) {
                    return;
                }
                String string = ((SpellerController.SingleCharItem)iSpellerItem).getChar(true);
                SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string);
                spellerControllerAsia.notifyCharacterPressed(string, false, false);
                ((SpellerControllerAsia.TouchPredictionLine)iTouchPredictionLine).setOutdatedData(true);
            } else if (iTouchPredictionLine.isToggleButton(iSpellerItem)) {
                spellerControllerAsia.toggleTouchResultLineToSpeller(((SpellerController.ButtonItem)iSpellerItem).getButtonType());
                spellerControllerAsia.changeSpellerState(DEFAULT_SPELLER);
            } else if (iSpellerItem instanceof SpellerController.SingleCharItem && ((SpellerController.SingleCharItem)iSpellerItem).getChar(true) == " " || iSpellerItem instanceof SpellerController.ButtonItem && ((SpellerController.ButtonItem)iSpellerItem).getButtonType() == SpellerController.SpellerButtonType.SPACE) {
                spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
                SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, TouchPredictionBehavior.EMPTY_SPACE);
                spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
            } else {
                boolean bl;
                spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
                boolean bl2 = bl = iSpellerItem instanceof SpellerController.ButtonItem && ((SpellerController.ButtonItem)iSpellerItem).getButtonType() == SpellerController.SpellerButtonType.CLOSE;
                if (!bl) {
                    iTouchPredictionLine.deleteOldResultItemsIfPresent();
                    spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
                }
            }
        }

        public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
            if (StringUtilities.isNullOrEmpty(string)) {
                return;
            }
            SpellerBandState spellerBandState = SpellerBandState.updateSpellerBandStateByTouchInput(string, spellerControllerAsia, TOUCH_PREDICTION_LINE);
            if (spellerBandState == TOUCH_PREDICTION_LINE && !TouchControllerAsia.isOnlyBackSpace(string)) {
                SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string);
            } else {
                spellerControllerAsia.changeSpellerState(spellerBandState);
            }
            spellerControllerAsia.getTouchResultLine().setResultItems(string);
        }

        public void closed(SpellerControllerAsia spellerControllerAsia) {
            spellerControllerAsia.changeSpellerState(DEFAULT_SPELLER);
        }

        public boolean hasPendingTouchResult() {
            return false;
        }

        public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
            return "";
        }
    }

    static interface IBandStateDependentBehavior {
        public void handlePressItem(SpellerController.ISpellerItem var1, SpellerControllerAsia var2);

        public void touchPadFilteredCharactersRecognized(String var1, SpellerControllerAsia var2);

        public void closed(SpellerControllerAsia var1);

        public boolean hasPendingTouchResult();

        public String getPendingTouchResult(SpellerControllerAsia var1);
    }

    protected static class MultipleTouchResultsBehavior
    implements IBandStateDependentBehavior {
        private MultipleTouchResultsBehavior() {
        }

        public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
            if (null == string) {
                return;
            }
            SpellerBandState spellerBandState = SpellerBandState.updateSpellerBandStateByTouchInput(string, spellerControllerAsia, TOUCH_RESULT_LINE_MULTIPLE_RESULTS);
            if (spellerBandState == TOUCH_PREDICTION_LINE && !TouchControllerAsia.isOnlyBackSpace(string)) {
                String string2 = StringUtility.concatenate(this.getPendingTouchResult(spellerControllerAsia), string);
                SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string2);
            }
            spellerControllerAsia.changeSpellerState(spellerBandState);
            spellerControllerAsia.getTouchResultLine().setResultItems(string);
        }

        public void handlePressItem(SpellerController.ISpellerItem iSpellerItem, SpellerControllerAsia spellerControllerAsia) {
            ITouchResultLine iTouchResultLine = spellerControllerAsia.getTouchResultLine();
            if (iTouchResultLine.isToggleButton(iSpellerItem)) {
                spellerControllerAsia.toggleTouchResultLineToSpeller(((SpellerController.ButtonItem)iSpellerItem).getButtonType());
                spellerControllerAsia.changeSpellerState(DEFAULT_SPELLER);
            } else if (iTouchResultLine.isResultItem(iSpellerItem)) {
                String string = ((SpellerController.SingleCharItem)iSpellerItem).getChar(true);
                iTouchResultLine.setResultItems("");
                if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                    spellerControllerAsia.changeSpellerState(TOUCH_PREDICTION_LINE);
                    if (spellerControllerAsia.shouldShowWordPredictionResultsForTouch()) {
                        SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string);
                    }
                } else {
                    spellerControllerAsia.changeSpellerState(TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
                }
                spellerControllerAsia.notifyCharacterPressed(string, false, false);
            } else if (iSpellerItem instanceof SpellerController.SingleCharItem && ((SpellerController.SingleCharItem)iSpellerItem).getChar(true) == " ") {
                if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                    spellerControllerAsia.changeSpellerState(TOUCH_PREDICTION_LINE);
                    if (spellerControllerAsia.shouldShowWordPredictionResultsForTouch()) {
                        String string = StringUtility.concatenate(iTouchResultLine.getFirstResultOrEmptyString(), ' ');
                        SpellerBandState.notifyWordPredictionTouchInputOccurredIfShouldShowWordPredictionResults(spellerControllerAsia, string);
                    }
                } else {
                    spellerControllerAsia.changeSpellerState(TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
                }
                iTouchResultLine.deleteOldResultItemsIfPresent();
                spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
                spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
            } else {
                boolean bl;
                boolean bl2 = bl = iSpellerItem instanceof SpellerController.ButtonItem && ((SpellerController.ButtonItem)iSpellerItem).getButtonType() == SpellerController.SpellerButtonType.CLOSE;
                if (!bl) {
                    if (((SpellerController.ButtonItem)iSpellerItem).getButtonType() == SpellerController.SpellerButtonType.DELETE) {
                        spellerControllerAsia.changeSpellerState(TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
                    }
                    iTouchResultLine.deleteOldResultItemsIfPresent();
                    spellerControllerAsia.refreshTouchResultLineIfCurrentlyActive();
                }
                spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
            }
        }

        public void closed(SpellerControllerAsia spellerControllerAsia) {
            spellerControllerAsia.changeSpellerState(DEFAULT_SPELLER);
        }

        public boolean hasPendingTouchResult() {
            return true;
        }

        public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
            SpellerController.ISpellerItem iSpellerItem = spellerControllerAsia.getCurrentCursorTarget();
            if (spellerControllerAsia.getTouchResultLine().isResultItem(iSpellerItem)) {
                return ((SpellerController.SingleCharItem)iSpellerItem).getChar(true);
            }
            return spellerControllerAsia.getTouchResultLine().getFirstResultOrEmptyString();
        }
    }

    protected static class SingleOrNoTouchResultBehavior
    implements IBandStateDependentBehavior {
        private SingleOrNoTouchResultBehavior() {
        }

        public void touchPadFilteredCharactersRecognized(String string, SpellerControllerAsia spellerControllerAsia) {
            if (null == string) {
                return;
            }
            SpellerBandState spellerBandState = SpellerBandState.updateSpellerBandStateByTouchInput(string, spellerControllerAsia, TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
            spellerControllerAsia.changeSpellerState(spellerBandState);
            spellerControllerAsia.getTouchResultLine().setResultItems(string);
        }

        public void handlePressItem(SpellerController.ISpellerItem iSpellerItem, SpellerControllerAsia spellerControllerAsia) {
            if (spellerControllerAsia.getTouchResultLine().isToggleButton(iSpellerItem)) {
                spellerControllerAsia.toggleTouchResultLineToSpeller(((SpellerController.ButtonItem)iSpellerItem).getButtonType());
                spellerControllerAsia.changeSpellerState(DEFAULT_SPELLER);
            } else if (iSpellerItem instanceof SpellerController.SingleCharItem && ((SpellerController.SingleCharItem)iSpellerItem).getChar(true) == " " || iSpellerItem instanceof SpellerController.ButtonItem && ((SpellerController.ButtonItem)iSpellerItem).getButtonType() == SpellerController.SpellerButtonType.SPACE) {
                if (spellerControllerAsia.shouldUseTouchPredictionLine()) {
                    spellerControllerAsia.changeSpellerState(TOUCH_PREDICTION_LINE);
                } else {
                    spellerControllerAsia.changeSpellerState(TOUCH_RESULT_LINE_SINGLE_OR_NO_RESULT);
                }
                spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
            } else {
                spellerControllerAsia.callSuperHandlePressItem(iSpellerItem);
            }
        }

        public void closed(SpellerControllerAsia spellerControllerAsia) {
            spellerControllerAsia.changeSpellerState(DEFAULT_SPELLER);
        }

        public boolean hasPendingTouchResult() {
            return false;
        }

        public String getPendingTouchResult(SpellerControllerAsia spellerControllerAsia) {
            return "";
        }
    }
}

