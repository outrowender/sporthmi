.version 50 0 
.class public super [107] 
.super [109] 
.field private static [110] [111] 
.field private final [112] [113] 
.field private final [114] [115] 
.field private final [116] [117] 

.method public static [119] : [120] 
    .attribute [118] .code stack 1 locals 0 
L0:     aload_0 
L1:     putstatic [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [121] : [122] 
    .attribute [118] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     ifnull L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [17] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [18] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 7 locals 6 
L0:     getstatic [2] 
L3:     ifnonnull L7 
L6:     return 
L7:     aload_2 
L8:     invokeinterface [19] 0 
L13:    astore_3 
L14:    aload_3 
L15:    invokeinterface [20] 0 
L20:    astore 4 
L22:    aload_3 
L23:    invokeinterface [21] 0 
L28:    istore 5 
L30:    aload 4 
L32:    arraylength 
L33:    iload 5 
L35:    isub 
L36:    istore 6 
L38:    new [22] 
L41:    dup 
L42:    aload 4 
L44:    iload 6 
L46:    iload 5 
L48:    invokespecial [15] 
L51:    astore 7 
L53:    aload_2 
L54:    invokeinterface [23] 0 
L59:    astore 8 
L61:    getstatic [2] 
L64:    aload_0 
L65:    getfield [10] 
L68:    aload 8 
L70:    aload_0 
L71:    getfield [9] 
L74:    iload_1 
L75:    aload 7 
L77:    aload_0 
L78:    getfield [11] 
L81:    invokevirtual [12] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [24] [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Field [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Field [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Field [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Field [46] [47] 
.const [17] = Field [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = InterfaceMethod [52] [53] 
.const [20] = InterfaceMethod [54] [55] 
.const [21] = InterfaceMethod [56] [57] 
.const [22] = Class [58] 
.const [23] = InterfaceMethod [59] [60] 
.const [24] = Class [61] 
.const [25] = NameAndType [62] [63] 
.const [26] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [27] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [30] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [31] = Utf8 de/esolutions/fw/comm/core/tracing/CommMessageTracing 
.const [32] = Class [64] 
.const [33] = NameAndType [65] [66] 
.const [34] = Class [67] 
.const [35] = NameAndType [68] [69] 
.const [36] = Class [70] 
.const [37] = NameAndType [71] [72] 
.const [38] = Class [73] 
.const [39] = NameAndType [74] [75] 
.const [40] = Class [76] 
.const [41] = NameAndType [77] [78] 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [62] = Utf8 commMessageTracing 
.const [63] = Utf8 Lde/esolutions/fw/comm/core/tracing/CommMessageTracing; 
.const [64] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [65] = Utf8 stub 
.const [66] = Utf8 Lde/esolutions/fw/comm/core/IStub; 
.const [67] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [68] = Utf8 channel 
.const [69] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [70] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [71] = Utf8 callCount 
.const [72] = Utf8 I 
.const [73] = Utf8 de/esolutions/fw/comm/core/tracing/CommMessageTracing 
.const [74] = Utf8 logStub 
.const [75] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;Lde/esolutions/fw/util/serializer/IStreamSerializer;Lde/esolutions/fw/comm/core/IStub;SLde/esolutions/fw/comm/core/tracing/SubBuffer;I)V 
.const [76] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [77] = Utf8 commMessageTracing 
.const [78] = Utf8 Lde/esolutions/fw/comm/core/tracing/CommMessageTracing; 
.const [79] = Utf8 java/lang/Object 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ([BII)V 
.const [85] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [86] = Utf8 stub 
.const [87] = Utf8 Lde/esolutions/fw/comm/core/IStub; 
.const [88] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [89] = Utf8 channel 
.const [90] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [91] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [92] = Utf8 callCount 
.const [93] = Utf8 I 
.const [94] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [95] = Utf8 getAttachedBuffer 
.const [96] = Utf8 ()Lde/esolutions/fw/util/transport/IReadable; 
.const [97] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [98] = Utf8 getDirectData 
.const [99] = Utf8 ()[B 
.const [100] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [101] = Utf8 getDirectOffset 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [104] = Utf8 createCompatibleSerializer 
.const [105] = Utf8 ()Lde/esolutions/fw/util/serializer/ISerializer; 
.const [106] = Utf8 de/esolutions/fw/comm/core/tracing/StubTracing 
.const [107] = Class [106] 
.const [108] = Utf8 java/lang/Object 
.const [109] = Class [108] 
.const [110] = Utf8 commMessageTracing 
.const [111] = Utf8 Lde/esolutions/fw/comm/core/tracing/CommMessageTracing; 
.const [112] = Utf8 stub 
.const [113] = Utf8 Lde/esolutions/fw/comm/core/IStub; 
.const [114] = Utf8 channel 
.const [115] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [116] = Utf8 callCount 
.const [117] = Utf8 I 
.const [118] = Utf8 Code 
.const [119] = Utf8 setTracing 
.const [120] = Utf8 (Lde/esolutions/fw/comm/core/tracing/CommMessageTracing;)V 
.const [121] = Utf8 isEnabled 
.const [122] = Utf8 ()Z 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/esolutions/fw/comm/core/IStub;Lde/esolutions/fw/util/tracing/TraceChannel;I)V 
.const [125] = Utf8 log 
.const [126] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;)V 
.end class 
