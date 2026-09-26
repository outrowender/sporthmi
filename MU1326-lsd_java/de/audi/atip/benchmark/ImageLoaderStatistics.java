/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IImageLoaderStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.ImageLoaderStatistics$ImageLoadingMetric;
import de.audi.atip.benchmark.ImageLoaderStatistics$NullImageLoaderStatistics;
import de.audi.atip.benchmark.ImageLoaderStatistics$TextureLoadingMetric;
import de.audi.atip.benchmark.StatisticsManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ImageLoaderStatistics
implements IImageLoaderStatistics {
    static final String HEADER;
    static final IImageLoaderStatistics NULL_OBJECT;
    private final ITimeSource timeSource;
    private final List imgLoadingMetrics;
    private long start;

    public ImageLoaderStatistics(StatisticsManager statisticsManager) {
        this.timeSource = statisticsManager.getTimeSource();
        this.imgLoadingMetrics = new LinkedList();
    }

    @Override
    public void imageLoadStart() {
        this.start = this.timeSource.getCurrentTime();
    }

    @Override
    public void imageLoadEnd(String string, boolean bl) {
        long l = this.timeSource.getCurrentTime();
        ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric = new ImageLoaderStatistics$ImageLoadingMetric(null);
        this.imgLoadingMetrics.add(imageLoaderStatistics$ImageLoadingMetric);
        ImageLoaderStatistics$ImageLoadingMetric.access$202(imageLoaderStatistics$ImageLoadingMetric, this.start);
        ImageLoaderStatistics$ImageLoadingMetric.access$302(imageLoaderStatistics$ImageLoadingMetric, l);
        ImageLoaderStatistics$ImageLoadingMetric.access$402(imageLoaderStatistics$ImageLoadingMetric, string);
        ImageLoaderStatistics$ImageLoadingMetric.access$502(imageLoaderStatistics$ImageLoadingMetric, bl);
    }

    @Override
    public void textureCreateStart() {
        this.start = this.timeSource.getCurrentTime();
    }

    @Override
    public void textureCreateEnd(String string, boolean bl, boolean bl2) {
        Object object;
        long l = this.timeSource.getCurrentTime();
        if (!this.imgLoadingMetrics.isEmpty() && (object = this.imgLoadingMetrics.get(this.imgLoadingMetrics.size() - 1)) instanceof ImageLoaderStatistics$ImageLoadingMetric) {
            ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric = new ImageLoaderStatistics$TextureLoadingMetric((ImageLoaderStatistics$ImageLoadingMetric)object);
            ImageLoaderStatistics$TextureLoadingMetric.access$602(imageLoaderStatistics$TextureLoadingMetric, bl);
            ImageLoaderStatistics$TextureLoadingMetric.access$702(imageLoaderStatistics$TextureLoadingMetric, l);
            ImageLoaderStatistics$TextureLoadingMetric.access$802(imageLoaderStatistics$TextureLoadingMetric, this.start);
            ImageLoaderStatistics$TextureLoadingMetric.access$902(imageLoaderStatistics$TextureLoadingMetric, bl2);
            this.imgLoadingMetrics.set(this.imgLoadingMetrics.size() - 1, imageLoaderStatistics$TextureLoadingMetric);
        }
    }

    public void doDump(PrintStream printStream) {
        if (this.imgLoadingMetrics.isEmpty()) {
            printStream.println("No measurements taken!");
            return;
        }
        printStream.println("Type(T=texture & I=image);Image Path;Img Start(ms);Img End(ms);Img Duration(ms);Img Load Error;Img Length(bytes);Texture Start(ms);Texture End(ms);Texture Duration(ms);Texture Load Error;Cache in EAL?;Texture Total Time(ms)");
        Iterator iterator = this.imgLoadingMetrics.iterator();
        while (iterator.hasNext()) {
            Object object;
            Buffer buffer = new Buffer(128);
            Object object2 = iterator.next();
            if (object2 instanceof ImageLoaderStatistics$ImageLoadingMetric) {
                object = (ImageLoaderStatistics$ImageLoadingMetric)object2;
                buffer.append('I').append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$400((ImageLoaderStatistics$ImageLoadingMetric)object)).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$200((ImageLoaderStatistics$ImageLoadingMetric)object)).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$300((ImageLoaderStatistics$ImageLoadingMetric)object)).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$300((ImageLoaderStatistics$ImageLoadingMetric)object) - ImageLoaderStatistics$ImageLoadingMetric.access$200((ImageLoaderStatistics$ImageLoadingMetric)object)).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$500((ImageLoaderStatistics$ImageLoadingMetric)object)).append(";").append(ImageLoaderStatistics.getFileSize(ImageLoaderStatistics$ImageLoadingMetric.access$400((ImageLoaderStatistics$ImageLoadingMetric)object))).append(";-;-;-;-;-;-");
            } else if (object2 instanceof ImageLoaderStatistics$TextureLoadingMetric) {
                object = (ImageLoaderStatistics$TextureLoadingMetric)object2;
                buffer.append('T').append(";");
                long l = 0L;
                if (null == ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object)) {
                    buffer.append("-;-;-;-;-;-;");
                } else {
                    l = ImageLoaderStatistics$ImageLoadingMetric.access$300(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object)) - ImageLoaderStatistics$ImageLoadingMetric.access$200(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object));
                    buffer.append(ImageLoaderStatistics$ImageLoadingMetric.access$400(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object))).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$200(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object))).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$300(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object))).append(";").append(l).append(";").append(ImageLoaderStatistics$ImageLoadingMetric.access$500(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object))).append(";").append(ImageLoaderStatistics.getFileSize(ImageLoaderStatistics$ImageLoadingMetric.access$400(ImageLoaderStatistics$TextureLoadingMetric.access$1000((ImageLoaderStatistics$TextureLoadingMetric)object)))).append(";");
                }
                long l2 = 0L;
                l2 = ImageLoaderStatistics$TextureLoadingMetric.access$700((ImageLoaderStatistics$TextureLoadingMetric)object) - ImageLoaderStatistics$TextureLoadingMetric.access$800((ImageLoaderStatistics$TextureLoadingMetric)object);
                buffer.append(ImageLoaderStatistics$TextureLoadingMetric.access$800((ImageLoaderStatistics$TextureLoadingMetric)object)).append(";").append(ImageLoaderStatistics$TextureLoadingMetric.access$700((ImageLoaderStatistics$TextureLoadingMetric)object)).append(";").append(l2).append(";").append(ImageLoaderStatistics$TextureLoadingMetric.access$900((ImageLoaderStatistics$TextureLoadingMetric)object)).append(";").append(ImageLoaderStatistics$TextureLoadingMetric.access$600((ImageLoaderStatistics$TextureLoadingMetric)object)).append(";").append(l + l2);
            }
            printStream.println(buffer);
        }
    }

    private static long getFileSize(String string) {
        File file = new File(string);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return -1L;
    }

    @Override
    public void reset() {
        this.imgLoadingMetrics.clear();
    }

    @Override
    public String getName() {
        return "ImageLoaderStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println(new StringBuffer().append("Exception while printing image loading statistics: ").append(exception).toString());
        }
    }

    static {
        NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new ImageLoaderStatistics$NullImageLoaderStatistics(null) : null;
    }
}

