/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rse;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.rse.AbstractRSECommand;
import de.audi.atip.rse.AbstractRSEConnection;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.Criteria;
import de.audi.tghu.navi.app.rse.RSEFrontManager;
import de.audi.tghu.navi.app.rse.RSENaviCommandFactory;
import de.audi.tghu.navi.app.rse.RSERearManager;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public abstract class RSEManager
implements ButtonListener {
    protected final NavigationEnv env;
    protected LogChannel logChannel;
    protected AbstractRSEConnection rseConnection;
    protected RSENaviCommandFactory factory;

    protected RSEManager(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getRSELogChannel();
        this.factory = new RSENaviCommandFactory(navigationEnv);
        this.setListeners();
    }

    public static RSEManager createManager(NavigationEnv navigationEnv) {
        if (navigationEnv.getFramework().isFrontMU()) {
            return new RSEFrontManager(navigationEnv);
        }
        return new RSERearManager(navigationEnv);
    }

    protected abstract void setListeners() {
    }

    public abstract void decodeLocationStream(byte[] byArray, Criteria criteria) {
    }

    public abstract CommandList prepareRouteTransfer(Route route) {
    }

    public abstract CommandList prepareLocationTransfer(NavLocation navLocation, boolean bl) {
    }

    public abstract void syncCriteria(Criteria criteria) {
    }

    public void setRSEConnection(AbstractRSEConnection abstractRSEConnection) {
        this.logChannel.log(-2137614336, "RSEManager#setRSEConnection( %1 )", (Object)abstractRSEConnection);
        this.rseConnection = abstractRSEConnection;
        if (abstractRSEConnection != null) {
            abstractRSEConnection.registerCommandFactory(this.factory);
        }
    }

    protected void sendCommand(AbstractRSECommand abstractRSECommand) {
        this.logChannel.log(-2137614336, "RSEManager#sendCommand( %1 )", (Object)abstractRSECommand);
        if (this.rseConnection != null) {
            this.rseConnection.sendCommand(abstractRSECommand);
        } else {
            this.logChannel.log(-1601830656, "RSEManager#sendCommand() - failed to send command: connection not present!");
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "RSEManager#keyReleased()");
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "RSEManager#keyTyped()");
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

