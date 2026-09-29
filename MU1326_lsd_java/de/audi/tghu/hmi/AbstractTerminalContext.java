/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.AbstractRootWindowFactory;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenCache;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.HMIRegistry;

public abstract class AbstractTerminalContext
implements ITerminalContext {
    protected FwHMI fwHMI;
    protected LogChannel log;
    protected final int terminalID;
    protected IRootWindow rootWindow;
    protected IScreenManager screenManager;
    protected IPopupManager popupManager;
    protected ITerminalContext[] subTerminals = new ITerminalContext[4];

    public AbstractTerminalContext(int n) {
        this.terminalID = n;
    }

    @Override
    public int getTerminalID() {
        return this.terminalID;
    }

    @Override
    public boolean isCluster() {
        return this.getTerminalID() == 1;
    }

    @Override
    public ITerminalContext getSubterminal(int n) {
        if (n == 0) {
            return this;
        }
        if (this.getTerminalID() == 1 && this.subTerminals[n] == null) {
            this.subTerminals[n] = this.createSubTerminalContext(this.getTerminalID());
            this.subTerminals[n].initialize(this.getHMIService());
        }
        return this.subTerminals[n];
    }

    protected abstract ITerminalContext createSubTerminalContext(int n) {
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.fwHMI.getFramework();
    }

    @Override
    public HMIService getHMIService() {
        return this.fwHMI;
    }

    protected HMIRegistry getHMIRegistry() {
        return this.fwHMI.getHMIRegistry();
    }

    @Override
    public HMITerminal getHmiTerminal() {
        return this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID());
    }

    @Override
    public IRootWindow getRootWindow() {
        if (this.rootWindow == null) {
            switch (this.terminalID) {
                case 0: {
                    if (!this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 1: {
                    if (!this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 2: {
                    this.log.log(-2137614336, "IRootWindowImpl#getInstance: Returning instanceFrontPassenger");
                    if (!this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 3: {
                    this.log.log(-2137614336, "IRootWindowImpl#getInstance: Returning instanceRearSeat1");
                    if (this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 4: {
                    this.log.log(-2137614336, "IRootWindowImpl#getInstance: Returning instanceRearSeat2");
                    if (this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 5: {
                    this.log.log(-2137614336, "IRootWindowImpl#getInstance: Returning instanceRearSeatJoint");
                    if (this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 6: {
                    this.log.log(-2137614336, "IRootWindowImpl#getInstance: Returning instanceSDS");
                    if (!this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                case 7: {
                    this.log.log(-2137614336, "IRootWindowImpl#getInstance: Returning instanceSideContext");
                    if (!this.getFramework().isFrontMU()) break;
                    this.rootWindow = AbstractRootWindowFactory.getInstance().getRootWindow(this.terminalID);
                    break;
                }
                default: {
                    this.log.log(10000, "ERR: RootWindow.getInstance(): unknown terminal ID ");
                }
            }
        }
        return this.rootWindow;
    }

    @Override
    public Screen getScreenFromCache(int n) {
        ScreenCache screenCache = null;
        Screen screen = null;
        if (this.getHmiTerminal() != null && (screenCache = this.getHmiTerminal().getScreenCache()) != null && (screen = screenCache.getScreen(n)) != null) {
            this.log.log(-2137614336, "TerminalManager.getScreenFromCache(): returning %1 ", (Object)screen);
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getScreenStatistics().increaseCacheHits(n);
            }
            return screen;
        }
        if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
            StatisticsManager.instance().getScreenStatistics().getScreenStart(n);
        }
        screen = this.getHMIRegistry().getScreen(this.getTerminalID(), n);
        if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
            StatisticsManager.instance().getScreenStatistics().getScreenEnd();
        }
        if (screen != null) {
            screen.setTerminal(this.getHmiTerminal());
            if (screenCache != null) {
                this.log.log(-2137614336, "TerminalManager.getScreenFromCache(): cache screen == %1", (Object)screen);
                screenCache.putScreen(screen);
            }
        }
        return screen;
    }

    @Override
    public HMIApplication getHMIApplication(int n) {
        return this.getHMIRegistry().getHMIApplication(n);
    }

    @Override
    public HMIModel getModel(int n) {
        return this.getHMIRegistry().getModel(this.getTerminalID(), n);
    }

    @Override
    public void callbackScreenVisible(int n) {
        HMIApplication hMIApplication = this.getHMIApplication(n);
        if (hMIApplication != null) {
            this.log.log(-2137614336, "TerminalContext[%1]: hmiApp.screenVisible(), screen = %2", (long)this.getTerminalID(), (long)n);
            hMIApplication.screenVisible(n, this.getTerminalID());
        }
    }

    @Override
    public void callbackScreenHidden(int n) {
        HMIApplication hMIApplication = this.getHMIApplication(n);
        if (hMIApplication != null) {
            this.log.log(-2137614336, "TerminalContext[%1]: hmiApp.screenHidden(), screen = %2", (long)this.getTerminalID(), (long)n);
            hMIApplication.screenHidden(n, this.getTerminalID());
        }
    }

    @Override
    public void callbackPopupVisible(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n);
        if (hMIApplication != null) {
            this.log.log(-2137614336, "TerminalContext[%1]: hmiApp.popupVisible(), popup = %2", (long)this.getTerminalID(), (long)n2);
            hMIApplication.popupVisible(n2, this.getTerminalID());
        }
    }

    @Override
    public void callbackPopupHidden(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n);
        if (hMIApplication != null) {
            this.log.log(-2137614336, "TerminalContext[%1]: hmiApp.popupHidden(), popup = %2", (long)this.getTerminalID(), (long)n2);
            hMIApplication.popupHidden(n2, this.getTerminalID());
        }
    }

    @Override
    public void callbackPopupRemoved(int n, int n2) {
        HMIApplication hMIApplication = this.getHMIApplication(n);
        if (hMIApplication != null) {
            this.log.log(-2137614336, "TerminalContext[%1].callbackPopupRemoved(), popup = %2", (long)this.getTerminalID(), (long)n2);
            hMIApplication.popupRemoved(n2, this.getTerminalID());
        }
    }
}

