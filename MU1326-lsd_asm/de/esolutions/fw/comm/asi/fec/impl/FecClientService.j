.version 50 0 
.class public super [131] 
.super [133] 
.field private static final [134] [135] 
.field private [136] [137] 

.method public [139] : [140] 
    .attribute [138] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [31] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [26] 
L15:    invokespecial [27] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [32] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [138] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [138] .code stack 4 locals 1 
        .catch [11] from L0 to L67 using L70 
L0:     iload_1 
L1:     lookupswitch 
            1 : L20 
            default : L40 

L20:    aload_2 
L21:    invokestatic [7] 
L24:    astore 4 
L26:    aload_0 
L27:    getfield [21] 
L30:    aload 4 
L32:    invokeinterface [33] 0 
L37:    goto L67 
L40:    new [34] 
L43:    dup 
L44:    new [35] 
L47:    dup 
L48:    invokespecial [29] 
L51:    ldc [10] 
L53:    invokevirtual [22] 
L56:    iload_1 
L57:    invokevirtual [23] 
L60:    invokevirtual [24] 
L63:    invokespecial [30] 
L66:    athrow 
L67:    goto L112 
L70:    astore 4 
L72:    new [34] 
L75:    dup 
L76:    new [35] 
L79:    dup 
L80:    invokespecial [29] 
L83:    ldc [12] 
L85:    invokevirtual [22] 
L88:    iload_1 
L89:    invokevirtual [23] 
L92:    ldc [13] 
L94:    invokevirtual [22] 
L97:    aload 4 
L99:    invokevirtual [25] 
L102:   invokevirtual [22] 
L105:   invokevirtual [24] 
L108:   invokespecial [30] 
L111:   athrow 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method static [145] : [146] 
    .attribute [138] .code stack 1 locals 0 
L0:     ldc [14] 
L2:     invokestatic [15] 
L5:     putstatic [28] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = String [37] 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = Field [40] [41] 
.const [7] = Method [42] [43] 
.const [8] = Class [44] 
.const [9] = Class [45] 
.const [10] = String [46] 
.const [11] = Class [47] 
.const [12] = String [48] 
.const [13] = String [49] 
.const [14] = String [50] 
.const [15] = Method [51] [52] 
.const [16] = Class [53] 
.const [17] = Class [54] 
.const [18] = Class [55] 
.const [19] = Class [56] 
.const [20] = Class [57] 
.const [21] = Field [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Class [78] 
.const [32] = Field [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Class [83] 
.const [35] = Class [84] 
.const [36] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [37] = Utf8 ff733e4d-6e39-49b8-b354-ee9c22f6cfc9 
.const [38] = Utf8 '41fc1271-3ffd-552d-a498-7d1f105d825a' 
.const [39] = Utf8 'asi.fec.FecClient' 
.const [40] = Class [85] 
.const [41] = NameAndType [86] [87] 
.const [42] = Class [88] 
.const [43] = NameAndType [89] [90] 
.const [44] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [45] = Utf8 java/lang/StringBuffer 
.const [46] = Utf8 'Invalid Method Id ' 
.const [47] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [48] = Utf8 'Deserialization failed: method=' 
.const [49] = Utf8 ', error=' 
.const [50] = Utf8 'STUB.asi.fec.FecClient' 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecClientService 
.const [54] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [55] = Utf8 de/esolutions/fw/comm/asi/fec/impl/SFecStateSerializer 
.const [56] = Utf8 de/esolutions/fw/comm/asi/fec/FecClient 
.const [57] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [58] = Class [94] 
.const [59] = NameAndType [95] [96] 
.const [60] = Class [97] 
.const [61] = NameAndType [98] [99] 
.const [62] = Class [100] 
.const [63] = NameAndType [101] [102] 
.const [64] = Class [103] 
.const [65] = NameAndType [104] [105] 
.const [66] = Class [106] 
.const [67] = NameAndType [107] [108] 
.const [68] = Class [109] 
.const [69] = NameAndType [110] [111] 
.const [70] = Class [112] 
.const [71] = NameAndType [113] [114] 
.const [72] = Class [115] 
.const [73] = NameAndType [116] [117] 
.const [74] = Class [118] 
.const [75] = NameAndType [119] [120] 
.const [76] = Class [121] 
.const [77] = NameAndType [122] [123] 
.const [78] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [79] = Class [124] 
.const [80] = NameAndType [125] [126] 
.const [81] = Class [127] 
.const [82] = NameAndType [128] [129] 
.const [83] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecClientService 
.const [86] = Utf8 context 
.const [87] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [88] = Utf8 de/esolutions/fw/comm/asi/fec/impl/SFecStateSerializer 
.const [89] = Utf8 getOptionalSFecStateVarArray 
.const [90] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/fec/SFecState; 
.const [91] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [92] = Utf8 getContext 
.const [93] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [94] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecClientService 
.const [95] = Utf8 p_FecClient 
.const [96] = Utf8 Lde/esolutions/fw/comm/asi/fec/FecClient; 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 append 
.const [102] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 toString 
.const [105] = Utf8 ()Ljava/lang/String; 
.const [106] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [107] = Utf8 getMessage 
.const [108] = Utf8 ()Ljava/lang/String; 
.const [109] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [112] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [115] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecClientService 
.const [116] = Utf8 context 
.const [117] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Ljava/lang/String;)V 
.const [124] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecClientService 
.const [125] = Utf8 p_FecClient 
.const [126] = Utf8 Lde/esolutions/fw/comm/asi/fec/FecClient; 
.const [127] = Utf8 de/esolutions/fw/comm/asi/fec/FecClient 
.const [128] = Utf8 updateFECs 
.const [129] = Utf8 ([Lde/esolutions/fw/comm/asi/fec/SFecState;)V 
.const [130] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecClientService 
.const [131] = Class [130] 
.const [132] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [133] = Class [132] 
.const [134] = Utf8 context 
.const [135] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [136] = Utf8 p_FecClient 
.const [137] = Utf8 Lde/esolutions/fw/comm/asi/fec/FecClient; 
.const [138] = Utf8 Code 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (ILde/esolutions/fw/comm/asi/fec/FecClient;)V 
.const [141] = Utf8 getCallContext 
.const [142] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [143] = Utf8 handleCallMethod 
.const [144] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [145] = Utf8 <clinit> 
.const [146] = Utf8 ()V 
.end class 
