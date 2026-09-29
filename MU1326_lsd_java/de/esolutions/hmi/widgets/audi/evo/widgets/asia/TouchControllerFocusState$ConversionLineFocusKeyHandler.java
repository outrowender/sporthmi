/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$KeyHandler;

class TouchControllerFocusState$ConversionLineFocusKeyHandler
implements TouchControllerFocusState$KeyHandler {
    private TouchControllerFocusState$ConversionLineFocusKeyHandler() {
    }

    @Override
    public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 15) {
            touchControllerAsia.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
        } else if (keyEvent.getKeyCode() == 17) {
            ConversionLineController conversionLineController = touchControllerAsia.getConversionLine();
            touchControllerAsia.setConversionLineVisible(false);
            if (conversionLineController.getCurrentFocus() == ConversionLineController.TRUFFLE_BUTTON_ITEM) {
                touchControllerAsia.acceptSuggestion();
                touchControllerAsia.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
            } else if (conversionLineController.getCurrentFocus() != ConversionLineController.OPEN_MATRIX_POPUP_BUTTON_ITEM && !touchControllerAsia.shouldUseWordPrediction()) {
                touchControllerAsia.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
            }
            conversionLineController.acceptFocusedItemAsSelection();
            keyEvent.consume(true);
        }
    }

    @Override
    public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
        int n = joystickEvent.getDirection();
        if (n == 6) {
            touchControllerAsia.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
            joystickEvent.consume(true);
        }
    }

    @Override
    public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
        touchControllerAsia.getConversionLine().keyTurned(wheelButtonEvent);
        wheelButtonEvent.consume(true);
    }

    /* synthetic */ TouchControllerFocusState$ConversionLineFocusKeyHandler(TouchControllerFocusState$1 touchControllerFocusState$1) {
        this();
    }
}

