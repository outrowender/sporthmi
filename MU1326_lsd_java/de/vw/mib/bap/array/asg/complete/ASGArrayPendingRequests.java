/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.complete.ASGArrayListData;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;
import java.util.Iterator;
import java.util.LinkedHashMap;

class ASGArrayPendingRequests {
    public static final int PENDING_REQUEST_TYPE_INVALID = -1;
    public static final int PENDING_REQUEST_TYPE_RELOAD = 0;
    public static final int PENDING_REQUEST_TYPE_LOADING = 1;
    public static final int PENDING_REQUEST_TYPE_DELETE_REQUEST = 2;
    public static final int PENDING_REQUEST_TYPE_MODIFY_REQUEST = 3;
    public static final int PENDING_REQUEST_TYPE_INSERT_REQUEST = 4;
    public static final int PENDIG_REQUEST_TYPE_INSERT_ONE_ELEMENT_INDICATION = 5;
    public static final int PENDING_REQUEST_TYPE_INSERT_INDICATION = 6;
    public static final int PENDING_REQUEST_TYPE_MODIFY_INDICATION = 7;
    private LinkedHashMap _pendigRequests;
    private static final int INITIAL_NUMBER_OF_REQUESTS = 8;

    ASGArrayPendingRequests() {
    }

    public void insertPendingRequest(BAPGetArray bAPGetArray, int n, ASGArrayListData aSGArrayListData) {
        Integer n2 = new Integer(bAPGetArray.getTransactionId());
        PendingRequestEntry pendingRequestEntry = (PendingRequestEntry)this.getPendingRequests().get(n2);
        if (pendingRequestEntry != null) {
            pendingRequestEntry.setBapGetArray(bAPGetArray);
            pendingRequestEntry.setPendigRequestType(n);
            pendingRequestEntry.setPendingElements(aSGArrayListData);
        } else {
            this.getPendingRequests().put(n2, new PendingRequestEntry(bAPGetArray, n, aSGArrayListData));
        }
    }

    public void setPendigRequestTimer(int n, Timer timer) {
        PendingRequestEntry pendingRequestEntry = (PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        if (pendingRequestEntry != null) {
            pendingRequestEntry.setTimer(timer);
        }
    }

    public int getPendingRequestType(int n) {
        PendingRequestEntry pendingRequestEntry = (PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return pendingRequestEntry != null ? pendingRequestEntry.getPendingRequestType() : -1;
    }

    public ASGArrayListData getPendingRequestElements(int n) {
        PendingRequestEntry pendingRequestEntry = (PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return pendingRequestEntry != null ? pendingRequestEntry.getPendingElements() : null;
    }

    public BAPGetArray getPendingRequest(int n) {
        PendingRequestEntry pendingRequestEntry = (PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return pendingRequestEntry != null ? pendingRequestEntry.getBapGetArray() : null;
    }

    public Timer getPendingRequestTimer(int n) {
        PendingRequestEntry pendingRequestEntry = (PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return pendingRequestEntry != null ? pendingRequestEntry.getTimer() : null;
    }

    public boolean enumerate(PendigRequestEnumerator pendigRequestEnumerator) {
        PendingRequestEntry pendingRequestEntry;
        boolean bl = false;
        Iterator iterator = this.getPendingRequests().values().iterator();
        while (iterator.hasNext() && !(bl = pendigRequestEnumerator.enumerate((pendingRequestEntry = (PendingRequestEntry)iterator.next()).getBapGetArray(), pendingRequestEntry.getPendingRequestType(), pendingRequestEntry.getTimer()))) {
        }
        return bl;
    }

    public void deletePendingRequest(int n) {
        this.getPendingRequests().remove(new Integer(n));
    }

    public void clearAll() {
        this.getPendingRequests().clear();
    }

    public boolean existsPendingRequest(int n) {
        return this.getPendingRequests().containsKey(new Integer(n));
    }

    public int size() {
        return this.getPendingRequests().size();
    }

    private LinkedHashMap getPendingRequests() {
        if (this._pendigRequests == null) {
            this._pendigRequests = new LinkedHashMap(8);
        }
        return this._pendigRequests;
    }

    private static final class PendingRequestEntry {
        private BAPGetArray _request;
        private ASGArrayListData _pendingElements;
        private int _pendingRequestType;
        private Timer _timer;

        protected PendingRequestEntry(BAPGetArray bAPGetArray, int n, ASGArrayListData aSGArrayListData) {
            this._request = bAPGetArray;
            this._pendingRequestType = n;
            this._pendingElements = aSGArrayListData;
        }

        public BAPGetArray getBapGetArray() {
            return this._request;
        }

        public void setBapGetArray(BAPGetArray bAPGetArray) {
            this._request = bAPGetArray;
        }

        public void setPendingElements(ASGArrayListData aSGArrayListData) {
            this._pendingElements = aSGArrayListData;
        }

        public ASGArrayListData getPendingElements() {
            return this._pendingElements;
        }

        public int getPendingRequestType() {
            return this._pendingRequestType;
        }

        public void setPendigRequestType(int n) {
            this._pendingRequestType = n;
        }

        public void setTimer(Timer timer) {
            this._timer = timer;
        }

        public Timer getTimer() {
            return this._timer;
        }
    }

    public static interface PendigRequestEnumerator {
        public boolean enumerate(BAPGetArray var1, int var2, Timer var3);
    }
}

