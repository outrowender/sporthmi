/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$1;
import de.audi.app.terminalmode.audio.AudioManager$AudioConnectionListenerAdapter;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle$IAudioConnectionListener;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.tghu.command.Command;

final class AudioManager$AudioConnectionHandle
implements IAudioConnectionHandle {
    private final TMAudioConnection audioConnection;
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$AudioConnectionHandle(AudioManager audioManager, TMAudioConnection tMAudioConnection) {
        this.this$0 = audioManager;
        this.audioConnection = tMAudioConnection;
    }

    @Override
    public Command createRequestCommand(boolean bl) {
        return this.this$0.createAudioConnectionRequest(this.audioConnection, bl);
    }

    @Override
    public Command createReleaseCommand() {
        return new ReleaseAudioConnection(this.audioConnection, AudioManager.access$2000(this.this$0));
    }

    @Override
    public void registerListener(IAudioConnectionHandle$IAudioConnectionListener iAudioConnectionHandle$IAudioConnectionListener) {
        this.this$0.addAudioContextListener(new AudioManager$AudioConnectionListenerAdapter(iAudioConnectionHandle$IAudioConnectionListener, this.audioConnection, this.this$0));
    }

    @Override
    public void unregisterListener(IAudioConnectionHandle$IAudioConnectionListener iAudioConnectionHandle$IAudioConnectionListener) {
        this.this$0.removeAudioContextListener(new AudioManager$AudioConnectionListenerAdapter(iAudioConnectionHandle$IAudioConnectionListener, this.audioConnection, this.this$0));
    }

    /* synthetic */ AudioManager$AudioConnectionHandle(AudioManager audioManager, TMAudioConnection tMAudioConnection, AudioManager$1 audioManager$1) {
        this(audioManager, tMAudioConnection);
    }
}

