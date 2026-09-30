/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.rse;

import de.audi.atip.log.LogChannel;
import de.audi.atip.rse.AbstractRSECommand;
import de.audi.atip.rse.AbstractRSECommandFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractRSEConnection {
    private static LogChannel log;
    private final Object cmdFactoriesLock = new Object();
    protected final Object connectionLock = new Object();
    protected final Object connectionStatusLock = new Object();
    private AbstractRSECommandFactory[] cmdFactories = new AbstractRSECommandFactory[32];
    private ServiceRegistration rseConnectionService;
    private final BundleContext bc;
    private boolean connectionIsEstablished;
    private List[] commandQueues = new ArrayList[32];
    static /* synthetic */ Class class$de$audi$atip$rse$AbstractRSEConnection;

    public AbstractRSEConnection(BundleContext bundleContext) {
        this.bc = bundleContext;
    }

    public static void setLog(LogChannel logChannel) {
        log = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerCommandFactory(AbstractRSECommandFactory abstractRSECommandFactory) {
        Object object = this.cmdFactoriesLock;
        synchronized (object) {
            if (abstractRSECommandFactory != null) {
                int n = abstractRSECommandFactory.getModuleID();
                this.cmdFactories[n] = abstractRSECommandFactory;
                AbstractRSEConnection.getLog().log(10000000, "AbstractRSEConnection#registerCommandFactory: Registering command factory: %1", (long)n);
                if (this.commandQueues[n] != null && this.commandQueues[n].size() > 0) {
                    while (!this.commandQueues[n].isEmpty()) {
                        AbstractRSEConnection.getLog().log(10000000, "AbstractRSEConnection#registerCommandFactory: executing cached command for module %1", (long)n);
                        byte[] byArray = (byte[])this.commandQueues[n].get(0);
                        this.commandQueues[n].remove(0);
                        try {
                            this.decodeAndExecuteCommand(byArray);
                        }
                        catch (IOException iOException) {
                            AbstractRSEConnection.getLog().log(10000, "AbstractRSEConnection#registerCommandFactory: ", (Throwable)iOException);
                        }
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterCommandFactory(AbstractRSECommandFactory abstractRSECommandFactory) {
        Object object = this.cmdFactoriesLock;
        synchronized (object) {
            if (abstractRSECommandFactory != null) {
                int n = abstractRSECommandFactory.getModuleID();
                this.cmdFactories[n] = null;
                AbstractRSEConnection.getLog().log(10000000, "AbstractRSEConnection#registerCommandFactory: Unregistering command factory: %1", (long)n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int decodeAndExecuteCommand(byte[] byArray) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(byteArrayInputStream));
        int n = -1;
        n = AbstractRSECommand.decodeHeader(dataInputStream);
        int n2 = AbstractRSECommand.extractModuleID(n);
        if (n != -1 && n2 != -1 && n2 >= 0 && n2 < this.cmdFactories.length) {
            AbstractRSEConnection.getLog().log(10000000, "AbstractRSEConnection#decodeCommand: module=%1, cmdID=%2", (long)n2, (long)n);
            AbstractRSECommandFactory abstractRSECommandFactory = null;
            Object object = this.cmdFactoriesLock;
            synchronized (object) {
                abstractRSECommandFactory = this.cmdFactories[n2];
            }
            if (abstractRSECommandFactory != null) {
                object = abstractRSECommandFactory.getCommand(n);
                if (object != null) {
                    ((AbstractRSECommand)object).decode(dataInputStream);
                    ((AbstractRSECommand)object).execute(this);
                    return n;
                }
                AbstractRSEConnection.getLog().log(10000, "AbstractRSEConnection#decodeCommand: Command with module=%1, cmdID=%2 not found", (long)n2, (long)n);
            } else {
                AbstractRSEConnection.getLog().log(10000, "AbstractRSEConnection#decodeCommand: Command factory %1 is null. Caching command %2", (long)n2, (long)n);
                this.cacheCommand(n2, byArray);
            }
        } else {
            AbstractRSEConnection.getLog().log(10000, "AbstractRSEConnection#decodeCommand: cmdID / module not valid: cmdID=%1, module=%2", (long)n, (long)n2);
        }
        return n;
    }

    private void cacheCommand(int n, byte[] byArray) {
        if (this.commandQueues[n] == null) {
            this.commandQueues[n] = new ArrayList(10);
        }
        this.commandQueues[n].add(byArray);
    }

    public abstract void sendCommand(AbstractRSECommand var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void connectionEstablished() {
        AbstractRSEConnection.getLog().log(10000000, "AbstractRSEConnection#connectionEstablished");
        Object object = this.connectionStatusLock;
        synchronized (object) {
            this.setConnectionEstablished(true);
            this.setRseConnectionService(this.getBc().registerService((class$de$audi$atip$rse$AbstractRSEConnection == null ? (class$de$audi$atip$rse$AbstractRSEConnection = AbstractRSEConnection.class$("de.audi.atip.rse.AbstractRSEConnection")) : class$de$audi$atip$rse$AbstractRSEConnection).getName(), (Object)this, null));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void connectionBroken() {
        AbstractRSEConnection.getLog().log(10000000, "AbstractRSEConnection#connectionBroken: Cleaning up");
        Object object = this.connectionStatusLock;
        synchronized (object) {
            this.getRseConnectionService().unregister();
            this.setRseConnectionService(null);
            this.setConnectionEstablished(false);
        }
    }

    protected static LogChannel getLog() {
        return log;
    }

    private BundleContext getBc() {
        return this.bc;
    }

    private void setRseConnectionService(ServiceRegistration serviceRegistration) {
        this.rseConnectionService = serviceRegistration;
    }

    private ServiceRegistration getRseConnectionService() {
        return this.rseConnectionService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setConnectionEstablished(boolean bl) {
        Object object = this.connectionStatusLock;
        synchronized (object) {
            this.connectionIsEstablished = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean isConnectionEstablished() {
        Object object = this.connectionStatusLock;
        synchronized (object) {
            return this.connectionIsEstablished;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

