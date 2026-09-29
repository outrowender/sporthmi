.version 50 0 
.class super abstract [121] 
.super [123] 
.field private static [124] [125] 
.field protected final [126] [127] 
.field protected final [128] [129] 

.method protected static [131] : [132] 
    .attribute [130] .code stack 4 locals 5 
L0:     new [21] 
L3:     dup 
L4:     getstatic [3] 
L7:     arraylength 
L8:     invokespecial [17] 
L11:    astore_1 
L12:    aload_0 
L13:    ifnull L88 
L16:    iconst_0 
L17:    istore_2 
L18:    iload_2 
L19:    getstatic [3] 
L22:    arraylength 
L23:    if_icmpge L88 
L26:    getstatic [3] 
L29:    iload_2 
L30:    iaload 
L31:    istore_3 
L32:    iconst_1 
L33:    istore 4 
L35:    iconst_0 
L36:    istore 5 
L38:    iload 5 
L40:    aload_0 
L41:    arraylength 
L42:    if_icmpge L62 
L45:    aload_0 
L46:    iload 5 
L48:    iaload 
L49:    iload_3 
L50:    if_icmpne L56 
L53:    iconst_0 
L54:    istore 4 
L56:    iinc 5 1 
L59:    goto L38 
L62:    iload 4 
L64:    ifeq L82 
L67:    aload_1 
L68:    new [22] 
L71:    dup 
L72:    iload_3 
L73:    invokespecial [18] 
L76:    invokeinterface [23] 0 
L81:    pop 
L82:    iinc 2 1 
L85:    goto L18 
L88:    aload_1 
L89:    invokeinterface [24] 0 
L94:    newarray int 
L96:    astore_2 
L97:    iconst_0 
L98:    istore_3 
L99:    iload_3 
L100:   aload_2 
L101:   arraylength 
L102:   if_icmpge L127 
L105:   aload_2 
L106:   iload_3 
L107:   aload_1 
L108:   iload_3 
L109:   invokeinterface [25] 0 
L114:   checkcast [4] 
L117:   invokevirtual [11] 
L120:   iastore 
L121:   iinc 3 1 
L124:   goto L99 
L127:   aload_2 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [130] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [19] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [26] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [27] 
L15:    return 
L16:    
    .end code 
.end method 

.method protected [135] : [136] 
    .attribute [130] .code stack 6 locals 1 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [12] 
L8:     sipush 10000 
L11:    ldc [5] 
L13:    invokevirtual [14] 
L16:    pop 
L17:    return 
L18:    iconst_0 
L19:    istore_2 
L20:    iload_2 
L21:    aload_1 
L22:    arraylength 
L23:    if_icmpge L55 
L26:    aload_0 
L27:    new [28] 
L30:    dup 
L31:    aload_0 
L32:    getfield [12] 
L35:    aload_1 
L36:    iload_2 
L37:    iaload 
L38:    aload_0 
L39:    getfield [13] 
L42:    invokespecial [20] 
L45:    invokevirtual [15] 
L48:    pop 
L49:    iinc 2 1 
L52:    goto L20 
L55:    return 
L56:    
    .end code 
.end method 

.method static [137] : [138] 
    .attribute [130] .code stack 4 locals 0 
L0:     bipush 11 
L2:     newarray int 
L4:     dup 
L5:     iconst_0 
L6:     bipush 104 
L8:     iastore 
L9:     dup 
L10:    iconst_1 
L11:    bipush 106 
L13:    iastore 
L14:    dup 
L15:    iconst_2 
L16:    bipush 99 
L18:    iastore 
L19:    dup 
L20:    iconst_3 
L21:    bipush 102 
L23:    iastore 
L24:    dup 
L25:    iconst_4 
L26:    bipush 110 
L28:    iastore 
L29:    dup 
L30:    iconst_5 
L31:    bipush 111 
L33:    iastore 
L34:    dup 
L35:    bipush 6 
L37:    bipush 103 
L39:    iastore 
L40:    dup 
L41:    bipush 7 
L43:    bipush 98 
L45:    iastore 
L46:    dup 
L47:    bipush 8 
L49:    bipush 87 
L51:    iastore 
L52:    dup 
L53:    bipush 9 
L55:    sipush 136 
L58:    iastore 
L59:    dup 
L60:    bipush 10 
L62:    sipush 137 
L65:    iastore 
L66:    putstatic [16] 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Field [30] [31] 
.const [4] = Class [32] 
.const [5] = String [33] 
.const [6] = Class [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Method [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Class [59] 
.const [22] = Class [60] 
.const [23] = InterfaceMethod [61] [62] 
.const [24] = InterfaceMethod [63] [64] 
.const [25] = InterfaceMethod [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Class [71] 
.const [29] = Utf8 java/util/ArrayList 
.const [30] = Class [72] 
.const [31] = NameAndType [73] [74] 
.const [32] = Utf8 java/lang/Integer 
.const [33] = Utf8 'AbstractTelAudioCmdList#addReleaseConnectionCommands connectionsToRelease is null' 
.const [34] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [35] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [36] = Utf8 de/audi/tghu/command/CommandList 
.const [37] = Utf8 java/util/List 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Utf8 java/util/ArrayList 
.const [60] = Utf8 java/lang/Integer 
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
.const [71] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [72] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [73] = Utf8 relevantTelephoneAudioConnectionsForRelease 
.const [74] = Utf8 [I 
.const [75] = Utf8 java/lang/Integer 
.const [76] = Utf8 intValue 
.const [77] = Utf8 ()I 
.const [78] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [79] = Utf8 log 
.const [80] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [81] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [82] = Utf8 audioService 
.const [83] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [84] = Utf8 de/audi/atip/log/LogChannel 
.const [85] = Utf8 log 
.const [86] = Utf8 (ILjava/lang/String;)Z 
.const [87] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [88] = Utf8 add 
.const [89] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [90] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [91] = Utf8 relevantTelephoneAudioConnectionsForRelease 
.const [92] = Utf8 [I 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (I)V 
.const [96] = Utf8 java/lang/Integer 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (I)V 
.const [99] = Utf8 de/audi/tghu/command/CommandList 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (Lde/audi/tghu/command/CommandListManager;)V 
.const [102] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;)V 
.const [105] = Utf8 java/util/List 
.const [106] = Utf8 add 
.const [107] = Utf8 (Ljava/lang/Object;)Z 
.const [108] = Utf8 java/util/List 
.const [109] = Utf8 size 
.const [110] = Utf8 ()I 
.const [111] = Utf8 java/util/List 
.const [112] = Utf8 get 
.const [113] = Utf8 (I)Ljava/lang/Object; 
.const [114] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [115] = Utf8 log 
.const [116] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [117] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [118] = Utf8 audioService 
.const [119] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [120] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [121] = Class [120] 
.const [122] = Utf8 de/audi/tghu/command/CommandList 
.const [123] = Class [122] 
.const [124] = Utf8 relevantTelephoneAudioConnectionsForRelease 
.const [125] = Utf8 [I 
.const [126] = Utf8 log 
.const [127] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [128] = Utf8 audioService 
.const [129] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [130] = Utf8 Code 
.const [131] = Utf8 getAudioConnectionsToRelease 
.const [132] = Utf8 ([I)[I 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;)V 
.const [135] = Utf8 addReleaseConnectionCommands 
.const [136] = Utf8 ([I)V 
.const [137] = Utf8 <clinit> 
.const [138] = Utf8 ()V 
.end class 
