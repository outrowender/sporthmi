.version 50 0 
.class public super [147] 
.super [149] 
.field private static final [150] [151] 
.field private [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [32] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [26] 
L15:    invokespecial [27] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [33] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [154] .code stack 2 locals 0 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [154] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [154] .code stack 5 locals 3 
        .catch [11] from L0 to L93 using L96 
L0:     iload_1 
L1:     lookupswitch 
            0 : L20 
            default : L66 

L20:    aload_2 
L21:    invokeinterface [35] 0 
L26:    astore 4 
L28:    aload_2 
L29:    invokeinterface [36] 0 
L34:    istore 5 
L36:    aload_2 
L37:    invokeinterface [36] 0 
L42:    istore 6 
L44:    aload_0 
L45:    getfield [21] 
L48:    aload 4 
L50:    iload 5 
L52:    iload 6 
L54:    aload_3 
L55:    checkcast [6] 
L58:    invokeinterface [37] 0 
L63:    goto L93 
L66:    new [38] 
L69:    dup 
L70:    new [39] 
L73:    dup 
L74:    invokespecial [30] 
L77:    ldc [10] 
L79:    invokevirtual [22] 
L82:    iload_1 
L83:    invokevirtual [23] 
L86:    invokevirtual [24] 
L89:    invokespecial [31] 
L92:    athrow 
L93:    goto L138 
L96:    astore 4 
L98:    new [38] 
L101:   dup 
L102:   new [39] 
L105:   dup 
L106:   invokespecial [30] 
L109:   ldc [12] 
L111:   invokevirtual [22] 
L114:   iload_1 
L115:   invokevirtual [23] 
L118:   ldc [13] 
L120:   invokevirtual [22] 
L123:   aload 4 
L125:   invokevirtual [25] 
L128:   invokevirtual [22] 
L131:   invokevirtual [24] 
L134:   invokespecial [31] 
L137:   athrow 
L138:   return 
L139:   nop 
L140:   
    .end code 
.end method 

.method static [163] : [164] 
    .attribute [154] .code stack 1 locals 0 
L0:     ldc [14] 
L2:     invokestatic [15] 
L5:     putstatic [29] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [40] 
.const [3] = String [41] 
.const [4] = String [42] 
.const [5] = String [43] 
.const [6] = Class [44] 
.const [7] = Field [45] [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = String [49] 
.const [11] = Class [50] 
.const [12] = String [51] 
.const [13] = String [52] 
.const [14] = String [53] 
.const [15] = Method [54] [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Class [60] 
.const [21] = Field [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Class [83] 
.const [33] = Field [84] [85] 
.const [34] = Class [86] 
.const [35] = InterfaceMethod [87] [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = InterfaceMethod [91] [92] 
.const [38] = Class [93] 
.const [39] = Class [94] 
.const [40] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [41] = Utf8 '9e66ab20-39b4-11e0-9e42-0800200c9a66' 
.const [42] = Utf8 ff4289cb-25d7-57d5-9068-5614ad250529 
.const [43] = Utf8 'asi.fec.ComponentProtection' 
.const [44] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionReplyProxy 
.const [45] = Class [95] 
.const [46] = NameAndType [96] [97] 
.const [47] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [48] = Utf8 java/lang/StringBuffer 
.const [49] = Utf8 'Invalid Method Id ' 
.const [50] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [51] = Utf8 'Deserialization failed: method=' 
.const [52] = Utf8 ', error=' 
.const [53] = Utf8 'STUB.asi.fec.ComponentProtection' 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionService 
.const [57] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [58] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [59] = Utf8 de/esolutions/fw/comm/asi/fec/ComponentProtectionS 
.const [60] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [84] = Class [134] 
.const [85] = NameAndType [135] [136] 
.const [86] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionReplyProxy 
.const [87] = Class [137] 
.const [88] = NameAndType [138] [139] 
.const [89] = Class [140] 
.const [90] = NameAndType [141] [142] 
.const [91] = Class [143] 
.const [92] = NameAndType [144] [145] 
.const [93] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionService 
.const [96] = Utf8 context 
.const [97] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [98] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [99] = Utf8 getContext 
.const [100] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [101] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionService 
.const [102] = Utf8 p_ComponentProtection 
.const [103] = Utf8 Lde/esolutions/fw/comm/asi/fec/ComponentProtectionS; 
.const [104] = Utf8 java/lang/StringBuffer 
.const [105] = Utf8 append 
.const [106] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 append 
.const [109] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 toString 
.const [112] = Utf8 ()Ljava/lang/String; 
.const [113] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [114] = Utf8 getMessage 
.const [115] = Utf8 ()Ljava/lang/String; 
.const [116] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [119] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [122] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionReplyProxy 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionService 
.const [126] = Utf8 context 
.const [127] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Ljava/lang/String;)V 
.const [134] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionService 
.const [135] = Utf8 p_ComponentProtection 
.const [136] = Utf8 Lde/esolutions/fw/comm/asi/fec/ComponentProtectionS; 
.const [137] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [138] = Utf8 getOptionalString 
.const [139] = Utf8 ()Ljava/lang/String; 
.const [140] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [141] = Utf8 getInt32 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/esolutions/fw/comm/asi/fec/ComponentProtectionS 
.const [144] = Utf8 authString 
.const [145] = Utf8 (Ljava/lang/String;IILde/esolutions/fw/comm/asi/fec/ComponentProtectionReply;)V 
.const [146] = Utf8 de/esolutions/fw/comm/asi/fec/impl/ComponentProtectionService 
.const [147] = Class [146] 
.const [148] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [149] = Class [148] 
.const [150] = Utf8 context 
.const [151] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [152] = Utf8 p_ComponentProtection 
.const [153] = Utf8 Lde/esolutions/fw/comm/asi/fec/ComponentProtectionS; 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (ILde/esolutions/fw/comm/asi/fec/ComponentProtectionS;)V 
.const [157] = Utf8 createReplyProxy 
.const [158] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [159] = Utf8 getCallContext 
.const [160] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [161] = Utf8 handleCallMethod 
.const [162] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [163] = Utf8 <clinit> 
.const [164] = Utf8 ()V 
.end class 
