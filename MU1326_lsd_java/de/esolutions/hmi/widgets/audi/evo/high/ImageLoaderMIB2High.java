/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.TargetImageInfo;
import de.esolutions.hmi.widgets.audi.base.AbstractImageLoader;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.LRUCache;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.LRUCacheEAL;
import java.io.File;
import java.io.InputStream;

public class ImageLoaderMIB2High
extends AbstractImageLoader {
    public static final int CACHE_SIZE_GUIDE_IMAGES = 4000000;
    public static final int CACHE_SIZE_RESOURCE_LOCATOR_PATH = 3500000;
    public static final int CACHE_SIZE_RESOURCE_LOCATOR_ID = 500000;
    protected EALManager ealManager;

    public ImageLoaderMIB2High() {
        super(4000000, 3500000, 500000);
    }

    public ImageLoaderMIB2High(EALManager eALManager) {
        this();
        this.ealManager = eALManager;
    }

    public Object getErrorImage() {
        if (this.ealManager == null) {
            return null;
        }
        if (AbstractWidget.imageLoaderLogChannel.isDebug()) {
            return this.ealManager.getHMIImage(HMIImageConstantsSystem.white_pixel, -1);
        }
        return this.ealManager.getHMIImage(HMIImageConstantsSystem.empty_image, -1);
    }

    public Object getEmptyImage() {
        return this.ealManager == null ? null : this.ealManager.getHMIImage(HMIImageConstantsSystem.empty_image, -1);
    }

    public int getRealImageSize(int n, int n2, int n3) {
        return 1;
    }

    protected void destroyEmptyImage() {
    }

    protected void destroyErrorImage() {
    }

    protected int getDefaultFormat() {
        return 6;
    }

    protected int getWidth(Object object) {
        return 1;
    }

    protected int getHeight(Object object) {
        return 1;
    }

    protected Object loadViaPath(String string, int n, int n2) {
        return new HMIImage(new File(string).getAbsolutePath(), n, n2);
    }

    protected Object loadViaStream(InputStream inputStream, int n, int n2) {
        throw new RuntimeException("Loading via stream is not yet supported");
    }

    protected Object loadViaID(int n, int n2, int n3) {
        return "c:\\temp\\testhighway.png";
    }

    public void destroyImage(Object object) {
    }

    protected LRUCache createLRUCache(int n) {
        return new LRUCacheEAL(n, this);
    }

    protected int getAutoFormat(int n) {
        return TargetImageInfo.getImageType(n);
    }

    protected int getImageFlags(int n) {
        return TargetImageInfo.getImageFlags(n);
    }
}

