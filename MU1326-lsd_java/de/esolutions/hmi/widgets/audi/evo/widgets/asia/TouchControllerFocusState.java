/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$ConversionLineFocusKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$InputLineFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$KeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$SpellerLineFocusKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$TouchPredictionLineFocusKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$TouchResultLineFocusKeyHandler;

public final class TouchControllerFocusState {
    public static final TouchControllerFocusState SPELLER_LINE_FOCUS = new TouchControllerFocusState("SPELLER_LINE_FOCUS", new TouchControllerFocusState$SpellerLineFocusKeyHandler(null));
    public static final TouchControllerFocusState INPUT_LINE_FOCUS = new TouchControllerFocusState("INPUT_LINE_FOCUS", new TouchControllerFocusState$InputLineFocusState(null));
    public static final TouchControllerFocusState TOUCH_RESULT_LINE_FOCUS = new TouchControllerFocusState("TOUCH_RESULT_LINE_FOCUS", new TouchControllerFocusState$TouchResultLineFocusKeyHandler(null));
    public static final TouchControllerFocusState TOUCH_PREDICTION_LINE_FOCUS = new TouchControllerFocusState("PREDICTION_RESULT_LINE_FOCUS", new TouchControllerFocusState$TouchPredictionLineFocusKeyHandler(null));
    public static final TouchControllerFocusState CONVERSION_LINE_FOCUS = new TouchControllerFocusState("CONVERSION_LINE_FOCUS", new TouchControllerFocusState$ConversionLineFocusKeyHandler(null));
    private final String name;
    private final TouchControllerFocusState$KeyHandler keyHandler;

    private TouchControllerFocusState(String string, TouchControllerFocusState$KeyHandler touchControllerFocusState$KeyHandler) {
        this.name = string;
        this.keyHandler = touchControllerFocusState$KeyHandler;
    }

    public TouchControllerFocusState$KeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    public String toString() {
        return this.name;
    }
}

