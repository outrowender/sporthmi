/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.auxaudiostream;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.DirectFadeToAudioConnectionHandler;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.source.IActivationContext;
import de.esolutions.fw.util.commons.Buffer;

public class AudioStreamContent
extends AbstractMediaContent {
    private static final String LOGCLASS = "AudioStreamContent";
    private final DirectFadeToAudioConnectionHandler audioConnectionHandler;

    public AudioStreamContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal) {
        super(5, iContentContext, iMediaTerminal);
        this.audioConnectionHandler = new DirectFadeToAudioConnectionHandler(iMediaTerminal);
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        super.activate(iActivationContext);
        this.getTerminal().getAudioManager().requestAudio(iActivationContext.getSlot().getSource().getAudioConnection(iActivationContext.getSlot()), true);
        this.getTerminal().getAudioManager().releaseVolumelock("AUX activated");
        this.getTerminal().getAudioManager().addAudioContextListener(this.audioConnectionHandler);
        this.notifyContentActivationFinished();
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.getTerminal().getAudioManager().removeAudioContextListener(this.audioConnectionHandler);
        super.deactivate();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

