/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModel2DGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;

public class RadioButtonController
extends AbstractWidgetController
implements AnimationListener,
ListItemWidget {
    public static final int RANGE_OVERLAY_BOUND_MIN = 0;
    public static final int RANGE_OVERLAY_BOUND_MAX = 1;
    public static final int RANGE_OVERLAY_BOUND_INT_SIZE = 2;
    public static final int NO_RANGE_OVERLAY_BOUNDS = 3;
    private static final int ANIMATION_TARGET = 1000;
    private static final int ANIMATION_TYPE = 74;
    private RadioButtonRenderer renderer;
    private AbstractAnimation animation;
    private float animatedDisabled;
    private float startAnimatedDisabled;
    private float targetAnimatedDisabled;
    private float animatedSelected;
    private float startAnimatedSelected;
    private float targetAnimatedSelected;
    private int widgetID = -1;
    private int m_rModelChoiceValue = -1;
    private int m_rModelRangeValue = -1;
    private int m_rModelMin = 0;
    private int m_rModelMax = 0;
    private float m_rangeIconRotationValue = 0.0f;
    private int[] m_rangeOverlayBounds = new int[]{225, 495, 270};
    private int modelColumn = -1;

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.updateState(this.isConnected());
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.setRangeOverlayBounds(new int[]{this.terminal.getLayout().getDistance(190), this.terminal.getLayout().getDistance(191)});
        this.updateRModelLimits();
        this.updateState(false);
    }

    public void animate(int n, float f2) {
        float f3 = this.animation.getProgress();
        this.animatedDisabled = RadioButtonController.getInterpolatedValue(this.startAnimatedDisabled, this.targetAnimatedDisabled, f3);
        this.animatedSelected = RadioButtonController.getInterpolatedValue(this.startAnimatedSelected, this.targetAnimatedSelected, f3);
        this.setCompositesDirty(true);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1) {
            this.updateState(true);
        } else if (n == 14) {
            this.updateRModelLimits();
            this.updateState(false);
        } else if (n == 4 && this.model instanceof RangeModel2DGUI) {
            this.updateRModelLimits();
            this.updateState(true);
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        this.animatedDisabled = this.targetAnimatedDisabled;
        this.animatedSelected = this.targetAnimatedSelected;
        this.setCompositesDirty(true);
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(RadioButtonRenderer radioButtonRenderer) {
        this.renderer = radioButtonRenderer;
    }

    public int getPreferredWidth() {
        if (this.renderer != null) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    public int getPreferredHeight() {
        if (this.renderer != null) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    public int getModelColumn() {
        return this.modelColumn;
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    public void updateRModelValues(boolean bl) {
        if (this.model instanceof RangeModel2DGUI) {
            RangeModel2DGUI rangeModel2DGUI = (RangeModel2DGUI)this.model;
            int n = rangeModel2DGUI.getValueX();
            int n2 = rangeModel2DGUI.getValueY();
            if (bl || n != this.m_rModelChoiceValue) {
                this.m_rModelChoiceValue = n;
                this.targetAnimatedSelected = this.calculateAnimatedSelected(n);
                this.setCompositesDirty(true);
            }
            if (bl || this.widgetID == this.m_rModelChoiceValue && n2 != this.m_rModelRangeValue) {
                this.m_rModelRangeValue = n2;
                this.m_rangeIconRotationValue = AnimUtils.norm1(this.m_rModelMin, this.m_rModelMax, n2);
                this.setCompositesDirty(true);
            }
        }
    }

    public boolean isAnimationRunning() {
        return this.animation != null && this.animation.isAnimating();
    }

    public float getAnimatedDisabled() {
        return this.animatedDisabled;
    }

    public float getAnimatedSelected() {
        return this.animatedSelected;
    }

    public float getRangeIconRotationValue() {
        return this.m_rangeIconRotationValue;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    public int[] getRangeOverlayBounds() {
        return this.m_rangeOverlayBounds;
    }

    public void setRangeOverlayBounds(int[] nArray) {
        if (nArray != null && nArray.length >= 2) {
            int n = this.getPositiveBelow360Angle(nArray[0]);
            int n2 = this.getPositiveBelow360Angle(nArray[1]);
            if (n2 < n) {
                n2 += 360;
            }
            this.m_rangeOverlayBounds = new int[]{n, n2, n2 - n};
        }
    }

    private void updateState(boolean bl) {
        this.calculateTargets();
        if (this.targetAnimatedDisabled == this.animatedDisabled && this.targetAnimatedSelected == this.animatedSelected) {
            return;
        }
        if (!bl) {
            this.animatedDisabled = this.targetAnimatedDisabled;
            this.animatedSelected = this.targetAnimatedSelected;
            this.setCompositesDirty(true);
            return;
        }
        this.initializeAnimation();
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 74, false, this);
        }
    }

    private void calculateTargets() {
        if (this.model == null) {
            this.targetAnimatedDisabled = 0.0f;
            this.targetAnimatedSelected = 0.0f;
            return;
        }
        this.targetAnimatedDisabled = this.isEnabled() ? 0.0f : 1.0f;
        if (this.model instanceof HMIModelGUI && ((HMIModelGUI)this.model).getStatus() == 3) {
            this.targetAnimatedDisabled = 1.0f;
            this.targetAnimatedSelected = 0.0f;
            return;
        }
        if (this.model instanceof ChoiceModelGUI) {
            this.targetAnimatedSelected = this.calculateAnimatedSelected(((ChoiceModelGUI)this.model).getValue());
        } else if (this.model instanceof RangeModel2DGUI) {
            this.updateRModelValues(false);
        } else if (this.model instanceof IntegerListCell) {
            if (this.widgetID == -1) {
                this.widgetID = 1;
            }
            this.targetAnimatedSelected = this.calculateAnimatedSelected(((IntegerListCell)this.model).getValue());
        } else if (this.model instanceof Integer) {
            if (this.widgetID == -1) {
                this.widgetID = 1;
            }
            this.targetAnimatedSelected = this.calculateAnimatedSelected((Integer)this.model);
        } else {
            logChannel.log(100000, "Unknown model %2: %1", this.model, (long)this.modelID);
        }
    }

    private float calculateAnimatedSelected(int n) {
        if (n == this.widgetID) {
            return 1.0f;
        }
        return 0.0f;
    }

    private void initializeAnimation() {
        this.startAnimatedDisabled = this.animatedDisabled;
        this.startAnimatedSelected = this.animatedSelected;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    private void updateRModelLimits() {
        if (this.model instanceof RangeModel2DGUI) {
            RangeModel2DGUI rangeModel2DGUI = (RangeModel2DGUI)this.model;
            this.m_rModelMin = rangeModel2DGUI.getMinimumY();
            this.m_rModelMax = rangeModel2DGUI.getMaximumY();
        }
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(74);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private static float getInterpolatedValue(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * f4;
    }

    private int getPositiveBelow360Angle(int n) {
        int n2 = n % 360;
        n2 = n2 < 0 ? n2 + 360 : n2;
        return n2;
    }

    protected void destroyWidget() {
        super.destroyWidget();
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }
}

