/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.picturestore.PictureStoreProvider;
import de.audi.atip.interapp.picturestore.PictureStoreProviderListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.picturestore.PictureStoreDSIDefaultListener;
import de.audi.tghu.picturestore.commands.CloneFilterSetCommand;
import de.audi.tghu.picturestore.commands.CountPicturesInContextCommand;
import de.audi.tghu.picturestore.commands.CreateFilterSetCommand;
import de.audi.tghu.picturestore.commands.DecreaseRefCounterCommand;
import de.audi.tghu.picturestore.commands.DeleteAllPicturesCommand;
import de.audi.tghu.picturestore.commands.DeleteFilterSetCommand;
import de.audi.tghu.picturestore.commands.DeletePicturesCommand;
import de.audi.tghu.picturestore.commands.DeletePicturesFromContextCommand;
import de.audi.tghu.picturestore.commands.DeletePicturesWithFilterSetCommand;
import de.audi.tghu.picturestore.commands.GetAvailableFoldersCommand;
import de.audi.tghu.picturestore.commands.GetAvailableMonthsCommand;
import de.audi.tghu.picturestore.commands.GetAvailableYearsCommand;
import de.audi.tghu.picturestore.commands.GetFreeSlotsCommand;
import de.audi.tghu.picturestore.commands.GetLRUPicturesCommand;
import de.audi.tghu.picturestore.commands.GetPictureAttributesCommand;
import de.audi.tghu.picturestore.commands.GetRectanglePictureGridCommand;
import de.audi.tghu.picturestore.commands.GetReferencesCommand;
import de.audi.tghu.picturestore.commands.ImportPictureCommand;
import de.audi.tghu.picturestore.commands.ImportPictureFromSourceCommand;
import de.audi.tghu.picturestore.commands.IncreaseRefCounterCommand;
import de.audi.tghu.picturestore.commands.ListInAllContextsCommand;
import de.audi.tghu.picturestore.commands.ListInContextCommand;
import de.audi.tghu.picturestore.commands.ListInContextWithFilterCommand;
import de.audi.tghu.picturestore.commands.PictureExistsCommand;
import de.audi.tghu.picturestore.commands.ResetToFactorySettingsCommand;
import de.audi.tghu.picturestore.commands.SetConfigCommand;
import de.audi.tghu.picturestore.commands.SetConfigWithFileTypeCommand;
import de.audi.tghu.picturestore.commands.SetFilterFolderNameCommand;
import de.audi.tghu.picturestore.commands.SetFilterGeoAreaCommand;
import de.audi.tghu.picturestore.commands.SetFilterImportSourceCommand;
import de.audi.tghu.picturestore.commands.SetFilterTimeIntervalCommand;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;

