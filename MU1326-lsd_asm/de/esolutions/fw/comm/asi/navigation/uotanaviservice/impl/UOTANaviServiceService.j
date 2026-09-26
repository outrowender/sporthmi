.version 50 0 
.class public super [161] 
.super [163] 
.field private static final [164] [165] 
.field private [166] [167] 

.method public [169] : [170] 
    .attribute [168] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [34] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [28] 
L15:    invokespecial [29] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [35] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [168] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [168] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [168] .code stack 5 locals 3 
        .catch [12] from L0 to L125 using L128 
L0:     iload_1 
L1:     lookupswitch 
            1 : L28 
            2 : L54 
            default : L98 

L28:    aload_2 
L29:    invokeinterface [37] 0 
L34:    istore 4 
L36:    aload_0 
L37:    getfield [23] 
L40:    iload 4 
L42:    aload_3 
L43:    checkcast [6] 
L46:    invokeinterface [38] 0 
L51:    goto L125 
L54:    aload_2 
L55:    invokeinterface [39] 0 
L60:    istore 4 
L62:    aload_2 
L63:    invokestatic [8] 
L66:    astore 5 
L68:    aload_2 
L69:    invokeinterface [37] 0 
L74:    istore 6 
L76:    aload_0 
L77:    getfield [23] 
L80:    iload 4 
L82:    aload 5 
L84:    iload 6 
L86:    aload_3 
L87:    checkcast [6] 
L90:    invokeinterface [40] 0 
L95:    goto L125 
L98:    new [41] 
L101:   dup 
L102:   new [42] 
L105:   dup 
L106:   invokespecial [32] 
L109:   ldc [11] 
L111:   invokevirtual [24] 
L114:   iload_1 
L115:   invokevirtual [25] 
L118:   invokevirtual [26] 
L121:   invokespecial [33] 
L124:   athrow 
L125:   goto L170 
L128:   astore 4 
L130:   new [41] 
L133:   dup 
L134:   new [42] 
L137:   dup 
L138:   invokespecial [32] 
L141:   ldc [13] 
L143:   invokevirtual [24] 
L146:   iload_1 
L147:   invokevirtual [25] 
L150:   ldc [14] 
L152:   invokevirtual [24] 
L155:   aload 4 
L157:   invokevirtual [27] 
L160:   invokevirtual [24] 
L163:   invokevirtual [26] 
L166:   invokespecial [33] 
L169:   athrow 
L170:   return 
L171:   nop 
L172:   
    .end code 
.end method 

.method static [177] : [178] 
    .attribute [168] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = String [44] 
.const [4] = String [45] 
.const [5] = String [46] 
.const [6] = Class [47] 
.const [7] = Field [48] [49] 
.const [8] = Method [50] [51] 
.const [9] = Class [52] 
.const [10] = Class [53] 
.const [11] = String [54] 
.const [12] = Class [55] 
.const [13] = String [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = Method [59] [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Class [66] 
.const [23] = Field [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Class [89] 
.const [35] = Field [90] [91] 
.const [36] = Class [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = InterfaceMethod [95] [96] 
.const [39] = InterfaceMethod [97] [98] 
.const [40] = InterfaceMethod [99] [100] 
.const [41] = Class [101] 
.const [42] = Class [102] 
.const [43] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [44] = Utf8 '761c5633-4d14-4d62-9410-2cefd2161346' 
.const [45] = Utf8 '4530e019-1027-5e9c-a559-78a464b914fe' 
.const [46] = Utf8 'asi.navigation.uotanaviservice.UOTANaviService' 
.const [47] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceReplyProxy 
.const [48] = Class [103] 
.const [49] = NameAndType [104] [105] 
.const [50] = Class [106] 
.const [51] = NameAndType [107] [108] 
.const [52] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 'Invalid Method Id ' 
.const [55] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [56] = Utf8 'Deserialization failed: method=' 
.const [57] = Utf8 ', error=' 
.const [58] = Utf8 'STUB.asi.navigation.uotanaviservice.UOTANaviService' 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceService 
.const [62] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [63] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [64] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS 
.const [65] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/ComponentInfoSerializer 
.const [66] = Utf8 de/esolutions/fw/comm/core/CallContext 
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
.const [85] = Class [139] 
.const [86] = NameAndType [140] [141] 
.const [87] = Class [142] 
.const [88] = NameAndType [143] [144] 
.const [89] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [90] = Class [145] 
.const [91] = NameAndType [146] [147] 
.const [92] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceReplyProxy 
.const [93] = Class [148] 
.const [94] = NameAndType [149] [150] 
.const [95] = Class [151] 
.const [96] = NameAndType [152] [153] 
.const [97] = Class [154] 
.const [98] = NameAndType [155] [156] 
.const [99] = Class [157] 
.const [100] = NameAndType [158] [159] 
.const [101] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceService 
.const [104] = Utf8 context 
.const [105] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [106] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/ComponentInfoSerializer 
.const [107] = Utf8 getOptionalComponentInfoVarArray 
.const [108] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo; 
.const [109] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [110] = Utf8 getContext 
.const [111] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [112] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceService 
.const [113] = Utf8 p_UOTANaviService 
.const [114] = Utf8 Lde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 toString 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [125] = Utf8 getMessage 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [130] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [133] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceReplyProxy 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceService 
.const [137] = Utf8 context 
.const [138] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Ljava/lang/String;)V 
.const [145] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceService 
.const [146] = Utf8 p_UOTANaviService 
.const [147] = Utf8 Lde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS; 
.const [148] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [149] = Utf8 getEnum 
.const [150] = Utf8 ()I 
.const [151] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS 
.const [152] = Utf8 registerClient 
.const [153] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceReply;)V 
.const [154] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [155] = Utf8 getInt16 
.const [156] = Utf8 ()S 
.const [157] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS 
.const [158] = Utf8 respondVersionInfo 
.const [159] = Utf8 (S[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo;ILde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceReply;)V 
.const [160] = Utf8 de/esolutions/fw/comm/asi/navigation/uotanaviservice/impl/UOTANaviServiceService 
.const [161] = Class [160] 
.const [162] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [163] = Class [162] 
.const [164] = Utf8 context 
.const [165] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [166] = Utf8 p_UOTANaviService 
.const [167] = Utf8 Lde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS; 
.const [168] = Utf8 Code 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/uotanaviservice/UOTANaviServiceS;)V 
.const [171] = Utf8 createReplyProxy 
.const [172] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [173] = Utf8 getCallContext 
.const [174] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [175] = Utf8 handleCallMethod 
.const [176] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [177] = Utf8 <clinit> 
.const [178] = Utf8 ()V 
.end class 
