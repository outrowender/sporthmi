/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;

public class PoiExternalHmiListener
extends AbstractPoiScreenHmiListener
implements ButtonListener {
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final INavigationInputModeManager navigationInputModeManager;

    public PoiExternalHmiListener(NavigationEnv navigationEnv, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, ICommandListFactory iCommandListFactory) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea);
        this.commandListFactory = iCommandListFactory;
        this.navigationInputModeManager = navigationEnv.getInputModeManager();
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    protected void registerAsListener() {
        this.env.getButtonModel(402579).setButtonListener(this);
    }

    public CommandList getStartCommandList() {
        return this.commandListFactory.createCommandList();
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "PoiExternalHmiListener#keyTyped. modelId: %1, keyId: %2 - fire model event", (long)n, (long)n2);
        if (n == 402579) {
            this.env.getChoiceModel(402577).setValue(0);
            this.poiSearchArea.setSearchContext(0);
            this.poiSearchArea.setLocation(null);
            if (this.navigationInputModeManager.getInputMode() == 1) {
                this.env.getChoiceModel(170).setValue(2);
            }
            this.poiManager.startPoiMainScreen(true, false);
        }
        this.env.fireModelEvent(n, n3);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
    }

    public void preparePreviewMap() {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

