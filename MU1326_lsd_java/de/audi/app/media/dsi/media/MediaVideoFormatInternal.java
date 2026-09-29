/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaVideoFormat;
import de.audi.atip.log.LogChannel;

public class MediaVideoFormatInternal
implements IMediaVideoFormat {
    private static final String LOGCLASS;
    public static final int HMI_VIDEO_FORMAT_ID_ORIGINAL;
    public static final int HMI_VIDEO_FORMAT_ID_47_20_CINEMASCOPE_5_4;
    public static final int HMI_VIDEO_FORMAT_ID_14_9_ZOOM;
    public static final int HMI_VIDEO_FORMAT_ID_16_9_WIDESCREEN;
    public static final int HMI_VIDEO_FORMAT_ID_4_3_STANDARD_4_3;
    public static final int HMI_VIDEO_FORMAT_ID_AUTOMATIC;
    public static final int HMI_VIDEO_FORMAT_ID_UNDEFINED;
    protected final LogChannel logger;
    private final IMediaDSIPlayerController dsiPlayerController;

    public MediaVideoFormatInternal(LogChannel logChannel, IMediaDSIPlayerController iMediaDSIPlayerController) {
        this.logger = logChannel;
        this.dsiPlayerController = iMediaDSIPlayerController;
    }

    @Override
    public boolean setVideoFormat(int n) {
        return this.dsiPlayerController.setVideoFormat(MediaVideoFormatInternal.getDSIVideoFormatID(n));
    }

    private static int getDSIVideoFormatID(int n) {
        switch (n) {
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 4: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 0: {
                return 5;
            }
            case 5: {
                return 6;
            }
        }
        return 5;
    }

    @Override
    public int getHMIVideoFormatID(int n) {
        switch (n) {
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 4: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 5: {
                return 0;
            }
            case 6: {
                return 5;
            }
        }
        return -1;
    }
}

