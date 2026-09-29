/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IAirSuspensionRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;

public class AirSuspensionController
extends AbstractWidgetController
implements AnimationListener,
IEmptyableWidget {
    private int targetLevel;
    private int currentLevel;
    private int activityState;
    private IAirSuspensionRenderer renderer;
    private int availableState;
    private AbstractAnimation animation;
    static final int ANIMATION_TYPE;
    private int blinkStatus;
    private int blinkInterval = 350;

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.updateModelValue();
    }

    private void updateModelValue() {
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
        if (this.getChildren().size() == 3 && choiceModelGUI != null) {
            this.currentLevel = choiceModelGUI.getValue();
            this.targetLevel = ((ChoiceModelGUI)((AbstractWidgetController)this.getChild(0)).getModel()).getValue();
            this.activityState = ((ChoiceModelGUI)((AbstractWidgetController)this.getChild(1)).getModel()).getValue();
            this.availableState = ((ChoiceModelGUI)((AbstractWidgetController)this.getChild(2)).getModel()).getValue();
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = this.currentLevel;
        int n2 = this.targetLevel;
        int n3 = this.activityState;
        this.updateModelValue();
        if (n != this.currentLevel || n2 != this.targetLevel || n3 != this.activityState) {
            this.setCompositesDirty(true);
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void startAnimation() {
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget());
        } else {
            abstractAnimation.startEndlessAnimation(this.blinkInterval, this);
        }
    }

    public void stopAnimation() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
            this.blinkStatus = 0;
        }
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public void setCurrentLevel(int n) {
        this.currentLevel = n;
    }

    public int getTargetLevel() {
        return this.targetLevel;
    }

    public void setTargetLevel(int n) {
        this.targetLevel = n;
    }

    public int getActivityState() {
        return this.activityState;
    }

    public void setActivityState(int n) {
        this.activityState = n;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IAirSuspensionRenderer iAirSuspensionRenderer) {
        this.renderer = iAirSuspensionRenderer;
    }

    @Override
    public void animate(int n, float f2) {
        this.blinkStatus = this.blinkStatus == 0 ? 1 : 0;
        this.setCompositesDirty(true);
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
    }

    public AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(1);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    public boolean isAnimating() {
        if (this.animation != null) {
            return this.animation.isAnimating();
        }
        return false;
    }

    public void setBlinkStatus(int n) {
        this.blinkStatus = n;
    }

    public int getBlinkStatus() {
        return this.blinkStatus;
    }

    public void setBlinkInterval(int n) {
        this.blinkInterval = n;
    }

    public int getBlinkInterval() {
        return this.blinkInterval;
    }

    @Override
    public boolean hasContent() {
        return true;
    }

    public int getAvailableState() {
        return this.availableState;
    }

    public void setAvailableState(int n) {
        this.availableState = n;
    }

    @Override
    public int getPreferredWidth() {
        if (this.renderer != null) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    @Override
    public int getPreferredHeight() {
        if (this.renderer != null) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }
}

