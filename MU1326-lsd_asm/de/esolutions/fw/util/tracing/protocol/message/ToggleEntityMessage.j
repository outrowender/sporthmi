.version 50 0 
.class public super [133] 
.super [135] 
.field private [136] [137] 
.field private [138] [139] 

.method public [141] : [142] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     invokespecial [20] 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [22] 
L12:    aload_0 
L13:    iload_2 
L14:    putfield [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     invokespecial [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [13] 
L5:     invokevirtual [15] 
L8:     invokeinterface [24] 0 
L13:    aload_1 
L14:    aload_0 
L15:    getfield [13] 
L18:    invokevirtual [16] 
L21:    invokeinterface [25] 0 
L26:    aload_1 
L27:    aload_0 
L28:    getfield [14] 
L31:    ifeq L38 
L34:    iconst_1 
L35:    goto L39 
L38:    iconst_0 
L39:    invokeinterface [26] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [140] .code stack 5 locals 3 
L0:     aload_1 
L1:     invokeinterface [27] 0 
L6:     istore_2 
L7:     aload_1 
L8:     invokeinterface [28] 0 
L13:    istore_3 
L14:    aload_1 
L15:    invokeinterface [29] 0 
L20:    istore 4 
L22:    aload_0 
L23:    new [30] 
L26:    dup 
L27:    iload_2 
L28:    iload_3 
L29:    invokespecial [21] 
L32:    putfield [22] 
L35:    aload_0 
L36:    iload 4 
L38:    ifeq L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    putfield [23] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public interface [149] : [150] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [151] : [152] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_1 
L1:     ldc [4] 
L3:     invokevirtual [17] 
L6:     pop 
L7:     aload_1 
L8:     aload_0 
L9:     getfield [13] 
L12:    invokevirtual [15] 
L15:    invokevirtual [18] 
L18:    pop 
L19:    aload_1 
L20:    ldc [5] 
L22:    invokevirtual [17] 
L25:    pop 
L26:    aload_1 
L27:    aload_0 
L28:    getfield [13] 
L31:    invokevirtual [16] 
L34:    invokevirtual [18] 
L37:    pop 
L38:    aload_1 
L39:    ldc [6] 
L41:    invokevirtual [17] 
L44:    pop 
L45:    aload_1 
L46:    aload_0 
L47:    getfield [14] 
L50:    invokevirtual [19] 
L53:    pop 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [31] [32] 
.const [3] = Class [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = InterfaceMethod [65] [66] 
.const [25] = InterfaceMethod [67] [68] 
.const [26] = InterfaceMethod [69] [70] 
.const [27] = InterfaceMethod [71] [72] 
.const [28] = InterfaceMethod [73] [74] 
.const [29] = InterfaceMethod [75] [76] 
.const [30] = Class [77] 
.const [31] = Class [78] 
.const [32] = NameAndType [79] [80] 
.const [33] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [34] = Utf8 'Toggle Entity: type=' 
.const [35] = Utf8 ' id=' 
.const [36] = Utf8 ' on=' 
.const [37] = Utf8 de/esolutions/fw/util/tracing/protocol/message/ToggleEntityMessage 
.const [38] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [39] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageType 
.const [40] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [41] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [42] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Class [117] 
.const [68] = NameAndType [118] [119] 
.const [69] = Class [120] 
.const [70] = NameAndType [121] [122] 
.const [71] = Class [123] 
.const [72] = NameAndType [124] [125] 
.const [73] = Class [126] 
.const [74] = NameAndType [127] [128] 
.const [75] = Class [129] 
.const [76] = NameAndType [130] [131] 
.const [77] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [78] = Utf8 de/esolutions/fw/util/tracing/protocol/message/MessageType 
.const [79] = Utf8 TOGGLE_ENTITY 
.const [80] = Utf8 Lde/esolutions/fw/util/tracing/protocol/message/MessageType; 
.const [81] = Utf8 de/esolutions/fw/util/tracing/protocol/message/ToggleEntityMessage 
.const [82] = Utf8 uri 
.const [83] = Utf8 Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.const [84] = Utf8 de/esolutions/fw/util/tracing/protocol/message/ToggleEntityMessage 
.const [85] = Utf8 on 
.const [86] = Utf8 Z 
.const [87] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [88] = Utf8 getType 
.const [89] = Utf8 ()S 
.const [90] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [91] = Utf8 getId 
.const [92] = Utf8 ()I 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Utf8 append 
.const [98] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [99] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [100] = Utf8 append 
.const [101] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [102] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/esolutions/fw/util/tracing/protocol/message/MessageType;)V 
.const [105] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (SI)V 
.const [108] = Utf8 de/esolutions/fw/util/tracing/protocol/message/ToggleEntityMessage 
.const [109] = Utf8 uri 
.const [110] = Utf8 Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.const [111] = Utf8 de/esolutions/fw/util/tracing/protocol/message/ToggleEntityMessage 
.const [112] = Utf8 on 
.const [113] = Utf8 Z 
.const [114] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [115] = Utf8 putInt16 
.const [116] = Utf8 (S)V 
.const [117] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [118] = Utf8 putInt32 
.const [119] = Utf8 (I)V 
.const [120] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [121] = Utf8 putInt8 
.const [122] = Utf8 (B)V 
.const [123] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [124] = Utf8 getInt16 
.const [125] = Utf8 ()S 
.const [126] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [127] = Utf8 getInt32 
.const [128] = Utf8 ()I 
.const [129] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [130] = Utf8 getInt8 
.const [131] = Utf8 ()B 
.const [132] = Utf8 de/esolutions/fw/util/tracing/protocol/message/ToggleEntityMessage 
.const [133] = Class [132] 
.const [134] = Utf8 de/esolutions/fw/util/tracing/protocol/message/AbstractMessage 
.const [135] = Class [134] 
.const [136] = Utf8 uri 
.const [137] = Utf8 Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.const [138] = Utf8 on 
.const [139] = Utf8 Z 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;Z)V 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 serializeElements 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [147] = Utf8 deserializeElements 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [149] = Utf8 getUri 
.const [150] = Utf8 ()Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.const [151] = Utf8 getOn 
.const [152] = Utf8 ()Z 
.const [153] = Utf8 toStringBuffer 
.const [154] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.end class 
