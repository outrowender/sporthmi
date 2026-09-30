/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.folderbrowsing;

public interface IFolderBrowsingService {
    public void requestEnterAccount(MessageType var1);

    public static final class ResultCode {
        public static final ResultCode OK = new ResultCode("OK");
        public static final ResultCode ERROR_GENERAL = new ResultCode("ERROR_GENERAL");
        public static final ResultCode ERROR_ILLEGAL_ARGUMENT = new ResultCode("ERROR_ILLEGAL_ARGUMENT");
        public static final ResultCode ERROR_ILLEGAL_STATE = new ResultCode("ERROR_ILLEGAL_STATE");
        private final String name;

        private ResultCode(String string) {
            this.name = string;
        }

        public String toString() {
            return this.name;
        }

        public boolean equals(Object object) {
            if (object instanceof ResultCode) {
                ResultCode resultCode = (ResultCode)object;
                return resultCode.name.equals(this.name);
            }
            return false;
        }
    }

    public static final class MessageType {
        public static final MessageType SMS = new MessageType("SMS");
        public static final MessageType EMAIL = new MessageType("EMAIL");
        private final String name;

        private MessageType(String string) {
            this.name = string;
        }

        public String toString() {
            return this.name;
        }
    }
}

