/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IRequestHandler;
import de.audi.app.media.dsi.media.PlayViewExceptionController$RequestData;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;
import java.util.List;

public class PlayViewExceptionController {
    List requests = new LinkedList();
    private IRequestHandler requestHandler;
    private LogChannel log;
    private final String LOGCLASS;

    public PlayViewExceptionController(LogChannel logChannel) {
        this.LOGCLASS = "PlayViewExceptionController";
        this.log = logChannel;
    }

    public synchronized void addRequest(long l, int n, int n2, int n3) {
        PlayViewExceptionController$RequestData playViewExceptionController$RequestData = new PlayViewExceptionController$RequestData(l, n, n2, n3);
        if (this.requests.contains(playViewExceptionController$RequestData)) {
            this.requests.remove(playViewExceptionController$RequestData);
        }
        this.requests.add(playViewExceptionController$RequestData);
    }

    public synchronized void invalidate() {
        for (int i2 = 0; i2 < this.requests.size(); ++i2) {
            PlayViewExceptionController$RequestData playViewExceptionController$RequestData = (PlayViewExceptionController$RequestData)this.requests.get(i2);
            playViewExceptionController$RequestData.invalidate();
        }
    }

    public synchronized void responseReceived(int n) {
        for (int i2 = 0; i2 < this.requests.size(); ++i2) {
            if (((PlayViewExceptionController$RequestData)this.requests.get(i2)).getClientID() != n) continue;
            this.requests.remove(i2);
        }
    }

    public synchronized boolean asyncException(int n, String string, int n2) {
        boolean bl;
        if (n2 != 1013) {
            this.log.log(1078071040, "[%1] Ignoring asyncException. Not on playview request.", (Object)"PlayViewExceptionController");
            return false;
        }
        if (this.requestHandler == null) {
            this.log.log(-1601830656, "[%1] No request handler defined. Ignoring asyncException.", (Object)"PlayViewExceptionController");
            return false;
        }
        if (this.requests.isEmpty()) {
            this.log.log(1078071040, "[%1] No pending requests. Ignoring asyncException.", (Object)"PlayViewExceptionController");
            return true;
        }
        boolean bl2 = n == 8304 || string != null && string.toLowerCase().indexOf("timeout") != -1;
        boolean bl3 = bl = n == 8303 || n == 0 && string != null && string.toLowerCase().indexOf("not allowed to request") != -1;
        if (!bl2 && !bl) {
            PlayViewExceptionController$RequestData playViewExceptionController$RequestData = this.getValidRequestData();
            if (playViewExceptionController$RequestData != null) {
                this.log.log(1078071040, "[%1] Active request %2. Removing request.", (Object)"PlayViewExceptionController", (Object)playViewExceptionController$RequestData);
                this.requests.remove(playViewExceptionController$RequestData);
            }
            return false;
        }
        PlayViewExceptionController$RequestData playViewExceptionController$RequestData = (PlayViewExceptionController$RequestData)this.requests.get(0);
        if (!playViewExceptionController$RequestData.isValid()) {
            this.log.log(1078071040, "[%1] Unresponded, invalid request %2. Ignoring asyncException. Removing request.", (Object)"PlayViewExceptionController", (Object)playViewExceptionController$RequestData);
            this.requests.remove(0);
            return true;
        }
        if (!playViewExceptionController$RequestData.retry()) {
            this.log.log(-1601830656, "[%1] Max retries reached for request. %2", (Object)"PlayViewExceptionController", (Object)playViewExceptionController$RequestData);
            this.requests.remove(playViewExceptionController$RequestData);
            return false;
        }
        RequestParameterList requestParameterList = new RequestParameterList(playViewExceptionController$RequestData.getEntryID(), 0, playViewExceptionController$RequestData.getIndex(), playViewExceptionController$RequestData.getCount(), playViewExceptionController$RequestData.getClientID(), true);
        this.log.log(1078071040, "[%1] Retry for request %2.", (Object)"PlayViewExceptionController", (Object)playViewExceptionController$RequestData);
        this.requestHandler.discard(playViewExceptionController$RequestData.getClientID());
        if (this.requestHandler.isRequestRunning(requestParameterList)) {
            this.log.log(1078071040, "[%1] Retrying current request.", (Object)"PlayViewExceptionController", (Object)playViewExceptionController$RequestData);
        }
        this.requestHandler.request(requestParameterList);
        return true;
    }

    private PlayViewExceptionController$RequestData getValidRequestData() {
        for (int i2 = 0; i2 < this.requests.size(); ++i2) {
            PlayViewExceptionController$RequestData playViewExceptionController$RequestData = (PlayViewExceptionController$RequestData)this.requests.get(i2);
            if (!playViewExceptionController$RequestData.isValid()) continue;
            return playViewExceptionController$RequestData;
        }
        return null;
    }

    public void setRequestHandler(IRequestHandler iRequestHandler) {
        this.requestHandler = iRequestHandler;
    }
}

