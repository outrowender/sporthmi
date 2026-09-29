.version 50 0 
.class public super [159] 
.super [161] 
.field private static final [162] [163] 
.field private [164] [165] 

.method public [167] : [168] 
    .attribute [166] .code stack 7 locals 0 
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

.method public [169] : [170] 
    .attribute [166] .code stack 2 locals 0 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [166] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [166] .code stack 5 locals 3 
        .catch [11] from L0 to L127 using L130 
L0:     iload_1 
L1:     lookupswitch 
            0 : L54 
            9 : L28 
            default : L100 

L28:    aload_2 
L29:    invokeinterface [35] 0 
L34:    istore 4 
L36:    aload_0 
L37:    getfield [21] 
L40:    iload 4 
L42:    aload_3 
L43:    checkcast [6] 
L46:    invokeinterface [36] 0 
L51:    goto L127 
L54:    aload_2 
L55:    invokeinterface [37] 0 
L60:    astore 4 
L62:    aload_2 
L63:    invokeinterface [38] 0 
L68:    astore 5 
L70:    aload_2 
L71:    invokeinterface [38] 0 
L76:    astore 6 
L78:    aload_0 
L79:    getfield [21] 
L82:    aload 4 
L84:    aload 5 
L86:    aload 6 
L88:    aload_3 
L89:    checkcast [6] 
L92:    invokeinterface [39] 0 
L97:    goto L127 
L100:   new [40] 
L103:   dup 
L104:   new [41] 
L107:   dup 
L108:   invokespecial [30] 
L111:   ldc [10] 
L113:   invokevirtual [22] 
L116:   iload_1 
L117:   invokevirtual [23] 
L120:   invokevirtual [24] 
L123:   invokespecial [31] 
L126:   athrow 
L127:   goto L172 
L130:   astore 4 
L132:   new [40] 
L135:   dup 
L136:   new [41] 
L139:   dup 
L140:   invokespecial [30] 
L143:   ldc [12] 
L145:   invokevirtual [22] 
L148:   iload_1 
L149:   invokevirtual [23] 
L152:   ldc [13] 
L154:   invokevirtual [22] 
L157:   aload 4 
L159:   invokevirtual [25] 
L162:   invokevirtual [22] 
L165:   invokevirtual [24] 
L168:   invokespecial [31] 
L171:   athrow 
L172:   return 
L173:   nop 
L174:   nop 
L175:   nop 
L176:   
    .end code 
.end method 

.method static [175] : [176] 
    .attribute [166] .code stack 1 locals 0 
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
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = Class [46] 
.const [7] = Field [47] [48] 
.const [8] = Class [49] 
.const [9] = Class [50] 
.const [10] = String [51] 
.const [11] = Class [52] 
.const [12] = String [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = Method [56] [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Class [62] 
.const [21] = Field [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Class [85] 
.const [33] = Field [86] [87] 
.const [34] = Class [88] 
.const [35] = InterfaceMethod [89] [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = InterfaceMethod [95] [96] 
.const [39] = InterfaceMethod [97] [98] 
.const [40] = Class [99] 
.const [41] = Class [100] 
.const [42] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [43] = Utf8 '374197ca-caef-403f-a993-7e171899db9d' 
.const [44] = Utf8 '44bd5e8c-c0a5-58f5-b4e5-8c4bb4689d0e' 
.const [45] = Utf8 'asi.fec.FecAppMMX' 
.const [46] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXReplyProxy 
.const [47] = Class [101] 
.const [48] = NameAndType [102] [103] 
.const [49] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 'Invalid Method Id ' 
.const [52] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [53] = Utf8 'Deserialization failed: method=' 
.const [54] = Utf8 ', error=' 
.const [55] = Utf8 'STUB.asi.fec.FecAppMMX' 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXService 
.const [59] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [60] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [61] = Utf8 de/esolutions/fw/comm/asi/fec/FecAppMMXS 
.const [62] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Class [131] 
.const [80] = NameAndType [132] [133] 
.const [81] = Class [134] 
.const [82] = NameAndType [135] [136] 
.const [83] = Class [137] 
.const [84] = NameAndType [138] [139] 
.const [85] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [86] = Class [140] 
.const [87] = NameAndType [141] [142] 
.const [88] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXReplyProxy 
.const [89] = Class [143] 
.const [90] = NameAndType [144] [145] 
.const [91] = Class [146] 
.const [92] = NameAndType [147] [148] 
.const [93] = Class [149] 
.const [94] = NameAndType [150] [151] 
.const [95] = Class [152] 
.const [96] = NameAndType [153] [154] 
.const [97] = Class [155] 
.const [98] = NameAndType [156] [157] 
.const [99] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXService 
.const [102] = Utf8 context 
.const [103] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [104] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [105] = Utf8 getContext 
.const [106] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [107] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXService 
.const [108] = Utf8 p_FecAppMMX 
.const [109] = Utf8 Lde/esolutions/fw/comm/asi/fec/FecAppMMXS; 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 append 
.const [112] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 toString 
.const [118] = Utf8 ()Ljava/lang/String; 
.const [119] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [120] = Utf8 getMessage 
.const [121] = Utf8 ()Ljava/lang/String; 
.const [122] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [125] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [128] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXReplyProxy 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXService 
.const [132] = Utf8 context 
.const [133] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [134] = Utf8 java/lang/StringBuffer 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Ljava/lang/String;)V 
.const [140] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXService 
.const [141] = Utf8 p_FecAppMMX 
.const [142] = Utf8 Lde/esolutions/fw/comm/asi/fec/FecAppMMXS; 
.const [143] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [144] = Utf8 getEnum 
.const [145] = Utf8 ()I 
.const [146] = Utf8 de/esolutions/fw/comm/asi/fec/FecAppMMXS 
.const [147] = Utf8 registerForFec 
.const [148] = Utf8 (ILde/esolutions/fw/comm/asi/fec/FecAppMMXReply;)V 
.const [149] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [150] = Utf8 getOptionalString 
.const [151] = Utf8 ()Ljava/lang/String; 
.const [152] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [153] = Utf8 getOptionalUInt8VarArray 
.const [154] = Utf8 ()[S 
.const [155] = Utf8 de/esolutions/fw/comm/asi/fec/FecAppMMXS 
.const [156] = Utf8 checkPkgSignature 
.const [157] = Utf8 (Ljava/lang/String;[S[SLde/esolutions/fw/comm/asi/fec/FecAppMMXReply;)V 
.const [158] = Utf8 de/esolutions/fw/comm/asi/fec/impl/FecAppMMXService 
.const [159] = Class [158] 
.const [160] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [161] = Class [160] 
.const [162] = Utf8 context 
.const [163] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [164] = Utf8 p_FecAppMMX 
.const [165] = Utf8 Lde/esolutions/fw/comm/asi/fec/FecAppMMXS; 
.const [166] = Utf8 Code 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (ILde/esolutions/fw/comm/asi/fec/FecAppMMXS;)V 
.const [169] = Utf8 createReplyProxy 
.const [170] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [171] = Utf8 getCallContext 
.const [172] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [173] = Utf8 handleCallMethod 
.const [174] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [175] = Utf8 <clinit> 
.const [176] = Utf8 ()V 
.end class 
