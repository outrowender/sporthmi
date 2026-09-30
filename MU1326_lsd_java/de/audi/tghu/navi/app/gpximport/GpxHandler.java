/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.gpximport;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.ImportRouteFromGpxFileCommand;
import de.audi.tghu.navi.app.gpximport.IRouteImportListener;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class GpxHandler {
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final Navigation navigation;
    private IRouteImportListener routeImportListener;

    public GpxHandler(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, Navigation navigation) {
        this.logChannel = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.navigation = navigation;
    }

    public ICommandList getGpxRouteImportFromFileCommandList(String string, IRouteImportListener iRouteImportListener) {
        this.logChannel.log(10000000, "GpxHandler#importRouteFromGpxFile( %1)", (Object)string);
        this.routeImportListener = iRouteImportListener;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ImportRouteFromGpxFileCommand(string, this));
        return commandList;
    }

    public void setImportedLocation(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        if (iMyLocationAccessor.isNavigable()) {
            if (this.routeImportListener != null) {
                this.routeImportListener.updateStatus(1);
                this.navigation.getStartGuidanceDependantSequence().start(navLocation, true);
            }
        } else if (this.routeImportListener != null) {
            this.routeImportListener.updateStatus(0);
        }
    }
}

