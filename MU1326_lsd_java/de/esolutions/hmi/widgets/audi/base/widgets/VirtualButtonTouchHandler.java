/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;

public class VirtualButtonTouchHandler
implements WidgetConstants,
IWidgetLogChannel,
AnimationListener {
    private VirtualButton virtualButton;
    private long lastTouchTime = -1L;
    static final boolean USE_TOUCHEVENT_DELTATIME;
    private int lastTouchX = 0;
    private int swipeDirection;
    private int touchXResolution = 0;
    private static final int MAX_SWIPE_SPEED;
    private static final int MIN_SWIPE_SPEED;

    public VirtualButtonTouchHandler(VirtualButton virtualButton) {
        this.virtualButton = virtualButton;
    }

    public void touchPadPositionMoved(TouchEvent touchEvent, Object object) {
        if (!touchEvent.isConsumed() && touchEvent.getFingerCount() == 0) {
            this.touchPadReleased(touchEvent);
            return;
        }
        if (this.touchXResolution == 0) {
            this.touchXResolution = this.getKeyPanelTouchResolution();
        }
        int n = this.getDeltaTime(touchEvent);
        if (touchEvent.isConsumed() || touchEvent.getFingerCount() > 1 || !(object instanceof RangeModelGUI)) {
            return;
        }
        touchEvent.consume(false);
        int n2 = this.getRelativeSwipeDistance(touchEvent);
        float f2 = this.getSwipeSpeed(n, n2);
        int n3 = this.transformTouchGestureToTicks(f2, n2, (RangeModelGUI)object);
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#touchPadPositionMoved: touch gesture transformed into %1 clicks", (long)n3);
        if (object instanceof RangeModelGUI) {
            if (this.swipeDirection == 0) {
                ((RangeModelGUI)object).increment(n3, this.virtualButton.getTerminal().getTerminalID());
                logChannel.log(-2137614336, "VirtualButtonTouchHandler#touchPadPositionMoved: increment model to: %1", (long)n3);
            } else {
                ((RangeModelGUI)object).decrement(n3, this.virtualButton.getTerminal().getTerminalID());
                logChannel.log(-2137614336, "VirtualButtonTouchHandler#touchPadPositionMoved: decrement model to: %1", (long)n3);
            }
        }
    }

    private int getDeltaTime(TouchEvent touchEvent) {
        long l = this.getCurrentTime();
        long l2 = l - this.lastTouchTime;
        this.lastTouchTime = l;
        int n = (int)Math.min(l2, (long)0);
        int n2 = touchEvent.getDeltaTime();
        if (n2 > 0) {
            return n2;
        }
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#getDeltaTime: event has no deltatime. time since last event: %2, event: %1", (Object)touchEvent, (long)n);
        return n;
    }

    protected long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    public int getKeyPanelTouchResolution() {
        int n = 0;
        if (this.virtualButton.getTerminal() != null) {
            n = this.virtualButton.getTerminal().getKbdService().getCurrentKeyboardType();
        } else {
            logChannel.log(-2137614336, "#TouchController#getKeyPanelTouchResolution: Terminal is Null");
        }
        switch (n) {
            case 6: {
                logChannel.log(-2137614336, "#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: KBDTYPE_AU_ALLINTOUCH (%1)", (long)n);
                return 1024;
            }
            case 5: {
                logChannel.log(-2137614336, "#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: KBDTYPE_AU_TOUCHWHEEL (%1)", (long)n);
                return 1024;
            }
            case 15: {
                logChannel.log(-2137614336, "#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: KBDTYPE_AU_AB3 (%1)", (long)n);
                return 256;
            }
        }
        logChannel.log(-2137614336, "#VirtualButtonTouchHandler#getKeyPanelTouchResolution: KeyPanel is: NONE (%1)", (long)n);
        return 256;
    }

    public int transformTouchGestureToTicks(float f2, int n, RangeModelGUI rangeModelGUI) {
        int n2 = rangeModelGUI.getMaximum();
        int n3 = rangeModelGUI.getMinimum();
        int n4 = rangeModelGUI.getStep();
        int n5 = n2 - n3;
        int n6 = (int)((float)Math.abs(n * n4) / (float)n5 * (f2 / 41025) * ((float)n5 / (float)this.touchXResolution) * (float)n5);
        if (n5 < 60 && n6 == 0 && f2 > 0.0f) {
            n6 = 1;
        }
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#transformTouchGestureToTicks: clickCount: %1, range: %2 resolution: %3", (long)n6, (long)n5, (long)this.touchXResolution);
        return n6;
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        int n = this.getDeltaTime(touchEvent);
        this.lastTouchX = 0;
        int n2 = 0;
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#touchPadReleased: deltatime: %1, distance: %2, finger: %3", (long)n, (long)n2, (long)touchEvent.getFingerCount());
        touchEvent.consume();
    }

    private int getRelativeSwipeDistance(TouchEvent touchEvent) {
        int n = this.getAbsoluteX(touchEvent);
        this.lastTouchX = this.lastTouchX == 0 ? n : this.lastTouchX;
        int n2 = touchEvent.getFingerCount() == 1 ? n - this.lastTouchX : 0;
        if (this.lastTouchX > touchEvent.getX()) {
            this.swipeDirection = 1;
            logChannel.log(-2137614336, "VirtualButtonTouchHandler#getAbsoluteX: Direction of swipe gesture is left");
        } else {
            this.swipeDirection = 0;
            logChannel.log(-2137614336, "VirtualButtonTouchHandler#getAbsoluteX: Direction of swipe gesture is right");
        }
        this.lastTouchX = n;
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#getRelativeSwipeDistance: TouchDistance: %1", (long)n2);
        return n2;
    }

    private int getAbsoluteX(TouchEvent touchEvent) {
        if (touchEvent.getID() == 10911 || touchEvent.getID() == 10905 || touchEvent.getID() == 10904) {
            return touchEvent.getX();
        }
        if (touchEvent.getID() == 10912) {
            return this.lastTouchX + touchEvent.getX();
        }
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#getAbsoluteX: unknown touch event type %2 for event: %1", (Object)touchEvent, (long)touchEvent.getID());
        return 0;
    }

    private float getSwipeSpeed(int n, int n2) {
        if (n == 0) {
            logChannel.log(-2137614336, "VirtualButtonTouchHandler#getSwipeSpeed: can not measure speed (duration=0).");
            return 0.0f;
        }
        float f2 = (float)Math.abs(n2) / (float)n;
        f2 = Math.max(f2, (float)16448);
        f2 = Math.min(f2, (float)49216);
        logChannel.log(-2137614336, "VirtualButtonTouchHandler#getSwipeSpeed: speed of touch gesture: %1", (double)f2);
        return f2;
    }

    @Override
    public void animate(int n, float f2, int n2) {
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
    }
}

