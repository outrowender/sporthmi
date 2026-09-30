/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelComponent;

public interface ITelAudio
extends ITelComponent {
    public void muteRingtone(boolean var1);

    public void switchMicMuteOn(int var1);

    public void switchMicMuteOff(int var1);

    public void toggelMicMuteState(int var1);
}

