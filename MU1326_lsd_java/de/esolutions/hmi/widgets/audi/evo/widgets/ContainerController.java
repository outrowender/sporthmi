/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem$Helper;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.IIdleTimerWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RectangleParameters;
import de.esolutions.hmi.widgets.audi.base.Rectangular;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CarViewerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController$AnimationTransformation;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController$MutableAnimationTransformation;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerTitle;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionDrawerPreviewIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SharedTextureController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IDecoratorProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ContainerController
extends LayoutContainerController
implements ScreenMainArea,
AnimationListener,
DrawerMain,
DrawerIcon,
DrawerTitle,
IDecoratorProvider {
    public static final int ROLE_FULLSCREEN_MAP;
    public static final int ROLE_MENU_OVERLAY_DECORATOR;
    public static final int ROLE_SELECTION_DRAWER_PREVIEWS;
    public static final int ROLE_SELECTION_DRAWER_PREVIEWS_BACKGROUND_ABOVE;
    public static final int ROLE_SELECTION_DRAWER_PREVIEWS_BACKGROUND_BELOW;
    public static final int ROLE_KDK;
    public static final int LAYER_ONSCREEN_ABOVE;
    public static final int LAYER_OFFSCREEN;
    public static final int LAYER_ONSCREEN_BELOW;
    public static final int LAYER_CLOSED_SELECTION_DRAWER;
    public static final int LAYER_CLOSED_OPTION_DRAWER;
    public static final int LAYER_ONSCREEN_ABOVE_DO_NOT_FLIP_IN_RTL;
    public static final int LAYER_ONSCREEN_MAP_BORDER;
    private static final float ANIMATION_TARGET;
    private static final float FULL_OPACITY;
    private static final float PASSIVE_OPACITY;
    private static final float PASSIVE_SCALING;
    private static final float MASK_OPACITY_BIG_STAGE;
    private static final float[] ANIM_FACTORS;
    private static final int ANIM_STATE_DEFAULT;
    private static final int ANIM_STATE_ENT_DRAWER_OPENINIG;
    private static final int ANIM_STATE_ENT_DRAWER_CLOSING;
    private static final int TRANSFORMATION_INDEX_OPTION_DRAWER;
    private static final int TRANSFORMATION_INDEX_SELECTION_DRAWER;
    private static final int TRANSFORMATION_INDEX_ENTERTAINMENT_DRAWER;
    private static final int TRANSFORMATION_INDEX_SCREEN_CHANGE;
    private static final int TRANSFORMATION_INDEX_VIEW_SIZE;
    private static final int TRANSFORMATION_INDEX_PARTIAL_POPUP;
    private static final int TRANSFORMATION_INDEX_DRAWER_ITEM;
    private static final int TRANSFORMATION_INDEX_SDS;
    private static final int TRANSFORMATION_COUNT;
    private static final int INVERT_MASK_MAIN_AREA;
    private static final int INVERT_MASK_DRAWER;
    private static final int CONTAINER_TYPE_DEFAULT;
    private static final int CONTAINER_TYPE_SCREEN_AREA;
    private static final int CONTAINER_TYPE_DRAWER_ITEM;
    private static final boolean ENABLE_DRAWER_ICON_DESATURATION_WHEN_PARTIAL_POPUP_OPENS;
    private static final ContainerController$AnimationTransformation IDENTITY_TRANSFORMATION;
    private static final LogChannel LC;
    private final ContainerController$MutableAnimationTransformation[] currentTransformations = new ContainerController$MutableAnimationTransformation[8];
    private final ContainerController$AnimationTransformation[] targetTransformations = new ContainerController$AnimationTransformation[8];
    private final Map screenChangeTransformations = new HashMap(10);
    private boolean noScreenChangeAnimation = false;
    private boolean passOnOpacityToPartialPopups;
    private boolean focusableInSmallStage = true;
    private boolean hideSmallStageContentOnOpenSelectionDrawer = true;
    private boolean isSmallStage = false;
    private boolean connected;
    private boolean searchedForCarViewer;
    private boolean closingOptionDrawer;
    private boolean resetFocusCursor;
    private boolean transitionForward = true;
    private boolean transformationInitialized;
    public int target = 24;
    private int animationMask;
    private int invertMask;
    private int drawerAnimationType = 1;
    private int containerType = 0;
    private int mmiCombiSyncMode = 1;
    private int containerRole;
    private int animationType = 76;
    private int animState = 0;
    private int screenLayer = 2;
    private float[] opacitySet = null;
    private float drawerDesaturationValue;
    private float transY;
    private float viewSizeOpacity = 1.0f;
    private float ppDesaturation = 0.0f;
    private float selectionDrawerValue;
    private float smallStageSelectionDrawerOpacity = 1.0f;
    private float[] viewSizeWeights;
    IconController notFocusableIcon;
    private AbstractAnimation animation;
    private List idleTimers = null;
    private SharedTextureController fullScreenMapTexture;
    private SharedTextureController kdkTexture;
    private MenuController menuController;
    private SelectionDrawerPreviewIconController selectionDrawerPreviewIconController;
    private ContainerController$MutableAnimationTransformation currentPPTransform = new ContainerController$MutableAnimationTransformation();
    private ContainerController$MutableAnimationTransformation tempTransformation = new ContainerController$MutableAnimationTransformation();
    private ContainerController$MutableAnimationTransformation intermediateTransformation = new ContainerController$MutableAnimationTransformation();
    private CarViewerController carViewerController;
    private ContainerController$AnimationTransformation startTransformation;
    private ContainerController$AnimationTransformation targetTransformation;
    private ContainerController$AnimationTransformation currentTransformation = IDENTITY_TRANSFORMATION;
    private ContainerController$AnimationTransformation startScreenChangeTransformation;
    private ContainerController$AnimationTransformation targetScreenChangeTransformation;
    private ContainerController$MutableAnimationTransformation currentDisplayTransformation = new ContainerController$MutableAnimationTransformation();
    private ContainerController$MutableAnimationTransformation optionMenuTransformation;
    private ContainerController$MutableAnimationTransformation selectionMenuTransformation;
    private ContainerController$MutableAnimationTransformation entertainmentMenuTransformation;
    private ContainerController$MutableAnimationTransformation currentviewSizeTransformation = new ContainerController$MutableAnimationTransformation();
    private ContainerController$MutableAnimationTransformation viewSizeTransformation;
    private ContainerController$MutableAnimationTransformation hideTransformation;
    private int hideCenterX;
    private int hideCenterY;
    private float hideScale = 32959;
    private ContainerController$AnimationTransformation screenFadeInTransformation;
    private ContainerController$AnimationTransformation screenFadeOutTransformation;
    private List menuDecorators = new ArrayList();
    private AbstractWidget menuDecorator;
    private boolean sharedTextureMapEnabled;
    private boolean oldSharedTextureMapEnabled;
    private IScreenManager screenManager;

    public ContainerController() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.currentTransformations[i2] = new ContainerController$MutableAnimationTransformation();
        }
    }

    @Override
    public void showDrawerItem(boolean bl, boolean bl2) {
        AbstractAnimation abstractAnimation;
        LC.log(-2137614336, "ContainerController#showDrawerItem animate=%1, this=%2", bl, (Object)this);
        if (bl && !this.transformationInitialized) {
            LC.log(10000, "ContainerController#showDrawerItem transformation not initialized");
        }
        this.closingOptionDrawer = false;
        this.setVisible(true);
        if (this.menuController != null) {
            this.menuController.setOnScreen(true);
        }
        if (this.transformationInitialized) {
            this.startTransformation = this.targetTransformations[3];
        } else {
            LC.log(-2137614336, "ContainerController#showDrawerItem initializing transformation");
            this.startTransformation = this.getHideTransformation(true);
            if (this.startTransformation == null) {
                this.startTransformation = this.targetTransformations[3];
            }
            this.transformationInitialized = true;
        }
        this.targetTransformation = IDENTITY_TRANSFORMATION;
        if (this.resetFocusCursor) {
            this.resetFocusCursor();
            this.resetFocusCursor = false;
        }
        if (bl && (abstractAnimation = this.getAnimation()) == null) {
            bl = false;
        }
        if (!bl || !this.animationNeeded()) {
            this.stopAnimation();
            this.targetTransformations[3] = this.targetTransformation;
            this.targetTransformation.copyTo(this.currentTransformations[3]);
            this.updateCurrentDisplayTransformation(true);
            this.setCompositesDirty(true);
            return;
        }
        abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
            abstractAnimation.setFading(true);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, this.animationType, true, this);
            this.setCompositesDirty(true);
        }
    }

    private void stopAnimation() {
        if (this.animation == null) {
            return;
        }
        if (this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
    }

    private boolean animationNeeded() {
        return !this.targetTransformation.equals(this.targetTransformations[3]);
    }

    private void resetFocusCursor() {
        int n = this.getChildrenSize();
        if (n == 0) {
            return;
        }
        List list = this.getChildren();
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)list.get(i2);
            if (!(abstractWidgetController instanceof MenuController)) continue;
            MenuController menuController = (MenuController)abstractWidgetController;
            MenuItemIndex menuItemIndex = menuController.getFirstMenuItem();
            if (menuItemIndex != null) {
                menuLogCh.log(-2137614336, "ContainerController#resetFocusCursor: focus first menu item with index: %1", (Object)menuItemIndex);
                menuController.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
            }
            return;
        }
    }

    @Override
    public void hideDrawerItem(boolean bl, boolean bl2) {
        AbstractAnimation abstractAnimation;
        LC.log(-2137614336, "ContainerController#hideDrawerItem animate=%1, this=%2", bl, (Object)this);
        if (bl && !this.transformationInitialized) {
            LC.log(10000, "ContainerController#hideDrawerItem transformation not initialized");
        }
        if (this.transformationInitialized) {
            this.startTransformation = this.currentTransformation;
        } else {
            LC.log(-2137614336, "ContainerController#hideDrawerItem initializing transformation");
            this.startTransformation = IDENTITY_TRANSFORMATION;
            this.transformationInitialized = true;
        }
        this.targetTransformation = this.getHideTransformation(bl2);
        if (bl && (abstractAnimation = this.getAnimation()) == null) {
            bl = false;
        }
        if (!bl || !this.animationNeeded()) {
            if (this.menuController != null && !this.isAnimating()) {
                this.menuController.setOnScreen(false);
            }
            this.stopAnimation();
            this.targetTransformations[3] = this.targetTransformation;
            this.targetTransformation.copyTo(this.currentTransformations[3]);
            this.updateCurrentDisplayTransformation(true);
            this.setCompositesDirty(true);
            if (this.animationType == 53 && this.terminal != null && !this.terminal.getDrawerFocusManager().isUsePersistence()) {
                this.resetFocusCursor = true;
            }
            return;
        }
        this.closingOptionDrawer = true;
        abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
            abstractAnimation.setFading(false);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, this.animationType, false, this);
        }
    }

    private boolean isAnimating() {
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (abstractAnimation == null) {
            return false;
        }
        return abstractAnimation.isAnimating();
    }

    private void handleAnimStateTransitions(int n) {
        switch (n) {
            case 32: {
                this.animState = 1;
                break;
            }
            case 16: {
                if (this.animState == 1) {
                    this.animState = 2;
                    break;
                }
                this.animState = 0;
                break;
            }
            default: {
                this.animState = 0;
            }
        }
    }

    @Override
    public void setMainAreaState(int n, int n2, int n3) {
        this.containerRole = n2;
        this.animationMask = 5365;
        this.containerType = 1;
        this.invertMask = 0;
        this.targetTransformations[0] = this.getScreenAreaTransformation(8, n2);
        this.targetTransformations[1] = this.getScreenAreaTransformation(4, n2);
        this.targetTransformations[2] = this.getScreenAreaTransformation(32, n2);
        this.targetTransformations[7] = this.createSdsTransformation(n2);
    }

    private ContainerController$AnimationTransformation createSdsTransformation(int n) {
        if (n == 7) {
            return IDENTITY_TRANSFORMATION;
        }
        if (n == 2 && !this.isScreenModeOptionScreen()) {
            float f2 = this.terminal.getLayout().getFloatConstant(16);
            ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation = this.createZTransformation(f2, 1.0f);
            containerController$MutableAnimationTransformation.setTranslation(containerController$MutableAnimationTransformation.getTransX(), containerController$MutableAnimationTransformation.getTransY() / 2.0f, 0.0f);
            return containerController$MutableAnimationTransformation;
        }
        float f3 = this.terminal.getLayout().getFloatConstant(16);
        return this.createZTransformation(f3, 1.0f);
    }

    @Override
    public void setMainAreaState(int n, int n2, boolean bl) {
        AbstractAnimation abstractAnimation;
        if (LC.isDebug()) {
            LC.log(-2137614336, "ContainerController#setMainAreaState state=%1, role=%2, animate=%3, this=%4", (Object)Util.createInteger(n), (Object)Util.createInteger(n2), (Object)String.valueOf(bl), (Object)this);
        }
        this.containerType = 1;
        this.targetTransformation = this.getScreenAreaTransformation(n, n2);
        this.handleAnimStateTransitions(n);
        if (this.transformationInitialized) {
            this.startTransformation = this.targetTransformations[3];
        } else {
            this.startTransformation = IDENTITY_TRANSFORMATION;
            this.transformationInitialized = true;
        }
        if (bl && (abstractAnimation = this.getAnimation()) == null) {
            bl = false;
        }
        if (!bl || !this.animationNeeded()) {
            this.stopAnimation();
            this.targetTransformations[3] = this.targetTransformation;
            this.targetTransformation.copyTo(this.currentTransformations[3]);
            this.updateCurrentDisplayTransformation(true);
            this.setCompositesDirty(true);
            return;
        }
        abstractAnimation = this.getAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
            abstractAnimation.setFading(false);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, this.animationType, false, this);
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private ContainerController$AnimationTransformation getScreenAreaTransformation(int n, int n2) {
        int n3;
        if (n == 16) {
            return IDENTITY_TRANSFORMATION;
        }
        boolean bl = n2 == 1;
        int n4 = n3 = bl ? 63 : (int)0.0f;
        if (n == 8) {
            if (this.optionMenuTransformation == null) {
                this.optionMenuTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(n3);
                if (bl) {
                    this.optionMenuTransformation.move(32960, 57408, 0.0f).setScale(-1701242561);
                }
            }
            return this.optionMenuTransformation;
        }
        if (n == 4) {
            if (this.selectionMenuTransformation == null) {
                this.selectionMenuTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(n3);
                if (bl) {
                    this.selectionMenuTransformation.move(46915, 57408, 0.0f).setScale(-1701242561);
                }
            }
            return this.selectionMenuTransformation;
        }
        if (n == 32) {
            if (this.entertainmentMenuTransformation == null) {
                this.entertainmentMenuTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(n3);
                if (bl) {
                    this.entertainmentMenuTransformation.move(16449, 16449, 0.0f).setScale(-1883081409);
                }
            }
            return this.entertainmentMenuTransformation;
        }
        LC.log(10000, "ContainerController#getTargetTransformation unknown passive mode %1", (long)n);
        return null;
    }

    private ContainerController$AnimationTransformation getScreenChangeTransformation(int n) {
        if (this.noScreenChangeAnimation) {
            return IDENTITY_TRANSFORMATION;
        }
        int n2 = n & 0x1C;
        int n3 = n & 3;
        int n4 = n & 0x60;
        Integer n5 = Util.createInteger(n2 | n3 | n4);
        ContainerController$AnimationTransformation containerController$AnimationTransformation = (ContainerController$AnimationTransformation)this.screenChangeTransformations.get(n5);
        if (containerController$AnimationTransformation != null) {
            return containerController$AnimationTransformation;
        }
        ContainerController$AnimationTransformation containerController$AnimationTransformation2 = this.getScreenChangeTransformation(n2, n3, n4);
        if (containerController$AnimationTransformation2 == null) {
            LC.log(-1601830656, "ContainerController#getScreenChangeTransformation unknown screenChangeTarget %1", (long)n);
            return IDENTITY_TRANSFORMATION;
        }
        this.screenChangeTransformations.put(n5, containerController$AnimationTransformation2);
        return containerController$AnimationTransformation2;
    }

    private ContainerController$AnimationTransformation getScreenChangeTransformation(int n, int n2, int n3) {
        ContainerController$AnimationTransformation containerController$AnimationTransformation = null;
        switch (n) {
            case 16: {
                containerController$AnimationTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(0.0f);
                break;
            }
            case 8: 
            case 28: {
                if (ScreenChangeAnimationItem$Helper.isTransition(n3, 32) && ScreenChangeAnimationItem$Helper.isFade(n2, 1) || ScreenChangeAnimationItem$Helper.isTransition(n3, 64) && ScreenChangeAnimationItem$Helper.isFade(n2, 2)) {
                    containerController$AnimationTransformation = this.createZTransformation(0x3333733F, 0.0f);
                    break;
                }
                containerController$AnimationTransformation = this.createZTransformation(1717995071, 0.0f);
                break;
            }
            case 4: {
                if (ScreenChangeAnimationItem$Helper.isFade(n2, 1)) {
                    if (this.screenFadeInTransformation == null) {
                        containerController$AnimationTransformation = this.createZTransformation(-842216387, 0.0f);
                        break;
                    }
                    containerController$AnimationTransformation = this.screenFadeInTransformation;
                    break;
                }
                if (!ScreenChangeAnimationItem$Helper.isFade(n2, 2)) break;
                if (this.screenFadeOutTransformation == null) {
                    containerController$AnimationTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(0.0f);
                    break;
                }
                containerController$AnimationTransformation = this.screenFadeOutTransformation;
                break;
            }
            case 24: {
                containerController$AnimationTransformation = IDENTITY_TRANSFORMATION;
                break;
            }
            default: {
                LC.log(10000, "ContainerController#getScreenChangeTransformation No case defined for screenChangeType = %1", (long)n);
            }
        }
        return containerController$AnimationTransformation;
    }

    private ContainerController$MutableAnimationTransformation createZTransformation(float f2, float f3) {
        float f4 = this.calculateCoordinate(this.getScreenWidth(), f2);
        float f5 = this.calculateCoordinate(this.getScreenHeight(), f2);
        return new ContainerController$MutableAnimationTransformation(f4, f5, f2, f3);
    }

    private float calculateCoordinate(float f2, float f3) {
        return f2 * (1.0f - f3) / 2.0f;
    }

    public boolean isDrawerOrMainAreaShown() {
        return this.targetTransformation == null || this.targetTransformation.equals(IDENTITY_TRANSFORMATION);
    }

    public boolean isIdentiyDisplayTransformation() {
        return this.currentDisplayTransformation == null || this.currentDisplayTransformation.equals(IDENTITY_TRANSFORMATION);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            AnimationController animationController = this.getAnimationController();
            if (animationController == null) {
                return null;
            }
            this.animation = animationController.getAnimation(this.animationType);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    @Override
    protected void destroyWidget() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }

    private AnimationController getAnimationController() {
        if (this.getTerminal() != null) {
            return (AnimationController)this.getTerminal().getIAnimationController();
        }
        return null;
    }

    @Override
    public void animate(int n, float f2) {
        if (n == this.animationType && this.startTransformation != null) {
            AbstractAnimation abstractAnimation = this.getAnimation();
            float f3 = AnimUtils.clamp(0.0f, 1.0f, abstractAnimation.getProgress() * ANIM_FACTORS[this.animState]);
            this.currentTransformations[3].copyFrom(this.startTransformation.getIntermediateTransformation(this.tempTransformation, this.targetTransformation, f3));
            this.targetTransformations[3] = this.currentTransformations[3];
            this.updateCurrentDisplayTransformation(true);
            this.setCompositesDirty(true);
        }
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        if (n == this.animationType) {
            this.targetTransformations[3] = this.targetTransformation;
            this.updateCurrentDisplayTransformation(true);
            if (this.closingOptionDrawer) {
                if (n == 53 && !this.terminal.getDrawerFocusManager().isUsePersistence()) {
                    this.resetFocusCursor = true;
                }
                if (this.menuController != null) {
                    this.menuController.setOnScreen(false);
                }
            }
            this.setCompositesDirty(true);
        }
    }

    public float getScaling() {
        return this.currentDisplayTransformation.getScale();
    }

    public float getTransX() {
        return this.currentDisplayTransformation.getTransX();
    }

    protected void setTransY(float f2) {
        this.transY = f2;
    }

    public float getTransY() {
        return this.currentDisplayTransformation.getTransY() + this.transY;
    }

    @Override
    public void setRenderer(CompositeRenderer compositeRenderer) {
        if (compositeRenderer instanceof ContainerRenderer) {
            this.renderer = compositeRenderer;
        } else {
            LC.log(10000, " renderer is not instance of ContainerRenderer ");
        }
    }

    public void setOptionMenuTransformation(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.optionMenuTransformation = new ContainerController$MutableAnimationTransformation(containerController$AnimationTransformation);
    }

    public void setOptionMenuTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.optionMenuTransformation = new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    public void setSelectionMenuTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.selectionMenuTransformation = new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    public void setEntertainmentMenuTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.entertainmentMenuTransformation = new ContainerController$MutableAnimationTransformation(f2, f3, f4, 1.0f);
    }

    public void setHideTransformation(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.hideTransformation = new ContainerController$MutableAnimationTransformation(containerController$AnimationTransformation);
    }

    public void setHideTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.hideTransformation = new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    private static ContainerController$MutableAnimationTransformation createScaleCenterAnimation(int n, int n2, int n3, int n4, float f2) {
        float f3 = (float)n3 - f2 * (float)n;
        float f4 = (float)n4 - f2 * (float)n2;
        return new ContainerController$MutableAnimationTransformation(f3, f4, f2, 0.0f);
    }

    public void setScreenOptionDrawerFadeInTransformation(float f2, float f3, float f4, float f5, float f6) {
    }

    public void setScreenOptionDrawerFadeOutTransformation(float f2, float f3, float f4, float f5, float f6) {
    }

    public void setSreenUpTransitionTransformation(float f2, float f3, float f4, float f5, float f6) {
        new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    public void setScreenFadeInTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.screenFadeInTransformation = new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    public void setScreenFadeOutTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.screenFadeOutTransformation = new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    public void setSreenDownTransitionTransformation(float f2, float f3, float f4, float f5, float f6) {
        new ContainerController$MutableAnimationTransformation(f2, f3, f4, f6);
    }

    public void setHideTransformationCenter(float f2, float f3, float f4) {
        this.hideCenterX = (int)f2;
        this.hideCenterY = (int)f3;
        this.hideScale = f4;
    }

    public ContainerController$AnimationTransformation getDrawerTransformation() {
        if (this.drawerAnimationType == 1) {
            return this.getStandardDrawerTransformation();
        }
        boolean bl = ScreenChangeAnimationItem$Helper.isTransition(this.target, 32) && ScreenChangeAnimationItem$Helper.isFade(this.target, 1) || ScreenChangeAnimationItem$Helper.isTransition(this.target, 64) && ScreenChangeAnimationItem$Helper.isFade(this.target, 2);
        return this.getHideTransformation(bl);
    }

    private boolean isDrawerMain() {
        return this.containerType == 2 && this.animationType == 53;
    }

    public ContainerController$AnimationTransformation getHideTransformation(boolean bl) {
        logDrawerAnimationDrawer.log(-2137614336, "ContainerController#getHideTransformation transitionForward=%1, this=%2", bl, (Object)this);
        if (this.hideScale >= 0.0f) {
            int n = bl ? 0x3333733F : 1717995071;
            RectangleParameters rectangleParameters = this.getRectangleParameters();
            if (rectangleParameters == null) {
                return ContainerController.createScaleCenterAnimation(0, 0, this.hideCenterX, this.hideCenterY, n);
            }
            int n2 = (int)((float)rectangleParameters.getX() + (float)rectangleParameters.getWidth() / 2.0f);
            int n3 = (int)((float)rectangleParameters.getY() + (float)rectangleParameters.getHeight() / 2.0f);
            return ContainerController.createScaleCenterAnimation(n2, n3, n2, n3, n);
        }
        if (this.hideTransformation == null) {
            this.hideTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(0.0f);
        }
        return this.hideTransformation;
    }

    public ContainerController$AnimationTransformation getStandardDrawerTransformation() {
        logDrawerAnimationDrawer.log(-2137614336, "ContainerController#getStandardDrawerTransformation, this=%1", (Object)this);
        if (this.hideScale >= 0.0f) {
            RectangleParameters rectangleParameters = this.getRectangleParameters();
            if (rectangleParameters == null) {
                return ContainerController.createScaleCenterAnimation(0, 0, this.hideCenterX, this.hideCenterY, this.hideScale);
            }
            int n = (int)((float)rectangleParameters.getX() + (float)rectangleParameters.getWidth() / 2.0f);
            int n2 = (int)((float)rectangleParameters.getY() + (float)rectangleParameters.getHeight() / 2.0f);
            return ContainerController.createScaleCenterAnimation(n, n2, this.hideCenterX, this.hideCenterY, this.hideScale);
        }
        if (this.hideTransformation == null) {
            this.hideTransformation = new ContainerController$MutableAnimationTransformation().setOpacity(0.0f);
        }
        return this.hideTransformation;
    }

    public ContainerController$AnimationTransformation getDrawerScreenChangeTransformation() {
        logDrawerAnimationDrawer.log(-2137614336, "ContainerController#getStandardDrawerTransformation, this=%1", (Object)this);
        return this.getScreenChangeTransformation(this.target);
    }

    @Override
    public void setScreenChangeProgress(float f2) {
    }

    @Override
    public void setScreenChangeTarget(int n) {
        int n2;
        if (logScreenChange.isDebug()) {
            logScreenChange.log(-2137614336, "ContainerController#setScreenChangeTarget this=%1, target=%2", (Object)this, (Object)ScreenChangeAnimationItem$Helper.getText(n));
        }
        LC.log(-2137614336, "ContainerController#setScreenChangeTarget target=%2, this=%1", (Object)this, (long)n);
        this.target = n;
        this.listenForScreenChange(true);
        CarViewerController carViewerController = this.getCarViewerController();
        if (carViewerController != null) {
            n2 = n & 0x1C;
            LC.log(-2137614336, "ContainerController#setScreenChangeTarget screenChangeType=%1", (long)n2);
            if (n2 == 4) {
                carViewerController.setIgnoreScreenChangeTransformation(false);
            } else {
                carViewerController.setIgnoreScreenChangeTransformation(true);
            }
        }
        n2 = this.isDrawerMain();
        boolean bl = ScreenChangeAnimationItem$Helper.isType(n, 8);
        if (n2 != 0 && bl) {
            this.drawerAnimationType = 2;
            this.targetTransformations[6] = this.getDrawerTransformation();
        } else {
            this.drawerAnimationType = 1;
        }
        this.targetTransformations[3] = this.startScreenChangeTransformation = this.getScreenChangeTransformation(n);
        if (this.containerType == 1 && ScreenChangeAnimationItem$Helper.isFade(n, 1)) {
            this.startScreenChangeTransformation.copyTo(this.currentTransformations[3]);
        }
        logScreenChange.log(-2137614336, "ContainerController#setScreenChangeTarget animating from %1 to %2", (Object)this.startScreenChangeTransformation, (Object)this.targetScreenChangeTransformation);
        this.combineCurrentTransformations(true);
        this.setCompositesDirty(true);
    }

    private void listenForScreenChange(boolean bl) {
        this.animationMask = bl ? (this.animationMask |= 0x1000) : (this.animationMask &= 0xFFFFEFFF);
    }

    private int getScreenWidth() {
        if (this.terminal == null) {
            LC.log(10000, "ContainerController#getScreenWidth: Terminal not available to get screen width. Using 1024");
            return 1024;
        }
        Layout layout = this.terminal.getLayout();
        return layout.getDistance(1);
    }

    private int getScreenHeight() {
        if (this.terminal == null) {
            LC.log(10000, "ContainerController#getScreenHeight: Terminal not available to get screen height. Using 480");
            return 480;
        }
        Layout layout = this.terminal.getLayout();
        return layout.getDistance(2);
    }

    public void setScreenFadeInTransformation(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.screenFadeInTransformation = containerController$AnimationTransformation;
    }

    public void setScreenFadeOutTransformation(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.screenFadeOutTransformation = containerController$AnimationTransformation;
    }

    private void updateCurrentDisplayTransformation(boolean bl) {
        if (this.currentviewSizeTransformation == null || IDENTITY_TRANSFORMATION.equals(this.currentviewSizeTransformation)) {
            this.currentTransformations[4].resetToIdentityTransformation();
        } else {
            this.currentTransformations[4].copyFrom(this.currentviewSizeTransformation);
        }
        if (this.currentPPTransform == null || IDENTITY_TRANSFORMATION.equals(this.currentPPTransform)) {
            this.currentTransformations[5].resetToIdentityTransformation();
        } else {
            this.currentTransformations[5].copyFrom(this.currentPPTransform);
        }
        this.combineCurrentTransformations(false);
        if (this.isEntertainmentController(this) || this.isEntertainmentController(this.parent)) {
            this.setOnScreen(ContainerController$MutableAnimationTransformation.access$200(this.currentDisplayTransformation) > 0.0f);
        }
        if (bl) {
            this.handleSharedTextureController();
        }
    }

    private boolean isEntertainmentController(AbstractWidget abstractWidget) {
        return abstractWidget instanceof EntertainmentDrawerContentController || abstractWidget instanceof EntertainmentDrawerOpenCloseController || abstractWidget instanceof EntertainmentDrawerController;
    }

    private void combineCurrentTransformations(boolean bl) {
        this.currentDisplayTransformation.resetToIdentityTransformation();
        for (int i2 = 0; i2 < 8; ++i2) {
            ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation = this.currentTransformations[i2];
            if (IDENTITY_TRANSFORMATION.equals(containerController$MutableAnimationTransformation)) continue;
            this.currentDisplayTransformation.combine(containerController$MutableAnimationTransformation);
        }
        this.currentDisplayTransformation.multiplyOpacity(this.smallStageSelectionDrawerOpacity * this.viewSizeOpacity);
        if (bl) {
            this.handleSharedTextureController();
        }
    }

    public void handleSharedTextureController() {
        if (!this.connected || this.fullScreenMapTexture == null) {
            return;
        }
        this.oldSharedTextureMapEnabled = this.sharedTextureMapEnabled;
        this.sharedTextureMapEnabled = this.currentDisplayTransformation.getTransX() != 0.0f || this.currentDisplayTransformation.getTransY() != 0.0f || this.currentDisplayTransformation.getScale() != 1.0f;
        LC.log(-2137614336, new StringBuffer().append("ContainerController#handleSharedTextureController: shared texture controller is: ").append(this.sharedTextureMapEnabled ? "enabled" : "disabled").toString());
        this.fullScreenMapTexture.setOnScreen(this.sharedTextureMapEnabled);
        if (this.kdkTexture != null) {
            int n = this.kdkTexture.getDisplayableID();
            if (n == -1) {
                IWidgetLogChannel.logKDK.log(-2137614336, "ContainerController#handleSharedTextureController displayable is NONE, set SharedTextureController onScreen=false");
                this.kdkTexture.setOnScreen(false);
            } else {
                IWidgetLogChannel.logKDK.log(-2137614336, "ContainerController#handleSharedTextureController displayable is %1, set SharedTextureController onScreen=%2", (Object)String.valueOf(n), (Object)String.valueOf(this.sharedTextureMapEnabled));
                this.kdkTexture.setOnScreen(this.sharedTextureMapEnabled);
            }
        }
        this.fullScreenMapTexture.setHMIBackgroundOpaque(this.sharedTextureMapEnabled);
    }

    public void setClippingWidget(AbstractWidgetController abstractWidgetController) {
    }

    @Override
    public void screenChangeFinished() {
        this.listenForScreenChange(false);
        this.target = 24;
    }

    @Override
    public AbstractWidgetController getScreenAreaWidget() {
        return this;
    }

    private AbstractScreenWidget getScreen() {
        AbstractWidget abstractWidget = this.getParent();
        if (abstractWidget == null) {
            return null;
        }
        if (!(abstractWidget instanceof AbstractScreenWidget)) {
            return null;
        }
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)abstractWidget;
        if (this.equals(abstractScreenWidget.getMainArea())) {
            return abstractScreenWidget;
        }
        return null;
    }

    @Override
    public void setPPDesaturation(float f2) {
        this.ppDesaturation = f2;
        IDENTITY_TRANSFORMATION.getIntermediateTransformation(this.currentPPTransform, this.getPPTransform(), f2);
        this.updateCurrentDisplayTransformation(true);
        this.setCompositesDirty(true);
    }

    private ContainerController$AnimationTransformation getPPTransform() {
        if (this.animationType == 54 || this.animationType == 55) {
            if (ENABLE_DRAWER_ICON_DESATURATION_WHEN_PARTIAL_POPUP_OPENS && !this.isMapScreen()) {
                return new ContainerController$MutableAnimationTransformation().setOpacity(63);
            }
            return new ContainerController$MutableAnimationTransformation().setOpacity(1.0f);
        }
        if (ENABLE_DRAWER_ICON_DESATURATION_WHEN_PARTIAL_POPUP_OPENS && !this.isMapScreen()) {
            return this.createZTransformation(-1883081409, 63);
        }
        return this.createZTransformation(-1883081409, 1.0f);
    }

    public float getMainAreaDesaturation() {
        return 1.0f - (1.0f - this.drawerDesaturationValue) * (1.0f - this.ppDesaturation);
    }

    private void setMaskOpacity(AbstractWidget abstractWidget, float f2) {
        if (abstractWidget == null) {
            return;
        }
        abstractWidget.setOpacity(f2);
        abstractWidget.setVisible(f2 > 0.0f);
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof IIdleTimerWidget) {
            if (this.idleTimers == null) {
                this.idleTimers = new ArrayList(3);
            }
            this.idleTimers.add(abstractWidget);
        }
        if (abstractWidget instanceof MenuController) {
            this.menuController = (MenuController)abstractWidget;
        }
    }

    @Override
    public void add(AbstractWidget abstractWidget, int n) {
        if (n == 1) {
            if (abstractWidget instanceof SharedTextureController) {
                this.fullScreenMapTexture = (SharedTextureController)abstractWidget;
            } else {
                LC.log(10000, "ContainerController#add role ROLE_FULLSCREEN_MAP can only be used with SharedTextureControllers");
            }
        } else if (n == 2) {
            this.menuDecorators.add(abstractWidget);
        } else if (n == 3) {
            if (this.selectionDrawerPreviewIconController != null) {
                LC.log(10000, "ContainerController#add SELECTION_DRAWER_PREVIEWS is already in use. Old widget: %1, new widget: %2", (Object)this.selectionDrawerPreviewIconController, (Object)abstractWidget);
            } else if (abstractWidget instanceof SelectionDrawerPreviewIconController) {
                this.selectionDrawerPreviewIconController = (SelectionDrawerPreviewIconController)abstractWidget;
            } else {
                LC.log(10000, "ContainerController#add SELECTION_DRAWER_PREVIEWS. Widget %1 is not instance of SelectionDrawerPreviewIconController", (Object)abstractWidget);
            }
        } else if (n == 6) {
            if (abstractWidget instanceof SharedTextureController) {
                this.kdkTexture = (SharedTextureController)abstractWidget;
            } else {
                LC.log(10000, "ContainerController#add role ROLE_KDK can only be used with SharedTextureControllers");
            }
        }
        this.add(abstractWidget);
    }

    @Override
    public boolean hasIdleTimer() {
        return this.idleTimers != null;
    }

    @Override
    public void restartIdleTimer() {
        if (this.idleTimers != null) {
            int n = this.idleTimers.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((IIdleTimerWidget)this.idleTimers.get(i2)).restartTimer();
            }
        }
    }

    @Override
    public void cancelIdleTimer() {
        if (this.idleTimers != null) {
            int n = this.idleTimers.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((IIdleTimerWidget)this.idleTimers.get(i2)).cancelTimer();
            }
        }
    }

    public int getAnimationType() {
        return this.animationType;
    }

    @Override
    public void setAnimationType(int n) {
        this.animationType = n;
        this.invertMask = n == 54 ? 2 : 31;
        this.containerType = 2;
        if (n == 54 || n == 55) {
            this.targetTransformations[6] = this.getStandardDrawerTransformation();
        }
        if (n == 54) {
            this.screenLayer = 4;
        }
        if (n == 55) {
            this.screenLayer = 5;
        }
    }

    @Override
    public void setMMICombiSyncMode(int n) {
        this.mmiCombiSyncMode = n;
    }

    @Override
    public int getMMICombiSyncMode() {
        return this.mmiCombiSyncMode;
    }

    @Override
    public boolean isVisible() {
        return this.mmiCombiSyncMode != 2 && super.isVisible();
    }

    public boolean isMapScreen() {
        AbstractScreenWidget abstractScreenWidget;
        if (this.screenManager == null) {
            if (this.terminal == null) {
                return false;
            }
            this.screenManager = framework.getHMITerminalRegistry().getTerminalContext(this.terminal.getTerminalID()).getScreenManager();
        }
        if ((abstractScreenWidget = (AbstractScreenWidget)this.screenManager.getCurrentConnectedScreen()) == null) {
            return false;
        }
        IDisplayControllerWidget iDisplayControllerWidget = abstractScreenWidget.getDisplayController();
        if (iDisplayControllerWidget == null) {
            return false;
        }
        return iDisplayControllerWidget.getTargetContextID() == 10 || iDisplayControllerWidget.getTargetContextID() == 16 || iDisplayControllerWidget.getTargetContextID() == 29;
    }

    @Override
    public void setOpacity(float f2) {
        this.currentDisplayTransformation = this.currentDisplayTransformation.setOpacity(f2);
    }

    @Override
    public float getOpacity() {
        return ContainerController$MutableAnimationTransformation.access$200(this.currentDisplayTransformation);
    }

    @Override
    public void predisconnecting() {
        super.predisconnecting();
        if (this.fullScreenMapTexture != null) {
            this.fullScreenMapTexture.setHMIBackgroundOpaque(true);
        }
        this.connected = false;
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.resetFocusCursor = false;
        this.targetScreenChangeTransformation = IDENTITY_TRANSFORMATION;
        this.startScreenChangeTransformation = IDENTITY_TRANSFORMATION;
        this.screenChangeTransformations.clear();
        this.ppDesaturation = 0.0f;
        this.currentPPTransform.resetToIdentityTransformation();
        this.currentTransformations[3].resetToIdentityTransformation();
        this.targetTransformations[3] = null;
        this.updateCurrentDisplayTransformation(false);
    }

    @Override
    public void initializeScreenChangeAnimation(Rectangular rectangular) {
        logScreenChange.log(1078071040, "ContainerController#initializeScreenChangeAnimation this=%1, rec=%2", (Object)this, (Object)rectangular);
    }

    @Override
    public boolean canOpen() {
        if (this.menuController == null) {
            return true;
        }
        return this.menuController.getFirstMenuItem() != null;
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        this.viewSizeWeights = fArray;
        this.updateSmallStageSelectionDrawerOpacity();
        this.calculateStageOpactiy(fArray, fArray2);
        if (!this.focusableInSmallStage) {
            IDENTITY_TRANSFORMATION.getIntermediateTransformation(this.currentviewSizeTransformation, this.getViewSizeTransformation(), fArray[0]);
        }
        this.updateCurrentDisplayTransformation(true);
        this.setCompositesDirty(true);
        super.setViewSizeAnimation(f2, fArray, fArray2, bl);
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
        super.viewSizeTargetChanged(fArray, fArray2, bl);
        this.calculateStageOpactiy(fArray, fArray2);
    }

    public void calculateStageOpactiy(float[] fArray, float[] fArray2) {
        if (this.opacitySet != null && this.isScreenTypeScreenShot()) {
            float f2 = this.opacitySet[0];
            float f3 = this.opacitySet[1];
            float f4 = Math.abs(f2 - f3);
            if (fArray2[0] == 1.0f) {
                this.isSmallStage = true;
                float f5 = f4 * fArray[0];
                this.viewSizeOpacity = f2 - (f2 > f3 ? f5 : -f5);
            } else {
                this.isSmallStage = false;
                float f6 = f4 * (1.0f - fArray[0]);
                this.viewSizeOpacity = f3 - (f2 > f3 ? -f6 : f6);
            }
        }
    }

    private boolean isScreenTypeScreenShot() {
        Screen screen = this.getInitContext().getScreen();
        if (!(screen instanceof AbstractScreenWidget)) {
            return false;
        }
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)screen;
        return abstractScreenWidget.getSmallStageType() == 3;
    }

    private boolean isScreenModeOptionScreen() {
        if (this.getInitContext() == null) {
            return false;
        }
        Screen screen = this.getInitContext().getScreen();
        if (!(screen instanceof AbstractScreenWidget)) {
            return false;
        }
        return ((AbstractScreenWidget)screen).getScreenMode() == 2;
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        this.viewSizeWeights = fArray;
        this.updateSmallStageSelectionDrawerOpacity();
        if (!this.focusableInSmallStage) {
            IDENTITY_TRANSFORMATION.getIntermediateTransformation(this.currentviewSizeTransformation, this.getViewSizeTransformation(), fArray[0]);
        }
        this.calculateStageOpactiy(fArray, fArray);
        if (this.opacitySet != null && this.isScreenTypeScreenShot()) {
            this.viewSizeOpacity = this.isSmallStage ? this.opacitySet[1] : this.opacitySet[0];
        }
        this.updateCurrentDisplayTransformation(true);
        this.setCompositesDirty(true);
        super.setViewSizeAnimationFinished(fArray, bl);
    }

    private boolean isCarArea() {
        return this.getCarViewerController() != null;
    }

    private ContainerController$AnimationTransformation getViewSizeTransformation() {
        if (this.viewSizeTransformation == null) {
            if (this.isCarArea()) {
                this.viewSizeTransformation = new ContainerController$MutableAnimationTransformation();
            } else {
                float f2 = 0.0f;
                if (this.terminal instanceof HMITerminalEvo) {
                    boolean bl;
                    boolean bl2 = bl = ((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1;
                    if (bl) {
                        Layout layout = this.terminal.getLayout();
                        f2 = layout.getIntegerConstant(95);
                    }
                }
                this.viewSizeTransformation = new ContainerController$MutableAnimationTransformation();
                this.viewSizeTransformation.move(37187, 23618 + f2, 0.0f).setScale(-1701242561);
            }
        }
        return this.viewSizeTransformation;
    }

    public void setViewSizeTransformation(int n, int n2) {
        this.viewSizeTransformation = ContainerController.createScaleCenterAnimation(0, 0, n, n2, -1701242561).setOpacity(1.0f);
    }

    public void setViewSizeTransformation(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.viewSizeTransformation = new ContainerController$MutableAnimationTransformation(containerController$AnimationTransformation);
    }

    @Override
    public boolean isFocusableInSmallStage() {
        return this.focusableInSmallStage;
    }

    @Override
    public void setFocusableInSmallStage(boolean bl) {
        this.focusableInSmallStage = bl;
    }

    @Override
    public void setNotFocusableIcon(AbstractWidgetController abstractWidgetController) {
        this.notFocusableIcon = (IconController)abstractWidgetController;
    }

    @Override
    public AbstractWidgetController getNotFocusableIcon() {
        return this.notFocusableIcon;
    }

    @Override
    public RectangleParameters getRectangleParameters() {
        if (this.menuController == null) {
            return null;
        }
        return new RectangleParameters(this.menuController);
    }

    @Override
    public void initializeScreenChangeAnimation() {
        if (logScreenChange.isInfo()) {
            logScreenChange.log(1078071040, "ContainerController#initializeScreenChangeAnimation this=%1, target=%2", (Object)this, (Object)ScreenChangeAnimationItem$Helper.getText(this.target));
        }
        this.setCompositesDirty(true);
    }

    public void setVisibleDirect(boolean bl) {
        if (!(this.renderer instanceof ContainerRenderer)) {
            return;
        }
        ContainerRenderer containerRenderer = (ContainerRenderer)this.renderer;
        containerRenderer.setVisibleDirect(bl);
    }

    public boolean hasDrawerScreenChangeAnimation() {
        return false;
    }

    public int getScreenLayer() {
        return this.screenLayer;
    }

    public void setScreenLayer(int n) {
        this.screenLayer = n;
    }

    @Override
    public AbstractWidget getMenuDecorator() {
        if (this.menuDecorator != null) {
            return this.menuDecorator;
        }
        if (this.menuDecorators == null || this.menuDecorators.isEmpty()) {
            return null;
        }
        if (this.menuDecorators.size() == 1) {
            this.menuDecorator = (AbstractWidget)this.menuDecorators.get(0);
            return this.menuDecorator;
        }
        Iterator iterator = this.menuDecorators.iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!abstractWidget.isVisible()) continue;
            this.menuDecorator = abstractWidget;
            break;
        }
        return this.menuDecorator;
    }

    public SelectionDrawerPreviewIconController getSelectionDrawerPreviewIconController() {
        return this.selectionDrawerPreviewIconController;
    }

    public void updateMenuInitialFocus() {
        if (this.menuController != null && this.menuController.getInitialization() != null) {
            this.menuController.getInitialization().updateInitialFocus();
        }
    }

    public CarViewerController getCarViewerController() {
        if (!this.searchedForCarViewer) {
            for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
                AbstractWidget abstractWidget = this.getChild(i2);
                if (!(abstractWidget instanceof CarViewerController)) continue;
                this.carViewerController = (CarViewerController)abstractWidget;
                this.searchedForCarViewer = true;
                break;
            }
            this.searchedForCarViewer = true;
        }
        return this.carViewerController;
    }

    @Override
    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
        if (this.containerType == 1) {
            if ((n & 0x20) != 0) {
                this.targetTransformations[5] = this.getPPTransform();
            }
            if (this.animationType == 53) {
                this.targetTransformations[0] = this.getScreenAreaTransformation(8, this.containerRole);
            } else if (this.animationType == 52) {
                this.targetTransformations[1] = this.getScreenAreaTransformation(4, this.containerRole);
            }
        } else if (this.containerType == 2) {
            this.targetTransformations[6] = this.getStandardDrawerTransformation();
            this.targetTransformations[3] = this.getDrawerScreenChangeTransformation();
        }
    }

    @Override
    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        if (logDrawerAnimation.isDebug2()) {
            logDrawerAnimation.log(14808325, "ContainerController#setDrawerAnimation this=%1", (Object)this);
            logDrawerAnimation.log(14808325, "ContainerController#setDrawerAnimation current=%1", (Object)Util.arrayToString(fArray));
            logDrawerAnimation.log(14808325, "ContainerController#setDrawerAnimation target=%1", (Object)Util.arrayToString(fArray2));
            logDrawerAnimation.log(14808325, "ContainerController#setDrawerAnimation mask=%1", (Object)Integer.toBinaryString(n));
        }
        this.updateSelectionDrawerValue(fArray);
        boolean bl = this.updateTransformations(fArray, n & this.getDrawerAnimationMask());
        if (bl) {
            this.combineCurrentTransformations(true);
        }
        this.updateMasks(fArray, n);
        this.setCompositesDirty(true);
        if (this.renderer instanceof ContainerRenderer && this.isConnected() && this.containerType == 2) {
            ((ContainerRenderer)this.renderer).setScreenChangeProgress(0.0f);
        }
    }

    private void updateSelectionDrawerValue(float[] fArray) {
        float f2 = fArray == null ? 0.0f : fArray[0];
        if (this.selectionDrawerValue == f2) {
            return;
        }
        this.selectionDrawerValue = f2;
        this.updateSmallStageSelectionDrawerOpacity();
    }

    private void updateSmallStageSelectionDrawerOpacity() {
        if (this.containerType != 1 || !this.hideSmallStageContentOnOpenSelectionDrawer || this.viewSizeWeights == null) {
            this.smallStageSelectionDrawerOpacity = 1.0f;
            return;
        }
        float f2 = this.viewSizeWeights[0];
        this.smallStageSelectionDrawerOpacity = 1.0f - f2 * this.selectionDrawerValue;
    }

    private void updateMasks(float[] fArray, int n) {
        float f2;
        float f3;
        float f4;
        AbstractScreenWidget abstractScreenWidget = this.getScreen();
        if (abstractScreenWidget == null) {
            return;
        }
        if (abstractScreenWidget.getSelectionMask() != null && (0x1081 & n) != 0) {
            float f5 = fArray[0];
            f4 = fArray[7];
            f3 = fArray[12];
            f2 = f5 * -842249153 + f4 * -859026370;
            this.setMaskOpacity(abstractScreenWidget.getSelectionMask(), f2 *= 1.0f - f3);
        }
        if ((0x1004 & n) != 0) {
            f4 = fArray[2];
            f3 = fArray[12];
            f2 = f4 * (1.0f - f3);
            this.setMaskOpacity(abstractScreenWidget.getOptionMask(), f2);
        }
        if ((0x20 & n) != 0 || this.oldSharedTextureMapEnabled != this.sharedTextureMapEnabled) {
            if (this.sharedTextureMapEnabled) {
                this.setMaskOpacity(abstractScreenWidget.getPartialPopupMask(), 0.0f);
            } else if (this.isMapScreen()) {
                this.setMaskOpacity(abstractScreenWidget.getPartialPopupMask(), 0.0f);
            } else {
                this.setMaskOpacity(abstractScreenWidget.getPartialPopupMask(), fArray[5] * 16447);
            }
        }
    }

    private boolean updateTransformations(float[] fArray, int n) {
        boolean bl = false;
        if (this.containerType == 2) {
            bl = this.updateDrawerTransformations(fArray, n, bl);
            bl = this.updateTransformation(fArray, n, 5, 5) || bl;
        } else if (this.containerType == 1) {
            bl = this.updateTransformation(fArray, n, 2, 0) || bl;
            bl = this.updateTransformation(fArray, n, 0, 1) || bl;
            bl = this.updateTransformation(fArray, n, 4, 2) || bl;
            bl = this.updateTransformation(fArray, n, 6, 7) || bl;
        }
        bl = this.updateTransformation(fArray, n, 12, 3) || bl;
        bl = this.updateTransformation(fArray, n, 7, 4) || bl;
        return bl;
    }

    private boolean updateDrawerTransformations(float[] fArray, int n, boolean bl) {
        if (this.animationType == 54) {
            bl = this.updateTransformation(fArray, n, 2, 0) || bl;
            bl = this.updateTransformation(fArray, n, 3, 6) || bl;
            bl = this.updateTransformation(fArray, n, 0, 1) || bl;
            bl = this.updateTransformation(fArray, n, 1, 6) || bl;
            bl = this.updateTransformation(fArray, n, 4, 2) || bl;
        } else {
            bl = this.updateTransformation(fArray, n, 2, 6) || bl;
            bl = this.updateTransformation(fArray, n, 3, 6) || bl;
            bl = this.updateTransformation(fArray, n, 0, 6) || bl;
            bl = this.updateTransformation(fArray, n, 1, 6) || bl;
            bl = this.updateTransformation(fArray, n, 4, 6) || bl;
        }
        return bl;
    }

    private boolean updateTransformation(float[] fArray, int n, int n2, int n3) {
        int n4 = 1 << n2;
        if ((n & n4) == 0) {
            return false;
        }
        ContainerController$AnimationTransformation containerController$AnimationTransformation = this.targetTransformations[n3];
        boolean bl = (this.invertMask & n4) != 0;
        float f2 = fArray == null ? 0.0f : fArray[n2];
        float f3 = bl ? 1.0f - f2 : f2;
        return this.updateTransformation(f3, n3, containerController$AnimationTransformation);
    }

    private boolean updateTransformation(float f2, int n, ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        boolean bl;
        ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation = this.currentTransformations[n];
        if (containerController$AnimationTransformation == null || IDENTITY_TRANSFORMATION.equals(containerController$AnimationTransformation) || f2 <= 0.0f) {
            bl = containerController$MutableAnimationTransformation != null && !IDENTITY_TRANSFORMATION.equals(containerController$MutableAnimationTransformation);
            this.currentTransformations[n].resetToIdentityTransformation();
        } else {
            IDENTITY_TRANSFORMATION.getIntermediateTransformation(this.intermediateTransformation, containerController$AnimationTransformation, f2);
            bl = !this.intermediateTransformation.equals(containerController$MutableAnimationTransformation);
            this.currentTransformations[n].copyFrom(this.intermediateTransformation);
        }
        return bl;
    }

    @Override
    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        this.setDrawerAnimation(fArray, fArray2, n);
        this.setCompositesDirty(true);
    }

    @Override
    public int getDrawerAnimationMask() {
        return this.animationMask;
    }

    @Override
    public void setDrawerAnimationMask(int n) {
        this.animationMask = n;
    }

    private void clearTransformations() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.targetTransformations[i2] = null;
            this.currentTransformations[i2].resetToIdentityTransformation();
        }
    }

    @Override
    public boolean isTransitionForward() {
        return this.transitionForward;
    }

    @Override
    public void setTransitionForward(boolean bl) {
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.transitionForward = true;
        this.drawerAnimationType = 16;
        this.connected = true;
    }

    @Override
    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation = this.currentTransformations[3];
        this.clearTransformations();
        if (this.containerType == 2) {
            this.targetTransformations[6] = this.getStandardDrawerTransformation();
            this.targetTransformations[3] = this.getDrawerScreenChangeTransformation();
            this.updateSelectionDrawerValue(null);
            if (this.animationType == 54) {
                this.targetTransformations[0] = this.getScreenAreaTransformation(8, this.containerRole);
                this.targetTransformations[1] = this.getScreenAreaTransformation(4, this.containerRole);
                this.targetTransformations[2] = this.getScreenAreaTransformation(32, this.containerRole);
                this.targetTransformations[5] = this.getPPTransform();
            } else if (this.animationType == 55) {
                this.targetTransformations[5] = this.getPPTransform();
            }
        } else if (this.containerType == 1) {
            this.targetTransformations[0] = this.getScreenAreaTransformation(8, this.containerRole);
            this.targetTransformations[1] = this.getScreenAreaTransformation(4, this.containerRole);
            this.targetTransformations[2] = this.getScreenAreaTransformation(32, this.containerRole);
            if (!this.focusableInSmallStage) {
                this.targetTransformations[4] = this.getViewSizeTransformation();
            }
            containerController$MutableAnimationTransformation.copyTo(this.currentTransformations[3]);
            this.targetTransformations[7] = this.createSdsTransformation(this.containerRole);
        }
        this.updateMasks(fArray, this.animationMask);
        this.updateSelectionDrawerValue(fArray);
        this.updateTransformations(fArray, this.animationMask);
        this.combineCurrentTransformations(true);
        this.setCompositesDirty(true);
    }

    public float getOptionDrawerOpacity() {
        return this.currentTransformations[0].getOpacity();
    }

    public ContainerController$AnimationTransformation getSelectionDrawerTransformation() {
        return this.currentTransformations[1];
    }

    public ContainerController$AnimationTransformation getTargetSelectionDrawerTransformation() {
        return this.getScreenAreaTransformation(4, 1);
    }

    public ContainerController$AnimationTransformation getOptionDrawerTransformation() {
        return this.currentTransformations[0];
    }

    public ContainerController$AnimationTransformation getTargetOptionDrawerTransformation() {
        return this.getScreenAreaTransformation(8, 1);
    }

    public ContainerController$AnimationTransformation getEntertainmentDrawerTransformation() {
        return this.currentTransformations[2];
    }

    public ContainerController$AnimationTransformation getCurrentScreenChangeTransformation() {
        return this.currentTransformations[3];
    }

    public float[] getOpacitySet() {
        return this.opacitySet;
    }

    public void setOpacitySet(float f2, float f3) {
        if (this.opacitySet == null) {
            this.opacitySet = new float[2];
        }
        this.opacitySet[0] = f2;
        this.opacitySet[1] = f3;
    }

    @Override
    public void setDrawerAnimationType(int n) {
        this.drawerAnimationType = n;
    }

    @Override
    public void hideDrawerItem() {
        this.clearTransformations();
        this.targetTransformations[6] = this.getDrawerTransformation();
        this.currentTransformations[6].resetToIdentityTransformation();
        this.targetTransformations[3] = this.getDrawerScreenChangeTransformation();
        this.targetTransformations[3].copyTo(this.currentTransformations[3]);
        this.updateSelectionDrawerValue(null);
        this.updateTransformations(null, this.animationMask);
        this.combineCurrentTransformations(true);
        this.setCompositesDirty(true);
    }

    public void setNoScreenChangeAnimation(boolean bl) {
        this.noScreenChangeAnimation = bl;
    }

    @Override
    public boolean canClose() {
        return true;
    }

    public boolean isHideSmallStageContentOnSelectionDrawer() {
        return this.hideSmallStageContentOnOpenSelectionDrawer;
    }

    public void setHideSmallStageContentOnSelectionDrawer(boolean bl) {
        this.hideSmallStageContentOnOpenSelectionDrawer = bl;
    }

    public float getSmallStageSelectionDrawerOpacity() {
        return this.smallStageSelectionDrawerOpacity;
    }

    public void setPassOnOpacityToPartialPopups(boolean bl) {
        this.passOnOpacityToPartialPopups = bl;
    }

    public boolean isPassOnOpacityToPartialPopups() {
        return this.passOnOpacityToPartialPopups;
    }

    @Override
    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    @Override
    public boolean hasVisibleFocusCursor() {
        AbstractWidget abstractWidget;
        if (this.menuController != null && (abstractWidget = this.menuController.getChildOfRole(1)) instanceof FocusCursorController) {
            return abstractWidget.isVisibleInHierarchy();
        }
        return false;
    }

    static /* synthetic */ ContainerController$AnimationTransformation access$000() {
        return IDENTITY_TRANSFORMATION;
    }

    static /* synthetic */ LogChannel access$100() {
        return LC;
    }

    static {
        ANIM_FACTORS = new float[]{1.0f, 16448, 16448};
        IDENTITY_TRANSFORMATION = new ContainerController$MutableAnimationTransformation(0.0f, 0.0f, 1.0f, 1.0f);
        if (AbstractWidget.framework != null) {
            LC = logContainer;
            ENABLE_DRAWER_ICON_DESATURATION_WHEN_PARTIAL_POPUP_OPENS = !AbstractWidget.isScreenResolution1440();
        } else {
            LC = null;
            ENABLE_DRAWER_ICON_DESATURATION_WHEN_PARTIAL_POPUP_OPENS = false;
            System.err.println("ContainerController: Warning: no framework available");
        }
    }
}

