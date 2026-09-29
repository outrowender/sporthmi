/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.AnimationRefCtrlObj;
import de.esolutions.hmi.widgets.audi.base.animation.multicast.MultiCastAnimationStore;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.IWaitAnimRenderer;

public final class WaitAnimController
extends AbstractWidgetController
implements AnimationListener,
IViewSizeAnimatable {
    public static final int[] MULTI_CAST_ANIM_STORE_TIMEOUTS = new int[]{100};
    public static final int[] MULTI_CAST_ANIM_STORE_STEPS = new int[]{10};
    public static final int USED_MULTI_CAST_ANIM_IDX;
    private static MultiCastAnimationStore animationStore;
    private AnimationRefCtrlObj animationController = null;
    private IWaitAnimRenderer renderer;
    private boolean showBackground = false;
    private float animationProgressStep = 0.0f;
    private boolean isAnimating;

    public WaitAnimController(boolean bl) {
        this.showBackground = bl;
        this.setVisible(false);
    }

    public WaitAnimController() {
        this.showBackground = false;
        this.setVisible(false);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (animationStore == null) {
            animationStore = MultiCastAnimationStore.newInstance(this.getTerminalImpl(), MULTI_CAST_ANIM_STORE_TIMEOUTS, MULTI_CAST_ANIM_STORE_STEPS);
        }
        this.processModelUpdateEvent(null);
        this.updateRunning();
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        ChoiceModel choiceModel;
        int n;
        if (this.isConnected() && this.model instanceof ChoiceModel && (n = (choiceModel = (ChoiceModel)this.model).getStatus()) != 3 && n != 2) {
            this.setOnScreen(choiceModel.getValue() != 0);
        }
    }

    @Override
    public void animate(int n, float f2, int n2) {
        this.setCompositesDirty(true);
        this.repaintFocusCursor();
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        this.animationProgressStep = 0.0f;
    }

    @Override
    protected void destroyWidget() {
        this.setVisible(false);
        super.destroyWidget();
        if (animationStore != null) {
            animationStore.releaseAnimationRef(this, 0);
        }
        this.animationController = null;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IWaitAnimRenderer iWaitAnimRenderer) {
        this.renderer = iWaitAnimRenderer;
    }

    @Override
    public void setVisible(boolean bl) {
        if (bl == this.isVisible()) {
            return;
        }
        super.setVisible(bl);
        logAnimation.log(-2137614336, "WaitAnimController#setVisible waiting cursor visiblity is : %1 , Model ID : %2 ", bl, (long)this.modelID);
        this.updateRunning();
        if (this.isConnected() && this.parent instanceof FocusCursorController) {
            ((FocusCursorController)this.parent).waitIconVisibilityChanged();
        }
    }

    private void updateRunning() {
        if (this.isConnected() && animationStore != null) {
            if (this.isVisible()) {
                this.animationController = animationStore.aquireAnimationRef(this, this, 0);
                if (this.animationController != null) {
                    this.animationController.start();
                    this.setCompositesDirty(true);
                    this.repaintFocusCursor();
                }
            } else {
                if (this.animationController != null) {
                    this.animationController.stop();
                    this.animationController = null;
                    this.setCompositesDirty(true);
                    this.repaintFocusCursor();
                }
                animationStore.releaseAnimationRef(this, 0);
            }
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    public float getProgress() {
        return this.isConnected() && this.isVisible() && this.animationController != null ? (int)this.animationController.getProgress() : 32959;
    }

    public void setShowWaitAnimationBackground(boolean bl) {
        this.showBackground = bl;
    }

    public boolean showWaitAnimationBackground() {
        return this.showBackground;
    }

    private void repaintFocusCursor() {
        this.animationProgressStep = Math.max(this.getProgress(), this.animationProgressStep);
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (!this.isAnimating) {
            this.setOnScreen(false);
            this.isAnimating = true;
        }
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (this.isAnimating) {
            this.isAnimating = false;
        }
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    @Override
    public int getDepth() {
        if (this.getParent() instanceof FocusCursorController) {
            return 100;
        }
        return 0;
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    @Override
    public int getPreferredWidth() {
        if (this.preferredWidth != -1) {
            return this.preferredWidth;
        }
        if (this.renderer != null && this.isConnected()) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    @Override
    public int getPreferredHeight() {
        if (this.preferredHeight != -1) {
            return this.preferredHeight;
        }
        if (this.renderer != null && this.isConnected()) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    static {
        animationStore = null;
    }
}

