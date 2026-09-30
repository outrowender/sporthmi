/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface MMX2SpeechDiagServiceS {
    public void responseErrorSpeech(sClientResponseError var1, MMX2SpeechDiagServiceReply var2) throws MethodException;

    public void responseCommandSDS(sCommandSDS var1, MMX2SpeechDiagServiceReply var2) throws MethodException;

    public void responseCountryRegionVersion(sNavCountryRegionVersion var1, MMX2SpeechDiagServiceReply var2) throws MethodException;

    public void updateAvailableLanguages(LanguageVoiceInfo[] var1, int var2, MMX2SpeechDiagServiceReply var3) throws MethodException;
}

