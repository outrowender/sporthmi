/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.keyhandling.IKeyEventDistributor;
import de.audi.atip.keyhandling.IVirtualGUIManager;
import de.audi.atip.log.LogChannel;

public class KeyInputListener
implements ATIPEventListener {
    private final IKeyEventDistributor keyEventDistributor;
    private final LogChannel log;

    public KeyInputListener(int n, IFrameworkAccess iFrameworkAccess, IVirtualGUIManager iVirtualGUIManager) {
        this.keyEventDistributor = iFrameworkAccess.getHMITerminalRegistry().getKeyEventDistributor(n);
        if (this.keyEventDistributor == null) {
            throw new IllegalArgumentException("terminalId " + n + " out of Range!");
        }
        this.keyEventDistributor.setHardkeyListeners(iVirtualGUIManager);
        this.log = iFrameworkAccess.getLogChannel("Fw.Kbd.KeyInputListener");
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        this.log.log(1000000, "KeyInputListener.processEvent(%1)", (Object)aTIPEvent);
        if (aTIPEvent instanceof KeyEvent) {
            switch (((KeyEvent)aTIPEvent).getID()) {
                case 10401: {
                    this.keyEventDistributor.keyPressed((KeyEvent)aTIPEvent);
                    break;
                }
                case 10402: {
                    this.keyEventDistributor.keyReleased((KeyEvent)aTIPEvent);
                    break;
                }
                case 10403: {
                    this.keyEventDistributor.keyTurned((WheelButtonEvent)aTIPEvent);
                    break;
                }
                case 10404: {
                    this.keyEventDistributor.keyMoved((JoystickEvent)aTIPEvent);
                    break;
                }
            }
        } else if (aTIPEvent instanceof TouchEvent) {
            switch (((TouchEvent)aTIPEvent).getID()) {
                case 10908: {
                    this.keyEventDistributor.touchPadCharactersRecognized((TouchEvent)aTIPEvent);
                    break;
                }
                case 10910: {
                    this.keyEventDistributor.touchPadAbandoned((TouchEvent)aTIPEvent);
                    break;
                }
                case 10909: {
                    this.keyEventDistributor.touchPadApproached((TouchEvent)aTIPEvent);
                    break;
                }
                case 10904: 
                case 10906: 
                case 10907: {
                    this.keyEventDistributor.touchPadPressed((TouchEvent)aTIPEvent);
                    break;
                }
                case 10905: {
                    this.keyEventDistributor.touchPadReleased((TouchEvent)aTIPEvent);
                    break;
                }
                case 10911: {
                    this.keyEventDistributor.touchPadPositionMoved((TouchEvent)aTIPEvent);
                    break;
                }
                case 10912: {
                    this.keyEventDistributor.touchPadPositionMoved((TouchEvent)aTIPEvent);
                    break;
                }
                case 10914: {
                    this.keyEventDistributor.touchPadPalmRecognized((TouchEvent)aTIPEvent);
                    break;
                }
                case 10913: {
                    this.keyEventDistributor.touchPadPositionMoved((TouchEvent)aTIPEvent);
                    break;
                }
            }
        } else if (aTIPEvent instanceof GestureEvent) {
            this.keyEventDistributor.triggerGestureEvent((GestureEvent)aTIPEvent);
        } else if (aTIPEvent instanceof ProximityEvent) {
            this.keyEventDistributor.triggerProximityEvent((ProximityEvent)aTIPEvent);
        }
    }

    public void setSDSService(SDSService sDSService) {
        this.keyEventDistributor.setSDSService(sDSService);
    }
}

