.version 50 0 
.class final super [164] 
.super [166] 
.implements [168] 
.field private static final [169] [170] 
.field private final synthetic [171] [172] 

.method private [174] : [175] 
    .attribute [173] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     invokespecial [31] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [173] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokestatic [2] 
L7:     new [36] 
L10:    dup 
L11:    aload_0 
L12:    ldc [4] 
L14:    iload_1 
L15:    iload_2 
L16:    invokespecial [32] 
L19:    invokeinterface [37] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [178] : [179] 
    .attribute [173] .code stack 8 locals 4 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokestatic [5] 
L7:     dup 
L8:     astore 4 
L10:    monitorenter 
        .catch [0] from L11 to L101 using L154 
L11:    aload_0 
L12:    getfield [25] 
L15:    invokestatic [6] 
L18:    ldc [7] 
L20:    ldc [8] 
L22:    iload_2 
L23:    ldc [9] 
L25:    new [38] 
L28:    dup 
L29:    iload_1 
L30:    invokespecial [33] 
L33:    invokevirtual [26] 
L36:    aload_0 
L37:    getfield [25] 
L40:    invokestatic [11] 
L43:    istore 5 
L45:    aload_0 
L46:    getfield [25] 
L49:    invokestatic [12] 
L52:    new [39] 
L55:    dup 
L56:    iload_2 
L57:    invokespecial [34] 
L60:    invokeinterface [40] 0 
L65:    aload_0 
L66:    getfield [25] 
L69:    invokestatic [11] 
L72:    istore 6 
L74:    iload 5 
L76:    iload 6 
L78:    if_icmpne L102 
L81:    aload_0 
L82:    getfield [25] 
L85:    invokestatic [6] 
L88:    ldc [7] 
L90:    ldc [14] 
L92:    ldc [9] 
L94:    invokevirtual [27] 
L97:    pop 
L98:    aload 4 
L100:   monitorexit 
L101:   return 
        .catch [0] from L102 to L151 using L154 
L102:   aload_0 
L103:   getfield [25] 
L106:   invokestatic [6] 
L109:   ldc [7] 
L111:   ldc [15] 
L113:   ldc [9] 
L115:   aload_0 
L116:   getfield [25] 
L119:   iload 6 
L121:   invokestatic [16] 
L124:   invokevirtual [28] 
L127:   aload_0 
L128:   getfield [25] 
L131:   invokestatic [17] 
L134:   iload 6 
L136:   iconst_1 
L137:   if_icmpne L148 
L140:   aload_0 
L141:   getfield [25] 
L144:   iload_3 
L145:   invokestatic [18] 
L148:   aload 4 
L150:   monitorexit 
L151:   goto L162 
        .catch [0] from L154 to L159 using L154 
L154:   astore 7 
L156:   aload 4 
L158:   monitorexit 
L159:   aload 7 
L161:   athrow 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 

.method synthetic [180] : [181] 
    .attribute [173] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [182] : [183] 
    .attribute [173] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [184] : [185] 
    .attribute [173] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iload_3 
