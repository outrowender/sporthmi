/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.CheckboxChoiceModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;

public class CheckboxController
extends AbstractWidgetController
implements AnimationListener,
ListItemWidget {
    private static final int[] DEFAULT_MAPPING = new int[]{0, 1};
    private static final int ANIMATION_TARGET = 1000;
    private static final int ANIMATION_TYPE = 75;
    public static final int CHECK_MARK_STATE_UNCHECKED_SOURCE = 0;
    public static final int CHECK_MARK_STATE_CHECKED = 1;
    public static final int CHECK_MARK_STATE_UNCHECKED_DESTINATION = 2;
    public static final float CHECK_MARK_STATE_FULL_OPAQUE = 0.0f;
    public static final float CHECK_MARK_STATE_TRANSLUTIENT = 1.0f;
    private CheckboxRenderer renderer;
    private float checkMarkState = 1.0f;
    private float activeOpaqueness;
    private float lastSelectionIcon = this.activeOpaqueness = 0.0f;
    private int modelColumn = -1;
    private float itemDisabled;
    private float startCheckMarkState;
    private float startItemDisabled;
    private float targetCheckMarkState = 1.0f;
    private float targetItemDisabled;
    private AbstractAnimation animation;
    private IWidgetKeyHandler keyHandler = new CheckboxChoiceModelKeyHandler();
    private int[][] mapping;

    public CheckboxController() {
        this.propageMappingToKeyHandler();
    }

    public void setRenderer(CheckboxRenderer checkboxRenderer) {
        this.updateState(false);
        this.renderer = checkboxRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public float getCheckMarkState() {
        return this.checkMarkState;
    }

    public void setCheckMarkState(float f2) {
        this.checkMarkState = f2;
    }

    public float getOpaqueness() {
        return this.activeOpaqueness;
    }

    public void setOpaqueness(float f2) {
        this.activeOpaqueness = this.isIconOpaque((int)f2) ? 0.0f : 1.0f;
    }

    public float getItemDisabled() {
        return this.itemDisabled;
    }

    public void setItemDisabled(float f2) {
        this.itemDisabled = f2;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 2 || n == 14) {
            if (this.getParent().getParent() instanceof ListController) {
                ListController listController = (ListController)this.getParent().getParent();
                if (listController.getParent() instanceof MenuController) {
                    MenuController menuController = (MenuController)listController.getParent();
                    if (menuController.getAnimationManager().isScrollAnimationRunning()) {
                        this.updateState(false);
                    } else {
                        this.updateState(true);
                    }
                }
            } else {
                this.updateState(true);
            }
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.updateState(this.isConnected());
    }

    private void updateState(boolean bl) {
        this.calculateTargets();
        if (this.targetCheckMarkState == this.checkMarkState && this.targetItemDisabled == this.itemDisabled && this.activeOpaqueness == this.lastSelectionIcon) {
            return;
        }
        if (this.activeOpaqueness != this.lastSelectionIcon) {
            this.lastSelectionIcon = this.activeOpaqueness;
            this.setCompositesDirty(true);
        }
        if (!bl) {
            this.checkMarkState = this.targetCheckMarkState;
            this.itemDisabled = this.targetItemDisabled;
            this.setCompositesDirty(true);
            return;
        }
        this.startCheckMarkState = this.checkMarkState == 2.0f && this.targetCheckMarkState == 1.0f ? 0.0f : this.checkMarkState;
        this.startItemDisabled = this.itemDisabled;
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 75, false, this);
        }
    }

    private void calculateTargets() {
        if (this.model == null) {
            this.targetItemDisabled = 1.0f;
            this.targetCheckMarkState = 2.0f;
            return;
        }
        this.targetItemDisabled = this.isEnabled() ? 0.0f : 1.0f;
        if (this.model instanceof HMIModelGUI && ((HMIModelGUI)this.model).getStatus() == 3) {
            this.targetItemDisabled = 1.0f;
            this.targetCheckMarkState = 2.0f;
            return;
        }
        if (this.model instanceof ChoiceModelGUI) {
            this.calculateCheckMarkFromInteger(((ChoiceModelGUI)this.model).getValue());
        } else if (this.model instanceof IntegerListCell) {
            this.calculateCheckMarkFromInteger(((IntegerListCell)this.model).getValue());
        } else if (this.model instanceof Integer) {
            this.calculateCheckMarkFromInteger((Integer)this.model);
        } else {
            logChannel.log(100000, "CheckboxController#calculateTargets: Unknown model %2: %1", this.model, (long)this.modelID);
        }
    }

    private void calculateCheckMarkFromInteger(int n) {
        this.targetCheckMarkState = this.isCheckedModelValue(n) ? 1.0f : 2.0f;
        this.setOpaqueness(n);
    }

    private boolean isCheckedModelValue(int n) {
        if (this.mapping == null || this.mapping.length == 0 || this.mapping[0].length == 0) {
            return n != 0;
        }
        int[] nArray = this.mapping[0];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return false;
        }
        return true;
    }

    private boolean isIconOpaque(int n) {
        return !this.isIconTransparent(n);
    }

    private boolean isIconTransparent(int n) {
        return (n & 0x80) > 0;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(75);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    public void animate(int n, float f2) {
        float f3 = this.animation.getProgress();
        this.checkMarkState = CheckboxController.getInterpolatedValue(this.startCheckMarkState, this.targetCheckMarkState, f3);
        this.itemDisabled = CheckboxController.getInterpolatedValue(this.startItemDisabled, this.targetItemDisabled, f3);
        this.setCompositesDirty(true);
    }

    private static float getInterpolatedValue(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * f4;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        this.checkMarkState = this.targetCheckMarkState;
        this.itemDisabled = this.targetItemDisabled;
        this.setCompositesDirty(true);
    }

    protected void destroyWidget() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateState(true);
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

    public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        boolean bl = this.hasState(36);
        if (bl && this.keyHandler != null) {
            this.keyHandler.keyPressed(this, keyEvent);
            return;
        }
        if (keyEvent.getKeyCode() == 17 && !bl && this.isFunctional()) {
            keyEvent.consume(true);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        if (this.hasState(36) && this.keyHandler != null) {
            this.keyHandler.keyReleased(this, keyEvent);
        }
        super.keyReleased(keyEvent);
    }

    public IWidgetKeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    public void setKeyHandler(IWidgetKeyHandler iWidgetKeyHandler) {
        this.keyHandler = iWidgetKeyHandler;
        this.propageMappingToKeyHandler();
    }

    public int[][] getMapping() {
        return this.mapping;
    }

    public void setMapping(int[][] nArray) {
        this.mapping = nArray;
        this.propageMappingToKeyHandler();
    }

    private final void propageMappingToKeyHandler() {
        if (this.keyHandler instanceof CheckboxChoiceModelKeyHandler) {
            if (this.mapping == null) {
                ((CheckboxChoiceModelKeyHandler)this.keyHandler).setModelValues(DEFAULT_MAPPING);
            } else {
                ((CheckboxChoiceModelKeyHandler)this.keyHandler).setModelValues(new int[]{this.mapping[0][0], this.mapping[1][0]});
            }
        }
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    public int getModelColumn() {
        return this.modelColumn;
    }
}

