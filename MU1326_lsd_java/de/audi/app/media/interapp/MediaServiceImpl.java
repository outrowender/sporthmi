/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.interapp.MediaSlotInfoImpl;
import de.audi.app.media.osgi.AbstractMediaServiceListenerTracker;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActivationContext;
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
    private static final String LOGCLASS = "MediaServiceImpl";
    private final AbstractMediaServiceListenerTracker mediaServiceListenerTracker = new AbstractMediaServiceListenerTracker(this.getTerminal()){

        protected void mediaServiceListenerAdded(IMediaServiceListener iMediaServiceListener) {
            int n;
            Object object;
            this.logger.main().log(10000000, "[%1.mediaServiceListenerAdded] '%2'", (Object)MediaServiceImpl.LOGCLASS, (Object)iMediaServiceListener);
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < 14; ++i2) {
                object = this.getTerminal().getSourceController().getSource(i2);
                if (object == null || object.getType() == 4) continue;
                n = MediaServiceImpl.getMediaSourceIDOfISourceID(object.getType());
                if (object.isAvailable()) {
                    try {
                        iMediaServiceListener.sourceAvailable(n, object.isAvailable());
                    }
                    catch (Exception exception) {
                        this.logger.main().log(100000, "[%1.mediaServiceListenerAdded] %2", (Object)MediaServiceImpl.LOGCLASS, (Throwable)exception);
                    }
                }
                if (object.isEmpty()) continue;
                LinkedList linkedList = new LinkedList();
                hashMap.put(new Integer(n), linkedList);
                Iterator iterator = object.getSlots().iterator();
                while (iterator.hasNext()) {
                    ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
                    if (!iSourceSlot.isLoaded()) continue;
                    linkedList.add(new MediaSlotInfoImpl(iSourceSlot));
                }
            }
            try {
                iMediaServiceListener.sourceListChanged(hashMap);
                IActivationContext iActivationContext = this.getTerminal().getSourceController().getActivationContext();
                if (iActivationContext != null && (object = iActivationContext.getSlot()) != null) {
                    n = object.getState() == 1 ? 1 : 0;
                    iMediaServiceListener.updateActiveSource(new MediaSlotInfoImpl((ISourceSlot)object), n != 0);
                }
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.mediaServiceListenerAdded] %2", (Object)MediaServiceImpl.LOGCLASS, (Throwable)exception);
            }
        }
    };
    private volatile ServiceRegistration mediaServiceRegistration;
    private volatile IPlayer player;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaService;

    public MediaServiceImpl(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.mediaServiceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$media$IMediaService == null ? (class$de$audi$atip$interapp$media$IMediaService = MediaServiceImpl.class$("de.audi.atip.interapp.media.IMediaService")) : class$de$audi$atip$interapp$media$IMediaService, this, new Hashtable(0));
        this.mediaServiceListenerTracker.init();
        this.getTerminal().getSourceController().addSourceListener(this);
        this.getTerminal().getSourceController().addSourceListListener(this);
        this.getTerminal().getSourceController().addActiveSourceListener(this);
        this.getTerminal().getContentManager().addContentListener(this);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.mediaServiceListenerTracker.deinit();
        this.mediaServiceRegistration.unregister();
    }

    public int getTerminalID() {
        return this.getTerminal().getTerminalID();
    }

    public void activateSource(int n, final int n2) {
        this.logger.main().log(1000000, "[%1.activateSource] '%2' (slotIdx='%3').", (Object)LOGCLASS, (long)n, (long)n2);
        int n3 = MediaServiceImpl.getISourceIDFromMediaSourceID(n);
        if (n3 == -1) {
            this.logger.main().log(100000, "[%1.activateSource] SourceID '%2' is invalid. Ignore.", (Object)LOGCLASS, (long)n);
            return;
        }
        final ISourceController iSourceController = this.getTerminal().getSourceController();
        final ISource iSource = iSourceController.getSource(n3);
        if (iSource == null) {
            this.logger.main().log(1000000, "[%1.activateSource] Source '%2' not found. Ignore.", (Object)LOGCLASS, (long)n3);
            return;
        }
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("MediaService.activateSource"){

            public void run() {
                iSourceController.activateSource(new ActivationContext(iSource.getSlot(n2)));
            }
        });
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

    public void sourceAvailable(ISource iSource, boolean bl) {
        if (this.logger.main().isInfo()) {
            this.logger.main().log(1000000, "[%1.sourceAvailable] [%2] %3", (Object)LOGCLASS, (Object)iSource, (Object)(bl ? "AVAILABLE" : "NOT AVAILABLE"));
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
                this.logger.main().log(100000, "[%1.sourceAvailable] Exception occured: %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void sourceListChanged(Map map) {
        Object object;
        this.logger.main().log(1000000, "[%1.sourceListChanged]", (Object)LOGCLASS);
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
                this.logger.main().log(100000, "[%1.sourceListChanged] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.main().log(1000000, "[%1.activeSourceChanged]", (Object)LOGCLASS);
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
                this.logger.main().log(100000, "[%1.activeSourceChanged] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logger.main().log(1000000, "[%1.contentActivated]", (Object)LOGCLASS);
        if (iContent instanceof IContentMedia) {
            this.player = ((IContentMedia)iContent).getPlayer();
            this.notifyPlaybackStateChanged(0);
            this.player.addPlayerListener(this);
        } else {
            this.player = null;
        }
    }

    public void contentActivationFinished(IContent iContent) {
    }

    public void contentDeactivated(IContent iContent) {
        this.logger.main().log(1000000, "[%1.contentDeactivated]", (Object)LOGCLASS);
        if (this.player != null) {
            this.player.removePlayerListener(this);
            this.notifyPlaybackStateChanged(0);
            this.player = null;
        }
    }

    public void playerStartupComplete() {
    }

    public void repeatScopeChanged(int n, boolean bl) {
    }

    public void repeatModeChanged(int n) {
    }

    public void playbackStateChanged(int n) {
        this.logger.main().log(1000000, "[%1.playbackStateChanged]", (Object)LOGCLASS);
        this.notifyPlaybackStateChanged(MediaServiceImpl.getMediaPlaybackStateOfPlaybackStateId(n));
    }

    public void capabilitiesChanged(Capabilities capabilities) {
    }

    public void notifyPlaybackStateChanged(int n) {
        this.logger.main().log(100000000, "[%1.notifyPlaybackStateChanged]", (Object)LOGCLASS);
        List list = this.mediaServiceListenerTracker.getMediaServiceListener();
        if (list.isEmpty() || this.player == null) {
            this.logger.main().log(1000000, "[%1.notifyPlaybackStateChanged] no listeners or no player", (Object)LOGCLASS);
            return;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)iterator.next();
            try {
                iMediaServiceListener.updatePlaybackState(n);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlaybackStateChanged] %2", (Object)LOGCLASS, (Throwable)exception);
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

    public void commandBlocked() {
    }

    public void currentPMLevelChanged(int n) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void sourceDeactivated() {
        List list = this.mediaServiceListenerTracker.getMediaServiceListener();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMediaServiceListener iMediaServiceListener = (IMediaServiceListener)iterator.next();
            try {
                this.logger.main().log(100000, "[%1.sourceDeactivated] %2", (Object)LOGCLASS, (Object)iMediaServiceListener);
                iMediaServiceListener.sourceDeactivated();
            }
            catch (Exception exception) {
                this.logger.main().log(10000, "[%1.sourceDeactivated] %2 %3", (Object)LOGCLASS, (Object)iMediaServiceListener, (Object)exception);
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

