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

    public TiledListModelApp getListModel() {
        return this.hmiService.getTiledListModel(700463);
    }

    public ChoiceModelApp getListModelSelected() {
        return this.hmiService.getChoiceModel(700473);
    }

    public LabelModelApp getPathLabel() {
        return this.hmiService.getLabelModel(700536);
    }

    public boolean showCwdFullPath() {
        return false;
    }

    public ButtonModelApp getSelectSingleButton() {
        return this.hmiService.getButtonModel(700484);
    }

    public ChoiceModelApp getSelectAllChoice() {
        return this.hmiService.getChoiceModel(700534);
    }

    public ButtonModelApp getSearchButton() {
        return null;
    }

    public ChoiceModelApp getSearchButtonDisableChoice() {
        return null;
    }

    public MatchspellerModelApp getSearchSpeller() {
        return null;
    }

    public ListModelApp getSearchPreviewList() {
        return null;
    }

    public boolean fileSelected(int n, BrowsedFile browsedFile) {
        return true;
    }

    public boolean fileFocused(int n, BrowsedFile browsedFile) {
        return true;
    }

    public ChoiceModelApp getRootFolderReachedModel() {
        return this.hmiService.getChoiceModel(700470);
    }

    public TiledListModelApp getSearchFilteredList() {
        return null;
    }

    public ChoiceModelApp getSearchFilteredListSelected() {
        return null;
    }

    public ChoiceModelApp getFileFocused() {
        return this.hmiService.getChoiceModel(700468);
    }

    public ButtonModelApp getImportButton() {
        return this.hmiService.getButtonModel(700485);
    }

    public ChoiceModelApp getNoFilesAvailable() {
        return this.hmiService.getChoiceModel(700477);
    }
}

