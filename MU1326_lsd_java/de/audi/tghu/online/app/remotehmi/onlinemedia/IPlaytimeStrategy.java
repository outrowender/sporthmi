/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;

public interface IPlaytimeStrategy {
    public void updatePlayPosition(int var1, int var2);

    public void updateBufferPosition(IOnlineMediaSession var1);
}

