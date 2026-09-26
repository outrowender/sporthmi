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

    @Override
    public IGUIManager getGUIManager() {
        return null;
    }

    public IKanziResourceLoader getKanziResourceLoader() {
        return null;
    }

    @Override
    protected StringUtility generateStringUtility() {
        return null;
    }

    @Override
    protected IDrawerFocusManagerEvo generateDrawerFocusManager() {
        return null;
    }

    @Override
    protected IDrawerManager generateDrawerManager() {
        return null;
    }

    @Override
    protected IViewSizeManager generateViewSizeManager() {
        return null;
    }

    @Override
    protected IDrawerConditionEngine generateDrawerConditionEngine(BundleContext bundleContext) {
        return null;
    }

    @Override
    protected ITouchInputManager generateTouchInputManager() {
        return null;
    }

    @Override
    protected void initializeGraphics() {
    }

    @Override
    protected void initializeBins() {
    }

    @Override
    protected Screen createFallbackScreen() {
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(-129);
        screenWidgetEVO.setRenderer(new ScreenRendererHigh(screenWidgetEVO));
        screenWidgetEVO.setTerminal(this);
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -1, -1, -1}});
        screenWidgetEVO.setColorIndices(new int[]{0, 0, 0, 0});
        return screenWidgetEVO;
    }

    @Override
    protected DumpInfoProvider createRenderInfoProvider() {
        return null;
    }

    @Override
    protected void disposeGraphics() {
    }

    @Override
    protected Layout generateLayout() {
        return null;
    }

    @Override
    protected IAnimationController generateAnimationController() {
        return new AnimationControllerMIB2High(109);
    }

    @Override
    protected IImageLoader generateImageLoader() {
        return null;
    }

    @Override
    protected IFontLoader generateFontLoader() {
        return null;
    }

    @Override
    protected IPartialPopupManagerEvo generatePartialPopupManagerEvo() {
        return null;
    }

    @Override
    protected IPresetInputHandler generatePresetPopupHandler() {
        return null;
    }

    @Override
    protected IPhoneKeyHandler generatePhoneKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        return null;
    }

    @Override
    protected void setJointTerminalFocus(int n) {
    }

    @Override
    protected void initializeOSGi() {
    }

    @Override
    protected void initializeApplicationModels() {
    }

    @Override
    public IUserHintHandler getUserHintHandler() {
        return null;
    }

    @Override
    protected ILongpressKeyHandler generateLongpressKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        return null;
    }

    @Override
    protected ICarCodingHelper generateCarCodingHelper() {
        return null;
    }

    @Override
    protected IKzbMappingHelper generateKzbMappingHelper(ICarCodingHelper iCarCodingHelper) {
        return null;
    }
}

