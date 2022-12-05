import re

# Parse the input and create a list of section assignment pairs
pairs = []
with open("C:\\Users\\Mechanist\\Documents\\Programming\\Java\\AdventOfCode2022\\advent\\dayfour\\input.txt") as f:
    for line in f:
        match = re.match(r"(\d+)-(\d+),(\d+)-(\d+)", line.strip())
        if match:
            elf_one_start, elf_one_end, elf_two_start, elf_two_end = map(int, match.groups())
            pairs.append((elf_one_start,elf_one_end, elf_two_start, elf_two_end))

count = 0

#get largest number in pairs
largest = 0
for i in range(len(pairs)):
    if(pairs[i][1] > largest):
        largest = pairs[i][1]
    if(pairs[i][3] > largest):
        largest = pairs[i][3]

#count the number of overlapping pairs
for i in range(len(pairs)):
    #Determine if j overlaps with i
    iPair = ""
    jPair = ""

    currentPair = pairs[i]

    #Get the min and max of the pairs
    iMin = pairs[i][0]
    iMax = pairs[i][1]
    jMin = pairs[i][2]
    jMax = pairs[i][3]

    #get lowest min and highest max
    min = iMin if iMin < jMin else jMin
    max = iMax if iMax > jMax else jMax
    

    for x in range(0, pairs[i][0]+1):
        iPair += "."
    for x in range(pairs[i][0], pairs[i][1]+1):
        iPair += "#"

    for x in range(0, pairs[i][2]+1):
        jPair += "."

    for x in range(pairs[i][2], pairs[i][3]+1):
        jPair += "#"

    #add the rest of the pairs
    for x in range(pairs[i][1]+1, largest+1):
        iPair += "."
    for x in range(pairs[i][3]+1, largest+1):
        jPair += "."

    iPair += " " + str(pairs[i][0]) + "-" + str(pairs[i][1])
    jPair += " " + str(pairs[i][2]) + "-" + str(pairs[i][3])

    #(54,70),(70,71)
    #is the first pair fully contained in the second pair?
    if(currentPair[1] <= currentPair[3] and currentPair[0] >= currentPair[2]):
        count += 1
        print("Fully Contained")
        print(iPair)
        print(jPair + "\n")
        continue

    #is the second pair fully contained in the first pair?
    if(currentPair[3] <= currentPair[1] and currentPair[2] >= currentPair[0]):
        count += 1
        print("Fully Contained")
        print(iPair)
        print(jPair + "\n")
        continue

   # print(iPair)
    #print(jPair + "\n")

    #print(pairs[i][0], pairs[i][1], pairs[j][0], pairs[j][1])

    
      




print(pairs)


# Print the result
print(count)