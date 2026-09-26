.version 50 0 
.class public final super [125] 
.super [127] 
.implements [129] 
.field private [130] [131] 
.field private [132] [133] 
.field private final [134] [135] 

.method public [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [21] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public final [139] : [140] 
    .attribute [136] .code stack 2 locals 1 
        .catch [2] from L0 to L29 using L30 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokeinterface [22] 0 
L9:     aload_0 
L10:    getfield [11] 
L13:    aload_0 
L14:    getfield [10] 
L17:    invokevirtual [12] 
L20:    aload_0 
L21:    getfield [10] 
L24:    invokeinterface [23] 0 
L29:    areturn 
L30:    astore_1 
L31:    iconst_0 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public final [141] : [142] 
    .attribute [136] .code stack 4 locals 1 
        .catch [2] from L0 to L31 using L34 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_1 
L5:     invokeinterface [24] 0 
L10:    aload_0 
L11:    getfield [11] 
L14:    aload_0 
L15:    getfield [10] 
L18:    invokevirtual [12] 
L21:    aload_0 
L22:    getfield [10] 
L25:    invokeinterface [25] 0 
L30:    pop 
L31:    goto L62 
L34:    astore_2 
L35:    new [26] 
L38:    dup 
L39:    new [27] 
L42:    dup 
L43:    invokespecial [18] 
L46:    ldc [5] 
L48:    invokevirtual [13] 
L51:    aload_2 
L52:    invokevirtual [14] 
L55:    invokevirtual [15] 
L58:    invokespecial [19] 
L61:    athrow 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public final [143] : [144] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final interface [145] : [146] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Field [37] [38] 
.const [11] = Field [39] [40] 
.const [12] = Method [41] [42] 
.const [13] = Method [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = InterfaceMethod [61] [62] 
.const [23] = InterfaceMethod [63] [64] 
.const [24] = InterfaceMethod [65] [66] 
.const [25] = InterfaceMethod [67] [68] 
.const [26] = Class [69] 
.const [27] = Class [70] 
.const [28] = Field [71] [72] 
.const [29] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [30] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [31] = Utf8 java/lang/StringBuffer 
.const [32] = Utf8 'Serializer failed with: ' 
.const [33] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [36] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [37] = Class [73] 
.const [38] = NameAndType [74] [75] 
.const [39] = Class [76] 
.const [40] = NameAndType [77] [78] 
.const [41] = Class [79] 
.const [42] = NameAndType [80] [81] 
.const [43] = Class [82] 
.const [44] = NameAndType [83] [84] 
.const [45] = Class [85] 
.const [46] = NameAndType [86] [87] 
.const [47] = Class [88] 
.const [48] = NameAndType [89] [90] 
.const [49] = Class [91] 
.const [50] = NameAndType [92] [93] 
.const [51] = Class [94] 
.const [52] = NameAndType [95] [96] 
.const [53] = Class [97] 
.const [54] = NameAndType [98] [99] 
.const [55] = Class [100] 
.const [56] = NameAndType [101] [102] 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [70] = Utf8 java/lang/StringBuffer 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [74] = Utf8 serializer 
.const [75] = Utf8 Lde/esolutions/fw/util/serializer/ISerializer; 
.const [76] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [77] = Utf8 message 
.const [78] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [79] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [80] = Utf8 serialize 
.const [81] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 append 
.const [84] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 append 
.const [87] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [88] = Utf8 java/lang/StringBuffer 
.const [89] = Utf8 toString 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [92] = Utf8 debugTag 
.const [93] = Utf8 Ljava/lang/Object; 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Ljava/lang/String;)V 
.const [103] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [104] = Utf8 serializer 
.const [105] = Utf8 Lde/esolutions/fw/util/serializer/ISerializer; 
.const [106] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [107] = Utf8 message 
.const [108] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [109] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [110] = Utf8 beginSizeCalc 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [113] = Utf8 endSizeCalc 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [116] = Utf8 attachBuffer 
.const [117] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [118] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [119] = Utf8 detachBuffer 
.const [120] = Utf8 ()I 
.const [121] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [122] = Utf8 debugTag 
.const [123] = Utf8 Ljava/lang/Object; 
.const [124] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessageWriter 
.const [125] = Class [124] 
.const [126] = Utf8 java/lang/Object 
.const [127] = Class [126] 
.const [128] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [129] = Class [128] 
.const [130] = Utf8 debugTag 
.const [131] = Utf8 Ljava/lang/Object; 
.const [132] = Utf8 serializer 
.const [133] = Utf8 Lde/esolutions/fw/util/serializer/ISerializer; 
.const [134] = Utf8 message 
.const [135] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage; 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/util/tracing/protocol/message/AbstractMessage;)V 
.const [139] = Utf8 size 
.const [140] = Utf8 ()I 
.const [141] = Utf8 write 
.const [142] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [143] = Utf8 setDebugTag 
.const [144] = Utf8 (Ljava/lang/Object;)V 
.const [145] = Utf8 getDebugTag 
.const [146] = Utf8 ()Ljava/lang/Object; 
.end class 
