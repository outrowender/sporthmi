.version 50 0 
.class public super [157] 
.super [159] 
.field private final [160] [161] 
.field private volatile [162] [163] 
.field private volatile [164] [165] 

.method public [167] : [168] 
    .attribute [166] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [30] 
L9:     aload_0 
L10:    aload_1 
L11:    getstatic [2] 
L14:    invokevirtual [16] 
L17:    putfield [31] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [32] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [166] .code stack 5 locals 1 
L0:     iload_1 
L1:     iflt L21 
L4:     iload_2 
L5:     iflt L21 
L8:     iload_1 
L9:     iload_2 
L10:    if_icmpgt L21 
L13:    aload_0 
L14:    getfield [18] 
L17:    iload_1 
L18:    if_icmple L86 
L21:    aload_0 
L22:    aload_0 
L23:    getfield [15] 
L26:    getstatic [3] 
L29:    invokevirtual [16] 
L32:    invokespecial [27] 
L35:    pop 
L36:    new [33] 
L39:    dup 
L40:    bipush 50 
L42:    invokespecial [28] 
L45:    astore_3 
L46:    aload_3 
L47:    ldc [5] 
L49:    invokevirtual [19] 
L52:    pop 
L53:    aload_3 
L54:    iload_1 
L55:    invokevirtual [20] 
L58:    pop 
L59:    aload_3 
L60:    ldc [6] 
L62:    invokevirtual [19] 
L65:    pop 
L66:    aload_3 
L67:    iload_2 
L68:    invokevirtual [20] 
L71:    pop 
L72:    aload_0 
L73:    getfield [17] 
L76:    aload_3 
L77:    invokevirtual [21] 
L80:    invokevirtual [22] 
L83:    goto L99 
L86:    aload_0 
L87:    new [34] 
L90:    dup 
L91:    iload_1 
L92:    iload_2 
L93:    invokespecial [29] 
L96:    invokevirtual [23] 
L99:    aload_0 
L100:   iload_1 
L101:   putfield [32] 
L104:   return 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_1 
L5:     invokevirtual [24] 
L8:     invokevirtual [22] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [166] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [15] 
L5:     getstatic [8] 
L8:     invokevirtual [16] 
L11:    invokespecial [27] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [166] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [32] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [15] 
L10:    getstatic [9] 
L13:    invokevirtual [16] 
L16:    invokespecial [27] 
L19:    pop 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [177] : [178] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [25] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [31] 
L9:     iconst_1 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [35] [36] 
.const [3] = Field [37] [38] 
.const [4] = Class [39] 
.const [5] = String [40] 
.const [6] = String [41] 
.const [7] = Class [42] 
.const [8] = Field [43] [44] 
.const [9] = Field [45] [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Field [52] [53] 
.const [16] = Method [54] [55] 
.const [17] = Field [56] [57] 
.const [18] = Field [58] [59] 
.const [19] = Method [60] [61] 
.const [20] = Method [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Field [84] [85] 
.const [32] = Field [86] [87] 
.const [33] = Class [88] 
.const [34] = Class [89] 
.const [35] = Class [90] 
.const [36] = NameAndType [91] [92] 
.const [37] = Class [93] 
.const [38] = NameAndType [94] [95] 
.const [39] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [40] = Utf8 'playPosition=' 
.const [41] = Utf8 ' totalTime=' 
.const [42] = Utf8 de/audi/app/terminalmode/events/TrackPlayPositionEvent 
.const [43] = Class [96] 
.const [44] = NameAndType [97] [98] 
.const [45] = Class [99] 
.const [46] = NameAndType [100] [101] 
.const [47] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 de/audi/app/terminalmode/events/PlayPositionEvent 
.const [50] = Utf8 de/audi/app/terminalmode/events/PlayPositionLoggerConfiguration 
.const [51] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogEvent 
.const [52] = Class [102] 
.const [53] = NameAndType [103] [104] 
.const [54] = Class [105] 
.const [55] = NameAndType [106] [107] 
.const [56] = Class [108] 
.const [57] = NameAndType [109] [110] 
.const [58] = Class [111] 
.const [59] = NameAndType [112] [113] 
.const [60] = Class [114] 
.const [61] = NameAndType [115] [116] 
.const [62] = Class [117] 
.const [63] = NameAndType [118] [119] 
.const [64] = Class [120] 
.const [65] = NameAndType [121] [122] 
.const [66] = Class [123] 
.const [67] = NameAndType [124] [125] 
.const [68] = Class [126] 
.const [69] = NameAndType [127] [128] 
.const [70] = Class [129] 
.const [71] = NameAndType [130] [131] 
.const [72] = Class [132] 
.const [73] = NameAndType [133] [134] 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Class [150] 
.const [85] = NameAndType [151] [152] 
.const [86] = Class [153] 
.const [87] = NameAndType [154] [155] 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 de/audi/app/terminalmode/events/TrackPlayPositionEvent 
.const [90] = Utf8 de/audi/app/terminalmode/events/PlayPositionEvent 
.const [91] = Utf8 STARTUP 
.const [92] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionEvent; 
.const [93] = Utf8 de/audi/app/terminalmode/events/PlayPositionEvent 
.const [94] = Utf8 ILLEGAL_PLAYPOSITION 
.const [95] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionEvent; 
.const [96] = Utf8 de/audi/app/terminalmode/events/PlayPositionEvent 
.const [97] = Utf8 PLAYBACK_STATE_CHANGED 
.const [98] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionEvent; 
.const [99] = Utf8 de/audi/app/terminalmode/events/PlayPositionEvent 
.const [100] = Utf8 TRACK_CHANGED 
.const [101] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionEvent; 
.const [102] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [103] = Utf8 logEventConfiguration 
.const [104] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionLoggerConfiguration; 
.const [105] = Utf8 de/audi/app/terminalmode/events/PlayPositionLoggerConfiguration 
.const [106] = Utf8 getPlayPositionLogEvent 
.const [107] = Utf8 (Lde/audi/app/terminalmode/events/PlayPositionEvent;)Lde/audi/app/terminalmode/events/PlayPositionLogEvent; 
.const [108] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [109] = Utf8 currentLogEvent 
.const [110] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionLogEvent; 
.const [111] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [112] = Utf8 lastPlayPosition 
.const [113] = Utf8 I 
.const [114] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [117] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [118] = Utf8 append 
.const [119] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [120] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [121] = Utf8 toString 
.const [122] = Utf8 ()Ljava/lang/String; 
.const [123] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogEvent 
.const [124] = Utf8 logUpdatePlayposition 
.const [125] = Utf8 (Ljava/lang/String;)V 
.const [126] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [127] = Utf8 updatePlayPosition 
.const [128] = Utf8 (Lde/audi/app/terminalmode/events/TrackPlayPositionEvent;)V 
.const [129] = Utf8 de/audi/app/terminalmode/events/TrackPlayPositionEvent 
.const [130] = Utf8 toString 
.const [131] = Utf8 ()Ljava/lang/String; 
.const [132] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogEvent 
.const [133] = Utf8 resetCounter 
.const [134] = Utf8 ()V 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [139] = Utf8 setCurrentLogEvent 
.const [140] = Utf8 (Lde/audi/app/terminalmode/events/PlayPositionLogEvent;)Z 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 de/audi/app/terminalmode/events/TrackPlayPositionEvent 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (II)V 
.const [147] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [148] = Utf8 logEventConfiguration 
.const [149] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionLoggerConfiguration; 
.const [150] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [151] = Utf8 currentLogEvent 
.const [152] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionLogEvent; 
.const [153] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [154] = Utf8 lastPlayPosition 
.const [155] = Utf8 I 
.const [156] = Utf8 de/audi/app/terminalmode/events/PlayPositionLogger 
.const [157] = Class [156] 
.const [158] = Utf8 java/lang/Object 
.const [159] = Class [158] 
.const [160] = Utf8 logEventConfiguration 
.const [161] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionLoggerConfiguration; 
.const [162] = Utf8 currentLogEvent 
.const [163] = Utf8 Lde/audi/app/terminalmode/events/PlayPositionLogEvent; 
.const [164] = Utf8 lastPlayPosition 
.const [165] = Utf8 I 
.const [166] = Utf8 Code 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Lde/audi/app/terminalmode/events/PlayPositionLoggerConfiguration;)V 
.const [169] = Utf8 updatePlayPosition 
.const [170] = Utf8 (II)V 
.const [171] = Utf8 updatePlayPosition 
.const [172] = Utf8 (Lde/audi/app/terminalmode/events/TrackPlayPositionEvent;)V 
.const [173] = Utf8 playbackStateChanged 
.const [174] = Utf8 ()V 
.const [175] = Utf8 trackChanged 
.const [176] = Utf8 ()V 
.const [177] = Utf8 setCurrentLogEvent 
.const [178] = Utf8 (Lde/audi/app/terminalmode/events/PlayPositionLogEvent;)Z 
.end class 
