define i32 @main(i32) {
entry:
  %"n * fac(n - 1).reg2mem" = alloca i32
  %result.reg2mem = alloca i32
  %"n == 0" = icmp eq i32 %0, 0
  br i1 %"n == 0", label %iftrue, label %iffalse

iftrue:                                           ; preds = %entry
  store i32 1, i32* %result.reg2mem
  br label %end

iffalse:                                          ; preds = %entry
  %"n - 1" = add i32 %0, -1
  %"fac(n - 1)" = call i32 @main(i32 %"n - 1")
  %"n * fac(n - 1)" = mul i32 %"fac(n - 1)", %0
  store i32 %"n * fac(n - 1)", i32* %"n * fac(n - 1).reg2mem"
  store i32 %"n * fac(n - 1)", i32* %result.reg2mem
  br label %end

end:                                              ; preds = %iffalse, %iftrue
  %result.reload = phi i32 [ %"n * fac(n - 1)", %iffalse ], [ 1, %iftrue ]
  ret i32 %result.reload
}
