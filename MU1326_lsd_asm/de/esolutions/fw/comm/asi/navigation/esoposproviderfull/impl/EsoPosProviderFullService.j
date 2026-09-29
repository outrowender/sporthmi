.version 50 0 
.class public super [203] 
.super [205] 
.field private static final [206] [207] 
.field private [208] [209] 

.method public [211] : [212] 
    .attribute [210] .code stack 7 locals 0 
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

.method public [213] : [214] 
    .attribute [210] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [210] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [210] .code stack 4 locals 2 
        .catch [12] from L0 to L273 using L276 
L0:     iload_1 
L1:     tableswitch 8 
            L60 
            L246 
            L246 
            L246 
            L178 
            L220 
            L194 
            L86 
            L110 
            L152 
            L126 
            default : L246 

L60:    aload_2 
L61:    invokeinterface [37] 0 
L66:    istore 4 
L68:    aload_0 
L69:    getfield [23] 
L72:    iload 4 
L74:    aload_3 
L75:    checkcast [6] 
L78:    invokeinterface [38] 0 
L83:    goto L273 
L86:    aload_2 
L87:    invokestatic [8] 
L90:    astore 4 
L92:    aload_0 
L93:    getfield [23] 
L96:    aload 4 
L98:    aload_3 
L99:    checkcast [6] 
L102:   invokeinterface [39] 0 
L107:   goto L273 
L110:   aload_0 
L111:   getfield [23] 
L114:   aload_3 
L115:   checkcast [6] 
L118:   invokeinterface [40] 0 
L123:   goto L273 
L126:   aload_2 
L127:   invokeinterface [41] 0 
L132:   lstore 4 
L134:   aload_0 
L135:   getfield [23] 
L138:   lload 4 
L140:   aload_3 
L141:   checkcast [6] 
L144:   invokeinterface [42] 0 
L149:   goto L273 
L152:   aload_2 
L153:   invokeinterface [43] 0 
L158:   astore 4 
L160:   aload_0 
L161:   getfield [23] 
L164:   aload 4 
L166:   aload_3 
L167:   checkcast [6] 
L170:   invokeinterface [44] 0 
L175:   goto L273 
L178:   aload_0 
L179:   getfield [23] 
L182:   aload_3 
L183:   checkcast [6] 
L186:   invokeinterface [45] 0 
L191:   goto L273 
L194:   aload_2 
L195:   invokeinterface [41] 0 
L200:   lstore 4 
L202:   aload_0 
L203:   getfield [23] 
L206:   lload 4 
L208:   aload_3 
L209:   checkcast [6] 
L212:   invokeinterface [46] 0 
L217:   goto L273 
L220:   aload_2 
L221:   invokeinterface [43] 0 
L226:   astore 4 
L228:   aload_0 
L229:   getfield [23] 
L232:   aload 4 
L234:   aload_3 
L235:   checkcast [6] 
L238:   invokeinterface [47] 0 
L243:   goto L273 
L246:   new [48] 
L249:   dup 
L250:   new [49] 
L253:   dup 
L254:   invokespecial [32] 
L257:   ldc [11] 
L259:   invokevirtual [24] 
L262:   iload_1 
L263:   invokevirtual [25] 
L266:   invokevirtual [26] 
L269:   invokespecial [33] 
L272:   athrow 
L273:   goto L318 
L276:   astore 4 
L278:   new [48] 
L281:   dup 
L282:   new [49] 
L285:   dup 
L286:   invokespecial [32] 
L289:   ldc [13] 
L291:   invokevirtual [24] 
L294:   iload_1 
L295:   invokevirtual [25] 
L298:   ldc [14] 
L300:   invokevirtual [24] 
L303:   aload 4 
L305:   invokevirtual [27] 
L308:   invokevirtual [24] 
L311:   invokevirtual [26] 
L314:   invokespecial [33] 
L317:   athrow 
L318:   return 
L319:   nop 
L320:   
    .end code 
.end method 

