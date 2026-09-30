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

    public void asyncException(final int n, final String string, final int n2) {
        this.getLogChannel().log(10000, "PictureStoreDSIListener#asyncException errorCode: %2 errorMsg: %1 requestType: %3", (Object)string, (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#asyncException CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).asyncException(n, string, n2);
            }
        });
    }

    public void importPictureResult(final int n, final ResourceLocator resourceLocator, final ResourceLocator resourceLocator2, final int n2) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#importPictureResult volatileRL: %1 persistentRL: %2 resultCode: %3", (Object)resourceLocator, (Object)resourceLocator2, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#importPictureResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).importPictureResult(n, resourceLocator, resourceLocator2, n2);
            }
        });
    }

    public void pictureExists(final ResourceLocator resourceLocator, final boolean bl) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#pictureExists rl: %2 doesExist: %1", bl, (Object)resourceLocator);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#pictureExists CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).pictureExists(resourceLocator, bl);
            }
        });
    }

    public void freeSlots(final int n, final int n2) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#freeSlots contextID: %1 numberOfFreeSlots: %2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#freeSlots CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).freeSlots(n, n2);
            }
        });
    }

    public void getReferencesResult(final ResourceLocator resourceLocator, final int[] nArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#getReferencesResult rl: %1 contextIDs: %2", (Object)resourceLocator, (Object)nArray);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#getReferencesResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).getReferencesResult(resourceLocator, nArray);
            }
        });
    }

    public void deletedPictures(final ResourceLocator[] resourceLocatorArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#deletedPictures rls: %1", (Object)resourceLocatorArray);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#deletedPictures CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).deletedPictures(resourceLocatorArray);
            }
        });
    }

    public void responseLRUPictures(final int n, final ResourceLocator[] resourceLocatorArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#responseLRUPictures rls: %1 contextIDs: %2", (Object)resourceLocatorArray, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#responseLRUPictures CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).responseLRUPictures(n, resourceLocatorArray);
            }
        });
    }

    public void listResult(final ResourceLocator[] resourceLocatorArray, final int n) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#listResult rls: %1 index: %2", (Object)resourceLocatorArray, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).listResult(resourceLocatorArray, n);
            }
        });
    }

    public void listForContextResult(final int n, final ResourceLocator[] resourceLocatorArray, final int n2) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextResult contextID: %2 rls: %1 index: %3", (Object)resourceLocatorArray, (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).listForContextResult(n, resourceLocatorArray, n2);
            }
        });
    }

    public void getPictureAttributesResult(final ResourceLocator resourceLocator, final PictureAttribute[] pictureAttributeArray, final int n) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextResult rl: %1 attributes: %2 resultCode: %3", (Object)resourceLocator, (Object)pictureAttributeArray, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).getPictureAttributesResult(resourceLocator, pictureAttributeArray, n);
            }
        });
    }

    public void importPictureFromSourceResult(final int n, final ResourceLocator resourceLocator, final ResourceLocator resourceLocator2, final int n2) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#importPictureFromSourceResult volatileRL: %1 persistentRL: %2 resultCode: %3", (Object)resourceLocator, (Object)resourceLocator2, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#importPictureFromSourceResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).importPictureFromSourceResult(n, resourceLocator, resourceLocator2, n2);
            }
        });
    }

    public void listForContextWithFilterResult(final int n, final ResourceLocator[] resourceLocatorArray, final int n2) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextWithFilterResult contextID: %1 index: %2 ", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#listForContextWithFilterResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).listForContextWithFilterResult(n, resourceLocatorArray, n2);
            }
        });
    }

    public void getRectanglePicturesGridResult(final GeoPicture[] geoPictureArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#getRectanglePicturesGridResult geopictures: %1 ", (Object)geoPictureArray);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#getRectanglePicturesGridResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).getRectanglePicturesGridResult(geoPictureArray);
            }
        });
    }

    public void getAvailableYearsResult(final int[] nArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#getAvailableYearsResult years: %1 ", (Object)nArray);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#getAvailableYearsResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).getAvailableYearsResult(nArray);
            }
        });
    }

    public void getAvailableMonthsResult(final int[] nArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#getAvailableMonthsResult years: %1 ", (Object)nArray);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#getAvailableMonthsResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).getAvailableMonthsResult(nArray);
            }
        });
    }

    public void createFilterSetResult(final int n) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#createFilterSetResult filterSetID: %1 ", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#createFilterSetResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).createFilterSetResult(n);
            }
        });
    }

    public void cloneFilterSetResult(final int n, final int n2) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#cloneFilterSetResult sourceFilterSetID: %1 newFilterSetID: %2 ", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#cloneFilterSetResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).cloneFilterSetResult(n, n2);
            }
        });
    }

    public void resetToFactorySettingsResult(final int n) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#resetToFactorySettingsResult success: %1 ", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#resetToFactorySettingsResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).resetToFactorySettingsResult(n);
            }
        });
    }

    public void invalidData() {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#invalidData called - call reinitializePicutureConfigs");
        this.pictureStoreProxy.reinitializePictureConfigs();
    }

    public void getAvailableFoldersResult(final int n, final String[] stringArray) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#getAvailableFoldersResult contextId: %2 folderNames: %1 ", (Object)stringArray, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#getAvailableFoldersResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).getAvailableFoldersResult(n, stringArray);
            }
        });
    }

    public void countPicturesInContextResult(final int n, final int n2, final int n3) {
        this.getLogChannel().log(10000000, "PictureStoreDSIListener#countPicturesInContextResult contextId: %2 filterSetID: %1 count:%3", (long)n2, (long)n, (long)n3);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                PictureStoreDSIListener.this.getLogChannel().log(10000000, "PictureStoreDSIListener#countPicturesInContextResult CommandResponse#call handler: %1 ", (Object)dSIListener);
                ((DSIPictureStoreListener)dSIListener).countPicturesInContextResult(n, n2, n3);
            }
        });
    }

    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public void setPictureStoreProxy(PictureStoreProxy pictureStoreProxy) {
        this.pictureStoreProxy = pictureStoreProxy;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public LogChannel getLogChannel() {
        return this.cmdListMgr.getLogChannel();
    }

    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
    }

    public void invalidData(int[] nArray, int n) {
    }
}

