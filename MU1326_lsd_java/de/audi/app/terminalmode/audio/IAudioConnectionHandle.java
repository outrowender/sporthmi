/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.tghu.command.Command;

public interface IAudioConnectionHandle {
    public Command createRequestCommand(boolean var1);

    public Command createReleaseCommand();

    public void registerListener(IAudioConnectionListener var1);

    public void unregisterListener(IAudioConnectionListener var1);

    public static interface IAudioConnectionListener {
        public void onStart();

        public void onResume();

        public void onPause();

        public void onPauseByMute();

        public void onStopped();

        public void onFadedIn();

        public void onError();
    }
}

