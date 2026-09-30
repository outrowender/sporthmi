/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.eso.IconExtractor.IconExtractor;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ByteBufferBackedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class IconLoader {
    private static IconLoader wrapper = null;
    private final IFrameworkAccess framework;
    private final JobQueue iconLoadQueue;
    private final DispatcherBase iconLoaderDispatcher;
    private boolean started = false;
    private static Map iconExtractorRecorder = new HashMap();
    private static final int DEFAULT_WAIT_FOR_ICON_TIME = 1000;

    public static synchronized IconLoader getInstance() {
        if (wrapper == null) {
            wrapper = new IconLoader(AbstractWidget.framework);
        }
        return wrapper;
    }

    private IconLoader(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.iconLoadQueue = new IconLoadQueue(iFrameworkAccess.getMonotonicTimeSource());
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

    public void loadImage(int n, Integer n2, IIconLoadedCallBack iIconLoadedCallBack) {
        CancelableIconLoadWorker cancelableIconLoadWorker = new CancelableIconLoadWorker(n, n2, iIconLoadedCallBack);
        this.getLogChannel().log(1000000, "IconLoader#loadImage Post load image job %1", (Object)cancelableIconLoadWorker);
        this.iconLoaderDispatcher.execute(cancelableIconLoadWorker);
    }

    public void cancelLoad(int n, IIconLoadedCallBack iIconLoadedCallBack) {
        CancelableIconLoadWorker cancelableIconLoadWorker = new CancelableIconLoadWorker(n, null, true, iIconLoadedCallBack);
        this.getLogChannel().log(1000000, "IconLoader#cancelLoad Post cancel load image job %1", (Object)cancelableIconLoadWorker);
        this.iconLoaderDispatcher.execute(cancelableIconLoadWorker);
    }

    public static IconExtractor.Bitmap getImage(int n) {
        return IconLoader.getImage(n, 1000);
    }

    public static IconExtractor.Bitmap getImage(int n, int n2) {
        IWidgetLogChannel.iconLabelLogCh.log(10000000, "IconLoader#getImage Bitmap with ID = %1 will be created", (long)n);
        long l = System.currentTimeMillis();
        IconExtractor.Bitmap bitmap = IconExtractor.getImage(n, (long)n2);
        long l2 = System.currentTimeMillis();
        IWidgetLogChannel.iconLabelLogCh.log(10000000, "IconLoader#getImage Bitmap with ID = %1 has been created from IconExtractor in %2 ms", (long)n, l2 - l);
        if (bitmap != null && IWidgetLogChannel.iconLabelLogCh.isDebug()) {
            Integer n3 = new Integer(n);
            ByteBuffer byteBuffer = bitmap.getData();
            ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBuffer);
            IconLoader.compareAndPut(n3, byteBufferBackedInputStream, iconExtractorRecorder);
        }
        return bitmap;
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

    public static String encryptBytes(ByteBufferBackedInputStream byteBufferBackedInputStream) throws NoSuchAlgorithmException {
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
        IWidgetLogChannel.iconLabelLogCh.log(10000000, stringBuffer.toString());
    }

    private static final class IconLoadQueue
    extends JobQueue {
        public IconLoadQueue(ITimeSource iTimeSource) throws UnsupportedOperationException {
            super(iTimeSource);
            this.initFilterChain(new BaseJobFilter(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void enqueue(Job job, int n) {
                    CancelableIconLoadWorker cancelableIconLoadWorker = (CancelableIconLoadWorker)job.getPayload();
                    boolean bl = cancelableIconLoadWorker.isCancelJob();
                    IconLoadQueue iconLoadQueue = IconLoadQueue.this;
                    synchronized (iconLoadQueue) {
                        List list = IconLoadQueue.this.getJobs();
                        boolean bl2 = !bl;
                        for (int i2 = 0; i2 < list.size(); ++i2) {
                            Job job2 = IconLoadQueue.this.getJob(i2);
                            CancelableIconLoadWorker cancelableIconLoadWorker2 = (CancelableIconLoadWorker)job2.getPayload();
                            if (cancelableIconLoadWorker2.iconID == cancelableIconLoadWorker.iconID) {
                                List list2 = cancelableIconLoadWorker2.pendingRequests;
                                synchronized (list2) {
                                    if (bl) {
                                        cancelableIconLoadWorker2.pendingRequests.remove(cancelableIconLoadWorker.iconLoadedCallBack);
                                        --cancelableIconLoadWorker2.pendingRequestAmount;
                                    } else {
                                        cancelableIconLoadWorker2.pendingRequests.add(cancelableIconLoadWorker.iconLoadedCallBack);
                                        ++cancelableIconLoadWorker2.pendingRequestAmount;
                                    }
                                }
                                bl2 = false;
                                break;
                            }
                            IWidgetLogChannel.iconLabelLogCh.log(1000000, "IconLoadQueue: EnqueueFilter update to old job [%1] ", (Object)cancelableIconLoadWorker2.toString());
                        }
                        if (bl2) {
                            long l = IconLoadQueue.this.getTimeSource().getCurrentTime();
                            job.setPosted(l);
                            list.add(job);
                            IWidgetLogChannel.iconLabelLogCh.log(1000000, "IconLoadQueue: EnqueueFilter insert new job [%1] ", (Object)job.toString());
                        }
                        IconLoadQueue.this.notifyAll();
                    }
                }

                public String toString() {
                    return "IconLoadQueue: EnqueueFilter";
                }
            });
        }
    }

    public static class IconLoadedEvent
    extends ATIPEvent {
        private final int iconID;
        private final Integer id_int;
        private final IconExtractor.Bitmap bitmap;

        protected IconLoadedEvent(IIconLoadedCallBack iIconLoadedCallBack, int n, Integer n2, IconExtractor.Bitmap bitmap) {
            super(iIconLoadedCallBack, n);
            this.iconID = n;
            this.id_int = n2;
            this.bitmap = bitmap;
        }

        public int getIconID() {
            return this.iconID;
        }

        public Integer getIDInt() {
            return this.id_int;
        }

        public IconExtractor.Bitmap getImage() {
            return this.bitmap;
        }
    }

    public static interface IIconLoadedCallBack
    extends ATIPEventListener {
        public void onIconLoaded(int var1, Integer var2, IconExtractor.Bitmap var3);
    }

    private class CancelableIconLoadWorker
    implements Runnable {
        final int iconID;
        final Integer id_int;
        private IconExtractor.Bitmap bitmap = null;
        IIconLoadedCallBack iconLoadedCallBack;
        private final boolean cancelJob;
        int pendingRequestAmount = 0;
        List pendingRequests = new ArrayList();

        public CancelableIconLoadWorker(int n, Integer n2, IIconLoadedCallBack iIconLoadedCallBack) {
            this(n, n2, false, iIconLoadedCallBack);
        }

        public CancelableIconLoadWorker(int n, Integer n2, boolean bl, IIconLoadedCallBack iIconLoadedCallBack) {
            this.iconID = n;
            this.id_int = n2;
            this.pendingRequestAmount = 1;
            this.pendingRequests.add(iIconLoadedCallBack);
            this.iconLoadedCallBack = iIconLoadedCallBack;
            this.cancelJob = bl;
        }

        public boolean isCancelJob() {
            return this.cancelJob;
        }

        public String toString() {
            Buffer buffer = new Buffer().append("IconLoadWorker: iconID = ").append(String.valueOf(this.iconID)).append(" pendingRequestAmount = ").append(" iconLoadedCallBack = ").append(String.valueOf(this.iconLoadedCallBack.hashCode())).append(String.valueOf(this.pendingRequestAmount)).append(" pendingRequests = ").append(String.valueOf(this.pendingRequests.size()));
            buffer.append("[");
            for (int i2 = 0; i2 < this.pendingRequests.size(); ++i2) {
                buffer.append(new StringBuffer().append(" ").append(((Object)this.pendingRequests).hashCode()).append(",").toString());
            }
            buffer.append("]");
            return buffer.toString();
        }

        public void run() {
            try {
                this.bitmap = IconLoader.getImage(this.iconID);
            }
            catch (Exception exception) {
                IconLoader.this.getLogChannel().log(10000, "IconLoadWorker#run Caught exception when getting bitmap with id = %2, message as %1", (Object)exception.getMessage(), (long)this.iconID);
                return;
            }
            IconLoader.this.getLogChannel().log(10000000, "IconLoadWorker#run task information %1", (Object)this);
            int n = this.pendingRequests.size();
            if (n != this.pendingRequestAmount) {
                IconLoader.this.getLogChannel().log(10000, "IconLoadWorker#run pendingAmount != pendingRequestAmount");
            }
            if (this.pendingRequestAmount > 0) {
                Iterator iterator = this.pendingRequests.iterator();
                while (iterator.hasNext()) {
                    IconLoadedEvent iconLoadedEvent = new IconLoadedEvent((IIconLoadedCallBack)iterator.next(), this.iconID, this.id_int, this.bitmap);
                    IconLoader.this.framework.getHMIService().getEventDispatcher().postEvent(iconLoadedEvent);
                }
            } else {
                IconLoadedEvent iconLoadedEvent = new IconLoadedEvent(this.iconLoadedCallBack, this.iconID, this.id_int, this.bitmap);
                IconLoader.this.framework.getHMIService().getEventDispatcher().postEvent(iconLoadedEvent);
            }
        }
    }
}

