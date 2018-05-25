@0 = private unnamed_addr constant [16 x i8] c"uwaga, test ifa\00"
@1 = private unnamed_addr constant [4 x i8] c" :>\00"
@2 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@3 = private unnamed_addr constant [9 x i8] c"sq == 50\00"
@4 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@5 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@6 = private unnamed_addr constant [9 x i8] c"sq == 51\00"
@7 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@8 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@9 = private unnamed_addr constant [5 x i8] c"ELSE\00"
@10 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@11 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@12 = private unnamed_addr constant [29 x i8] c"Jakie\C5\9B proste rzeczy to tak\00"
@13 = private unnamed_addr constant [45 x i8] c"%s          %d           %d %s          %d \0A\00"

define void @main() {
entry_main:
  %it = alloca i32
  %sq = alloca i32
  %kkk = alloca [21 x i8]
  %0 = load i32, i32* %it
  %1 = load i32, i32* %it
  %"0+" = add i32 %0, %1
  %"1+" = add i32 %"0+", 31
  %"2-" = sub i32 %"1+", 13
  store i32 %"2-", i32* %sq
  store i32 12, i32* %sq
  store i32 50, i32* %sq
  %2 = call i32 (...) @printf([6 x i8]* @2, [16 x i8]* @0, [4 x i8]* @1)
  %3 = load i32, i32* %sq
  %4 = icmp eq i32 %3, 50
  %5 = load i32, i32* %sq
  %6 = icmp eq i32 %5, 50
  %7 = load i32, i32* %sq
  %8 = icmp eq i32 %7, 51
  %9 = xor i1 %8, true
  %10 = icmp eq i1 %4, %6
  %11 = and i1 %10, %9
  br i1 %11, label %15, label %17

end_block:                                        ; preds = %22, %20, %15
  store [20 x i8] c"Ov fire and the void", [21 x i8]* %kkk
  store i32 -372, i32* %it
  %12 = load i32, i32* %it
  %13 = load i32, i32* %sq
  %14 = call i32 (...) @printf([45 x i8]* @13, [29 x i8]* @12, i32 %12, i32 %13, [21 x i8]* %kkk, i32 12)
  ret void

; <label>:15:                                     ; preds = %entry_main
  %16 = call i32 (...) @printf([6 x i8]* @5, [9 x i8]* @3, [18 x i8]* @4)
  store i32 10, i32* %sq
  br label %end_block

; <label>:17:                                     ; preds = %entry_main
  %18 = load i32, i32* %sq
  %19 = icmp slt i32 %18, 51
  br i1 %19, label %20, label %22

; <label>:20:                                     ; preds = %17
  %21 = call i32 (...) @printf([6 x i8]* @8, [9 x i8]* @6, [18 x i8]* @7)
  store i32 1, i32* %sq
  br label %end_block

; <label>:22:                                     ; preds = %17
  %23 = call i32 (...) @printf([6 x i8]* @11, [5 x i8]* @9, [18 x i8]* @10)
  store i32 6, i32* %sq
  br label %end_block
}

declare i32 @printf(...)