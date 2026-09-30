/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerRenderer;

public class PopupDrawerController
extends ContainerController {
    protected void initializeWidget() {
        this.getDrawerFocusManager().registerPopupDrawerAction(new Runnable(){

            public void run() {
                PopupDrawerController.this.closePopupDrawer();
                PopupDrawerController.this.triggerRepaint();
            }
        });
    }

    protected void destroyWidget() {
        this.getDrawerFocusManager().registerPopupDrawerAction(null);
    }

    public void keyPressed(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (this.isDrawerOpened()) {
            if (this.isDrawerKey(n)) {
                logDrawerFocusMain.log(1000000, "PopupDrawerController#keyPressed closing popup drawer because drawer key pressed");
                this.closePopupDrawer();
                keyEvent.consume();
                return;
            }
            logDrawerFocusMain.log(10000000, "PopupDrawerController#keyPressed processing events by children");
            super.keyPressed(keyEvent);
            if (!keyEvent.isConsumed() && PopupDrawerController.isBackKey(n)) {
                logDrawerFocusMain.log(1000000, "PopupDrawerController#keyPressed closing popup drawer because back key pressed");
                this.closePopupDrawer();
                keyEvent.consume();
                return;
            }
            return;
        }
        if (this.isOptionDrawerKey(n) && this.areAllDrawersClosed()) {
            logDrawerFocusMain.log(1000000, "PopupDrawerController#keyPressed opening popup drawer because option drawer key pressed");
            this.openPopupDrawer();
            keyEvent.consume();
            return;
        }
        logDrawerFocusMain.log(10000000, "PopupDrawerController#keyPressed not processing event %1", (Object)keyEvent);
    }

    public void closePopupDrawer() {
        this.setOnScreen(false);
        this.focusChanged(1, 16, 0);
        this.terminal.getDrawerFocusManager().setPartialPopupDrawerOpen(false);
        this.setCompositesDirty(true);
        if (this.renderer instanceof ContainerRenderer) {
            ((ContainerRenderer)this.renderer).setVisibleDirect(false);
        }
    }

    private void openPopupDrawer() {
        this.setOnScreen(true);
        this.focusChanged(2, 8, 0);
        this.terminal.getDrawerFocusManager().setPartialPopupDrawerOpen(true);
        this.setCompositesDirty(true);
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        int n = joystickEvent.getDirection();
        if (this.isDrawerOpened()) {
            if (this.isDrawerDirection(n)) {
                logDrawerFocusMain.log(1000000, "PopupDrawerController#keyMoved closing popup drawer because key moved");
                this.closePopupDrawer();
                joystickEvent.consume();
                return;
            }
            logDrawerFocusMain.log(10000000, "PopupDrawerController#keyMoved processing events by children");
            super.keyPressed(joystickEvent);
            return;
        }
        if (this.isOptionDrawerDirection(n) && this.areAllDrawersClosed()) {
            logDrawerFocusMain.log(1000000, "PopupDrawerController#keyMoved opening popup drawer because key moved");
            this.openPopupDrawer();
            joystickEvent.consume();
            return;
        }
        logDrawerFocusMain.log(10000000, "PopupDrawerController#keyMoved not processing event %1", (Object)joystickEvent);
    }

    private boolean isDrawerOpened() {
        return this.isOnScreen() && this.isVisible();
    }

    private boolean isDrawerKey(int n) {
        return this.isSelectionDrawerKey(n) || this.isOptionDrawerKey(n);
    }

    private boolean isSelectionDrawerKey(int n) {
        if (this.isLTR()) {
            return n == 9;
        }
        return n == 11;
    }

    private boolean isOptionDrawerKey(int n) {
        if (this.isLTR()) {
            return n == 11;
        }
        return n == 9;
    }

    private boolean isDrawerDirection(int n) {
        return this.isOptionDrawerDirection(n) || this.isSelectionDrawerDirection(n) || PopupDrawerController.isEntertainmentDrawerDirection(n);
    }

    private static boolean isEntertainmentDrawerDirection(int n) {
        return n == 6;
    }

    private static boolean isBackKey(int n) {
        return n == 15;
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (this.isDrawerOpened()) {
            super.keyReleased(keyEvent);
            return;
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.isDrawerOpened()) {
            super.keyTurned(wheelButtonEvent);
            return;
        }
    }

    private boolean areAllDrawersClosed() {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.getDrawerFocusManager();
        return iDrawerFocusManagerEvo.getDrawerState() == 16;
    }

    private IDrawerFocusManagerEvo getDrawerFocusManager() {
        return this.getTerminalImpl().getDrawerFocusManager();
    }
}

