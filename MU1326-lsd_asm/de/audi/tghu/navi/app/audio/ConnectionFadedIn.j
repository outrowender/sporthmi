.version 50 0 
.class public super [86] 
.super [88] 

.method public annotation [90] : [91] 
    .attribute [89] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [20] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [92] : [93] 
    .attribute [89] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [12] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [21] 
L19:    iload_1 
L20:    iconst_3 
L21:    if_icmpne L35 
L24:    aload_0 
L25:    getfield [13] 
L28:    iconst_1 
L29:    invokevirtual [14] 
L32:    goto L97 
L35:    iload_1 
L36:    iconst_1 
L37:    if_icmpne L57 
L40:    aload_0 
L41:    getfield [11] 
L44:    ldc [2] 
L46:    ldc [4] 
L48:    iload_1 
L49:    i2l 
L50:    invokevirtual [12] 
L53:    pop 
L54:    goto L97 
L57:    iload_1 
L58:    iconst_2 
L59:    if_icmpne L86 
L62:    aload_0 
L63:    getfield [13] 
L66:    invokevirtual [15] 
L69:    ifeq L86 
L72:    aload_0 
L73:    getfield [13] 
L76:    invokevirtual [16] 
L79:    iconst_0 
L80:    invokevirtual [17] 
L83:    goto L97 
L86:    aload_0 
L87:    aload_0 
L88:    getfield [13] 
L91:    invokevirtual [18] 
L94:    invokevirtual [19] 
L97:    return 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [94] : [95] 
    .attribute [89] .code stack 1 locals 0 
L0:     ldc [5] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [22] 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Method [50] [51] 
.const [22] = Utf8 'ConnectionFadedIn#updateAudioRequest( %1 ) ' 
.const [23] = Utf8 'ConnectionFadedIn#updateAudioRequest( %1 ) - audio active ' 
.const [24] = Utf8 CONNECTION_FADEDIN 
.const [25] = Utf8 de/audi/tghu/navi/app/audio/ConnectionFadedIn 
.const [26] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [29] = Utf8 de/audi/tghu/navi/app/audio/LastAnnouncementHandler 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Utf8 de/audi/tghu/navi/app/audio/ConnectionFadedIn 
.const [53] = Utf8 logChannel 
.const [54] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 log 
.const [57] = Utf8 (ILjava/lang/String;J)Z 
.const [58] = Utf8 de/audi/tghu/navi/app/audio/ConnectionFadedIn 
.const [59] = Utf8 stateMachine 
.const [60] = Utf8 Lde/audi/tghu/navi/app/audio/AudioStateMachine; 
.const [61] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [62] = Utf8 audioTrigger 
.const [63] = Utf8 (Z)V 
.const [64] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [65] = Utf8 isAutoRepeatMode 
.const [66] = Utf8 ()Z 
.const [67] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [68] = Utf8 getLastAnnouncementHandler 
.const [69] = Utf8 ()Lde/audi/tghu/navi/app/audio/LastAnnouncementHandler; 
.const [70] = Utf8 de/audi/tghu/navi/app/audio/LastAnnouncementHandler 
.const [71] = Utf8 repeatLastAnnouncementSimple 
.const [72] = Utf8 (I)V 
.const [73] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [74] = Utf8 getCurrentConnection 
.const [75] = Utf8 ()I 
.const [76] = Utf8 de/audi/tghu/navi/app/audio/ConnectionFadedIn 
.const [77] = Utf8 releaseConnection 
.const [78] = Utf8 (I)V 
.const [79] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/audio/AudioStateMachine;Lde/audi/tghu/navi/app/SpeechManager;)V 
.const [82] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [83] = Utf8 updateAudioRequest 
.const [84] = Utf8 (I)V 
.const [85] = Utf8 de/audi/tghu/navi/app/audio/ConnectionFadedIn 
.const [86] = Class [85] 
.const [87] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [88] = Class [87] 
.const [89] = Utf8 Code 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/audio/AudioStateMachine;Lde/audi/tghu/navi/app/SpeechManager;)V 
.const [92] = Utf8 updateAudioRequest 
.const [93] = Utf8 (I)V 
.const [94] = Utf8 toString 
.const [95] = Utf8 ()Ljava/lang/String; 
.end class 
