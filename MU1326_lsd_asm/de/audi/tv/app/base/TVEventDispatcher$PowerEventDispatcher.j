.version 50 0 
.class super [140] 
.super [142] 
.implements [144] 
.field private final synthetic [145] [146] 

.method private [148] : [149] 
    .attribute [147] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [30] 
L5:     aload_0 
L6:     invokespecial [28] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [147] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    invokevirtual [22] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [147] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [5] 
L11:    invokevirtual [22] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [147] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [6] 
L11:    iload_1 
L12:    i2l 
L13:    invokevirtual [23] 
L16:    pop 
L17:    iload_2 
L18:    ifeq L22 
L21:    return 
L22:    iload_1 
L23:    lookupswitch 
            1 : L119 
            2 : L48 
            default : L190 

L48:    iconst_0 
L49:    istore_3 
L50:    iload_3 
L51:    aload_0 
L52:    getfield [21] 
L55:    invokestatic [7] 
L58:    invokevirtual [24] 
L61:    if_icmpge L116 
L64:    aload_0 
L65:    getfield [21] 
L68:    invokestatic [8] 
L71:    invokestatic [9] 
L74:    new [31] 
L77:    dup 
L78:    iconst_0 
L79:    invokespecial [29] 
L82:    invokeinterface [32] 0 
L87:    aload_0 
L88:    getfield [21] 
L91:    invokestatic [7] 
L94:    iload_3 
L95:    invokevirtual [25] 
L98:    checkcast [11] 
L101:   astore 4 
L103:   aload 4 
L105:   invokeinterface [33] 0 
L110:   iinc 3 1 
L113:   goto L50 
L116:   goto L190 
L119:   iconst_0 
L120:   istore_3 
L121:   iload_3 
L122:   aload_0 
L123:   getfield [21] 
L126:   invokestatic [7] 
L129:   invokevirtual [24] 
L132:   if_icmpge L187 
L135:   aload_0 
L136:   getfield [21] 
L139:   invokestatic [8] 
L142:   invokestatic [9] 
L145:   new [31] 
L148:   dup 
L149:   iconst_1 
L150:   invokespecial [29] 
L153:   invokeinterface [32] 0 
L158:   aload_0 
L159:   getfield [21] 
L162:   invokestatic [7] 
L165:   iload_3 
L166:   invokevirtual [25] 
L169:   checkcast [11] 
L172:   astore 4 
L174:   aload 4 
L176:   invokeinterface [34] 0 
L181:   iinc 3 1 
L184:   goto L121 
L187:   goto L190 
L190:   return 
L191:   nop 
L192:   
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [147] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [12] 
L11:    iload_1 
L12:    iload_2 
L13:    invokevirtual [26] 
L16:    aload_0 
L17:    getfield [21] 
L20:    invokestatic [8] 
L23:    invokestatic [13] 
L26:    new [31] 
L29:    dup 
L30:    iload_2 
L31:    invokespecial [29] 
L34:    invokeinterface [32] 0 
L39:    return 
L40:    
    .end code 
.end method 

.method synthetic [158] : [159] 
    .attribute [147] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [35] [36] 
