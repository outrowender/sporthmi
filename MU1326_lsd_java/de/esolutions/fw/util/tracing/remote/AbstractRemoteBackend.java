/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.protocol.ProtocolException;
import de.esolutions.fw.util.tracing.protocol.ProtocolHandler;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExitMessage;
import de.esolutions.fw.util.tracing.remote.RemoteBackendActions;
import de.esolutions.fw.util.tracing.remote.SyncMarkerSender;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;
import java.util.Date;

public abstract class AbstractRemoteBackend
extends AbstractTraceBackend {
    private int maxEntities;
    private String id;
    private Connection connection;
    private ProtocolHandler protocol;
    private int syncCount;
    private boolean sendSyncMarkers;
    private SyncMarkerSender syncSender;

    public AbstractRemoteBackend(String string) {
        super(string);
    }

    public void setSendSyncMarkers(boolean bl) {
        this.sendSyncMarkers = bl;
    }

    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        this.maxEntities = iTraceBackendListener.getCoreMaxEntities();
        this.id = iTraceBackendListener.getCoreId();
    }

    public boolean adjustToChangeLevel(ITraceEntity iTraceEntity) {
        return true;
    }

    public boolean isPassiveConnect() {
        if (this.protocol == null) {
            return false;
        }
        return this.protocol.getState() == 2;
    }

    public String getPeerName() {
        if (this.protocol == null) {
            return null;
        }
        return this.protocol.getPeerName();
    }

    public int getFlags() {
        return 0;
    }

    public boolean log(ITraceMessage iTraceMessage) {
        try {
            if (this.protocol != null) {
                this.protocol.sendLogData(iTraceMessage);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "log message failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "log message failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "log message failed: " + interruptedException);
            return false;
        }
    }

    public ITraceMessage logBulk(ITraceMessage[] iTraceMessageArray) {
        try {
            if (this.protocol != null) {
                this.protocol.sendLogDataBulk(iTraceMessageArray);
            }
            return null;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "bulk log message failed: " + iOException);
            return iTraceMessageArray[0];
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "bulk log message failed: " + transportException);
            return iTraceMessageArray[0];
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "bulk log message failed: " + interruptedException);
            return iTraceMessageArray[0];
        }
    }

    public boolean droppedMessages(int n) {
        try {
            if (this.protocol != null) {
                this.protocol.sendDroppedMessages(n);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "dropped messages failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "dropped messages failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "dropped messages failed: " + interruptedException);
            return false;
        }
    }

    public boolean createEntity(ITraceEntity iTraceEntity) {
        try {
            if (this.protocol != null) {
                this.protocol.sendCreateEntity(iTraceEntity.createExternalCoreEntity());
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "create failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "create failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "create failed: " + interruptedException);
            return false;
        }
    }

    public boolean createEntityBulk(ITraceEntity[] iTraceEntityArray) {
        try {
            if (this.protocol != null && iTraceEntityArray != null) {
                int n = iTraceEntityArray.length;
                IExternalTraceEntity[] iExternalTraceEntityArray = new IExternalTraceEntity[n];
                for (int i2 = 0; i2 < n; ++i2) {
                    iExternalTraceEntityArray[i2] = iTraceEntityArray[i2].createExternalCoreEntity();
                }
                this.protocol.sendCreateEntityBulk(iExternalTraceEntityArray);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "create failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "create failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "create failed: " + interruptedException);
            return false;
        }
    }

    public boolean registerTimeZone(int n, int n2, String string) {
        try {
            if (this.protocol != null) {
                this.listener.logMessage(this.bid, "send register timezone");
                this.protocol.sendRegisterTimeZone(n, n2, string);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "register timezone failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "register timezone failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "register timezone failed: " + interruptedException);
            return false;
        }
    }

    public boolean updateTimeZone(int n, long l, long l2) {
        try {
            if (this.protocol != null) {
                this.listener.logMessage(this.bid, "send update timezone");
                this.protocol.sendUpdateTimeZone(n, l, l2);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "update timezone failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "update timezone failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "update timezone failed: " + interruptedException);
            return false;
        }
    }

    public boolean changeFilterLevel(TraceEntityURI traceEntityURI, short s) {
        try {
            if (this.protocol != null) {
                this.protocol.sendChangeLevel(traceEntityURI, s);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "send failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "send failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "send failed: " + interruptedException);
            return false;
        }
    }

    public boolean changeFilterLevelBulk(ITraceEntity[] iTraceEntityArray) {
        try {
            if (this.protocol != null && iTraceEntityArray != null) {
                int n = iTraceEntityArray.length;
                IExternalTraceEntity[] iExternalTraceEntityArray = new IExternalTraceEntity[n];
                for (int i2 = 0; i2 < n; ++i2) {
                    iExternalTraceEntityArray[i2] = iTraceEntityArray[i2].createExternalCoreEntity();
                }
                this.protocol.sendChangeLevelBulk(iExternalTraceEntityArray);
            }
            return true;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "send failed: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "send failed: " + transportException);
            return false;
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "send failed: " + interruptedException);
            return false;
        }
    }

    protected boolean remoteConnect(Connection connection, boolean bl, boolean bl2, boolean bl3) throws InterruptedException {
        try {
            this.connection = connection;
            this.listener.logMessage(this.bid, "trying to open connection " + connection.getDescription());
            this.protocol = new ProtocolHandler(this.id, connection, bl);
            this.protocol.setMaxEntities(this.maxEntities);
            this.protocol.setActionHandler(new RemoteBackendActions(this.bid, this.listener));
            connection.open();
            if (this.protocol.connect(bl2, bl3)) {
                this.listener.logMessage(this.bid, "protocol connected");
                this.listener.connected(this.bid, true);
                if (this.sendSyncMarkers) {
                    this.syncCount = 0;
                    this.syncSender = new SyncMarkerSender(this);
                    this.syncSender.start();
                }
                return true;
            }
            connection.close(true);
            return false;
        }
        catch (IOException iOException) {
            this.listener.logMessage(this.bid, "ERROR: opening connection: " + iOException);
            return false;
        }
        catch (TransportException transportException) {
            this.listener.logMessage(this.bid, "ERROR: opening connection: " + transportException);
            return false;
        }
        catch (SerializerException serializerException) {
            this.listener.logMessage(this.bid, "ERROR: opening connection: " + serializerException);
            return false;
        }
        catch (ProtocolException protocolException) {
            this.listener.logMessage(this.bid, "ERROR: opening connection: " + protocolException);
            return false;
        }
    }

    protected boolean remoteDisconnect() {
        if (this.protocol == null) {
            return false;
        }
        this.listener.logMessage(this.bid, "disconnecing remote");
        if (this.syncSender != null) {
            this.syncSender.stop();
            this.syncSender = null;
        }
        if (this.protocol != null) {
            try {
                this.protocol.disconnect();
                this.protocol = null;
            }
            catch (ProtocolException protocolException) {
                this.listener.logMessage(this.bid, "disconnecing remote: protocol notes: " + protocolException.getMessage());
            }
            catch (InterruptedException interruptedException) {
            }
            catch (IOException iOException) {
                this.listener.logMessage(this.bid, "disconnecing remote: IO notes: " + iOException.getMessage());
            }
            catch (TransportException transportException) {
                this.listener.logMessage(this.bid, "disconnecing remote: transport notes: " + transportException.getMessage());
            }
        }
        if (this.connection != null) {
            try {
                this.connection.close(true);
                this.connection = null;
            }
            catch (Exception exception) {
                this.listener.logMessage(this.bid, "disconnection exception " + exception);
                return false;
            }
        }
        this.listener.disconnected(this.bid);
        return true;
    }

    protected boolean handleProtocol() {
        try {
            if (this.protocol != null) {
                AbstractMessage abstractMessage = this.protocol.handleIncomingMessage();
                return abstractMessage != null && !(abstractMessage instanceof ExitMessage);
            }
            return false;
        }
        catch (Exception exception) {
            this.listener.logMessage(this.bid, "protocol interrupted: " + exception);
            return false;
        }
    }

    protected void sendSyncMarker() {
        if (this.protocol != null) {
            Date date = new Date();
            try {
                this.protocol.sendSyncMarker(this.syncCount, date.getTime());
                ++this.syncCount;
            }
            catch (Exception exception) {
                this.listener.logMessage(this.bid, "error sending sync marker: " + exception);
            }
        }
    }
}

