/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaVideoFormat;
import de.audi.app.media.dsi.media.NullMediaVideoFormat;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public abstract class AbstractVideoFormatSetting
extends AbstractMediaTerminalComponent
implements ChoiceListener {
    public static final int HMI_VIDEO_FORMAT_ID_ORIGINAL;
    public static final int HMI_VIDEO_FORMAT_ID_47_20_CINEMASCOPE_5_4;
    public static final int HMI_VIDEO_FORMAT_ID_14_9_ZOOM;
    public static final int HMI_VIDEO_FORMAT_ID_16_9_WIDESCREEN;
    public static final int HMI_VIDEO_FORMAT_ID_4_3_STANDARD_4_3;
    public static final int HMI_VIDEO_FORMAT_ID_AUTOMATIC;
    public static final int HMI_VIDEO_FORMAT_ID_UNDEFINED;
    protected static final int HMI_LIST_AUTO;
    protected static final int HMI_LIST_4_3;
    protected static final int HMI_LIST_16_9;
    protected static final int HMI_LIST_ZOOM;
    protected static final int HMI_LIST_CINEMA;
    protected static final int HMI_LIST_ORIGINAL;
    private static final String LOGCLASS;
    private final ChoiceModelApp pictureFormatChoiceModel;
    private final int persistenceKey;
    private final int[] supportedVideoFormats;
    private volatile IMediaVideoFormat videoFormatHandler;
    private volatile int currentVideoFormat = 0;

    public AbstractVideoFormatSetting(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, int[] nArray, int n2) {
        super(iMediaTerminal);
        this.pictureFormatChoiceModel = this.getChoiceModel(n);
        this.persistenceKey = n2;
        this.supportedVideoFormats = nArray;
        this.videoFormatHandler = new NullMediaVideoFormat(this.logger.main());
    }

    public void activate(IMediaVideoFormat iMediaVideoFormat) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"AbstractVideoFormatSetting");
        this.pictureFormatChoiceModel.setChoiceListener(this);
        this.pictureFormatChoiceModel.addHint(this.convertVideoFormatToBitcode(this.supportedVideoFormats));
        if (iMediaVideoFormat == null) {
            this.logger.main().log(1078071040, "[%1.activate] VideoFormatHandler is null", (Object)"AbstractVideoFormatSetting");
            this.videoFormatHandler = new NullMediaVideoFormat(this.logger.main());
        } else {
            this.videoFormatHandler = iMediaVideoFormat;
        }
    }

    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"AbstractVideoFormatSetting");
        this.pictureFormatChoiceModel.resetHints();
        this.pictureFormatChoiceModel.setValue(-1);
        this.pictureFormatChoiceModel.setChoiceListener(null);
    }

    public void setActiveVideoFormat(int n) {
        this.currentVideoFormat = this.videoFormatHandler.getHMIVideoFormatID(n);
        this.logger.hmi().log(1078071040, "[%1.setActiveVideoFormat] '%3' ('%2').", (Object)"AbstractVideoFormatSetting", (Object)AbstractVideoFormatSetting.hmiVideoFormatStr(this.currentVideoFormat), (long)n);
        this.pictureFormatChoiceModel.setValue(this.convertHMIId2ListItem(this.currentVideoFormat));
        this.getTerminal().getMediaPersistence().getStorage().persist(this.getTerminal(), this.persistenceKey, this.currentVideoFormat);
    }

    public void requestFormatChange(int n) {
        this.logger.hmi().log(1078071040, "[%1.requestFormatChange] '%2'.", (Object)"AbstractVideoFormatSetting", (Object)AbstractVideoFormatSetting.hmiVideoFormatStr(n));
        this.videoFormatHandler.setVideoFormat(n);
    }

    public void restoreSetting() {
        this.currentVideoFormat = this.getTerminal().getMediaPersistence().getStorage().load(this.getTerminal(), this.persistenceKey, 0, 0, 5);
        this.logger.main().log(1078071040, "[%1.restoreSetting] videoFormat='%2'.", (Object)"AbstractVideoFormatSetting", (Object)AbstractVideoFormatSetting.hmiVideoFormatStr(this.currentVideoFormat));
        this.videoFormatHandler.setVideoFormat(this.currentVideoFormat);
    }

    public void resetSetting(boolean bl) {
        this.logger.main().log(1078071040, "[%1.resetSetting] Reset video format.", (Object)"AbstractVideoFormatSetting");
        this.getTerminal().getMediaPersistence().getStorage().persist(this.getTerminal(), this.persistenceKey, 0);
        if (bl) {
            this.videoFormatHandler.setVideoFormat(0);
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
        this.logger.hmi().log(1078071040, "[%1.itemSelected] '%2'.", (Object)"AbstractVideoFormatSetting", (long)n2);
        this.requestFormatChange(this.convertListItem2HMIId(n2));
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private int convertVideoFormatToBitcode(int[] nArray) {
        int n = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n |= this.getBitcodeValue(nArray[i2]);
        }
        return n;
    }

    public int getHMIVideoFormatID(int n) {
        return this.videoFormatHandler.getHMIVideoFormatID(n);
    }

    public static String hmiVideoFormatStr(int n) {
        switch (n) {
            case 3: {
                return "14:9";
            }
            case 2: {
                return "16:9";
            }
            case 4: {
                return "5:4";
            }
            case 1: {
                return "4:3";
            }
            case 0: {
                return "AUTO";
            }
            case 5: {
                return "ORIGINAL";
            }
        }
        return "UNDEFINED";
    }

    protected abstract int getBitcodeValue(int n) {
    }

    protected abstract int convertListItem2HMIId(int n) {
    }

    protected abstract int convertHMIId2ListItem(int n) {
    }
}