public class PictureStoreProxy
implements PictureStoreProvider {
    private DSIPictureStore dsiPictureStore = null;
    private PictureStoreDSIDefaultListener pictureStoreDefaultListener = null;
    private LogChannel logChannel = null;
    private CommandListManager cmdListMgr = null;
    private IFrameworkAccess framework = null;
    private ArrayList pictureStoreConfigs = new ArrayList(4);
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$ImportPictureCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$PictureExistsCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetFreeSlotsCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetReferencesCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$DeleteAllPicturesCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$DeletePicturesFromContextCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$DeletePicturesCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetLRUPicturesCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$ListInAllContextsCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$ListInContextCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetPictureAttributesCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$SetConfigCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$IncreaseRefCounterCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$DecreaseRefCounterCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$SetConfigWithFileTypeCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$ImportPictureFromSourceCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$DeletePicturesWithFilterSetCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$ListInContextWithFilterCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetRectanglePictureGridCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetAvailableYearsCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetAvailableMonthsCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$CreateFilterSetCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$CloneFilterSetCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$DeleteFilterSetCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$SetFilterImportSourceCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$SetFilterTimeIntervalCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$SetFilterGeoAreaCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$ResetToFactorySettingsCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$GetAvailableFoldersCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$SetFilterFolderNameCommand;
    static /* synthetic */ Class class$de$audi$tghu$picturestore$commands$CountPicturesInContextCommand;

    PictureStoreProxy(IFrameworkAccess iFrameworkAccess, CommandListManager commandListManager, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.cmdListMgr = commandListManager;
        this.logChannel = logChannel;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public void setDSIPictureStore(DSIPictureStore dSIPictureStore) {
        this.dsiPictureStore = dSIPictureStore;
    }

    public DSIPictureStore getDSIPictureStore() {
        return this.dsiPictureStore;
    }

    public void setPictureStoreDSIDefaultHandler(PictureStoreDSIDefaultListener pictureStoreDSIDefaultListener) {
        this.pictureStoreDefaultListener = pictureStoreDSIDefaultListener;
    }

    public PictureStoreDSIDefaultListener getPictureStoreDSIDefaultListener() {
        return this.pictureStoreDefaultListener;
    }

    @Override
    public void importPicture(int n, ResourceLocator resourceLocator, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#importPicture contextID: %3 ResourceLocator: %1 callback: %2", (Object)resourceLocator, (Object)pictureStoreProviderListener, (long)n);
        ImportPictureCommand importPictureCommand = new ImportPictureCommand(this, this.logChannel, n, resourceLocator, bl, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(importPictureCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$ImportPictureCommand == null ? (class$de$audi$tghu$picturestore$commands$ImportPictureCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.ImportPictureCommand")) : class$de$audi$tghu$picturestore$commands$ImportPictureCommand).getName());
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#pictureExists ResourceLocator: %1 callback: %2", (Object)resourceLocator, (Object)pictureStoreProviderListener);
        PictureExistsCommand pictureExistsCommand = new PictureExistsCommand(this, this.logChannel, resourceLocator, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(pictureExistsCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$PictureExistsCommand == null ? (class$de$audi$tghu$picturestore$commands$PictureExistsCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.PictureExistsCommand")) : class$de$audi$tghu$picturestore$commands$PictureExistsCommand).getName());
    }

    @Override
    public void getFreeSlots(int n, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getFreeSlots contextID: %2 callback: %1", (Object)pictureStoreProviderListener, (long)n);
        GetFreeSlotsCommand getFreeSlotsCommand = new GetFreeSlotsCommand(this, n, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getFreeSlotsCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetFreeSlotsCommand == null ? (class$de$audi$tghu$picturestore$commands$GetFreeSlotsCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetFreeSlotsCommand")) : class$de$audi$tghu$picturestore$commands$GetFreeSlotsCommand).getName());
    }

    @Override
    public void getReferences(ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getReferences ResourceLocator: %1 callback: %2", (Object)resourceLocator, (Object)pictureStoreProviderListener);
        GetReferencesCommand getReferencesCommand = new GetReferencesCommand(this, resourceLocator, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getReferencesCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetReferencesCommand == null ? (class$de$audi$tghu$picturestore$commands$GetReferencesCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetReferencesCommand")) : class$de$audi$tghu$picturestore$commands$GetReferencesCommand).getName());
    }

    @Override
    public void deleteAllPictures(int n, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#deleteAllPictures contextID: %2, callback: %1", (Object)pictureStoreProviderListener, (long)n);
        DeleteAllPicturesCommand deleteAllPicturesCommand = new DeleteAllPicturesCommand(this, n, bl, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(deleteAllPicturesCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$DeleteAllPicturesCommand == null ? (class$de$audi$tghu$picturestore$commands$DeleteAllPicturesCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.DeleteAllPicturesCommand")) : class$de$audi$tghu$picturestore$commands$DeleteAllPicturesCommand).getName());
    }

    @Override
    public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#deletePicturesFromContext ResourceLocator[]: %2, callback: %1, contextID: %3", (Object)pictureStoreProviderListener, (Object)resourceLocatorArray, (long)n);
        DeletePicturesFromContextCommand deletePicturesFromContextCommand = new DeletePicturesFromContextCommand(this, n, resourceLocatorArray, bl, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(deletePicturesFromContextCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$DeletePicturesFromContextCommand == null ? (class$de$audi$tghu$picturestore$commands$DeletePicturesFromContextCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.DeletePicturesFromContextCommand")) : class$de$audi$tghu$picturestore$commands$DeletePicturesFromContextCommand).getName());
    }

    @Override
    public void deletePictures(ResourceLocator[] resourceLocatorArray, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#deletePicturesFromContext ResourceLocator[]: %1, callback: %2", (Object)resourceLocatorArray, (Object)pictureStoreProviderListener);
        DeletePicturesCommand deletePicturesCommand = new DeletePicturesCommand(this, resourceLocatorArray, bl, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(deletePicturesCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$DeletePicturesCommand == null ? (class$de$audi$tghu$picturestore$commands$DeletePicturesCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.DeletePicturesCommand")) : class$de$audi$tghu$picturestore$commands$DeletePicturesCommand).getName());
    }

    @Override
    public void getLRUPictures(int n, boolean bl, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getLRUPictures contextID: %2 count: %3 callback: %1", (Object)pictureStoreProviderListener, (long)n, (long)n2);
        GetLRUPicturesCommand getLRUPicturesCommand = new GetLRUPicturesCommand(this, n, bl, n2, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getLRUPicturesCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetLRUPicturesCommand == null ? (class$de$audi$tghu$picturestore$commands$GetLRUPicturesCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetLRUPicturesCommand")) : class$de$audi$tghu$picturestore$commands$GetLRUPicturesCommand).getName());
    }

    @Override
    public void listInAllContexts(int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#listInAllContexts index: %2 count: %3 callback: %1", (Object)pictureStoreProviderListener, (long)n, (long)n2);
        ListInAllContextsCommand listInAllContextsCommand = new ListInAllContextsCommand(this, n, n2, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(listInAllContextsCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$ListInAllContextsCommand == null ? (class$de$audi$tghu$picturestore$commands$ListInAllContextsCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.ListInAllContextsCommand")) : class$de$audi$tghu$picturestore$commands$ListInAllContextsCommand).getName());
    }

    @Override
    public void listInContext(int n, int n2, int n3, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#listInContext index: %2 count: %3 callback: %1", (Object)pictureStoreProviderListener, (long)n2, (long)n3);
        ListInContextCommand listInContextCommand = new ListInContextCommand(this, n, n2, n3, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(listInContextCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$ListInContextCommand == null ? (class$de$audi$tghu$picturestore$commands$ListInContextCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.ListInContextCommand")) : class$de$audi$tghu$picturestore$commands$ListInContextCommand).getName());
    }

    @Override
    public void getPictureAttributes(ResourceLocator resourceLocator, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getPictureAttributes ResourceLocator: %1 scaleWidth: %2 scaleHeight: %3", (Object)resourceLocator, (Object)pictureStoreProviderListener);
        GetPictureAttributesCommand getPictureAttributesCommand = new GetPictureAttributesCommand(this, resourceLocator, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getPictureAttributesCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetPictureAttributesCommand == null ? (class$de$audi$tghu$picturestore$commands$GetPictureAttributesCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetPictureAttributesCommand")) : class$de$audi$tghu$picturestore$commands$GetPictureAttributesCommand).getName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setConfig(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#setConfig contextID: %1 scaleWidth: %2 scaleHeight: %3", (long)n, (long)n3, (long)n4);
        SetConfigCommand setConfigCommand = new SetConfigCommand(this, n, n2, n3, n4);
        Object object = this.pictureStoreConfigs;
        synchronized (object) {
            if (this.pictureStoreConfigs.size() < 10) {
                this.pictureStoreConfigs.add(setConfigCommand);
            }
        }
        object = new CommandList(this.cmdListMgr);
        ((CommandList)object).add(setConfigCommand);
        ((CommandList)object).execute((class$de$audi$tghu$picturestore$commands$SetConfigCommand == null ? (class$de$audi$tghu$picturestore$commands$SetConfigCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetConfigCommand")) : class$de$audi$tghu$picturestore$commands$SetConfigCommand).getName());
    }

    @Override
    public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#increaseRefCounter ResourceLocator: %1 contextID: %2", (Object)resourceLocator, (long)n);
        IncreaseRefCounterCommand increaseRefCounterCommand = new IncreaseRefCounterCommand(this, resourceLocator, n);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(increaseRefCounterCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$IncreaseRefCounterCommand == null ? (class$de$audi$tghu$picturestore$commands$IncreaseRefCounterCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.IncreaseRefCounterCommand")) : class$de$audi$tghu$picturestore$commands$IncreaseRefCounterCommand).getName());
    }

    @Override
    public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#decreaseRefCounter ResourceLocator: %1 contextID: %2", (Object)resourceLocator, (long)n);
        DecreaseRefCounterCommand decreaseRefCounterCommand = new DecreaseRefCounterCommand(this, resourceLocator, n);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(decreaseRefCounterCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$DecreaseRefCounterCommand == null ? (class$de$audi$tghu$picturestore$commands$DecreaseRefCounterCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.DecreaseRefCounterCommand")) : class$de$audi$tghu$picturestore$commands$DecreaseRefCounterCommand).getName());
    }

    @Override
    public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#setConfigWithFileType contextID: %1 scaleWidth: %2 scaleHeight: %3", (long)n, (long)n3, (long)n4);
        SetConfigWithFileTypeCommand setConfigWithFileTypeCommand = new SetConfigWithFileTypeCommand(this, n, n2, n3, n4, n5);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(setConfigWithFileTypeCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$SetConfigWithFileTypeCommand == null ? (class$de$audi$tghu$picturestore$commands$SetConfigWithFileTypeCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetConfigWithFileTypeCommand")) : class$de$audi$tghu$picturestore$commands$SetConfigWithFileTypeCommand).getName());
    }

    @Override
    public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#importPictureFromSource contextID: %2 resourceLocator: %1 importSource: %3", (Object)resourceLocator, (long)n, (long)n2);
        ImportPictureFromSourceCommand importPictureFromSourceCommand = new ImportPictureFromSourceCommand(this, this.logChannel, n, resourceLocator, bl, n2, string, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(importPictureFromSourceCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$ImportPictureFromSourceCommand == null ? (class$de$audi$tghu$picturestore$commands$ImportPictureFromSourceCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.ImportPictureFromSourceCommand")) : class$de$audi$tghu$picturestore$commands$ImportPictureFromSourceCommand).getName());
    }

    @Override
    public void deletePicturesWithFilterSet(int n, int n2, boolean bl, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#deletePicturesWithFilterSet contextID: %1 filterSetID: %2 force: %3", (long)n, (long)n2, bl);
        DeletePicturesWithFilterSetCommand deletePicturesWithFilterSetCommand = new DeletePicturesWithFilterSetCommand(this, n, n2, bl, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(deletePicturesWithFilterSetCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$DeletePicturesWithFilterSetCommand == null ? (class$de$audi$tghu$picturestore$commands$DeletePicturesWithFilterSetCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.DeletePicturesWithFilterSetCommand")) : class$de$audi$tghu$picturestore$commands$DeletePicturesWithFilterSetCommand).getName());
    }

    @Override
    public void listInContextWithFilter(int n, int n2, int n3, int n4, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#listInContextWithFilter contextID: %1 filterSetID: %2 index: %3", (long)n, (long)n2, (long)n3);
        ListInContextWithFilterCommand listInContextWithFilterCommand = new ListInContextWithFilterCommand(this, n, n2, n3, n4, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(listInContextWithFilterCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$ListInContextWithFilterCommand == null ? (class$de$audi$tghu$picturestore$commands$ListInContextWithFilterCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.ListInContextWithFilterCommand")) : class$de$audi$tghu$picturestore$commands$ListInContextWithFilterCommand).getName());
    }

    @Override
    public void getRectanglePicturesGrid(int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getRectanglePicturesGrid contextID: %1 filterSetID: %2 ", (long)n, (long)n2);
        GetRectanglePictureGridCommand getRectanglePictureGridCommand = new GetRectanglePictureGridCommand(this, n, n2, f2, f3, f4, f5, n3, n4, n5, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getRectanglePictureGridCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetRectanglePictureGridCommand == null ? (class$de$audi$tghu$picturestore$commands$GetRectanglePictureGridCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetRectanglePictureGridCommand")) : class$de$audi$tghu$picturestore$commands$GetRectanglePictureGridCommand).getName());
    }

    @Override
    public void getAvailableYears(int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getAvailableYears contextID: %1 timeIntervalFilterType: %2 ", (long)n, (long)n2);
        GetAvailableYearsCommand getAvailableYearsCommand = new GetAvailableYearsCommand(this, n, n2, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getAvailableYearsCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetAvailableYearsCommand == null ? (class$de$audi$tghu$picturestore$commands$GetAvailableYearsCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetAvailableYearsCommand")) : class$de$audi$tghu$picturestore$commands$GetAvailableYearsCommand).getName());
    }

    @Override
    public void getAvailableMonths(int n, int n2, int n3, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getAvailableMonths contextID: %1 year: %2 timeIntervalFilterType: %3 ", (long)n, (long)n2, (long)n3);
        GetAvailableMonthsCommand getAvailableMonthsCommand = new GetAvailableMonthsCommand(this, n, n2, n3, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getAvailableMonthsCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetAvailableMonthsCommand == null ? (class$de$audi$tghu$picturestore$commands$GetAvailableMonthsCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetAvailableMonthsCommand")) : class$de$audi$tghu$picturestore$commands$GetAvailableMonthsCommand).getName());
    }

    @Override
    public void createFilterSet(PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#createFilterSet called");
        CreateFilterSetCommand createFilterSetCommand = new CreateFilterSetCommand(this, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(createFilterSetCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$CreateFilterSetCommand == null ? (class$de$audi$tghu$picturestore$commands$CreateFilterSetCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.CreateFilterSetCommand")) : class$de$audi$tghu$picturestore$commands$CreateFilterSetCommand).getName());
    }

    @Override
    public void cloneFilterSet(int n, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#cloneFilterSet sourceFilterSetID: %1 ", (long)n);
        CloneFilterSetCommand cloneFilterSetCommand = new CloneFilterSetCommand(this, n, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(cloneFilterSetCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$CloneFilterSetCommand == null ? (class$de$audi$tghu$picturestore$commands$CloneFilterSetCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.CloneFilterSetCommand")) : class$de$audi$tghu$picturestore$commands$CloneFilterSetCommand).getName());
    }

    @Override
    public void deleteFilterSet(int n) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#deleteFilterSet filterSetID: %1 ", (long)n);
        DeleteFilterSetCommand deleteFilterSetCommand = new DeleteFilterSetCommand(this, n);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(deleteFilterSetCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$DeleteFilterSetCommand == null ? (class$de$audi$tghu$picturestore$commands$DeleteFilterSetCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.DeleteFilterSetCommand")) : class$de$audi$tghu$picturestore$commands$DeleteFilterSetCommand).getName());
    }

    @Override
    public void setFilterImportSource(int n, int n2) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#setFilterImportSource filterSetID: %1 importSources: %2", (long)n, (long)n2);
        SetFilterImportSourceCommand setFilterImportSourceCommand = new SetFilterImportSourceCommand(this, n, n2);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(setFilterImportSourceCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$SetFilterImportSourceCommand == null ? (class$de$audi$tghu$picturestore$commands$SetFilterImportSourceCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetFilterImportSourceCommand")) : class$de$audi$tghu$picturestore$commands$SetFilterImportSourceCommand).getName());
    }

    @Override
    public void setFilterTimeInterval(int n, int n2, long l, long l2) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#setFilterTimeInterval filterSetID: %1 timeIntervalFilterType: %2", (long)n, (long)n2);
        SetFilterTimeIntervalCommand setFilterTimeIntervalCommand = new SetFilterTimeIntervalCommand(this, n, n2, l, l2);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(setFilterTimeIntervalCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$SetFilterTimeIntervalCommand == null ? (class$de$audi$tghu$picturestore$commands$SetFilterTimeIntervalCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetFilterTimeIntervalCommand")) : class$de$audi$tghu$picturestore$commands$SetFilterTimeIntervalCommand).getName());
    }

    @Override
    public void setFilterGeoArea(int n, float f2, float f3, float f4, float f5) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#setFilterGeoArea filterSetID: %1", (long)n);
        SetFilterGeoAreaCommand setFilterGeoAreaCommand = new SetFilterGeoAreaCommand(this, n, f2, f3, f4, f5);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(setFilterGeoAreaCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$SetFilterGeoAreaCommand == null ? (class$de$audi$tghu$picturestore$commands$SetFilterGeoAreaCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetFilterGeoAreaCommand")) : class$de$audi$tghu$picturestore$commands$SetFilterGeoAreaCommand).getName());
    }

    @Override
    public void resetToFactorySettings(PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#resetToFactorySettings");
        ResetToFactorySettingsCommand resetToFactorySettingsCommand = new ResetToFactorySettingsCommand(this, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(resetToFactorySettingsCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$ResetToFactorySettingsCommand == null ? (class$de$audi$tghu$picturestore$commands$ResetToFactorySettingsCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.ResetToFactorySettingsCommand")) : class$de$audi$tghu$picturestore$commands$ResetToFactorySettingsCommand).getName());
    }

    @Override
    public void getAvailableFolders(int n, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#getAvailableFolders contextID:%1", (long)n);
        GetAvailableFoldersCommand getAvailableFoldersCommand = new GetAvailableFoldersCommand(this, n, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(getAvailableFoldersCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$GetAvailableFoldersCommand == null ? (class$de$audi$tghu$picturestore$commands$GetAvailableFoldersCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.GetAvailableFoldersCommand")) : class$de$audi$tghu$picturestore$commands$GetAvailableFoldersCommand).getName());
    }

    @Override
    public void setFilterFolderName(int n, String string) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#setFilterFolderName filterSetID:%1 folderName:%2", (Object)String.valueOf(n), (Object)string);
        SetFilterFolderNameCommand setFilterFolderNameCommand = new SetFilterFolderNameCommand(this, n, string);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(setFilterFolderNameCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$SetFilterFolderNameCommand == null ? (class$de$audi$tghu$picturestore$commands$SetFilterFolderNameCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetFilterFolderNameCommand")) : class$de$audi$tghu$picturestore$commands$SetFilterFolderNameCommand).getName());
    }

    @Override
    public void countPicturesInContext(int n, int n2, PictureStoreProviderListener pictureStoreProviderListener) {
        this.logChannel.log(-2137614336, "PictureStoreProxy#countPicturesInContext contextID:%1 filterSetID:%2", (long)n, (long)n2);
        CountPicturesInContextCommand countPicturesInContextCommand = new CountPicturesInContextCommand(this, n, n2, pictureStoreProviderListener);
        CommandList commandList = new CommandList(this.cmdListMgr);
        commandList.add(countPicturesInContextCommand);
        commandList.execute((class$de$audi$tghu$picturestore$commands$CountPicturesInContextCommand == null ? (class$de$audi$tghu$picturestore$commands$CountPicturesInContextCommand = PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.CountPicturesInContextCommand")) : class$de$audi$tghu$picturestore$commands$CountPicturesInContextCommand).getName());
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reinitializePictureConfigs() {
        this.logChannel.log(-2137614336, "PictureStoreProxy#reinitializePictureConfigs is called");
        ArrayList arrayList = this.pictureStoreConfigs;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < this.pictureStoreConfigs.size(); ++i2) {
                CommandList commandList = new CommandList(this.cmdListMgr);
                commandList.add((SetConfigCommand)this.pictureStoreConfigs.get(i2));
                commandList.execute((class$de$audi$tghu$picturestore$commands$SetConfigCommand == null ? PictureStoreProxy.class$("de.audi.tghu.picturestore.commands.SetConfigCommand") : class$de$audi$tghu$picturestore$commands$SetConfigCommand).getName());
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

