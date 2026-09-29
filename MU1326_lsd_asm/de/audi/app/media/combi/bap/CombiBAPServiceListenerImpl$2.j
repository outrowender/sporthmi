.version 50 0 
.class super [127] 
.super [129] 
.field private final synthetic [130] [131] 
.field private final synthetic [132] [133] 
.field private final synthetic [134] [135] 

.method [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     iload_3 
L7:     putfield [26] 
L10:    aload_0 
L11:    iload 4 
L13:    putfield [27] 
L16:    aload_0 
L17:    aload_2 
L18:    invokespecial [24] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [136] .code stack 8 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    aload_0 
L14:    getfield [17] 
L17:    i2l 
L18:    aload_0 
L19:    getfield [18] 
L22:    i2l 
L23:    invokevirtual [19] 
L26:    pop 
L27:    aload_0 
L28:    getfield [16] 
L31:    invokestatic [6] 
L34:    invokevirtual [20] 
L37:    astore_1 
L38:    aload_1 
L39:    ifnonnull L60 
L42:    aload_0 
L43:    getfield [16] 
L46:    invokestatic [2] 
L49:    ldc [3] 
L51:    ldc [7] 
L53:    ldc [5] 
L55:    invokevirtual [21] 
L58:    pop 
L59:    return 
L60:    aload_0 
L61:    getfield [17] 
L64:    lookupswitch 
            2 : L92 
            4 : L92 
            default : L97 

L92:    iconst_1 
L93:    istore_2 
L94:    goto L99 
L97:    iconst_0 
L98:    istore_2 
L99:    aload_0 
L100:   getfield [18] 
L103:   tableswitch 1 
            L155 
            L140 
            L145 
            L160 
            L150 
            L165 
            default : L165 

L140:   iconst_0 
L141:   istore_3 
L142:   goto L210 
L145:   iconst_1 
L146:   istore_3 
L147:   goto L210 
L150:   iconst_2 
L151:   istore_3 
L152:   goto L210 
L155:   iconst_3 
L156:   istore_3 
L157:   goto L210 
L160:   iconst_4 
L161:   istore_3 
L162:   goto L210 
L165:   aload_0 
L166:   getfield [16] 
L169:   invokestatic [2] 
L172:   ldc [8] 
L174:   ldc [9] 
L176:   ldc [5] 
L178:   aload_0 
L179:   getfield [18] 
L182:   i2l 
L183:   invokevirtual [22] 
L186:   pop 
L187:   aload_0 
L188:   getfield [16] 
L191:   invokestatic [6] 
L194:   aload_1 
L195:   invokeinterface [28] 0 
L200:   aload_1 
L201:   invokeinterface [29] 0 
L206:   invokevirtual [23] 
L209:   return 
L210:   aload_1 
L211:   iload_3 
L212:   iload_2 
L213:   invokeinterface [30] 0 
L218:   ifne L243 
L221:   aload_0 
L222:   getfield [16] 
L225:   invokestatic [6] 
L228:   aload_1 
L229:   invokeinterface [28] 0 
L234:   aload_1 
L235:   invokeinterface [29] 0 
L240:   invokevirtual [23] 
L243:   return 
L244:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [31] [32] 
.const [3] = Int 1078071040 
.const [4] = String [33] 
.const [5] = String [34] 
.const [6] = Method [35] [36] 
.const [7] = String [37] 
.const [8] = Int -1601830656 
.const [9] = String [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Class [44] 
.const [16] = Field [45] [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Field [63] [64] 
.const [26] = Field [65] [66] 
.const [27] = Field [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = InterfaceMethod [71] [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = Class [75] 
.const [32] = NameAndType [76] [77] 
.const [33] = Utf8 "[%1.setActiveSourceState] PlayMode='%2',playScope='%3'." 
.const [34] = Utf8 CombiBAPServiceListenerImpl 
.const [35] = Class [78] 
.const [36] = NameAndType [79] [80] 
.const [37] = Utf8 '[%1.setActiveSourceState] No content adapter active. Ignore.' 
.const [38] = Utf8 "[%1.setActiveSourceState] Scope '%2' not supported. Ignored." 
.const [39] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [40] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [41] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [44] = Utf8 de/audi/app/media/combi/bap/ICombiBAPContentAdapter 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Class [114] 
.const [68] = NameAndType [115] [116] 
.const [69] = Class [117] 
.const [70] = NameAndType [118] [119] 
.const [71] = Class [120] 
.const [72] = NameAndType [121] [122] 
.const [73] = Class [123] 
.const [74] = NameAndType [124] [125] 
.const [75] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [76] = Utf8 access$000 
.const [77] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/atip/log/LogChannel; 
.const [78] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [79] = Utf8 access$100 
.const [80] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/app/media/combi/bap/CombiBAPController; 
.const [81] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [82] = Utf8 this$0 
.const [83] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [84] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [85] = Utf8 val$pPlayMode 
.const [86] = Utf8 I 
.const [87] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [88] = Utf8 val$pPlayScope 
.const [89] = Utf8 I 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [93] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [94] = Utf8 getActiveCombiContentAdapter 
.const [95] = Utf8 ()Lde/audi/app/media/combi/bap/ICombiBAPContentAdapter; 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 log 
.const [101] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [102] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [103] = Utf8 updateActiveRepeatScope 
.const [104] = Utf8 (IZ)V 
.const [105] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (Ljava/lang/String;)V 
.const [108] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [109] = Utf8 this$0 
.const [110] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [111] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [112] = Utf8 val$pPlayMode 
.const [113] = Utf8 I 
.const [114] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [115] = Utf8 val$pPlayScope 
.const [116] = Utf8 I 
.const [117] = Utf8 de/audi/app/media/combi/bap/ICombiBAPContentAdapter 
.const [118] = Utf8 getCurrentRepeatScope 
.const [119] = Utf8 ()I 
.const [120] = Utf8 de/audi/app/media/combi/bap/ICombiBAPContentAdapter 
.const [121] = Utf8 isMixActive 
.const [122] = Utf8 ()Z 
.const [123] = Utf8 de/audi/app/media/combi/bap/ICombiBAPContentAdapter 
.const [124] = Utf8 setRepeatScope 
.const [125] = Utf8 (IZ)Z 
.const [126] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$2 
.const [127] = Class [126] 
.const [128] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [129] = Class [128] 
.const [130] = Utf8 val$pPlayMode 
.const [131] = Utf8 I 
.const [132] = Utf8 val$pPlayScope 
.const [133] = Utf8 I 
.const [134] = Utf8 this$0 
.const [135] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;Ljava/lang/String;II)V 
.const [139] = Utf8 run 
.const [140] = Utf8 ()V 
.end class 
