seqSum1(x,n) = begin
  total = 1
  i = 0
  while(i<n)
    total += (i/(x^i))
    i += 1
  end
  return total
end
x = 5
n = 100
println(seqSum1(x,n))
