/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.eso.widgets.preset.PresetManager;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public class PresetInputHandler
implements IPresetInputHandler {
    private static LogChannel lc = IWidgetLogChannel.logPresetInput;
    private final PresetManager presetManager;

    public PresetInputHandler(PresetManager presetManager) {
        this.presetManager = presetManager;
    }

    public PresetManager getPresetManager() {
        return this.presetManager;
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        lc.log(-2137614336, "touchPadPressed keyCode: %1", (long)touchEvent.getCode());
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        lc.log(-2137614336, "touchPadReleased keyCode: %1 - do nothing", (long)touchEvent.getCode());
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        lc.log(-2137614336, "touchPadPositionMoved evt: %1", (Object)touchEvent);
        this.presetManager.getPresetFSM().touchPadPositionMoved(touchEvent);
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadPalmRecognized(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        lc.log(-2137614336, "touchPadApproached keyCode: %1", (long)touchEvent.getCode());
        if (this.isEcallActive()) {
            lc.log(-2137614336, "touchPadApproached eCall is active -> return");
            return;
        }
        int n = touchEvent.getCode();
        switch (n) {
            case 43: {
                this.presetManager.getPresetFSM().touchPadApproached(0);
                touchEvent.consume(true);
                break;
            }
            case 44: {
                this.presetManager.getPresetFSM().touchPadApproached(1);
                touchEvent.consume(true);
                break;
            }
            case 45: {
                this.presetManager.getPresetFSM().touchPadApproached(2);
                touchEvent.consume(true);
                break;
            }
            case 46: {
                this.presetManager.getPresetFSM().touchPadApproached(3);
                touchEvent.consume(true);
                break;
            }
            case 47: {
                this.presetManager.getPresetFSM().touchPadApproached(4);
                touchEvent.consume(true);
                break;
            }
            case 48: {
                this.presetManager.getPresetFSM().touchPadApproached(5);
                touchEvent.consume(true);
                break;
            }
            case 79: {
                this.presetManager.getPresetFSM().touchPadApproached(6);
                touchEvent.consume(true);
                break;
            }
            case 80: {
                this.presetManager.getPresetFSM().touchPadApproached(7);
                touchEvent.consume(true);
                break;
            }
            case 86: {
                this.presetManager.getPresetFSM().touchPadAbandoned();
                touchEvent.consume(true);
                break;
            }
        }
    }

    private boolean isEcallActive() {
        if (AbstractWidget.hmiService != null) {
            return AbstractWidget.hmiService.getChoiceModel(4371).getValue() == 1;
        }
        return false;
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        lc.log(-2137614336, "touchPadAbandoned keyCode: %1", (long)touchEvent.getCode());
        this.presetManager.getPresetFSM().touchPadAbandoned();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        lc.log(-2137614336, "keyPressed keyCode: %1", (long)n);
        switch (n) {
            case 43: {
                this.presetManager.getPresetFSM().keyPressed(0);
                break;
            }
            case 44: {
                this.presetManager.getPresetFSM().keyPressed(1);
                break;
            }
            case 45: {
                this.presetManager.getPresetFSM().keyPressed(2);
                break;
            }
            case 46: {
                this.presetManager.getPresetFSM().keyPressed(3);
                break;
            }
            case 47: {
                this.presetManager.getPresetFSM().keyPressed(4);
                break;
            }
            case 48: {
                this.presetManager.getPresetFSM().keyPressed(5);
                break;
            }
            case 79: {
                this.presetManager.getPresetFSM().keyPressed(6);
                break;
            }
            case 80: {
                this.presetManager.getPresetFSM().keyPressed(7);
                break;
            }
            default: {
                this.presetManager.getPresetFSM().cancelPopup();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        lc.log(-2137614336, "keyReleased keyCode: %1", (long)n);
        switch (n) {
            case 43: {
                this.presetManager.getPresetFSM().keyReleased(0);
                break;
            }
            case 44: {
                this.presetManager.getPresetFSM().keyReleased(1);
                break;
            }
            case 45: {
                this.presetManager.getPresetFSM().keyReleased(2);
                break;
            }
            case 46: {
                this.presetManager.getPresetFSM().keyReleased(3);
                break;
            }
            case 47: {
                this.presetManager.getPresetFSM().keyReleased(4);
                break;
            }
            case 48: {
                this.presetManager.getPresetFSM().keyReleased(5);
                break;
            }
            case 79: {
                this.presetManager.getPresetFSM().keyReleased(6);
                break;
            }
            case 80: {
                this.presetManager.getPresetFSM().keyReleased(7);
                break;
            }
            case 86: {
                lc.log(-2137614336, "keyReleased on TouchPadCenter preset execution is NOT triggered");
                break;
            }
            default: {
                lc.log(-2137614336, "keyReleased unsupported keyCode, preset execution is NOT triggered");
            }
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        lc.log(-2137614336, "keyTurned WheelButtonEvent: %1", (Object)wheelButtonEvent);
        this.presetManager.getPresetFSM().cancelPopup();
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        lc.log(-2137614336, "keyMoved JoystickEvent: %1", (Object)joystickEvent);
        this.presetManager.getPresetFSM().cancelPopup();
    }

    @Override
    public void presetPopupVisible(boolean bl) {
        lc.log(-2137614336, "presetPopupVisible visible: %1", bl);
        this.presetManager.presetPopupVisible(bl);
    }
}

