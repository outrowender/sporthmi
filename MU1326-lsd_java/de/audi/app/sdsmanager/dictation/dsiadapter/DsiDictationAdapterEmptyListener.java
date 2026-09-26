/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import java.util.LinkedList;

public class DsiDictationAdapterEmptyListener
implements IDsiDictationAdapterListener {
    @Override
    public void responseSetLanguage(int n) {
    }

    @Override
    public void responseSetFallbackLanguage(int n) {
    }

    @Override
    public void responseSetUserId(int n) {
    }

    @Override
    public void responseActivateDictation(int n) {
    }

    @Override
    public void responseStartDictation(int n) {
    }

    @Override
    public void responseProcessVoiceData(int n, LinkedList linkedList) {
    }

    @Override
    public void responseStopDictation(int n) {
    }

    @Override
    public void updateLanguage(String string, String string2) {
    }

    @Override
    public void updateUserId(String string) {
    }

    @Override
    public void updateActivationState(int n) {
    }

    @Override
    public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
    }
}

