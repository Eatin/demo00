

var table = document.getElementById('table-batabase');

save.onclick = function(){
    alert("Hello! I am an alert box!!");
    alert(table.rows.length);

    var tr;

    var dataArray = new Array();

    for(var i=1;i<table.rows.length;i++){

        date = new Object();

        tr = table.rows[i];

        date.Code = tr.childNodes[0].innerHTML;

        date.Name = tr.childNodes[1].innerHTML;

        date.Age  = tr.childNodes[2].innerHTML;


        //将table表对象转换成数组装成json放在数组里

        dataArray.push(JSON.stringify(date));

    }

    //将数组装成json放在数组里

    document.getElementById('JSONText').value = dataArray.toString();

    myform.submit();

}