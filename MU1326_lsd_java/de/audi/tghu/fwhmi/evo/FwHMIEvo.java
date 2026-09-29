/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.cc.IComponentConditionManager;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IVisualFeedback;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.evo.FwHMIEvo$1;
import de.audi.tghu.fwhmi.evo.FwHMIEvo$2;
import de.audi.tghu.fwhmi.evo.FwHMIEvo$3;
import de.audi.tghu.fwhmi.evo.FwHMIEvo$4;
import de.audi.tghu.fwhmi.evo.HMIRegistryEvo;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.audi.tghu.hmi.evo.ITerminalContextEvo;

public class FwHMIEvo
extends FwHMI
implements IHMIServiceEvo {
    private LogChannel logRepaintCause;

    public FwHMIEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    @Override
    public Object getKanziResource(String string, Object object, int n, int n2, int n3) {
        return ((ITerminalContextEvo)this.getTerminalManager(n2)).getKanziResource(string, object, n, n3);
    }

    @Override
    public IDrawerControllerEvo[] getSelectionDrawers(int n, int n2) {
        return ((ITerminalContextEvo)this.getTerminalManager(n)).getSelectionDrawers(n2);
    }

    @Override
    public IDrawerControllerEvo[] getOptionDrawers(int n, int n2) {
        return ((ITerminalContextEvo)this.getTerminalManager(n)).getOptionDrawers(n2);
    }

    @Override
    public IComponentConditionManager getComponentConditionManager() {
        return this.getHMIRegistry().getConditionsObserver();
    }

    @Override
    public void switchToDisplayContext(int n, int n2, int n3, int n4) {
        this.getLogHMI().log(-2137614336, "FwHMIEvo.switchToDisplayContextFake(): context == %1", (long)n);
    }

    @Override
    protected void createHMIRegistry() {
        if (null == this.hmiRegistry) {
            this.hmiRegistry = new HMIRegistryEvo(this.getFramework().getBundleCxt(), this);
        }
    }

    @Override
    public void sMActionRequiresNoScreenChange(int n) {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
        if (n == 0 && (iDrawerFocusManagerEvo = ((HMITerminalEvo)this.getTerminalManager(0).getHmiTerminal()).getDrawerFocusManager()) != null && (iDrawerFocusManagerEvo.getDrawerState() == 4 && iDrawerFocusManagerEvo.isDrawerClosingRequested(4) || iDrawerFocusManagerEvo.getDrawerState() == 8 && iDrawerFocusManagerEvo.isDrawerClosingRequested(8))) {
            this.getLogHMI().log(-2137614336, "FwHMIEvo#sMActionRequiresNoScreenChange smID=%1", (long)n);
            if (!this.getTerminalManager(0).getHmiTerminal().getIAnimationController().isScreenChangeAnimationRunning()) {
                iDrawerFocusManagerEvo.requestDrawerState(16);
            } else {
                this.getLogHMI().log(-2137614336, "FwHMIEvo#sMActionRequiresNoScreenChange not closing drawer because screen change animation running");
            }
        }
    }

    @Override
    public void showVisualFeedback(long l, String string, int n) {
        if (l <= 0L) {
            return;
        }
        if (n != -1) {
            if (null != string) {
                this.flashText(string, l, n);
            } else {
                this.flashScreen(l, n);
            }
        } else {
            for (int i2 = 0; i2 < 8; ++i2) {
                if (null != string) {
                    this.flashText(string, l, i2);
                    continue;
                }
                this.flashScreen(l, i2);
            }
        }
    }

    private void flashScreen(long l, int n) {
        IRootWindow iRootWindow = this.getRootWindow(n);
        IVisualFeedback iVisualFeedback = ((HMITerminalEvo)this.getTerminalRegistry().getTerminal(n)).getVisualFeedback();
        if (null != iRootWindow && null != iVisualFeedback) {
            this.getEventDispatcher().postEvent(new RunnableEvent(false, new FwHMIEvo$1(this, iVisualFeedback, iRootWindow)));
            this.getEventDispatcher().postEvent(new RunnableEvent(false, new FwHMIEvo$2(this, iVisualFeedback, iRootWindow)), l);
        }
    }

    protected LogChannel getLogRepaintCause() {
        if (this.logRepaintCause == null) {
            this.logRepaintCause = this.getFramework().getLogChannel("Fw.Widgets.RepaintCause");
        }
        return this.logRepaintCause;
    }

    private void flashText(String string, long l, int n) {
        IRootWindow iRootWindow = this.getRootWindow(n);
        IVisualFeedback iVisualFeedback = ((HMITerminalEvo)this.getTerminalRegistry().getTerminal(n)).getVisualFeedback();
        if (null != iRootWindow && null != iVisualFeedback) {
            this.getEventDispatcher().postEvent(new RunnableEvent(false, new FwHMIEvo$3(this, iVisualFeedback, string, iRootWindow)));
            this.getEventDispatcher().postEvent(new RunnableEvent(false, new FwHMIEvo$4(this, iVisualFeedback, iRootWindow)), l);
        }
    }

    @Override
    public Screen getPartialPopup(int n, int n2) {
        return ((ITerminalContextEvo)this.getTerminalManager(n)).getPartialPopup(n, n2);
    }
}

