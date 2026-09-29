/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$KeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataAsia;
import java.util.Iterator;

class TouchControllerFocusState$SpellerLineFocusKeyHandler
implements TouchControllerFocusState$KeyHandler {
    private TouchControllerFocusState$SpellerLineFocusKeyHandler() {
    }

    @Override
    public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
        if (touchControllerAsia.isInputLocked()) {
            keyEvent.consume(true);
        }
    }

    @Override
    public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
        int n = joystickEvent.getDirection();
        if (n == 2) {
            boolean bl = ((SpellerControllerAsia)touchControllerAsia.getSpeller()).releasePressedItem();
            if (bl) {
                return;
            }
            ConversionLineController conversionLineController = touchControllerAsia.getConversionLine();
            if (conversionLineController != null && 1 == conversionLineController.getMode() || touchControllerAsia.isInputLocked()) {
                return;
            }
            IInputTextInfoProvider iInputTextInfoProvider = touchControllerAsia.getInputData();
            if (null == iInputTextInfoProvider || !(iInputTextInfoProvider instanceof TouchInputDataAsia)) {
                return;
            }
            if (conversionLineController != null && (((TouchInputDataAsia)iInputTextInfoProvider).hasUnconvertedCharacters() || touchControllerAsia.isWordPredictionAvailable())) {
                if (touchControllerAsia.getConversionLine().isSingleTruffleButtonShowed()) {
                    if (ConversionLineController.TRUFFLE_BUTTON_ITEM.isEnabled()) {
                        touchControllerAsia.acceptSuggestion();
                    }
                } else {
                    Iterator iterator = conversionLineController.getCandidateIterator();
                    int n2 = 0;
                    while (iterator.hasNext()) {
                        ++n2;
                        iterator.next();
                    }
                    if (n2 < 2) {
                        touchControllerAsia.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
                        touchControllerAsia.setConversionLineVisible(false);
                        conversionLineController.acceptFocusedItemAsSelection();
                    } else {
                        if (!conversionLineController.isVisible()) {
                            touchControllerAsia.setConversionLineVisible(true);
                        }
                        touchControllerAsia.setFocusState(TouchControllerFocusState.CONVERSION_LINE_FOCUS);
                        conversionLineController.refreshCursor();
                    }
                    joystickEvent.consume(true);
                }
            }
        }
    }

    @Override
    public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
    }

    /* synthetic */ TouchControllerFocusState$SpellerLineFocusKeyHandler(TouchControllerFocusState$1 touchControllerFocusState$1) {
        this();
    }
}

