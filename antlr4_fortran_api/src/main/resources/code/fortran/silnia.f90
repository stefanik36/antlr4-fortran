function silnia(n)
   integer n, silnia, tmp
   if (n.LT.2) then
      silnia = 1
   else
      silnia = n * silnia(n-1)
   end if
end
program main
  integer result
   result = silnia(3)
    print *, 'Silnia 3: ', result
end
