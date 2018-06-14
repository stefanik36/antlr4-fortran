      program doLoops
      implicit none
      integer it, sq
      character*(20) kkk
        sq = 50
      do it=0, 12
        print 'JD', it, 1
      end do
      print *, 'uwaga, test ifa', ' :>'
      if (sq .EQ.51.EQV.sq.EQ.50.AND..NOT.sq.EQ.51) then
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
       it = 12-3*2
      print *, 'Jakieś proste rzeczy to tak', it, sq, kkk, 12
      end
