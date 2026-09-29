.version 50 0 
.class public super [141] 
.super [143] 
.field protected [144] [145] 
.field protected [146] [147] 

.method public [149] : [150] 
    .attribute [148] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [15] 
L9:     putfield [29] 
L12:    aload_0 
L13:    new [30] 
L16:    dup 
L17:    aload_1 
L18:    invokevirtual [17] 
L21:    invokespecial [26] 
L24:    putfield [31] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [148] .code stack 4 locals 0 
L0:     aload_0 
L1:     new [30] 
L4:     dup 
L5:     aload_1 
L6:     invokespecial [26] 
L9:     putfield [31] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_0 
L5:     getfield [16] 
L8:     invokeinterface [32] 0 
L13:    invokevirtual [19] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [148] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [20] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L19 
L9:     new [33] 
L12:    dup 
L13:    ldc [4] 
L15:    invokespecial [27] 
L18:    athrow 
L19:    aload_1 
L20:    invokevirtual [21] 
L23:    getstatic [5] 
L26:    if_acmpeq L59 
L29:    new [33] 
L32:    dup 
L33:    new [34] 
L36:    dup 
L37:    invokespecial [28] 
L40:    ldc [7] 
L42:    invokevirtual [22] 
L45:    aload_1 
L46:    invokevirtual [21] 
L49:    invokevirtual [23] 
L52:    invokevirtual [24] 
L55:    invokespecial [27] 
L58:    athrow 
L59:    aload_1 
L60:    checkcast [8] 
L63:    areturn 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = String [37] 
.const [5] = Field [38] [39] 
.const [6] = Class [40] 
.const [7] = String [41] 
.const [8] = Class [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Method [49] [50] 
.const [16] = Field [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Field [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Class [79] 
.const [31] = Field [80] [81] 
.const [32] = InterfaceMethod [82] [83] 
.const [33] = Class [84] 
.const [34] = Class [85] 
.const [35] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageDecoder 
.const [36] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [37] = Utf8 'Invalid Received Comm Message' 
.const [38] = Class [86] 
.const [39] = NameAndType [87] [88] 
.const [40] = Utf8 java/lang/StringBuffer 
.const [41] = Utf8 'Expected INIT message, but got ' 
.const [42] = Utf8 de/esolutions/fw/util/tracing/protocol/message/InitMessage 
.const [43] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/esolutions/fw/util/serializer/connection/Connection 
.const [46] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [47] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [48] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageType 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Class [128] 
.const [76] = NameAndType [129] [130] 
.const [77] = Class [131] 
.const [78] = NameAndType [132] [133] 
.const [79] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageDecoder 
.const [80] = Class [134] 
.const [81] = NameAndType [135] [136] 
.const [82] = Class [137] 
.const [83] = NameAndType [138] [139] 
.const [84] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageType 
.const [87] = Utf8 INIT 
.const [88] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [89] = Utf8 de/esolutions/fw/util/serializer/connection/Connection 
.const [90] = Utf8 getTransport 
.const [91] = Utf8 ()Lde/esolutions/fw/util/transport/ITransport; 
.const [92] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [93] = Utf8 transport 
.const [94] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [95] = Utf8 de/esolutions/fw/util/serializer/connection/Connection 
.const [96] = Utf8 getDeserializer 
.const [97] = Utf8 ()Lde/esolutions/fw/util/serializer/IDeserializer; 
.const [98] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [99] = Utf8 decoder 
.const [100] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageDecoder; 
.const [101] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageDecoder 
.const [102] = Utf8 decodeReadable 
.const [103] = Utf8 (Lde/esolutions/fw/util/transport/IReadable;)Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [104] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [105] = Utf8 recvMessage 
.const [106] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [107] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [108] = Utf8 getMessageType 
.const [109] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 append 
.const [112] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 toString 
.const [118] = Utf8 ()Ljava/lang/String; 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageDecoder 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [125] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Ljava/lang/String;)V 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [132] = Utf8 transport 
.const [133] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [134] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [135] = Utf8 decoder 
.const [136] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageDecoder; 
.const [137] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [138] = Utf8 recv 
.const [139] = Utf8 ()Lde/esolutions/fw/util/transport/IReadable; 
.const [140] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageReceiver 
.const [141] = Class [140] 
.const [142] = Utf8 java/lang/Object 
.const [143] = Class [142] 
.const [144] = Utf8 transport 
.const [145] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [146] = Utf8 decoder 
.const [147] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageDecoder; 
.const [148] = Utf8 Code 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/connection/Connection;)V 
.const [151] = Utf8 setDeserializer 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [153] = Utf8 recvMessage 
.const [154] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [155] = Utf8 recvInitMessage 
.const [156] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/InitMessage; 
.end class 
