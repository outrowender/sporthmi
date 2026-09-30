/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storagecache;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.tghu.storagecache.CacheWorker;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class PresetLayoutCacheWorker
extends CacheWorker
implements DSICarVehicleStatesListener {
    private DSICarVehicleStates dsi;
    private boolean isHandSchalter;
    private String token = "";

    public PresetLayoutCacheWorker(LogChannel logChannel, IStorageAccess iStorageAccess, int n, int n2, int n3, String string) {
        super(logChannel, iStorageAccess, n, n2, n3, string);
        this.token = string;
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
    }

    public void updateVINViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateVINData(String string, int n) {
    }

    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateKeyData(KeyData keyData, int n) {
    }

    public void updateDrvSchoolSystem(boolean bl, int n) {
    }

    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
    }

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        if (n != 1 || dynamicVehicleInfoMidFrequentViewOptions == null) {
            this.log.log(10000, "PresetLayoutCacheWorker.updateDynamicVehicleInfoMidFrequentViewOptions(): vehicleInfoViewOptions list is not valid %1", (Object)dynamicVehicleInfoMidFrequentViewOptions);
            return;
        }
        CarViewOption carViewOption = dynamicVehicleInfoMidFrequentViewOptions.getAutomaticGearShiftTransMode();
        if (carViewOption != null) {
            this.isHandSchalter = carViewOption.getState() == 0;
            this.serializeAndWrite();
            Map map = this.token2Subscriber;
            synchronized (map) {
                List list = (List)this.token2Subscriber.get(this.token);
                if (list != null) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((CacheEventListener)iterator.next()).updateToken(this.serviceID, this.token, new Boolean(this.isHandSchalter));
                        }
                        catch (Exception exception) {
                            this.log.log(10000, "CacheEventListener.updateToken() callback error: %1", (Throwable)exception);
                        }
                    }
                } else {
                    this.log.log(1000000, "CacheEventListener.updateDynamicVehicleInfoMidFrequent: No subscriber for token %1 are registered", (Object)this.token);
                }
            }
        } else {
            this.log.log(10000, "PresetLayoutCacheWorker.updateDynamicVehicleInfoMidFrequentViewOptions(): getAutomaticGearShiftTransMode() is null");
        }
    }

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
    }

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
    }

    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
    }

    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
    }

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
    }

    public Object getState(String string) {
        if (string.equals(this.token)) {
            return new Boolean(this.isHandSchalter);
        }
        return new Boolean(false);
    }

    protected void registerWorkerAsServiceListener(Object object) {
        this.log.log(1000000, "PresetLayoutCacheWorker.setDSI() (%1)", object);
        this.dsi = (DSICarVehicleStates)object;
        this.dsi.setNotification(new int[]{13}, (DSIListener)this);
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeBoolean(this.isHandSchalter);
        dataOutputStream.writeUTF(this.token);
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        this.isHandSchalter = dataInputStream.readBoolean();
        this.token = dataInputStream.readUTF();
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
        super.convertContainer(n, n2, dataInputStream);
        this.deserialize(dataInputStream);
    }

    protected void registerCacheEventListener(CacheEventListener cacheEventListener) {
    }
}

