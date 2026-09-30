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
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

final class RootWindowQNX
extends AbstractWindow
implements IRootWindowEvo {
    private static boolean layersInitialized = true;
    private boolean repainting = false;
    IDrawerFocusManagerEvo drawerFocusManager;
    IViewSizeManager viewSizeManager;
    private IGUIManager guiManager;
    private static final int REPAINT_TIMER_INTERVAL = 100;

    RootWindowQNX(int n, IFrameworkAccess iFrameworkAccess) {
        super(n, iFrameworkAccess);
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(new RepaintProvider());
        if (Boolean.getBoolean("EnableIdleRendering")) {
            this.startNativeWindowUpdater(100);
        }
    }

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
    public void repaint() {
        this.repainting = true;
        try {
            this.paintGUI();
        }
        finally {
            this.repainting = false;
        }
    }

    protected void writeBMPPixelData(int[] nArray, int n, int n2, OutputStream outputStream) throws IOException {
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

    public IDrawerFocusManagerEvo getDrawerFocusManager() {
        return this.drawerFocusManager;
    }

    public void setDrawerFocusManager(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        this.drawerFocusManager = iDrawerFocusManagerEvo;
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        this.viewSizeManager = iViewSizeManager;
    }

    public void add(IScreenData iScreenData, Screen screen) {
        super.add(iScreenData, screen);
        if (null != this.viewSizeManager) {
            this.viewSizeManager.setScreen(screen);
        }
        if (null != this.drawerFocusManager) {
            this.drawerFocusManager.setScreen(iScreenData, screen);
        }
    }

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

    protected void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.getTerminalID() == 1) {
            this.logATIPEvent.log(1000000, "IRootWindowImpl[%1]#processEventImpl: CLUSTER - Processing allowed for ModelUpdateEvent with terminalID == %2.", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
        } else if (modelUpdateEvent.getTerminalID() == -1 || modelUpdateEvent.getTerminalID() == this.getTerminalID()) {
            this.logATIPEvent.log(1000000, "IRootWindowImpl[%1]#processEventImpl: Processing allowed for ModelUpdateEvent with terminalID == %2.", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
        } else {
            this.logATIPEvent.log(1000000, "IRootWindowImpl[%1]#processEventImpl: ModelUpdateEvent with terminalID == %2 ignored", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
            return;
        }
        if (this.drawerFocusManager != null) {
            this.drawerFocusManager.processModelUpdateEvent(modelUpdateEvent);
        }
        if (this.currentScreen != null) {
            this.logATIPEvent.log(10000000, "RootWindow: sending %1 to current screen", (Object)modelUpdateEvent);
            this.currentScreen.processModelUpdateEvent(modelUpdateEvent);
        }
        this.logATIPEvent.log(10000000, "RootWindow: sending %1 to smInterpreter", (Object)modelUpdateEvent);
        this.getFramework().getSMInterpreter().processUpdate(modelUpdateEvent);
    }

    protected HMITerminalEvo getHMITerminalEvo() {
        return (HMITerminalEvo)this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID());
    }

    public IViewSizeManager getViewSizeManager() {
        return this.viewSizeManager;
    }

    private class RepaintProvider
    implements DumpInfoProvider {
        private RepaintProvider() {
        }

        public String getName() {
            return new StringBuffer().append("RepaintInfo").append(RootWindowQNX.this.getTerminalID()).toString();
        }

        public void dump(PrintStream printStream, String string) {
            printStream.println(RootWindowQNX.this.repainting ? "In Repaint" : "Not in Repaint");
            if (RootWindowQNX.this.currentScreen != null) {
                printStream.println(new StringBuffer().append("Current Screen: ").append(RootWindowQNX.this.currentScreen.getID()).toString());
            }
        }
    }
}

