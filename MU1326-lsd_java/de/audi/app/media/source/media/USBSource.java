/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;
import de.audi.atip.util.StringUtilities;
import java.util.Iterator;
import java.util.List;

public class USBSource
extends AbstractMediaSource {
    private final int AUDIO_CONNECTION_GENERIC;
    private static final String LOGCLASS;

    public USBSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, String string) {
        super(iMediaTerminal, iMediaDSIPlayerController, n, string);
        this.getTerminal().getMediaPersistence().registerStringProperty("GLOBAL_KEY_IOS_AUTOSTART", "");
        switch (this.getTerminal().getTerminalID()) {
            case 3: 
            case 4: {
                this.AUDIO_CONNECTION_GENERIC = 0;
                break;
            }
            default: {
                this.AUDIO_CONNECTION_GENERIC = 20;
            }
        }
    }

    @Override
    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return this.AUDIO_CONNECTION_GENERIC;
    }

    @Override
    public int getSlotNumberByPartition(int n, int n2) {
        List list = this.getSlots();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int n3;
            ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
            if (iSourceSlot.getDeviceIndex() != n || (n3 = MediaUtils.calculatePartitionIndex(iSourceSlot)) != n2) continue;
            return iSourceSlot.getIndex();
        }
        return -1;
    }

    @Override
    public ISourceSlot getActivatableSlot(ISourceSlot iSourceSlot) {
        if (0 != iSourceSlot.getState()) {
            return iSourceSlot;
        }
        List list = this.getSlots();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ISourceSlot iSourceSlot2 = (ISourceSlot)iterator.next();
            if (iSourceSlot.getDeviceIndex() == iSourceSlot2.getDeviceIndex() && !iSourceSlot.isEmpty() || 1 != iSourceSlot2.getState()) continue;
            return iSourceSlot2;
        }
        return iSourceSlot;
    }

    @Override
    public void activate(ISourceSlot iSourceSlot) {
        if (this.getActiveState() == 2) {
            this.logger.main().log(1078071040, "[%1.activate] [%2] Already active.", (Object)"USBSource", (Object)this);
            return;
        }
        if (iSourceSlot.getMediaType() == 24) {
            try {
                MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iSourceSlot;
                String string = this.getTerminal().getMediaPersistence().getGlobalStringProperty("GLOBAL_KEY_IOS_AUTOSTART");
                if (!StringUtilities.isNullOrEmpty(string)) {
                    this.logger.main().log(-2137614336, "[%1.activate] execute launchMediaApp: %2", (Object)"USBSource", (Object)string);
                    if (!this.getTerminal().getDSIBaseController().launchMediaApp(mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID(), string)) {
                        this.logger.main().log(-1601830656, "[%1.activate] launchMediaApp cannot be executed", (Object)"USBSource");
                    }
                } else {
                    this.logger.main().log(1078071040, "[%1.activate] no App stored for launching", (Object)"USBSource");
                }
            }
            catch (Exception exception) {
                this.logger.main().log(10000, "[%1.activate] iPod slot is not a MediaSourceSlot: %2", (Object)"USBSource", (Throwable)exception);
            }
        }
        super.activate(iSourceSlot);
    }
}

