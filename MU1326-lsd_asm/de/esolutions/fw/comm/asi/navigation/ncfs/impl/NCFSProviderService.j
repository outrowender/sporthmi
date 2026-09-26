.version 50 0 
.class public super [147] 
.super [149] 
.field private static final [150] [151] 
.field private [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [27] 
L15:    invokespecial [28] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [34] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [154] .code stack 2 locals 0 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [29] 
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
    .attribute [154] .code stack 4 locals 1 
        .catch [12] from L0 to L103 using L106 
L0:     iload_1 
L1:     lookupswitch 
            0 : L52 
            1 : L28 
            default : L76 

L28:    aload_2 
L29:    invokestatic [8] 
L32:    astore 4 
L34:    aload_0 
L35:    getfield [22] 
L38:    aload 4 
L40:    aload_3 
L41:    checkcast [6] 
L44:    invokeinterface [36] 0 
L49:    goto L103 
L52:    aload_2 
L53:    invokestatic [8] 
L56:    astore 4 
L58:    aload_0 
L59:    getfield [22] 
L62:    aload 4 
L64:    aload_3 
L65:    checkcast [6] 
L68:    invokeinterface [37] 0 
L73:    goto L103 
L76:    new [38] 
L79:    dup 
L80:    new [39] 
L83:    dup 
L84:    invokespecial [31] 
L87:    ldc [11] 
L89:    invokevirtual [23] 
L92:    iload_1 
L93:    invokevirtual [24] 
L96:    invokevirtual [25] 
L99:    invokespecial [32] 
L102:   athrow 
L103:   goto L148 
L106:   astore 4 
L108:   new [38] 
L111:   dup 
L112:   new [39] 
L115:   dup 
L116:   invokespecial [31] 
L119:   ldc [13] 
L121:   invokevirtual [23] 
L124:   iload_1 
L125:   invokevirtual [24] 
L128:   ldc [14] 
L130:   invokevirtual [23] 
L133:   aload 4 
L135:   invokevirtual [26] 
L138:   invokevirtual [23] 
L141:   invokevirtual [25] 
L144:   invokespecial [32] 
L147:   athrow 
L148:   return 
L149:   nop 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method static [163] : [164] 
    .attribute [154] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
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
.const [8] = Method [47] [48] 
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
.const [29] = Method [77] [78] 
.const [30] = Field [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Class [85] 
.const [34] = Field [86] [87] 
.const [35] = Class [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = InterfaceMethod [91] [92] 
.const [38] = Class [93] 
.const [39] = Class [94] 
.const [40] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [41] = Utf8 '93230d7c-f001-4f4e-b59b-75d947a01065' 
.const [42] = Utf8 '6e1126d6-ac37-5862-92a7-b77a9a12ac7d' 
.const [43] = Utf8 'asi.navigation.ncfs.NCFSProvider' 
.const [44] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyProxy 
.const [45] = Class [95] 
.const [46] = NameAndType [96] [97] 
.const [47] = Class [98] 
.const [48] = NameAndType [99] [100] 
.const [49] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 'Invalid Method Id ' 
.const [52] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [53] = Utf8 'Deserialization failed: method=' 
.const [54] = Utf8 ', error=' 
.const [55] = Utf8 'STUB.asi.navigation.ncfs.NCFSProvider' 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderService 
.const [59] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [60] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [61] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS 
.const [62] = Utf8 de/esolutions/fw/comm/core/CallContext 
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
.const [83] = Class [134] 
.const [84] = NameAndType [135] [136] 
.const [85] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [86] = Class [137] 
.const [87] = NameAndType [138] [139] 
.const [88] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyProxy 
.const [89] = Class [140] 
.const [90] = NameAndType [141] [142] 
.const [91] = Class [143] 
.const [92] = NameAndType [144] [145] 
.const [93] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderService 
.const [96] = Utf8 context 
.const [97] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [98] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [99] = Utf8 getOptionalsBoundingBox 
.const [100] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [101] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [102] = Utf8 getContext 
.const [103] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [104] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderService 
.const [105] = Utf8 p_NCFSProvider 
.const [106] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS; 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 append 
.const [109] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 append 
.const [112] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 toString 
.const [115] = Utf8 ()Ljava/lang/String; 
.const [116] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [117] = Utf8 getMessage 
.const [118] = Utf8 ()Ljava/lang/String; 
.const [119] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [122] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [125] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyProxy 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderService 
.const [129] = Utf8 context 
.const [130] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Ljava/lang/String;)V 
.const [137] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderService 
.const [138] = Utf8 p_NCFSProvider 
.const [139] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS; 
.const [140] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS 
.const [141] = Utf8 requestVZORestrictions 
.const [142] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox;Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply;)V 
.const [143] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS 
.const [144] = Utf8 requestLGI 
.const [145] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox;Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply;)V 
.const [146] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderService 
.const [147] = Class [146] 
.const [148] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [149] = Class [148] 
.const [150] = Utf8 context 
.const [151] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [152] = Utf8 p_NCFSProvider 
.const [153] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS; 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderS;)V 
.const [157] = Utf8 createReplyProxy 
.const [158] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [159] = Utf8 getCallContext 
.const [160] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [161] = Utf8 handleCallMethod 
.const [162] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [163] = Utf8 <clinit> 
.const [164] = Utf8 ()V 
.end class 