.const [3] = Int -2137614336 
.const [4] = String [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = Method [40] [41] 
.const [8] = Method [42] [43] 
.const [9] = Method [44] [45] 
.const [10] = Class [46] 
.const [11] = Class [47] 
.const [12] = String [48] 
.const [13] = Method [49] [50] 
.const [14] = Class [51] 
.const [15] = Class [52] 
.const [16] = Class [53] 
.const [17] = Class [54] 
.const [18] = Class [55] 
.const [19] = Class [56] 
.const [20] = Class [57] 
.const [21] = Field [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Field [76] [77] 
.const [31] = Class [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = InterfaceMethod [83] [84] 
.const [35] = Class [85] 
.const [36] = NameAndType [86] [87] 
.const [37] = Utf8 '[TVEventDispatcher.notifyPowerListenerOnEnterState]' 
.const [38] = Utf8 '[TVEventDispatcher.notifyPowerListenerOnExitState]' 
.const [39] = Utf8 '[TVEventDispatcher.notifyPowerTriggerAction] trigger: %1' 
.const [40] = Class [88] 
.const [41] = NameAndType [89] [90] 
.const [42] = Class [91] 
.const [43] = NameAndType [92] [93] 
.const [44] = Class [94] 
.const [45] = NameAndType [95] [96] 
.const [46] = Utf8 java/lang/Boolean 
.const [47] = Utf8 de/audi/tv/app/base/ITVEventListener 
.const [48] = Utf8 '[TVEventDispatcher.updateClampState] clampS %1, clamp15 %2' 
.const [49] = Class [97] 
.const [50] = NameAndType [98] [99] 
.const [51] = Utf8 de/audi/tv/app/base/TVEventDispatcher$PowerEventDispatcher 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/audi/tv/app/base/TVEventDispatcher 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 java/util/ArrayList 
.const [56] = Utf8 de/audi/tv/app/base/TVEventDispatcher$Properties 
.const [57] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Utf8 java/lang/Boolean 
.const [79] = Class [130] 
.const [80] = NameAndType [131] [132] 
.const [81] = Class [133] 
.const [82] = NameAndType [134] [135] 
.const [83] = Class [136] 
.const [84] = NameAndType [137] [138] 
.const [85] = Utf8 de/audi/tv/app/base/TVEventDispatcher 
.const [86] = Utf8 access$900 
.const [87] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher;)Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/tv/app/base/TVEventDispatcher 
.const [89] = Utf8 access$1000 
.const [90] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher;)Ljava/util/ArrayList; 
.const [91] = Utf8 de/audi/tv/app/base/TVEventDispatcher 
.const [92] = Utf8 access$1100 
.const [93] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher;)Lde/audi/tv/app/base/TVEventDispatcher$Properties; 
.const [94] = Utf8 de/audi/tv/app/base/TVEventDispatcher$Properties 
.const [95] = Utf8 access$1300 
.const [96] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher$Properties;)Lde/audi/atip/utils/reactive/properties/Property; 
.const [97] = Utf8 de/audi/tv/app/base/TVEventDispatcher$Properties 
.const [98] = Utf8 access$1400 
.const [99] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher$Properties;)Lde/audi/atip/utils/reactive/properties/Property; 
.const [100] = Utf8 de/audi/tv/app/base/TVEventDispatcher$PowerEventDispatcher 
.const [101] = Utf8 this$0 
.const [102] = Utf8 Lde/audi/tv/app/base/TVEventDispatcher; 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;)Z 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;J)Z 
.const [109] = Utf8 java/util/ArrayList 
.const [110] = Utf8 size 
.const [111] = Utf8 ()I 
.const [112] = Utf8 java/util/ArrayList 
.const [113] = Utf8 get 
.const [114] = Utf8 (I)Ljava/lang/Object; 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;ZZ)V 
.const [118] = Utf8 de/audi/tv/app/base/TVEventDispatcher$PowerEventDispatcher 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher;)V 
.const [121] = Utf8 java/lang/Object 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 java/lang/Boolean 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Z)V 
.const [127] = Utf8 de/audi/tv/app/base/TVEventDispatcher$PowerEventDispatcher 
.const [128] = Utf8 this$0 
.const [129] = Utf8 Lde/audi/tv/app/base/TVEventDispatcher; 
.const [130] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [131] = Utf8 accept 
.const [132] = Utf8 (Ljava/lang/Object;)V 
.const [133] = Utf8 de/audi/tv/app/base/ITVEventListener 
.const [134] = Utf8 onPowerStateStandby 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/audi/tv/app/base/ITVEventListener 
.const [137] = Utf8 onPowerStateOn 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/audi/tv/app/base/TVEventDispatcher$PowerEventDispatcher 
.const [140] = Class [139] 
.const [141] = Utf8 java/lang/Object 
.const [142] = Class [141] 
.const [143] = Utf8 de/audi/atip/power/PowerEventListener 
.const [144] = Class [143] 
.const [145] = Utf8 this$0 
.const [146] = Utf8 Lde/audi/tv/app/base/TVEventDispatcher; 
.const [147] = Utf8 Code 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher;)V 
.const [150] = Utf8 notifyPowerListenerOnEnterState 
.const [151] = Utf8 (II)V 
.const [152] = Utf8 notifyPowerListenerOnExitState 
.const [153] = Utf8 (II)V 
.const [154] = Utf8 notifyPowerTriggerAction 
.const [155] = Utf8 (II)V 
.const [156] = Utf8 updateClampState 
.const [157] = Utf8 (ZZZZ)V 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Lde/audi/tv/app/base/TVEventDispatcher;Lde/audi/tv/app/base/TVEventDispatcher$1;)V 
.end class 
