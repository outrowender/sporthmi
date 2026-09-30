/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.push;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.GenericSpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.message.TraceMessage;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.remote.AbstractConnectionFrontendListener;
import de.esolutions.fw.util.tracing.remote.AbstractRemoteFrontend;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendOneShotWorker;
import de.esolutions.fw.util.tracing.remote.IConnectionFrontendListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RemoteListenFrontend
extends AbstractRemoteFrontend
implements ISpawnedConnectionListener,
IConnectionFrontendListener {
    private final GenericSpawnConnectionFactory factory;
    private final TraceFrontend frontend;
    private final Map workers;
    private final List listeners;
    private int cid;
    private int tid;
    private static final String chn = "RemoteListenFrontend";

    public RemoteListenFrontend(GenericSpawnConnectionFactory genericSpawnConnectionFactory, TraceFrontend traceFrontend) {
        super(traceFrontend);
        this.factory = genericSpawnConnectionFactory;
        this.factory.setListener(this);
        this.frontend = traceFrontend;
        this.workers = new HashMap();
        this.listeners = new ArrayList();
    }

    public boolean start() {
        if (!super.start()) {
            return false;
        }
        TraceMe.msg(TraceMe.INFO, chn, "start");
        TraceEntityURIWithLevel traceEntityURIWithLevel = this.frontend.createEntity((short)1, "server", (short)7, null);
        TraceEntityURIWithLevel traceEntityURIWithLevel2 = this.frontend.createEntity((short)3, "clients", (short)7, traceEntityURIWithLevel);
        if (traceEntityURIWithLevel2 == null) {
            return false;
        }
        this.cid = traceEntityURIWithLevel2.getId();
        TraceEntityURIWithLevel traceEntityURIWithLevel3 = this.frontend.createEntity((short)2, Thread.currentThread().getName(), (short)7, traceEntityURIWithLevel);
        this.tid = traceEntityURIWithLevel3.getId();
        try {
            this.factory.enableSpawning();
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        HashMap hashMap;
        TraceMe.msg(TraceMe.INFO, chn, "stop");
        this.factory.disableSpawning();
        Object object = this.workers;
        synchronized (object) {
            hashMap = new HashMap(this.workers);
        }
        object = hashMap.values().iterator();
        while (object.hasNext()) {
            ConnectionFrontendOneShotWorker connectionFrontendOneShotWorker = (ConnectionFrontendOneShotWorker)object.next();
            TraceMe.msg(TraceMe.INFO, chn, "stopping worker %1", connectionFrontendOneShotWorker);
            connectionFrontendOneShotWorker.stop();
        }
        super.stop();
    }

    public void addListener(IConnectionFrontendListener iConnectionFrontendListener) {
        this.listeners.add(iConnectionFrontendListener);
    }

    public void removeListener(IConnectionFrontendListener iConnectionFrontendListener) {
        this.listeners.remove(iConnectionFrontendListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void spawnedConnection(Connection connection) {
        TraceMe.msg(TraceMe.INFO, chn, "spawned connection: %1", connection.getDescription());
        String string = SystemConfig.getInstance().getMyProcName();
        ConnectionFrontendOneShotWorker connectionFrontendOneShotWorker = new ConnectionFrontendOneShotWorker(string, connection, this.frontend);
        AbstractConnectionFrontendListener abstractConnectionFrontendListener = new AbstractConnectionFrontendListener();
        abstractConnectionFrontendListener.setPassiveMode(false);
        connectionFrontendOneShotWorker.addListener(abstractConnectionFrontendListener);
        connectionFrontendOneShotWorker.addListener(this);
        connectionFrontendOneShotWorker.start();
        Map map = this.workers;
        synchronized (map) {
            this.workers.put(connection, connectionFrontendOneShotWorker);
        }
    }

    public boolean spawningRetry(ISpawnConnectionFactory iSpawnConnectionFactory, IOException iOException, int n) {
        TraceMe.msg(TraceMe.INFO, chn, "%1 retry spawning: %2", iSpawnConnectionFactory.getDescription(), iOException);
        return true;
    }

    public void spawningEnabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
        TraceMe.msg(TraceMe.INFO, chn, "%1 enabeld", iSpawnConnectionFactory.getDescription());
    }

    public void spawningDisabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
        TraceMe.msg(TraceMe.INFO, chn, "%1 disabled", iSpawnConnectionFactory.getDescription());
    }

    public void log(String string) {
        if (this.cid == -1 || this.tid == -1) {
            return;
        }
        long l = System.currentTimeMillis();
        TraceMessage traceMessage = new TraceMessage(l, this.cid, this.tid, 2, 0, 1, string);
        this.frontend.log(traceMessage);
    }

    public void registerConnection(ConnectionFrontendHandler connectionFrontendHandler) {
        TraceMe.msg(TraceMe.INFO, chn, "connected: " + connectionFrontendHandler);
        this.log("[" + connectionFrontendHandler.getPeerName() + "] connected");
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IConnectionFrontendListener iConnectionFrontendListener = (IConnectionFrontendListener)iterator.next();
            iConnectionFrontendListener.registerConnection(connectionFrontendHandler);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterConnection(ConnectionFrontendHandler connectionFrontendHandler) {
        TraceMe.msg(TraceMe.INFO, chn, "disconnected: " + connectionFrontendHandler);
        this.log("[" + connectionFrontendHandler.getPeerName() + "] disconnected");
        Connection connection = connectionFrontendHandler.getConnection();
        Object object = this.workers;
        synchronized (object) {
            this.workers.remove(connection);
        }
        object = this.listeners.iterator();
        while (object.hasNext()) {
            IConnectionFrontendListener iConnectionFrontendListener = (IConnectionFrontendListener)object.next();
            iConnectionFrontendListener.unregisterConnection(connectionFrontendHandler);
        }
    }

    public void configureHandler(ConnectionFrontendHandler connectionFrontendHandler) {
        connectionFrontendHandler.setIsMaster(false);
    }

    public void handleMessage(ConnectionFrontendHandler connectionFrontendHandler, AbstractMessage abstractMessage) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IConnectionFrontendListener iConnectionFrontendListener = (IConnectionFrontendListener)iterator.next();
            iConnectionFrontendListener.handleMessage(connectionFrontendHandler, abstractMessage);
        }
    }
}

