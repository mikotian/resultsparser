
def rparser(files):
    rawresults=[]
    results={}
    for file in files:
        try:
            f=open(file)
            rawresults=f.readlines()
            for result in rawresults:
                testStatus=result.strip().split(",")[1]
                if results.get(testStatus) is None:
                    results[testStatus]=1
                else:
                    results[testStatus]+=1
        except IOError as e:
            print(e.errno)
        finally:
            f.close()
    return results
filearr=[".\\result2.txt",".\\result2.txt",".\\result3.txt"]
print(rparser(filearr))