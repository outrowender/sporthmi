/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.LocationSerializer$1;
import de.audi.tghu.navi.app.LocationSerializer$2;
import de.audi.tghu.navi.app.LocationSerializer$GetNavLocationCommand;
import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.global.NavLocation;

public class LocationSerializer {
    private static final String BYTE_STREAM_KEY;
    private static final String NAV_LOCATION_KEY;
    private LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private static final long TIMEOUT;

    public LocationSerializer(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
        this.logChannel = navigationEnv.getLogChannel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavLocation streamToLocation(byte[] byArray) {
        if (byArray == null) {
            this.logChannel.log(-1601830656, "LocationSerializer#streamToLocation stream is null");
            return null;
        }
        Object object = new Object();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationSerializer$1(this, "StreamToLocationCommand", byArray));
        LocationSerializer$GetNavLocationCommand locationSerializer$GetNavLocationCommand = new LocationSerializer$GetNavLocationCommand(this, object);
        commandList.add(locationSerializer$GetNavLocationCommand);
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("StreamToLocationCommandList");
            try {
                object.wait(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.logChannel.log(-2137614336, "LocationSerializer#streamToLocation - %1", (Object)locationSerializer$GetNavLocationCommand.getNavLocationResult());
        return locationSerializer$GetNavLocationCommand.getNavLocationResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public byte[] locationToStream(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "LocationSerializer#locationToStream location is null");
            return null;
        }
        Object object = new Object();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationSerializer$2(this, "LocationToStreamCommand", navLocation));
        LocationSerializer$GetNavLocationCommand locationSerializer$GetNavLocationCommand = new LocationSerializer$GetNavLocationCommand(this, object);
        commandList.add(locationSerializer$GetNavLocationCommand);
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("LocationToStreamCommandList");
            try {
                object.wait(0);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.logChannel.log(-2137614336, "LocationSerializer#locationToStream - %1", (Object)locationSerializer$GetNavLocationCommand.getByteLocationResult());
        return locationSerializer$GetNavLocationCommand.getByteLocationResult();
    }
}

