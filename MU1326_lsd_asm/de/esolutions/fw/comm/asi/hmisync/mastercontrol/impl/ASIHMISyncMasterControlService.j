.version 50 0 
.class public super [177] 
.super [179] 
.field private static final [180] [181] 
.field private [182] [183] 

.method public [185] : [186] 
    .attribute [184] .code stack 7 locals 0 
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

.method public [187] : [188] 
    .attribute [184] .code stack 2 locals 0 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [184] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [184] .code stack 4 locals 2 
        .catch [11] from L0 to L211 using L214 
L0:     iload_1 
L1:     tableswitch 0 
            L116 
            L158 
            L132 
            L184 
            L184 
            L48 
            L90 
            L64 
            default : L184 

L48:    aload_0 
L49:    getfield [21] 
L52:    aload_3 
L53:    checkcast [6] 
L56:    invokeinterface [35] 0 
L61:    goto L211 
L64:    aload_2 
L65:    invokeinterface [36] 0 
L70:    lstore 4 
L72:    aload_0 
L73:    getfield [21] 
L76:    lload 4 
L78:    aload_3 
L79:    checkcast [6] 
L82:    invokeinterface [37] 0 
L87:    goto L211 
L90:    aload_2 
L91:    invokeinterface [38] 0 
L96:    astore 4 
L98:    aload_0 
L99:    getfield [21] 
L102:   aload 4 
L104:   aload_3 
L105:   checkcast [6] 
L108:   invokeinterface [39] 0 
L113:   goto L211 
L116:   aload_0 
L117:   getfield [21] 
L120:   aload_3 
L121:   checkcast [6] 
L124:   invokeinterface [40] 0 
L129:   goto L211 
L132:   aload_2 
L133:   invokeinterface [36] 0 
L138:   lstore 4 
L140:   aload_0 
L141:   getfield [21] 
L144:   lload 4 
L146:   aload_3 
L147:   checkcast [6] 
L150:   invokeinterface [41] 0 
L155:   goto L211 
L158:   aload_2 
L159:   invokeinterface [38] 0 
L164:   astore 4 
L166:   aload_0 
L167:   getfield [21] 
L170:   aload 4 
L172:   aload_3 
L173:   checkcast [6] 
L176:   invokeinterface [42] 0 
L181:   goto L211 
L184:   new [43] 
L187:   dup 
L188:   new [44] 
L191:   dup 
L192:   invokespecial [30] 
L195:   ldc [10] 
L197:   invokevirtual [22] 
L200:   iload_1 
L201:   invokevirtual [23] 
L204:   invokevirtual [24] 
L207:   invokespecial [31] 
L210:   athrow 
L211:   goto L256 
L214:   astore 4 
L216:   new [43] 
L219:   dup 
L220:   new [44] 
L223:   dup 
L224:   invokespecial [30] 
L227:   ldc [12] 
L229:   invokevirtual [22] 
L232:   iload_1 
L233:   invokevirtual [23] 
L236:   ldc [13] 
L238:   invokevirtual [22] 
L241:   aload 4 
L243:   invokevirtual [25] 
L246:   invokevirtual [22] 
L249:   invokevirtual [24] 
L252:   invokespecial [31] 
L255:   athrow 
L256:   return 
L257:   nop 
L258:   nop 
L259:   nop 
L260:   
    .end code 
.end method 

