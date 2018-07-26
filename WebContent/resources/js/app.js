function Common() {
		this.move = function(t,domain, action, page){
			location.href = t+"/" + domain + ".do?action="
		+ action + "&page=" + page;}
}
;

function Member() {
		var userId, ssn,password; 
		this.setUserId = function(x){
			this.userId=x;
		}
		this.setSsn = function(x){
			this.ssn=x;
		}
		this.setPassword = function(x){
			this.password=x;
		}
		this.getUserId = function(){
			return this.userId;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
	
		this.loginValidation = function() {
			
			if(this.userId === ""){
					alert("아이디를 입력하세요.");
					return false;
				}else if(this.password === ""){
					alert("비밀번호를 입력하세요.");
					return false;
				}else{
					return true;
				}}
	};