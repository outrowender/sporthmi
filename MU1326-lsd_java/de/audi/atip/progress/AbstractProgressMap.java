/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

import de.audi.atip.progress.ProgressMap;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;

public abstract class AbstractProgressMap
implements ProgressMap {
    private String[] taskNames;
    private boolean[] taskStatus;

    protected AbstractProgressMap(String[] stringArray) {
        this.taskNames = stringArray;
        this.reset();
    }

    @Override
    public final void reset() {
        this.taskStatus = new boolean[this.taskNames == null ? 0 : this.taskNames.length];
    }

    @Override
    public int getTaskCount() {
        return this.taskNames.length;
    }

    @Override
    public int taskCompleted(int n, boolean bl) {
        if (0 <= n && n < this.taskNames.length) {
            this.taskStatus[n] = bl;
        }
        int n2 = 0;
        for (int i2 = 0; i2 < this.taskStatus.length; ++i2) {
            if (!this.taskStatus[i2]) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public String taskIDToString(int n) {
        if (0 <= n && n < this.taskNames.length) {
            return this.taskNames[n];
        }
        return "UNKNOWN_TASK";
    }

    public String toString() {
        Buffer buffer = new Buffer();
        int n = this.getTaskCount();
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(this.taskIDToString(i2)).append('=').append(this.taskStatus[i2]).append(Formatter.LINE_SEPARATOR);
        }
        return buffer.toString();
    }
}

