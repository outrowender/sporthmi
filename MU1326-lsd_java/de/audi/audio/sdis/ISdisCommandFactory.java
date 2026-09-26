/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.tghu.command.Command;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import org.dsi.ifc.media.AudioRoute;

public interface ISdisCommandFactory {
    default public Command cmdAudioRouteA2LS() {
    }

    default public Command cmdAudioRouteMedia(AudioRoute audioRoute) {
    }

    default public Command cmdStartStreaming() {
    }

    default public Command cmdStopStreaming(boolean bl) {
    }

    default public Command cmdRequestConf(int n) {
    }

    default public Command cmdRequestConf(int n, int n2) {
    }

    default public Command cmdAudioFocus(int n) {
    }

    default public Command cmdFrontAudioFocus(int n) {
    }

    default public Command cmdWaitUntilRadioAudible() {
    }

    default public Command cmdWaitUntilTVAudible() {
    }

    default public Command cmdWaitUntilA2LSAudible() {
    }

    default public Command cmdRegister() {
    }

    default public Command cmdUnregister() {
    }

    default public Command cmdSleep() {
    }

    default public Command cmdSleep(int n) {
    }

    default public Command cmdResponseEnableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public Command cmdRequestA2LS() {
    }

    default public Command cmdReleaseA2LS() {
    }

    default public Command cmdSendA2LSReady(int n) {
    }

    default public Command cmdSendReady(int n) {
    }

    default public Command cmdSendInChange(int n) {
    }

    default public Command cmdReleaseSdisAudioConnections() {
    }

    default public Command cmdSendLockState(VolumeLockState volumeLockState) {
    }

    default public Command cmdFrontLastMode(int n) {
    }

    default public Command cmdDemute() {
    }
}

