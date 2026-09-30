/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.di.IBackupLocationHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public class DestTransfereToNdfHandler
implements IRouteGuidanceListener {
    private final IDestinationHandler destinationHandler;
    private final IBackupLocationHandler backupLocationHandler;
    private final LogChannel logChannel;

    public DestTransfereToNdfHandler(IDestinationHandler iDestinationHandler, IBackupLocationHandler iBackupLocationHandler, LogChannel logChannel) {
        this.destinationHandler = iDestinationHandler;
        this.backupLocationHandler = iBackupLocationHandler;
        this.logChannel = logChannel;
    }

    public void routeGuidanceRequested(Route route, NavLocation navLocation) {
        this.logChannel.log(1000000, "DestTransfereToNdfHandler#routeGuidanceRequested() Transfere NavLocation %1 to NDF %2 ", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Boolean.toString(this.destinationHandler.shouldTransfereToNdf()));
        if (navLocation == null || Util.isHURegionAsia()) {
            this.destinationHandler.setTransfereToNdf(false);
            return;
        }
        if (navLocation.isPositionValid() && this.destinationHandler.shouldTransfereToNdf()) {
            this.backupLocationHandler.setBackupLocation(navLocation);
            this.backupLocationHandler.persistBackupLocation(navLocation);
            this.destinationHandler.setTransfereToNdf(false);
        }
    }

    public void cancelStartRouteCalculation() {
    }
}

