/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.FwServices;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Consumption;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.metrics.Volume;
import de.audi.atip.start.ILastmodeStorage;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LastmodeStorage
extends AbstractStorageDataContainer
implements ILastmodeStorage {
    private static final int VERSION = 3;
    private static final boolean USE_GEM_SKIN_OVERRIDE = Boolean.getBoolean("UseGEMSkinOverride");
    private final boolean rebootToDownload;
    private int lastmodeApp;
    private int lastmodeAudio;
    private int lastmodeBrightness;
    private int lastmodeDistance;
    private int lastmodeSpeed;
    private int lastmodePressure;
    private int lastmodeTemperature;
    private int lastmodeConsumption;
    private int lastmodeVolume;
    private int skin = 0;
    private boolean navEnabled;
    private int lastmodeKombiBrightness;
    private int lastmodeConsumptionElectro;
    private final FwServices framework;
    private final LogChannel lc;

    LastmodeStorage(FwServices fwServices, LogChannel logChannel, boolean bl) {
        super(fwServices.getStorageManager(), 3, 256, 20);
        this.framework = fwServices;
        this.lc = logChannel;
        this.rebootToDownload = bl;
        this.restoreDefaultValues();
    }

    private final FwServices getFw() {
        return this.framework;
    }

    protected void handleCRC32Error() {
        this.lc.log(10000, "LastmodeStorage.handleCRC32Error(): restore default values");
        this.restoreDefaultValues();
    }

    protected void handleStorageReadError(Exception exception) {
        this.lc.log(10000, "LastmodeStorage.handleStorageReadError(): restore default values", (Object)exception.getMessage());
        this.restoreDefaultValues();
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.lc.log(10000, "LastmodeStorage.convertContainere(%1, %2, ...): restore default values", (long)n, (long)n2);
        if (n == 1 && n2 == 3) {
            try {
                this.deserializeV1(dataInputStream);
                this.setKombiBrightness(this.lastmodeKombiBrightness, false);
            }
            catch (IOException iOException) {
                this.restoreDefaultValues();
            }
        } else if (n == 2 && n2 == 3) {
            try {
                this.deserializeV2(dataInputStream);
                this.setConsumptionElectro(this.lastmodeConsumptionElectro, false);
            }
            catch (IOException iOException) {
                this.restoreDefaultValues();
            }
        } else {
            this.restoreDefaultValues();
        }
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.lc.log(1000000, "LastmodeStorage.serialize() %1", (Object)this);
        try {
            dataOutputStream.writeInt(this.getLastmode());
            dataOutputStream.writeInt(this.getLastmodeAudio());
            dataOutputStream.writeInt(this.getBrightness());
            dataOutputStream.writeInt(this.getDistance());
            dataOutputStream.writeInt(this.getSpeed());
            dataOutputStream.writeInt(this.getPressure());
            dataOutputStream.writeInt(this.getTemperature());
            dataOutputStream.writeInt(this.getVolume());
            dataOutputStream.writeInt(this.getConsumption());
            dataOutputStream.writeBoolean(this.isNavEnabled());
            dataOutputStream.writeInt(this.skin);
            dataOutputStream.writeInt(this.getKombiBrightness());
            dataOutputStream.writeInt(this.getConsumptionElectro());
        }
        catch (IOException iOException) {
            this.lc.log(10000, "LastmodeStorage.serialize(): IOException", (Throwable)iOException);
            throw iOException;
        }
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        this.lc.log(10000000, "LastmodeStorage.deserialize()");
        this.deserializeV2(dataInputStream);
        this.setConsumptionElectro(dataInputStream.readInt(), false);
        this.lc.log(1000000, "LastmodeStorage.deserialize(): %1", (Object)this);
    }

    private void deserializeV2(DataInputStream dataInputStream) throws IOException {
        this.lc.log(10000000, "LastmodeStorage.deserialize()");
        this.deserializeV1(dataInputStream);
        this.setKombiBrightness(dataInputStream.readInt(), false);
        this.lc.log(1000000, "LastmodeStorage.deserialize(): %1", (Object)this);
    }

    private void deserializeV1(DataInputStream dataInputStream) throws IOException {
        this.lastmodeApp = dataInputStream.readInt();
        this.lastmodeAudio = dataInputStream.readInt();
        this.lc.log(10000000, "LastmodeStorage.deserializeV1(): LM = %1, LMA=%2", (long)this.lastmodeApp, (long)this.lastmodeAudio);
        this.setBrightness(dataInputStream.readInt(), false);
        this.setDistance(dataInputStream.readInt(), false);
        this.setSpeed(dataInputStream.readInt(), false);
        this.setPressure(dataInputStream.readInt(), false);
        this.setTemperature(dataInputStream.readInt(), false);
        this.setVolume(dataInputStream.readInt(), false);
        this.setConsumption(dataInputStream.readInt(), false);
        this.setNavEnabled(dataInputStream.readBoolean());
        this.skin = dataInputStream.readInt();
        if (USE_GEM_SKIN_OVERRIDE) {
            this.skin = this.getStorageAccess().getInt(256, 1, this.skin);
        }
        this.lc.log(1000000, "LastmodeStorage.deserializeV1(): %1", (Object)this);
    }

    private void restoreDefaultValues() {
        this.lc.log(1000000, "LastmodeStorage.restoreDefaultValues()");
        this.lastmodeApp = 1;
        this.lastmodeAudio = 1;
        this.lastmodeBrightness = 50;
        this.lastmodeDistance = 1;
        this.lastmodeSpeed = 1;
        this.lastmodePressure = 1;
        this.lastmodeTemperature = 1;
        this.lastmodeConsumption = 1;
        this.lastmodeConsumptionElectro = 6;
        this.lastmodeVolume = 1;
        this.navEnabled = true;
        this.skin = 0;
        this.lastmodeKombiBrightness = 50;
    }

    public void setLastmode(int n) {
        this.lastmodeApp = n;
    }

    public int getLastmode() {
        return this.lastmodeApp;
    }

    public void setLastmodeAudio(int n) {
        this.lastmodeAudio = n;
    }

    public int getLastmodeAudio() {
        return this.lastmodeAudio;
    }

    public boolean isNavEnabled() {
        return this.navEnabled;
    }

    public void setNavEnabled(boolean bl) {
        this.navEnabled = bl;
    }

    public int getBrightness() {
        return this.lastmodeBrightness;
    }

    public int getKombiBrightness() {
        return this.lastmodeKombiBrightness;
    }

    public int getDistance() {
        return this.lastmodeDistance;
    }

    public int getSpeed() {
        return this.lastmodeSpeed;
    }

    public int getPressure() {
        return this.lastmodePressure;
    }

    public int getTemperature() {
        return this.lastmodeTemperature;
    }

    public int getVolume() {
        return this.lastmodeVolume;
    }

    public int getConsumption() {
        return this.lastmodeConsumption;
    }

    public int getConsumptionElectro() {
        return this.lastmodeConsumptionElectro;
    }

    public int getSkin() {
        return this.skin;
    }

    public void setBrightness(int n, boolean bl) {
        if (n >= 0 && n <= 100) {
            this.lastmodeBrightness = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setKombiBrightness(int n, boolean bl) {
        if (n >= 0 && n <= 100) {
            this.lastmodeKombiBrightness = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setDistance(int n, boolean bl) {
        if (Distance.unitIsValid(n)) {
            this.lastmodeDistance = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setSpeed(int n, boolean bl) {
        if (Speed.unitIsValid(n)) {
            this.lastmodeSpeed = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setPressure(int n, boolean bl) {
        if (Pressure.unitIsValid(n)) {
            this.lastmodePressure = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setTemperature(int n, boolean bl) {
        if (Temperature.unitIsValid(n)) {
            this.lastmodeTemperature = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setVolume(int n, boolean bl) {
        if (Volume.unitIsValid(n)) {
            this.lastmodeVolume = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setConsumption(int n, boolean bl) {
        if (Consumption.unitIsValid(n)) {
            this.lastmodeConsumption = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setConsumptionElectro(int n, boolean bl) {
        if (Consumption.unitIsValid(n)) {
            this.lastmodeConsumptionElectro = n;
            if (bl && !this.rebootToDownload) {
                this.serializeAndWrite();
            }
        }
    }

    public void setSkin(int n) {
        this.skin = n;
        this.serializeAndWrite();
    }

    void initPersistentData() {
        this.lc.log(1000000, "LastmodeStorage.initPersistentData() start DSIPersistence");
        this.readAndDeserialize();
        Distance.setSystemUnit(this.lastmodeDistance);
        Speed.setSystemUnit(this.lastmodeSpeed);
        Temperature.setSystemUnit(this.lastmodeTemperature);
        Pressure.setSystemUnit(this.lastmodePressure);
        Volume.setSystemUnit(this.lastmodeVolume);
        Consumption.setSystemUnit(this.lastmodeConsumption);
        Consumption.setSystemUnitElektro(this.lastmodeConsumptionElectro);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("\nlastmode: ").append(this.getLastmode());
        buffer.append("\nlastmodeAudio: ").append(this.getLastmodeAudio());
        buffer.append("\nbrightness: ").append(this.getBrightness());
        buffer.append("\ndistance: ").append(this.getDistance());
        buffer.append("\nspeed: ").append(this.getSpeed());
        buffer.append("\npressure: ").append(this.getPressure());
        buffer.append("\ntemperature: ").append(this.getTemperature());
        buffer.append("\nvolume: ").append(this.getVolume());
        buffer.append("\nconsumption: ").append(this.getConsumption());
        buffer.append("\nnavEnabled: ").append(this.isNavEnabled());
        buffer.append("\nkombiBrightness: ").append(this.getKombiBrightness());
        buffer.append("\nconsumptionElectro: ").append(this.getConsumptionElectro());
        return buffer.toString();
    }
}

