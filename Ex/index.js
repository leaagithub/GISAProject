var crypto = require ('crypto');
var uuid = require('uuid');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');
var ProjectID;
var connection = mysql.createConnection({
  host     : 'mygisainst.c7mj9olumnzo.us-west-1.rds.amazonaws.com',
  user     : 'GISAlogin',
  password : 'GISA2018pass',
  database : 'GISA'
});

var app = express();

app.listen(3000);
console.log('Example app listening at port:3000');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

connection.connect(function(err) {
	if (err) throw err;
	console.log("Connected!");
});
app.post('/submitIncidentReport/',(req,res)=>{
    var post_data = req.body;
	//Incident Report Table VAR
	console.log(post_data);
    var DateOfIncident = post_data.DateOfIncident;
    var DateOfReport = post_data.DateOfReport;
    var District = post_data.District;
    var County = post_data.County;
    var Route = post_data.Route;
    var Latitude = post_data.Latitude;
    var Longitude = post_data.Longitude;
    var Observation = post_data.Observation;
    var EmployeeId = post_data.EmployeeID;
	var Distribution = post_data.Distribution;
	var HighwayStatus = post_data.HighwayStatus;
	var ClosedLanes = post_data.ClosedLanes;
	var WaterContent = post_data.WaterContent;
	var AdjacentUtilities = post_data.AdjacentUtilities;
	var AdjacentProperties = post_data.AdjacentProperties;
	var Sketch = post_data.Sketch;
	var Photos = post_data.Photos;
	//Material Table VAR
	var sql = 'INSERT INTO IncidentReport (DateOfIncident,DateOfReport,District,County,Route,Latitude,Longitude,Observation,EmployeeId,Distribution,HighwayStatus,ClosedLanes,WaterContent,AdjacentUtilities,AdjacentProperties,Photos) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);'
	connection.query(sql,[DateOfIncident,DateOfReport,District,County,Route,Latitude,Longitude,Observation,EmployeeId,Distribution,HighwayStatus,ClosedLanes,WaterContent,AdjacentUtilities,AdjacentProperties,Photos],function (err, result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('Register error: ',err);
		});
		res.end('Incident Report Registered');
		console.log('Incident Report Registered Successful!!');
	});
	sql = 'SELECT ProjectID FROM IncidentReport ORDER BY ProjectID DESC LIMIT 1';
	connection.query(sql,function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MYSQL ERROR]',err);
		});
		console.log(result[0].ProjectID);
		ProjectID = result[0].ProjectID;
	});
})
app.post()

app.post('/register/',(req,res)=>{
	var post_data = req.body; //GET POST PARAMETERS
	console.log(post_data);
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
			function (err, result,fields){
			connection.on('error',function(err){
				console.log('[MySQL Error]',err);
				res.json('Register error: ',err);
			});
			res.end('Registered');
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
				//res.end(JSON.stringify(result[0])); //RETURNS USER INFO
                res.end('Successful');
                console.log('Login Successful');
			}
			else{
				res.end(JSON.stringify('Wrong Password'));
                console.log('Wrong Passowrd');
            }
		}
		else{
			res.json('User Does Not Exists');
            console.log('User not exists');
		}
	});
})

app.get('/test',function(req,res){
	res.send('Hello This is a Test');
	console.log(ProjectID);
});