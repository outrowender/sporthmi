.version 50 0 
.class super [33] 
.super [35] 
.implements [37] 

.method private annotation [39] : [40] 
    .attribute [38] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [41] : [42] 
    .attribute [38] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_2 
L5:     ifnonnull L10 
L8:     iconst_0 
L9:     areturn 
L10:    aload_1 
L11:    getfield [5] 
L14:    ifgt L24 
L17:    aload_2 
L18:    getfield [5] 
L21:    ifle L53 
L24:    aload_1 
L25:    getfield [5] 
L28:    aload_2 
L29:    getfield [5] 
L32:    if_icmpeq L47 
L35:    aload_1 
L36:    getfield [6] 
L39:    aload_2 
L40:    getfield [6] 
L43:    lcmp 
L44:    ifne L51 
L47:    iconst_1 
L48:    goto L52 
L51:    iconst_0 
L52:    areturn 
L53:    aload_1 
L54:    getfield [6] 
L57:    aload_2 
L58:    getfield [6] 
L61:    lcmp 
L62:    ifne L69 
L65:    iconst_1 
L66:    goto L70 
L69:    iconst_0 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method synthetic [43] : [44] 
    .attribute [38] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Class [11] 
.const [5] = Field [12] [13] 
.const [6] = Field [14] [15] 
.const [7] = Method [16] [17] 
.const [8] = Method [18] [19] 
.const [9] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparatorEU 
.const [10] = Utf8 java/lang/Object 
.const [11] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [12] = Class [20] 
.const [13] = NameAndType [21] [22] 
.const [14] = Class [23] 
.const [15] = NameAndType [24] [25] 
.const [16] = Class [26] 
.const [17] = NameAndType [27] [28] 
.const [18] = Class [29] 
.const [19] = NameAndType [30] [31] 
.const [20] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [21] = Utf8 pi 
.const [22] = Utf8 I 
.const [23] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [24] = Utf8 frequency 
.const [25] = Utf8 J 
.const [26] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparatorEU 
.const [27] = Utf8 <init> 
.const [28] = Utf8 ()V 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 <init> 
.const [31] = Utf8 ()V 
.const [32] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparatorEU 
.const [33] = Class [32] 
.const [34] = Utf8 java/lang/Object 
.const [35] = Class [34] 
.const [36] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparator 
.const [37] = Class [36] 
.const [38] = Utf8 Code 
.const [39] = Utf8 <init> 
.const [40] = Utf8 ()V 
.const [41] = Utf8 equals 
.const [42] = Utf8 (Lde/audi/tuner/app/amfm/AMFMStation;Lde/audi/tuner/app/amfm/AMFMStation;)Z 
.const [43] = Utf8 <init> 
.const [44] = Utf8 (Lde/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$1;)V 
.end class 
