.version 50 0 
.class public super [142] 
.super [144] 
.field private static final [145] [146] 
.field private final [147] [148] 

.method public [150] : [151] 
    .attribute [149] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     aload_2 
L5:     invokespecial [23] 
L8:     aload_0 
L9:     aload_3 
L10:    putfield [25] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [149] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     invokeinterface [26] 0 
L9:     invokeinterface [27] 0 
L14:    astore_1 
L15:    aload_1 
L16:    ifnonnull L43 
L19:    aload_0 
L20:    getfield [20] 
L23:    ldc [3] 
L25:    ldc [4] 
L27:    ldc [5] 
L29:    invokevirtual [21] 
L32:    pop 
L33:    aload_0 
L34:    invokevirtual [22] 
L37:    invokeinterface [28] 0 
L42:    return 
L43:    aload_0 
L44:    invokevirtual [19] 
L47:    invokeinterface [26] 0 
L52:    invokeinterface [29] 0 
L57:    lookupswitch 
            1 : L100 
            2 : L100 
            4 : L100 
            11 : L100 
            default : L121 

L100:   aload_0 
L101:   getfield [20] 
L104:   ldc [3] 
L106:   ldc [6] 
L108:   ldc [5] 
L110:   invokevirtual [21] 
L113:   pop 
L114:   aload_0 
L115:   invokespecial [24] 
L118:   goto L144 
L121:   aload_0 
L122:   getfield [20] 
L125:   ldc [3] 
L127:   ldc [7] 
L129:   ldc [5] 
L131:   invokevirtual [21] 
L134:   pop 
L135:   aload_0 
L136:   invokevirtual [19] 
L139:   invokeinterface [30] 0 
L144:   return 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method private [154] : [155] 
    .attribute [149] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     invokeinterface [31] 0 
