/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.dsi.fastlist.listener.DSIFastListScrollingAudioListenerImpl;
import de.audi.app.combi.bap.fw.arrays.fastlist.AbstractListAdapterFastList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataInitials;

public abstract class AbstractListAdapterFastListAudio
extends AbstractListAdapterFastList {
    private final DSIFastListScrollingAudioListenerImpl dsiListener = new DSIFastListScrollingAudioListenerImpl(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener;

    public AbstractListAdapterFastListAudio(ArrayHandler arrayHandler) {
        super(arrayHandler);
    }

    protected final DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected final Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener = AbstractListAdapterFastListAudio.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener;
    }

    public final void setNotificationCommonList(boolean bl) {
    }

    public abstract void setNotificationReceptionList(boolean var1);

    public abstract void setNotificationCurrentListSizes(boolean var1);

    public abstract void addMediaBrowserJob(int var1, int var2, ArrayHeader var3);

    public abstract void addMediaBrowserJobs(int var1, int var2, ArrayHeader[] var3);

    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.logChannel.log(100000, "[AbstractListAdapterFastListAudio#responseInitials] not supported");
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

