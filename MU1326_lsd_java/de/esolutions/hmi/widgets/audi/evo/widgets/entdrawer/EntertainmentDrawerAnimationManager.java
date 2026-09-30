/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.tghu.hmi.evo.IDrawer;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerAnimationState;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerEventType;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerState;

public class EntertainmentDrawerAnimationManager
implements AnimationListener,
EntertainmentDrawerEventType,
WidgetConstants {
    private boolean isDelayForDeblacklistingActive = false;
    private final int ANIMATION_TYPE;
    private final float START_ANIMATION;
    private final float END_ANIMATION;
    private AbstractAnimation animation;
    public static final int ANIMATION_TYPE_DRAWER_GLOBAL = 100;
    public static final int ANIMATION_TYPE_DRAWER_LOCAL = 200;
    private int animationSource;
    private EntertainmentDrawerOpenCloseController entertainmentDrawer;
    private EntertainmentDrawerState sourceState;
    private EntertainmentDrawerState currentState;
    private EntertainmentDrawerState targetState;
    private float progress;
    private HMITerminalImpl terminal;
    private boolean globalAnimationIsAnimating;

    public EntertainmentDrawerAnimationManager(EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController) {
        this.ANIMATION_TYPE = 58;
        this.START_ANIMATION = 0.0f;
        this.END_ANIMATION = 1000.0f;
        this.entertainmentDrawer = entertainmentDrawerOpenCloseController;
        this.terminal = entertainmentDrawerOpenCloseController.getTerminalImpl();
        this.animation = (AbstractAnimation)this.terminal.getIAnimationController().getIAnimation(58);
        this.animation.addListener(this);
    }

    public void processAnimation(int n, float f2, int n2) {
        if (this.isDelayForDeblacklistingActive && n2 != 3) {
            IWidgetLogChannel.logEntertainmentDrawer.log(1000000, "No animation because of blacklisting timer");
            return;
        }
        if (this.animation.isAnimating()) {
            if (n == 200) {
                IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#processAnimation: local animation running, new local animation requested");
                boolean bl = this.updateAnimationStates();
                if (bl) {
                    IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#processAnimation: stop local animation, start new local animation");
                    this.stopAnimation();
                    this.startAnimation();
                }
            }
        } else if (this.globalAnimationIsAnimating) {
            if (n == 100) {
                IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#processAnimation: global animation running, global animation processing");
                this.animationSource = 100;
                this.globalAnimationIsAnimating = true;
                this.animate(-1, f2, -1);
            }
        } else if (n == 200) {
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#processAnimation: no animation running, start local animation");
            this.startAnimation();
        } else if (n == 100) {
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#processAnimation: no animation running, global animation processing");
            this.animationSource = 100;
            this.globalAnimationIsAnimating = true;
            this.animate(-1, f2, -1);
        }
        this.updateMainArea();
    }

    public void startAnimation() {
        this.animationSource = 200;
        this.animation.startDynamicAnimation(0.0f, 1000.0f, 58, true, this.entertainmentDrawer);
    }

    public void stopAnimation() {
        this.animation.stopAnimation();
    }

    public boolean updateAnimationStates() {
        this.entertainmentDrawer.updateTargetState();
        EntertainmentDrawerAnimationState entertainmentDrawerAnimationState = this.entertainmentDrawer.getAnimationStates();
        boolean bl = false;
        if (entertainmentDrawerAnimationState.getTargetState() != null) {
            this.sourceState = entertainmentDrawerAnimationState.getSourceState();
            this.currentState = entertainmentDrawerAnimationState.getCurrentState();
            if (this.targetState == null || !this.targetState.equals(entertainmentDrawerAnimationState.getTargetState())) {
                this.targetState = new EntertainmentDrawerState(entertainmentDrawerAnimationState.getTargetState());
                bl = true;
                IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateAnimationStates target has changed");
            }
        }
        return bl;
    }

    public void animate(int n, float f2, int n2) {
        this.updateAnimationStates();
        if (this.currentState != null && this.sourceState != null && this.targetState != null) {
            this.progress = this.animationSource == 200 ? f2 / 1000.0f : f2;
            this.updateContent();
            this.updateGapWidth();
            this.updateGapHeight();
            this.updateHeight();
            if (this.currentState.getYTranslation() + (float)this.currentState.getYScreenOffset() != this.targetState.getYTranslation() + (float)this.targetState.getYScreenOffset()) {
                this.updateYScreenOffset();
                this.updateYTranslation();
            }
            this.entertainmentDrawer.invalidate();
        }
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
    }

    private void updateYTranslation() {
        if (this.sourceState.getYTranslation() != this.targetState.getYTranslation()) {
            float f2 = this.sourceState.getYTranslation();
            float f3 = this.targetState.getYTranslation();
            float f4 = f3 - f2;
            float f5 = this.progress;
            float f6 = f2 + f4 * f5;
            this.currentState.setYTranslation((int)f6);
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateYTranslation: S=%1 --> C=%2 --> T=%3", (double)f2, (double)f6, (double)f3);
        }
    }

    private void updateYScreenOffset() {
        if (this.sourceState.getYScreenOffset() != this.targetState.getYScreenOffset()) {
            float f2 = this.sourceState.getYScreenOffset();
            float f3 = this.targetState.getYScreenOffset();
            float f4 = f3 - f2;
            float f5 = this.progress;
            float f6 = f2 + f4 * f5;
            this.currentState.setYScreenOffset((int)f6);
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateYScreenOffset: S=%1 --> C=%2 --> T=%3", (double)f2, (double)f6, (double)f3);
        }
    }

    private void updateHeight() {
        IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateHeight: C=%1 --> T=%2", (long)this.currentState.getHeight(), (long)this.targetState.getHeight());
        this.currentState.setHeight(this.targetState.getHeight());
    }

    private void updateGapWidth() {
        if (this.currentState != null && this.targetState != null) {
            float f2 = this.currentState.getWidth();
            float f3 = this.targetState.getWidth();
            float f4 = f3 - f2;
            float f5 = f2 + this.progress * f4;
            this.currentState.setWidth((int)f5);
            IStatusbarGapEventHandler iStatusbarGapEventHandler = this.entertainmentDrawer.getStatusbarGapEventHandler();
            if (iStatusbarGapEventHandler != null) {
                iStatusbarGapEventHandler.setGapWidth((int)f5, true);
            }
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateGapWidth: S=%1 --> C=%2 --> T=%3", (double)f2, (double)f5, (double)f3);
        }
    }

    private void updateGapHeight() {
        if (this.currentState.getGapHeight() != this.targetState.getGapHeight() && this.targetState.getGapHeight() != this.sourceState.getGapHeight()) {
            if (this.targetState.getGapHeight() == 0.0f) {
                this.currentState.setGapHeight(1.0f - this.progress);
                IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateGapHeight: S=%1 --> C=%2 --> T=%3", (double)this.sourceState.getGapHeight(), (double)this.currentState.getGapHeight(), (double)this.targetState.getGapHeight());
            } else if (this.targetState.getGapHeight() == 1.0f) {
                this.currentState.setGapHeight(this.progress);
                IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateGapHeight: S=%1 --> C=%2 --> T=%3", (double)this.sourceState.getGapHeight(), (double)this.currentState.getGapHeight(), (double)this.targetState.getGapHeight());
            }
        }
    }

    public void updateContent() {
        if (this.currentState != null && this.targetState != null) {
            Buffer buffer = new Buffer();
            this.currentState.setContent(this.targetState.getContent());
            buffer.append("\naudioSource:\t\t\t\t\t\t" + this.currentState.getAudioSource() + " --> " + this.targetState.getAudioSource());
            this.currentState.setAudioSource(this.targetState.getAudioSource());
            buffer.append("\nanimationDrawerState:\t\t\t\t" + this.currentState.isAnimateDrawerStateChange() + " --> " + this.targetState.isAnimateDrawerStateChange());
            this.currentState.setAnimateDrawerStateChange(this.targetState.isAnimateDrawerStateChange());
            buffer.append("\ndrawerState:\t\t\t\t\t\t" + AnimUtils.valueToString(this.currentState.getDrawerState(), IDrawer.DRAWER_STATE_TO_STRING) + " --> " + AnimUtils.valueToString(this.targetState.getDrawerState(), IDrawer.DRAWER_STATE_TO_STRING));
            this.currentState.setDrawerState(this.targetState.getDrawerState());
            buffer.append("\nvisible:\t\t\t\t\t\t\t" + this.currentState.isVisible() + " --> " + this.targetState.isVisible());
            this.currentState.setVisible(this.targetState.isVisible());
            buffer.append("\nopacity:\t\t\t\t\t\t\t" + this.currentState.getOpacity() + " --> " + this.targetState.getOpacity());
            this.currentState.setOpacity(this.targetState.getOpacity());
            buffer.append("\nED onScreen:\t\t\t\t\t\t" + this.entertainmentDrawer.isOnScreen() + " --> " + this.targetState.isVisible());
            this.entertainmentDrawer.setOnScreen(this.targetState.isVisible());
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateContent:%1\n", (Object)buffer.toString());
            if (this.currentState.getContent() != null && this.currentState.getContent().isConnected() && this.currentState.getContent().getDisplayDrawerState() != this.currentState.getDrawerState()) {
                this.currentState.getContent().setDisplayDrawerState(this.currentState.getDrawerState(), this.currentState.isAnimateDrawerStateChange(), true);
            }
        }
    }

    public void updateMainArea() {
        if (this.targetState != null && this.sourceState != null) {
            int n;
            DrawerFocusManager drawerFocusManager = (DrawerFocusManager)this.terminal.getDrawerFocusManager();
            int n2 = -1;
            EntertainmentDrawerContentController entertainmentDrawerContentController = this.targetState.getContent();
            if (entertainmentDrawerContentController != null && EntertainmentDrawerContentManager.isDefaultAudioSource(entertainmentDrawerContentController.getAudioSource())) {
                n2 = 16;
            } else {
                n = this.targetState.getDrawerState();
                int n3 = this.sourceState.getDrawerState();
                IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateMainArea target ED state: %1, current ED state: %2", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING), (Object)AnimUtils.valueToString(n3, IDrawer.DRAWER_STATE_TO_STRING));
                switch (n) {
                    case 0: {
                        if (n3 == 0) break;
                        n2 = 32;
                        break;
                    }
                    case 1: {
                        if (n3 != 0) break;
                        n2 = 16;
                        break;
                    }
                    case 6: {
                        if (n3 != 0) break;
                        n2 = 16;
                        break;
                    }
                    case 2: {
                        if (n3 != 0) break;
                        n2 = 16;
                        break;
                    }
                    default: {
                        IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(100000, "EntertainmentDrawerAnimationManager#updateMainArea untreated targetDrawerState: %1", (long)n);
                    }
                }
            }
            if (n2 != -1) {
                n = drawerFocusManager.getDrawerState();
                if (IWidgetLogChannel.logEntertainmentDrawerAnimationManager.isDebug()) {
                    IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerAnimationManager#updateMainArea request drawer state from DrawerFocusManager: %1, currentDrawerState: %2", (Object)DrawerFocusManager.getStateName(n2), (Object)DrawerFocusManager.getStateName(n));
                }
                if (n2 == 16 && n != 32) {
                    IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(100000, "EntertainmentDrawerAnimationManager#updateMainArea not requesting STATE_MAIN_AREA, because state is no longer STATE_ENTERTAINMENT_MENU");
                } else {
                    drawerFocusManager.requestDrawerState(n2);
                }
            }
        }
    }

    public void setGlobalAnimationIsAnimating(boolean bl) {
        this.globalAnimationIsAnimating = bl;
    }

    public void setDelayForDeblacklistingActive(boolean bl) {
        this.isDelayForDeblacklistingActive = bl;
    }

    public boolean getDelayForDeblacklistingActive() {
        return this.isDelayForDeblacklistingActive;
    }
}

