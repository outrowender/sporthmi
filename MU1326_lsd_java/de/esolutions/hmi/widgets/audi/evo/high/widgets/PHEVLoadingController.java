/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PHEVLoadingRedererHigh;

public class PHEVLoadingController
extends AbstractWidgetController
implements AnimationListener {
    private PHEVLoadingRedererHigh renderer;
    private float phevDriveState;
    private float phevWheelsDirection;
    private float phevBatteryState;
    private float phevBatteryLevel;
    private float phevCableColor;
    private float phevCablePlugState;
    private float phevPlugAnimation;
    private float blinkAnimationStateGreen;
    private float blinkAnimationStateYellow;
    private float blinkAnimationStateRed;
    private float pulseAnimationStateGreen;
    private float pulseAnimationStateYellow;
    private float pulseAnimationStateRed;
    private float animationColor;
    private int phevClimateState;
    private int layoutX = 0;
    private int layoutY = 0;
    private int arabicXOffset = 0;
    private ModelStubController modelstubBatteryLevel;
    private ModelStubController modelstubBatteryState;
    private ModelStubController modelstubPlugState;
    private ModelStubController modelstubPlugColor;
    private ModelStubController modelstubPlugAnimation;
    private ModelStubController modelstubClimateState;
    private int mode = 0;
    private static final int ANIMATION_TYPE = 1;
    private static final int ANIMATE_INTERVAL = 100;
    private static final float ANIMATION_STEP_CHARGING = 0.025f;
    private static final float INITIAL_VALUE = 0.0f;
    private static final float MAX_ANIMATION_LIMIT = 1.0f;
    private static final float MAX_VALUE_GREEN_CABLE = 1.0f;
    private static final float MAX_VALUE_YELLOW_CABLE = 3.0f;
    private static final float MAX_VALUE_RED_CABLE = 5.0f;
    private static final float MID_VALUE_GREEN_CABLE = 0.5f;
    private static final float MID_VALUE_YELLOW_CABLE = 2.5f;
    private static final float MID_VALUE_RED_CABLE = 4.5f;
    private static final float INITIAL_VALUE_GREEN_CABLE = 0.0f;
    private static final float INITIAL_VALUE_YELLOW_CABLE = 2.0f;
    private static final float INITIAL_VALUE_RED_CABLE = 4.0f;
    private static final float BATTERY_SEGMENTS = 8.0f;
    private static final int PLUG_ANIMATION_OFF_OR_PERMANENT = 0;
    private static final int PLUG_ANIMATION_BLINK = 1;
    private static final int PLUG_ANIMATION_PULSE = 2;
    private static final int PLUG_ANIMATION_FLASH = 3;
    private static final int PLUG_ANIMATION_COLOR_GREEN = 1;
    private static final int PLUG_ANIMATION_COLOR_YELLOW = 2;
    private static final int PLUG_ANIMATION_COLOR_RED = 3;
    private static final float PLUG_ANIMATION_STEP_LONG = 0.03f;
    private static final float PLUG_ANIMATION_STEP_SHORT = 0.1f;
    private static final int MINIMUM_BATTERY_LEVEL = 1;
    private static final int VALUE_BATTERY_INACTIVE = 0;
    private static final int VALUE_BATTERY_NO_CURRENT = 1;
    private static final int VALUE_BATTERY_CHARGING = 2;
    private AbstractAnimation animation;
    private boolean isAnimating = false;

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateModelValue();
    }

    public void add(AbstractWidget abstractWidget) {
        if (!(abstractWidget instanceof ModelStubController)) {
            return;
        }
        super.add(abstractWidget);
        if (this.modelstubBatteryLevel == null) {
            this.modelstubBatteryLevel = (ModelStubController)abstractWidget;
            return;
        }
        if (this.modelstubBatteryState == null) {
            this.modelstubBatteryState = (ModelStubController)abstractWidget;
            return;
        }
        if (this.modelstubPlugState == null) {
            this.modelstubPlugState = (ModelStubController)abstractWidget;
            return;
        }
        if (this.modelstubPlugColor == null) {
            this.modelstubPlugColor = (ModelStubController)abstractWidget;
            return;
        }
        if (this.modelstubPlugAnimation == null) {
            this.modelstubPlugAnimation = (ModelStubController)abstractWidget;
            return;
        }
        if (this.modelstubClimateState == null) {
            this.modelstubClimateState = (ModelStubController)abstractWidget;
            return;
        }
    }

    private void updateModelValue() {
        int n;
        ChoiceModelGUI choiceModelGUI;
        if (this.modelstubBatteryState != null) {
            choiceModelGUI = (ChoiceModelGUI)this.modelstubBatteryState.getModel();
            this.phevBatteryState = choiceModelGUI.getValue();
        }
        if (this.modelstubBatteryLevel != null) {
            choiceModelGUI = (ChoiceModelGUI)this.modelstubBatteryLevel.getModel();
            this.phevBatteryLevel = choiceModelGUI.getValue();
            if (this.phevBatteryLevel >= 1.0f) {
                this.phevBatteryLevel = (this.phevBatteryLevel - 1.0f) / 8.0f;
            } else if (this.phevBatteryLevel < 1.0f && this.phevBatteryState != 2.0f) {
                this.phevBatteryState = 0.0f;
            }
        }
        if (this.modelstubPlugState != null) {
            choiceModelGUI = (ChoiceModelGUI)this.modelstubPlugState.getModel();
            n = choiceModelGUI.getValue();
            switch (n) {
                case 0: {
                    this.phevCablePlugState = 1.0f;
                    break;
                }
                case 1: {
                    this.phevCablePlugState = 2.0f;
                    break;
                }
                default: {
                    this.phevCablePlugState = 0.0f;
                }
            }
        }
        if (this.modelstubPlugColor != null) {
            choiceModelGUI = (ChoiceModelGUI)this.modelstubPlugColor.getModel();
            this.animationColor = this.phevCableColor = (float)choiceModelGUI.getValue();
        }
        if (this.modelstubPlugAnimation != null) {
            choiceModelGUI = (ChoiceModelGUI)this.modelstubPlugAnimation.getModel();
            this.phevPlugAnimation = choiceModelGUI.getValue();
        }
        if (this.modelstubClimateState != null) {
            choiceModelGUI = (ChoiceModelGUI)this.modelstubClimateState.getModel();
            this.phevClimateState = n = choiceModelGUI.getValue();
        }
        if (this.animation == null) {
            this.createAnimation();
            if (this.animation == null) {
                return;
            }
        }
        if (this.isAnimating) {
            this.animation.stopAnimation();
            this.isAnimating = false;
        }
        if (this.phevPlugAnimation == 0.0f) {
            if (this.phevCableColor == 2.0f) {
                this.phevCableColor = 3.0f;
            } else if (this.phevCableColor == 3.0f) {
                this.phevCableColor = 5.0f;
            }
        }
        if (this.phevPlugAnimation > 0.0f || this.phevBatteryState == 2.0f) {
            this.animation.startEndlessAnimation(100, this);
            this.isAnimating = true;
        }
        this.setCompositesDirty(true);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateModelValue();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void createAnimation() {
        if (this.terminal != null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.animation = (AbstractAnimation)abstractAnimationController.getIAnimation(1);
            this.animation.addListener(this);
        }
    }

    public void animate(int n, float f2, int n2) {
        if (this.phevBatteryState == 2.0f) {
            if (this.phevBatteryLevel > 1.0f) {
                this.phevBatteryLevel = 0.0f;
            }
            this.phevBatteryLevel += 0.025f;
        }
        if (this.phevPlugAnimation == 3.0f) {
            this.startPlugAnimationFlash();
        }
        if (this.phevPlugAnimation == 2.0f) {
            this.startPlugAnimationPluse();
        }
        if (this.phevPlugAnimation == 1.0f) {
            this.startPlugAnimationBlink();
        }
        this.setCompositesDirty(true);
    }

    private void startPlugAnimationFlash() {
        if (this.animationColor == 1.0f) {
            this.phevCableColor = this.animationColor;
            if (this.blinkAnimationStateGreen > 1.0f) {
                this.blinkAnimationStateGreen = 0.0f;
            }
            if (this.blinkAnimationStateGreen >= 0.5f) {
                this.phevCableColor = 0.0f;
            }
            this.blinkAnimationStateGreen += 0.03f;
        }
        if (this.animationColor == 2.0f) {
            this.phevCableColor = 3.0f;
            if (this.blinkAnimationStateYellow > 3.0f) {
                this.blinkAnimationStateYellow = 2.0f;
            }
            if (this.blinkAnimationStateYellow >= 2.5f) {
                this.phevCableColor = 2.0f;
            }
            this.blinkAnimationStateYellow += 0.03f;
        }
        if (this.animationColor == 3.0f) {
            this.phevCableColor = 5.0f;
            if (this.blinkAnimationStateRed > 5.0f) {
                this.blinkAnimationStateRed = 4.0f;
            }
            if (this.blinkAnimationStateRed >= 4.5f) {
                this.phevCableColor = 4.0f;
            }
            this.blinkAnimationStateRed += 0.03f;
        }
    }

    private void startPlugAnimationPluse() {
        if (this.animationColor == 1.0f) {
            this.phevCableColor = 0.0f;
            if (this.blinkAnimationStateGreen > 1.0f) {
                this.pulseAnimationStateGreen = 1.0f;
            }
            if (this.blinkAnimationStateGreen <= 0.0f) {
                this.pulseAnimationStateGreen = 0.0f;
            }
            this.blinkAnimationStateGreen = this.pulseAnimationStateGreen == 0.0f ? (this.blinkAnimationStateGreen += 0.1f) : (this.blinkAnimationStateGreen -= 0.1f);
            this.phevCableColor = this.blinkAnimationStateGreen;
        }
        if (this.animationColor == 2.0f) {
            this.phevCableColor = 2.0f;
            if (this.blinkAnimationStateYellow > 3.0f) {
                this.pulseAnimationStateYellow = 3.0f;
            }
            if (this.blinkAnimationStateYellow <= 2.0f) {
                this.pulseAnimationStateYellow = 2.0f;
            }
            this.blinkAnimationStateYellow = this.pulseAnimationStateYellow == 2.0f ? (this.blinkAnimationStateYellow += 0.1f) : (this.blinkAnimationStateYellow -= 0.1f);
            this.phevCableColor = this.blinkAnimationStateYellow;
        }
        if (this.animationColor == 3.0f) {
            this.phevCableColor = 4.0f;
            if (this.blinkAnimationStateRed > 5.0f) {
                this.pulseAnimationStateRed = 5.0f;
            }
            if (this.blinkAnimationStateRed <= 4.0f) {
                this.pulseAnimationStateRed = 4.0f;
            }
            this.blinkAnimationStateRed = this.pulseAnimationStateRed == 4.0f ? (this.blinkAnimationStateRed += 0.1f) : (this.blinkAnimationStateRed -= 0.1f);
            this.phevCableColor = this.blinkAnimationStateRed;
        }
    }

    private void startPlugAnimationBlink() {
        if (this.animationColor == 1.0f) {
            this.phevCableColor = this.animationColor;
            if (this.blinkAnimationStateGreen > 1.0f) {
                this.blinkAnimationStateGreen = 0.0f;
            }
            if (this.blinkAnimationStateGreen >= 0.5f) {
                this.phevCableColor = 0.0f;
            }
            this.blinkAnimationStateGreen += 0.1f;
        }
        if (this.animationColor == 2.0f) {
            this.phevCableColor = 3.0f;
            if (this.blinkAnimationStateYellow > 3.0f) {
                this.blinkAnimationStateYellow = 2.0f;
            }
            if (this.blinkAnimationStateYellow >= 2.5f) {
                this.phevCableColor = 2.0f;
            }
            this.blinkAnimationStateYellow += 0.1f;
        }
        if (this.animationColor == 3.0f) {
            this.phevCableColor = 5.0f;
            if (this.blinkAnimationStateRed > 5.0f) {
                this.blinkAnimationStateRed = 4.0f;
            }
            if (this.blinkAnimationStateRed >= 4.5f) {
                this.phevCableColor = 4.0f;
            }
            this.blinkAnimationStateRed += 0.1f;
        }
    }

    public void disconnecting() {
        super.disconnecting();
    }

    public void setRenderer(PHEVLoadingRedererHigh pHEVLoadingRedererHigh) {
        this.renderer = pHEVLoadingRedererHigh;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public float getPhevDriveState() {
        return this.phevDriveState;
    }

    public float getPhevWheelsDirection() {
        return this.phevWheelsDirection;
    }

    public float getPhevBatteryState() {
        return this.phevBatteryState;
    }

    public float getPhevBatteryLevel() {
        return this.phevBatteryLevel;
    }

    public void setX(int n) {
        this.layoutX = n;
    }

    public int getX() {
        return this.layoutX;
    }

    public void setY(int n) {
        this.layoutY = n;
    }

    public int getY() {
        return this.layoutY;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
    }

    public float getPhevCableColor() {
        return this.phevCableColor;
    }

    public void setPhevCableColor(float f2) {
        this.phevCableColor = f2;
    }

    public float getPhevCablePlugState() {
        return this.phevCablePlugState;
    }

    public void setPhevCablePlugState(float f2) {
        this.phevCablePlugState = f2;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int n) {
        this.mode = n;
    }

    public float getPhevPlugAnimation() {
        return this.phevPlugAnimation;
    }

    public void setPhevPlugAnimation(float f2) {
        this.phevPlugAnimation = f2;
    }

    public int getClimateState() {
        return this.phevClimateState;
    }

    public void setArabicXOffset(int n) {
        this.arabicXOffset = n;
    }

    public int getArabicXOffset() {
        return this.arabicXOffset;
    }
}

