.version 50 0 
.class public super [169] 
.super [171] 
.field private static final [172] [173] 
.field private [174] [175] 

.method public [177] : [178] 
    .attribute [176] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [31] 
L15:    invokespecial [32] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [38] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [176] .code stack 2 locals 0 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [33] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [176] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [176] .code stack 4 locals 1 
        .catch [14] from L0 to L127 using L130 
L0:     iload_1 
L1:     tableswitch 5 
            L76 
            L52 
            L28 
            default : L100 

L28:    aload_2 
L29:    invokestatic [8] 
L32:    astore 4 
L34:    aload_0 
L35:    getfield [26] 
L38:    aload 4 
L40:    aload_3 
L41:    checkcast [6] 
L44:    invokeinterface [40] 0 
L49:    goto L127 
L52:    aload_2 
L53:    invokestatic [9] 
L56:    astore 4 
L58:    aload_0 
L59:    getfield [26] 
L62:    aload 4 
L64:    aload_3 
L65:    checkcast [6] 
L68:    invokeinterface [41] 0 
L73:    goto L127 
L76:    aload_2 
L77:    invokestatic [10] 
L80:    astore 4 
L82:    aload_0 
L83:    getfield [26] 
L86:    aload 4 
L88:    aload_3 
L89:    checkcast [6] 
L92:    invokeinterface [42] 0 
L97:    goto L127 
L100:   new [43] 
L103:   dup 
L104:   new [44] 
L107:   dup 
L108:   invokespecial [35] 
L111:   ldc [13] 
L113:   invokevirtual [27] 
L116:   iload_1 
L117:   invokevirtual [28] 
L120:   invokevirtual [29] 
L123:   invokespecial [36] 
L126:   athrow 
L127:   goto L172 
L130:   astore 4 
L132:   new [43] 
L135:   dup 
L136:   new [44] 
L139:   dup 
L140:   invokespecial [35] 
L143:   ldc [15] 
L145:   invokevirtual [27] 
L148:   iload_1 
L149:   invokevirtual [28] 
L152:   ldc [16] 
L154:   invokevirtual [27] 
L157:   aload 4 
L159:   invokevirtual [30] 
L162:   invokevirtual [27] 
L165:   invokevirtual [29] 
L168:   invokespecial [36] 
L171:   athrow 
L172:   return 
L173:   nop 
L174:   nop 
L175:   nop 
L176:   
    .end code 
.end method 

.method static [185] : [186] 
    .attribute [176] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [34] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [45] 
