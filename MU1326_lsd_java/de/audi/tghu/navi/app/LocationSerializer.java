/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class LocationSerializer {
    private static final String BYTE_STREAM_KEY = "ByteStream";
    private static final String NAV_LOCATION_KEY = "NavLocation";
    private LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private static final long TIMEOUT = 30000L;

    public LocationSerializer(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
        this.logChannel = navigationEnv.getLogChannel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavLocation streamToLocation(final byte[] byArray) {
        if (byArray == null) {
            this.logChannel.log(100000, "LocationSerializer#streamToLocation stream is null");
            return null;
        }
        Object object = new Object();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("StreamToLocationCommand"){

            public void execute() {
                this.getDSINavigation().streamToLocation(byArray);
            }

            public void streamToLocationResult(boolean bl, NavLocation navLocation) {
                if (bl) {
                    this.getCommandList().put(LocationSerializer.NAV_LOCATION_KEY, navLocation);
                }
                this.getCommandList().commandFinished();
            }
        });
        GetNavLocationCommand getNavLocationCommand = new GetNavLocationCommand(object);
        commandList.add(getNavLocationCommand);
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("StreamToLocationCommandList");
            try {
                object.wait(30000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.logChannel.log(10000000, "LocationSerializer#streamToLocation - %1", (Object)getNavLocationCommand.getNavLocationResult());
        return getNavLocationCommand.getNavLocationResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public byte[] locationToStream(final NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(100000, "LocationSerializer#locationToStream location is null");
            return null;
        }
        Object object = new Object();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("LocationToStreamCommand"){

            public void execute() {
                this.getDSINavigation().locationToStream(navLocation);
            }

            public void locationToStreamResult(boolean bl, byte[] byArray) {
                if (bl) {
                    this.getCommandList().put(LocationSerializer.BYTE_STREAM_KEY, byArray);
                }
                this.getCommandList().commandFinished();
            }
        });
        GetNavLocationCommand getNavLocationCommand = new GetNavLocationCommand(object);
        commandList.add(getNavLocationCommand);
        Object object2 = object;
        synchronized (object2) {
            commandList.execute("LocationToStreamCommandList");
            try {
                object.wait(30000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.logChannel.log(10000000, "LocationSerializer#locationToStream - %1", (Object)getNavLocationCommand.getByteLocationResult());
        return getNavLocationCommand.getByteLocationResult();
    }

    private class GetNavLocationCommand
    extends NavCommand {
        private NavLocation navLocation;
        private byte[] byteLocation;
        private final Object waitingLock;

        public GetNavLocationCommand(Object object) {
            this.waitingLock = object;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void execute() {
            Object object = this.waitingLock;
            synchronized (object) {
                this.navLocation = (NavLocation)this.getCommandList().get(LocationSerializer.NAV_LOCATION_KEY);
                this.byteLocation = (byte[])this.getCommandList().get(LocationSerializer.BYTE_STREAM_KEY);
                this.waitingLock.notify();
            }
            this.getCommandList().commandFinished();
        }

        public NavLocation getNavLocationResult() {
            return this.navLocation;
        }

        public byte[] getByteLocationResult() {
            return this.byteLocation;
        }
    }
}

