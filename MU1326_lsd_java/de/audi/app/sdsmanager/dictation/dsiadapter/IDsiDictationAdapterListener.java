/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import java.util.LinkedList;

public interface IDsiDictationAdapterListener {
    public void responseSetLanguage(int var1);

    public void responseSetFallbackLanguage(int var1);

    public void responseSetUserId(int var1);

    public void responseActivateDictation(int var1);

    public void responseStartDictation(int var1);

    public void responseProcessVoiceData(int var1, LinkedList var2);

    public void responseStopDictation(int var1);

    public void updateLanguage(String var1, String var2);

    public void updateUserId(String var1);

    public void updateActivationState(int var1);

    public void updateServiceProviderInfo(ServiceProviderInfo var1);

    public void updateDsiAvailability(boolean var1);
}

