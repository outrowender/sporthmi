/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.pictureserver;

import de.audi.app.combi.bap.app.kombipictures.IPictureManager;
import de.audi.app.combi.bap.dsi.pictureserver.DSIKombiPictureServerListenerImpl$1;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;

public class DSIKombiPictureServerListenerImpl
implements DSIKombiPictureServerListener {
    private static final int INCOMING_CALL_WAIT_FOR_PICTURE_DELAY_MS;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final IPictureManager pictureManager;
    private final LogChannel logChannel;

    public DSIKombiPictureServerListenerImpl(IPictureManager iPictureManager) {
        this.pictureManager = iPictureManager;
        this.logChannel = CombiLogger.getPicServerDSILog();
    }

    private int convertToBAPSourceType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 12: {
                return 12;
            }
            case 13: {
                return 13;
            }
            case 14: {
                return 14;
            }
            case 15: {
                return 15;
            }
            case 16: {
                return 16;
            }
            case 17: {
                return 17;
            }
            case 18: {
                return 18;
            }
            case 19: {
                return 19;
            }
            case 20: {
                return 20;
            }
            case 21: {
                return 21;
            }
            case 22: {
                return 22;
            }
            case 23: {
                return 23;
            }
            case 24: {
                return 24;
            }
            case 25: {
                return 31;
            }
            case 32: {
                return 32;
            }
            case 33: {
                return 33;
            }
            case 28: {
                return 34;
            }
            case 35: {
                return 35;
            }
            case 255: {
                return 255;
            }
        }
        this.logChannel.log(-1601830656, "[DSIKombiPictureServerListenerImpl#convertToBAPSourceType] sourceType not available for BAP: %1", (long)n);
        return n;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void indicationCoverArt(long l, int n, int n2) {
        this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationCoverArt] address=%1, addressType=%2, sourceType=%3", l, (long)n, (long)n2);
        if (l == 0L && n == 0 && n2 == 255) {
            this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationCoverArt] notification on CoverArt received");
            this.pictureManager.setNotification(0);
        } else if (n == 0) {
            this.pictureManager.requestCoverArt(l, this.convertToBAPSourceType(n2));
        } else {
            this.logChannel.log(10000, "[DSIKombiPictureServerListenerImpl#indicationCoverArt] addressType MOST not supported");
        }
    }

    @Override
    public void indicationStationArt(long l, int n, int n2) {
        this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationStationArt] address=%1, addressType=%2, sourceType=%3", l, (long)n, (long)n2);
        if (l == 0L && n == 0 && n2 == 255) {
            this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationStationArt] notification on StationArt received");
            this.pictureManager.setNotification(1);
        }
        if (n == 0) {
            this.pictureManager.requestStationArt(l, this.convertToBAPSourceType(n2));
        } else {
            this.logChannel.log(10000, "[DSIKombiPictureServerListenerImpl#indicationStationArt] addressType MOST not supported");
        }
    }

    @Override
    public void indicationActiveCallPicture(int n) {
        this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationActiveCallPicture] callID=%1", (long)n);
        if (n == 255) {
            this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationActiveCallPicture] notification on ActiveCallPicture received");
            this.pictureManager.setNotification(2);
        } else {
            this.executor.schedule(new DSIKombiPictureServerListenerImpl$1(this, n), (long)0, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void indicationInternalAddressID(long l, int n) {
        this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationInternalAddressID] address=%1, idType=%2", l, (long)n);
    }

    @Override
    public void indicationAdbContactPicture(long l, int n) {
        this.logChannel.log(1078071040, "[DSIKombiPictureServerListenerImpl#indicationAdbContactPicture] address=%1, addressType=%2", l, (long)n);
        if (n == 0) {
            this.pictureManager.requestAdbContactPicture(l);
        } else {
            this.logChannel.log(10000, "[DSIKombiPictureServerListenerImpl#indicationAdbContactPicture] addressType MOST not supported");
        }
    }

    @Override
    public void indicationPictureStreamAbilities() {
    }

    @Override
    public void indicationPictureStream(int n, short s, short s2, int n2, int n3, int n4, int n5, byte[] byArray) {
    }

    @Override
    public void indicationActiveCallPictureInstance(int n, int n2) {
    }

    @Override
    public void indicationDynamicIcon(int n, int n2) {
    }

    static /* synthetic */ LogChannel access$000(DSIKombiPictureServerListenerImpl dSIKombiPictureServerListenerImpl) {
        return dSIKombiPictureServerListenerImpl.logChannel;
    }

    static /* synthetic */ IPictureManager access$100(DSIKombiPictureServerListenerImpl dSIKombiPictureServerListenerImpl) {
        return dSIKombiPictureServerListenerImpl.pictureManager;
    }
}

