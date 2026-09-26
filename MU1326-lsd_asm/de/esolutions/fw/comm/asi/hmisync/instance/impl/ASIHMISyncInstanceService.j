.version 50 0 
.class public super [189] 
.super [191] 
.field private static final [192] [193] 
.field private [194] [195] 

.method public [197] : [198] 
    .attribute [196] .code stack 7 locals 0 
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

.method public [199] : [200] 
    .attribute [196] .code stack 2 locals 0 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [196] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [196] .code stack 4 locals 2 
        .catch [11] from L0 to L247 using L250 
L0:     iload_1 
L1:     tableswitch 0 
            L152 
            L194 
            L168 
            L48 
            L220 
            L84 
            L126 
            L100 
            default : L220 

L48:    aload_2 
L49:    invokeinterface [35] 0 
L54:    astore 4 
L56:    aload_2 
L57:    invokeinterface [35] 0 
L62:    astore 5 
L64:    aload_0 
L65:    getfield [21] 
L68:    aload 4 
L70:    aload 5 
L72:    aload_3 
L73:    checkcast [6] 
L76:    invokeinterface [36] 0 
L81:    goto L247 
L84:    aload_0 
L85:    getfield [21] 
L88:    aload_3 
L89:    checkcast [6] 
L92:    invokeinterface [37] 0 
L97:    goto L247 
L100:   aload_2 
L101:   invokeinterface [38] 0 
L106:   lstore 4 
L108:   aload_0 
L109:   getfield [21] 
L112:   lload 4 
L114:   aload_3 
L115:   checkcast [6] 
L118:   invokeinterface [39] 0 
L123:   goto L247 
L126:   aload_2 
L127:   invokeinterface [40] 0 
L132:   astore 4 
L134:   aload_0 
L135:   getfield [21] 
L138:   aload 4 
L140:   aload_3 
L141:   checkcast [6] 
L144:   invokeinterface [41] 0 
L149:   goto L247 
L152:   aload_0 
L153:   getfield [21] 
L156:   aload_3 
L157:   checkcast [6] 
L160:   invokeinterface [42] 0 
L165:   goto L247 
L168:   aload_2 
L169:   invokeinterface [38] 0 
L174:   lstore 4 
L176:   aload_0 
L177:   getfield [21] 
L180:   lload 4 
L182:   aload_3 
L183:   checkcast [6] 
L186:   invokeinterface [43] 0 
L191:   goto L247 
L194:   aload_2 
L195:   invokeinterface [40] 0 
L200:   astore 4 
L202:   aload_0 
L203:   getfield [21] 
L206:   aload 4 
L208:   aload_3 
L209:   checkcast [6] 
L212:   invokeinterface [44] 0 
L217:   goto L247 
L220:   new [45] 
L223:   dup 
L224:   new [46] 
L227:   dup 
L228:   invokespecial [30] 
L231:   ldc [10] 
L233:   invokevirtual [22] 
L236:   iload_1 
L237:   invokevirtual [23] 
L240:   invokevirtual [24] 
L243:   invokespecial [31] 
L246:   athrow 
L247:   goto L292 
L250:   astore 4 
L252:   new [45] 
L255:   dup 
L256:   new [46] 
L259:   dup 
L260:   invokespecial [30] 
L263:   ldc [12] 
L265:   invokevirtual [22] 
L268:   iload_1 
L269:   invokevirtual [23] 
L272:   ldc [13] 
L274:   invokevirtual [22] 
L277:   aload 4 
L279:   invokevirtual [25] 
L282:   invokevirtual [22] 
L285:   invokevirtual [24] 
L288:   invokespecial [31] 
L291:   athrow 
L292:   return 
L293:   nop 
L294:   nop 
L295:   nop 
L296:   
    .end code 
.end method 

