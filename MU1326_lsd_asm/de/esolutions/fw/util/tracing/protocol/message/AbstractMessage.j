.version 50 0 
.class public super abstract [119] 
.super [121] 
.field private final [122] [123] 
.field private [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public final interface [129] : [130] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [131] : [132] 
    .attribute [126] .code stack 2 locals 1 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [10] 
L5:     invokevirtual [11] 
L8:     invokeinterface [20] 0 
L13:    aload_0 
L14:    aload_1 
L15:    invokevirtual [12] 
L18:    aload_1 
L19:    invokeinterface [21] 0 
L24:    astore_2 
L25:    aload_2 
L26:    ifnull L39 
L29:    aload_0 
L30:    aload_2 
L31:    invokeinterface [22] 0 
L36:    putfield [23] 
L39:    return 
L40:    
    .end code 
.end method 

.method public final [133] : [134] 
    .attribute [126] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [14] 
L5:     aload_1 
L6:     invokeinterface [24] 0 
L11:    astore_2 
L12:    aload_2 
L13:    ifnull L26 
L16:    aload_0 
L17:    aload_2 
L18:    invokeinterface [25] 0 
L23:    putfield [23] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected abstract [135] : [136] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [137] : [138] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [139] : [140] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [126] .code stack 2 locals 1 
L0:     new [26] 
L3:     dup 
L4:     invokespecial [18] 
L7:     astore_1 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [15] 
L13:    aload_1 
L14:    invokevirtual [16] 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [143] : [144] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [145] : [146] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [126] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [126] .code stack 2 locals 0 
L0:     ldc2_w [27] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [126] .code stack 2 locals 0 
L0:     ldc2_w [27] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [126] .code stack 1 locals 0 
L0:     iconst_m1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Field [37] [38] 
.const [11] = Method [39] [40] 
.const [12] = Method [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = InterfaceMethod [57] [58] 
.const [21] = InterfaceMethod [59] [60] 
.const [22] = InterfaceMethod [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = InterfaceMethod [65] [66] 
.const [25] = InterfaceMethod [67] [68] 
.const [26] = Class [69] 
.const [27] = Long -1L 
.const [29] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [30] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageType 
.const [33] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [34] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [35] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [36] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [71] = Utf8 type 
.const [72] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [73] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageType 
.const [74] = Utf8 toByte 
.const [75] = Utf8 ()B 
.const [76] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [77] = Utf8 serializeElements 
.const [78] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [79] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [80] = Utf8 size 
.const [81] = Utf8 I 
.const [82] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [83] = Utf8 deserializeElements 
.const [84] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [85] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [86] = Utf8 toStringBuffer 
.const [87] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 toString 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [98] = Utf8 type 
.const [99] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [100] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [101] = Utf8 putInt8 
.const [102] = Utf8 (B)V 
.const [103] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [104] = Utf8 getAttachedBuffer 
.const [105] = Utf8 ()Lde/esolutions/fw/util/transport/IWriteable; 
.const [106] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [107] = Utf8 size 
.const [108] = Utf8 ()I 
.const [109] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [110] = Utf8 size 
.const [111] = Utf8 I 
.const [112] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [113] = Utf8 getAttachedBuffer 
.const [114] = Utf8 ()Lde/esolutions/fw/util/transport/IReadable; 
.const [115] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [116] = Utf8 size 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 type 
.const [123] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [124] = Utf8 size 
.const [125] = Utf8 I 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/esolutions/fw/util/tracing/protocol/message/MessageType;)V 
.const [129] = Utf8 getMessageType 
.const [130] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [131] = Utf8 serialize 
.const [132] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [133] = Utf8 deserialize 
.const [134] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [135] = Utf8 serializeElements 
.const [136] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [137] = Utf8 deserializeElements 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [139] = Utf8 toStringBuffer 
.const [140] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [141] = Utf8 toString 
.const [142] = Utf8 ()Ljava/lang/String; 
.const [143] = Utf8 getProtocolMessageType 
.const [144] = Utf8 ()Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [145] = Utf8 getProtocolMessageSize 
.const [146] = Utf8 ()I 
.const [147] = Utf8 getRawDataPortion 
.const [148] = Utf8 ()[B 
.const [149] = Utf8 getTimeStamp 
.const [150] = Utf8 ()J 
.const [151] = Utf8 getExternalTimeStamp 
.const [152] = Utf8 ()J 
.const [153] = Utf8 getLevel 
.const [154] = Utf8 ()S 
.end class 
