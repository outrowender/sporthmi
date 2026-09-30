/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storagecache;

import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.tghu.storagecache.CacheWorker;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

public class OnlineServiceCacheWorker
extends CacheWorker
implements IOnlineServiceListener,
MsgListener {
    private OnlineServiceListState serviceListState = new OnlineServiceListState(-1, -1);
    private IOnlineService iOnlineService;
    private Map token2License = Collections.synchronizedMap(new HashMap());

    public OnlineServiceCacheWorker(LogChannel logChannel, IStorageAccess iStorageAccess, int n, int n2, int n3, String string) {
        super(logChannel, iStorageAccess, n, n2, n3, string);
        logChannel.log(100000000, "OnlineServiceCacheWorker for %1 created.", (Object)string);
    }

    protected void registerWorkerAsServiceListener(Object object) {
        this.iOnlineService = (IOnlineService)object;
        this.iOnlineService.addCallBackListener(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        Object[] objectArray;
        Object object;
        if (dataOutputStream == null || this.token2License == null) {
            this.log.log(100000, "OnlineServiceCacheWorker#serialize: dos=%1 or token2License=%2 is null!", (Object)dataOutputStream, (Object)this.token2License);
            return;
        }
        Map map = this.token2License;
        synchronized (map) {
            object = this.token2License.keySet();
            objectArray = new String[object.size()];
            objectArray = (String[])object.toArray(objectArray);
        }
        if (objectArray != null) {
            dataOutputStream.writeInt(objectArray.length);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                object = objectArray[i2];
                if (object == null) {
                    this.log.log(100000, "OnlineServiceCacheWorker#serialize: token is null!");
                    continue;
                }
                Integer n = (Integer)this.getState((String)object);
                dataOutputStream.writeInt(n);
                dataOutputStream.writeUTF((String)object);
            }
        }
    }

    public void deserialize(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = dataInputStream.readInt();
            String string = dataInputStream.readUTF();
            if (n2 == -1) continue;
            this.token2License.put(string, new Integer(n2));
        }
    }

    public void deserializeV1(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        String string = dataInputStream.readUTF();
        if (n != -1) {
            this.token2License.put(string, new Integer(n));
        }
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
    }

    public void activateLicenseResponse(int n) {
    }

    public synchronized void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
    }

    public void getReminderStatusResult(int n) {
    }

    public void setReminderStateResponse(int n) {
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
    }

    public Object getState(String string) {
        Integer n = (Integer)this.token2License.get(string);
        return n != null ? n : new Integer(-1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
        this.log.log(1000000, "OnlineServiceCacheWorker#updateServiceState called serviceList %1", (Object)onlineServiceListState);
        if (!this.serviceListState.equalsIgnorePending(onlineServiceListState)) {
            if (onlineServiceListState.isOnline() || onlineServiceListState.isOffline()) {
                Object[] objectArray;
                Object object;
                this.log.log(1000000, "OnlineServiceCacheWorker#updateServiceState changed. Refreshing %1", (Object)this.serviceID);
                Map map = this.token2License;
                synchronized (map) {
                    this.log.log(1000000, "OnlineServiceCacheWorker#updateServiceState synchronized getting tokens for %1", (Object)this.serviceID);
                    object = this.token2License.keySet();
                    objectArray = new String[object.size()];
                    objectArray = (String[])object.toArray(objectArray);
                }
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    object = objectArray[i2];
                    this.iOnlineService.getOnlineApplicationPreCheck(this, (String)object);
                    this.log.log(1000000, "OnlineServiceCacheWorker.updateServiceState() SL is available, requesting new license state for %1:%2. SL[%3]", (Object)this.serviceID, object, (Object)onlineServiceListState);
                }
            }
            this.serviceListState = onlineServiceListState;
        }
    }

    public synchronized void getPreCheckResult(OSRServiceState oSRServiceState) {
        int n = 29;
        OSRLicense oSRLicense = null;
        if (oSRServiceState == null) {
            this.log.log(10000, "OnlineServiceCacheWorker#getPreCheckResult state is null! Response will not be handled!");
            return;
        }
        String string = oSRServiceState.getSymbolicName();
        if (string == null) {
            this.log.log(10000, "OnlineServiceCacheWorker#getPreCheckResult state.getSymbolicName is null! Response will not be handled!");
            return;
        }
        n = oSRServiceState.getErrorCode();
        if (oSRServiceState.getServiceListEntry() != null) {
            oSRLicense = oSRServiceState.getServiceListEntry().getLicense();
        } else if (n != 18) {
            this.log.log(100000, "OnlineServiceCacheWorker#getPreCheckResult no license received, errorCode: %1", (long)n);
        }
        this.log.log(1000000, "OnlineServiceCacheWorker#getPreCheckResult service: %2/%3, errorCode: %4, license: %1", (Object)oSRLicense, (Object)this.serviceID, (Object)string, (long)n);
        this.log.log(1000000, "OnlineServiceCacheWorker#getPreCheckResult serviceListEntry: %1, errorCode: %2, serviceId=%3, symbolicName=%4", (Object)oSRServiceState.getServiceListEntry(), (Object)Integer.toString(n), (Object)this.serviceID, (Object)string);
        if (!this.isLicenseCheckRequired(n)) {
            this.forwardPreCheckResult(string, 1);
        } else if (this.isServiceUsable(n)) {
            if (oSRLicense == null) {
                this.log.log(1000000, "OnlineServiceCacheWorker#getPreCheckResult token %1 is handled as license free because of null license.", (Object)string);
                this.forwardPreCheckResult(string, 1);
            } else {
                this.forwardPreCheckResult(string, oSRLicense.getState());
            }
        } else {
            this.forwardPreCheckResult(string, 3);
        }
    }

    private boolean isLicenseCheckRequired(int n) {
        return n != 0;
    }

    private boolean isServiceUsable(int n) {
        return n == 3 || n == 24 || n == 6;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void forwardPreCheckResult(String string, int n) {
        List list;
        Integer n2 = new Integer(n);
        this.token2License.put(string, n2);
        this.serializeAndWrite();
        this.log.log(1000000, "OnlineServiceCacheWorker.getPreCheckResult() called. New license state for <%1:%2> is %3", (Object)this.serviceID, (Object)string, (long)n);
        Object object = this.token2Subscriber;
        synchronized (object) {
            list = (List)this.token2Subscriber.get(string);
            if (list == null) {
                this.log.log(1000000, "OnlineServiceCacheWorker.forwardPreCheckResult: No subscriber for serviceID:token %1:%2 are registered", (Object)this.serviceID, (Object)string);
                return;
            }
            list = new ArrayList(list);
        }
        object = list.iterator();
        while (object.hasNext()) {
            try {
                ((CacheEventListener)object.next()).updateToken(this.serviceID, string, n2);
            }
            catch (Exception exception) {
                this.log.log(10000, "OnlineServiceCacheWorker.updateToken() callback error: %1", (Throwable)exception);
            }
        }
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
        super.convertContainer(n, n2, dataInputStream);
        if (n == 1 && n2 == this.getContainerVersion()) {
            try {
                this.deserializeV1(dataInputStream);
            }
            catch (IOException iOException) {
                this.log.log(10000, "IOException bei convertContainer: %1", (Throwable)iOException);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerCacheEventListener(CacheEventListener cacheEventListener) {
        String[] stringArray = null;
        try {
            stringArray = cacheEventListener.getTokens(this.serviceID);
        }
        catch (Exception exception) {
            this.log.log(10000, "OnlineServiceCacheWorker: CacheEventListener.getTokens() callback error", (Throwable)exception);
        }
        if (stringArray != null) {
            Map map = this.token2License;
            synchronized (map) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    Integer n = (Integer)this.token2License.get(stringArray[i2]);
                    if (n != null) continue;
                    n = new Integer(-1);
                    this.token2License.put(stringArray[i2], n);
                }
            }
        }
        if (this.iOnlineService != null) {
            this.iOnlineService.removeCallBackListener(this);
            this.iOnlineService.addCallBackListener(this);
        }
    }

    public void processMsg(int n) {
        this.log.log(10000000, "OnlineServiceCacheWorker#processMsg(): serviceId = %1, message: %2", (Object)this.serviceID, (long)n);
        if (n != 88 && n != 23) {
            this.log.log(10000000, "OnlineServiceCacheWorker#processMsg(): wrong message type. Do nothing.");
            return;
        }
        this.log.log(1000000, "OnlineServiceCacheWorker#processMsg(): Received message %1. Resetting persited license states.", (long)n);
        this.log.log(10000000, "OnlineServiceCacheWorker#processMsg(): handle factory reset.");
        Iterator iterator = this.token2License.keySet().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof String)) continue;
            this.log.log(1000000, "OnlineServiceCacheWorker#processMsg(): Reset persited license for %1", object);
            this.forwardPreCheckResult((String)object, -1);
        }
    }
}

