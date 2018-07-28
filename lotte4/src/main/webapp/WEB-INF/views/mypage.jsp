<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .updatebtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
	var checkPassword=$(":input[name=password]").val();
	var checkName=$(":input[name=name]").val();
	var phoneNumber=$("input[name=phoneNumber]").val();
	$(document).ready(function(){
		
		$(".cancelbtn").click(function(){
			location.href="${pageContext.request.contextPath}/index.do";
		});
		
		//regForm onsubmit 함수
		$("#regForm").submit(function(){
			if(checkName==""){
				alert("이름을 체크하세요");
				return false;
			}
			if(checkPassword==""){
				alert("비밀번호를 체크하세요");
				return false;
			}
			if(phoneNumber==""){
				alert("전화번호를 확인하세요");
				return false;
			}
			
		});
		
		

		
		/*  $(":input[name=psw-repeat]").keyup(function(){
			var repeatPwd=$(this).val().trim();
			var pwd=$(":input[name=password]").val().trim();
			if(pwd!=repeatPwd){
				$(".result_psw_repeat").html("비밀번호가 일치하지않습니다");
				checkPassword="";
			}
			if(pwd==repeatPwd){
				$(".result_psw_repeat").html("비밀번호가 일치합니다");
				checkPassword=pwd;
			}
		});  */
		
		$(":input[name=name]").keyup(function(){
			var mName=$(this).val().trim();
			if(mName.length<2){
				$(".result_name").html("이름은 3자 이상 입력해주세요");
				checkName="";
			}
			checkName=mName;
		});
		
		
		
		$(":input[name=phoneNumber]").keyup(function(){
			var phone=$(this).val().trim();
			if(phone!=""){
				phoneNumber=phone;
			}
		});
		
		/* var checkBox=document.getElementById("checkBox")
		var checkResult=$(checkBox).prop("checked");
		if(checkResult==false){
			checkBox.val("0");
		}
 */			
			
			
	
	});
	


</script>

<body>

<form action="${pageContext.request.contextPath}/updateMember.do"   method="post" style="border:1px solid #ccc" id="regForm">
  <div class="container">
    <h1>${sessionScope.memberVO.name }님의 정보</h1>
    <hr>
	
	<label for="id"><b>id</b></label>
    <input type="text" placeholder="Enter id" name="memberId" value="${sessionScope.memberVO.memberId }" readonly>
    <p class="result_id" id="checkId"></p>
	
    <label for="name"><b>name</b></label>
    <input type="text" placeholder="Enter name" name="name" value="${sessionScope.memberVO.name }">
    <p class="result_name"></p>

    <label for="pwd"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" value="${sessionScope.memberVO.password }">
    <p class="result_pwd"></p>
    
    
    <label for="phoneNumber"><b>Phone Number</b></label>
    <input type="text" placeholder="Enter phone number" name="phoneNumber" value="${sessionScope.memberVO.phoneNumber }">
    <p class="result_phoneNumber"></p>
    
    <label>
      <input type="checkbox" checked="checked" name="sms" value="1" style="margin-bottom:15px" id="checkBox"> SMS 수신 동의
    </label>
    
    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">취소</button>
      <button type="submit" class="updatebtn">회원정보 수정</button>
    </div>
  </div>
</form>

</body>
</html>