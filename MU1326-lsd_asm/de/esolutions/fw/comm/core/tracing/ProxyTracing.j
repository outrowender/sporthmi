.version 50 0 
.class public super [131] 
.super [133] 
.implements [135] 
.field private static [136] [137] 
.field private final [138] [139] 
.field private final [140] [141] 
.field private final [142] [143] 
.field private final [144] [145] 
.field private [146] [147] 

.method public static [149] : [150] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     putstatic [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [151] : [152] 
    .attribute [148] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     ifnull L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [19] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [20] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [21] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_3 
L2:     invokeinterface [22] 0 
L7:     putfield [23] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [148] .code stack 8 locals 5 
L0:     getstatic [2] 
L3:     ifnonnull L7 
L6:     return 
L7:     aload_3 
L8:     invokeinterface [24] 0 
L13:    astore 4 
L15:    aload_3 
L16:    invokeinterface [22] 0 
L21:    aload_0 
L22:    getfield [13] 
L25:    isub 
L26:    istore 5 
L28:    aload_0 
L29:    getfield [11] 
L32:    ifnull L109 
L35:    aload 4 
L37:    invokeinterface [25] 0 
L42:    astore 6 
L44:    iload 5 
L46:    ifne L57 
L49:    aconst_null 
L50:    astore 6 
L52:    aload_0 
L53:    iconst_0 
L54:    putfield [23] 
L57:    new [26] 
L60:    dup 
L61:    aload 6 
L63:    iload 5 
L65:    aload_0 
L66:    getfield [13] 
L69:    invokespecial [17] 
L72:    astore 7 
L74:    aload_3 
L75:    invokeinterface [27] 0 
L80:    astore 8 
L82:    getstatic [2] 
L85:    aload_0 
L86:    getfield [11] 
L89:    aload 8 
L91:    aload_0 
L92:    getfield [9] 
L95:    aload_0 
L96:    getfield [10] 
L99:    iload_2 
L100:   aload 7 
L102:   aload_0 
L103:   getfield [12] 
L106:   invokevirtual [14] 
L109:   return 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [28] [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Field [36] [37] 
.const [10] = Field [38] [39] 
.const [11] = Field [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Method [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Field [54] [55] 
.const [19] = Field [56] [57] 
.const [20] = Field [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = InterfaceMethod [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = InterfaceMethod [66] [67] 
.const [25] = InterfaceMethod [68] [69] 
.const [26] = Class [70] 
.const [27] = InterfaceMethod [71] [72] 
.const [28] = Class [73] 
.const [29] = NameAndType [74] [75] 
.const [30] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [31] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [34] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [35] = Utf8 de/esolutions/fw/comm/core/tracing/CommMessageTracing 
.const [36] = Class [76] 
.const [37] = NameAndType [77] [78] 
.const [38] = Class [79] 
.const [39] = NameAndType [80] [81] 
.const [40] = Class [82] 
.const [41] = NameAndType [83] [84] 
.const [42] = Class [85] 
.const [43] = NameAndType [86] [87] 
.const [44] = Class [88] 
.const [45] = NameAndType [89] [90] 
.const [46] = Class [91] 
.const [47] = NameAndType [92] [93] 
.const [48] = Class [94] 
.const [49] = NameAndType [95] [96] 
.const [50] = Class [97] 
.const [51] = NameAndType [98] [99] 
.const [52] = Class [100] 
.const [53] = NameAndType [101] [102] 
.const [54] = Class [103] 
.const [55] = NameAndType [104] [105] 
.const [56] = Class [106] 
.const [57] = NameAndType [107] [108] 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Class [112] 
.const [61] = NameAndType [113] [114] 
.const [62] = Class [115] 
.const [63] = NameAndType [116] [117] 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Class [121] 
.const [67] = NameAndType [122] [123] 
.const [68] = Class [124] 
.const [69] = NameAndType [125] [126] 
.const [70] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [74] = Utf8 commMessageTracing 
.const [75] = Utf8 Lde/esolutions/fw/comm/core/tracing/CommMessageTracing; 
.const [76] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [77] = Utf8 proxy 
.const [78] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [79] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [80] = Utf8 peerAgentID 
.const [81] = Utf8 S 
.const [82] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [83] = Utf8 channel 
.const [84] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [85] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [86] = Utf8 callCount 
.const [87] = Utf8 I 
.const [88] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [89] = Utf8 offset 
.const [90] = Utf8 I 
.const [91] = Utf8 de/esolutions/fw/comm/core/tracing/CommMessageTracing 
.const [92] = Utf8 logProxy 
.const [93] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;Lde/esolutions/fw/util/serializer/IStreamSerializer;Lde/esolutions/fw/comm/core/Proxy;SSLde/esolutions/fw/comm/core/tracing/SubBuffer;I)V 
.const [94] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [95] = Utf8 commMessageTracing 
.const [96] = Utf8 Lde/esolutions/fw/comm/core/tracing/CommMessageTracing; 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ([BII)V 
.const [103] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [104] = Utf8 proxy 
.const [105] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [106] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [107] = Utf8 peerAgentID 
.const [108] = Utf8 S 
.const [109] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [110] = Utf8 channel 
.const [111] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [112] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [113] = Utf8 callCount 
.const [114] = Utf8 I 
.const [115] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [116] = Utf8 getDirectPos 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [119] = Utf8 offset 
.const [120] = Utf8 I 
.const [121] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [122] = Utf8 getAttachedBuffer 
.const [123] = Utf8 ()Lde/esolutions/fw/util/transport/IWriteable; 
.const [124] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [125] = Utf8 getDirectData 
.const [126] = Utf8 ()[B 
.const [127] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [128] = Utf8 createCompatibleStreamSerializer 
.const [129] = Utf8 ()Lde/esolutions/fw/util/serializer/IStreamSerializer; 
.const [130] = Utf8 de/esolutions/fw/comm/core/tracing/ProxyTracing 
.const [131] = Class [130] 
.const [132] = Utf8 java/lang/Object 
.const [133] = Class [132] 
.const [134] = Utf8 de/esolutions/fw/comm/core/message/ICallMethodSerializeCallback 
.const [135] = Class [134] 
.const [136] = Utf8 commMessageTracing 
.const [137] = Utf8 Lde/esolutions/fw/comm/core/tracing/CommMessageTracing; 
.const [138] = Utf8 proxy 
.const [139] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [140] = Utf8 peerAgentID 
.const [141] = Utf8 S 
.const [142] = Utf8 channel 
.const [143] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [144] = Utf8 callCount 
.const [145] = Utf8 I 
.const [146] = Utf8 offset 
.const [147] = Utf8 I 
.const [148] = Utf8 Code 
.const [149] = Utf8 setTracing 
.const [150] = Utf8 (Lde/esolutions/fw/comm/core/tracing/CommMessageTracing;)V 
.const [151] = Utf8 isEnabled 
.const [152] = Utf8 ()Z 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;SLde/esolutions/fw/util/tracing/TraceChannel;I)V 
.const [155] = Utf8 beginSerializeCallMethodPayload 
.const [156] = Utf8 (SSLde/esolutions/fw/util/serializer/ISerializer;)V 
.const [157] = Utf8 endSerializeCallMethodPayload 
.const [158] = Utf8 (SSLde/esolutions/fw/util/serializer/ISerializer;)V 
.end class 
