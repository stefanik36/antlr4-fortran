      program doLoops
      implicit none
      integer it, sq
      real k2
      character*(20) kkk
      do it = 10, 10, 20
         sq = it * it + 31 * 13
         sq = 12
      end do
        sq = 50
      print *, 'uwaga, test ifa', 'BTW zle tego printa zrobilem. te stringi powinny sie polaczyc przy wyswietlaniu'
      if (sq .EQ. 50.EQV.sq.EQ.50.AND..NOT.sq.EQ.51) then
        print *, 'sq == 50', 'piękna sprawa :>'
        sq = 10
      else if (sq .LT. 51) then
        print *, 'sq == 51', 'piękna sprawa :>'
        sq = 1
      else
        print *, 'ELSE', 'piękna sprawa :>'
        sq = 6
      end if
       kkk = 'Ov fire and the void'
       it = 666
       k2 = 22.21
      print *, 'Jakieś proste rzeczy to tak', it, sq, kkk, 12,(12 -12 * -12 + 12 - 12)
      end
