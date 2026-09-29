/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.DeserializationResult;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.fw.indication.BAPIndicationData;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IErrorIndicationListener;
import de.audi.app.bap.fw.request.IBAPRequestHandler;
import de.audi.app.bap.utils.BAPDeserializer;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.IndicationTypes;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.RequestTypes;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.BAPEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBAPFunction
implements IBAPFunction {
    public static final int BAP_FUNCTIONTYPE_METHOD;
    public static final int BAP_FUNCTIONTYPE_PROPERTY;
    public static final int BAP_FUNCTIONTYPE_ARRAY;
    public static final int BAP_FUNCTIONTYPE_CACHE;
    protected final LogChannel logChannel;
    private final LogChannel logChannelBAPData;
    protected final IBAPRequestHandler requestHandler;
    protected final int lsgID;
    protected final int fctID;
    protected final String lsgIDDesc;
    protected final String fctIDDesc;
    private volatile boolean dataValid = false;
    private final List dataListeners = new ArrayList(1);
    private final List acknowledgeListeners = new ArrayList(1);
    private final List errorIndicationListeners = new ArrayList(1);

    protected AbstractBAPFunction(AbstractBAPModule abstractBAPModule, int n) {
        this.lsgID = abstractBAPModule.getLSGID();
        this.fctID = n;
        this.lsgIDDesc = LSGIDs.getDescription(this.lsgID);
        this.fctIDDesc = FunctionIDs.getDescription(this.lsgID, n);
        this.requestHandler = abstractBAPModule.getRequestHandler();
        this.logChannel = abstractBAPModule.getLogger().getLog(this.lsgID);
        this.logChannelBAPData = abstractBAPModule.getLogger().getLogBAPData(this.lsgID);
    }

    @Override
    public int getFctID() {
        return this.fctID;
    }

    @Override
    public String getFctIDDescription() {
        return this.fctIDDesc;
    }

    @Override
    public String getLSGIDDescription() {
        return this.lsgIDDesc;
    }

    public boolean isDataValid() {
        return this.dataValid;
    }

    protected void setDataValid(boolean bl) {
        if (this.dataValid != bl) {
            this.dataValid = bl;
            this.notifyListenersDataValidChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processAcknowledge(int n) {
        ArrayList arrayList;
        this.logChannel.log(14808325, "[AbstractBAPFunction#processAcknowledge]");
        Object object = this.acknowledgeListeners;
        synchronized (object) {
            if (this.acknowledgeListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.acknowledgeListeners);
        }
        this.logChannel.log(14808325, "[AbstractBAPFunction#processAcknowledge] function acknowledged -> inform listeners (lsgID=%1, fctID=%2, acknowledgeType=%3)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (long)n);
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((IAcknowledgeListener)object.next()).processAcknowledge(this.fctID, n);
        }
    }

    @Override
    public void processIndication(int n, BAPIndicationData bAPIndicationData) {
        if (this.isIndicationTypeSupported(n)) {
            DeserializationResult deserializationResult = this.deserializeData(n, bAPIndicationData);
            switch (deserializationResult.getResult()) {
                case 0: 
                case 4: {
                    this.doProcessIndication(n, deserializationResult.getData());
                    break;
                }
                case 1: {
                    this.requestHandler.requestError(this.lsgID, this.fctID, 0);
                    break;
                }
                case 2: {
                    this.requestHandler.requestError(this.lsgID, this.fctID, 5);
                    break;
                }
                case 3: {
                    this.requestHandler.requestError(this.lsgID, this.fctID, 4);
                    break;
                }
                default: {
                    this.logChannel.log(10000, "[AbstractBAPFunction#processIndication] unhandled case: %1", (long)deserializationResult.getResult());
                    break;
                }
            }
        } else {
            this.logChannel.log(10000, "[AbstractBAPFunction#processIndication] indicationType not supported by FSG: %1 (lsgID=%2, fctID=%3)", (Object)IndicationTypes.getDescription(n), (long)this.lsgID, (long)this.fctID);
            this.requestHandler.requestError(this.lsgID, this.fctID, 7);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processIndicationError(int n) {
        ArrayList arrayList;
        this.doProcessError(n);
        Object object = this.errorIndicationListeners;
        synchronized (object) {
            if (this.errorIndicationListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.errorIndicationListeners);
        }
        if (arrayList.isEmpty()) {
            this.logChannel.log(-2137614336, "[AbstractBAPFunction#processIndicationError] indication error ignored (lsgID=%1, fctID=%2, errorCode=%3)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (Object)ErrorCodes.getDescription(this.lsgID, n));
        } else {
            this.logChannel.log(-2137614336, "[AbstractBAPFunction#processIndicationError] indication error received -> inform listeners (lsgID=%1, fctID=%2, errorCode=%3)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (long)n);
            object = arrayList.iterator();
            while (object.hasNext()) {
                ((IErrorIndicationListener)object.next()).processIndicationError(this.fctID, n);
            }
        }
    }

    protected abstract boolean isIndicationTypeSupported(int n) {
    }

    protected abstract void doProcessIndication(int n, BAPEntity bAPEntity) {
    }

    protected abstract void doProcessError(int n) {
    }

    private DeserializationResult deserializeData(int n, BAPIndicationData bAPIndicationData) {
        int n2;
        if (n == 10) {
            return new DeserializationResult(4, null);
        }
        BAPEntity bAPEntity = this.getIndicationSerializer(n);
        if (bAPIndicationData == null) {
            if (bAPEntity == null) {
                n2 = 4;
            } else {
                this.logChannel.log(10000, "AbstractBAPFunction#deserializeData] void indication not supported by function: lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
                n2 = 3;
            }
        } else if (bAPEntity != null) {
            n2 = BAPDeserializer.deserializeData(this.logChannel, this.logChannelBAPData, this.lsgID, this.fctID, bAPEntity, bAPIndicationData);
        } else {
            this.logChannel.log(10000, "AbstractBAPFunction#deserializeData] parameterized indication not supported by function: lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            n2 = 3;
        }
        return new DeserializationResult(n2, bAPEntity);
    }

    protected boolean sendRequest(int n) {
        return this.sendRequest(n, null);
    }

    public boolean sendRequest(int n, BAPEntity bAPEntity) {
        if (bAPEntity != null) {
            this.logChannelBAPData.log(-2137614336, "[AbstractBAPFunction#sendRequest] lsgID=%2, fctID=%3, requestType=%4, data=%1", (Object)bAPEntity, (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (Object)RequestTypes.getDescription(n));
        } else {
            this.logChannelBAPData.log(-2137614336, "[AbstractBAPFunction#sendRequest] lsgID=%1, fctID=%2, requestType=%3", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (Object)RequestTypes.getDescription(n));
        }
        return this.requestHandler.processRequest(this.lsgID, this.fctID, n, bAPEntity);
    }

    public void functionNotSupported() {
        this.logChannel.log(10000, "[AbstractBAPFunction#functionNotSupported] (lsgID=%1, fctID=%2) Function not supported by FSG", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.reset();
        this.requestHandler.requestError(this.lsgID, this.fctID, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyListenersDataValidChanged() {
        ArrayList arrayList;
        Object object = this.dataListeners;
        synchronized (object) {
            if (this.dataListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.dataListeners);
        }
        this.logChannel.log(14808325, "[AbstractBAPFunction#notifyListenersDataValidChanged] data valid status changed -> inform listeners (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        object = arrayList.iterator();
        while (object.hasNext()) {
            BAPFunctionDataListener bAPFunctionDataListener = (BAPFunctionDataListener)object.next();
            bAPFunctionDataListener.notifyDataValidChanged(this.fctID, this.dataValid);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void notifyListenersDataChanged() {
        ArrayList arrayList;
        Object object = this.dataListeners;
        synchronized (object) {
            if (this.dataListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.dataListeners);
        }
        this.logChannel.log(14808325, "[AbstractBAPFunction#notifyListenersDataChanged] status changed -> inform listeners (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        object = arrayList.iterator();
        while (object.hasNext()) {
            BAPFunctionDataListener bAPFunctionDataListener = (BAPFunctionDataListener)object.next();
            bAPFunctionDataListener.notifyDataChanged(this.fctID);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void notifyListenersDataNotChanged() {
        ArrayList arrayList;
        Object object = this.dataListeners;
        synchronized (object) {
            if (this.dataListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.dataListeners);
        }
        this.logChannel.log(14808325, "[AbstractBAPFunction#notifyListenersDataChanged] status not changed -> inform listeners (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        object = arrayList.iterator();
        while (object.hasNext()) {
            BAPFunctionDataListener bAPFunctionDataListener = (BAPFunctionDataListener)object.next();
            bAPFunctionDataListener.notifyDataUpdatedNoChange(this.fctID);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addDataListener(BAPFunctionDataListener bAPFunctionDataListener) {
        List list = this.dataListeners;
        synchronized (list) {
            if (!this.dataListeners.contains(bAPFunctionDataListener)) {
                this.dataListeners.add(bAPFunctionDataListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeDataListener(BAPFunctionDataListener bAPFunctionDataListener) {
        List list = this.dataListeners;
        synchronized (list) {
            this.dataListeners.remove(bAPFunctionDataListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addAcknowledgeListener(IAcknowledgeListener iAcknowledgeListener) {
        List list = this.acknowledgeListeners;
        synchronized (list) {
            if (!this.acknowledgeListeners.contains(iAcknowledgeListener)) {
                this.acknowledgeListeners.add(iAcknowledgeListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAcknowledgeListener(IAcknowledgeListener iAcknowledgeListener) {
        List list = this.acknowledgeListeners;
        synchronized (list) {
            this.acknowledgeListeners.remove(iAcknowledgeListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addErrorIndicationListener(IErrorIndicationListener iErrorIndicationListener) {
        List list = this.errorIndicationListeners;
        synchronized (list) {
            if (!this.errorIndicationListeners.contains(iErrorIndicationListener)) {
                this.errorIndicationListeners.add(iErrorIndicationListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeErrorIndicationListener(IErrorIndicationListener iErrorIndicationListener) {
        List list = this.errorIndicationListeners;
        synchronized (list) {
            this.errorIndicationListeners.remove(iErrorIndicationListener);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("lsgID=");
        buffer.append(this.lsgIDDesc);
        buffer.append(", fctID=");
        buffer.append(this.fctIDDesc);
        return buffer.toString();
    }

    @Override
    public void onRemoteProcessState(RemoteProcessState remoteProcessState) {
    }
}

