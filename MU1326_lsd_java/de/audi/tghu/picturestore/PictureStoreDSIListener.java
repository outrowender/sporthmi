/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.picturestore;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.picturestore.PictureStoreDSIDefaultListener;
import de.audi.tghu.picturestore.PictureStoreDSIListener$1;
import de.audi.tghu.picturestore.PictureStoreDSIListener$10;
import de.audi.tghu.picturestore.PictureStoreDSIListener$11;
import de.audi.tghu.picturestore.PictureStoreDSIListener$12;
import de.audi.tghu.picturestore.PictureStoreDSIListener$13;
import de.audi.tghu.picturestore.PictureStoreDSIListener$14;
import de.audi.tghu.picturestore.PictureStoreDSIListener$15;
import de.audi.tghu.picturestore.PictureStoreDSIListener$16;
import de.audi.tghu.picturestore.PictureStoreDSIListener$17;
import de.audi.tghu.picturestore.PictureStoreDSIListener$18;
import de.audi.tghu.picturestore.PictureStoreDSIListener$19;
import de.audi.tghu.picturestore.PictureStoreDSIListener$2;
import de.audi.tghu.picturestore.PictureStoreDSIListener$20;
import de.audi.tghu.picturestore.PictureStoreDSIListener$3;
import de.audi.tghu.picturestore.PictureStoreDSIListener$4;
import de.audi.tghu.picturestore.PictureStoreDSIListener$5;
import de.audi.tghu.picturestore.PictureStoreDSIListener$6;
import de.audi.tghu.picturestore.PictureStoreDSIListener$7;
import de.audi.tghu.picturestore.PictureStoreDSIListener$8;
import de.audi.tghu.picturestore.PictureStoreDSIListener$9;
import de.audi.tghu.picturestore.PictureStoreProxy;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureStoreDSIListener
implements DSIPictureStoreListener,
ICommandResponseSupplier {
    private CommandListManager cmdListMgr;
    private PictureStoreDSIDefaultListener defaultListener;
    private PictureStoreProxy pictureStoreProxy;

    public PictureStoreDSIListener(CommandListManager commandListManager, PictureStoreDSIDefaultListener pictureStoreDSIDefaultListener) {
        this.cmdListMgr = commandListManager;
        this.defaultListener = pictureStoreDSIDefaultListener;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getLogChannel().log(10000, "PictureStoreDSIListener#asyncException errorCode: %2 errorMsg: %1 requestType: %3", (Object)string, (long)n, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$1(this, n, string, n2));
    }

    @Override
    public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#importPictureResult volatileRL: %1 persistentRL: %2 resultCode: %3", (Object)resourceLocator, (Object)resourceLocator2, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$2(this, n, resourceLocator, resourceLocator2, n2));
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#pictureExists rl: %2 doesExist: %1", bl, (Object)resourceLocator);
        CommandResponse.execute(this, new PictureStoreDSIListener$3(this, resourceLocator, bl));
    }

    @Override
    public void freeSlots(int n, int n2) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#freeSlots contextID: %1 numberOfFreeSlots: %2", (long)n, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$4(this, n, n2));
    }

    @Override
    public void getReferencesResult(ResourceLocator resourceLocator, int[] nArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getReferencesResult rl: %1 contextIDs: %2", (Object)resourceLocator, (Object)nArray);
        CommandResponse.execute(this, new PictureStoreDSIListener$5(this, resourceLocator, nArray));
    }

    @Override
    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#deletedPictures rls: %1", (Object)resourceLocatorArray);
        CommandResponse.execute(this, new PictureStoreDSIListener$6(this, resourceLocatorArray));
    }

    @Override
    public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#responseLRUPictures rls: %1 contextIDs: %2", (Object)resourceLocatorArray, (long)n);
        CommandResponse.execute(this, new PictureStoreDSIListener$7(this, n, resourceLocatorArray));
    }

    @Override
    public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listResult rls: %1 index: %2", (Object)resourceLocatorArray, (long)n);
        CommandResponse.execute(this, new PictureStoreDSIListener$8(this, resourceLocatorArray, n));
    }

    @Override
    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listForContextResult contextID: %2 rls: %1 index: %3", (Object)resourceLocatorArray, (long)n, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$9(this, n, resourceLocatorArray, n2));
    }

    @Override
    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listForContextResult rl: %1 attributes: %2 resultCode: %3", (Object)resourceLocator, (Object)pictureAttributeArray, (long)n);
        CommandResponse.execute(this, new PictureStoreDSIListener$10(this, resourceLocator, pictureAttributeArray, n));
    }

    @Override
    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#importPictureFromSourceResult volatileRL: %1 persistentRL: %2 resultCode: %3", (Object)resourceLocator, (Object)resourceLocator2, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$11(this, n, resourceLocator, resourceLocator2, n2));
    }

    @Override
    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#listForContextWithFilterResult contextID: %1 index: %2 ", (long)n, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$12(this, n, resourceLocatorArray, n2));
    }

    @Override
    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getRectanglePicturesGridResult geopictures: %1 ", (Object)geoPictureArray);
        CommandResponse.execute(this, new PictureStoreDSIListener$13(this, geoPictureArray));
    }

    @Override
    public void getAvailableYearsResult(int[] nArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getAvailableYearsResult years: %1 ", (Object)nArray);
        CommandResponse.execute(this, new PictureStoreDSIListener$14(this, nArray));
    }

    @Override
    public void getAvailableMonthsResult(int[] nArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getAvailableMonthsResult years: %1 ", (Object)nArray);
        CommandResponse.execute(this, new PictureStoreDSIListener$15(this, nArray));
    }

    @Override
    public void createFilterSetResult(int n) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#createFilterSetResult filterSetID: %1 ", (long)n);
        CommandResponse.execute(this, new PictureStoreDSIListener$16(this, n));
    }

    @Override
    public void cloneFilterSetResult(int n, int n2) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#cloneFilterSetResult sourceFilterSetID: %1 newFilterSetID: %2 ", (long)n, (long)n2);
        CommandResponse.execute(this, new PictureStoreDSIListener$17(this, n, n2));
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#resetToFactorySettingsResult success: %1 ", (long)n);
        CommandResponse.execute(this, new PictureStoreDSIListener$18(this, n));
    }

    public void invalidData() {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#invalidData called - call reinitializePicutureConfigs");
        this.pictureStoreProxy.reinitializePictureConfigs();
    }

    @Override
    public void getAvailableFoldersResult(int n, String[] stringArray) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#getAvailableFoldersResult contextId: %2 folderNames: %1 ", (Object)stringArray, (long)n);
        CommandResponse.execute(this, new PictureStoreDSIListener$19(this, n, stringArray));
    }

    @Override
    public void countPicturesInContextResult(int n, int n2, int n3) {
        this.getLogChannel().log(-2137614336, "PictureStoreDSIListener#countPicturesInContextResult contextId: %2 filterSetID: %1 count:%3", (long)n2, (long)n, (long)n3);
        CommandResponse.execute(this, new PictureStoreDSIListener$20(this, n, n2, n3));
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public void setPictureStoreProxy(PictureStoreProxy pictureStoreProxy) {
        this.pictureStoreProxy = pictureStoreProxy;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.cmdListMgr.getLogChannel();
    }

    @Override
    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
    }

    @Override
    public void invalidData(int[] nArray, int n) {
    }
}

