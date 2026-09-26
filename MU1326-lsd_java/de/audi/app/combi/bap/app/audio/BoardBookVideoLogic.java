/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.atip.log.LogChannel;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class BoardBookVideoLogic {
    private static final int DEFAULT_INFO_STATE;
    private final LogChannel logChannel;
    private final Map infoStatesForApps = new ConcurrentHashMap();
    private volatile boolean boardBookVideoRunning = false;
    private volatile boolean boardBookVideoRunningChanged = false;
    private volatile int infoStatesToSend = 0;

    public BoardBookVideoLogic(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void receivedInfoStateFromApp(int n, int n2) {
        this.infoStatesToSend = 0;
        this.boardBookVideoRunningChanged = false;
        this.infoStatesForApps.put(new Integer(n2), new Integer(n));
        if (n == 67) {
            this.logChannel.log(-2137614336, "[BoardBookVideoLogic#receivedInfoStateFromApp] On");
            this.boardBookVideoRunning = true;
            this.boardBookVideoRunningChanged = true;
        } else if (this.boardBookVideoRunning) {
            this.logChannel.log(-2137614336, "[BoardBookVideoLogic#receivedInfoStateFromApp] Off");
            this.boardBookVideoRunning = false;
            this.boardBookVideoRunningChanged = true;
        }
    }

    public boolean isThereAnInfoStateToSend(int n) {
        if (this.boardBookVideoRunningChanged && this.boardBookVideoRunning) {
            this.infoStatesToSend = 67;
            return true;
        }
        if (this.boardBookVideoRunningChanged && !this.boardBookVideoRunning && n != 1) {
            Integer n2 = (Integer)this.infoStatesForApps.get(new Integer(n));
            this.infoStatesToSend = n2 != null ? n2 : 0;
            return true;
        }
        return false;
    }

    public int getInfoStateToSend() {
        return this.infoStatesToSend;
    }
}

