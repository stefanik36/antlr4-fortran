function fib(n)
   integer fib, n
    if (n.EQ.0) then
        fib = 0
    else if (n .EQ.1) then
        fib = 1
    else
        fib = fib(n-1) + fib(n-2)
   end if
end
program main
   integer result
    result = fib(13)
    print *, 'Result fib(13):', result
end
