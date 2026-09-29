/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import java.util.LinkedList;

public interface IDsiDictationAdapterListener {
    default public void responseSetLanguage(int n) {
    }

    default public void responseSetFallbackLanguage(int n) {
    }

    default public void responseSetUserId(int n) {
    }

    default public void responseActivateDictation(int n) {
    }

    default public void responseStartDictation(int n) {
    }

    default public void responseProcessVoiceData(int n, LinkedList linkedList) {
    }

    default public void responseStopDictation(int n) {
    }

    default public void updateLanguage(String string, String string2) {
    }

    default public void updateUserId(String string) {
    }

    default public void updateActivationState(int n) {
    }

    default public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
    }

    default public void updateDsiAvailability(boolean bl) {
    }
}

