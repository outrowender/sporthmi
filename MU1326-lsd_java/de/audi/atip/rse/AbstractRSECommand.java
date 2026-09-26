/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.rse;

import de.audi.atip.log.LogChannel;
import de.audi.atip.rse.AbstractRSEConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class AbstractRSECommand {
    public static final int SHIFT_LENGTH;
    private static final short MODULE_MASK;
    public static final short COMMAND_ID_MASK;
    public static final short MODULE_COUNT;
    public static final short MODULE_TEST;
    public static final short MODULE_TUNER;
    public static final short MODULE_MEDIA;
    public static final short MODULE_CONNECTION;
    public static final short MODULE_STORAGE;
    public static final short MODULE_SETTINGS;
    public static final short MODULE_NAVI;
    public static final short MODULE_SWDL;
    public static final short MODULE_I18N;
    public static final short MODULE_AUDIO;
    protected static LogChannel log;
    protected int id = -1;

    protected AbstractRSECommand(int n) {
        this.id = n;
    }

    protected void encodeHeader(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.id);
    }

    protected static short decodeHeader(DataInputStream dataInputStream) {
        short s = -1;
        s = dataInputStream.readShort();
        return s;
    }

    protected static int extractModuleID(int n) {
        return (n & 0xFFFFFF00) >> 8;
    }

    public abstract void encode(DataOutputStream dataOutputStream) {
    }

    public abstract void decode(DataInputStream dataInputStream) {
    }

    public abstract void execute(AbstractRSEConnection abstractRSEConnection) {
    }

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
        return new StringBuffer().append("RSECommand: id=").append(this.id).toString();
    }
}

