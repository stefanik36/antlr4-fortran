; ModuleID = 'TEST'
source_filename = "TEST"

@0 = private unnamed_addr constant [16 x i8] c"INSIDE FUNCTION\00"
@1 = private unnamed_addr constant [4 x i8] c"%s\0A\00"
@2 = private unnamed_addr constant [15 x i8] c"FUNCTION VALUE\00"
@3 = private unnamed_addr constant [4 x i8] c"V: \00"
@4 = private unnamed_addr constant [32 x i8] c"%s          %d %s          %d \0A\00"

define i32 @ff(i32, i32) {
entry_ff:
  %ffVar = alloca i32
  %arg = alloca i32
  store i32 %0, i32* %arg
  %arg2 = alloca i32
  store i32 %1, i32* %arg2
  %2 = call i32 (...) @printf([4 x i8]* @1, [16 x i8]* @0)
  %3 = load i32, i32* %arg
  %"0+" = add i32 666, %3
  store i32 %"0+", i32* %ffVar
  %4 = load i32, i32* %ffVar
  ret i32 %4

entry_ff1:                                        ; No predecessors!
  %5 = load i32, i32* %ffVar
  ret i32 %5
}

declare i32 @printf(...)

define i32 @main() {
entry_main:
  %arg = alloca i32
  %vv = alloca i32
  %abc = alloca i32
  %func2 = alloca i32
  store i32 3, i32* %arg
  store i32 222, i32* %abc
  %0 = call i32 @ff(i32* %abc, i32* %arg)
  store i32 %0, i32* %vv
  %1 = load i32, i32* %arg
  %2 = load i32, i32* %vv
  %3 = call i32 (...) @printf([32 x i8]* @4, [15 x i8]* @2, i32 %1, [4 x i8]* @3, i32 %2)
  ret i32 0
}