L4:     invokespecial [29] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [41] [42] 
.const [3] = Class [43] 
.const [4] = String [44] 
.const [5] = Method [45] [46] 
.const [6] = Method [47] [48] 
.const [7] = Int -2137614336 
.const [8] = String [49] 
.const [9] = String [50] 
.const [10] = Class [51] 
.const [11] = Method [52] [53] 
.const [12] = Method [54] [55] 
.const [13] = Class [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = Method [59] [60] 
.const [17] = Method [61] [62] 
.const [18] = Method [63] [64] 
.const [19] = Class [65] 
.const [20] = Class [66] 
.const [21] = Class [67] 
.const [22] = Class [68] 
.const [23] = Class [69] 
.const [24] = Class [70] 
.const [25] = Field [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Method [89] [90] 
.const [35] = Field [91] [92] 
.const [36] = Class [93] 
.const [37] = InterfaceMethod [94] [95] 
.const [38] = Class [96] 
.const [39] = Class [97] 
.const [40] = InterfaceMethod [98] [99] 
.const [41] = Class [100] 
.const [42] = NameAndType [101] [102] 
.const [43] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient$1 
.const [44] = Utf8 'AudioManager.AudioFocusClient.updateAudioFocus' 
.const [45] = Class [103] 
.const [46] = NameAndType [104] [105] 
.const [47] = Class [106] 
.const [48] = NameAndType [107] [108] 
.const [49] = Utf8 "[%2.setAudioFocus] '%1' (terminal='%3')" 
.const [50] = Utf8 'AudioManager.AudioFocusClient' 
.const [51] = Utf8 java/lang/Integer 
.const [52] = Class [109] 
.const [53] = NameAndType [110] [111] 
.const [54] = Class [112] 
.const [55] = NameAndType [113] [114] 
.const [56] = Utf8 java/lang/Boolean 
.const [57] = Utf8 '[%1.setAudioFocus] Not changed. Ignore.' 
.const [58] = Utf8 "[%1.setAudioFocus] '%2'" 
.const [59] = Class [115] 
.const [60] = NameAndType [116] [117] 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [68] = Utf8 de/audi/atip/utils/dispatching/IDispatcher 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Class [127] 
.const [74] = NameAndType [128] [129] 
.const [75] = Class [130] 
.const [76] = NameAndType [131] [132] 
.const [77] = Class [133] 
.const [78] = NameAndType [134] [135] 
.const [79] = Class [136] 
.const [80] = NameAndType [137] [138] 
.const [81] = Class [139] 
.const [82] = NameAndType [140] [141] 
.const [83] = Class [142] 
.const [84] = NameAndType [143] [144] 
.const [85] = Class [145] 
.const [86] = NameAndType [146] [147] 
.const [87] = Class [148] 
.const [88] = NameAndType [149] [150] 
.const [89] = Class [151] 
.const [90] = NameAndType [152] [153] 
.const [91] = Class [154] 
.const [92] = NameAndType [155] [156] 
.const [93] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient$1 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Utf8 java/lang/Integer 
.const [97] = Utf8 java/lang/Boolean 
.const [98] = Class [160] 
.const [99] = NameAndType [161] [162] 
.const [100] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [101] = Utf8 access$2100 
.const [102] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)Lde/audi/atip/utils/dispatching/IDispatcher; 
.const [103] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [104] = Utf8 access$2700 
.const [105] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)Ljava/lang/Object; 
.const [106] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [107] = Utf8 access$300 
.const [108] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)Lde/audi/atip/log/LogChannel; 
.const [109] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [110] = Utf8 access$2800 
.const [111] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)I 
.const [112] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [113] = Utf8 access$2900 
.const [114] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)Lde/audi/atip/utils/reactive/properties/Property; 
.const [115] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [116] = Utf8 access$3000 
.const [117] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;I)Ljava/lang/String; 
.const [118] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [119] = Utf8 access$900 
.const [120] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)V 
.const [121] = Utf8 de/audi/app/terminalmode/audio/AudioManager 
.const [122] = Utf8 access$3100 
.const [123] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;Z)V 
.const [124] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient 
.const [125] = Utf8 this$0 
.const [126] = Utf8 Lde/audi/app/terminalmode/audio/AudioManager; 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 log 
.const [129] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;Ljava/lang/Object;)V 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 log 
.const [132] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [136] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient 
.const [137] = Utf8 setAudioFocus 
.const [138] = Utf8 (IZZ)V 
.const [139] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient$1 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager$AudioFocusClient;Ljava/lang/String;II)V 
.const [148] = Utf8 java/lang/Integer 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (I)V 
.const [151] = Utf8 java/lang/Boolean 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Z)V 
.const [154] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient 
.const [155] = Utf8 this$0 
.const [156] = Utf8 Lde/audi/app/terminalmode/audio/AudioManager; 
.const [157] = Utf8 de/audi/atip/utils/dispatching/IDispatcher 
.const [158] = Utf8 execute 
.const [159] = Utf8 (Ljava/lang/Runnable;)V 
.const [160] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [161] = Utf8 accept 
.const [162] = Utf8 (Ljava/lang/Object;)V 
.const [163] = Utf8 de/audi/app/terminalmode/audio/AudioManager$AudioFocusClient 
.const [164] = Class [163] 
.const [165] = Utf8 java/lang/Object 
.const [166] = Class [165] 
.const [167] = Utf8 de/audi/atip/audio/IAudioFocusClient 
.const [168] = Class [167] 
.const [169] = Utf8 LOGCLASS 
.const [170] = Utf8 Ljava/lang/String; 
.const [171] = Utf8 this$0 
.const [172] = Utf8 Lde/audi/app/terminalmode/audio/AudioManager; 
.const [173] = Utf8 Code 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;)V 
.const [176] = Utf8 updateAudioFocus 
.const [177] = Utf8 (II)V 
.const [178] = Utf8 setAudioFocus 
.const [179] = Utf8 (IZZ)V 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager;Lde/audi/app/terminalmode/audio/AudioManager$1;)V 
.const [182] = Utf8 access$2200 
.const [183] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager$AudioFocusClient;)Lde/audi/app/terminalmode/audio/AudioManager; 
.const [184] = Utf8 access$2600 
.const [185] = Utf8 (Lde/audi/app/terminalmode/audio/AudioManager$AudioFocusClient;IZZ)V 
.end class 
