var crypto = require ('crypto');
var uuid = require('uuid');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

var connection = mysql.createConnection({
  host     : 'mygisainst.c7mj9olumnzo.us-west-1.rds.amazonaws.com',
  user     : 'GISAlogin',
  password : 'GISA2018pass',
  database : 'GISA'
});

var app = express();

app.listen(3000);
console.log('Example app listening at port:3000');
//app.post('/login/',(req,res,next)=>{
	
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

connection.connect(function(err) {
	if (err) throw err;
	console.log("Connected!");
});

app.post('/register/',(req,res)=>{
	var post_data = req.body; //GET POST PARAMETERS
	console.log(post_data);

	/*var eid = req.param.eid;
	var lname = req.param.lname;
	var fname = req.param.fname;
	var phoneno = req.param.phoneno;
	var password = req.param.password;
	var email = req.param.email;*/
	var eid = post_data.eid;
	var fname = post_data.fname;
	var lname = post_data.lname;
	var phoneno = post_data.phoneno;
	var password = post_data.password;
	var email = post_data.email;
	
	
	connection.query('SELECT * FROM Employee WHERE CaltransID =?',[eid],
		function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL ERROR]',err);
		});
		if(result && result.length){
			res.json('User already exists!!!');
            console.log('User already exists!!!');
		}
		else
		{
			//var sql = "INSERT Into Employee(CaltransID, FName, LName, PhoneNo, Password, Email) VALUES( ? , ? , ? , ? , ?, ?);";
			connection.query("INSERT Into Employee(CaltransID, FName, LName, PhoneNo, Password, Email) VALUES( ? , ? , ? , ? , ?, ?);",[eid,fname,lname,phoneno,password,email],
			function (err, result1,fields){
			connection.on('error',function(err){
				console.log('[MySQL Error]',err);
				res.json('Register error: ',err);
			});
			res.json('Register successful!!');
            console.log('Register Successful!!');
		})
		}
	});
})

app.post('/login',(req,res,next)=>{
	var post_data = req.body;
	var user_password = post_data.password;
	var user_eid = post_data.eid;
	connection.query('SELECT * FROM Employee WHERE CaltransID =?',[user_eid],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MYSQL ERROR]',err);
		});

		if(result && result.length){
			var password = result[0].Password; 
			if(user_password == password){
				res.end(JSON.stringify(result[0])); //RETURNS USER INFO
			}
			else
				res.end(JSON.stringify('WRONG PASSWORD'));
                console.log('Wrong password');
		}
		else{
			res.json('USER NOT EXISTS!!!!!!');
            console.log('User not exists');
		}
	});
})

app.get('/test',function(req,res){
    res.send('Hello This is a Test');
});
