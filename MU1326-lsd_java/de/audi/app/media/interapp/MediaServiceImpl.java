/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.interapp.MediaServiceImpl$1;
import de.audi.app.media.interapp.MediaServiceImpl$2;
import de.audi.app.media.interapp.MediaSlotInfoImpl;
import de.audi.app.media.osgi.AbstractMediaServiceListenerTracker;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceListListener;
import de.audi.app.media.source.ISourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.media.Capabilities;
import org.osgi.framework.ServiceRegistration;

public class MediaServiceImpl
extends AbstractMediaTerminalComponent
implements IMediaService,
ISourceListener,
ISourceListListener,
IActiveSourceListener,
IContentListener,
IPlayerListener {
    private static final String LOGCLASS;
    private final AbstractMediaServiceListenerTracker mediaServiceListenerTracker = new MediaServiceImpl$1(this, this.getTerminal());
    private volatile ServiceRegistration mediaServiceRegistration;
    private volatile IPlayer player;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaService;

    public MediaServiceImpl(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"MediaServiceImpl");
        this.mediaServiceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$media$IMediaService == null ? (class$de$audi$atip$interapp$media$IMediaService = MediaServiceImpl.class$("de.audi.atip.interapp.media.IMediaService")) : class$de$audi$atip$interapp$media$IMediaService, this, new Hashtable(0));
        this.mediaServiceListenerTracker.init();
        this.getTerminal().getSourceController().addSourceListener(this);
        this.getTerminal().getSourceController().addSourceListListener(this);
        this.getTerminal().getSourceController().addActiveSourceListener(this);
        this.getTerminal().getContentManager().addContentListener(this);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"MediaServiceImpl");
        this.mediaServiceListenerTracker.deinit();
        this.mediaServiceRegistration.unregister();
    }

    @Override
    public int getTerminalID() {
        return this.getTerminal().getTerminalID();
    }

    @Override
    public void activateSource(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.activateSource] '%2' (slotIdx='%3').", (Object)"MediaServiceImpl", (long)n, (long)n2);
        int n3 = MediaServiceImpl.getISourceIDFromMediaSourceID(n);
        if (n3 == -1) {
            this.logger.main().log(-1601830656, "[%1.activateSource] SourceID '%2' is invalid. Ignore.", (Object)"MediaServiceImpl", (long)n);
            return;
        }
        ISourceController iSourceController = this.getTerminal().getSourceController();
        ISource iSource = iSourceController.getSource(n3);
        if (iSource == null) {
            this.logger.main().log(1078071040, "[%1.activateSource] Source '%2' not found. Ignore.", (Object)"MediaServiceImpl", (long)n3);
            return;
        }
        this.getTerminal().getDispatcher().execute(new MediaServiceImpl$2(this, "MediaService.activateSource", iSourceController, iSource, n2));
    }

    public static int getMediaSourceIDOfISourceID(int n) {
        switch (n) {
            case 9: {
                return 9;
            }
            case 8: {
                return 8;
            }
            case 11: {
                return 11;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 1;
            }
            case 3: {
                return 4;
            }
            case 2: {
                return 3;
            }
            case 6: {
                return 6;
            }
            case 5: {
                return 5;
            }
            case 7: {
                return 7;
            }
            case 10: {
                return 10;
            }
            case 12: {
                return 12;
            }
            case 13: {
                return 13;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Source ID '").append(n).append("' undefined.").toString());
    }

    public static int getISourceIDFromMediaSourceID(int n) {
        switch (n) {
            case 9: {
                return 9;
            }
            case 8: {
                return 8;
            }
            case 11: {
                return 11;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 0;
            }
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 6: {
                return 6;
            }
            case 5: {
                return 5;
            }
            case 7: {
                return 7;
            }
            case 10: {
                return 10;
            }
            case 12: {
                return 12;
            }
            case 13: {
                return 13;
            }
        }
        return -1;
    }

    @Override
    public void sourceAvailable(ISource iSource, boolean bl) {
        if (this.logger.main().isInfo()) {
            this.logger.main().log(1078071040, "[%1.sourceAvailable] [%2] %3", (Object)"MediaServiceImpl", (Object)iSource, (Object)(bl ? "AVAILABLE" : "NOT AVAILABLE"));
        }
        if (iSource.getType() == 4 || iSource.getType() == 13) {
            return;
        }
        Iterator iterator = this.mediaServiceListenerTracker.getMediaServiceListener().iterator();
        while (iterator.hasNext()) {
            IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)iterator.next();
            try {
                iMediaServiceListener.sourceAvailable(MediaServiceImpl.getMediaSourceIDOfISourceID(iSource.getType()), bl);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.sourceAvailable] Exception occured: %2", (Object)"MediaServiceImpl", (Throwable)exception);
            }
        }
    }

    @Override
    public void sourceListChanged(Map map) {
        Object object;
        this.logger.main().log(1078071040, "[%1.sourceListChanged]", (Object)"MediaServiceImpl");
        List list = this.mediaServiceListenerTracker.getMediaServiceListener();
        if (list.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map.size());
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            LinkedList linkedList;
            object = (Integer)iterator.next();
            if ((Integer)object == 4 || (linkedList = (LinkedList)map.get(object)) == null || linkedList.isEmpty()) continue;
            LinkedList linkedList2 = new LinkedList();
            hashMap.put(Integers.valueOf(MediaServiceImpl.getMediaSourceIDOfISourceID((Integer)object)), linkedList2);
            Iterator iterator2 = linkedList.iterator();
            while (iterator2.hasNext()) {
                ISourceSlot iSourceSlot = (ISourceSlot)iterator2.next();
                if (!iSourceSlot.isLoaded()) continue;
                linkedList2.add(new MediaSlotInfoImpl(iSourceSlot));
            }
        }
        iterator = list.iterator();
        while (iterator.hasNext()) {
            object = (IMediaServiceListener)iterator.next();
            try {
                object.sourceListChanged(hashMap);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.sourceListChanged] %2", (Object)"MediaServiceImpl", (Throwable)exception);
            }
        }
    }

    @Override
    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.main().log(1078071040, "[%1.activeSourceChanged]", (Object)"MediaServiceImpl");
        List list = this.mediaServiceListenerTracker.getMediaServiceListener();
        if (list.isEmpty() || activeSourceState.getSlot() == null || activeSourceState.getSlot().getSource().getType() == 4) {
            return;
        }
        MediaSlotInfoImpl mediaSlotInfoImpl = new MediaSlotInfoImpl(activeSourceState.getSlot());
        boolean bl2 = activeSourceState.getState() == 1;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)iterator.next();
            try {
                iMediaServiceListener.updateActiveSource(mediaSlotInfoImpl, bl2);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.activeSourceChanged] %2", (Object)"MediaServiceImpl", (Throwable)exception);
            }
        }
    }

    @Override
    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logger.main().log(1078071040, "[%1.contentActivated]", (Object)"MediaServiceImpl");
        if (iContent instanceof IContentMedia) {
            this.player = ((IContentMedia)iContent).getPlayer();
            this.notifyPlaybackStateChanged(0);
            this.player.addPlayerListener(this);
        } else {
            this.player = null;
        }
    }

    @Override
    public void contentActivationFinished(IContent iContent) {
    }

    @Override
    public void contentDeactivated(IContent iContent) {
        this.logger.main().log(1078071040, "[%1.contentDeactivated]", (Object)"MediaServiceImpl");
        if (this.player != null) {
            this.player.removePlayerListener(this);
            this.notifyPlaybackStateChanged(0);
            this.player = null;
        }
    }

    @Override
    public void playerStartupComplete() {
    }

    @Override
    public void repeatScopeChanged(int n, boolean bl) {
    }

    @Override
    public void repeatModeChanged(int n) {
    }

    @Override
    public void playbackStateChanged(int n) {
        this.logger.main().log(1078071040, "[%1.playbackStateChanged]", (Object)"MediaServiceImpl");
        this.notifyPlaybackStateChanged(MediaServiceImpl.getMediaPlaybackStateOfPlaybackStateId(n));
    }

    @Override
    public void capabilitiesChanged(Capabilities capabilities) {
    }

    public void notifyPlaybackStateChanged(int n) {
        this.logger.main().log(14808325, "[%1.notifyPlaybackStateChanged]", (Object)"MediaServiceImpl");
        List list = this.mediaServiceListenerTracker.getMediaServiceListener();
        if (list.isEmpty() || this.player == null) {
            this.logger.main().log(1078071040, "[%1.notifyPlaybackStateChanged] no listeners or no player", (Object)"MediaServiceImpl");
            return;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)iterator.next();
            try {
                iMediaServiceListener.updatePlaybackState(n);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.notifyPlaybackStateChanged] %2", (Object)"MediaServiceImpl", (Throwable)exception);
            }
        }
    }

    private static int getMediaPlaybackStateOfPlaybackStateId(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 6: {
                return 6;
            }
        }
        return 0;
    }

    @Override
    public void commandBlocked() {
    }

    @Override
    public void currentPMLevelChanged(int n) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("MediaServiceImpl").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void sourceDeactivated() {
        List list = this.mediaServiceListenerTracker.getMediaServiceListener();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)iterator.next();
            try {
                this.logger.main().log(-1601830656, "[%1.sourceDeactivated] %2", (Object)"MediaServiceImpl", (Object)iMediaServiceListener);
                iMediaServiceListener.sourceDeactivated();
            }
            catch (Exception exception) {
                this.logger.main().log(10000, "[%1.sourceDeactivated] %2 %3", (Object)"MediaServiceImpl", (Object)iMediaServiceListener, (Object)exception);
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

