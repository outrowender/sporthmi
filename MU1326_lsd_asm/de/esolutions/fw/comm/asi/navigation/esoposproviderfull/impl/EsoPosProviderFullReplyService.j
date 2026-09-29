.version 50 0 
.class public super [203] 
.super [205] 
.field private static final [206] [207] 
.field private static [208] [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [39] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [33] 
L17:    invokespecial [34] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [40] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [215] : [216] 
    .attribute [212] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [35] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [212] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 4 locals 3 
        .catch [15] from L0 to L173 using L176 
L0:     iload_1 
L1:     lookupswitch 
            19 : L114 
            21 : L36 
            25 : L76 
            default : L146 

L36:    aload_2 
L37:    invokeinterface [41] 0 
L42:    istore 4 
L44:    aload_2 
L45:    invokestatic [9] 
L48:    astore 5 
L50:    aload_2 
L51:    invokeinterface [42] 0 
L56:    istore 6 
L58:    aload_0 
L59:    getfield [28] 
L62:    iload 4 
L64:    aload 5 
L66:    iload 6 
L68:    invokeinterface [43] 0 
L73:    goto L173 
L76:    aload_2 
L77:    invokeinterface [44] 0 
L82:    astore 4 
L84:    aload_2 
L85:    invokestatic [10] 
L88:    astore 5 
L90:    aload_2 
L91:    invokestatic [11] 
L94:    astore 6 
L96:    aload_0 
L97:    getfield [28] 
L100:   aload 4 
L102:   aload 5 
L104:   aload 6 
L106:   invokeinterface [45] 0 
L111:   goto L173 
L114:   aload_2 
L115:   invokeinterface [46] 0 
L120:   astore 4 
L122:   aload_2 
L123:   invokeinterface [41] 0 
L128:   istore 5 
L130:   aload_0 
L131:   getfield [28] 
L134:   aload 4 
L136:   iload 5 
L138:   invokeinterface [47] 0 
L143:   goto L173 
L146:   new [48] 
L149:   dup 
L150:   new [49] 
L153:   dup 
L154:   invokespecial [37] 
L157:   ldc [14] 
L159:   invokevirtual [29] 
L162:   iload_1 
L163:   invokevirtual [30] 
L166:   invokevirtual [31] 
L169:   invokespecial [38] 
L172:   athrow 
L173:   goto L218 
L176:   astore 4 
L178:   new [48] 
L181:   dup 
L182:   new [49] 
L185:   dup 
L186:   invokespecial [37] 
L189:   ldc [16] 
L191:   invokevirtual [29] 
L194:   iload_1 
L195:   invokevirtual [30] 
L198:   ldc [17] 
L200:   invokevirtual [29] 
L203:   aload 4 
L205:   invokevirtual [32] 
L208:   invokevirtual [29] 
L211:   invokevirtual [31] 
L214:   invokespecial [38] 
L217:   athrow 
L218:   return 
L219:   nop 
L220:   
    .end code 
.end method 

.method static [221] : [222] 
    .attribute [212] .code stack 1 locals 0 
L0:     ldc [18] 
L2:     invokestatic [19] 
L5:     putstatic [36] 
L8:     iconst_0 
L9:     putstatic [35] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = Method [52] [53] 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = Field [56] [57] 
.const [8] = Field [58] [59] 
.const [9] = Method [60] [61] 
.const [10] = Method [62] [63] 
.const [11] = Method [64] [65] 
.const [12] = Class [66] 
.const [13] = Class [67] 
.const [14] = String [68] 
.const [15] = Class [69] 
.const [16] = String [70] 
.const [17] = String [71] 
.const [18] = String [72] 
.const [19] = Method [73] [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Class [78] 
.const [24] = Class [79] 
.const [25] = Class [80] 
.const [26] = Class [81] 
.const [27] = Class [82] 
.const [28] = Field [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Field [97] [98] 
.const [36] = Field [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Class [105] 
.const [40] = Field [106] [107] 
.const [41] = InterfaceMethod [108] [109] 
.const [42] = InterfaceMethod [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = Class [122] 
.const [49] = Class [123] 
.const [50] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [51] = Utf8 '4325a74a-4251-11e3-9bb9-000c29e68a4a' 
.const [52] = Class [124] 
.const [53] = NameAndType [125] [126] 
.const [54] = Utf8 '995a4140-c7f3-5205-8335-d13059867b08' 
.const [55] = Utf8 'asi.navigation.esoposproviderfull.EsoPosProviderFull' 
.const [56] = Class [127] 
.const [57] = NameAndType [128] [129] 
.const [58] = Class [130] 
.const [59] = NameAndType [131] [132] 
.const [60] = Class [133] 
.const [61] = NameAndType [134] [135] 
.const [62] = Class [136] 
.const [63] = NameAndType [137] [138] 
.const [64] = Class [139] 
.const [65] = NameAndType [140] [141] 
.const [66] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [67] = Utf8 java/lang/StringBuffer 
.const [68] = Utf8 'Invalid Method Id ' 
.const [69] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [70] = Utf8 'Deserialization failed: method=' 
.const [71] = Utf8 ', error=' 
.const [72] = Utf8 'STUB.asi.navigation.esoposproviderfull.EsoPosProviderFull' 
.const [73] = Class [142] 
.const [74] = NameAndType [143] [144] 
.const [75] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [76] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [77] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [78] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sConfigSerializer 
.const [79] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply 
.const [80] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sMapPositionSerializer 
.const [81] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [82] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Class [157] 
.const [92] = NameAndType [158] [159] 
.const [93] = Class [160] 
.const [94] = NameAndType [161] [162] 
.const [95] = Class [163] 
.const [96] = NameAndType [164] [165] 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Class [169] 
.const [100] = NameAndType [170] [171] 
.const [101] = Class [172] 
.const [102] = NameAndType [173] [174] 
.const [103] = Class [175] 
.const [104] = NameAndType [176] [177] 
.const [105] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [106] = Class [178] 
.const [107] = NameAndType [179] [180] 
.const [108] = Class [181] 
.const [109] = NameAndType [182] [183] 
.const [110] = Class [184] 
.const [111] = NameAndType [185] [186] 
.const [112] = Class [187] 
.const [113] = NameAndType [188] [189] 
.const [114] = Class [190] 
.const [115] = NameAndType [191] [192] 
.const [116] = Class [193] 
.const [117] = NameAndType [194] [195] 
.const [118] = Class [196] 
.const [119] = NameAndType [197] [198] 
.const [120] = Class [199] 
.const [121] = NameAndType [200] [201] 
.const [122] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [123] = Utf8 java/lang/StringBuffer 
.const [124] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [125] = Utf8 nextDynamicHandle 
.const [126] = Utf8 ()I 
.const [127] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [128] = Utf8 dynamicHandle 
.const [129] = Utf8 I 
.const [130] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [131] = Utf8 context 
.const [132] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [133] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sConfigSerializer 
.const [134] = Utf8 getOptionalsConfig 
.const [135] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sConfig; 
.const [136] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sMapPositionSerializer 
.const [137] = Utf8 getOptionalsMapPosition 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition; 
.const [139] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [140] = Utf8 getOptionalsPositionVarArray 
.const [141] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.const [142] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [143] = Utf8 getContext 
.const [144] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [145] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [146] = Utf8 p_EsoPosProviderFullReply 
.const [147] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply; 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 append 
.const [150] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 append 
.const [153] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 toString 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [158] = Utf8 getMessage 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [163] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [167] = Utf8 dynamicHandle 
.const [168] = Utf8 I 
.const [169] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [170] = Utf8 context 
.const [171] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [172] = Utf8 java/lang/StringBuffer 
.const [173] = Utf8 <init> 
.const [174] = Utf8 ()V 
.const [175] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (Ljava/lang/String;)V 
.const [178] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [179] = Utf8 p_EsoPosProviderFullReply 
.const [180] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply; 
.const [181] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [182] = Utf8 getBool 
.const [183] = Utf8 ()Z 
.const [184] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [185] = Utf8 getEnum 
.const [186] = Utf8 ()I 
.const [187] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply 
.const [188] = Utf8 updateState 
.const [189] = Utf8 (ZLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sConfig;I)V 
.const [190] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [191] = Utf8 getOptionalStringVarArray 
.const [192] = Utf8 ()[Ljava/lang/String; 
.const [193] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply 
.const [194] = Utf8 updatePosition 
.const [195] = Utf8 ([Ljava/lang/String;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sMapPosition;[Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition;)V 
.const [196] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [197] = Utf8 getOptionalString 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply 
.const [200] = Utf8 updateASIVersion 
.const [201] = Utf8 (Ljava/lang/String;Z)V 
.const [202] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyService 
.const [203] = Class [202] 
.const [204] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [205] = Class [204] 
.const [206] = Utf8 context 
.const [207] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [208] = Utf8 dynamicHandle 
.const [209] = Utf8 I 
.const [210] = Utf8 p_EsoPosProviderFullReply 
.const [211] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply; 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [215] = Utf8 nextDynamicHandle 
.const [216] = Utf8 ()I 
.const [217] = Utf8 getCallContext 
.const [218] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [219] = Utf8 handleCallMethod 
.const [220] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [221] = Utf8 <clinit> 
.const [222] = Utf8 ()V 
.end class 
