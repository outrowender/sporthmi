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
        .catch [12] from L0 to L239 using L242 
L0:     iload_1 
L1:     tableswitch 0 
            L144 
            L186 
            L160 
            L212 
            L212 
            L76 
            L118 
            L92 
            L52 
            default : L212 

L52:    aload_2 
L53:    invokestatic [8] 
L56:    astore 4 
L58:    aload_0 
L59:    getfield [23] 
L62:    aload 4 
L64:    aload_3 
L65:    checkcast [6] 
L68:    invokeinterface [37] 0 
L73:    goto L239 
L76:    aload_0 
L77:    getfield [23] 
L80:    aload_3 
L81:    checkcast [6] 
L84:    invokeinterface [38] 0 
L89:    goto L239 
L92:    aload_2 
L93:    invokeinterface [39] 0 
L98:    lstore 4 
L100:   aload_0 
L101:   getfield [23] 
L104:   lload 4 
L106:   aload_3 
L107:   checkcast [6] 
L110:   invokeinterface [40] 0 
L115:   goto L239 
L118:   aload_2 
L119:   invokeinterface [41] 0 
L124:   astore 4 
L126:   aload_0 
L127:   getfield [23] 
L130:   aload 4 
L132:   aload_3 
L133:   checkcast [6] 
L136:   invokeinterface [42] 0 
L141:   goto L239 
L144:   aload_0 
L145:   getfield [23] 
L148:   aload_3 
L149:   checkcast [6] 
L152:   invokeinterface [43] 0 
L157:   goto L239 
L160:   aload_2 
L161:   invokeinterface [39] 0 
L166:   lstore 4 
L168:   aload_0 
L169:   getfield [23] 
L172:   lload 4 
L174:   aload_3 
L175:   checkcast [6] 
L178:   invokeinterface [44] 0 
L183:   goto L239 
L186:   aload_2 
L187:   invokeinterface [41] 0 
L192:   astore 4 
L194:   aload_0 
L195:   getfield [23] 
L198:   aload 4 
L200:   aload_3 
L201:   checkcast [6] 
L204:   invokeinterface [45] 0 
L209:   goto L239 
L212:   new [46] 
L215:   dup 
L216:   new [47] 
L219:   dup 
L220:   invokespecial [32] 
L223:   ldc [11] 
L225:   invokevirtual [24] 
L228:   iload_1 
L229:   invokevirtual [25] 
L232:   invokevirtual [26] 
L235:   invokespecial [33] 
L238:   athrow 
L239:   goto L284 
L242:   astore 4 
L244:   new [46] 
L247:   dup 
L248:   new [47] 
L251:   dup 
L252:   invokespecial [32] 
L255:   ldc [13] 
L257:   invokevirtual [24] 
L260:   iload_1 
L261:   invokevirtual [25] 
L264:   ldc [14] 
L266:   invokevirtual [24] 
L269:   aload 4 
L271:   invokevirtual [27] 
L274:   invokevirtual [24] 
L277:   invokevirtual [26] 
L280:   invokespecial [33] 
L283:   athrow 
L284:   return 
L285:   nop 
L286:   nop 
L287:   nop 
L288:   
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
.const [49] = Utf8 '43ddd4bf-1185-405b-ad9d-d74c07925b2a' 
.const [50] = Utf8 '59fbcec2-b8b2-5f69-a9e5-b65f2d9a124c' 
.const [51] = Utf8 'asi.hmisync.navigation.ASIHMISyncNavigation' 
.const [52] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyProxy 
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
.const [63] = Utf8 'STUB.asi.hmisync.navigation.ASIHMISyncNavigation' 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationService 
.const [67] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [68] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/DestinationInfoSerializer 
.const [69] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
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
.const [97] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyProxy 
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
.const [118] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationService 
.const [119] = Utf8 context 
.const [120] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [121] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/DestinationInfoSerializer 
.const [122] = Utf8 getOptionalDestinationInfoVarArray 
.const [123] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo; 
.const [124] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [125] = Utf8 getContext 
.const [126] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [127] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationService 
.const [128] = Utf8 p_ASIHMISyncNavigation 
.const [129] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS; 
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
.const [148] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationReplyProxy 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationService 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Ljava/lang/String;)V 
.const [160] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationService 
.const [161] = Utf8 p_ASIHMISyncNavigation 
.const [162] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS; 
.const [163] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [164] = Utf8 startGuidanceToDestinations 
.const [165] = Utf8 ([Lde/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo;Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [166] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [167] = Utf8 setNotification 
.const [168] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getUInt32 
.const [171] = Utf8 ()J 
.const [172] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [173] = Utf8 setNotification 
.const [174] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [175] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [176] = Utf8 getOptionalUInt32VarArray 
.const [177] = Utf8 ()[J 
.const [178] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [179] = Utf8 setNotification 
.const [180] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [181] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [182] = Utf8 clearNotification 
.const [183] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [184] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [185] = Utf8 clearNotification 
.const [186] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [187] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS 
.const [188] = Utf8 clearNotification 
.const [189] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationReply;)V 
.const [190] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/impl/ASIHMISyncNavigationService 
.const [191] = Class [190] 
.const [192] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [193] = Class [192] 
.const [194] = Utf8 context 
.const [195] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [196] = Utf8 p_ASIHMISyncNavigation 
.const [197] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS; 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/navigation/ASIHMISyncNavigationS;)V 
.const [201] = Utf8 createReplyProxy 
.const [202] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [203] = Utf8 getCallContext 
.const [204] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [205] = Utf8 handleCallMethod 
.const [206] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [207] = Utf8 <clinit> 
.const [208] = Utf8 ()V 
.end class 
