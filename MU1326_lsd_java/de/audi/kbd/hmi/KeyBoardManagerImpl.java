/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.IKeyBoardManager;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.keyhandling.IVirtualGUIManager;
import de.audi.atip.log.LogChannel;
import de.audi.kbd.hmi.KeyInputListener;
import de.esolutions.fw.util.commons.job.Job;

public class KeyBoardManagerImpl
implements IKeyBoardManager {
    private static final boolean SUPPORT_HDDS_SUBTICKS = Boolean.getBoolean("supportHDDS");
    private IFrameworkAccess framework;
    private final LogChannel logChannel;
    private final KeyInputListener[] keyInputListener = new KeyInputListener[8];

    public KeyBoardManagerImpl(IFrameworkAccess iFrameworkAccess, IVirtualGUIManager iVirtualGUIManager) {
        this.framework = iFrameworkAccess;
        this.logChannel = this.framework.getLogChannel("Fw.Kbd.KeyEvent");
        for (int i2 = 0; i2 < 8; ++i2) {
            this.keyInputListener[i2] = new KeyInputListener(i2, this.framework, iVirtualGUIManager);
        }
    }

    public Job fireKeyEvent(int n, long l, int n2, int n3) {
        return this.fireKeyEvent(n, l, n2, 0L, n3);
    }

    public Job fireKeyEvent(int n, long l, int n2, long l2, int n3) {
        if (n2 == 86 && (n == 10401 || n == 10402)) {
            n2 = 17;
        }
        KeyEvent keyEvent = new KeyEvent(this.getKeyEventListener(n3), n, l + l2, n2, n3);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireKeyEvent: Sending event! [%1]", (Object)keyEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(keyEvent, l2);
    }

    public void fireKeyEventDirectlyInEventDispatchThread(int n, long l, int n2, int n3) {
        if (!this.framework.getHMIService().getEventDispatcher().isDispatchThread()) {
            this.logChannel.log(1000, " trying to call method outside of event dispatch thread in thread: %1", (Object)Thread.currentThread());
            throw new FrameworkException("Not allowed to call method fireKeyEventDirectlyInEventDispatchThread from outside event dispatch thread");
        }
        KeyEvent keyEvent = new KeyEvent(this.getKeyEventListener(n3), n, l, n2, n3);
        this.getKeyEventListener(n3).processEvent(keyEvent);
    }

    public Job fireJoyStickEvent(int n, long l, int n2, int n3, int n4) {
        JoystickEvent joystickEvent = new JoystickEvent(this.getKeyEventListener(n4), n, l, n2, n3, n4);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireJoyStickEvent: Sending event! [%1]", (Object)joystickEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(joystickEvent);
    }

    public Job fireWheelButtonEvent(int n, long l, int n2, int n3, int n4, int n5) {
        return this.fireWheelButtonEvent(n, l, n2, n3, n4, 0, n5);
    }

    public Job fireWheelButtonEvent(int n, long l, int n2, int n3, int n4, int n5, int n6) {
        if (!SUPPORT_HDDS_SUBTICKS) {
            if (n4 == 0) {
                this.logChannel.log(1000000, "KeyBoardManagerImpl.fireWheelButtonEvent: ignore hDDS turn event, subticks: %1.", (long)n5);
                return null;
            }
            n5 = 0;
        }
        WheelButtonEvent wheelButtonEvent = new WheelButtonEvent(this.getKeyEventListener(n6), n, l, n2, n3, n4, n5, n6);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireWheelButtonEvent: Sending event! [%1]", (Object)wheelButtonEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(wheelButtonEvent);
    }

    public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, int n6) {
        TouchEvent touchEvent = new TouchEvent(this.getKeyEventListener(n6), n, l, n2, n3, n4, n5);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireTouchEvent: Sending event! [%1]", (Object)touchEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(touchEvent);
    }

    public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        TouchEvent touchEvent = new TouchEvent(this.getKeyEventListener(n9), n, l, n2, n3, n4, n5, n6, n7, n8);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireTouchEvent: Sending event! [%1]", (Object)touchEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(touchEvent);
    }

    public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, String string, int[] nArray, int n5) {
        TouchEvent touchEvent = new TouchEvent(this.getKeyEventListener(n5), n, l, n2, n3, n4, string, nArray);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireTouchEvent: Sending event! [%1]", (Object)touchEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(touchEvent);
    }

    public Job fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7, int n8, int n9) {
        TouchEvent touchEvent = new TouchEvent(this.getKeyEventListener(n9), n, l, n2, n3, n4, n5, bl, n6, n7, n8);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireTouchEvent: Sending event! [%1]", (Object)touchEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(touchEvent);
    }

    public Job fireGestureEvent(int n, long l, int n2, int n3, String[] stringArray, int[] nArray, int n4) {
        GestureEvent gestureEvent = new GestureEvent(this.getKeyEventListener(n4), n, this.framework.getMonotonicTime(), 0, n2, n3, stringArray, nArray);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireGestureEvent: Sending event! [%1]", (Object)gestureEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(gestureEvent);
    }

    public Job fireGestureEvent(int n, int n2, int n3, int n4, int n5, int n6, long l, int n7) {
        GestureEvent gestureEvent = new GestureEvent(this.getKeyEventListener(n7), n, l, 0, n3, n4, n5, n6);
        this.logChannel.log(1000000, "KeyBoardManagerImpl.fireGestureEvent: Sending event! [%1]", (Object)gestureEvent);
        return this.framework.getHMIService().getEventDispatcher().postEvent(gestureEvent);
    }

    public Job fireGestureEvent(int n, long l, int n2, int n3, int n4) {
        return this.fireGestureEvent(n, 1, n2, n3, 0, 0, this.framework.getMonotonicTime(), n4);
    }

    public Job fireProximityEvent(int n, int n2) {
        if (this.framework.getHMIService() != null) {
            ProximityEvent proximityEvent = new ProximityEvent(this.getKeyEventListener(n2), this.framework.getMonotonicTime(), n, n2);
            this.logChannel.log(1000000, "KeyBoardManagerImpl.fireProximityEvent: Sending event! [%1]", (Object)proximityEvent);
            return this.framework.getHMIService().getEventDispatcher().postEvent(proximityEvent);
        }
        return null;
    }

    public void setSDSService(SDSService sDSService) {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.keyInputListener[i2].setSDSService(sDSService);
        }
    }

    private ATIPEventListener getKeyEventListener(int n) {
        if (n < 0 || n > 8) {
            return null;
        }
        return this.keyInputListener[n];
    }
}

