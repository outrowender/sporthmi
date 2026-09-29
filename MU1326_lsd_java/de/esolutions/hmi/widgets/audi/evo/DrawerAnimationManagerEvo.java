/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem$Helper;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.DrawerItem;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.ScreenArea;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager$Helper;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerIcon;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawerAnimationManagerEvo
implements DrawerAnimationManager,
IWidgetLogChannel,
AnimationListener,
ScreenChangeAnimationItem,
DrawerAnimationListener {
    private static final LogChannel LC;
    private static final LogChannel LC_DRAWER;
    private static final LogChannel LC_SCREEN;
    private static final boolean ENABLE_MAIN_AREA_DESATURATION_WHEN_PARTIAL_POPUP_OPENS;
    public static final int DRAWER_COMPONENT_MASK;
    public static final int ANIMATING_VALUES_MASK;
    public static final int SCREEN_ANIMATION_MASK;
    private final HMITerminalImpl terminal;
    private final AbstractAnimation[] animations = new AbstractAnimation[14];
    private final float[] currentAnimationValues = new float[14];
    private final float[] targetAnimationValues = new float[14];
    private final List listeners = new ArrayList();
    private static final int[][] ANIMATION_INDEX_TYPE_MAPPING;
    private int viewSize;
    private AbstractScreenWidget currentScreen;
    private AbstractScreenWidget oldScreen;
    private DrawerController currentSelectionDrawer;
    private DrawerController newSelectionDrawer;
    private DrawerController closingOptionDrawer;
    private DrawerController currentOptionDrawer;
    private DrawerController newOptionDrawer;
    private DrawerController currentEntertainmentDrawer;
    private int drawerState = 16;
    private float drawerDesaturationValue;
    private final IGUIManager guiManager;
    private boolean isMapScreen;
    private boolean screenChangeFadeIn = false;
    private boolean showOptionIcon = true;
    private boolean optionDrawerBlocked = false;
    private boolean selectionDrawerBlocked = false;
    private int optionIconOffsetX = 0;
    private int optionIconOffsetY = 0;
    private float targetSdsState = 0.0f;
    private int newDrawerState;
    private boolean initialized;
    private int popupOrigin = 0;
    private boolean isEntertainmentDrawerVisible = true;
    private static int[] mapContexts;

    protected static boolean isG24MMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    private static void setMapContexts() {
        mapContexts = new int[12];
        DrawerAnimationManagerEvo.mapContexts[0] = 10;
        DrawerAnimationManagerEvo.mapContexts[1] = 16;
        DrawerAnimationManagerEvo.mapContexts[2] = 12;
        DrawerAnimationManagerEvo.mapContexts[3] = 18;
        DrawerAnimationManagerEvo.mapContexts[4] = 11;
        DrawerAnimationManagerEvo.mapContexts[5] = 17;
        DrawerAnimationManagerEvo.mapContexts[6] = 14;
        DrawerAnimationManagerEvo.mapContexts[7] = 20;
        DrawerAnimationManagerEvo.mapContexts[8] = 13;
        DrawerAnimationManagerEvo.mapContexts[9] = 19;
        DrawerAnimationManagerEvo.mapContexts[10] = 29;
        DrawerAnimationManagerEvo.mapContexts[11] = 30;
    }

    public DrawerAnimationManagerEvo(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
        this.guiManager = hMITerminalImpl.getGUIManager();
    }

    public void setScreenChangeProgress(float f2, boolean bl) {
        AbstractScreenWidget abstractScreenWidget = this.getSelectedScreen(bl);
        this.setScreenChangeProgress(abstractScreenWidget, f2);
    }

    private AbstractScreenWidget getSelectedScreen(boolean bl) {
        if (bl) {
            return this.oldScreen;
        }
        return this.currentScreen;
    }

    private void setScreenChangeProgress(AbstractScreenWidget abstractScreenWidget, float f2) {
        if (abstractScreenWidget == null) {
            LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#setScreenChangeProgress screen is NULL");
            return;
        }
        this.setScreenChangeProgress(abstractScreenWidget.getMainArea(), f2);
        this.setScreenChangeProgress(abstractScreenWidget.getTitleArea(), f2);
        this.setScreenChangeProgress(abstractScreenWidget.getSpecialAreas(), f2);
        LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#setScreenChangeProgress called");
    }

    private void setScreenChangeProgress(ScreenChangeAnimationItem screenChangeAnimationItem, float f2) {
        if (screenChangeAnimationItem == null) {
            LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#setScreenChangeProgress screen change animation item is NULL");
            return;
        }
        screenChangeAnimationItem.setScreenChangeProgress(f2);
    }

    private void setScreenChangeProgress(List list, float f2) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.setScreenChangeProgress(f2);
        }
    }

    public void setScreenChangeTarget(int n, boolean bl) {
        AbstractScreenWidget abstractScreenWidget = this.getSelectedScreen(bl);
        this.setScreenChangeTarget(abstractScreenWidget, n);
    }

    private void setScreenChangeTarget(AbstractScreenWidget abstractScreenWidget, int n) {
        if (abstractScreenWidget == null) {
            return;
        }
        this.setScreenChangeTarget(abstractScreenWidget.getMainArea(), n);
        this.setScreenChangeTarget(abstractScreenWidget.getTitleArea(), n);
        this.setScreenChangeTarget(abstractScreenWidget.getSpecialAreas(), n);
    }

    private void setScreenChangeTarget(ScreenChangeAnimationItem screenChangeAnimationItem, int n) {
        if (screenChangeAnimationItem == null) {
            return;
        }
        screenChangeAnimationItem.setScreenChangeTarget(n);
    }

    private void setScreenChangeTarget(List list, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.setScreenChangeTarget(n);
        }
    }

    public void screenChangeFinished(boolean bl) {
        AbstractScreenWidget abstractScreenWidget = this.getSelectedScreen(bl);
        this.screenChangeFinished(abstractScreenWidget);
    }

    private void screenChangeFinished(AbstractScreenWidget abstractScreenWidget) {
        if (abstractScreenWidget == null) {
            return;
        }
        this.screenChangeFinished(abstractScreenWidget.getMainArea());
        this.screenChangeFinished(abstractScreenWidget.getTitleArea());
        this.screenChangeFinished(abstractScreenWidget.getSpecialAreas());
    }

    private void screenChangeFinished(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.screenChangeFinished();
        }
    }

    private void screenChangeFinished(ScreenChangeAnimationItem screenChangeAnimationItem) {
        if (screenChangeAnimationItem == null) {
            return;
        }
        screenChangeAnimationItem.screenChangeFinished();
    }

    @Override
    public void setDrawerState(int n, boolean bl) {
        if (LC_DRAWER.isInfo()) {
            String string = DrawerFocusManager.getStateName(n);
            LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#setDrawerState state=%1 (%2)", (Object)string, (long)n);
        }
        this.drawerState = n;
        this.newDrawerState = n;
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    private int initializeDrawerAnimations() {
        int n = 0;
        for (int i2 = 0; i2 < 14; ++i2) {
            float f2;
            int n2 = 1 << i2;
            if ((0x5F & n2) == 0) continue;
            this.stopAnimation(i2);
            this.targetAnimationValues[i2] = f2 = this.getTargetDrawerValue(i2);
            this.currentAnimationValues[i2] = f2;
            n |= n2;
        }
        return n;
    }

    private int updateAnimations() {
        int n;
        int n2 = 0;
        for (n = 0; n < 14; ++n) {
            int n3 = 1 << n;
            if ((0x5F & n3) == 0) continue;
            float f2 = this.getTargetDrawerValue(n);
            float f3 = this.currentAnimationValues[n];
            float f4 = this.targetAnimationValues[n];
            AbstractAnimation abstractAnimation = this.animations[n];
            if (abstractAnimation != null && abstractAnimation.isAnimating()) {
                float f5 = abstractAnimation.getTarget();
                if (f4 != f5) {
                    LC.log(-1601830656, "DrawerAnimationManagerEvo#updateAnimations target of animation %1 is %2 but should be %3", (double)n, (double)f5, (double)f4);
                }
                if (f2 == f4) {
                    LC.log(-2137614336, "DrawerAnimationManagerEvo#updateAnimations target value for running animation %1 has not changed", (Object)DrawerAnimationManager$Helper.getAnimationName(n));
                    continue;
                }
                if (f2 == f4 && f2 == f5) continue;
                LC.log(1078071040, "DrawerAnimationManagerEvo#updateAnimations target for running animation %1 changed:", (Object)DrawerAnimationManager$Helper.getAnimationName(n));
                LC.log(1078071040, "DrawerAnimationManagerEvo#updateAnimations currentTarget=%1, newTarget=%2", (double)f4, (double)f2, 0.0);
                this.targetAnimationValues[n] = f2;
                n2 |= n3;
                abstractAnimation.setTarget(f2);
                continue;
            }
            if (f2 == f3) continue;
            this.targetAnimationValues[n] = f2;
            n2 |= n3;
            AbstractWidget abstractWidget = this.getRepaintTarget(n);
            if (abstractWidget == null) continue;
            this.startAnimation(n, f2, f3, f4, abstractAnimation, abstractWidget);
        }
        if (LC.isDebug()) {
            LC.log(-2137614336, "DrawerAnimationManagerEvo#updateAnimations mask=%1 (%3), targetValues=%2", (Object)Integer.toBinaryString(n2), (Object)Util.arrayToString(this.targetAnimationValues), (Object)DrawerAnimationManager$Helper.getMaskString(n2));
        }
        if ((n = this.calculateDesaturation()) != 0) {
            this.fireSetDrawerAnimation(n);
        }
        return n2;
    }

    private void startAnimation(int n, float f2, float f3, float f4, AbstractAnimation abstractAnimation, AbstractWidget abstractWidget) {
        int n2 = this.getAnimationType(n);
        if (abstractAnimation == null) {
            this.animations[n] = abstractAnimation = this.createAnimation(n2);
        }
        if (abstractAnimation != null) {
            if (LC.isInfo()) {
                LC.log(1078071040, "DrawerAnimationManagerEvo#updateAnimations starting animation %1", (Object)DrawerAnimationManager$Helper.getAnimationName(n));
                LC.log(1078071040, "DrawerAnimationManagerEvo#updateAnimations from %1 to %2", (double)f4, (double)f2, 0.0);
            }
            abstractAnimation.startDynamicAnimation(f3, f2, n2, f2 > 0.0f, abstractWidget);
        }
    }

    private AbstractWidget getRepaintTarget(int n) {
        DrawerController drawerController = null;
        switch (n) {
            case 2: 
            case 3: {
                drawerController = this.currentOptionDrawer;
                break;
            }
            case 0: 
            case 1: {
                drawerController = this.currentSelectionDrawer;
                break;
            }
            case 4: {
                drawerController = this.currentEntertainmentDrawer;
                break;
            }
            default: {
                LC.log(10000, "DrawerAnimationManagerEvo#getRepaintTarget Cannot get repaintTarget for animation %1", (Object)DrawerAnimationManager$Helper.getAnimationName(n));
            }
        }
        return drawerController;
    }

    private int getAnimationType(int n) {
        for (int i2 = 0; i2 < ANIMATION_INDEX_TYPE_MAPPING.length; ++i2) {
            int[] nArray = ANIMATION_INDEX_TYPE_MAPPING[i2];
            if (nArray[0] != n) continue;
            return nArray[1];
        }
        LC.log(10000, "DrawerAnimationManagerEvo#getAnimationType Cannot get animation type for animation %1", (Object)DrawerAnimationManager$Helper.getAnimationName(n));
        return -1;
    }

    private int getAnimationIndex(int n) {
        for (int i2 = 0; i2 < ANIMATION_INDEX_TYPE_MAPPING.length; ++i2) {
            int[] nArray = ANIMATION_INDEX_TYPE_MAPPING[i2];
            if (nArray[1] != n) continue;
            return nArray[0];
        }
        LC.log(10000, "DrawerAnimationManagerEvo#getAnimationType Cannot get animation index for type %1", (long)n);
        return -1;
    }

    private AbstractAnimation createAnimation(int n) {
        AnimationController animationController = (AnimationController)this.terminal.getIAnimationController();
        if (animationController == null) {
            return null;
        }
        AbstractAnimation abstractAnimation = animationController.getAnimation(n);
        abstractAnimation.addListener(this);
        return abstractAnimation;
    }

    private float getTargetDrawerValue(int n) {
        float f2 = 0.0f;
        switch (n) {
            case 2: {
                f2 = this.drawerState == 8 ? 1.0f : 0.0f;
                break;
            }
            case 0: {
                f2 = this.drawerState == 4 ? 1.0f : 0.0f;
                break;
            }
            case 4: {
                f2 = this.drawerState == 32 ? 1.0f : 0.0f;
                break;
            }
            case 3: {
                if (!Util.equals(this.newOptionDrawer, this.currentOptionDrawer) || this.terminal.getViewSizeManager().isSportskinSmallStage()) {
                    f2 = 0.0f;
                    break;
                }
                f2 = this.isOptionIconVisible(this.drawerState) ? 1.0f : 0.0f;
                break;
            }
            case 1: {
                if (!Util.equals(this.newOptionDrawer, this.currentOptionDrawer) || this.terminal.getViewSizeManager().isSportskinSmallStage()) {
                    f2 = 0.0f;
                    break;
                }
                f2 = this.isSelectionIconVisible(this.drawerState) ? 1.0f : 0.0f;
                break;
            }
            case 6: {
                f2 = this.targetSdsState;
                break;
            }
            default: {
                LC.log(10000, "DrawerAnimationManagerEvo#getTargetValue Cannot get target value for index %1", (long)n);
            }
        }
        return f2;
    }

    private boolean isOptionIconVisible(int n) {
        boolean bl;
        if (n != 16) {
            return false;
        }
        DrawerController drawerController = this.getAnimatingDrawer(8);
        boolean bl2 = bl = drawerController != null && (this.showOptionIcon && !this.optionDrawerBlocked && this.shouldShowSideDrawerIcons() && drawerController.canOpen() || drawerController.hasRemoteHMIDrawerEntries() && !this.mainAreaHasVisibleFocusCursor());
        if (LC_DRAWER.isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("DrawerAnimationManagerEvo#isOptionIconVisible showOptionIcon: ");
            buffer.append(this.showOptionIcon);
            buffer.append("; optionDrawerBlocked: ");
            buffer.append(this.optionDrawerBlocked);
            buffer.append("; canOpen: ");
            buffer.append(drawerController != null && drawerController.canOpen());
            buffer.append("; shouldShowSideDrawerIcons: ");
            buffer.append(this.shouldShowSideDrawerIcons());
            buffer.append("; hasRemoteHMIDrawerEntries: ");
            buffer.append(drawerController != null && drawerController.hasRemoteHMIDrawerEntries());
            buffer.append("; mainAreaHasVisibleFocusCursor: ");
            buffer.append(this.mainAreaHasVisibleFocusCursor());
            LC_DRAWER.log(-2137614336, buffer.toString());
        }
        return bl;
    }

    protected boolean mainAreaHasVisibleFocusCursor() {
        ScreenArea screenArea;
        if (this.currentScreen != null && (screenArea = this.currentScreen.getScreenArea(1)) instanceof ScreenMainArea) {
            return ((ScreenMainArea)screenArea).hasVisibleFocusCursor();
        }
        return false;
    }

    private void updateOptionIconOffset() {
        DrawerController drawerController;
        if (this.currentScreen instanceof ScreenWidgetEVO && !((ScreenWidgetEVO)this.currentScreen).hasOptionIconPositionController() && (drawerController = this.getAnimatingDrawer(8)) != null && drawerController.getDrawerIcon() instanceof ContainerController) {
            ContainerController containerController = (ContainerController)drawerController.getDrawerIcon();
            containerController.setX(this.optionIconOffsetX);
            containerController.setY(this.optionIconOffsetY);
        }
    }

    private boolean isSelectionIconVisible(int n) {
        if (n != 16) {
            return false;
        }
        DrawerController drawerController = this.getAnimatingDrawer(4);
        return drawerController != null && !this.selectionDrawerBlocked && this.shouldShowSideDrawerIcons() && drawerController.canOpen();
    }

    @Override
    public void setOptionDrawer(DrawerController drawerController, int n) {
        LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#setOptionDrawer drawer=%1", (Object)drawerController);
        this.newOptionDrawer = drawerController;
        if (Util.equals(drawerController, this.currentOptionDrawer)) {
            return;
        }
        LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#setOptionDrawer hiding new drawer %1", (Object)drawerController);
        this.hideDrawer(drawerController);
        if (!this.initialized) {
            this.updateDrawers();
        }
    }

    private void hideDrawer(DrawerController drawerController) {
        if (drawerController == null) {
            return;
        }
        this.hideDrawerItem(drawerController.getDrawerMain());
        this.hideDrawerItem(drawerController.getDrawerIcon());
    }

    private void hideDrawerItem(DrawerItem drawerItem) {
        if (drawerItem == null) {
            return;
        }
        drawerItem.hideDrawerItem();
    }

    private void initializeDrawer(DrawerController drawerController) {
        if (drawerController == null) {
            return;
        }
        this.initializeDrawerItem(drawerController.getDrawerMain());
        this.initializeDrawerItem(drawerController.getDrawerIcon());
    }

    private void initializeDrawerItem(DrawerItem drawerItem) {
        if (drawerItem == null) {
            return;
        }
        drawerItem.initializeDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues);
    }

    private void initializeScreen(AbstractScreenWidget abstractScreenWidget, int n) {
        if (abstractScreenWidget == null) {
            return;
        }
        this.initializeScreenArea(abstractScreenWidget.getMainArea(), 1, n);
        this.initializeScreenArea(abstractScreenWidget.getTitleArea(), 2, n);
        this.initializeScreenArea(abstractScreenWidget.getSpecialAreas(), n);
    }

    private void initializeScreenArea(ScreenArea screenArea, int n, int n2) {
        if (screenArea == null) {
            return;
        }
        screenArea.setMainAreaState(this.drawerState, n, n2);
        screenArea.initializeDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues);
    }

    private void initializeScreenArea(List list, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.setMainAreaState(this.drawerState, 7, n);
            screenMainArea.initializeDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues);
        }
    }

    @Override
    public void setSelectionDrawer(DrawerController drawerController, int n) {
        LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#setSelectionDrawer drawer=%1", (Object)drawerController);
        this.newSelectionDrawer = drawerController;
        if (!this.initialized) {
            this.updateDrawers();
        }
    }

    @Override
    public void setEntertainmentDrawer(DrawerController drawerController, int n) {
        this.currentEntertainmentDrawer = drawerController;
    }

    @Override
    public void setScreen(AbstractScreenWidget abstractScreenWidget, int n) {
        LC_SCREEN.log(1078071040, "DrawerAnimationManagerEve#setScreen new screen=%1", (Object)abstractScreenWidget);
        LC_SCREEN.log(1078071040, "DrawerAnimationManagerEve#setScreen current screen=%1", (Object)this.currentScreen);
        LC_SCREEN.log(1078071040, "DrawerAnimationManagerEve#setScreen old screen=%1", (Object)this.oldScreen);
        this.showOptionIcon = abstractScreenWidget.isOptionIconVisible();
        this.optionIconOffsetX = abstractScreenWidget.getOptionIconOffsetX();
        this.optionIconOffsetY = abstractScreenWidget.getOptionIconOffsetY();
        this.oldScreen = this.currentScreen;
        this.currentScreen = abstractScreenWidget;
        this.newDrawerState = n;
        int n2 = this.initializeDrawerAnimations();
        this.updateOptionIconOffset();
        this.fireSetDrawerAnimation(n2);
        this.initializeScreen(abstractScreenWidget, n);
        this.updateIsMapScreen();
        this.fireDrawerAnimationTargetChanged(this.updateAnimations() | n2);
    }

    private void updateIsMapScreen() {
        this.isMapScreen = false;
        if (this.currentScreen == null) {
            return;
        }
        IDisplayControllerWidget iDisplayControllerWidget = this.currentScreen.getDisplayController();
        if (iDisplayControllerWidget == null) {
            return;
        }
        for (int i2 = 0; i2 < mapContexts.length; ++i2) {
            if (mapContexts[i2] != iDisplayControllerWidget.getTargetContextID()) continue;
            this.isMapScreen = true;
            break;
        }
    }

    @Override
    public void registerListener(DrawerAnimationListener drawerAnimationListener) {
        if (!this.listeners.contains(drawerAnimationListener)) {
            this.listeners.add(drawerAnimationListener);
        } else {
            LC.log(-1601830656, new StringBuffer().append("DrawerAnimationManagerEvo#registerListener : Listener is already registered in the list - %1  ").append(drawerAnimationListener).toString());
        }
        drawerAnimationListener.initializeDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues);
    }

    @Override
    public void unregisterListener(DrawerAnimationListener drawerAnimationListener) {
        this.listeners.remove(drawerAnimationListener);
    }

    @Override
    public void setViewSize(int n, boolean bl) {
        this.viewSize = n;
        if (!bl) {
            this.currentAnimationValues[7] = n == 2 ? 0.0f : 1.0f;
            this.fireSetDrawerAnimation(128);
        }
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    @Override
    public void setSdsState(float f2, boolean bl) {
        this.targetSdsState = f2;
        if (!bl) {
            int n = 0;
            int n2 = 0;
            if (this.targetAnimationValues[6] != f2) {
                this.targetAnimationValues[6] = f2;
                n |= 0x40;
            }
            if (this.currentAnimationValues[6] != f2) {
                this.currentAnimationValues[6] = f2;
                n2 |= 0x40;
            }
            this.fireDrawerAnimationTargetChanged(n);
            this.fireSetDrawerAnimation(n2);
            this.fireDrawerAnimationFinished(64);
        }
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    private void fireDrawerAnimationTargetChanged(int n) {
        if (n == 0) {
            return;
        }
        if (LC.isInfo()) {
            LC.log(1078071040, "DrawerAnimationManagerEvo#fireDrawerAnimationTargetChanged mask=%1", (Object)Integer.toBinaryString(n));
            if (LC.isDebug()) {
                LC.log(-2137614336, "DrawerAnimationManagerEvo#fireDrawerAnimationTargetChanged mask=%1", (Object)DrawerAnimationManager$Helper.getMaskString(n));
                LC.log(-2137614336, "DrawerAnimationManagerEvo#fireDrawerAnimationTargetChanged current=%1", (Object)Util.arrayToString(this.currentAnimationValues));
                LC.log(-2137614336, "DrawerAnimationManagerEvo#fireDrawerAnimationTargetChanged target =%1", (Object)Util.arrayToString(this.targetAnimationValues));
            }
        }
        this.fireDrawerAnimationTargetChanged(16, n);
        this.fireDrawerAnimationTargetChanged(8, n);
        this.fireDrawerAnimationTargetChanged(4, n);
        this.fireDrawerAnimationTargetChanged(32, n);
        int n2 = this.listeners.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            DrawerAnimationListener drawerAnimationListener = (DrawerAnimationListener)this.listeners.get(i2);
            int n3 = drawerAnimationListener.getDrawerAnimationMask();
            if ((n3 & n) == 0) continue;
            drawerAnimationListener.drawerAnimationTargetChanged(this.currentAnimationValues, this.targetAnimationValues, n);
        }
    }

    private void fireDrawerAnimationTargetChanged(int n, int n2) {
        DrawerIcon drawerIcon;
        if (n == 16) {
            if ((n2 & 0x14F5) != 0 && this.currentScreen != null) {
                this.fireDrawerAnimationTargetChanged(this.currentScreen.getMainArea(), n2);
                this.fireDrawerAnimationTargetChanged(this.currentScreen.getTitleArea(), n2);
                this.fireDrawerAnimationTargetChanged(this.currentScreen.getSpecialAreas(), n2);
            }
            return;
        }
        DrawerController drawerController = this.getAnimatingDrawer(n);
        if (drawerController == null) {
            return;
        }
        DrawerMain drawerMain = drawerController.getDrawerMain();
        if (drawerMain != null && (drawerMain.getDrawerAnimationMask() & n2) != 0) {
            if (LC_DRAWER.isDebug2()) {
                LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#fireDrawerAnimationTargetChanged main changed of drawer %1", (Object)DrawerFocusManager.getStateName(n));
            }
            drawerMain.drawerAnimationTargetChanged(this.currentAnimationValues, this.targetAnimationValues, n2);
        }
        if ((drawerIcon = drawerController.getDrawerIcon()) != null && (drawerIcon.getDrawerAnimationMask() & n2) != 0) {
            if (LC_DRAWER.isDebug2()) {
                LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#fireDrawerAnimationTargetChanged icon changed of drawer %1", (Object)DrawerFocusManager.getStateName(n));
            }
            drawerIcon.drawerAnimationTargetChanged(this.currentAnimationValues, this.targetAnimationValues, n2);
        }
    }

    private void fireDrawerAnimationTargetChanged(ScreenArea screenArea, int n) {
        if (screenArea == null) {
            return;
        }
        screenArea.drawerAnimationTargetChanged(this.currentAnimationValues, this.targetAnimationValues, n);
    }

    private void fireDrawerAnimationTargetChanged(List list, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.drawerAnimationTargetChanged(this.currentAnimationValues, this.targetAnimationValues, n);
        }
    }

    private void fireSetDrawerAnimation(int n) {
        if (n == 0) {
            return;
        }
        if (LC.isDebug2()) {
            LC.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation mask=%1 (%2)", (Object)Integer.toBinaryString(n), (Object)DrawerAnimationManager$Helper.getMaskString(n));
            LC.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation current=%1", (Object)Util.arrayToString(this.currentAnimationValues));
            LC.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation target =%1", (Object)Util.arrayToString(this.targetAnimationValues));
        }
        this.fireSetDrawerAnimation(16, n);
        this.fireSetDrawerAnimation(8, n);
        this.fireSetDrawerAnimation(4, n);
        this.fireSetDrawerAnimation(32, n);
        int n2 = this.listeners.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            DrawerAnimationListener drawerAnimationListener = (DrawerAnimationListener)this.listeners.get(i2);
            int n3 = drawerAnimationListener.getDrawerAnimationMask();
            if ((n3 & n) == 0) continue;
            drawerAnimationListener.setDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues, n);
        }
    }

    private void fireDrawerAnimationFinished(int n) {
        if (n == 0) {
            return;
        }
        if (LC.isInfo()) {
            LC.log(1078071040, "DrawerAnimationManagerEvo#fireDrawerAnimationFinished mask=%1", (Object)Integer.toBinaryString(n));
        }
        if (LC.isDebug()) {
            LC.log(-2137614336, "DrawerAnimationManagerEvo#fireDrawerAnimationFinished mask=%1", (Object)DrawerAnimationManager$Helper.getMaskString(n));
            LC.log(-2137614336, "DrawerAnimationManagerEvo#fireDrawerAnimationFinished current=%1", (Object)Util.arrayToString(this.currentAnimationValues));
            LC.log(-2137614336, "DrawerAnimationManagerEvo#fireDrawerAnimationFinished target =%1", (Object)Util.arrayToString(this.targetAnimationValues));
        }
        this.fireDrawerAnimationFinished(16, n);
        this.fireDrawerAnimationFinished(8, n);
        this.fireDrawerAnimationFinished(4, n);
        this.fireDrawerAnimationFinished(32, n);
        int n2 = this.listeners.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            DrawerAnimationListener drawerAnimationListener = (DrawerAnimationListener)this.listeners.get(i2);
            int n3 = drawerAnimationListener.getDrawerAnimationMask();
            if ((n3 & n) == 0) continue;
            drawerAnimationListener.drawerAnimationFinished(this.currentAnimationValues, this.targetAnimationValues, n);
        }
    }

    void fireDrawerAnimationFinished(int n, int n2) {
        DrawerIcon drawerIcon;
        if (n == 16) {
            if ((n2 & 0x14F5) != 0 && this.currentScreen != null) {
                this.fireDrawerAnimationFinished(this.currentScreen.getMainArea(), n2);
                this.fireDrawerAnimationFinished(this.currentScreen.getTitleArea(), n2);
                this.fireDrawerAnimationFinished(this.currentScreen.getSpecialAreas(), n2);
            }
            return;
        }
        DrawerController drawerController = this.getAnimatingDrawer(n);
        if (drawerController == null) {
            return;
        }
        DrawerMain drawerMain = drawerController.getDrawerMain();
        if (drawerMain != null && (drawerMain.getDrawerAnimationMask() & n2) != 0) {
            drawerMain.drawerAnimationFinished(this.currentAnimationValues, this.targetAnimationValues, n2);
        }
        if ((drawerIcon = drawerController.getDrawerIcon()) != null && (drawerIcon.getDrawerAnimationMask() & n2) != 0) {
            drawerIcon.drawerAnimationFinished(this.currentAnimationValues, this.targetAnimationValues, n2);
        }
    }

    private void fireDrawerAnimationFinished(ScreenArea screenArea, int n) {
        if (screenArea == null) {
            return;
        }
        screenArea.drawerAnimationFinished(this.currentAnimationValues, this.targetAnimationValues, n);
    }

    private void fireDrawerAnimationFinished(List list, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            this.fireDrawerAnimationFinished(screenMainArea, n);
        }
    }

    private void fireSetDrawerAnimation(int n, int n2) {
        DrawerIcon drawerIcon;
        if (n == 16) {
            if ((n2 & 0x14F5) != 0 && this.currentScreen != null) {
                LC_SCREEN.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation setting animation on main screen area");
                this.fireSetDrawerAnimation(this.currentScreen.getMainArea(), n2);
                LC_SCREEN.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation setting animation on title screen area");
                this.fireSetDrawerAnimation(this.currentScreen.getTitleArea(), n2);
                LC_SCREEN.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation setting animation on special screen areas");
                this.fireSetDrawerAnimation(this.currentScreen.getSpecialAreas(), n2);
            }
            return;
        }
        DrawerController drawerController = this.getAnimatingDrawer(n);
        if (drawerController == null) {
            return;
        }
        DrawerMain drawerMain = drawerController.getDrawerMain();
        if (drawerMain != null && (drawerMain.getDrawerAnimationMask() & n2) != 0) {
            if (LC_DRAWER.isDebug2()) {
                LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation main changed of drawer %1", (Object)DrawerFocusManager.getStateName(n));
            }
            drawerMain.setDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues, n2);
        }
        if ((drawerIcon = drawerController.getDrawerIcon()) != null && (drawerIcon.getDrawerAnimationMask() & n2) != 0) {
            if (LC_DRAWER.isDebug2()) {
                LC_DRAWER.log(14808325, "DrawerAnimationManagerEvo#fireSetDrawerAnimation icon changed of drawer %1", (Object)DrawerFocusManager.getStateName(n));
            }
            if (DrawerAnimationManagerEvo.isG24MMIKombi() && this.isMapScreen) {
                int n3 = 5;
                float f2 = this.currentAnimationValues[n3];
                float f3 = this.targetAnimationValues[n3];
                this.currentAnimationValues[n3] = 0.0f;
                this.targetAnimationValues[n3] = 0.0f;
                drawerIcon.setDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues, n2);
                this.currentAnimationValues[n3] = f2;
                this.targetAnimationValues[n3] = f3;
            } else {
                drawerIcon.setDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues, n2);
            }
        }
    }

    private void fireSetDrawerAnimation(ScreenArea screenArea, int n) {
        if (screenArea == null) {
            return;
        }
        screenArea.setDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues, n);
    }

    private void fireSetDrawerAnimation(List list, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ScreenMainArea screenMainArea = (ScreenMainArea)iterator.next();
            screenMainArea.setDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues, n);
        }
    }

    @Override
    public void setDesaturationRequest(float f2, int n) {
        float f3;
        int n2 = 0;
        if (!(n != 0 && n != 1 || (f3 = this.currentAnimationValues[5]) == f2 && this.popupOrigin == n)) {
            this.currentAnimationValues[5] = f2;
            this.targetAnimationValues[5] = f2;
            this.popupOrigin = n;
            if (n == 0) {
                this.currentAnimationValues[13] = f2;
                this.targetAnimationValues[13] = f2;
                n2 |= 0x2000;
            }
            n2 |= 0x20;
            n2 |= this.calculateDesaturation();
        }
        this.fireSetDrawerAnimation(n2);
    }

    private boolean shouldShowSideDrawerIcons() {
        boolean bl;
        boolean bl2 = bl = this.viewSize != 1 && this.drawerState != 4 && this.drawerState != 8;
        if (!bl) {
            LC_DRAWER.log(-2137614336, "DrawerAnimationManagerEvo#shouldShowSideDrawerIcons small view size or opened side drawers -> hiding icons");
            return false;
        }
        if (this.currentScreen == null) {
            LC_DRAWER.log(-2137614336, "DrawerAnimationManagerEvo#shouldShowSideDrawerIcons no screen -> showing icons");
            return true;
        }
        int n = this.currentScreen.getDrawerVisibility();
        LC_DRAWER.log(-2137614336, "DrawerAnimationManagerEvo#shouldShowSideDrawerIcons screen drawerVisibility flag: %1", (long)n);
        boolean bl3 = n == 0 || n == 2;
        LC_DRAWER.log(-2137614336, "DrawerAnimationManagerEvo#shouldShowSideDrawerIcons returning %1", bl3);
        return bl3;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        int n3 = this.getAnimationIndex(n);
        if (n3 < 0) {
            LC.log(10000, "DrawerAnimationManagerEvo#animate Unknown animation type %1, value=%2, id=%3", (double)n, (double)f2, (double)n2);
            return;
        }
        if (LC.isDebug2()) {
            LC.log(14808325, "DrawerAnimationManagerEvo#animate animationIndex=%2 (%1)", (Object)DrawerAnimationManager$Helper.getAnimationName(n3), (long)n3);
            LC.log(14808325, "DrawerAnimationManagerEvo#animate value=%1", (double)f2);
        }
        this.currentAnimationValues[n3] = f2;
        int n4 = 1 << n3;
        this.fireSetDrawerAnimation(n4);
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        int n3 = this.getAnimationIndex(n);
        if (n3 < 0) {
            LC.log(10000, "DrawerAnimationManagerEvo#animationFinished Unknown animation type %1, value=%2, id=%3", (long)n, (long)n2);
            return;
        }
        float f2 = this.targetAnimationValues[n3];
        if (LC.isDebug()) {
            LC.log(-2137614336, "DrawerAnimationManagerEvo#animationFinished animationIndex=%2 (%1)", (Object)DrawerAnimationManager$Helper.getAnimationName(n3), (long)n3);
            LC.log(-2137614336, "DrawerAnimationManagerEvo#animationFinished target value=%1", (double)f2);
        }
        this.currentAnimationValues[n3] = f2;
        this.fireDrawerAnimationFinished(1 << n3);
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    private DrawerController getAnimatingDrawer(int n) {
        DrawerController drawerController = null;
        switch (n) {
            case 4: {
                drawerController = this.currentSelectionDrawer;
                break;
            }
            case 8: {
                drawerController = this.currentOptionDrawer;
                break;
            }
            case 32: {
                drawerController = this.currentEntertainmentDrawer;
                break;
            }
            default: {
                LC_DRAWER.log(10000, "DrawerAnimationManagerEvo#getAnimatingDrawer Unknown drawer side %1", (long)n);
            }
        }
        return drawerController;
    }

    private int calculateDesaturation() {
        float f2 = this.drawerDesaturationValue;
        float f3 = 0.0f;
        f3 = Math.max(f3, this.targetAnimationValues[2]);
        f3 = Math.max(f3, this.targetAnimationValues[0]);
        if (!this.isMapScreen) {
            f3 = this.isEntertainmentDrawerVisible ? Math.max(f3, this.targetAnimationValues[4]) : Math.max(f3, 0.0f);
        }
        if (ENABLE_MAIN_AREA_DESATURATION_WHEN_PARTIAL_POPUP_OPENS && !this.isMapScreen) {
            f3 = Math.max(f3, this.targetAnimationValues[5]);
        }
        float f4 = 0.0f;
        f4 = Math.max(f4, this.currentAnimationValues[2]);
        float f5 = f4 = Math.max(f4, this.currentAnimationValues[0]);
        if (!this.isMapScreen) {
            f4 = this.isEntertainmentDrawerVisible ? Math.max(f4, this.currentAnimationValues[4]) : Math.max(f4, 0.0f);
        }
        if (ENABLE_MAIN_AREA_DESATURATION_WHEN_PARTIAL_POPUP_OPENS && !this.isMapScreen) {
            f4 = Math.max(f4, this.currentAnimationValues[5]);
            f5 = Math.max(f5, this.currentAnimationValues[5]);
        }
        this.drawerDesaturationValue = f3 > this.drawerDesaturationValue ? Math.max(this.drawerDesaturationValue, f4) : Math.min(this.drawerDesaturationValue, f4);
        if (this.guiManager != null) {
            this.guiManager.setMainAreaMaterialProperties(this.isMapScreen, this.drawerDesaturationValue, f5);
        }
        this.currentAnimationValues[11] = this.drawerDesaturationValue;
        if (LC.isDebug2()) {
            LC.log(14808325, "DrawerAnimationManagerEvo#calculateDesaturation current=%1", (Object)Util.arrayToString(this.currentAnimationValues));
            LC.log(14808325, "DrawerAnimationManagerEvo#calculateDesaturation target=%1", (Object)Util.arrayToString(this.targetAnimationValues));
        }
        int n = 0;
        if (this.drawerDesaturationValue != f2) {
            LC.log(1078071040, "DrawerAnimationManagerEvo#calculateDesaturation main area desaturation changed to %1", (double)this.drawerDesaturationValue);
            n |= 0x800;
        }
        if (n != 0 && this.currentScreen != null) {
            this.currentScreen.setCompositesDirty(true);
        }
        return n;
    }

    @Override
    public void setViewSize(float f2, float[] fArray, float[] fArray2) {
        this.currentAnimationValues[7] = fArray[0];
        this.fireSetDrawerAnimation(0x80 | this.updateAnimations());
    }

    @Override
    public void viewSizeChanged(float[] fArray, float[] fArray2) {
        this.targetAnimationValues[7] = fArray2[0];
        this.fireDrawerAnimationTargetChanged(0x80 | this.updateAnimations());
    }

    @Override
    public void closeCurrentOptionDrawer() {
        if (this.closingOptionDrawer == null) {
            this.closingOptionDrawer = this.currentOptionDrawer;
        }
        this.currentOptionDrawer = null;
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    @Override
    public void initializeDrawerAnimation(DrawerAnimationListener drawerAnimationListener) {
        drawerAnimationListener.initializeDrawerAnimation(this.currentAnimationValues, this.targetAnimationValues);
    }

    @Override
    public void setScreenChangeProgress(float f2) {
        float f3;
        this.currentAnimationValues[12] = f3 = this.screenChangeFadeIn ? 1.0f - f2 : f2;
        if (LC_SCREEN.isDebug2()) {
            LC_SCREEN.log(14808325, "DrawerAnimationManagerEvo#setScreenChangeProgress progress=%1", (double)f2);
        }
        this.fireSetDrawerAnimation(4096);
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    @Override
    public void setScreenChangeTarget(int n) {
        float f2;
        LC.log(1078071040, "DrawerAnimationManagerEvo#setScreenChangeTarget target=%1", (long)n);
        this.initialized = true;
        this.screenChangeFadeIn = ScreenChangeAnimationItem$Helper.isFade(n, 1);
        if (this.screenChangeFadeIn) {
            f2 = 0.0f;
            this.drawerState = this.newDrawerState;
            this.updateDrawers();
        } else {
            f2 = 1.0f;
        }
        this.targetAnimationValues[12] = f2;
        this.fireDrawerAnimationTargetChanged(0x1000 | this.updateAnimations());
    }

    private void updateDrawers() {
        LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#updateDrawers");
        if (!Util.equals(this.currentOptionDrawer, this.newOptionDrawer)) {
            LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#updateDrawers option drawer has changed %1 -> %2", (Object)this.currentOptionDrawer, (Object)this.newOptionDrawer);
            this.hideDrawer(this.currentOptionDrawer);
            this.currentOptionDrawer = this.newOptionDrawer;
            this.initializeDrawer(this.currentOptionDrawer);
        }
        if (!Util.equals(this.currentSelectionDrawer, this.newSelectionDrawer)) {
            LC_DRAWER.log(1078071040, "DrawerAnimationManagerEvo#updateDrawers selection drawer has changed %1 -> %2", (Object)this.currentSelectionDrawer, (Object)this.newSelectionDrawer);
            this.hideDrawer(this.currentSelectionDrawer);
            this.currentSelectionDrawer = this.newSelectionDrawer;
            this.initializeDrawer(this.currentSelectionDrawer);
        }
        this.updateOptionIconOffset();
    }

    private void stopAnimation(int n) {
        AbstractAnimation abstractAnimation = this.animations[n];
        if (abstractAnimation == null) {
            return;
        }
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
    }

    @Override
    public void screenChangeFinished() {
        LC.log(1078071040, "DrawerAnimationManagerEvo#screenChangeFinished");
        this.updateDrawers();
        this.screenChangeFadeIn = true;
        this.setScreenChangeProgress(1.0f);
        this.updateIsMapScreen();
        this.calculateDesaturation();
    }

    @Override
    public void showSideOptionIcon(boolean bl) {
        this.showOptionIcon = bl;
        this.fireDrawerAnimationTargetChanged(this.updateAnimations());
    }

    @Override
    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
    }

    @Override
    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    @Override
    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
    }

    @Override
    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
    }

    @Override
    public int getDrawerAnimationMask() {
        return 0;
    }

    public void setOptionIconOffset(int n, int n2) {
        this.optionIconOffsetX = n;
        this.optionIconOffsetY = n2;
    }

    @Override
    public void updateClosedDrawerIconVisibility() {
        if (this.currentScreen instanceof ScreenWidgetEVO && this.terminal instanceof HMITerminalEvoImpl) {
            ScreenWidgetEVO screenWidgetEVO = (ScreenWidgetEVO)this.currentScreen;
            HMITerminalEvoImpl hMITerminalEvoImpl = (HMITerminalEvoImpl)this.terminal;
            boolean bl = hMITerminalEvoImpl.getFramework().getLanguageMgr().isLeftToRightOrientation();
            boolean bl2 = false;
            if (bl) {
                bl2 |= this.blockOptionDrawer(screenWidgetEVO, 11);
                bl2 |= this.blockSelectionDrawer(screenWidgetEVO, 9);
            } else {
                bl2 |= this.blockOptionDrawer(screenWidgetEVO, 11);
                bl2 |= this.blockSelectionDrawer(screenWidgetEVO, 9);
            }
            if (bl2) {
                this.fireDrawerAnimationTargetChanged(this.updateAnimations());
            }
        }
    }

    private boolean blockSelectionDrawer(ScreenWidgetEVO screenWidgetEVO, int n) {
        if (this.selectionDrawerBlocked != screenWidgetEVO.doesHKFilterContainsKey(n)) {
            this.selectionDrawerBlocked = !this.selectionDrawerBlocked;
            return true;
        }
        return false;
    }

    private boolean blockOptionDrawer(ScreenWidgetEVO screenWidgetEVO, int n) {
        if (this.optionDrawerBlocked != screenWidgetEVO.doesHKFilterContainsKey(n)) {
            this.optionDrawerBlocked = !this.optionDrawerBlocked;
            return true;
        }
        return false;
    }

    @Override
    public void setIsEntertainmentDrawerVisible(boolean bl) {
        this.isEntertainmentDrawerVisible = bl;
    }

    static {
        ANIMATION_INDEX_TYPE_MAPPING = new int[][]{{2, 53}, {3, 55}, {0, 52}, {1, 54}, {4, 58}, {6, 105}};
        if (AbstractWidget.framework != null) {
            LC = logDrawerAnimation;
            LC_DRAWER = logDrawerAnimationDrawer;
            LC_SCREEN = logDrawerAnimationScreen;
            ENABLE_MAIN_AREA_DESATURATION_WHEN_PARTIAL_POPUP_OPENS = !DrawerAnimationManagerEvo.isG24MMIKombi();
        } else {
            LC = null;
            LC_DRAWER = null;
            LC_SCREEN = null;
            System.err.println("DrawerAnimationManagerEvo: Warning: no framework available");
            ENABLE_MAIN_AREA_DESATURATION_WHEN_PARTIAL_POPUP_OPENS = false;
        }
        DrawerAnimationManagerEvo.setMapContexts();
    }
}

