/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;
import de.audi.tghu.navi.app.map.minimap.DSIAsiaTrafficInfoMenuListenerAdapter;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import de.audi.tghu.navi.app.map.minimap.NullTrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.TrafficMiniMapInterruptStorage;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
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
    protected TrafficMiniMapDSIListener dsiListener;
    private TrafficMiniMapInterruptStorage interruptStorage;
    public static final ITrafficMiniMap NULL_TRAFFIC_MINI_MAP = new NullTrafficMiniMap();
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener;

    public AbstractTrafficMiniMap(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, ICruiseModeHandler iCruiseModeHandler) {
        this.logChannel = logChannel;
        this.framework = iFrameworkAccess;
        this.cruiseModeHandler = iCruiseModeHandler;
        this.dsiListener = new TrafficMiniMapDSIListener();
        this.interruptStorage = new TrafficMiniMapInterruptStorage(this.logChannel);
    }

    public abstract void loadState();

    public abstract void persistSettings();

    public abstract void resetSettings();

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

    public void startDSI(BundleContext bundleContext) {
        this.getDSIActivator().start(bundleContext);
    }

    private DSIActivator getDSIActivator() {
        if (this.dsiActivator == null) {
            IDSIClient iDSIClient = new IDSIClient(){

                public void setDSI(DSIBase dSIBase) {
                    AbstractTrafficMiniMap.this.logChannel.log(1000000, "TrafficMiniMap#getDSIActivator#setDSI dsi = (%1)", (Object)dSIBase);
                    AbstractTrafficMiniMap.this.dsiAsiaTrafficInfoMenu = (DSIAsiaTrafficInfoMenu)dSIBase;
                }

                public int[] getAutoNotifications() {
                    return new int[]{1, 2};
                }
            };
            this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = AbstractTrafficMiniMap.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName(), (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = AbstractTrafficMiniMap.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener).getName(), new Integer(0), this.dsiListener, iDSIClient);
        }
        return this.dsiActivator;
    }

    public void stopDSI(BundleContext bundleContext) {
        this.getDSIActivator().stop(bundleContext);
    }

    private boolean checkCruiseMode() {
        return this.cruiseModeHandler.isInCruiseMode();
    }

    private boolean checkCenter2Car() {
        return this.cruiseModeHandler.isCenterToCar();
    }

    public DSIBase getDSI() {
        return this.dsiAsiaTrafficInfoMenu;
    }

    public void setActive(boolean bl) {
        this.view.setActive(bl);
    }

    public void setCurrentSystemLanguage() {
    }

    public boolean isActive() {
        return this.view.isActivated();
    }

    public int getCurrentlyDisplayedID() {
        return this.currentlyDisplayedID;
    }

    public void tmpCommandSetActive(boolean bl) {
        this.view.activateAndPersist();
        this.persistSettings();
    }

    public void cleanup() {
    }

    public DSIAsiaTrafficInfoMenuListenerAdapter getTrafficMiniMapDSIListener() {
        return this.dsiListener;
    }

    public final boolean isVisible() {
        return this.view.isVisible();
    }

    public void hideTrafficMiniMap() {
    }

    public void activateAndPersist(boolean bl) {
        if (bl) {
            this.view.activateAndPersist();
        } else {
            this.view.deactivateAndPersist();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    protected class TrafficMiniMapDSIListener
    extends DSIAsiaTrafficInfoMenuListenerAdapter {
        protected TrafficMiniMapDSIListener() {
        }

        public void updateActiveInterrupts(Interrupt[] interruptArray, int n) {
            AbstractTrafficMiniMap.this.logChannel.log(1000000, "TrafficMiniMapDSIListener#updateActiveInterrupts interrupts=%1 with valid=%2", (Object)interruptArray, (long)n);
            if (1 != n) {
                AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Invalid flag!");
                return;
            }
            if (!AbstractTrafficMiniMap.this.checkCruiseMode()) {
                AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts No cruise mode!");
                return;
            }
            if (!AbstractTrafficMiniMap.this.isActive()) {
                AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Not active!");
                return;
            }
            if (null == interruptArray) {
                AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt-array is null!");
                return;
            }
            if (interruptArray.length < 1) {
                AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt-len < 1!");
                return;
            }
            Interrupt[] interruptArray2 = AbstractTrafficMiniMap.this.interruptStorage.getNewInterrupts(interruptArray);
            if (0 == interruptArray2.length) {
                AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts received no new interrupts out of %1", (long)interruptArray.length);
            }
            Interrupt interrupt = null;
            for (int i2 = 0; i2 < interruptArray2.length; ++i2) {
                AbstractTrafficMiniMap.this.logChannel.log(1000000, "TrafficMiniMapDSIListener#updateActiveInterrupts %1/%2", (long)(1 + i2), (long)interruptArray2.length);
                interrupt = interruptArray2[i2];
                if (null == interrupt) {
                    AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt[%1] is null!", (long)i2);
                    return;
                }
                AbstractTrafficMiniMap.this.logChannel.log(1000000, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt[%1] id=%2.", (long)i2, (long)interrupt.getInterruptId());
                if (!AbstractTrafficMiniMap.this.isInterruptTypeTraffiMiniMap(interrupt.getInterruptType())) {
                    AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Bad interrupt type=%1! -> continue", (long)interrupt.getInterruptType());
                    continue;
                }
                if (interrupt.getInterruptId() == AbstractTrafficMiniMap.this.getCurrentlyDisplayedID()) {
                    AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts Interrupt-id already known/displayed %1!", (long)interrupt.getInterruptId());
                    return;
                }
                AbstractTrafficMiniMap.this.currentlyDisplayedID = interrupt.getInterruptId();
                int[] nArray = interrupt.getContentID();
                if (null == nArray) {
                    AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts contentIDs nulled! - > continue");
                    continue;
                }
                if (0 == nArray.length) {
                    AbstractTrafficMiniMap.this.logChannel.log(100000, "TrafficMiniMapDSIListener#updateActiveInterrupts contentIDs is empty array! - > continue");
                    continue;
                }
                AbstractTrafficMiniMap.this.requestResourceInformation(nArray[0]);
                break;
            }
        }

        public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
            AbstractTrafficMiniMap.this.logChannel.log(1000000, "TrafficMiniMap#requestResourceInformationResponse resourceInformation = %1", (Object)resourceInformation);
            AbstractTrafficMiniMap.this.view.displayMiniMap(resourceInformation);
        }
    }
}

