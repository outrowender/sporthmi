.version 50 0 
.class public super [91] 
.super [93] 
.implements [95] 
.field private final [96] [97] 
.field private final [98] [99] 
.field private final [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [21] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [22] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     aload_0 
L5:     getfield [17] 
L8:     ldc [2] 
L10:    iload_2 
L11:    invokestatic [3] 
L14:    iload_1 
L15:    i2l 
L16:    invokevirtual [18] 
L19:    pop 
L20:    aload_0 
L21:    getfield [15] 
L24:    iload_1 
L25:    iload_2 
L26:    invokeinterface [23] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method private static [107] : [108] 
    .attribute [102] .code stack 1 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            1 : L55 
            2 : L52 
            38 : L64 
            43 : L58 
            48 : L61 
            default : L67 

L52:    ldc [4] 
L54:    areturn 
L55:    ldc [5] 
L57:    areturn 
L58:    ldc [6] 
L60:    areturn 
L61:    ldc [7] 
L63:    areturn 
L64:    ldc [8] 
L66:    areturn 
L67:    iload_0 
L68:    invokestatic [9] 
L71:    areturn 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [24] 
.const [3] = Method [25] [26] 
.const [4] = String [27] 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = String [31] 
.const [9] = Method [32] [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Field [53] [54] 
.const [23] = InterfaceMethod [55] [56] 
.const [24] = Utf8 '-> [IAudioFocusManager.setActiveAudioApp] terminalId %2, appId %1' 
.const [25] = Class [57] 
.const [26] = NameAndType [58] [59] 
.const [27] = Utf8 APPLICATION_ID_MEDIA 
.const [28] = Utf8 APPLICATION_ID_TUNER 
.const [29] = Utf8 APPLICATION_ID_TERMINALMODE 
.const [30] = Utf8 APPLICATION_ID_TERMINALMODE_AUDIO 
.const [31] = Utf8 APPLICATION_ID_TV 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 de/audi/atip/audio/IAudioFocusManager 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 java/lang/Integer 
.const [39] = Class [63] 
.const [40] = NameAndType [64] [65] 
.const [41] = Class [66] 
.const [42] = NameAndType [67] [68] 
.const [43] = Class [69] 
.const [44] = NameAndType [70] [71] 
.const [45] = Class [72] 
.const [46] = NameAndType [73] [74] 
.const [47] = Class [75] 
.const [48] = NameAndType [76] [77] 
.const [49] = Class [78] 
.const [50] = NameAndType [79] [80] 
.const [51] = Class [81] 
.const [52] = NameAndType [82] [83] 
.const [53] = Class [84] 
.const [54] = NameAndType [85] [86] 
.const [55] = Class [87] 
.const [56] = NameAndType [88] [89] 
.const [57] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [58] = Utf8 appIdToString 
.const [59] = Utf8 (I)Ljava/lang/String; 
.const [60] = Utf8 java/lang/Integer 
.const [61] = Utf8 toString 
.const [62] = Utf8 (I)Ljava/lang/String; 
.const [63] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [64] = Utf8 wrappee 
.const [65] = Utf8 Lde/audi/atip/audio/IAudioFocusManager; 
.const [66] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [67] = Utf8 lc 
.const [68] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [69] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [70] = Utf8 level 
.const [71] = Utf8 I 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 log 
.const [74] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [79] = Utf8 wrappee 
.const [80] = Utf8 Lde/audi/atip/audio/IAudioFocusManager; 
.const [81] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [82] = Utf8 lc 
.const [83] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [84] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [85] = Utf8 level 
.const [86] = Utf8 I 
.const [87] = Utf8 de/audi/atip/audio/IAudioFocusManager 
.const [88] = Utf8 setActiveAudioApp 
.const [89] = Utf8 (II)V 
.const [90] = Utf8 de/audi/app/terminalmode/logging/IAudioFocusManagerLoggingDecorator 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Object 
.const [93] = Class [92] 
.const [94] = Utf8 de/audi/atip/audio/IAudioFocusManager 
.const [95] = Class [94] 
.const [96] = Utf8 wrappee 
.const [97] = Utf8 Lde/audi/atip/audio/IAudioFocusManager; 
.const [98] = Utf8 lc 
.const [99] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [100] = Utf8 level 
.const [101] = Utf8 I 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/atip/audio/IAudioFocusManager;Lde/audi/atip/log/LogChannel;I)V 
.const [105] = Utf8 setActiveAudioApp 
.const [106] = Utf8 (II)V 
.const [107] = Utf8 appIdToString 
.const [108] = Utf8 (I)Ljava/lang/String; 
.end class 
