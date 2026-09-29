.version 50 0 
.class public super [84] 
.super [86] 
.field [87] [88] 
.field [89] [90] 
.field private final synthetic [91] [92] 

.method public [94] : [95] 
    .attribute [93] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     aload_2 
L7:     invokespecial [15] 
L10:    aload_0 
L11:    iload_3 
L12:    putfield [18] 
L15:    aload_0 
L16:    iload 4 
L18:    putfield [19] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [96] : [97] 
    .attribute [93] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_0 
L5:     getfield [11] 
L8:     aload_0 
L9:     getfield [12] 
L12:    invokestatic [2] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [98] : [99] 
    .attribute [93] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [100] : [101] 
    .attribute [93] .code stack 4 locals 0 
L0:     new [20] 
L3:     dup 
L4:     lconst_0 
L5:     invokespecial [16] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [102] : [103] 
    .attribute [93] .code stack 5 locals 0 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [10] 
L13:    getfield [13] 
L16:    ldc [5] 
L18:    ldc [6] 
L20:    aload_1 
L21:    checkcast [4] 
L24:    getfield [11] 
L27:    i2l 
L28:    invokevirtual [14] 
L31:    pop 
L32:    iconst_1 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [21] [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Int 1078071040 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Field [29] [30] 
.const [11] = Field [31] [32] 
.const [12] = Field [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Field [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = Class [49] 
.const [21] = Class [50] 
.const [22] = NameAndType [51] [52] 
.const [23] = Utf8 java/lang/Long 
.const [24] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [25] = Utf8 'UpdatePlayTimeTask#coalesceWith: avoided update of playtime: %1' 
.const [26] = Utf8 de/audi/tghu/online/app/remotehmi/AbstractRemoteHMITask 
.const [27] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Class [53] 
.const [30] = NameAndType [54] [55] 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
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
.const [49] = Utf8 java/lang/Long 
.const [50] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy 
.const [51] = Utf8 access$000 
.const [52] = Utf8 (Lde/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy;II)V 
.const [53] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [54] = Utf8 this$0 
.const [55] = Utf8 Lde/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy; 
.const [56] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [57] = Utf8 timePlaying 
.const [58] = Utf8 I 
.const [59] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [60] = Utf8 timeTotal 
.const [61] = Utf8 I 
.const [62] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy 
.const [63] = Utf8 logChannel 
.const [64] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 log 
.const [67] = Utf8 (ILjava/lang/String;J)Z 
.const [68] = Utf8 de/audi/tghu/online/app/remotehmi/AbstractRemoteHMITask 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (Ljava/lang/String;)V 
.const [71] = Utf8 java/lang/Long 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (J)V 
.const [74] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [75] = Utf8 this$0 
.const [76] = Utf8 Lde/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy; 
.const [77] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [78] = Utf8 timePlaying 
.const [79] = Utf8 I 
.const [80] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [81] = Utf8 timeTotal 
.const [82] = Utf8 I 
.const [83] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy$UpdatePlayTimeTask 
.const [84] = Class [83] 
.const [85] = Utf8 de/audi/tghu/online/app/remotehmi/AbstractRemoteHMITask 
.const [86] = Class [85] 
.const [87] = Utf8 timePlaying 
.const [88] = Utf8 I 
.const [89] = Utf8 timeTotal 
.const [90] = Utf8 I 
.const [91] = Utf8 this$0 
.const [92] = Utf8 Lde/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy; 
.const [93] = Utf8 Code 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (Lde/audi/tghu/online/app/remotehmi/onlinemedia/PlaytimeSingleTrackStrategy;Ljava/lang/String;II)V 
.const [96] = Utf8 run 
.const [97] = Utf8 ()V 
.const [98] = Utf8 isCoalescable 
.const [99] = Utf8 ()Z 
.const [100] = Utf8 getDelayMillis 
.const [101] = Utf8 ()Ljava/lang/Long; 
.const [102] = Utf8 coalesceWith 
.const [103] = Utf8 (Lde/audi/tghu/online/app/remotehmi/RemoteHMITask;)Z 
.end class 
