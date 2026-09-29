/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swap;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.swap.SWaPEventListener;
import de.audi.atip.swap.SWaPHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.DSISWaP;
import org.dsi.ifc.swap.DSISWaPListener;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public class SWaPHandlerImpl
extends AbstractStorageDataContainer
implements SWaPHandler,
DSISWaPListener {
    private static final int VERSION;
    private DSISWaP dsi;
    private LogChannel log;
    private Map id2Subscriber = Collections.synchronizedMap(new HashMap());
    private Map fscList = Collections.synchronizedMap(new HashMap());

    public SWaPHandlerImpl(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess.getStorageMgr(), 1, 256, 160);
        this.log = iFrameworkAccess.getLogChannel("Fw.SWaP.Handler");
        this.readAndDeserialize();
    }

    public void setDSI(DSISWaP dSISWaP) {
        this.log.log(1078071040, "SWaPHandlerImpl.setDSI() (%1)", (Object)dSISWaP);
        this.dsi = dSISWaP;
        dSISWaP.setNotification(new int[]{8}, (DSIListener)this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(SWaPEventListener sWaPEventListener) {
        int[] nArray;
        try {
            nArray = sWaPEventListener.getFSCs();
        }
        catch (Exception exception) {
            this.log.log(10000, "SWaPHandlerImpl.addListener() error: %1", (Object)exception.toString());
            return;
        }
        Map map = this.id2Subscriber;
        synchronized (map) {
            Map map2 = this.fscList;
            synchronized (map2) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    Integer n = new Integer(nArray[i2]);
                    List list = (List)this.id2Subscriber.get(n);
                    if (list == null) {
                        list = new ArrayList();
                        this.id2Subscriber.put(n, list);
                    }
                    list.add(sWaPEventListener);
                    SFscStatus sFscStatus = (SFscStatus)this.fscList.get(n);
                    if (sFscStatus == null) {
                        sWaPEventListener.updateFSC(nArray[i2], -1, -1);
                        continue;
                    }
                    sWaPEventListener.updateFSC(sFscStatus.getSwid(), sFscStatus.getState(), sFscStatus.getIndex());
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(SWaPEventListener sWaPEventListener) {
        int[] nArray;
        try {
            nArray = sWaPEventListener.getFSCs();
        }
        catch (Exception exception) {
            this.log.log(10000, "SWaPHandlerImpl.removeListener() error: %1", (Object)exception.toString());
            return;
        }
        Map map = this.id2Subscriber;
        synchronized (map) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                Integer n = new Integer(nArray[i2]);
                List list = (List)this.id2Subscriber.get(n);
                if (list == null) continue;
                list.remove(sWaPEventListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getFscStata(int n) {
        Map map = this.fscList;
        synchronized (map) {
            SFscStatus sFscStatus = (SFscStatus)this.fscList.get(new Integer(n));
            if (sFscStatus != null) {
                return sFscStatus.getState();
            }
            return -1;
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "SWaPHandlerImpl.asyncException() %1 %2", (Object)string, (long)n);
    }

    @Override
    public void updateSoftwareEnabling(int[] nArray, int n) {
    }

    @Override
    public void updateIllegalFSCs(int[] nArray, int n) {
    }

    @Override
    public void updateAreFSCsSigned(boolean bl, int n) {
    }

    @Override
    public void updateLimitedLifetime(boolean bl, int n) {
    }

    @Override
    public void updateConfigCheck(ConfigInfo configInfo, int n) {
    }

    @Override
    public void updateConfigPrepare(String string, int n) {
    }

    @Override
    public void updateConfigFinalize(ConfigInfo configInfo, int n) {
    }

    private void storeNewFsc(SFscStatus sFscStatus) {
        Integer n = new Integer(sFscStatus.getSwid());
        SFscStatus sFscStatus2 = (SFscStatus)this.fscList.get(n);
        if (sFscStatus2 != null) {
            switch (sFscStatus2.getState()) {
                case 0: {
                    if (sFscStatus.getState() == 4) break;
                    return;
                }
                case 2: {
                    if (sFscStatus.getState() == 4 || sFscStatus.getState() != 0) break;
                    return;
                }
                case 4: {
                    break;
                }
            }
        }
        this.fscList.put(n, sFscStatus);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateFscList(SFscStatus[] sFscStatusArray, int n) {
        if (n != 1 || sFscStatusArray == null) {
            this.log.log(-1601830656, "SWaPHandlerImpl.updateFSCList() : fsc list is not valid %1", (Object)sFscStatusArray);
            return;
        }
        Buffer buffer = new Buffer();
        Map map = this.fscList;
        synchronized (map) {
            this.fscList.clear();
            for (int i2 = 0; i2 < sFscStatusArray.length; ++i2) {
                this.storeNewFsc(sFscStatusArray[i2]);
            }
            this.serializeAndWrite();
        }
        map = this.id2Subscriber;
        synchronized (map) {
            Object[] objectArray = new Integer[this.id2Subscriber.size()];
            objectArray = (Integer[])this.fscList.keySet().toArray(objectArray);
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                List list = (List)this.id2Subscriber.get(objectArray[i3]);
                if (list == null) continue;
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    SWaPEventListener sWaPEventListener = (SWaPEventListener)iterator.next();
                    SFscStatus sFscStatus = (SFscStatus)this.fscList.get(objectArray[i3]);
                    try {
                        if (sFscStatus != null) {
                            sWaPEventListener.updateFSC(sFscStatus.getSwid(), sFscStatus.getState(), sFscStatus.getIndex());
                            buffer.append(sFscStatus.toString());
                            continue;
                        }
                        sWaPEventListener.updateFSC((Integer)objectArray[i3], -1, -1);
                    }
                    catch (Exception exception) {
                        this.log.log(10000, "SWaPHandlerImpl.updateFSCList() callback error: %1", (Throwable)exception);
                    }
                }
            }
        }
        this.log.log(1078071040, "SWaPHandlerImpl updateFscList: %1", (Object)buffer);
    }

    @Override
    public void encryptFile(String string, int n) {
    }

    @Override
    public void checkSignature(boolean bl, String string) {
    }

    @Override
    public void getPublicKey(short[] sArray, boolean bl) {
    }

    @Override
    public void checkSingleFsc(int n, int n2) {
    }

    @Override
    public void decryptFile(String string, int n) {
    }

    @Override
    public void getFscDetail(SFscDetails sFscDetails) {
    }

    @Override
    public void importFSCs(int n, SFscImportStatus sFscImportStatus) {
    }

    @Override
    public void importFSCsList(int n, SFscImportStatus[] sFscImportStatusArray) {
        this.log.log(1078071040, "SWaPHandlerImpl.importFSCsList(): resultCode(%1)", (long)n);
    }

    @Override
    public void exportCCD(int n) {
    }

    @Override
    public void getHistory(SFscHistory sFscHistory) {
    }

    @Override
    public void getHistoryList(SFscHistory[] sFscHistoryArray) {
    }

    @Override
    protected void handleCRC32Error() {
        this.log.log(-1601830656, "SWaPHandlerImpl.handleCRC32Error()");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        this.log.log(-1601830656, "SWaPHandlerImpl.handleStorageReadError(): %1", (Object)exception.toString());
        this.fscList.clear();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.log.log(1078071040, "SWaPHandlerImpl.serialize()");
        Set set = this.fscList.keySet();
        dataOutputStream.writeInt(set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            SFscStatus sFscStatus = (SFscStatus)this.fscList.get(iterator.next());
            dataOutputStream.writeInt(sFscStatus.getSwid());
            dataOutputStream.writeInt(sFscStatus.getState());
            dataOutputStream.writeInt(sFscStatus.getIndex());
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.log.log(1078071040, "SWaPHandlerImpl.deserialize()");
        int n = dataInputStream.readInt();
        this.fscList.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            SFscStatus sFscStatus = new SFscStatus(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt());
            this.fscList.put(new Integer(sFscStatus.getSwid()), sFscStatus);
        }
    }
}

