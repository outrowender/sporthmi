/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface DSITTSListener
extends DSIListener {
    public void updateLanguage(String var1, int var2, int var3, int var4);

    public void updateAvailableLanguages(LanguageVoiceInfo[] var1, int var2);

    public void updateMarkerPassed(int var1, int var2);

    public void responseSetLanguage(short var1, int var2);

    public void responseInit(short var1, int var2);

    public void responseAudioTrigger(short var1, int var2);

    public void updateAudioRequest(int var1, int var2);

    public void responsePlayTone(short var1, int var2);

    public void responseSpeakPrompt(short var1, int var2);

    public void responseSkipSpeaking(short var1, int var2);
}

