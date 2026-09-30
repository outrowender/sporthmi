/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.rse;

import de.audi.atip.log.LogChannel;
import de.audi.atip.rse.AbstractRSEConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class AbstractRSECommand {
    public static final int SHIFT_LENGTH = 8;
    private static final short MODULE_MASK = -256;
    public static final short COMMAND_ID_MASK = 255;
    public static final short MODULE_COUNT = 32;
    public static final short MODULE_TEST = 0;
    public static final short MODULE_TUNER = 1;
    public static final short MODULE_MEDIA = 2;
    public static final short MODULE_CONNECTION = 3;
    public static final short MODULE_STORAGE = 4;
    public static final short MODULE_SETTINGS = 11;
    public static final short MODULE_NAVI = 5;
    public static final short MODULE_SWDL = 17;
    public static final short MODULE_I18N = 18;
    public static final short MODULE_AUDIO = 19;
    protected static LogChannel log;
    protected int id = -1;

    protected AbstractRSECommand(int n) {
        this.id = n;
    }

    protected void encodeHeader(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.id);
    }

    protected static short decodeHeader(DataInputStream dataInputStream) throws IOException {
        short s = -1;
        s = dataInputStream.readShort();
        return s;
    }

    protected static int extractModuleID(int n) {
        return (n & 0xFFFFFF00) >> 8;
    }

    public abstract void encode(DataOutputStream var1);

    public abstract void decode(DataInputStream var1);

    public abstract void execute(AbstractRSEConnection var1);

    public static LogChannel getLog() {
        return log;
    }

    public static void setLog(LogChannel logChannel) {
        log = logChannel;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "RSECommand: id=" + this.id;
    }
}

