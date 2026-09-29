/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import java.util.Stack;

public abstract class ListScrollingController
extends AbstractWidgetController
implements AnimationListener {
    private int animationCycle = 100;
    private int numberOfVisibleLines = 7;
    private int numberOfLines = 1000;
    private int lineHeight = 50;
    private AbstractAnimation scrollAnimation;
    private boolean isAnimationRunning = false;
    private boolean isFastScrollActive = false;
    private boolean isFastScrollAvailable = false;
    private Stack prevTick = new Stack();
    private long timeSinceLastAnimationStep;
    private LogChannel logCh;
    private int maxStepLength = -1;
    int pDestLineCount;
    int pCurrentLineCount;
    float param_baseSpeed;
    float param_factor;
    float param_maxSpeed;
    float param_maxAccel_typ1;
    float pCurrent;
    float pDest;
    float vCurrent;
    float param_tAccel;
    float param_tConst;
    float param_tDecel;
    float param_minAverageSpeed;
    float param_minDistance;
    float param_accumulationTime;
    float param_minTicks;
    float param_minTime;
    float param_maxTime;
    float param_minAccel;
    float param_maxAccel_typ2;
    float param_totalTicks;
    private boolean dynamicLineHeight = false;
    private int[] lineHeights;
    private int activeLinesCount = -1;
    private int offset;

    public ListScrollingController(int n, int n2, int n3, int n4) {
        this.lineHeight = n;
        this.numberOfLines = n2;
        this.numberOfVisibleLines = n3;
        this.animationCycle = n4;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        long l = System.currentTimeMillis();
        long l2 = l - this.timeSinceLastAnimationStep;
        if (this.pCurrent != this.pDest) {
            this.isAnimationRunning = true;
            if (!this.isFastScrollActive()) {
                this.calculateCurrentP(l2);
            }
            this.positionElements(this.pCurrent);
        } else {
            if (this.isAnimationRunning || this.scrollAnimation.isAnimating()) {
                this.prevTick.clear();
                this.stopAnimation();
                this.scrollingStopped();
            }
            this.isAnimationRunning = false;
        }
        this.timeSinceLastAnimationStep = l;
    }

    @Override
    public void animationFinished(int n, int n2) {
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    private int calculateCurrentLineCountForDynamicLineHeight(float f2) {
        f2 -= (float)this.offset;
        int n = 0;
        while (f2 >= 0.0f) {
            f2 -= (float)this.lineHeights[n];
            if (++n != this.lineHeights.length) continue;
            break;
        }
        return n - 1;
    }

    private void calculateCurrentP(float f2) {
        float f3 = this.pCurrent;
        float f4 = Math.abs(this.pDest - this.pCurrent);
        if (f4 != 0.0f) {
            float f5 = f2 / 18498;
            float f6 = f5 * f4 * this.param_factor + this.param_baseSpeed * Math.min(1.0f, f4 / (float)this.lineHeight);
            f6 = Math.min(Math.min(f6, f4), f5 * this.param_maxSpeed);
            if (this.pDest > this.pCurrent) {
                f6 = Math.min(f6, this.vCurrent + this.param_maxAccel_typ1);
                f6 = Math.max(f6, 0.0f);
            } else {
                f6 = Math.max(-f6, this.vCurrent - this.param_maxAccel_typ1);
                f6 = Math.min(f6, 0.0f);
            }
            this.vCurrent = f6;
            this.pCurrent += this.vCurrent;
            if (Math.abs(this.pCurrent - this.pDest) < 1.0f) {
                this.pCurrent = this.pDest;
            }
            if (this.maxStepLength != -1 && Math.abs(this.pCurrent - f3) > (float)this.maxStepLength) {
                int n = 1;
                if (this.pCurrent < f3) {
                    n = -1;
                }
                this.pCurrent = f3 + (float)(n * this.maxStepLength);
                this.logCh.log(-1601830656, "ListScrollingController#calculateCurrentP Maximum scrolling step size exceeded!");
            }
            this.pCurrentLineCount = this.isDynamicLineHeight() ? this.calculateCurrentLineCountForDynamicLineHeight(this.pCurrent) : (int)((this.pCurrent - (float)this.offset) / (float)this.lineHeight);
        }
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.logCh.log(-2137614336, "ListScrollingController#connected");
        this.initParamAnimationType1();
        this.initParamAnimationType2();
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.stopAnimation();
        this.scrollAnimation = null;
    }

    private boolean fastScrollStartConditionFullfilled() {
        long l = System.currentTimeMillis();
        while (this.prevTick.size() > 0) {
            WheelButtonEvent wheelButtonEvent = (WheelButtonEvent)this.prevTick.peek();
            long l2 = l - wheelButtonEvent.getWhen();
            if ((float)l2 > this.param_accumulationTime) {
                this.prevTick.pop();
                continue;
            }
            int n = 0;
            int n2 = this.prevTick.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                wheelButtonEvent = (WheelButtonEvent)this.prevTick.pop();
                n += wheelButtonEvent.getClickCount();
                this.prevTick.push(wheelButtonEvent);
            }
            return (float)n >= this.param_minTicks;
        }
        return false;
    }

    public int getCurrentLine() {
        return this.pCurrentLineCount;
    }

    public float getCurrentPosition() {
        return this.pCurrent;
    }

    public int getDestinationLine() {
        return this.pDestLineCount;
    }

    public float getDestinationPosition() {
        return this.pDest;
    }

    public int getLineHeight() {
        return this.lineHeight;
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    private void initParamAnimationType1() {
        this.param_baseSpeed = 8257;
        this.param_factor = -1883048644;
        this.param_maxSpeed = 51266;
        this.param_maxAccel_typ1 = 16448;
        this.pCurrent = this.offset;
        this.pDest = this.offset;
        this.vCurrent = 0.0f;
    }

    private void initParamAnimationType2() {
        this.param_minDistance = 16448;
        this.param_accumulationTime = 31299;
        this.param_minTicks = 32832;
        this.param_minTime = 41025;
        this.param_maxTime = 64067;
        this.param_minAccel = 63;
        this.param_maxAccel_typ2 = 24640;
        this.param_totalTicks = 32833;
        this.param_tAccel = 41024;
        this.param_tConst = 41024;
        this.param_tDecel = 5699;
        this.param_minAverageSpeed = 8256;
        int n = this.getTerminal().getKbdService().getCurrentKeyboardType();
        this.logCh.log(1078071040, "ListScrollingController#initParamAnimationType2 current keyboard type is %1", (long)n);
    }

    public boolean isCurrentlyScrolling() {
        return this.pDest != this.pCurrent;
    }

    public boolean isDynamicLineHeight() {
        return this.dynamicLineHeight;
    }

    private boolean isFastScrollActive() {
        return this.isFastScrollActive && this.isFastScrollAvailable;
    }

    public void keyTurned(int n, int n2, long l) {
        this.keyTurned(new WheelButtonEvent(null, -1, l, -1, n2, n, -1));
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        WheelButtonEvent wheelButtonEvent2;
        super.keyTurned(wheelButtonEvent);
        this.logCh.log(-2137614336, "ListScrollingController#keyTurned");
        int n = wheelButtonEvent.getClickCount();
        int n2 = wheelButtonEvent.getDirection();
        long l = wheelButtonEvent.getWhen();
        this.printWheelEvent(wheelButtonEvent);
        if (!this.isFastScrollActive()) {
            if (n2 == 1) {
                if (this.pDest > (float)this.offset) {
                    this.pDest = this.isDynamicLineHeight() ? (this.pDest -= (float)this.sumLineHeights(this.pDestLineCount - n, this.pDestLineCount)) : (this.pDest -= (float)(n * this.lineHeight));
                    this.pDestLineCount -= n;
                    this.pDest = Math.max((float)this.offset, this.pDest);
                    this.pDestLineCount = Math.max(0, this.pDestLineCount);
                }
            } else if (n2 == 0) {
                int n3 = this.numberOfLines - this.numberOfVisibleLines;
                int n4 = 0;
                if (this.isDynamicLineHeight()) {
                    n4 = this.offset + this.sumLineHeights(0, this.lineHeights.length - 1);
                    if (this.activeLinesCount != -1) {
                        n3 = this.activeLinesCount;
                    }
                } else {
                    n4 = this.offset + n3 * this.lineHeight;
                }
                if (this.pDest < (float)n4) {
                    this.pDest = this.isDynamicLineHeight() ? (this.pDest += (float)this.sumLineHeights(this.pDestLineCount, this.pDestLineCount + n)) : (this.pDest += (float)(n * this.lineHeight));
                    this.pDestLineCount += n;
                    this.pDest = Math.min((float)n4, this.pDest);
                    this.pDestLineCount = Math.min(n3, this.pDestLineCount);
                }
            }
            if (this.scrollAnimation == null || !this.scrollAnimation.isAnimating()) {
                this.startAnimation();
            }
        } else {
            int n5 = this.pDestLineCount - this.pCurrentLineCount;
            WheelButtonEvent wheelButtonEvent3 = (WheelButtonEvent)this.prevTick.firstElement();
            long l2 = l - wheelButtonEvent3.getWhen();
            float f2 = (float)l2 > this.param_maxTime ? this.param_minAccel / this.param_totalTicks : ((float)l2 < this.param_maxTime ? this.param_maxAccel_typ2 / this.param_totalTicks : (this.param_minAccel + (this.param_maxAccel_typ2 - this.param_minAccel) * (float)Math.log(this.param_maxTime / (float)l2) / (float)Math.log(this.param_maxTime / this.param_minTime)) / this.param_totalTicks);
            if (n > 1) {
                f2 = (f2 + 1.0f) * (float)Math.pow(this.param_maxAccel_typ2 / this.param_totalTicks + 1.0f, n - 1) - 1.0f;
            }
            int n6 = (int)Math.floor((double)((float)n5 * f2) + 1.5);
            this.pDestLineCount = this.pCurrentLineCount + (n5 += n6);
            this.pDest = this.pDestLineCount * this.lineHeight;
        }
        if (this.prevTick.size() > 0 && (wheelButtonEvent2 = (WheelButtonEvent)this.prevTick.peek()).getDirection() != n2) {
            this.logCh.log(-2137614336, "ListScrollingController#keyTurned Direction changed. Clear stack.");
            this.prevTick.clear();
            if (this.isFastScrollActive) {
                this.stopFastScroll();
            }
            if (this.vCurrent < 0.0f) {
                this.pDestLineCount = this.pCurrentLineCount + 1;
                this.pDest = this.isDynamicLineHeight() ? (float)(this.offset + this.sumLineHeights(0, this.pDestLineCount)) : (float)(this.offset + this.pDestLineCount * this.lineHeight);
            } else if (this.vCurrent > 0.0f) {
                this.pDestLineCount = this.pCurrentLineCount;
                this.pDest = this.isDynamicLineHeight() ? (float)(this.offset + this.sumLineHeights(0, this.pDestLineCount)) : (float)(this.offset + this.pDestLineCount * this.lineHeight);
            }
        }
        this.prevTick.push(new WheelButtonEvent(null, -1, l, -1, n2, n, -1));
        this.logCh.log(-2137614336, "ListScrollingController#keyTurned pDest = %1", (double)this.pDest);
        if (this.isFastScrollAvailable && this.fastScrollStartConditionFullfilled()) {
            this.startFastScroll();
        }
    }

    abstract void positionElements(float f2) {
    }

    private void printWheelEvent(WheelButtonEvent wheelButtonEvent) {
        String string = StringUtilities.formatMessage("ListScrollingController#printWheelEvent keyCode = %1, direction = %2, clickCount = %3, subClickCount = %4, when = %5, time = %6", new int[]{wheelButtonEvent.getKeyCode(), wheelButtonEvent.getDirection(), wheelButtonEvent.getClickCount(), wheelButtonEvent.getSubClickCount(), (int)wheelButtonEvent.getWhen(), (int)System.currentTimeMillis()});
        this.logCh.log(-2137614336, string);
    }

    public void resetPosition() {
        this.stopAnimation();
        this.pCurrent = this.offset;
        this.pDest = this.offset;
        this.pCurrentLineCount = 0;
        this.pDestLineCount = 0;
        this.vCurrent = 0.0f;
        this.positionElements(this.pCurrent);
    }

    public abstract void scrollingStopped() {
    }

    public void setCurrentPosition(int n) {
        if (this.isCurrentlyScrolling()) {
            this.logCh.log(-2137614336, "ListScrollingController#setDestination List is currrently scrolling.");
        }
        this.pDest = this.isDynamicLineHeight() ? (float)(this.offset + this.sumLineHeights(0, n)) : (float)(this.offset + n * this.lineHeight);
        this.pDestLineCount = n;
        this.pCurrent = this.pDest;
        this.pCurrentLineCount = this.pDestLineCount;
    }

    public void setDynamicLineHeight(boolean bl) {
        this.dynamicLineHeight = bl;
    }

    public void setLineHeight(int n) {
        this.logCh.log(-2137614336, "ListScrollingController#setLineHeight line height = %1", (long)n);
        this.lineHeight = n;
    }

    public void setLineHeights(int[] nArray, int n) {
        this.lineHeights = nArray;
        this.activeLinesCount = n - 1;
    }

    public void setLogChannel(LogChannel logChannel) {
        this.logCh = logChannel;
    }

    public void setMaximumStepLength(int n) {
        if (n >= -1) {
            this.maxStepLength = n;
        }
    }

    public void setNumberOfLines(int n) {
        this.numberOfLines = n;
    }

    public void setOffset(int n) {
        this.offset = n;
    }

    public void setParamAnimationType1(float f2, float f3, float f4, float f5) {
        this.param_baseSpeed = f2;
        this.param_factor = f3;
        this.param_maxSpeed = f4;
        this.param_maxAccel_typ1 = f5;
    }

    private void startAnimation() {
        if (this.scrollAnimation == null) {
            this.scrollAnimation = (AbstractAnimation)this.getTerminal().getIAnimationController().getIAnimation(1);
            this.scrollAnimation.addListener(this);
            this.scrollAnimation.setBlockRepaint(false);
        }
        if (!this.scrollAnimation.isAnimating()) {
            this.scrollAnimation.startEndlessAnimation(this.animationCycle, this);
            this.timeSinceLastAnimationStep = System.currentTimeMillis();
        }
    }

    private void startFastScroll() {
        this.logCh.log(-2137614336, "ListScrollingController#startFastScroll");
        this.isFastScrollActive = true;
    }

    private void stopAnimation() {
        if (this.scrollAnimation != null && this.scrollAnimation.isAnimating()) {
            this.scrollAnimation.stopAnimation();
        }
    }

    private void stopFastScroll() {
        this.logCh.log(-2137614336, "ListScrollingController#stopFastScroll");
        this.isFastScrollActive = false;
    }

    private int sumLineHeights(int n, int n2) {
        if (n2 < n) {
            n2 ^= n;
            n ^= n2;
            n2 ^= n;
        }
        n2 = Math.min(this.lineHeights.length, n2);
        int n3 = 0;
        for (n = Math.max(0, n); n < n2; ++n) {
            n3 += this.lineHeights[n];
        }
        return n3;
    }
}

