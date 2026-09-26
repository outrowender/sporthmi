/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class VideoNormSetting
extends AbstractMediaTerminalComponent
implements ChoiceListener {
    public static final int HMI_VIDEO_NORM_ID_NTSC;
    public static final int HMI_VIDEO_NORM_ID_PAL;
    public static final int HMI_VIDEO_NORM_ID_AUTOMATIC;
    public static final int HMI_VIDEO_NORM_ID_UNDEFINED;
    private static final String LOGCLASS;
    private final IMediaDSIPlayerController dsiPlayer;
    private final ChoiceModelApp videoNormChoiceModel;
    private final int persistenceKey;
    private volatile int currentVideoNorm = 0;

    public VideoNormSetting(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, int n2) {
        super(iMediaTerminal);
        this.dsiPlayer = iMediaDSIPlayerController;
        this.videoNormChoiceModel = this.getChoiceModel(n);
        this.persistenceKey = n2;
    }

    public void activate() {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"VideoNormSetting");
        this.videoNormChoiceModel.setChoiceListener(this);
    }

    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"VideoNormSetting");
        this.videoNormChoiceModel.setValue(-1);
        this.videoNormChoiceModel.setChoiceListener(null);
    }

    public void setActiveVideoNorm(int n) {
        this.currentVideoNorm = VideoNormSetting.getHMIVideoNormID(n);
        this.logger.hmi().log(1078071040, "[%1.setActiveVideoNorm] '%3' ('%2').", (Object)"VideoNormSetting", (Object)VideoNormSetting.hmiVideoNormStr(this.currentVideoNorm), (long)n);
        this.videoNormChoiceModel.setValue(this.currentVideoNorm);
        this.getTerminal().getMediaPersistence().getStorage().persist(this.getTerminal(), this.persistenceKey, this.currentVideoNorm);
    }

    public void restoreSetting() {
        this.currentVideoNorm = this.getTerminal().getMediaPersistence().getStorage().load(this.getTerminal(), this.persistenceKey, 0, 0, 2);
        this.logger.main().log(1078071040, "[%1.restoreSetting] '%2'.", (Object)"VideoNormSetting", (Object)VideoNormSetting.hmiVideoNormStr(this.currentVideoNorm));
        this.dsiPlayer.setVideoNorm(VideoNormSetting.getDSIVideoNormID(this.currentVideoNorm));
    }

    public void resetSetting(boolean bl) {
        this.logger.main().log(1078071040, "[%1.resetSetting] Reset video norm.", (Object)"VideoNormSetting");
        this.getTerminal().getMediaPersistence().getStorage().persist(this.getTerminal(), this.persistenceKey, 0);
        if (bl) {
            this.dsiPlayer.setVideoNorm(VideoNormSetting.getDSIVideoNormID(0));
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi().log(1078071040, "[%1.itemSelected] '%2'.", (Object)"VideoNormSetting", (Object)VideoNormSetting.hmiVideoNormStr(n2));
        this.dsiPlayer.setVideoNorm(VideoNormSetting.getDSIVideoNormID(n2));
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public static String hmiVideoNormStr(int n) {
        switch (n) {
            case 0: {
                return "AUTO";
            }
            case 2: {
                return "NTSC";
            }
            case 1: {
                return "PAL";
            }
        }
        return "UNDEFINED";
    }

    public static int getDSIVideoNormID(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 3;
    }

    public static int getHMIVideoNormID(int n) {
        switch (n) {
            case 3: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return -1;
    }
}

