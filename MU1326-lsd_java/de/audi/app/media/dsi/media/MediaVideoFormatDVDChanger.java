/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.dsi.media.IMediaVideoFormat;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;
import de.audi.atip.log.LogChannel;

public class MediaVideoFormatDVDChanger
implements IMediaVideoFormat,
IDisplayManagerServiceListener {
    private static final String LOGCLASS;
    protected final LogChannel logger;
    private final AbstractMediaPlayer dvdPlayer;
    private final IMediaTerminal terminal;
    private volatile IDisplayManagerService displayManagerService;
    private volatile int requestedFormat;
    private volatile boolean videoComponentStarted = false;
    private int srcWidth;
    private int srcHeight;
    private int srcX;
    private int srcY;

    public MediaVideoFormatDVDChanger(LogChannel logChannel, IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer) {
        this.logger = logChannel;
        this.dvdPlayer = abstractMediaPlayer;
        this.terminal = iMediaTerminal;
    }

    public void setDisplayManagerService(IDisplayManagerService iDisplayManagerService) {
        this.displayManagerService = iDisplayManagerService;
    }

    public int getRatioToVideoFormat(int n) {
        this.logger.log(1078071040, "[%1.getRatioToVideoFormat] HMI video format=%2", (Object)"MediaVideoFormatDVDChanger", (long)n);
        switch (n) {
            case 0: {
                return 1;
            }
            case 3: {
                return 4;
            }
            case 2: {
                return 1;
            }
            case 4: {
                return 3;
            }
            case 1: {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public boolean setVideoFormat(int n) {
        this.logger.log(1078071040, "[%1.setVideoFormat] mgr: '%2'", (Object)"MediaVideoFormatDVDChanger", (Object)this.displayManagerService);
        if (this.displayManagerService != null) {
            this.setFormat(n);
            this.logger.log(1078071040, "[%1.setVideoFormat] displayableID=: '%2'", (Object)"MediaVideoFormatDVDChanger", (long)this.displayManagerService.getCurrentDisplayable());
            this.videoComponentStarted = this.displayManagerService.getCurrentDisplayable() == 34;
            this.logger.log(10000, "[%2.setVideoFormat] videoComponentStarted=: '%1'", this.videoComponentStarted, (Object)"MediaVideoFormatDVDChanger");
            if (this.videoComponentStarted) {
                this.logger.log(1078071040, "[%1.setVideoFormat] component started", (Object)"MediaVideoFormatDVDChanger");
                this.displayManagerService.setCropping(34, this.getRatioToVideoFormat(n), this.srcX, this.srcY, this.srcWidth, this.srcHeight, this);
            }
            this.requestedFormat = n;
            return true;
        }
        return false;
    }

    @Override
    public void setCroppingResult(int n) {
        if (n == 1) {
            this.dvdPlayer.updateVideoFormat(this.requestedFormat);
        }
    }

    @Override
    public int getHMIVideoFormatID(int n) {
        return n;
    }

    private void setFormat(int n) {
        block0 : switch (this.terminal.getFramework().getScreenRes()) {
            case 1: {
                this.srcX = 0;
                this.srcY = 0;
                this.srcWidth = 800;
                this.srcHeight = 480;
                break;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        this.srcX = 0;
                        this.srcY = 0;
                        this.srcWidth = 1024;
                        this.srcHeight = 576;
                        break block0;
                    }
                    case 1: {
                        this.srcX = 0;
                        this.srcY = 0;
                        this.srcWidth = 1024;
                        this.srcHeight = 576;
                        break block0;
                    }
                    case 2: {
                        this.srcX = 128;
                        this.srcY = 0;
                        this.srcWidth = 768;
                        this.srcHeight = 576;
                        break block0;
                    }
                    case 3: {
                        this.srcX = 0;
                        this.srcY = 48;
                        this.srcWidth = 1024;
                        this.srcHeight = 480;
                        break block0;
                    }
                    case 4: {
                        this.srcX = 0;
                        this.srcY = 70;
                        this.srcWidth = 1024;
                        this.srcHeight = 436;
                        break block0;
                    }
                }
                this.srcX = 0;
                this.srcY = 0;
                this.srcWidth = 1024;
                this.srcHeight = 480;
                break;
            }
            case 3: {
                this.srcX = 0;
                this.srcY = 0;
                this.srcWidth = 1280;
                this.srcHeight = 540;
                break;
            }
            case 4: {
                if (this.terminal.getFramework().isEvoHighMMIKombi()) {
                    this.srcX = 0;
                    this.srcY = 0;
                    this.srcWidth = 640;
                    this.srcHeight = 360;
                    break;
                }
                this.srcX = 0;
                this.srcY = 0;
                this.srcWidth = 1440;
                this.srcHeight = 540;
                break;
            }
            case 5: {
                this.srcX = 0;
                this.srcY = 0;
                this.srcWidth = 1680;
                this.srcHeight = 580;
                break;
            }
            case 6: {
                this.srcX = 0;
                this.srcY = 0;
                this.srcWidth = 1920;
                this.srcHeight = 580;
                break;
            }
            default: {
                this.srcWidth = 0;
                this.srcHeight = 0;
            }
        }
    }

    @Override
    public void activeComponentChanged(int n) {
        this.logger.log(1078071040, "[%1.activeComponentChanged] displayableID=: '%2'", (Object)"MediaVideoFormatDVDChanger", (long)n);
        if (n == 34) {
            if (!this.videoComponentStarted) {
                this.logger.log(1078071040, "[%1.activeComponentChanged] videoComponentStarted set Cropping", (Object)"MediaVideoFormatDVDChanger");
                this.displayManagerService.setCropping(34, this.getRatioToVideoFormat(this.requestedFormat), this.srcX, this.srcY, this.srcWidth, this.srcHeight, this);
                this.videoComponentStarted = true;
            }
        } else {
            this.logger.log(1078071040, "[%1.activeComponentChanged] videoComponent not started", (Object)"MediaVideoFormatDVDChanger");
            this.videoComponentStarted = false;
        }
    }
}

