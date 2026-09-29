/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap$1;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap$TrafficMiniMapDSIListener;
import de.audi.tghu.navi.app.map.minimap.DSIAsiaTrafficInfoMenuListenerAdapter;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import de.audi.tghu.navi.app.map.minimap.NullTrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.TrafficMiniMapInterruptStorage;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.BundleContext;

public abstract class AbstractTrafficMiniMap
implements ITrafficMiniMap {
    protected final LogChannel logChannel;
    private DSIActivator dsiActivator = null;
    protected final IFrameworkAccess framework;
    private DSIAsiaTrafficInfoMenu dsiAsiaTrafficInfoMenu;
    private int currentlyDisplayedID;
    protected final ICruiseModeHandler cruiseModeHandler;
    protected ITrafficMiniMapView view = ITrafficMiniMapView.NULL_TMM_VIEW;
    protected AbstractTrafficMiniMap$TrafficMiniMapDSIListener dsiListener;
    private TrafficMiniMapInterruptStorage interruptStorage;
    public static final ITrafficMiniMap NULL_TRAFFIC_MINI_MAP = new NullTrafficMiniMap();
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener;

    public AbstractTrafficMiniMap(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, ICruiseModeHandler iCruiseModeHandler) {
        this.logChannel = logChannel;
        this.framework = iFrameworkAccess;
        this.cruiseModeHandler = iCruiseModeHandler;
        this.dsiListener = new AbstractTrafficMiniMap$TrafficMiniMapDSIListener(this);
        this.interruptStorage = new TrafficMiniMapInterruptStorage(this.logChannel);
    }

    @Override
    public abstract void loadState() {
    }

    @Override
    public abstract void persistSettings() {
    }

    @Override
    public abstract void resetSettings() {
    }

    private boolean isInterruptTypeTraffiMiniMap(int n) {
        return 21 == n;
    }

    protected void requestResourceInformation(int n) {
        try {
            this.logChannel.log(10000, "TrafficMiniMap#requestResourceInformation calling requestResourceInformation");
            this.dsiAsiaTrafficInfoMenu.requestResourceInformation(n);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "TrafficMiniMap#requestResourceInformation# exception = %1", (Throwable)exception);
        }
    }

    @Override
    public void startDSI(BundleContext bundleContext) {
        this.getDSIActivator().start(bundleContext);
    }

    private DSIActivator getDSIActivator() {
        if (this.dsiActivator == null) {
            AbstractTrafficMiniMap$1 abstractTrafficMiniMap$1 = new AbstractTrafficMiniMap$1(this);
            this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = AbstractTrafficMiniMap.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName(), (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = AbstractTrafficMiniMap.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener).getName(), new Integer(0), this.dsiListener, abstractTrafficMiniMap$1);
        }
        return this.dsiActivator;
    }

    @Override
    public void stopDSI(BundleContext bundleContext) {
        this.getDSIActivator().stop(bundleContext);
    }

    private boolean checkCruiseMode() {
        return this.cruiseModeHandler.isInCruiseMode();
    }

    private boolean checkCenter2Car() {
        return this.cruiseModeHandler.isCenterToCar();
    }

    @Override
    public DSIBase getDSI() {
        return this.dsiAsiaTrafficInfoMenu;
    }

    @Override
    public void setActive(boolean bl) {
        this.view.setActive(bl);
    }

    @Override
    public void setCurrentSystemLanguage() {
    }

    @Override
    public boolean isActive() {
        return this.view.isActivated();
    }

    public int getCurrentlyDisplayedID() {
        return this.currentlyDisplayedID;
    }

    @Override
    public void tmpCommandSetActive(boolean bl) {
        this.view.activateAndPersist();
        this.persistSettings();
    }

    @Override
    public void cleanup() {
    }

    public DSIAsiaTrafficInfoMenuListenerAdapter getTrafficMiniMapDSIListener() {
        return this.dsiListener;
    }

    @Override
    public final boolean isVisible() {
        return this.view.isVisible();
    }

    @Override
    public void hideTrafficMiniMap() {
    }

    @Override
    public void activateAndPersist(boolean bl) {
        if (bl) {
            this.view.activateAndPersist();
        } else {
            this.view.deactivateAndPersist();
        }
    }

    static /* synthetic */ DSIAsiaTrafficInfoMenu access$002(AbstractTrafficMiniMap abstractTrafficMiniMap, DSIAsiaTrafficInfoMenu dSIAsiaTrafficInfoMenu) {
        abstractTrafficMiniMap.dsiAsiaTrafficInfoMenu = dSIAsiaTrafficInfoMenu;
        return abstractTrafficMiniMap.dsiAsiaTrafficInfoMenu;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$100(AbstractTrafficMiniMap abstractTrafficMiniMap) {
        return abstractTrafficMiniMap.checkCruiseMode();
    }

    static /* synthetic */ TrafficMiniMapInterruptStorage access$200(AbstractTrafficMiniMap abstractTrafficMiniMap) {
        return abstractTrafficMiniMap.interruptStorage;
    }

    static /* synthetic */ boolean access$300(AbstractTrafficMiniMap abstractTrafficMiniMap, int n) {
        return abstractTrafficMiniMap.isInterruptTypeTraffiMiniMap(n);
    }

    static /* synthetic */ int access$402(AbstractTrafficMiniMap abstractTrafficMiniMap, int n) {
        abstractTrafficMiniMap.currentlyDisplayedID = n;
        return abstractTrafficMiniMap.currentlyDisplayedID;
    }
}

