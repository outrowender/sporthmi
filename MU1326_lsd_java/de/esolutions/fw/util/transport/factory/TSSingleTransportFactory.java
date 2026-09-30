/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.TSTransport;

public class TSSingleTransportFactory
extends BaseTransportFactory
implements ISingleTransportFactory {
    private String fileName;

    public TSSingleTransportFactory(String string, String string2) {
        this.fileName = string + "/connect/" + string2;
    }

    public ITransport createTransport() {
        TSTransport tSTransport = new TSTransport(this.fileName);
        ITransport iTransport = new PacketTransport(tSTransport);
        iTransport = this.enrichTransport(iTransport);
        return iTransport;
    }

    public String getDescription() {
        return "[File:" + this.fileName + "]";
    }
}

