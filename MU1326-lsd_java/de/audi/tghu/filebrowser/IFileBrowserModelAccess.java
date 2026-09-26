/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import org.dsi.ifc.filebrowser.BrowsedFile;

public interface IFileBrowserModelAccess {
    default public TiledListModelApp getListModel() {
    }

    default public ChoiceModelApp getListModelSelected() {
    }

    default public LabelModelApp getPathLabel() {
    }

    default public ButtonModelApp getSelectSingleButton() {
    }

    default public ButtonModelApp getImportButton() {
    }

    default public ChoiceModelApp getFileFocused() {
    }

    default public ChoiceModelApp getSelectAllChoice() {
    }

    default public ChoiceModelApp getRootFolderReachedModel() {
    }

    default public ChoiceModelApp getNoFilesAvailable() {
    }

    default public ButtonModelApp getSearchButton() {
    }

    default public ChoiceModelApp getSearchButtonDisableChoice() {
    }

    default public MatchspellerModelApp getSearchSpeller() {
    }

    default public ListModelApp getSearchPreviewList() {
    }

    default public TiledListModelApp getSearchFilteredList() {
    }

    default public ChoiceModelApp getSearchFilteredListSelected() {
    }

    default public boolean fileSelected(int n, BrowsedFile browsedFile) {
    }

    default public boolean fileFocused(int n, BrowsedFile browsedFile) {
    }

    default public boolean showCwdFullPath() {
    }
}

