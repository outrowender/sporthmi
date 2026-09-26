/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.sds.ISDSCommandDistpacher;
import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;

public class SDSCommandDispatcherImpl
implements ISDSCommandDistpacher {
    private static final String LOGCLASS;
    private final HashMap[] commandTerminalMap = new HashMap[3];
    private final LogChannel logger;

    public SDSCommandDispatcherImpl(LogChannel logChannel) {
        this.logger = logChannel;
        for (int i2 = 0; i2 < this.commandTerminalMap.length; ++i2) {
            this.commandTerminalMap[i2] = new HashMap();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"SDSCommandDispatcherImpl");
        for (int i2 = 0; i2 < this.commandTerminalMap.length; ++i2) {
            HashMap hashMap = this.commandTerminalMap[i2];
            synchronized (hashMap) {
                this.commandTerminalMap[i2].clear();
                continue;
            }
        }
    }

    private static int getMapIdxForTerminalID(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addCommandListener(int n, ISDSCommandListener iSDSCommandListener) {
        int n2 = SDSCommandDispatcherImpl.getMapIdxForTerminalID(n);
        if (iSDSCommandListener == null || n2 < 0) {
            throw new IllegalArgumentException();
        }
        this.logger.log(1078071040, "[%1.addCommandListener] '%2','%3','%4'", (Object)"SDSCommandDispatcherImpl", (Object)MediaUtils.getTerminalIDToStr(n), (Object)iSDSCommandListener.getCommandIDs(), (Object)iSDSCommandListener);
        HashMap hashMap = this.commandTerminalMap[n2];
        synchronized (hashMap) {
            for (int i2 = 0; i2 < iSDSCommandListener.getCommandIDs().length; ++i2) {
                Integer n3 = Integers.valueOf(iSDSCommandListener.getCommandIDs()[i2]);
                if (this.commandTerminalMap[n2].containsKey(n3)) {
                    this.logger.log(1078071040, "[%1.addCommandListener] Always registered. Overwrite.", (Object)"SDSCommandDispatcherImpl");
                }
                this.commandTerminalMap[n2].put(n3, iSDSCommandListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeCommandListener(int n, ISDSCommandListener iSDSCommandListener) {
        this.logger.log(1078071040, "[%1.removeCommandListener] '%2','%3'", (Object)"SDSCommandDispatcherImpl", (Object)MediaUtils.getTerminalIDToStr(n), (Object)iSDSCommandListener);
        int n2 = SDSCommandDispatcherImpl.getMapIdxForTerminalID(n);
        if (iSDSCommandListener == null || n2 < 0) {
            throw new IllegalArgumentException();
        }
        HashMap hashMap = this.commandTerminalMap[n2];
        synchronized (hashMap) {
            for (int i2 = 0; i2 < iSDSCommandListener.getCommandIDs().length; ++i2) {
                this.commandTerminalMap[n2].remove(Integers.valueOf(iSDSCommandListener.getCommandIDs()[i2]));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object notifyCommand(int n, int n2, Map map) {
        ISDSCommandListener iSDSCommandListener;
        this.logger.log(1078071040, "[%1.notifyCommand] '%2','%3'", (Object)"SDSCommandDispatcherImpl", (Object)MediaUtils.getTerminalIDToStr(n2), (long)n);
        int n3 = SDSCommandDispatcherImpl.getMapIdxForTerminalID(n2);
        if (map == null || n3 < 0) {
            throw new IllegalArgumentException();
        }
        HashMap hashMap = this.commandTerminalMap[n3];
        synchronized (hashMap) {
            iSDSCommandListener = (ISDSCommandListener)this.commandTerminalMap[n3].get(new Integer(n));
        }
        if (iSDSCommandListener == null) {
            this.logger.log(1078071040, "[%1.notifyCommand] Command '%2' not registered for terminal '%3'", (Object)"SDSCommandDispatcherImpl", (Object)new Integer(n), (Object)MediaUtils.getTerminalIDToStr(n2));
            return null;
        }
        return iSDSCommandListener.performCommand(n, map);
    }
}

