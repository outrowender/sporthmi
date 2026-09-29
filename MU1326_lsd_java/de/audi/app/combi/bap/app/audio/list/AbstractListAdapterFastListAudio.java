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

    @Override
    protected final DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected final Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener = AbstractListAdapterFastListAudio.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener;
    }

    public final void setNotificationCommonList(boolean bl) {
    }

    public abstract void setNotificationReceptionList(boolean bl) {
    }

    public abstract void setNotificationCurrentListSizes(boolean bl) {
    }

    public abstract void addMediaBrowserJob(int n, int n2, ArrayHeader arrayHeader) {
    }

    public abstract void addMediaBrowserJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
    }

    @Override
    public void responseInitials(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
        this.logChannel.log(-1601830656, "[AbstractListAdapterFastListAudio#responseInitials] not supported");
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

