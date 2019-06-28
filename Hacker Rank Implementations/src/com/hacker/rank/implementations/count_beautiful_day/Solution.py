# Enter your code here. Read input from STDIN. Print output to STDOUT
if __name__ == "__main__":
	print('Give input in string format, space saperated')
	l = input().split()
	i = int(l[0])
	j = int(l[1])
	k = int(l[2])

	count = 0
	for l in range(i , j+1) :
		if abs(l - int(str(l)[::-1])) % k == 0 :
			count+=1

	print(count)

