.version 50 0 
.class public super [149] 
.super [151] 
.field private static final [152] [153] 
.field private static [154] [155] 
.field private [156] [157] 

.method public [159] : [160] 
    .attribute [158] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [27] 
L17:    invokespecial [28] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [34] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [161] : [162] 
    .attribute [158] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [29] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [158] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [158] .code stack 4 locals 1 
        .catch [12] from L0 to L69 using L72 
L0:     iload_1 
L1:     lookupswitch 
            0 : L20 
            default : L42 

L20:    aload_2 
L21:    invokeinterface [35] 0 
L26:    istore 4 
L28:    aload_0 
L29:    getfield [22] 
L32:    iload 4 
L34:    invokeinterface [36] 0 
L39:    goto L69 
L42:    new [37] 
L45:    dup 
L46:    new [38] 
L49:    dup 
L50:    invokespecial [31] 
L53:    ldc [11] 
L55:    invokevirtual [23] 
L58:    iload_1 
L59:    invokevirtual [24] 
L62:    invokevirtual [25] 
L65:    invokespecial [32] 
L68:    athrow 
L69:    goto L114 
L72:    astore 4 
L74:    new [37] 
L77:    dup 
L78:    new [38] 
L81:    dup 
L82:    invokespecial [31] 
L85:    ldc [13] 
L87:    invokevirtual [23] 
L90:    iload_1 
L91:    invokevirtual [24] 
L94:    ldc [14] 
L96:    invokevirtual [23] 
L99:    aload 4 
L101:   invokevirtual [26] 
L104:   invokevirtual [23] 
L107:   invokevirtual [25] 
L110:   invokespecial [32] 
L113:   athrow 
L114:   return 
L115:   nop 
L116:   
    .end code 
.end method 

.method static [167] : [168] 
    .attribute [158] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
L8:     iconst_0 
L9:     putstatic [29] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = String [40] 
.const [4] = Method [41] [42] 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = Field [45] [46] 
.const [8] = Field [47] [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = String [51] 
.const [12] = Class [52] 
.const [13] = String [53] 
.const [14] = String [54] 
.const [15] = String [55] 
.const [16] = Method [56] [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Class [60] 
.const [20] = Class [61] 
.const [21] = Class [62] 
.const [22] = Field [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Field [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Class [85] 
.const [34] = Field [86] [87] 
.const [35] = InterfaceMethod [88] [89] 
.const [36] = InterfaceMethod [90] [91] 
.const [37] = Class [92] 
.const [38] = Class [93] 
.const [39] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [40] = Utf8 '116d951a-df12-5d02-93b4-69573b9d69b5' 
.const [41] = Class [94] 
.const [42] = NameAndType [95] [96] 
.const [43] = Utf8 eddb9230-0b3c-558e-b321-dbb0a049fbfb 
.const [44] = Utf8 'asi.persistence.GEM' 
.const [45] = Class [97] 
.const [46] = NameAndType [98] [99] 
.const [47] = Class [100] 
.const [48] = NameAndType [101] [102] 
.const [49] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 'Invalid Method Id ' 
.const [52] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [53] = Utf8 'Deserialization failed: method=' 
.const [54] = Utf8 ', error=' 
.const [55] = Utf8 'STUB.asi.persistence.GEM' 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [59] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [60] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [61] = Utf8 de/esolutions/fw/comm/asi/persistence/GEMReply 
.const [62] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Class [121] 
.const [74] = NameAndType [122] [123] 
.const [75] = Class [124] 
.const [76] = NameAndType [125] [126] 
.const [77] = Class [127] 
.const [78] = NameAndType [128] [129] 
.const [79] = Class [130] 
.const [80] = NameAndType [131] [132] 
.const [81] = Class [133] 
.const [82] = NameAndType [134] [135] 
.const [83] = Class [136] 
.const [84] = NameAndType [137] [138] 
.const [85] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [86] = Class [139] 
.const [87] = NameAndType [140] [141] 
.const [88] = Class [142] 
.const [89] = NameAndType [143] [144] 
.const [90] = Class [145] 
.const [91] = NameAndType [146] [147] 
.const [92] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [95] = Utf8 nextDynamicHandle 
.const [96] = Utf8 ()I 
.const [97] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [98] = Utf8 dynamicHandle 
.const [99] = Utf8 I 
.const [100] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [101] = Utf8 context 
.const [102] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [103] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [104] = Utf8 getContext 
.const [105] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [106] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [107] = Utf8 p_GEMReply 
.const [108] = Utf8 Lde/esolutions/fw/comm/asi/persistence/GEMReply; 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 append 
.const [111] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 append 
.const [114] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 toString 
.const [117] = Utf8 ()Ljava/lang/String; 
.const [118] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [119] = Utf8 getMessage 
.const [120] = Utf8 ()Ljava/lang/String; 
.const [121] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [124] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [127] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [128] = Utf8 dynamicHandle 
.const [129] = Utf8 I 
.const [130] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [131] = Utf8 context 
.const [132] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Ljava/lang/String;)V 
.const [139] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [140] = Utf8 p_GEMReply 
.const [141] = Utf8 Lde/esolutions/fw/comm/asi/persistence/GEMReply; 
.const [142] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [143] = Utf8 getBool 
.const [144] = Utf8 ()Z 
.const [145] = Utf8 de/esolutions/fw/comm/asi/persistence/GEMReply 
.const [146] = Utf8 gemActive 
.const [147] = Utf8 (Z)V 
.const [148] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/GEMReplyService 
.const [149] = Class [148] 
.const [150] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [151] = Class [150] 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 dynamicHandle 
.const [155] = Utf8 I 
.const [156] = Utf8 p_GEMReply 
.const [157] = Utf8 Lde/esolutions/fw/comm/asi/persistence/GEMReply; 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/esolutions/fw/comm/asi/persistence/GEMReply;)V 
.const [161] = Utf8 nextDynamicHandle 
.const [162] = Utf8 ()I 
.const [163] = Utf8 getCallContext 
.const [164] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [165] = Utf8 handleCallMethod 
.const [166] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [167] = Utf8 <clinit> 
.const [168] = Utf8 ()V 
.end class 
