/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class NullETCTTSSpeakService
extends NullService
implements TTSSingleSpeakService {
    protected NullETCTTSSpeakService(LogChannel logChannel) {
        super(logChannel, -1601830656, "TTSService");
    }

    @Override
    public void speak(String string) {
        this.log(new Buffer("speak():").append(string).toString());
    }

    @Override
    public void abortSpeaking() {
        this.log("abortSpeaking()");
    }
}

