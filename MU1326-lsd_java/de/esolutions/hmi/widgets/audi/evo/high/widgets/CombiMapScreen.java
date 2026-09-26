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

    @Override
    public void connected(InitializationContext initializationContext) {
        this.initConnect(initializationContext);
        this.initializeWidget();
        this.propagateConnected(initializationContext);
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        try {
            logWidgetPerformance.log(1078071040, "CombiMapScreen#processModelUpdateEvent start, event: %1", (Object)modelUpdateEvent);
            if (modelUpdateEvent.getTerminalID() != -1 && modelUpdateEvent.getTerminalID() != this.initContext.getTerminalID()) {
                if (screenLogChannel.isDebug()) {
                    screenLogChannel.log(-2137614336, "CombiMapScreen#processModelUpdateEvent is called for other terminal. modelUpdateTerminalID: %1 initContext.terminalID: %2", (long)modelUpdateEvent.getTerminalID(), (long)this.initContext.getTerminalID());
                }
                return;
            }
            if (new ModelEventPropagator(modelUpdateEvent, this).propagate()) {
                screenLogChannel.log(-2137614336, "CombiMapScreen#processModelUpdateEvent updateEvent with ID: %1 has been processed", (long)modelUpdateEvent.getModelId());
            }
        }
        catch (Exception exception) {
            logChannel.log(10000, "CombiMapScreen#processModelUpdateEvent error ocurred in screen with ID %1, exception: %2", (long)this.id, (Throwable)exception);
            exception.printStackTrace();
        }
    }

    @Override
    public void paint() {
    }

    @Override
    public void doCheckedRepaint() {
    }

    @Override
    public void triggerRepaint() {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadPalmRecognized(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
    }

    @Override
    public void processSDSEvent(SDSEvent sDSEvent) {
    }

    @Override
    public void unitsChanged(UnitChangedEvent unitChangedEvent) {
    }

    @Override
    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    @Override
    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    @Override
    public void processKeyEvent(KeyEvent keyEvent) {
    }

    @Override
    public void processTouchPadEvent(TouchEvent touchEvent) {
    }

    @Override
    public void processGestureEvent(GestureEvent gestureEvent) {
    }
}

