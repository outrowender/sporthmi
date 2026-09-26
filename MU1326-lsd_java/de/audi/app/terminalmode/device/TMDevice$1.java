/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.app.terminalmode.util.Streamable$Creator;
import java.io.DataInputStream;

final class TMDevice$1
implements Streamable$Creator {
    TMDevice$1() {
    }

    @Override
    public Object readFromStream(DataInputStream dataInputStream) {
        String string = dataInputStream.readUTF();
        String string2 = dataInputStream.readUTF();
        String string3 = dataInputStream.readBoolean() ? dataInputStream.readUTF() : null;
        String string4 = dataInputStream.readUTF();
        boolean bl = dataInputStream.readBoolean();
        boolean bl2 = dataInputStream.readBoolean();
        return new TMDevice(new TMDeviceID(string, SmartphoneManager$SmartphoneType.valueOf(string2))).setName(string3).setUserAcceptState(TMDevice$UserAcceptState.valueOf(string4)).setWasDisclaimerPreviouslyAccepted(bl).setStoreUserAcceptState(bl2);
    }
}

