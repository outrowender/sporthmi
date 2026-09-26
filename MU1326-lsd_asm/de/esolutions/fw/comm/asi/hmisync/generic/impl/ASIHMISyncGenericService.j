.version 50 0 
.class public super [191] 
.super [193] 
.field private static final [194] [195] 
.field private [196] [197] 

.method public [199] : [200] 
    .attribute [198] .code stack 7 locals 0 
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

.method public [201] : [202] 
    .attribute [198] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [198] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [198] .code stack 4 locals 2 
        .catch [12] from L0 to L235 using L238 
L0:     iload_1 
L1:     tableswitch 0 
            L140 
            L182 
            L156 
            L208 
            L48 
            L72 
            L114 
            L88 
            default : L208 

L48:    aload_2 
L49:    invokestatic [8] 
L52:    astore 4 
L54:    aload_0 
L55:    getfield [23] 
L58:    aload 4 
L60:    aload_3 
L61:    checkcast [6] 
L64:    invokeinterface [37] 0 
L69:    goto L235 
L72:    aload_0 
L73:    getfield [23] 
L76:    aload_3 
L77:    checkcast [6] 
L80:    invokeinterface [38] 0 
L85:    goto L235 
L88:    aload_2 
L89:    invokeinterface [39] 0 
L94:    lstore 4 
L96:    aload_0 
L97:    getfield [23] 
L100:   lload 4 
L102:   aload_3 
L103:   checkcast [6] 
L106:   invokeinterface [40] 0 
L111:   goto L235 
L114:   aload_2 
L115:   invokeinterface [41] 0 
L120:   astore 4 
L122:   aload_0 
L123:   getfield [23] 
L126:   aload 4 
L128:   aload_3 
L129:   checkcast [6] 
L132:   invokeinterface [42] 0 
L137:   goto L235 
L140:   aload_0 
L141:   getfield [23] 
L144:   aload_3 
L145:   checkcast [6] 
L148:   invokeinterface [43] 0 
L153:   goto L235 
L156:   aload_2 
L157:   invokeinterface [39] 0 
L162:   lstore 4 
L164:   aload_0 
L165:   getfield [23] 
L168:   lload 4 
L170:   aload_3 
L171:   checkcast [6] 
L174:   invokeinterface [44] 0 
L179:   goto L235 
L182:   aload_2 
L183:   invokeinterface [41] 0 
L188:   astore 4 
L190:   aload_0 
L191:   getfield [23] 
L194:   aload 4 
L196:   aload_3 
L197:   checkcast [6] 
L200:   invokeinterface [45] 0 
L205:   goto L235 
L208:   new [46] 
L211:   dup 
L212:   new [47] 
L215:   dup 
L216:   invokespecial [32] 
L219:   ldc [11] 
L221:   invokevirtual [24] 
L224:   iload_1 
L225:   invokevirtual [25] 
L228:   invokevirtual [26] 
L231:   invokespecial [33] 
L234:   athrow 
L235:   goto L280 
L238:   astore 4 
L240:   new [46] 
L243:   dup 
L244:   new [47] 
L247:   dup 
L248:   invokespecial [32] 
L251:   ldc [13] 
L253:   invokevirtual [24] 
L256:   iload_1 
L257:   invokevirtual [25] 
L260:   ldc [14] 
L262:   invokevirtual [24] 
L265:   aload 4 
L267:   invokevirtual [27] 
L270:   invokevirtual [24] 
L273:   invokevirtual [26] 
L276:   invokespecial [33] 
L279:   athrow 
L280:   return 
L281:   nop 
L282:   nop 
L283:   nop 
L284:   
    .end code 
.end method 

