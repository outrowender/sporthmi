.version 50 0 
.class public super [75] 
.super [77] 
.field [78] [79] 
.field private final synthetic [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     aload_2 
L7:     invokespecial [15] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [18] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     aload_0 
L7:     getfield [12] 
L10:    aconst_null 
L11:    invokevirtual [13] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [82] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 4 locals 0 
L0:     new [19] 
L3:     dup 
L4:     ldc_w [1] 
L7:     invokespecial [16] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [82] .code stack 3 locals 0 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [11] 
L13:    invokestatic [5] 
L16:    ldc [6] 
L18:    ldc [7] 
L20:    invokevirtual [14] 
L23:    pop 
L24:    iconst_1 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Method [24] [25] 
.const [6] = Int 1078071040 
.const [7] = String [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Class [46] 
.const [20] = Int 738263040 
.const [21] = Utf8 MEDIA_BUFFER_FILLED_CHANGED 
.const [22] = Utf8 java/lang/Long 
.const [23] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent$ProcessBufferEventTask 
.const [24] = Class [47] 
.const [25] = NameAndType [48] [49] 
.const [26] = Utf8 'ProcessBufferEventTask#processBufferEvent coalesceWith: avoided processing' 
.const [27] = Utf8 de/audi/tghu/online/app/remotehmi/AbstractRemoteHMITask 
.const [28] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Utf8 java/lang/Long 
.const [47] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent 
.const [48] = Utf8 access$200 
.const [49] = Utf8 (Lde/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent;)Lde/audi/atip/log/LogChannel; 
.const [50] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent$ProcessBufferEventTask 
.const [51] = Utf8 this$0 
.const [52] = Utf8 Lde/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent; 
.const [53] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent$ProcessBufferEventTask 
.const [54] = Utf8 session 
.const [55] = Utf8 Lde/audi/remotehmi/media/IOnlineMediaSession; 
.const [56] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent 
.const [57] = Utf8 processGenericEvent 
.const [58] = Utf8 (Ljava/lang/String;Lde/audi/remotehmi/media/IOnlineMediaSession;Ljava/lang/Object;)V 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 log 
.const [61] = Utf8 (ILjava/lang/String;)Z 
.const [62] = Utf8 de/audi/tghu/online/app/remotehmi/AbstractRemoteHMITask 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Ljava/lang/String;)V 
.const [65] = Utf8 java/lang/Long 
.const [66] = Utf8 <init> 
.const [67] = Utf8 (J)V 
.const [68] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent$ProcessBufferEventTask 
.const [69] = Utf8 this$0 
.const [70] = Utf8 Lde/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent; 
.const [71] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent$ProcessBufferEventTask 
.const [72] = Utf8 session 
.const [73] = Utf8 Lde/audi/remotehmi/media/IOnlineMediaSession; 
.const [74] = Utf8 de/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent$ProcessBufferEventTask 
.const [75] = Class [74] 
.const [76] = Utf8 de/audi/tghu/online/app/remotehmi/AbstractRemoteHMITask 
.const [77] = Class [76] 
.const [78] = Utf8 session 
.const [79] = Utf8 Lde/audi/remotehmi/media/IOnlineMediaSession; 
.const [80] = Utf8 this$0 
.const [81] = Utf8 Lde/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent; 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/tghu/online/app/remotehmi/onlinemedia/OnlineMediaComponent;Ljava/lang/String;Lde/audi/remotehmi/media/IOnlineMediaSession;)V 
.const [85] = Utf8 run 
.const [86] = Utf8 ()V 
.const [87] = Utf8 isCoalescable 
.const [88] = Utf8 ()Z 
.const [89] = Utf8 getDelayMillis 
.const [90] = Utf8 ()Ljava/lang/Long; 
.const [91] = Utf8 coalesceWith 
.const [92] = Utf8 (Lde/audi/tghu/online/app/remotehmi/RemoteHMITask;)Z 
.end class 
