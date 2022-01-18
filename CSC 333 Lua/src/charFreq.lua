function charFrequency(freqDict,str)  

  for i=1, str.len(str), 1 do
    local_, count = string.gsub(str, string.sub(str,i,i), "." )
    if count>=2 then
      freqDict[string.sub(str,i,i)] = count
    end
  end   
end

freqDict = {}
charFrequency(freqDict, "ProgrammingLanguageTheory" )
for key, value in pairs(freqDict) do
 print(key, value)
end