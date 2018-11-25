var fs =require('fs');

function parseFiles(files) {
    resmap={};
    files.forEach(element => {
        if(fs.existsSync(element))
        var results=fs.readFileSync(element).toString();

        for (const result in results.split('\n')) {
            resStatus=result.split(',')[1];
            if (resmap.hasOwnProperty(resStatus)) {
                var val=resmap[resStatus];
                resmap[resStatus]=val+1;                
            }else{
                resmap[resStatus]=1;
            }
        }
        //console.log(results);
        

    });
    return resmap;
}

filesarr=[".\\result2.txt",".\\result2.txt",".\\result3.txt"];
console.log(parseFiles(filesarr));