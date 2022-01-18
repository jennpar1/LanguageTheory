fun1(x) = begin
  n = 1
  total = 1
  while(n <= 100)
    total += (((x^n)/n)+(3/n))
    n += 1
  end
  return total
end
x = 2
println(fun1(x))
