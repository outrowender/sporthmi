/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DisplayControllerEvo;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationParamtersEvoHighSportskin;
import de.esolutions.hmi.widgets.audi.evo.high.IAnimationParametersMIB2;

public class AnimationMIB2HighSport
extends AnimationMIB2High {
    public AnimationMIB2HighSport(AbstractAnimationController abstractAnimationController) {
        super(abstractAnimationController);
    }

    protected void doSpecializedAnimation() {
        switch (this.type) {
            case 57: {
                float f2 = this.getValue();
                float f3 = this.fadeIn ? 1.0f - f2 : f2;
                logAnimationSport.log(10000000, "AnimationMIB2HighSport#doSpecializedAnimation viewSizeProgress=%1", (double)f3);
                logAnimationSport.log(10000000, "AnimationMIB2HighSport#doSpecializedAnimation value=%1", (double)f2);
                logAnimationSport.log(10000000, "AnimationMIB2HighSport#doSpecializedAnimation fadIn=%1", this.fadeIn);
                if (this.isMapScreen()) {
                    DisplayControllerEvo displayControllerEvo;
                    this.setViewSizeOpacity(f3);
                    AbstractWidgetController abstractWidgetController = ((AnimationController)this.controller).getSportskinSmallStageMapGrid();
                    if (abstractWidgetController != null) {
                        if (f2 > 0.0f) {
                            abstractWidgetController.setOnScreen(true);
                            float f4 = 1.0f - (float)Math.pow(1.0f - f2, 2.5);
                            abstractWidgetController.setOpacity(f4);
                        } else {
                            abstractWidgetController.setOnScreen(false);
                        }
                    }
                    if ((displayControllerEvo = (DisplayControllerEvo)((AbstractScreenWidget)this.animatedScreen).getDisplayController()) != null) {
                        float f5 = Math.abs((f2 - 0.5f) / 0.5f);
                        displayControllerEvo.setOpacityOnBackgroundLayers(f5, false);
                    }
                    if (f2 < 0.5f) {
                        this.setViewSizeSmallStage(false);
                        if (this.animatedScreen != null && displayControllerEvo != null) {
                            Layout layout = this.getLayout();
                            logAnimationSport.log(100000000, "AnimationMIB2HighSport#doSpecializedAnimation LayoutClass: %1", (Object)layout);
                            int n = layout.getIntegerConstant(82);
                            int n2 = layout.getIntegerConstant(83);
                            logAnimationSport.log(10000000, "AnimationMIB2HighSport#doSpecializedAnimation offsetX= %1, offsetY= %2", (long)n, (long)n2);
                            displayControllerEvo.setPositionOnBackgroundLayers(n, n2, false);
                        }
                    } else {
                        this.setViewSizeSmallStage(true);
                        if (this.animatedScreen != null && displayControllerEvo != null) {
                            Layout layout = this.getLayout();
                            logAnimationSport.log(100000000, "AnimationMIB2HighSport#doSpecializedAnimation LayoutClass: %1", (Object)layout);
                            int n = layout.getIntegerConstant(80);
                            int n3 = layout.getIntegerConstant(81);
                            logAnimationSport.log(10000000, "AnimationMIB2HighSport#doSpecializedAnimation offsetX= %1, offsetY= %2", (long)n, (long)n3);
                            displayControllerEvo.setPositionOnBackgroundLayers(n, n3, false);
                        }
                    }
                } else {
                    float f6 = 1.0f;
                    if (this.fadeIn && f2 < 0.5f || !this.fadeIn && f2 > 0.5f) {
                        this.setViewSizeSmallStage(!this.fadeIn);
                        f6 = -1.0f + 2.0f * f3;
                    } else {
                        f6 = 1.0f - 2.0f * f3;
                    }
                    this.setViewSizeOpacity(f6);
                }
                super.doSpecializedAnimation();
                break;
            }
            default: {
                super.doSpecializedAnimation();
            }
        }
    }

    private void setViewSizeSmallStage(boolean bl) {
        EALManager eALManager = (EALManager)this.controller.getTerminal().getGUIManager();
        this.controller.getTerminal().getViewSizeManager().setSportskinSmallStage(bl);
        AnimationMIB2HighSport.setViewSize(eALManager, this.getLayout(), bl);
    }

    private Layout getLayout() {
        return this.controller.getTerminal().getLayout();
    }

    private boolean isMapScreen() {
        return ((AnimationController)this.controller).getSportskinSmallStageMapGrid() != null && ((AnimationController)this.controller).getSportskinSmallStageMapGrid().isConnected();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static INode2D getSelectionLayer(EALManager eALManager) {
        INode iNode = null;
        if (eALManager == null) {
            return iNode;
        }
        INode2DManaged iNode2DManaged = eALManager.getMasterRoot().getNode();
        if (iNode2DManaged != null) {
            INode2D iNode2D = null;
            INode2D iNode2D2 = null;
            INode iNode2 = null;
            try {
                iNode2D = iNode2DManaged.getChildAtIndex(1L);
                if (iNode2D != null && iNode2D.isValid() && (iNode2D2 = iNode2D.getChildByIndex(200)) != null && iNode2D2.isValid() && (iNode2 = iNode2D2.getChildAtIndex(0L)) != null && iNode2.isValid()) {
                    iNode = iNode2;
                }
            }
            finally {
                if (iNode2D != null) {
                    iNode2D.dispose();
                }
                if (iNode2D2 != null) {
                    iNode2D2.dispose();
                }
                if (iNode2 != null && !iNode2.equals(iNode)) {
                    ((INode2D)iNode2).dispose();
                }
            }
        }
        return iNode;
    }

    public static void setViewSize(EALManager eALManager, Layout layout, boolean bl) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        if (eALManager == null || layout == null || layout.getDistance(1) != 1440) {
            logAnimationSport.log(100000000, "AnimationMIB2HighSport#setViewSize ignoring invocation as either the environment is not configured or the system is not G24");
            return;
        }
        if (bl) {
            n8 = layout.getIntegerConstant(80);
            n7 = layout.getIntegerConstant(81);
            n6 = layout.getIntegerConstant(84);
            n5 = layout.getIntegerConstant(85);
            n4 = layout.getIntegerConstant(97);
            n3 = layout.getIntegerConstant(98);
            n2 = layout.getIntegerConstant(99);
            n = layout.getIntegerConstant(100);
        } else {
            n8 = layout.getIntegerConstant(82);
            n7 = layout.getIntegerConstant(83);
            n6 = layout.getIntegerConstant(86);
            n5 = layout.getIntegerConstant(87);
            n4 = layout.getIntegerConstant(101);
            n3 = layout.getIntegerConstant(102);
            n2 = layout.getIntegerConstant(103);
            n = layout.getIntegerConstant(104);
        }
        if (!AbstractWidget.framework.getLanguageMgr().isLeftToRightOrientation()) {
            n4 = -n4;
            n2 = -n2;
        }
        eALManager.getScreensLayer().getMainNode().setPosition(n8, n7, 0.0f);
        eALManager.getPopupBackLayer().getMainNode().setPosition(n6, n5, 0.0f);
        eALManager.getPopupFrontLayer().getMainNode().setPosition(n6, n5, 0.0f);
        eALManager.getPopupsBetweenLayer().getMainNode().setPosition(n6, n5, 0.0f);
        eALManager.getScreenPartialPopupsLayer().getMainNode().setPosition(n6, n5, 0.0f);
        eALManager.getOptionDrawerClosedLayer().getMainNode().setPosition(n2, n, 0.0f);
        eALManager.getSelectionDrawerClosedLayer().getMainNode().setPosition(n4, n3, 0.0f);
        AnimationMIB2HighSport.setDrawerViewSize(eALManager, layout, bl);
        Car3DResourceHandler car3DResourceHandler = eALManager.getCar3DResourceHandler();
        if (car3DResourceHandler != null) {
            car3DResourceHandler.setSkinTranslation(n8, 0.0f);
        }
    }

    public static void setDrawerViewSize(EALManager eALManager, Layout layout, boolean bl) {
        int n;
        int n2;
        if (eALManager == null || layout == null) {
            return;
        }
        if (bl) {
            n2 = layout.getIntegerConstant(88);
            n = layout.getIntegerConstant(89);
        } else {
            n2 = layout.getIntegerConstant(90);
            n = layout.getIntegerConstant(91);
        }
        INode2D iNode2D = AnimationMIB2HighSport.getSelectionLayer(eALManager);
        if (iNode2D != null) {
            iNode2D.setTranslation(n2, n);
            iNode2D.dispose();
        }
    }

    private void setViewSizeOpacity(float f2) {
        Car3DResourceHandler car3DResourceHandler;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        EALManager eALManager = (EALManager)this.controller.getTerminal().getGUIManager();
        eALManager.getScreensNode().setOpacity(f2);
        eALManager.getOptionDrawerNode().setOpacity(f2);
        eALManager.getPartialPopupsBackNode().setOpacity(f2);
        eALManager.getPartialPopupsFrontNode().setOpacity(f2);
        eALManager.getPartialPopupsBetweenNode().setOpacity(f2);
        INode2D iNode2D = AnimationMIB2HighSport.getSelectionLayer(eALManager);
        if (iNode2D != null) {
            iNode2D.setOpacity(f2);
            iNode2D.dispose();
        }
        if ((car3DResourceHandler = eALManager.getCar3DResourceHandler()) != null) {
            car3DResourceHandler.setSkinOpacity(f2);
        }
    }

    protected void stopSpecializedAnimation() {
        switch (this.type) {
            case 56: {
                if (this.fadeIn) {
                    IWidgetLogChannel.logKDK.log(10000000, "AnimationMIB2HighSport#stopSpecializedAnimation adjsut small stage type on drawers");
                    boolean bl = this.controller.getTerminal().getViewSizeManager().getCurrentViewSize() == 1;
                    this.setViewSizeSmallStage(bl);
                }
                super.stopSpecializedAnimation();
                break;
            }
            default: {
                super.stopSpecializedAnimation();
            }
        }
    }

    protected boolean startSpezializedAnimation() {
        return super.startSpezializedAnimation();
    }

    protected int getKDKBackgroundImage(boolean bl) {
        if (bl) {
            return HMIImageConstantsSystem.kdk_background_default;
        }
        Layout layout = this.controller.getTerminal().getLayout();
        int n = layout.getIntegerConstant(107);
        if (n == 0) {
            n = HMIImageConstantsSystem.kdk_background_default;
        }
        return n;
    }

    protected IAnimationParametersMIB2 getAnimationParameters() {
        return AnimationParamtersEvoHighSportskin.getAnimationParametersEvoHighSportskin();
    }
}

