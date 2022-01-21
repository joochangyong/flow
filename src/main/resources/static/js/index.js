$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url : '/api/fix',
    dataType: 'json',
    success: function(res){
      for(let i = 0; i < res.length; i++) {
        if(res[i].state == 1) {
          $("#fix").append("<input type='checkbox' onclick='check(res[i].idx)' id="+res[i].idx+" checked>" + res[i].extensions);
        } else {
          $("#fix").append("<input type='checkbox' onclick='check(res[i].idx)' id="+res[i].idx+">" + res[i].extensions);
        }
      }
    },
    error:function(err){
      alert(err);
    }
  })

  $.ajax({
    type: 'GET',
    url : '/api/custom',
    dataType: 'json',
    success: function(res){
      $("#count").append(res.length + "/" + 200);
      res.map((item) => $("#list").append("<a id='extensions' style='border:1px solid; border-radius: 10px; width:100px;'>"
          +item.extensions+"<img src='/images/x.png' width='13px' height='13px'  onclick='deleteItem("+item.idx+")'></a>&nbsp;"));
    },
    error:function(err){
      alert(err);
    }
  })
});

function customAdd(){
  var data = {
    extensions: $('#extensions').val(),
  };
    $.ajax({
        type: 'POST',
        url : '/api/custom',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(data),
        success: function(){
          window.location.reload()
        },
        error:function(err){
          if(err.responseText == "중복된 확장자") {
            alert("이미 등록되어있는 확장자 입니다.");
          } else if(err.responseText == "200개 초과") {
            alert("확장자는 200개를 초과할 수 없습니다.");
          } else {
            alert(err);
          }
        }
    })
}