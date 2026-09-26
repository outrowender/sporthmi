/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class LocationSerializer$GetNavLocationCommand
extends NavCommand {
    private NavLocation navLocation;
    private byte[] byteLocation;
    private final Object waitingLock;
    private final /* synthetic */ LocationSerializer this$0;

    public LocationSerializer$GetNavLocationCommand(LocationSerializer locationSerializer, Object object) {
        this.this$0 = locationSerializer;
        this.waitingLock = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        Object object = this.waitingLock;
        synchronized (object) {
            this.navLocation = (NavLocation)this.getCommandList().get("NavLocation");
            this.byteLocation = (byte[])this.getCommandList().get("ByteStream");
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

