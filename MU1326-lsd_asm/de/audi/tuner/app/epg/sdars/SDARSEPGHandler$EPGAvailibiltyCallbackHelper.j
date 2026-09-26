.version 50 0 
.class super [91] 
.super [93] 
.field private [94] [95] 
.field private [96] [97] 
.field private [98] [99] 

.method public [101] : [102] 
    .attribute [100] .code stack 4 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     new [14] 
L7:     dup 
L8:     invokespecial [11] 
L11:    iconst_0 
L12:    invokespecial [12] 
L15:    aload_0 
L16:    getfield [7] 
L19:    iconst_m1 
L20:    putfield [16] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [100] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     getstatic [2] 
L8:     putfield [17] 
L11:    aload_0 
L12:    new [14] 
L15:    dup 
L16:    invokespecial [11] 
L19:    putfield [15] 
L22:    aload_0 
L23:    aload_1 
L24:    putfield [17] 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [15] 
L32:    aload_0 
L33:    iload_3 
L34:    putfield [18] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     getfield [8] 
L7:     aload_1 
L8:     getfield [8] 
L11:    if_icmpne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [100] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     iload_1 
L5:     if_icmpeq L27 
L8:     aload_0 
L9:     iload_1 
L10:    putfield [18] 
L13:    aload_0 
L14:    getfield [9] 
L17:    aload_0 
L18:    getfield [7] 
L21:    iload_1 
L22:    invokeinterface [19] 0 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [20] [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Field [26] [27] 
.const [8] = Field [28] [29] 
.const [9] = Field [30] [31] 
.const [10] = Field [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Class [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Field [47] [48] 
.const [19] = InterfaceMethod [49] [50] 
.const [20] = Class [51] 
.const [21] = NameAndType [52] [53] 
.const [22] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [23] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [24] = Utf8 java/lang/Object 
.const [25] = Utf8 de/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback 
.const [26] = Class [54] 
.const [27] = NameAndType [55] [56] 
.const [28] = Class [57] 
.const [29] = NameAndType [58] [59] 
.const [30] = Class [60] 
.const [31] = NameAndType [61] [62] 
.const [32] = Class [63] 
.const [33] = NameAndType [64] [65] 
.const [34] = Class [66] 
.const [35] = NameAndType [67] [68] 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Utf8 de/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback 
.const [52] = Utf8 DUMMY 
.const [53] = Utf8 Lde/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback; 
.const [54] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [55] = Utf8 interestingStation 
.const [56] = Utf8 Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [57] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [58] = Utf8 sID 
.const [59] = Utf8 I 
.const [60] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [61] = Utf8 callback 
.const [62] = Utf8 Lde/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback; 
.const [63] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [64] = Utf8 lastReportedValue 
.const [65] = Utf8 Z 
.const [66] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback;Lde/audi/tuner/app/sdars/StationInfoExt;Z)V 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [76] = Utf8 interestingStation 
.const [77] = Utf8 Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [78] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [79] = Utf8 sID 
.const [80] = Utf8 I 
.const [81] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [82] = Utf8 callback 
.const [83] = Utf8 Lde/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback; 
.const [84] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [85] = Utf8 lastReportedValue 
.const [86] = Utf8 Z 
.const [87] = Utf8 de/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback 
.const [88] = Utf8 epgAvailibiltyChanged 
.const [89] = Utf8 (Lde/audi/tuner/app/sdars/StationInfoExt;Z)V 
.const [90] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$EPGAvailibiltyCallbackHelper 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Object 
.const [93] = Class [92] 
.const [94] = Utf8 callback 
.const [95] = Utf8 Lde/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback; 
.const [96] = Utf8 interestingStation 
.const [97] = Utf8 Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [98] = Utf8 lastReportedValue 
.const [99] = Utf8 Z 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/tuner/app/epg/sdars/IEPGAvailibiltyCallback;Lde/audi/tuner/app/sdars/StationInfoExt;Z)V 
.const [105] = Utf8 isInterestedInEPGAvailibityChangesFor 
.const [106] = Utf8 (Lde/audi/tuner/app/sdars/StationInfoExt;)Z 
.const [107] = Utf8 notifyEPGAvailibity 
.const [108] = Utf8 (Z)V 
.end class 
