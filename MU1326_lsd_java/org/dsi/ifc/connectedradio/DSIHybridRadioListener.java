/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadioListener
extends DSIListener {
    public void getOnlineRadioAvailabilityResult(int var1, int var2, RadioStation[] var3);

    public void getRadioStationLogoResult(int var1, int var2, RadioStation[] var3, int var4);

    public void indicateRadioStationLogoResult(int var1, int var2, RadioStation[] var3, int var4);

    public void getStreamResult(int var1, int var2, RadioStation var3);

    public void startSlideshowResult(int var1, int var2, RadioStation var3);

    public void stopSlideshowResult(int var1, int var2, RadioStation var3);

    public void updateSlideshow(int var1, RadioStation var2, int var3);

    public void updateRadioText(int var1, RadioStation var2, int var3);

    public void cancelGetRadioStationLogoResult(int var1, int var2);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

