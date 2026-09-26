/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.TMDevice$1;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.app.terminalmode.util.Streamable;
import de.audi.app.terminalmode.util.Streamable$Creator;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataOutputStream;

public class TMDevice
implements Streamable {
    private final TMDeviceID uniqueId;
    private final String shortUniqueId;
    private volatile int id = -1;
    private volatile String name = "";
    private volatile TMDevice$ConnectionState connectionState;
    private volatile TMDevice$UserAcceptState userAcceptState;
    private volatile boolean isSelected;
    private volatile boolean wasDisclaimerPreviouslyAccepted;
    private volatile boolean storeUserAcceptState;
    private volatile long attachedTime;
    public static final Streamable$Creator CREATOR = new TMDevice$1();
    public static final TMDevice INVALID = new TMDevice(TMDeviceID.INVALID);
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState;

    public TMDevice(TMDeviceID tMDeviceID) {
        this.uniqueId = tMDeviceID;
        this.shortUniqueId = tMDeviceID.address == null ? "null" : tMDeviceID.address.substring(0, Math.min(tMDeviceID.address.length(), 7));
        this.userAcceptState = TMDevice$UserAcceptState.INITIAL;
        this.connectionState = TMDevice$ConnectionState.INVALID;
    }

    public TMDeviceID getUniqueID() {
        return this.uniqueId;
    }

    public int getDeviceId() {
        return this.id;
    }

    public String getDevicename() {
        return this.name;
    }

    public boolean isCarplayDevice() {
        return this.uniqueId.smartphoneType.is(SmartphoneManager$SmartphoneType.CARPLAY);
    }

    public boolean isAndroidAutoDevice() {
        return this.uniqueId.smartphoneType.is(SmartphoneManager$SmartphoneType.ANDROIDAUTO2);
    }

    public boolean isCarlifeDevice() {
        return this.uniqueId.smartphoneType.is(SmartphoneManager$SmartphoneType.CARLIFE);
    }

    public boolean isActive() {
        return this.connectionState().equals(TMDevice$ConnectionState.ACTIVE);
    }

    public TMDevice$ConnectionState connectionState() {
        return this.connectionState;
    }

    public TMDevice$UserAcceptState userAcceptState() {
        return this.userAcceptState;
    }

    public SmartphoneManager$SmartphoneType smartphoneType() {
        return this.uniqueId.smartphoneType;
    }

    public boolean isValid() {
        return !this.getUniqueID().equals(TMDeviceID.INVALID);
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean wasDisclaimerPreviouslyAccepted() {
        return this.wasDisclaimerPreviouslyAccepted;
    }

    public boolean isStoreUserAcceptState() {
        return this.storeUserAcceptState;
    }

    TMDevice setName(String string) {
        this.name = string;
        return this;
    }

    TMDevice setId(int n) {
        this.id = n;
        return this;
    }

    TMDevice setConnectionState(TMDevice$ConnectionState tMDevice$ConnectionState) {
        this.connectionState = tMDevice$ConnectionState;
        return this;
    }

    public TMDevice setUserAcceptState(TMDevice$UserAcceptState tMDevice$UserAcceptState) {
        this.userAcceptState = tMDevice$UserAcceptState;
        return this;
    }

    public TMDevice setStoreUserAcceptState(boolean bl) {
        this.storeUserAcceptState = bl;
        return this;
    }

    public TMDevice setSelected(boolean bl) {
        this.isSelected = bl;
        return this;
    }

    public TMDevice setWasDisclaimerPreviouslyAccepted(boolean bl) {
        this.wasDisclaimerPreviouslyAccepted = bl;
        return this;
    }

    public void setAttachTime(long l) {
        this.attachedTime = l;
    }

    public long getAttachTime() {
        return this.attachedTime;
    }

    public String toString() {
        return new Buffer(100).append("TMDevice[").append(this.isSelected ? "(x)" : "( )").append(", ").append(this.name).append(", ").append(this.uniqueId.smartphoneType).append(", ").append(this.connectionState).append(", ").append(this.attachedTime).append(", ").append(this.userAcceptState).append(", ").append(this.wasDisclaimerPreviouslyAccepted ? "accepted" : "not accepted").append(", ").append(this.storeUserAcceptState ? "stored" : "not stored").append(", ").append(this.id).append(", ").append("sid=").append(this.shortUniqueId).append("]").toString();
    }

    public String stateToString() {
        return this.connectionState().toString();
    }

    @Override
    public void writeToStream(DataOutputStream dataOutputStream) {
        dataOutputStream.writeUTF(this.uniqueId.address);
        dataOutputStream.writeUTF(this.uniqueId.smartphoneType.name());
        dataOutputStream.writeBoolean(this.name != null);
        if (this.name != null) {
            dataOutputStream.writeUTF(this.name);
        }
        dataOutputStream.writeUTF(this.userAcceptState.name());
        dataOutputStream.writeBoolean(this.wasDisclaimerPreviouslyAccepted);
        dataOutputStream.writeBoolean(this.storeUserAcceptState);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

