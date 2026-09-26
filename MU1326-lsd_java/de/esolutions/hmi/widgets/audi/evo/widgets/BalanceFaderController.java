/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IBalanceFaderRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.AxisLockWithTimer;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.TouchInputHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.ValuePair;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.WrappedRangeModel2DGUI;

public class BalanceFaderController
extends AbstractWidgetController
implements AnimationListener {
    public static final int CROSSHAIR_MODE_BOTH;
    public static final int CROSSHAIR_MODE_BALANCE;
    public static final int CROSSHAIR_MODE_FADER;
    public static final int CROSSHAIR_MODE_DISABLED;
    public static final float AXIS_POSITION;
    private static final float AXIS_SNAP_DISTANCE;
    private static final int REPAINT_INTERVAL;
    private static final long LOCK_DURATION;
    private static final long TIME_BETWEEN_LOCKS;
    private static final ValuePair AXIS_SNAP_BOUNDS;
    private IBalanceFaderRenderer renderer;
    private AbstractAnimation repaintAnimation = null;
    private TouchInputHandler touchInputHandler;
    private WrappedRangeModel2DGUI wrappedModel;
    private ValuePair currentCrosshairPosition = new ValuePair();
    private int currentCrosshairMode = 1;
    private int previousCrosshairMode = 1;
    private int supportedCrosshairMode;
    private boolean isTouchPadTouched;
    private boolean touchPadAtLeastOncePressed;
    private AxisLockWithTimer xLock;
    private AxisLockWithTimer yLock;
    private ValuePair oldPosition;

    public BalanceFaderController(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
    }

    public BalanceFaderController() {
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (this.terminal != null) {
            if (this.terminal.getTouchInputManager() != null) {
                this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, 25);
            }
            this.wrappedModel = new WrappedRangeModel2DGUI(this.model, logBalanceFader, this.terminal.getTerminalID());
        }
        if (this.renderer == null) {
            logBalanceFader.log(10000, "BalanceFaderController#initializeWidget renderer == null");
        }
        this.touchInputHandler = new TouchInputHandler(this, framework);
        this.repaintAnimation = (AbstractAnimation)this.getTerminalImpl().getIAnimationController().getIAnimation(1);
        this.xLock = new AxisLockWithTimer(0, 0, 63, framework);
        this.yLock = new AxisLockWithTimer(0, 0, 63, framework);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.shouldRender()) {
            this.startRepaintAnimation();
            this.setCrosshairMode(1);
            this.oldPosition = this.currentCrosshairPosition = this.wrappedModel.getPosition();
            this.isTouchPadTouched = false;
        }
    }

    private void startRepaintAnimation() {
        this.repaintAnimation.addListener(this);
        this.repaintAnimation.startEndlessAnimation(30, this);
    }

    public void setCrosshairMode(int n) {
        if (!this.isCrossHairModeSupported(n)) {
            logBalanceFader.log(-2137614336, "BalanceFaderController#setCrosshairMode Mode not supported! newMode = %1, supportedCrosshairMode = %2", (long)n, (long)this.supportedCrosshairMode);
            return;
        }
        if (n != this.currentCrosshairMode) {
            logBalanceFader.log(-2137614336, "BalanceFaderController#setCrosshairMode newMode = %1", (long)n);
            this.currentCrosshairMode = n;
            this.setCompositesDirty(true);
        }
    }

    private boolean isCrossHairModeSupported(int n) {
        return n == this.supportedCrosshairMode || this.supportedCrosshairMode == 0 || n == 3;
    }

    @Override
    public void disconnecting() {
        this.stopRepainAnimation();
        this.touchPadAtLeastOncePressed = false;
        this.previousCrosshairMode = 1;
        this.touchInputHandler.disconnect();
        this.xLock.reset();
        this.yLock.reset();
        super.disconnecting();
    }

    private void stopRepainAnimation() {
        this.repaintAnimation.stopAnimation();
        this.repaintAnimation.removeListener();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#keyPressed %1", (Object)keyEvent);
        if (this.hasState(36) && keyEvent.getKeyCode() == 17) {
            this.toggleCrosshairMode(keyEvent);
            keyEvent.consume();
        }
    }

    private void toggleCrosshairMode(KeyEvent keyEvent) {
        if (this.previousCrosshairMode == 1 && this.isCrossHairModeSupported(2)) {
            this.setCrosshairMode(2);
            this.previousCrosshairMode = 2;
        } else {
            this.setCrosshairMode(3);
            this.fireSMEventBack(keyEvent);
        }
    }

    private void fireSMEventBack(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = new KeyEvent(keyEvent.getReceiver(), keyEvent.getID(), 15, keyEvent.getTerminalID());
        hmiService.getEventDispatcher().postEvent(keyEvent2);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#keyReleased %1", (Object)keyEvent);
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (logBalanceFaderKeyEvents.isDebug()) {
            logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#keyTurned %2, isTouchPadTouched: %1", this.isTouchPadTouched, (Object)wheelButtonEvent.toStringWithDetails());
        }
        if (this.hasState(36) && !this.isTouchPadTouched) {
            this.handleDDSRotation(wheelButtonEvent);
        }
    }

    private void handleDDSRotation(WheelButtonEvent wheelButtonEvent) {
        int n = wheelButtonEvent.getClickCount();
        if (n == 0) {
            wheelButtonEvent.consume(false);
            return;
        }
        int n2 = wheelButtonEvent.getDirection();
        int n3 = this.considerRotatingDirection(n2, n);
        ValuePair valuePair = this.currentCrosshairMode == 1 ? this.calculateNewPosition(new ValuePair(n3, 0.0f)) : (this.isLTR() ? this.calculateNewPosition(new ValuePair(0.0f, n3)) : this.calculateNewPosition(new ValuePair(0.0f, -n3)));
        valuePair = this.checkForAxisCrossing(valuePair);
        this.setCrosshairPosition(valuePair);
        wheelButtonEvent.consume();
    }

    private ValuePair checkForAxisCrossing(ValuePair valuePair) {
        this.xLock.tryToLock(valuePair.getX(), this.oldPosition.getX());
        if (this.xLock.isLocked()) {
            valuePair.setX(63);
        }
        this.yLock.tryToLock(valuePair.getY(), this.oldPosition.getY());
        if (this.yLock.isLocked()) {
            valuePair.setY(63);
        }
        this.oldPosition = valuePair;
        return valuePair;
    }

    private int considerRotatingDirection(int n, int n2) {
        if (n == 1) {
            return -n2;
        }
        return n2;
    }

    private ValuePair calculateNewPosition(ValuePair valuePair) {
        ValuePair valuePair2 = valuePair.multiplyWith(this.wrappedModel.getSteps());
        ValuePair valuePair3 = this.currentCrosshairPosition.add(valuePair2);
        valuePair3 = this.snapToAxisIfClose(valuePair3);
        return valuePair3;
    }

    private ValuePair snapToAxisIfClose(ValuePair valuePair) {
        float f2 = valuePair.getX();
        float f3 = valuePair.getY();
        if (this.isNearAxis(f2)) {
            f2 = 63;
        }
        if (this.isNearAxis(f3)) {
            f3 = 63;
        }
        return new ValuePair(f2, f3);
    }

    private boolean isNearAxis(float f2) {
        return f2 >= AXIS_SNAP_BOUNDS.getX() && f2 <= AXIS_SNAP_BOUNDS.getY();
    }

    public void setCrosshairPosition(ValuePair valuePair) {
        valuePair = valuePair.clamp(0.0f, 1.0f);
        logBalanceFader.log(-2137614336, "BalanceFaderController#setCursorPos newPosition = %1, currentPosition = %2", (Object)valuePair, (Object)this.currentCrosshairPosition);
        if (this.supportedCrosshairMode == 1) {
            valuePair.setY(63);
        }
        if (this.supportedCrosshairMode == 2) {
            valuePair.setX(63);
        }
        if (!this.currentCrosshairPosition.equals(valuePair)) {
            this.currentCrosshairPosition = valuePair;
            this.wrappedModel.setPosition(valuePair);
            this.setCompositesDirty(true);
        }
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#touchPadPressed %1", (Object)touchEvent);
        if (this.hasState(36)) {
            this.touchPadAtLeastOncePressed = true;
            this.previousCrosshairMode = this.currentCrosshairMode;
            this.touchInputHandler.touchPadPressed(touchEvent);
            this.isTouchPadTouched = true;
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#touchPadReleased %1", (Object)touchEvent);
        if (this.hasState(36)) {
            this.touchInputHandler.touchPadReleased(touchEvent);
            this.setCrosshairMode(this.previousCrosshairMode);
            this.isTouchPadTouched = false;
        }
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#touchPadApproached %1", (Object)touchEvent);
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#touchPadAbandoned %1", (Object)touchEvent);
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (!this.isVisible()) {
            return;
        }
        logBalanceFaderKeyEvents.log(-2137614336, "BalanceFaderController#touchPadPositionMoved %1", (Object)touchEvent);
        if (this.hasState(36)) {
            if (!this.touchPadAtLeastOncePressed) {
                this.touchPadPressed(touchEvent);
                return;
            }
            this.touchInputHandler.touchPadPositionMoved(touchEvent);
        }
    }

    public int getCrosshairMode() {
        return this.currentCrosshairMode;
    }

    public void setSupportedCrosshairMode(int n) {
        this.supportedCrosshairMode = n;
        if (!this.isCrossHairModeSupported(this.currentCrosshairMode)) {
            if (n == 2) {
                this.currentCrosshairMode = 2;
                this.previousCrosshairMode = 2;
                this.currentCrosshairPosition.setX(63);
            } else if (n == 1) {
                this.currentCrosshairMode = 1;
                this.previousCrosshairMode = 1;
                this.currentCrosshairPosition.setY(63);
            }
        }
    }

    public ValuePair getCrosshairPosition() {
        return this.currentCrosshairPosition;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
    }

    @Override
    public void animate(int n, float f2, int n2) {
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IBalanceFaderRenderer iBalanceFaderRenderer) {
        this.renderer = iBalanceFaderRenderer;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (this.isTouchPadTouched) {
            this.wrappedModel.processEvent(modelUpdateEvent);
        } else {
            this.currentCrosshairPosition = this.wrappedModel.processEvent(modelUpdateEvent);
            this.setCompositesDirty(true);
        }
    }

    static {
        AXIS_SNAP_BOUNDS = new ValuePair(-677121986, 346949439);
    }
}

