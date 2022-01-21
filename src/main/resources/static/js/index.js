$(document).ready(function(){
  // 고정 확장자 불러오기
  $.ajax({
    type: 'GET',
    url : '/api/fix',
    dataType: 'json',
    success: function(res){
      for(let i = 0; i < res.length; i++) {
        if(res[i].state == 1) {
          $("#fix").append("<input type='checkbox' onclick='check(event)' value="+res[i].idx+" checked>" + res[i].extensions);
        } else {
          $("#fix").append("<input type='checkbox' onclick='check(event)' value="+res[i].idx+">" + res[i].extensions);
        }
      }
    },
    error:function(err){
      alert(err);
    }
  })

  // 커스텀 확장자 불러오기
  $.ajax({
    type: 'GET',
    url : '/api/custom',
    dataType: 'json',
    success: function(res){
      $("#count").append(res.length + "/" + 200);
      for(let i = 0; i < res.length; i++) {
        $("#list").append("<a id='extensions' style='border:1px solid; border-radius: 10px; width:100px;'>"
            +res[i].extensions+"<img src='/images/x.png' width='10px' height='10px' onclick='deleteItem(event)' id="+res[i].idx+"></a>&nbsp;");
      }
    },
    error:function(err){
      alert(err);
    }
  })
});

// 고정 확장자 체크
function check(event){
  $.ajax({
    type: "PUT",
    url:"api/fix",
    dataType:'text',
    data : {
      idx:event.target.value
    },
    success : function (){
      console.log("sucess");
    },
    error:function (err){
      alert(err);
    }
  })
}

// 커스텀 확장자 추가
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

// 커스텀 확장자 삭제
function deleteItem(event){
  $.ajax({
    type: "DELETE",
    url:"api/custom",
    dataType:'text',
    data : {
      idx:event.target.id
    },
    success : function (){
      alert("삭제되었습니다.");
      window.location.reload()
    },
    error:function (err){
      alert(err);
    }
  })
}