.method static [205] : [206] 
    .attribute [196] .code stack 1 locals 0 
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
.const [2] = Class [47] 
.const [3] = String [48] 
.const [4] = String [49] 
.const [5] = String [50] 
.const [6] = Class [51] 
.const [7] = Field [52] [53] 
.const [8] = Class [54] 
.const [9] = Class [55] 
.const [10] = String [56] 
.const [11] = Class [57] 
.const [12] = String [58] 
.const [13] = String [59] 
.const [14] = String [60] 
.const [15] = Method [61] [62] 
.const [16] = Class [63] 
.const [17] = Class [64] 
.const [18] = Class [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Field [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Field [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Class [90] 
.const [33] = Field [91] [92] 
.const [34] = Class [93] 
.const [35] = InterfaceMethod [94] [95] 
.const [36] = InterfaceMethod [96] [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = InterfaceMethod [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = Class [114] 
.const [46] = Class [115] 
.const [47] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [48] = Utf8 ec3859ab-0660-4557-8339-69dc874fe86b 
.const [49] = Utf8 b0085475-d550-520a-8dc6-1d1e3293432f 
.const [50] = Utf8 'asi.hmisync.instance.ASIHMISyncInstance' 
.const [51] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceReplyProxy 
.const [52] = Class [116] 
.const [53] = NameAndType [117] [118] 
.const [54] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [55] = Utf8 java/lang/StringBuffer 
.const [56] = Utf8 'Invalid Method Id ' 
.const [57] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [58] = Utf8 'Deserialization failed: method=' 
.const [59] = Utf8 ', error=' 
.const [60] = Utf8 'STUB.asi.hmisync.instance.ASIHMISyncInstance' 
.const [61] = Class [119] 
.const [62] = NameAndType [120] [121] 
.const [63] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceService 
.const [64] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [65] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [66] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [67] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [68] = Class [122] 
.const [69] = NameAndType [123] [124] 
.const [70] = Class [125] 
.const [71] = NameAndType [126] [127] 
.const [72] = Class [128] 
.const [73] = NameAndType [129] [130] 
.const [74] = Class [131] 
.const [75] = NameAndType [132] [133] 
.const [76] = Class [134] 
.const [77] = NameAndType [135] [136] 
.const [78] = Class [137] 
.const [79] = NameAndType [138] [139] 
.const [80] = Class [140] 
.const [81] = NameAndType [141] [142] 
.const [82] = Class [143] 
.const [83] = NameAndType [144] [145] 
.const [84] = Class [146] 
.const [85] = NameAndType [147] [148] 
.const [86] = Class [149] 
.const [87] = NameAndType [150] [151] 
.const [88] = Class [152] 
.const [89] = NameAndType [153] [154] 
.const [90] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceReplyProxy 
.const [94] = Class [158] 
.const [95] = NameAndType [159] [160] 
.const [96] = Class [161] 
.const [97] = NameAndType [162] [163] 
.const [98] = Class [164] 
.const [99] = NameAndType [165] [166] 
.const [100] = Class [167] 
.const [101] = NameAndType [168] [169] 
.const [102] = Class [170] 
.const [103] = NameAndType [171] [172] 
.const [104] = Class [173] 
.const [105] = NameAndType [174] [175] 
.const [106] = Class [176] 
.const [107] = NameAndType [177] [178] 
.const [108] = Class [179] 
.const [109] = NameAndType [180] [181] 
.const [110] = Class [182] 
.const [111] = NameAndType [183] [184] 
.const [112] = Class [185] 
.const [113] = NameAndType [186] [187] 
.const [114] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceService 
.const [117] = Utf8 context 
.const [118] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [119] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [120] = Utf8 getContext 
.const [121] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [122] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceService 
.const [123] = Utf8 p_ASIHMISyncInstance 
.const [124] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS; 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 append 
.const [127] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 append 
.const [130] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 toString 
.const [133] = Utf8 ()Ljava/lang/String; 
.const [134] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [135] = Utf8 getMessage 
.const [136] = Utf8 ()Ljava/lang/String; 
.const [137] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [140] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [143] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceReplyProxy 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceService 
.const [147] = Utf8 context 
.const [148] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 <init> 
.const [151] = Utf8 ()V 
.const [152] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Ljava/lang/String;)V 
.const [155] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceService 
.const [156] = Utf8 p_ASIHMISyncInstance 
.const [157] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS; 
.const [158] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [159] = Utf8 getOptionalString 
.const [160] = Utf8 ()Ljava/lang/String; 
.const [161] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [162] = Utf8 requestInstanceId 
.const [163] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [164] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [165] = Utf8 setNotification 
.const [166] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [167] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [168] = Utf8 getUInt32 
.const [169] = Utf8 ()J 
.const [170] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [171] = Utf8 setNotification 
.const [172] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [173] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [174] = Utf8 getOptionalUInt32VarArray 
.const [175] = Utf8 ()[J 
.const [176] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [177] = Utf8 setNotification 
.const [178] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [179] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [180] = Utf8 clearNotification 
.const [181] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [182] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [183] = Utf8 clearNotification 
.const [184] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [185] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS 
.const [186] = Utf8 clearNotification 
.const [187] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceReply;)V 
.const [188] = Utf8 de/esolutions/fw/comm/asi/hmisync/instance/impl/ASIHMISyncInstanceService 
.const [189] = Class [188] 
.const [190] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [191] = Class [190] 
.const [192] = Utf8 context 
.const [193] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [194] = Utf8 p_ASIHMISyncInstance 
.const [195] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS; 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/instance/ASIHMISyncInstanceS;)V 
.const [199] = Utf8 createReplyProxy 
.const [200] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [201] = Utf8 getCallContext 
.const [202] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [203] = Utf8 handleCallMethod 
.const [204] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [205] = Utf8 <clinit> 
.const [206] = Utf8 ()V 
.end class 
