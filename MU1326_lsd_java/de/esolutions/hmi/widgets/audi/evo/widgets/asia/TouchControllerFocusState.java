/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataAsia;
import java.util.Iterator;

public final class TouchControllerFocusState {
    public static final TouchControllerFocusState SPELLER_LINE_FOCUS = new TouchControllerFocusState("SPELLER_LINE_FOCUS", new SpellerLineFocusKeyHandler());
    public static final TouchControllerFocusState INPUT_LINE_FOCUS = new TouchControllerFocusState("INPUT_LINE_FOCUS", new InputLineFocusState());
    public static final TouchControllerFocusState TOUCH_RESULT_LINE_FOCUS = new TouchControllerFocusState("TOUCH_RESULT_LINE_FOCUS", new TouchResultLineFocusKeyHandler());
    public static final TouchControllerFocusState TOUCH_PREDICTION_LINE_FOCUS = new TouchControllerFocusState("PREDICTION_RESULT_LINE_FOCUS", new TouchPredictionLineFocusKeyHandler());
    public static final TouchControllerFocusState CONVERSION_LINE_FOCUS = new TouchControllerFocusState("CONVERSION_LINE_FOCUS", new ConversionLineFocusKeyHandler());
    private final String name;
    private final KeyHandler keyHandler;

    private TouchControllerFocusState(String string, KeyHandler keyHandler) {
        this.name = string;
        this.keyHandler = keyHandler;
    }

    public KeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    public String toString() {
        return this.name;
    }

    public static interface KeyHandler {
        public void handleKeyPress(TouchControllerAsia var1, KeyEvent var2);

        public void handleKeyMove(TouchControllerAsia var1, JoystickEvent var2);

        public void handleKeyTurn(TouchControllerAsia var1, WheelButtonEvent var2);
    }

    private static class InputLineFocusState
    implements KeyHandler {
        private InputLineFocusState() {
        }

        public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
        }

        public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
        }

        public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
        }
    }

    private static class SpellerLineFocusKeyHandler
    implements KeyHandler {
        private SpellerLineFocusKeyHandler() {
        }

        public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
            if (touchControllerAsia.isInputLocked()) {
                keyEvent.consume(true);
            }
        }

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
                            touchControllerAsia.setFocusState(SPELLER_LINE_FOCUS);
                            touchControllerAsia.setConversionLineVisible(false);
                            conversionLineController.acceptFocusedItemAsSelection();
                        } else {
                            if (!conversionLineController.isVisible()) {
                                touchControllerAsia.setConversionLineVisible(true);
                            }
                            touchControllerAsia.setFocusState(CONVERSION_LINE_FOCUS);
                            conversionLineController.refreshCursor();
                        }
                        joystickEvent.consume(true);
                    }
                }
            }
        }

        public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
        }
    }

    private static class ConversionLineFocusKeyHandler
    implements KeyHandler {
        private ConversionLineFocusKeyHandler() {
        }

        public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 15) {
                touchControllerAsia.setFocusState(SPELLER_LINE_FOCUS);
            } else if (keyEvent.getKeyCode() == 17) {
                ConversionLineController conversionLineController = touchControllerAsia.getConversionLine();
                touchControllerAsia.setConversionLineVisible(false);
                if (conversionLineController.getCurrentFocus() == ConversionLineController.TRUFFLE_BUTTON_ITEM) {
                    touchControllerAsia.acceptSuggestion();
                    touchControllerAsia.setFocusState(SPELLER_LINE_FOCUS);
                } else if (conversionLineController.getCurrentFocus() != ConversionLineController.OPEN_MATRIX_POPUP_BUTTON_ITEM && !touchControllerAsia.shouldUseWordPrediction()) {
                    touchControllerAsia.setFocusState(SPELLER_LINE_FOCUS);
                }
                conversionLineController.acceptFocusedItemAsSelection();
                keyEvent.consume(true);
            }
        }

        public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
            int n = joystickEvent.getDirection();
            if (n == 6) {
                touchControllerAsia.setFocusState(SPELLER_LINE_FOCUS);
                joystickEvent.consume(true);
            }
        }

        public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
            touchControllerAsia.getConversionLine().keyTurned(wheelButtonEvent);
            wheelButtonEvent.consume(true);
        }
    }

    private static class TouchResultLineFocusKeyHandler
    implements KeyHandler {
        private TouchResultLineFocusKeyHandler() {
        }

        public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
            if (touchControllerAsia.isToggleButtonTargetOfCursor()) {
                touchControllerAsia.setHandWrittenModeIsActive(false);
                touchControllerAsia.notifyMatchspellerModelAboutInputModeChange(0);
            }
        }

        public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
        }

        public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
            if (touchControllerAsia.getSpeller() != null && !touchControllerAsia.isSpellerClosed()) {
                touchControllerAsia.getSpeller().keyTurned(wheelButtonEvent);
            }
            touchControllerAsia.setTouchResultPreviewIfExisting();
        }
    }

    private static class TouchPredictionLineFocusKeyHandler
    implements KeyHandler {
        final TouchResultLineFocusKeyHandler delegate = new TouchResultLineFocusKeyHandler();

        private TouchPredictionLineFocusKeyHandler() {
        }

        public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
            SpellerControllerAsia.TouchPredictionLine touchPredictionLine = (SpellerControllerAsia.TouchPredictionLine)((SpellerControllerAsia)touchControllerAsia.getSpeller()).getTouchPredictionLine();
            SpellerController.ISpellerItem iSpellerItem = touchPredictionLine.getCurrentFocusedItem();
            if (iSpellerItem != null && iSpellerItem == touchPredictionLine.getTruffleButton() && keyEvent.getKeyCode() == 17) {
                touchControllerAsia.acceptSuggestion();
            } else {
                this.delegate.handleKeyPress(touchControllerAsia, keyEvent);
            }
        }

        public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
            this.delegate.handleKeyMove(touchControllerAsia, joystickEvent);
        }

        public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
            this.delegate.handleKeyTurn(touchControllerAsia, wheelButtonEvent);
        }
    }
}

