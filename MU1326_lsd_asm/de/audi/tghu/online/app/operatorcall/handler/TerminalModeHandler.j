.version 50 0 
.class public super [145] 
.super [147] 
.field private static final [148] [149] 
.field private static final [150] [151] 
.field private final [152] [153] 
.field private [154] [155] 
.field private [156] [157] 
.field private final [158] [159] 

.method public [161] : [162] 
    .attribute [160] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     invokevirtual [19] 
L11:    putfield [30] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [31] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [32] 
L24:    aload_0 
L25:    aload_2 
L26:    ldc [3] 
L28:    invokeinterface [33] 0 
L33:    putfield [34] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnull L103 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [24] 
L9:     putfield [31] 
L12:    aload_0 
L13:    getfield [20] 
L16:    ldc [4] 
L18:    ldc [5] 
L20:    aload_0 
L21:    getfield [21] 
L24:    invokestatic [6] 
L27:    invokevirtual [25] 
L30:    pop 
L31:    aload_0 
L32:    getfield [22] 
L35:    aload_0 
L36:    getfield [21] 
L39:    invokevirtual [26] 
L42:    ifeq L60 
L45:    aload_0 
L46:    getfield [20] 
L49:    ldc [4] 
L51:    ldc [7] 
L53:    invokevirtual [27] 
L56:    pop 
L57:    goto L122 
L60:    aload_0 
L61:    getfield [20] 
L64:    ldc [4] 
L66:    ldc [8] 
L68:    invokevirtual [27] 
L71:    pop 
L72:    aload_0 
L73:    getfield [22] 
L76:    invokevirtual [28] 
L79:    aload_0 
L80:    getfield [23] 
L83:    aload_0 
L84:    getfield [21] 
L87:    ifeq L94 
L90:    iconst_1 
L91:    goto L95 
L94:    iconst_0 
L95:    invokeinterface [35] 0 
L100:   goto L122 
L103:   aload_0 
L104:   getfield [20] 
L107:   ldc [4] 
L109:   ldc [9] 
L111:   aload_0 
L112:   getfield [21] 
L115:   invokestatic [6] 
L118:   invokevirtual [25] 
L121:   pop 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method public interface [165] : [166] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Int 1059005184 
.const [4] = Int 1078071040 
.const [5] = String [38] 
.const [6] = Method [39] [40] 
.const [7] = String [41] 
.const [8] = String [42] 
.const [9] = String [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Class [50] 
.const [17] = Class [51] 
.const [18] = Class [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Method [71] [72] 
.const [29] = Method [73] [74] 
.const [30] = Field [75] [76] 
.const [31] = Field [77] [78] 
.const [32] = Field [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Field [83] [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = Class [87] 
.const [37] = NameAndType [88] [89] 
.const [38] = Utf8 "TerminalModeUpdateListener#updateAudioConnectionUsage: setting isTerminalModeActive to '%1'." 
.const [39] = Class [90] 
.const [40] = NameAndType [91] [92] 
.const [41] = Utf8 'TerminalModeUpdateListener#updateAudioConnectionUsage: Do not trigger abort connection because a CarPlay call is connecting.' 
.const [42] = Utf8 'TerminalModeUpdateListener#updateAudioConnectionUsage: Triggering terminalModeChanged()' 
.const [43] = Utf8 "TerminalModeUpdateListener#updateAudioConnectionUsage: reveiced null for pAudioUsageList '%1'." 
.const [44] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [45] = Utf8 de/audi/atip/interapp/terminalmode/DefaultTerminalModeUpdateListener 
.const [46] = Utf8 de/audi/tghu/online/app/Online 
.const [47] = Utf8 de/audi/atip/hmi/HMIService 
.const [48] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAudioUsage 
.const [49] = Utf8 java/lang/Boolean 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Utf8 de/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain 
.const [52] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
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
.const [75] = Class [126] 
.const [76] = NameAndType [127] [128] 
.const [77] = Class [129] 
.const [78] = NameAndType [130] [131] 
.const [79] = Class [132] 
.const [80] = NameAndType [133] [134] 
.const [81] = Class [135] 
.const [82] = NameAndType [136] [137] 
.const [83] = Class [138] 
.const [84] = NameAndType [139] [140] 
.const [85] = Class [141] 
.const [86] = NameAndType [142] [143] 
.const [87] = Utf8 de/audi/tghu/online/app/Online 
.const [88] = Utf8 getInstance 
.const [89] = Utf8 ()Lde/audi/tghu/online/app/Online; 
.const [90] = Utf8 java/lang/Boolean 
.const [91] = Utf8 toString 
.const [92] = Utf8 (Z)Ljava/lang/String; 
.const [93] = Utf8 de/audi/tghu/online/app/Online 
.const [94] = Utf8 getOperatorCallLogChannel 
.const [95] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [96] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [97] = Utf8 logChannel 
.const [98] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [99] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [100] = Utf8 isTerminalModeActive 
.const [101] = Utf8 Z 
.const [102] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [103] = Utf8 operatorCallMain 
.const [104] = Utf8 Lde/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain; 
.const [105] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [106] = Utf8 operatorCallBlockedByTMChoice 
.const [107] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [108] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAudioUsage 
.const [109] = Utf8 isInUse 
.const [110] = Utf8 ()Z 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 log 
.const [113] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [114] = Utf8 de/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain 
.const [115] = Utf8 isTerminalModeChangedSupressed 
.const [116] = Utf8 (Z)Z 
.const [117] = Utf8 de/audi/atip/log/LogChannel 
.const [118] = Utf8 log 
.const [119] = Utf8 (ILjava/lang/String;)Z 
.const [120] = Utf8 de/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain 
.const [121] = Utf8 terminalModeChanged 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/audi/atip/interapp/terminalmode/DefaultTerminalModeUpdateListener 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [127] = Utf8 logChannel 
.const [128] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [129] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [130] = Utf8 isTerminalModeActive 
.const [131] = Utf8 Z 
.const [132] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [133] = Utf8 operatorCallMain 
.const [134] = Utf8 Lde/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain; 
.const [135] = Utf8 de/audi/atip/hmi/HMIService 
.const [136] = Utf8 getChoiceModel 
.const [137] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [138] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [139] = Utf8 operatorCallBlockedByTMChoice 
.const [140] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [141] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [142] = Utf8 setValue 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 de/audi/tghu/online/app/operatorcall/handler/TerminalModeHandler 
.const [145] = Class [144] 
.const [146] = Utf8 de/audi/atip/interapp/terminalmode/DefaultTerminalModeUpdateListener 
.const [147] = Class [146] 
.const [148] = Utf8 TERMINALMODE_CALL_ACTIVE 
.const [149] = Utf8 I 
.const [150] = Utf8 TERMINALMODE_CALL_NOT_ACTIVE 
.const [151] = Utf8 I 
.const [152] = Utf8 logChannel 
.const [153] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 isTerminalModeActive 
.const [155] = Utf8 Z 
.const [156] = Utf8 operatorCallMain 
.const [157] = Utf8 Lde/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain; 
.const [158] = Utf8 operatorCallBlockedByTMChoice 
.const [159] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [160] = Utf8 Code 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/audi/tghu/online/app/operatorcall/AbstractOperatorCallMain;Lde/audi/atip/hmi/HMIService;)V 
.const [163] = Utf8 updateAudioConnectionUsage 
.const [164] = Utf8 (Lde/audi/atip/interapp/terminalmode/TerminalModeAudioUsage;)V 
.const [165] = Utf8 isTerminalModeActive 
.const [166] = Utf8 ()Z 
.end class 
