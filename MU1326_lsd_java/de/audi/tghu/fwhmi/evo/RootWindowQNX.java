/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.AbstractWindow;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ComponentConditionEvent;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.event.LockingEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.fwhmi.evo.IRootWindowEvo;
import de.audi.tghu.fwhmi.evo.RootWindowQNX$RepaintProvider;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import java.io.OutputStream;

final class RootWindowQNX
extends AbstractWindow
implements IRootWindowEvo {
    private static boolean layersInitialized = true;
    private boolean repainting = false;
    IDrawerFocusManagerEvo drawerFocusManager;
    IViewSizeManager viewSizeManager;
    private IGUIManager guiManager;
    private static final int REPAINT_TIMER_INTERVAL;

    RootWindowQNX(int n, IFrameworkAccess iFrameworkAccess) {
        super(n, iFrameworkAccess);
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(new RootWindowQNX$RepaintProvider(this, null));
        if (Boolean.getBoolean("EnableIdleRendering")) {
            this.startNativeWindowUpdater(100);
        }
    }

    @Override
    protected void paintGUI() {
        if (this.guiManager == null) {
            this.guiManager = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getGUIManager();
        }
        if (this.currentScreen != null && this.guiManager != null) {
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getScreenStatistics().paintStart(this.currentScreen.getID());
            }
            this.currentScreen.paint();
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getScreenStatistics().paintEnd();
            }
            this.guiManager.draw();
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getScreenStatistics().drawEnd();
            }
            this.guiManager.swapBuffers();
            if (!layersInitialized) {
                layersInitialized = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void repaint() {
        this.repainting = true;
        try {
            this.paintGUI();
        }
        finally {
            this.repainting = false;
        }
    }

    @Override
    protected void writeBMPPixelData(int[] nArray, int n, int n2, OutputStream outputStream) {
        byte[] byArray = new byte[3];
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            for (int i3 = 0; i3 < n; ++i3) {
                int n3 = i2 * n + i3;
                byArray[2] = (byte)(nArray[n3] >> 16 & 0xFF);
                byArray[1] = (byte)(nArray[n3] >> 8 & 0xFF);
                byArray[0] = (byte)(nArray[n3] & 0xFF);
                outputStream.write(byArray);
            }
        }
    }

    @Override
    public IDrawerFocusManagerEvo getDrawerFocusManager() {
        return this.drawerFocusManager;
    }

    @Override
    public void setDrawerFocusManager(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        this.drawerFocusManager = iDrawerFocusManagerEvo;
    }

    @Override
    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        this.viewSizeManager = iViewSizeManager;
    }

    @Override
    public void add(IScreenData iScreenData, Screen screen) {
        super.add(iScreenData, screen);
        if (null != this.viewSizeManager) {
            this.viewSizeManager.setScreen(screen);
        }
        if (null != this.drawerFocusManager) {
            this.drawerFocusManager.setScreen(iScreenData, screen);
        }
    }

    @Override
    protected void processEventImpl(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof ComponentConditionEvent && this.getTerminalID() != 1) {
            this.getHMITerminalEvo().getDrawerConditionEngine().processCCEvent((ComponentConditionEvent)aTIPEvent);
        } else if (aTIPEvent instanceof DrawerEvent) {
            IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.getHMITerminalEvo().getDrawerFocusManager();
            if (iDrawerFocusManagerEvo != null) {
                DrawerEvent drawerEvent = (DrawerEvent)aTIPEvent;
                iDrawerFocusManagerEvo.processDrawerEvent(drawerEvent);
            }
        } else if (aTIPEvent instanceof LockingEvent) {
            this.getHMITerminalEvo().getLockingManager().processLockingEvent((LockingEvent)aTIPEvent);
        } else {
            super.processEventImpl(aTIPEvent);
        }
    }

    @Override
    protected void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.getTerminalID() == 1) {
            this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: CLUSTER - Processing allowed for ModelUpdateEvent with terminalID == %2.", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
        } else if (modelUpdateEvent.getTerminalID() == -1 || modelUpdateEvent.getTerminalID() == this.getTerminalID()) {
            this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: Processing allowed for ModelUpdateEvent with terminalID == %2.", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
        } else {
            this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: ModelUpdateEvent with terminalID == %2 ignored", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
            return;
        }
        if (this.drawerFocusManager != null) {
            this.drawerFocusManager.processModelUpdateEvent(modelUpdateEvent);
        }
        if (this.currentScreen != null) {
            this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to current screen", (Object)modelUpdateEvent);
            this.currentScreen.processModelUpdateEvent(modelUpdateEvent);
        }
        this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to smInterpreter", (Object)modelUpdateEvent);
        this.getFramework().getSMInterpreter().processUpdate(modelUpdateEvent);
    }

    protected HMITerminalEvo getHMITerminalEvo() {
        return (HMITerminalEvo)this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID());
    }

    @Override
    public IViewSizeManager getViewSizeManager() {
        return this.viewSizeManager;
    }

    static /* synthetic */ boolean access$100(RootWindowQNX rootWindowQNX) {
        return rootWindowQNX.repainting;
    }

    static /* synthetic */ Screen access$200(RootWindowQNX rootWindowQNX) {
        return rootWindowQNX.currentScreen;
    }

    static /* synthetic */ Screen access$300(RootWindowQNX rootWindowQNX) {
        return rootWindowQNX.currentScreen;
    }
}

