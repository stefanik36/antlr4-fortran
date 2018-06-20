; ModuleID = 'TEST'
source_filename = "TEST"

@0 = private unnamed_addr constant [28 x i8] c"          %d           %d \0A\00"
@1 = private unnamed_addr constant [16 x i8] c"uwaga, test ifa\00"
@2 = private unnamed_addr constant [4 x i8] c" :>\00"
@3 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@4 = private unnamed_addr constant [9 x i8] c"sq == 50\00"
@5 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@6 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@7 = private unnamed_addr constant [9 x i8] c"sq == 51\00"
@8 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@9 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@10 = private unnamed_addr constant [9 x i8] c"sq == 52\00"
@11 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@12 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@13 = private unnamed_addr constant [9 x i8] c"sq == 53\00"
@14 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@15 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@16 = private unnamed_addr constant [5 x i8] c"ELSE\00"
@17 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@18 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@19 = private unnamed_addr constant [5 x i8] c"ELSE\00"
@20 = private unnamed_addr constant [18 x i8] c"pi\C4\99kna sprawa :>\00"
@21 = private unnamed_addr constant [6 x i8] c"%s%s\0A\00"
@22 = private unnamed_addr constant [29 x i8] c"Jakie\C5\9B proste rzeczy to tak\00"
@23 = private unnamed_addr constant [45 x i8] c"%s          %d           %d %s          %d \0A\00"

define i32 @main() {
entry_main:
  %it = alloca i32
  %sq = alloca i32
  %kkk = alloca [20 x i8]
  store i32 50, i32* %sq
  store i32 0, i32* %it
  br label %loop

loop:                                             ; preds = %body_loop, %entry_main
  %0 = load i32, i32* %it
  %1 = add i32 %0, 1
  store i32 %1, i32* %it
  %2 = icmp slt i32 %1, 12
  br i1 %2, label %body_loop, label %end_loop

body_loop:                                        ; preds = %loop
  %3 = load i32, i32* %it
  %4 = call i32 (...) @printf([28 x i8]* @0, i32 %3, i32 1)
  br label %loop

end_loop:                                         ; preds = %loop
  %5 = call i32 (...) @printf([6 x i8]* @3, [16 x i8]* @1, [4 x i8]* @2)
  %6 = load i32, i32* %sq
  %7 = icmp eq i32 %6, 51
  %8 = load i32, i32* %sq
  %9 = icmp eq i32 %8, 50
  %10 = load i32, i32* %sq
  %11 = icmp eq i32 %10, 51
  %12 = xor i1 %11, true
  %13 = icmp eq i1 %7, %9
  %14 = and i1 %13, %12
  br i1 %14, label %18, label %20

end_block:                                        ; preds = %34, %end_block1, %18
  store [20 x i8] c"Ov fire and the void", [20 x i8]* %kkk
  store i32 6, i32* %it
  %15 = load i32, i32* %it
  %16 = load i32, i32* %sq
  %17 = call i32 (...) @printf([45 x i8]* @23, [29 x i8]* @22, i32 %15, i32 %16, [20 x i8]* %kkk, i32 12)
  ret i32 0

; <label>:18:                                     ; preds = %end_loop
  %19 = call i32 (...) @printf([6 x i8]* @6, [9 x i8]* @4, [18 x i8]* @5)
  store i32 10, i32* %sq
  br label %end_block

; <label>:20:                                     ; preds = %end_loop
  %21 = load i32, i32* %sq
  %22 = icmp slt i32 %21, 51
  br i1 %22, label %23, label %34

; <label>:23:                                     ; preds = %20
  %24 = call i32 (...) @printf([6 x i8]* @9, [9 x i8]* @7, [18 x i8]* @8)
  store i32 1, i32* %sq
  %25 = load i32, i32* %sq
  %26 = icmp eq i32 %25, 51
  %27 = load i32, i32* %sq
  %28 = icmp eq i32 %27, 50
  %29 = load i32, i32* %sq
  %30 = icmp eq i32 %29, 51
  %31 = xor i1 %30, true
  %32 = icmp eq i1 %26, %28
  %33 = and i1 %32, %31
  br i1 %33, label %36, label %38

; <label>:34:                                     ; preds = %20
  %35 = call i32 (...) @printf([6 x i8]* @21, [5 x i8]* @19, [18 x i8]* @20)
  store i32 6, i32* %sq
  br label %end_block

end_block1:                                       ; preds = %43, %41, %36
  br label %end_block

; <label>:36:                                     ; preds = %23
  %37 = call i32 (...) @printf([6 x i8]* @12, [9 x i8]* @10, [18 x i8]* @11)
  store i32 10, i32* %sq
  br label %end_block1

; <label>:38:                                     ; preds = %23
  %39 = load i32, i32* %sq
  %40 = icmp slt i32 %39, 51
  br i1 %40, label %41, label %43

; <label>:41:                                     ; preds = %38
  %42 = call i32 (...) @printf([6 x i8]* @15, [9 x i8]* @13, [18 x i8]* @14)
  store i32 1, i32* %sq
  br label %end_block1

; <label>:43:                                     ; preds = %38
  %44 = call i32 (...) @printf([6 x i8]* @18, [5 x i8]* @16, [18 x i8]* @17)
  store i32 6, i32* %sq
  br label %end_block1
}

declare i32 @printf(...)
