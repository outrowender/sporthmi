/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class StreamToLocationCommand
extends NavCommand {
    public static final String STREAMED_LOCATION;
    private byte[] stream;
    private String mapKey;

    public StreamToLocationCommand(byte[] byArray) {
        this.stream = byArray;
        this.mapKey = null;
    }

    public StreamToLocationCommand(String string) {
        this.mapKey = string;
        this.stream = null;
    }

    @Override
    public void execute() {
        if (this.mapKey != null) {
            this.stream = (byte[])this.getCommandList().get(this.mapKey);
        }
        if (this.stream != null) {
            this.logger.log(-2137614336, "StreamToLocationCommand#execute() - calling streamToLocation() - stream.length=%1", (long)this.stream.length);
            this.getDSINavigation().streamToLocation(this.stream);
        } else {
            this.getCommandList().commandAborted("stream is null");
        }
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        this.logger.log(-2137614336, "StreamToLocationCommand#streamToLocationResult( %1, %2 )", bl, (Object)LocationFormatter.formatLocationShort(navLocation));
        if (bl) {
            this.getCommandList().put("STREAMED_LOCATION", navLocation);
        }
        this.getCommandList().commandFinished();
    }
}

