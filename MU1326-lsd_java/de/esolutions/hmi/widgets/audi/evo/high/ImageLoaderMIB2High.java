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
    public static final int CACHE_SIZE_GUIDE_IMAGES;
    public static final int CACHE_SIZE_RESOURCE_LOCATOR_PATH;
    public static final int CACHE_SIZE_RESOURCE_LOCATOR_ID;
    protected EALManager ealManager;

    public ImageLoaderMIB2High() {
        super(605440, -530107136, 547424000);
    }

    public ImageLoaderMIB2High(EALManager eALManager) {
        this();
        this.ealManager = eALManager;
    }

    @Override
    public Object getErrorImage() {
        if (this.ealManager == null) {
            return null;
        }
        if (AbstractWidget.imageLoaderLogChannel.isDebug()) {
            return this.ealManager.getHMIImage(HMIImageConstantsSystem.white_pixel, -1);
        }
        return this.ealManager.getHMIImage(HMIImageConstantsSystem.empty_image, -1);
    }

    @Override
    public Object getEmptyImage() {
        return this.ealManager == null ? null : this.ealManager.getHMIImage(HMIImageConstantsSystem.empty_image, -1);
    }

    @Override
    public int getRealImageSize(int n, int n2, int n3) {
        return 1;
    }

    @Override
    protected void destroyEmptyImage() {
    }

    @Override
    protected void destroyErrorImage() {
    }

    @Override
    protected int getDefaultFormat() {
        return 6;
    }

    @Override
    protected int getWidth(Object object) {
        return 1;
    }

    @Override
    protected int getHeight(Object object) {
        return 1;
    }

    @Override
    protected Object loadViaPath(String string, int n, int n2) {
        return new HMIImage(new File(string).getAbsolutePath(), n, n2);
    }

    @Override
    protected Object loadViaStream(InputStream inputStream, int n, int n2) {
        throw new RuntimeException("Loading via stream is not yet supported");
    }

    @Override
    protected Object loadViaID(int n, int n2, int n3) {
        return "c:\\temp\\testhighway.png";
    }

    @Override
    public void destroyImage(Object object) {
    }

    @Override
    protected LRUCache createLRUCache(int n) {
        return new LRUCacheEAL(n, this);
    }

    @Override
    protected int getAutoFormat(int n) {
        return TargetImageInfo.getImageType(n);
    }

    @Override
    protected int getImageFlags(int n) {
        return TargetImageInfo.getImageFlags(n);
    }
}

