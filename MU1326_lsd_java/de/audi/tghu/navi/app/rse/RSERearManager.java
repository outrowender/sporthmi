/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rse;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.Criteria;
import de.audi.tghu.navi.app.rse.RSEManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Title;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

class RSERearManager
extends RSEManager {
    protected RSERearManager(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected void setListeners() {
        this.env.getButtonModel(400670).setButtonListener(this);
        this.env.getButtonModel(400489).setButtonListener(this);
        this.env.getButtonModel(400673).setButtonListener(this);
        this.env.getButtonModel(400668).setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "RSERearManager#keyPressed( %1 )", (long)n);
        Object var4_4 = null;
        switch (n) {
            case 400489: 
            case 400670: {
                if (!Navigation.isRouteCalcMode()) break;
                this.env.fireModelEvent(400489, n3);
                break;
            }
            case 400673: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400668: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(100000, "RSERearManager#keyPressed() - unknown model id: %1!", (long)n);
            }
        }
    }

    public CommandList prepareRouteTransfer(Route route) {
        this.logChannel.log(10000000, "RSERearManager#prepareRouteTransfer( %1 )", (Object)RouteUtil.formatRouteShort(route));
        CommandList commandList = null;
        if (RouteUtil.isRouteNavigable(route)) {
            NavLocation navLocation = RouteUtil.getFinalDestination(route);
            commandList = this.prepareLocationTransfer(navLocation, true);
        } else {
            this.logChannel.log(10000000, "RSERearManager#prepareRouteTransfer() - given route is not navigable!");
        }
        return commandList;
    }

    public CommandList prepareLocationTransfer(NavLocation navLocation, boolean bl) {
        this.logChannel.log(10000000, "RSERearManager#prepareLocationTransfer( %2, %1 )", bl, (Object)LocationFormatter.formatLocationShort(navLocation));
        CommandList commandList = null;
        if (!this.env.getFramework().isFrontMU()) {
            if (navLocation != null && navLocation.isPositionValid()) {
                Object var4_4 = null;
                Title title = new Title(navLocation, true, this.env);
            } else {
                this.logChannel.log(100000, "RSERearManager#prepareLocationTransfer() - given location is not navigable!");
            }
        } else {
            this.logChannel.log(100000, "RSERearManager#prepareLocationTransfer() - destination transfer not allowed on front unit!");
        }
        return commandList;
    }

    private CommandList prepareShownMap() {
        return null;
    }

    public void decodeLocationStream(byte[] byArray, Criteria criteria) {
        this.logChannel.log(100000, "RSERearManager#decodeLocationStream() - function not supported on rear unit!");
    }

    public void syncCriteria(Criteria criteria) {
        this.logChannel.log(100000, "RSERearManager#transferRouteCriteria() - function not supported on rear unit!");
    }
}

