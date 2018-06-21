; ModuleID = 'TEST'
source_filename = "TEST"

@0 = private unnamed_addr constant [29 x i8] c"Jakie\C5\9B proste rzeczy to tak\00"
@1 = private unnamed_addr constant [30 x i8] c"%s          %d           %d \0A\00"

define i32 @main() {
entry_main:
  %it = alloca i32
  %sq = alloca i32
  %sum = alloca i32
  %s1 = alloca i32
  %s2 = alloca i32
  %s3 = alloca i32
  %kkk = alloca [20 x i8]
  store [20 x i8] c"Ov fire and the void", [20 x i8]* %kkk
  store i32 11, i32* %s1
  store i32 20, i32* %s2
  store i32 62, i32* %it
  store i32 12, i32* %sq
  %0 = load i32, i32* %s2
  %"1/" = sdiv i32 800, %0
  store i32 %"1/", i32* %s3
  %1 = load i32, i32* %s1
  %"0*" = mul i32 %1, 11
  %"0+" = add i32 %"0*", 29
  %"0/" = sdiv i32 %"0+", 10
  %2 = load i32, i32* %s1
  %3 = load i32, i32* %s2
  %"0-" = sub i32 %2, %3
  %"1+" = add i32 %"0-", 31
  %4 = load i32, i32* %s1
  %"0+1" = add i32 %4, %"0/"
  %"1-" = sub i32 %"0+1", %"1+"
  %"0*2" = mul i32 %"1-", 20
  store i32 %"0*2", i32* %sum
  %5 = load i32, i32* %sum
  %6 = load i32, i32* %s3
  %7 = call i32 (...) @printf([30 x i8]* @1, [29 x i8]* @0, i32 %5, i32 %6)
  ret i32 0
}

declare i32 @printf(...)
