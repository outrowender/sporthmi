/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractVideoFormatSetting;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;

public class VideoFormatSettingEvo
extends AbstractVideoFormatSetting {
    public VideoFormatSettingEvo(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, int[] nArray, int n2) {
        super(iMediaTerminal, iMediaDSIPlayerController, n, nArray, n2);
    }

    @Override
    protected int getBitcodeValue(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 8;
            }
            case 4: {
                return 16;
            }
            case 5: {
                return 32;
            }
        }
        return 0;
    }

    @Override
    protected int convertListItem2HMIId(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                if (2 == this.getTerminal().getSourceController().getSelectedSlot().getContentType()) {
                    return 4;
                }
                return 5;
            }
        }
        return 0;
    }

    @Override
    protected int convertHMIId2ListItem(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 4;
            }
        }
        return 0;
    }
}

