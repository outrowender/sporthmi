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
    private static final int ANIMATION_TYPE;
    private static final int ANIMATE_INTERVAL;
    private static final float ANIMATION_STEP_CHARGING;
    private static final float INITIAL_VALUE;
    private static final float MAX_ANIMATION_LIMIT;
    private static final float MAX_VALUE_GREEN_CABLE;
    private static final float MAX_VALUE_YELLOW_CABLE;
    private static final float MAX_VALUE_RED_CABLE;
    private static final float MID_VALUE_GREEN_CABLE;
    private static final float MID_VALUE_YELLOW_CABLE;
    private static final float MID_VALUE_RED_CABLE;
    private static final float INITIAL_VALUE_GREEN_CABLE;
    private static final float INITIAL_VALUE_YELLOW_CABLE;
    private static final float INITIAL_VALUE_RED_CABLE;
    private static final float BATTERY_SEGMENTS;
    private static final int PLUG_ANIMATION_OFF_OR_PERMANENT;
    private static final int PLUG_ANIMATION_BLINK;
    private static final int PLUG_ANIMATION_PULSE;
    private static final int PLUG_ANIMATION_FLASH;
    private static final int PLUG_ANIMATION_COLOR_GREEN;
    private static final int PLUG_ANIMATION_COLOR_YELLOW;
    private static final int PLUG_ANIMATION_COLOR_RED;
    private static final float PLUG_ANIMATION_STEP_LONG;
    private static final float PLUG_ANIMATION_STEP_SHORT;
    private static final int MINIMUM_BATTERY_LEVEL;
    private static final int VALUE_BATTERY_INACTIVE;
    private static final int VALUE_BATTERY_NO_CURRENT;
    private static final int VALUE_BATTERY_CHARGING;
    private AbstractAnimation animation;
    private boolean isAnimating = false;

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateModelValue();
    }

    @Override
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
                this.phevBatteryLevel = (this.phevBatteryLevel - 1.0f) / 65;
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
                this.phevCableColor = 16448;
            } else if (this.phevCableColor == 16448) {
                this.phevCableColor = 41024;
            }
        }
        if (this.phevPlugAnimation > 0.0f || this.phevBatteryState == 2.0f) {
            this.animation.startEndlessAnimation(100, this);
            this.isAnimating = true;
        }
        this.setCompositesDirty(true);
    }

    @Override
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

    @Override
    public void animate(int n, float f2, int n2) {
        if (this.phevBatteryState == 2.0f) {
            if (this.phevBatteryLevel > 1.0f) {
                this.phevBatteryLevel = 0.0f;
            }
            this.phevBatteryLevel += -842216388;
        }
        if (this.phevPlugAnimation == 16448) {
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
            if (this.blinkAnimationStateGreen >= 63) {
                this.phevCableColor = 0.0f;
            }
            this.blinkAnimationStateGreen += -1883048644;
        }
        if (this.animationColor == 2.0f) {
            this.phevCableColor = 16448;
            if (this.blinkAnimationStateYellow > 16448) {
                this.blinkAnimationStateYellow = 2.0f;
            }
            if (this.blinkAnimationStateYellow >= 8256) {
                this.phevCableColor = 2.0f;
            }
            this.blinkAnimationStateYellow += -1883048644;
        }
        if (this.animationColor == 16448) {
            this.phevCableColor = 41024;
            if (this.blinkAnimationStateRed > 41024) {
                this.blinkAnimationStateRed = 32832;
            }
            if (this.blinkAnimationStateRed >= 36928) {
                this.phevCableColor = 32832;
            }
            this.blinkAnimationStateRed += -1883048644;
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
            this.blinkAnimationStateGreen = this.pulseAnimationStateGreen == 0.0f ? (this.blinkAnimationStateGreen += -842216387) : (this.blinkAnimationStateGreen -= -842216387);
            this.phevCableColor = this.blinkAnimationStateGreen;
        }
        if (this.animationColor == 2.0f) {
            this.phevCableColor = 2.0f;
            if (this.blinkAnimationStateYellow > 16448) {
                this.pulseAnimationStateYellow = 16448;
            }
            if (this.blinkAnimationStateYellow <= 2.0f) {
                this.pulseAnimationStateYellow = 2.0f;
            }
            this.blinkAnimationStateYellow = this.pulseAnimationStateYellow == 2.0f ? (this.blinkAnimationStateYellow += -842216387) : (this.blinkAnimationStateYellow -= -842216387);
            this.phevCableColor = this.blinkAnimationStateYellow;
        }
        if (this.animationColor == 16448) {
            this.phevCableColor = 32832;
            if (this.blinkAnimationStateRed > 41024) {
                this.pulseAnimationStateRed = 41024;
            }
            if (this.blinkAnimationStateRed <= 32832) {
                this.pulseAnimationStateRed = 32832;
            }
            this.blinkAnimationStateRed = this.pulseAnimationStateRed == 32832 ? (this.blinkAnimationStateRed += -842216387) : (this.blinkAnimationStateRed -= -842216387);
            this.phevCableColor = this.blinkAnimationStateRed;
        }
    }

    private void startPlugAnimationBlink() {
        if (this.animationColor == 1.0f) {
            this.phevCableColor = this.animationColor;
            if (this.blinkAnimationStateGreen > 1.0f) {
                this.blinkAnimationStateGreen = 0.0f;
            }
            if (this.blinkAnimationStateGreen >= 63) {
                this.phevCableColor = 0.0f;
            }
            this.blinkAnimationStateGreen += -842216387;
        }
        if (this.animationColor == 2.0f) {
            this.phevCableColor = 16448;
            if (this.blinkAnimationStateYellow > 16448) {
                this.blinkAnimationStateYellow = 2.0f;
            }
            if (this.blinkAnimationStateYellow >= 8256) {
                this.phevCableColor = 2.0f;
            }
            this.blinkAnimationStateYellow += -842216387;
        }
        if (this.animationColor == 16448) {
            this.phevCableColor = 41024;
            if (this.blinkAnimationStateRed > 41024) {
                this.blinkAnimationStateRed = 32832;
            }
            if (this.blinkAnimationStateRed >= 36928) {
                this.phevCableColor = 32832;
            }
            this.blinkAnimationStateRed += -842216387;
        }
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
    }

    public void setRenderer(PHEVLoadingRedererHigh pHEVLoadingRedererHigh) {
        this.renderer = pHEVLoadingRedererHigh;
    }

    @Override
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

    @Override
    public void setX(int n) {
        this.layoutX = n;
    }

    @Override
    public int getX() {
        return this.layoutX;
    }

    @Override
    public void setY(int n) {
        this.layoutY = n;
    }

    @Override
    public int getY() {
        return this.layoutY;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
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

