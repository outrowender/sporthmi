/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.PopupDrawerController;
import java.util.Iterator;

public class PartialPopupController
extends AbstractPartialPopupController
implements AnimationListener,
LayoutContainer,
IViewSizeAnimatable {
    protected static final float ANIMATION_OPACITY_NONE = 0.0f;
    protected static final float ANIMATION_OPACITY_FULL = 1.0f;
    public static final int LAYER_IN_FRONT_OF_POPINS = 0;
    public static final int LAYER_BEHIND_POPINS = 1;
    public static final int DYNAMIC_SIZE_ALIGNMENT_BOTTOM = 0;
    public static final int DYNAMIC_SIZE_ALIGNMENT_TOP = 1;
    private static final int MIN_WIDTH = 50;
    private static final int MIN_HEIGHT = 50;
    private PartialPopupRenderer renderer;
    private int initialX = -1;
    private int initialY = -1;
    protected AbstractWidgetController backgroundController;
    private boolean dynamicSize = false;
    private int dynamicSizeVerticalAlignment = 0;
    private int contentInsetHorizontal = 0;
    private int contentInsetVertical = 0;
    private int visibleWidth;
    private int visibleHeight;
    private AbstractAnimation showHideAnimation;
    private int horizontalShift;
    private int maxWidth;
    private int currentStyle = 2;
    private boolean isBgGreyOutActivationAllowed = false;
    private float animatedValue = 0.0f;
    private int realRenderedX;
    private int realRenderedY;

    public PartialPopupController() {
    }

    public PartialPopupController(int n) {
        super(n);
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(PartialPopupRenderer partialPopupRenderer) {
        this.renderer = partialPopupRenderer;
    }

    public void render(RedrawContext redrawContext) {
        this.calculateVisibleSize();
        this.updateBounds();
        super.render(redrawContext);
    }

    private void calculateVisibleSize() {
        if (this.dynamicSize) {
            this.visibleWidth = 0;
            this.visibleHeight = 0;
            int n = this.getChildrenSize();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(i2);
                if (Util.equals(abstractWidgetController, this.backgroundController) || !(abstractWidgetController instanceof LayoutContainerController)) continue;
                LayoutContainerController layoutContainerController = (LayoutContainerController)abstractWidgetController;
                this.visibleWidth = Math.max(this.visibleWidth, layoutContainerController.getPreferredWidth());
                this.visibleHeight = Math.max(this.visibleHeight, layoutContainerController.getPreferredHeight());
            }
            this.visibleWidth += 2 * this.contentInsetHorizontal;
            this.visibleHeight += 2 * this.contentInsetVertical;
            this.visibleWidth = Math.max(this.visibleWidth, 50);
            if (this.maxWidth > 0) {
                this.visibleWidth = Math.min(this.visibleWidth, this.maxWidth);
            }
            this.visibleHeight = Math.max(this.visibleHeight, 50);
        } else {
            this.visibleWidth = this.getWidth();
            this.visibleHeight = this.getHeight();
        }
    }

    public void updateBounds() {
        if (this.dynamicSize) {
            float f2 = this.currentStyle == 2 ? 1.0f : this.animatedValue;
            float f3 = (1.0f - f2) * (float)(this.getWidth() / 2);
            float f4 = (1.0f - f2) * (float)(this.getHeight() / 2);
            int n = this.initialX + (int)f3;
            int n2 = this.initialY + (int)f4;
            if (this.dynamicSizeVerticalAlignment == 0) {
                this.setBounds(n - this.visibleWidth / 2, n2 - this.visibleHeight, this.visibleWidth, this.visibleHeight);
            } else {
                this.setBounds(n - this.visibleWidth / 2, n2, this.visibleWidth, this.visibleHeight);
            }
        }
    }

    public void setBackgroundController(AbstractWidgetController abstractWidgetController) {
        this.backgroundController = abstractWidgetController;
        super.add(abstractWidgetController);
    }

    public AbstractWidgetController getBackgroundController() {
        return this.backgroundController;
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        if (this.hasBounds(n, n2, n3, n4)) {
            return;
        }
        super.setBounds(n, n2, n3, n4);
        if (this.backgroundController != null) {
            this.backgroundController.setWidth(n3);
            this.backgroundController.setHeight(n4);
        }
        if (this.isDynamicSize()) {
            if (this.isConnected()) {
                this.setDynamicSizeChildrenBounds();
            } else {
                this.maxWidth = n3;
            }
        }
        if (this.initialX < 0) {
            this.initialX = n;
        }
        if (this.initialY < 0) {
            this.initialY = n2;
        }
    }

    public void setWidth(int n) {
        super.setWidth(n);
        if (this.backgroundController != null) {
            this.backgroundController.setWidth(n);
        }
    }

    public void setHeight(int n) {
        super.setHeight(n);
        if (this.backgroundController != null) {
            this.backgroundController.setHeight(n);
        }
    }

    private void setDynamicSizeChildrenBounds() {
        int n = this.visibleWidth - this.contentInsetHorizontal * 2;
        int n2 = this.getHeight() - this.contentInsetVertical * 2;
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (Util.equals(abstractWidgetController, this.backgroundController)) continue;
            abstractWidgetController.setBounds(this.contentInsetHorizontal, this.contentInsetVertical, n, n2);
        }
    }

    public void predisconnecting() {
        super.predisconnecting();
        this.setVisible(false);
        this.renderer.hide();
        this.setCompositesDirty(true);
    }

    public void disconnecting() {
        if (this.showHideAnimation != null && this.showHideAnimation.isAnimating()) {
            this.showHideAnimation.stopAnimation();
        }
        this.showHideAnimation = null;
        this.horizontalShift = 0;
        super.disconnecting();
    }

    public int hide(int n) {
        int n2;
        this.currentStyle = n;
        super.hide(this.currentStyle);
        for (n2 = 0; n2 < this.getChildrenSize(); ++n2) {
            AbstractWidget abstractWidget = this.getChild(n2);
            if (!(abstractWidget instanceof PopupDrawerController)) continue;
            PopupDrawerController popupDrawerController = (PopupDrawerController)abstractWidget;
            popupDrawerController.closePopupDrawer();
        }
        ((ScreenWidgetEVO)this.terminal.getIAnimationController().getConnectedMainScreen()).setCurrentViewSizeOnWidget(this);
        if (this.currentStyle == 2) {
            if (!this.greyOutBackground) {
                this.setVisible(false);
                this.setCompositesDirty(true);
            }
            if (this.popupManager != null) {
                this.popupManager.popupHidden(this.popupID);
            }
            this.renderer.hide();
        } else if (this.isBgGreyOutDeactive()) {
            this.setOpacity(0.0f);
            this.setCompositesDirty(true);
        }
        if ((this.greyOutBackground || this.currentStyle == 1) && this.isVisible()) {
            if (this.showHideAnimation == null) {
                this.showHideAnimation = (AbstractAnimation)this.terminal.getIAnimationController().getIAnimation(72);
                this.showHideAnimation.addListener(this);
            }
            if (this.showHideAnimation.isAnimating()) {
                this.showHideAnimation.setTarget(0.0f);
            } else {
                this.showHideAnimation.startDynamicAnimation(1.0f, 0.0f, 72, false, this);
            }
            if (this.greyOutBackground && this.currentStyle == 2 && this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                n2 = this.getlayer() == 0 ? 1 : 0;
                ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(0.0f, n2);
            }
        }
        return 1;
    }

    public int show(int n) {
        int n2;
        logChannelPopups.log(10000000, "PartialPopupController#show id: %1, style: %2", (long)this.popupID, (long)n);
        boolean bl = false;
        for (n2 = 0; n2 < this.getChildrenSize(); ++n2) {
            AbstractWidget abstractWidget = this.getChild(n2);
            abstractWidget.focusChanged(2, 64, 0);
            if (!(abstractWidget instanceof PopupDrawerController)) continue;
            bl = true;
            PopupDrawerController popupDrawerController = (PopupDrawerController)abstractWidget;
            popupDrawerController.setOnScreen(false);
        }
        this.currentStyle = n;
        if (super.show(this.currentStyle) == 2) {
            return 2;
        }
        if (bl) {
            logDrawerFocusMain.log(1000000, "PartialPopupController#show closing drawers because popup contains drawer");
            this.terminal.getDrawerFocusManager().requestDrawerState(16);
        }
        if (!this.isUserHint()) {
            ((ScreenWidgetEVO)this.terminal.getIAnimationController().getConnectedMainScreen()).setCurrentViewSizeOnWidget(this);
        }
        this.makeSubtreeDirty();
        if (this.currentStyle == 2) {
            this.setVisible(true);
            this.setOpacity(1.0f);
            this.setCompositesDirty(true);
            this.forceRepaintInPartialPopup();
            this.setCompositesDirty(true);
            if (this.popupManager != null && this.popupManager.popupVisible(this.popupID) != 1) {
                return 2;
            }
        } else {
            this.setOpacity(1.0f);
            this.setCompositesDirty(true);
        }
        if (this.greyOutBackground || this.currentStyle == 1) {
            if (this.showHideAnimation == null) {
                this.showHideAnimation = (AbstractAnimation)this.terminal.getIAnimationController().getIAnimation(72);
                this.showHideAnimation.addListener(this);
            }
            this.setVisible(true);
            if (this.popupManager != null && this.currentStyle == 1) {
                this.popupManager.popupVisible(this.popupID);
            }
            if (this.showHideAnimation.isAnimating()) {
                this.showHideAnimation.setTarget(1.0f);
            } else {
                this.showHideAnimation.startDynamicAnimation(0.0f, 1.0f, 72, false, this);
            }
            if (this.greyOutBackground && this.currentStyle == 2 && this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                n2 = this.getlayer() == 0 ? 1 : 0;
                ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(1.0f, n2);
            }
        }
        return 1;
    }

    public void animate(int n, float f2) {
        if (n == 72) {
            if (this.currentStyle == 1) {
                if (this.greyOutBackground && this.getSlot() != 5 && this.getSlot() != 3 && this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                    int n2 = this.getlayer() == 0 ? 1 : 0;
                    ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(f2, n2);
                }
                this.setVisible(f2 > 0.0f);
                this.setOpacity(f2 < 0.5f ? f2 : 1.0f);
                this.animatedValue = f2;
            }
            this.setCompositesDirty(true);
        }
    }

    public float getAnimationValue() {
        return this.animatedValue;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        if (n == 72) {
            if (this.currentStyle == 1) {
                if ((double)Math.abs(this.showHideAnimation.getTarget() - 1.0f) <= Double.MIN_VALUE * 2.0) {
                    this.setOpacity(1.0f);
                    this.animatedValue = 1.0f;
                    this.setVisible(true);
                    if (this.greyOutBackground && this.getSlot() != 5 && this.getSlot() != 3 && this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                        int n3 = this.getlayer() == 0 ? 1 : 0;
                        ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(1.0f, n3);
                    }
                    this.setCompositesDirty(true);
                    if (this.popupManager != null) {
                        this.popupManager.setPartialPopupCoordinates(this.popupID, this.realRenderedX, this.realRenderedY, this.width, this.height);
                    }
                } else {
                    this.setOpacity(0.0f);
                    this.setVisible(false);
                    if (this.greyOutBackground && this.getSlot() != 5 && this.getSlot() != 3 && this.terminal != null && ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager() != null) {
                        int n4 = this.getlayer() == 0 ? 1 : 0;
                        ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager().setDesaturationRequest(0.0f, n4);
                    }
                    this.renderer.hide();
                    this.setCompositesDirty(true);
                    if (this.popupManager != null) {
                        this.popupManager.popupHidden(this.popupID);
                    }
                }
            }
            if (this.isBgGreyOutDeactive() && this.isBgGreyOutActivationAllowed) {
                this.activateBackgroundGrayOut();
            }
            this.isBgGreyOutActivationAllowed = true;
        }
    }

    public boolean isBgGreyOutDeactive() {
        return this.tempGrayOut && !this.greyOutBackground;
    }

    public void shiftHorizontal(int n) {
        this.horizontalShift = n;
        this.setCompositesDirty(true);
    }

    public void hideNotScreenChangeSurvivingPopups() {
    }

    public int getHorizontalShift() {
        return this.horizontalShift;
    }

    public int getCurrentStyle() {
        return this.currentStyle;
    }

    public boolean isDynamicSize() {
        return this.dynamicSize;
    }

    public void setDynamicSize(boolean bl) {
        this.dynamicSize = bl;
        if (!this.isConnected()) {
            this.maxWidth = this.width;
        }
    }

    public void setDynamicSizeVerticalAlignment(int n) {
        if (n == 1 || n == 0) {
            this.dynamicSizeVerticalAlignment = n;
        }
    }

    public void activateBackgroundGrayOut() {
    }

    public void deactivateBackgroundGrayOut() {
    }

    public int getContentInset() {
        return this.contentInsetHorizontal;
    }

    public int getContentInsetHorizontal() {
        return this.contentInsetHorizontal;
    }

    public int getContentInsetVertical() {
        return this.contentInsetVertical;
    }

    public void setContentInset(int n) {
        this.contentInsetHorizontal = n;
        this.contentInsetVertical = n;
    }

    public void setContentInset(int n, int n2) {
        this.contentInsetHorizontal = n;
        this.contentInsetVertical = n2;
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        this.setCompositesDirty(true);
    }

    public HMIView[][] getReplacementWidgets() {
        return this.replacementWidgets;
    }

    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    public void setColorPalettes(int[][] nArray) {
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        this.setCompositesDirty(true);
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        this.setCompositesDirty(true);
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public void add(AbstractWidget abstractWidget, int n) {
        this.add(abstractWidget);
    }

    public boolean isUserHint() {
        return this.slot == 10;
    }

    public void sendBoundsToPartialPopupManager(int n, int n2) {
        if (this.popupManager != null && this.currentStyle == 2) {
            this.popupManager.setPartialPopupCoordinates(this.popupID, n, n2, this.width, this.height);
        } else {
            this.realRenderedX = n;
            this.realRenderedY = n2;
        }
    }

    public boolean shouldRender() {
        if (!super.shouldRender()) {
            return false;
        }
        if (this.getCurrentStyle() == 1) {
            return this.animatedValue > 0.0f;
        }
        return true;
    }
}

