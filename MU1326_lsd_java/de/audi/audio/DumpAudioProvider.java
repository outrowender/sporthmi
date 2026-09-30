/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.RingBuffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.ArrayList;

public final class DumpAudioProvider
implements DumpInfoProvider {
    public static final DumpAudioProvider INSTANCE = new DumpAudioProvider();
    private static final int BUFFER_SIZE = 50;
    private final RingBuffer ringBuffer = new RingBuffer(50);

    private DumpAudioProvider() {
    }

    public void putCall(String string, int n, int n2) {
        this.put(new Buffer().append("-> ").append(string).append(" - AC:").append(n).append(" AT:").append(n2));
    }

    public void putUpdate(String string, int n, int n2) {
        this.put(new Buffer().append("<- ").append(string).append(" - AC:").append(n).append(" AT:").append(n2));
    }

    public void putAMAvailable(int n) {
        this.put(new Buffer().append("<- ").append("updateAMAvailable - ").append(n == 3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void put(Buffer buffer) {
        RingBuffer ringBuffer = this.ringBuffer;
        synchronized (ringBuffer) {
            this.ringBuffer.put(buffer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dump(PrintStream printStream, String string) {
        try {
            int n;
            ArrayList arrayList = new ArrayList(50);
            RingBuffer ringBuffer = this.ringBuffer;
            synchronized (ringBuffer) {
                int n2 = this.ringBuffer.size();
                for (n = 0; n < n2; ++n) {
                    arrayList.add(this.ringBuffer.get(n));
                }
            }
            n = arrayList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                printStream.println(arrayList.get(i2));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String getName() {
        return "AudioState";
    }
}

