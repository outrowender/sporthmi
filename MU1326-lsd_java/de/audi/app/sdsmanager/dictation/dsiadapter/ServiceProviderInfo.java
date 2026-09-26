/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.online.DictationValueSentence;

public final class ServiceProviderInfo {
    private final boolean isValid;
    private final int voiceSourceID;
    private final String voiceSourceName;
    private final int voiceRecognizerAudioFormat;
    private final String imageVoiceUrl;
    private final String imageVoiceCheckSum;

    public ServiceProviderInfo() {
        this.isValid = false;
        this.voiceSourceID = 0;
        this.voiceSourceName = "";
        this.voiceRecognizerAudioFormat = 0;
        this.imageVoiceUrl = "";
        this.imageVoiceCheckSum = "";
    }

    ServiceProviderInfo(DictationValueSentence dictationValueSentence) {
        this.isValid = true;
        this.voiceSourceID = dictationValueSentence.getVoiceSourceID();
        this.voiceSourceName = dictationValueSentence.getVoiceSourceName();
        this.voiceRecognizerAudioFormat = dictationValueSentence.getVoiceRecognizerAudioFormat();
        this.imageVoiceUrl = dictationValueSentence.getImageVoiceUrl();
        this.imageVoiceCheckSum = dictationValueSentence.getImageVoiceCheckSum();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public int getVoiceSourceID() {
        return this.voiceSourceID;
    }

    public String getVoiceSourceName() {
        return this.voiceSourceName;
    }

    public int getVoiceRecognizerAudioFormat() {
        return this.voiceRecognizerAudioFormat;
    }

    public String getImageVoiceUrl() {
        return this.imageVoiceUrl;
    }

    public String getImageVoiceCheckSum() {
        return this.imageVoiceCheckSum;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ServiceProviderInfo {");
        buffer.append("isValid = ").append(this.isValid);
        buffer.append(", voiceSourceID = ").append(this.voiceSourceID);
        buffer.append(", voiceSourceName = ").append(this.voiceSourceName);
        buffer.append(", voiceRecognizerAudioFormat = ").append(this.voiceRecognizerAudioFormat);
        buffer.append(", imageVoiceUrl = ").append(this.imageVoiceUrl);
        buffer.append(", imageVoiceCheckSum = ").append(this.imageVoiceCheckSum);
        buffer.append('}');
        return buffer.toString();
    }

    public boolean equals(Object object) {
        boolean bl = false;
        try {
            ServiceProviderInfo serviceProviderInfo = (ServiceProviderInfo)object;
            bl = serviceProviderInfo.isValid() == this.isValid() && serviceProviderInfo.getImageVoiceCheckSum().equals(this.getImageVoiceCheckSum()) && serviceProviderInfo.getImageVoiceUrl().equals(this.getImageVoiceUrl()) && serviceProviderInfo.getVoiceRecognizerAudioFormat() == this.getVoiceRecognizerAudioFormat() && serviceProviderInfo.getVoiceSourceID() == this.getVoiceSourceID() && serviceProviderInfo.getVoiceSourceName().equals(this.getVoiceSourceName());
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return this.getVoiceSourceName().hashCode();
    }
}

