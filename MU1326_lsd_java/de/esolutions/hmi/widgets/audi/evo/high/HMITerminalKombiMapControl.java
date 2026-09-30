/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IFontLoader;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.audi.tghu.hmi.evo.IKzbMappingHelper;
import de.audi.tghu.hmi.evo.ILongpressKeyHandler;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.audi.tghu.hmi.evo.IPhoneKeyHandler;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IDrawerManager;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import org.osgi.framework.BundleContext;

public class HMITerminalKombiMapControl
extends HMITerminalImpl {
    public HMITerminalKombiMapControl(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        super(n, bundleContext, iFrameworkAccess);
    }

    public IGUIManager getGUIManager() {
        return null;
    }

    public IKanziResourceLoader getKanziResourceLoader() {
        return null;
    }

    protected StringUtility generateStringUtility() {
        return null;
    }

    protected IDrawerFocusManagerEvo generateDrawerFocusManager() {
        return null;
    }

    protected IDrawerManager generateDrawerManager() {
        return null;
    }

    protected IViewSizeManager generateViewSizeManager() {
        return null;
    }

    protected IDrawerConditionEngine generateDrawerConditionEngine(BundleContext bundleContext) {
        return null;
    }

    protected ITouchInputManager generateTouchInputManager() {
        return null;
    }

    protected void initializeGraphics() {
    }

    protected void initializeBins() {
    }

    protected Screen createFallbackScreen() {
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(Integer.MAX_VALUE);
        screenWidgetEVO.setRenderer(new ScreenRendererHigh(screenWidgetEVO));
        screenWidgetEVO.setTerminal(this);
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -1, -1, -1}});
        screenWidgetEVO.setColorIndices(new int[]{0, 0, 0, 0});
        return screenWidgetEVO;
    }

    protected DumpInfoProvider createRenderInfoProvider() {
        return null;
    }

    protected void disposeGraphics() {
    }

    protected Layout generateLayout() {
        return null;
    }

    protected IAnimationController generateAnimationController() {
        return new AnimationControllerMIB2High(109);
    }

    protected IImageLoader generateImageLoader() {
        return null;
    }

    protected IFontLoader generateFontLoader() {
        return null;
    }

    protected IPartialPopupManagerEvo generatePartialPopupManagerEvo() {
        return null;
    }

    protected IPresetInputHandler generatePresetPopupHandler() {
        return null;
    }

    protected IPhoneKeyHandler generatePhoneKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        return null;
    }

    protected void setJointTerminalFocus(int n) {
    }

    protected void initializeOSGi() {
    }

    protected void initializeApplicationModels() {
    }

    public IUserHintHandler getUserHintHandler() {
        return null;
    }

    protected ILongpressKeyHandler generateLongpressKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        return null;
    }

    protected ICarCodingHelper generateCarCodingHelper() {
        return null;
    }

    protected IKzbMappingHelper generateKzbMappingHelper(ICarCodingHelper iCarCodingHelper) {
        return null;
    }
}

