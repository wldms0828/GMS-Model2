/*var mem = (function(){}());*/
"use strict";
var router = (()=>{
	return {move :x=>{
			location.href =
				x.ctx+"/" + x.domain + ".do?action="
		+ x.action + "&page=" + x.page}
		}; // closure 
})();
//실행하는 함수는  세미콜론을 꼭 붙여줘야 한다. 노드의 single threaded model이다.
var service = (()=>{
	return{
		nullChecker : x=>{
			var i = 0;//초기화
			var json = {
				checker : false,
				//속성 키와 속성 값이 때문에 =말고 : 사용
				text : "빈칸을 입력하세요"
			};
			for(i in x){
				if(x[i]===""){
					json.checker = false;
					break;
				}else{
					json.checker = true;
				}
			}
			return json;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
			if(arr.indexOf(cName) == -1){
				dom.className +=" "+cName;
			}
		}		
	}

})();
var common=(()=>{
	return {
		main : x=>{
			document.getElementById('moveToAdminMain')
			.addEventListener('click',function(){			
				var isAdmin = confirm('관리자입니까');
			if(isAdmin){
				var password = prompt('관리자 비밀번호 입력 바랍니다.');
				if(password==1){
					router.move({
						ctx: x,
						domain: "admin",
						action: "search",
						page: "main"
					});
				}
			}else{
				alert('관리자만 접근 가능합니다.');
			}});

			document.getElementById('moveLoginForm').addEventListener('click',function(){ //콜백함수
				alert('로그인 클릭 이벤트 체크!'+x);
				router.move({ctx :x,
					domain : 'member', 
					action : 'move',
					page : 'login'});
			});	
			document.getElementById('moveJoinForm').addEventListener('click',function(){
				alert('조인 클릭 이벤트 체크');
				router.move({ctx : x,
					domain : 'member', 
					action : 'move',
					page : 'add'});
			});
			document.getElementById('movedeleteForm').addEventListener('click',function(){
				router.move({ctx : '${ctx}',
					domain : 'member', 
					action : 'move',
					page : 'deleteForm'});
			})
				
		}
	};
})();
var admin =(()=>{
	return {	
		main:x=>{
			 service.addClass(
	 		document.getElementById('contentBoxMeta'),'bgColorIs '
 );
			 service.addClass(
	 		document.getElementById('contentBoxTab'),'marginAuto width80 height100px'
);
			 service.addClass(
	 		document.getElementById('content-box-search'),'width90 marginAuto'
);





	 	document.getElementById('searchBtn').addEventListener('click',()=>{

	 		location.href =
	 		(document.getElementById('searchOption').value==='USERID')?
	 			x+'/admin.do?action=retrieve&page=memberDetail&USERID='+ document.getElementById('search').value

	 		:
	 			x+'/admin.do?action=search&page=main&searchOption='+ document.getElementById('searchOption').value+'&search='+ document.getElementById('search').value;
	 	});
//	 	var x = document.querySelectorAll('.username');
	 	for(var i of document.querySelectorAll('.username')){
	 		service.addClass(
	 				i, 'cursor fontColor');
//	 		x[i].className='fontColor';
//	 		x[i].className='cursor';
	 		i.addEventListener('click',function(){
	 			alert('클릭'+this.getAttribute('id'));
	 			location.href = 
	 				x+"/member.do?action=retrieve&page=retrieve&USERID="+this.getAttribute('id');
				
//
	 		});
	 	}
		
		for(var i of document.querySelectorAll('.pageNum')){
	 		service.addClass(
	 				i, 'cursor fontColor');
			i.addEventListener('click',function(){
				location.href=
					x+"/admin.do?action=search&page=main&pageIndex="+this.getAttribute('id');
			});
		}


		}	
};})();



//userId, ssn, name, roll, teamId,password,gender;
var member = (()=>{
	var _userId, _age,_password,_name,_gender; 
	var setUserId = (userId)=>{this._userId=userId;}
	var setPassword = (password)=>{this._password=password;}
	var setName = (name)=>{this._name=name;}
	var setSsn = (ssn)=>{this.ssn=ssn;}
	var setAge = x=>{

		this._age = 119-x.substring(0,2);
		}
	var setGender = x=>{
		var gd = x.charAt(7);
		var gender = "";
		if(gd==='1'||gd==='3'){
			gender = "남";
			}else if(gd==='2'||gd==='4'){
			gender = "여";
			}else if(gd==='5'||gd==='6'){
			gender = "외국인";
			}else{
			gender = "다시 입력하세요";
			}
		this._gender = gender;
		}
	var getGender = ()=>{return this._gender;}
	var getUserId = ()=>{return this._userId;}
	var getPassword = ()=>{return this._password;}
	var getName = ()=>{return this._name;}
	var getAge = ()=>{return this._age;}
	var getSsn = ()=>{return this._ssn;}
	var getGender = ()=>{return this._gender;}
	return {
		setUserId : setUserId,
		setPassword :setPassword,
		setName :setName,
		setAge:setAge,
		setGender :setGender,
		getUserId:getUserId,
		getAge:getAge,
		getSsn:getSsn,
		getPassword:getPassword,
		getName:getName,
		getGender:getGender,
		join : x=>{

			member.setAge(x);
			member.setGender(x);
		}			
		
	};
})();
