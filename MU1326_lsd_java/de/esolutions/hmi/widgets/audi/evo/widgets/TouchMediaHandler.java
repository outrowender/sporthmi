/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class TouchMediaHandler
extends AbstractWidgetController {
    public static final int MODE_DVD;
    public static final int MODE_JP_TV;
    private static final int TRIGGER_MIN_DISTANCE;
    private static final int TRIGGER_DISTANCE;
    private int triggerRootXCoordinate = 0;
    private int triggerRootYCoordinate = 0;
    private int currentXCoordinate = 0;
    private int currentYCoordinate = 0;
    private boolean triggeredInCycle = false;

    @Override
    protected void initializeWidget() {
        if (this.terminal != null && this.terminal.getTouchInputManager() != null) {
            this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, 25);
        }
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        this.triggerRootXCoordinate = touchEvent.getX();
        this.triggerRootYCoordinate = touchEvent.getY();
        this.triggeredInCycle = false;
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        this.currentXCoordinate = touchEvent.getX();
        this.currentYCoordinate = touchEvent.getY();
        if (this.model instanceof VirtualButtonModelGUI) {
            if (Math.abs(this.triggerRootXCoordinate - this.currentXCoordinate) > 400) {
                this.triggerHorizontally(this.triggerRootXCoordinate - this.currentXCoordinate);
                this.triggerRootXCoordinate = this.currentXCoordinate;
                this.triggerRootYCoordinate = this.currentYCoordinate;
            } else if (Math.abs(this.triggerRootYCoordinate - this.currentYCoordinate) > 400) {
                this.triggerVertically(this.triggerRootYCoordinate - this.currentYCoordinate);
                this.triggerRootXCoordinate = this.currentXCoordinate;
                this.triggerRootYCoordinate = this.currentYCoordinate;
            }
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        if (!this.triggeredInCycle && this.model instanceof VirtualButtonModelGUI) {
            int n = Math.abs(this.triggerRootXCoordinate - this.currentXCoordinate);
            int n2 = Math.abs(this.triggerRootYCoordinate - this.currentYCoordinate);
            if (n > 200 || n2 > 200) {
                if (n > n2) {
                    this.triggerHorizontally(this.triggerRootXCoordinate - this.currentXCoordinate);
                } else {
                    this.triggerVertically(this.triggerRootYCoordinate - this.currentYCoordinate);
                }
            }
        }
        ((VirtualButtonModelGUI)this.model).joyIdle(this.terminal.getTerminalID());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 17 && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).keyPressed(keyEvent.getKeyCode(), this.terminal.getTerminalID());
            ((VirtualButtonModelGUI)this.model).keyTyped(keyEvent.getKeyCode(), this.terminal.getTerminalID());
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 17 && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).keyReleased(keyEvent.getKeyCode(), this.terminal.getTerminalID());
        }
    }

    private void triggerHorizontally(int n) {
        this.triggeredInCycle = true;
        if (n < 0) {
            ((VirtualButtonModelGUI)this.model).joyE(this.terminal.getTerminalID());
        } else {
            ((VirtualButtonModelGUI)this.model).joyW(this.terminal.getTerminalID());
        }
    }

    private void triggerVertically(int n) {
        this.triggeredInCycle = true;
        if (n < 0) {
            ((VirtualButtonModelGUI)this.model).joyS(this.terminal.getTerminalID());
        } else {
            ((VirtualButtonModelGUI)this.model).joyN(this.terminal.getTerminalID());
        }
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }
}

