.version 50 0 
.class public super [133] 
.super [135] 
.implements [137] 
.field private static final [138] [139] 
.field private final [140] [141] 
.field private final [142] [143] 
.field private final [144] [145] 

.method public [147] : [148] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [25] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [26] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [146] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokeinterface [27] 0 
L9:     astore_1 
L10:    aload_1 
L11:    invokeinterface [28] 0 
L16:    ifeq L65 
        .catch [3] from L19 to L37 using L40 
L19:    aload_1 
L20:    invokeinterface [29] 0 
L25:    checkcast [2] 
L28:    aload_0 
L29:    getfield [17] 
L32:    invokeinterface [30] 0 
L37:    goto L10 
L40:    astore_2 
L41:    aload_0 
L42:    getfield [15] 
L45:    invokeinterface [31] 0 
L50:    sipush 10000 
L53:    ldc [4] 
L55:    ldc [5] 
L57:    aload_2 
L58:    invokevirtual [18] 
L61:    pop 
L62:    goto L10 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 2 locals 1 
L0:     new [32] 
L3:     dup 
L4:     invokespecial [23] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    invokevirtual [19] 
L14:    aload_0 
L15:    getfield [17] 
L18:    invokevirtual [20] 
L21:    ldc [8] 
L23:    invokevirtual [19] 
L26:    pop 
L27:    aload_1 
L28:    invokevirtual [21] 
L31:    areturn 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [33] 
.const [3] = Class [34] 
.const [4] = String [35] 
.const [5] = String [36] 
.const [6] = Class [37] 
.const [7] = String [38] 
.const [8] = String [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Field [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = InterfaceMethod [70] [71] 
.const [28] = InterfaceMethod [72] [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = Class [80] 
.const [33] = Utf8 de/audi/app/media/audio/IAudioStateListener 
.const [34] = Utf8 java/lang/Exception 
.const [35] = Utf8 '[%1.run]' 
.const [36] = Utf8 JobNotifyAudioFocus 
.const [37] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [38] = Utf8 "AudioManager.audioFocusChanged('" 
.const [39] = Utf8 "')" 
.const [40] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 java/util/List 
.const [43] = Utf8 java/util/Iterator 
.const [44] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Class [120] 
.const [73] = NameAndType [121] [122] 
.const [74] = Class [123] 
.const [75] = NameAndType [124] [125] 
.const [76] = Class [126] 
.const [77] = NameAndType [127] [128] 
.const [78] = Class [129] 
.const [79] = NameAndType [130] [131] 
.const [80] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [81] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [82] = Utf8 logger 
.const [83] = Utf8 Lde/audi/app/media/logger/IMediaLogger; 
.const [84] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [85] = Utf8 listeners 
.const [86] = Utf8 Ljava/util/List; 
.const [87] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [88] = Utf8 hasAudioFocus 
.const [89] = Utf8 Z 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Utf8 append 
.const [98] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [99] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [100] = Utf8 toString 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [109] = Utf8 logger 
.const [110] = Utf8 Lde/audi/app/media/logger/IMediaLogger; 
.const [111] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [112] = Utf8 listeners 
.const [113] = Utf8 Ljava/util/List; 
.const [114] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [115] = Utf8 hasAudioFocus 
.const [116] = Utf8 Z 
.const [117] = Utf8 java/util/List 
.const [118] = Utf8 iterator 
.const [119] = Utf8 ()Ljava/util/Iterator; 
.const [120] = Utf8 java/util/Iterator 
.const [121] = Utf8 hasNext 
.const [122] = Utf8 ()Z 
.const [123] = Utf8 java/util/Iterator 
.const [124] = Utf8 next 
.const [125] = Utf8 ()Ljava/lang/Object; 
.const [126] = Utf8 de/audi/app/media/audio/IAudioStateListener 
.const [127] = Utf8 audioFocusChanged 
.const [128] = Utf8 (Z)V 
.const [129] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [130] = Utf8 audio 
.const [131] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [132] = Utf8 de/audi/app/media/audio/JobNotifyAudioFocus 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Object 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Runnable 
.const [137] = Class [136] 
.const [138] = Utf8 LOGCLASS 
.const [139] = Utf8 Ljava/lang/String; 
.const [140] = Utf8 listeners 
.const [141] = Utf8 Ljava/util/List; 
.const [142] = Utf8 logger 
.const [143] = Utf8 Lde/audi/app/media/logger/IMediaLogger; 
.const [144] = Utf8 hasAudioFocus 
.const [145] = Utf8 Z 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Lde/audi/app/media/logger/IMediaLogger;Ljava/util/List;Z)V 
.const [149] = Utf8 run 
.const [150] = Utf8 ()V 
.const [151] = Utf8 toString 
.const [152] = Utf8 ()Ljava/lang/String; 
.end class 
