/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.UnitChangedEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.ModelEventPropagator;

public class CombiMapScreen
extends AbstractScreenWidget {
    public CombiMapScreen(int n) {
        super(n);
    }

    public void connected(InitializationContext initializationContext) {
        this.initConnect(initializationContext);
        this.initializeWidget();
        this.propagateConnected(initializationContext);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        try {
            logWidgetPerformance.log(1000000, "CombiMapScreen#processModelUpdateEvent start, event: %1", (Object)modelUpdateEvent);
            if (modelUpdateEvent.getTerminalID() != -1 && modelUpdateEvent.getTerminalID() != this.initContext.getTerminalID()) {
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(10000000, "CombiMapScreen#processModelUpdateEvent is called for other terminal. modelUpdateTerminalID: %1 initContext.terminalID: %2", (long)modelUpdateEvent.getTerminalID(), (long)this.initContext.getTerminalID());
                }
                return;
            }
            if (new ModelEventPropagator(modelUpdateEvent, this).propagate()) {
                screenLogChannel.log(10000000, "CombiMapScreen#processModelUpdateEvent updateEvent with ID: %1 has been processed", (long)modelUpdateEvent.getModelId());
            }
        }
        catch (Exception exception) {
            logChannel.log(10000, "CombiMapScreen#processModelUpdateEvent error ocurred in screen with ID %1, exception: %2", (long)this.id, (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void paint() {
    }

    public void doCheckedRepaint() {
    }

    public void triggerRepaint() {
    }

    public void keyPressed(KeyEvent keyEvent) {
    }

    public void keyReleased(KeyEvent keyEvent) {
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    public void keyMoved(JoystickEvent joystickEvent) {
    }

    public void touchPadPressed(TouchEvent touchEvent) {
    }

    public void touchPadReleased(TouchEvent touchEvent) {
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
    }

    public void touchPadPalmRecognized(TouchEvent touchEvent) {
    }

    public void touchPadApproached(TouchEvent touchEvent) {
    }

    public void processSDSEvent(SDSEvent sDSEvent) {
    }

    public void unitsChanged(UnitChangedEvent unitChangedEvent) {
    }

    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    public void processKeyEvent(KeyEvent keyEvent) {
    }

    public void processTouchPadEvent(TouchEvent touchEvent) {
    }

    public void processGestureEvent(GestureEvent gestureEvent) {
    }
}