.method static [193] : [194] 
    .attribute [184] .code stack 1 locals 0 
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
.const [2] = Class [45] 
.const [3] = String [46] 
.const [4] = String [47] 
.const [5] = String [48] 
.const [6] = Class [49] 
.const [7] = Field [50] [51] 
.const [8] = Class [52] 
.const [9] = Class [53] 
.const [10] = String [54] 
.const [11] = Class [55] 
.const [12] = String [56] 
.const [13] = String [57] 
.const [14] = String [58] 
.const [15] = Method [59] [60] 
.const [16] = Class [61] 
.const [17] = Class [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Field [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Class [88] 
.const [33] = Field [89] [90] 
.const [34] = Class [91] 
.const [35] = InterfaceMethod [92] [93] 
.const [36] = InterfaceMethod [94] [95] 
.const [37] = InterfaceMethod [96] [97] 
.const [38] = InterfaceMethod [98] [99] 
.const [39] = InterfaceMethod [100] [101] 
.const [40] = InterfaceMethod [102] [103] 
.const [41] = InterfaceMethod [104] [105] 
.const [42] = InterfaceMethod [106] [107] 
.const [43] = Class [108] 
.const [44] = Class [109] 
.const [45] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [46] = Utf8 bacc7eeb-475f-4a14-ad22-d3b237ca4c1b 
.const [47] = Utf8 '5e04952b-b55c-5075-a09b-d930bfab035a' 
.const [48] = Utf8 'asi.hmisync.mastercontrol.ASIHMISyncMasterControl' 
.const [49] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlReplyProxy 
.const [50] = Class [110] 
.const [51] = NameAndType [111] [112] 
.const [52] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 'Invalid Method Id ' 
.const [55] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [56] = Utf8 'Deserialization failed: method=' 
.const [57] = Utf8 ', error=' 
.const [58] = Utf8 'STUB.asi.hmisync.mastercontrol.ASIHMISyncMasterControl' 
.const [59] = Class [113] 
.const [60] = NameAndType [114] [115] 
.const [61] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlService 
.const [62] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [63] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [64] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [65] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Class [146] 
.const [87] = NameAndType [147] [148] 
.const [88] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [89] = Class [149] 
.const [90] = NameAndType [150] [151] 
.const [91] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlReplyProxy 
.const [92] = Class [152] 
.const [93] = NameAndType [153] [154] 
.const [94] = Class [155] 
.const [95] = NameAndType [156] [157] 
.const [96] = Class [158] 
.const [97] = NameAndType [159] [160] 
.const [98] = Class [161] 
.const [99] = NameAndType [162] [163] 
.const [100] = Class [164] 
.const [101] = NameAndType [165] [166] 
.const [102] = Class [167] 
.const [103] = NameAndType [168] [169] 
.const [104] = Class [170] 
.const [105] = NameAndType [171] [172] 
.const [106] = Class [173] 
.const [107] = NameAndType [174] [175] 
.const [108] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlService 
.const [111] = Utf8 context 
.const [112] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [113] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [114] = Utf8 getContext 
.const [115] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [116] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlService 
.const [117] = Utf8 p_ASIHMISyncMasterControl 
.const [118] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS; 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 append 
.const [121] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 append 
.const [124] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 toString 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [129] = Utf8 getMessage 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [134] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [137] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlReplyProxy 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlService 
.const [141] = Utf8 context 
.const [142] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Ljava/lang/String;)V 
.const [149] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlService 
.const [150] = Utf8 p_ASIHMISyncMasterControl 
.const [151] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS; 
.const [152] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [153] = Utf8 setNotification 
.const [154] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlReply;)V 
.const [155] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [156] = Utf8 getUInt32 
.const [157] = Utf8 ()J 
.const [158] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [159] = Utf8 setNotification 
.const [160] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlReply;)V 
.const [161] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [162] = Utf8 getOptionalUInt32VarArray 
.const [163] = Utf8 ()[J 
.const [164] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [165] = Utf8 setNotification 
.const [166] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlReply;)V 
.const [167] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [168] = Utf8 clearNotification 
.const [169] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlReply;)V 
.const [170] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [171] = Utf8 clearNotification 
.const [172] = Utf8 (JLde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlReply;)V 
.const [173] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS 
.const [174] = Utf8 clearNotification 
.const [175] = Utf8 ([JLde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlReply;)V 
.const [176] = Utf8 de/esolutions/fw/comm/asi/hmisync/mastercontrol/impl/ASIHMISyncMasterControlService 
.const [177] = Class [176] 
.const [178] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [179] = Class [178] 
.const [180] = Utf8 context 
.const [181] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [182] = Utf8 p_ASIHMISyncMasterControl 
.const [183] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS; 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/mastercontrol/ASIHMISyncMasterControlS;)V 
.const [187] = Utf8 createReplyProxy 
.const [188] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [189] = Utf8 getCallContext 
.const [190] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [191] = Utf8 handleCallMethod 
.const [192] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [193] = Utf8 <clinit> 
.const [194] = Utf8 ()V 
.end class 
