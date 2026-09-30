/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.app.terminalmode.util.Enum;
import de.audi.app.terminalmode.util.Streamable;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TMDevice
implements Streamable {
    private final TMDeviceID uniqueId;
    private final String shortUniqueId;
    private volatile int id = -1;
    private volatile String name = "";
    private volatile ConnectionState connectionState;
    private volatile UserAcceptState userAcceptState;
    private volatile boolean isSelected;
    private volatile boolean wasDisclaimerPreviouslyAccepted;
    private volatile boolean storeUserAcceptState;
    private volatile long attachedTime;
    public static final Streamable.Creator CREATOR = new Streamable.Creator(){

        public Object readFromStream(DataInputStream dataInputStream) throws IOException, IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
            String string = dataInputStream.readUTF();
            String string2 = dataInputStream.readUTF();
            String string3 = dataInputStream.readBoolean() ? dataInputStream.readUTF() : null;
            String string4 = dataInputStream.readUTF();
            boolean bl = dataInputStream.readBoolean();
            boolean bl2 = dataInputStream.readBoolean();
            return new TMDevice(new TMDeviceID(string, SmartphoneManager.SmartphoneType.valueOf(string2))).setName(string3).setUserAcceptState(UserAcceptState.valueOf(string4)).setWasDisclaimerPreviouslyAccepted(bl).setStoreUserAcceptState(bl2);
        }
    };
    public static final TMDevice INVALID = new TMDevice(TMDeviceID.INVALID);
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState;

    public TMDevice(TMDeviceID tMDeviceID) {
        this.uniqueId = tMDeviceID;
        this.shortUniqueId = tMDeviceID.address == null ? "null" : tMDeviceID.address.substring(0, Math.min(tMDeviceID.address.length(), 7));
        this.userAcceptState = UserAcceptState.INITIAL;
        this.connectionState = ConnectionState.INVALID;
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
        return this.uniqueId.smartphoneType.is(SmartphoneManager.SmartphoneType.CARPLAY);
    }

    public boolean isAndroidAutoDevice() {
        return this.uniqueId.smartphoneType.is(SmartphoneManager.SmartphoneType.ANDROIDAUTO2);
    }

    public boolean isCarlifeDevice() {
        return this.uniqueId.smartphoneType.is(SmartphoneManager.SmartphoneType.CARLIFE);
    }

    public boolean isActive() {
        return this.connectionState().equals(ConnectionState.ACTIVE);
    }

    public ConnectionState connectionState() {
        return this.connectionState;
    }

    public UserAcceptState userAcceptState() {
        return this.userAcceptState;
    }

    public SmartphoneManager.SmartphoneType smartphoneType() {
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

    TMDevice setConnectionState(ConnectionState connectionState) {
        this.connectionState = connectionState;
        return this;
    }

    public TMDevice setUserAcceptState(UserAcceptState userAcceptState) {
        this.userAcceptState = userAcceptState;
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

    public void writeToStream(DataOutputStream dataOutputStream) throws IOException {
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

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class ConnectionState
    extends Enum<ConnectionState> {
        public static final ConnectionState INVALID = new ConnectionState("INVALID");
        public static final ConnectionState NOT_ATTACHED = new ConnectionState("NOT_ATTACHED");
        public static final ConnectionState ATTACHED = new ConnectionState("ATTACHED");
        public static final ConnectionState ACTIVATING = new ConnectionState("ACTIVATING");
        public static final ConnectionState ACTIVE = new ConnectionState("ACTIVE");
        public static final ConnectionState CONNECTED = new ConnectionState("CONNECTED");
        public static final ConnectionState CONNECTING = new ConnectionState("CONNECTING");

        private ConnectionState(String string) {
            super(string);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class UserAcceptState
    extends Enum<UserAcceptState> {
        public static final UserAcceptState INITIAL = new UserAcceptState("INITIAL");
        public static final UserAcceptState TM_SELECTED = new UserAcceptState("TM_SELECTED");
        public static final UserAcceptState NATIVE_SELECTED = new UserAcceptState("NATIVE_SELECTED");
        public static final UserAcceptState DISCLAIMER_ACCEPTED = new UserAcceptState("DISCLAIMER_ACCEPTED");
        public static final UserAcceptState NATIVE = new UserAcceptState("NATIVE");

        private UserAcceptState(String string) {
            super(string);
        }

        public static UserAcceptState valueOf(String string) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
            return (UserAcceptState)(class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState == null ? (class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState = TMDevice.class$("de.audi.app.terminalmode.device.TMDevice$UserAcceptState")) : class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState).getField(string).get(null);
        }
    }
}

