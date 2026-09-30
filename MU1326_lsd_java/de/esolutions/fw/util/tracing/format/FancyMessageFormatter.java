/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FancyMessageFormatter
implements ITraceMessageFormatter {
    private Column[] columns;

    public void init(TraceConfigFormatter traceConfigFormatter) {
        ConfigValue configValue = traceConfigFormatter.getQuery().getArray("columns");
        if (configValue != null) {
            int n = configValue.getArraySize();
            this.columns = new Column[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ConfigValue configValue2 = configValue.getArrayValue(i2);
                ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue2);
                String string = configPathQuery.getStringValue("field", "none");
                Column column = null;
                if (string.equals("timestamp")) {
                    column = new TimeStampColumn(configPathQuery);
                } else if (string.equals("threadId")) {
                    column = new ThreadIdColumn(configPathQuery);
                } else if (string.equals("channelId")) {
                    column = new ChannelIdColumn(configPathQuery);
                } else if (string.equals("sequenceNumber")) {
                    column = new SeqNumColumn(configPathQuery);
                } else if (string.equals("messageType")) {
                    column = new MsgTypeColumn(configPathQuery);
                } else if (string.equals("messageModifier")) {
                    column = new MsgModColumn(configPathQuery);
                } else if (string.equals("messageLevel")) {
                    column = new LevelColumn(configPathQuery);
                } else if (string.equals("messageString")) {
                    column = new MsgStringColumn(configPathQuery);
                } else if (string.equals("processId")) {
                    column = new ProcessIdColumn(configPathQuery);
                }
                this.columns[i2] = column;
            }
        }
    }

    public String[] formatMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
        int n = iTraceMessage.getDecodedMessage().length;
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            Buffer buffer = new Buffer();
            for (int i3 = 0; i3 < this.columns.length; ++i3) {
                Column column = this.columns[i3];
                if (column != null) {
                    buffer.append(column.eval(iTraceMessage, iTraceEntityResolver, i2));
                } else {
                    buffer.append("<INVALID>");
                }
                buffer.append(" ");
            }
            stringArray[i2] = buffer.toString();
        }
        return stringArray;
    }

    private abstract class Column {
        protected final int width;
        protected final boolean resolve;
        protected final boolean crop;

        public Column(IConfigQuery iConfigQuery) {
            this.width = iConfigQuery.getIntegerValue("width", 10);
            this.resolve = iConfigQuery.getBooleanValue("resolve", true);
            this.crop = iConfigQuery.getBooleanValue("crop", true);
        }

        public abstract String print(ITraceMessage var1, ITraceEntityResolver var2, int var3);

        public String eval(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            String string = this.print(iTraceMessage, iTraceEntityResolver, n);
            return StringUtils.padString(string, this.width, this.crop ? 1 : 4);
        }
    }

    private class LevelColumn
    extends Column {
        public LevelColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            if (this.resolve) {
                return TraceLevels.levelNames[iTraceMessage.getLevel()];
            }
            return Short.toString(iTraceMessage.getLevel());
        }
    }

    private class MsgModColumn
    extends Column {
        public MsgModColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            return Short.toString(iTraceMessage.getModifiers());
        }
    }

    private class SeqNumColumn
    extends Column {
        public SeqNumColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            return Integer.toString(iTraceMessage.getSeqNum());
        }
    }

    private class MsgTypeColumn
    extends Column {
        public MsgTypeColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            return Short.toString(iTraceMessage.getMessageType());
        }
    }

    private class ThreadIdColumn
    extends Column {
        public ThreadIdColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            if (this.resolve) {
                return iTraceEntityResolver.resolveName(new TraceEntityURI(2, iTraceMessage.getThreadID()));
            }
            return Integer.toString(iTraceMessage.getThreadID());
        }
    }

    private class ChannelIdColumn
    extends Column {
        public ChannelIdColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            if (this.resolve) {
                return iTraceEntityResolver.resolvePath(new TraceEntityURI(3, iTraceMessage.getChannelID()), true);
            }
            return Integer.toString(iTraceMessage.getChannelID());
        }
    }

    private class MsgStringColumn
    extends Column {
        public MsgStringColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            return iTraceMessage.getDecodedMessage()[n];
        }
    }

    private class ProcessIdColumn
    extends Column {
        public ProcessIdColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            if (this.resolve) {
                return iTraceEntityResolver.resolveParentName(new TraceEntityURI(2, iTraceMessage.getThreadID()), (short)1);
            }
            return "???";
        }
    }

    private class TimeStampColumn
    extends Column {
        private final SimpleDateFormat sdf;

        public TimeStampColumn(IConfigQuery iConfigQuery) {
            super(iConfigQuery);
            String string = iConfigQuery.getStringValue("format", "HH:mm:ss.SSS");
            this.sdf = new SimpleDateFormat(string);
            this.sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
            return this.sdf.format(new Date(iTraceMessage.getTimeStamp()));
        }
    }
}

