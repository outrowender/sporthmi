.version 50 0 
.class super [168] 
.super [170] 
.field private [171] [172] 
.field private final synthetic [173] [174] 

.method private [176] : [177] 
    .attribute [175] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [31] 
L5:     aload_0 
L6:     invokespecial [27] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [32] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private interface [178] : [179] 
    .attribute [175] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [180] : [181] 
    .attribute [175] .code stack 2 locals 5 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokestatic [2] 
L7:     invokeinterface [33] 0 
L12:    ifle L134 
L15:    aload_0 
L16:    getfield [17] 
L19:    invokestatic [3] 
L22:    aload_0 
L23:    getfield [17] 
L26:    invokestatic [4] 
L29:    invokeinterface [33] 0 
L34:    invokeinterface [34] 0 
L39:    astore 4 
L41:    aload 4 
L43:    invokeinterface [35] 0 
L48:    ifeq L134 
L51:    aload 4 
L53:    invokeinterface [36] 0 
L58:    checkcast [5] 
L61:    invokevirtual [19] 
L64:    checkcast [6] 
L67:    astore_2 
L68:    aload_2 
L69:    instanceof [7] 
L72:    ifeq L41 
L75:    aload_2 
L76:    checkcast [7] 
L79:    astore_3 
L80:    aload_1 
L81:    invokevirtual [20] 
L84:    istore 5 
L86:    aload_3 
L87:    invokevirtual [20] 
L90:    istore 6 
L92:    aload_3 
L93:    invokevirtual [21] 
L96:    aload_1 
L97:    invokevirtual [21] 
L100:   if_icmpeq L117 
L103:   iload 5 
L105:   bipush 100 
L107:   if_icmpne L131 
L110:   iload 6 
L112:   bipush 100 
L114:   if_icmpne L131 
L117:   aload_1 
L118:   aload_3 
L119:   invokevirtual [22] 
L122:   ifne L129 
L125:   iconst_1 
L126:   goto L130 
L129:   iconst_0 
L130:   areturn 
L131:   goto L41 
L134:   iconst_1 
L135:   areturn 
L136:   
    .end code 
.end method 

.method private [182] : [183] 
    .attribute [175] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [23] 
L4:     ifne L19 
L7:     aload_0 
L8:     aload_1 
L9:     invokespecial [28] 
L12:    ifne L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [175] .code stack 7 locals 1 
L0:     aload_1 
L1:     invokevirtual [19] 
L4:     astore_3 
L5:     aload_3 
L6:     instanceof [7] 
L9:     ifeq L67 
L12:    aload_0 
L13:    aload_3 
L14:    checkcast [7] 
L17:    invokespecial [29] 
L20:    ifeq L67 
L23:    aload_0 
L24:    getfield [17] 
L27:    invokestatic [8] 
L30:    ldc [9] 
L32:    ldc [10] 
L34:    aload_3 
L35:    checkcast [7] 
L38:    invokevirtual [21] 
L41:    i2l 
L42:    aload_3 
L43:    checkcast [7] 
L46:    invokevirtual [20] 
L49:    i2l 
L50:    invokevirtual [24] 
L53:    pop 
L54:    aload_0 
L55:    dup 
L56:    getfield [18] 
L59:    iconst_1 
L60:    iadd 
L61:    putfield [32] 
L64:    goto L73 
L67:    aload_0 
L68:    aload_1 
L69:    iload_2 
L70:    invokespecial [30] 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method synthetic [186] : [187] 
    .attribute [175] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [26] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [188] : [189] 
    .attribute [175] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [37] [38] 
