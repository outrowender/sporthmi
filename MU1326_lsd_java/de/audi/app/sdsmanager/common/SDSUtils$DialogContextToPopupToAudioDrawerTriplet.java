/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
import de.esolutions.fw.util.commons.Buffer;

public class SDSUtils$DialogContextToPopupToAudioDrawerTriplet {
    public final int dialogContext;
    public final int popupMapping;
    public final AudioDrawerContext$Source audioDrawerContextSource;
    public static final SDSUtils$DialogContextToPopupToAudioDrawerTriplet[] TRIPLET_DATA = new SDSUtils$DialogContextToPopupToAudioDrawerTriplet[]{new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(0, 100, AudioDrawerContext.SOURCE_SDS_MAIN), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(1, 80, AudioDrawerContext.SOURCE_SDS_ADB), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(2, 81, AudioDrawerContext.SOURCE_SDS_MEDIA), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(3, 82, AudioDrawerContext.SOURCE_SDS_MESSAGING), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(4, 84, AudioDrawerContext.SOURCE_SDS_NAVI), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(5, 83, AudioDrawerContext.SOURCE_SDS_NAVI_ASIA_CNTW), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(6, 85, AudioDrawerContext.SOURCE_SDS_NAVI_POI_ONLINE), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(7, 86, AudioDrawerContext.SOURCE_SDS_PHONE), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(8, 87, AudioDrawerContext.SOURCE_SDS_RHMI), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(9, 88, AudioDrawerContext.SOURCE_SDS_TUNER), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(10, 89, AudioDrawerContext.SOURCE_SDS_NAVI_ASIA_JP), new SDSUtils$DialogContextToPopupToAudioDrawerTriplet(11, 90, AudioDrawerContext.SOURCE_SDS_NAVI_ASIA_KR)};

    private SDSUtils$DialogContextToPopupToAudioDrawerTriplet(int n, int n2, AudioDrawerContext$Source audioDrawerContext$Source) {
        this.dialogContext = n;
        this.popupMapping = n2;
        this.audioDrawerContextSource = audioDrawerContext$Source;
    }

    public String toString() {
        return new Buffer().append("[dialogCtxt=").append(this.dialogContext).append(", popupMappingID=").append(this.popupMapping).append(", audioDrawerCtxt=").append(this.audioDrawerContextSource).append("]").toString();
    }
}

