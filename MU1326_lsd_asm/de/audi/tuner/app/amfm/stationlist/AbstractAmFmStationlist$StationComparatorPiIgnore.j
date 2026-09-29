.version 50 0 
.class super [27] 
.super [29] 
.implements [31] 

.method private annotation [33] : [34] 
    .attribute [32] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [35] : [36] 
    .attribute [32] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_2 
L5:     ifnonnull L10 
L8:     iconst_0 
L9:     areturn 
L10:    aload_1 
L11:    getfield [5] 
L14:    aload_2 
L15:    getfield [5] 
L18:    lcmp 
L19:    ifne L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method synthetic [37] : [38] 
    .attribute [32] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [8] 
.const [3] = Class [9] 
.const [4] = Class [10] 
.const [5] = Field [11] [12] 
.const [6] = Method [13] [14] 
.const [7] = Method [15] [16] 
.const [8] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparatorPiIgnore 
.const [9] = Utf8 java/lang/Object 
.const [10] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [11] = Class [17] 
.const [12] = NameAndType [18] [19] 
.const [13] = Class [20] 
.const [14] = NameAndType [21] [22] 
.const [15] = Class [23] 
.const [16] = NameAndType [24] [25] 
.const [17] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [18] = Utf8 frequency 
.const [19] = Utf8 J 
.const [20] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparatorPiIgnore 
.const [21] = Utf8 <init> 
.const [22] = Utf8 ()V 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 <init> 
.const [25] = Utf8 ()V 
.const [26] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparatorPiIgnore 
.const [27] = Class [26] 
.const [28] = Utf8 java/lang/Object 
.const [29] = Class [28] 
.const [30] = Utf8 de/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$StationComparator 
.const [31] = Class [30] 
.const [32] = Utf8 Code 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 equals 
.const [36] = Utf8 (Lde/audi/tuner/app/amfm/AMFMStation;Lde/audi/tuner/app/amfm/AMFMStation;)Z 
.const [37] = Utf8 <init> 
.const [38] = Utf8 (Lde/audi/tuner/app/amfm/stationlist/AbstractAmFmStationlist$1;)V 
.end class 
