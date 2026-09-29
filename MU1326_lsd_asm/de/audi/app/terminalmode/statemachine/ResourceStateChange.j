.version 50 0 
.class public super [139] 
.super [141] 
.field private final [142] [143] 
.field private final [144] [145] 
.field private final [146] [147] 

.method public [149] : [150] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     invokespecial [23] 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [28] 
L12:    aload_0 
L13:    aload_2 
L14:    putfield [29] 
L17:    aload_0 
L18:    aload_3 
L19:    putfield [30] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [148] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     istore_2 
L5:     bipush 31 
L7:     iload_2 
L8:     imul 
L9:     aload_0 
L10:    getfield [15] 
L13:    ifnonnull L20 
L16:    iconst_0 
L17:    goto L27 
L20:    aload_0 
L21:    getfield [15] 
L24:    invokevirtual [16] 
L27:    iadd 
L28:    istore_2 
L29:    bipush 31 
L31:    iload_2 
L32:    imul 
L33:    aload_0 
L34:    getfield [14] 
L37:    ifnonnull L44 
L40:    iconst_0 
L41:    goto L51 
L44:    aload_0 
L45:    getfield [14] 
L48:    invokevirtual [16] 
L51:    iadd 
L52:    istore_2 
L53:    bipush 31 
L55:    iload_2 
L56:    imul 
L57:    aload_0 
L58:    getfield [13] 
L61:    ifnonnull L68 
L64:    iconst_0 
L65:    goto L75 
L68:    aload_0 
L69:    getfield [13] 
L72:    invokevirtual [17] 
L75:    iadd 
L76:    istore_2 
L77:    iload_2 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [148] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_0 
L8:     aload_1 
L9:     invokespecial [25] 
L12:    ifne L17 
L15:    iconst_0 
L16:    areturn 
L17:    aload_0 
L18:    invokespecial [26] 
L21:    aload_1 
L22:    invokespecial [26] 
L25:    if_acmpeq L30 
L28:    iconst_0 
L29:    areturn 
L30:    aload_1 
L31:    checkcast [3] 
L34:    astore_2 
L35:    aload_0 
L36:    getfield [15] 
L39:    ifnonnull L51 
L42:    aload_2 
L43:    getfield [15] 
L46:    ifnull L67 
L49:    iconst_0 
L50:    areturn 
L51:    aload_0 
L52:    getfield [15] 
L55:    aload_2 
L56:    getfield [15] 
L59:    invokevirtual [18] 
L62:    ifne L67 
L65:    iconst_0 
L66:    areturn 
L67:    aload_0 
L68:    getfield [14] 
L71:    ifnonnull L83 
L74:    aload_2 
L75:    getfield [14] 
L78:    ifnull L99 
L81:    iconst_0 
L82:    areturn 
L83:    aload_0 
L84:    getfield [14] 
L87:    aload_2 
L88:    getfield [14] 
L91:    invokevirtual [18] 
L94:    ifne L99 
L97:    iconst_0 
L98:    areturn 
L99:    aload_0 
L100:   getfield [13] 
L103:   ifnonnull L115 
L106:   aload_2 
L107:   getfield [13] 
L110:   ifnull L131 
L113:   iconst_0 
L114:   areturn 
L115:   aload_0 
L116:   getfield [13] 
L119:   aload_2 
L120:   getfield [13] 
L123:   invokevirtual [19] 
L126:   ifne L131 
L129:   iconst_0 
L130:   areturn 
L131:   iconst_1 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [148] .code stack 3 locals 1 
L0:     new [31] 
L3:     dup 
L4:     bipush 100 
L6:     invokespecial [27] 
L9:     astore_1 
L10:    aload_1 
L11:    ldc [5] 
L13:    invokevirtual [20] 
L16:    pop 
L17:    aload_1 
L18:    aload_0 
L19:    getfield [13] 
L22:    invokevirtual [21] 
L25:    pop 
L26:    aload_1 
L27:    ldc [6] 
L29:    invokevirtual [20] 
L32:    pop 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [14] 
L38:    invokevirtual [21] 
L41:    pop 
L42:    aload_1 
L43:    ldc [7] 
L45:    invokevirtual [20] 
L48:    pop 
L49:    aload_1 
L50:    aload_0 
L51:    getfield [15] 
L54:    invokevirtual [21] 
L57:    pop 
L58:    aload_1 
L59:    ldc [8] 
L61:    invokevirtual [20] 
L64:    pop 
L65:    aload_1 
L66:    invokevirtual [22] 
L69:    areturn 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [32] [33] 
.const [3] = Class [34] 
.const [4] = Class [35] 
.const [5] = String [36] 
.const [6] = String [37] 
.const [7] = String [38] 
.const [8] = String [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Field [74] [75] 
.const [29] = Field [76] [77] 
.const [30] = Field [78] [79] 
.const [31] = Class [80] 
.const [32] = Class [81] 
.const [33] = NameAndType [82] [83] 
.const [34] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [35] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [36] = Utf8 "[ResourceStateChange resource='" 
.const [37] = Utf8 "' oldState='" 
.const [38] = Utf8 "' newState='" 
.const [39] = Utf8 "']" 
.const [40] = Utf8 de/audi/app/terminalmode/statemachine/AbstractStateChange 
.const [41] = Utf8 de/audi/app/terminalmode/statemachine/ResourceState 
.const [42] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [43] = Utf8 java/lang/Object 
.const [44] = Class [84] 
.const [45] = NameAndType [85] [86] 
.const [46] = Class [87] 
.const [47] = NameAndType [88] [89] 
.const [48] = Class [90] 
.const [49] = NameAndType [91] [92] 
.const [50] = Class [93] 
.const [51] = NameAndType [94] [95] 
.const [52] = Class [96] 
.const [53] = NameAndType [97] [98] 
.const [54] = Class [99] 
.const [55] = NameAndType [100] [101] 
.const [56] = Class [102] 
.const [57] = NameAndType [103] [104] 
.const [58] = Class [105] 
.const [59] = NameAndType [106] [107] 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Class [111] 
.const [63] = NameAndType [112] [113] 
.const [64] = Class [114] 
.const [65] = NameAndType [115] [116] 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [81] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [82] = Utf8 RESOURCESTATE 
.const [83] = Utf8 Lde/audi/app/terminalmode/statemachine/StateChangeType; 
.const [84] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [85] = Utf8 resourceId 
.const [86] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [87] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [88] = Utf8 oldState 
.const [89] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceState; 
.const [90] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [91] = Utf8 newState 
.const [92] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceState; 
.const [93] = Utf8 de/audi/app/terminalmode/statemachine/ResourceState 
.const [94] = Utf8 hashCode 
.const [95] = Utf8 ()I 
.const [96] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [97] = Utf8 hashCode 
.const [98] = Utf8 ()I 
.const [99] = Utf8 de/audi/app/terminalmode/statemachine/ResourceState 
.const [100] = Utf8 equals 
.const [101] = Utf8 (Ljava/lang/Object;)Z 
.const [102] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [103] = Utf8 equals 
.const [104] = Utf8 (Ljava/lang/Object;)Z 
.const [105] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [106] = Utf8 append 
.const [107] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [108] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [109] = Utf8 append 
.const [110] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [111] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [112] = Utf8 toString 
.const [113] = Utf8 ()Ljava/lang/String; 
.const [114] = Utf8 de/audi/app/terminalmode/statemachine/AbstractStateChange 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lde/audi/app/terminalmode/statemachine/StateChangeType;)V 
.const [117] = Utf8 de/audi/app/terminalmode/statemachine/AbstractStateChange 
.const [118] = Utf8 hashCode 
.const [119] = Utf8 ()I 
.const [120] = Utf8 de/audi/app/terminalmode/statemachine/AbstractStateChange 
.const [121] = Utf8 equals 
.const [122] = Utf8 (Ljava/lang/Object;)Z 
.const [123] = Utf8 java/lang/Object 
.const [124] = Utf8 getClass 
.const [125] = Utf8 ()Ljava/lang/Class; 
.const [126] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (I)V 
.const [129] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [130] = Utf8 resourceId 
.const [131] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [132] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [133] = Utf8 oldState 
.const [134] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceState; 
.const [135] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [136] = Utf8 newState 
.const [137] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceState; 
.const [138] = Utf8 de/audi/app/terminalmode/statemachine/ResourceStateChange 
.const [139] = Class [138] 
.const [140] = Utf8 de/audi/app/terminalmode/statemachine/AbstractStateChange 
.const [141] = Class [140] 
.const [142] = Utf8 resourceId 
.const [143] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [144] = Utf8 oldState 
.const [145] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceState; 
.const [146] = Utf8 newState 
.const [147] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceState; 
.const [148] = Utf8 Code 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/audi/app/terminalmode/statemachine/Resource;Lde/audi/app/terminalmode/statemachine/ResourceState;Lde/audi/app/terminalmode/statemachine/ResourceState;)V 
.const [151] = Utf8 hashCode 
.const [152] = Utf8 ()I 
.const [153] = Utf8 equals 
.const [154] = Utf8 (Ljava/lang/Object;)Z 
.const [155] = Utf8 toString 
.const [156] = Utf8 ()Ljava/lang/String; 
.end class 
