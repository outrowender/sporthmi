/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.eso.IconExtractor.IconExtractor;
import de.eso.IconExtractor.IconExtractor$Bitmap;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ByteBufferBackedInputStream;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$CancelableIconLoadWorker;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IIconLoadedCallBack;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IconLoadQueue;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class IconLoader {
    private static IconLoader wrapper = null;
    private final IFrameworkAccess framework;
    private final JobQueue iconLoadQueue;
    private final DispatcherBase iconLoaderDispatcher;
    private boolean started = false;
    private static Map iconExtractorRecorder = new HashMap();
    private static final int DEFAULT_WAIT_FOR_ICON_TIME;

    public static synchronized IconLoader getInstance() {
        if (wrapper == null) {
            wrapper = new IconLoader(AbstractWidget.framework);
        }
        return wrapper;
    }

    private IconLoader(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.iconLoadQueue = new IconLoader$IconLoadQueue(iFrameworkAccess.getMonotonicTimeSource());
        this.iconLoaderDispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("AsynchronizedIconLoader", new JobLogger(this.getLogChannel()), this.iconLoadQueue);
    }

    public void start() {
        if (!this.started) {
            this.iconLoaderDispatcher.start();
            this.started = true;
        }
    }

    public boolean isStarted() {
        return this.started;
    }

    private LogChannel getLogChannel() {
        return AbstractWidget.framework.getLogChannel("Fw.Widgets.IconLabel");
    }

    public void suspend() {
        this.iconLoaderDispatcher.suspend();
    }

    public void stop() {
        this.iconLoaderDispatcher.stop();
    }

    public void loadImage(int n, Integer n2, IconLoader$IIconLoadedCallBack iconLoader$IIconLoadedCallBack) {
        IconLoader$CancelableIconLoadWorker iconLoader$CancelableIconLoadWorker = new IconLoader$CancelableIconLoadWorker(this, n, n2, iconLoader$IIconLoadedCallBack);
        this.getLogChannel().log(1078071040, "IconLoader#loadImage Post load image job %1", (Object)iconLoader$CancelableIconLoadWorker);
        this.iconLoaderDispatcher.execute(iconLoader$CancelableIconLoadWorker);
    }

    public void cancelLoad(int n, IconLoader$IIconLoadedCallBack iconLoader$IIconLoadedCallBack) {
        IconLoader$CancelableIconLoadWorker iconLoader$CancelableIconLoadWorker = new IconLoader$CancelableIconLoadWorker(this, n, null, true, iconLoader$IIconLoadedCallBack);
        this.getLogChannel().log(1078071040, "IconLoader#cancelLoad Post cancel load image job %1", (Object)iconLoader$CancelableIconLoadWorker);
        this.iconLoaderDispatcher.execute(iconLoader$CancelableIconLoadWorker);
    }

    public static IconExtractor$Bitmap getImage(int n) {
        return IconLoader.getImage(n, 1000);
    }

    public static IconExtractor$Bitmap getImage(int n, int n2) {
        IWidgetLogChannel.iconLabelLogCh.log(-2137614336, "IconLoader#getImage Bitmap with ID = %1 will be created", (long)n);
        long l = System.currentTimeMillis();
        IconExtractor$Bitmap iconExtractor$Bitmap = IconExtractor.getImage(n, (long)n2);
        long l2 = System.currentTimeMillis();
        IWidgetLogChannel.iconLabelLogCh.log(-2137614336, "IconLoader#getImage Bitmap with ID = %1 has been created from IconExtractor in %2 ms", (long)n, l2 - l);
        if (iconExtractor$Bitmap != null && IWidgetLogChannel.iconLabelLogCh.isDebug()) {
            Integer n3 = new Integer(n);
            ByteBuffer byteBuffer = iconExtractor$Bitmap.getData();
            ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBuffer);
            IconLoader.compareAndPut(n3, byteBufferBackedInputStream, iconExtractorRecorder);
        }
        return iconExtractor$Bitmap;
    }

    public static void compareAndPut(Object object, ByteBufferBackedInputStream byteBufferBackedInputStream, Map map) {
        try {
            String string = IconLoader.encryptBytes(byteBufferBackedInputStream);
            if (map.containsKey(object)) {
                String string2 = (String)map.get(object);
                if (!string.equals(string2)) {
                    IWidgetLogChannel.iconLabelLogCh.log(10000, "IconLoader#compareAndPut icon(id = %1) content changed", object);
                }
            } else {
                map.put(object, string);
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            IWidgetLogChannel.iconLabelLogCh.log(10000, "IconLoader#compareAndPut NoSuchAlgorithmException: %1", (Throwable)noSuchAlgorithmException);
        }
    }

    public static String encryptBytes(ByteBufferBackedInputStream byteBufferBackedInputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int n = 1000;
            byte[] byArray = new byte[n];
            int n2 = 0;
            while ((n2 = byteBufferBackedInputStream.read(byArray)) > 0) {
                messageDigest.update(byArray, 0, n2);
            }
            byte[] byArray2 = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < byArray2.length; ++i2) {
                stringBuffer.append(Integer.toString((byArray2[i2] & 0xFF) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        }
        catch (IOException iOException) {
            IWidgetLogChannel.iconLabelLogCh.log(10000, "IconLoader#encryptBytes entrypt icon access buffer backed input stream error!");
            return null;
        }
    }

    public static void dumpCache() {
        StringBuffer stringBuffer = new StringBuffer(52);
        stringBuffer.append("Icon context MD5 hash: [\r\n");
        Iterator iterator = iconExtractorRecorder.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            String string = (String)iconExtractorRecorder.get(n);
            stringBuffer.append("\t{id");
            stringBuffer.append(n);
            stringBuffer.append(", hash = ");
            stringBuffer.append(string);
            stringBuffer.append("}\r\n");
        }
        stringBuffer.append(']');
        IWidgetLogChannel.iconLabelLogCh.log(-2137614336, stringBuffer.toString());
    }

    static /* synthetic */ LogChannel access$300(IconLoader iconLoader) {
        return iconLoader.getLogChannel();
    }

    static /* synthetic */ IFrameworkAccess access$400(IconLoader iconLoader) {
        return iconLoader.framework;
    }
}

