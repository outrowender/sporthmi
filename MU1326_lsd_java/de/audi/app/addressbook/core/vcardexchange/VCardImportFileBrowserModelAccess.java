/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.tghu.filebrowser.IFileBrowserModelAccess;
import org.dsi.ifc.filebrowser.BrowsedFile;

public class VCardImportFileBrowserModelAccess
implements IFileBrowserModelAccess {
    private IHMIServiceApp hmiService;

    public VCardImportFileBrowserModelAccess(IHMIServiceApp iHMIServiceApp) {
        this.hmiService = iHMIServiceApp;
    }

    @Override
    public TiledListModelApp getListModel() {
        return this.hmiService.getTiledListModel(800066048);
    }

    @Override
    public ChoiceModelApp getListModelSelected() {
        return this.hmiService.getChoiceModel(967838208);
    }

    @Override
    public LabelModelApp getPathLabel() {
        return this.hmiService.getLabelModel(2024802816);
    }

    @Override
    public boolean showCwdFullPath() {
        return false;
    }

    @Override
    public ButtonModelApp getSelectSingleButton() {
        return this.hmiService.getButtonModel(1152387584);
    }

    @Override
    public ChoiceModelApp getSelectAllChoice() {
        return this.hmiService.getChoiceModel(1991248384);
    }

    @Override
    public ButtonModelApp getSearchButton() {
        return null;
    }

    @Override
    public ChoiceModelApp getSearchButtonDisableChoice() {
        return null;
    }

    @Override
    public MatchspellerModelApp getSearchSpeller() {
        return null;
    }

    @Override
    public ListModelApp getSearchPreviewList() {
        return null;
    }

    @Override
    public boolean fileSelected(int n, BrowsedFile browsedFile) {
        return true;
    }

    @Override
    public boolean fileFocused(int n, BrowsedFile browsedFile) {
        return true;
    }

    @Override
    public ChoiceModelApp getRootFolderReachedModel() {
        return this.hmiService.getChoiceModel(917506560);
    }

    @Override
    public TiledListModelApp getSearchFilteredList() {
        return null;
    }

    @Override
    public ChoiceModelApp getSearchFilteredListSelected() {
        return null;
    }

    @Override
    public ChoiceModelApp getFileFocused() {
        return this.hmiService.getChoiceModel(883952128);
    }

    @Override
    public ButtonModelApp getImportButton() {
        return this.hmiService.getButtonModel(1169164800);
    }

    @Override
    public ChoiceModelApp getNoFilesAvailable() {
        return this.hmiService.getChoiceModel(1034947072);
    }
}

