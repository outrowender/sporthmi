/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessageV4;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV3;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV4;
import de.esolutions.fw.comm.core.message.CallMethodMessage;
import de.esolutions.fw.comm.core.message.CreateRRStubMessage;
import de.esolutions.fw.comm.core.message.CreateStubMessage;
import de.esolutions.fw.comm.core.message.DestroyStubMessage;
import de.esolutions.fw.comm.core.message.DropMessage;
import de.esolutions.fw.comm.core.message.ExitMessage;
import de.esolutions.fw.comm.core.message.HelloMessage;
import de.esolutions.fw.comm.core.message.InitMessage;
import de.esolutions.fw.comm.core.message.InitMessageV4;
import de.esolutions.fw.comm.core.message.PingMessage;
import de.esolutions.fw.comm.core.message.ProxyAliveMessage;
import de.esolutions.fw.comm.core.message.RRStubCreatedMessage;
import de.esolutions.fw.comm.core.message.RawMessage;
import de.esolutions.fw.comm.core.message.RejectMessage;
import de.esolutions.fw.comm.core.message.SetFeatureMessage;
import de.esolutions.fw.comm.core.message.StubCreatedMessage;
import de.esolutions.fw.comm.core.message.StubFailedMessage;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MessageType {
    private static final byte TYPE_INIT = 0;
    private static final byte TYPE_ANNOUNCE_FEATURE = 1;
    private static final byte TYPE_SET_FEATURE = 2;
    private static final byte TYPE_CREATE_STUB = 3;
    private static final byte TYPE_STUB_CREATED = 4;
    private static final byte TYPE_DESTROY_STUB = 5;
    private static final byte TYPE_CALL_METHOD = 6;
    private static final byte TYPE_PROXY_ALIVE = 7;
    private static final byte TYPE_EXIT = 8;
    private static final byte TYPE_BROKER_ACK = 9;
    private static final byte TYPE_DROP = 10;
    private static final byte TYPE_STUB_FAILED = 11;
    private static final byte TYPE_CREATE_RRSTUB = 12;
    private static final byte TYPE_RRSTUB_CREATED = 13;
    private static final byte TYPE_PING = 14;
    private static final byte TYPE_HELLO = 16;
    private static final byte TYPE_REJECT = 17;
    public static final MessageType INIT = new MessageType(0);
    public static final MessageType ANNOUNCE_FEATURE = new MessageType(1);
    public static final MessageType SET_FEATURE = new MessageType(2);
    public static final MessageType CREATE_STUB = new MessageType(3);
    public static final MessageType STUB_CREATED = new MessageType(4);
    public static final MessageType DESTROY_STUB = new MessageType(5);
    public static final MessageType CALL_METHOD = new MessageType(6);
    public static final MessageType PROXY_ALIVE = new MessageType(7);
    public static final MessageType EXIT = new MessageType(8);
    public static final MessageType BROKER_ACK = new MessageType(9);
    public static final MessageType DROP = new MessageType(10);
    public static final MessageType STUB_FAILED = new MessageType(11);
    public static final MessageType CREATE_RRSTUB = new MessageType(12);
    public static final MessageType RRSTUB_CREATED = new MessageType(13);
    public static final MessageType PING = new MessageType(14);
    public static final MessageType HELLO = new MessageType(16);
    public static final MessageType REJECT = new MessageType(17);
    public static final String UNKNOWN_MESSAGE_STRING = "UNKNOWN";
    private final byte type;

    private MessageType(byte by) {
        this.type = by;
    }

    public byte toByte() {
        return this.type;
    }

    public static MessageType getType(byte by) {
        MessageType messageType;
        switch (by) {
            case 0: {
                messageType = INIT;
                break;
            }
            case 1: {
                messageType = ANNOUNCE_FEATURE;
                break;
            }
            case 2: {
                messageType = SET_FEATURE;
                break;
            }
            case 3: {
                messageType = CREATE_STUB;
                break;
            }
            case 4: {
                messageType = STUB_CREATED;
                break;
            }
            case 5: {
                messageType = DESTROY_STUB;
                break;
            }
            case 6: {
                messageType = CALL_METHOD;
                break;
            }
            case 7: {
                messageType = PROXY_ALIVE;
                break;
            }
            case 8: {
                messageType = EXIT;
                break;
            }
            case 9: {
                messageType = BROKER_ACK;
                break;
            }
            case 10: {
                messageType = DROP;
                break;
            }
            case 11: {
                messageType = STUB_FAILED;
                break;
            }
            case 12: {
                messageType = CREATE_RRSTUB;
                break;
            }
            case 13: {
                messageType = RRSTUB_CREATED;
                break;
            }
            case 14: {
                messageType = PING;
                break;
            }
            case 16: {
                messageType = HELLO;
                break;
            }
            case 17: {
                messageType = REJECT;
                break;
            }
            default: {
                messageType = new MessageType(by);
            }
        }
        return messageType;
    }

    public AbstractMessage createMessage(IDeserializer iDeserializer, boolean bl, byte by) throws SerializerException {
        switch (this.type) {
            case 0: {
                if (by < 4) {
                    return new InitMessage(iDeserializer, bl);
                }
                return new InitMessageV4(iDeserializer, bl);
            }
            case 1: {
                if (by < 4) {
                    return new AnnounceFeatureMessage(iDeserializer, bl);
                }
                return new AnnounceFeatureMessageV4(iDeserializer, bl);
            }
            case 2: {
                return new SetFeatureMessage(iDeserializer, bl);
            }
            case 3: {
                return new CreateStubMessage(iDeserializer, bl);
            }
            case 4: {
                return new StubCreatedMessage(iDeserializer, bl);
            }
            case 5: {
                return new DestroyStubMessage(iDeserializer, bl);
            }
            case 6: {
                return new CallMethodMessage(iDeserializer, bl);
            }
            case 7: {
                return new ProxyAliveMessage(iDeserializer, bl);
            }
            case 8: {
                return new ExitMessage(iDeserializer, bl);
            }
            case 9: {
                if (by < 3) {
                    return new BrokerAckMessage(iDeserializer, bl);
                }
                if (by == 3) {
                    return new BrokerAckMessageV3(iDeserializer, bl);
                }
                return new BrokerAckMessageV4(iDeserializer, bl);
            }
            case 10: {
                return new DropMessage(iDeserializer, bl);
            }
            case 11: {
                return new StubFailedMessage(iDeserializer, bl);
            }
            case 12: {
                return new CreateRRStubMessage(iDeserializer, bl);
            }
            case 13: {
                return new RRStubCreatedMessage(iDeserializer, bl);
            }
            case 14: {
                return new PingMessage(iDeserializer, bl);
            }
            case 16: {
                return new HelloMessage(iDeserializer, bl);
            }
            case 17: {
                return new RejectMessage(iDeserializer, bl);
            }
        }
        return new RawMessage(new MessageType(this.type), iDeserializer, bl);
    }

    public String toString() {
        switch (this.type) {
            case 0: {
                return "INIT";
            }
            case 1: {
                return "ANNOUNCE_FEATURE";
            }
            case 2: {
                return "SET_FEATURE";
            }
            case 3: {
                return "CREATE STUB";
            }
            case 4: {
                return "STUB_CREATED";
            }
            case 5: {
                return "DESTROY_STUB";
            }
            case 6: {
                return "CALL_METHOD";
            }
            case 7: {
                return "PROXY_ALIVE";
            }
            case 8: {
                return "EXIT";
            }
            case 9: {
                return "BROKER_ACK";
            }
            case 10: {
                return "DROP";
            }
            case 11: {
                return "STUB_FAILED";
            }
            case 12: {
                return "CREATE_RRSTUB";
            }
            case 13: {
                return "RRSTUB_CREATED";
            }
            case 14: {
                return "PING";
            }
            case 16: {
                return "HELLO";
            }
            case 17: {
                return "REJECT";
            }
        }
        return UNKNOWN_MESSAGE_STRING;
    }
}

