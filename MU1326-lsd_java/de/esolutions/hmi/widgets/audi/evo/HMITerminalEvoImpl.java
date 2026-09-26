/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.audi.tghu.hmi.evo.ILockingManager;
import de.audi.tghu.hmi.evo.IWidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.DrawerConditionEngine;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.TouchInputManager;
import de.esolutions.hmi.widgets.audi.evo.UserHintHandler;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;
import org.osgi.framework.BundleContext;

public abstract class HMITerminalEvoImpl
extends HMITerminalImpl
implements ExtHMITerminalEvo {
    protected IRendererFactory rendererFactory;
    protected static IKanziResourceLoader kanziResourceLoader;
    private UserHintHandler userHintHandler;
    protected int skin = 0;
    protected ILockingManager lockingmanager;

    public HMITerminalEvoImpl(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        super(n, bundleContext, iFrameworkAccess);
    }

    @Override
    protected IDrawerFocusManagerEvo generateDrawerFocusManager() {
        return new DrawerFocusManager(this);
    }

    @Override
    protected IViewSizeManager generateViewSizeManager() {
        return new ViewSizeManager(this);
    }

    @Override
    protected void initializeComponents() {
        this.generateLockingManager();
        super.initializeComponents();
        this.rendererFactory = this.generateRendererFactory();
        this.userHintHandler = this.generateUserHintHandler();
    }

    private void generateLockingManager() {
        this.lockingmanager = LockingManager.getInstance(IWidgetLogChannel.logLocking);
    }

    @Override
    public ILockingManager getLockingManager() {
        return this.lockingmanager;
    }

    private UserHintHandler generateUserHintHandler() {
        return new UserHintHandler(this);
    }

    @Override
    public IUserHintHandler getUserHintHandler() {
        return this.userHintHandler;
    }

    @Override
    public IRendererFactory getRendererFactory() {
        return this.rendererFactory;
    }

    protected abstract IRendererFactory generateRendererFactory() {
    }

    @Override
    protected IDrawerConditionEngine generateDrawerConditionEngine(BundleContext bundleContext) {
        return new DrawerConditionEngine(this, this.framework, bundleContext);
    }

    @Override
    protected ITouchInputManager generateTouchInputManager() {
        return new TouchInputManager(this);
    }

    protected abstract void generateKanziResourceLoader(IGUIManager iGUIManager) {
    }

    @Override
    public int getSkin() {
        return this.skin;
    }

    @Override
    public void setSkin(int n) {
        this.skin = n;
    }

    @Override
    public IWidgetRegistry getWidgetRegistryIf() {
        return this.widgetRegistry;
    }
}

