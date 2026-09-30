/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.id.uuid.state.Node;
import org.apache.commons.id.uuid.state.State;
import org.apache.commons.id.uuid.state.StateHelper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadOnlyResourceStateImpl
implements State {
    static long synchronizeInterval = Long.MAX_VALUE;
    static HashSet nodes = new HashSet();
    public static final String CONFIG_FILENAME_KEY = "org.apache.commons.id.uuid.config.resource.filename";

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void load() throws Exception {
        String string = System.getProperty(CONFIG_FILENAME_KEY);
        if (string == null) {
            throw new IllegalStateException("No value set for system property: org.apache.commons.id.uuid.config.resource.filename");
        }
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream(string);
            if (inputStream == null) {
                throw new IllegalStateException(string + " loaded as system resource is null");
            }
            this.parse(inputStream);
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    public long getSynchInterval() {
        return Long.MAX_VALUE;
    }

    public Set getNodes() {
        return nodes;
    }

    public void store(Set set) throws IOException {
    }

    public void store(Set set, long l) {
    }

    protected void parse(InputStream inputStream) throws Exception {
        StateConfigHandler stateConfigHandler = new StateConfigHandler();
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        sAXParserFactory.setValidating(true);
        SAXParser sAXParser = sAXParserFactory.newSAXParser();
        sAXParser.parse(inputStream, (DefaultHandler)stateConfigHandler);
    }

    class StateConfigHandler
    extends DefaultHandler {
        static final short UUID_STATE_TAG = 1;
        static final String UUID_STATE_TAG_STR = "uuidstate";
        static final String SYNCH_INTERVAL_STR = "synchinterval";
        static final short NODE_TAG = 2;
        static final String NODE_TAG_STR = "node";
        static final String ATTR_ID_STR = "id";
        static final String ATTR_CLOCKSEQ_STR = "clocksequence";
        static final String ATTR_LASTIMESTAMP_STR = "timestamp";

        StateConfigHandler() {
        }

        public void startElement(String string, String string2, String string3, Attributes attributes) throws SAXException {
            int n = 0;
            String string4 = string2;
            if ("".equals(string2)) {
                string4 = string3;
            }
            if (string4.equalsIgnoreCase(UUID_STATE_TAG_STR)) {
                n = 1;
            } else if (string4.equalsIgnoreCase(NODE_TAG_STR)) {
                n = 2;
            }
            if (attributes != null) {
                switch (n) {
                    case 1: {
                        this.processBodyTag(attributes);
                        break;
                    }
                    case 2: {
                        this.processNodeTag(attributes);
                        break;
                    }
                }
            }
        }

        private void processBodyTag(Attributes attributes) {
            for (int i2 = 0; i2 < attributes.getLength(); ++i2) {
                String string = attributes.getLocalName(i2);
                if ("".equals(string)) {
                    string = attributes.getQName(i2);
                }
                String string2 = attributes.getValue(i2);
                if (!string.equalsIgnoreCase(SYNCH_INTERVAL_STR)) continue;
                try {
                    synchronizeInterval = Long.parseLong(string2);
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    synchronizeInterval = 0L;
                }
            }
        }

        private void processNodeTag(Attributes attributes) {
            byte[] byArray = null;
            long l = 0L;
            short s = 0;
            for (int i2 = 0; i2 < attributes.getLength(); ++i2) {
                String string = attributes.getLocalName(i2);
                if ("".equals(string)) {
                    string = attributes.getQName(i2);
                }
                String string2 = attributes.getValue(i2);
                if (string.equalsIgnoreCase(ATTR_ID_STR)) {
                    byArray = StateHelper.decodeMACAddress(string2);
                    continue;
                }
                if (string.equalsIgnoreCase(ATTR_CLOCKSEQ_STR)) {
                    try {
                        s = Short.parseShort(string2);
                    }
                    catch (NumberFormatException numberFormatException) {
                        s = 0;
                    }
                    continue;
                }
                if (!string.equalsIgnoreCase(ATTR_LASTIMESTAMP_STR)) continue;
                try {
                    l = Long.parseLong(string2);
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    l = 0L;
                }
            }
            if (byArray != null) {
                if (s != 0) {
                    nodes.add(new Node(byArray, l, s));
                } else {
                    nodes.add(new Node(byArray));
                }
            }
        }
    }
}

