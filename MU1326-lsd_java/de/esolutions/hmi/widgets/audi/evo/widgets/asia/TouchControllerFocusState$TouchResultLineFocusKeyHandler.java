/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState$KeyHandler;

class TouchControllerFocusState$TouchResultLineFocusKeyHandler
implements TouchControllerFocusState$KeyHandler {
    private TouchControllerFocusState$TouchResultLineFocusKeyHandler() {
    }

    @Override
    public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
        if (touchControllerAsia.isToggleButtonTargetOfCursor()) {
            touchControllerAsia.setHandWrittenModeIsActive(false);
            touchControllerAsia.notifyMatchspellerModelAboutInputModeChange(0);
        }
    }

    @Override
    public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
    }

    @Override
    public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
        if (touchControllerAsia.getSpeller() != null && !touchControllerAsia.isSpellerClosed()) {
            touchControllerAsia.getSpeller().keyTurned(wheelButtonEvent);
        }
        touchControllerAsia.setTouchResultPreviewIfExisting();
    }

    /* synthetic */ TouchControllerFocusState$TouchResultLineFocusKeyHandler(TouchControllerFocusState$1 touchControllerFocusState$1) {
        this();
    }
}

