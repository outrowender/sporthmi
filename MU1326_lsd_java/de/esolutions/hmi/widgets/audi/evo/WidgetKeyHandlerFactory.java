/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.ButtonModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.ChoiceModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.CloseDrawerKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.OpenSelectionDrawerKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.RangeModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.RightDrawerActionKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.StateMachineKeyHandler;

public class WidgetKeyHandlerFactory
implements WidgetConstants,
IWidgetLogChannel {
    public static final int BUTTON_MODEL_KEY_HANDLER = 0;
    public static final int RANGE_MODEL_KEY_HANDLER = 1;
    public static final int CHOICE_MODEL_KEY_HANDLER = 2;
    public static final int STATE_MACHINE_MODEL_KEY_HANDLER = 3;
    public static final int SPELLER_OPEN_KEY_HANDLER = 4;
    public static final int SPELLER_CLOSE_KEY_HANDLER = 5;
    public static final int SPELLER_CLEAR_KEY_HANDLER = 6;
    public static final int SPELLER_SWITCH_TO_LATIN_KEY_HANDLER = 7;
    public static final int SPELLER_SWITCH_TO_CYRILLIC_KEY_HANDLER = 8;
    public static final int SPELLER_SWITCH_TO_ARABIC_KEY_HANDLER = 9;
    public static final int CLOSE_DRAWER_KEY_HANDLER = 10;
    public static final int OPEN_SELECTION_DRAWER_KEY_HANDLER = 11;
    public static final int SPELLER_SWITCH_TO_PINYIN_KEY_HANDLER = 12;
    public static final int SPELLER_SWITCH_TO_STROKE_KEY_HANDLER = 13;
    public static final int SPELLER_SWITCH_TO_ZHUYIN_KEY_HANDLER = 14;
    public static final int SPELLER_SWITCH_TO_HIRAGANA_KEY_HANDLER = 15;
    public static final int SPELLER_SWITCH_TO_JAMO_KEY_HANDLER = 16;

    private WidgetKeyHandlerFactory() {
    }

    public static IWidgetKeyHandler createKeyHandler(int n) {
        switch (n) {
            case 0: {
                return ButtonModelKeyHandler.BUTTON_MODEL_KEY_HANDLER_INSTANCE;
            }
            case 1: {
                return RangeModelKeyHandler.RANGE_MODEL_KEY_HANDLER_INSTANCE;
            }
            case 2: {
                return ChoiceModelKeyHandler.CHOICE_MODEL_HANDLER_INSTANCE;
            }
            case 3: {
                return StateMachineKeyHandler.STATE_MACHINE_HANDLER_INSTANCE;
            }
            case 4: {
                return new RightDrawerActionKeyHandler(2);
            }
            case 5: {
                return new RightDrawerActionKeyHandler(1);
            }
            case 6: {
                return new RightDrawerActionKeyHandler(3);
            }
            case 7: {
                return new RightDrawerActionKeyHandler(5);
            }
            case 8: {
                return new RightDrawerActionKeyHandler(6);
            }
            case 9: {
                return new RightDrawerActionKeyHandler(7);
            }
            case 12: {
                return new RightDrawerActionKeyHandler(8);
            }
            case 13: {
                return new RightDrawerActionKeyHandler(9);
            }
            case 14: {
                return new RightDrawerActionKeyHandler(10);
            }
            case 15: {
                return new RightDrawerActionKeyHandler(12);
            }
            case 16: {
                return new RightDrawerActionKeyHandler(11);
            }
            case 10: {
                return new CloseDrawerKeyHandler(null, true);
            }
            case 11: {
                return OpenSelectionDrawerKeyHandler.OPEN_SELECTION_DRAWER_KEY_HANDLER_INSTANCE;
            }
            case -1: {
                return null;
            }
        }
        menuItemLogCh.log(10000, "WidgetKeyHandlerFactory#createKeyHandler: Unknown key handler type: %1", (long)n);
        return null;
    }
}

