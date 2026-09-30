/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AudioState_StatusAck
implements StatusAckProperty {
    public int currentAudioSource;
    public static final int CURRENT_AUDIO_SOURCE_TOTAL_MUTE_ADDED_IN_DF3_1 = 7;
    public static final int CURRENT_AUDIO_SOURCE_HU_PHONE = 6;
    public static final int CURRENT_AUDIO_SOURCE_HU_INTERNAL = 5;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_CALL = 4;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_CALL_HIGH_PRIORITY = 3;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_VOICE_PROMPT = 2;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_VOICE_PROMPT_HIGH_PRIORITY = 1;
    public static final int CURRENT_AUDIO_SOURCE_UNKNOWN_DEFAULT_VALUE_AFTER_STARTUP = 0;
    public int audioRequest;
    public static final int AUDIO_REQUEST_TOTAL_MUTE_ADDED_IN_DF3_1 = 7;
    public static final int AUDIO_REQUEST_E_CALL_BOX_CALL_ADDED_IN_DF3_2 = 4;
    public static final int AUDIO_REQUEST_E_CALL_BOX_CALL_HIGH_PRIORITY_ADDED_IN_DF3_2 = 3;
    public static final int AUDIO_REQUEST_VOICE_PROMPT = 2;
    public static final int AUDIO_REQUEST_VOICE_PROMPT_HIGH_PRIORITY = 1;
    public static final int AUDIO_REQUEST_NO_AUDIO_REQUEST_PENDING_DEFAULT = 0;

    public AudioState_StatusAck() {
        this.internalReset();
        this.customInitialization();
    }

    public AudioState_StatusAck(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentAudioSource = 0;
        this.audioRequest = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AudioState_StatusAck audioState_StatusAck = (AudioState_StatusAck)bAPEntity;
        return this.currentAudioSource == audioState_StatusAck.currentAudioSource && this.audioRequest == audioState_StatusAck.audioRequest;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioState_StatusAck");
        stringBuffer.append("\n - currentAudioSource:").append(this.currentAudioSource);
        stringBuffer.append("\n - audioRequest:").append(this.audioRequest);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.currentAudioSource);
        bitStream.pushByte((byte)this.audioRequest);
    }

    public void deserialize(BitStream bitStream) {
        this.currentAudioSource = bitStream.popFrontByte();
        this.audioRequest = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 16;
    }

    public int getFunctionId() {
        return AudioState_StatusAck.functionId();
    }
}

