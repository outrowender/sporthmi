/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.sim.SimUsageUserDecision;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.esolutions.fw.util.commons.Converter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class TelSIMModeSwitchHandler$SimModeSwitchStorageHandler
extends AbstractStorageDataContainer {
    private static final int PERSISTENCE_CONTAINER_VERSION;
    private SimUsageUserDecision[] usageInfo;
    private final /* synthetic */ TelSIMModeSwitchHandler this$0;

    public TelSIMModeSwitchHandler$SimModeSwitchStorageHandler(TelSIMModeSwitchHandler telSIMModeSwitchHandler, IStorageAccess iStorageAccess) {
        this.this$0 = telSIMModeSwitchHandler;
        super(iStorageAccess, 0, 1003, 110);
    }

    private void storeSIMUsageUserDecision(SimUsageUserDecision[] simUsageUserDecisionArray) {
        this.usageInfo = simUsageUserDecisionArray != null ? simUsageUserDecisionArray : new SimUsageUserDecision[]{};
        TelSIMModeSwitchHandler.access$200(this.this$0).log(1078071040, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#storeSIMUsageUserDecision] %1", (Object)Converter.array2String(this.usageInfo));
        this.serializeAndWrite();
    }

    private SimUsageUserDecision[] loadSimUsageUserDecisionInfo() {
        this.readAndDeserialize();
        TelSIMModeSwitchHandler.access$300(this.this$0).log(1078071040, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#loadSimUsageUserDecisionInfo] %1", (Object)Converter.array2String(this.usageInfo));
        return this.usageInfo;
    }

    @Override
    protected void handleCRC32Error() {
        TelSIMModeSwitchHandler.access$400(this.this$0).log(10000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        TelSIMModeSwitchHandler.access$500(this.this$0).log(1078071040, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#handleStorageReadError] - no persisted sim usage information!");
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        TelSIMModeSwitchHandler.access$600(this.this$0).log(-1601830656, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#convertContainer] persistedVersion=%1, containerVersion=%2 --> NOP!", (long)n, (long)n2);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        int n = this.usageInfo.length;
        TelSIMModeSwitchHandler.access$700(this.this$0).log(-2137614336, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#serialize] length=%1", (long)n);
        dataOutputStream.writeInt(n);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        for (int i2 = 0; i2 < this.usageInfo.length; ++i2) {
            SimUsageUserDecision simUsageUserDecision = this.usageInfo[i2];
            TelSIMModeSwitchHandler.access$800(this.this$0).log(1078071040, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#serialize] SimUsageUserDecision=%1", (Object)simUsageUserDecision);
            objectOutputStream.writeObject(simUsageUserDecision);
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        TelSIMModeSwitchHandler.access$900(this.this$0).log(-2137614336, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize]");
        int n = dataInputStream.readInt();
        TelSIMModeSwitchHandler.access$1000(this.this$0).log(-2137614336, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] arrayLength=%1", (long)n);
        if (n < 0 || n > 50) {
            TelSIMModeSwitchHandler.access$1100(this.this$0).log(10000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] array length not valid: %1", (long)n);
            return;
        }
        this.usageInfo = new SimUsageUserDecision[n];
        ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
        for (int i2 = 0; i2 < n; ++i2) {
            try {
                SimUsageUserDecision simUsageUserDecision = (SimUsageUserDecision)objectInputStream.readObject();
                TelSIMModeSwitchHandler.access$1200(this.this$0).log(-2137614336, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] usageInfo=%1", (Object)this.usageInfo);
                this.usageInfo[i2] = simUsageUserDecision;
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                TelSIMModeSwitchHandler.access$1300(this.this$0).log(10000, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] %1", (Throwable)classNotFoundException);
            }
        }
        TelSIMModeSwitchHandler.access$1400(this.this$0).log(-2137614336, "[TelSIMModeSwitchHandler.SimModeSwitchStorageHandler#deserialize] %1", (Object)Converter.array2String(this.usageInfo));
    }

    static /* synthetic */ SimUsageUserDecision[] access$000(TelSIMModeSwitchHandler$SimModeSwitchStorageHandler telSIMModeSwitchHandler$SimModeSwitchStorageHandler) {
        return telSIMModeSwitchHandler$SimModeSwitchStorageHandler.loadSimUsageUserDecisionInfo();
    }

    static /* synthetic */ void access$100(TelSIMModeSwitchHandler$SimModeSwitchStorageHandler telSIMModeSwitchHandler$SimModeSwitchStorageHandler, SimUsageUserDecision[] simUsageUserDecisionArray) {
        telSIMModeSwitchHandler$SimModeSwitchStorageHandler.storeSIMUsageUserDecision(simUsageUserDecisionArray);
    }
}

