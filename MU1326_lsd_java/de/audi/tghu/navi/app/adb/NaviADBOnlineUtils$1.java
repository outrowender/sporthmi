/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBOnlineUtils;
import de.audi.tghu.navi.app.call.NavSimpleCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

final class NaviADBOnlineUtils$1
extends NavSimpleCall {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ DSINavigationManager val$dsiNavigationManager;
    private final /* synthetic */ NavigationEnv val$env;

    NaviADBOnlineUtils$1(LogChannel logChannel, String string, NavLocation navLocation, DSINavigationManager dSINavigationManager, NavigationEnv navigationEnv) {
        this.val$location = navLocation;
        this.val$dsiNavigationManager = dSINavigationManager;
        this.val$env = navigationEnv;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "NaviADBOnlineUtils#execute( ResolveGeoCoordsCall ) - calling liGetLocationDescriptionTransform( %1 ) ", (Object)LocationFormatter.formatLocationShort(this.val$location));
        this.val$dsiNavigationManager.getDSINavigation(0).liGetLocationDescriptionTransform(this.val$location);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        Object object;
        this.logger.log(-2137614336, "NaviADBOnlineUtils#liGetLocationDescriptionTransformResult() ");
        Object object2 = object = NaviADBOnlineUtils.access$000();
        synchronized (object2) {
            this.val$env.getContainer().setTransformedLocation(navLocation);
            object.notifyAll();
        }
        this.callFinished();
    }
}