.const [3] = String [46] 
.const [4] = String [47] 
.const [5] = String [48] 
.const [6] = Class [49] 
.const [7] = Field [50] [51] 
.const [8] = Method [52] [53] 
.const [9] = Method [54] [55] 
.const [10] = Method [56] [57] 
.const [11] = Class [58] 
.const [12] = Class [59] 
.const [13] = String [60] 
.const [14] = Class [61] 
.const [15] = String [62] 
.const [16] = String [63] 
.const [17] = String [64] 
.const [18] = Method [65] [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Class [70] 
.const [23] = Class [71] 
.const [24] = Class [72] 
.const [25] = Class [73] 
.const [26] = Field [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = Class [99] 
.const [40] = InterfaceMethod [100] [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = InterfaceMethod [104] [105] 
.const [43] = Class [106] 
.const [44] = Class [107] 
.const [45] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [46] = Utf8 '424a4ae2-a7c9-4146-810b-30406bca0fdc' 
.const [47] = Utf8 e8d46886-db30-5882-ad53-07b965ab808b 
.const [48] = Utf8 'asi.diagnosis.mmx2app.MMX2OlsDiagService' 
.const [49] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyProxy 
.const [50] = Class [108] 
.const [51] = NameAndType [109] [110] 
.const [52] = Class [111] 
.const [53] = NameAndType [112] [113] 
.const [54] = Class [114] 
.const [55] = NameAndType [115] [116] 
.const [56] = Class [117] 
.const [57] = NameAndType [118] [119] 
.const [58] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 'Invalid Method Id ' 
.const [61] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [62] = Utf8 'Deserialization failed: method=' 
.const [63] = Utf8 ', error=' 
.const [64] = Utf8 'STUB.asi.diagnosis.mmx2app.MMX2OlsDiagService' 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceService 
.const [68] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [69] = Utf8 de/esolutions/fw/comm/asi/diagnosis/diagtypes/impl/sClientResponseErrorSerializer 
.const [70] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS 
.const [71] = Utf8 de/esolutions/fw/comm/asi/diagnosis/ols/impl/sConnectionStateSerializer 
.const [72] = Utf8 de/esolutions/fw/comm/asi/diagnosis/ols/impl/sActivationStateSerializer 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Class [123] 
.const [75] = NameAndType [124] [125] 
.const [76] = Class [126] 
.const [77] = NameAndType [127] [128] 
.const [78] = Class [129] 
.const [79] = NameAndType [130] [131] 
.const [80] = Class [132] 
.const [81] = NameAndType [133] [134] 
.const [82] = Class [135] 
.const [83] = NameAndType [136] [137] 
.const [84] = Class [138] 
.const [85] = NameAndType [139] [140] 
.const [86] = Class [141] 
.const [87] = NameAndType [142] [143] 
.const [88] = Class [144] 
.const [89] = NameAndType [145] [146] 
.const [90] = Class [147] 
.const [91] = NameAndType [148] [149] 
.const [92] = Class [150] 
.const [93] = NameAndType [151] [152] 
.const [94] = Class [153] 
.const [95] = NameAndType [154] [155] 
.const [96] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [97] = Class [156] 
.const [98] = NameAndType [157] [158] 
.const [99] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyProxy 
.const [100] = Class [159] 
.const [101] = NameAndType [160] [161] 
.const [102] = Class [162] 
.const [103] = NameAndType [163] [164] 
.const [104] = Class [165] 
.const [105] = NameAndType [166] [167] 
.const [106] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceService 
.const [109] = Utf8 context 
.const [110] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [111] = Utf8 de/esolutions/fw/comm/asi/diagnosis/diagtypes/impl/sClientResponseErrorSerializer 
.const [112] = Utf8 getOptionalsClientResponseError 
.const [113] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/diagnosis/diagtypes/sClientResponseError; 
.const [114] = Utf8 de/esolutions/fw/comm/asi/diagnosis/ols/impl/sConnectionStateSerializer 
.const [115] = Utf8 getOptionalsConnectionState 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/diagnosis/ols/sConnectionState; 
.const [117] = Utf8 de/esolutions/fw/comm/asi/diagnosis/ols/impl/sActivationStateSerializer 
.const [118] = Utf8 getOptionalsActivationState 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/diagnosis/ols/sActivationState; 
.const [120] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [121] = Utf8 getContext 
.const [122] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [123] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceService 
.const [124] = Utf8 p_MMX2OlsDiagService 
.const [125] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS; 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 append 
.const [128] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 toString 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [136] = Utf8 getMessage 
.const [137] = Utf8 ()Ljava/lang/String; 
.const [138] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [141] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [144] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceReplyProxy 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceService 
.const [148] = Utf8 context 
.const [149] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Ljava/lang/String;)V 
.const [156] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceService 
.const [157] = Utf8 p_MMX2OlsDiagService 
.const [158] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS; 
.const [159] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS 
.const [160] = Utf8 responseErrorOls 
.const [161] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/diagtypes/sClientResponseError;Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply;)V 
.const [162] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS 
.const [163] = Utf8 responseConnectionState 
.const [164] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/ols/sConnectionState;Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply;)V 
.const [165] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS 
.const [166] = Utf8 responseActivationState 
.const [167] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/ols/sActivationState;Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceReply;)V 
.const [168] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OlsDiagServiceService 
.const [169] = Class [168] 
.const [170] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [171] = Class [170] 
.const [172] = Utf8 context 
.const [173] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [174] = Utf8 p_MMX2OlsDiagService 
.const [175] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS; 
.const [176] = Utf8 Code 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (ILde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OlsDiagServiceS;)V 
.const [179] = Utf8 createReplyProxy 
.const [180] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [181] = Utf8 getCallContext 
.const [182] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [183] = Utf8 handleCallMethod 
.const [184] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [185] = Utf8 <clinit> 
.const [186] = Utf8 ()V 
.end class 
