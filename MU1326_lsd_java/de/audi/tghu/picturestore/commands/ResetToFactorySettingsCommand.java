/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore.commands;

import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.commands.AbstractPictureStoreCommand;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class ResetToFactorySettingsCommand
extends AbstractPictureStoreCommand {
    private PictureStoreProxy psp = null;
    private final PictureStoreProviderListener callback;

    public ResetToFactorySettingsCommand(PictureStoreProxy pictureStoreProxy, PictureStoreProviderListener pictureStoreProviderListener) {
        super(pictureStoreProxy);
        this.psp = pictureStoreProxy;
        this.callback = pictureStoreProviderListener;
    }

    public void execute() {
        DSIPictureStore dSIPictureStore = this.psp.getDSIPictureStore();
        if (dSIPictureStore != null) {
            dSIPictureStore.resetToFactorySettings();
        }
    }

    public void resetToFactorySettingsResult(int n) {
        this.callback.resetToFactorySettingsResult(n);
        this.commandList.commandFinished();
    }

    public void invalidData(int[] nArray, int n) {
    }
}