L9:     iconst_0 
L10:    invokeinterface [32] 0 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [19] 
L20:    invokeinterface [31] 0 
L25:    invokeinterface [33] 0 
L30:    aload_0 
L31:    invokevirtual [19] 
L34:    invokeinterface [26] 0 
L39:    aconst_null 
L40:    invokeinterface [34] 0 
L45:    aload_0 
L46:    getfield [18] 
L49:    invokeinterface [35] 0 
L54:    aload_0 
L55:    invokevirtual [22] 
L58:    invokeinterface [28] 0 
L63:    return 
L64:    
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [149] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     invokeinterface [26] 0 
L9:     invokeinterface [29] 0 
L14:    iconst_4 
L15:    if_icmpeq L33 
L18:    aload_0 
L19:    getfield [20] 
L22:    ldc [3] 
L24:    ldc [8] 
L26:    ldc [5] 
L28:    invokevirtual [21] 
L31:    pop 
L32:    return 
L33:    aload_0 
L34:    getfield [20] 
L37:    ldc [3] 
L39:    ldc [9] 
L41:    ldc [5] 
L43:    invokevirtual [21] 
L46:    pop 
L47:    aload_0 
L48:    invokespecial [24] 
L51:    return 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [36] 
.const [3] = Int 1078071040 
.const [4] = String [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = String [41] 
.const [9] = String [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Field [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = InterfaceMethod [71] [72] 
.const [29] = InterfaceMethod [73] [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = InterfaceMethod [83] [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = Utf8 DETACH 
.const [37] = Utf8 '[%1.start] No session active.' 
.const [38] = Utf8 JobDettachSession 
.const [39] = Utf8 '[%1.start] Player already stopped.' 
.const [40] = Utf8 '[%1.start] Stop the player.' 
.const [41] = Utf8 '[%1.onPlaybackStateChanged] Wait that the player is stopped.' 
.const [42] = Utf8 '[%1.onPlaybackStateChanged] Player stopped.' 
.const [43] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [44] = Utf8 de/audi/app/media/content/media/fileplayer/content/AbstractFilePlayerJob 
.const [45] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayer 
.const [46] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayerState 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 de/audi/app/media/queue/IQueueExecutionContext 
.const [49] = Utf8 de/audi/app/media/audio/IAudioManager 
.const [50] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayerListener 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Class [90] 
.const [54] = NameAndType [91] [92] 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Class [96] 
.const [58] = NameAndType [97] [98] 
.const [59] = Class [99] 
.const [60] = NameAndType [100] [101] 
.const [61] = Class [102] 
.const [62] = NameAndType [103] [104] 
.const [63] = Class [105] 
.const [64] = NameAndType [106] [107] 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Class [135] 
.const [84] = NameAndType [136] [137] 
.const [85] = Class [138] 
.const [86] = NameAndType [139] [140] 
.const [87] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [88] = Utf8 listener 
.const [89] = Utf8 Lde/audi/app/media/content/media/fileplayer/content/IFilePlayerListener; 
.const [90] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [91] = Utf8 getPlayer 
.const [92] = Utf8 ()Lde/audi/app/media/content/media/fileplayer/content/IFilePlayer; 
.const [93] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [94] = Utf8 logger 
.const [95] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [99] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [100] = Utf8 getExecutionContext 
.const [101] = Utf8 ()Lde/audi/app/media/queue/IQueueExecutionContext; 
.const [102] = Utf8 de/audi/app/media/content/media/fileplayer/content/AbstractFilePlayerJob 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/media/content/media/fileplayer/content/IFilePlayer;)V 
.const [105] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [106] = Utf8 finishJob 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [109] = Utf8 listener 
.const [110] = Utf8 Lde/audi/app/media/content/media/fileplayer/content/IFilePlayerListener; 
.const [111] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayer 
.const [112] = Utf8 getState 
.const [113] = Utf8 ()Lde/audi/app/media/content/media/fileplayer/content/IFilePlayerState; 
.const [114] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayerState 
.const [115] = Utf8 getActiveSession 
.const [116] = Utf8 ()Lde/audi/app/media/content/media/fileplayer/FilePlayerSession; 
.const [117] = Utf8 de/audi/app/media/queue/IQueueExecutionContext 
.const [118] = Utf8 jobFinished 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayerState 
.const [121] = Utf8 getPlaybackState 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayer 
.const [124] = Utf8 stop 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayer 
.const [127] = Utf8 getAudioManager 
.const [128] = Utf8 ()Lde/audi/app/media/audio/IAudioManager; 
.const [129] = Utf8 de/audi/app/media/audio/IAudioManager 
.const [130] = Utf8 resumeAudio 
.const [131] = Utf8 (Z)Z 
.const [132] = Utf8 de/audi/app/media/audio/IAudioManager 
.const [133] = Utf8 releaseAudio 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayerState 
.const [136] = Utf8 setActiveSession 
.const [137] = Utf8 (Lde/audi/app/media/content/media/fileplayer/FilePlayerSession;)V 
.const [138] = Utf8 de/audi/app/media/content/media/fileplayer/content/IFilePlayerListener 
.const [139] = Utf8 sessionDettached 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/audi/app/media/content/media/fileplayer/content/JobDettachSession 
.const [142] = Class [141] 
.const [143] = Utf8 de/audi/app/media/content/media/fileplayer/content/AbstractFilePlayerJob 
.const [144] = Class [143] 
.const [145] = Utf8 LOGCLASS 
.const [146] = Utf8 Ljava/lang/String; 
.const [147] = Utf8 listener 
.const [148] = Utf8 Lde/audi/app/media/content/media/fileplayer/content/IFilePlayerListener; 
.const [149] = Utf8 Code 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/content/media/fileplayer/content/IFilePlayer;Lde/audi/app/media/content/media/fileplayer/content/IFilePlayerListener;)V 
.const [152] = Utf8 start 
.const [153] = Utf8 ()V 
.const [154] = Utf8 finishJob 
.const [155] = Utf8 ()V 
.const [156] = Utf8 onPlaybackStateChanged 
.const [157] = Utf8 ()V 
.end class 
