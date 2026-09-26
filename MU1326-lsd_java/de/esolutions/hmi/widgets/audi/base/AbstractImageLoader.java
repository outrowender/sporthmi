/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.view.IImageLoader;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.LRUCache;
import java.io.InputStream;

public abstract class AbstractImageLoader
implements IImageLoader,
IWidgetLogChannel {
    protected static final boolean LOAD_FROM_FILE;
    public static final String DEFAULT_IMAGE_ROOT;
    public static String imageRoot;
    protected String errorInfo = "";
    protected LRUCache guideBitmapCache;
    protected LRUCache ressourceLocatorPathBitmapCache;
    protected LRUCache ressourceLocatorIDBitmapCache;

    public AbstractImageLoader(int n, int n2, int n3) {
        this.guideBitmapCache = this.createLRUCache(n);
        this.ressourceLocatorPathBitmapCache = this.createLRUCache(n2);
        this.ressourceLocatorIDBitmapCache = this.createLRUCache(n3);
    }

    protected abstract LRUCache createLRUCache(int n) {
    }

    @Override
    public void clearImageCache() {
        this.guideBitmapCache.clear();
        this.ressourceLocatorPathBitmapCache.clear();
        this.ressourceLocatorIDBitmapCache.clear();
        this.destroyEmptyImage();
        this.destroyErrorImage();
    }

    protected abstract void destroyEmptyImage() {
    }

    protected abstract void destroyErrorImage() {
    }

    @Override
    public Object getImageFromCache(int n, int n2, int n3) {
        return this.guideBitmapCache.get(new Integer(n), n2, n3);
    }

    protected abstract int getAutoFormat(int n) {
    }

    protected int getImageFlags(int n) {
        return 0;
    }

    protected abstract Object loadViaPath(String string, int n, int n2) {
    }

    protected abstract Object loadViaStream(InputStream inputStream, int n, int n2) {
    }

    @Override
    public Object loadImage(HMIResourceLocator hMIResourceLocator, boolean bl, int n, int n2) {
        if (hMIResourceLocator.containsResourceURI()) {
            return this.getResourceViaResourceLocatorPath(hMIResourceLocator, n, n2, bl);
        }
        if (hMIResourceLocator.containsResourceID()) {
            return this.getResourceViaResourceLocatorID(hMIResourceLocator, n, n2, bl);
        }
        return null;
    }

    protected Object getResourceViaResourceLocatorID(HMIResourceLocator hMIResourceLocator, int n, int n2, boolean bl) {
        Integer n3;
        int n4 = hMIResourceLocator.getResourceID();
        if (imageLoaderLogChannel.isDebug()) {
            imageLoaderLogChannel.log(-2137614336, new StringBuffer().append("AbstractImageLoader#getResourceViaResourceLocatorID cached: ").append(bl).append(" screenID: %2 resourceID: %1 ").toString(), (long)n4, (long)n);
        }
        Object object = null;
        if (bl && (object = this.ressourceLocatorIDBitmapCache.get(n3 = new Integer(hMIResourceLocator.hashCode()), n, n2)) != null) {
            return object;
        }
        object = this.loadViaID(n4, 0, this.getDefaultFormat());
        if (object == null) {
            if (bl) {
                return this.getErrorImage();
            }
            return null;
        }
        if (bl) {
            n3 = new Integer(hMIResourceLocator.hashCode());
            int n5 = this.getRealImageSize(this.getWidth(object), this.getHeight(object), this.getDefaultFormat());
            this.ressourceLocatorIDBitmapCache.put(n3, object, n5, this.getDefaultFormat(), 0, n, n2);
        }
        return object;
    }

    protected abstract Object loadViaID(int n, int n2, int n3) {
    }

    protected Object getResourceViaResourceLocatorPath(HMIResourceLocator hMIResourceLocator, int n, int n2, boolean bl) {
        String string = hMIResourceLocator.getResourceURI();
        if (imageLoaderLogChannel.isDebug()) {
            imageLoaderLogChannel.log(-2137614336, new StringBuffer().append("AbstractImageLoader#getResourceViaResourceLocatorPath cached: ").append(bl).append(" screenID: %2 path: %1 ").toString(), (Object)string, (long)n);
        }
        Object object = null;
        if (bl && (object = this.ressourceLocatorPathBitmapCache.get((Comparable)((Object)string), n, n2)) != null) {
            return object;
        }
        object = this.loadViaPath(string, this.getDefaultFormat(), 0);
        if (object == null) {
            if (bl) {
                return this.getErrorImage();
            }
            return null;
        }
        if (bl) {
            int n3 = this.getRealImageSize(this.getWidth(object), this.getHeight(object), this.getDefaultFormat());
            this.ressourceLocatorPathBitmapCache.put((Comparable)((Object)string), object, n3, this.getDefaultFormat(), 0, n, n2);
        }
        return object;
    }

    protected abstract int getDefaultFormat() {
    }

    @Override
    public Object loadImageAbsolutePath(int n, String string, boolean bl, boolean bl2, int n2, int n3, int n4) {
        return this.doLoadHybridBitmap(n, string, bl, bl2, n2, n3, n4);
    }

    @Override
    public Object loadImage(int n, String string, boolean bl, boolean bl2, int n2, int n3, int n4) {
        String string2 = new Buffer(imageRoot.length() + string.length()).append(imageRoot).append(string).toString();
        return this.doLoadHybridBitmap(n, string2, bl, bl2, n2, n3, n4);
    }

    protected Object doLoadHybridBitmap(int n, Object object, boolean bl, boolean bl2, int n2, int n3, int n4) {
        int n5 = this.getAutoFormat(n);
        n2 |= this.getImageFlags(n);
        if (n5 == -1) {
            n5 = this.getDefaultFormat();
            imageLoaderLogChannel.log(10000, "AbstractImageLoader#getAutoFormat format for image %1 cannot be found, using RGBA", (long)n);
        } else {
            imageLoaderLogChannel.log(-2137614336, "AbstractImageLoader#loading image %1 with format %2", (long)n, (long)n5);
        }
        if (object == null) {
            return this.getErrorImage();
        }
        Object object2 = null;
        if (bl && (object2 = this.guideBitmapCache.get(new Integer(n), n3, n4)) != null) {
            return object2;
        }
        imageLoaderLogChannel.log(-2137614336, "AbstractImageLoader#doLoadHybridBitmap before createBitmap call for id: %1", (long)n);
        object2 = object instanceof InputStream ? this.loadViaStream((InputStream)object, n5, n2) : this.loadViaPath((String)object, n5, n2);
        if (object2 == null) {
            return this.getErrorImage();
        }
        if (screenLogChannel.isDebug()) {
            imageLoaderLogChannel.log(-2137614336, "AbstractImageLoader#doLoadHybridBitmap after createBitmap call for id: %1 size: %2 : %3", (long)n, (long)this.getWidth(object2), (long)this.getHeight(object2));
        }
        if (bl2) {
            int n6 = this.getRealImageSize(this.getWidth(object2), this.getHeight(object2), this.getDefaultFormat());
            this.guideBitmapCache.put(new Integer(n), object2, n6, n5, n2, n3, n4);
        }
        return object2;
    }

    public void screenDisconnected(int n, int n2) {
        this.guideBitmapCache.decrementRefCounters(n, n2);
        this.ressourceLocatorIDBitmapCache.decrementRefCounters(n, n2);
        this.ressourceLocatorPathBitmapCache.decrementRefCounters(n, n2);
        this.clearAsyncPictureRequests();
    }

    protected void clearAsyncPictureRequests() {
    }

    public void dumpBitmapCaches() {
        int n;
        Object[] objectArray;
        if (this.guideBitmapCache != null) {
            imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache start dumping GUIDE-images");
            objectArray = this.guideBitmapCache.elements();
            for (n = 0; n < objectArray.length; ++n) {
                imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache nextBitmap, width: %1 height: %2", (long)this.getWidth(objectArray[n]), (long)this.getHeight(objectArray[n]));
            }
            imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache finished dumping GUIDE-images");
        }
        if (this.ressourceLocatorIDBitmapCache != null) {
            imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache start dumping resource locator id images");
            objectArray = this.ressourceLocatorIDBitmapCache.elements();
            for (n = 0; n < objectArray.length; ++n) {
                imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache nextRessourceIcon , width: %1 height: %2", (long)this.getWidth(objectArray[n]), (long)this.getHeight(objectArray[n]));
            }
            imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache finished dumping resource locator id images");
        }
        if (this.ressourceLocatorPathBitmapCache != null) {
            imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache start dumping resource locator path images");
            objectArray = this.ressourceLocatorPathBitmapCache.elements();
            for (n = 0; n < objectArray.length; ++n) {
                imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache nextRessourceIcon , width: %1 height: %2", (long)this.getWidth(objectArray[n]), (long)this.getHeight(objectArray[n]));
            }
            imageLoaderStatisticsLogChannel.log(-2137614336, "ImageLoader#dumpBitmapCache finished dumping resource locator path images");
        }
    }

    protected abstract int getWidth(Object object) {
    }

    protected abstract int getHeight(Object object) {
    }

    public int getBitmapCount() {
        int n = 0;
        if (this.guideBitmapCache != null) {
            n += this.guideBitmapCache.size();
        }
        if (this.ressourceLocatorIDBitmapCache != null) {
            n += this.ressourceLocatorIDBitmapCache.size();
        }
        if (this.ressourceLocatorPathBitmapCache != null) {
            n += this.ressourceLocatorPathBitmapCache.size();
        }
        return n;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public long getStorageSize() {
        return this.guideBitmapCache.getStorageSize() + this.ressourceLocatorPathBitmapCache.getStorageSize() + this.ressourceLocatorIDBitmapCache.getStorageSize();
    }

    public int getNoOfCachedGUIDEImages() {
        return this.guideBitmapCache.size();
    }

    public int getNoOfCachedDynamicImages() {
        return this.ressourceLocatorPathBitmapCache.size() + this.ressourceLocatorIDBitmapCache.size();
    }

    public static int getPowerOfTwoSize(int n) {
        if (n <= 2) {
            return n;
        }
        if (n <= 4) {
            return 4;
        }
        if (n <= 8) {
            return 8;
        }
        if (n <= 16) {
            return 16;
        }
        if (n <= 32) {
            return 32;
        }
        if (n <= 64) {
            return 64;
        }
        if (n <= 128) {
            return 128;
        }
        if (n <= 256) {
            return 256;
        }
        if (n <= 512) {
            return 512;
        }
        if (n <= 1024) {
            return 1024;
        }
        if (n <= 2048) {
            return 2048;
        }
        if (n <= 4096) {
            return 4096;
        }
        if (n <= 8192) {
            return 8192;
        }
        imageLoaderLogChannel.log(10000, "AbstractImageLoader#getPowerOfTwoSize real size is greater than 8192 stop computing power of two");
        return n;
    }

    static {
        String string = System.getProperty("ImageRoot");
        if (string != null) {
            imageRoot = new StringBuffer().append(string).append("/").toString();
            LOAD_FROM_FILE = true;
        } else {
            imageRoot = "/images/";
            LOAD_FROM_FILE = false;
        }
    }
}

