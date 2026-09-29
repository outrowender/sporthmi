/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.info;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceInfo;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoInfo_Status;

public class AppConnectorInfo
extends AbstractCombiConnector
implements CombiBAPServiceInfo {
    private ActiveSource_Status savedActiveSourceStatus;

    public AppConnectorInfo(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    @Override
    public void skipResult(boolean bl) {
        this.logChannel.log(-2137614336, "[AppConnectorInfo#skipResult] called (successful=%1)", bl);
        ((CombiModuleAudio)this.moduleFsg).getDedicatedAudioControlHandler().skipResult(bl);
    }

    @Override
    public void updateTPMemoInfo(short s, short s2, short s3, short s4, String string) {
        Buffer buffer = new Buffer(s).append("/").append(s2);
        Buffer buffer2 = new Buffer(s3).append(":").append(s4);
        this.logChannel.log(-2137614336, "[AppConnectorInfo#updateTPMemoInfo] called (messageNo=%1, messageTime=%2, stationName=%3", (Object)buffer, (Object)buffer2, (Object)string);
        TpMemoInfo_Status tpMemoInfo_Status = new TpMemoInfo_Status();
        tpMemoInfo_Status.tpCounters.currentMsgNumber = s;
        tpMemoInfo_Status.tpCounters.totalMsgNumber = s2;
        tpMemoInfo_Status.messageTime.hour = s3;
        tpMemoInfo_Status.messageTime.minute = s4;
        tpMemoInfo_Status.stationName.setContent(string);
        this.moduleFsg.getBAPFunctionPropertyFSG(26).sendStatusIfChanged(tpMemoInfo_Status);
    }

    @Override
    public void notifyMessagePlaybackActive(boolean bl) {
        this.logChannel.log(-2137614336, "[AppConnectorInfo#notifyMessagePlaybackActive] called (active=%1)", bl);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(16);
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (bl) {
            if (activeSource_Status.sourceType != 12) {
                this.logChannel.log(-2137614336, "[AppConnectorInfo#notifyMessagePlaybackActive] save current audio source settings");
                this.savedActiveSourceStatus = activeSource_Status;
                this.logChannel.log(-2137614336, "[AppConnectorInfo#notifyMessagePlaybackActive] change active audio source to TP memo");
                ActiveSource_Status activeSource_Status2 = new ActiveSource_Status();
                activeSource_Status2.sourceType = 12;
                activeSource_Status2.sourceList_Reference = 0;
                activeSource_Status2.list_State = 0;
                activeSource_Status2.typeOfNumber = 0;
                activeSource_Status2.number = 0;
                bAPFunctionPropertyFSG.sendStatusIfChanged(activeSource_Status2);
            } else {
                this.logChannel.log(-2137614336, "[AppConnectorInfo#notifyMessagePlaybackActive] active source is already set to TP memo");
            }
        } else if (activeSource_Status.sourceType == 12) {
            if (this.savedActiveSourceStatus != null) {
                this.logChannel.log(-2137614336, "[AppConnectorInfo#notifyMessagePlaybackActive] restore active source settings");
                bAPFunctionPropertyFSG.sendStatusIfChanged(this.savedActiveSourceStatus);
            } else {
                this.logChannel.log(10000, "[AppConnectorInfo#notifyMessagePlaybackActive] no active source status for restore available");
            }
        } else {
            this.logChannel.log(-2137614336, "[AppConnectorInfo#notifyMessagePlaybackActive] active source is not TP memo");
        }
    }

    @Override
    public void updateTAMessageRecordingActive(boolean bl) {
        this.logChannel.log(-2137614336, "[AppConnectorInfo#updateTAMessageRecordingActive] active=%1", bl);
        if (bl) {
            ((CombiModuleAudio)this.moduleFsg).getTunerService().updateActiveInfoState(32);
        } else {
            ((CombiModuleAudio)this.moduleFsg).getTunerService().restoreInfoState(32);
        }
    }
}

