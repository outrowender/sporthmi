/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.utils;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.IEvoTransferController;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.interapp.tv.ITVService;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;
import org.osgi.framework.ServiceReference;

public class MediaEvoUtils {
    static /* synthetic */ Class class$de$audi$app$media$evo$transfer$IEvoTransferController;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVService;

    public static IEvoTransferController getEvoTransferController(IServiceManager iServiceManager) {
        ServiceReference[] serviceReferenceArray = iServiceManager.getServiceReferences(class$de$audi$app$media$evo$transfer$IEvoTransferController == null ? (class$de$audi$app$media$evo$transfer$IEvoTransferController = MediaEvoUtils.class$("de.audi.app.media.evo.transfer.IEvoTransferController")) : class$de$audi$app$media$evo$transfer$IEvoTransferController);
        for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
            Object object;
            if (null == serviceReferenceArray[i2] || !((object = iServiceManager.getService(serviceReferenceArray[i2])) instanceof IEvoTransferController)) continue;
            return (IEvoTransferController)object;
        }
        return null;
    }

    public static ITVService getTVService(IServiceManager iServiceManager) {
        ServiceReference[] serviceReferenceArray = iServiceManager.getServiceReferences(class$de$audi$atip$interapp$tv$ITVService == null ? (class$de$audi$atip$interapp$tv$ITVService = MediaEvoUtils.class$("de.audi.atip.interapp.tv.ITVService")) : class$de$audi$atip$interapp$tv$ITVService);
        for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
            Object object;
            if (null == serviceReferenceArray[i2] || !((object = iServiceManager.getService(serviceReferenceArray[i2])) instanceof ITVService)) continue;
            return (ITVService)object;
        }
        return null;
    }

    public static MediaListEntry createAlbumMediaListEntry(String string, String string2) {
        return new MediaListEntry(new ListEntry(-1L, string, string, 14, -1, 16, new ListEntryExt(string, -1L, string2, -1L, null, -1L, -1, -1, -1)));
    }

    public static MediaListEntry[] createDefaultAlbumpath(String string) {
        if (null == string || string.length() == 0) {
            return new MediaListEntry[]{MediaEvoUtils.createMediaListEntry("", ""), MediaEvoUtils.createMediaListEntry(I18NString.getOriginalString(null, 5), I18NString.getOriginalString(null, 5))};
        }
        return new MediaListEntry[]{MediaEvoUtils.createMediaListEntry("", ""), MediaEvoUtils.createMediaListEntry(I18NString.getOriginalString(null, 2), I18NString.getOriginalString(null, 2)), MediaEvoUtils.createMediaListEntry(string, string)};
    }

    public static MediaListEntry[] createRootPath() {
        return new MediaListEntry[]{MediaEvoUtils.createMediaListEntry("", "")};
    }

    public static MediaListEntry createVideosEntry() {
        return MediaEvoUtils.createMediaListEntry(I18NString.getOriginalString(null, 13), I18NString.getOriginalString(null, 13));
    }

    private static MediaListEntry createMediaListEntry(String string, String string2) {
        return new MediaListEntry(new ListEntry(-1L, string, string2, 0, -1, 16, null));
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

