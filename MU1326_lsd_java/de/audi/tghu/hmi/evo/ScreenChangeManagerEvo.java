/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.PopupManager;
import de.audi.tghu.hmi.ScreenChangeManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.audi.tghu.hmi.evo.ITerminalContextEvo;

public class ScreenChangeManagerEvo
extends ScreenChangeManager {
    public ScreenChangeManagerEvo(ITerminalContext iTerminalContext, IScreenManager iScreenManager, PopupManager popupManager, boolean bl, LogChannel logChannel, LogChannel logChannel2) {
        super(iTerminalContext, iScreenManager, popupManager, bl, logChannel, logChannel2);
    }

    protected void preDisconnectScreen(Screen screen) {
        try {
            if (screen instanceof IScreenEvo) {
                ((IScreenEvo)screen).predisconnecting();
            }
        }
        catch (Exception exception) {
            this.logScreenChange.log(10000, "ScreenChangeManagerEvo#preDisconnectScreen error predisconnecting screen %1", (Throwable)exception);
        }
    }

    protected void afterConnect(Screen screen, boolean bl) {
        if (!bl && this.terminalContext.getHmiTerminal() instanceof HMITerminalEvo && ((HMITerminalEvo)this.terminalContext.getHmiTerminal()).getDrawerFocusManager() != null) {
            this.logScreenChange.log(10000000, "ScreenChangeManagerEvo#afterConnect sending screen change finished to drawer focus manager");
            ((HMITerminalEvo)this.terminalContext.getHmiTerminal()).getDrawerFocusManager().screenFadedOut();
            ((HMITerminalEvo)this.terminalContext.getHmiTerminal()).getDrawerFocusManager().screenChangeFinished();
        }
    }

    public void notifyScreenFadedOut(Screen screen) {
        int[] nArray;
        if (screen instanceof IScreenEvo && (nArray = ((IScreenEvo)screen).getHmiAppsToNotifyForVisibility()) != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                ((ITerminalContextEvo)this.terminalContext).notifyScreenFadedOut(screen.getID(), nArray[i2]);
            }
        }
    }

    public void notifyScreenConnected(Screen screen) {
        int[] nArray;
        if (screen instanceof IScreenEvo && (nArray = ((IScreenEvo)screen).getHmiAppsToNotifyForVisibility()) != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                ((ITerminalContextEvo)this.terminalContext).notifyScreenConnected(screen.getID(), nArray[i2]);
            }
        }
    }

    protected void updateDrawers(Screen screen, IScreenData iScreenData) {
        if (screen instanceof IScreenEvo) {
            ((IScreenEvo)screen).updateDrawers(iScreenData);
        }
    }

    protected void changeToCurrentConnectedScreen(IScreenData iScreenData, boolean bl) {
        if (iScreenData != null) {
            ((HMITerminalEvo)this.terminalContext.getHmiTerminal()).getDrawerFocusManager().changeToCurrentConnectedScreen(iScreenData.isReinit());
        }
        super.changeToCurrentConnectedScreen(iScreenData, bl);
        if (iScreenData != null) {
            ((HMITerminalEvo)this.terminalContext.getHmiTerminal()).getDrawerFocusManager().screenChangeFinished();
        }
    }
}

