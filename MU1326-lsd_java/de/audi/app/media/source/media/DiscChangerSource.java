/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;

public class DiscChangerSource
extends AbstractMediaSource {
    private static final String LOGCLASS;
    private static final int WILDCARD_MEDIA_ID;
    private volatile boolean wildCardActivation = false;
    private volatile boolean wasWildCardActivation = false;

    public DiscChangerSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, String string) {
        super(iMediaTerminal, iMediaDSIPlayerController, n, string);
    }

    @Override
    public int getAudioConnection(ISourceSlot iSourceSlot) {
        if (this.getTerminal().getAudioManager().hasRearSeatAudioFocusOnly()) {
            switch (iSourceSlot.getContentType()) {
                case 0: {
                    return 306;
                }
            }
            return 305;
        }
        switch (iSourceSlot.getContentType()) {
            case 0: {
                return 24;
            }
        }
        return 23;
    }

    public void setWildCardActivation() {
        this.wildCardActivation = true;
    }

    @Override
    public void activate(ISourceSlot iSourceSlot) {
        if (this.wildCardActivation) {
            this.logger.main().log(1078071040, "[%1.activate] wild card activation.", (Object)"DiscChangerSource");
            this.dsiPlayerController.activate(((MediaSourceSlot)iSourceSlot).getDeviceID(), -1L);
            this.wasWildCardActivation = true;
            this.wildCardActivation = false;
        } else {
            this.logger.main().log(1078071040, "[%1.activate]", (Object)"DiscChangerSource");
            this.wasWildCardActivation = false;
            super.activate(iSourceSlot);
        }
    }

    @Override
    protected ISourceSlot getDefaultEmptySlot(int n) {
        int n2 = n == 0 || n == 1 ? 0 : (n == 2 || n == 3 ? 1 : -1);
        return new MediaSourceSlot(this, 0, n, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 19, n2, "");
    }

    public boolean wasWildCardActivation() {
        return this.wasWildCardActivation;
    }
}

