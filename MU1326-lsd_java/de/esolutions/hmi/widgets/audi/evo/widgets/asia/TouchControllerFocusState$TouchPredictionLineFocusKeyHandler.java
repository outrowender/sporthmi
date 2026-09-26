/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia$TouchPredictionLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$KeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$TouchResultLineFocusKeyHandler;

class TouchControllerFocusState$TouchPredictionLineFocusKeyHandler
implements TouchControllerFocusState$KeyHandler {
    final TouchControllerFocusState$TouchResultLineFocusKeyHandler delegate = new TouchControllerFocusState$TouchResultLineFocusKeyHandler(null);

    private TouchControllerFocusState$TouchPredictionLineFocusKeyHandler() {
    }

    @Override
    public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
        SpellerControllerAsia$TouchPredictionLine spellerControllerAsia$TouchPredictionLine = (SpellerControllerAsia$TouchPredictionLine)((SpellerControllerAsia)touchControllerAsia.getSpeller()).getTouchPredictionLine();
        SpellerController$ISpellerItem spellerController$ISpellerItem = spellerControllerAsia$TouchPredictionLine.getCurrentFocusedItem();
        if (spellerController$ISpellerItem != null && spellerController$ISpellerItem == spellerControllerAsia$TouchPredictionLine.getTruffleButton() && keyEvent.getKeyCode() == 17) {
            touchControllerAsia.acceptSuggestion();
        } else {
            this.delegate.handleKeyPress(touchControllerAsia, keyEvent);
        }
    }

    @Override
    public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
        this.delegate.handleKeyMove(touchControllerAsia, joystickEvent);
    }

    @Override
    public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
        this.delegate.handleKeyTurn(touchControllerAsia, wheelButtonEvent);
    }

    /* synthetic */ TouchControllerFocusState$TouchPredictionLineFocusKeyHandler(TouchControllerFocusState$1 touchControllerFocusState$1) {
        this();
    }
}

