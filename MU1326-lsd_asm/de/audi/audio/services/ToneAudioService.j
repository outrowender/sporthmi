.version 50 0 
.class public super [99] 
.super [101] 

.method public annotation [103] : [104] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [24] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 7 locals 3 
L0:     aload_0 
L1:     getfield [14] 
L4:     getfield [15] 
L7:     ldc [2] 
L9:     ldc [3] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [16] 
L18:    pop 
L19:    iload_2 
L20:    invokestatic [4] 
L23:    istore_3 
L24:    getstatic [5] 
L27:    iload_1 
L28:    iload_3 
L29:    invokevirtual [17] 
L32:    istore 4 
L34:    iload 4 
L36:    lookupswitch 
            5 : L64 
            6 : L64 
            default : L113 

L64:    aload_0 
L65:    getfield [14] 
L68:    getfield [18] 
L71:    invokevirtual [19] 
L74:    ifeq L119 
L77:    aload_0 
L78:    iload_1 
L79:    iload_3 
L80:    iload_1 
L81:    iload_2 
L82:    invokevirtual [20] 
L85:    astore 5 
L87:    aload_0 
L88:    getfield [14] 
L91:    getfield [18] 
L94:    ldc [6] 
L96:    ldc [7] 
L98:    aload_0 
L99:    getfield [21] 
L102:   aload 5 
L104:   iload 4 
L106:   i2l 
L107:   invokevirtual [22] 
L110:   goto L119 
L113:   aload_0 
L114:   iload_1 
L115:   iload_3 
L116:   invokevirtual [23] 
L119:   return 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [25] 
.const [4] = Method [26] [27] 
.const [5] = Field [28] [29] 
.const [6] = Int -2137614336 
.const [7] = String [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Class [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Field [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Method [55] [56] 
.const [24] = Method [57] [58] 
.const [25] = Utf8 '[ToneAudioService.releaseConnection] connection: %1, HT: %2]' 
.const [26] = Class [59] 
.const [27] = NameAndType [60] [61] 
.const [28] = Class [62] 
.const [29] = NameAndType [63] [64] 
.const [30] = Utf8 '[%1] [DSIAudioManagement.releaseConnection] IGNORED status:%3 %2' 
.const [31] = Utf8 de/audi/audio/services/ToneAudioService 
.const [32] = Utf8 de/audi/audio/services/BaseAudioService 
.const [33] = Utf8 de/audi/audio/AudioEnv 
.const [34] = Utf8 de/audi/atip/log/LogChannel 
.const [35] = Utf8 de/audi/atip/audio/TerminalMapper 
.const [36] = Utf8 de/audi/audio/store/ConnectionStore 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Utf8 de/audi/atip/audio/TerminalMapper 
.const [60] = Utf8 toAudioTerminal 
.const [61] = Utf8 (I)I 
.const [62] = Utf8 de/audi/audio/store/ConnectionStore 
.const [63] = Utf8 INSTANCE 
.const [64] = Utf8 Lde/audi/audio/store/ConnectionStore; 
.const [65] = Utf8 de/audi/audio/services/ToneAudioService 
.const [66] = Utf8 env 
.const [67] = Utf8 Lde/audi/audio/AudioEnv; 
.const [68] = Utf8 de/audi/audio/AudioEnv 
.const [69] = Utf8 lcDSI 
.const [70] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [71] = Utf8 de/audi/atip/log/LogChannel 
.const [72] = Utf8 log 
.const [73] = Utf8 (ILjava/lang/String;JJ)Z 
.const [74] = Utf8 de/audi/audio/store/ConnectionStore 
.const [75] = Utf8 getStatus 
.const [76] = Utf8 (II)I 
.const [77] = Utf8 de/audi/audio/AudioEnv 
.const [78] = Utf8 lcMain 
.const [79] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [80] = Utf8 de/audi/atip/log/LogChannel 
.const [81] = Utf8 isDebug 
.const [82] = Utf8 ()Z 
.const [83] = Utf8 de/audi/audio/services/ToneAudioService 
.const [84] = Utf8 toDebug 
.const [85] = Utf8 (IIII)Lde/esolutions/fw/util/commons/Buffer; 
.const [86] = Utf8 de/audi/audio/services/ToneAudioService 
.const [87] = Utf8 name 
.const [88] = Utf8 Ljava/lang/String; 
.const [89] = Utf8 de/audi/atip/log/LogChannel 
.const [90] = Utf8 log 
.const [91] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [92] = Utf8 de/audi/audio/services/ToneAudioService 
.const [93] = Utf8 callReleaseConnection 
.const [94] = Utf8 (II)V 
.const [95] = Utf8 de/audi/audio/services/BaseAudioService 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/audio/AudioEnv;Ljava/lang/String;)V 
.const [98] = Utf8 de/audi/audio/services/ToneAudioService 
.const [99] = Class [98] 
.const [100] = Utf8 de/audi/audio/services/BaseAudioService 
.const [101] = Class [100] 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/audio/AudioEnv;Ljava/lang/String;)V 
.const [105] = Utf8 releaseConnection 
.const [106] = Utf8 (II)V 
.end class 
