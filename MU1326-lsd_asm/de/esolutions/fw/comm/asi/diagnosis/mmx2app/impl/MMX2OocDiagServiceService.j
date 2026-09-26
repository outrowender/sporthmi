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
        .catch [14] from L0 to L135 using L138 
L0:     iload_1 
L1:     lookupswitch 
            2 : L60 
            5 : L84 
            8 : L36 
            default : L108 

L36:    aload_2 
L37:    invokestatic [8] 
L40:    astore 4 
L42:    aload_0 
L43:    getfield [26] 
L46:    aload 4 
L48:    aload_3 
L49:    checkcast [6] 
L52:    invokeinterface [40] 0 
L57:    goto L135 
L60:    aload_2 
L61:    invokestatic [9] 
L64:    astore 4 
L66:    aload_0 
L67:    getfield [26] 
L70:    aload 4 
L72:    aload_3 
L73:    checkcast [6] 
L76:    invokeinterface [41] 0 
L81:    goto L135 
L84:    aload_2 
L85:    invokestatic [10] 
L88:    astore 4 
L90:    aload_0 
L91:    getfield [26] 
L94:    aload 4 
L96:    aload_3 
L97:    checkcast [6] 
L100:   invokeinterface [42] 0 
L105:   goto L135 
L108:   new [43] 
L111:   dup 
L112:   new [44] 
L115:   dup 
L116:   invokespecial [35] 
L119:   ldc [13] 
L121:   invokevirtual [27] 
L124:   iload_1 
L125:   invokevirtual [28] 
L128:   invokevirtual [29] 
L131:   invokespecial [36] 
L134:   athrow 
L135:   goto L180 
L138:   astore 4 
L140:   new [43] 
L143:   dup 
L144:   new [44] 
L147:   dup 
L148:   invokespecial [35] 
L151:   ldc [15] 
L153:   invokevirtual [27] 
L156:   iload_1 
L157:   invokevirtual [28] 
L160:   ldc [16] 
L162:   invokevirtual [27] 
L165:   aload 4 
L167:   invokevirtual [30] 
L170:   invokevirtual [27] 
L173:   invokevirtual [29] 
L176:   invokespecial [36] 
L179:   athrow 
L180:   return 
L181:   nop 
L182:   nop 
L183:   nop 
L184:   
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
.const [46] = Utf8 '09c63284-f374-4fbe-89ea-924e201190ad' 
.const [47] = Utf8 '24561f40-b427-5b46-a327-ce4029a7b7b0' 
.const [48] = Utf8 'asi.diagnosis.mmx2app.MMX2OocDiagService' 
.const [49] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyProxy 
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
.const [64] = Utf8 'STUB.asi.diagnosis.mmx2app.MMX2OocDiagService' 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceService 
.const [68] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [69] = Utf8 de/esolutions/fw/comm/asi/diagnosis/diagtypes/impl/sClientResponseErrorSerializer 
.const [70] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS 
.const [71] = Utf8 de/esolutions/fw/comm/asi/diagnosis/ooc/impl/sTemperatureMMXSerializer 
.const [72] = Utf8 de/esolutions/fw/comm/asi/diagnosis/diagtypes/impl/sRoutineResponseSerializer 
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
.const [99] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyProxy 
.const [100] = Class [159] 
.const [101] = NameAndType [160] [161] 
.const [102] = Class [162] 
.const [103] = NameAndType [163] [164] 
.const [104] = Class [165] 
.const [105] = NameAndType [166] [167] 
.const [106] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceService 
.const [109] = Utf8 context 
.const [110] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [111] = Utf8 de/esolutions/fw/comm/asi/diagnosis/diagtypes/impl/sClientResponseErrorSerializer 
.const [112] = Utf8 getOptionalsClientResponseError 
.const [113] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/diagnosis/diagtypes/sClientResponseError; 
.const [114] = Utf8 de/esolutions/fw/comm/asi/diagnosis/ooc/impl/sTemperatureMMXSerializer 
.const [115] = Utf8 getOptionalsTemperatureMMX 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/diagnosis/ooc/sTemperatureMMX; 
.const [117] = Utf8 de/esolutions/fw/comm/asi/diagnosis/diagtypes/impl/sRoutineResponseSerializer 
.const [118] = Utf8 getOptionalsRoutineResponse 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/diagnosis/diagtypes/sRoutineResponse; 
.const [120] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [121] = Utf8 getContext 
.const [122] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [123] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceService 
.const [124] = Utf8 p_MMX2OocDiagService 
.const [125] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS; 
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
.const [144] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceReplyProxy 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceService 
.const [148] = Utf8 context 
.const [149] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Ljava/lang/String;)V 
.const [156] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceService 
.const [157] = Utf8 p_MMX2OocDiagService 
.const [158] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS; 
.const [159] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS 
.const [160] = Utf8 responseErrorOoc 
.const [161] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/diagtypes/sClientResponseError;Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply;)V 
.const [162] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS 
.const [163] = Utf8 responseTemperatureMMX 
.const [164] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/ooc/sTemperatureMMX;Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply;)V 
.const [165] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS 
.const [166] = Utf8 responseDeleteMemory 
.const [167] = Utf8 (Lde/esolutions/fw/comm/asi/diagnosis/diagtypes/sRoutineResponse;Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceReply;)V 
.const [168] = Utf8 de/esolutions/fw/comm/asi/diagnosis/mmx2app/impl/MMX2OocDiagServiceService 
.const [169] = Class [168] 
.const [170] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [171] = Class [170] 
.const [172] = Utf8 context 
.const [173] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [174] = Utf8 p_MMX2OocDiagService 
.const [175] = Utf8 Lde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS; 
.const [176] = Utf8 Code 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (ILde/esolutions/fw/comm/asi/diagnosis/mmx2app/MMX2OocDiagServiceS;)V 
.const [179] = Utf8 createReplyProxy 
.const [180] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [181] = Utf8 getCallContext 
.const [182] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [183] = Utf8 handleCallMethod 
.const [184] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [185] = Utf8 <clinit> 
.const [186] = Utf8 ()V 
.end class 