.const [3] = Method [39] [40] 
.const [4] = Method [41] [42] 
.const [5] = Class [43] 
.const [6] = Class [44] 
.const [7] = Class [45] 
.const [8] = Method [46] [47] 
.const [9] = Int -2137614336 
.const [10] = String [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Field [55] [56] 
.const [18] = Field [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = InterfaceMethod [87] [88] 
.const [34] = InterfaceMethod [89] [90] 
.const [35] = InterfaceMethod [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = Class [95] 
.const [38] = NameAndType [96] [97] 
.const [39] = Class [98] 
.const [40] = NameAndType [99] [100] 
.const [41] = Class [101] 
.const [42] = NameAndType [102] [103] 
.const [43] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [44] = Utf8 de/audi/atip/hmi/event/ATIPEvent 
.const [45] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [46] = Class [104] 
.const [47] = NameAndType [105] [106] 
.const [48] = Utf8 'HMIEventQueue do not post modelupdateevent (modelID: %1, is modeltype: %2), information not needed ' 
.const [49] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [50] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [51] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue 
.const [52] = Utf8 java/util/List 
.const [53] = Utf8 java/util/ListIterator 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Class [107] 
.const [56] = NameAndType [108] [109] 
.const [57] = Class [110] 
.const [58] = NameAndType [111] [112] 
.const [59] = Class [113] 
.const [60] = NameAndType [114] [115] 
.const [61] = Class [116] 
.const [62] = NameAndType [117] [118] 
.const [63] = Class [119] 
.const [64] = NameAndType [120] [121] 
.const [65] = Class [122] 
.const [66] = NameAndType [123] [124] 
.const [67] = Class [125] 
.const [68] = NameAndType [126] [127] 
.const [69] = Class [128] 
.const [70] = NameAndType [129] [130] 
.const [71] = Class [131] 
.const [72] = NameAndType [132] [133] 
.const [73] = Class [134] 
.const [74] = NameAndType [135] [136] 
.const [75] = Class [137] 
.const [76] = NameAndType [138] [139] 
.const [77] = Class [140] 
.const [78] = NameAndType [141] [142] 
.const [79] = Class [143] 
.const [80] = NameAndType [144] [145] 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue 
.const [96] = Utf8 access$1000 
.const [97] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;)Ljava/util/List; 
.const [98] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue 
.const [99] = Utf8 access$1200 
.const [100] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;)Ljava/util/List; 
.const [101] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue 
.const [102] = Utf8 access$1100 
.const [103] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;)Ljava/util/List; 
.const [104] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue 
.const [105] = Utf8 access$700 
.const [106] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;)Lde/audi/atip/log/LogChannel; 
.const [107] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [108] = Utf8 this$0 
.const [109] = Utf8 Lde/audi/tghu/fwhmi/HMIEventQueue; 
.const [110] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [111] = Utf8 filteredEvents 
.const [112] = Utf8 I 
.const [113] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [114] = Utf8 getPayload 
.const [115] = Utf8 ()Ljava/lang/Object; 
.const [116] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [117] = Utf8 getModelType 
.const [118] = Utf8 ()I 
.const [119] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [120] = Utf8 getModelId 
.const [121] = Utf8 ()I 
.const [122] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [123] = Utf8 isRedundantToAlreadyQueuedEvent 
.const [124] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)Z 
.const [125] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [126] = Utf8 alwaysPlaceInQueue 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 de/audi/atip/log/LogChannel 
.const [129] = Utf8 log 
.const [130] = Utf8 (ILjava/lang/String;JJ)Z 
.const [131] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [132] = Utf8 getFilteredEvents 
.const [133] = Utf8 ()I 
.const [134] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;)V 
.const [137] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [141] = Utf8 isEventNeededInQueue 
.const [142] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)Z 
.const [143] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [144] = Utf8 discardEvent 
.const [145] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)Z 
.const [146] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [147] = Utf8 enqueue 
.const [148] = Utf8 (Lde/esolutions/fw/util/commons/job/Job;I)V 
.const [149] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [150] = Utf8 this$0 
.const [151] = Utf8 Lde/audi/tghu/fwhmi/HMIEventQueue; 
.const [152] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [153] = Utf8 filteredEvents 
.const [154] = Utf8 I 
.const [155] = Utf8 java/util/List 
.const [156] = Utf8 size 
.const [157] = Utf8 ()I 
.const [158] = Utf8 java/util/List 
.const [159] = Utf8 listIterator 
.const [160] = Utf8 (I)Ljava/util/ListIterator; 
.const [161] = Utf8 java/util/ListIterator 
.const [162] = Utf8 hasPrevious 
.const [163] = Utf8 ()Z 
.const [164] = Utf8 java/util/ListIterator 
.const [165] = Utf8 previous 
.const [166] = Utf8 ()Ljava/lang/Object; 
.const [167] = Utf8 de/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter 
.const [168] = Class [167] 
.const [169] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [170] = Class [169] 
.const [171] = Utf8 filteredEvents 
.const [172] = Utf8 I 
.const [173] = Utf8 this$0 
.const [174] = Utf8 Lde/audi/tghu/fwhmi/HMIEventQueue; 
.const [175] = Utf8 Code 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;)V 
.const [178] = Utf8 getFilteredEvents 
.const [179] = Utf8 ()I 
.const [180] = Utf8 isEventNeededInQueue 
.const [181] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)Z 
.const [182] = Utf8 discardEvent 
.const [183] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)Z 
.const [184] = Utf8 enqueue 
.const [185] = Utf8 (Lde/esolutions/fw/util/commons/job/Job;I)V 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue;Lde/audi/tghu/fwhmi/HMIEventQueue$1;)V 
.const [188] = Utf8 access$500 
.const [189] = Utf8 (Lde/audi/tghu/fwhmi/HMIEventQueue$ModelUpdateFilter;)I 
.end class 
