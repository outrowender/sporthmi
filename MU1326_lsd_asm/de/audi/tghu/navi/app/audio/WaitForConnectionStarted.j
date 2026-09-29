.version 50 0 
.class public super [64] 
.super [66] 

.method public annotation [68] : [69] 
    .attribute [67] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [16] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [70] : [71] 
    .attribute [67] .code stack 5 locals 1 
L0:     iload_1 
L1:     invokestatic [2] 
L4:     ifeq L52 
L7:     aload_0 
L8:     getfield [10] 
L11:    ldc [3] 
L13:    ldc [4] 
L15:    iload_1 
L16:    i2l 
L17:    invokevirtual [11] 
L20:    pop 
L21:    aload_0 
L22:    getfield [12] 
L25:    invokevirtual [13] 
L28:    istore_3 
L29:    iload_3 
L30:    iconst_3 
L31:    if_icmpeq L39 
L34:    iload_3 
L35:    iconst_1 
L36:    if_icmpne L47 
L39:    aload_0 
L40:    iload_1 
L41:    invokevirtual [14] 
L44:    goto L52 
L47:    aload_0 
L48:    iload_1 
L49:    invokevirtual [15] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [72] : [73] 
    .attribute [67] .code stack 1 locals 0 
L0:     ldc [5] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [17] [18] 
.const [3] = Int -2137614336 
.const [4] = String [19] 
.const [5] = String [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Class [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Class [39] 
.const [18] = NameAndType [40] [41] 
.const [19] = Utf8 'WaitForConnectionStarted#startConnection( %1 ) ' 
.const [20] = Utf8 WAIT_FOR_CONNECTION_STARTED 
.const [21] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStarted 
.const [22] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [23] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [24] = Utf8 de/audi/atip/log/LogChannel 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
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
.const [39] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [40] = Utf8 isNaviAudioConnection 
.const [41] = Utf8 (I)Z 
.const [42] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStarted 
.const [43] = Utf8 logChannel 
.const [44] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 log 
.const [47] = Utf8 (ILjava/lang/String;J)Z 
.const [48] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStarted 
.const [49] = Utf8 stateMachine 
.const [50] = Utf8 Lde/audi/tghu/navi/app/audio/AudioStateMachine; 
.const [51] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [52] = Utf8 getAudioState 
.const [53] = Utf8 ()I 
.const [54] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStarted 
.const [55] = Utf8 fadeToConnection 
.const [56] = Utf8 (I)V 
.const [57] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStarted 
.const [58] = Utf8 releaseConnection 
.const [59] = Utf8 (I)V 
.const [60] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/audio/AudioStateMachine;Lde/audi/tghu/navi/app/SpeechManager;)V 
.const [63] = Utf8 de/audi/tghu/navi/app/audio/WaitForConnectionStarted 
.const [64] = Class [63] 
.const [65] = Utf8 de/audi/tghu/navi/app/audio/AudioState 
.const [66] = Class [65] 
.const [67] = Utf8 Code 
.const [68] = Utf8 <init> 
.const [69] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/audio/AudioStateMachine;Lde/audi/tghu/navi/app/SpeechManager;)V 
.const [70] = Utf8 startConnection 
.const [71] = Utf8 (II)V 
.const [72] = Utf8 toString 
.const [73] = Utf8 ()Ljava/lang/String; 
.end class 