.method static [219] : [220] 
    .attribute [210] .code stack 1 locals 0 
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
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = String [52] 
.const [5] = String [53] 
.const [6] = Class [54] 
.const [7] = Field [55] [56] 
.const [8] = Method [57] [58] 
.const [9] = Class [59] 
.const [10] = Class [60] 
.const [11] = String [61] 
.const [12] = Class [62] 
.const [13] = String [63] 
.const [14] = String [64] 
.const [15] = String [65] 
.const [16] = Method [66] [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Field [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Field [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Class [96] 
.const [35] = Field [97] [98] 
.const [36] = Class [99] 
.const [37] = InterfaceMethod [100] [101] 
.const [38] = InterfaceMethod [102] [103] 
.const [39] = InterfaceMethod [104] [105] 
.const [40] = InterfaceMethod [106] [107] 
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
.const [51] = Utf8 '3a8ac390-4251-11e3-9434-000c29e68a4a' 
.const [52] = Utf8 '2c5da29e-82ab-5b99-8f06-68cfdd97c847' 
.const [53] = Utf8 'asi.navigation.esoposproviderfull.EsoPosProviderFull' 
.const [54] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyProxy 
.const [55] = Class [124] 
.const [56] = NameAndType [125] [126] 
.const [57] = Class [127] 
.const [58] = NameAndType [128] [129] 
.const [59] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 'Invalid Method Id ' 
.const [62] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [63] = Utf8 'Deserialization failed: method=' 
.const [64] = Utf8 ', error=' 
.const [65] = Utf8 'STUB.asi.navigation.esoposproviderfull.EsoPosProviderFull' 
.const [66] = Class [130] 
.const [67] = NameAndType [131] [132] 
.const [68] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullService 
.const [69] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [70] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [71] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [72] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sConfigSerializer 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Class [148] 
.const [85] = NameAndType [149] [150] 
.const [86] = Class [151] 
.const [87] = NameAndType [152] [153] 
.const [88] = Class [154] 
.const [89] = NameAndType [155] [156] 
.const [90] = Class [157] 
.const [91] = NameAndType [158] [159] 
.const [92] = Class [160] 
.const [93] = NameAndType [161] [162] 
.const [94] = Class [163] 
.const [95] = NameAndType [164] [165] 
.const [96] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyProxy 
.const [100] = Class [169] 
.const [101] = NameAndType [170] [171] 
.const [102] = Class [172] 
.const [103] = NameAndType [173] [174] 
.const [104] = Class [175] 
.const [105] = NameAndType [176] [177] 
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
.const [124] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullService 
.const [125] = Utf8 context 
.const [126] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [127] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sConfigSerializer 
.const [128] = Utf8 getOptionalsConfig 
.const [129] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sConfig; 
.const [130] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [131] = Utf8 getContext 
.const [132] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [133] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullService 
.const [134] = Utf8 p_EsoPosProviderFull 
.const [135] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 append 
.const [141] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 toString 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [146] = Utf8 getMessage 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [151] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [154] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullReplyProxy 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullService 
.const [158] = Utf8 context 
.const [159] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 <init> 
.const [162] = Utf8 ()V 
.const [163] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Ljava/lang/String;)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullService 
.const [167] = Utf8 p_EsoPosProviderFull 
.const [168] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS; 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getBool 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [173] = Utf8 setActive 
.const [174] = Utf8 (ZLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [175] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [176] = Utf8 setConfig 
.const [177] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sConfig;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [178] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [179] = Utf8 setNotification 
.const [180] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [181] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [182] = Utf8 getUInt32 
.const [183] = Utf8 ()J 
.const [184] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [185] = Utf8 setNotification 
.const [186] = Utf8 (JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getOptionalUInt32VarArray 
.const [189] = Utf8 ()[J 
.const [190] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [191] = Utf8 setNotification 
.const [192] = Utf8 ([JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [193] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [194] = Utf8 clearNotification 
.const [195] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [196] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [197] = Utf8 clearNotification 
.const [198] = Utf8 (JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [199] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [200] = Utf8 clearNotification 
.const [201] = Utf8 ([JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [202] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullService 
.const [203] = Class [202] 
.const [204] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [205] = Class [204] 
.const [206] = Utf8 context 
.const [207] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [208] = Utf8 p_EsoPosProviderFull 
.const [209] = Utf8 Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS; 
.const [210] = Utf8 Code 
.const [211] = Utf8 <init> 
.const [212] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS;)V 
.const [213] = Utf8 createReplyProxy 
.const [214] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [215] = Utf8 getCallContext 
.const [216] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [217] = Utf8 handleCallMethod 
.const [218] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [219] = Utf8 <clinit> 
.const [220] = Utf8 ()V 
.end class 
