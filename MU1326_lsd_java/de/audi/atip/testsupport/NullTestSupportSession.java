/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportSession;

public class NullTestSupportSession
implements ITestSupportSession {
    private final LogChannel logChannel;
    private int loggingLevel;

    public NullTestSupportSession(int n, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.loggingLevel = n;
    }

    public void activateMenuEntry(boolean bl) {
        this.log();
    }

    public void flashText(String string, long l) {
        this.log();
    }

    public void flashScreen() {
        this.log();
    }

    public void updateData(String[] stringArray) {
        this.log();
    }

    public int getStatus() {
        this.log();
        return 0;
    }

    private void log() {
        this.logChannel.log(this.loggingLevel, "[NullTestSupportSession] using null session");
    }
}

