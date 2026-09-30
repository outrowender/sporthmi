/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallPoiStorage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallPoiStorageDataContainer
extends AbstractStorageDataContainer {
    private static final int MAX_POIS = 5;
    private static final int POI_VERSION = 1;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private ArrayList poiStorages;
    private boolean used = false;

    public OperatorCallPoiStorageDataContainer(IStorageAccess iStorageAccess, int n) {
        super(iStorageAccess, 1, 1023, n);
    }

    public int getPoiStorageKeyId() {
        return this.getKey();
    }

    protected void handleCRC32Error() {
        this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#handleCRC32Error");
    }

    protected void handleStorageReadError(Exception exception) {
        this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#handleStorageReadError!", (Throwable)exception);
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
        this.logChannel.log(10000000, "OperatorCallPoiStorageDataContainer#convertContainer!");
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        if (this.poiStorages == null) {
            this.logChannel.log(10000, "OperatorCallPoiStorageDataContainer#serialize: arraylist for saving pois is null! This should never happen!");
            return;
        }
        int n = this.poiStorages.size();
        dataOutputStream.writeInt(n);
        for (int i2 = 0; i2 < n; ++i2) {
            OperatorCallPoiStorage operatorCallPoiStorage = (OperatorCallPoiStorage)this.poiStorages.get(i2);
            operatorCallPoiStorage.serialize(dataOutputStream);
            this.logChannel.log(100000000, "OperatorCallPoiStorageDataContainer#serialize: poi = %1", (Object)operatorCallPoiStorage);
        }
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        if (n < 0 || n > 5) {
            this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#deserialize: Number of pois (%1) exceeds the valid number of pois [0,%2]! Persistence must be corrupt. Ignoring the POIs of this call.", (long)n, 5L);
            return;
        }
        this.poiStorages = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            int n2;
            String string;
            boolean bl = true;
            String string2 = dataInputStream.readUTF();
            int n3 = dataInputStream.readInt();
            if (n3 != 2 && n3 != 1) {
                this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#deserialize: serviceType unknown! Persistence must be corrupt. Ignoring this POI.");
                bl = false;
            }
            if ((string = this.getNullForEmptyString(dataInputStream.readUTF())) == null || string.length() < 1) {
                this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#deserialize: poi name is null or empty! Persistence must be corrupt. Ignoring this POI.");
                bl = false;
            }
            String string3 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string4 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string5 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string6 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string7 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string8 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string9 = this.getNullForEmptyString(dataInputStream.readUTF());
            String string10 = this.getNullForEmptyString(dataInputStream.readUTF());
            int n4 = dataInputStream.readInt();
            if (n4 < -1073741760 || n4 > 1073741760) {
                this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#deserialize: latitude invalid! Persistence must be corrupt. Ignoring this POI.");
                bl = false;
            }
            if ((n2 = dataInputStream.readInt()) < -2147483520 || n2 > 2147483520) {
                this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#deserialize: longitude invalid! Persistence must be corrupt. Ignoring this POI.");
                bl = false;
            }
            if (!bl) continue;
            OperatorCallAddressEntry operatorCallAddressEntry = new OperatorCallAddressEntry(string3, string4, string5, string6, string7, string8, string9, string10);
            NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(n2, n4);
            OperatorCallResult operatorCallResult = new OperatorCallResult(string2, n3, string, operatorCallAddressEntry, navLocationWgs84);
            OperatorCallPoiStorage operatorCallPoiStorage = new OperatorCallPoiStorage(operatorCallResult);
            this.poiStorages.add(operatorCallPoiStorage);
            this.logChannel.log(100000000, "OperatorCallPoiStorageDataContainer#deserialize: poi = %1", (Object)operatorCallPoiStorage);
        }
    }

    public OperatorCallResult[] getOperatorCallResults() {
        if (this.poiStorages == null || this.poiStorages.size() < 1) {
            this.logChannel.log(10000, "OperatorCallPoiStorageDataContainer#getOperatorCallResults: No pois for this call! This should never happen!");
            return null;
        }
        int n = this.poiStorages.size();
        OperatorCallResult[] operatorCallResultArray = new OperatorCallResult[n];
        for (int i2 = 0; i2 < n; ++i2) {
            OperatorCallPoiStorage operatorCallPoiStorage = (OperatorCallPoiStorage)this.poiStorages.get(i2);
            String string = operatorCallPoiStorage.getServiceId();
            int n2 = operatorCallPoiStorage.getServiceType();
            String string2 = operatorCallPoiStorage.getName();
            OperatorCallAddressEntry operatorCallAddressEntry = operatorCallPoiStorage.getAddress();
            NavLocationWgs84 navLocationWgs84 = operatorCallPoiStorage.getLocation();
            operatorCallResultArray[i2] = new OperatorCallResult(string, n2, string2, operatorCallAddressEntry, navLocationWgs84);
        }
        return operatorCallResultArray;
    }

    public void storePois(OperatorCallResult[] operatorCallResultArray) {
        int n;
        if (operatorCallResultArray.length <= 5) {
            n = operatorCallResultArray.length;
        } else {
            this.logChannel.log(100000, "OperatorCallPoiStorageDataContainer#addPois: too many POIs (%1). Persisting only the first %2 POIs", (long)operatorCallResultArray.length, 5L);
            n = 5;
        }
        this.poiStorages = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            this.poiStorages.add(new OperatorCallPoiStorage(operatorCallResultArray[i2]));
        }
    }

    public String getNullForEmptyString(String string) {
        if ("".equalsIgnoreCase(string)) {
            return null;
        }
        return string;
    }

    public void setUsed(boolean bl) {
        this.used = bl;
    }

    public boolean isUsed() {
        return this.used;
    }
}

