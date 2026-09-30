/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.animation.CombinedAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.CarViewerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewSizeAnimationManager
implements AnimationListener {
    private final AnimationController animationController;
    private final DrawerAnimationManager drawerAnimationManager;
    private CombinedAnimation animation;
    private final float[] currentWeights;
    private final float[] targetWeights;
    private final int ANIMATION_TYPE;
    private static final float ANIMATION_VALUE_BIG_STAGE = 0.0f;
    private static final float ANIMATION_VALUE_SMALL_STAGE = 1.0f;
    private final List screens = new ArrayList(3);
    private int requestedViewSize = -1;
    private final float[] previousWeights;
    private boolean fadeIn;
    private static final LogChannel LC;
    private boolean fireAnimationStarted;

    public ViewSizeAnimationManager(AnimationController animationController, DrawerAnimationManager drawerAnimationManager, int n) {
        this.ANIMATION_TYPE = 51;
        this.currentWeights = new float[n - 1];
        this.targetWeights = new float[n - 1];
        this.previousWeights = new float[n - 1];
        this.animationController = animationController;
        this.drawerAnimationManager = drawerAnimationManager;
    }

    public void addScreen(AbstractScreenWidget abstractScreenWidget) {
        boolean bl;
        if (this.screens.contains(abstractScreenWidget)) {
            IWidgetLogChannel.screenLogChannel.log(10000, "ViewSizeAnimationManager#addScreen: Screen is already registered: %1,   registered screens: %2", (Object)abstractScreenWidget, (Object)this.screens);
            this.screens.remove(abstractScreenWidget);
        }
        this.screens.add(abstractScreenWidget);
        if (this.animation != null) {
            this.animation.setRepaintTarget(abstractScreenWidget);
        }
        boolean bl2 = bl = abstractScreenWidget.getSmallStageType() != 3;
        if (this.isAnimationRunning()) {
            LC.log(1000000, "ViewsizeAnimationManager#addScreen screen=%1, adjustBounds=%2, animation is running", (Object)abstractScreenWidget, (Object)bl);
            ViewSizeAnimationManager.setScreenViewSizeAnimation(abstractScreenWidget, this.currentWeights, this.targetWeights, this.animation.getProgress(), false);
        } else {
            LC.log(1000000, "ViewsizeAnimationManager#addScreen screen=%1, adjustBounds=%2, animation is not running", (Object)abstractScreenWidget, (Object)bl);
            ViewSizeAnimationManager.setScreenViewSizeAnimationFinished(abstractScreenWidget, this.targetWeights, true, true);
        }
    }

    public void removeScreen(AbstractScreenWidget abstractScreenWidget) {
        this.screens.remove(abstractScreenWidget);
    }

    public void setTargetWeights(float[] fArray, boolean bl, int n) {
        if (LC.isInfo()) {
            LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights weight=%1", (double)fArray[0]);
            LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights animate=%1, viewSize=%2", (Object)bl, (long)n);
        }
        System.arraycopy((Object)fArray, 0, (Object)this.targetWeights, 0, this.targetWeights.length);
        if (!bl) {
            System.arraycopy((Object)this.targetWeights, 0, (Object)this.currentWeights, 0, this.currentWeights.length);
        }
        if (this.drawerAnimationManager != null) {
            this.drawerAnimationManager.viewSizeChanged(this.currentWeights, this.targetWeights);
        }
        boolean bl2 = this.isAnimationRunning();
        LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights animationIsRunning=%1", bl2);
        if (this.screens.isEmpty()) {
            LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights no screens available");
            this.requestedViewSize = n;
            if (bl2) {
                LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights stopping animation");
                this.animation.stopAnimation();
            }
            return;
        }
        Iterator iterator = this.screens.iterator();
        AbstractScreenWidget abstractScreenWidget = null;
        while (iterator.hasNext()) {
            abstractScreenWidget = (AbstractScreenWidget)iterator.next();
            ViewSizeAnimationManager.setScreenViewSizeTargetChanged(abstractScreenWidget, this.currentWeights, this.targetWeights, bl);
        }
        if (bl) {
            float[] fArray2;
            float[] fArray3;
            CombinedAnimation combinedAnimation = (CombinedAnimation)this.getAnimation();
            this.fadeIn = n == 2;
            LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights setting fadeIn to %1", this.fadeIn);
            if (bl2) {
                if (this.requestedViewSize == n) {
                    LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights animation running, requestedViewSize == targetViewSize");
                    return;
                }
                LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights animation running, rollBack");
                combinedAnimation.rollBackAnimation(true);
                this.requestedViewSize = n;
                return;
            }
            this.requestedViewSize = n;
            if (this.fadeIn) {
                fArray3 = new float[]{0.0f, 1.0f, 0.0f};
                fArray2 = new float[]{1000.0f, 0.0f, 1000.0f};
            } else {
                fArray3 = new float[]{0.0f, 0.0f, 0.0f};
                fArray2 = new float[]{1000.0f, 1.0f, 1000.0f};
            }
            int[] nArray = new int[]{56, 57, 56};
            boolean[] blArray = new boolean[]{false, this.fadeIn, true};
            this.fireAnimationStarted = true;
            LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights starting animation");
            combinedAnimation.startCombinedAnimation(51, fArray3, fArray2, nArray, blArray, (AbstractScreenWidget)this.screens.get(this.screens.size() - 1));
        } else {
            this.requestedViewSize = n;
            if (bl2) {
                LC.log(1000000, "ViewsizeAnimationManager#setTargetWeights stopping animation");
                this.animation.stopAnimation();
                boolean bl3 = this.checkProgressCrossedStageDivider(fArray);
                iterator = this.screens.iterator();
                while (iterator.hasNext()) {
                    abstractScreenWidget = (AbstractScreenWidget)iterator.next();
                    ViewSizeAnimationManager.setScreenViewSizeAnimation(abstractScreenWidget, this.currentWeights, this.targetWeights, this.animation.getProgress(), bl3);
                }
            } else {
                boolean bl4 = this.checkProgressCrossedStageDivider(fArray);
                iterator = this.screens.iterator();
                while (iterator.hasNext()) {
                    abstractScreenWidget = (AbstractScreenWidget)iterator.next();
                    ViewSizeAnimationManager.setScreenViewSizeAnimationFinished(abstractScreenWidget, fArray, bl4, true);
                }
            }
            this.requestedViewSize = n;
        }
    }

    public void setCurrentViewSizeOnWidget(AbstractWidgetController abstractWidgetController) {
        LC.log(1000000, "ViewsizeAnimationManager#setCurrentViewSizeOnWidget widget=%1", (Object)abstractWidgetController);
        boolean bl = true;
        if (this.isAnimationRunning()) {
            LC.log(1000000, "ViewsizeAnimationManager#setCurrentViewSizeOnWidget animation is running, current=%1, target=%2", (double)this.currentWeights[0], (double)this.targetWeights[0], 0.0);
            ViewSizeAnimationManager.setViewSizeAnimation(abstractWidgetController, this.currentWeights, this.targetWeights, this.animation.getProgress(), bl, false);
        } else {
            LC.log(1000000, "ViewsizeAnimationManager#setCurrentViewSizeOnWidget animation not running, target=%1", (double)this.targetWeights[0]);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(abstractWidgetController, this.targetWeights, bl, true, true);
        }
    }

    private IAnimation getAnimation() {
        if (this.animation != null) {
            return this.animation;
        }
        LC.log(1000000, "ViewsizeAnimationManager#getAnimation creating animation object for type=%1", 51L);
        this.animation = this.animationController.getCombinedAnimation(51);
        this.animation.addListener(this);
        return this.animation;
    }

    public boolean isAnimationRunning() {
        return this.animation != null && this.animation.isAnimating();
    }

    private static void setScreenViewSizeAnimation(AbstractScreenWidget abstractScreenWidget, float[] fArray, float[] fArray2, float f2, boolean bl) {
        LC.log(1000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation widget=%1", (Object)abstractScreenWidget);
        if (((HMITerminalEvo)abstractScreenWidget.getTerminal()).getSkin() != 1) {
            ScreenMainArea screenMainArea;
            boolean bl2;
            ScreenMainArea screenMainArea2 = abstractScreenWidget.getMainArea();
            boolean bl3 = bl2 = abstractScreenWidget.getSmallStageType() != 3;
            if (screenMainArea2 != null) {
                LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation mainArea=%1", (Object)screenMainArea2);
                ViewSizeAnimationManager.setViewSizeAnimation(screenMainArea2.getScreenAreaWidget(), fArray, fArray2, f2, bl2, bl);
            }
            if ((screenMainArea = abstractScreenWidget.getTitleArea()) != null) {
                LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation titleArea=%1", (Object)screenMainArea);
                ViewSizeAnimationManager.setViewSizeAnimation(screenMainArea.getScreenAreaWidget(), fArray, fArray2, f2, bl2, bl);
            }
            List list = abstractScreenWidget.getSpecialAreas();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ScreenMainArea screenMainArea3 = (ScreenMainArea)iterator.next();
                LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation specialArea=%1", (Object)screenMainArea3);
                ViewSizeAnimationManager.setViewSizeAnimation(screenMainArea3.getScreenAreaWidget(), fArray, fArray2, f2, true, bl);
            }
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(0));
            if (abstractWidgetController != null) {
                LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation visiblePP=%1", (Object)abstractWidgetController);
                ViewSizeAnimationManager.setViewSizeAnimation(abstractWidgetController, fArray, fArray2, f2, true, bl);
            }
            if ((abstractWidgetController = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(11))) != null) {
                LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation visiblePP=%1", (Object)abstractWidgetController);
                ViewSizeAnimationManager.setViewSizeAnimation(abstractWidgetController, fArray, fArray2, f2, true, bl);
            }
            if ((abstractWidgetController = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(3))) != null) {
                LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation statusbar=%1", (Object)abstractWidgetController);
                ViewSizeAnimationManager.setViewSizeAnimation(abstractWidgetController, fArray, fArray2, f2, true, bl);
            }
        } else {
            LC.log(100000000, "ViewsizeAnimationManager#setScreenViewSizeAnimation tts-skin");
            if (fArray[0] > 0.5f) {
                ViewSizeAnimationManager.setScreenViewSizeAnimationFinished(abstractScreenWidget, new float[]{1.0f}, bl, false);
            } else {
                ViewSizeAnimationManager.setScreenViewSizeAnimationFinished(abstractScreenWidget, new float[]{0.0f}, bl, false);
            }
        }
    }

    private static void setViewSizeAnimation(AbstractWidgetController abstractWidgetController, float[] fArray, float[] fArray2, float f2, boolean bl, boolean bl2) {
        Object object;
        int n;
        LC.log(100000000, "ViewsizeAnimationManager#setViewSizeAnimation adjustBounds=%1, widget=%2", bl, (Object)abstractWidgetController);
        int[] nArray = abstractWidgetController.getCoordinateSets();
        if (nArray != null) {
            ViewSizeAnimationManager.setWeightedBounds(abstractWidgetController, nArray, fArray, bl);
        }
        if ((n = abstractWidgetController.getChildrenSize()) > 0) {
            object = abstractWidgetController.getChildren();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)object.get(i2);
                ViewSizeAnimationManager.setViewSizeAnimation(abstractWidgetController2, fArray, fArray2, f2, bl, bl2);
            }
        }
        if (abstractWidgetController instanceof IViewSizeAnimatable) {
            object = (IViewSizeAnimatable)((Object)abstractWidgetController);
            LC.log(100000000, "ViewsizeAnimationManager#setViewSizeAnimation calling setViewSizeAnimation on %1", (Object)abstractWidgetController);
            object.setViewSizeAnimation(f2, fArray, fArray2, bl2);
        }
    }

    private boolean checkProgressCrossedStageDivider(float[] fArray) {
        boolean bl = this.isBigStage(fArray) != this.isBigStage(this.previousWeights);
        System.arraycopy((Object)fArray, 0, (Object)this.previousWeights, 0, this.previousWeights.length);
        return bl;
    }

    private boolean isBigStage(float[] fArray) {
        return fArray == null || fArray[0] < 0.5f;
    }

    private static int getWeightedValue(int[] nArray, float[] fArray, int n) {
        int n2 = nArray[1 + n];
        float f2 = n2;
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            int n3 = nArray[5 + i2 * 4 + n] - n2;
            f2 += fArray[i2] * (float)n3;
        }
        return Math.round(f2);
    }

    private static void setScreenViewSizeTargetChanged(AbstractScreenWidget abstractScreenWidget, float[] fArray, float[] fArray2, boolean bl) {
        Object object;
        ScreenMainArea screenMainArea;
        LC.log(1000000, "ViewsizeAnimationManager#setScreenViewSizeTargetChanged widget=%1", (Object)abstractScreenWidget);
        ScreenMainArea screenMainArea2 = abstractScreenWidget.getMainArea();
        if (screenMainArea2 != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeTargetChanged mainArea=%1", (Object)screenMainArea2);
            ViewSizeAnimationManager.viewSizeTargetChanged(screenMainArea2.getScreenAreaWidget(), fArray, fArray2, bl);
        }
        if ((screenMainArea = abstractScreenWidget.getTitleArea()) != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeTargetChanged titleArea=%1", (Object)screenMainArea);
            ViewSizeAnimationManager.viewSizeTargetChanged(screenMainArea.getScreenAreaWidget(), fArray, fArray2, bl);
        }
        List list = abstractScreenWidget.getSpecialAreas();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            object = (ScreenMainArea)iterator.next();
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeTargetChanged specialArea=%1", object);
            ViewSizeAnimationManager.viewSizeTargetChanged(object.getScreenAreaWidget(), fArray, fArray2, bl);
        }
        object = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(0));
        if (object != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeTargetChanged visiblePP=%1", object);
            ViewSizeAnimationManager.viewSizeTargetChanged((AbstractWidgetController)object, fArray, fArray2, bl);
        }
    }

    private static void setScreenViewSizeAnimationFinished(AbstractScreenWidget abstractScreenWidget, float[] fArray, boolean bl, boolean bl2) {
        ScreenMainArea screenMainArea;
        ScreenMainArea screenMainArea2 = abstractScreenWidget.getMainArea();
        int n = abstractScreenWidget.getSmallStageType();
        boolean bl3 = n != 3 && n != 8;
        LC.log(1000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished widget=%2, adjustBounds=%1", (Object)bl3, (Object)abstractScreenWidget);
        if (screenMainArea2 != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished mainArea=%1", (Object)screenMainArea2);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(screenMainArea2.getScreenAreaWidget(), fArray, bl3, bl, bl2);
        }
        if ((screenMainArea = abstractScreenWidget.getTitleArea()) != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished titleArea=%1", (Object)screenMainArea);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(screenMainArea.getScreenAreaWidget(), fArray, bl3, bl, bl2);
        }
        List list = abstractScreenWidget.getSpecialAreas();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea3 = (ScreenMainArea)iterator.next();
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished specialArea=%1", (Object)screenMainArea3);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(screenMainArea3.getScreenAreaWidget(), fArray, true, bl, bl2);
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(0));
        if (abstractWidgetController != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished visiblePP=%1", (Object)abstractWidgetController);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(abstractWidgetController, fArray, true, bl, bl2);
        }
        if ((abstractWidgetController = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(11))) != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished visiblePP=%1", (Object)abstractWidgetController);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(abstractWidgetController, fArray, true, bl, bl2);
        }
        if ((abstractWidgetController = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(3))) != null) {
            LC.log(10000000, "ViewsizeAnimationManager#setScreenViewSizeAnimationFinished statusbar=%1", (Object)abstractWidgetController);
            ViewSizeAnimationManager.setViewSizeAnimationFinished(abstractWidgetController, fArray, true, bl, bl2);
        }
    }

    private static void setViewSizeAnimationFinished(AbstractWidgetController abstractWidgetController, float[] fArray, boolean bl, boolean bl2, boolean bl3) {
        Object object;
        int n;
        LC.log(100000000, "ViewsizeAnimationManager#setViewSizeAnimationFinished adjustBounds=%1, widget=%2", bl, (Object)abstractWidgetController);
        int[] nArray = abstractWidgetController.getCoordinateSets();
        if (nArray != null) {
            ViewSizeAnimationManager.setWeightedBounds(abstractWidgetController, nArray, fArray, bl);
        }
        if ((n = abstractWidgetController.getChildrenSize()) > 0) {
            object = abstractWidgetController.getChildren();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)object.get(i2);
                ViewSizeAnimationManager.setViewSizeAnimationFinished(abstractWidgetController2, fArray, bl, bl2, bl3);
            }
        }
        if (abstractWidgetController instanceof IViewSizeAnimatable) {
            object = (IViewSizeAnimatable)((Object)abstractWidgetController);
            LC.log(100000000, "ViewsizeAnimationManager#setViewSizeAnimationFinished calling setViewSizeAnimationFinished on %1", (Object)abstractWidgetController);
            object.setViewSizeAnimationFinished(fArray, bl2);
            if (bl3 && abstractWidgetController instanceof CarViewerController) {
                CarViewerController carViewerController = (CarViewerController)abstractWidgetController;
                carViewerController.setViewSizeAnimationReallyFinished(fArray, bl2);
            }
        }
    }

    private static void viewSizeTargetChanged(AbstractWidgetController abstractWidgetController, float[] fArray, float[] fArray2, boolean bl) {
        Object object;
        LC.log(100000000, "ViewsizeAnimationManager#viewSizeTargetChanged widget=%1", (Object)abstractWidgetController);
        int n = abstractWidgetController.getChildrenSize();
        if (n > 0) {
            object = abstractWidgetController.getChildren();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)object.get(i2);
                ViewSizeAnimationManager.viewSizeTargetChanged(abstractWidgetController2, fArray, fArray2, bl);
            }
        }
        if (abstractWidgetController instanceof IViewSizeAnimatable) {
            object = (IViewSizeAnimatable)((Object)abstractWidgetController);
            LC.log(100000000, "ViewsizeAnimationManager#viewSizeTargetChanged calling viewSizeTargetChanged on %1", (Object)abstractWidgetController);
            object.viewSizeTargetChanged(fArray, fArray2, bl);
        }
    }

    private static void setWeightedBounds(AbstractWidgetController abstractWidgetController, int[] nArray, float[] fArray, boolean bl) {
        LC.log(100000000, "ViewsizeAnimationManager#setWeightedBounds adjustBounds=%1, widget=%2", bl, (Object)abstractWidgetController);
        float[] fArray2 = bl || abstractWidgetController instanceof SmallStageApplicationIconController ? fArray : ScreenWidgetEVO.BIG_STAGE;
        float f2 = ViewSizeAnimationManager.calculateOpacityForViewSize(nArray, fArray2);
        abstractWidgetController.setVisibleOnCurrentStage(f2 > 0.0f);
        abstractWidgetController.setViewSizeOpacity(f2);
        int n = ViewSizeAnimationManager.getWeightedValue(nArray, fArray2, 0);
        int n2 = ViewSizeAnimationManager.getWeightedValue(nArray, fArray2, 1);
        int n3 = ViewSizeAnimationManager.getWeightedValue(nArray, fArray2, 2);
        int n4 = ViewSizeAnimationManager.getWeightedValue(nArray, fArray2, 3);
        if (LC.isDebug2()) {
            LC.log(100000000, "ViewsizeAnimationManager#setWeightedBounds x=%1, y=%2, opacity=%3", (double)n, (double)n2, (double)f2);
            LC.log(100000000, "ViewsizeAnimationManager#setWeightedBounds width=%1, height=%2", (long)n3, (long)n4);
        }
        abstractWidgetController.setBounds(n, n2, n3, n4);
        abstractWidgetController.invalidateParentLayout();
    }

    public static float calculateOpacityForViewSize(int[] nArray, float[] fArray) {
        float f2;
        int n = nArray[0];
        float f3 = f2 = (float)(n & 1);
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            float f4 = (n & 1 << i2 + 1) == 0 ? 0.0f : 1.0f;
            f3 += fArray[i2] * (f4 - f2);
        }
        return f3;
    }

    public void animate(int n, float f2, int n2) {
        this.animate(n, f2);
    }

    public void animate(int n, float f2) {
        if (this.animation == null) {
            return;
        }
        if (n != 57) {
            if (LC.isDebug2()) {
                LC.log(100000000, "ViewsizeAnimationManager#animate ignoring animation of type %2, fade=%1", (Object)this.animation.isFadeIn(), (long)n);
                LC.log(100000000, "ViewsizeAnimationManager#animate value=%1", (double)f2);
            }
            return;
        }
        float f3 = this.animation.getProgress();
        this.currentWeights[0] = this.fadeIn ? 1.0f - this.getChangedViewSizeChangeProgress(1.0f - f2) : this.getChangedViewSizeChangeProgress(f2);
        if (this.fireAnimationStarted) {
            this.viewSizeAnimationStarted(f3, this.currentWeights, this.targetWeights);
            this.fireAnimationStarted = false;
        }
        boolean bl = this.checkProgressCrossedStageDivider(this.currentWeights);
        if (LC.isInfo()) {
            LC.log(1000000, "ViewsizeAnimationManager#animate value=%1", (double)f2);
            LC.log(1000000, "ViewsizeAnimationManager#animate fadeIn=%1, stageChanged=%2", this.fadeIn, bl);
            LC.log(1000000, "ViewsizeAnimationManager#animate progress=%1, currentWeight=%2", (double)this.currentWeights[0], (double)f3, 0.0);
        }
        Iterator iterator = this.screens.iterator();
        while (iterator.hasNext()) {
            AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)iterator.next();
            ViewSizeAnimationManager.setScreenViewSizeAnimation(abstractScreenWidget, this.currentWeights, this.targetWeights, f3, bl);
        }
        if (this.drawerAnimationManager != null) {
            this.drawerAnimationManager.setViewSize(f2, this.currentWeights, this.targetWeights);
        }
    }

    private void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
        LC.log(1000000, "ViewsizeAnimationManager#viewSizeAnimationStarted progress=%1", (double)f2);
        Iterator iterator = this.screens.iterator();
        while (iterator.hasNext()) {
            AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)iterator.next();
            ViewSizeAnimationManager.screenViewSizeAnimationStarted(abstractScreenWidget, f2, fArray, fArray2);
        }
    }

    private static void screenViewSizeAnimationStarted(AbstractScreenWidget abstractScreenWidget, float f2, float[] fArray, float[] fArray2) {
        Object object;
        ScreenMainArea screenMainArea;
        LC.log(1000000, "ViewsizeAnimationManager#screenViewSizeAnimationStarted screen=%1", (Object)abstractScreenWidget);
        ScreenMainArea screenMainArea2 = abstractScreenWidget.getMainArea();
        if (screenMainArea2 != null) {
            LC.log(10000000, "ViewsizeAnimationManager#screenViewSizeAnimationStarted mainArea=%1", (Object)screenMainArea2);
            ViewSizeAnimationManager.viewSizeAnimationStarted(screenMainArea2.getScreenAreaWidget(), f2, fArray, fArray2);
        }
        if ((screenMainArea = abstractScreenWidget.getTitleArea()) != null) {
            LC.log(10000000, "ViewsizeAnimationManager#screenViewSizeAnimationStarted titleArea=%1", (Object)screenMainArea);
            ViewSizeAnimationManager.viewSizeAnimationStarted(screenMainArea.getScreenAreaWidget(), f2, fArray, fArray2);
        }
        List list = abstractScreenWidget.getSpecialAreas();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            object = (ScreenMainArea)iterator.next();
            LC.log(10000000, "ViewsizeAnimationManager#screenViewSizeAnimationStarted specialArea=%1", object);
            ViewSizeAnimationManager.viewSizeAnimationStarted(object.getScreenAreaWidget(), f2, fArray, fArray2);
        }
        object = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(0));
        if (object != null) {
            LC.log(10000000, "ViewsizeAnimationManager#screenViewSizeAnimationStarted visiblePP=%1", object);
            ViewSizeAnimationManager.viewSizeAnimationStarted((AbstractWidgetController)object, f2, fArray, fArray2);
        }
        if ((object = (AbstractWidgetController)((Object)abstractScreenWidget.getTerminal().getPartialPopupManager().getCurrentVisiblePopup(3))) != null) {
            LC.log(10000000, "ViewsizeAnimationManager#screenViewSizeAnimationStarted statusbar=%1", object);
            ViewSizeAnimationManager.viewSizeAnimationStarted((AbstractWidgetController)object, f2, fArray, fArray2);
        }
    }

    private static void viewSizeAnimationStarted(AbstractWidgetController abstractWidgetController, float f2, float[] fArray, float[] fArray2) {
        Object object;
        LC.log(100000000, "ViewsizeAnimationManager#viewSizeAnimationStarted widget=%1", (Object)abstractWidgetController);
        int n = abstractWidgetController.getChildrenSize();
        if (n > 0) {
            object = abstractWidgetController.getChildren();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)object.get(i2);
                ViewSizeAnimationManager.viewSizeAnimationStarted(abstractWidgetController2, f2, fArray, fArray2);
            }
        }
        if (abstractWidgetController instanceof IViewSizeAnimatable) {
            object = (IViewSizeAnimatable)((Object)abstractWidgetController);
            LC.log(100000000, "ViewsizeAnimationManager#setViewSizeAnimationStarted calling viewSizeAnimationStarted on %1", (Object)abstractWidgetController);
            object.viewSizeAnimationStarted(f2, fArray, fArray2);
        }
    }

    private float getChangedViewSizeChangeProgress(float f2) {
        if (f2 >= 0.9f) {
            return 1.0f;
        }
        return f2 / 0.9f;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        if (LC.isInfo()) {
            LC.log(1000000, "ViewsizeAnimationManager#animationFinished animationType=%1", (long)n);
            LC.log(1000000, "ViewsizeAnimationManager#animate targetWeight=%1", (double)this.targetWeights[0]);
        }
        System.arraycopy((Object)this.targetWeights, 0, (Object)this.currentWeights, 0, this.currentWeights.length);
        if (this.fireAnimationStarted) {
            this.viewSizeAnimationStarted(1.0f, this.currentWeights, this.targetWeights);
            this.fireAnimationStarted = false;
        }
        boolean bl = this.checkProgressCrossedStageDivider(this.targetWeights);
        Iterator iterator = this.screens.iterator();
        while (iterator.hasNext()) {
            AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)iterator.next();
            ViewSizeAnimationManager.setScreenViewSizeAnimationFinished(abstractScreenWidget, this.targetWeights, bl, true);
        }
        if (this.drawerAnimationManager != null) {
            this.drawerAnimationManager.setViewSize(1.0f, this.currentWeights, this.targetWeights);
        }
    }

    public float[] getCurrentWeights() {
        return this.currentWeights;
    }

    static {
        if (AbstractWidget.framework != null) {
            LC = IWidgetLogChannel.logViewSizeAnimation;
        } else {
            LC = null;
            System.err.println("ViewSizeAnimationManager: Warning: no framework available");
        }
    }
}

