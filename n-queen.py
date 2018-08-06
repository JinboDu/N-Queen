def isOk(list,num):
	if(len(list)==0):
		return True;
	else:
		size=len(list);
		for i in range(size):
			if num==list[i] or abs(num-list[i])==abs(i-size):
				return False;
		return True;	
def queen(n):
	list=[];
	p=1;
	counter=0;
	while p<=n and (len(list)==0 or list[0]<=n):
		if(isOk(list,p)):
			list.append(p);
			if len(list)==n:
				counter=counter+1;
				print(counter);
				print(list);
				p=list.pop()+1;
				while p>n and len(list)>0:
					p=list.pop()+1;
			else:
				p=1;
		else:
			if p==n:
				p=list.pop()+1;
				while p>n and len(list)>0:
					p=list.pop()+1;
			else:
				p=p+1;
	print('end');
num=input("how many queens?");
num=int(num);
queen(num);
