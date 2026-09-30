/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface MMX2SpeechDiagServiceC {
    public void responseErrorSpeech(sClientResponseError var1) throws MethodException;

    public void responseCommandSDS(sCommandSDS var1) throws MethodException;

    public void responseCountryRegionVersion(sNavCountryRegionVersion var1) throws MethodException;

    public void updateAvailableLanguages(LanguageVoiceInfo[] var1, int var2) throws MethodException;
}