.method static [207] : [208] 
    .attribute [198] .code stack 1 locals 0 
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
.const [2] = Class [48] 
.const [3] = String [49] 
.const [4] = String [50] 
.const [5] = String [51] 
.const [6] = Class [52] 
.const [7] = Field [53] [54] 
.const [8] = Method [55] [56] 
.const [9] = Class [57] 
.const [10] = Class [58] 
.const [11] = String [59] 
.const [12] = Class [60] 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = String [63] 
.const [16] = Method [64] [65] 
.const [17] = Class [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Field [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Class [94] 
.const [35] = Field [95] [96] 
.const [36] = Class [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = InterfaceMethod [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = InterfaceMethod [114] [115] 
.const [46] = Class [116] 
.const [47] = Class [117] 
.const [48] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [49] = Utf8 '8240215d-ce8b-4cad-8c1c-31b07f57874c' 
.const [50] = Utf8 acbc4ddf-b980-5af2-a38a-506f1125c975 
.const [51] = Utf8 'asi.hmisync.generic.ASIHMISyncGeneric' 
.const [52] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyProxy 
.const [53] = Class [118] 
.const [54] = NameAndType [119] [120] 
.const [55] = Class [121] 
.const [56] = NameAndType [122] [123] 
.const [57] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'Invalid Method Id ' 
.const [60] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [61] = Utf8 'Deserialization failed: method=' 
.const [62] = Utf8 ', error=' 
.const [63] = Utf8 'STUB.asi.hmisync.generic.ASIHMISyncGeneric' 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericService 
.const [67] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [68] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/GenericPacketSerializer 
.const [69] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [70] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [71] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Class [151] 
.const [89] = NameAndType [152] [153] 
.const [90] = Class [154] 
.const [91] = NameAndType [155] [156] 
.const [92] = Class [157] 
.const [93] = NameAndType [158] [159] 
.const [94] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [95] = Class [160] 
.const [96] = NameAndType [161] [162] 
.const [97] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyProxy 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Class [166] 
.const [101] = NameAndType [167] [168] 
.const [102] = Class [169] 
.const [103] = NameAndType [170] [171] 
.const [104] = Class [172] 
.const [105] = NameAndType [173] [174] 
.const [106] = Class [175] 
.const [107] = NameAndType [176] [177] 
.const [108] = Class [178] 
.const [109] = NameAndType [179] [180] 
.const [110] = Class [181] 
.const [111] = NameAndType [182] [183] 
.const [112] = Class [184] 
.const [113] = NameAndType [185] [186] 
.const [114] = Class [187] 
.const [115] = NameAndType [188] [189] 
.const [116] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericService 
.const [119] = Utf8 context 
.const [120] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [121] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/GenericPacketSerializer 
.const [122] = Utf8 getOptionalGenericPacket 
.const [123] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/generic/GenericPacket; 
.const [124] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [125] = Utf8 getContext 
.const [126] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [127] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericService 
.const [128] = Utf8 p_ASIHMISyncGeneric 
.const [129] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS; 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 append 
.const [132] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 toString 
.const [138] = Utf8 ()Ljava/lang/String; 
.const [139] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [140] = Utf8 getMessage 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [145] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [148] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericReplyProxy 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericService 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Ljava/lang/String;)V 
.const [160] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericService 
.const [161] = Utf8 p_ASIHMISyncGeneric 
.const [162] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS; 
.const [163] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [164] = Utf8 sendDataToUnit 
.const [165] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/generic/GenericPacket;Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [167] = Utf8 setNotification 
.const [168] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getUInt32 
.const [171] = Utf8 ()J 
.const [172] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [173] = Utf8 setNotification 
.const [174] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [175] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [176] = Utf8 getOptionalUInt32VarArray 
.const [177] = Utf8 ()[J 
.const [178] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [179] = Utf8 setNotification 
.const [180] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [181] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [182] = Utf8 clearNotification 
.const [183] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [184] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [185] = Utf8 clearNotification 
.const [186] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [187] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS 
.const [188] = Utf8 clearNotification 
.const [189] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericReply;)V 
.const [190] = Utf8 de/esolutions/fw/comm/asi/hmisync/generic/impl/ASIHMISyncGenericService 
.const [191] = Class [190] 
.const [192] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [193] = Class [192] 
.const [194] = Utf8 context 
.const [195] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [196] = Utf8 p_ASIHMISyncGeneric 
.const [197] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS; 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/generic/ASIHMISyncGenericS;)V 
.const [201] = Utf8 createReplyProxy 
.const [202] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [203] = Utf8 getCallContext 
.const [204] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [205] = Utf8 handleCallMethod 
.const [206] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [207] = Utf8 <clinit> 
.const [208] = Utf8 ()V 
.end class 
