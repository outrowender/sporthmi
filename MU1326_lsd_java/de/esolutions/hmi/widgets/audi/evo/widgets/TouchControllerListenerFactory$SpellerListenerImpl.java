/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;

final class TouchControllerListenerFactory$SpellerListenerImpl
implements ISpellerListener {
    private TouchController touchController = null;

    private TouchControllerListenerFactory$SpellerListenerImpl(TouchController touchController) {
        this.touchController = touchController;
    }

    @Override
    public void buttonPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType, SpellerButtonArgument spellerButtonArgument) {
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.CLOSE) {
            this.touchController.closeSpeller();
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.OK) {
            this.touchController.okPressed(spellerButtonArgument);
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.RIGHT) {
            this.touchController.moveCursorRight();
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.LEFT) {
            this.touchController.moveCursorLeft();
        }
    }

    @Override
    public void buttonLongPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.DELETE) {
            this.touchController.clear(true);
        }
    }

    @Override
    public void buttonReleased(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.DELETE) {
            this.characterPressed("\b", false, false);
        }
    }

    @Override
    public void characterPressed(String string, boolean bl, boolean bl2) {
        if (!bl2 || bl2 && !bl) {
            this.touchController.setFastDelete(false);
            this.touchController.stringEntered(string, null);
            if (string != null && string.length() > 0) {
                this.touchController.notifyPRPAboutSpellerInput(string.charAt(0));
            }
            this.touchController.setCompositesDirty(true);
        }
    }

    @Override
    public void focusedCharacterChanged(String string) {
        this.touchController.spellerCharacterFocused(TouchController.extractFirstCharacter(string));
    }

    @Override
    public void focusChanged(SpellerController$ISpellerItem spellerController$ISpellerItem, int n) {
    }

    /* synthetic */ TouchControllerListenerFactory$SpellerListenerImpl(TouchController touchController, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchController);
    }
}

