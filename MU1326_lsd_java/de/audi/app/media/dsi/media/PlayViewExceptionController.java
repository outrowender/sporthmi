/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IRequestHandler;
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
        RequestData requestData = new RequestData(l, n, n2, n3);
        if (this.requests.contains(requestData)) {
            this.requests.remove(requestData);
        }
        this.requests.add(requestData);
    }

    public synchronized void invalidate() {
        for (int i2 = 0; i2 < this.requests.size(); ++i2) {
            RequestData requestData = (RequestData)this.requests.get(i2);
            requestData.invalidate();
        }
    }

    public synchronized void responseReceived(int n) {
        for (int i2 = 0; i2 < this.requests.size(); ++i2) {
            if (((RequestData)this.requests.get(i2)).getClientID() != n) continue;
            this.requests.remove(i2);
        }
    }

    public synchronized boolean asyncException(int n, String string, int n2) {
        boolean bl;
        if (n2 != 1013) {
            this.log.log(1000000, "[%1] Ignoring asyncException. Not on playview request.", (Object)"PlayViewExceptionController");
            return false;
        }
        if (this.requestHandler == null) {
            this.log.log(100000, "[%1] No request handler defined. Ignoring asyncException.", (Object)"PlayViewExceptionController");
            return false;
        }
        if (this.requests.isEmpty()) {
            this.log.log(1000000, "[%1] No pending requests. Ignoring asyncException.", (Object)"PlayViewExceptionController");
            return true;
        }
        boolean bl2 = n == 8304 || string != null && string.toLowerCase().indexOf("timeout") != -1;
        boolean bl3 = bl = n == 8303 || n == 0 && string != null && string.toLowerCase().indexOf("not allowed to request") != -1;
        if (!bl2 && !bl) {
            RequestData requestData = this.getValidRequestData();
            if (requestData != null) {
                this.log.log(1000000, "[%1] Active request %2. Removing request.", (Object)"PlayViewExceptionController", (Object)requestData);
                this.requests.remove(requestData);
            }
            return false;
        }
        RequestData requestData = (RequestData)this.requests.get(0);
        if (!requestData.isValid()) {
            this.log.log(1000000, "[%1] Unresponded, invalid request %2. Ignoring asyncException. Removing request.", (Object)"PlayViewExceptionController", (Object)requestData);
            this.requests.remove(0);
            return true;
        }
        if (!requestData.retry()) {
            this.log.log(100000, "[%1] Max retries reached for request. %2", (Object)"PlayViewExceptionController", (Object)requestData);
            this.requests.remove(requestData);
            return false;
        }
        RequestParameterList requestParameterList = new RequestParameterList(requestData.getEntryID(), 0, requestData.getIndex(), requestData.getCount(), requestData.getClientID(), true);
        this.log.log(1000000, "[%1] Retry for request %2.", (Object)"PlayViewExceptionController", (Object)requestData);
        this.requestHandler.discard(requestData.getClientID());
        if (this.requestHandler.isRequestRunning(requestParameterList)) {
            this.log.log(1000000, "[%1] Retrying current request.", (Object)"PlayViewExceptionController", (Object)requestData);
        }
        this.requestHandler.request(requestParameterList);
        return true;
    }

    private RequestData getValidRequestData() {
        for (int i2 = 0; i2 < this.requests.size(); ++i2) {
            RequestData requestData = (RequestData)this.requests.get(i2);
            if (!requestData.isValid()) continue;
            return requestData;
        }
        return null;
    }

    public void setRequestHandler(IRequestHandler iRequestHandler) {
        this.requestHandler = iRequestHandler;
    }

    static class RequestData {
        private static final int MAX_RETRY = 3;
        private long entryID;
        private int index;
        private int count;
        private int clientID;
        private boolean valid;
        private int retries;

        RequestData(long l, int n, int n2, int n3) {
            this.entryID = l;
            this.index = n;
            this.count = n2;
            this.clientID = n3;
            this.valid = true;
        }

        long getEntryID() {
            return this.entryID;
        }

        int getIndex() {
            return this.index;
        }

        int getCount() {
            return this.count;
        }

        int getClientID() {
            return this.clientID;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.clientID;
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            RequestData requestData = (RequestData)object;
            return this.clientID == requestData.clientID;
        }

        boolean isValid() {
            return this.valid;
        }

        void invalidate() {
            this.valid = false;
        }

        public int getRetries() {
            return this.retries;
        }

        public boolean retry() {
            return ++this.retries <= 3;
        }

        public String toString() {
            return "entry ID: " + this.entryID + ", index: " + this.index + ", count: " + this.count + ", client ID: " + this.clientID + ", valid: " + this.valid + ", retries: " + this.retries;
        }
    }
}

