/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ITransportFactoryProvider;
import de.esolutions.fw.util.transport.factory.TCPSingleTransportFactory;
import de.esolutions.fw.util.transport.factory.TCPSpawnTransportFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class SimpleTransportFactoryProvider
implements ITransportFactoryProvider {
    protected String myProcName;
    protected Map procMap;
    protected Map nodeMap;

    public SimpleTransportFactoryProvider(String string) {
        this.myProcName = string;
        this.procMap = new HashMap();
        this.nodeMap = new HashMap();
    }

    public void addTCPConnection(String string, String string2, String string3, String string4, int n) {
        AddressPort addressPort = new AddressPort(string4, n);
        this.procMap.put(string + ":" + string2, addressPort);
        this.nodeMap.put(string + ":" + string2 + ":" + string3, addressPort);
    }

    public ISingleTransportFactory createSingleTransportFactory(String string, String string2) throws TransportFactoryException {
        AddressPort addressPort = (AddressPort)this.procMap.get(string + ":" + string2);
        if (addressPort == null) {
            throw new TransportFactoryException("transport for proc " + string + ":" + string2 + " not found!");
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(addressPort.address);
            return new TCPSingleTransportFactory(inetAddress, addressPort.port);
        }
        catch (IOException iOException) {
            throw new TransportFactoryException("Failed IO: " + iOException);
        }
    }

    public ISpawnTransportFactory createSpawnTransportFactory(String string, String string2) throws TransportFactoryException {
        AddressPort addressPort = (AddressPort)this.nodeMap.get(string + ":" + this.myProcName + ":" + string2);
        if (addressPort == null) {
            throw new TransportFactoryException("transport for node " + string + ":" + string2 + " not found!");
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(addressPort.address);
            return new TCPSpawnTransportFactory(inetAddress, addressPort.port);
        }
        catch (IOException iOException) {
            throw new TransportFactoryException("Failed IO: " + iOException);
        }
    }

    protected static class AddressPort {
        public String address;
        public int port;

        public AddressPort(String string, int n) {
            this.address = string;
            this.port = n;
        }
    }
}

