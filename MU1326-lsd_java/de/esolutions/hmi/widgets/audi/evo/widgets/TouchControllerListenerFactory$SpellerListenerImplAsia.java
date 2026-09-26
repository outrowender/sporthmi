/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$SpellerListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ISpellerListenerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;

final class TouchControllerListenerFactory$SpellerListenerImplAsia
implements ISpellerListenerAsia {
    private TouchControllerListenerFactory$SpellerListenerImpl delegate = null;
    private TouchControllerAsia touchController = null;

    private TouchControllerListenerFactory$SpellerListenerImplAsia(TouchControllerAsia touchControllerAsia, TouchControllerListenerFactory$SpellerListenerImpl touchControllerListenerFactory$SpellerListenerImpl) {
        this.touchController = touchControllerAsia;
        this.delegate = touchControllerListenerFactory$SpellerListenerImpl;
    }

    @Override
    public void buttonPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType, SpellerButtonArgument spellerButtonArgument) {
        this.delegate.buttonPressed(spellerController$SpellerButtonType, spellerButtonArgument);
        if (spellerController$SpellerButtonType.isCharsetToggleButton()) {
            this.touchController.switchToSpeller(spellerController$SpellerButtonType.getTargetToggleCharset());
            this.touchController.forceFocusOnItem(spellerController$SpellerButtonType);
        }
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.JP_TONE_LOWER_CASE_TOGGLE) {
            this.touchController.toggleCharStatusForJapan();
        }
    }

    @Override
    public void characterPressed(String string, boolean bl, boolean bl2) {
        String string2 = string;
        boolean bl3 = this.touchController.isMatchspellerModel();
        boolean bl4 = AbstractWidget.isJp();
        if (bl4 && bl3) {
            String string3 = this.touchController.getMatchSpellerValidChars();
            if ((string2 = AbstractToneAndCaseTogglingTable.getFirstValidToneOrCaseCharForJPLanguageWithNVCFilter(string2, string3)) == null) {
                string2 = string;
            }
            this.touchController.setToneLowerCaseButtonValidChars(string3);
        }
        if (bl) {
            this.handleLongPressCharacter(string2);
        } else {
            this.delegate.characterPressed(string2, bl, bl2);
        }
        if ("\b".equals(string) && this.touchController.isWordPredictionAvailable()) {
            this.touchController.updateWordPredictionContext("", false);
        }
    }

    private void handleLongPressCharacter(String string) {
        ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
        iTouchInputDataAsia.longPressOnCharacterOccurred(string);
    }

    @Override
    public void buttonLongPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        this.delegate.buttonLongPressed(spellerController$SpellerButtonType);
    }

    @Override
    public void buttonReleased(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        if (SpellerController$SpellerButtonType.DELETE == spellerController$SpellerButtonType && !this.touchController.hasNonRegularCharacters()) {
            this.touchController.handleDeletionForTruffleButton();
            this.touchController.setEmptyWordPredictionContext();
        }
        this.delegate.buttonReleased(spellerController$SpellerButtonType);
    }

    @Override
    public void focusedCharacterChanged(String string) {
    }

    @Override
    public void spellerBandStateChanged(SpellerBandState spellerBandState, SpellerBandState spellerBandState2) {
        this.touchController.showFocusStateDebugInfo();
        if (spellerBandState2 == SpellerBandState.TOUCH_PREDICTION_LINE) {
            this.touchController.clearSuggestion();
        }
        if (spellerBandState == SpellerBandState.TOUCH_PREDICTION_LINE) {
            if (spellerBandState2.isUsingDefaultSpellerBand()) {
                this.touchController.clearSuggestion();
            }
            this.touchController.setFocusState(TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS);
        } else if (spellerBandState.isUsingTouchResultLine()) {
            this.touchController.setFocusState(TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS);
        }
        this.touchController.updateButtonStates();
    }

    @Override
    public void touchWordPredictionContextUpdateNeeded(String string) {
        this.touchController.updateWordPredictionContext(string, false);
    }

    @Override
    public void focusChanged(SpellerController$ISpellerItem spellerController$ISpellerItem, int n) {
        this.delegate.focusChanged(spellerController$ISpellerItem, n);
    }

    /* synthetic */ TouchControllerListenerFactory$SpellerListenerImplAsia(TouchControllerAsia touchControllerAsia, TouchControllerListenerFactory$SpellerListenerImpl touchControllerListenerFactory$SpellerListenerImpl, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchControllerAsia, touchControllerListenerFactory$SpellerListenerImpl);
    }
}

