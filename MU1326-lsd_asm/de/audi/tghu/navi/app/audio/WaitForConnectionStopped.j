.version 50 0 
.class public super [73] 
.super [75] 

.method public annotation [77] : [78] 
    .attribute [76] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [19] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 5 locals 1 
L0:     iload_1 
L1:     invokestatic [2] 
L4:     ifeq L60 
L7:     aload_0 
L8:     getfield [12] 
L11:    ldc [3] 
L13:    ldc [4] 
L15:    iload_1 
L16:    i2l 
L17:    invokevirtual [13] 
L20:    pop 
L21:    aload_0 
L22:    iload_1 
L23:    invokevirtual [14] 
L26:    aload_0 
L27:    getfield [15] 
L30:    invokevirtual [16] 
L33:    istore_3 
L34:    iload_3 
L35:    iconst_3 
L36:    if_icmpeq L44 
L39:    iload_3 
L40:    iconst_1 
L41:    if_icmpne L60 
L44:    aload_0 
L45:    getfield [12] 
L48:    ldc [5] 
L50:    ldc [6] 
L52:    invokevirtual [17] 
L55:    pop 
L56:    aload_0 
L57:    invokevirtual [18] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [76] .code stack 1 locals 0 
L0:     ldc [7] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [20] [21] 
.const [3] = Int -2137614336 
.const [4] = String [22] 
.const [5] = Int -1601830656 
.const [6] = String [23] 
.const [7] = String [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Class [27] 
.const [11] = Class [28] 
.const [12] = Field [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Field [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Method [39] [40] 
.const [18] = Method [41] [42] 
.const [19] = Method [43] [44] 
.const [20] = Class [45] 
.const [21] = NameAndType [46] [47] 
.const [22] = Utf8 'WaitForConnectionStopped#stopConnection( %1 ) - going to CONNECTION_STOPPED ' 
.const [23] = Utf8 'WaitForConnectionStopped#stopConnection() - another connection requested! ' 
.const [24] = Utf8 WAIT_FOR_CONNECTION_STOPPED 
.const [25] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStopped 
.const [26] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [27] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Class [63] 
.const [40] = NameAndType [64] [65] 
.const [41] = Class [66] 
.const [42] = NameAndType [67] [68] 
.const [43] = Class [69] 
.const [44] = NameAndType [70] [71] 
.const [45] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [46] = Utf8 isNaviAudioConnection 
.const [47] = Utf8 (I)Z 
.const [48] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStopped 
.const [49] = Utf8 logChannel 
.const [50] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 log 
.const [53] = Utf8 (ILjava/lang/String;J)Z 
.const [54] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStopped 
.const [55] = Utf8 acknowledgeStopAudio 
.const [56] = Utf8 (I)V 
.const [57] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStopped 
.const [58] = Utf8 stateMachine 
.const [59] = Utf8 Lde/audi/tghu/navi/app/audio/AudioStateMachine; 
.const [60] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [61] = Utf8 getAudioState 
.const [62] = Utf8 ()I 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 log 
.const [65] = Utf8 (ILjava/lang/String;)Z 
.const [66] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStopped 
.const [67] = Utf8 requestConnection 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/audio/AudioStateMachine;Lde/audi/tghu/navi/app/SpeechManager;)V 
.const [72] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStopped 
.const [73] = Class [72] 
.const [74] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [75] = Class [74] 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/audio/AudioStateMachine;Lde/audi/tghu/navi/app/SpeechManager;)V 
.const [79] = Utf8 stopConnection 
.const [80] = Utf8 (II)V 
.const [81] = Utf8 toString 
.const [82] = Utf8 ()Ljava/lang/String; 
.end class 
