/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallHistoryStorage;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallHistoryStorageDataContainer$1;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallInformation;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallPoiStorageDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallHistoryStorageDataContainer
extends AbstractStorageDataContainer {
    static final int[] PERSISTENCE_KEY_MAP = new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    public static final int DEFAULT_MAX_NUMBER_OF_CALLS;
    private static final int CALL_VERSION;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    ArrayList historyCalls = new ArrayList();
    private OperatorCallPoiStorageDataContainer[] poiStorageDataContainers;
    private int nextFreeUniqueId = 0;

    public OperatorCallHistoryStorageDataContainer(IStorageAccess iStorageAccess) {
        super(iStorageAccess, 1, 1023, 19);
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#constructor called");
        this.initializePoiStorageDataContainer();
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#constructor calling readAndDeserialize ...");
        this.readAndDeserialize();
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#constructor readAndDeserialize finished");
    }

    private void initializePoiStorageDataContainer() {
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#initializePoiStorageDataContainer called");
        this.poiStorageDataContainers = new OperatorCallPoiStorageDataContainer[10];
        IStorageAccess iStorageAccess = this.getStorageAccess();
        for (int i2 = 0; i2 < this.poiStorageDataContainers.length; ++i2) {
            this.poiStorageDataContainers[i2] = new OperatorCallPoiStorageDataContainer(iStorageAccess, this.getPersistenceKey(i2));
        }
    }

    private int getNextFreePoiStorageDataContainerIndex() {
        int n = this.poiStorageDataContainers.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (this.poiStorageDataContainers[i2].isUsed()) continue;
            return i2;
        }
        OperatorCallHistoryStorage operatorCallHistoryStorage = (OperatorCallHistoryStorage)this.historyCalls.get(0);
        return operatorCallHistoryStorage.getPoiStorageIndex();
    }

    private OperatorCallPoiStorageDataContainer getPoiStorageDataContainer(int n) {
        return this.poiStorageDataContainers[n];
    }

    private int getPersistenceKey(int n) {
        return PERSISTENCE_KEY_MAP[n];
    }

    @Override
    protected void handleCRC32Error() {
        this.logChannel.log(10000, "OperatorCallHistoryStorageDataContainer#handleCRC32Error!");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.logChannel.log(-1601830656, "OperatorCallHistoryStorageDataContainer#handleStorageReadError -> ok, if operator calls were never persisted before ", (Throwable)exception);
        } else {
            this.logChannel.log(10000, "OperatorCallHistoryStorageDataContainer#handleStorageReadError", (Throwable)exception);
        }
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#convertContainer!");
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n;
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#deserialize called");
        int n2 = dataInputStream.readInt();
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#deserialize: number of calls = %1", (long)n2);
        this.historyCalls = new ArrayList();
        for (n = 0; n < n2; ++n) {
            OperatorCallHistoryStorage operatorCallHistoryStorage = this.deserializeHistoryCall(dataInputStream, n);
            if (operatorCallHistoryStorage == null) continue;
            this.historyCalls.add(operatorCallHistoryStorage);
            OperatorCallPoiStorageDataContainer operatorCallPoiStorageDataContainer = this.getPoiStorageDataContainer(operatorCallHistoryStorage.getPoiStorageIndex());
            operatorCallPoiStorageDataContainer.readAndDeserialize();
        }
        this.setNextFreeUniqueId(n);
    }

    private OperatorCallHistoryStorage deserializeHistoryCall(DataInputStream dataInputStream, int n) {
        this.logChannel.log(14808325, "OperatorCallHistoryStorageDataContainer#deserializeHistoryCall called");
        boolean bl = true;
        String string = this.getNullForEmptyString(dataInputStream.readUTF());
        if (string == null || string.length() < 1) {
            this.logChannel.log(-1601830656, "OperatorCallHistoryStorageDataContainer#deserializeHistoryCall: poi name is null or empty! Persistence must be corrupt. Ignoring this call.");
            bl = false;
        }
        long l = dataInputStream.readLong();
        int n2 = dataInputStream.readInt();
        if (n2 < 0 || n2 > this.poiStorageDataContainers.length - 1) {
            this.logChannel.log(-1601830656, "OperatorCallHistoryStorageDataContainer#deserializeHistoryCall: poiStorageIndex is invalid(%1)! Persistence must be corrupt. Ignoring this call.", (long)n2);
            bl = false;
        }
        if (bl) {
            this.setPoiStorageIsUsed(n2, true);
            OperatorCallHistoryStorage operatorCallHistoryStorage = new OperatorCallHistoryStorage(n, string, l, n2, false);
            this.logChannel.log(14808325, "OperatorCallHistoryStorageDataContainer#deserializeHistoryCall: name = %1, poiStorageIndex = %3", (Object)string, (long)n2);
            return operatorCallHistoryStorage;
        }
        return null;
    }

    public String getNullForEmptyString(String string) {
        if ("".equalsIgnoreCase(string)) {
            return null;
        }
        return string;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#serialize called");
        int n = this.historyCalls.size();
        dataOutputStream.writeInt(n);
        for (int i2 = 0; i2 < n; ++i2) {
            OperatorCallHistoryStorage operatorCallHistoryStorage = (OperatorCallHistoryStorage)this.historyCalls.get(i2);
            operatorCallHistoryStorage.serialize(dataOutputStream);
            if (operatorCallHistoryStorage.writePoisToPersistence()) {
                OperatorCallPoiStorageDataContainer operatorCallPoiStorageDataContainer = this.getPoiStorageDataContainer(operatorCallHistoryStorage.getPoiStorageIndex());
                operatorCallPoiStorageDataContainer.serializeAndWrite();
            }
            operatorCallHistoryStorage.setWriteFlag(false);
        }
    }

    private void setPoiStorageIsUsed(int n, boolean bl) {
        this.poiStorageDataContainers[n].setUsed(bl);
    }

    public int addCall(AbstractHistoryCallData abstractHistoryCallData) {
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#addCall");
        int n = this.getNextFreePoiStorageDataContainerIndex();
        if (this.historyCalls.size() == 10) {
            this.historyCalls.remove(0);
        }
        String string = abstractHistoryCallData.getName();
        long l = abstractHistoryCallData.getDateTime().getTime();
        int n2 = this.getNextFreeUniqueId();
        OperatorCallHistoryStorage operatorCallHistoryStorage = new OperatorCallHistoryStorage(n2, string, l, n, true);
        this.setPoiStorageIsUsed(n, true);
        OperatorCallPoiStorageDataContainer operatorCallPoiStorageDataContainer = this.getPoiStorageDataContainer(n);
        operatorCallPoiStorageDataContainer.storePois(abstractHistoryCallData.getPois());
        this.historyCalls.add(operatorCallHistoryStorage);
        this.serializeAndWrite();
        operatorCallHistoryStorage.setWriteFlag(false);
        this.increaseNextFreeUniqueId();
        return n2;
    }

    private int getNextFreeUniqueId() {
        return this.nextFreeUniqueId;
    }

    private void increaseNextFreeUniqueId() {
        ++this.nextFreeUniqueId;
    }

    private void setNextFreeUniqueId(int n) {
        this.nextFreeUniqueId = n;
    }

    public void removeCall(int n) {
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#removeCall removing the history call with uniqueId %1!", (long)n);
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#removeCall uniqueId = %1!", (long)n);
        int n2 = this.nextFreeUniqueId - 1;
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#removeCall maxNumberOfOccupiedIds = %1!", (long)n2);
        int n3 = Collections.binarySearch(this.historyCalls, new Integer(n), new OperatorCallHistoryStorageDataContainer$1(this));
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#removeCall index = %1!", (long)n3);
        if (n3 < 0 || n3 > this.historyCalls.size() - 1) {
            this.logChannel.log(-1601830656, "OperatorCallHistoryStorageDataContainer#removeCall: uniqueId %1 doesn't exist any more. -> Nothing to remove in persistence", (long)n);
            return;
        }
        this.setPoiStorageDCToUnused(n3);
        this.historyCalls.remove(n3);
        this.serializeAndWrite();
    }

    protected void setPoiStorageDCToUnused(int n) {
        OperatorCallHistoryStorage operatorCallHistoryStorage = (OperatorCallHistoryStorage)this.historyCalls.get(n);
        int n2 = operatorCallHistoryStorage.getPoiStorageIndex();
        this.setPoiStorageIsUsed(n2, false);
    }

    public void removeAllCalls() {
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#removeAllCalls called!");
        int n = this.historyCalls.size();
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#removeAllCalls: number of calls: %1", (long)n);
        for (int i2 = n - 1; i2 >= 0; --i2) {
            this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#removeAllCalls removing the %1. history call!", (long)(i2 + 1));
            this.setPoiStorageDCToUnused(i2);
            this.historyCalls.remove(i2);
        }
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#removeAllCalls: all calls removed!");
        this.serializeAndWrite();
        this.setNextFreeUniqueId(0);
    }

    public OperatorCallInformation[] getAllInformation() {
        int n;
        this.logChannel.log(1078071040, "OperatorCallHistoryStorageDataContainer#getAllInformation called!");
        if (TestHandler.isPersistenceSimulation()) {
            OperatorCallInformation[] operatorCallInformationArray = new OperatorCallInformation[]{new OperatorCallInformation(0, "blub", new Date(0), TestHandler.getPOIsFromPersistence(2)), new OperatorCallInformation(1, "blub2", new Date(0), TestHandler.getPOIsFromPersistence(2)), new OperatorCallInformation(2, "blub3", new Date(0), TestHandler.getPOIsFromPersistence(2))};
            return operatorCallInformationArray;
        }
        this.logChannel.log(-2137614336, "OperatorCallHistoryStorageDataContainer#getAllInformation: %1 historycalls were read from persistence", (long)this.historyCalls.size());
        int n2 = n = this.historyCalls.size();
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            OperatorCallHistoryStorage operatorCallHistoryStorage = (OperatorCallHistoryStorage)this.historyCalls.get(i2);
            int n3 = operatorCallHistoryStorage.getUniqueId();
            String string = operatorCallHistoryStorage.getName();
            Date date = operatorCallHistoryStorage.getDate();
            OperatorCallPoiStorageDataContainer operatorCallPoiStorageDataContainer = this.getPoiStorageDataContainer(operatorCallHistoryStorage.getPoiStorageIndex());
            OperatorCallResult[] operatorCallResultArray = operatorCallPoiStorageDataContainer.getOperatorCallResults();
            if (operatorCallResultArray == null || operatorCallResultArray.length < 1) {
                --n2;
                this.logChannel.log(-1601830656, "OperatorCallHistoryStorageDataContainer#getAllInformation: no POIs for this call. Ignoring call %1.", (Object)string);
                continue;
            }
            OperatorCallInformation operatorCallInformation = new OperatorCallInformation(n3, string, date, operatorCallResultArray);
            arrayList.add(operatorCallInformation);
            this.logChannel.log(14808325, "OperatorCallHistoryStorageDataContainer#getAllInformation: i=%1 \n %2", (Object)new Integer(i2), (Object)operatorCallInformation);
        }
        return (OperatorCallInformation[])arrayList.toArray(new OperatorCallInformation[n2]);
    }
}

