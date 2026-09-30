/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ConnectionState_Status
implements StatusProperty {
    public int bluetoothState;
    private static final int BLUETOOTH_STATE_BITSIZE = 4;
    public static final int BLUETOOTH_STATE_BLUETOOTH_NOT_INSTALLED = 0;
    public static final int BLUETOOTH_STATE_BLUETOOTH_OFF = 1;
    public static final int BLUETOOTH_STATE_BLUETOOTH_ON = 2;
    public static final int BLUETOOTH_STATE_BLUETOOTH_SWITCHING_OFF = 3;
    public static final int BLUETOOTH_STATE_BLUETOOTH_SWITCHING_ON = 4;
    public static final int BLUETOOTH_STATE_BLUETOOTH_NOT_FUNCTIONAL = 5;
    public int bluetoothVisibility;
    private static final int BLUETOOTH_VISIBILITY_BITSIZE = 4;
    public static final int BLUETOOTH_VISIBILITY_NOT_VISIBLE = 0;
    public static final int BLUETOOTH_VISIBILITY_VISIBLE = 1;
    public static final int BLUETOOTH_VISIBILITY_AUTO = 2;
    public final BluetoothConnections bluetoothConnections = new BluetoothConnections();
    public int wlanstate;
    private static final int WLAN_STATE_BITSIZE = 4;
    public static final int WLAN_STATE_WLAN_NOT_INSTALLED = 0;
    public static final int WLAN_STATE_OFF = 1;
    public static final int WLAN_STATE_ON = 2;
    public int wlanvisibility;
    private static final int WLAN_VISIBILITY_BITSIZE = 4;
    public static final int WLAN_VISIBILITY_NOT_VISIBLE = 0;
    public static final int WLAN_VISIBILITY_VISIBLE = 1;
    public static final int WLAN_VISIBILITY_AUTO = 2;
    public int wlanconnections;
    private static final int WLAN_CONNECTIONS_BITSIZE = 8;
    public static final int EXTENSION_1_MIN = 0;
    public int extension_1;
    private static final int EXTENSION_1_BITSIZE = 8;
    public static final int EXTENSION_2_MIN = 0;
    public int extension_2;
    private static final int EXTENSION_2_BITSIZE = 8;

    public ConnectionState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ConnectionState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bluetoothState = 0;
        this.bluetoothVisibility = 0;
        this.wlanstate = 0;
        this.wlanvisibility = 0;
        this.wlanconnections = 0;
        this.extension_1 = 0;
        this.extension_2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.bluetoothConnections.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ConnectionState_Status connectionState_Status = (ConnectionState_Status)bAPEntity;
        return this.bluetoothState == connectionState_Status.bluetoothState && this.bluetoothVisibility == connectionState_Status.bluetoothVisibility && this.bluetoothConnections.equalTo(connectionState_Status.bluetoothConnections) && this.wlanstate == connectionState_Status.wlanstate && this.wlanvisibility == connectionState_Status.wlanvisibility && this.wlanconnections == connectionState_Status.wlanconnections && this.extension_1 == connectionState_Status.extension_1 && this.extension_2 == connectionState_Status.extension_2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ConnectionState_Status:");
        stringBuffer.append("\n - BluetoothState: ");
        switch (this.bluetoothState) {
            case 0: {
                stringBuffer.append("0x0 (Bluetooth not installed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (Bluetooth off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Bluetooth on)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Bluetooth switching off)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Bluetooth switching on)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (Bluetooth not functional)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - BluetoothVisibility: ");
        switch (this.bluetoothVisibility) {
            case 0: {
                stringBuffer.append("0x0 (not visible)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (visible)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (auto)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - BluetoothConnections - ");
        stringBuffer.append(this.bluetoothConnections.toString());
        stringBuffer.append("\n - WLANState: ");
        switch (this.wlanstate) {
            case 0: {
                stringBuffer.append("0x0 (WLAN not installed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (on)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - WLANVisibility: ");
        switch (this.wlanvisibility) {
            case 0: {
                stringBuffer.append("0x0 (not visible)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (visible)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (auto)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - WLANConnections - ");
        stringBuffer.append(this.wlanconnections);
        stringBuffer.append("\n - Extension_1 - ");
        stringBuffer.append(this.extension_1);
        stringBuffer.append("\n - Extension_2 - ");
        stringBuffer.append(this.extension_2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += this.bluetoothConnections.bitSize();
        n += 4;
        n += 4;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.bluetoothState);
        bitStream.pushBits(4, this.bluetoothVisibility);
        this.bluetoothConnections.serialize(bitStream);
        bitStream.pushBits(4, this.wlanstate);
        bitStream.pushBits(4, this.wlanvisibility);
        bitStream.pushByte((byte)this.wlanconnections);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    public void deserialize(BitStream bitStream) {
        this.bluetoothState = bitStream.popFrontBits(4);
        this.bluetoothVisibility = bitStream.popFrontBits(4);
        this.bluetoothConnections.deserialize(bitStream);
        this.wlanstate = bitStream.popFrontBits(4);
        this.wlanvisibility = bitStream.popFrontBits(4);
        this.wlanconnections = bitStream.popFrontByte();
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return ConnectionState_Status.functionId();
    }

    public static final class BluetoothConnections
    implements BAPEntity {
        private static final int RESERVED_BIT_4__7_BITSIZE = 4;
        public boolean simAccessProfileActive;
        public boolean phonebookAccessProfileActive;
        public boolean handsFreeProfileActive;
        public boolean audioplayerActive;
        private static final int BLUETOOTH_CONNECTIONS_BITSIZE = 8;

        public BluetoothConnections() {
            this.internalReset();
            this.customInitialization();
        }

        public BluetoothConnections(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.simAccessProfileActive = false;
            this.phonebookAccessProfileActive = false;
            this.handsFreeProfileActive = false;
            this.audioplayerActive = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            BluetoothConnections bluetoothConnections = (BluetoothConnections)bAPEntity;
            return this.simAccessProfileActive == bluetoothConnections.simAccessProfileActive && this.phonebookAccessProfileActive == bluetoothConnections.phonebookAccessProfileActive && this.handsFreeProfileActive == bluetoothConnections.handsFreeProfileActive && this.audioplayerActive == bluetoothConnections.audioplayerActive;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("BluetoothConnections:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.simAccessProfileActive) {
                stringBuffer.append("true  (SimAccessProfile active");
            } else {
                stringBuffer.append("false  (SimAccessProfile not active");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.phonebookAccessProfileActive) {
                stringBuffer.append("true  (PhonebookAccessProfile active");
            } else {
                stringBuffer.append("false  (PhonebookAccessProfile not active");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.handsFreeProfileActive) {
                stringBuffer.append("true  (HandsFreeProfile active");
            } else {
                stringBuffer.append("false  (HandsFreeProfile not active");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.audioplayerActive) {
                stringBuffer.append("true  (Audioplayer active");
            } else {
                stringBuffer.append("false  (Audioplayer not active");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(4);
            bitStream.pushBoolean(this.simAccessProfileActive);
            bitStream.pushBoolean(this.phonebookAccessProfileActive);
            bitStream.pushBoolean(this.handsFreeProfileActive);
            bitStream.pushBoolean(this.audioplayerActive);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(4);
            this.simAccessProfileActive = bitStream.popFrontBoolean();
            this.phonebookAccessProfileActive = bitStream.popFrontBoolean();
            this.handsFreeProfileActive = bitStream.popFrontBoolean();
            this.audioplayerActive = bitStream.popFrontBoolean();
        }
    }
}

