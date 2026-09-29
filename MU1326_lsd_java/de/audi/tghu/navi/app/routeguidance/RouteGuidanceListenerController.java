/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.AbstractNaviServiceComponent;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController$1;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController$2;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController$IUpdateOperation;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public class RouteGuidanceListenerController
extends AbstractNaviServiceComponent
implements IRouteGuidanceListener {
    static /* synthetic */ Class class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener;

    public RouteGuidanceListenerController(LogChannel logChannel) {
        super(logChannel);
    }

    private void traverseListeners(RouteGuidanceListenerController$IUpdateOperation routeGuidanceListenerController$IUpdateOperation) {
        Object[] objectArray = this.tracker.getServices();
        if (objectArray != null && objectArray.length > 0) {
            this.logChannel.log(-2137614336, "RouteGuidanceListenerController#traverseListeners - length: %1", (long)objectArray.length);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                IRouteGuidanceListener iRouteGuidanceListener = (IRouteGuidanceListener)objectArray[i2];
                try {
                    routeGuidanceListenerController$IUpdateOperation.update(iRouteGuidanceListener);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "RouteGuidanceListenerController#traverseListeners - error during update. - %1 - %2", (Object)super.getClass().getName(), (Throwable)exception);
                }
            }
        }
    }

    @Override
    public void routeGuidanceRequested(Route route, NavLocation navLocation) {
        this.traverseListeners(new RouteGuidanceListenerController$1(this, route, navLocation));
    }

    @Override
    public void cancelStartRouteCalculation() {
        this.traverseListeners(new RouteGuidanceListenerController$2(this));
    }

    @Override
    protected String[] getTrackedService() {
        return new String[]{(class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener == null ? (class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener = RouteGuidanceListenerController.class$("de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener")) : class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener).getName()};
    }

    @Override
    protected boolean trackedServiceAdded(Object object) {
        this.logChannel.log(-2137614336, "RouteGuidanceListenerController#trackedServiceAdded( %1 )", object);
        if (object instanceof IRouteGuidanceListener) {
            return true;
        }
        this.logChannel.log(-2137614336, "RouteGuidanceListenerController#trackedServiceAdded() - not a IRouteGuidanceListener");
        return false;
    }

    @Override
    protected boolean trackedServiceRemoved(Object object) {
        this.logChannel.log(-2137614336, "RouteGuidanceListenerController#trackedServiceRemoved( %1 )", object);
        return object instanceof IRouteGuidanceListener;
    }

    @Override
    protected void onStart() {
        this.logChannel.log(-2137614336, "RouteGuidanceListenerController#onStart( )");
    }

    @Override
    protected void onStop() {
        this.logChannel.log(-2137614336, "RouteGuidanceListenerController#onStop( )");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

