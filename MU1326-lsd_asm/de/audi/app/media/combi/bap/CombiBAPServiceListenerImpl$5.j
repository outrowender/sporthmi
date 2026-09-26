.version 50 0 
.class super [147] 
.super [149] 
.field private final synthetic [150] [151] 
.field private final synthetic [152] [153] 
.field private final synthetic [154] [155] 

.method [157] : [158] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [32] 
L5:     aload_0 
L6:     iload_3 
L7:     putfield [33] 
L10:    aload_0 
L11:    iload 4 
L13:    putfield [34] 
L16:    aload_0 
L17:    aload_2 
L18:    invokespecial [31] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [156] .code stack 8 locals 3 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    aload_0 
L14:    getfield [21] 
L17:    i2l 
L18:    aload_0 
L19:    getfield [22] 
L22:    i2l 
L23:    invokevirtual [23] 
L26:    pop 
L27:    aload_0 
L28:    getfield [20] 
L31:    invokestatic [6] 
L34:    invokevirtual [24] 
L37:    aload_0 
L38:    getfield [21] 
L41:    invokevirtual [25] 
L44:    astore_1 
L45:    aload_1 
L46:    ifnonnull L117 
L49:    aload_0 
L50:    getfield [20] 
L53:    invokestatic [2] 
L56:    ldc [7] 
L58:    ldc [8] 
L60:    ldc [5] 
L62:    aload_0 
L63:    getfield [21] 
L66:    i2l 
L67:    invokevirtual [26] 
L70:    pop 
        .catch [9] from L71 to L93 using L96 
L71:    aload_0 
L72:    getfield [20] 
L75:    invokestatic [6] 
L78:    invokevirtual [27] 
L81:    iconst_1 
L82:    aload_0 
L83:    getfield [21] 
L86:    iconst_m1 
L87:    iconst_m1 
L88:    invokeinterface [35] 0 
L93:    goto L116 
L96:    astore_2 
L97:    aload_0 
L98:    getfield [20] 
L101:   invokestatic [2] 
L104:   sipush 10000 
L107:   ldc [10] 
L109:   ldc [5] 
L111:   aload_2 
L112:   invokevirtual [28] 
L115:   pop 
L116:   return 
L117:   aload_0 
L118:   getfield [20] 
L121:   invokestatic [6] 
L124:   invokevirtual [29] 
L127:   astore_2 
L128:   aload_2 
L129:   ifnonnull L195 
L132:   aload_0 
L133:   getfield [20] 
L136:   invokestatic [2] 
L139:   ldc [3] 
L141:   ldc [11] 
L143:   ldc [5] 
L145:   invokevirtual [30] 
L148:   pop 
        .catch [9] from L149 to L171 using L174 
L149:   aload_0 
L150:   getfield [20] 
L153:   invokestatic [6] 
L156:   invokevirtual [27] 
L159:   iconst_1 
L160:   aload_0 
L161:   getfield [21] 
L164:   iconst_m1 
L165:   iconst_m1 
L166:   invokeinterface [35] 0 
L171:   goto L194 
L174:   astore_3 
L175:   aload_0 
L176:   getfield [20] 
L179:   invokestatic [2] 
L182:   sipush 10000 
L185:   ldc [10] 
L187:   ldc [5] 
L189:   aload_3 
L190:   invokevirtual [28] 
L193:   pop 
L194:   return 
L195:   aload_2 
L196:   aload_1 
L197:   aload_0 
L198:   getfield [22] 
L201:   invokeinterface [36] 0 
L206:   return 
L207:   nop 
L208:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [37] [38] 
.const [3] = Int 1078071040 
.const [4] = String [39] 
.const [5] = String [40] 
.const [6] = Method [41] [42] 
.const [7] = Int -1601830656 
.const [8] = String [43] 
.const [9] = Class [44] 
.const [10] = String [45] 
.const [11] = String [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Class [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Method [71] [72] 
.const [29] = Method [73] [74] 
.const [30] = Method [75] [76] 
.const [31] = Method [77] [78] 
.const [32] = Field [79] [80] 
.const [33] = Field [81] [82] 
.const [34] = Field [83] [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = InterfaceMethod [87] [88] 
.const [37] = Class [89] 
.const [38] = NameAndType [90] [91] 
.const [39] = Utf8 "[%1.getNextListPos] combiID='%2',offset='%3'." 
.const [40] = Utf8 CombiBAPServiceListenerImpl 
.const [41] = Class [92] 
.const [42] = NameAndType [93] [94] 
.const [43] = Utf8 "[%1.getNextListPos] No entryInfo found for combiID '%2'." 
.const [44] = Utf8 java/lang/Exception 
.const [45] = Utf8 '[%1.getNextListPos] Combi failed: %2' 
.const [46] = Utf8 '[%1.getNextListPos] No active combi content adapter.' 
.const [47] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [48] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [49] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [52] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [53] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceMedia 
.const [54] = Utf8 de/audi/app/media/combi/bap/ICombiBAPContentAdapter 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
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
.const [85] = Class [140] 
.const [86] = NameAndType [141] [142] 
.const [87] = Class [143] 
.const [88] = NameAndType [144] [145] 
.const [89] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [90] = Utf8 access$000 
.const [91] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [93] = Utf8 access$100 
.const [94] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/app/media/combi/bap/CombiBAPController; 
.const [95] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [96] = Utf8 this$0 
.const [97] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [98] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [99] = Utf8 val$pCombiID 
.const [100] = Utf8 I 
.const [101] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [102] = Utf8 val$pOffset 
.const [103] = Utf8 I 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [107] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [108] = Utf8 getIdMapper 
.const [109] = Utf8 ()Lde/audi/app/media/combi/bap/CombiBAPIdMapper; 
.const [110] = Utf8 de/audi/app/media/combi/bap/CombiBAPIdMapper 
.const [111] = Utf8 getEntry 
.const [112] = Utf8 (I)Lde/audi/app/media/combi/bap/CombiBAPMediaEntry; 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [116] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [117] = Utf8 getCombiBAPService 
.const [118] = Utf8 ()Lde/audi/atip/interapp/combi/bap/audio/CombiBAPServiceMedia; 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [122] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [123] = Utf8 getActiveCombiContentAdapter 
.const [124] = Utf8 ()Lde/audi/app/media/combi/bap/ICombiBAPContentAdapter; 
.const [125] = Utf8 de/audi/atip/log/LogChannel 
.const [126] = Utf8 log 
.const [127] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [128] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/String;)V 
.const [131] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [132] = Utf8 this$0 
.const [133] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [134] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [135] = Utf8 val$pCombiID 
.const [136] = Utf8 I 
.const [137] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [138] = Utf8 val$pOffset 
.const [139] = Utf8 I 
.const [140] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceMedia 
.const [141] = Utf8 getNextListPosResult 
.const [142] = Utf8 (IIII)V 
.const [143] = Utf8 de/audi/app/media/combi/bap/ICombiBAPContentAdapter 
.const [144] = Utf8 getNextListPos 
.const [145] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPMediaEntry;I)V 
.const [146] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$5 
.const [147] = Class [146] 
.const [148] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [149] = Class [148] 
.const [150] = Utf8 val$pCombiID 
.const [151] = Utf8 I 
.const [152] = Utf8 val$pOffset 
.const [153] = Utf8 I 
.const [154] = Utf8 this$0 
.const [155] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [156] = Utf8 Code 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;Ljava/lang/String;II)V 
.const [159] = Utf8 run 
.const [160] = Utf8 ()V 
.end class 
