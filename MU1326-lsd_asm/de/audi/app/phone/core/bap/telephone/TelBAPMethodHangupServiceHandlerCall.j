.version 50 0 
.class public super [99] 
.super [101] 
.field private volatile [102] [103] 
.field private final [104] [105] 
.field static synthetic [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     new [20] 
L8:     dup 
L9:     aload_0 
L10:    aload_1 
L11:    invokespecial [17] 
L14:    putfield [21] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method [111] : [112] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokeinterface [22] 0 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method [113] : [114] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokeinterface [23] 0 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_1 
L1:     ifnonnull L14 
L4:     aload_0 
L5:     getfield [12] 
L8:     invokevirtual [13] 
L11:    goto L21 
L14:    aload_0 
L15:    getfield [12] 
L18:    invokevirtual [14] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method static synthetic [117] : [118] 
    .attribute [108] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [19] 
L9:     dup 
L10:    invokespecial [15] 
L13:    aload_1 
L14:    invokevirtual [11] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [119] : [120] 
    .attribute [108] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     dup_x1 
L3:     putfield [18] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [24] [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Field [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Field [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Class [51] 
.const [20] = Class [52] 
.const [21] = Field [53] [54] 
.const [22] = InterfaceMethod [55] [56] 
.const [23] = InterfaceMethod [57] [58] 
.const [24] = Class [59] 
.const [25] = NameAndType [60] [61] 
.const [26] = Utf8 java/lang/ClassNotFoundException 
.const [27] = Utf8 java/lang/NoClassDefFoundError 
.const [28] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker 
.const [29] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 java/lang/Class 
.const [32] = Utf8 de/audi/atip/interapp/phone/ITelEcallService 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Utf8 java/lang/NoClassDefFoundError 
.const [52] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Utf8 java/lang/Class 
.const [60] = Utf8 forName 
.const [61] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [62] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall 
.const [63] = Utf8 telEcallService 
.const [64] = Utf8 Lde/audi/atip/interapp/phone/ITelEcallService; 
.const [65] = Utf8 java/lang/NoClassDefFoundError 
.const [66] = Utf8 initCause 
.const [67] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [68] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall 
.const [69] = Utf8 telEcallServiceTracker 
.const [70] = Utf8 Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker; 
.const [71] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker 
.const [72] = Utf8 deinit 
.const [73] = Utf8 ()V 
.const [74] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker 
.const [75] = Utf8 init 
.const [76] = Utf8 ()V 
.const [77] = Utf8 java/lang/NoClassDefFoundError 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall;Lde/audi/app/phone/core/ITelApplication;)V 
.const [86] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall 
.const [87] = Utf8 telEcallService 
.const [88] = Utf8 Lde/audi/atip/interapp/phone/ITelEcallService; 
.const [89] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall 
.const [90] = Utf8 telEcallServiceTracker 
.const [91] = Utf8 Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker; 
.const [92] = Utf8 de/audi/atip/interapp/phone/ITelEcallService 
.const [93] = Utf8 hangupServiceCall 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/atip/interapp/phone/ITelEcallService 
.const [96] = Utf8 hangupLowPrioritySOSCall 
.const [97] = Utf8 ()V 
.const [98] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 telEcallService 
.const [103] = Utf8 Lde/audi/atip/interapp/phone/ITelEcallService; 
.const [104] = Utf8 telEcallServiceTracker 
.const [105] = Utf8 Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker; 
.const [106] = Utf8 class$de$audi$atip$interapp$phone$ITelEcallService 
.const [107] = Utf8 Ljava/lang/Class; 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [111] = Utf8 hangupServiceCall 
.const [112] = Utf8 ()V 
.const [113] = Utf8 hangupLowPrioritySOSCall 
.const [114] = Utf8 ()V 
.const [115] = Utf8 onCombiServiceChanged 
.const [116] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone;)V 
.const [117] = Utf8 class$ 
.const [118] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [119] = Utf8 access$002 
.const [120] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodHangupServiceHandlerCall;Lde/audi/atip/interapp/phone/ITelEcallService;)Lde/audi/atip/interapp/phone/ITelEcallService; 
.end class 
