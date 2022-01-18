function charFrequency(freqDict,str)
  for i=1, str.len(str), 1 do
    local_, count = string.gsub(str, string.sub(str,i,i), "." )
    if count>=2 then
      freqDict[string.sub(str,i,i)] = count
    end
  end   
end

freqDict = {}

freqDict = setmetatable({}, {
 __tostring = function(freqDict)
 for key, value in pairs(freqDict) do
   return  key..value
 end
 end})

charFrequency(freqDict, "ProgrammingLanguageTheory" )
print(freqDict)
