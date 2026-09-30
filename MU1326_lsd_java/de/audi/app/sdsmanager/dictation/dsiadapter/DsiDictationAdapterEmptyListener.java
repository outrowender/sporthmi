/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import java.util.LinkedList;

public class DsiDictationAdapterEmptyListener
implements IDsiDictationAdapterListener {
    public void responseSetLanguage(int n) {
    }

    public void responseSetFallbackLanguage(int n) {
    }

    public void responseSetUserId(int n) {
    }

    public void responseActivateDictation(int n) {
    }

    public void responseStartDictation(int n) {
    }

    public void responseProcessVoiceData(int n, LinkedList linkedList) {
    }

    public void responseStopDictation(int n) {
    }

    public void updateLanguage(String string, String string2) {
    }

    public void updateUserId(String string) {
    }

    public void updateActivationState(int n) {
    }

    public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
    }

    public void updateDsiAvailability(boolean bl) {
    }
}

