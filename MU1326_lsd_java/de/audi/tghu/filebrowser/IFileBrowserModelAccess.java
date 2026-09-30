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
    public TiledListModelApp getListModel();

    public ChoiceModelApp getListModelSelected();

    public LabelModelApp getPathLabel();

    public ButtonModelApp getSelectSingleButton();

    public ButtonModelApp getImportButton();

    public ChoiceModelApp getFileFocused();

    public ChoiceModelApp getSelectAllChoice();

    public ChoiceModelApp getRootFolderReachedModel();

    public ChoiceModelApp getNoFilesAvailable();

    public ButtonModelApp getSearchButton();

    public ChoiceModelApp getSearchButtonDisableChoice();

    public MatchspellerModelApp getSearchSpeller();

    public ListModelApp getSearchPreviewList();

    public TiledListModelApp getSearchFilteredList();

    public ChoiceModelApp getSearchFilteredListSelected();

    public boolean fileSelected(int var1, BrowsedFile var2);

    public boolean fileFocused(int var1, BrowsedFile var2);

    public boolean showCwdFullPath();
}

